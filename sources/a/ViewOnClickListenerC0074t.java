package a;

import android.app.Dialog;
import android.view.View;
import android.widget.LinearLayout;

/* renamed from: a.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class ViewOnClickListenerC0074t implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f660a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f661b;

    public /* synthetic */ ViewOnClickListenerC0074t(int i2, Object obj) {
        this.f660a = i2;
        this.f661b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f660a) {
            case 0:
                ((Dialog) this.f661b).dismiss();
                return;
            case 1:
                ((Dialog) this.f661b).dismiss();
                return;
            case 2:
                ((Dialog) this.f661b).dismiss();
                return;
            default:
                LinearLayout linearLayout = ((C0006b1) this.f661b).g0;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    return;
                } else {
                    i.b.g("panel");
                    throw null;
                }
        }
    }
}
