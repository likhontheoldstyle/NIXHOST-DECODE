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

/* renamed from: a.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0056o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f605a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f606b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f607c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f608d;

    public /* synthetic */ RunnableC0056o(C0000a c0000a, C0006b1 c0006b1, String str) {
        this.f605a = 3;
        this.f607c = c0000a;
        this.f606b = c0006b1;
        this.f608d = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:0x0246, code lost:
    
        r5 = "";
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        final String str;
        String canonicalPath;
        ZipFile zipFile;
        char c2;
        char c3;
        String str2;
        FileOutputStream fileOutputStream;
        String str3;
        SharedPreferences sharedPreferences;
        final String message;
        Bitmap a2;
        final int i2 = 1;
        final int i3 = 0;
        switch (this.f605a) {
            case 0:
                File file = z2.f758a;
                File b2 = z2.b((String) this.f608d);
                C0006b1 c0006b1 = (C0006b1) this.f606b;
                c0006b1.f414a.runOnUiThread(new RunnableC0056o((Object) c0006b1, this.f607c, (Object) b2, 1, false));
                return;
            case 1:
                C0006b1 c0006b12 = (C0006b1) this.f606b;
                long j2 = c0006b12.m1;
                long j3 = ((K0) this.f607c).f150a;
                if (j2 != j3) {
                    return;
                }
                c0006b12.m1 = Long.MIN_VALUE;
                File file2 = (File) this.f608d;
                if (file2 != null) {
                    c0006b12.e1(j3, file2);
                    return;
                }
                C1 c1 = (C1) c0006b12.j1.get(Long.valueOf(j3));
                if (c1 != null) {
                    c1.set("play");
                }
                c0006b12.f416c.a(c0006b12.e0() ? "No internet connection" : "Couldn't load the voice message, try again");
                return;
            case 2:
                C0006b1 c0006b13 = (C0006b1) this.f606b;
                c.h.G(c0006b13.D, new C0001a0(i3, (M0) this.f607c));
                C0000a c0000a = (C0000a) this.f608d;
                if (c0000a.f400a == 401) {
                    c0006b13.f417d.a();
                    return;
                }
                if (c0000a.b()) {
                    JSONObject c4 = c0000a.c();
                    r4 = c4 != null ? c4.optJSONObject("msg") : null;
                    if (r4 != null) {
                        c0006b13.b(new JSONArray().put(r4));
                    }
                } else {
                    c0006b13.f416c.a(C0006b1.E(c0000a));
                }
                c0006b13.w0();
                c0006b13.x0(true);
                return;
            case 3:
                C0000a c0000a2 = (C0000a) this.f607c;
                boolean b3 = c0000a2.b();
                C0006b1 c0006b14 = (C0006b1) this.f606b;
                if (!b3) {
                    JSONObject c5 = c0000a2.c();
                    long optLong = c5 != null ? c5.optLong("nat", 0L) : 0L;
                    if (c0000a2.f400a == 429 && optLong > 0) {
                        c0006b14.d0(optLong);
                        C0029h0 c0029h0 = c0006b14.y1;
                        if (c0029h0 != null) {
                            c0029h0.a();
                        }
                    }
                    c0006b14.f416c.a(C0006b1.E(c0000a2));
                    return;
                }
                c0006b14.t0.put(c0006b14.f415b, (String) this.f608d);
                JSONObject c6 = c0000a2.c();
                c0006b14.d0(c6 != null ? c6.optLong("nat", System.currentTimeMillis()) : System.currentTimeMillis());
                c0006b14.B0();
                O0 o0 = c0006b14.j0;
                if (o0 == null) {
                    i.b.g("adapter");
                    throw null;
                }
                o0.notifyDataSetChanged();
                c0006b14.i1();
                C0029h0 c0029h02 = c0006b14.y1;
                if (c0029h02 != null) {
                    c0029h02.a();
                    return;
                }
                return;
            case 4:
                final File file3 = (File) this.f608d;
                File file4 = (File) this.f606b;
                int i4 = MainActivity.R;
                try {
                    file3.mkdirs();
                    canonicalPath = file3.getCanonicalPath();
                    zipFile = new ZipFile(file4);
                } catch (Exception e2) {
                    String message2 = e2.getMessage();
                    if (message2 == null) {
                        message2 = "failed";
                    }
                    str = message2;
                }
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    String str4 = null;
                    while (true) {
                        c2 = '\\';
                        c3 = '/';
                        str = "";
                        if (entries.hasMoreElements()) {
                            String I = m.m.I(entries.nextElement().getName(), '\\', '/');
                            if (I.length() != 0 && !m.m.K(I, "__MACOSX/")) {
                                int P = m.e.P(I, '/', 0, false, 6);
                                if (P < 0) {
                                    break;
                                } else {
                                    String substring = I.substring(0, P);
                                    i.b.d(substring, "substring(...)");
                                    if (str4 == null) {
                                        str4 = substring;
                                    } else if (!str4.equals(substring)) {
                                        break;
                                    }
                                }
                            }
                        } else if (str4 != null) {
                            str2 = str4 + "/";
                        }
                    }
                    byte[] bArr = new byte[65536];
                    Enumeration<? extends ZipEntry> entries2 = zipFile.entries();
                    while (entries2.hasMoreElements()) {
                        ZipEntry nextElement = entries2.nextElement();
                        String I2 = m.m.I(nextElement.getName(), c2, c3);
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
                                                        AbstractC0008c.a(fileOutputStream, null);
                                                        AbstractC0008c.a(inputStream, null);
                                                    }
                                                } finally {
                                                }
                                            }
                                        } finally {
                                        }
                                    }
                                }
                                c2 = '\\';
                                c3 = '/';
                            }
                        }
                    }
                    AbstractC0008c.a(zipFile, null);
                    final MainActivity mainActivity = (MainActivity) this.f607c;
                    mainActivity.runOnUiThread(new Runnable() { // from class: a.V1
                        @Override // java.lang.Runnable
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
                                    mainActivity2.T(concat);
                                    if (i.b.a(mainActivity2.f784d, "files")) {
                                        mainActivity2.L();
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
                                    mainActivity2.T(concat2);
                                    if (i.b.a(mainActivity2.f784d, "files")) {
                                        mainActivity2.L();
                                        break;
                                    }
                                    break;
                            }
                        }
                    });
                    return;
                } finally {
                }
            case 5:
                C0000a c0000a3 = (C0000a) this.f606b;
                MainActivity mainActivity2 = (MainActivity) this.f607c;
                String str5 = (String) this.f608d;
                int i5 = MainActivity.R;
                if (!c0000a3.b()) {
                    mainActivity2.T(c0000a3.a());
                    return;
                }
                L2 l2 = L2.f198a;
                String str6 = mainActivity2.f785e + "-" + str5;
                synchronized (l2) {
                    try {
                        K2 k2 = (K2) L2.f199b.remove(str6);
                        if (k2 != null) {
                            try {
                                k2.h();
                            } catch (Exception unused) {
                            }
                        }
                        if (k2 == null) {
                            k2 = new K2(new File("/"), new File("/"), l2.f(str6));
                        }
                        k2.t();
                        try {
                            str3 = "draft_" + str6;
                            sharedPreferences = AbstractC0008c.f440c;
                        } catch (Exception unused2) {
                        }
                        if (sharedPreferences == null) {
                            i.b.g("sp");
                            throw null;
                        }
                        sharedPreferences.edit().remove(str3).apply();
                    } finally {
                    }
                }
                JSONObject c7 = c0000a3.c();
                r4 = c7 != null ? c7.optJSONArray("instances") : null;
                File filesDir = mainActivity2.getFilesDir();
                JSONObject jSONObject = AbstractC0008c.f438a;
                if (jSONObject != null) {
                    if (r4 == null) {
                        r4 = new JSONArray();
                    }
                    jSONObject.put("instances", r4);
                    try {
                        g.m.L(new File(filesDir, "c_me.json"), jSONObject.toString());
                    } catch (Exception unused3) {
                    }
                }
                mainActivity2.N();
                return;
            case 6:
                final MainActivity mainActivity3 = (MainActivity) this.f608d;
                Uri uri = (Uri) this.f606b;
                final File file5 = (File) this.f607c;
                int i6 = MainActivity.R;
                try {
                    InputStream openInputStream = mainActivity3.getContentResolver().openInputStream(uri);
                    if (openInputStream != null) {
                        try {
                            fileOutputStream = new FileOutputStream(file5);
                            try {
                                AbstractC0008c.e(openInputStream, fileOutputStream, 65536);
                                AbstractC0008c.a(fileOutputStream, null);
                                AbstractC0008c.a(openInputStream, null);
                            } finally {
                            }
                        } finally {
                        }
                    }
                    message = "";
                } catch (Exception e3) {
                    try {
                        file5.delete();
                    } catch (Exception unused4) {
                    }
                    message = e3.getMessage();
                    if (message == null) {
                        message = "failed";
                    }
                }
                mainActivity3.runOnUiThread(new Runnable() { // from class: a.V1
                    @Override // java.lang.Runnable
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
                                mainActivity22.T(concat);
                                if (i.b.a(mainActivity22.f784d, "files")) {
                                    mainActivity22.L();
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
                                mainActivity22.T(concat2);
                                if (i.b.a(mainActivity22.f784d, "files")) {
                                    mainActivity22.L();
                                    break;
                                }
                                break;
                        }
                    }
                });
                return;
            case 7:
                int i7 = MainActivity.R;
                final LinearLayout linearLayout = (LinearLayout) this.f608d;
                final float height = linearLayout.getHeight();
                linearLayout.setTranslationY(height);
                linearLayout.setVisibility(0);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.setDuration(380L);
                ofFloat.setInterpolator(new DecelerateInterpolator(2.0f));
                final FrameLayout frameLayout = (FrameLayout) ((View) this.f607c);
                final View view = (View) this.f606b;
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: a.p2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
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
                File file6 = (File) this.f606b;
                boolean exists = file6.exists();
                Handler handler = z2.f761d;
                A2 a22 = (A2) this.f607c;
                if (exists && (a2 = z2.a(file6, 300)) != null) {
                    handler.post(new U(a22, a2, 7));
                }
                String str7 = (String) this.f608d;
                byte[] g2 = C0004b.g(str7);
                if (g2 != null) {
                    try {
                        g.m.K(file6, g2);
                    } catch (Exception unused5) {
                    }
                }
                if (g2 != null && file6.exists()) {
                    r4 = z2.a(file6, 300);
                }
                if (r4 != null) {
                    handler.post(new RunnableC0056o(str7, r4, a22, 9));
                    return;
                }
                return;
            case 9:
                HashMap hashMap = z2.f762e;
                String str8 = (String) this.f608d;
                Bitmap bitmap = (Bitmap) this.f606b;
                hashMap.put(str8, bitmap);
                A2 a23 = (A2) this.f607c;
                a23.setBmp(bitmap);
                a23.invalidate();
                return;
            default:
                K2 k22 = (K2) this.f606b;
                k22.e((File) this.f607c, (String) this.f608d);
                k22.f();
                return;
        }
    }

    public /* synthetic */ RunnableC0056o(Object obj, Object obj2, Object obj3, int i2) {
        this.f605a = i2;
        this.f608d = obj;
        this.f606b = obj2;
        this.f607c = obj3;
    }

    public /* synthetic */ RunnableC0056o(Object obj, Object obj2, Object obj3, int i2, byte b2) {
        this.f605a = i2;
        this.f606b = obj;
        this.f608d = obj2;
        this.f607c = obj3;
    }

    public /* synthetic */ RunnableC0056o(Object obj, Object obj2, Object obj3, int i2, boolean z) {
        this.f605a = i2;
        this.f606b = obj;
        this.f607c = obj2;
        this.f608d = obj3;
    }
}
