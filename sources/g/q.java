package g;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f839a;

    /* renamed from: b, reason: collision with root package name */
    public static final q f840b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ q[] f841c;

    static {
        q qVar = new q("SKIP", 0);
        f839a = qVar;
        q qVar2 = new q("TERMINATE", 1);
        f840b = qVar2;
        f841c = new q[]{qVar, qVar2};
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) f841c.clone();
    }
}
