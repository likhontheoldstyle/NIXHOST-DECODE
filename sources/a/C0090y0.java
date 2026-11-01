package a;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.PowerManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nix.host.MainActivity;

/* renamed from: a.y0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0090y0 implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f716a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f717b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f718c;

    public /* synthetic */ C0090y0(Object obj, Object obj2, int i2) {
        this.f716a = i2;
        this.f717b = obj;
        this.f718c = obj2;
    }

    @Override // h.a
    public final Object a() {
        String str;
        Object obj = this.f718c;
        Object obj2 = this.f717b;
        switch (this.f716a) {
            case 0:
                EditText editText = ((C0006b1) obj2).h0;
                if (editText != null) {
                    editText.setText((String) obj);
                    return b.d.f770c;
                }
                i.b.g("input");
                throw null;
            case 1:
                int i2 = MainActivity.R;
                ((Dialog) obj2).dismiss();
                MainActivity mainActivity = (MainActivity) obj;
                Object systemService = mainActivity.getSystemService("power");
                i.b.c(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                if (((PowerManager) systemService).isIgnoringBatteryOptimizations(mainActivity.getPackageName())) {
                    SharedPreferences sharedPreferences = AbstractC0008c.f440c;
                    if (sharedPreferences == null) {
                        i.b.g("sp");
                        throw null;
                    }
                    sharedPreferences.edit().putString("battery", "1").apply();
                    mainActivity.T("Already on. It stays on until you turn it off in phone settings.");
                } else {
                    try {
                        mainActivity.startActivity(new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", Uri.parse("package:" + mainActivity.getPackageName())));
                    } catch (Exception unused) {
                        mainActivity.startActivity(new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS"));
                    }
                }
                return b.d.f770c;
            case 2:
                int i3 = MainActivity.R;
                ((i.e) obj2).f847a = 0;
                ((LinearLayout) obj).setVisibility(8);
                return b.d.f770c;
            case 3:
                int i4 = MainActivity.R;
                CharSequence text = ((TextView) obj2).getText();
                if (text == null || (str = text.toString()) == null) {
                    str = "";
                }
                MainActivity mainActivity2 = (MainActivity) obj;
                if (m.e.R(str)) {
                    mainActivity2.T("Nothing to copy");
                } else {
                    Object systemService2 = mainActivity2.getSystemService("clipboard");
                    i.b.c(systemService2, "null cannot be cast to non-null type android.content.ClipboardManager");
                    ((ClipboardManager) systemService2).setPrimaryClip(ClipData.newPlainText("terminal", str));
                    mainActivity2.T("Copied");
                }
                return b.d.f770c;
            case 4:
                int i5 = MainActivity.R;
                EditText editText2 = (EditText) obj2;
                editText2.setText("cd ");
                editText2.setSelection(editText2.getText().length());
                MainActivity.A(editText2, (MainActivity) obj);
                return b.d.f770c;
            default:
                int i6 = MainActivity.R;
                ((MainActivity) obj2).j();
                ((h.a) obj).a();
                return b.d.f770c;
        }
    }
}
