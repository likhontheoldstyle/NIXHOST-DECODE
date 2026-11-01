package a;

public final class PendingReaction {

    public final String emoji;

    public long sentAtMs;

    public boolean acknowledged = false;

    public PendingReaction(String str, long j2) {
        this.emoji = str;
        this.sentAtMs = j2;
    }
}
