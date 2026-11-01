package a;

import android.animation.ValueAnimator;
import android.view.View;
import com.nix.host.MainActivity;

public final class SheetSlideAnimatorListener implements ValueAnimator.AnimatorUpdateListener {

    public final int mode;

    public final DragSheetLayout sheet;

    public final float slideDistance;

    public final View scrimView;

    public SheetSlideAnimatorListener(DragSheetLayout dragSheetLayout, float f2, View view) {
        this.mode = 1;
        this.sheet = dragSheetLayout;
        this.slideDistance = f2;
        this.scrimView = view;
    }

    @Override
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view = this.scrimView;
        DragSheetLayout dragSheetLayout = this.sheet;
        float f2 = this.slideDistance;
        switch (this.mode) {
            case 0:
                int i2 = MainActivity.R;
                Object animatedValue = valueAnimator.getAnimatedValue();
                i.b.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                float floatValue = ((Float) animatedValue).floatValue();
                dragSheetLayout.setTranslationY(floatValue);
                view.setAlpha(AppState.b(1.0f - (floatValue / f2), 0.0f, 1.0f));
                break;
            default:
                int i3 = MainActivity.R;
                Object animatedValue2 = valueAnimator.getAnimatedValue();
                i.b.c(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
                float floatValue2 = ((Float) animatedValue2).floatValue();
                dragSheetLayout.setTranslationY((1.0f - floatValue2) * f2);
                view.setAlpha(floatValue2);
                break;
        }
    }

    public SheetSlideAnimatorListener(DragSheetLayout dragSheetLayout, View view, float f2) {
        this.mode = 0;
        this.sheet = dragSheetLayout;
        this.scrimView = view;
        this.slideDistance = f2;
    }
}
