package a;

import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.widget.ScrollView;
import com.nix.host.MainActivity;

public final class UiTask implements Runnable {

    public final int mode;

    public final MainActivity activity;

    public UiTask(MainActivity mainActivity, int i2) {
        this.mode = i2;
        this.activity = mainActivity;
    }

    @Override
    public final void run() {
        NotificationChannel notificationChannel;
        int i2 = 1;
        int i3 = 0;
        MainActivity mainActivity = this.activity;
        switch (this.mode) {
            case 0:
                int i4 = MainActivity.R;
                mainActivity.runOnUiThread(new ApiTask(1, mainActivity, AppState.refreshAccount(mainActivity.getFilesDir())));
                break;
            case 1:
                ScrollView scrollView = mainActivity.termScroll;
                if (scrollView != null) {
                    scrollView.scrollTo(0, 1000000000);
                    break;
                }
                break;
            case 2:
                ScrollView scrollView2 = mainActivity.termScroll;
                if (scrollView2 != null) {
                    scrollView2.scrollTo(0, 1000000000);
                    break;
                }
                break;
            case 3:
                int i5 = MainActivity.R;
                mainActivity.runOnUiThread(new ApiTask(2, mainActivity, AppState.refreshAccount(mainActivity.getFilesDir())));
                break;
            case 4:
                if (mainActivity.username.length() != 0 && !i.b.a(mainActivity.screen, "login") && !i.b.a(mainActivity.screen, "locked")) {
                    Object systemService = mainActivity.getSystemService("notification");
                    i.b.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                    NotificationManager notificationManager = (NotificationManager) systemService;
                    if (!notificationManager.areNotificationsEnabled() || ((notificationChannel = notificationManager.getNotificationChannel("host3")) != null && notificationChannel.getImportance() == 0)) {
                        Dialog dialog = mainActivity.notifDialog;
                        if (dialog == null || !dialog.isShowing()) {
                            mainActivity.notifDialog = MainActivity.showDialog(mainActivity, 0, false, new PromptDialogContent(mainActivity, i3), 3);
                            break;
                        }
                    }
                }
                Dialog dialog2 = mainActivity.notifDialog;
                if (dialog2 != null) {
                    dialog2.dismiss();
                }
                mainActivity.notifDialog = null;
                break;
            case 5:
                int i6 = MainActivity.R;
                mainActivity.getClass();
                MainActivity.showDialog(mainActivity, 0, false, new PromptDialogContent(mainActivity, i2), 3);
                break;
            case 6:
                int i7 = MainActivity.R;
                mainActivity.logout();
                break;
            default:
                mainActivity.runOnUiThread(new ApiTask(4, mainActivity, AppState.refreshAccount(mainActivity.getFilesDir())));
                break;
        }
    }
}
