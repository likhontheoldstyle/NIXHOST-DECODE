package a;

import android.app.Dialog;
import com.nix.host.MainActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class T1 implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f320a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Dialog f321b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h.a f322c;

    public /* synthetic */ T1(Dialog dialog, h.a aVar, int i2) {
        this.f320a = i2;
        this.f321b = dialog;
        this.f322c = aVar;
    }

    @Override // h.a
    public final Object a() {
        h.a aVar = this.f322c;
        Dialog dialog = this.f321b;
        switch (this.f320a) {
            case 0:
                int i2 = MainActivity.R;
                dialog.dismiss();
                aVar.a();
                break;
            default:
                int i3 = MainActivity.R;
                dialog.dismiss();
                aVar.a();
                break;
        }
        return b.d.f770c;
    }
}
