package a;

import android.app.Dialog;
import android.view.View;
import android.widget.EditText;

public final class MessageDialogClickListener implements View.OnClickListener {

    public final int mode;

    public final Dialog dialog;

    public final ChatScreen chatScreen;

    public final ChatMessage message;

    public final String value;

    public final Object extra;

    public MessageDialogClickListener(Dialog dialog, ChatScreen chatScreen, ChatMessage chatMessage, String str, String str2) {
        this.mode = 0;
        this.dialog = dialog;
        this.chatScreen = chatScreen;
        this.message = chatMessage;
        this.value = str;
        this.extra = str2;
    }

    @Override
    public final void onClick(View view) {
        switch (this.mode) {
            case 0:
                this.dialog.dismiss();
                String str = this.value;
                if (i.b.a(str, (String) this.extra)) {
                    str = "";
                }
                this.chatScreen.setReaction(this.message, str);
                break;
            default:
                EditText editText = (EditText) this.extra;
                if (ChatScreen.hasEditedText(editText, this.value)) {
                    String obj = m.e.h0(editText.getText().toString()).toString();
                    this.dialog.dismiss();
                    ChatScreen chatScreen = this.chatScreen;
                    chatScreen.getClass();
                    ChatMessage chatMessage = this.message;
                    String str2 = chatMessage.text;
                    int i2 = chatMessage.status;
                    chatMessage.text = obj;
                    chatMessage.status = i2 + 1;
                    chatScreen.applyScroll(false);
                    new Thread(new MultiWorkRunnable(chatMessage, obj, chatScreen, str2, i2)).start();
                    break;
                }
                break;
        }
    }

    public MessageDialogClickListener(EditText editText, Dialog dialog, ChatScreen chatScreen, ChatMessage chatMessage, String str) {
        this.mode = 1;
        this.extra = editText;
        this.dialog = dialog;
        this.chatScreen = chatScreen;
        this.message = chatMessage;
        this.value = str;
    }
}
