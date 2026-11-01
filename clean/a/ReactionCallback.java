package a;

public final class ReactionCallback implements h.b {

    public final int mode;

    public final ChatScreen chatScreen;

    public final ChatMessage message;

    public ReactionCallback(ChatScreen chatScreen, ChatMessage chatMessage, int i2) {
        this.mode = i2;
        this.chatScreen = chatScreen;
        this.message = chatMessage;
    }

    @Override
    public final Object a(Object obj) {
        String str = (String) obj;
        switch (this.mode) {
            case 0:
                this.chatScreen.setReaction(this.message, str);
                break;
            default:
                this.chatScreen.setReaction(this.message, str);
                break;
        }
        return b.d.f770c;
    }
}
