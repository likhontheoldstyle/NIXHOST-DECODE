package n;

import java.io.InputStream;

/* loaded from: classes.dex */
public final class b implements m, l {

    /* renamed from: a, reason: collision with root package name */
    public int f881a;

    /* renamed from: b, reason: collision with root package name */
    public long f882b;

    @Override // n.l
    public boolean a() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // n.m
    public InputStream b(InputStream inputStream, a aVar) {
        v.a aVar2;
        long j2 = this.f882b;
        int i2 = this.f881a;
        if (j2 == 4) {
            v.c cVar = new v.c();
            cVar.f1003b = 0;
            cVar.f1002a = i2 + 5;
            aVar2 = cVar;
        } else if (j2 == 5) {
            aVar2 = new v.a(i2, 4, false);
        } else if (j2 == 6) {
            aVar2 = new v.a(i2, 0, false);
        } else if (j2 == 7) {
            aVar2 = new v.a(i2, 2);
        } else if (j2 == 8) {
            aVar2 = new v.a(i2, 3);
        } else if (j2 == 9) {
            aVar2 = new v.a(i2, 6, false);
        } else if (j2 == 10) {
            aVar2 = new v.a(i2, 1, false);
        } else if (j2 == 11) {
            v.a aVar3 = new v.a();
            aVar3.f999b = i2;
            aVar2 = aVar3;
        } else {
            aVar2 = null;
        }
        return new p(inputStream, aVar2);
    }

    @Override // n.l
    public boolean c() {
        return true;
    }

    @Override // n.m
    public int d() {
        int i2 = p.f918j;
        return 5;
    }

    @Override // n.l
    public boolean e() {
        return false;
    }
}
