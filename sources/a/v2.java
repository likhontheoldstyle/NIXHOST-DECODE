package a;

import java.io.BufferedInputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class v2 extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f689a;

    /* renamed from: b, reason: collision with root package name */
    public long f690b;

    public v2(BufferedInputStream bufferedInputStream, long j2) {
        this.f689a = bufferedInputStream;
        this.f690b = j2;
    }

    @Override // java.io.InputStream
    public final int read() {
        if (this.f690b <= 0) {
            return -1;
        }
        int read = this.f689a.read();
        if (read >= 0) {
            this.f690b--;
        }
        return read;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        long j2 = this.f690b;
        if (j2 <= 0) {
            return -1;
        }
        int read = this.f689a.read(bArr, i2, (int) Math.min(i3, j2));
        if (read > 0) {
            this.f690b -= read;
        }
        return read;
    }
}
