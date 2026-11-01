package a;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class ChatMedia {

    public static File cacheDir;

    public static final BitmapLruCache bitmapCache = new BitmapLruCache(14680064, 1);

    public static final ExecutorService executor = Executors.newFixedThreadPool(3);

    public static final Handler mainHandler = new Handler(Looper.getMainLooper());

    public static final HashMap avatarCache = new HashMap();

    public static final HashMap aspectRatios = new HashMap();

    public static Bitmap decodeSampled(File file, int i2) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i3 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getPath(), options);
            while (true) {
                int i4 = i3 * 2;
                if (options.outWidth / i4 < i2 || options.outHeight / i4 < i2) {
                    break;
                }
                i3 = i4;
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = i3;
            return BitmapFactory.decodeFile(file.getPath(), options2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static File fetchMediaFile(String str) {
        File c2 = mediaFile(str);
        if (c2.exists() && c2.length() > 0) {
            return c2;
        }
        if (m.m.K(str, "L")) {
            return null;
        }
        if (ApiClient.baseUrl.length() == 0) {
            return null;
        }
        try {
            URLConnection openConnection = new URL(ApiClient.baseUrl + "/chat/media/" + str).openConnection();
            i.b.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(60000);
            httpURLConnection.setRequestProperty("User-Agent", "NixHost");
            SharedPreferences sharedPreferences = AppState.prefs;
            if (sharedPreferences == null) {
                i.b.g("sp");
                throw null;
            }
            String string = sharedPreferences.getString("session", "");
            String str2 = "";
            if (string != null) {
                str2 = string;
            }
            httpURLConnection.setRequestProperty("Authorization", "Bearer ".concat(str2));
            int responseCode = httpURLConnection.getResponseCode();
            if (200 <= responseCode && responseCode < 300) {
                byte[] u2;
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    u2 = AppState.u(inputStream);
                    AppState.a(inputStream, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        AppState.a(inputStream, th);
                        throw th2;
                    }
                }
                if (u2 != null) {
                    try {
                        g.m.K(c2, u2);
                        return c2;
                    } catch (Exception unused2) {
                        return null;
                    }
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static File mediaFile(String str) {
        return new File(cacheDir(), StringPlus.stringPlus("m_", str));
    }

    public static File cacheDir() {
        File file = cacheDir;
        if (file != null) {
            return file;
        }
        i.b.g("dir");
        throw null;
    }

    public static void loadInto(ImageView imageView, String str, int i2, h.b bVar) {
        imageView.setTag(str);
        String str2 = str + "@" + i2;
        Bitmap bitmap = (Bitmap) bitmapCache.get(str2);
        if (bitmap == null) {
            imageView.setImageDrawable(null);
            executor.execute(new MultiWorkRunnable(str, i2, str2, imageView, bVar));
        } else {
            aspectRatios.put(str, Float.valueOf(bitmap.getWidth() / bitmap.getHeight()));
            imageView.setImageBitmap(bitmap);
            if (bVar != null) {
                bVar.a(bitmap);
            }
        }
    }

    public static void loadAvatar(AvatarView avatarView, String str) {
        Bitmap bitmap = (Bitmap) avatarCache.get(str);
        if (bitmap != null) {
            avatarView.setBmp(bitmap);
            avatarView.invalidate();
            return;
        }
        executor.execute(new BackgroundTask((Object) new File(cacheDir(), "g_" + Math.abs(str.hashCode())), (Object) str, (Object) avatarView, 8, (byte) 0));
    }

    public static File videoFile(String str) {
        return new File(cacheDir(), StringPlus.stringPlus("v_", str));
    }
}
