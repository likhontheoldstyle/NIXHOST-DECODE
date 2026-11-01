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

public final class ChatNotifier {

    public static final ChatNotifier INSTANCE = new ChatNotifier();

    public static volatile boolean polling;

    public static Thread pollThread;

    public static final HashMap pendingLines = new HashMap();

    public static final HashMap displayNames = new HashMap();

    public static final HashMap memberPics = new HashMap();

    public static final HashMap avatarBitmaps = new HashMap();

    public static long membersFetchedAt;

    public static MediaPlayer soundPlayer;

    public static final Handler mainHandler = new Handler(Looper.getMainLooper());

    public static Bitmap makeInitialAvatar(ChatNotifier chatNotifier, String str) {
        chatNotifier.getClass();
        Bitmap createBitmap = Bitmap.createBitmap(128, 128, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        String lowerCase = str.toLowerCase(Locale.ROOT);
        i.b.d(lowerCase, "toLowerCase(...)");
        paint.setColor(Color.HSVToColor(new float[]{Math.abs(lowerCase.hashCode()) % 360, 0.5f, 0.75f}));
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

    public static void stopSound() {
        MediaPlayer mediaPlayer = soundPlayer;
        if (mediaPlayer == null) {
            return;
        }
        soundPlayer = null;
        try {
            mediaPlayer.stop();
        } catch (Exception unused) {
        }
        try {
            mediaPlayer.release();
        } catch (Exception unused2) {
        }
    }

    public final Bitmap avatarFor(String str) {
        String str2 = (String) memberPics.get(str);
        if (str2 == null) {
            str2 = "";
        }
        int length = str2.length();
        HashMap hashMap = displayNames;
        if (length == 0) {
            String str3 = (String) hashMap.get(str);
            if (str3 != null) {
                str = str3;
            }
            return makeInitialAvatar(this, str);
        }
        HashMap hashMap2 = avatarBitmaps;
        Bitmap bitmap = (Bitmap) hashMap2.get(str2);
        if (bitmap != null) {
            return bitmap;
        }
        try {
            byte[] g2 = ApiClient.downloadBytes(str2);
            Bitmap decodeByteArray = g2 != null ? BitmapFactory.decodeByteArray(g2, 0, g2.length) : null;
            if (decodeByteArray == null) {
                String str4 = (String) hashMap.get(str);
                if (str4 == null) {
                    str4 = str;
                }
                return makeInitialAvatar(this, str4);
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
            return makeInitialAvatar(this, str);
        }
    }

    public final void clearChatNotifications(Context context) {
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
                pendingLines.clear();
            }
        } catch (Exception unused) {
        }
    }

    public final synchronized void refreshMembers(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z || currentTimeMillis - membersFetchedAt >= 600000) {
            ApiResponse b2 = ApiClient.requestWithDefaults(ApiClient.INSTANCE, "GET", "/chat/members", null, 12);
            JSONObject c2 = b2.json();
            JSONArray optJSONArray = c2 != null ? c2.optJSONArray("members") : null;
            if (b2.isSuccess() && optJSONArray != null) {
                membersFetchedAt = currentTimeMillis;
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("u");
                        displayNames.put(optString, optJSONObject.optString("n", optString));
                        memberPics.put(optString, optJSONObject.optString("p", ""));
                    }
                }
            }
        }
    }

    public final void pollOnce(Context context) {
        JSONObject c2;
        SharedPreferences sharedPreferences = AppState.prefs;
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
        SharedPreferences sharedPreferences2 = AppState.prefs;
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
        SharedPreferences sharedPreferences3 = AppState.prefs;
        if (sharedPreferences3 == null) {
            i.b.g("sp");
            throw null;
        }
        String string3 = sharedPreferences3.getString(concat, "");
        if (string3 == null) {
            string3 = "";
        }
        Long D = m.l.D(string3);
        ApiClient apiClient = ApiClient.INSTANCE;
        if (D == null) {
            ApiResponse b2 = ApiClient.requestWithDefaults(apiClient, "GET", "/chat/new?since=-1", null, 12);
            if (b2.isSuccess()) {
                JSONObject c3 = b2.json();
                AppState.putPref(concat, String.valueOf(c3 != null ? c3.optLong("max", 0L) : 0L));
                return;
            }
            return;
        }
        ApiResponse b3 = ApiClient.requestWithDefaults(apiClient, "GET", "/chat/new?since=" + D.longValue(), null, 12);
        if (!b3.isSuccess() || (c2 = b3.json()) == null) {
            return;
        }
        long optLong = c2.optLong("max", D.longValue());
        JSONArray optJSONArray = c2.optJSONArray("msgs");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return;
        }
        AppState.putPref(concat, String.valueOf(optLong));
        if (AppState.chatForeground) {
            return;
        }
        String concat2 = "muted_".concat(string);
        SharedPreferences sharedPreferences4 = AppState.prefs;
        if (sharedPreferences4 == null) {
            i.b.g("sp");
            throw null;
        }
        String string4 = sharedPreferences4.getString(concat2, "");
        if ((string4 != null ? string4 : "").equals("1")) {
            return;
        }
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
                    String preview = null;
                    if (optString3 != null) {
                        switch (optString3) {
                            case "like":
                                preview = "👍";
                                break;
                            case "image":
                                preview = "📷 Photo";
                                break;
                            case "video":
                                preview = "🎥 Video";
                                break;
                            case "voice":
                                preview = "🎤 Voice message";
                                break;
                        }
                    }
                    if (preview == null) {
                        preview = optJSONObject.optString("x");
                    }
                    arrayList.add(preview);
                    hashMap.put(optString2, Long.valueOf(optJSONObject.optLong("id")));
                }
            }
        }
        if (linkedHashMap.isEmpty()) {
            return;
        }
        try {
            Set keySet = linkedHashMap.keySet();
            boolean needNames = false;
            if (!(keySet instanceof Collection) || !keySet.isEmpty()) {
                Iterator it = keySet.iterator();
                while (it.hasNext()) {
                    if (displayNames.get((String) it.next()) == null) {
                        needNames = true;
                        break;
                    }
                }
            }
            refreshMembers(needNames);
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                ArrayList arrayList2 = (ArrayList) entry.getValue();
                Long l2 = (Long) hashMap.get(str);
                showNotification(context, str, arrayList2, l2 != null ? l2.longValue() : optLong, false);
            }
            Object systemService = context.getSystemService("audio");
            i.b.c(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            if (((AudioManager) systemService).getRingerMode() != 2) {
                return;
            }
            try {
                File file = new File(context.getFilesDir(), "sound-nix.mp3");
                if (!file.isFile() || file.length() <= 0 || System.currentTimeMillis() - file.lastModified() >= 86400000) {
                    byte[] e2 = ApiClient.downloadChatSound();
                    if (e2 != null && !(e2.length == 0)) {
                        g.m.K(file, e2);
                    } else if (file.isFile()) {
                        file.setLastModified(System.currentTimeMillis());
                    }
                }
            } catch (Exception unused) {
            }
            mainHandler.post(new HttpConnectionHandler(new File(context.getFilesDir(), "sound-nix.mp3"), context, 3));
        } catch (Throwable unused2) {
        }
    }

    public final synchronized void showNotification(Context context, String str, List list, long j2, boolean z) {
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
            HashMap hashMap = pendingLines;
            Object obj = hashMap.get(str);
            if (obj == null) {
                obj = new ArrayList();
                hashMap.put(str, obj);
            }
            ArrayList arrayList = (ArrayList) obj;
            arrayList.addAll(list);
            while (arrayList.size() > 6) {
                arrayList.remove(0);
            }
            String str2 = (String) displayNames.get(str);
            if (str2 == null) {
                str2 = str;
            }
            PendingIntent activity = PendingIntent.getActivity(context, i2, new Intent(context, (Class<?>) MainActivity.class).putExtra("openChat", true).addFlags(805306368), 201326592);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, i2, new Intent(context, (Class<?>) NotifyReceiver.class).setAction("com.nix.host.CHAT_REPLY").putExtra("u", str).putExtra("last", j2), (Build.VERSION.SDK_INT >= 31 ? 33554432 : 0) | 134217728);
            PendingIntent broadcast2 = PendingIntent.getBroadcast(context, hashCode + 102000, new Intent(context, (Class<?>) NotifyReceiver.class).setAction("com.nix.host.CHAT_LIKE").putExtra("u", str).putExtra("last", j2), 201326592);
            Icon createWithResource = Icon.createWithResource(context, R.drawable.ic_stat_term);
            notificationManager.notify(i2, new Notification.Builder(context, "chat1").setSmallIcon(R.drawable.ic_stat_term).setLargeIcon(avatarFor(str)).setContentTitle(str2).setContentText((CharSequence) c.b.M(arrayList)).setStyle(new Notification.BigTextStyle().bigText(c.b.L(arrayList, "\n", null, null, null, 62))).setCategory("msg").setAutoCancel(true).setShowWhen(true).setWhen(System.currentTimeMillis()).setOnlyAlertOnce(z).setContentIntent(activity).addAction(new Notification.Action.Builder(createWithResource, "Reply", broadcast).addRemoteInput(new RemoteInput.Builder("reply_text").setLabel("Reply").build()).setAllowGeneratedReplies(true).build()).addAction(new Notification.Action.Builder(createWithResource, "👍 Like", broadcast2).build()).build());
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void showOwnMessageNotification(Context context, String str, String str2, long j2) {
        refreshMembers(displayNames.get(str) == null);
        showNotification(context, str, AppState.p("You: ".concat(str2)), j2, true);
    }

    public final synchronized void startPolling(Context context) {
        if (polling) {
            return;
        }
        polling = true;
        Thread thread = new Thread(new TaskRunnable(1, context.getApplicationContext()));
        thread.setDaemon(true);
        pollThread = thread;
        thread.start();
    }

    public final synchronized void stopPolling() {
        polling = false;
        try {
            Thread thread = pollThread;
            if (thread != null) {
                thread.interrupt();
            }
        } catch (Exception unused) {
        }
        pollThread = null;
    }
}
