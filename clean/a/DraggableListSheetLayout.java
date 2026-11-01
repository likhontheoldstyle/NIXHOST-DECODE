package a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ListView;

public final class DraggableListSheetLayout extends FrameLayout {

    public final ListView listView;

    public final h.a onDismiss;

    public final int touchSlop;

    public float startY;

    public boolean dragging;

    public VelocityTracker velocityTracker;

    public DraggableListSheetLayout(Context context, ListView listView, DismissAction dismissAction) {
        super(context);
        this.listView = listView;
        this.onDismiss = dismissAction;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
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
        if (motionEvent.getActionMasked() != 2 || this.dragging || motionEvent.getRawY() - this.startY <= this.touchSlop || this.listView.canScrollVertically(-1)) {
            return false;
        }
        this.dragging = true;
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
                    setTranslationY(Math.max(0.0f, motionEvent.getRawY() - this.startY));
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
            this.dragging = false;
            if (getTranslationY() > getHeight() * 0.28f || yVelocity > 1400.0f) {
                animate().translationY(getHeight()).setDuration(160L).withEndAction(new SheetSlideRunnable(this, 1)).start();
            } else {
                animate().translationY(0.0f).setDuration(160L).start();
            }
        } else {
            this.startY = motionEvent.getRawY();
            this.dragging = true;
        }
        return true;
    }
}
