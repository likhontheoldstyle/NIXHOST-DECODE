package a;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.service.notification.StatusBarNotification;
import com.nix.host.MainActivity;
import com.nix.host.NotifyReceiver;
import com.nix.host.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: a.e1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0018e1 {

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f460b;

    /* renamed from: c, reason: collision with root package name */
    public static Thread f461c;

    /* renamed from: h, reason: collision with root package name */
    public static long f466h;

    /* renamed from: i, reason: collision with root package name */
    public static MediaPlayer f467i;

    /* renamed from: a, reason: collision with root package name */
    public static final C0018e1 f459a = new C0018e1();

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f462d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap f463e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public static final HashMap f464f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public static final HashMap f465g = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    public static final Handler f468j = new Handler(Looper.getMainLooper());

    public static Bitmap d(C0018e1 c0018e1, String str) {
        c0018e1.getClass();
        Bitmap createBitmap = Bitmap.createBitmap(128, 128, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        i.b.d(str.toLowerCase(Locale.ROOT), "toLowerCase(...)");
        paint.setColor(Color.HSVToColor(new float[]{Math.abs(r5.hashCode()) % 360, 0.5f, 0.75f}));
        float f2 = 128;
        float f3 = f2 / 2.0f;
        canvas.drawCircle(f3, f3, f3, paint);
        paint.setColor(-1);
        paint.setTextSize(f2 * 0.5f);
        paint.setTextAlign(Paint.Align.CENTER);
        String obj = m.e.h0(str).toString();
        i.b.e(obj, "<this>");
        Character valueOf = obj.length() == 0 ? null : Character.valueOf(obj.charAt(0));
        canvas.drawText(String.valueOf(Character.toUpperCase(valueOf != null ? valueOf.charValue() : '?')), f3, f3 - ((paint.ascent() + paint.descent()) / 2.0f), paint);
        return createBitmap;
    }

    public static void j() {
        MediaPlayer mediaPlayer = f467i;
        if (mediaPlayer == null) {
            return;
        }
        f467i = null;
        try {
            mediaPlayer.stop();
        } catch (Exception unused) {
        }
        try {
            mediaPlayer.release();
        } catch (Exception unused2) {
        }
    }

    public final Bitmap a(String str) {
        String str2 = (String) f464f.get(str);
        if (str2 == null) {
            str2 = "";
        }
        int length = str2.length();
        HashMap hashMap = f463e;
        if (length == 0) {
            String str3 = (String) hashMap.get(str);
            if (str3 != null) {
                str = str3;
            }
            return d(this, str);
        }
        HashMap hashMap2 = f465g;
        Bitmap bitmap = (Bitmap) hashMap2.get(str2);
        if (bitmap != null) {
            return bitmap;
        }
        try {
            byte[] g2 = C0004b.g(str2);
            Bitmap decodeByteArray = g2 != null ? BitmapFactory.decodeByteArray(g2, 0, g2.length) : null;
            if (decodeByteArray == null) {
                String str4 = (String) hashMap.get(str);
                if (str4 == null) {
                    str4 = str;
                }
                return d(this, str4);
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, 128, 128, true);
            Bitmap createBitmap = Bitmap.createBitmap(128, 128, Bitmap.Config.ARGB_8888);
            Paint paint = new Paint(1);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(createScaledBitmap, tileMode, tileMode));
            float f2 = 128 / 2.0f;
            new Canvas(createBitmap).drawCircle(f2, f2, f2, paint);
            hashMap2.put(str2, createBitmap);
            return createBitmap;
        } catch (Throwable unused) {
            String str5 = (String) hashMap.get(str);
            if (str5 != null) {
                str = str5;
            }
            return d(this, str);
        }
    }

    public final void b(Context context) {
        try {
            Object systemService = context.getSystemService("notification");
            i.b.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            i.a a2 = i.j.a(notificationManager.getActiveNotifications());
            while (a2.hasNext()) {
                StatusBarNotification statusBarNotification = (StatusBarNotification) a2.next();
                int id = statusBarNotification.getId();
                if (2000 <= id && id < 67536) {
                    notificationManager.cancel(statusBarNotification.getId());
                }
            }
            synchronized (this) {
                f462d.clear();
            }
        } catch (Exception unused) {
        }
    }

    public final synchronized void c(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z || currentTimeMillis - f466h >= 600000) {
            C0000a b2 = C0004b.b(C0004b.f409a, "GET", "/chat/members", null, 12);
            JSONObject c2 = b2.c();
            JSONArray optJSONArray = c2 != null ? c2.optJSONArray("members") : null;
            if (b2.b() && optJSONArray != null) {
                f466h = currentTimeMillis;
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("u");
                        f463e.put(optString, optJSONObject.optString("n", optString));
                        f464f.put(optString, optJSONObject.optString("p", ""));
                    }
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x020a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(Context context) {
        JSONObject c2;
        C0018e1 c0018e1;
        boolean z;
        Object systemService;
        String optString;
        SharedPreferences sharedPreferences = AbstractC0008c.f440c;
        if (sharedPreferences == null) {
            i.b.g("sp");
            throw null;
        }
        String string = sharedPreferences.getString("user", "");
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            return;
        }
        SharedPreferences sharedPreferences2 = AbstractC0008c.f440c;
        if (sharedPreferences2 == null) {
            i.b.g("sp");
            throw null;
        }
        String string2 = sharedPreferences2.getString("session", "");
        if (string2 == null) {
            string2 = "";
        }
        if (string2.length() == 0) {
            return;
        }
        String concat = "nlast_".concat(string);
        SharedPreferences sharedPreferences3 = AbstractC0008c.f440c;
        if (sharedPreferences3 == null) {
            i.b.g("sp");
            throw null;
        }
        String string3 = sharedPreferences3.getString(concat, "");
        if (string3 == null) {
            string3 = "";
        }
        Long D = m.l.D(string3);
        C0004b c0004b = C0004b.f409a;
        if (D == null) {
            C0000a b2 = C0004b.b(c0004b, "GET", "/chat/new?since=-1", null, 12);
            if (b2.b()) {
                JSONObject c3 = b2.c();
                AbstractC0008c.t(concat, String.valueOf(c3 != null ? c3.optLong("max", 0L) : 0L));
                return;
            }
            return;
        }
        C0000a b3 = C0004b.b(c0004b, "GET", "/chat/new?since=" + D.longValue(), null, 12);
        if (b3.b() && (c2 = b3.c()) != null) {
            long optLong = c2.optLong("max", D.longValue());
            JSONArray optJSONArray = c2.optJSONArray("msgs");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return;
            }
            AbstractC0008c.t(concat, String.valueOf(optLong));
            if (!AbstractC0008c.f441d) {
                String concat2 = "muted_".concat(string);
                SharedPreferences sharedPreferences4 = AbstractC0008c.f440c;
                if (sharedPreferences4 == null) {
                    i.b.g("sp");
                    throw null;
                }
                String string4 = sharedPreferences4.getString(concat2, "");
                if (!(string4 != null ? string4 : "").equals("1")) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    HashMap hashMap = new HashMap();
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            String optString2 = optJSONObject.optString("u");
                            if (optString2.length() != 0 && !optString2.equalsIgnoreCase(string) && optJSONObject.optInt("del") != 1 && !i.b.a(optJSONObject.optString("t"), "sys")) {
                                Object obj = linkedHashMap.get(optString2);
                                if (obj == null) {
                                    obj = new ArrayList();
                                    linkedHashMap.put(optString2, obj);
                                }
                                ArrayList arrayList = (ArrayList) obj;
                                String optString3 = optJSONObject.optString("t");
                                if (optString3 != null) {
                                    switch (optString3.hashCode()) {
                                        case 3321751:
                                            if (optString3.equals("like")) {
                                                optString = "👍";
                                                break;
                                            }
                                            break;
                                        case 100313435:
                                            if (optString3.equals("image")) {
                                                optString = "📷 Photo";
                                                break;
                                            }
                                            break;
                                        case 112202875:
                                            if (optString3.equals("video")) {
                                                optString = "🎥 Video";
                                                break;
                                            }
                                            break;
                                        case 112386354:
                                            if (optString3.equals("voice")) {
                                                optString = "🎤 Voice message";
                                                break;
                                            }
                                            break;
                                    }
                                    arrayList.add(optString);
                                    hashMap.put(optString2, Long.valueOf(optJSONObject.optLong("id")));
                                }
                                optString = optJSONObject.optString("x");
                                arrayList.add(optString);
                                hashMap.put(optString2, Long.valueOf(optJSONObject.optLong("id")));
                            }
                        }
                    }
                    if (linkedHashMap.isEmpty()) {
                        return;
                    }
                    Set keySet = linkedHashMap.keySet();
                    try {
                        if (!(keySet instanceof Collection) || !keySet.isEmpty()) {
                            Iterator it = keySet.iterator();
                            while (it.hasNext()) {
                                if (f463e.get((String) it.next()) == null) {
                                    c0018e1 = this;
                                    z = true;
                                    c0018e1.c(z);
                                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                                        String str = (String) entry.getKey();
                                        ArrayList arrayList2 = (ArrayList) entry.getValue();
                                        Long l2 = (Long) hashMap.get(str);
                                        f(context, str, arrayList2, l2 != null ? l2.longValue() : optLong, false);
                                    }
                                    systemService = context.getSystemService("audio");
                                    i.b.c(systemService, "null cannot be cast to non-null type android.media.AudioManager");
                                    if (((AudioManager) systemService).getRingerMode() == 2) {
                                        return;
                                    }
                                    try {
                                        File file = new File(context.getFilesDir(), "sound-nix.mp3");
                                        if (!file.isFile() || file.length() <= 0 || System.currentTimeMillis() - file.lastModified() >= 86400000) {
                                            byte[] e2 = C0004b.e();
                                            if (e2 != null) {
                                                if (!(e2.length == 0)) {
                                                    g.m.K(file, e2);
                                                }
                                            }
                                            if (file.isFile()) {
                                                file.setLastModified(System.currentTimeMillis());
                                            }
                                        }
                                    } catch (Exception unused) {
                                    }
                                    f468j.post(new U(new File(context.getFilesDir(), "sound-nix.mp3"), context, 3));
                                    return;
                                }
                            }
                        }
                        systemService = context.getSystemService("audio");
                        i.b.c(systemService, "null cannot be cast to non-null type android.media.AudioManager");
                        if (((AudioManager) systemService).getRingerMode() == 2) {
                        }
                    } catch (Throwable unused2) {
                        return;
                    }
                    c0018e1 = this;
                    z = false;
                    c0018e1.c(z);
                    while (r15.hasNext()) {
                    }
                }
            }
        }
    }

    public final synchronized void f(Context context, String str, List list, long j2, boolean z) {
        try {
            Object systemService = context.getSystemService("notification");
            i.b.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            NotificationChannel notificationChannel = new NotificationChannel("chat1", "NixHost Messages", 4);
            notificationChannel.setSound(null, null);
            notificationChannel.enableVibration(true);
            notificationChannel.setShowBadge(true);
            notificationManager.createNotificationChannel(notificationChannel);
            String lowerCase = str.toLowerCase(Locale.ROOT);
            i.b.d(lowerCase, "toLowerCase(...)");
            int hashCode = lowerCase.hashCode() & 65535;
            int i2 = hashCode + 2000;
            HashMap hashMap = f462d;
            Object obj = hashMap.get(str);
            if (obj == null) {
                obj = new ArrayList();
                hashMap.put(str, obj);
            }
            ArrayList arrayList = (ArrayList) obj;
            arrayList.addAll(list);
            while (true) {
                if (arrayList.size() <= 6) {
                    break;
                } else {
                    arrayList.remove(0);
                }
            }
            String str2 = (String) f463e.get(str);
            if (str2 == null) {
                str2 = str;
            }
            PendingIntent activity = PendingIntent.getActivity(context, i2, new Intent(context, (Class<?>) MainActivity.class).putExtra("openChat", true).addFlags(805306368), 201326592);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, i2, new Intent(context, (Class<?>) NotifyReceiver.class).setAction("com.nix.host.CHAT_REPLY").putExtra("u", str).putExtra("last", j2), (Build.VERSION.SDK_INT >= 31 ? 33554432 : 0) | 134217728);
            PendingIntent broadcast2 = PendingIntent.getBroadcast(context, hashCode + 102000, new Intent(context, (Class<?>) NotifyReceiver.class).setAction("com.nix.host.CHAT_LIKE").putExtra("u", str).putExtra("last", j2), 201326592);
            Icon createWithResource = Icon.createWithResource(context, R.drawable.ic_stat_term);
            notificationManager.notify(i2, new Notification.Builder(context, "chat1").setSmallIcon(R.drawable.ic_stat_term).setLargeIcon(a(str)).setContentTitle(str2).setContentText((CharSequence) c.b.M(arrayList)).setStyle(new Notification.BigTextStyle().bigText(c.b.L(arrayList, "\n", null, null, null, 62))).setCategory("msg").setAutoCancel(true).setShowWhen(true).setWhen(System.currentTimeMillis()).setOnlyAlertOnce(z).setContentIntent(activity).addAction(new Notification.Action.Builder(createWithResource, "Reply", broadcast).addRemoteInput(new RemoteInput.Builder("reply_text").setLabel("Reply").build()).setAllowGeneratedReplies(true).build()).addAction(new Notification.Action.Builder(createWithResource, "👍 Like", broadcast2).build()).build());
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void g(Context context, String str, String str2, long j2) {
        c(f463e.get(str) == null);
        f(context, str, AbstractC0008c.p("You: ".concat(str2)), j2, true);
    }

    public final synchronized void h(Context context) {
        if (f460b) {
            return;
        }
        f460b = true;
        Thread thread = new Thread(new G(1, context.getApplicationContext()));
        thread.setDaemon(true);
        f461c = thread;
        thread.start();
    }

    public final synchronized void i() {
        f460b = false;
        try {
            Thread thread = f461c;
            if (thread != null) {
                thread.interrupt();
            }
        } catch (Exception unused) {
        }
        f461c = null;
    }
}
