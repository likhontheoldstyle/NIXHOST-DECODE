package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.FrameLayout;

public final class SheetDismissAnimatorListener extends AnimatorListenerAdapter {

    public final FrameLayout container;

    public final DragSheetLayout sheet;

    public final View scrimView;

    public final h.a onFinished;

    public SheetDismissAnimatorListener(FrameLayout frameLayout, DragSheetLayout dragSheetLayout, View view, h.a aVar) {
        this.container = frameLayout;
        this.sheet = dragSheetLayout;
        this.scrimView = view;
        this.onFinished = aVar;
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        DragSheetLayout dragSheetLayout = this.sheet;
        FrameLayout frameLayout = this.container;
        frameLayout.removeView(dragSheetLayout);
        frameLayout.removeView(this.scrimView);
        this.onFinished.a();
    }
}
