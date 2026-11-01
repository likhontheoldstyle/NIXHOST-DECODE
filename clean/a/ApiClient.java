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

public final class ApiClient {

    public static final ApiClient INSTANCE = new ApiClient();

    public static volatile String baseUrl = "";

    public static ApiResponse request(String str, String str2, JSONObject jSONObject, boolean z) {
        if (baseUrl.length() == 0) {
            return new ApiResponse(0, "");
        }
        try {
            URLConnection openConnection = new URL(baseUrl + str2).openConnection();
            i.b.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setRequestMethod(str);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(25000);
            httpURLConnection.setRequestProperty("User-Agent", "NixHost");
            if (z) {
                SharedPreferences sharedPreferences = AppState.prefs;
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
                    AppState.a(outputStream, null);
                } finally {
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            InputStream errorStream = (200 > responseCode || responseCode >= 300) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
            return new ApiResponse(responseCode, errorStream != null ? AppState.v(new BufferedReader(new InputStreamReader(errorStream, m.a.f864a), 8192)) : "");
        } catch (Exception unused) {
            return new ApiResponse(0, "");
        }
    }

    public static ApiResponse requestWithDefaults(ApiClient apiClient, String str, String str2, JSONObject jSONObject, int i2) {
        if ((i2 & 4) != 0) {
            jSONObject = null;
        }
        apiClient.getClass();
        return request(str, str2, jSONObject, true);
    }

    public static byte[] downloadChatSound() {
        if (baseUrl.length() == 0) {
            return null;
        }
        try {
            URLConnection openConnection = new URL(baseUrl + "/chat/sound").openConnection();
            i.b.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setRequestProperty("User-Agent", "NixHost");
            String str = "";
            SharedPreferences sharedPreferences = AppState.prefs;
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
                byte[] u2 = AppState.u(inputStream);
                AppState.a(inputStream, null);
                return u2;
            } finally {
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] downloadBytes(String str) {
        try {
            i.b.e(str, "<this>");
            boolean G = m.m.G(str, 0, "http", 0, 4, true);
            if (!G) {
                str = baseUrl + str;
            }
            URLConnection openConnection = new URL(str).openConnection();
            i.b.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setRequestProperty("User-Agent", "NixHost");
            if (!G) {
                String str2 = "";
                SharedPreferences sharedPreferences = AppState.prefs;
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
                byte[] u2 = AppState.u(inputStream);
                AppState.a(inputStream, null);
                return u2;
            } finally {
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static void loadBaseUrl(Context context) {
        String str = "";
        try {
            str = m.e.j0(new JSONObject(AppState.v(new BufferedReader(new InputStreamReader(context.getAssets().open("data/server.json"), m.a.f864a), 8192))).optString("url", ""), '/');
        } catch (Exception unused) {
        }
        baseUrl = str;
    }

    public final void markSeen(long j2) {
        requestWithDefaults(this, "POST", "/chat/seen", new JSONObject().put("id", j2), 8);
    }

    public final ApiResponse sendChatMessage(JSONObject jSONObject) {
        return requestWithDefaults(this, "POST", "/chat/send", jSONObject, 8);
    }

    public final ApiResponse syncChat(long j2, long j3) {
        return requestWithDefaults(this, "GET", "/chat/sync?since=" + j2 + "&before=" + j3, null, 12);
    }
}
