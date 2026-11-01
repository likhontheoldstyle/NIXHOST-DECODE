package g;

import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public final class b extends ByteArrayOutputStream {
    public final byte[] a() {
        byte[] bArr = ((ByteArrayOutputStream) this).buf;
        i.b.d(bArr, "buf");
        return bArr;
    }
}
