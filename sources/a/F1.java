package a;

import android.app.NotificationManager;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.os.Handler;
import android.service.notification.StatusBarNotification;
import com.nix.host.HostService;
import com.nix.host.MainActivity;

/* loaded from: classes.dex */
public final class F1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f96a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ContextWrapper f97b;

    public /* synthetic */ F1(ContextWrapper contextWrapper, int i2) {
        this.f96a = i2;
        this.f97b = contextWrapper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f96a) {
            case 0:
                HostService hostService = (HostService) this.f97b;
                try {
                    Object systemService = hostService.getSystemService("notification");
                    i.b.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                    StatusBarNotification[] activeNotifications = ((NotificationManager) systemService).getActiveNotifications();
                    int length = activeNotifications.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            hostService.a(hostService.f778c, L2.f198a.b());
                        } else if (activeNotifications[i2].getId() != 1) {
                            i2++;
                        }
                    }
                } catch (Exception unused) {
                }
                hostService.f779d.postDelayed(this, 5000L);
                return;
            default:
                MainActivity mainActivity = (MainActivity) this.f97b;
                boolean a2 = i.b.a(mainActivity.f784d, "term");
                Handler handler = mainActivity.f783c;
                if (a2) {
                    if (mainActivity.X()) {
                        mainActivity.P = 0L;
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        long j2 = mainActivity.P;
                        if (j2 == 0) {
                            mainActivity.P = currentTimeMillis;
                        } else if (currentTimeMillis - j2 >= 1000) {
                            mainActivity.P = 0L;
                            mainActivity.p = "";
                            SharedPreferences sharedPreferences = AbstractC0008c.f440c;
                            if (sharedPreferences == null) {
                                i.b.g("sp");
                                throw null;
                            }
                            sharedPreferences.edit().remove("lastTerm").apply();
                            mainActivity.N();
                            mainActivity.T("WiFi disconnected. Terminal needs WiFi");
                            handler.postDelayed(this, 500L);
                            return;
                        }
                    }
                    if (i.b.a(mainActivity.f784d, "term")) {
                        mainActivity.C();
                        mainActivity.F();
                    }
                } else {
                    mainActivity.P = 0L;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (mainActivity.f785e.length() > 0 && currentTimeMillis2 - mainActivity.f786f > 30000) {
                    mainActivity.f786f = currentTimeMillis2;
                    new Thread(new M1(mainActivity, 7)).start();
                }
                if (i.b.a(mainActivity.f784d, "home") && mainActivity.f791k == null && mainActivity.x() != mainActivity.O) {
                    mainActivity.N();
                }
                handler.postDelayed(this, i.b.a(mainActivity.f784d, "term") ? 200L : 500L);
                return;
        }
    }
}
