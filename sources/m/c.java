package m;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class c implements l.c {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f872a;

    /* renamed from: b, reason: collision with root package name */
    public final int f873b;

    /* renamed from: c, reason: collision with root package name */
    public final int f874c;

    /* renamed from: d, reason: collision with root package name */
    public final h.c f875d;

    public c(CharSequence charSequence, int i2, int i3, h.c cVar) {
        i.b.e(charSequence, "input");
        this.f872a = charSequence;
        this.f873b = i2;
        this.f874c = i3;
        this.f875d = cVar;
    }

    @Override // l.c
    public final Iterator iterator() {
        return new b(this);
    }
}
