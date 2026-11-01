package l;

import g.p;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f860a;

    public a(p pVar) {
        this.f860a = new AtomicReference(pVar);
    }

    @Override // l.c
    public final Iterator iterator() {
        c cVar = (c) this.f860a.getAndSet(null);
        if (cVar != null) {
            return cVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
