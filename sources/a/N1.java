package a;

import android.app.Dialog;
import android.widget.LinearLayout;
import com.nix.host.MainActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class N1 implements h.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainActivity f220a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f221b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f222c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f223d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f224e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ h.a f225f;

    public /* synthetic */ N1(MainActivity mainActivity, String str, String str2, String str3, int i2, h.a aVar) {
        this.f220a = mainActivity;
        this.f221b = str;
        this.f222c = str2;
        this.f223d = str3;
        this.f224e = i2;
        this.f225f = aVar;
    }

    @Override // h.c
    public final Object a(Object obj, Object obj2) {
        LinearLayout linearLayout = (LinearLayout) obj;
        Dialog dialog = (Dialog) obj2;
        int i2 = MainActivity.R;
        int i3 = AbstractC0008c.f442e ? -1 : -15656921;
        String str = this.f221b;
        MainActivity mainActivity = this.f220a;
        linearLayout.addView(mainActivity.U(str, 22.0f, i3, true));
        linearLayout.addView(mainActivity.U(this.f222c, 16.0f, AbstractC0008c.f442e ? -8618878 : -9735552, false), MainActivity.v(mainActivity, mainActivity.f781a, mainActivity.f782b, 8, 0, 0, 56));
        linearLayout.addView(mainActivity.f(mainActivity.m("Cancel", 0, AbstractC0008c.f442e ? -1 : -15656921, true, new C0060p(dialog, 7)), mainActivity.m(this.f223d, this.f224e, -1, false, new T1(dialog, this.f225f, 0))), MainActivity.v(mainActivity, mainActivity.f781a, mainActivity.f782b, 22, 0, 0, 56));
        return b.d.f770c;
    }
}
