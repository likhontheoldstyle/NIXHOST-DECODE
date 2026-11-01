package a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public final class SwipeDownSheetLayout extends LinearLayout {

    public final h.a onDismiss;

    public final int touchSlop;

    public float startY;

    public boolean dragging;

    public VelocityTracker velocityTracker;

    public SwipeDownSheetLayout(Context context, RefAction refAction) {
        super(context);
        this.onDismiss = refAction;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setOrientation(1);
    }

    public static boolean canScrollUp(View view) {
        if (view.canScrollVertically(-1)) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (canScrollUp(viewGroup.getChildAt(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            this.velocityTracker = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        if (motionEvent.getActionMasked() == 0) {
            this.startY = motionEvent.getRawY();
            this.dragging = false;
        }
        if (motionEvent.getActionMasked() != 2 || this.dragging || motionEvent.getRawY() - this.startY <= this.touchSlop || canScrollUp(this)) {
            return false;
        }
        this.dragging = true;
        this.startY = motionEvent.getRawY();
        return true;
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            this.velocityTracker = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.dragging) {
                        setTranslationY(Math.max(0.0f, motionEvent.getRawY() - this.startY));
                    }
                }
            }
            VelocityTracker velocityTracker3 = this.velocityTracker;
            if (velocityTracker3 != null) {
                velocityTracker3.computeCurrentVelocity(1000);
            }
            VelocityTracker velocityTracker4 = this.velocityTracker;
            float yVelocity = velocityTracker4 != null ? velocityTracker4.getYVelocity() : 0.0f;
            VelocityTracker velocityTracker5 = this.velocityTracker;
            if (velocityTracker5 != null) {
                velocityTracker5.recycle();
            }
            this.velocityTracker = null;
            if (this.dragging) {
                this.dragging = false;
                if (getTranslationY() > getHeight() * 0.28f || yVelocity > 1400.0f) {
                    animate().translationY(getHeight()).setDuration(160L).withEndAction(new TaskRunnable(4, this)).start();
                } else {
                    animate().translationY(0.0f).setDuration(160L).start();
                }
            }
        } else {
            this.startY = motionEvent.getRawY();
            this.dragging = false;
        }
        return true;
    }
}
