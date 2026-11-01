package a;

import android.widget.LinearLayout;

/* renamed from: a.h0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0029h0 implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f518a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f519b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LinearLayout f520c;

    public /* synthetic */ C0029h0(C0006b1 c0006b1, LinearLayout linearLayout) {
        this.f519b = c0006b1;
        this.f520c = linearLayout;
    }

    @Override // h.a
    public final Object a() {
        switch (this.f518a) {
            case 0:
                C0006b1.g0(this.f519b, this.f520c);
                break;
            default:
                C0006b1 c0006b1 = this.f519b;
                c0006b1.u0(true, new C0028h(c0006b1, this.f520c, 0));
                break;
        }
        return b.d.f770c;
    }

    public /* synthetic */ C0029h0(LinearLayout linearLayout, C0006b1 c0006b1) {
        this.f520c = linearLayout;
        this.f519b = c0006b1;
    }
}
