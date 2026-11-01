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

/* loaded from: classes.dex */
public abstract class z2 {

    /* renamed from: a, reason: collision with root package name */
    public static File f758a;

    /* renamed from: b, reason: collision with root package name */
    public static final A1 f759b = new A1(14680064, 1);

    /* renamed from: c, reason: collision with root package name */
    public static final ExecutorService f760c = Executors.newFixedThreadPool(3);

    /* renamed from: d, reason: collision with root package name */
    public static final Handler f761d = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap f762e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public static final HashMap f763f = new HashMap();

    public static Bitmap a(File file, int i2) {
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

    /* JADX WARN: Removed duplicated region for block: B:14:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File b(String str) {
        HttpURLConnection httpURLConnection;
        String str2;
        SharedPreferences sharedPreferences;
        byte[] u2;
        File c2 = c(str);
        if (c2.exists() && c2.length() > 0) {
            return c2;
        }
        if (m.m.K(str, "L")) {
            return null;
        }
        if (C0004b.f410b.length() != 0) {
            try {
                URLConnection openConnection = new URL(C0004b.f410b + "/chat/media/" + str).openConnection();
                i.b.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setRequestProperty("User-Agent", "NixHost");
                str2 = "";
                sharedPreferences = AbstractC0008c.f440c;
            } catch (Exception unused) {
            }
            if (sharedPreferences == null) {
                i.b.g("sp");
                throw null;
            }
            String string = sharedPreferences.getString("session", "");
            if (string != null) {
                str2 = string;
            }
            httpURLConnection.setRequestProperty("Authorization", "Bearer ".concat(str2));
            int responseCode = httpURLConnection.getResponseCode();
            if (200 <= responseCode && responseCode < 300) {
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    u2 = AbstractC0008c.u(inputStream);
                    AbstractC0008c.a(inputStream, null);
                    if (u2 != null) {
                        return null;
                    }
                    try {
                        g.m.K(c2, u2);
                        return c2;
                    } catch (Exception unused2) {
                        return null;
                    }
                } finally {
                }
            }
        }
        u2 = null;
        if (u2 != null) {
        }
    }

    public static File c(String str) {
        return new File(d(), J0.a("m_", str));
    }

    public static File d() {
        File file = f758a;
        if (file != null) {
            return file;
        }
        i.b.g("dir");
        throw null;
    }

    public static void e(ImageView imageView, String str, int i2, h.b bVar) {
        imageView.setTag(str);
        String str2 = str + "@" + i2;
        Bitmap bitmap = (Bitmap) f759b.get(str2);
        if (bitmap == null) {
            imageView.setImageDrawable(null);
            f760c.execute(new RunnableC0037j0(str, i2, str2, imageView, bVar));
        } else {
            f763f.put(str, Float.valueOf(bitmap.getWidth() / bitmap.getHeight()));
            imageView.setImageBitmap(bitmap);
            if (bVar != null) {
                bVar.a(bitmap);
            }
        }
    }

    public static void f(A2 a2, String str) {
        Bitmap bitmap = (Bitmap) f762e.get(str);
        if (bitmap != null) {
            a2.setBmp(bitmap);
            a2.invalidate();
            return;
        }
        f760c.execute(new RunnableC0056o((Object) new File(d(), "g_" + Math.abs(str.hashCode())), (Object) str, (Object) a2, 8, (byte) 0));
    }

    public static File g(String str) {
        return new File(d(), J0.a("v_", str));
    }
}
