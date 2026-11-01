package n;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class v extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final a f941a;

    /* renamed from: b, reason: collision with root package name */
    public final int f942b;

    /* renamed from: c, reason: collision with root package name */
    public InputStream f943c;

    /* renamed from: d, reason: collision with root package name */
    public q f944d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f945e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f946f;

    /* renamed from: g, reason: collision with root package name */
    public IOException f947g;

    /* renamed from: h, reason: collision with root package name */
    public final byte[] f948h;

    public v(InputStream inputStream) {
        a aVar = a.f880a;
        this.f946f = false;
        this.f947g = null;
        this.f948h = new byte[1];
        this.f941a = aVar;
        this.f943c = inputStream;
        this.f942b = -1;
        this.f945e = true;
        byte[] bArr = new byte[12];
        new DataInputStream(inputStream).readFully(bArr);
        this.f944d = new q(inputStream, -1, true, bArr, aVar);
    }

    public final void a() {
        DataInputStream dataInputStream = new DataInputStream(this.f943c);
        byte[] bArr = new byte[12];
        while (dataInputStream.read(bArr, 0, 1) != -1) {
            dataInputStream.readFully(bArr, 1, 3);
            if (bArr[0] != 0 || bArr[1] != 0 || bArr[2] != 0 || bArr[3] != 0) {
                dataInputStream.readFully(bArr, 4, 8);
                try {
                    this.f944d = new q(this.f943c, this.f942b, this.f945e, bArr, this.f941a);
                    return;
                } catch (t unused) {
                    throw new h("Garbage after a valid XZ Stream");
                }
            }
        }
        this.f946f = true;
    }

    @Override // java.io.InputStream
    public final int available() {
        if (this.f943c == null) {
            throw new u("Stream closed");
        }
        IOException iOException = this.f947g;
        if (iOException != null) {
            throw iOException;
        }
        q qVar = this.f944d;
        if (qVar == null) {
            return 0;
        }
        return qVar.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f943c != null) {
            q qVar = this.f944d;
            if (qVar != null) {
                qVar.a(false);
                this.f944d = null;
            }
            try {
                this.f943c.close();
            } finally {
                this.f943c = null;
            }
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = this.f948h;
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
        int i5 = 0;
        if (i3 == 0) {
            return 0;
        }
        if (this.f943c == null) {
            throw new u("Stream closed");
        }
        IOException iOException = this.f947g;
        if (iOException != null) {
            throw iOException;
        }
        if (this.f946f) {
            return -1;
        }
        while (i3 > 0) {
            try {
                if (this.f944d == null) {
                    a();
                    if (this.f946f) {
                        if (i5 == 0) {
                            return -1;
                        }
                        return i5;
                    }
                }
                int read = this.f944d.read(bArr, i2, i3);
                if (read > 0) {
                    i5 += read;
                    i2 += read;
                    i3 -= read;
                } else if (read == -1) {
                    this.f944d = null;
                }
            } catch (IOException e2) {
                this.f947g = e2;
                if (i5 == 0) {
                    throw e2;
                }
            }
        }
        return i5;
    }
}
