package s;

import n.h;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f961a;

    /* renamed from: b, reason: collision with root package name */
    public final int f962b;

    /* renamed from: c, reason: collision with root package name */
    public int f963c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f964d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f965e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f966f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f967g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f968h = 0;

    public a(int i2, n.a aVar) {
        this.f962b = i2;
        this.f961a = aVar.a(i2);
    }

    public final void a(int i2, int i3) {
        int i4;
        if (i2 < 0 || i2 >= this.f965e) {
            throw new h();
        }
        int min = Math.min(this.f966f - this.f964d, i3);
        this.f967g = i3 - min;
        this.f968h = i2;
        int i5 = (this.f964d - i2) - 1;
        byte[] bArr = this.f961a;
        if (i5 < 0) {
            int i6 = this.f962b;
            int i7 = i5 + i6;
            int min2 = Math.min(i6 - i7, min);
            System.arraycopy(bArr, i7, bArr, this.f964d, min2);
            this.f964d += min2;
            min -= min2;
            if (min == 0) {
                return;
            } else {
                i5 = 0;
            }
        }
        do {
            int min3 = Math.min(min, this.f964d - i5);
            System.arraycopy(bArr, i5, bArr, this.f964d, min3);
            i4 = this.f964d + min3;
            this.f964d = i4;
            min -= min3;
        } while (min > 0);
        if (this.f965e < i4) {
            this.f965e = i4;
        }
    }
}
