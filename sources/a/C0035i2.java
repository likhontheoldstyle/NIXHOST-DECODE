package a;

import android.view.View;
import android.widget.FrameLayout;
import com.nix.host.MainActivity;

/* renamed from: a.i2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0035i2 implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f534a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i.d f535b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MainActivity f536c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ G1 f537d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ s2 f538e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ View f539f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f540g;

    public /* synthetic */ C0035i2(i.d dVar, MainActivity mainActivity, G1 g1, s2 s2Var, View view, FrameLayout frameLayout, int i2) {
        this.f534a = i2;
        this.f535b = dVar;
        this.f536c = mainActivity;
        this.f537d = g1;
        this.f538e = s2Var;
        this.f539f = view;
        this.f540g = frameLayout;
    }

    @Override // h.a
    public final Object a() {
        switch (this.f534a) {
            case 0:
                C0 c0 = new C0(2);
                i.d dVar = this.f535b;
                MainActivity.b(this.f537d, this.f538e, this.f539f, this.f540g, this.f536c, c0, dVar);
                break;
            default:
                C0 c02 = new C0(2);
                i.d dVar2 = this.f535b;
                MainActivity.b(this.f537d, this.f538e, this.f539f, this.f540g, this.f536c, c02, dVar2);
                break;
        }
        return b.d.f770c;
    }
}
