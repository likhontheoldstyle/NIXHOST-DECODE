package a;

import android.net.ConnectivityManager;
import android.net.Network;

/* renamed from: a.a1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0002a1 extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f404a;

    public C0002a1(C0006b1 c0006b1) {
        this.f404a = c0006b1;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        C0006b1 c0006b1 = this.f404a;
        c0006b1.f418e.post(new RunnableC0048m(c0006b1, 14));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        C0006b1 c0006b1 = this.f404a;
        c0006b1.f418e.post(new RunnableC0048m(c0006b1, 13));
    }
}
