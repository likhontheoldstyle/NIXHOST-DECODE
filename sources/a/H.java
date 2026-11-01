package a;

import android.app.Dialog;
import android.view.View;

/* loaded from: classes.dex */
public final /* synthetic */ class H implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f116a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Dialog f117b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f118c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ K0 f119d;

    public /* synthetic */ H(Dialog dialog, C0006b1 c0006b1, K0 k0, int i2) {
        this.f116a = i2;
        this.f117b = dialog;
        this.f118c = c0006b1;
        this.f119d = k0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f116a) {
            case 0:
                this.f117b.dismiss();
                this.f118c.t0(this.f119d, "");
                break;
            default:
                this.f117b.dismiss();
                K0 k0 = this.f119d;
                C0006b1 c0006b1 = this.f118c;
                c0006b1.u0(false, new C0024g(c0006b1, k0, 1));
                break;
        }
    }
}
