package n;

import a.C0000a;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class k extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public InputStream f902a;

    /* renamed from: b, reason: collision with root package name */
    public final C0000a f903b;

    /* renamed from: c, reason: collision with root package name */
    public IOException f904c = null;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f905d = new byte[1];

    public k(InputStream inputStream, int i2) {
        inputStream.getClass();
        this.f902a = inputStream;
        this.f903b = new C0000a(i2);
    }

    @Override // java.io.InputStream
    public final int available() {
        InputStream inputStream = this.f902a;
        if (inputStream == null) {
            throw new u("Stream closed");
        }
        IOException iOException = this.f904c;
        if (iOException == null) {
            return inputStream.available();
        }
        throw iOException;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        InputStream inputStream = this.f902a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f902a = null;
            }
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = this.f905d;
        if (read(bArr, 0, 1) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        byte[] bArr2;
        if (i3 == 0) {
            return 0;
        }
        InputStream inputStream = this.f902a;
        if (inputStream == null) {
            throw new u("Stream closed");
        }
        IOException iOException = this.f904c;
        if (iOException != null) {
            throw iOException;
        }
        try {
            int read = inputStream.read(bArr, i2, i3);
            if (read == -1) {
                return -1;
            }
            C0000a c0000a = this.f903b;
            int i4 = c0000a.f400a;
            int min = Math.min(read, i4);
            int i5 = 0;
            while (true) {
                bArr2 = (byte[]) c0000a.f401b;
                if (i5 >= min) {
                    break;
                }
                int i6 = i2 + i5;
                bArr[i6] = (byte) (bArr[i6] + bArr2[i5]);
                i5++;
            }
            while (i5 < read) {
                int i7 = i2 + i5;
                bArr[i7] = (byte) (bArr[i7] + bArr[i7 - i4]);
                i5++;
            }
            if (read >= i4) {
                System.arraycopy(bArr, (i2 + read) - i4, bArr2, 0, i4);
            } else {
                int i8 = i4 - i5;
                System.arraycopy(bArr2, i5, bArr2, 0, i8);
                System.arraycopy(bArr, i2, bArr2, i8, read);
            }
            return read;
        } catch (IOException e2) {
            this.f904c = e2;
            throw e2;
        }
    }
}
