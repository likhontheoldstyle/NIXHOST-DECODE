package n;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class o extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final a f906a;

    /* renamed from: b, reason: collision with root package name */
    public DataInputStream f907b;

    /* renamed from: c, reason: collision with root package name */
    public s.a f908c;

    /* renamed from: d, reason: collision with root package name */
    public u.a f909d;

    /* renamed from: e, reason: collision with root package name */
    public t.c f910e;

    /* renamed from: f, reason: collision with root package name */
    public int f911f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f912g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f913h = true;

    /* renamed from: i, reason: collision with root package name */
    public boolean f914i = true;

    /* renamed from: j, reason: collision with root package name */
    public boolean f915j = false;

    /* renamed from: k, reason: collision with root package name */
    public IOException f916k = null;

    /* renamed from: l, reason: collision with root package name */
    public final byte[] f917l = new byte[1];

    public o(InputStream inputStream, int i2, a aVar) {
        inputStream.getClass();
        this.f906a = aVar;
        this.f907b = new DataInputStream(inputStream);
        this.f909d = new u.a(aVar);
        this.f908c = new s.a(b(i2), aVar);
    }

    public static int b(int i2) {
        if (i2 >= 4096 && i2 <= 2147483632) {
            return (i2 + 15) & (-16);
        }
        throw new IllegalArgumentException("Unsupported dictionary size " + i2);
    }

    public final void a() {
        int readUnsignedByte = this.f907b.readUnsignedByte();
        if (readUnsignedByte == 0) {
            this.f915j = true;
            s.a aVar = this.f908c;
            if (aVar != null) {
                a aVar2 = this.f906a;
                aVar2.b(aVar.f961a);
                this.f908c = null;
                aVar2.b(this.f909d.f995c);
                this.f909d = null;
                return;
            }
            return;
        }
        if (readUnsignedByte >= 224 || readUnsignedByte == 1) {
            this.f914i = true;
            this.f913h = false;
            s.a aVar3 = this.f908c;
            aVar3.f963c = 0;
            aVar3.f964d = 0;
            aVar3.f965e = 0;
            aVar3.f966f = 0;
            aVar3.f961a[aVar3.f962b - 1] = 0;
        } else if (this.f913h) {
            throw new h();
        }
        if (readUnsignedByte < 128) {
            if (readUnsignedByte > 2) {
                throw new h();
            }
            this.f912g = false;
            this.f911f = this.f907b.readUnsignedShort() + 1;
            return;
        }
        this.f912g = true;
        int i2 = (readUnsignedByte & 31) << 16;
        this.f911f = i2;
        this.f911f = this.f907b.readUnsignedShort() + 1 + i2;
        int readUnsignedShort = this.f907b.readUnsignedShort();
        int i3 = readUnsignedShort + 1;
        if (readUnsignedByte >= 192) {
            this.f914i = false;
            int readUnsignedByte2 = this.f907b.readUnsignedByte();
            if (readUnsignedByte2 > 224) {
                throw new h();
            }
            int i4 = readUnsignedByte2 / 45;
            int i5 = readUnsignedByte2 - (i4 * 45);
            int i6 = i5 / 9;
            int i7 = i5 - (i6 * 9);
            if (i7 + i6 > 4) {
                throw new h();
            }
            this.f910e = new t.c(this.f908c, this.f909d, i7, i6, i4);
        } else {
            if (this.f914i) {
                throw new h();
            }
            if (readUnsignedByte >= 160) {
                this.f910e.b();
            }
        }
        u.a aVar4 = this.f909d;
        DataInputStream dataInputStream = this.f907b;
        aVar4.getClass();
        if (i3 < 5) {
            throw new h();
        }
        if (dataInputStream.readUnsignedByte() != 0) {
            throw new h();
        }
        aVar4.f994b = dataInputStream.readInt();
        aVar4.f993a = -1;
        int i8 = readUnsignedShort - 4;
        byte[] bArr = aVar4.f995c;
        int length = bArr.length - i8;
        aVar4.f996d = length;
        dataInputStream.readFully(bArr, length, i8);
    }

    @Override // java.io.InputStream
    public final int available() {
        DataInputStream dataInputStream = this.f907b;
        if (dataInputStream == null) {
            throw new u("Stream closed");
        }
        IOException iOException = this.f916k;
        if (iOException == null) {
            return this.f912g ? this.f911f : Math.min(this.f911f, dataInputStream.available());
        }
        throw iOException;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f907b != null) {
            s.a aVar = this.f908c;
            if (aVar != null) {
                a aVar2 = this.f906a;
                aVar2.b(aVar.f961a);
                this.f908c = null;
                aVar2.b(this.f909d.f995c);
                this.f909d = null;
            }
            try {
                this.f907b.close();
            } finally {
                this.f907b = null;
            }
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = this.f917l;
        if (read(bArr, 0, 1) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        int i4;
        if (i2 < 0 || i3 < 0 || (i4 = i2 + i3) < 0 || i4 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i3 == 0) {
            return 0;
        }
        if (this.f907b == null) {
            throw new u("Stream closed");
        }
        IOException iOException = this.f916k;
        if (iOException != null) {
            throw iOException;
        }
        if (this.f915j) {
            return -1;
        }
        int i5 = 0;
        while (i3 > 0) {
            try {
                if (this.f911f == 0) {
                    a();
                    if (this.f915j) {
                        if (i5 == 0) {
                            return -1;
                        }
                        return i5;
                    }
                }
                int min = Math.min(this.f911f, i3);
                if (this.f912g) {
                    s.a aVar = this.f908c;
                    int i6 = aVar.f964d;
                    int i7 = aVar.f962b;
                    if (i7 - i6 <= min) {
                        aVar.f966f = i7;
                    } else {
                        aVar.f966f = i6 + min;
                    }
                    this.f910e.a();
                } else {
                    s.a aVar2 = this.f908c;
                    DataInputStream dataInputStream = this.f907b;
                    int min2 = Math.min(aVar2.f962b - aVar2.f964d, min);
                    dataInputStream.readFully(aVar2.f961a, aVar2.f964d, min2);
                    int i8 = aVar2.f964d + min2;
                    aVar2.f964d = i8;
                    if (aVar2.f965e < i8) {
                        aVar2.f965e = i8;
                    }
                }
                s.a aVar3 = this.f908c;
                int i9 = aVar3.f964d;
                int i10 = aVar3.f963c;
                int i11 = i9 - i10;
                if (i9 == aVar3.f962b) {
                    aVar3.f964d = 0;
                }
                System.arraycopy(aVar3.f961a, i10, bArr, i2, i11);
                aVar3.f963c = aVar3.f964d;
                i2 += i11;
                i3 -= i11;
                i5 += i11;
                int i12 = this.f911f - i11;
                this.f911f = i12;
                if (i12 == 0) {
                    u.a aVar4 = this.f909d;
                    boolean z = true;
                    if (aVar4.f996d == aVar4.f995c.length && aVar4.f994b == 0) {
                        if (this.f908c.f967g <= 0) {
                            z = false;
                        }
                        if (!z) {
                        }
                    }
                    throw new h();
                }
            } catch (IOException e2) {
                this.f916k = e2;
                throw e2;
            }
        }
        return i5;
    }
}
