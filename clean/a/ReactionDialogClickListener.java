package a;

import android.app.Dialog;
import android.view.View;

public final class ReactionDialogClickListener implements View.OnClickListener {

    public final int mode;

    public final Dialog dialog;

    public final ChatScreen chatScreen;

    public final ChatMessage message;

    public ReactionDialogClickListener(Dialog dialog, ChatScreen chatScreen, ChatMessage chatMessage, int i2) {
        this.mode = i2;
        this.dialog = dialog;
        this.chatScreen = chatScreen;
        this.message = chatMessage;
    }

    @Override
    public final void onClick(View view) {
        switch (this.mode) {
            case 0:
                this.dialog.dismiss();
                this.chatScreen.setReaction(this.message, "");
                break;
            default:
                this.dialog.dismiss();
                ChatMessage chatMessage = this.message;
                ChatScreen chatScreen = this.chatScreen;
                chatScreen.showReactionPicker(false, new ReactionCallback(chatScreen, chatMessage, 1));
                break;
        }
    }
}
