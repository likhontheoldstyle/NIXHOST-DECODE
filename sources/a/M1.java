package a;

import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.widget.ScrollView;
import com.nix.host.MainActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class M1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f214a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f215b;

    public /* synthetic */ M1(MainActivity mainActivity, int i2) {
        this.f214a = i2;
        this.f215b = mainActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NotificationChannel notificationChannel;
        int i2 = 1;
        int i3 = 0;
        MainActivity mainActivity = this.f215b;
        switch (this.f214a) {
            case 0:
                int i4 = MainActivity.R;
                mainActivity.runOnUiThread(new O1(1, mainActivity, AbstractC0008c.z(mainActivity.getFilesDir())));
                break;
            case 1:
                ScrollView scrollView = mainActivity.z;
                if (scrollView != null) {
                    scrollView.scrollTo(0, 1000000000);
                    break;
                }
                break;
            case 2:
                ScrollView scrollView2 = mainActivity.z;
                if (scrollView2 != null) {
                    scrollView2.scrollTo(0, 1000000000);
                    break;
                }
                break;
            case 3:
                int i5 = MainActivity.R;
                mainActivity.runOnUiThread(new O1(2, mainActivity, AbstractC0008c.z(mainActivity.getFilesDir())));
                break;
            case 4:
                if (mainActivity.f785e.length() != 0 && !i.b.a(mainActivity.f784d, "login") && !i.b.a(mainActivity.f784d, "locked")) {
                    Object systemService = mainActivity.getSystemService("notification");
                    i.b.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                    NotificationManager notificationManager = (NotificationManager) systemService;
                    if (!notificationManager.areNotificationsEnabled() || ((notificationChannel = notificationManager.getNotificationChannel("host3")) != null && notificationChannel.getImportance() == 0)) {
                        Dialog dialog = mainActivity.L;
                        if (dialog == null || !dialog.isShowing()) {
                            mainActivity.L = MainActivity.g(mainActivity, 0, false, new C0055n2(mainActivity, i3), 3);
                            break;
                        }
                    }
                }
                Dialog dialog2 = mainActivity.L;
                if (dialog2 != null) {
                    dialog2.dismiss();
                }
                mainActivity.L = null;
                break;
            case 5:
                int i6 = MainActivity.R;
                mainActivity.getClass();
                MainActivity.g(mainActivity, 0, false, new C0055n2(mainActivity, i2), 3);
                break;
            case 6:
                int i7 = MainActivity.R;
                mainActivity.u();
                break;
            default:
                mainActivity.runOnUiThread(new O1(4, mainActivity, AbstractC0008c.z(mainActivity.getFilesDir())));
                break;
        }
    }
}
