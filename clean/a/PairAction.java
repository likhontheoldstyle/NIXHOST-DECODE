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

public final class PairAction implements h.a {

    public final int mode;

    public final Object first;

    public final Object second;

    public PairAction(Object obj, Object obj2, int i2) {
        this.mode = i2;
        this.first = obj;
        this.second = obj2;
    }

    @Override
    public final Object a() {
        String str;
        Object obj = this.second;
        Object obj2 = this.first;
        switch (this.mode) {
            case 0:
                EditText editText = ((ChatScreen) obj2).messageInput;
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
                    SharedPreferences sharedPreferences = AppState.prefs;
                    if (sharedPreferences == null) {
                        i.b.g("sp");
                        throw null;
                    }
                    sharedPreferences.edit().putString("battery", "1").apply();
                    mainActivity.toast("Already on. It stays on until you turn it off in phone settings.");
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
                    mainActivity2.toast("Nothing to copy");
                } else {
                    Object systemService2 = mainActivity2.getSystemService("clipboard");
                    i.b.c(systemService2, "null cannot be cast to non-null type android.content.ClipboardManager");
                    ((ClipboardManager) systemService2).setPrimaryClip(ClipData.newPlainText("terminal", str));
                    mainActivity2.toast("Copied");
                }
                return b.d.f770c;
            case 4:
                int i5 = MainActivity.R;
                EditText editText2 = (EditText) obj2;
                editText2.setText("cd ");
                editText2.setSelection(editText2.getText().length());
                MainActivity.focusAndShowKeyboard(editText2, (MainActivity) obj);
                return b.d.f770c;
            default:
                int i6 = MainActivity.R;
                ((MainActivity) obj2).hideTermKeys();
                ((h.a) obj).a();
                return b.d.f770c;
        }
    }
}
