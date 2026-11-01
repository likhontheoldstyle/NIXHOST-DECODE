package a;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.AudioAttributes;
import android.media.ExifInterface;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.nix.host.MainActivity;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final /* synthetic */ class U implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f323a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f324b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f325c;

    public /* synthetic */ U(C0006b1 c0006b1, Uri uri) {
        this.f323a = 1;
        this.f324b = c0006b1;
        this.f325c = uri;
    }

    private final void a() {
        List b0;
        OutputStream outputStream;
        int read;
        Socket socket = (Socket) this.f324b;
        G2 g2 = (G2) this.f325c;
        g2.getClass();
        try {
            socket.setSoTimeout(20000);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read2 = bufferedInputStream.read();
                if (read2 < 0 || read2 == 10) {
                    break;
                } else if (read2 != 13) {
                    sb.append((char) read2);
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < 16384 && (read = bufferedInputStream.read()) >= 0) {
                i2++;
                if (read == 10 && i3 == 10) {
                    break;
                } else if (read != 13) {
                    i3 = read;
                }
            }
            b0 = m.e.b0(sb.toString(), new String[]{" "});
            outputStream = socket.getOutputStream();
        } catch (Exception unused) {
        } catch (Throwable th) {
            try {
                socket.close();
            } catch (Exception unused2) {
            }
            throw th;
        }
        try {
            if (b0.size() >= 2 && (i.b.a(b0.get(0), "GET") || i.b.a(b0.get(0), "HEAD"))) {
                String decode = URLDecoder.decode(m.e.e0((String) b0.get(1), '?'), "UTF-8");
                File canonicalFile = g2.f111a.getCanonicalFile();
                File canonicalFile2 = new File(canonicalFile, decode).getCanonicalFile();
                if (!i.b.a(canonicalFile2.getPath(), canonicalFile.getPath())) {
                    if (!m.m.K(canonicalFile2.getPath(), canonicalFile.getPath() + "/")) {
                        byte[] bytes = "Forbidden".getBytes(m.a.f864a);
                        i.b.d(bytes, "getBytes(...)");
                        G2.a(outputStream, 403, "text/plain", bytes);
                        socket.close();
                        return;
                    }
                }
                if (canonicalFile2.isDirectory()) {
                    canonicalFile2 = new File(canonicalFile2, "index.html");
                }
                if (canonicalFile2.isFile()) {
                    LinkedHashMap linkedHashMap = g2.f115e;
                    String name = canonicalFile2.getName();
                    i.b.d(name, "getName(...)");
                    String lowerCase = m.e.d0(name, '.', "").toLowerCase(Locale.ROOT);
                    i.b.d(lowerCase, "toLowerCase(...)");
                    String str = (String) linkedHashMap.get(lowerCase);
                    if (str == null) {
                        str = "application/octet-stream";
                    }
                    G2.a(outputStream, 200, str, i.b.a(b0.get(0), "HEAD") ? new byte[0] : g.m.G(canonicalFile2));
                } else {
                    byte[] bytes2 = "Not found".getBytes(m.a.f864a);
                    i.b.d(bytes2, "getBytes(...)");
                    G2.a(outputStream, 404, "text/plain", bytes2);
                }
                socket.close();
                return;
            }
            socket.close();
            return;
        } catch (Exception unused3) {
            return;
        }
        byte[] bytes3 = "Method not allowed".getBytes(m.a.f864a);
        i.b.d(bytes3, "getBytes(...)");
        G2.a(outputStream, 405, "text/plain", bytes3);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x037e A[Catch: all -> 0x03bf, TryCatch #17 {all -> 0x03bf, blocks: (B:96:0x02e3, B:203:0x02f7, B:99:0x0305, B:101:0x030f, B:105:0x0319, B:152:0x032e, B:155:0x0335, B:172:0x035b, B:158:0x0369, B:160:0x037e, B:162:0x0387, B:163:0x038b, B:186:0x0364, B:187:0x0367, B:198:0x03bb, B:199:0x03be, B:212:0x0300, B:213:0x0303, B:151:0x032a, B:194:0x03b8, B:202:0x02f4, B:208:0x02fd), top: B:95:0x02e3, inners: #8, #11, #12, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0387 A[Catch: all -> 0x03bf, TryCatch #17 {all -> 0x03bf, blocks: (B:96:0x02e3, B:203:0x02f7, B:99:0x0305, B:101:0x030f, B:105:0x0319, B:152:0x032e, B:155:0x0335, B:172:0x035b, B:158:0x0369, B:160:0x037e, B:162:0x0387, B:163:0x038b, B:186:0x0364, B:187:0x0367, B:198:0x03bb, B:199:0x03be, B:212:0x0300, B:213:0x0303, B:151:0x032a, B:194:0x03b8, B:202:0x02f4, B:208:0x02fd), top: B:95:0x02e3, inners: #8, #11, #12, #13 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        byte[] bArr;
        C0000a c0000a;
        InputStream openInputStream;
        BitmapFactory.Options options;
        int i2;
        int min;
        String str;
        int i3 = 3;
        int i4 = 5;
        int i5 = 9;
        String str2 = "";
        int i6 = 2;
        switch (this.f323a) {
            case 0:
                C0004b c0004b = C0004b.f409a;
                C0022f1 c0022f1 = (C0022f1) this.f325c;
                C0000a b2 = C0004b.b(c0004b, "POST", "/chat/theme", new JSONObject().put("id", c0022f1.f481a).put("q", c0022f1.f483c), 8);
                C0006b1 c0006b1 = (C0006b1) this.f324b;
                c0006b1.f414a.runOnUiThread(new S(b2, c0006b1, i6));
                return;
            case 1:
                C0006b1 c0006b12 = (C0006b1) this.f324b;
                Uri uri = (Uri) this.f325c;
                Activity activity = c0006b12.f414a;
                try {
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    options2.inJustDecodeBounds = true;
                    openInputStream = activity.getContentResolver().openInputStream(uri);
                    if (openInputStream != null) {
                        try {
                            BitmapFactory.decodeStream(openInputStream, null, options2);
                            AbstractC0008c.a(openInputStream, null);
                        } finally {
                            try {
                                throw th;
                            } finally {
                                AbstractC0008c.a(openInputStream, th);
                            }
                        }
                    }
                    int i7 = 1;
                    while (true) {
                        int i8 = i7 * 2;
                        if (options2.outWidth / i8 >= 720 && options2.outHeight / i8 >= 720) {
                            i7 = i8;
                        }
                    }
                    options = new BitmapFactory.Options();
                    options.inSampleSize = i7;
                    openInputStream = activity.getContentResolver().openInputStream(uri);
                } catch (Throwable unused) {
                }
                if (openInputStream != null) {
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream, null, options);
                        AbstractC0008c.a(openInputStream, null);
                        if (decodeStream != null) {
                            try {
                                openInputStream = activity.getContentResolver().openInputStream(uri);
                            } catch (Exception unused2) {
                            }
                            if (openInputStream != null) {
                                try {
                                    int attributeInt = new ExifInterface(openInputStream).getAttributeInt("Orientation", 1);
                                    i2 = attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : 270 : 90 : 180;
                                    try {
                                        AbstractC0008c.a(openInputStream, null);
                                    } catch (Exception unused3) {
                                    }
                                    min = Math.min(decodeStream.getWidth(), decodeStream.getHeight());
                                    Matrix matrix = new Matrix();
                                    if (min > 360) {
                                        float f2 = 360.0f / min;
                                        matrix.postScale(f2, f2);
                                    }
                                    if (i2 != 0) {
                                        matrix.postRotate(i2);
                                    }
                                    Bitmap createBitmap = Bitmap.createBitmap(decodeStream, (decodeStream.getWidth() - min) / 2, (decodeStream.getHeight() - min) / 2, min, min, matrix, true);
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                    createBitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
                                    bArr = byteArrayOutputStream.toByteArray();
                                    if (bArr == null) {
                                        c0006b12.f414a.runOnUiThread(new RunnableC0048m(c0006b12, i5));
                                        return;
                                    }
                                    if (C0004b.f410b.length() == 0) {
                                        c0000a = new C0000a(0, "");
                                    } else {
                                        try {
                                            URLConnection openConnection = new URL(C0004b.f410b + "/chat/avatar").openConnection();
                                            i.b.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                                            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                                            httpURLConnection.setRequestMethod("POST");
                                            httpURLConnection.setConnectTimeout(15000);
                                            httpURLConnection.setReadTimeout(30000);
                                            httpURLConnection.setRequestProperty("User-Agent", "NixHost");
                                            SharedPreferences sharedPreferences = AbstractC0008c.f440c;
                                            if (sharedPreferences == null) {
                                                i.b.g("sp");
                                                throw null;
                                            }
                                            String string = sharedPreferences.getString("session", "");
                                            if (string == null) {
                                                string = "";
                                            }
                                            httpURLConnection.setRequestProperty("Authorization", "Bearer " + string);
                                            httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                                            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                                            httpURLConnection.setDoOutput(true);
                                            OutputStream outputStream = httpURLConnection.getOutputStream();
                                            try {
                                                outputStream.write(bArr);
                                                AbstractC0008c.a(outputStream, null);
                                                int responseCode = httpURLConnection.getResponseCode();
                                                InputStream errorStream = (200 > responseCode || responseCode >= 300) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
                                                c0000a = new C0000a(responseCode, errorStream != null ? AbstractC0008c.v(new BufferedReader(new InputStreamReader(errorStream, m.a.f864a), 8192)) : "");
                                            } finally {
                                            }
                                        } catch (Exception unused4) {
                                            c0000a = new C0000a(0, "");
                                        }
                                    }
                                    c0006b12.f414a.runOnUiThread(new S(c0000a, c0006b12, i3));
                                    return;
                                } catch (Throwable th) {
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                            }
                            i2 = 0;
                            min = Math.min(decodeStream.getWidth(), decodeStream.getHeight());
                            Matrix matrix2 = new Matrix();
                            if (min > 360) {
                            }
                            if (i2 != 0) {
                            }
                            Bitmap createBitmap2 = Bitmap.createBitmap(decodeStream, (decodeStream.getWidth() - min) / 2, (decodeStream.getHeight() - min) / 2, min, min, matrix2, true);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            createBitmap2.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream2);
                            bArr = byteArrayOutputStream2.toByteArray();
                            if (bArr == null) {
                            }
                        }
                    } finally {
                    }
                }
                bArr = null;
                if (bArr == null) {
                }
                break;
            case 2:
                C0000a b3 = C0004b.b(C0004b.f409a, "DELETE", "/chat/msg/" + ((K0) this.f325c).f150a, null, 12);
                if (b3.b()) {
                    return;
                }
                C0006b1 c0006b13 = (C0006b1) this.f324b;
                c0006b13.f414a.runOnUiThread(new S(c0006b13, b3, i4));
                return;
            case 3:
                File file = (File) this.f325c;
                Context context = (Context) this.f324b;
                C0018e1 c0018e1 = C0018e1.f459a;
                try {
                    C0018e1.j();
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(5).setContentType(4).build());
                    if (!file.isFile() || file.length() <= 0) {
                        mediaPlayer.setDataSource(context, RingtoneManager.getDefaultUri(2));
                    } else {
                        mediaPlayer.setDataSource(file.getPath());
                    }
                    mediaPlayer.setOnCompletionListener(new C0010c1());
                    mediaPlayer.setOnErrorListener(new C0014d1());
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    C0018e1.f467i = mediaPlayer;
                    C0018e1.f468j.postDelayed(new G(i6, mediaPlayer), 10000L);
                    return;
                } catch (Throwable unused5) {
                    C0018e1.j();
                    return;
                }
            case 4:
                B1 b1 = (B1) this.f325c;
                b1.f38m.clear();
                b1.f38m.addAll((List) this.f324b);
                b1.a();
                return;
            case 5:
                C0000a c0000a2 = (C0000a) this.f325c;
                MainActivity mainActivity = (MainActivity) this.f324b;
                int i9 = MainActivity.R;
                if (!c0000a2.b()) {
                    mainActivity.T(c0000a2.a());
                    return;
                }
                JSONObject c2 = c0000a2.c();
                JSONArray optJSONArray = c2 != null ? c2.optJSONArray("instances") : null;
                File filesDir = mainActivity.getFilesDir();
                JSONObject jSONObject = AbstractC0008c.f438a;
                if (jSONObject != null) {
                    if (optJSONArray == null) {
                        optJSONArray = new JSONArray();
                    }
                    jSONObject.put("instances", optJSONArray);
                    try {
                        g.m.L(new File(filesDir, "c_me.json"), jSONObject.toString());
                    } catch (Exception unused6) {
                    }
                }
                mainActivity.N();
                return;
            case 6:
                int i10 = MainActivity.R;
                s2 s2Var = (s2) this.f325c;
                float height = s2Var.getHeight();
                s2Var.setTranslationY(height);
                s2Var.setVisibility(0);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.setDuration(320L);
                ofFloat.setInterpolator(new DecelerateInterpolator(2.0f));
                ofFloat.addUpdateListener(new J1(s2Var, height, (View) this.f324b));
                ofFloat.start();
                return;
            case 7:
                A2 a2 = (A2) this.f325c;
                a2.setBmp((Bitmap) this.f324b);
                a2.invalidate();
                return;
            case 8:
                G2 g2 = (G2) this.f325c;
                ServerSocket serverSocket = (ServerSocket) this.f324b;
                while (g2.f114d) {
                    try {
                        g2.f113c.execute(new U(g2, serverSocket.accept(), i5));
                    } catch (Exception unused7) {
                        if (!g2.f114d) {
                            return;
                        }
                    }
                }
                return;
            case 9:
                a();
                return;
            default:
                File file2 = (File) this.f324b;
                y2 y2Var = y2.f736a;
                K2 k2 = (K2) this.f325c;
                File file3 = k2.f168b;
                StringBuilder sb = new StringBuilder();
                try {
                    File B = y2.B();
                    sb.append("dataDir: ");
                    sb.append(y2.f().getApplicationInfo().dataDir);
                    sb.append('\n');
                    sb.append("prefix: ");
                    sb.append(y2.C());
                    sb.append('\n');
                    sb.append("ready: ");
                    sb.append(y2.F());
                    sb.append('\n');
                    for (String str3 : c.c.C("node", "npm", "sh")) {
                        File file4 = new File(B, "bin/" + str3);
                        try {
                            str = Files.readSymbolicLink(file4.toPath()).toString();
                        } catch (Exception unused8) {
                            str = "-";
                        }
                        sb.append(str3);
                        sb.append(": exists=");
                        sb.append(file4.exists());
                        sb.append(" exec=");
                        sb.append(file4.canExecute());
                        sb.append(" link=");
                        sb.append(str);
                        sb.append('\n');
                    }
                    File file5 = new File(B, "bin/npm");
                    if (file5.isFile()) {
                        sb.append("npm head: ");
                        try {
                            String readLine = new BufferedReader(new InputStreamReader(new FileInputStream(file5), m.a.f864a), 8192).readLine();
                            if (readLine != null) {
                                str2 = readLine;
                            }
                        } catch (Exception unused9) {
                        }
                        sb.append(str2);
                        sb.append('\n');
                    }
                    ProcessBuilder processBuilder = new ProcessBuilder("/system/bin/sh", "-c", "'" + y2.C() + "/bin/node' -v 2>&1; echo \"npm path: $(command -v npm 2>&1)\"; echo \"NIX_NM=$NIX_NM\"; npm -v 2>&1");
                    processBuilder.directory(file2);
                    y2.a(processBuilder.environment(), file3, file2);
                    processBuilder.redirectErrorStream(true);
                    Process start = processBuilder.start();
                    sb.append(AbstractC0008c.v(new BufferedReader(new InputStreamReader(start.getInputStream(), m.a.f864a), 8192)));
                    start.waitFor();
                } catch (Exception e2) {
                    sb.append("diag error: ");
                    sb.append(e2.getMessage());
                    sb.append('\n');
                }
                k2.a(sb.toString());
                k2.f();
                return;
        }
    }

    public /* synthetic */ U(Object obj, Object obj2, int i2) {
        this.f323a = i2;
        this.f325c = obj;
        this.f324b = obj2;
    }
}
