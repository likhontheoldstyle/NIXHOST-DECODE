package a;

import org.json.JSONObject;

/* renamed from: a.m0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0049m0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f589a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f590b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f591c;

    public /* synthetic */ RunnableC0049m0(int i2, long j2, C0006b1 c0006b1) {
        this.f589a = i2;
        this.f590b = j2;
        this.f591c = c0006b1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f589a) {
            case 0:
                C0000a f2 = C0004b.f409a.f(0L, this.f590b);
                C0006b1 c0006b1 = this.f591c;
                c0006b1.f414a.runOnUiThread(new S(c0006b1, f2, 4));
                break;
            default:
                C0004b c0004b = C0004b.f409a;
                C0000a f3 = c0004b.f(this.f590b, 0L);
                C0000a c0000a = null;
                C0000a b2 = C0004b.b(c0004b, "GET", "/chat/seen", null, 12);
                long currentTimeMillis = System.currentTimeMillis();
                C0006b1 c0006b12 = this.f591c;
                if (currentTimeMillis - c0006b12.q0 > 20000) {
                    c0006b12.q0 = currentTimeMillis;
                    C0004b.b(c0004b, "POST", "/chat/ping", new JSONObject(), 8);
                }
                if (currentTimeMillis - c0006b12.r0 > 8000) {
                    c0006b12.r0 = currentTimeMillis;
                    c0000a = C0004b.b(c0004b, "GET", "/chat/presence", null, 12);
                }
                c0006b12.f414a.runOnUiThread(new K(c0006b12, f3, b2, c0000a));
                break;
        }
    }
}
