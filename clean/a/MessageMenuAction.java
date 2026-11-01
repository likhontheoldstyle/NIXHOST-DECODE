package a;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public final class MessageMenuAction implements h.a {

    public final int mode;

    public final Dialog dialog;

    public final ChatScreen chatScreen;

    public final ChatMessage message;

    public MessageMenuAction(Dialog dialog, ChatScreen chatScreen, ChatMessage chatMessage, int i2) {
        this.mode = i2;
        this.dialog = dialog;
        this.chatScreen = chatScreen;
        this.message = chatMessage;
    }

    @Override
    public final Object a() {
        switch (this.mode) {
            case 0:
                this.dialog.dismiss();
                ChatScreen chatScreen = this.chatScreen;
                Object systemService = chatScreen.activity.getSystemService("clipboard");
                i.b.c(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("message", this.message.text));
                chatScreen.toaster.a("Copied");
                break;
            case 1:
                this.dialog.dismiss();
                final ChatScreen chatScreen2 = this.chatScreen;
                chatScreen2.getClass();
                final ChatMessage chatMessage = this.message;
                final String str = chatMessage.text;
                chatScreen2.showBottomSheet(true, new h.c() {
                    @Override
                    public final Object a(Object obj, Object obj2) {
                        LinearLayout linearLayout = (LinearLayout) obj;
                        Dialog dialog = (Dialog) obj2;
                        ChatScreen chatScreen3 = chatScreen2;
                        LinearLayout P = chatScreen3.rowLayout();
                        float f2 = 8;
                        P.setPadding(chatScreen3.dp(16), chatScreen3.dp(2), chatScreen3.dp(f2), chatScreen3.dp(f2));
                        int i2 = chatScreen3.textColor;
                        P.addView(chatScreen3.makeText("Edit message", 21.0f, i2, false), new LinearLayout.LayoutParams(0, -2, 1.0f));
                        Activity activity = chatScreen3.activity;
                        FrameLayout frameLayout = new FrameLayout(activity);
                        float f3 = 22;
                        frameLayout.addView(new IconView(activity, "close", i2, 2.2f), new FrameLayout.LayoutParams(chatScreen3.dp(f3), chatScreen3.dp(f3), 17));
                        frameLayout.setOnClickListener(new DialogDismissClickListener(2, dialog));
                        float f4 = 44;
                        P.addView(frameLayout, ChatScreen.layoutParamsDefault(chatScreen3, chatScreen3.dp(f4), chatScreen3.dp(f4), 0, 0, 0, 60));
                        linearLayout.addView(P, ChatScreen.layoutParamsDefault(chatScreen3, -1, -2, 0, 0, 0, 60));
                        linearLayout.addView(chatScreen3.dividerView());
                        LinearLayout P2 = chatScreen3.rowLayout();
                        float f5 = 12;
                        P2.setPadding(chatScreen3.dp(f5), chatScreen3.dp(f5), chatScreen3.dp(f5), chatScreen3.dp(14));
                        EditText editText = new EditText(activity);
                        String str2 = str;
                        editText.setText(str2);
                        editText.setTextColor(i2);
                        editText.setTextSize(1, 19.251001f);
                        editText.setBackground(chatScreen3.roundedDrawable(chatScreen3.chipColor, 26.0f, chatScreen3.lightBars ? -7697007 : -4407100, 1.0f));
                        float f6 = 18;
                        float f7 = 10;
                        editText.setPadding(chatScreen3.dp(f6), chatScreen3.dp(f7), chatScreen3.dp(f6), chatScreen3.dp(f7));
                        editText.setInputType(147457);
                        editText.setMaxLines(5);
                        P2.addView(editText, new LinearLayout.LayoutParams(0, -2, 1.0f));
                        FrameLayout frameLayout2 = new FrameLayout(activity);
                        ChatIconView M = chatScreen3.makeIcon("checkf", -11907758, 26);
                        float f8 = 26;
                        frameLayout2.addView(M, new FrameLayout.LayoutParams(chatScreen3.dp(f8), chatScreen3.dp(f8), 17));
                        float f9 = 46;
                        P2.addView(frameLayout2, ChatScreen.layoutParamsDefault(chatScreen3, chatScreen3.dp(f9), chatScreen3.dp(f9), 10, 0, 0, 56));
                        ChatScreen.updateEditSaveButton(frameLayout2, chatScreen3, M, editText, str2);
                        editText.addTextChangedListener(new CheckButtonTextWatcher(frameLayout2, chatScreen3, M, editText, str2));
                        frameLayout2.setOnClickListener(new MessageDialogClickListener(editText, dialog, chatScreen3, chatMessage, str2));
                        linearLayout.addView(P2, ChatScreen.layoutParamsDefault(chatScreen3, -1, -2, 0, 0, 0, 60));
                        editText.post(new FocusInputRunnable(editText, chatScreen3, 1));
                        return b.d.f770c;
                    }
                });
                break;
            case 2:
                this.dialog.dismiss();
                this.chatScreen.setReplyTarget(this.message);
                break;
            case 3:
                this.dialog.dismiss();
                ChatScreen chatScreen4 = this.chatScreen;
                chatScreen4.getClass();
                chatScreen4.showConfirmDialog("Delete?", "Are you sure you want to delete this message?", "No", "Yes", new MessageAction(chatScreen4, this.message, 0));
                break;
            default:
                this.dialog.dismiss();
                ChatScreen chatScreen5 = this.chatScreen;
                chatScreen5.getClass();
                chatScreen5.showConfirmDialog("Delete for everyone?", "This message will be permanently removed for everyone in this chat. They will see that you deleted a message and will still be able to report it.", "Cancel", "Delete", new MessageAction(chatScreen5, this.message, 2));
                break;
        }
        return b.d.f770c;
    }
}
