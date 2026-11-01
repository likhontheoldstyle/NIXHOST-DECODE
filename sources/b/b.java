package b;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class b implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f764a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f765b;

    public b(Object obj, Object obj2) {
        this.f764a = obj;
        this.f765b = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return i.b.a(this.f764a, bVar.f764a) && i.b.a(this.f765b, bVar.f765b);
    }

    public final int hashCode() {
        Object obj = this.f764a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f765b;
        return hashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f764a + ", " + this.f765b + ')';
    }
}
