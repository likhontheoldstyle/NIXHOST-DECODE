package m;

import a.AbstractC0008c;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b implements Iterator, j.a {

    /* renamed from: a, reason: collision with root package name */
    public int f866a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f867b;

    /* renamed from: c, reason: collision with root package name */
    public int f868c;

    /* renamed from: d, reason: collision with root package name */
    public k.c f869d;

    /* renamed from: e, reason: collision with root package name */
    public int f870e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f871f;

    public b(c cVar) {
        this.f871f = cVar;
        int c2 = AbstractC0008c.c(cVar.f873b, cVar.f872a.length());
        this.f867b = c2;
        this.f868c = c2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
    
        if (r6 < r3) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        int i2 = this.f868c;
        if (i2 < 0) {
            this.f866a = 0;
            this.f869d = null;
            return;
        }
        c cVar = this.f871f;
        int i3 = cVar.f874c;
        if (i3 > 0) {
            int i4 = this.f870e + 1;
            this.f870e = i4;
        }
        if (i2 <= cVar.f872a.length()) {
            b.b bVar = (b.b) cVar.f875d.a(cVar.f872a, Integer.valueOf(this.f868c));
            if (bVar == null) {
                this.f869d = new k.c(this.f867b, e.N(cVar.f872a), 1);
                this.f868c = -1;
            } else {
                int intValue = ((Number) bVar.f764a).intValue();
                int intValue2 = ((Number) bVar.f765b).intValue();
                this.f869d = AbstractC0008c.B(this.f867b, intValue);
                int i5 = intValue + intValue2;
                this.f867b = i5;
                this.f868c = i5 + (intValue2 == 0 ? 1 : 0);
            }
            this.f866a = 1;
        }
        this.f869d = new k.c(this.f867b, e.N(cVar.f872a), 1);
        this.f868c = -1;
        this.f866a = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f866a == -1) {
            a();
        }
        return this.f866a == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f866a == -1) {
            a();
        }
        if (this.f866a == 0) {
            throw new NoSuchElementException();
        }
        k.c cVar = this.f869d;
        i.b.c(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
        this.f869d = null;
        this.f866a = -1;
        return cVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
