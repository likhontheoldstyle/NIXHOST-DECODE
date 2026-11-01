package com.nix.host;

import a.ApiClient;
import a.AppState;
import a.ChatNotifier;
import a.FileFilters;
import a.HttpConnectionHandler;
import a.HttpServer;
import a.TaskRunnable;
import a.TerminalManager;
import a.TickRunnable;
import a.Workspace;
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
import java.io.File;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public final class HostService extends Service {

    public static volatile HttpServer server;

    public PowerManager.WakeLock wakeLock;

    public WifiManager.WifiLock wifiLock;

    public int currentPort;

    public final Handler mainHandler = new Handler(Looper.getMainLooper());

    public final TickRunnable tick = new TickRunnable(this, 0);

    public final void postNotification(int i2, boolean z) {
        String str;
        Object systemService = getSystemService("notification");
        i.b.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
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
        this.currentPort = i2;
        if (Build.VERSION.SDK_INT >= 29) {
            startForeground(1, build, 1073741824);
        } else {
            startForeground(1, build);
        }
    }

    public final void acquireWifiLock() {
        if (this.wifiLock != null) {
            return;
        }
        try {
            Object systemService = getApplicationContext().getSystemService("wifi");
            i.b.c(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            WifiManager.WifiLock createWifiLock = ((WifiManager) systemService).createWifiLock(3, "nixhost:wifi");
            createWifiLock.acquire();
            this.wifiLock = createWifiLock;
        } catch (Exception unused) {
        }
    }

    public final void stopServer() {
        try {
            HttpServer httpServer = server;
            if (httpServer != null) {
                httpServer.running = false;
                try {
                    ServerSocket serverSocket = httpServer.serverSocket;
                    if (serverSocket != null) {
                        serverSocket.close();
                    }
                } catch (Exception unused) {
                }
                httpServer.executor.shutdownNow();
            }
        } catch (Exception unused2) {
        }
        server = null;
        try {
            PowerManager.WakeLock wakeLock = this.wakeLock;
            if (wakeLock != null && wakeLock.isHeld()) {
                wakeLock.release();
            }
        } catch (Exception unused3) {
        }
        this.wakeLock = null;
        try {
            WifiManager.WifiLock wifiLock = this.wifiLock;
            if (wifiLock != null && wifiLock.isHeld()) {
                wifiLock.release();
            }
        } catch (Exception unused4) {
        }
        this.wifiLock = null;
    }

    @Override
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public final void onCreate() {
        super.onCreate();
        this.mainHandler.postDelayed(this.tick, 5000L);
    }

    @Override
    public final void onDestroy() {
        ChatNotifier.INSTANCE.stopPolling();
        this.mainHandler.removeCallbacks(this.tick);
        stopServer();
        super.onDestroy();
    }

    @Override
    public final int onStartCommand(Intent intent, int i2, int i3) {
        SharedPreferences sharedPreferences;
        File file;
        File[] listFiles;
        int i4 = 0;
        String str = "";
        if (!i.b.a(intent != null ? intent.getAction() : null, "com.nix.host.STOP")) {
            try {
                AppState.prefs = getSharedPreferences("nixhost", 0);
                ApiClient.loadBaseUrl(this);
                if (AppState.appVersion.length() <= 0) {
                    try {
                        String str2 = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
                        if (str2 == null) {
                            str2 = "";
                        }
                        AppState.appVersion = str2;
                    } catch (Exception unused) {
                    }
                }
                ChatNotifier.INSTANCE.startPolling(this);
            } catch (Exception unused2) {
            }
        }
        if (i.b.a(intent != null ? intent.getAction() : null, "com.nix.host.STOP")) {
            ChatNotifier.INSTANCE.stopPolling();
            stopServer();
            stopSelf();
            return 2;
        }
        if (intent == null || i.b.a(intent.getAction(), "com.nix.host.RESTORE")) {
            SharedPreferences sharedPreferences2 = getSharedPreferences("nixhost", 0);
            AppState.prefs = sharedPreferences2;
            if (sharedPreferences2 == null) {
                i.b.g("sp");
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
            postNotification(0, false);
            TerminalManager terminalManager = TerminalManager.INSTANCE;
            try {
                TerminalManager.appContext = getApplicationContext();
                sharedPreferences = getSharedPreferences("nixhost", 0);
                AppState.prefs = sharedPreferences;
            } catch (Exception unused3) {
                sharedPreferences = null;
            }
            if (sharedPreferences == null) {
                i.b.g("sp");
                throw null;
            }
            String string2 = sharedPreferences.getString("user", "");
            if (string2 == null) {
                string2 = "";
            }
            if (string2.length() != 0) {
                SharedPreferences sharedPreferences3 = AppState.prefs;
                if (sharedPreferences3 == null) {
                    i.b.g("sp");
                    throw null;
                }
                String string3 = sharedPreferences3.getString("session", "");
                if (string3 != null) {
                    str = string3;
                }
                if (str.length() != 0 && (listFiles = (file = new File(getFilesDir(), "termlog")).listFiles(new FileFilters(2))) != null) {
                    File b2 = Workspace.homeDir(this, string2);
                    int length = listFiles.length;
                    while (i4 < length) {
                        File file2 = new File(file, m.e.Y(listFiles[i4].getName(), ".run") + ".key");
                        if (file2.isFile()) {
                            String obj = m.e.h0(g.m.I(file2)).toString();
                            if (m.m.K(obj, string2 + "-")) {
                                terminalManager.getOrCreateSession(b2, new File(getFilesDir(), "home"), obj);
                            }
                        }
                        i4++;
                    }
                }
            }
            TerminalManager.INSTANCE.syncServiceState();
            return 1;
        }
        if (!intent.getBooleanExtra("keep", false) && !i.b.a(intent.getAction(), "com.nix.host.REPOST")) {
            AppState.prefs = getSharedPreferences("nixhost", 0);
            ApiClient.loadBaseUrl(this);
            SharedPreferences sharedPreferences4 = AppState.prefs;
            if (sharedPreferences4 == null) {
                i.b.g("sp");
                throw null;
            }
            String string4 = sharedPreferences4.getString("servePort", "8080");
            Integer C = m.l.C(string4 != null ? string4 : "8080");
            final int intValue = C != null ? C.intValue() : 8080;
            postNotification(intValue, false);
            acquireWifiLock();
            if (server == null) {
                Object systemService = getSystemService("power");
                i.b.c(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                PowerManager.WakeLock newWakeLock = ((PowerManager) systemService).newWakeLock(1, "nixhost:server");
                newWakeLock.acquire();
                this.wakeLock = newWakeLock;
                new Thread(new Runnable() {
                    @Override
                    public final void run() {
                        HostService hostService = HostService.this;
                        int i5 = intValue;
                        HttpServer httpServer = HostService.server;
                        try {
                            String path = hostService.getFilesDir().getPath();
                            SharedPreferences sharedPreferences5 = AppState.prefs;
                            if (sharedPreferences5 == null) {
                                i.b.g("sp");
                                throw null;
                            }
                            String string5 = sharedPreferences5.getString("serveDir", path);
                            if (string5 != null) {
                                path = string5;
                            }
                            HttpServer httpServer2 = new HttpServer(new File(path), i5);
                            ServerSocket serverSocket = new ServerSocket();
                            serverSocket.setReuseAddress(true);
                            serverSocket.bind(new InetSocketAddress(i5));
                            httpServer2.serverSocket = serverSocket;
                            httpServer2.running = true;
                            new Thread(new HttpConnectionHandler(httpServer2, serverSocket, 8)).start();
                            HostService.server = httpServer2;
                            new Thread(new TaskRunnable(6, hostService)).start();
                        } catch (Exception e2) {
                            e2.getMessage();
                            hostService.stopServer();
                            hostService.stopSelf();
                        }
                    }
                }).start();
            }
            return 1;
        }
        boolean z = intent.getBooleanExtra("busy", false) || TerminalManager.INSTANCE.hasBusySession();
        if (server != null) {
            SharedPreferences sharedPreferences5 = AppState.prefs;
            if (sharedPreferences5 == null) {
                i.b.g("sp");
                throw null;
            }
            String string5 = sharedPreferences5.getString("servePort", "8080");
            Integer SentSoundPlayer = m.l.C(string5 != null ? string5 : "8080");
            i4 = SentSoundPlayer != null ? SentSoundPlayer.intValue() : 8080;
        }
        postNotification(i4, z);
        if (z) {
            if (this.wakeLock == null) {
                Object systemService2 = getSystemService("power");
                i.b.c(systemService2, "null cannot be cast to non-null type android.os.PowerManager");
                PowerManager.WakeLock newWakeLock2 = ((PowerManager) systemService2).newWakeLock(1, "nixhost:terminal");
                newWakeLock2.acquire();
                this.wakeLock = newWakeLock2;
            }
            acquireWifiLock();
        } else if (server == null) {
            try {
                PowerManager.WakeLock wakeLock = this.wakeLock;
                if (wakeLock != null && wakeLock.isHeld()) {
                    wakeLock.release();
                }
            } catch (Exception unused4) {
            }
            this.wakeLock = null;
            try {
                WifiManager.WifiLock wifiLock = this.wifiLock;
                if (wifiLock != null && wifiLock.isHeld()) {
                    wifiLock.release();
                }
            } catch (Exception unused5) {
            }
            this.wifiLock = null;
        }
        return 1;
    }

    @Override
    public final void onTaskRemoved(Intent intent) {
        try {
            TerminalManager terminalManager = TerminalManager.INSTANCE;
            if (terminalManager.hasBusySession() || server != null) {
                startForegroundService(new Intent(this, (Class<?>) HostService.class).putExtra("keep", true).putExtra("busy", terminalManager.hasBusySession()));
            }
        } catch (Exception unused) {
        }
        super.onTaskRemoved(intent);
    }
}
