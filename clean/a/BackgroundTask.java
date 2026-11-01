package a;

import android.animation.ValueAnimator;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.nix.host.MainActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONObject;

public final class BackgroundTask implements Runnable {

    public final int mode;

    public final Object first;

    public final Object second;

    public final Object third;

    public BackgroundTask(ApiResponse apiResponse, ChatScreen chatScreen, String str) {
        this.mode = 3;
        this.second = apiResponse;
        this.first = chatScreen;
        this.third = str;
    }

    @Override
    public final void run() {
        final String str;
        String canonicalPath;
        ZipFile zipFile;
        String str2;
        FileOutputStream fileOutputStream;
        String str3;
        SharedPreferences sharedPreferences;
        final String message;
        Bitmap a2;
        final int i2 = 1;
        final int i3 = 0;
        switch (this.mode) {
            case 0:
                File file = ChatMedia.cacheDir;
                File b2 = ChatMedia.fetchMediaFile((String) this.third);
                ChatScreen chatScreen = (ChatScreen) this.first;
                chatScreen.activity.runOnUiThread(new BackgroundTask((Object) chatScreen, this.second, (Object) b2, 1, false));
                return;
            case 1:
                ChatScreen chatScreen2 = (ChatScreen) this.first;
                long j2 = chatScreen2.previewMessageId;
                long j3 = ((ChatMessage) this.second).id;
                if (j2 != j3) {
                    return;
                }
                chatScreen2.previewMessageId = Long.MIN_VALUE;
                File file2 = (File) this.third;
                if (file2 != null) {
                    chatScreen2.toggleVoicePlayback(j3, file2);
                    return;
                }
                C1 c1 = (C1) chatScreen2.playButtons.get(Long.valueOf(j3));
                if (c1 != null) {
                    c1.set("play");
                }
                chatScreen2.toaster.a(chatScreen2.isOffline() ? "No internet connection" : "Couldn't load the voice message, try again");
                return;
            case 2:
                ChatScreen chatScreen3 = (ChatScreen) this.first;
                c.h.G(chatScreen3.messages, new ToastCallback(i3, (OutboxEntry) this.second));
                ApiResponse apiResponse = (ApiResponse) this.third;
                if (apiResponse.code == 401) {
                    chatScreen3.onSessionExpired.a();
                    return;
                }
                if (apiResponse.isSuccess()) {
                    JSONObject c4 = apiResponse.json();
                    JSONObject optJSONObject = c4 != null ? c4.optJSONObject("msg") : null;
                    if (optJSONObject != null) {
                        chatScreen3.addMessages(new JSONArray().put(optJSONObject));
                    }
                } else {
                    chatScreen3.toaster.a(ChatScreen.errorText(apiResponse));
                }
                chatScreen3.refreshMessages();
                chatScreen3.applyScroll(true);
                return;
            case 3:
                ApiResponse apiResponse2 = (ApiResponse) this.second;
                boolean b3 = apiResponse2.isSuccess();
                ChatScreen chatScreen4 = (ChatScreen) this.first;
                if (!b3) {
                    JSONObject c5 = apiResponse2.json();
                    long optLong = c5 != null ? c5.optLong("nat", 0L) : 0L;
                    if (apiResponse2.code == 429 && optLong > 0) {
                        chatScreen4.saveNameChangedAt(optLong);
                        C0029h0 c0029h0 = chatScreen4.quickReactionRefresher;
                        if (c0029h0 != null) {
                            c0029h0.a();
                        }
                    }
                    chatScreen4.toaster.a(ChatScreen.errorText(apiResponse2));
                    return;
                }
                chatScreen4.displayNames.put(chatScreen4.username, (String) this.third);
                JSONObject c6 = apiResponse2.json();
                chatScreen4.saveNameChangedAt(c6 != null ? c6.optLong("nat", System.currentTimeMillis()) : System.currentTimeMillis());
                chatScreen4.saveCache();
                O0 o0 = chatScreen4.messageAdapter;
                if (o0 == null) {
                    i.b.g("adapter");
                    throw null;
                }
                o0.notifyDataSetChanged();
                chatScreen4.refreshHeader();
                C0029h0 c0029h02 = chatScreen4.quickReactionRefresher;
                if (c0029h02 != null) {
                    c0029h02.a();
                    return;
                }
                return;
            case 4:
                final File file3 = (File) this.third;
                File file4 = (File) this.first;
                int i4 = MainActivity.R;
                String error = "";
                try {
                    file3.mkdirs();
                    canonicalPath = file3.getCanonicalPath();
                    zipFile = new ZipFile(file4);
                    try {
                        Enumeration<? extends ZipEntry> entries = zipFile.entries();
                        String common = null;
                        boolean mixed = false;
                        while (entries.hasMoreElements()) {
                            String I = m.m.I(entries.nextElement().getName(), '\\', '/');
                            if (I.length() != 0 && !m.m.K(I, "__MACOSX/")) {
                                int P = m.e.P(I, '/', 0, false, 6);
                                if (P < 0) {
                                    mixed = true;
                                    break;
                                }
                                String substring = I.substring(0, P);
                                i.b.d(substring, "substring(...)");
                                if (common == null) {
                                    common = substring;
                                } else if (!common.equals(substring)) {
                                    mixed = true;
                                    break;
                                }
                            }
                        }
                        str2 = (!mixed && common != null) ? common + "/" : "";
                        byte[] bArr = new byte[65536];
                        Enumeration<? extends ZipEntry> entries2 = zipFile.entries();
                        while (entries2.hasMoreElements()) {
                            ZipEntry nextElement = entries2.nextElement();
                            String I2 = m.m.I(nextElement.getName(), '\\', '/');
                            if (I2.length() != 0 && !m.m.K(I2, "__MACOSX/")) {
                                if (str2.length() > 0) {
                                    I2 = m.e.X(I2, str2);
                                }
                                if (I2.length() != 0) {
                                    File canonicalFile = new File(file3, I2).getCanonicalFile();
                                    if (m.m.K(canonicalFile.getPath(), canonicalPath + "/")) {
                                        if (nextElement.isDirectory()) {
                                            canonicalFile.mkdirs();
                                        } else {
                                            File parentFile = canonicalFile.getParentFile();
                                            if (parentFile != null) {
                                                parentFile.mkdirs();
                                            }
                                            InputStream inputStream = zipFile.getInputStream(nextElement);
                                            try {
                                                fileOutputStream = new FileOutputStream(canonicalFile);
                                                while (true) {
                                                    try {
                                                        int read = inputStream.read(bArr);
                                                        if (read >= 0) {
                                                            fileOutputStream.write(bArr, 0, read);
                                                        } else {
                                                            AppState.a(fileOutputStream, null);
                                                            AppState.a(inputStream, null);
                                                        }
                                                    } finally {
                                                    }
                                                }
                                            } finally {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        AppState.a(zipFile, null);
                    } finally {
                    }
                } catch (Exception e2) {
                    String message2 = e2.getMessage();
                    if (message2 == null) {
                        message2 = "failed";
                    }
                    error = message2;
                }
                str = error;
                final MainActivity mainActivity = (MainActivity) this.second;
                mainActivity.runOnUiThread(new Runnable() {
                    @Override
                    public final void run() {
                        String concat;
                        String concat2;
                        File file5 = file3;
                        MainActivity mainActivity2 = mainActivity;
                        String str5 = str;
                        switch (i3) {
                            case 0:
                                int i5 = MainActivity.R;
                                if (str5.length() == 0) {
                                    concat = "Unzipped to " + file5.getName();
                                } else {
                                    concat = "Unzip failed: ".concat(str5);
                                }
                                mainActivity2.toast(concat);
                                if (i.b.a(mainActivity2.screen, "files")) {
                                    mainActivity2.showFiles();
                                    break;
                                }
                                break;
                            default:
                                int i6 = MainActivity.R;
                                if (str5.length() == 0) {
                                    concat2 = "Uploaded: " + file5.getName();
                                } else {
                                    concat2 = "Upload failed: ".concat(str5);
                                }
                                mainActivity2.toast(concat2);
                                if (i.b.a(mainActivity2.screen, "files")) {
                                    mainActivity2.showFiles();
                                    break;
                                }
                                break;
                        }
                    }
                });
                return;
            case 5:
                ApiResponse apiResponse3 = (ApiResponse) this.first;
                MainActivity mainActivity2 = (MainActivity) this.second;
                String str5 = (String) this.third;
                int i5 = MainActivity.R;
                if (!apiResponse3.isSuccess()) {
                    mainActivity2.toast(apiResponse3.errorMessage());
                    return;
                }
                TerminalManager terminalManager = TerminalManager.INSTANCE;
                String str6 = mainActivity2.username + "-" + str5;
                synchronized (terminalManager) {
                    try {
                        TerminalSession terminalSession = (TerminalSession) TerminalManager.sessions.remove(str6);
                        if (terminalSession != null) {
                            try {
                                terminalSession.interrupt();
                            } catch (Exception unused) {
                            }
                        }
                        if (terminalSession == null) {
                            terminalSession = new TerminalSession(new File("/"), new File("/"), terminalManager.logFileFor(str6));
                        }
                        terminalSession.deleteLogFiles();
                        str3 = "draft_" + str6;
                        sharedPreferences = AppState.prefs;
                        if (sharedPreferences == null) {
                            i.b.g("sp");
                            throw null;
                        }
                        sharedPreferences.edit().remove(str3).apply();
                    } finally {
                    }
                }
                JSONObject c7 = apiResponse3.json();
                JSONArray optJSONArray = c7 != null ? c7.optJSONArray("instances") : null;
                File filesDir = mainActivity2.getFilesDir();
                JSONObject jSONObject = AppState.meJson;
                if (jSONObject != null) {
                    if (optJSONArray == null) {
                        optJSONArray = new JSONArray();
                    }
                    jSONObject.put("instances", optJSONArray);
                    try {
                        g.m.L(new File(filesDir, "c_me.json"), jSONObject.toString());
                    } catch (Exception unused3) {
                    }
                }
                mainActivity2.showHome();
                return;
            case 6:
                final MainActivity mainActivity3 = (MainActivity) this.third;
                Uri uri = (Uri) this.first;
                final File file5 = (File) this.second;
                int i6 = MainActivity.R;
                String message3;
                try {
                    InputStream openInputStream = mainActivity3.getContentResolver().openInputStream(uri);
                    if (openInputStream != null) {
                        try {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file5);
                            try {
                                AppState.e(openInputStream, fileOutputStream2, 65536);
                                AppState.a(fileOutputStream2, null);
                                AppState.a(openInputStream, null);
                            } finally {
                            }
                        } finally {
                        }
                    }
                    message3 = "";
                } catch (Exception e3) {
                    try {
                        file5.delete();
                    } catch (Exception unused4) {
                    }
                    message3 = e3.getMessage();
                    if (message3 == null) {
                        message3 = "failed";
                    }
                }
                message = message3;
                mainActivity3.runOnUiThread(new Runnable() {
                    @Override
                    public final void run() {
                        String concat;
                        String concat2;
                        File file52 = file5;
                        MainActivity mainActivity22 = mainActivity3;
                        String str52 = message;
                        switch (i2) {
                            case 0:
                                int i52 = MainActivity.R;
                                if (str52.length() == 0) {
                                    concat = "Unzipped to " + file52.getName();
                                } else {
                                    concat = "Unzip failed: ".concat(str52);
                                }
                                mainActivity22.toast(concat);
                                if (i.b.a(mainActivity22.screen, "files")) {
                                    mainActivity22.showFiles();
                                    break;
                                }
                                break;
                            default:
                                int i62 = MainActivity.R;
                                if (str52.length() == 0) {
                                    concat2 = "Uploaded: " + file52.getName();
                                } else {
                                    concat2 = "Upload failed: ".concat(str52);
                                }
                                mainActivity22.toast(concat2);
                                if (i.b.a(mainActivity22.screen, "files")) {
                                    mainActivity22.showFiles();
                                    break;
                                }
                                break;
                        }
                    }
                });
                return;
            case 7:
                int i7 = MainActivity.R;
                final LinearLayout linearLayout = (LinearLayout) this.third;
                final float height = linearLayout.getHeight();
                linearLayout.setTranslationY(height);
                linearLayout.setVisibility(0);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.setDuration(380L);
                ofFloat.setInterpolator(new DecelerateInterpolator(2.0f));
                final FrameLayout frameLayout = (FrameLayout) ((View) this.second);
                final View view = (View) this.first;
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        RenderEffect createBlurEffect;
                        int i8 = MainActivity.R;
                        Object animatedValue = valueAnimator.getAnimatedValue();
                        i.b.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                        float floatValue = ((Float) animatedValue).floatValue();
                        linearLayout.setTranslationY((1.0f - floatValue) * height);
                        view.setAlpha(floatValue);
                        if (Build.VERSION.SDK_INT < 31 || floatValue <= 0.01f) {
                            return;
                        }
                        float f2 = floatValue * 22.0f;
                        createBlurEffect = RenderEffect.createBlurEffect(f2, f2, Shader.TileMode.CLAMP);
                        ((FrameLayout) frameLayout).setRenderEffect(createBlurEffect);
                    }
                });
                ofFloat.start();
                return;
            case 8:
                File file6 = (File) this.first;
                boolean exists = file6.exists();
                Handler handler = ChatMedia.mainHandler;
                AvatarView a22 = (AvatarView) this.second;
                Bitmap decoded = null;
                if (exists && (a2 = ChatMedia.decodeSampled(file6, 300)) != null) {
                    handler.post(new HttpConnectionHandler(a22, a2, 7));
                    decoded = a2;
                }
                String str7 = (String) this.third;
                byte[] g2 = ApiClient.downloadBytes(str7);
                if (g2 != null) {
                    try {
                        g.m.K(file6, g2);
                    } catch (Exception unused5) {
                    }
                }
                if (g2 != null && file6.exists()) {
                    decoded = ChatMedia.decodeSampled(file6, 300);
                }
                if (decoded != null) {
                    handler.post(new BackgroundTask(str7, decoded, a22, 9));
                    return;
                }
                return;
            case 9:
                HashMap hashMap = ChatMedia.avatarCache;
                String str8 = (String) this.third;
                Bitmap bitmap = (Bitmap) this.first;
                hashMap.put(str8, bitmap);
                AvatarView a23 = (AvatarView) this.second;
                a23.setBmp(bitmap);
                a23.invalidate();
                return;
            default:
                TerminalSession terminalSession2 = (TerminalSession) this.first;
                terminalSession2.runShellCommand((File) this.second, (String) this.third);
                terminalSession2.finishRun();
                return;
        }
    }

    public BackgroundTask(Object obj, Object obj2, Object obj3, int i2) {
        this.mode = i2;
        this.third = obj;
        this.first = obj2;
        this.second = obj3;
    }

    public BackgroundTask(Object obj, Object obj2, Object obj3, int i2, byte b2) {
        this.mode = i2;
        this.first = obj;
        this.third = obj2;
        this.second = obj3;
    }

    public BackgroundTask(Object obj, Object obj2, Object obj3, int i2, boolean z) {
        this.mode = i2;
        this.first = obj;
        this.second = obj2;
        this.third = obj3;
    }
}
