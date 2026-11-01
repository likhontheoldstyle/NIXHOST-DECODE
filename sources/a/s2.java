package a;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.LinearLayout;
import com.nix.host.MainActivity;

/* loaded from: classes.dex */
public final class s2 extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public float f654a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f655b;

    /* renamed from: c, reason: collision with root package name */
    public VelocityTracker f656c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f657d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ i.g f658e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ i.g f659f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s2(MainActivity mainActivity, int i2, i.g gVar, i.g gVar2) {
        super(mainActivity);
        this.f657d = i2;
        this.f658e = gVar;
        this.f659f = gVar2;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f654a = motionEvent.getRawY();
            this.f655b = false;
            VelocityTracker velocityTracker = this.f656c;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f656c = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
        } else if (actionMasked == 2) {
            VelocityTracker velocityTracker2 = this.f656c;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            if (!this.f655b && motionEvent.getRawY() - this.f654a > this.f657d) {
                this.f655b = true;
            }
        }
        return this.f655b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0013, code lost:
    
        if (r0 != 3) goto L32;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker = this.f656c;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (motionEvent.getRawY() - this.f654a > this.f657d) {
                    this.f655b = true;
                }
                if (this.f655b) {
                    ((h.b) this.f658e.f850b).a(Float.valueOf(Math.max(0.0f, motionEvent.getRawY() - this.f654a)));
                }
            }
            return true;
        }
        VelocityTracker velocityTracker2 = this.f656c;
        if (velocityTracker2 != null) {
            velocityTracker2.computeCurrentVelocity(1000);
        }
        VelocityTracker velocityTracker3 = this.f656c;
        float yVelocity = velocityTracker3 != null ? velocityTracker3.getYVelocity() : 0.0f;
        VelocityTracker velocityTracker4 = this.f656c;
        if (velocityTracker4 != null) {
            velocityTracker4.recycle();
        }
        this.f656c = null;
        if (this.f655b) {
            ((h.c) this.f659f.f850b).a(Float.valueOf(Math.max(0.0f, motionEvent.getRawY() - this.f654a)), Float.valueOf(yVelocity));
        }
        this.f655b = false;
        return true;
    }
}
