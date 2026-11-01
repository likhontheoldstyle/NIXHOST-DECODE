package a;

import android.view.View;
import android.widget.LinearLayout;
import com.nix.host.MainActivity;

/* renamed from: a.g2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0027g2 implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f512a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinearLayout f513b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MainActivity f514c;

    public /* synthetic */ C0027g2(LinearLayout linearLayout, MainActivity mainActivity, int i2) {
        this.f512a = i2;
        this.f513b = linearLayout;
        this.f514c = mainActivity;
    }

    @Override // h.a
    public final Object a() {
        MainActivity mainActivity = this.f514c;
        LinearLayout linearLayout = this.f513b;
        switch (this.f512a) {
            case 0:
                int i2 = MainActivity.R;
                if (linearLayout.getVisibility() == 0) {
                    mainActivity.i();
                } else {
                    LinearLayout linearLayout2 = mainActivity.f798t;
                    if (linearLayout2 != null) {
                        View view = mainActivity.f799u;
                        if (view != null) {
                            view.setVisibility(0);
                        }
                        linearLayout2.setVisibility(0);
                        linearLayout2.setAlpha(0.0f);
                        linearLayout2.animate().alpha(1.0f).setDuration(120L).start();
                    }
                }
                break;
            default:
                int i3 = MainActivity.R;
                if (linearLayout.getVisibility() == 0) {
                    mainActivity.j();
                } else {
                    LinearLayout linearLayout3 = mainActivity.G;
                    if (linearLayout3 != null) {
                        View view2 = mainActivity.H;
                        if (view2 != null) {
                            view2.setVisibility(0);
                        }
                        linearLayout3.setVisibility(0);
                        linearLayout3.setAlpha(0.0f);
                        linearLayout3.setTranslationY(-mainActivity.n(24));
                        linearLayout3.animate().alpha(1.0f).translationY(0.0f).setDuration(160L).start();
                    }
                }
                break;
        }
        return b.d.f770c;
    }
}
