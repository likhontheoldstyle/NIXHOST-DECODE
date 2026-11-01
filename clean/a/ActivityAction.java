package a;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import com.nix.host.MainActivity;
import java.io.File;

public final class ActivityAction implements h.a {

    public final int mode;

    public final MainActivity activity;

    public ActivityAction(MainActivity mainActivity, int i2) {
        this.mode = i2;
        this.activity = mainActivity;
    }

    @Override
    public final Object a() {
        MainActivity mainActivity = this.activity;
        switch (this.mode) {
            case 0:
                int i2 = MainActivity.R;
                mainActivity.showFiles();
                return b.d.f770c;
            case 1:
                int i3 = MainActivity.R;
                mainActivity.onBackPressed();
                return b.d.f770c;
            case 2:
                File file = mainActivity.homeDir;
                if (file == null) {
                    i.b.g("homeDir");
                    throw null;
                }
                mainActivity.currentDir = file;
                mainActivity.showFiles();
                return b.d.f770c;
            case 3:
                int i4 = MainActivity.R;
                mainActivity.showChat();
                return b.d.f770c;
            case 4:
                int i5 = MainActivity.R;
                try {
                    try {
                        mainActivity.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                    } catch (Exception unused) {
                        mainActivity.startActivity(new Intent("android.settings.SETTINGS"));
                    }
                } catch (Exception unused2) {
                }
                return b.d.f770c;
            case 5:
                int i6 = MainActivity.R;
                if (mainActivity.isOnline()) {
                    mainActivity.showHome();
                } else {
                    mainActivity.toast("Still no internet");
                }
                return b.d.f770c;
            case 6:
                int i7 = MainActivity.R;
                try {
                    return Typeface.createFromAsset(mainActivity.getAssets(), "fonts/mono.ttf");
                } catch (Exception unused3) {
                    return Typeface.MONOSPACE;
                }
            case 7:
                int i8 = MainActivity.R;
                mainActivity.runOnUiThread(new UiTask(mainActivity, 6));
                return b.d.f770c;
            case 8:
                int i9 = MainActivity.R;
                mainActivity.getClass();
                MainActivity.showDialog(mainActivity, 0, false, new PromptDialogContent(mainActivity, 1), 3);
                return b.d.f770c;
            case 9:
                MainActivity mainActivity2 = this.activity;
                ActivityAction activityAction = new ActivityAction(mainActivity2, 14);
                int i10 = MainActivity.R;
                mainActivity2.getClass();
                MainActivity.showDialog(mainActivity2, 0, false, new ConfirmDialogContent(mainActivity2, "Logout?", "Do you want to log out of NixHost?", "Logout", -429290, activityAction), 3);
                return b.d.f770c;
            case 10:
                int i11 = MainActivity.R;
                mainActivity.getClass();
                if (Build.VERSION.SDK_INT >= 30) {
                    try {
                        try {
                            mainActivity.startActivity(new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", Uri.parse("package:" + mainActivity.getPackageName())));
                        } catch (Exception unused4) {
                            mainActivity.toast("Settings > Apps > NixHost > Permissions > All files access");
                        }
                    } catch (Exception unused5) {
                        mainActivity.startActivity(new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION"));
                    }
                } else {
                    mainActivity.requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 2);
                }
                return b.d.f770c;
            case 11:
                int i12 = MainActivity.R;
                mainActivity.logout();
                return b.d.f770c;
            case 12:
                int i13 = MainActivity.R;
                new Thread(new UiTask(mainActivity, 0)).start();
                return b.d.f770c;
            case 13:
                mainActivity.termKey = "";
                SharedPreferences sharedPreferences = AppState.prefs;
                if (sharedPreferences == null) {
                    i.b.g("sp");
                    throw null;
                }
                sharedPreferences.edit().remove("lastTerm").apply();
                mainActivity.showHome();
                return b.d.f770c;
            case 14:
                int i14 = MainActivity.R;
                mainActivity.logout();
                return b.d.f770c;
            default:
                int i15 = MainActivity.R;
                try {
                    try {
                        mainActivity.startActivity(new Intent("android.settings.APP_NOTIFICATION_SETTINGS").putExtra("android.provider.extra.APP_PACKAGE", mainActivity.getPackageName()));
                    } catch (Exception unused6) {
                        mainActivity.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + mainActivity.getPackageName())));
                    }
                } catch (Exception unused7) {
                }
                return b.d.f770c;
        }
    }
}
