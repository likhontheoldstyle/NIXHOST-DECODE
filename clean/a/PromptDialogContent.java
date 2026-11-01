package a;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.PowerManager;
import android.widget.LinearLayout;
import com.nix.host.MainActivity;

public final class PromptDialogContent implements h.c {

    public final int mode;

    public final MainActivity activity;

    public PromptDialogContent(MainActivity mainActivity, int i2) {
        this.mode = i2;
        this.activity = mainActivity;
    }

    @Override
    public final Object a(Object obj, Object obj2) {
        int i2 = 1;
        switch (this.mode) {
            case 0:
                LinearLayout linearLayout = (LinearLayout) obj;
                int i3 = MainActivity.R;
                ((Dialog) obj2).setCancelable(false);
                int i4 = AppState.darkTheme ? -1 : -15656921;
                MainActivity mainActivity = this.activity;
                linearLayout.addView(mainActivity.makeText("Turn on notifications", 22.0f, i4, true));
                linearLayout.addView(mainActivity.makeText("NixHost needs its notification to keep your terminal and bot running in the background. Please allow notifications for NixHost.", 16.0f, AppState.darkTheme ? -8618878 : -9735552, false), MainActivity.layoutParams(mainActivity, mainActivity.matchParent, mainActivity.wrapContent, 8, 0, 0, 56));
                linearLayout.addView(mainActivity.makeButton("Open settings", -429290, -1, false, new ActivityAction(mainActivity, 15)), MainActivity.layoutParams(mainActivity, mainActivity.matchParent, mainActivity.dp(48), 22, 0, 0, 56));
                return b.d.f770c;
            default:
                LinearLayout linearLayout2 = (LinearLayout) obj;
                Dialog dialog = (Dialog) obj2;
                int i5 = MainActivity.R;
                MainActivity mainActivity2 = this.activity;
                Object systemService = mainActivity2.getSystemService("power");
                i.b.c(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                if (((PowerManager) systemService).isIgnoringBatteryOptimizations(mainActivity2.getPackageName())) {
                    SharedPreferences sharedPreferences = AppState.prefs;
                    if (sharedPreferences == null) {
                        i.b.g("sp");
                        throw null;
                    }
                    sharedPreferences.edit().putString("battery", "1").apply();
                    linearLayout2.addView(mainActivity2.makeText("Background run is ON", 22.0f, AppState.darkTheme ? -1 : -15656921, true));
                    linearLayout2.addView(mainActivity2.makeText("NixHost keeps running in the background and your terminal commands and servers are not stopped. You do not need to turn this on again. Only switching the phone off (or turning it off in phone settings) stops them.", 16.0f, AppState.darkTheme ? -8618878 : -9735552, false), MainActivity.layoutParams(mainActivity2, mainActivity2.matchParent, mainActivity2.wrapContent, 10, 0, 0, 56));
                    linearLayout2.addView(mainActivity2.makeButton("OK", -429290, -1, false, new DismissAction(dialog, 5)), MainActivity.layoutParams(mainActivity2, mainActivity2.matchParent, mainActivity2.dp(48), 22, 0, 0, 56));
                } else {
                    linearLayout2.addView(mainActivity2.makeText("Permission allowed", 22.0f, AppState.darkTheme ? -1 : -15656921, true));
                    linearLayout2.addView(mainActivity2.makeText("Allow NixHost to always run in the background so terminal commands and servers never stop. Turn it on once, it stays on.\n\nIt may use more battery.", 16.0f, AppState.darkTheme ? -8618878 : -9735552, false), MainActivity.layoutParams(mainActivity2, mainActivity2.matchParent, mainActivity2.wrapContent, 10, 0, 0, 56));
                    linearLayout2.addView(mainActivity2.buttonRow(mainActivity2.makeButton("Deny", 0, AppState.darkTheme ? -1 : -15656921, true, new DismissAction(dialog, 6)), mainActivity2.makeButton("Allow", -429290, -1, false, new PairAction(dialog, mainActivity2, i2))), MainActivity.layoutParams(mainActivity2, mainActivity2.matchParent, mainActivity2.wrapContent, 22, 0, 0, 56));
                }
                return b.d.f770c;
        }
    }
}
