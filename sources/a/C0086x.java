package a;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import java.util.ArrayList;

/* renamed from: a.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0086x implements h.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f703a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f704b;

    public /* synthetic */ C0086x(C0006b1 c0006b1, int i2) {
        this.f703a = i2;
        this.f704b = c0006b1;
    }

    @Override // h.b
    public final Object a(Object obj) {
        switch (this.f703a) {
            case 0:
                MotionEvent motionEvent = (MotionEvent) obj;
                C0006b1 c0006b1 = this.f704b;
                c0006b1.getClass();
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    c0006b1.s1 = 0;
                    c0006b1.t1 = false;
                    c0006b1.u1 = null;
                    c0006b1.v1 = null;
                    c0006b1.q1 = motionEvent.getX();
                    c0006b1.r1 = motionEvent.getY();
                    I2 i2 = c0006b1.W;
                    if (i2 == null) {
                        i.b.g("lv");
                        throw null;
                    }
                    int pointToPosition = i2.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (pointToPosition < 0) {
                        return null;
                    }
                    ArrayList arrayList = c0006b1.D;
                    if (pointToPosition >= arrayList.size()) {
                        return null;
                    }
                    K0 k0 = (K0) arrayList.get(pointToPosition);
                    I2 i22 = c0006b1.W;
                    if (i22 == null) {
                        i.b.g("lv");
                        throw null;
                    }
                    View childAt = i22.getChildAt(pointToPosition - i22.getFirstVisiblePosition());
                    Object tag = childAt != null ? childAt.getTag() : null;
                    J2 j2 = tag instanceof J2 ? (J2) tag : null;
                    if (j2 == null || k0.f159j || c0006b1.S(k0) || i.b.a(k0.f152c, "sys")) {
                        return null;
                    }
                    c0006b1.u1 = j2;
                    c0006b1.v1 = k0;
                    return null;
                }
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        J2 j22 = c0006b1.u1;
                        if (j22 == null) {
                            return null;
                        }
                        int i3 = c0006b1.s1;
                        if (i3 == 1) {
                            c0006b1.a1(j22, motionEvent.getX() - c0006b1.q1);
                            return Boolean.TRUE;
                        }
                        if (i3 == 2) {
                            return null;
                        }
                        float x = motionEvent.getX() - c0006b1.q1;
                        float y = motionEvent.getY() - c0006b1.r1;
                        int scaledTouchSlop = ViewConfiguration.get(c0006b1.f414a).getScaledTouchSlop();
                        float abs = Math.abs(x);
                        float abs2 = Math.abs(y);
                        float f2 = scaledTouchSlop;
                        if (abs2 > f2 && abs2 > abs) {
                            c0006b1.s1 = 2;
                            return null;
                        }
                        if (abs <= f2 * 1.5f || abs <= abs2 * 1.5f) {
                            return null;
                        }
                        boolean z = j22.f144c;
                        if ((!z || x >= 0.0f) && (z || x <= 0.0f)) {
                            c0006b1.s1 = 2;
                            return null;
                        }
                        MotionEvent obtain = MotionEvent.obtain(motionEvent);
                        obtain.setAction(3);
                        I2 i23 = c0006b1.W;
                        if (i23 == null) {
                            i.b.g("lv");
                            throw null;
                        }
                        i23.a(obtain);
                        obtain.recycle();
                        I2 i24 = c0006b1.W;
                        if (i24 == null) {
                            i.b.g("lv");
                            throw null;
                        }
                        ViewParent parent = i24.getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                        c0006b1.s1 = 1;
                        c0006b1.q1 = motionEvent.getX();
                        View view = j22.f142a;
                        View view2 = j22.f143b;
                        view2.setTranslationY(((view.getHeight() / 2.0f) + view.getTop()) - c0006b1.z(17.0f));
                        view2.setAlpha(0.0f);
                        view2.setScaleX(0.4f);
                        view2.setScaleY(0.4f);
                        c0006b1.a1(j22, 0.0f);
                        return Boolean.TRUE;
                    }
                    if (actionMasked != 3) {
                        return null;
                    }
                }
                J2 j23 = c0006b1.u1;
                K0 k02 = c0006b1.v1;
                int i4 = c0006b1.s1;
                boolean z2 = c0006b1.t1 && motionEvent.getActionMasked() == 1;
                c0006b1.s1 = 0;
                c0006b1.t1 = false;
                c0006b1.u1 = null;
                c0006b1.v1 = null;
                if (i4 != 1 || j23 == null) {
                    return null;
                }
                j23.f142a.animate().translationX(0.0f).setDuration(190L).setInterpolator(new DecelerateInterpolator()).start();
                j23.f143b.animate().alpha(0.0f).scaleX(0.4f).scaleY(0.4f).setDuration(150L).start();
                if (z2 && k02 != null) {
                    c0006b1.L0(k02);
                }
                return Boolean.TRUE;
            case 1:
                return Boolean.valueOf(i.b.a(((b.b) obj).f764a, this.f704b.f415b));
            case 2:
                String str = (String) obj;
                C0006b1 c0006b12 = this.f704b;
                EditText editText = c0006b12.h0;
                if (editText == null) {
                    i.b.g("input");
                    throw null;
                }
                editText.append(str);
                c0006b12.h1();
                return b.d.f770c;
            default:
                String str2 = (String) obj;
                C0006b1 c0006b13 = this.f704b;
                c0006b13.getClass();
                c0006b13.D1 = System.currentTimeMillis();
                C0006b1.Z0(str2);
                c0006b13.h1();
                new Thread(new G(0, str2)).start();
                C0029h0 c0029h0 = c0006b13.y1;
                if (c0029h0 != null) {
                    c0029h0.a();
                }
                return b.d.f770c;
        }
    }
}
