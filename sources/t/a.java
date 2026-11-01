package t;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final short[] f969a = new short[2];

    /* renamed from: b, reason: collision with root package name */
    public final short[][] f970b;

    /* renamed from: c, reason: collision with root package name */
    public final short[][] f971c;

    /* renamed from: d, reason: collision with root package name */
    public final short[] f972d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ c f973e;

    public a(c cVar) {
        this.f973e = cVar;
        Class cls = Short.TYPE;
        this.f970b = (short[][]) Array.newInstance((Class<?>) cls, 16, 8);
        this.f971c = (short[][]) Array.newInstance((Class<?>) cls, 16, 8);
        this.f972d = new short[256];
    }

    public final int a(int i2) {
        c cVar = this.f973e;
        u.a aVar = cVar.f991n;
        short[] sArr = this.f969a;
        return aVar.a(sArr, 0) == 0 ? cVar.f991n.b(this.f970b[i2]) + 2 : cVar.f991n.a(sArr, 1) == 0 ? cVar.f991n.b(this.f971c[i2]) + 10 : cVar.f991n.b(this.f972d) + 18;
    }

    public final void b() {
        short[][] sArr;
        u.a.c(this.f969a);
        int i2 = 0;
        while (true) {
            sArr = this.f970b;
            if (i2 >= sArr.length) {
                break;
            }
            u.a.c(sArr[i2]);
            i2++;
        }
        for (int i3 = 0; i3 < sArr.length; i3++) {
            u.a.c(this.f971c[i3]);
        }
        u.a.c(this.f972d);
    }
}
