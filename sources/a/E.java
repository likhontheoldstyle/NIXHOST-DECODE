package a;

import android.view.View;
import android.widget.ScrollView;
import com.nix.host.MainActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class E implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f76a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f77b;

    public /* synthetic */ E(int i2, Object obj) {
        this.f76a = i2;
        this.f77b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        Object obj = this.f77b;
        switch (this.f76a) {
            case 0:
                int i10 = i5 - i3;
                int i11 = i9 - i7;
                final C0006b1 c0006b1 = (C0006b1) obj;
                if (i11 <= 0 || i10 >= i11) {
                    I2 i22 = c0006b1.W;
                    if (i22 != null) {
                        c0006b1.V = true ^ i22.canScrollVertically(1);
                        return;
                    } else {
                        i.b.g("lv");
                        throw null;
                    }
                }
                final int i12 = i11 - i10;
                final boolean z = c0006b1.V;
                I2 i23 = c0006b1.W;
                if (i23 != null) {
                    i23.post(new Runnable() { // from class: a.n0
                        @Override // java.lang.Runnable
                        public final void run() {
                            C0006b1 c0006b12 = c0006b1;
                            if (c0006b12.U != 0) {
                                c0006b12.c();
                                return;
                            }
                            if (z) {
                                I2 i24 = c0006b12.W;
                                if (i24 != null) {
                                    i24.scrollListBy(i12);
                                } else {
                                    i.b.g("lv");
                                    throw null;
                                }
                            }
                        }
                    });
                    return;
                } else {
                    i.b.g("lv");
                    throw null;
                }
            default:
                int i13 = MainActivity.R;
                ScrollView scrollView = (ScrollView) obj;
                scrollView.post(new G(7, scrollView));
                return;
        }
    }
}
