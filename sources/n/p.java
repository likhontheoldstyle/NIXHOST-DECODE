package n;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class p extends InputStream {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f918j = 0;

    /* renamed from: a, reason: collision with root package name */
    public InputStream f919a;

    /* renamed from: b, reason: collision with root package name */
    public final v.b f920b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f921c = new byte[4096];

    /* renamed from: d, reason: collision with root package name */
    public int f922d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f923e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f924f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f925g = false;

    /* renamed from: h, reason: collision with root package name */
    public IOException f926h = null;

    /* renamed from: i, reason: collision with root package name */
    public final byte[] f927i = new byte[1];

    public p(InputStream inputStream, v.b bVar) {
        inputStream.getClass();
        this.f919a = inputStream;
        this.f920b = bVar;
    }

    @Override // java.io.InputStream
    public final int available() {
        if (this.f919a == null) {
            throw new u("Stream closed");
        }
        IOException iOException = this.f926h;
        if (iOException == null) {
            return this.f923e;
        }
        throw iOException;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        InputStream inputStream = this.f919a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f919a = null;
            }
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = this.f927i;
        if (read(bArr, 0, 1) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        int i4;
        byte[] bArr2 = this.f921c;
        if (i2 < 0 || i3 < 0 || (i4 = i2 + i3) < 0 || i4 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i3 == 0) {
            return 0;
        }
        if (this.f919a == null) {
            throw new u("Stream closed");
        }
        IOException iOException = this.f926h;
        if (iOException != null) {
            throw iOException;
        }
        int i5 = 0;
        while (true) {
            try {
                int min = Math.min(this.f923e, i3);
                System.arraycopy(bArr2, this.f922d, bArr, i2, min);
                int i6 = this.f922d + min;
                this.f922d = i6;
                int i7 = this.f923e - min;
                this.f923e = i7;
                i2 += min;
                i3 -= min;
                i5 += min;
                int i8 = this.f924f;
                if (i6 + i7 + i8 == 4096) {
                    System.arraycopy(bArr2, i6, bArr2, 0, i7 + i8);
                    this.f922d = 0;
                }
                if (i3 == 0 || this.f925g) {
                    break;
                }
                int i9 = this.f922d;
                int i10 = this.f923e;
                int i11 = this.f924f;
                int read = this.f919a.read(bArr2, i9 + i10 + i11, 4096 - ((i9 + i10) + i11));
                if (read == -1) {
                    this.f925g = true;
                    this.f923e = this.f924f;
                    this.f924f = 0;
                } else {
                    int i12 = this.f924f + read;
                    this.f924f = i12;
                    int a2 = this.f920b.a(bArr2, this.f922d, i12);
                    this.f923e = a2;
                    this.f924f -= a2;
                }
            } catch (IOException e2) {
                this.f926h = e2;
                throw e2;
            }
        }
        if (i5 > 0) {
            return i5;
        }
        return -1;
    }
}
