package a;

import android.view.animation.DecelerateInterpolator;

/* loaded from: classes.dex */
public final /* synthetic */ class L implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f186a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ D2 f187b;

    public /* synthetic */ L(D2 d2, int i2) {
        this.f186a = i2;
        this.f187b = d2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f186a) {
            case 0:
                this.f187b.animate().translationY(0.0f).setDuration(300L).setInterpolator(new DecelerateInterpolator(1.8f)).start();
                break;
            default:
                this.f187b.f71b.a();
                break;
        }
    }
}
