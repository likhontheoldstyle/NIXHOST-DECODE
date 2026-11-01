package a;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.nix.host.MainActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class I implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f125a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f126b;

    public /* synthetic */ I(View view, int i2) {
        this.f125a = i2;
        this.f126b = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View view = this.f126b;
        switch (this.f125a) {
            case 0:
                view.animate().translationY(0.0f).setDuration(300L).setInterpolator(new DecelerateInterpolator(1.8f)).start();
                break;
            default:
                int i2 = MainActivity.R;
                view.setVisibility(8);
                break;
        }
    }
}
