package l;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class b implements c {

    /* renamed from: a, reason: collision with root package name */
    public final c f861a;

    /* renamed from: b, reason: collision with root package name */
    public final int f862b;

    public b(c cVar, int i2) {
        this.f861a = cVar;
        this.f862b = i2;
        if (i2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i2 + '.').toString());
    }

    @Override // l.c
    public final Iterator iterator() {
        return new i.a(this);
    }
}
