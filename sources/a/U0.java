package a;

import java.util.Comparator;

/* loaded from: classes.dex */
public final class U0 implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f326a;

    public U0(C0006b1 c0006b1) {
        this.f326a = c0006b1;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        C0006b1 c0006b1 = this.f326a;
        return AbstractC0008c.d(Integer.valueOf(!m.m.F((String) obj, c0006b1.C1) ? 1 : 0), Integer.valueOf(!m.m.F((String) obj2, c0006b1.C1) ? 1 : 0));
    }
}
