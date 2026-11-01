package a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ListView;

/* loaded from: classes.dex */
public final class D2 extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final ListView f70a;

    /* renamed from: b, reason: collision with root package name */
    public final h.a f71b;

    /* renamed from: c, reason: collision with root package name */
    public final int f72c;

    /* renamed from: d, reason: collision with root package name */
    public float f73d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f74e;

    /* renamed from: f, reason: collision with root package name */
    public VelocityTracker f75f;

    public D2(Context context, ListView listView, C0060p c0060p) {
        super(context);
        this.f70a = listView;
        this.f71b = c0060p;
        this.f72c = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            VelocityTracker velocityTracker = this.f75f;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            this.f75f = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker2 = this.f75f;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f73d = motionEvent.getRawY();
            this.f74e = false;
        }
        if (motionEvent.getActionMasked() != 2 || this.f74e || motionEvent.getRawY() - this.f73d <= this.f72c || this.f70a.canScrollVertically(-1)) {
            return false;
        }
        this.f74e = true;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
    
        if (r0 != 3) goto L39;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            VelocityTracker velocityTracker = this.f75f;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            this.f75f = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker2 = this.f75f;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    setTranslationY(Math.max(0.0f, motionEvent.getRawY() - this.f73d));
                }
            }
            VelocityTracker velocityTracker3 = this.f75f;
            if (velocityTracker3 != null) {
                velocityTracker3.computeCurrentVelocity(1000);
            }
            VelocityTracker velocityTracker4 = this.f75f;
            float yVelocity = velocityTracker4 != null ? velocityTracker4.getYVelocity() : 0.0f;
            VelocityTracker velocityTracker5 = this.f75f;
            if (velocityTracker5 != null) {
                velocityTracker5.recycle();
            }
            this.f75f = null;
            this.f74e = false;
            if (getTranslationY() > getHeight() * 0.28f || yVelocity > 1400.0f) {
                animate().translationY(getHeight()).setDuration(160L).withEndAction(new L(this, 1)).start();
            } else {
                animate().translationY(0.0f).setDuration(160L).start();
            }
        } else {
            this.f73d = motionEvent.getRawY();
            this.f74e = true;
        }
        return true;
    }
}
