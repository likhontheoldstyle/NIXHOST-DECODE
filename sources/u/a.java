package u;

import java.util.Arrays;
import n.h;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f993a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f994b = 0;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f995c;

    /* renamed from: d, reason: collision with root package name */
    public int f996d;

    public a(n.a aVar) {
        byte[] a2 = aVar.a(65531);
        this.f995c = a2;
        this.f996d = a2.length;
    }

    public static final void c(short[] sArr) {
        Arrays.fill(sArr, (short) 1024);
    }

    public final int a(short[] sArr, int i2) {
        d();
        short s2 = sArr[i2];
        int i3 = (this.f993a >>> 11) * s2;
        if (Integer.compareUnsigned(this.f994b, i3) < 0) {
            this.f993a = i3;
            sArr[i2] = (short) (s2 + ((2048 - s2) >>> 5));
            return 0;
        }
        this.f993a -= i3;
        this.f994b -= i3;
        sArr[i2] = (short) (s2 - (s2 >>> 5));
        return 1;
    }

    public final int b(short[] sArr) {
        int i2 = 1;
        do {
            i2 = a(sArr, i2) | (i2 << 1);
        } while (i2 < sArr.length);
        return i2 - sArr.length;
    }

    public final void d() {
        int i2 = this.f993a;
        if (((-16777216) & i2) == 0) {
            try {
                int i3 = this.f994b << 8;
                byte[] bArr = this.f995c;
                int i4 = this.f996d;
                this.f996d = i4 + 1;
                this.f994b = i3 | (bArr[i4] & 255);
                this.f993a = i2 << 8;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new h();
            }
        }
    }
}
