package a;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.PowerManager;
import android.widget.LinearLayout;
import com.nix.host.MainActivity;

/* renamed from: a.n2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0055n2 implements h.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f603a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f604b;

    public /* synthetic */ C0055n2(MainActivity mainActivity, int i2) {
        this.f603a = i2;
        this.f604b = mainActivity;
    }

    @Override // h.c
    public final Object a(Object obj, Object obj2) {
        int i2 = 1;
        switch (this.f603a) {
            case 0:
                LinearLayout linearLayout = (LinearLayout) obj;
                int i3 = MainActivity.R;
                ((Dialog) obj2).setCancelable(false);
                int i4 = AbstractC0008c.f442e ? -1 : -15656921;
                MainActivity mainActivity = this.f604b;
                linearLayout.addView(mainActivity.U("Turn on notifications", 22.0f, i4, true));
                linearLayout.addView(mainActivity.U("NixHost needs its notification to keep your terminal and bot running in the background. Please allow notifications for NixHost.", 16.0f, AbstractC0008c.f442e ? -8618878 : -9735552, false), MainActivity.v(mainActivity, mainActivity.f781a, mainActivity.f782b, 8, 0, 0, 56));
                linearLayout.addView(mainActivity.m("Open settings", -429290, -1, false, new K1(mainActivity, 15)), MainActivity.v(mainActivity, mainActivity.f781a, mainActivity.n(48), 22, 0, 0, 56));
                return b.d.f770c;
            default:
                LinearLayout linearLayout2 = (LinearLayout) obj;
                Dialog dialog = (Dialog) obj2;
                int i5 = MainActivity.R;
                MainActivity mainActivity2 = this.f604b;
                Object systemService = mainActivity2.getSystemService("power");
                i.b.c(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                if (((PowerManager) systemService).isIgnoringBatteryOptimizations(mainActivity2.getPackageName())) {
                    SharedPreferences sharedPreferences = AbstractC0008c.f440c;
                    if (sharedPreferences == null) {
                        i.b.g("sp");
                        throw null;
                    }
                    sharedPreferences.edit().putString("battery", "1").apply();
                    linearLayout2.addView(mainActivity2.U("Background run is ON", 22.0f, AbstractC0008c.f442e ? -1 : -15656921, true));
                    linearLayout2.addView(mainActivity2.U("NixHost keeps running in the background and your terminal commands and servers are not stopped. You do not need to turn this on again. Only switching the phone off (or turning it off in phone settings) stops them.", 16.0f, AbstractC0008c.f442e ? -8618878 : -9735552, false), MainActivity.v(mainActivity2, mainActivity2.f781a, mainActivity2.f782b, 10, 0, 0, 56));
                    linearLayout2.addView(mainActivity2.m("OK", -429290, -1, false, new C0060p(dialog, 5)), MainActivity.v(mainActivity2, mainActivity2.f781a, mainActivity2.n(48), 22, 0, 0, 56));
                } else {
                    linearLayout2.addView(mainActivity2.U("Permission allowed", 22.0f, AbstractC0008c.f442e ? -1 : -15656921, true));
                    linearLayout2.addView(mainActivity2.U("Allow NixHost to always run in the background so terminal commands and servers never stop. Turn it on once, it stays on.\n\nIt may use more battery.", 16.0f, AbstractC0008c.f442e ? -8618878 : -9735552, false), MainActivity.v(mainActivity2, mainActivity2.f781a, mainActivity2.f782b, 10, 0, 0, 56));
                    linearLayout2.addView(mainActivity2.f(mainActivity2.m("Deny", 0, AbstractC0008c.f442e ? -1 : -15656921, true, new C0060p(dialog, 6)), mainActivity2.m("Allow", -429290, -1, false, new C0090y0(dialog, mainActivity2, i2))), MainActivity.v(mainActivity2, mainActivity2.f781a, mainActivity2.f782b, 22, 0, 0, 56));
                }
                return b.d.f770c;
        }
    }
}
