package n;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile a f880a;

    static {
        a aVar = new a();
        String property = System.getProperty("org.tukaani.xz.ArrayCache");
        if (property == null) {
            property = "Dummy";
        }
        if (property.equals("Basic")) {
            f880a = e.f885a;
        } else {
            if (property.equals("Dummy")) {
                f880a = aVar;
                return;
            }
            throw new Error("Unsupported value '" + property + "' in the system property org.tukaani.xz.ArrayCache. Supported values: Dummy, Basic");
        }
    }

    public byte[] a(int i2) {
        return new byte[i2];
    }

    public void b(byte[] bArr) {
    }
}
