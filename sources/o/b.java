package o;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: d, reason: collision with root package name */
    public static final long[][] f951d = (long[][]) Array.newInstance((Class<?>) Long.TYPE, 4, 256);

    /* renamed from: c, reason: collision with root package name */
    public long f952c;

    static {
        int i2 = 0;
        while (i2 < 4) {
            for (int i3 = 0; i3 < 256; i3++) {
                long j2 = i2 == 0 ? i3 : f951d[i2 - 1][i3];
                for (int i4 = 0; i4 < 8; i4++) {
                    j2 = (j2 & 1) == 1 ? (j2 >>> 1) ^ (-3932672073523589310L) : j2 >>> 1;
                }
                f951d[i2][i3] = j2;
            }
            i2++;
        }
    }

    @Override // o.c
    public final byte[] a() {
        byte[] bArr = {(byte) (~this.f952c), (byte) (r2 >>> 8), (byte) (r2 >>> 16), (byte) (r2 >>> 24), (byte) (r2 >>> 32), (byte) (r2 >>> 40), (byte) (r2 >>> 48), (byte) (r2 >>> 56)};
        this.f952c = -1L;
        return bArr;
    }

    @Override // o.c
    public final void b(byte[] bArr, int i2, int i3) {
        long[][] jArr;
        int i4 = i3 + i2;
        int i5 = i4 - 3;
        while (true) {
            jArr = f951d;
            if (i2 >= i5) {
                break;
            }
            long j2 = this.f952c;
            int i6 = (int) j2;
            this.f952c = (((j2 >>> 32) ^ (jArr[3][(i6 & 255) ^ (bArr[i2] & 255)] ^ jArr[2][((i6 >>> 8) & 255) ^ (bArr[i2 + 1] & 255)])) ^ jArr[1][((i6 >>> 16) & 255) ^ (bArr[i2 + 2] & 255)]) ^ jArr[0][((i6 >>> 24) & 255) ^ (bArr[i2 + 3] & 255)];
            i2 += 4;
        }
        while (i2 < i4) {
            long[] jArr2 = jArr[0];
            int i7 = i2 + 1;
            int i8 = bArr[i2] & 255;
            long j3 = this.f952c;
            this.f952c = (j3 >>> 8) ^ jArr2[i8 ^ (((int) j3) & 255)];
            i2 = i7;
        }
    }
}
