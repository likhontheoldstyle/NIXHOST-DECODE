package a;

import android.widget.LinearLayout;

public final class QuickReactionRefresher implements h.a {

    public final int mode;

    public final ChatScreen chatScreen;

    public final LinearLayout panel;

    public QuickReactionRefresher(ChatScreen chatScreen, LinearLayout linearLayout) {
        this.mode = 0;
        this.chatScreen = chatScreen;
        this.panel = linearLayout;
    }

    @Override
    public final Object a() {
        switch (this.mode) {
            case 0:
                ChatScreen.buildGroupInfo(this.chatScreen, this.panel);
                break;
            default:
                ChatScreen chatScreen = this.chatScreen;
                chatScreen.showReactionPicker(true, new TextInputAction(chatScreen, this.panel, 0));
                break;
        }
        return b.d.f770c;
    }

    public QuickReactionRefresher(LinearLayout linearLayout, ChatScreen chatScreen) {
        this.mode = 1;
        this.panel = linearLayout;
        this.chatScreen = chatScreen;
    }
}
