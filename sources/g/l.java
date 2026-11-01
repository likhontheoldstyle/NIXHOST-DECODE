package g;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f831a;

    /* renamed from: b, reason: collision with root package name */
    public static final l f832b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ l[] f833c;

    static {
        l lVar = new l("TOP_DOWN", 0);
        f831a = lVar;
        l lVar2 = new l("BOTTOM_UP", 1);
        f832b = lVar2;
        f833c = new l[]{lVar, lVar2};
    }

    public static l valueOf(String str) {
        return (l) Enum.valueOf(l.class, str);
    }

    public static l[] values() {
        return (l[]) f833c.clone();
    }
}
