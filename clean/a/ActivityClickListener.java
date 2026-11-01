package a;

import android.content.SharedPreferences;
import android.view.View;
import com.nix.host.MainActivity;

public final class ActivityClickListener implements View.OnClickListener {

    public final int mode;

    public final MainActivity activity;

    public ActivityClickListener(MainActivity mainActivity, int i2) {
        this.mode = i2;
        this.activity = mainActivity;
    }

    @Override
    public final void onClick(View view) {
        MainActivity mainActivity = this.activity;
        switch (this.mode) {
            case 0:
                int i2 = MainActivity.R;
                boolean z = !AppState.darkTheme;
                AppState.darkTheme = z;
                String str = z ? "1" : "0";
                SharedPreferences sharedPreferences = AppState.prefs;
                if (sharedPreferences == null) {
                    i.b.g("sp");
                    throw null;
                }
                sharedPreferences.edit().putString("dark", str).apply();
                if (i.b.a(mainActivity.screen, "files")) {
                    mainActivity.showFiles();
                    return;
                }
                mainActivity.showHome();
                return;
            case 1:
                int i3 = MainActivity.R;
                mainActivity.hidePopupMenu();
                return;
            default:
                int i4 = MainActivity.R;
                mainActivity.hideTermKeys();
                return;
        }
    }
}
