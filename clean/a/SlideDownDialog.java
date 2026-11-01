package a;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

public final class SlideDownDialog extends Dialog {

    public View sheetView;

    public boolean dismissing;

    public SlideDownDialog(Context context) {
        super(context);
    }

    public static void dismissImmediately(SlideDownDialog e2) {
        try {
            e2.dismiss();
        } catch (Exception unused) {
        }
    }

    @Override
    public final void dismiss() {
        View view = this.sheetView;
        if (this.dismissing || view == null || !isShowing() || view.getHeight() == 0 || view.getTranslationY() >= view.getHeight() - 2.0f) {
            super.dismiss();
        } else {
            this.dismissing = true;
            view.animate().translationY(view.getHeight()).setDuration(200L).setInterpolator(new AccelerateInterpolator(1.3f)).withEndAction(new TaskRunnable(9, this)).start();
        }
    }
}
