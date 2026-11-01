package r;

import a.AbstractC0008c;
import java.io.DataInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import n.h;
import n.u;
import o.c;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final u f955a;

    /* renamed from: b, reason: collision with root package name */
    public long f956b;

    /* renamed from: c, reason: collision with root package name */
    public long f957c;

    /* renamed from: d, reason: collision with root package name */
    public long f958d;

    /* renamed from: e, reason: collision with root package name */
    public long f959e;

    /* renamed from: f, reason: collision with root package name */
    public final c f960f;

    public a() {
        h hVar = new h();
        this.f956b = 0L;
        this.f957c = 0L;
        this.f958d = 0L;
        this.f959e = 0L;
        this.f955a = hVar;
        try {
            this.f960f = new o.a(1);
        } catch (NoSuchAlgorithmException unused) {
            this.f960f = new o.a(0);
        }
    }

    public final void a(long j2, long j3) {
        this.f956b += (3 + j2) & (-4);
        this.f957c += j3;
        this.f958d += AbstractC0008c.n(j3) + AbstractC0008c.n(j2);
        this.f959e = this.f959e + 1;
        if (this.f956b >= 0 && this.f957c >= 0 && ((AbstractC0008c.n(r5) + 1 + this.f958d + 7) & (-4)) <= 17179869184L) {
            if (((AbstractC0008c.n(this.f959e) + 1 + this.f958d + 7) & (-4)) + this.f956b + 12 + 12 >= 0) {
                ByteBuffer allocate = ByteBuffer.allocate(16);
                allocate.putLong(j2);
                allocate.putLong(j3);
                byte[] array = allocate.array();
                c cVar = this.f960f;
                cVar.getClass();
                cVar.b(array, 0, array.length);
                return;
            }
        }
        throw this.f955a;
    }

    public final void b(InputStream inputStream) {
        CRC32 crc32 = new CRC32();
        crc32.update(0);
        CheckedInputStream checkedInputStream = new CheckedInputStream(inputStream, crc32);
        if (AbstractC0008c.g(checkedInputStream) != this.f959e) {
            throw new h("XZ Block Header or the start of XZ Index is corrupt");
        }
        a aVar = new a();
        for (long j2 = 0; j2 < this.f959e; j2++) {
            try {
                aVar.a(AbstractC0008c.g(checkedInputStream), AbstractC0008c.g(checkedInputStream));
                if (aVar.f956b > this.f956b || aVar.f957c > this.f957c || aVar.f958d > this.f958d) {
                    throw new h("XZ Index is corrupt");
                }
            } catch (u unused) {
                throw new h("XZ Index is corrupt");
            }
        }
        if (aVar.f956b != this.f956b || aVar.f957c != this.f957c || aVar.f958d != this.f958d || !Arrays.equals(aVar.f960f.a(), this.f960f.a())) {
            throw new h("XZ Index is corrupt");
        }
        DataInputStream dataInputStream = new DataInputStream(checkedInputStream);
        for (int n2 = (int) (3 & (4 - (((AbstractC0008c.n(this.f959e) + 1) + this.f958d) + 4))); n2 > 0; n2--) {
            if (dataInputStream.readUnsignedByte() != 0) {
                throw new h("XZ Index is corrupt");
            }
        }
        long value = crc32.getValue();
        for (int i2 = 0; i2 < 4; i2++) {
            if (((value >>> (i2 * 8)) & 255) != dataInputStream.readUnsignedByte()) {
                throw new h("XZ Index is corrupt");
            }
        }
    }
}
