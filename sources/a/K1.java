package a;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import com.nix.host.MainActivity;
import java.io.File;

/* loaded from: classes.dex */
public final /* synthetic */ class K1 implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f165a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f166b;

    public /* synthetic */ K1(MainActivity mainActivity, int i2) {
        this.f165a = i2;
        this.f166b = mainActivity;
    }

    @Override // h.a
    public final Object a() {
        MainActivity mainActivity = this.f166b;
        switch (this.f165a) {
            case 0:
                int i2 = MainActivity.R;
                mainActivity.L();
                return b.d.f770c;
            case 1:
                int i3 = MainActivity.R;
                mainActivity.onBackPressed();
                return b.d.f770c;
            case 2:
                File file = mainActivity.f795o;
                if (file == null) {
                    i.b.g("homeDir");
                    throw null;
                }
                mainActivity.f794n = file;
                mainActivity.L();
                return b.d.f770c;
            case 3:
                int i4 = MainActivity.R;
                mainActivity.M();
                return b.d.f770c;
            case 4:
                int i5 = MainActivity.R;
                try {
                    try {
                        mainActivity.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    mainActivity.startActivity(new Intent("android.settings.SETTINGS"));
                }
                return b.d.f770c;
            case 5:
                int i6 = MainActivity.R;
                if (mainActivity.x()) {
                    mainActivity.N();
                } else {
                    mainActivity.T("Still no internet");
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
                mainActivity.runOnUiThread(new M1(mainActivity, 6));
                return b.d.f770c;
            case 8:
                int i9 = MainActivity.R;
                mainActivity.getClass();
                MainActivity.g(mainActivity, 0, false, new C0055n2(mainActivity, 1), 3);
                return b.d.f770c;
            case 9:
                MainActivity mainActivity2 = this.f166b;
                K1 k1 = new K1(mainActivity2, 14);
                int i10 = MainActivity.R;
                mainActivity2.getClass();
                MainActivity.g(mainActivity2, 0, false, new N1(mainActivity2, "Logout?", "Do you want to log out of NixHost?", "Logout", -429290, k1), 3);
                return b.d.f770c;
            case 10:
                int i11 = MainActivity.R;
                mainActivity.getClass();
                if (Build.VERSION.SDK_INT >= 30) {
                    try {
                        try {
                            mainActivity.startActivity(new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", Uri.parse("package:" + mainActivity.getPackageName())));
                        } catch (Exception unused4) {
                            mainActivity.T("Settings > Apps > NixHost > Permissions > All files access");
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
                mainActivity.u();
                return b.d.f770c;
            case 12:
                int i13 = MainActivity.R;
                new Thread(new M1(mainActivity, 0)).start();
                return b.d.f770c;
            case 13:
                mainActivity.p = "";
                SharedPreferences sharedPreferences = AbstractC0008c.f440c;
                if (sharedPreferences == null) {
                    i.b.g("sp");
                    throw null;
                }
                sharedPreferences.edit().remove("lastTerm").apply();
                mainActivity.N();
                return b.d.f770c;
            case 14:
                int i14 = MainActivity.R;
                mainActivity.u();
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
