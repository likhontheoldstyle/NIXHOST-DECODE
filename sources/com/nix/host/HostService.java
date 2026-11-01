package com.nix.host;

import a.AbstractC0008c;
import a.B2;
import a.C0004b;
import a.C0018e1;
import a.F1;
import a.G2;
import a.L2;
import a.t2;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import com.nix.host.HostService;
import g.m;
import i.b;
import java.io.File;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import m.e;
import m.l;

/* loaded from: classes.dex */
public final class HostService extends Service {

    /* renamed from: f, reason: collision with root package name */
    public static volatile G2 f775f;

    /* renamed from: a, reason: collision with root package name */
    public PowerManager.WakeLock f776a;

    /* renamed from: b, reason: collision with root package name */
    public WifiManager.WifiLock f777b;

    /* renamed from: c, reason: collision with root package name */
    public int f778c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f779d = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name */
    public final F1 f780e = new F1(this, 0);

    public final void a(int i2, boolean z) {
        String str;
        Object systemService = getSystemService("notification");
        b.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        try {
            notificationManager.deleteNotificationChannel("host");
        } catch (Exception unused) {
        }
        try {
            notificationManager.deleteNotificationChannel("host2");
        } catch (Exception unused2) {
        }
        NotificationChannel notificationChannel = new NotificationChannel("host3", "NixHost", 3);
        notificationChannel.setShowBadge(false);
        notificationManager.createNotificationChannel(notificationChannel);
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) MainActivity.class), 67108864);
        Notification.Builder contentTitle = new Notification.Builder(this, "host3").setContentTitle("NixHost - Best Fr Fr");
        if (z) {
            str = "NixHost server is running";
        } else if (i2 != 0) {
            str = "Serving your project on port " + i2;
        } else {
            str = "NixHost is active";
        }
        Notification build = contentTitle.setContentText(str).setSmallIcon(R.drawable.ic_stat_term).setContentIntent(activity).setDeleteIntent(PendingIntent.getService(this, 2, new Intent(this, (Class<?>) HostService.class).setAction("com.nix.host.REPOST"), 67108864)).setShowWhen(true).setWhen(System.currentTimeMillis()).setOngoing(true).setOnlyAlertOnce(true).setCategory("service").build();
        build.flags |= 98;
        this.f778c = i2;
        if (Build.VERSION.SDK_INT >= 29) {
            startForeground(1, build, 1073741824);
        } else {
            startForeground(1, build);
        }
    }

    public final void b() {
        if (this.f777b != null) {
            return;
        }
        try {
            Object systemService = getApplicationContext().getSystemService("wifi");
            b.c(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            WifiManager.WifiLock createWifiLock = ((WifiManager) systemService).createWifiLock(3, "nixhost:wifi");
            createWifiLock.acquire();
            this.f777b = createWifiLock;
        } catch (Exception unused) {
        }
    }

    public final void c() {
        try {
            G2 g2 = f775f;
            if (g2 != null) {
                g2.f114d = false;
                try {
                    ServerSocket serverSocket = g2.f112b;
                    if (serverSocket != null) {
                        serverSocket.close();
                    }
                } catch (Exception unused) {
                }
                g2.f113c.shutdownNow();
            }
        } catch (Exception unused2) {
        }
        f775f = null;
        try {
            PowerManager.WakeLock wakeLock = this.f776a;
            if (wakeLock != null && wakeLock.isHeld()) {
                wakeLock.release();
            }
        } catch (Exception unused3) {
        }
        this.f776a = null;
        try {
            WifiManager.WifiLock wifiLock = this.f777b;
            if (wifiLock != null && wifiLock.isHeld()) {
                wifiLock.release();
            }
        } catch (Exception unused4) {
        }
        this.f777b = null;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.f779d.postDelayed(this.f780e, 5000L);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        C0018e1.f459a.i();
        this.f779d.removeCallbacks(this.f780e);
        c();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        SharedPreferences sharedPreferences;
        File file;
        File[] listFiles;
        int i4 = 0;
        String str = "";
        if (!b.a(intent != null ? intent.getAction() : null, "com.nix.host.STOP")) {
            try {
                AbstractC0008c.f440c = getSharedPreferences("nixhost", 0);
                C0004b.h(this);
                if (AbstractC0008c.f439b.length() <= 0) {
                    try {
                        String str2 = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
                        if (str2 == null) {
                            str2 = "";
                        }
                        AbstractC0008c.f439b = str2;
                    } catch (Exception unused) {
                    }
                }
                C0018e1.f459a.h(this);
            } catch (Exception unused2) {
            }
        }
        if (b.a(intent != null ? intent.getAction() : null, "com.nix.host.STOP")) {
            C0018e1.f459a.i();
            c();
            stopSelf();
            return 2;
        }
        if (intent == null || b.a(intent.getAction(), "com.nix.host.RESTORE")) {
            SharedPreferences sharedPreferences2 = getSharedPreferences("nixhost", 0);
            AbstractC0008c.f440c = sharedPreferences2;
            if (sharedPreferences2 == null) {
                b.g("sp");
                throw null;
            }
            String string = sharedPreferences2.getString("user", "");
            if (string == null) {
                string = "";
            }
            if (string.length() == 0) {
                stopSelf();
                return 2;
            }
            a(0, false);
            L2 l2 = L2.f198a;
            try {
                L2.f200c = getApplicationContext();
                sharedPreferences = getSharedPreferences("nixhost", 0);
                AbstractC0008c.f440c = sharedPreferences;
            } catch (Exception unused3) {
            }
            if (sharedPreferences == null) {
                b.g("sp");
                throw null;
            }
            String string2 = sharedPreferences.getString("user", "");
            if (string2 == null) {
                string2 = "";
            }
            if (string2.length() != 0) {
                SharedPreferences sharedPreferences3 = AbstractC0008c.f440c;
                if (sharedPreferences3 == null) {
                    b.g("sp");
                    throw null;
                }
                String string3 = sharedPreferences3.getString("session", "");
                if (string3 != null) {
                    str = string3;
                }
                if (str.length() != 0 && (listFiles = (file = new File(getFilesDir(), "termlog")).listFiles(new t2(2))) != null) {
                    File b2 = B2.b(this, string2);
                    int length = listFiles.length;
                    while (i4 < length) {
                        File file2 = new File(file, e.Y(listFiles[i4].getName(), ".run") + ".key");
                        if (file2.isFile()) {
                            String obj = e.h0(m.I(file2)).toString();
                            if (m.m.K(obj, string2 + "-")) {
                                l2.d(b2, new File(getFilesDir(), "home"), obj);
                            }
                        }
                        i4++;
                    }
                }
            }
            L2.f198a.c();
            return 1;
        }
        if (!intent.getBooleanExtra("keep", false) && !b.a(intent.getAction(), "com.nix.host.REPOST")) {
            AbstractC0008c.f440c = getSharedPreferences("nixhost", 0);
            C0004b.h(this);
            SharedPreferences sharedPreferences4 = AbstractC0008c.f440c;
            if (sharedPreferences4 == null) {
                b.g("sp");
                throw null;
            }
            String string4 = sharedPreferences4.getString("servePort", "8080");
            Integer C = l.C(string4 != null ? string4 : "8080");
            final int intValue = C != null ? C.intValue() : 8080;
            a(intValue, false);
            b();
            if (f775f == null) {
                Object systemService = getSystemService("power");
                b.c(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                PowerManager.WakeLock newWakeLock = ((PowerManager) systemService).newWakeLock(1, "nixhost:server");
                newWakeLock.acquire();
                this.f776a = newWakeLock;
                new Thread(new Runnable() { // from class: a.E1
                    @Override // java.lang.Runnable
                    public final void run() {
                        HostService hostService = HostService.this;
                        int i5 = intValue;
                        G2 g2 = HostService.f775f;
                        try {
                            String path = hostService.getFilesDir().getPath();
                            SharedPreferences sharedPreferences5 = AbstractC0008c.f440c;
                            if (sharedPreferences5 == null) {
                                i.b.g("sp");
                                throw null;
                            }
                            String string5 = sharedPreferences5.getString("serveDir", path);
                            if (string5 != null) {
                                path = string5;
                            }
                            G2 g22 = new G2(new File(path), i5);
                            ServerSocket serverSocket = new ServerSocket();
                            serverSocket.setReuseAddress(true);
                            serverSocket.bind(new InetSocketAddress(i5));
                            g22.f112b = serverSocket;
                            g22.f114d = true;
                            new Thread(new U(g22, serverSocket, 8)).start();
                            HostService.f775f = g22;
                            new Thread(new G(6, hostService)).start();
                        } catch (Exception e2) {
                            e2.getMessage();
                            hostService.c();
                            hostService.stopSelf();
                        }
                    }
                }).start();
            }
            return 1;
        }
        boolean z = intent.getBooleanExtra("busy", false) || L2.f198a.b();
        if (f775f != null) {
            SharedPreferences sharedPreferences5 = AbstractC0008c.f440c;
            if (sharedPreferences5 == null) {
                b.g("sp");
                throw null;
            }
            String string5 = sharedPreferences5.getString("servePort", "8080");
            Integer C2 = l.C(string5 != null ? string5 : "8080");
            i4 = C2 != null ? C2.intValue() : 8080;
        }
        a(i4, z);
        if (z) {
            if (this.f776a == null) {
                Object systemService2 = getSystemService("power");
                b.c(systemService2, "null cannot be cast to non-null type android.os.PowerManager");
                PowerManager.WakeLock newWakeLock2 = ((PowerManager) systemService2).newWakeLock(1, "nixhost:terminal");
                newWakeLock2.acquire();
                this.f776a = newWakeLock2;
            }
            b();
        } else if (f775f == null) {
            try {
                PowerManager.WakeLock wakeLock = this.f776a;
                if (wakeLock != null && wakeLock.isHeld()) {
                    wakeLock.release();
                }
            } catch (Exception unused4) {
            }
            this.f776a = null;
            try {
                WifiManager.WifiLock wifiLock = this.f777b;
                if (wifiLock != null && wifiLock.isHeld()) {
                    wifiLock.release();
                }
            } catch (Exception unused5) {
            }
            this.f777b = null;
        }
        return 1;
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        try {
            L2 l2 = L2.f198a;
            if (l2.b() || f775f != null) {
                startForegroundService(new Intent(this, (Class<?>) HostService.class).putExtra("keep", true).putExtra("busy", l2.b()));
            }
        } catch (Exception unused) {
        }
        super.onTaskRemoved(intent);
    }
}
