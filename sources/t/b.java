package t;

import m.d;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f974a;

    /* renamed from: b, reason: collision with root package name */
    public final int f975b;

    /* renamed from: c, reason: collision with root package name */
    public final d[] f976c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f977d;

    public b(c cVar, int i2, int i3) {
        this.f977d = cVar;
        this.f974a = i2;
        this.f975b = (1 << i3) - 1;
        this.f976c = new d[1 << (i2 + i3)];
        int i4 = 0;
        while (true) {
            d[] dVarArr = this.f976c;
            if (i4 >= dVarArr.length) {
                return;
            }
            dVarArr[i4] = new d(this);
            i4++;
        }
    }
}
