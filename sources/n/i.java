package n;

import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class i extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public long f899a;

    public i(InputStream inputStream) {
        super(inputStream);
        this.f899a = 0L;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        int read = ((FilterInputStream) this).in.read();
        if (read != -1) {
            long j2 = this.f899a;
            if (j2 >= 0) {
                this.f899a = j2 + 1;
            }
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        int read = ((FilterInputStream) this).in.read(bArr, i2, i3);
        if (read > 0) {
            long j2 = this.f899a;
            if (j2 >= 0) {
                this.f899a = j2 + read;
            }
        }
        return read;
    }
}
