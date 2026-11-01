package a;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.LinearLayout;
import com.nix.host.MainActivity;

public final class DragSheetLayout extends LinearLayout {

    public float startY;

    public boolean dragging;

    public VelocityTracker velocityTracker;

    public final int threshold;

    public final i.g onDragRef;

    public final i.g onReleaseRef;

    public DragSheetLayout(MainActivity mainActivity, int i2, i.g gVar, i.g gVar2) {
        super(mainActivity);
        this.threshold = i2;
        this.onDragRef = gVar;
        this.onReleaseRef = gVar2;
    }

    @Override
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.startY = motionEvent.getRawY();
            this.dragging = false;
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            VelocityTracker obtain = VelocityTracker.obtain();
            this.velocityTracker = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
        } else if (actionMasked == 2) {
            VelocityTracker velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            if (!this.dragging && motionEvent.getRawY() - this.startY > this.threshold) {
                this.dragging = true;
            }
        }
        return this.dragging;
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (motionEvent.getRawY() - this.startY > this.threshold) {
                    this.dragging = true;
                }
                if (this.dragging) {
                    ((h.b) this.onDragRef.f850b).a(Float.valueOf(Math.max(0.0f, motionEvent.getRawY() - this.startY)));
                }
            }
            return true;
        }
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.computeCurrentVelocity(1000);
        }
        VelocityTracker velocityTracker3 = this.velocityTracker;
        float yVelocity = velocityTracker3 != null ? velocityTracker3.getYVelocity() : 0.0f;
        VelocityTracker velocityTracker4 = this.velocityTracker;
        if (velocityTracker4 != null) {
            velocityTracker4.recycle();
        }
        this.velocityTracker = null;
        if (this.dragging) {
            ((h.c) this.onReleaseRef.f850b).a(Float.valueOf(Math.max(0.0f, motionEvent.getRawY() - this.startY)), Float.valueOf(yVelocity));
        }
        this.dragging = false;
        return true;
    }
}
