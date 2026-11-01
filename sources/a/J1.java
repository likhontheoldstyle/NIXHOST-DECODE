package a;

import android.animation.ValueAnimator;
import android.view.View;
import com.nix.host.MainActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class J1 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f138a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s2 f139b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f140c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f141d;

    public /* synthetic */ J1(s2 s2Var, float f2, View view) {
        this.f139b = s2Var;
        this.f140c = f2;
        this.f141d = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view = this.f141d;
        s2 s2Var = this.f139b;
        float f2 = this.f140c;
        switch (this.f138a) {
            case 0:
                int i2 = MainActivity.R;
                Object animatedValue = valueAnimator.getAnimatedValue();
                i.b.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                float floatValue = ((Float) animatedValue).floatValue();
                s2Var.setTranslationY(floatValue);
                view.setAlpha(AbstractC0008c.b(1.0f - (floatValue / f2), 0.0f, 1.0f));
                break;
            default:
                int i3 = MainActivity.R;
                Object animatedValue2 = valueAnimator.getAnimatedValue();
                i.b.c(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
                float floatValue2 = ((Float) animatedValue2).floatValue();
                s2Var.setTranslationY((1.0f - floatValue2) * f2);
                view.setAlpha(floatValue2);
                break;
        }
    }

    public /* synthetic */ J1(s2 s2Var, View view, float f2) {
        this.f139b = s2Var;
        this.f141d = view;
        this.f140c = f2;
    }
}
