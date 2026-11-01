package n;

import a.AbstractC0008c;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public final class q extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public InputStream f928a;

    /* renamed from: b, reason: collision with root package name */
    public final a f929b;

    /* renamed from: c, reason: collision with root package name */
    public final int f930c;

    /* renamed from: d, reason: collision with root package name */
    public final b f931d;

    /* renamed from: e, reason: collision with root package name */
    public final o.c f932e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f933f;

    /* renamed from: g, reason: collision with root package name */
    public g f934g = null;

    /* renamed from: h, reason: collision with root package name */
    public final r.a f935h = new r.a();

    /* renamed from: i, reason: collision with root package name */
    public boolean f936i = false;

    /* renamed from: j, reason: collision with root package name */
    public IOException f937j = null;

    /* renamed from: k, reason: collision with root package name */
    public final byte[] f938k = new byte[1];

    public q(InputStream inputStream, int i2, boolean z, byte[] bArr, a aVar) {
        o.c cVar;
        this.f929b = aVar;
        this.f928a = inputStream;
        this.f930c = i2;
        this.f933f = z;
        for (int i3 = 0; i3 < 6; i3++) {
            if (bArr[i3] != s.f939a[i3]) {
                throw new t("Input is not in the XZ format");
            }
        }
        if (!AbstractC0008c.o(bArr, 6, 2, 8)) {
            throw new h("XZ Stream Header is corrupt");
        }
        try {
            b f2 = AbstractC0008c.f(bArr, 6);
            this.f931d = f2;
            int i4 = f2.f881a;
            if (i4 == 0) {
                o.c dVar = new o.d();
                dVar.f953a = 0;
                dVar.f954b = "None";
                cVar = dVar;
            } else if (i4 == 1) {
                cVar = new o.a(0);
            } else {
                if (i4 != 4) {
                    if (i4 == 10) {
                        try {
                            cVar = new o.a(1);
                        } catch (NoSuchAlgorithmException unused) {
                        }
                    }
                    throw new r("Unsupported Check ID " + i4);
                }
                o.b bVar = new o.b();
                bVar.f952c = -1L;
                bVar.f953a = 8;
                bVar.f954b = "CRC64";
                cVar = bVar;
            }
            this.f932e = cVar;
        } catch (r unused2) {
            throw new r("Unsupported options in XZ Stream Header");
        }
    }

    public final void a(boolean z) {
        if (this.f928a != null) {
            g gVar = this.f934g;
            if (gVar != null) {
                gVar.close();
                this.f934g = null;
            }
            if (z) {
                try {
                    this.f928a.close();
                } finally {
                    this.f928a = null;
                }
            }
        }
    }

    @Override // java.io.InputStream
    public final int available() {
        if (this.f928a == null) {
            throw new u("Stream closed");
        }
        IOException iOException = this.f937j;
        if (iOException != null) {
            throw iOException;
        }
        g gVar = this.f934g;
        if (gVar == null) {
            return 0;
        }
        return gVar.f889c.available();
    }

    public final void b() {
        byte[] bArr = new byte[12];
        new DataInputStream(this.f928a).readFully(bArr);
        byte b2 = bArr[10];
        byte[] bArr2 = s.f940b;
        if (b2 != bArr2[0] || bArr[11] != bArr2[1]) {
            throw new h("XZ Stream Footer is corrupt");
        }
        if (!AbstractC0008c.o(bArr, 4, 6, 0)) {
            throw new h("XZ Stream Footer is corrupt");
        }
        try {
            b f2 = AbstractC0008c.f(bArr, 8);
            f2.f882b = 0L;
            for (int i2 = 0; i2 < 4; i2++) {
                f2.f882b |= (bArr[i2 + 4] & 255) << (i2 * 8);
            }
            f2.f882b = (f2.f882b + 1) * 4;
            if (this.f931d.f881a == f2.f881a) {
                if (((AbstractC0008c.n(r0.f959e) + 1 + this.f935h.f958d + 7) & (-4)) == f2.f882b) {
                    return;
                }
            }
            throw new h("XZ Stream Footer does not match Stream Header");
        } catch (r unused) {
            throw new r("Unsupported options in XZ Stream Footer");
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a(true);
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = this.f938k;
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
        if (this.f928a == null) {
            throw new u("Stream closed");
        }
        IOException iOException = this.f937j;
        if (iOException != null) {
            throw iOException;
        }
        if (this.f936i) {
            return -1;
        }
        while (i3 > 0) {
            try {
                g gVar = this.f934g;
                r.a aVar = this.f935h;
                if (gVar == null) {
                    try {
                        this.f934g = new g(this.f928a, this.f932e, this.f933f, this.f930c, this.f929b);
                    } catch (n unused) {
                        aVar.b(this.f928a);
                        b();
                        this.f936i = true;
                        if (i5 > 0) {
                            return i5;
                        }
                        return -1;
                    }
                }
                int read = this.f934g.read(bArr, i2, i3);
                if (read > 0) {
                    i5 += read;
                    i2 += read;
                    i3 -= read;
                } else if (read == -1) {
                    g gVar2 = this.f934g;
                    aVar.a(gVar2.f895i + gVar2.f888b.f899a + gVar2.f890d.f953a, gVar2.f896j);
                    this.f934g = null;
                }
            } catch (IOException e2) {
                this.f937j = e2;
                if (i5 == 0) {
                    throw e2;
                }
            }
        }
        return i5;
    }
}
