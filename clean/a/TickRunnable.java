package a;

import android.app.NotificationManager;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.os.Handler;
import android.service.notification.StatusBarNotification;
import com.nix.host.HostService;
import com.nix.host.MainActivity;

public final class TickRunnable implements Runnable {

    public final int mode;

    public final ContextWrapper owner;

    public TickRunnable(ContextWrapper contextWrapper, int i2) {
        this.mode = i2;
        this.owner = contextWrapper;
    }

    @Override
    public final void run() {
        switch (this.mode) {
            case 0:
                HostService hostService = (HostService) this.owner;
                try {
                    Object systemService = hostService.getSystemService("notification");
                    i.b.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                    StatusBarNotification[] activeNotifications = ((NotificationManager) systemService).getActiveNotifications();
                    int length = activeNotifications.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            hostService.postNotification(hostService.currentPort, TerminalManager.INSTANCE.hasBusySession());
                        } else if (activeNotifications[i2].getId() != 1) {
                            i2++;
                        }
                    }
                } catch (Exception unused) {
                }
                hostService.mainHandler.postDelayed(this, 5000L);
                return;
            default:
                MainActivity mainActivity = (MainActivity) this.owner;
                boolean a2 = i.b.a(mainActivity.screen, "term");
                Handler handler = mainActivity.mainHandler;
                if (a2) {
                    if (mainActivity.isWifiConnected()) {
                        mainActivity.wifiLostAt = 0L;
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        long j2 = mainActivity.wifiLostAt;
                        if (j2 == 0) {
                            mainActivity.wifiLostAt = currentTimeMillis;
                        } else if (currentTimeMillis - j2 >= 1000) {
                            mainActivity.wifiLostAt = 0L;
                            mainActivity.termKey = "";
                            SharedPreferences sharedPreferences = AppState.prefs;
                            if (sharedPreferences == null) {
                                i.b.g("sp");
                                throw null;
                            }
                            sharedPreferences.edit().remove("lastTerm").apply();
                            mainActivity.showHome();
                            mainActivity.toast("WiFi disconnected. Terminal needs WiFi");
                            handler.postDelayed(this, 500L);
                            return;
                        }
                    }
                    if (i.b.a(mainActivity.screen, "term")) {
                        mainActivity.flushTerminalOutput();
                        mainActivity.refreshTerminalChrome();
                    }
                } else {
                    mainActivity.wifiLostAt = 0L;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (mainActivity.username.length() > 0 && currentTimeMillis2 - mainActivity.lastRefreshAt > 30000) {
                    mainActivity.lastRefreshAt = currentTimeMillis2;
                    new Thread(new UiTask(mainActivity, 7)).start();
                }
                if (i.b.a(mainActivity.screen, "home") && mainActivity.emojiToggle == null && mainActivity.isOnline() != mainActivity.online) {
                    mainActivity.showHome();
                }
                handler.postDelayed(this, i.b.a(mainActivity.screen, "term") ? 200L : 500L);
                return;
        }
    }
}
