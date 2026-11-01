package a;

public final class IdPredicate implements h.b {

    public final int mode;

    public final long id;

    public IdPredicate(long j2, int i2) {
        this.mode = i2;
        this.id = j2;
    }

    @Override
    public final Object a(Object obj) {
        ChatMessage chatMessage = (ChatMessage) obj;
        switch (this.mode) {
            case 0:
                return Boolean.valueOf(chatMessage.id == this.id);
            case 1:
                return Boolean.valueOf(chatMessage.id == this.id);
            default:
                return Boolean.valueOf(chatMessage.id == this.id);
        }
    }
}
