package a;

import java.io.BufferedInputStream;
import java.io.InputStream;

public final class LimitedInputStream extends InputStream {

    public final InputStream delegate;

    public long remaining;

    public LimitedInputStream(BufferedInputStream bufferedInputStream, long j2) {
        this.delegate = bufferedInputStream;
        this.remaining = j2;
    }

    @Override
    public final int read() {
        if (this.remaining <= 0) {
            return -1;
        }
        int read = this.delegate.read();
        if (read >= 0) {
            this.remaining--;
        }
        return read;
    }

    @Override
    public final int read(byte[] bArr, int i2, int i3) {
        long j2 = this.remaining;
        if (j2 <= 0) {
            return -1;
        }
        int read = this.delegate.read(bArr, i2, (int) Math.min(i3, j2));
        if (read > 0) {
            this.remaining -= read;
        }
        return read;
    }
}
