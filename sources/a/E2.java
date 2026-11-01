package a;

import android.app.Dialog;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

/* loaded from: classes.dex */
public final class E2 extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    public View f84a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f85b;

    public static void a(E2 e2) {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        View view = this.f84a;
        if (this.f85b || view == null || !isShowing() || view.getHeight() == 0 || view.getTranslationY() >= view.getHeight() - 2.0f) {
            super.dismiss();
        } else {
            this.f85b = true;
            view.animate().translationY(view.getHeight()).setDuration(200L).setInterpolator(new AccelerateInterpolator(1.3f)).withEndAction(new G(9, this)).start();
        }
    }
}
