package v;

import a.AbstractC0008c;

/* loaded from: classes.dex */
public final class c implements b {

    /* renamed from: c, reason: collision with root package name */
    public static final boolean[] f1000c = {true, true, true, false, true, false, false, false};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f1001d = {0, 1, 2, 2, 3, 3, 3, 3};

    /* renamed from: a, reason: collision with root package name */
    public int f1002a;

    /* renamed from: b, reason: collision with root package name */
    public int f1003b;

    @Override // v.b
    public final int a(byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        int i6 = i2 - 1;
        int i7 = (i3 + i2) - 5;
        int i8 = i2;
        while (true) {
            if (i8 > i7) {
                break;
            }
            if ((bArr[i8] & 254) == 232) {
                int i9 = i8 - i6;
                int i10 = i9 & (-4);
                int[] iArr = f1001d;
                if (i10 != 0) {
                    this.f1003b = 0;
                } else {
                    int i11 = (this.f1003b << (i9 - 1)) & 7;
                    this.f1003b = i11;
                    if (i11 != 0 && (!f1000c[i11] || (i4 = bArr[(i8 + 4) - iArr[i11]] & 255) == 0 || i4 == 255)) {
                        this.f1003b = (i11 << 1) | 1;
                        i6 = i8;
                    }
                }
                int i12 = i8 + 4;
                int i13 = bArr[i12] & 255;
                if (i13 == 0 || i13 == 255) {
                    int i14 = i8 + 1;
                    int k2 = AbstractC0008c.k(bArr, i14);
                    while (true) {
                        i5 = k2 - ((this.f1002a + i8) - i2);
                        int i15 = this.f1003b;
                        if (i15 != 0) {
                            int i16 = iArr[i15] * 8;
                            int i17 = ((byte) (i5 >>> (24 - i16))) & 255;
                            if (i17 != 0 && i17 != 255) {
                                break;
                            }
                            k2 = i5 ^ ((1 << (32 - i16)) - 1);
                        } else {
                            break;
                        }
                    }
                    AbstractC0008c.x(bArr, i14, (i5 << 7) >> 7);
                    i6 = i8;
                    i8 = i12;
                } else {
                    this.f1003b = (this.f1003b << 1) | 1;
                    i6 = i8;
                }
            }
            i8++;
        }
        int i18 = i8 - i6;
        this.f1003b = (i18 & (-4)) == 0 ? this.f1003b << (i18 - 1) : 0;
        int i19 = i8 - i2;
        this.f1002a += i19;
        return i19;
    }
}
