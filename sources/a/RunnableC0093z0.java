package a;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: a.z0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0093z0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f747a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f748b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f749c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f750d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f751e;

    public /* synthetic */ RunnableC0093z0(AtomicBoolean atomicBoolean, long j2, File file, K2 k2) {
        this.f749c = atomicBoolean;
        this.f748b = j2;
        this.f750d = file;
        this.f751e = k2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f747a) {
            case 0:
                C0004b c0004b = C0004b.f409a;
                JSONObject jSONObject = (JSONObject) this.f749c;
                C0000a d2 = c0004b.d(jSONObject);
                C0006b1 c0006b1 = (C0006b1) this.f750d;
                c0006b1.f414a.runOnUiThread(new RunnableC0040k(d2, c0006b1, this.f748b, jSONObject, (K0) this.f751e));
                break;
            default:
                long j2 = this.f748b;
                while (true) {
                    AtomicBoolean atomicBoolean = (AtomicBoolean) this.f749c;
                    if (!atomicBoolean.get()) {
                        break;
                    } else {
                        try {
                            Thread.sleep(j2);
                            if (!atomicBoolean.get()) {
                                break;
                            } else {
                                y2.f736a.O((File) this.f750d, ((K2) this.f751e).f168b);
                            }
                        } catch (InterruptedException unused) {
                        }
                    }
                }
        }
    }

    public /* synthetic */ RunnableC0093z0(JSONObject jSONObject, C0006b1 c0006b1, long j2, K0 k0) {
        this.f749c = jSONObject;
        this.f750d = c0006b1;
        this.f748b = j2;
        this.f751e = k0;
    }
}
