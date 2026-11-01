package a;

import android.app.Dialog;
import android.view.View;
import android.widget.EditText;
import java.util.regex.Pattern;

public final class ChatSettingsClickListener implements View.OnClickListener {

    public final int mode;

    public final ChatScreen chatScreen;

    public final Dialog dialog;

    public final Object first;

    public final Object second;

    public ChatSettingsClickListener(ChatScreen chatScreen, ChatTheme chatTheme, Dialog dialog, Dialog dialog2) {
        this.mode = 1;
        this.chatScreen = chatScreen;
        this.first = chatTheme;
        this.dialog = dialog;
        this.second = dialog2;
    }

    @Override
    public final void onClick(View view) {
        switch (this.mode) {
            case 0:
                String obj = ((EditText) this.first).getText().toString();
                Pattern compile = Pattern.compile("\\s+");
                i.b.d(compile, "compile(...)");
                i.b.e(obj, "input");
                String replaceAll = compile.matcher(obj).replaceAll(" ");
                i.b.d(replaceAll, "replaceAll(...)");
                String obj2 = m.e.h0(replaceAll).toString();
                int length = obj2.length();
                ChatScreen chatScreen = this.chatScreen;
                if (length != 0) {
                    boolean a2 = i.b.a(obj2, (String) this.second);
                    Dialog dialog = this.dialog;
                    if (!a2) {
                        if (!chatScreen.isOffline()) {
                            dialog.dismiss();
                            new Thread(new ProfileOrPrefetchRunnable(obj2, chatScreen, 2)).start();
                            break;
                        } else {
                            chatScreen.toaster.a("No internet connection");
                            break;
                        }
                    } else {
                        dialog.dismiss();
                        break;
                    }
                } else {
                    chatScreen.toaster.a("Name can't be empty");
                    break;
                }
            default:
                ChatScreen chatScreen2 = this.chatScreen;
                if (!chatScreen2.isOffline()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    chatScreen2.lastThemeSyncAt = currentTimeMillis;
                    chatScreen2.lastQuickReactionAt = currentTimeMillis;
                    ChatTheme chatTheme = (ChatTheme) this.first;
                    ChatScreen.saveQuickReaction(chatTheme.emoji);
                    chatScreen2.applyTheme(chatTheme);
                    new Thread(new HttpConnectionHandler(chatTheme, chatScreen2, 0)).start();
                    this.dialog.dismiss();
                    ((Dialog) this.second).dismiss();
                    Dialog dialog2 = chatScreen2.sourceDialog;
                    if (dialog2 != null) {
                        dialog2.dismiss();
                        break;
                    }
                } else {
                    chatScreen2.toaster.a("No internet connection");
                    break;
                }
                break;
        }
    }

    public ChatSettingsClickListener(EditText editText, ChatScreen chatScreen, String str, Dialog dialog) {
        this.mode = 0;
        this.first = editText;
        this.chatScreen = chatScreen;
        this.second = str;
        this.dialog = dialog;
    }
}
