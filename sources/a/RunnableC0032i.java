package a;

import java.io.File;
import org.json.JSONObject;

/* renamed from: a.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0032i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f526a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f527b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f528c;

    public /* synthetic */ RunnableC0032i(C0006b1 c0006b1, String str) {
        this.f526a = 1;
        this.f527b = c0006b1;
        this.f528c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0006b1 c0006b1 = this.f527b;
        String str = this.f528c;
        switch (this.f526a) {
            case 0:
                File file = z2.f758a;
                z2.b(str);
                c0006b1.f418e.post(new RunnableC0032i(c0006b1, str));
                break;
            case 1:
                c0006b1.p1.remove(str);
                break;
            default:
                c0006b1.f414a.runOnUiThread(new RunnableC0056o(C0004b.b(C0004b.f409a, "POST", "/chat/profile", new JSONObject().put("name", str), 8), c0006b1, str));
                break;
        }
    }

    public /* synthetic */ RunnableC0032i(String str, C0006b1 c0006b1, int i2) {
        this.f526a = i2;
        this.f528c = str;
        this.f527b = c0006b1;
    }
}
