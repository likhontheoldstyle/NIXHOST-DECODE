package d;

import java.util.Comparator;

/* loaded from: classes.dex */
public final class b implements Comparator {

    /* renamed from: b, reason: collision with root package name */
    public static final b f803b = new b(0);

    /* renamed from: c, reason: collision with root package name */
    public static final b f804c = new b(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f805a;

    public /* synthetic */ b(int i2) {
        this.f805a = i2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f805a) {
            case 0:
                Comparable comparable = (Comparable) obj;
                Comparable comparable2 = (Comparable) obj2;
                i.b.e(comparable, "a");
                i.b.e(comparable2, "b");
                return comparable.compareTo(comparable2);
            default:
                Comparable comparable3 = (Comparable) obj;
                Comparable comparable4 = (Comparable) obj2;
                i.b.e(comparable3, "a");
                i.b.e(comparable4, "b");
                return comparable4.compareTo(comparable3);
        }
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        switch (this.f805a) {
            case 0:
                return f804c;
            default:
                return f803b;
        }
    }
}
