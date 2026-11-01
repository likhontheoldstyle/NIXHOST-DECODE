package a;

import android.app.Dialog;
import android.view.View;
import android.widget.EditText;

/* loaded from: classes.dex */
public final /* synthetic */ class V implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f332a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Dialog f333b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f334c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ K0 f335d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f336e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f337f;

    public /* synthetic */ V(Dialog dialog, C0006b1 c0006b1, K0 k0, String str, String str2) {
        this.f333b = dialog;
        this.f334c = c0006b1;
        this.f335d = k0;
        this.f336e = str;
        this.f337f = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f332a) {
            case 0:
                this.f333b.dismiss();
                String str = this.f336e;
                if (i.b.a(str, (String) this.f337f)) {
                    str = "";
                }
                this.f334c.t0(this.f335d, str);
                break;
            default:
                EditText editText = (EditText) this.f337f;
                if (C0006b1.A(editText, this.f336e)) {
                    String obj = m.e.h0(editText.getText().toString()).toString();
                    this.f333b.dismiss();
                    C0006b1 c0006b1 = this.f334c;
                    c0006b1.getClass();
                    K0 k0 = this.f335d;
                    String str2 = k0.f153d;
                    int i2 = k0.f164o;
                    k0.f153d = obj;
                    k0.f164o = i2 + 1;
                    c0006b1.x0(false);
                    new Thread(new RunnableC0037j0(k0, obj, c0006b1, str2, i2)).start();
                    break;
                }
                break;
        }
    }

    public /* synthetic */ V(EditText editText, Dialog dialog, C0006b1 c0006b1, K0 k0, String str) {
        this.f337f = editText;
        this.f333b = dialog;
        this.f334c = c0006b1;
        this.f335d = k0;
        this.f336e = str;
    }
}
