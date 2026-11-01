package a;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;

/* renamed from: a.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0004b {

    /* renamed from: a, reason: collision with root package name */
    public static final C0004b f409a = new C0004b();

    /* renamed from: b, reason: collision with root package name */
    public static volatile String f410b = "";

    public static C0000a a(String str, String str2, JSONObject jSONObject, boolean z) {
        if (f410b.length() == 0) {
            return new C0000a(0, "");
        }
        try {
            URLConnection openConnection = new URL(f410b + str2).openConnection();
            i.b.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setRequestMethod(str);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(25000);
            httpURLConnection.setRequestProperty("User-Agent", "NixHost");
            if (z) {
                SharedPreferences sharedPreferences = AbstractC0008c.f440c;
                if (sharedPreferences == null) {
                    i.b.g("sp");
                    throw null;
                }
                String string = sharedPreferences.getString("session", "");
                if (string == null) {
                    string = "";
                }
                if (string.length() > 0) {
                    httpURLConnection.setRequestProperty("Authorization", "Bearer ".concat(string));
                }
            }
            if (jSONObject != null) {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                OutputStream outputStream = httpURLConnection.getOutputStream();
                try {
                    byte[] bytes = jSONObject.toString().getBytes(m.a.f864a);
                    i.b.d(bytes, "getBytes(...)");
                    outputStream.write(bytes);
                    AbstractC0008c.a(outputStream, null);
                } finally {
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            InputStream errorStream = (200 > responseCode || responseCode >= 300) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
            return new C0000a(responseCode, errorStream != null ? AbstractC0008c.v(new BufferedReader(new InputStreamReader(errorStream, m.a.f864a), 8192)) : "");
        } catch (Exception unused) {
            return new C0000a(0, "");
        }
    }

    public static /* synthetic */ C0000a b(C0004b c0004b, String str, String str2, JSONObject jSONObject, int i2) {
        if ((i2 & 4) != 0) {
            jSONObject = null;
        }
        c0004b.getClass();
        return a(str, str2, jSONObject, true);
    }

    public static byte[] e() {
        if (f410b.length() == 0) {
            return null;
        }
        try {
            URLConnection openConnection = new URL(f410b + "/chat/sound").openConnection();
            i.b.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setRequestProperty("User-Agent", "NixHost");
            String str = "";
            SharedPreferences sharedPreferences = AbstractC0008c.f440c;
            if (sharedPreferences == null) {
                i.b.g("sp");
                throw null;
            }
            String string = sharedPreferences.getString("session", "");
            if (string != null) {
                str = string;
            }
            httpURLConnection.setRequestProperty("Authorization", "Bearer ".concat(str));
            int responseCode = httpURLConnection.getResponseCode();
            if (200 > responseCode || responseCode >= 300) {
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                byte[] u2 = AbstractC0008c.u(inputStream);
                AbstractC0008c.a(inputStream, null);
                return u2;
            } finally {
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] g(String str) {
        try {
            i.b.e(str, "<this>");
            boolean G = m.m.G(str, 0, "http", 0, 4, true);
            if (!G) {
                str = f410b + str;
            }
            URLConnection openConnection = new URL(str).openConnection();
            i.b.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setRequestProperty("User-Agent", "NixHost");
            if (!G) {
                String str2 = "";
                SharedPreferences sharedPreferences = AbstractC0008c.f440c;
                if (sharedPreferences == null) {
                    i.b.g("sp");
                    throw null;
                }
                String string = sharedPreferences.getString("session", "");
                if (string != null) {
                    str2 = string;
                }
                httpURLConnection.setRequestProperty("Authorization", "Bearer ".concat(str2));
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (200 > responseCode || responseCode >= 300) {
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                byte[] u2 = AbstractC0008c.u(inputStream);
                AbstractC0008c.a(inputStream, null);
                return u2;
            } finally {
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static void h(Context context) {
        String str = "";
        try {
            str = m.e.j0(new JSONObject(AbstractC0008c.v(new BufferedReader(new InputStreamReader(context.getAssets().open("data/server.json"), m.a.f864a), 8192))).optString("url", ""), '/');
        } catch (Exception unused) {
        }
        f410b = str;
    }

    public final void c(long j2) {
        b(this, "POST", "/chat/seen", new JSONObject().put("id", j2), 8);
    }

    public final C0000a d(JSONObject jSONObject) {
        return b(this, "POST", "/chat/send", jSONObject, 8);
    }

    public final C0000a f(long j2, long j3) {
        return b(this, "GET", "/chat/sync?since=" + j2 + "&before=" + j3, null, 12);
    }
}
