package a;

import android.content.SharedPreferences;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.CRC32;
import org.json.JSONObject;

public abstract class AppState {

    public static volatile JSONObject meJson = null;

    public static volatile String appVersion = "";

    public static SharedPreferences prefs = null;

    public static volatile boolean chatForeground = false;

    public static boolean darkTheme = true;

    public static final g.c A(File file) {
        int length;
        List list;
        int P;
        String path = file.getPath();
        i.b.b(path);
        char c2 = File.separatorChar;
        int P2 = m.e.P(path, c2, 0, false, 4);
        if (P2 != 0) {
            length = (P2 <= 0 || path.charAt(P2 + (-1)) != ':') ? (P2 == -1 && path.length() > 0 && h(path.charAt(m.e.N(path)), ':', false)) ? path.length() : 0 : P2 + 1;
        } else if (path.length() <= 1 || path.charAt(1) != c2 || (P = m.e.P(path, c2, 2, false, 4)) < 0) {
            length = 1;
        } else {
            int P3 = m.e.P(path, c2, P + 1, false, 4);
            length = P3 >= 0 ? P3 + 1 : path.length();
        }
        String substring = path.substring(0, length);
        i.b.d(substring, "substring(...)");
        String substring2 = path.substring(length);
        i.b.d(substring2, "substring(...)");
        if (substring2.length() == 0) {
            list = c.j.f773a;
        } else {
            List a0 = m.e.a0(0, substring2, String.valueOf(new char[]{c2}[0]), false);
            ArrayList arrayList = new ArrayList(c.d.E(a0));
            Iterator it = a0.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            list = arrayList;
        }
        return new g.c(new File(substring), list);
    }

    public static k.c B(int i2, int i3) {
        if (i3 > Integer.MIN_VALUE) {
            return new k.c(i2, i3 - 1, 1);
        }
        k.c cVar = k.c.f859d;
        return k.c.f859d;
    }

    public static final void a(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                if (th != th2) {
                    Integer num = f.a.f807a;
                    if (num == null || num.intValue() >= 19) {
                        th.addSuppressed(th2);
                        return;
                    }
                    Method method = e.a.f806a;
                    if (method != null) {
                        method.invoke(th, th2);
                    }
                }
            }
        }
    }

    public static float b(float f2, float f3, float f4) {
        if (f3 <= f4) {
            return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f4 + " is less than minimum " + f3 + '.');
    }

    public static int c(int i2, int i3) {
        if (i3 >= 0) {
            if (i2 < 0) {
                return 0;
            }
            return i2 > i3 ? i3 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum 0.");
    }

    public static int d(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static final long e(InputStream inputStream, OutputStream outputStream, int i2) {
        i.b.e(inputStream, "<this>");
        byte[] bArr = new byte[i2];
        int read = inputStream.read(bArr);
        long j2 = 0;
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            j2 += read;
            read = inputStream.read(bArr);
        }
        return j2;
    }

    public static n.b f(byte[] bArr, int i2) {
        if (bArr[i2] == 0) {
            byte b2 = bArr[i2 + 1];
            if ((b2 & 255) < 16) {
                n.b bVar = new n.b();
                bVar.f882b = -1L;
                bVar.f881a = b2;
                return bVar;
            }
        }
        throw new n.r();
    }

    public static long g(InputStream inputStream) {
        int read = inputStream.read();
        if (read == -1) {
            throw new EOFException();
        }
        long j2 = read & 127;
        int i2 = 0;
        while ((read & 128) != 0) {
            i2++;
            if (i2 >= 9) {
                throw new n.h();
            }
            read = inputStream.read();
            if (read == -1) {
                throw new EOFException();
            }
            if (read == 0) {
                throw new n.h();
            }
            j2 |= (read & 127) << (i2 * 7);
        }
        return j2;
    }

    public static final boolean h(char c2, char c3, boolean z) {
        if (c2 == c3) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c2);
        char upperCase2 = Character.toUpperCase(c3);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static JSONObject accountFor(String str) {
        JSONObject jSONObject = meJson;
        if (jSONObject == null || (!i.b.a(jSONObject.optString("username"), str) && jSONObject.optBoolean("known", true))) {
            return null;
        }
        return jSONObject;
    }

    public static int j(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | (bArr[i2] << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }

    public static int k(byte[] bArr, int i2) {
        return (bArr[i2 + 3] << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public static int subTextColor() {
        return darkTheme ? -8618878 : -9735552;
    }

    public static int mainTextColor() {
        return darkTheme ? -1 : -15656921;
    }

    public static int n(long j2) {
        int i2 = 0;
        do {
            i2++;
            j2 >>= 7;
        } while (j2 != 0);
        return i2;
    }

    public static boolean o(byte[] bArr, int i2, int i3, int i4) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, i2, i3);
        long value = crc32.getValue();
        for (int i5 = 0; i5 < 4; i5++) {
            if (((byte) (value >>> (i5 * 8))) != bArr[i4 + i5]) {
                return false;
            }
        }
        return true;
    }

    public static List p(Object obj) {
        List singletonList = Collections.singletonList(obj);
        i.b.d(singletonList, "singletonList(...)");
        return singletonList;
    }

    public static boolean isLockedOrExpired(JSONObject jSONObject) {
        if (!jSONObject.optBoolean("known", true) || jSONObject.optBoolean("locked", false)) {
            return true;
        }
        long optLong = jSONObject.optLong("expires_at", 0L);
        return optLong > 0 && System.currentTimeMillis() > optLong;
    }

    public static final int r(int i2) {
        if (i2 < 0) {
            return i2;
        }
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((i2 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static boolean isUpdateAvailable(JSONObject jSONObject) {
        String optString;
        String str = "";
        if (jSONObject != null && (optString = jSONObject.optString("version", "")) != null) {
            str = optString;
        }
        String X = m.e.X(m.e.X(m.e.h0(str).toString(), "v"), "V");
        return X.length() > 0 && appVersion.length() > 0 && !X.equals(m.e.X(m.e.X(m.e.h0(appVersion).toString(), "v"), "V"));
    }

    public static void putPref(String str, String str2) {
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        } else {
            i.b.g("sp");
            throw null;
        }
    }

    public static final byte[] u(InputStream inputStream) {
        i.b.e(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        e(inputStream, byteArrayOutputStream, 8192);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        i.b.d(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public static final String v(Reader reader) {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[8192];
        int read = reader.read(cArr);
        while (read >= 0) {
            stringWriter.write(cArr, 0, read);
            read = reader.read(cArr);
        }
        String stringWriter2 = stringWriter.toString();
        i.b.d(stringWriter2, "toString(...)");
        return stringWriter2;
    }

    public static void w(byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) (i3 >>> 24);
        bArr[i2 + 1] = (byte) (i3 >>> 16);
        bArr[i2 + 2] = (byte) (i3 >>> 8);
        bArr[i2 + 3] = (byte) i3;
    }

    public static void x(byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) i3;
        bArr[i2 + 1] = (byte) (i3 >>> 8);
        bArr[i2 + 2] = (byte) (i3 >>> 16);
        bArr[i2 + 3] = (byte) (i3 >>> 24);
    }

    public static Set y(Object... objArr) {
        int length = objArr.length;
        if (length == 0) {
            return c.k.f774a;
        }
        if (length == 1) {
            Set singleton = Collections.singleton(objArr[0]);
            i.b.d(singleton, "singleton(...)");
            return singleton;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(r(objArr.length));
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }

    public static String refreshAccount(File file) {
        ApiResponse b2 = ApiClient.requestWithDefaults(ApiClient.INSTANCE, "GET", "/me", null, 12);
        int i2 = b2.code;
        if (i2 == 0) {
            return "offline";
        }
        if (i2 != 401) {
            JSONObject c2 = b2.json();
            if (c2 == null) {
                return "offline";
            }
            c2.remove("session");
            meJson = c2;
            try {
                g.m.L(new File(file, "c_me.json"), c2.toString());
                return "ok";
            } catch (Exception unused) {
                return "ok";
            }
        }
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null) {
            i.b.g("sp");
            throw null;
        }
        sharedPreferences.edit().putString("session", "").apply();
        meJson = null;
        try {
            new File(file, "c_me.json").delete();
            return "badsession";
        } catch (Exception unused2) {
            return "badsession";
        }
    }
}
