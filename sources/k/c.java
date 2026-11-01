package k;

/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: d, reason: collision with root package name */
    public static final c f859d = new c(1, 0, 1);

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (this.f852a == cVar.f852a) {
                    if (this.f853b == cVar.f853b) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f852a * 31) + this.f853b;
    }

    public final boolean isEmpty() {
        return this.f852a > this.f853b;
    }

    public final String toString() {
        return this.f852a + ".." + this.f853b;
    }
}
