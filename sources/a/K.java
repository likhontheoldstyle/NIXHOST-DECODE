package a;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.MediaScannerConnection;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.os.Environment;
import android.util.Size;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final /* synthetic */ class K implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f145a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f146b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f147c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f148d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f149e;

    public /* synthetic */ K(C0000a c0000a, L0 l0, C0006b1 c0006b1, K0 k0) {
        this.f145a = 1;
        this.f149e = c0000a;
        this.f146b = l0;
        this.f147c = c0006b1;
        this.f148d = k0;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|1|(5:37|38|39|8|9)|3|4|(1:6)(4:11|(2:12|(1:1)(1:16))|18|(3:21|(2:23|(2:25|(1:27)(1:32))(1:33))(1:34)|(2:29|30)(1:31))(1:20))|7|8|9) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void a() {
        Bitmap loadThumbnail;
        Bitmap bitmap;
        B1 b1 = (B1) this.f148d;
        b1.getClass();
        int i2 = Build.VERSION.SDK_INT;
        C0094z1 c0094z1 = (C0094z1) this.f147c;
        if (i2 >= 29) {
            try {
                loadThumbnail = b1.f26a.getContentResolver().loadThumbnail(c0094z1.f752a, new Size(320, 320), null);
                bitmap = loadThumbnail;
            } catch (Throwable unused) {
            }
            b1.f34i.post(new K((Object) b1, (String) this.f149e, (Object) bitmap, this.f146b, 6));
        }
        boolean z = c0094z1.f753b;
        Bitmap bitmap2 = null;
        String str = c0094z1.f757f;
        if (z) {
            bitmap2 = ThumbnailUtils.createVideoThumbnail(str, 1);
        } else {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i3 = 1;
            while (true) {
                int i4 = i3 * 2;
                if (options.outWidth / i4 < 320 || options.outHeight / i4 < 320) {
                    break;
                } else {
                    i3 = i4;
                }
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = i3;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options2);
            if (decodeFile != null) {
                int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
                int i5 = attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : 270 : 90 : 180;
                if (i5 != 0) {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(i5);
                    bitmap2 = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
                } else {
                    bitmap2 = decodeFile;
                }
            }
        }
        bitmap = bitmap2;
        b1.f34i.post(new K((Object) b1, (String) this.f149e, (Object) bitmap, this.f146b, 6));
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01c4 A[Catch: Exception -> 0x01b2, OutOfMemoryError -> 0x0238, x2 -> 0x023b, TryCatch #14 {x2 -> 0x023b, Exception -> 0x01b2, OutOfMemoryError -> 0x0238, blocks: (B:106:0x018d, B:122:0x01c4, B:123:0x01c7, B:146:0x01d7, B:147:0x01e4, B:149:0x01f8, B:151:0x0211, B:152:0x0214), top: B:105:0x018d }] */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[Catch: Exception -> 0x01b2, OutOfMemoryError -> 0x0238, x2 -> 0x023b, SYNTHETIC, TryCatch #14 {x2 -> 0x023b, Exception -> 0x01b2, OutOfMemoryError -> 0x0238, blocks: (B:106:0x018d, B:122:0x01c4, B:123:0x01c7, B:146:0x01d7, B:147:0x01e4, B:149:0x01f8, B:151:0x0211, B:152:0x0214), top: B:105:0x018d }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x028f A[Catch: Exception -> 0x02c7, TryCatch #14 {Exception -> 0x02c7, blocks: (B:22:0x024f, B:24:0x026b, B:28:0x027c, B:30:0x028f, B:31:0x0294, B:33:0x029a), top: B:21:0x024f }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x02b2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02cf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02af  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        boolean z;
        JSONObject c2;
        Bitmap bitmap;
        K2 k2;
        File file;
        String str;
        String str2;
        String str3;
        String str4;
        String message;
        File file2;
        File B;
        boolean exists;
        boolean z2;
        File[] listFiles;
        boolean z3;
        File B2;
        String str5;
        ArrayList H;
        String str6;
        long j2;
        Iterator it;
        File file3;
        ArrayList arrayList;
        Throwable th;
        boolean z4;
        List list;
        int i2 = 3;
        switch (this.f145a) {
            case 0:
                C0004b c0004b = C0004b.f409a;
                K0 k0 = (K0) this.f148d;
                C0000a b2 = C0004b.b(c0004b, "POST", "/chat/react", new JSONObject().put("msg", k0.f150a).put("emoji", (String) this.f149e), 8);
                C0006b1 c0006b1 = (C0006b1) this.f147c;
                c0006b1.f414a.runOnUiThread(new K(b2, (L0) this.f146b, c0006b1, k0));
                return;
            case 1:
                C0000a c0000a = (C0000a) this.f149e;
                boolean b3 = c0000a.b();
                L0 l0 = (L0) this.f146b;
                if (b3) {
                    l0.f190c = true;
                    l0.f189b = System.currentTimeMillis();
                    return;
                }
                C0006b1 c0006b12 = (C0006b1) this.f147c;
                HashMap hashMap = c0006b12.K0;
                K0 k02 = (K0) this.f148d;
                if (hashMap.get(Long.valueOf(k02.f150a)) == l0) {
                    c0006b12.K0.remove(Long.valueOf(k02.f150a));
                }
                c0006b12.f416c.a(C0006b1.E(c0000a));
                c0006b12.b1();
                return;
            case 2:
                String str7 = (String) this.f149e;
                final C0006b1 c0006b13 = (C0006b1) this.f147c;
                final i.d dVar = new i.d();
                try {
                    File b4 = z2.b(str7);
                    if (b4 != null) {
                        File file4 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "NixHost");
                        file4.mkdirs();
                        File file5 = new File(file4, "NixHost_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date()) + ".jpg");
                        g.m.D(b4, file5, true);
                        MediaScannerConnection.scanFile(c0006b13.f414a, new String[]{file5.getPath()}, new String[]{"image/jpeg"}, null);
                        dVar.f846a = file5.length() > 0;
                    }
                } catch (Exception unused) {
                }
                Activity activity = c0006b13.f414a;
                final RunnableC0064q runnableC0064q = (RunnableC0064q) ((Runnable) this.f146b);
                final TextView textView = (TextView) this.f148d;
                final int i3 = 0;
                activity.runOnUiThread(new Runnable() { // from class: a.Z
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i3) {
                            case 0:
                                String str8 = dVar.f846a ? "Downloaded" : "Could not save the photo";
                                RunnableC0064q runnableC0064q2 = (RunnableC0064q) runnableC0064q;
                                TextView textView2 = textView;
                                textView2.setText(str8);
                                textView2.setVisibility(0);
                                C0006b1 c0006b14 = c0006b13;
                                c0006b14.f418e.removeCallbacks(runnableC0064q2);
                                c0006b14.f418e.postDelayed(runnableC0064q2, 2400L);
                                break;
                            default:
                                C0006b1.h0((RunnableC0064q) runnableC0064q, c0006b13, textView, dVar.f846a ? "Downloaded" : "Could not save the video");
                                break;
                        }
                    }
                });
                return;
            case 3:
                File file6 = (File) this.f148d;
                final C0006b1 c0006b14 = (C0006b1) this.f147c;
                final i.d dVar2 = new i.d();
                try {
                    File file7 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES), "NixHost");
                    file7.mkdirs();
                    File file8 = new File(file7, "NixHost_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date()) + ".mp4");
                    g.m.D(file6, file8, true);
                    MediaScannerConnection.scanFile(c0006b14.f414a, new String[]{file8.getPath()}, new String[]{"video/mp4"}, null);
                    dVar2.f846a = file8.length() > 0;
                } catch (Exception unused2) {
                }
                Activity activity2 = c0006b14.f414a;
                final RunnableC0064q runnableC0064q2 = (RunnableC0064q) ((Runnable) this.f146b);
                final TextView textView2 = (TextView) this.f149e;
                final int i4 = 1;
                activity2.runOnUiThread(new Runnable() { // from class: a.Z
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i4) {
                            case 0:
                                String str8 = dVar2.f846a ? "Downloaded" : "Could not save the photo";
                                RunnableC0064q runnableC0064q22 = (RunnableC0064q) runnableC0064q2;
                                TextView textView22 = textView2;
                                textView22.setText(str8);
                                textView22.setVisibility(0);
                                C0006b1 c0006b142 = c0006b14;
                                c0006b142.f418e.removeCallbacks(runnableC0064q22);
                                c0006b142.f418e.postDelayed(runnableC0064q22, 2400L);
                                break;
                            default:
                                C0006b1.h0((RunnableC0064q) runnableC0064q2, c0006b14, textView2, dVar2.f846a ? "Downloaded" : "Could not save the video");
                                break;
                        }
                    }
                });
                return;
            case 4:
                C0006b1 c0006b15 = (C0006b1) this.f147c;
                c0006b15.H = false;
                if (c0006b15.G) {
                    C0000a c0000a2 = (C0000a) this.f148d;
                    if (c0000a2.f400a == 401) {
                        c0006b15.f417d.a();
                        return;
                    }
                    JSONObject c3 = c0000a2.c();
                    if (c0000a2.f400a == 0) {
                        if (c0006b15.N != 2 || System.currentTimeMillis() - c0006b15.O > 8000) {
                            c0006b15.K0(1);
                            return;
                        }
                        return;
                    }
                    if (c0006b15.N != 0) {
                        c0006b15.K0(0);
                        if (c0006b15.F.isEmpty()) {
                            c0006b15.U();
                        }
                    }
                    if (!c0000a2.b() || c3 == null) {
                        if (c0006b15.L) {
                            return;
                        }
                        c0006b15.M = c0000a2.a();
                        c0006b15.i1();
                        return;
                    }
                    c0006b15.M = "";
                    boolean z5 = !c0006b15.L;
                    c0006b15.L = true;
                    if (z5) {
                        JSONArray optJSONArray = c3.optJSONArray("msgs");
                        if ((optJSONArray != null ? optJSONArray.length() : 0) < 40) {
                            c0006b15.I = false;
                        }
                    }
                    long optLong = c3.optLong("cl", 0L);
                    String s2 = c0006b15.s();
                    SharedPreferences sharedPreferences = AbstractC0008c.f440c;
                    if (sharedPreferences == null) {
                        i.b.g("sp");
                        throw null;
                    }
                    String string = sharedPreferences.getString(s2, "0");
                    Long D = m.l.D(string != null ? string : "0");
                    long longValue = D != null ? D.longValue() : 0L;
                    if (optLong > longValue) {
                        c0006b15.d(optLong);
                    } else if (optLong < longValue) {
                        String s3 = c0006b15.s();
                        String valueOf = String.valueOf(optLong);
                        SharedPreferences sharedPreferences2 = AbstractC0008c.f440c;
                        if (sharedPreferences2 == null) {
                            i.b.g("sp");
                            throw null;
                        }
                        sharedPreferences2.edit().putString(s3, valueOf).apply();
                    }
                    int b5 = c0006b15.b(c3.optJSONArray("msgs"));
                    boolean g2 = c0006b15.g(c3);
                    c0006b15.e(c3);
                    c0006b15.i(c3);
                    JSONArray optJSONArray2 = c3.optJSONArray("ty");
                    ArrayList arrayList2 = new ArrayList();
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i5 = 0; i5 < length; i5++) {
                            String optString = optJSONArray2.optString(i5);
                            if (!i.b.a(optString, c0006b15.f415b)) {
                                arrayList2.add(optString);
                            }
                        }
                    }
                    if (!arrayList2.equals(c0006b15.G0)) {
                        c0006b15.G0 = arrayList2;
                        c0006b15.i1();
                    }
                    C0000a c0000a3 = (C0000a) this.f149e;
                    JSONObject c4 = c0000a3.c();
                    JSONObject optJSONObject = c4 != null ? c4.optJSONObject("seen") : null;
                    if (!c0000a3.b() || optJSONObject == null) {
                        z = false;
                    } else {
                        Iterator<String> keys = optJSONObject.keys();
                        z = false;
                        while (keys.hasNext()) {
                            String next = keys.next();
                            long optLong2 = optJSONObject.optLong(next);
                            HashMap hashMap2 = c0006b15.m0;
                            Long l2 = (Long) hashMap2.get(next);
                            if (l2 == null || l2.longValue() != optLong2) {
                                hashMap2.put(next, Long.valueOf(optLong2));
                                z = true;
                            }
                        }
                    }
                    C0000a c0000a4 = (C0000a) this.f146b;
                    JSONArray optJSONArray3 = (c0000a4 == null || (c2 = c0000a4.c()) == null) ? null : c2.optJSONArray("online");
                    if ((c0000a4 != null && c0000a4.b()) && optJSONArray3 != null) {
                        HashSet hashSet = new HashSet();
                        int length2 = optJSONArray3.length();
                        for (int i6 = 0; i6 < length2; i6++) {
                            hashSet.add(optJSONArray3.optString(i6));
                        }
                        HashSet hashSet2 = c0006b15.p0;
                        if (!hashSet.equals(hashSet2)) {
                            hashSet2.clear();
                            hashSet2.addAll(hashSet);
                            z = true;
                        }
                    }
                    if (b5 > 0 || g2 || z5 || z) {
                        c0006b15.w0();
                        c0006b15.x0(z5);
                        if (b5 > 0 || g2 || z5) {
                            c0006b15.B0();
                        }
                    }
                    if (z5) {
                        I2 i22 = c0006b15.W;
                        if (i22 == null) {
                            i.b.g("lv");
                            throw null;
                        }
                        i22.post(new RunnableC0048m(c0006b15, 0));
                    }
                    ArrayList arrayList3 = c0006b15.O0;
                    if ((!arrayList3.isEmpty()) && !c0006b15.Q0 && !arrayList3.isEmpty()) {
                        c0006b15.Q0 = true;
                        new Thread(new RunnableC0048m(c0006b15, i2)).start();
                    }
                    if (!c0006b15.D.isEmpty()) {
                        final long T = c0006b15.T();
                        if (T > c0006b15.o0) {
                            c0006b15.o0 = T;
                            new Thread(new Runnable() { // from class: a.n
                                @Override // java.lang.Runnable
                                public final void run() {
                                    C0004b.f409a.c(T);
                                }
                            }).start();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                a();
                return;
            case 6:
                B1 b1 = (B1) this.f148d;
                HashSet hashSet3 = b1.f37l;
                String str8 = (String) this.f149e;
                hashSet3.remove(str8);
                Bitmap bitmap2 = (Bitmap) this.f147c;
                if (bitmap2 != null) {
                    b1.f36k.put(str8, bitmap2);
                    C0082v1 c0082v1 = (C0082v1) this.f146b;
                    if (i.b.a(c0082v1.f687f, str8)) {
                        c0082v1.f682a.setImageBitmap(bitmap2);
                        return;
                    }
                    return;
                }
                return;
            case 7:
                ImageView imageView = (ImageView) this.f148d;
                Object tag = imageView.getTag();
                String str9 = (String) this.f149e;
                if (!i.b.a(tag, str9) || (bitmap = (Bitmap) this.f147c) == null) {
                    return;
                }
                z2.f763f.put(str9, Float.valueOf(bitmap.getWidth() / bitmap.getHeight()));
                imageView.setImageBitmap(bitmap);
                h.b bVar = (h.b) this.f146b;
                if (bVar != null) {
                    bVar.a(bitmap);
                    return;
                }
                return;
            default:
                List list2 = (List) this.f148d;
                K2 k22 = (K2) this.f147c;
                File file9 = (File) this.f146b;
                String str10 = (String) this.f149e;
                String str11 = "Stopped.";
                y2 y2Var = y2.f736a;
                I0 i0 = new I0(2, k22);
                C0001a0 c0001a0 = new C0001a0(3, k22);
                try {
                    B2 = y2.B();
                    if (!y2.F()) {
                        y2.R(B2);
                    }
                    new File(B2, "var/cache/nixpkg").mkdirs();
                    y2.u();
                    b.b s4 = y2.s();
                    str5 = (String) s4.f764a;
                    H = y2.H((Map) s4.f765b, (ArrayList) list2, y2.E(B2));
                    str6 = "clang?";
                } catch (x2 unused3) {
                    k2 = k22;
                    file = file9;
                    str = "";
                } catch (Exception e2) {
                    e = e2;
                    k2 = k22;
                    file = file9;
                    str = "";
                } catch (OutOfMemoryError unused4) {
                    k2 = k22;
                    file = file9;
                    str = "";
                }
                if (H.isEmpty()) {
                    y2.n(B2, new ArrayList());
                    y2.u();
                    if (list2.contains("clang?")) {
                        y2.v();
                    }
                    file = file9;
                    str4 = "";
                    str = str4;
                    str2 = str10;
                    str3 = "Stopped.";
                    k22.f179m = false;
                    if (str4.length() == 0 && !k22.f180n) {
                        y2 y2Var2 = y2.f736a;
                        try {
                            B = y2.B();
                            exists = new File(B, "bin/python3").exists();
                        } catch (Exception unused5) {
                        }
                        if (!new File(B, "bin/pip").exists() && !new File(B, "bin/pip3").exists()) {
                            z2 = false;
                            listFiles = new File(B, "lib").listFiles(new t2(1));
                            if (listFiles == null) {
                                i.a a2 = i.j.a(listFiles);
                                z3 = false;
                                while (a2.hasNext()) {
                                    if (new File((File) a2.next(), "site-packages/setuptools").isDirectory()) {
                                        z3 = true;
                                    }
                                }
                            } else {
                                z3 = false;
                            }
                            if (exists && z2 && !z3) {
                                k22.f176j = "Installing setuptools...";
                                L2.f198a.c();
                                file2 = file;
                                k22.e(file2, "python3 -m pip install --no-warn-script-location --disable-pip-version-check setuptools");
                                if (str4.length() != 0 && str2 != null && !k22.f180n) {
                                    String str12 = str2;
                                    k22.f176j = k22.f182r.b(str12) ? "Installing packages..." : str;
                                    L2.f198a.c();
                                    k22.e(file2, str12);
                                } else if (str4.length() != 0) {
                                    k22.a("Done.\n");
                                } else if (!str4.equals(str3)) {
                                    k22.a(str4.concat("\n"));
                                }
                                k22.f();
                                return;
                            }
                        }
                        z2 = true;
                        listFiles = new File(B, "lib").listFiles(new t2(1));
                        if (listFiles == null) {
                        }
                        if (exists) {
                            k22.f176j = "Installing setuptools...";
                            L2.f198a.c();
                            file2 = file;
                            k22.e(file2, "python3 -m pip install --no-warn-script-location --disable-pip-version-check setuptools");
                            if (str4.length() != 0) {
                            }
                            if (str4.length() != 0) {
                            }
                            k22.f();
                            return;
                        }
                    }
                    file2 = file;
                    if (str4.length() != 0) {
                    }
                    if (str4.length() != 0) {
                    }
                    k22.f();
                    return;
                }
                i.f fVar = new i.f();
                Iterator it2 = H.iterator();
                while (true) {
                    long j3 = 1000000;
                    if (!it2.hasNext()) {
                        String str13 = str6;
                        String str14 = str5;
                        i.f fVar2 = new i.f();
                        i.e eVar = new i.e();
                        eVar.f847a = -1;
                        str = "";
                        try {
                            y2.o(fVar2, fVar, eVar, c0001a0, 0.0d);
                            ArrayList arrayList4 = new ArrayList();
                            Iterator it3 = H.iterator();
                            while (it3.hasNext()) {
                                w2 w2Var = (w2) it3.next();
                                if (((Boolean) i0.a()).booleanValue()) {
                                    throw new x2();
                                }
                                k2 = k22;
                                file = file9;
                                try {
                                    j2 = w2Var.f702f;
                                    it = it3;
                                    if (j2 <= 0) {
                                        j2 = 1000000;
                                    }
                                    arrayList = arrayList4;
                                    String str15 = w2Var.f697a;
                                    StringBuilder sb = new StringBuilder();
                                    str3 = str11;
                                    try {
                                        sb.append("var/cache/nixpkg/");
                                        sb.append(str15);
                                        sb.append(".deb");
                                        file3 = new File(B2, sb.toString());
                                        try {
                                            list = list2;
                                            str2 = str10;
                                            try {
                                                y2.g(str14, w2Var, file3, i0, new u2(j2, fVar2, fVar, eVar, c0001a0));
                                                try {
                                                    y2.o(fVar2, fVar, eVar, c0001a0, j2 * 0.6d);
                                                    y2.p(file3, B2, arrayList, i0);
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    z4 = true;
                                                    if (z4) {
                                                        throw th;
                                                    }
                                                    file3.delete();
                                                    throw th;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                th = th;
                                                z4 = false;
                                                if (z4) {
                                                }
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                        }
                                    } catch (x2 unused6) {
                                        str2 = str10;
                                    } catch (Exception e3) {
                                        e = e3;
                                        str2 = str10;
                                    } catch (OutOfMemoryError unused7) {
                                        str2 = str10;
                                    }
                                } catch (x2 unused8) {
                                    str2 = str10;
                                    str3 = str11;
                                    k22 = k2;
                                    str4 = str3;
                                    k22.f179m = false;
                                    if (str4.length() == 0) {
                                    }
                                    file2 = file;
                                    if (str4.length() != 0) {
                                    }
                                    if (str4.length() != 0) {
                                    }
                                    k22.f();
                                    return;
                                } catch (Exception e4) {
                                    e = e4;
                                    str2 = str10;
                                    str3 = str11;
                                    message = e.getMessage();
                                    if (message == null) {
                                        message = e.getClass().getSimpleName();
                                    }
                                    str4 = "Failed: ".concat(message);
                                    k22 = k2;
                                    k22.f179m = false;
                                    if (str4.length() == 0) {
                                    }
                                    file2 = file;
                                    if (str4.length() != 0) {
                                    }
                                    if (str4.length() != 0) {
                                    }
                                    k22.f();
                                    return;
                                } catch (OutOfMemoryError unused9) {
                                    str2 = str10;
                                    str3 = str11;
                                    str4 = "Failed: out of memory";
                                    k22 = k2;
                                    k22.f179m = false;
                                    if (str4.length() == 0) {
                                    }
                                    file2 = file;
                                    if (str4.length() != 0) {
                                    }
                                    if (str4.length() != 0) {
                                    }
                                    k22.f();
                                    return;
                                }
                                try {
                                    file3.delete();
                                    y2.t(B2, w2Var);
                                    fVar2.f848a += j2;
                                    y2.o(fVar2, fVar, eVar, c0001a0, 0.0d);
                                    arrayList4 = arrayList;
                                    k22 = k2;
                                    file9 = file;
                                    it3 = it;
                                    str11 = str3;
                                    str10 = str2;
                                    list2 = list;
                                } catch (x2 unused10) {
                                    k22 = k2;
                                    str4 = str3;
                                    k22.f179m = false;
                                    if (str4.length() == 0) {
                                    }
                                    file2 = file;
                                    if (str4.length() != 0) {
                                    }
                                    if (str4.length() != 0) {
                                    }
                                    k22.f();
                                    return;
                                } catch (Exception e5) {
                                    e = e5;
                                    message = e.getMessage();
                                    if (message == null) {
                                    }
                                    str4 = "Failed: ".concat(message);
                                    k22 = k2;
                                    k22.f179m = false;
                                    if (str4.length() == 0) {
                                    }
                                    file2 = file;
                                    if (str4.length() != 0) {
                                    }
                                    if (str4.length() != 0) {
                                    }
                                    k22.f();
                                    return;
                                } catch (OutOfMemoryError unused11) {
                                    str4 = "Failed: out of memory";
                                    k22 = k2;
                                    k22.f179m = false;
                                    if (str4.length() == 0) {
                                    }
                                    file2 = file;
                                    if (str4.length() != 0) {
                                    }
                                    if (str4.length() != 0) {
                                    }
                                    k22.f();
                                    return;
                                }
                            }
                            k2 = k22;
                            file = file9;
                            str2 = str10;
                            str3 = str11;
                            y2.n(B2, arrayList4);
                            y2.u();
                            if (list2.contains(str13)) {
                                y2.v();
                            }
                            c0001a0.a(100);
                            str4 = str;
                        } catch (x2 unused12) {
                            k2 = k22;
                            file = file9;
                        } catch (Exception e6) {
                            e = e6;
                            k2 = k22;
                            file = file9;
                        } catch (OutOfMemoryError unused13) {
                            k2 = k22;
                            file = file9;
                        }
                        k22 = k2;
                        k22.f179m = false;
                        if (str4.length() == 0) {
                            y2 y2Var22 = y2.f736a;
                            B = y2.B();
                            exists = new File(B, "bin/python3").exists();
                            if (!new File(B, "bin/pip").exists()) {
                                z2 = false;
                                listFiles = new File(B, "lib").listFiles(new t2(1));
                                if (listFiles == null) {
                                }
                                if (exists) {
                                }
                            }
                            z2 = true;
                            listFiles = new File(B, "lib").listFiles(new t2(1));
                            if (listFiles == null) {
                            }
                            if (exists) {
                            }
                        }
                        file2 = file;
                        if (str4.length() != 0) {
                        }
                        if (str4.length() != 0) {
                        }
                        k22.f();
                        return;
                    }
                    w2 w2Var2 = (w2) it2.next();
                    String str16 = str6;
                    String str17 = str5;
                    long j4 = fVar.f848a;
                    long j5 = w2Var2.f702f;
                    if (j5 > 0) {
                        j3 = j5;
                    }
                    fVar.f848a = j4 + j3;
                    str6 = str16;
                    str5 = str17;
                }
        }
    }

    public /* synthetic */ K(RunnableC0064q runnableC0064q, C0006b1 c0006b1, TextView textView, String str) {
        this.f145a = 2;
        this.f149e = str;
        this.f147c = c0006b1;
        this.f148d = textView;
        this.f146b = runnableC0064q;
    }

    public /* synthetic */ K(C0006b1 c0006b1, C0000a c0000a, C0000a c0000a2, C0000a c0000a3) {
        this.f145a = 4;
        this.f147c = c0006b1;
        this.f148d = c0000a;
        this.f149e = c0000a2;
        this.f146b = c0000a3;
    }

    public /* synthetic */ K(Object obj, Object obj2, Object obj3, Object obj4, int i2) {
        this.f145a = i2;
        this.f148d = obj;
        this.f147c = obj2;
        this.f149e = obj3;
        this.f146b = obj4;
    }

    public /* synthetic */ K(Object obj, String str, Object obj2, Object obj3, int i2) {
        this.f145a = i2;
        this.f148d = obj;
        this.f149e = str;
        this.f147c = obj2;
        this.f146b = obj3;
    }

    public /* synthetic */ K(ArrayList arrayList, K2 k2, File file, String str) {
        this.f145a = 8;
        this.f148d = arrayList;
        this.f147c = k2;
        this.f146b = file;
        this.f149e = str;
    }
}
