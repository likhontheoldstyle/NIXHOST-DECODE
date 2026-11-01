package a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* renamed from: a.k1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0042k1 extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final h.a f569a;

    /* renamed from: b, reason: collision with root package name */
    public final int f570b;

    /* renamed from: c, reason: collision with root package name */
    public float f571c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f572d;

    /* renamed from: e, reason: collision with root package name */
    public VelocityTracker f573e;

    public C0042k1(Context context, I0 i0) {
        super(context);
        this.f569a = i0;
        this.f570b = ViewConfiguration.get(context).getScaledTouchSlop();
        setOrientation(1);
    }

    public static boolean a(View view) {
        if (view.canScrollVertically(-1)) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (a(viewGroup.getChildAt(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            VelocityTracker velocityTracker = this.f573e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            this.f573e = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker2 = this.f573e;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f571c = motionEvent.getRawY();
            this.f572d = false;
        }
        if (motionEvent.getActionMasked() != 2 || this.f572d || motionEvent.getRawY() - this.f571c <= this.f570b || a(this)) {
            return false;
        }
        this.f572d = true;
        this.f571c = motionEvent.getRawY();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0029, code lost:
    
        if (r0 != 3) goto L43;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            VelocityTracker velocityTracker = this.f573e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            this.f573e = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker2 = this.f573e;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.f572d) {
                        setTranslationY(Math.max(0.0f, motionEvent.getRawY() - this.f571c));
                    }
                }
            }
            VelocityTracker velocityTracker3 = this.f573e;
            if (velocityTracker3 != null) {
                velocityTracker3.computeCurrentVelocity(1000);
            }
            VelocityTracker velocityTracker4 = this.f573e;
            float yVelocity = velocityTracker4 != null ? velocityTracker4.getYVelocity() : 0.0f;
            VelocityTracker velocityTracker5 = this.f573e;
            if (velocityTracker5 != null) {
                velocityTracker5.recycle();
            }
            this.f573e = null;
            if (this.f572d) {
                this.f572d = false;
                if (getTranslationY() > getHeight() * 0.28f || yVelocity > 1400.0f) {
                    animate().translationY(getHeight()).setDuration(160L).withEndAction(new G(4, this)).start();
                } else {
                    animate().translationY(0.0f).setDuration(160L).start();
                }
            }
        } else {
            this.f571c = motionEvent.getRawY();
            this.f572d = false;
        }
        return true;
    }
}
