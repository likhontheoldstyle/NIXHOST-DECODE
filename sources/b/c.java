package b;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class c implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public h.a f766a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f767b = d.f769b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f768c = this;

    public c(h.a aVar) {
        this.f766a = aVar;
    }

    public final Object a() {
        Object obj;
        Object obj2 = this.f767b;
        d dVar = d.f769b;
        if (obj2 != dVar) {
            return obj2;
        }
        synchronized (this.f768c) {
            obj = this.f767b;
            if (obj == dVar) {
                h.a aVar = this.f766a;
                i.b.b(aVar);
                obj = aVar.a();
                this.f767b = obj;
                this.f766a = null;
            }
        }
        return obj;
    }

    public final String toString() {
        return this.f767b != d.f769b ? String.valueOf(a()) : "Lazy value not initialized yet.";
    }
}
