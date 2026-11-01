package n;

import a.AbstractC0008c;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class g extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final DataInputStream f887a;

    /* renamed from: b, reason: collision with root package name */
    public final i f888b;

    /* renamed from: c, reason: collision with root package name */
    public InputStream f889c;

    /* renamed from: d, reason: collision with root package name */
    public final o.c f890d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f891e;

    /* renamed from: f, reason: collision with root package name */
    public final long f892f;

    /* renamed from: g, reason: collision with root package name */
    public final long f893g;

    /* renamed from: h, reason: collision with root package name */
    public final long f894h;

    /* renamed from: i, reason: collision with root package name */
    public final int f895i;

    /* renamed from: j, reason: collision with root package name */
    public long f896j = 0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f897k = false;

    /* renamed from: l, reason: collision with root package name */
    public final byte[] f898l = new byte[1];

    public g(InputStream inputStream, o.c cVar, boolean z, int i2, a aVar) {
        int i3;
        char c2;
        this.f892f = -1L;
        this.f893g = -1L;
        this.f890d = cVar;
        this.f891e = z;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f887a = dataInputStream;
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        if (readUnsignedByte == 0) {
            throw new n();
        }
        int i4 = (readUnsignedByte + 1) * 4;
        this.f895i = i4;
        byte[] bArr = new byte[i4];
        bArr[0] = (byte) readUnsignedByte;
        dataInputStream.readFully(bArr, 1, i4 - 1);
        int i5 = i4 - 4;
        if (!AbstractC0008c.o(bArr, 0, i5, i5)) {
            throw new h("XZ Block Header is corrupt");
        }
        int i6 = bArr[1];
        if ((i6 & 60) != 0) {
            throw new r("Unsupported options in XZ Block Header");
        }
        int i7 = i6 & 3;
        int i8 = i7 + 1;
        long[] jArr = new long[i8];
        byte[][] bArr2 = new byte[i8][];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, 2, i4 - 6);
        try {
            long j2 = (9223372036854775804L - i4) - cVar.f953a;
            this.f894h = j2;
            if ((bArr[1] & 64) != 0) {
                i3 = i7;
                long g2 = AbstractC0008c.g(byteArrayInputStream);
                this.f893g = g2;
                if (g2 == 0 || g2 > j2) {
                    throw new h();
                }
                this.f894h = g2;
                c2 = 1;
            } else {
                i3 = i7;
                c2 = 1;
            }
            if ((bArr[c2] & 128) != 0) {
                this.f892f = AbstractC0008c.g(byteArrayInputStream);
            }
            for (int i9 = 0; i9 < i8; i9++) {
                jArr[i9] = AbstractC0008c.g(byteArrayInputStream);
                long g3 = AbstractC0008c.g(byteArrayInputStream);
                if (g3 > byteArrayInputStream.available()) {
                    throw new h();
                }
                byte[] bArr3 = new byte[(int) g3];
                bArr2[i9] = bArr3;
                byteArrayInputStream.read(bArr3);
            }
            for (int available = byteArrayInputStream.available(); available > 0; available--) {
                if (byteArrayInputStream.read() != 0) {
                    throw new r("Unsupported options in XZ Block Header");
                }
            }
            m[] mVarArr = new m[i8];
            for (int i10 = 0; i10 < i8; i10++) {
                long j3 = jArr[i10];
                if (j3 == 33) {
                    byte[] bArr4 = bArr2[i10];
                    j jVar = new j(1);
                    if (bArr4.length == 1) {
                        byte b2 = bArr4[0];
                        if ((b2 & 255) <= 37) {
                            jVar.f901b = ((b2 & 1) | 2) << ((b2 >>> 1) + 11);
                            mVarArr[i10] = jVar;
                        }
                    }
                    throw new r("Unsupported LZMA2 properties");
                }
                if (j3 == 3) {
                    mVarArr[i10] = new j(bArr2[i10]);
                } else {
                    if (j3 < 4 || j3 > 11) {
                        throw new r("Unknown Filter ID " + jArr[i10]);
                    }
                    byte[] bArr5 = bArr2[i10];
                    b bVar = new b();
                    bVar.f882b = j3;
                    if (bArr5.length == 0) {
                        bVar.f881a = 0;
                    } else {
                        if (bArr5.length != 4) {
                            throw new r("Unsupported BCJ filter properties");
                        }
                        int i11 = 0;
                        for (int i12 = 0; i12 < 4; i12++) {
                            i11 |= (bArr5[i12] & 255) << (i12 * 8);
                        }
                        bVar.f881a = i11;
                    }
                    mVarArr[i10] = bVar;
                }
            }
            int i13 = 0;
            while (true) {
                int i14 = i3;
                if (i13 >= i14) {
                    if (!mVarArr[i14].e()) {
                        throw new r("Unsupported XZ filter chain");
                    }
                    int i15 = 0;
                    for (int i16 = 0; i16 < i8; i16++) {
                        if (mVarArr[i16].a()) {
                            i15++;
                        }
                    }
                    if (i15 > 3) {
                        throw new r("Unsupported XZ filter chain");
                    }
                    if (i2 >= 0) {
                        int i17 = 0;
                        for (int i18 = 0; i18 < i8; i18++) {
                            i17 += mVarArr[i18].d();
                        }
                        if (i17 > i2) {
                            throw new h("" + i17 + " KiB of memory would be needed; limit was " + i2 + " KiB");
                        }
                    }
                    i iVar = new i(inputStream);
                    this.f888b = iVar;
                    this.f889c = iVar;
                    for (int i19 = i14; i19 >= 0; i19--) {
                        this.f889c = mVarArr[i19].b(this.f889c, aVar);
                    }
                    return;
                }
                if (!mVarArr[i13].c()) {
                    throw new r("Unsupported XZ filter chain");
                }
                i13++;
                i3 = i14;
            }
        } catch (IOException unused) {
            throw new h("XZ Block Header is corrupt");
        }
    }

    public final void a() {
        long j2 = this.f888b.f899a;
        long j3 = this.f893g;
        if (j3 == -1 || j3 == j2) {
            long j4 = this.f892f;
            if (j4 == -1 || j4 == this.f896j) {
                while (true) {
                    long j5 = 1 + j2;
                    long j6 = j2 & 3;
                    DataInputStream dataInputStream = this.f887a;
                    if (j6 == 0) {
                        o.c cVar = this.f890d;
                        byte[] bArr = new byte[cVar.f953a];
                        dataInputStream.readFully(bArr);
                        if (!this.f891e || Arrays.equals(cVar.a(), bArr)) {
                            return;
                        }
                        throw new h("Integrity check (" + cVar.f954b + ") does not match");
                    }
                    if (dataInputStream.readUnsignedByte() != 0) {
                        throw new h();
                    }
                    j2 = j5;
                }
            }
        }
        throw new h();
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f889c.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            this.f889c.close();
        } catch (IOException unused) {
        }
        this.f889c = null;
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = this.f898l;
        if (read(bArr, 0, 1) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        if (this.f897k) {
            return -1;
        }
        int read = this.f889c.read(bArr, i2, i3);
        if (read > 0) {
            if (this.f891e) {
                this.f890d.b(bArr, i2, read);
            }
            long j2 = this.f896j + read;
            this.f896j = j2;
            long j3 = this.f888b.f899a;
            if (j3 >= 0 && j3 <= this.f894h && j2 >= 0) {
                long j4 = this.f892f;
                if (j4 == -1 || j2 <= j4) {
                    if (read < i3 || j2 == j4) {
                        if (this.f889c.read() != -1) {
                            throw new h();
                        }
                        a();
                        this.f897k = true;
                    }
                }
            }
            throw new h();
        }
        if (read == -1) {
            a();
            this.f897k = true;
        }
        return read;
    }
}
