package o;

import a.AbstractC0008c;
import java.security.MessageDigest;
import java.util.zip.CRC32;

/* loaded from: classes.dex */
public final class a extends c {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f949c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f950d;

    public a(int i2) {
        this.f949c = i2;
        switch (i2) {
            case 1:
                this.f953a = 32;
                this.f954b = "SHA-256";
                this.f950d = MessageDigest.getInstance("SHA-256");
                break;
            default:
                this.f950d = new CRC32();
                this.f953a = 4;
                this.f954b = "CRC32";
                break;
        }
    }

    @Override // o.c
    public final byte[] a() {
        switch (this.f949c) {
            case 0:
                byte[] bArr = new byte[4];
                CRC32 crc32 = (CRC32) this.f950d;
                AbstractC0008c.x(bArr, 0, (int) crc32.getValue());
                crc32.reset();
                return bArr;
            default:
                MessageDigest messageDigest = (MessageDigest) this.f950d;
                byte[] digest = messageDigest.digest();
                messageDigest.reset();
                return digest;
        }
    }

    @Override // o.c
    public final void b(byte[] bArr, int i2, int i3) {
        switch (this.f949c) {
            case 0:
                ((CRC32) this.f950d).update(bArr, i2, i3);
                break;
            default:
                ((MessageDigest) this.f950d).update(bArr, i2, i3);
                break;
        }
    }
}
