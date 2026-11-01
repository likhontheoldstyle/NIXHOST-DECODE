package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.FrameLayout;

/* renamed from: a.r2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0070r2 extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f641a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s2 f642b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f643c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h.a f644d;

    public C0070r2(FrameLayout frameLayout, s2 s2Var, View view, h.a aVar) {
        this.f641a = frameLayout;
        this.f642b = s2Var;
        this.f643c = view;
        this.f644d = aVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        s2 s2Var = this.f642b;
        FrameLayout frameLayout = this.f641a;
        frameLayout.removeView(s2Var);
        frameLayout.removeView(this.f643c);
        this.f644d.a();
    }
}
