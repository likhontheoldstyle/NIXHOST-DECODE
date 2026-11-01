package a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import java.io.File;
import org.json.JSONObject;

/* renamed from: a.j0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0037j0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f543a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f544b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f545c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f546d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f547e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f548f;

    public /* synthetic */ RunnableC0037j0(K0 k0, String str, int i2, C0006b1 c0006b1, C0000a c0000a) {
        this.f544b = k0;
        this.f545c = str;
        this.f546d = i2;
        this.f547e = c0006b1;
        this.f548f = c0000a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String concat;
        switch (this.f543a) {
            case 0:
                C0004b c0004b = C0004b.f409a;
                K0 k0 = (K0) this.f544b;
                C0000a b2 = C0004b.b(c0004b, "POST", "/chat/edit/" + k0.f150a, new JSONObject().put("text", this.f545c), 8);
                if (!b2.b()) {
                    C0006b1 c0006b1 = (C0006b1) this.f547e;
                    c0006b1.f414a.runOnUiThread(new RunnableC0037j0(k0, (String) this.f548f, this.f546d, c0006b1, b2));
                    break;
                }
                break;
            case 1:
                String str = this.f545c;
                K0 k02 = (K0) this.f544b;
                k02.f153d = str;
                k02.f164o = this.f546d;
                C0006b1 c0006b12 = (C0006b1) this.f547e;
                c0006b12.x0(false);
                c0006b12.f416c.a(C0006b1.E((C0000a) this.f548f));
                break;
            case 2:
                File file = z2.f758a;
                String str2 = this.f545c;
                File b3 = z2.b(str2);
                Bitmap a2 = b3 != null ? z2.a(b3, this.f546d) : null;
                if (a2 != null) {
                    z2.f759b.put((String) this.f548f, a2);
                }
                z2.f761d.post(new K(this.f544b, str2, (Object) a2, this.f547e, 7));
                break;
            default:
                String str3 = this.f545c;
                String str4 = (String) this.f548f;
                File file2 = (File) this.f544b;
                int i2 = this.f546d;
                K2 k2 = (K2) this.f547e;
                try {
                    concat = B2.a(str3, str4, file2);
                } catch (Exception e2) {
                    String message = e2.getMessage();
                    if (message == null) {
                        message = "error";
                    }
                    concat = "Failed: ".concat(message);
                }
                if (i2 == k2.f181o) {
                    k2.a(concat + "\n");
                    k2.f();
                    break;
                }
                break;
        }
    }

    public /* synthetic */ RunnableC0037j0(K0 k0, String str, C0006b1 c0006b1, String str2, int i2) {
        this.f544b = k0;
        this.f545c = str;
        this.f547e = c0006b1;
        this.f548f = str2;
        this.f546d = i2;
    }

    public /* synthetic */ RunnableC0037j0(String str, int i2, String str2, ImageView imageView, h.b bVar) {
        this.f545c = str;
        this.f546d = i2;
        this.f548f = str2;
        this.f544b = imageView;
        this.f547e = bVar;
    }

    public /* synthetic */ RunnableC0037j0(String str, String str2, File file, int i2, K2 k2) {
        this.f545c = str;
        this.f548f = str2;
        this.f544b = file;
        this.f546d = i2;
        this.f547e = k2;
    }
}
