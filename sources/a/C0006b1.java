package a;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.media.AudioManager;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.nix.host.MainActivity;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: a.b1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0006b1 {
    public FrameLayout A;
    public LinearLayout A0;
    public long A1;
    public LinearLayout B;
    public FrameLayout B0;
    public final long B1;
    public Dialog C;
    public C1 C0;
    public final String C1;
    public final ArrayList D;
    public TextView D0;
    public long D1;
    public final HashMap E;
    public ArrayList E0;
    public List F;
    public final X0 F0;
    public boolean G;
    public List G0;
    public boolean H;
    public long H0;
    public boolean I;
    public boolean I0;
    public boolean J;
    public final b.c J0;
    public boolean K;
    public final HashMap K0;
    public boolean L;
    public final long L0;
    public String M;
    public long M0;
    public int N;
    public boolean N0;
    public long O;
    public final ArrayList O0;
    public LinearLayout P;
    public final ExecutorService P0;
    public FrameLayout Q;
    public boolean Q0;
    public TextView R;
    public final HashSet R0;
    public C0002a1 S;
    public boolean S0;
    public K0 T;
    public Uri T0;
    public long U;
    public String U0;
    public boolean V;
    public MediaRecorder V0;
    public I2 W;
    public File W0;
    public TextView X;
    public long X0;
    public ProgressBar Y;
    public int Y0;
    public TextView Z;
    public int Z0;

    /* renamed from: a, reason: collision with root package name */
    public final Activity f414a;
    public TextView a0;
    public File a1;

    /* renamed from: b, reason: collision with root package name */
    public final String f415b;
    public LinearLayout b0;
    public final ArrayList b1;

    /* renamed from: c, reason: collision with root package name */
    public final h.b f416c;
    public View c0;
    public P2 c1;

    /* renamed from: d, reason: collision with root package name */
    public final h.a f417d;
    public TextView d0;
    public TextView d1;

    /* renamed from: e, reason: collision with root package name */
    public final Handler f418e = new Handler(Looper.getMainLooper());
    public TextView e0;
    public boolean e1;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f419f;
    public FrameLayout f0;
    public final X0 f1;

    /* renamed from: g, reason: collision with root package name */
    public final int f420g;
    public LinearLayout g0;
    public MediaPlayer g1;

    /* renamed from: h, reason: collision with root package name */
    public final int f421h;
    public EditText h0;
    public long h1;

    /* renamed from: i, reason: collision with root package name */
    public final int f422i;
    public LinearLayout i0;
    public final HashMap i1;

    /* renamed from: j, reason: collision with root package name */
    public final int f423j;
    public O0 j0;
    public final HashMap j1;

    /* renamed from: k, reason: collision with root package name */
    public final int f424k;
    public final float k0;
    public final X0 k1;

    /* renamed from: l, reason: collision with root package name */
    public final int f425l;
    public final HashMap l0;
    public float l1;

    /* renamed from: m, reason: collision with root package name */
    public final int f426m;
    public final HashMap m0;
    public long m1;

    /* renamed from: n, reason: collision with root package name */
    public final int f427n;
    public final HashMap n0;
    public final HashMap n1;

    /* renamed from: o, reason: collision with root package name */
    public final int f428o;
    public long o0;
    public final ExecutorService o1;
    public final int p;
    public final HashSet p0;
    public final HashSet p1;
    public final List q;
    public long q0;
    public float q1;

    /* renamed from: r, reason: collision with root package name */
    public final int f429r;
    public long r0;
    public float r1;

    /* renamed from: s, reason: collision with root package name */
    public final int f430s;
    public long s0;
    public int s1;

    /* renamed from: t, reason: collision with root package name */
    public final int f431t;
    public final HashMap t0;
    public boolean t1;

    /* renamed from: u, reason: collision with root package name */
    public final int f432u;
    public String u0;
    public J2 u1;

    /* renamed from: v, reason: collision with root package name */
    public final int f433v;
    public String v0;
    public K0 v1;
    public C0022f1 w;
    public A2 w0;
    public long w1;
    public long x;
    public TextView x0;
    public long x1;
    public int y;
    public FrameLayout y0;
    public C0029h0 y1;
    public C0011c2 z;
    public FrameLayout z0;
    public boolean z1;

    public C0006b1(Activity activity, String str, C0001a0 c0001a0, K1 k1) {
        int i2 = 1;
        this.f414a = activity;
        this.f415b = str;
        this.f416c = c0001a0;
        this.f417d = k1;
        boolean z = AbstractC0008c.f442e;
        this.f419f = z;
        this.f420g = -16226561;
        this.f421h = z ? -13793025 : -15173646;
        this.f422i = z ? -14276823 : -1;
        this.f423j = z ? -13421773 : -986379;
        this.f424k = z ? -12895170 : -986379;
        this.f425l = z ? -920842 : -16448251;
        this.f426m = z ? -5196872 : -10131605;
        this.f427n = z ? -12697534 : -1775893;
        this.f428o = z ? -13289674 : -3420978;
        this.p = z ? -10131092 : -2960427;
        this.q = c.c.C("❤️", "😆", "😮", "😢", "😠", "👍");
        this.f429r = z ? -14408410 : -1;
        this.f430s = z ? -12960964 : -1775893;
        this.f431t = z ? -11559440 : -15173646;
        this.f432u = -45715;
        this.f433v = z ? -12895170 : -1775893;
        List list = AbstractC0026g1.f511a;
        SharedPreferences sharedPreferences = AbstractC0008c.f440c;
        if (sharedPreferences == null) {
            i.b.g("sp");
            throw null;
        }
        String string = sharedPreferences.getString("chat_theme", "");
        this.w = AbstractC0026g1.a(string == null ? "" : string);
        this.D = new ArrayList();
        this.E = new HashMap();
        c.j jVar = c.j.f773a;
        this.F = jVar;
        this.I = true;
        this.M = "";
        this.V = true;
        this.k0 = 250.0f;
        this.l0 = new HashMap();
        this.m0 = new HashMap();
        this.n0 = new HashMap();
        this.p0 = new HashSet();
        this.t0 = new HashMap();
        this.u0 = "";
        this.v0 = "";
        this.F0 = new X0(this, 1);
        this.G0 = jVar;
        this.J0 = new b.c(new C0(i2));
        this.K0 = new HashMap();
        this.L0 = 4611686018427387903L;
        this.O0 = new ArrayList();
        this.P0 = Executors.newSingleThreadExecutor();
        this.R0 = new HashSet();
        this.U0 = "idle";
        this.b1 = new ArrayList();
        this.f1 = new X0(this, 2);
        this.h1 = Long.MIN_VALUE;
        this.i1 = new HashMap();
        this.j1 = new HashMap();
        this.k1 = new X0(this, 0);
        this.l1 = 1.0f;
        this.m1 = Long.MIN_VALUE;
        this.n1 = new HashMap();
        this.o1 = Executors.newSingleThreadExecutor();
        this.p1 = new HashSet();
        this.w1 = Long.MIN_VALUE;
        this.B1 = 604800000L;
        this.C1 = "aryan";
    }

    public static final boolean A(EditText editText, String str) {
        String obj = m.e.h0(editText.getText().toString()).toString();
        return obj.length() > 0 && !obj.equals(m.e.h0(str).toString());
    }

    public static ArrayList A0(List list) {
        if (list.isEmpty()) {
            ArrayList arrayList = new ArrayList(48);
            for (int i2 = 0; i2 < 48; i2++) {
                arrayList.add(5);
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        while (i3 < 48) {
            int size = (list.size() * i3) / 48;
            i3++;
            int min = Math.min(Math.max(size + 1, (list.size() * i3) / 48), list.size());
            int i4 = 0;
            while (size < min) {
                i4 = Math.max(i4, ((Number) list.get(size)).intValue());
                size++;
            }
            arrayList2.add(Integer.valueOf(i4));
        }
        return arrayList2;
    }

    public static final void B(FrameLayout frameLayout, C0006b1 c0006b1, C1 c1, EditText editText, String str) {
        if (A(editText, str)) {
            c0006b1.getClass();
            frameLayout.setBackground(i0(-13793025));
            c1.f53b = c0006b1.f419f ? -14934495 : -1;
            c1.invalidate();
            return;
        }
        c0006b1.getClass();
        frameLayout.setBackground(i0(-3091496));
        c1.f53b = -11907758;
        c1.invalidate();
    }

    public static boolean D(String str) {
        String obj = m.e.h0(str).toString();
        if (obj.length() == 0 || obj.length() > 12) {
            return false;
        }
        int i2 = 0;
        while (i2 < obj.length()) {
            int codePointAt = obj.codePointAt(i2);
            if (codePointAt != 8205 && codePointAt != 65039 && codePointAt < 8592) {
                return false;
            }
            i2 += Character.charCount(codePointAt);
        }
        return true;
    }

    public static String E(C0000a c0000a) {
        return c0000a.f400a == 0 ? "No internet" : c0000a.a();
    }

    public static String G(int i2) {
        int i3 = (i2 + 500) / 1000;
        return (i3 / 60) + ":" + m.e.U(String.valueOf(i3 % 60));
    }

    public static boolean N(K0 k0) {
        String str = k0.f152c;
        if (i.b.a(str, "sys")) {
            return false;
        }
        if (k0.f159j) {
            return true;
        }
        if (i.b.a(str, "like")) {
            return false;
        }
        return (i.b.a(str, "text") && D(k0.f153d)) ? false : true;
    }

    public static final void Q0(LinearLayout linearLayout, List list, i.g gVar, C0006b1 c0006b1, LinearLayout linearLayout2, LinkedHashMap linkedHashMap, Dialog dialog, K0 k0, int i2) {
        linearLayout.removeAllViews();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b.b bVar = (b.b) it.next();
            if (((CharSequence) gVar.f850b).length() <= 0 || i.b.a(bVar.f765b, gVar.f850b)) {
                LinearLayout P = c0006b1.P();
                float f2 = 9;
                P.setPadding(c0006b1.z(16), c0006b1.z(f2), c0006b1.z(20), c0006b1.z(f2));
                P.addView(c0006b1.k((String) bVar.f764a, 50.0f), X(c0006b1, c0006b1.z(50.0f), c0006b1.z(50.0f), 0, 0, 14, 32));
                LinearLayout k1 = c0006b1.k1();
                Object obj = bVar.f764a;
                String x = c0006b1.x((String) obj);
                int i3 = c0006b1.f425l;
                k1.addView(c0006b1.f1(x, 20.0f, i3, true));
                String str = c0006b1.f415b;
                if (i.b.a(obj, str)) {
                    k1.addView(c0006b1.f1("Tap to remove", 16.0f, c0006b1.f426m, false));
                }
                P.addView(k1, new LinearLayout.LayoutParams(0, -2, 1.0f));
                P.addView(c0006b1.f1((String) bVar.f765b, 30.0f, i3, false));
                if (i.b.a(obj, str)) {
                    P.setOnClickListener(new H(dialog, c0006b1, k0, 0));
                }
                linearLayout.addView(P, X(c0006b1, -1, -2, 0, 0, 0, 60));
            }
        }
        linearLayout2.removeAllViews();
        R0(c0006b1, gVar, i2, linearLayout2, linearLayout, list, linkedHashMap, dialog, k0, "All", list.size(), "");
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            R0(c0006b1, gVar, i2, linearLayout2, linearLayout, list, linkedHashMap, dialog, k0, str2, ((Number) entry.getValue()).intValue(), str2);
        }
    }

    public static final void R0(final C0006b1 c0006b1, final i.g gVar, final int i2, final LinearLayout linearLayout, final LinearLayout linearLayout2, final List list, final LinkedHashMap linkedHashMap, final Dialog dialog, final K0 k0, String str, int i3, final String str2) {
        LinearLayout P = c0006b1.P();
        float f2 = 18;
        float f3 = 7;
        P.setPadding(c0006b1.z(f2), c0006b1.z(f3), c0006b1.z(f2), c0006b1.z(f3));
        if (i.b.a(gVar.f850b, str2)) {
            P.setBackground(c0006b1.N0(i2, 30.0f, 0, 0.0f));
        }
        boolean a2 = i.b.a(gVar.f850b, str2);
        int i4 = c0006b1.f425l;
        int i5 = a2 ? i4 : c0006b1.f426m;
        if (str2.length() == 0) {
            P.addView(c0006b1.f1(str, 20.0f, i5, true));
        } else {
            P.addView(c0006b1.f1(str, 26.0f, i4, false));
            P.addView(c0006b1.f1(String.valueOf(i3), 20.0f, i5, false), c0006b1.W(-2, -2, 6, 0, 0, 0));
        }
        P.setOnClickListener(new View.OnClickListener() { // from class: a.Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.g gVar2 = i.g.this;
                gVar2.f850b = str2;
                C0006b1.Q0(linearLayout2, list, gVar2, c0006b1, linearLayout, linkedHashMap, dialog, k0, i2);
            }
        });
        linearLayout.addView(P, X(c0006b1, -2, -2, 0, 0, 8, 32));
    }

    public static String V0(float f2) {
        return f2 >= 2.0f ? "2x" : f2 >= 1.5f ? "1.5x" : "1x";
    }

    public static /* synthetic */ LinearLayout.LayoutParams X(C0006b1 c0006b1, int i2, int i3, int i4, int i5, int i6, int i7) {
        return c0006b1.W(i2, i3, (i7 & 4) != 0 ? 0 : i4, (i7 & 8) != 0 ? 0 : i5, (i7 & 16) != 0 ? 0 : i6, 0);
    }

    public static void Z0(String str) {
        if (str.length() == 0) {
            SharedPreferences sharedPreferences = AbstractC0008c.f440c;
            if (sharedPreferences != null) {
                sharedPreferences.edit().remove("qr_all").apply();
                return;
            } else {
                i.b.g("sp");
                throw null;
            }
        }
        SharedPreferences sharedPreferences2 = AbstractC0008c.f440c;
        if (sharedPreferences2 != null) {
            sharedPreferences2.edit().putString("qr_all", str).apply();
        } else {
            i.b.g("sp");
            throw null;
        }
    }

    public static String c0() {
        return "L".concat(m.e.g0(14, m.m.J(UUID.randomUUID().toString(), "-", "")));
    }

    public static final void c1(LinearLayout linearLayout, C0006b1 c0006b1, TextView textView, boolean z, int i2) {
        c0006b1.getClass();
        LinearLayout.LayoutParams W = c0006b1.W(-2, -2, 0, i2, 0, 0);
        W.gravity = z ? 8388613 : 8388611;
        linearLayout.addView(textView, W);
    }

    public static final void g0(C0006b1 c0006b1, LinearLayout linearLayout) {
        int i2 = 0;
        linearLayout.removeAllViews();
        A2 a2 = new A2(c0006b1.f414a);
        if (c0006b1.v0.length() > 0) {
            File file = z2.f758a;
            z2.f(a2, c0006b1.v0);
        }
        float f2 = 106;
        LinearLayout.LayoutParams W = c0006b1.W(c0006b1.z(f2), c0006b1.z(f2), 0, 2, 0, 0);
        W.gravity = 1;
        linearLayout.addView(a2, W);
        String str = c0006b1.u0.length() == 0 ? "NixHost Group" : c0006b1.u0;
        int i3 = c0006b1.f425l;
        TextView f1 = c0006b1.f1(str, 29.0f, i3, true);
        f1.setGravity(17);
        float f3 = 20;
        f1.setPadding(c0006b1.z(f3), 0, c0006b1.z(f3), 0);
        linearLayout.addView(f1, c0006b1.W(-1, -2, 0, 12, 0, 0));
        boolean R = c0006b1.R();
        int i4 = c0006b1.f430s;
        int i5 = R ? c0006b1.f419f ? -14272175 : -1575937 : i4;
        LinearLayout k1 = c0006b1.k1();
        k1.setGravity(1);
        Activity activity = c0006b1.f414a;
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setBackground(i0(i5));
        String str2 = R ? "bellmute" : "bell";
        int i6 = c0006b1.f420g;
        C1 M = c0006b1.M(str2, R ? i6 : i3, 26);
        M.setCut(i5);
        float f4 = 26;
        frameLayout.addView(M, new FrameLayout.LayoutParams(c0006b1.z(f4), c0006b1.z(f4), 17));
        float f5 = 53;
        k1.addView(frameLayout, new LinearLayout.LayoutParams(c0006b1.z(f5), c0006b1.z(f5)));
        String str3 = R ? "Unmute" : "Mute";
        if (!R) {
            i6 = i3;
        }
        k1.addView(c0006b1.f1(str3, 16.0f, i6, true), c0006b1.W(-2, -2, 0, 6, 0, 0));
        k1.setOnClickListener(new ViewOnClickListenerC0072s0(c0006b1, linearLayout, i2));
        LinearLayout.LayoutParams W2 = c0006b1.W(-2, -2, 0, 28, 0, 0);
        W2.gravity = 1;
        linearLayout.addView(k1, W2);
        linearLayout.addView(c0006b1.D0(24, "Users"));
        String str4 = c0006b1.f415b;
        linearLayout.addView(c0006b1.M0(c0006b1.k(str4, 38), "Profile photo", null, new C0036j(c0006b1, 14)));
        long Z = c0006b1.Z();
        long currentTimeMillis = (c0006b1.B1 + Z) - System.currentTimeMillis();
        linearLayout.addView(c0006b1.M0(c0006b1.r(i3, "editf"), c0006b1.x(str4), (Z <= 0 || currentTimeMillis <= 0) ? "Change name" : J0.a("You can change it again in ", w(currentTimeMillis)), new C0036j(c0006b1, 15)));
        linearLayout.addView(c0006b1.D0(12, "Actions"));
        linearLayout.addView(c0006b1.M0(c0006b1.r(i3, "people"), "See members", null, new C0036j(c0006b1, 16)));
        if (m.m.F(str4, c0006b1.C1)) {
            linearLayout.addView(c0006b1.M0(c0006b1.r(c0006b1.f432u, "trashf"), "Clear group data", null, new C0036j(c0006b1, 17)));
        }
        linearLayout.addView(c0006b1.D0(12, "Customization"));
        linearLayout.addView(c0006b1.M0(c0006b1.r(i3, "themes"), "Themes", c0006b1.w.f482b, new C0036j(c0006b1, 18)));
        FrameLayout frameLayout2 = new FrameLayout(activity);
        frameLayout2.setBackground(i0(i4));
        String p0 = p0();
        if (p0.length() == 0) {
            float f6 = 22;
            frameLayout2.addView(c0006b1.M("like", c0006b1.f421h, 22), new FrameLayout.LayoutParams(c0006b1.z(f6), c0006b1.z(f6), 17));
        } else {
            TextView textView = new TextView(activity);
            textView.setText(p0);
            textView.setTextSize(1, 19.53f);
            textView.setGravity(17);
            frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1, 17));
        }
        linearLayout.addView(c0006b1.M0(frameLayout2, "Quick reaction", null, new C0029h0(c0006b1, linearLayout)));
        linearLayout.addView(c0006b1.D0(12, "Privacy & support"));
        linearLayout.addView(c0006b1.M0(c0006b1.r(i3, "gear"), "Coming soon", null, new C0036j(c0006b1, 19)));
        linearLayout.addView(new View(activity), X(c0006b1, -1, c0006b1.z(36), 0, 0, 0, 60));
    }

    public static final void h0(RunnableC0064q runnableC0064q, C0006b1 c0006b1, TextView textView, String str) {
        textView.setText(str);
        textView.setVisibility(0);
        c0006b1.f418e.removeCallbacks(runnableC0064q);
        c0006b1.f418e.postDelayed(runnableC0064q, 2400L);
    }

    public static GradientDrawable i0(int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i2);
        return gradientDrawable;
    }

    public static b.b j1(String str, byte[] bArr) {
        C0000a c0000a;
        String str2;
        String str3 = "";
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                break;
            }
            if (C0004b.f410b.length() == 0) {
                c0000a = new C0000a(0, "");
            } else {
                try {
                    URLConnection openConnection = new URL(C0004b.f410b + "/chat/media?kind=" + str).openConnection();
                    i.b.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                    HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.setReadTimeout(60000);
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
                } catch (Exception unused) {
                    c0000a = new C0000a(0, "");
                }
            }
            JSONObject c2 = c0000a.c();
            if (c2 == null || (str2 = c2.optString("id")) == null) {
                str2 = "";
            }
            if (c0000a.b() && str2.length() > 0) {
                return new b.b(str2, "");
            }
            String E = E(c0000a);
            int i3 = c0000a.f400a;
            if (i3 != 0 && i3 < 500) {
                str3 = E;
                break;
            }
            try {
                Thread.sleep(800L);
            } catch (Exception unused2) {
            }
            i2++;
            str3 = E;
        }
        return new b.b("", str3);
    }

    public static K0 k0(JSONObject jSONObject) {
        JSONArray optJSONArray;
        String optString;
        String optString2;
        String optString3;
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("m");
        if (optJSONArray2 != null) {
            int length = optJSONArray2.length();
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(optJSONArray2.optString(i2));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("w");
        if (optJSONArray3 != null) {
            int length2 = optJSONArray3.length();
            for (int i3 = 0; i3 < length2; i3++) {
                arrayList2.add(Integer.valueOf(optJSONArray3.optInt(i3)));
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("rp");
        K0 k0 = new K0(jSONObject.optLong("id"), jSONObject.optString("u"), jSONObject.optString("t"), jSONObject.optString("x"), arrayList, arrayList2, jSONObject.optInt("d"), jSONObject.optLong("re"), jSONObject.optLong("ts"), jSONObject.optInt("del") == 1, (optJSONObject == null || (optString3 = optJSONObject.optString("u")) == null) ? "" : optString3, (optJSONObject == null || (optString2 = optJSONObject.optString("t")) == null) ? "" : optString2, (optJSONObject == null || (optString = optJSONObject.optString("x")) == null) ? "" : optString, (optJSONObject != null ? optJSONObject.optInt("del") : 0) == 1, jSONObject.optInt("ed"));
        ArrayList arrayList3 = new ArrayList();
        if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("m")) != null) {
            int length3 = optJSONArray.length();
            for (int i4 = 0; i4 < length3; i4++) {
                arrayList3.add(optJSONArray.optString(i4));
            }
        }
        k0.p = arrayList3;
        return k0;
    }

    public static void m0(C0006b1 c0006b1, String str, String str2, C0090y0 c0090y0, int i2) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13 = (i2 & 2) != 0 ? "" : str2;
        c.j jVar = c.j.f773a;
        C0090y0 c0090y02 = (i2 & 32) != 0 ? null : c0090y0;
        c0006b1.getClass();
        JSONObject put = new JSONObject().put("type", str).put("text", str13).put("media", new JSONArray((Collection) jVar)).put("wave", new JSONArray((Collection) jVar)).put("dur", 0);
        K0 k0 = c0006b1.T;
        if (k0 != null) {
            str3 = "type";
            put.put("reply", k0.f150a);
        } else {
            str3 = "type";
        }
        c0006b1.L0(null);
        int i3 = c0006b1.N;
        ArrayList arrayList = c0006b1.D;
        ArrayList arrayList2 = c0006b1.O0;
        long j2 = c0006b1.L0;
        if (i3 != 1 && !(!arrayList2.isEmpty())) {
            long j3 = c0006b1.M0 + 1;
            c0006b1.M0 = j3;
            long j4 = j2 + j3;
            arrayList.add(new K0(j4, c0006b1.f415b, str, str13, new ArrayList(), new ArrayList(jVar), 0, k0 != null ? k0.f150a : 0L, System.currentTimeMillis(), (k0 == null || (str12 = k0.f151b) == null) ? "" : str12, (k0 == null || (str11 = k0.f152c) == null) ? "" : str11, (k0 == null || (str10 = k0.f153d) == null) ? "" : str10, k0 != null ? k0.f159j : false));
            c0006b1.Y(j4);
            c0006b1.w0();
            c0006b1.x0(true);
            c0006b1.P0.execute(new RunnableC0040k(put, c0006b1, j4, k0, c0090y02));
            return;
        }
        long j5 = c0006b1.M0 + 1;
        c0006b1.M0 = j5;
        long j6 = j5 + j2;
        ArrayList arrayList3 = new ArrayList();
        JSONArray optJSONArray = put.optJSONArray("media");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                arrayList3.add(optJSONArray.optString(i4));
            }
        }
        ArrayList arrayList4 = new ArrayList();
        JSONArray optJSONArray2 = put.optJSONArray("wave");
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i5 = 0; i5 < length2; i5++) {
                arrayList4.add(Integer.valueOf(optJSONArray2.optInt(i5)));
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        arrayList.add(new K0(j6, c0006b1.f415b, put.optString(str3), put.optString("text"), arrayList3, arrayList4, put.optInt("dur"), k0 != null ? k0.f150a : 0L, currentTimeMillis, (k0 == null || (str9 = k0.f151b) == null) ? "" : str9, (k0 == null || (str8 = k0.f152c) == null) ? "" : str8, (k0 == null || (str7 = k0.f153d) == null) ? "" : str7, k0 != null ? k0.f159j : false));
        c0006b1.Y(j6);
        arrayList2.add(new M0(j6, put, currentTimeMillis, (k0 == null || (str6 = k0.f151b) == null) ? "" : str6, (k0 == null || (str5 = k0.f152c) == null) ? "" : str5, (k0 == null || (str4 = k0.f153d) == null) ? "" : str4, k0 != null ? k0.f159j : false));
        c0006b1.C0();
        c0006b1.w0();
        c0006b1.x0(true);
    }

    public static void n0(View view, h.a aVar) {
        view.setOnClickListener(new ViewOnClickListenerC0044l(aVar, 3));
    }

    public static String p0() {
        SharedPreferences sharedPreferences = AbstractC0008c.f440c;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("qr_all", "");
            return string == null ? "" : string;
        }
        i.b.g("sp");
        throw null;
    }

    public static String r0(String str, String str2, boolean z) {
        return z ? "Message deleted" : i.b.a(str, "voice") ? "Audio 📎" : i.b.a(str, "image") ? "Attachment 📎" : i.b.a(str, "video") ? "Video 📎" : i.b.a(str, "like") ? "👍" : str2;
    }

    public static final void v0(ArrayList arrayList, String str, List list) {
        if (list.isEmpty()) {
            return;
        }
        arrayList.add(str);
        int i2 = 0;
        while (i2 < list.size()) {
            int i3 = i2 + 5;
            arrayList.add(c.b.Q(list.subList(i2, Math.min(i3, list.size()))));
            i2 = i3;
        }
    }

    public static String w(long j2) {
        int i2 = (int) ((j2 + 86399999) / 86400000);
        if (i2 < 1) {
            i2 = 1;
        }
        if (i2 == 1) {
            return "1 day";
        }
        return i2 + " days";
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x021f A[Catch: Exception -> 0x0232, TryCatch #0 {Exception -> 0x0232, blocks: (B:3:0x0008, B:4:0x0013, B:6:0x0019, B:9:0x0025, B:14:0x0029, B:18:0x0030, B:20:0x0038, B:21:0x0047, B:22:0x0055, B:25:0x005d, B:27:0x0070, B:29:0x00cc, B:30:0x00ee, B:32:0x0101, B:34:0x0109, B:35:0x0112, B:37:0x0118, B:39:0x0133, B:45:0x0141, B:46:0x014e, B:48:0x0154, B:51:0x0170, B:55:0x0182, B:58:0x018a, B:59:0x0199, B:61:0x019f, B:63:0x01b9, B:65:0x01f7, B:69:0x0203, B:71:0x021f, B:73:0x022b, B:74:0x0231), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x022b A[Catch: Exception -> 0x0232, TryCatch #0 {Exception -> 0x0232, blocks: (B:3:0x0008, B:4:0x0013, B:6:0x0019, B:9:0x0025, B:14:0x0029, B:18:0x0030, B:20:0x0038, B:21:0x0047, B:22:0x0055, B:25:0x005d, B:27:0x0070, B:29:0x00cc, B:30:0x00ee, B:32:0x0101, B:34:0x0109, B:35:0x0112, B:37:0x0118, B:39:0x0133, B:45:0x0141, B:46:0x014e, B:48:0x0154, B:51:0x0170, B:55:0x0182, B:58:0x018a, B:59:0x0199, B:61:0x019f, B:63:0x01b9, B:65:0x01f7, B:69:0x0203, B:71:0x021f, B:73:0x022b, B:74:0x0231), top: B:2:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void B0() {
        boolean z;
        SharedPreferences sharedPreferences;
        try {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.D.iterator();
            while (it.hasNext()) {
                K0 k0 = (K0) it.next();
                if (!S(k0)) {
                    arrayList.add(k0);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            List subList = arrayList.size() > 60 ? arrayList.subList(arrayList.size() - 60, arrayList.size()) : arrayList;
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            Iterator it2 = subList.iterator();
            while (it2.hasNext()) {
                K0 k02 = (K0) it2.next();
                JSONObject jSONObject2 = new JSONObject();
                long j2 = k02.f150a;
                JSONArray jSONArray2 = jSONArray;
                long j3 = k02.f157h;
                Iterator it3 = it2;
                JSONObject put = jSONObject2.put("id", j2).put("u", k02.f151b).put("t", k02.f152c).put("x", k02.f153d).put("m", new JSONArray((Collection) k02.f154e)).put("w", new JSONArray((Collection) k02.f155f)).put("d", k02.f156g).put("re", j3).put("ts", k02.f158i).put("del", k02.f159j ? 1 : 0).put("ed", k02.f164o);
                if (j3 > 0) {
                    put.put("rp", new JSONObject().put("u", k02.f160k).put("t", k02.f161l).put("x", k02.f162m).put("del", k02.f163n ? 1 : 0));
                }
                jSONArray2.put(put);
                List<b.b> list = (List) this.E.get(Long.valueOf(j2));
                if (list != null && (!list.isEmpty())) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (b.b bVar : list) {
                        jSONArray3.put(new JSONArray().put(bVar.f764a).put(bVar.f765b));
                    }
                    jSONObject.put(String.valueOf(j2), jSONArray3);
                }
                jSONArray = jSONArray2;
                it2 = it3;
            }
            JSONArray jSONArray4 = jSONArray;
            JSONArray jSONArray5 = new JSONArray();
            for (String str : this.F) {
                JSONObject put2 = new JSONObject().put("u", str);
                String str2 = (String) this.t0.get(str);
                if (str2 == null) {
                    str2 = str;
                }
                JSONObject put3 = put2.put("n", str2);
                String str3 = (String) this.l0.get(str);
                if (str3 == null) {
                    str3 = "";
                }
                jSONArray5.put(put3.put("p", str3));
            }
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry entry : this.m0.entrySet()) {
                jSONObject3.put((String) entry.getKey(), ((Number) entry.getValue()).longValue());
            }
            JSONObject put4 = new JSONObject().put("msgs", jSONArray4).put("r", jSONObject).put("mem", jSONArray5).put("seen", jSONObject3).put("g", new JSONObject().put("name", this.u0).put("pic", this.v0));
            if (!this.I && arrayList.size() <= 60) {
                z = false;
                JSONObject put5 = put4.put("more", z);
                String str4 = "chatcache_" + this.f415b;
                String jSONObject4 = put5.toString();
                sharedPreferences = AbstractC0008c.f440c;
                if (sharedPreferences == null) {
                    sharedPreferences.edit().putString(str4, jSONObject4).apply();
                    return;
                } else {
                    i.b.g("sp");
                    throw null;
                }
            }
            z = true;
            JSONObject put52 = put4.put("more", z);
            String str42 = "chatcache_" + this.f415b;
            String jSONObject42 = put52.toString();
            sharedPreferences = AbstractC0008c.f440c;
            if (sharedPreferences == null) {
            }
        } catch (Exception unused) {
        }
    }

    public final List C() {
        ArrayList arrayList = this.E0;
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            TextPaint textPaint = new TextPaint();
            String str = null;
            for (String str2 : m.e.T(AbstractC0008c.v(new BufferedReader(new InputStreamReader(this.f414a.getAssets().open("data/emoji.txt"), m.a.f864a), 8192)))) {
                if (m.m.K(str2, "# ")) {
                    str = str2.substring(2);
                    i.b.d(str, "substring(...)");
                } else if (!m.e.R(str2)) {
                    List b0 = m.e.b0(str2, new String[]{" "});
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj : b0) {
                        String str3 = (String) obj;
                        if (str3.length() > 0 && textPaint.hasGlyph(str3)) {
                            arrayList3.add(obj);
                        }
                    }
                    if (!arrayList3.isEmpty()) {
                        if (str != null) {
                            arrayList2.add(str);
                            str = null;
                        }
                        int i2 = 0;
                        while (i2 < arrayList3.size()) {
                            int i3 = i2 + 7;
                            arrayList2.add(c.b.Q(arrayList3.subList(i2, Math.min(i3, arrayList3.size()))));
                            i2 = i3;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        this.E0 = arrayList2;
        return arrayList2;
    }

    public final void C0() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.O0) {
            Iterator it = this.O0.iterator();
            while (it.hasNext()) {
                M0 m0 = (M0) it.next();
                jSONArray.put(new JSONObject().put("b", m0.f208b).put("ts", m0.f209c).put("u", m0.f210d).put("t", m0.f211e).put("x", m0.f212f).put("d", m0.f213g));
            }
        }
        if (jSONArray.length() == 0) {
            String str = "outbox_" + this.f415b;
            SharedPreferences sharedPreferences = AbstractC0008c.f440c;
            if (sharedPreferences != null) {
                sharedPreferences.edit().remove(str).apply();
                return;
            } else {
                i.b.g("sp");
                throw null;
            }
        }
        String str2 = "outbox_" + this.f415b;
        String jSONArray2 = jSONArray.toString();
        SharedPreferences sharedPreferences2 = AbstractC0008c.f440c;
        if (sharedPreferences2 != null) {
            sharedPreferences2.edit().putString(str2, jSONArray2).apply();
        } else {
            i.b.g("sp");
            throw null;
        }
    }

    public final TextView D0(int i2, String str) {
        TextView f1 = f1(str, 15.5f, this.f425l, true);
        f1.setPadding(z(21), z(i2), z(20), z(13));
        return f1;
    }

    public final void E0(long j2, String str, List list, int i2, K0 k0, List list2) {
        JSONObject put = new JSONObject().put("type", str).put("text", "").put("media", new JSONArray((Collection) list)).put("wave", new JSONArray((Collection) list2)).put("dur", i2);
        if (k0 != null) {
            put.put("reply", k0.f150a);
        }
        if (this.N == 1 || (!this.O0.isEmpty())) {
            d1(j2, put, k0);
        } else {
            new Thread(new RunnableC0093z0(put, this, j2, k0)).start();
        }
    }

    public final void F() {
        if (this.I && !this.J && this.L && (!this.D.isEmpty())) {
            I2 i2 = this.W;
            if (i2 == null) {
                i.b.g("lv");
                throw null;
            }
            if (i2.canScrollVertically(-1)) {
                return;
            }
            I2 i22 = this.W;
            if (i22 == null) {
                i.b.g("lv");
                throw null;
            }
            if (i22.canScrollVertically(1)) {
                return;
            }
            V();
        }
    }

    public final void F0(List list) {
        K0 k0 = this.T;
        L0(null);
        ArrayList arrayList = new ArrayList(c.d.E(list));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(c0());
        }
        new Thread(new RunnableC0040k(list, this, arrayList, a("image", arrayList, 0, k0, c.j.f773a), k0)).start();
    }

    public final void G0(Uri uri) {
        K0 k0 = this.T;
        L0(null);
        String c0 = c0();
        new Thread(new RunnableC0040k(this, uri, c0, a("video", AbstractC0008c.p(c0), 0, k0, c.j.f773a), k0)).start();
    }

    public final b.b H() {
        Dialog dialog = new Dialog(this.f414a, R.style.Theme.Black.NoTitleBar);
        LinearLayout k1 = k1();
        int i2 = this.f422i;
        k1.setBackgroundColor(i2);
        dialog.setContentView(k1, new ViewGroup.LayoutParams(-1, -1));
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(i2));
            window.setLayout(-1, -1);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i2);
            window.setNavigationBarColor(i2);
            if (!this.f419f) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8208);
            }
        }
        return new b.b(dialog, k1);
    }

    public final void H0() {
        byte[] bArr;
        File file = this.W0;
        if (file == null) {
            return;
        }
        X0();
        final ArrayList A0 = A0(this.b1);
        final int i2 = this.Y0;
        this.W0 = null;
        this.U0 = "idle";
        P0();
        try {
            bArr = g.m.G(file);
        } catch (Exception unused) {
            bArr = null;
        }
        file.delete();
        if (bArr == null) {
            this.f416c.a("Could not read the recording");
            return;
        }
        final K0 k0 = this.T;
        L0(null);
        String c0 = c0();
        try {
            g.m.K(z2.c(c0), bArr);
        } catch (Exception unused2) {
        }
        final long a2 = a("voice", AbstractC0008c.p(c0), i2, k0, A0);
        final byte[] bArr2 = bArr;
        new Thread(new Runnable() { // from class: a.x0
            @Override // java.lang.Runnable
            public final void run() {
                final C0006b1 c0006b1 = C0006b1.this;
                c0006b1.getClass();
                final byte[] bArr3 = bArr2;
                final b.b j1 = C0006b1.j1("voice", bArr3);
                final ArrayList arrayList = (ArrayList) A0;
                final long j2 = a2;
                final int i3 = i2;
                final K0 k02 = k0;
                c0006b1.f414a.runOnUiThread(new Runnable() { // from class: a.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        byte[] bArr4 = bArr3;
                        b.b bVar = b.b.this;
                        Object obj = bVar.f764a;
                        int length = ((CharSequence) obj).length();
                        C0006b1 c0006b12 = c0006b1;
                        long j3 = j2;
                        if (length <= 0) {
                            c0006b12.z0(j3);
                            c0006b12.f416c.a(bVar.f765b);
                            return;
                        }
                        try {
                            File file2 = z2.f758a;
                            g.m.K(z2.c((String) obj), bArr4);
                        } catch (Exception unused3) {
                        }
                        c0006b12.E0(j3, "voice", AbstractC0008c.p(obj), i3, k02, arrayList);
                    }
                });
            }
        }).start();
    }

    public final int I() {
        return L() ? this.w.f489i : this.f421h;
    }

    public final void I0(Uri uri) {
        if (e0()) {
            this.f416c.a("No internet connection");
        } else {
            new Thread(new U(this, uri)).start();
        }
    }

    public final int J() {
        return L() ? this.w.f487g : this.f425l;
    }

    public final void J0(View view, final K0 k0) {
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: a.H0
            /* JADX WARN: Code restructure failed: missing block: B:12:0x0042, code lost:
            
                if (r2 != null) goto L16;
             */
            @Override // android.view.View.OnLongClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final boolean onLongClick(View view2) {
                final String str;
                Object obj;
                final C0006b1 c0006b1 = C0006b1.this;
                c0006b1.getClass();
                final K0 k02 = k0;
                String str2 = k02.f151b;
                String str3 = c0006b1.f415b;
                final boolean a2 = i.b.a(str2, str3);
                List list = (List) c0006b1.E.get(Long.valueOf(k02.f150a));
                if (list != null) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (i.b.a(((b.b) obj).f764a, str3)) {
                            break;
                        }
                    }
                    b.b bVar = (b.b) obj;
                    if (bVar != null) {
                        str = (String) bVar.f765b;
                    }
                }
                str = "";
                c0006b1.l(false, new h.c() { // from class: a.J
                    @Override // h.c
                    public final Object a(Object obj2, Object obj3) {
                        K0 k03;
                        Activity activity;
                        final C0006b1 c0006b12;
                        final K0 k04;
                        LinearLayout linearLayout = (LinearLayout) obj2;
                        final Dialog dialog = (Dialog) obj3;
                        C0006b1 c0006b13 = C0006b1.this;
                        LinearLayout P = c0006b13.P();
                        int i2 = 17;
                        P.setGravity(17);
                        float f2 = 4;
                        P.setPadding(c0006b13.z(f2), c0006b13.z(8), c0006b13.z(f2), c0006b13.z(10));
                        Iterator it2 = c0006b13.q.iterator();
                        while (true) {
                            boolean hasNext = it2.hasNext();
                            k03 = k02;
                            activity = c0006b13.f414a;
                            if (!hasNext) {
                                break;
                            }
                            String str4 = (String) it2.next();
                            TextView textView = new TextView(activity);
                            textView.setText(str4);
                            textView.setTextSize(1, 31.62f);
                            textView.setGravity(i2);
                            String str5 = str;
                            if (i.b.a(str4, str5)) {
                                textView.setBackground(C0006b1.i0(c0006b13.f419f ? -14272175 : -1575937));
                            }
                            textView.setOnClickListener(new V(dialog, c0006b13, k03, str4, str5));
                            P.addView(textView, new LinearLayout.LayoutParams(0, c0006b13.z(52), 1.0f));
                            i2 = 17;
                        }
                        FrameLayout frameLayout = new FrameLayout(activity);
                        FrameLayout frameLayout2 = new FrameLayout(activity);
                        frameLayout2.setBackground(C0006b1.i0(c0006b13.f430s));
                        float f3 = 22;
                        frameLayout2.addView(new G1(activity, "plus", c0006b13.f425l, 2.4f), new FrameLayout.LayoutParams(c0006b13.z(f3), c0006b13.z(f3), 17));
                        frameLayout2.setOnClickListener(new H(dialog, c0006b13, k03, 1));
                        float f4 = 40;
                        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(c0006b13.z(f4), c0006b13.z(f4), 17));
                        P.addView(frameLayout, new LinearLayout.LayoutParams(0, c0006b13.z(52), 1.0f));
                        linearLayout.addView(P, C0006b1.X(c0006b13, -1, -2, 0, 0, 0, 60));
                        linearLayout.addView(c0006b13.y());
                        linearLayout.addView(new View(activity), new LinearLayout.LayoutParams(-1, c0006b13.z(6)));
                        boolean a3 = i.b.a(k03.f152c, "text");
                        if (a3) {
                            c0006b12 = c0006b13;
                            k04 = k03;
                            c0006b13.O0(linearLayout, "copyf", "Copy", c0006b13.f425l, new W(dialog, c0006b13, k03, 0));
                        } else {
                            c0006b12 = c0006b13;
                            k04 = k03;
                        }
                        final boolean z = a2;
                        if (z && a3) {
                            c0006b12.O0(linearLayout, "editf", "Edit", c0006b12.f425l, new W(dialog, c0006b12, k04, 1));
                        }
                        c0006b12.O0(linearLayout, "replyf", "Reply", c0006b12.f425l, new W(dialog, c0006b12, k04, 2));
                        c0006b12.O0(linearLayout, "trashf", z ? "Delete" : "Delete for me", c0006b12.f432u, new h.a() { // from class: a.X
                            @Override // h.a
                            public final Object a() {
                                dialog.dismiss();
                                boolean z2 = z;
                                C0006b1 c0006b14 = c0006b12;
                                K0 k05 = k04;
                                c0006b14.getClass();
                                if (z2) {
                                    c0006b14.l(false, new Y(c0006b14, k05, 0));
                                } else {
                                    c0006b14.u("Delete?", "Are you sure you want to delete this message?", "No", "Yes", new C0005b0(c0006b14, k05, 0));
                                }
                                return b.d.f770c;
                            }
                        });
                        return b.d.f770c;
                    }
                });
                return true;
            }
        });
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                J0(viewGroup.getChildAt(i2), k0);
            }
        }
    }

    public final int K() {
        return L() ? this.w.f488h : this.f426m;
    }

    public final void K0(int i2) {
        if (i2 == 2 && this.N != 2) {
            this.O = System.currentTimeMillis();
        }
        if (this.N == i2) {
            return;
        }
        this.N = i2;
        FrameLayout frameLayout = this.Q;
        if (frameLayout == null) {
            i.b.g("netIcon");
            throw null;
        }
        frameLayout.removeAllViews();
        if (i2 == 1) {
            FrameLayout frameLayout2 = this.Q;
            if (frameLayout2 == null) {
                i.b.g("netIcon");
                throw null;
            }
            float f2 = 24;
            frameLayout2.addView(M("wifioff", K(), 24), new FrameLayout.LayoutParams(z(f2), z(f2), 17));
            TextView textView = this.R;
            if (textView == null) {
                i.b.g("netTv");
                throw null;
            }
            textView.setText("No internet connection");
            LinearLayout linearLayout = this.P;
            if (linearLayout == null) {
                i.b.g("netBar");
                throw null;
            }
            linearLayout.setVisibility(0);
        } else if (i2 != 2) {
            LinearLayout linearLayout2 = this.P;
            if (linearLayout2 == null) {
                i.b.g("netBar");
                throw null;
            }
            linearLayout2.setVisibility(8);
        } else {
            FrameLayout frameLayout3 = this.Q;
            if (frameLayout3 == null) {
                i.b.g("netIcon");
                throw null;
            }
            float f3 = 22;
            frameLayout3.addView(new ProgressBar(this.f414a), new FrameLayout.LayoutParams(z(f3), z(f3), 17));
            TextView textView2 = this.R;
            if (textView2 == null) {
                i.b.g("netTv");
                throw null;
            }
            textView2.setText("Connecting...");
            LinearLayout linearLayout3 = this.P;
            if (linearLayout3 == null) {
                i.b.g("netBar");
                throw null;
            }
            linearLayout3.setVisibility(0);
        }
        i1();
    }

    public final boolean L() {
        return !this.w.f484d;
    }

    public final void L0(K0 k0) {
        this.T = k0;
        if (k0 == null) {
            this.U = 0L;
            LinearLayout linearLayout = this.b0;
            if (linearLayout == null) {
                i.b.g("replyBar");
                throw null;
            }
            linearLayout.setVisibility(8);
            View view = this.c0;
            if (view != null) {
                view.setVisibility(8);
                return;
            } else {
                i.b.g("replyTop");
                throw null;
            }
        }
        String str = k0.f151b;
        String x = i.b.a(str, this.f415b) ? "yourself" : x(str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("Replying to ");
        spannableStringBuilder.append((CharSequence) x);
        spannableStringBuilder.setSpan(new StyleSpan(1), spannableStringBuilder.length() - x.length(), spannableStringBuilder.length(), 33);
        TextView textView = this.d0;
        if (textView == null) {
            i.b.g("replyWho");
            throw null;
        }
        textView.setText(spannableStringBuilder);
        TextView textView2 = this.e0;
        if (textView2 == null) {
            i.b.g("replyTxt");
            throw null;
        }
        textView2.setText(r0(k0.f152c, k0.f153d, k0.f159j));
        LinearLayout linearLayout2 = this.b0;
        if (linearLayout2 == null) {
            i.b.g("replyBar");
            throw null;
        }
        linearLayout2.setVisibility(0);
        View view2 = this.c0;
        if (view2 == null) {
            i.b.g("replyTop");
            throw null;
        }
        view2.setVisibility(0);
        this.U = k0.f150a;
        EditText editText = this.h0;
        if (editText == null) {
            i.b.g("input");
            throw null;
        }
        editText.requestFocus();
        I2 i2 = this.W;
        if (i2 == null) {
            i.b.g("lv");
            throw null;
        }
        i2.post(new RunnableC0048m(this, 7));
        this.f418e.postDelayed(new RunnableC0048m(this, 8), 150L);
    }

    public final C1 M(String str, int i2, int i3) {
        C1 c1 = new C1(this.f414a, str, i2);
        float f2 = i3;
        c1.setMinimumWidth(z(f2));
        c1.setMinimumHeight(z(f2));
        c1.setCut(str.equals("face") ? L() ? this.w.p | (-16777216) : this.f424k : (L() && (str.equals("deliv") || str.equals("sent"))) ? -1 : L() ? this.w.f486f : this.f422i);
        return c1;
    }

    public final LinearLayout M0(View view, String str, String str2, h.a aVar) {
        LinearLayout P = P();
        float f2 = 8;
        P.setPadding(z(17), z(f2), z(16), z(f2));
        float f3 = 38;
        P.addView(view, X(this, z(f3), z(f3), 0, 0, 14, 32));
        LinearLayout k1 = k1();
        k1.addView(f1(str, 20.0f, this.f425l, false), X(this, -2, -2, 0, 0, 0, 60));
        if (str2 != null) {
            k1.addView(f1(str2, 14.5f, this.f426m, false), X(this, -2, -2, 0, 0, 0, 60));
        }
        P.addView(k1, new LinearLayout.LayoutParams(0, -2, 1.0f));
        P.setOnClickListener(new ViewOnClickListenerC0044l(aVar, 0));
        return P;
    }

    public final GradientDrawable N0(int i2, float f2, int i3, float f3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius(z(f2));
        if (f3 > 0.0f) {
            gradientDrawable.setStroke(z(f3), i3);
        }
        return gradientDrawable;
    }

    public final boolean O() {
        try {
            Object systemService = this.f414a.getSystemService("connectivity");
            i.b.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Network activeNetwork = connectivityManager.getActiveNetwork();
            NetworkCapabilities networkCapabilities = activeNetwork == null ? null : connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities != null) {
                if (networkCapabilities.hasCapability(12)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public final void O0(LinearLayout linearLayout, String str, String str2, int i2, h.a aVar) {
        LinearLayout P = P();
        float f2 = 16;
        float f3 = 6;
        P.setPadding(z(f2), z(f3), z(f2), z(f3));
        FrameLayout frameLayout = new FrameLayout(this.f414a);
        frameLayout.setBackground(i0(this.f430s));
        float f4 = 22;
        frameLayout.addView(M(str, i2, 22), new FrameLayout.LayoutParams(z(f4), z(f4), 17));
        float f5 = 44;
        P.addView(frameLayout, X(this, z(f5), z(f5), 0, 0, 16, 32));
        P.addView(f1(str2, 20.5f, this.f425l, false), new LinearLayout.LayoutParams(0, -2, 1.0f));
        P.setOnClickListener(new ViewOnClickListenerC0044l(aVar, 2));
        linearLayout.addView(P, X(this, -1, -2, 0, 0, 0, 60));
    }

    public final LinearLayout P() {
        LinearLayout linearLayout = new LinearLayout(this.f414a);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        return linearLayout;
    }

    public final void P0() {
        FrameLayout frameLayout = this.f0;
        if (frameLayout == null) {
            i.b.g("holder");
            throw null;
        }
        frameLayout.removeAllViews();
        FrameLayout frameLayout2 = this.f0;
        if (frameLayout2 == null) {
            i.b.g("holder");
            throw null;
        }
        LinearLayout linearLayout = this.i0;
        if (linearLayout != null) {
            frameLayout2.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        } else {
            i.b.g("idleView");
            throw null;
        }
    }

    public final ImageView Q(String str, float[] fArr, int i2, h.b bVar, h.a aVar) {
        ImageView imageView = new ImageView(this.f414a);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setBackgroundColor(this.f423j);
        imageView.setOutlineProvider(new T0(0, fArr));
        imageView.setClipToOutline(true);
        z2.e(imageView, str, i2, bVar);
        imageView.setOnClickListener(new ViewOnClickListenerC0016e(aVar, this, str, 0));
        imageView.setOnLongClickListener(new ViewOnLongClickListenerC0065q0());
        return imageView;
    }

    public final boolean R() {
        String str = "muted_" + this.f415b;
        SharedPreferences sharedPreferences = AbstractC0008c.f440c;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            return i.b.a(string != null ? string : "", "1");
        }
        i.b.g("sp");
        throw null;
    }

    public final boolean S(K0 k0) {
        return k0.f150a >= this.L0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v3 */
    public final void S0() {
        ?? r11;
        TextView textView;
        final boolean a2 = i.b.a(this.U0, "rec");
        LinearLayout k1 = k1();
        float f2 = 13;
        k1.setPadding(z(f2), z(6), z(f2), z(8));
        LinearLayout P = P();
        P.setBackground(N0(this.f420g, 30.0f, 0, 0.0f));
        P.setPadding(z(a2 ? 18 : 12), 0, z(f2), 0);
        float z = z(3);
        float z2 = z(2.5f);
        Activity activity = this.f414a;
        P2 p2 = new P2(activity, z, z2);
        p2.setFg(-1);
        ArrayList arrayList = this.b1;
        if (a2) {
            p2.setLive(true);
            p2.setValues(arrayList);
            this.c1 = p2;
            r11 = 1;
            textView = null;
        } else {
            C1 M = M("play", -1, 26);
            float f3 = 26;
            r11 = 1;
            P.addView(M, X(this, z(f3), z(f3), 0, 0, 11, 32));
            p2.setValues(A0(arrayList));
            p2.setCursor(true);
            textView = null;
            this.c1 = null;
            this.j1.put(-2L, M);
            this.i1.put(-2L, p2);
            n0(M, new C0036j(this, 5));
        }
        P.addView(p2, new LinearLayout.LayoutParams(0, z(34), 1.0f));
        TextView f1 = f1(G(a2 ? this.Z0 : this.Y0), 16.0f, -1, r11);
        this.d1 = a2 ? f1 : textView;
        P.addView(f1, X(this, -2, -2, 17, 0, 0, 56));
        k1.addView(P, X(this, -1, z(44), 0, 0, 0, 60));
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        FrameLayout frameLayout = new FrameLayout(activity);
        float f4 = 26;
        frameLayout.addView(new G1(activity, "trashmsg", this.f426m, 1.7f), new FrameLayout.LayoutParams(z(f4), z(f4), 17));
        n0(frameLayout, new C0036j(this, 6));
        float f5 = 52;
        linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(z(f5), z(f5)));
        linearLayout.addView(new View(activity), new LinearLayout.LayoutParams(0, r11, 1.0f));
        FrameLayout frameLayout2 = new FrameLayout(activity);
        String str = a2 ? "pauseo" : "mico";
        int i2 = this.f421h;
        float f6 = 28;
        frameLayout2.addView(M(str, i2, 28), new FrameLayout.LayoutParams(z(f6), z(f6), 17));
        final int i3 = 0;
        n0(frameLayout2, new h.a() { // from class: a.k0
            @Override // h.a
            public final Object a() {
                switch (i3) {
                    case 0:
                        boolean z3 = a2;
                        C0006b1 c0006b1 = this;
                        if (z3) {
                            c0006b1.Y0();
                        } else {
                            c0006b1.X0();
                            c0006b1.W0(true);
                        }
                        break;
                    default:
                        boolean z4 = a2;
                        C0006b1 c0006b12 = this;
                        if (z4) {
                            c0006b12.Y0();
                            if (i.b.a(c0006b12.U0, "prev")) {
                                c0006b12.H0();
                            }
                        } else {
                            c0006b12.H0();
                        }
                        break;
                }
                return b.d.f770c;
            }
        });
        linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(z(f5), z(f5)));
        linearLayout.addView(new View(activity), new LinearLayout.LayoutParams(0, r11, 1.0f));
        FrameLayout frameLayout3 = new FrameLayout(activity);
        frameLayout3.addView(M("send", i2, 28), new FrameLayout.LayoutParams(z(f6), z(f6), 17));
        final int i4 = 1;
        n0(frameLayout3, new h.a() { // from class: a.k0
            @Override // h.a
            public final Object a() {
                switch (i4) {
                    case 0:
                        boolean z3 = a2;
                        C0006b1 c0006b1 = this;
                        if (z3) {
                            c0006b1.Y0();
                        } else {
                            c0006b1.X0();
                            c0006b1.W0(true);
                        }
                        break;
                    default:
                        boolean z4 = a2;
                        C0006b1 c0006b12 = this;
                        if (z4) {
                            c0006b12.Y0();
                            if (i.b.a(c0006b12.U0, "prev")) {
                                c0006b12.H0();
                            }
                        } else {
                            c0006b12.H0();
                        }
                        break;
                }
                return b.d.f770c;
            }
        });
        linearLayout.addView(frameLayout3, new LinearLayout.LayoutParams(z(f5), z(f5)));
        k1.addView(linearLayout, X(this, -1, -2, 0, 0, 0, 60));
        FrameLayout frameLayout4 = this.f0;
        if (frameLayout4 == null) {
            i.b.g("holder");
            throw null;
        }
        frameLayout4.removeAllViews();
        FrameLayout frameLayout5 = this.f0;
        if (frameLayout5 != null) {
            frameLayout5.addView(k1, new FrameLayout.LayoutParams(-1, -2));
        } else {
            i.b.g("holder");
            throw null;
        }
    }

    public final long T() {
        ArrayList arrayList = this.D;
        int size = arrayList.size() - 1;
        if (size < 0) {
            return 0L;
        }
        while (true) {
            int i2 = size - 1;
            if (!S((K0) arrayList.get(size))) {
                return ((K0) arrayList.get(size)).f150a;
            }
            if (i2 < 0) {
                return 0L;
            }
            size = i2;
        }
    }

    public final void T0(Dialog dialog) {
        Window window = dialog.getWindow();
        if (window != null && (!m.m.F(this.f415b, this.C1))) {
            window.addFlags(8192);
        }
        dialog.show();
    }

    public final void U() {
        new Thread(new RunnableC0048m(this, 5)).start();
    }

    public final LinearLayout.LayoutParams U0(float f2) {
        int z = z(254);
        int z2 = z(265);
        int i2 = (int) (z / f2);
        if (i2 > z2) {
            z = (int) (z2 * f2);
        } else {
            z2 = i2;
        }
        float f3 = 90;
        if (z < z(f3)) {
            z = z(f3);
        }
        float f4 = 80;
        if (z2 < z(f4)) {
            z2 = z(f4);
        }
        return new LinearLayout.LayoutParams(z, z2);
    }

    public final void V() {
        ArrayList arrayList = this.D;
        if (arrayList.isEmpty()) {
            return;
        }
        this.J = true;
        new Thread(new RunnableC0049m0(0, ((K0) arrayList.get(0)).f150a, this)).start();
    }

    public final LinearLayout.LayoutParams W(int i2, int i3, int i4, int i5, int i6, int i7) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i3);
        layoutParams.setMargins(z(i4), z(i5), z(i6), z(i7));
        return layoutParams;
    }

    public final void W0(boolean z) {
        Activity activity = this.f414a;
        if (activity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            this.e1 = true;
            activity.requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, 3);
            return;
        }
        h.b bVar = this.f416c;
        if (z && this.Y0 >= 179000) {
            bVar.a("Voice message is at the maximum length");
            return;
        }
        try {
            try {
                File file = new File(activity.getCacheDir(), "rec_" + System.currentTimeMillis() + ".m4a");
                MediaRecorder mediaRecorder = new MediaRecorder();
                mediaRecorder.setAudioSource(1);
                mediaRecorder.setOutputFormat(2);
                mediaRecorder.setAudioEncoder(3);
                mediaRecorder.setAudioEncodingBitRate(32000);
                mediaRecorder.setAudioSamplingRate(22050);
                mediaRecorder.setAudioChannels(1);
                mediaRecorder.setOutputFile(file.getPath());
                mediaRecorder.prepare();
                mediaRecorder.start();
                this.V0 = mediaRecorder;
                this.a1 = file;
                LinearLayout linearLayout = this.g0;
                if (linearLayout == null) {
                    i.b.g("panel");
                    throw null;
                }
                linearLayout.setVisibility(8);
                Object systemService = activity.getSystemService("input_method");
                i.b.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                EditText editText = this.h0;
                if (editText == null) {
                    i.b.g("input");
                    throw null;
                }
                inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                if (!z) {
                    this.b1.clear();
                    this.Y0 = 0;
                    this.W0 = null;
                }
                this.Z0 = z ? this.Y0 : 0;
                this.U0 = "rec";
                this.X0 = System.currentTimeMillis();
                S0();
                this.f418e.post(this.f1);
            } catch (Exception unused) {
                this.V0 = null;
                bVar.a("Could not start the microphone");
            }
        } catch (Exception unused2) {
            MediaRecorder mediaRecorder2 = this.V0;
            if (mediaRecorder2 != null) {
                mediaRecorder2.release();
            }
            this.V0 = null;
            bVar.a("Could not start the microphone");
        }
    }

    public final void X0() {
        this.f418e.removeCallbacks(this.k1);
        try {
            MediaPlayer mediaPlayer = this.g1;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        } catch (Exception unused) {
        }
        this.g1 = null;
        C1 c1 = (C1) this.j1.get(Long.valueOf(this.h1));
        if (c1 != null) {
            c1.set("play");
        }
        TextView textView = (TextView) this.n1.get(Long.valueOf(this.h1));
        if (textView != null) {
            textView.setVisibility(8);
        }
        P2 p2 = (P2) this.i1.get(Long.valueOf(this.h1));
        if (p2 != null) {
            p2.setProgress(0.0f);
            p2.invalidate();
        }
        this.h1 = Long.MIN_VALUE;
    }

    public final void Y(long j2) {
        int i2 = 2;
        this.w1 = j2;
        this.x1 = 0L;
        Handler handler = C2.f57a;
        try {
            Object systemService = this.f414a.getSystemService("audio");
            i.b.c(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            if (((AudioManager) systemService).getRingerMode() != 2) {
                return;
            }
            C2.f58b.execute(new RunnableC0068r0(i2));
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:33|(3:34|35|36)|(3:37|38|39)|(7:43|44|45|(1:(2:86|87)(5:47|(1:49)|50|51|(3:54|(2:56|57)|58)(1:53)))|(6:74|75|(2:81|82)|77|78|79)(5:60|(2:61|(3:63|(2:65|66)(2:68|69)|67)(1:70))|71|72|73)|40|41)|94|(2:96|97)|100|101|102) */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0188 A[Catch: Exception -> 0x018b, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x018b, blocks: (B:77:0x00fe, B:113:0x0188), top: B:34:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Y0() {
        boolean z;
        MediaMuxer mediaMuxer;
        ByteBuffer allocate;
        MediaCodec.BufferInfo bufferInfo;
        Iterator it;
        int i2;
        int i3;
        long j2;
        MediaExtractor mediaExtractor;
        int i4;
        Iterator it2;
        int i5;
        if (i.b.a(this.U0, "rec")) {
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.X0);
            int i6 = 0;
            try {
                MediaRecorder mediaRecorder = this.V0;
                if (mediaRecorder != null) {
                    mediaRecorder.stop();
                }
                z = true;
            } catch (Exception unused) {
                z = false;
            }
            try {
                MediaRecorder mediaRecorder2 = this.V0;
                if (mediaRecorder2 != null) {
                    mediaRecorder2.release();
                }
            } catch (Exception unused2) {
            }
            MediaMuxer mediaMuxer2 = null;
            this.V0 = null;
            File file = this.a1;
            this.a1 = null;
            File file2 = this.W0;
            boolean z2 = file2 == null;
            h.b bVar = this.f416c;
            if (!z || file == null || ((z2 && currentTimeMillis < 600) || (!z2 && currentTimeMillis < 300))) {
                if (file != null) {
                    file.delete();
                }
                if (!z2) {
                    this.U0 = "prev";
                    S0();
                    return;
                } else {
                    bVar.a("Voice message is too short");
                    this.W0 = null;
                    this.U0 = "idle";
                    P0();
                    return;
                }
            }
            if (z2) {
                this.W0 = file;
                this.Y0 = currentTimeMillis;
            } else {
                i.b.b(file2);
                File file3 = new File(this.f414a.getCacheDir(), "rec_m_" + System.currentTimeMillis() + ".m4a");
                try {
                    try {
                        mediaMuxer = new MediaMuxer(file3.getPath(), 0);
                    } catch (Exception unused3) {
                    }
                } catch (Exception unused4) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    allocate = ByteBuffer.allocate(65536);
                    bufferInfo = new MediaCodec.BufferInfo();
                    it = c.c.C(file2, file).iterator();
                    i2 = 0;
                    i3 = -1;
                    j2 = 0;
                } catch (Exception unused5) {
                    mediaMuxer2 = mediaMuxer;
                    if (i6 != 0) {
                        try {
                            mediaMuxer2.stop();
                        } catch (Exception unused6) {
                        }
                    }
                    if (mediaMuxer2 != null) {
                    }
                    file3.delete();
                    file.delete();
                    bVar.a("Could not add to the recording");
                    this.U0 = "prev";
                    S0();
                } catch (Throwable th2) {
                    th = th2;
                    mediaMuxer2 = mediaMuxer;
                    if (i6 != 0) {
                        try {
                            mediaMuxer2.stop();
                        } catch (Exception unused7) {
                        }
                    }
                    if (mediaMuxer2 != null) {
                    }
                }
                while (it.hasNext()) {
                    try {
                        File file4 = (File) it.next();
                        mediaExtractor = new MediaExtractor();
                        try {
                            mediaExtractor.setDataSource(file4.getPath());
                            int trackCount = mediaExtractor.getTrackCount();
                            i4 = i6;
                            while (true) {
                                if (i4 >= trackCount) {
                                    it2 = it;
                                    i5 = i3;
                                    i4 = -1;
                                    break;
                                }
                                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i4);
                                String string = trackFormat.getString("mime");
                                if (string == null) {
                                    string = "";
                                }
                                it2 = it;
                                if (m.m.K(string, "audio/")) {
                                    if (i3 < 0) {
                                        i3 = mediaMuxer.addTrack(trackFormat);
                                        mediaMuxer.start();
                                        i2 = 1;
                                    }
                                    i5 = i3;
                                } else {
                                    i4++;
                                    it = it2;
                                }
                            }
                        } catch (Throwable th3) {
                            i6 = i2;
                            mediaExtractor.release();
                            throw th3;
                        }
                    } catch (Exception unused8) {
                        mediaMuxer2 = mediaMuxer;
                        i6 = i2;
                        if (i6 != 0 && mediaMuxer2 != null) {
                            mediaMuxer2.stop();
                        }
                        if (mediaMuxer2 != null) {
                            mediaMuxer2.release();
                        }
                        file3.delete();
                        file.delete();
                        bVar.a("Could not add to the recording");
                        this.U0 = "prev";
                        S0();
                    } catch (Throwable th4) {
                        th = th4;
                        mediaMuxer2 = mediaMuxer;
                        i6 = i2;
                        if (i6 != 0 && mediaMuxer2 != null) {
                            mediaMuxer2.stop();
                        }
                        if (mediaMuxer2 != null) {
                            throw th;
                        }
                        try {
                            mediaMuxer2.release();
                            throw th;
                        } catch (Exception unused9) {
                            throw th;
                        }
                    }
                    if (i4 < 0) {
                        mediaExtractor.release();
                        if (i2 != 0) {
                            try {
                                mediaMuxer.stop();
                            } catch (Exception unused10) {
                            }
                        }
                        mediaMuxer.release();
                        file3.delete();
                        file.delete();
                        bVar.a("Could not add to the recording");
                    } else {
                        mediaExtractor.selectTrack(i4);
                        long j3 = 0;
                        while (true) {
                            allocate.clear();
                            i6 = 0;
                            int readSampleData = mediaExtractor.readSampleData(allocate, 0);
                            if (readSampleData < 0) {
                                break;
                            }
                            bufferInfo.offset = 0;
                            bufferInfo.size = readSampleData;
                            bufferInfo.presentationTimeUs = mediaExtractor.getSampleTime() + j2;
                            bufferInfo.flags = (mediaExtractor.getSampleFlags() & 1) != 0 ? 1 : 0;
                            mediaMuxer.writeSampleData(i5, allocate, bufferInfo);
                            j3 = bufferInfo.presentationTimeUs;
                            mediaExtractor.advance();
                        }
                        j2 = j3 + 46440;
                        mediaExtractor.release();
                        i3 = i5;
                        it = it2;
                    }
                }
                if (i2 != 0) {
                    try {
                        mediaMuxer.stop();
                    } catch (Exception unused11) {
                    }
                }
                mediaMuxer.release();
                file2.delete();
                file.delete();
                this.W0 = file3;
                this.Y0 = this.Z0 + currentTimeMillis;
            }
            this.U0 = "prev";
            S0();
        }
    }

    public final long Z() {
        long j2 = this.A1;
        String str = "nameat_" + this.f415b;
        SharedPreferences sharedPreferences = AbstractC0008c.f440c;
        if (sharedPreferences == null) {
            i.b.g("sp");
            throw null;
        }
        String string = sharedPreferences.getString(str, "0");
        Long D = m.l.D(string != null ? string : "0");
        return Math.max(j2, D != null ? D.longValue() : 0L);
    }

    public final long a(String str, List list, int i2, K0 k0, List list2) {
        String str2;
        String str3;
        String str4;
        long j2 = this.M0 + 1;
        this.M0 = j2;
        long j3 = this.L0 + j2;
        this.D.add(new K0(j3, this.f415b, str, "", list, new ArrayList(list2), i2, k0 != null ? k0.f150a : 0L, System.currentTimeMillis(), (k0 == null || (str4 = k0.f151b) == null) ? "" : str4, (k0 == null || (str3 = k0.f152c) == null) ? "" : str3, (k0 == null || (str2 = k0.f153d) == null) ? "" : str2, k0 != null ? k0.f159j : false));
        Y(j3);
        this.R0.add(Long.valueOf(j3));
        w0();
        x0(true);
        return j3;
    }

    public final boolean a0(List list, boolean z) {
        if (!list.isEmpty() && e0()) {
            if (z) {
                File file = z2.f758a;
                File g2 = z2.g((String) list.get(0));
                if ((!g2.exists() || g2.length() <= 0) && !list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (!m.m.K(str, "L")) {
                            File c2 = z2.c(str);
                            if (c2.exists() && c2.length() > 0) {
                            }
                            b0();
                            return true;
                        }
                    }
                }
            } else if (!list.isEmpty()) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    String str2 = (String) it2.next();
                    if (!m.m.K(str2, "L")) {
                        File c3 = z2.c(str2);
                        if (c3.exists() && c3.length() > 0) {
                        }
                        b0();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void a1(J2 j2, float f2) {
        if (j2.f144c) {
            f2 = -f2;
        }
        float max = Math.max(0.0f, f2);
        float z = z(80.0f);
        float f3 = max <= z ? 0.75f * max : (0.75f * z) + ((max - z) * 0.12f);
        j2.f142a.setTranslationX((j2.f144c ? -1.0f : 1.0f) * f3);
        float b2 = AbstractC0008c.b((f3 - z(14.0f)) / z(24.0f), 0.0f, 1.0f);
        boolean z2 = max >= ((float) z(70.0f));
        if (z2 != this.t1) {
            this.t1 = z2;
            if (z2) {
                I2 i2 = this.W;
                if (i2 == null) {
                    i.b.g("lv");
                    throw null;
                }
                i2.performHapticFeedback(3);
            }
        }
        View view = j2.f143b;
        view.setAlpha(b2);
        float f4 = ((b2 * 0.6f) + 0.4f) * (z2 ? 1.12f : 1.0f);
        view.setScaleX(f4);
        view.setScaleY(f4);
    }

    public final int b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return 0;
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = this.D;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            hashSet.add(Long.valueOf(((K0) it.next()).f150a));
        }
        String s2 = s();
        SharedPreferences sharedPreferences = AbstractC0008c.f440c;
        if (sharedPreferences == null) {
            i.b.g("sp");
            throw null;
        }
        String string = sharedPreferences.getString(s2, "0");
        Long D = m.l.D(string != null ? string : "0");
        long longValue = D != null ? D.longValue() : 0L;
        int length = jSONArray.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                long optLong = optJSONObject.optLong("id");
                if (optLong > longValue && !hashSet.contains(Long.valueOf(optLong)) && !((HashSet) this.J0.a()).contains(Long.valueOf(optLong))) {
                    arrayList.add(k0(optJSONObject));
                    hashSet.add(Long.valueOf(optLong));
                    i2++;
                }
            }
        }
        if (i2 > 0 && arrayList.size() > 1) {
            c.g.F(arrayList, new N0(0));
        }
        return i2;
    }

    public final void b0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f414a, this.f419f ? R.style.Theme.DeviceDefault.Dialog.Alert : R.style.Theme.DeviceDefault.Light.Dialog.Alert);
        builder.setMessage("No internet connection.\nTurn on mobile data or Wi-Fi and try again.");
        builder.setPositiveButton("OK", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        T0(create);
        Button button = create.getButton(-1);
        if (button != null) {
            button.setTextColor(-13793025);
        }
    }

    public final void b1() {
        if (this.H) {
            return;
        }
        this.H = true;
        new Thread(new RunnableC0049m0(1, T(), this)).start();
    }

    public final void c() {
        long j2 = this.U;
        if (j2 == 0) {
            return;
        }
        Iterator it = this.D.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (((K0) it.next()).f150a == j2) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0) {
            return;
        }
        I2 i22 = this.W;
        if (i22 == null) {
            i.b.g("lv");
            throw null;
        }
        if (i22 == null) {
            i.b.g("lv");
            throw null;
        }
        View childAt = i22.getChildAt(i2 - i22.getFirstVisiblePosition());
        if (childAt == null) {
            I2 i23 = this.W;
            if (i23 == null) {
                i.b.g("lv");
                throw null;
            }
            if (i23 == null) {
                i.b.g("lv");
                throw null;
            }
            int paddingTop = i23.getPaddingTop();
            I2 i24 = this.W;
            if (i24 != null) {
                i23.setSelectionFromTop(i2, Math.max(paddingTop, i24.getHeight() - z(90)));
                return;
            } else {
                i.b.g("lv");
                throw null;
            }
        }
        int bottom = childAt.getBottom();
        I2 i25 = this.W;
        if (i25 == null) {
            i.b.g("lv");
            throw null;
        }
        int height = bottom - i25.getHeight();
        if (height > 0) {
            I2 i26 = this.W;
            if (i26 == null) {
                i.b.g("lv");
                throw null;
            }
            int top = childAt.getTop();
            I2 i27 = this.W;
            if (i27 != null) {
                i26.scrollListBy(Math.min(height, Math.max(top - i27.getPaddingTop(), 0)));
            } else {
                i.b.g("lv");
                throw null;
            }
        }
    }

    public final void d(final long j2) {
        c.h.G(this.D, new h.b() { // from class: a.N
            @Override // h.b
            public final Object a(Object obj) {
                K0 k0 = (K0) obj;
                return Boolean.valueOf(!C0006b1.this.S(k0) && k0.f150a <= j2);
            }
        });
        this.E.clear();
        this.m0.clear();
        this.I = false;
        String str = "chatcache_" + this.f415b;
        SharedPreferences sharedPreferences = AbstractC0008c.f440c;
        if (sharedPreferences == null) {
            i.b.g("sp");
            throw null;
        }
        sharedPreferences.edit().remove(str).apply();
        String s2 = s();
        String valueOf = String.valueOf(j2);
        SharedPreferences sharedPreferences2 = AbstractC0008c.f440c;
        if (sharedPreferences2 == null) {
            i.b.g("sp");
            throw null;
        }
        sharedPreferences2.edit().putString(s2, valueOf).apply();
        w0();
        x0(false);
    }

    public final void d0(long j2) {
        this.A1 = j2;
        String str = "nameat_" + this.f415b;
        String valueOf = String.valueOf(j2);
        SharedPreferences sharedPreferences = AbstractC0008c.f440c;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, valueOf).apply();
        } else {
            i.b.g("sp");
            throw null;
        }
    }

    public final void d1(long j2, JSONObject jSONObject, K0 k0) {
        Object obj;
        String str;
        String str2;
        String str3;
        this.R0.remove(Long.valueOf(j2));
        Iterator it = this.D.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((K0) obj).f150a == j2) {
                    break;
                }
            }
        }
        K0 k02 = (K0) obj;
        this.O0.add(new M0(j2, jSONObject, k02 != null ? k02.f158i : System.currentTimeMillis(), (k0 == null || (str3 = k0.f151b) == null) ? "" : str3, (k0 == null || (str2 = k0.f152c) == null) ? "" : str2, (k0 == null || (str = k0.f153d) == null) ? "" : str, k0 != null ? k0.f159j : false));
        C0();
        O0 o0 = this.j0;
        if (o0 != null) {
            o0.notifyDataSetChanged();
        } else {
            i.b.g("adapter");
            throw null;
        }
    }

    public final void e(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("q") || System.currentTimeMillis() - this.D1 < 6000) {
            return;
        }
        String optString = jSONObject.optString("q", "");
        if (i.b.a(optString, p0())) {
            return;
        }
        Z0(optString);
        h1();
        C0029h0 c0029h0 = this.y1;
        if (c0029h0 != null) {
            c0029h0.a();
        }
    }

    public final boolean e0() {
        try {
            Object systemService = this.f414a.getSystemService("connectivity");
            i.b.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Network activeNetwork = connectivityManager.getActiveNetwork();
            NetworkCapabilities networkCapabilities = activeNetwork == null ? null : connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities != null && networkCapabilities.hasCapability(12)) {
                if (networkCapabilities.hasCapability(16)) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void e1(final long j2, File file) {
        MediaPlayer mediaPlayer = this.g1;
        HashMap hashMap = this.j1;
        if (mediaPlayer == null || this.h1 != j2) {
            p();
            X0();
            MediaPlayer mediaPlayer2 = new MediaPlayer();
            try {
                mediaPlayer2.setDataSource(file.getPath());
                this.g1 = mediaPlayer2;
                this.h1 = j2;
                C1 c1 = (C1) hashMap.get(Long.valueOf(j2));
                if (c1 != null) {
                    c1.set("load");
                }
                mediaPlayer2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: a.t0
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public final void onPrepared(MediaPlayer mediaPlayer3) {
                        C0006b1 c0006b1 = C0006b1.this;
                        if (c0006b1.g1 == mediaPlayer3) {
                            mediaPlayer3.start();
                            long j3 = j2;
                            c0006b1.f(mediaPlayer3, j3);
                            TextView textView = (TextView) c0006b1.n1.get(Long.valueOf(j3));
                            if (textView != null) {
                                textView.setText(C0006b1.V0(c0006b1.l1));
                                textView.setVisibility(0);
                            }
                            C1 c12 = (C1) c0006b1.j1.get(Long.valueOf(j3));
                            if (c12 != null) {
                                c12.set("pause");
                            }
                            c0006b1.f418e.post(c0006b1.k1);
                        }
                    }
                });
                mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: a.u0
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public final void onCompletion(MediaPlayer mediaPlayer3) {
                        C0006b1 c0006b1 = C0006b1.this;
                        if (c0006b1.g1 == mediaPlayer3) {
                            c0006b1.X0();
                        }
                    }
                });
                mediaPlayer2.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: a.v0
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public final boolean onError(MediaPlayer mediaPlayer3, int i2, int i3) {
                        C0006b1 c0006b1 = C0006b1.this;
                        if (c0006b1.g1 == mediaPlayer3) {
                            c0006b1.X0();
                        }
                        c0006b1.f416c.a("Can't play this voice message");
                        return true;
                    }
                });
                mediaPlayer2.prepareAsync();
                return;
            } catch (Exception unused) {
                if (this.g1 == mediaPlayer2) {
                    X0();
                } else {
                    try {
                        mediaPlayer2.release();
                    } catch (Exception unused2) {
                    }
                }
                this.f416c.a("Can't play this voice message");
                return;
            }
        }
        try {
            boolean isPlaying = mediaPlayer.isPlaying();
            X0 x0 = this.k1;
            Handler handler = this.f418e;
            if (isPlaying) {
                mediaPlayer.pause();
                C1 c12 = (C1) hashMap.get(Long.valueOf(j2));
                if (c12 != null) {
                    c12.set("play");
                }
                handler.removeCallbacks(x0);
                return;
            }
            mediaPlayer.start();
            f(mediaPlayer, j2);
            C1 c13 = (C1) hashMap.get(Long.valueOf(j2));
            if (c13 != null) {
                c13.set("pause");
            }
            handler.post(x0);
        } catch (Exception unused3) {
            X0();
        }
    }

    public final void f(MediaPlayer mediaPlayer, long j2) {
        if (this.n1.containsKey(Long.valueOf(j2))) {
            try {
                mediaPlayer.setPlaybackParams(mediaPlayer.getPlaybackParams().setSpeed(this.l1));
            } catch (Exception unused) {
            }
        }
    }

    public final void f0() {
        C0036j c0036j = new C0036j(this, 4);
        C0017e0 c0017e0 = new C0017e0(this, 0);
        boolean z = this.f419f;
        Activity activity = this.f414a;
        final B1 b1 = new B1(activity, z, c0036j, c0017e0);
        b1.q = !m.m.F(this.f415b, this.C1);
        Dialog dialog = new Dialog(activity, R.style.Theme.Black.NoTitleBar);
        b1.f41r = dialog;
        Window window = dialog.getWindow();
        int i2 = b1.f30e;
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(i2));
        }
        Dialog dialog2 = b1.f41r;
        if (dialog2 == null) {
            i.b.g("dlg");
            throw null;
        }
        Window window2 = dialog2.getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(16);
        }
        FrameLayout frameLayout = new FrameLayout(activity);
        b1.f42s = frameLayout;
        frameLayout.setBackgroundColor(i2);
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setGravity(16);
        linearLayout2.setPadding(b1.e(4), b1.e(6), b1.e(12), b1.e(6));
        FrameLayout frameLayout2 = new FrameLayout(activity);
        int i3 = b1.f31f;
        frameLayout2.addView(new G1(activity, "back", i3, 2.4f), new FrameLayout.LayoutParams(b1.e(26), b1.e(26), 17));
        frameLayout2.setOnClickListener(new ViewOnClickListenerC0058o1(b1, 6));
        linearLayout2.addView(frameLayout2, new LinearLayout.LayoutParams(b1.e(48), b1.e(48)));
        LinearLayout linearLayout3 = new LinearLayout(activity);
        linearLayout3.setGravity(16);
        b1.f43t = b1.l("Gallery", 22.0f, i3, true);
        b1.f44u = new G1(activity, "down", i3, 2.6f);
        TextView textView = b1.f43t;
        if (textView == null) {
            i.b.g("titleTv");
            throw null;
        }
        linearLayout3.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        G1 g1 = b1.f44u;
        if (g1 == null) {
            i.b.g("chev");
            throw null;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(b1.e(22), b1.e(22));
        layoutParams.leftMargin = b1.e(4);
        linearLayout3.addView(g1, layoutParams);
        linearLayout3.setOnClickListener(new ViewOnClickListenerC0058o1(b1, 7));
        linearLayout2.addView(linearLayout3, new LinearLayout.LayoutParams(-2, b1.e(48)));
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        View view = new View(activity);
        view.setBackgroundColor(b1.f33h);
        linearLayout.addView(view, new LinearLayout.LayoutParams(-1, 1));
        FrameLayout frameLayout3 = new FrameLayout(activity);
        GridView gridView = new GridView(activity);
        b1.f45v = gridView;
        gridView.setNumColumns(3);
        GridView gridView2 = b1.f45v;
        if (gridView2 == null) {
            i.b.g("grid");
            throw null;
        }
        gridView2.setHorizontalSpacing(b1.e(2));
        GridView gridView3 = b1.f45v;
        if (gridView3 == null) {
            i.b.g("grid");
            throw null;
        }
        gridView3.setVerticalSpacing(b1.e(2));
        GridView gridView4 = b1.f45v;
        if (gridView4 == null) {
            i.b.g("grid");
            throw null;
        }
        gridView4.setStretchMode(2);
        GridView gridView5 = b1.f45v;
        if (gridView5 == null) {
            i.b.g("grid");
            throw null;
        }
        gridView5.setPadding(b1.e(2), b1.e(2), b1.e(2), b1.e(90));
        GridView gridView6 = b1.f45v;
        if (gridView6 == null) {
            i.b.g("grid");
            throw null;
        }
        gridView6.setClipToPadding(false);
        GridView gridView7 = b1.f45v;
        if (gridView7 == null) {
            i.b.g("grid");
            throw null;
        }
        gridView7.setSelector(new ColorDrawable(0));
        GridView gridView8 = b1.f45v;
        if (gridView8 == null) {
            i.b.g("grid");
            throw null;
        }
        gridView8.setBackgroundColor(i2);
        GridView gridView9 = b1.f45v;
        if (gridView9 == null) {
            i.b.g("grid");
            throw null;
        }
        gridView9.setAdapter((ListAdapter) b1.J);
        GridView gridView10 = b1.f45v;
        if (gridView10 == null) {
            i.b.g("grid");
            throw null;
        }
        frameLayout3.addView(gridView10, new FrameLayout.LayoutParams(-1, -1));
        TextView l2 = b1.l("No photos or videos", 18.0f, i3, false);
        b1.C = l2;
        l2.setVisibility(8);
        TextView textView2 = b1.C;
        if (textView2 == null) {
            i.b.g("emptyTv");
            throw null;
        }
        frameLayout3.addView(textView2, new FrameLayout.LayoutParams(-2, -2, 17));
        FrameLayout frameLayout4 = new FrameLayout(activity);
        frameLayout4.setBackground(B1.h(-1));
        frameLayout4.setElevation(b1.e(6));
        frameLayout4.addView(new C0046l1(activity, "cam", -16777216, -1), new FrameLayout.LayoutParams(b1.e(30), b1.e(30), 17));
        frameLayout4.setOnClickListener(new ViewOnClickListenerC0058o1(b1, 3));
        b1.y = frameLayout4;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(b1.e(60), b1.e(60), 81);
        layoutParams2.bottomMargin = b1.e(18);
        frameLayout3.addView(frameLayout4, layoutParams2);
        LinearLayout linearLayout4 = new LinearLayout(activity);
        b1.z = linearLayout4;
        linearLayout4.setOrientation(0);
        TextView l3 = b1.l("Preview", 19.0f, i3, true);
        b1.A = l3;
        l3.setGravity(17);
        TextView textView3 = b1.A;
        if (textView3 == null) {
            i.b.g("prevBtn");
            throw null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(b1.f32g);
        gradientDrawable.setCornerRadius(b1.e(8));
        textView3.setBackground(gradientDrawable);
        TextView textView4 = b1.A;
        if (textView4 == null) {
            i.b.g("prevBtn");
            throw null;
        }
        textView4.setOnClickListener(new ViewOnClickListenerC0058o1(b1, 4));
        TextView l4 = b1.l("Send", 19.0f, -1, true);
        b1.B = l4;
        l4.setGravity(17);
        TextView textView5 = b1.B;
        if (textView5 == null) {
            i.b.g("sendBtn");
            throw null;
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-16226561);
        gradientDrawable2.setCornerRadius(b1.e(8));
        textView5.setBackground(gradientDrawable2);
        TextView textView6 = b1.B;
        if (textView6 == null) {
            i.b.g("sendBtn");
            throw null;
        }
        textView6.setOnClickListener(new ViewOnClickListenerC0058o1(b1, 5));
        LinearLayout linearLayout5 = b1.z;
        if (linearLayout5 == null) {
            i.b.g("bar");
            throw null;
        }
        TextView textView7 = b1.A;
        if (textView7 == null) {
            i.b.g("prevBtn");
            throw null;
        }
        linearLayout5.addView(textView7, new LinearLayout.LayoutParams(0, b1.e(48), 1.0f));
        LinearLayout linearLayout6 = b1.z;
        if (linearLayout6 == null) {
            i.b.g("bar");
            throw null;
        }
        TextView textView8 = b1.B;
        if (textView8 == null) {
            i.b.g("sendBtn");
            throw null;
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, b1.e(48), 1.0f);
        layoutParams3.leftMargin = b1.e(12);
        linearLayout6.addView(textView8, layoutParams3);
        LinearLayout linearLayout7 = b1.z;
        if (linearLayout7 == null) {
            i.b.g("bar");
            throw null;
        }
        linearLayout7.setVisibility(8);
        LinearLayout linearLayout8 = b1.z;
        if (linearLayout8 == null) {
            i.b.g("bar");
            throw null;
        }
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2, 80);
        layoutParams4.setMargins(b1.e(12), 0, b1.e(12), b1.e(12));
        frameLayout3.addView(linearLayout8, layoutParams4);
        ScrollView scrollView = new ScrollView(activity);
        b1.w = scrollView;
        scrollView.setBackgroundColor(i2);
        ScrollView scrollView2 = b1.w;
        if (scrollView2 == null) {
            i.b.g("menu");
            throw null;
        }
        scrollView2.setClickable(true);
        ScrollView scrollView3 = b1.w;
        if (scrollView3 == null) {
            i.b.g("menu");
            throw null;
        }
        scrollView3.setVisibility(8);
        LinearLayout linearLayout9 = new LinearLayout(activity);
        b1.x = linearLayout9;
        linearLayout9.setOrientation(1);
        ScrollView scrollView4 = b1.w;
        if (scrollView4 == null) {
            i.b.g("menu");
            throw null;
        }
        LinearLayout linearLayout10 = b1.x;
        if (linearLayout10 == null) {
            i.b.g("menuCol");
            throw null;
        }
        scrollView4.addView(linearLayout10, new FrameLayout.LayoutParams(-1, -2));
        ScrollView scrollView5 = b1.w;
        if (scrollView5 == null) {
            i.b.g("menu");
            throw null;
        }
        frameLayout3.addView(scrollView5, new FrameLayout.LayoutParams(-1, -1));
        linearLayout.addView(frameLayout3, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        FrameLayout frameLayout5 = b1.f42s;
        if (frameLayout5 == null) {
            i.b.g("top");
            throw null;
        }
        frameLayout5.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        Dialog dialog3 = b1.f41r;
        if (dialog3 == null) {
            i.b.g("dlg");
            throw null;
        }
        FrameLayout frameLayout6 = b1.f42s;
        if (frameLayout6 == null) {
            i.b.g("top");
            throw null;
        }
        dialog3.setContentView(frameLayout6);
        b1.c(false);
        Dialog dialog4 = b1.f41r;
        if (dialog4 == null) {
            i.b.g("dlg");
            throw null;
        }
        dialog4.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: a.s1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
                if (i4 != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                B1 b12 = B1.this;
                if (b12.D != null) {
                    b12.d();
                    return true;
                }
                ScrollView scrollView6 = b12.w;
                if (scrollView6 == null) {
                    i.b.g("menu");
                    throw null;
                }
                if (scrollView6.getVisibility() == 0) {
                    b12.j(Boolean.FALSE);
                    return true;
                }
                Dialog dialog5 = b12.f41r;
                if (dialog5 != null) {
                    dialog5.dismiss();
                    return true;
                }
                i.b.g("dlg");
                throw null;
            }
        });
        Dialog dialog5 = b1.f41r;
        if (dialog5 == null) {
            i.b.g("dlg");
            throw null;
        }
        dialog5.setOnDismissListener(new DialogInterfaceOnDismissListenerC0033i0(1, b1));
        if (b1.q) {
            Dialog dialog6 = b1.f41r;
            if (dialog6 == null) {
                i.b.g("dlg");
                throw null;
            }
            Window window3 = dialog6.getWindow();
            if (window3 != null) {
                window3.addFlags(8192);
            }
        }
        Dialog dialog7 = b1.f41r;
        if (dialog7 == null) {
            i.b.g("dlg");
            throw null;
        }
        dialog7.show();
        new Thread(new G(5, b1)).start();
    }

    public final TextView f1(String str, float f2, int i2, boolean z) {
        TextView textView = new TextView(this.f414a);
        textView.setText(str);
        textView.setTextSize(1, f2 * 0.93f);
        textView.setTextColor(i2);
        if (z) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        return textView;
    }

    public final boolean g(JSONObject jSONObject) {
        Iterator it;
        JSONObject jSONObject2;
        long j2;
        long j3;
        String str;
        Object obj;
        String str2;
        boolean z;
        long j4;
        long optLong = jSONObject.optLong("lo", 0L);
        long optLong2 = jSONObject.optLong("hi", 0L);
        JSONObject optJSONObject = jSONObject.optJSONObject("r");
        JSONArray optJSONArray = jSONObject.optJSONArray("d");
        HashSet hashSet = new HashSet();
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                hashSet.add(Long.valueOf(optJSONArray.optLong(i2)));
            }
        }
        HashMap hashMap = new HashMap();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("e");
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                if (optJSONObject2 != null) {
                    hashMap.put(Long.valueOf(optJSONObject2.optLong("id")), new b.b(optJSONObject2.optString("x"), Integer.valueOf(optJSONObject2.optInt("ed"))));
                }
            }
        }
        Iterator it2 = this.D.iterator();
        boolean z2 = false;
        while (it2.hasNext()) {
            K0 k0 = (K0) it2.next();
            long j5 = k0.f150a;
            if (j5 < optLong || (optLong2 > 0 && j5 > optLong2)) {
                it = it2;
                jSONObject2 = optJSONObject;
                j2 = optLong;
                j3 = optLong2;
            } else {
                b.b bVar = (b.b) hashMap.get(Long.valueOf(j5));
                if (bVar != null && !k0.f159j) {
                    String str3 = k0.f153d;
                    Object obj2 = bVar.f764a;
                    boolean a2 = i.b.a(str3, obj2);
                    Object obj3 = bVar.f765b;
                    if (!a2 || k0.f164o != ((Number) obj3).intValue()) {
                        k0.f153d = (String) obj2;
                        k0.f164o = ((Number) obj3).intValue();
                        z2 = true;
                    }
                }
                long j6 = k0.f150a;
                JSONArray optJSONArray3 = optJSONObject != null ? optJSONObject.optJSONArray(String.valueOf(j6)) : null;
                ArrayList arrayList = new ArrayList();
                if (optJSONArray3 != null) {
                    int length3 = optJSONArray3.length();
                    it = it2;
                    int i4 = 0;
                    while (true) {
                        jSONObject2 = optJSONObject;
                        if (i4 >= length3) {
                            break;
                        }
                        JSONArray optJSONArray4 = optJSONArray3.optJSONArray(i4);
                        if (optJSONArray4 == null) {
                            z = z2;
                            j4 = optLong;
                        } else {
                            z = z2;
                            j4 = optLong;
                            arrayList.add(new b.b(optJSONArray4.optString(0), optJSONArray4.optString(1)));
                        }
                        i4++;
                        optJSONObject = jSONObject2;
                        z2 = z;
                        optLong = j4;
                    }
                } else {
                    it = it2;
                    jSONObject2 = optJSONObject;
                }
                boolean z3 = z2;
                j2 = optLong;
                HashMap hashMap2 = this.K0;
                L0 l0 = (L0) hashMap2.get(Long.valueOf(j6));
                if (l0 != null) {
                    j3 = optLong2;
                    long currentTimeMillis = System.currentTimeMillis() - l0.f189b;
                    Iterator it3 = arrayList.iterator();
                    while (true) {
                        boolean hasNext = it3.hasNext();
                        str = this.f415b;
                        if (!hasNext) {
                            obj = null;
                            break;
                        }
                        obj = it3.next();
                        if (i.b.a(((b.b) obj).f764a, str)) {
                            break;
                        }
                    }
                    b.b bVar2 = (b.b) obj;
                    if (bVar2 == null || (str2 = (String) bVar2.f765b) == null) {
                        str2 = "";
                    }
                    String str4 = l0.f188a;
                    if (str2.equals(str4) || ((l0.f190c && currentTimeMillis > 4000) || currentTimeMillis > 25000)) {
                        hashMap2.remove(Long.valueOf(j6));
                    } else {
                        c.h.G(arrayList, new C0086x(this, 1));
                        if (str4.length() > 0) {
                            arrayList.add(new b.b(str, str4));
                        }
                    }
                } else {
                    j3 = optLong2;
                }
                HashMap hashMap3 = this.E;
                Object obj4 = (List) hashMap3.get(Long.valueOf(j6));
                if (obj4 == null) {
                    obj4 = c.j.f773a;
                }
                if (!arrayList.equals(obj4)) {
                    hashMap3.put(Long.valueOf(j6), arrayList);
                    z3 = true;
                }
                if (!hashSet.contains(Long.valueOf(j6)) || k0.f159j) {
                    it2 = it;
                    optJSONObject = jSONObject2;
                    z2 = z3;
                    optLong = j2;
                    optLong2 = j3;
                } else {
                    k0.f159j = true;
                    k0.f153d = "";
                    z2 = true;
                }
            }
            it2 = it;
            optJSONObject = jSONObject2;
            optLong = j2;
            optLong2 = j3;
        }
        return z2;
    }

    public final void g1() {
        C0002a1 c0002a1 = this.S;
        if (c0002a1 == null) {
            return;
        }
        this.S = null;
        try {
            Object systemService = this.f414a.getSystemService("connectivity");
            i.b.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ((ConnectivityManager) systemService).unregisterNetworkCallback(c0002a1);
        } catch (Exception unused) {
        }
    }

    public final void h(C0022f1 c0022f1) {
        EditText editText;
        if (this.h0 == null || i.b.a(this.U0, "idle")) {
            this.w = c0022f1;
            String str = c0022f1.f481a;
            SharedPreferences sharedPreferences = AbstractC0008c.f440c;
            if (sharedPreferences == null) {
                i.b.g("sp");
                throw null;
            }
            sharedPreferences.edit().putString("chat_theme", str).apply();
            if (this.A == null || (editText = this.h0) == null) {
                return;
            }
            String obj = editText.getText().toString();
            EditText editText2 = this.h0;
            if (editText2 == null) {
                i.b.g("input");
                throw null;
            }
            int selectionStart = editText2.getSelectionStart();
            EditText editText3 = this.h0;
            if (editText3 == null) {
                i.b.g("input");
                throw null;
            }
            boolean hasFocus = editText3.hasFocus();
            I2 i2 = this.W;
            if (i2 == null) {
                i.b.g("lv");
                throw null;
            }
            final int firstVisiblePosition = i2.getFirstVisiblePosition();
            I2 i22 = this.W;
            if (i22 == null) {
                i.b.g("lv");
                throw null;
            }
            View childAt = i22.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : 0;
            final boolean z = this.V;
            K0 k0 = this.T;
            LinearLayout linearLayout = this.g0;
            if (linearLayout == null) {
                i.b.g("panel");
                throw null;
            }
            int visibility = linearLayout.getVisibility();
            FrameLayout frameLayout = this.A;
            if (frameLayout == null) {
                i.b.g("shell");
                throw null;
            }
            frameLayout.removeAllViews();
            FrameLayout frameLayout2 = this.A;
            if (frameLayout2 == null) {
                i.b.g("shell");
                throw null;
            }
            frameLayout2.addView(j(), new FrameLayout.LayoutParams(-1, -1));
            FrameLayout frameLayout3 = this.A;
            if (frameLayout3 == null) {
                i.b.g("shell");
                throw null;
            }
            frameLayout3.addView(n(), new FrameLayout.LayoutParams(-1, -1));
            EditText editText4 = this.h0;
            if (editText4 == null) {
                i.b.g("input");
                throw null;
            }
            editText4.setText(obj);
            EditText editText5 = this.h0;
            if (editText5 == null) {
                i.b.g("input");
                throw null;
            }
            editText5.setSelection(AbstractC0008c.c(selectionStart, editText5.length()));
            if (k0 != null) {
                L0(k0);
            }
            EditText editText6 = this.h0;
            if (hasFocus) {
                if (editText6 == null) {
                    i.b.g("input");
                    throw null;
                }
                editText6.requestFocus();
            } else {
                if (editText6 == null) {
                    i.b.g("input");
                    throw null;
                }
                editText6.clearFocus();
            }
            LinearLayout linearLayout2 = this.g0;
            if (linearLayout2 == null) {
                i.b.g("panel");
                throw null;
            }
            linearLayout2.setVisibility(visibility);
            int i3 = this.N;
            this.N = -1;
            K0(i3);
            if (this.v0.length() > 0) {
                File file = z2.f758a;
                A2 a2 = this.w0;
                if (a2 == null) {
                    i.b.g("headPic");
                    throw null;
                }
                z2.f(a2, this.v0);
            }
            h1();
            i1();
            I2 i23 = this.W;
            if (i23 == null) {
                i.b.g("lv");
                throw null;
            }
            i23.post(new Runnable() { // from class: a.w0
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z2 = z;
                    C0006b1 c0006b1 = this;
                    if (!z2) {
                        I2 i24 = c0006b1.W;
                        if (i24 != null) {
                            i24.setSelectionFromTop(firstVisiblePosition, top);
                            return;
                        } else {
                            i.b.g("lv");
                            throw null;
                        }
                    }
                    I2 i25 = c0006b1.W;
                    if (i25 == null) {
                        i.b.g("lv");
                        throw null;
                    }
                    if (c0006b1.j0 != null) {
                        i25.setSelection(Math.max(r2.getCount() - 1, 0));
                    } else {
                        i.b.g("adapter");
                        throw null;
                    }
                }
            });
            C0011c2 c0011c2 = this.z;
            if (c0011c2 != null) {
                int i4 = L() ? this.w.f486f : this.f422i;
                boolean z2 = L() ? this.w.q : !this.f419f;
                int i5 = MainActivity.R;
                MainActivity mainActivity = c0011c2.f446a;
                mainActivity.e(0, i4, z2);
                View view = mainActivity.N;
                if (view != null) {
                    view.setBackgroundColor(i4);
                }
            }
            C0029h0 c0029h0 = this.y1;
            if (c0029h0 != null) {
                c0029h0.a();
            }
        }
    }

    public final void h1() {
        EditText editText = this.h0;
        if (editText == null) {
            i.b.g("input");
            throw null;
        }
        boolean R = m.e.R(editText.getText().toString());
        C1 c1 = this.C0;
        if (c1 == null) {
            i.b.g("endGlyph");
            throw null;
        }
        c1.set(R ? "like" : "send");
        String p0 = p0();
        if (!R || p0.length() <= 0) {
            TextView textView = this.D0;
            if (textView == null) {
                i.b.g("endEmoji");
                throw null;
            }
            textView.setVisibility(8);
            C1 c12 = this.C0;
            if (c12 == null) {
                i.b.g("endGlyph");
                throw null;
            }
            c12.setVisibility(0);
        } else {
            TextView textView2 = this.D0;
            if (textView2 == null) {
                i.b.g("endEmoji");
                throw null;
            }
            textView2.setText(p0);
            TextView textView3 = this.D0;
            if (textView3 == null) {
                i.b.g("endEmoji");
                throw null;
            }
            textView3.setVisibility(0);
            C1 c13 = this.C0;
            if (c13 == null) {
                i.b.g("endGlyph");
                throw null;
            }
            c13.setVisibility(8);
        }
        FrameLayout frameLayout = this.y0;
        if (frameLayout == null) {
            i.b.g("btnImg");
            throw null;
        }
        frameLayout.setVisibility(R ? 0 : 8);
        FrameLayout frameLayout2 = this.z0;
        if (frameLayout2 == null) {
            i.b.g("btnMic");
            throw null;
        }
        frameLayout2.setVisibility(R ? 0 : 8);
        LinearLayout linearLayout = this.A0;
        if (linearLayout == null) {
            i.b.g("pillRef");
            throw null;
        }
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        i.b.c(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.leftMargin = R ? 0 : z(12);
        LinearLayout linearLayout2 = this.A0;
        if (linearLayout2 != null) {
            linearLayout2.setLayoutParams(layoutParams2);
        } else {
            i.b.g("pillRef");
            throw null;
        }
    }

    public final void i(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("th") || System.currentTimeMillis() - this.x < 6000) {
            return;
        }
        String optString = jSONObject.optString("th", "");
        if (optString.length() == 0) {
            optString = "default";
        }
        if (optString.equals(this.w.f481a)) {
            return;
        }
        h(AbstractC0026g1.a(optString));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i1() {
        StringBuilder sb;
        String str;
        String str2;
        TextView textView;
        TextView textView2 = this.x0;
        if (textView2 == null) {
            i.b.g("titleTv");
            throw null;
        }
        textView2.setText(this.u0.length() == 0 ? "NixHost Group" : this.u0);
        TextView textView3 = this.Z;
        if (textView3 == null) {
            i.b.g("subTitle");
            throw null;
        }
        if (!this.G0.isEmpty()) {
            String x = x((String) this.G0.get(0));
            sb = new StringBuilder();
            sb.append(x);
            str = " is typing...";
        } else {
            if (this.F.isEmpty()) {
                str2 = "";
                textView3.setText(str2);
                boolean z = this.L;
                ArrayList arrayList = this.D;
                boolean z2 = !z && arrayList.isEmpty() && this.M.length() == 0 && this.N == 0;
                textView = this.X;
                if (textView != null) {
                    i.b.g("emptyTv");
                    throw null;
                }
                textView.setVisibility(z2 ? 0 : 8);
                if (this.M.length() <= 0 || !arrayList.isEmpty()) {
                    TextView textView4 = this.X;
                    if (textView4 == null) {
                        i.b.g("emptyTv");
                        throw null;
                    }
                    textView4.setText("No messages yet.\nSay hi to everyone 👋");
                } else {
                    TextView textView5 = this.X;
                    if (textView5 == null) {
                        i.b.g("emptyTv");
                        throw null;
                    }
                    textView5.setText(this.M);
                    TextView textView6 = this.X;
                    if (textView6 == null) {
                        i.b.g("emptyTv");
                        throw null;
                    }
                    textView6.setVisibility(0);
                }
                ProgressBar progressBar = this.Y;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                    return;
                } else {
                    i.b.g("spin");
                    throw null;
                }
            }
            int size = this.F.size();
            sb = new StringBuilder();
            sb.append(size);
            str = " members";
        }
        sb.append(str);
        str2 = sb.toString();
        textView3.setText(str2);
        boolean z3 = this.L;
        ArrayList arrayList2 = this.D;
        if (z3) {
        }
        textView = this.X;
        if (textView != null) {
        }
    }

    public final N2 j() {
        DisplayMetrics displayMetrics = this.f414a.getResources().getDisplayMetrics();
        int i2 = (int) (displayMetrics.widthPixels * 0.5f);
        int i3 = (int) (displayMetrics.heightPixels * 0.5f);
        return new N2(this.f414a, L() ? this.w : null, this.f422i, i2 < 200 ? 200 : i2, i3 < 300 ? 300 : i3);
    }

    public final LinearLayout j0(Dialog dialog, String str) {
        LinearLayout P = P();
        float f2 = 9;
        P.setPadding(z(2), z(f2), z(8), z(f2));
        Activity activity = this.f414a;
        FrameLayout frameLayout = new FrameLayout(activity);
        int i2 = this.f425l;
        float f3 = 26;
        frameLayout.addView(new G1(activity, "back", i2, 2.4f), new FrameLayout.LayoutParams(z(f3), z(f3), 17));
        n0(frameLayout, new C0060p(dialog, 4));
        float f4 = 44;
        P.addView(frameLayout, X(this, z(f4), z(f4), 0, 0, 0, 60));
        if (str != null) {
            P.addView(f1(str, 21.0f, i2, true), new LinearLayout.LayoutParams(0, -2, 1.0f));
        }
        return P;
    }

    public final A2 k(String str, float f2) {
        A2 a2 = new A2(this.f414a);
        a2.setLayoutParams(new LinearLayout.LayoutParams(z(f2), z(f2)));
        String str2 = (String) this.l0.get(str);
        if (str2 != null && str2.length() != 0) {
            z2.f(a2, str2);
        }
        return a2;
    }

    public final LinearLayout k1() {
        LinearLayout linearLayout = new LinearLayout(this.f414a);
        linearLayout.setOrientation(1);
        return linearLayout;
    }

    public final E2 l(boolean z, h.c cVar) {
        Activity activity = this.f414a;
        E2 e2 = new E2(activity);
        e2.requestWindowFeature(1);
        C0042k1 c0042k1 = new C0042k1(activity, new I0(0, e2));
        float z2 = z(21.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.f429r);
        gradientDrawable.setCornerRadii(new float[]{z2, z2, z2, z2, 0.0f, 0.0f, 0.0f, 0.0f});
        c0042k1.setBackground(gradientDrawable);
        View view = new View(activity);
        view.setBackground(N0(this.f419f ? -10131605 : -4407100, 3.0f, 0, 0.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(z(45), z(4));
        layoutParams.gravity = 1;
        layoutParams.topMargin = z(10);
        layoutParams.bottomMargin = z(6);
        c0042k1.addView(view, layoutParams);
        cVar.a(c0042k1, e2);
        c0042k1.setPadding(0, 0, 0, z(8));
        e2.setContentView(c0042k1);
        Window window = e2.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        if (window != null) {
            window.setGravity(80);
        }
        if (window != null) {
            window.setLayout(-1, -2);
        }
        if (z && window != null) {
            window.setSoftInputMode(20);
        }
        e2.f84a = c0042k1;
        c0042k1.setTranslationY(activity.getResources().getDisplayMetrics().heightPixels);
        T0(e2);
        c0042k1.post(new I(c0042k1, 0));
        return e2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r0 != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l0() {
        boolean isExternalStorageManager;
        if (Build.VERSION.SDK_INT >= 30) {
            isExternalStorageManager = Environment.isExternalStorageManager();
        }
        Activity activity = this.f414a;
        if (activity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            this.S0 = true;
            activity.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 4);
            return;
        }
        f0();
    }

    public final long l1(Uri uri) {
        Activity activity = this.f414a;
        try {
            Cursor query = activity.getContentResolver().query(uri, new String[]{"_size"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst() && !query.isNull(0)) {
                        long j2 = query.getLong(0);
                        AbstractC0008c.a(query, null);
                        return j2;
                    }
                    AbstractC0008c.a(query, null);
                } finally {
                }
            }
        } catch (Exception unused) {
        }
        try {
            AssetFileDescriptor openAssetFileDescriptor = activity.getContentResolver().openAssetFileDescriptor(uri, "r");
            if (openAssetFileDescriptor == null) {
                return 0L;
            }
            try {
                long length = openAssetFileDescriptor.getLength();
                AbstractC0008c.a(openAssetFileDescriptor, null);
                return length;
            } finally {
            }
        } catch (Exception unused2) {
            return 0L;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0733  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x07c3  */
    /* JADX WARN: Type inference failed for: r0v123, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v71, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v72, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r14v2, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.Object[], java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r3v20, types: [android.view.ViewGroup, android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r3v32, types: [android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r3v4, types: [android.view.View, android.view.ViewGroup, android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r6v20, types: [a.P2, android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v15, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View m(K0 k0, boolean z, boolean z2, boolean z3) {
        Activity activity;
        int i2;
        ArrayList arrayList;
        Activity activity2;
        int i3;
        Iterator it;
        int i4;
        int i5;
        LinearLayout linearLayout;
        boolean z4;
        boolean z5;
        boolean z6;
        int i6;
        boolean z7;
        ViewGroup viewGroup;
        int i7;
        boolean z8;
        int i8;
        boolean z9;
        TextView textView;
        boolean z10;
        int i9 = this.f420g;
        int i10 = z ? L() ? this.w.f490j : i9 : L() ? this.w.f492l : this.f423j;
        int i11 = this.f425l;
        int i12 = z ? -1 : L() ? this.w.f493m : i11;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i10);
        if (z && L()) {
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            C0022f1 c0022f1 = this.w;
            gradientDrawable.setColors(new int[]{c0022f1.f490j, c0022f1.f491k});
        }
        gradientDrawable.setCornerRadii(s0(z, z2, z3, 19.0f));
        if (!k0.f159j) {
            String str = k0.f152c;
            int hashCode = str.hashCode();
            HashSet hashSet = this.R0;
            Activity activity3 = this.f414a;
            List list = k0.f154e;
            long j2 = k0.f150a;
            switch (hashCode) {
                case 3321751:
                    activity = activity3;
                    if (str.equals("like")) {
                        C1 M = M("likebig", L() ? this.w.f491k : i9, 43);
                        ?? frameLayout = new FrameLayout(activity);
                        frameLayout.setClipChildren(false);
                        float f2 = 43;
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(z(f2), z(f2));
                        layoutParams.rightMargin = -z(7);
                        frameLayout.addView(M, layoutParams);
                        float f3 = 2;
                        frameLayout.setPadding(z(4), z(f3), 0, z(f3));
                        textView = frameLayout;
                        break;
                    }
                    TextView textView2 = new TextView(activity);
                    textView2.setText(k0.f153d);
                    textView2.setMaxWidth(Math.min(z(this.k0), (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.68f)));
                    textView2.setTextIsSelectable(false);
                    if (!D(k0.f153d)) {
                        textView2.setTextSize(1, 19.065f);
                        textView2.setTextColor(i12);
                        float f4 = 14;
                        float f5 = 9;
                        textView2.setPadding(z(f4), z(f5), z(f4), z(f5));
                        textView2.setBackground(gradientDrawable);
                        textView = textView2;
                        break;
                    } else {
                        String str2 = k0.f153d;
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i13 = 0; i13 < length; i13++) {
                            char charAt = str2.charAt(i13);
                            if (!(Character.isWhitespace(charAt) || Character.isSpaceChar(charAt))) {
                                sb.append(charAt);
                            }
                        }
                        String sb2 = sb.toString();
                        i.b.d(sb2, "toString(...)");
                        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
                        characterInstance.setText(sb2);
                        StringBuilder sb3 = new StringBuilder();
                        int first = characterInstance.first();
                        int next = characterInstance.next();
                        int i14 = 0;
                        while (true) {
                            int i15 = next;
                            int i16 = first;
                            first = i15;
                            if (first == -1) {
                                textView2.setText(sb3.toString());
                                textView2.setTextSize(1, 46.5f);
                                textView2.setPadding(0, 0, 0, 0);
                                textView2.setTranslationX(z ? z(4.0f) : -z(4.0f));
                                textView = textView2;
                                break;
                            } else {
                                if (i14 > 0 && i14 % 3 == 0) {
                                    sb3.append('\n');
                                }
                                sb3.append((CharSequence) sb2, i16, first);
                                i14++;
                                next = characterInstance.next();
                            }
                        }
                    }
                    break;
                case 100313435:
                    if (str.equals("image")) {
                        boolean z11 = z || !z2;
                        boolean z12 = (z && z2) ? false : true;
                        boolean z13 = z || !z3;
                        boolean z14 = (z && z3) ? false : true;
                        ?? k1 = k1();
                        int z15 = z(166);
                        int z16 = z(2.7f);
                        if (list.size() == 1) {
                            String str3 = (String) list.get(0);
                            ImageView Q = Q(str3, v(z11, z12, z14, z13), 1280, new G0(this, str3, k1, 0), new D(this, str3, k0, 3));
                            Float f6 = (Float) z2.f763f.get(str3);
                            k1.addView(Q, f6 != null ? U0(f6.floatValue()) : new LinearLayout.LayoutParams(z15, z(200)));
                        } else {
                            int i17 = (z15 - z16) / 2;
                            ArrayList arrayList2 = new ArrayList();
                            if (list.size() % 2 == 1) {
                                arrayList2.add(AbstractC0008c.p(list.get(0)));
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            while (true) {
                                int i18 = i2 + 1;
                                int i19 = i17;
                                if (i18 < list.size()) {
                                    arrayList2.add(c.c.C(new String[]{list.get(i2), list.get(i18)}));
                                    i2 += 2;
                                    i17 = i19;
                                    z16 = z16;
                                } else {
                                    int i20 = z16;
                                    Iterator it2 = arrayList2.iterator();
                                    int i21 = 0;
                                    while (it2.hasNext()) {
                                        int i22 = i21 + 1;
                                        List list2 = (List) it2.next();
                                        boolean z17 = i21 == 0;
                                        boolean z18 = i21 == arrayList2.size() - 1;
                                        LinearLayout linearLayout2 = new LinearLayout(activity3);
                                        linearLayout2.setOrientation(0);
                                        ArrayList arrayList3 = arrayList2;
                                        if (list2.size() == 1) {
                                            String str4 = (String) list2.get(0);
                                            boolean z19 = z17 && z11;
                                            boolean z20 = z17 && z12;
                                            if (z18 && z14) {
                                                i7 = i21;
                                                z8 = true;
                                            } else {
                                                i7 = i21;
                                                z8 = false;
                                            }
                                            if (z18 && z13) {
                                                i8 = z15;
                                                z9 = true;
                                            } else {
                                                i8 = z15;
                                                z9 = false;
                                            }
                                            arrayList = arrayList3;
                                            int i23 = i19;
                                            it = it2;
                                            i4 = i20;
                                            i5 = i7;
                                            activity2 = activity3;
                                            i3 = i8;
                                            linearLayout2.addView(Q(str4, v(z19, z20, z8, z9), 800, null, new A0(this, list2, k0, 1)), new LinearLayout.LayoutParams(i3, i23));
                                            z5 = z11;
                                            z7 = z12;
                                            z6 = z13;
                                            viewGroup = linearLayout2;
                                            i6 = i23;
                                        } else {
                                            arrayList = arrayList3;
                                            activity2 = activity3;
                                            i3 = z15;
                                            int i24 = i19;
                                            it = it2;
                                            i4 = i20;
                                            i5 = i21;
                                            String str5 = (String) list2.get(0);
                                            boolean z21 = z17 && z11;
                                            if (z18 && z13) {
                                                linearLayout = linearLayout2;
                                                z4 = true;
                                            } else {
                                                linearLayout = linearLayout2;
                                                z4 = false;
                                            }
                                            z5 = z11;
                                            LinearLayout linearLayout3 = linearLayout;
                                            z6 = z13;
                                            i6 = i24;
                                            linearLayout3.addView(Q(str5, v(z21, false, false, z4), 480, null, new A0(this, list2, k0, 2)), new LinearLayout.LayoutParams(i6, i6));
                                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i6, i6);
                                            layoutParams2.leftMargin = i4;
                                            String str6 = (String) list2.get(1);
                                            boolean z22 = z17 && z12;
                                            z7 = z12;
                                            viewGroup = linearLayout3;
                                            viewGroup.addView(Q(str6, v(false, z22, z18 && z14, false), 480, null, new A0(this, list2, k0, 3)), layoutParams2);
                                        }
                                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i3, -2);
                                        if (i5 > 0) {
                                            layoutParams3.topMargin = i4;
                                        }
                                        k1.addView(viewGroup, layoutParams3);
                                        i20 = i4;
                                        z15 = i3;
                                        i21 = i22;
                                        z12 = z7;
                                        activity3 = activity2;
                                        arrayList2 = arrayList;
                                        z11 = z5;
                                        it2 = it;
                                        i19 = i6;
                                        z13 = z6;
                                    }
                                }
                            }
                        }
                        Activity activity4 = activity3;
                        if (hashSet.contains(Long.valueOf(j2))) {
                            ?? frameLayout2 = new FrameLayout(activity4);
                            frameLayout2.addView(k1, new FrameLayout.LayoutParams(-2, -2));
                            float f7 = 46;
                            frameLayout2.addView(new F2(activity4), new FrameLayout.LayoutParams(z(f7), z(f7), 17));
                            textView = frameLayout2;
                            break;
                        } else {
                            textView = k1;
                            break;
                        }
                    }
                    activity = activity3;
                    TextView textView22 = new TextView(activity);
                    textView22.setText(k0.f153d);
                    textView22.setMaxWidth(Math.min(z(this.k0), (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.68f)));
                    textView22.setTextIsSelectable(false);
                    if (!D(k0.f153d)) {
                    }
                    break;
                case 112202875:
                    if (str.equals("video")) {
                        boolean z23 = z || !z2;
                        boolean z24 = (z && z2) ? false : true;
                        boolean z25 = z || !z3;
                        boolean z26 = (z && z3) ? false : true;
                        String str7 = (String) c.b.I(list);
                        if (str7 == null) {
                            str7 = "";
                        }
                        String str8 = str7;
                        FrameLayout frameLayout3 = new FrameLayout(activity3);
                        ImageView Q2 = Q(str8, v(z23, z24, z26, z25), 800, new B0(this, frameLayout3, 1), new C0005b0(this, k0, 5));
                        Float f8 = (Float) z2.f763f.get(str8);
                        LinearLayout.LayoutParams U0 = f8 != null ? U0(f8.floatValue()) : new LinearLayout.LayoutParams(z(166), z(200));
                        frameLayout3.addView(Q2, new FrameLayout.LayoutParams(-1, -1));
                        if (hashSet.contains(Long.valueOf(j2))) {
                            float f9 = 46;
                            frameLayout3.addView(new F2(activity3), new FrameLayout.LayoutParams(z(f9), z(f9), 17));
                        } else {
                            FrameLayout frameLayout4 = new FrameLayout(activity3);
                            frameLayout4.setBackground(i0(-1290003426));
                            float f10 = 26;
                            frameLayout4.addView(M("play", -1, 26), new FrameLayout.LayoutParams(z(f10), z(f10), 17));
                            float f11 = 46;
                            frameLayout3.addView(frameLayout4, new FrameLayout.LayoutParams(z(f11), z(f11), 17));
                        }
                        int i25 = k0.f156g;
                        if (i25 > 0) {
                            TextView f1 = f1(G(i25), 16.0f, -1, false);
                            float f12 = 8;
                            float f13 = 3;
                            f1.setPadding(z(f12), z(f13), z(f12), z(f13));
                            z10 = false;
                            f1.setBackground(N0(-870638819, 9.0f, 0, 0.0f));
                            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2, 8388693);
                            layoutParams4.setMargins(0, 0, z(f12), z(f12));
                            frameLayout3.addView(f1, layoutParams4);
                        } else {
                            z10 = false;
                        }
                        ?? P = P();
                        P.setClipChildren(z10);
                        P.addView(frameLayout3, U0);
                        textView = P;
                        break;
                    }
                    activity = activity3;
                    TextView textView222 = new TextView(activity);
                    textView222.setText(k0.f153d);
                    textView222.setMaxWidth(Math.min(z(this.k0), (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.68f)));
                    textView222.setTextIsSelectable(false);
                    if (!D(k0.f153d)) {
                    }
                    break;
                case 112386354:
                    if (str.equals("voice")) {
                        ?? P2 = P();
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        gradientDrawable2.setColor(i10);
                        gradientDrawable2.setCornerRadii(s0(z, z2, z3, 14.5f));
                        P2.setBackground(gradientDrawable2);
                        float f14 = 9;
                        P2.setPadding(z(13.5f), z(f14), z(15), z(f14));
                        int i26 = z ? -1 : i11;
                        C1 M2 = M("play", i26, 30);
                        float f15 = 30;
                        LinearLayout.LayoutParams X = X(this, z(f15), z(f15), 0, 0, 0, 60);
                        X.rightMargin = z(8.5f);
                        P2.addView(M2, X);
                        ?? p2 = new P2(activity3, z(3.2f), z(3.2f));
                        p2.setFg(i26);
                        ?? r0 = k0.f155f;
                        if (r0.isEmpty()) {
                            r0 = new ArrayList(40);
                            for (int i27 = 0; i27 < 40; i27++) {
                                r0.add(20);
                            }
                        }
                        p2.setValues(r0);
                        P2.addView(p2, new LinearLayout.LayoutParams(z(Math.min(143, (Math.max(0, ((k0.f156g + 500) / 1000) - 8) * 3) + 113)), z(52)));
                        LinearLayout k12 = k1();
                        k12.setGravity(1);
                        k12.addView(f1(G(k0.f156g), 16.0f, i26, true), X(this, -2, -2, 0, 0, 0, 60));
                        TextView f16 = f1(V0(this.l1), 13.5f, i26, true);
                        f16.setGravity(17);
                        f16.setMinWidth(z(42));
                        float f17 = 8;
                        float f18 = 3;
                        f16.setPadding(z(f17), z(f18), z(f17), z(f18));
                        f16.setBackground(N0((16777215 & i26) | 939524096, 9.0f, 0, 0.0f));
                        f16.setVisibility(this.h1 == j2 ? 0 : 8);
                        n0(f16, new C0036j(this, 13));
                        k12.addView(f16, W(-2, -2, 0, 3, 0, 0));
                        P2.addView(k12, W(z(48), -2, 8, 0, 0, 0));
                        this.j1.put(Long.valueOf(j2), M2);
                        this.i1.put(Long.valueOf(j2), p2);
                        this.n1.put(Long.valueOf(j2), f16);
                        if (this.h1 == j2) {
                            try {
                                MediaPlayer mediaPlayer = this.g1;
                                M2.set((mediaPlayer == null || !mediaPlayer.isPlaying()) ? "play" : "pause");
                            } catch (Exception unused) {
                            }
                        } else if (this.m1 == j2) {
                            M2.set("load");
                        }
                        n0(M2, new C0005b0(this, k0, 3));
                        String str9 = (String) c.b.I(list);
                        if (str9 != null && !m.m.K(str9, "L") && !e0()) {
                            File c2 = z2.c(str9);
                            if (!c2.exists() || c2.length() <= 0) {
                                HashSet hashSet2 = this.p1;
                                if (hashSet2.add(str9)) {
                                    try {
                                        this.o1.execute(new RunnableC0032i(str9, this, 0));
                                    } catch (Exception unused2) {
                                        hashSet2.remove(str9);
                                    }
                                }
                            }
                        }
                        textView = P2;
                        break;
                    }
                    activity = activity3;
                    TextView textView2222 = new TextView(activity);
                    textView2222.setText(k0.f153d);
                    textView2222.setMaxWidth(Math.min(z(this.k0), (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.68f)));
                    textView2222.setTextIsSelectable(false);
                    if (!D(k0.f153d)) {
                    }
                    break;
                default:
                    activity = activity3;
                    TextView textView22222 = new TextView(activity);
                    textView22222.setText(k0.f153d);
                    textView22222.setMaxWidth(Math.min(z(this.k0), (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.68f)));
                    textView22222.setTextIsSelectable(false);
                    if (!D(k0.f153d)) {
                    }
                    break;
            }
        } else {
            TextView f19 = f1(z ? "You deleted a message" : x(k0.f151b) + " deleted a message", 20.5f, K(), false);
            float f20 = 14;
            float f21 = 9;
            f19.setPadding(z(f20), z(f21), z(f20), z(f21));
            f19.setSingleLine(false);
            f19.setMaxLines(Integer.MAX_VALUE);
            f19.setEllipsize(null);
            f19.setMaxWidth(z(28) + ((int) Math.ceil(f19.getPaint().measureText("You deleted a "))));
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setColor(L() ? 587202559 : this.f422i);
            gradientDrawable3.setStroke(z(1), L() ? K() : this.f427n);
            gradientDrawable3.setCornerRadii(s0(z, z2, z3, 19.0f));
            f19.setBackground(gradientDrawable3);
            textView = f19;
        }
        if (k0.f159j || S(k0)) {
            textView.setOnLongClickListener(new ViewOnLongClickListenerC0065q0());
        } else {
            J0(textView, k0);
        }
        return textView;
    }

    public final void m1(K0 k0, String str) {
        if (a0(AbstractC0008c.p(str), false)) {
            return;
        }
        Activity activity = this.f414a;
        Dialog dialog = new Dialog(activity, R.style.Theme.Black.NoTitleBar);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
        }
        final FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setBackgroundColor(-16777216);
        LinearLayout k1 = k1();
        frameLayout.addView(k1, new FrameLayout.LayoutParams(-1, -1));
        LinearLayout P = P();
        float f2 = 8;
        P.setPadding(z(f2), z(f2), z(f2), z(f2));
        FrameLayout frameLayout2 = new FrameLayout(activity);
        float f3 = 26;
        frameLayout2.addView(new G1(activity, "close", -1, 2.4f), new FrameLayout.LayoutParams(z(f3), z(f3), 17));
        n0(frameLayout2, new C0060p(dialog, 0));
        float f4 = 44;
        P.addView(frameLayout2, X(this, z(f4), z(f4), 0, 0, 0, 60));
        P.addView(new View(activity), new LinearLayout.LayoutParams(0, 1, 1.0f));
        FrameLayout frameLayout3 = new FrameLayout(activity);
        frameLayout3.addView(M("download", -1, 26), new FrameLayout.LayoutParams(z(f3), z(f3), 17));
        P.addView(frameLayout3, X(this, z(f4), z(f4), 0, 0, 0, 60));
        k1.addView(P, new LinearLayout.LayoutParams(-1, -2));
        R2 r2 = new R2(activity);
        r2.setBackgroundColor(-16777216);
        z2.e(r2, str, 1600, null);
        k1.addView(r2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        TextView f1 = f1("", 17.0f, -1, false);
        float f5 = 16;
        f1.setPadding(z(f5), z(f2), z(f5), z(f2));
        f1.setBackground(N0(-869651924, 20.0f, 0, 0.0f));
        f1.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 81);
        layoutParams.bottomMargin = z(84);
        frameLayout.addView(f1, layoutParams);
        final RunnableC0064q runnableC0064q = new RunnableC0064q(f1, 0);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: a.r
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                FrameLayout frameLayout4 = frameLayout;
                C0006b1 c0006b1 = C0006b1.this;
                c0006b1.f418e.removeCallbacks(runnableC0064q);
                try {
                    Object systemService = c0006b1.f414a.getSystemService("input_method");
                    i.b.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                    ((InputMethodManager) systemService).hideSoftInputFromWindow(frameLayout4.getWindowToken(), 0);
                } catch (Exception unused) {
                }
            }
        });
        n0(frameLayout3, new C0071s(f1, this, runnableC0064q, str, 0));
        if (k0 != null && !k0.f159j) {
            String str2 = k0.f151b;
            String x = i.b.a(str2, this.f415b) ? "yourself" : x(str2);
            LinearLayout P2 = P();
            P2.setBackgroundColor(-14935010);
            float f6 = 12;
            float f7 = 10;
            P2.setPadding(z(f6), z(f7), z(f2), z(f7));
            LinearLayout P3 = P();
            P3.setBackground(N0(-12961220, 26.0f, 0, 0.0f));
            P3.setPadding(z(18), 0, z(14), 0);
            EditText editText = new EditText(activity);
            editText.setBackground(null);
            editText.setHint("Reply to " + x);
            editText.setHintTextColor(-5196872);
            editText.setTextColor(-1);
            editText.setTextSize(1, 18.6f);
            editText.setPadding(0, z(f6), 0, z(f6));
            editText.setInputType(147457);
            editText.setMaxLines(4);
            P3.addView(editText, new LinearLayout.LayoutParams(0, -2, 1.0f));
            P2.addView(P3, new LinearLayout.LayoutParams(0, -2, 1.0f));
            FrameLayout frameLayout4 = new FrameLayout(activity);
            float f8 = 30;
            frameLayout4.addView(M("send", -1, 30), new FrameLayout.LayoutParams(z(f8), z(f8), 17));
            n0(frameLayout4, new C0071s(editText, this, k0, dialog, 1));
            P2.addView(frameLayout4, W(z(52), z(48), 4, 0, 0, 0));
            k1.addView(P2, new LinearLayout.LayoutParams(-1, -2));
        }
        dialog.setContentView(frameLayout);
        T0(dialog);
    }

    public final LinearLayout n() {
        LinearLayout k1 = k1();
        LinearLayout P = P();
        float f2 = 9;
        float f3 = 8;
        P.setPadding(z(2), z(f2) + this.y, z(f3), z(f2));
        P.setBackgroundColor(L() ? this.w.f494n : 0);
        this.B = P;
        Activity activity = this.f414a;
        FrameLayout frameLayout = new FrameLayout(activity);
        float f4 = 26;
        frameLayout.addView(new G1(activity, "back", J(), 2.4f), new FrameLayout.LayoutParams(z(f4), z(f4), 17));
        n0(frameLayout, new C0036j(this, 21));
        float f5 = 44;
        P.addView(frameLayout, X(this, z(f5), z(f5), 0, 0, 0, 60));
        A2 a2 = new A2(activity);
        this.w0 = a2;
        float f6 = 39;
        P.addView(a2, X(this, z(f6), z(f6), 5, 0, 10, 32));
        LinearLayout k12 = k1();
        TextView f1 = f1("NixHost Group", 21.0f, J(), true);
        this.x0 = f1;
        f1.setSingleLine(true);
        TextView textView = this.x0;
        if (textView == null) {
            i.b.g("titleTv");
            throw null;
        }
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        TextView textView2 = this.x0;
        if (textView2 == null) {
            i.b.g("titleTv");
            throw null;
        }
        k12.addView(textView2);
        TextView f12 = f1("", 13.0f, K(), false);
        this.Z = f12;
        k12.addView(f12);
        P.addView(k12, new LinearLayout.LayoutParams(0, -2, 1.0f));
        FrameLayout frameLayout2 = new FrameLayout(activity);
        frameLayout2.addView(M("gear", J(), 26), new FrameLayout.LayoutParams(z(f4), z(f4), 17));
        n0(frameLayout2, new C0036j(this, 1));
        float f7 = 40;
        P.addView(frameLayout2, X(this, z(f7), z(f7), 0, 0, 0, 60));
        k1.addView(P, X(this, -1, -2, 0, 0, 0, 60));
        View view = new View(activity);
        view.setBackgroundColor(L() ? 0 : this.f428o);
        k1.addView(view, X(this, -1, 1, 0, 0, 0, 60));
        LinearLayout P2 = P();
        this.P = P2;
        P2.setGravity(17);
        LinearLayout linearLayout = this.P;
        if (linearLayout == null) {
            i.b.g("netBar");
            throw null;
        }
        boolean L = L();
        int i2 = this.f422i;
        linearLayout.setBackgroundColor(L ? this.w.f495o : i2);
        LinearLayout linearLayout2 = this.P;
        if (linearLayout2 == null) {
            i.b.g("netBar");
            throw null;
        }
        float f8 = 16;
        float f9 = 10;
        linearLayout2.setPadding(z(f8), z(f9), z(f8), z(f9));
        FrameLayout frameLayout3 = new FrameLayout(activity);
        this.Q = frameLayout3;
        float f10 = 24;
        frameLayout3.addView(M("wifioff", K(), 24), new FrameLayout.LayoutParams(z(f10), z(f10), 17));
        LinearLayout linearLayout3 = this.P;
        if (linearLayout3 == null) {
            i.b.g("netBar");
            throw null;
        }
        FrameLayout frameLayout4 = this.Q;
        if (frameLayout4 == null) {
            i.b.g("netIcon");
            throw null;
        }
        linearLayout3.addView(frameLayout4, X(this, z(f10), z(f10), 0, 0, 10, 32));
        TextView f13 = f1("No internet connection", 19.0f, K(), false);
        this.R = f13;
        LinearLayout linearLayout4 = this.P;
        if (linearLayout4 == null) {
            i.b.g("netBar");
            throw null;
        }
        linearLayout4.addView(f13, X(this, -2, -2, 0, 0, 0, 60));
        LinearLayout linearLayout5 = this.P;
        if (linearLayout5 == null) {
            i.b.g("netBar");
            throw null;
        }
        linearLayout5.setVisibility(8);
        View view2 = this.P;
        if (view2 == null) {
            i.b.g("netBar");
            throw null;
        }
        k1.addView(view2, X(this, -1, -2, 0, 0, 0, 60));
        FrameLayout frameLayout5 = new FrameLayout(activity);
        I2 i22 = new I2(activity);
        this.W = i22;
        i22.setHook(new C0086x(this, 0));
        I2 i23 = this.W;
        if (i23 == null) {
            i.b.g("lv");
            throw null;
        }
        i23.setDivider(null);
        I2 i24 = this.W;
        if (i24 == null) {
            i.b.g("lv");
            throw null;
        }
        i24.setDividerHeight(0);
        I2 i25 = this.W;
        if (i25 == null) {
            i.b.g("lv");
            throw null;
        }
        i25.setSelector(new ColorDrawable(0));
        I2 i26 = this.W;
        if (i26 == null) {
            i.b.g("lv");
            throw null;
        }
        i26.setCacheColorHint(0);
        I2 i27 = this.W;
        if (i27 == null) {
            i.b.g("lv");
            throw null;
        }
        i27.setVerticalScrollBarEnabled(false);
        I2 i28 = this.W;
        if (i28 == null) {
            i.b.g("lv");
            throw null;
        }
        i28.setClipToPadding(false);
        I2 i29 = this.W;
        if (i29 == null) {
            i.b.g("lv");
            throw null;
        }
        i29.setPadding(0, z(f3), 0, z(f9));
        O0 o0 = new O0(0, this);
        this.j0 = o0;
        I2 i210 = this.W;
        if (i210 == null) {
            i.b.g("lv");
            throw null;
        }
        i210.setAdapter((ListAdapter) o0);
        I2 i211 = this.W;
        if (i211 == null) {
            i.b.g("lv");
            throw null;
        }
        i211.setOnScrollListener(new P0(this));
        I2 i212 = this.W;
        if (i212 == null) {
            i.b.g("lv");
            throw null;
        }
        i212.addOnLayoutChangeListener(new E(0, this));
        I2 i213 = this.W;
        if (i213 == null) {
            i.b.g("lv");
            throw null;
        }
        frameLayout5.addView(i213, new FrameLayout.LayoutParams(-1, -1));
        TextView f14 = f1("No messages yet.\nSay hi to everyone 👋", 16.0f, K(), false);
        this.X = f14;
        f14.setGravity(17);
        TextView textView3 = this.X;
        if (textView3 == null) {
            i.b.g("emptyTv");
            throw null;
        }
        textView3.setVisibility(8);
        TextView textView4 = this.X;
        if (textView4 == null) {
            i.b.g("emptyTv");
            throw null;
        }
        frameLayout5.addView(textView4, new FrameLayout.LayoutParams(-2, -2, 17));
        ProgressBar progressBar = new ProgressBar(activity);
        this.Y = progressBar;
        float f11 = 30;
        frameLayout5.addView(progressBar, new FrameLayout.LayoutParams(z(f11), z(f11), 17));
        k1.addView(frameLayout5, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        TextView f15 = f1("", 13.0f, K(), false);
        this.a0 = f15;
        float f16 = 4;
        f15.setPadding(z(f8), z(f16), z(f8), z(f16));
        TextView textView5 = this.a0;
        if (textView5 == null) {
            i.b.g("statusTv");
            throw null;
        }
        textView5.setVisibility(8);
        View view3 = this.a0;
        if (view3 == null) {
            i.b.g("statusTv");
            throw null;
        }
        k1.addView(view3, X(this, -1, -2, 0, 0, 0, 60));
        LinearLayout P3 = P();
        this.b0 = P3;
        P3.setBackgroundColor(L() ? this.w.f495o : i2);
        LinearLayout linearLayout6 = this.b0;
        if (linearLayout6 == null) {
            i.b.g("replyBar");
            throw null;
        }
        linearLayout6.setPadding(z(f8), z(f2), z(12), z(f2));
        LinearLayout k13 = k1();
        this.d0 = f1("", 18.0f, J(), false);
        TextView f17 = f1("", 16.0f, K(), false);
        this.e0 = f17;
        f17.setSingleLine(true);
        TextView textView6 = this.e0;
        if (textView6 == null) {
            i.b.g("replyTxt");
            throw null;
        }
        textView6.setEllipsize(truncateAt);
        TextView textView7 = this.d0;
        if (textView7 == null) {
            i.b.g("replyWho");
            throw null;
        }
        k13.addView(textView7);
        TextView textView8 = this.e0;
        if (textView8 == null) {
            i.b.g("replyTxt");
            throw null;
        }
        k13.addView(textView8);
        LinearLayout linearLayout7 = this.b0;
        if (linearLayout7 == null) {
            i.b.g("replyBar");
            throw null;
        }
        linearLayout7.addView(k13, new LinearLayout.LayoutParams(0, -2, 1.0f));
        FrameLayout frameLayout6 = new FrameLayout(activity);
        float f18 = 18;
        frameLayout6.addView(new G1(activity, "close", K(), 2.2f), new FrameLayout.LayoutParams(z(f18), z(f18), 17));
        n0(frameLayout6, new C0036j(this, 2));
        LinearLayout linearLayout8 = this.b0;
        if (linearLayout8 == null) {
            i.b.g("replyBar");
            throw null;
        }
        float f19 = 34;
        linearLayout8.addView(frameLayout6, X(this, z(f19), z(f19), 0, 0, 0, 60));
        LinearLayout linearLayout9 = this.b0;
        if (linearLayout9 == null) {
            i.b.g("replyBar");
            throw null;
        }
        linearLayout9.setVisibility(8);
        View view4 = new View(activity);
        this.c0 = view4;
        boolean L2 = L();
        int i3 = this.p;
        view4.setBackgroundColor(L2 ? 0 : i3);
        View view5 = this.c0;
        if (view5 == null) {
            i.b.g("replyTop");
            throw null;
        }
        view5.setVisibility(8);
        View view6 = this.c0;
        if (view6 == null) {
            i.b.g("replyTop");
            throw null;
        }
        k1.addView(view6, X(this, -1, 1, 0, 0, 0, 60));
        View view7 = this.b0;
        if (view7 == null) {
            i.b.g("replyBar");
            throw null;
        }
        k1.addView(view7, X(this, -1, -2, 0, 0, 0, 60));
        View view8 = new View(activity);
        if (L()) {
            i3 = 0;
        }
        view8.setBackgroundColor(i3);
        k1.addView(view8, X(this, -1, 1, 0, 0, 0, 60));
        FrameLayout frameLayout7 = new FrameLayout(activity);
        this.f0 = frameLayout7;
        frameLayout7.setBackgroundColor(L() ? this.w.f495o : 0);
        LinearLayout P4 = P();
        P4.setPadding(0, z(f2), z(5), z(f3));
        FrameLayout frameLayout8 = new FrameLayout(activity);
        frameLayout8.addView(M("image", I(), 30), new FrameLayout.LayoutParams(z(f11), z(f11), 17));
        n0(frameLayout8, new C0036j(this, 7));
        this.y0 = frameLayout8;
        float f20 = 46;
        P4.addView(frameLayout8, X(this, z(f20), z(f20), 0, 0, 0, 60));
        FrameLayout frameLayout9 = new FrameLayout(activity);
        frameLayout9.addView(M("mic", I(), 30), new FrameLayout.LayoutParams(z(f11), z(f11), 17));
        n0(frameLayout9, new C0036j(this, 8));
        this.z0 = frameLayout9;
        P4.addView(frameLayout9, X(this, z(f20), z(f20), 0, 0, 0, 60));
        LinearLayout P5 = P();
        P5.setBackground(N0(L() ? this.w.p : this.f424k, 24.0f, 0, 0.0f));
        P5.setPadding(z(19), 0, z(1), 0);
        P5.setMinimumHeight(z(47));
        this.A0 = P5;
        EditText editText = new EditText(activity);
        this.h0 = editText;
        editText.setBackground(null);
        EditText editText2 = this.h0;
        if (editText2 == null) {
            i.b.g("input");
            throw null;
        }
        editText2.setHint("Message");
        EditText editText3 = this.h0;
        if (editText3 == null) {
            i.b.g("input");
            throw null;
        }
        editText3.setHintTextColor(K());
        EditText editText4 = this.h0;
        if (editText4 == null) {
            i.b.g("input");
            throw null;
        }
        editText4.setTextColor(J());
        EditText editText5 = this.h0;
        if (editText5 == null) {
            i.b.g("input");
            throw null;
        }
        editText5.setTextSize(1, 19.251001f);
        EditText editText6 = this.h0;
        if (editText6 == null) {
            i.b.g("input");
            throw null;
        }
        editText6.setPadding(0, z(f9), 0, z(f9));
        EditText editText7 = this.h0;
        if (editText7 == null) {
            i.b.g("input");
            throw null;
        }
        editText7.setInputType(147457);
        EditText editText8 = this.h0;
        if (editText8 == null) {
            i.b.g("input");
            throw null;
        }
        editText8.setMaxLines(5);
        EditText editText9 = this.h0;
        if (editText9 == null) {
            i.b.g("input");
            throw null;
        }
        editText9.setOnClickListener(new ViewOnClickListenerC0074t(3, this));
        EditText editText10 = this.h0;
        if (editText10 == null) {
            i.b.g("input");
            throw null;
        }
        editText10.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: a.l0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view9, boolean z) {
                if (z) {
                    LinearLayout linearLayout10 = C0006b1.this.g0;
                    if (linearLayout10 != null) {
                        linearLayout10.setVisibility(8);
                    } else {
                        i.b.g("panel");
                        throw null;
                    }
                }
            }
        });
        EditText editText11 = this.h0;
        if (editText11 == null) {
            i.b.g("input");
            throw null;
        }
        editText11.addTextChangedListener(new R0(0, this));
        EditText editText12 = this.h0;
        if (editText12 == null) {
            i.b.g("input");
            throw null;
        }
        P5.addView(editText12, new LinearLayout.LayoutParams(0, -2, 1.0f));
        FrameLayout frameLayout10 = new FrameLayout(activity);
        frameLayout10.addView(M("face", I(), 30), new FrameLayout.LayoutParams(z(f11), z(f11), 17));
        n0(frameLayout10, new C0036j(this, 9));
        float f21 = 38;
        P5.addView(frameLayout10, X(this, z(f21), z(f21), 0, 0, 0, 60));
        LinearLayout.LayoutParams X = X(this, 0, -2, 0, 0, 0, 60);
        X.weight = 1.0f;
        P4.addView(P5, X);
        this.B0 = new FrameLayout(activity);
        C1 M = M("like", I(), 30);
        this.C0 = M;
        FrameLayout frameLayout11 = this.B0;
        if (frameLayout11 == null) {
            i.b.g("btnEnd");
            throw null;
        }
        frameLayout11.addView(M, new FrameLayout.LayoutParams(z(f11), z(f11), 17));
        TextView textView9 = new TextView(activity);
        this.D0 = textView9;
        textView9.setTextSize(1, 25.11f);
        TextView textView10 = this.D0;
        if (textView10 == null) {
            i.b.g("endEmoji");
            throw null;
        }
        textView10.setGravity(17);
        TextView textView11 = this.D0;
        if (textView11 == null) {
            i.b.g("endEmoji");
            throw null;
        }
        textView11.setVisibility(8);
        FrameLayout frameLayout12 = this.B0;
        if (frameLayout12 == null) {
            i.b.g("btnEnd");
            throw null;
        }
        TextView textView12 = this.D0;
        if (textView12 == null) {
            i.b.g("endEmoji");
            throw null;
        }
        frameLayout12.addView(textView12, new FrameLayout.LayoutParams(z(f7), z(f7), 17));
        FrameLayout frameLayout13 = this.B0;
        if (frameLayout13 == null) {
            i.b.g("btnEnd");
            throw null;
        }
        n0(frameLayout13, new C0036j(this, 10));
        View view9 = this.B0;
        if (view9 == null) {
            i.b.g("btnEnd");
            throw null;
        }
        P4.addView(view9, X(this, z(f20), z(f20), 0, 0, 0, 60));
        this.i0 = P4;
        FrameLayout frameLayout14 = this.f0;
        if (frameLayout14 == null) {
            i.b.g("holder");
            throw null;
        }
        frameLayout14.addView(P4, new FrameLayout.LayoutParams(-1, -2));
        View view10 = this.f0;
        if (view10 == null) {
            i.b.g("holder");
            throw null;
        }
        k1.addView(view10, X(this, -1, -2, 0, 0, 0, 60));
        LinearLayout o2 = o(new C0086x(this, 2), new C0036j(this, 3));
        this.g0 = o2;
        o2.setVisibility(8);
        View view11 = this.g0;
        if (view11 == null) {
            i.b.g("panel");
            throw null;
        }
        k1.addView(view11, X(this, -1, z(300), 0, 0, 0, 60));
        h1();
        i1();
        return k1;
    }

    public final LinearLayout o(C0086x c0086x, C0036j c0036j) {
        LinearLayout k1 = k1();
        int i2 = this.f422i;
        k1.setBackgroundColor(i2);
        LinearLayout P = P();
        P.setGravity(17);
        boolean z = this.f419f;
        P.setBackgroundColor(z ? -14934754 : -1249551);
        float f2 = 8;
        P.setPadding(0, z(f2), 0, z(f2));
        Activity activity = this.f414a;
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setBackground(N0(z ? -12960964 : -2894117, 22.0f, 0, 0.0f));
        int i3 = this.f425l;
        C1 M = M("smile", i3, 26);
        M.setCut(z ? -12960964 : -2894117);
        float f3 = 26;
        frameLayout.addView(M, new FrameLayout.LayoutParams(z(f3), z(f3), 17));
        float f4 = 86;
        float f5 = 44;
        P.addView(frameLayout, X(this, z(f4), z(f5), 0, 0, 30, 32));
        FrameLayout frameLayout2 = new FrameLayout(activity);
        int i4 = this.f426m;
        frameLayout2.addView(M("sticker", i4, 26), new FrameLayout.LayoutParams(z(f3), z(f3), 17));
        n0(frameLayout2, new C0036j(this, 11));
        P.addView(frameLayout2, X(this, z(f4), z(f5), 0, 0, 30, 32));
        FrameLayout frameLayout3 = new FrameLayout(activity);
        frameLayout3.addView(M("gif", i4, 26), new FrameLayout.LayoutParams(z(f3), z(f3), 17));
        n0(frameLayout3, new C0036j(this, 12));
        P.addView(frameLayout3, X(this, z(f4), z(f5), 0, 0, 0, 60));
        k1.addView(P, X(this, -1, -2, 0, 0, 0, 60));
        FrameLayout frameLayout4 = new FrameLayout(activity);
        List C = C();
        ListView listView = new ListView(activity);
        listView.setDivider(null);
        listView.setDividerHeight(0);
        listView.setSelector(new ColorDrawable(0));
        listView.setVerticalScrollBarEnabled(false);
        listView.setClipToPadding(false);
        listView.setPadding(z(f2), 0, z(f2), z(64));
        listView.setAdapter((ListAdapter) new Q0(C, this, c0086x));
        frameLayout4.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout5 = new FrameLayout(activity);
        frameLayout5.setBackground(i0(i2));
        frameLayout5.addView(M("backspace", i3, 34), new FrameLayout.LayoutParams(z(40), z(34), 17));
        n0(frameLayout5, new C0057o0(c0036j, 0));
        float f6 = 52;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(z(f6), z(f6), 8388693);
        layoutParams.setMargins(0, 0, z(10), z(f2));
        frameLayout4.addView(frameLayout5, layoutParams);
        k1.addView(frameLayout4, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        return k1;
    }

    public final TextView o0(String str, boolean z, C0022f1 c0022f1) {
        TextView f1 = f1(str, 18.0f, z ? -1 : c0022f1.f484d ? this.f425l : c0022f1.f493m, false);
        f1.setPadding(z(16.0f), z(11.0f), z(16.0f), z(11.0f));
        f1.setMaxWidth(z(270.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(z(20.0f));
        if (!z || c0022f1.f484d) {
            gradientDrawable.setColor(z ? this.f420g : c0022f1.f484d ? this.f423j : c0022f1.f492l);
        } else {
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(new int[]{c0022f1.f490j, c0022f1.f491k});
        }
        f1.setBackground(gradientDrawable);
        return f1;
    }

    public final void p() {
        long j2 = this.m1;
        if (j2 != Long.MIN_VALUE) {
            C1 c1 = (C1) this.j1.get(Long.valueOf(j2));
            if (c1 != null) {
                c1.set("play");
            }
            this.m1 = Long.MIN_VALUE;
        }
    }

    public final void q() {
        if (i.b.a(this.U0, "rec")) {
            try {
                MediaRecorder mediaRecorder = this.V0;
                if (mediaRecorder != null) {
                    mediaRecorder.stop();
                }
            } catch (Exception unused) {
            }
            try {
                MediaRecorder mediaRecorder2 = this.V0;
                if (mediaRecorder2 != null) {
                    mediaRecorder2.release();
                }
            } catch (Exception unused2) {
            }
            this.V0 = null;
            File file = this.a1;
            if (file != null) {
                file.delete();
            }
            this.a1 = null;
        }
        X0();
        File file2 = this.W0;
        if (file2 != null) {
            file2.delete();
        }
        this.W0 = null;
        this.U0 = "idle";
        P0();
    }

    public final LinearLayout.LayoutParams q0(float f2) {
        int z = (int) (z(r0) * f2);
        int z2 = z(132);
        float f3 = 130;
        if (z > z(f3)) {
            z = z(f3);
            z2 = (int) (z / f2);
        }
        float f4 = 64;
        if (z < z(f4)) {
            z = z(f4);
        }
        float f5 = 60;
        if (z2 < z(f5)) {
            z2 = z(f5);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(z, z2);
        layoutParams.setMargins(0, 0, 0, -z(6));
        return layoutParams;
    }

    public final FrameLayout r(int i2, String str) {
        FrameLayout frameLayout = new FrameLayout(this.f414a);
        int i3 = this.f430s;
        frameLayout.setBackground(i0(i3));
        C1 M = M(str, i2, 21);
        if (str.equals("themes")) {
            M.setCut(i3);
        }
        float f2 = 21;
        frameLayout.addView(M, new FrameLayout.LayoutParams(z(f2), z(f2), 17));
        return frameLayout;
    }

    public final String s() {
        return "chatclear_" + this.f415b;
    }

    public final float[] s0(boolean z, boolean z2, boolean z3, float f2) {
        float z4 = z(f2);
        float z5 = z(5.0f);
        float f3 = (z || !z2) ? z4 : z5;
        float f4 = (z || !z3) ? z4 : z5;
        float f5 = (z && z2) ? z5 : z4;
        if (z && z3) {
            z4 = z5;
        }
        return new float[]{f3, f3, f5, f5, z4, z4, f4, f4};
    }

    public final void t() {
        if (!m.m.F(this.f415b, this.C1)) {
            this.f414a.getWindow().clearFlags(8192);
        }
        B0();
        this.G = false;
        AbstractC0008c.f441d = false;
        g1();
        this.f418e.removeCallbacksAndMessages(null);
        X0();
        if (i.b.a(this.U0, "rec")) {
            try {
                MediaRecorder mediaRecorder = this.V0;
                if (mediaRecorder != null) {
                    mediaRecorder.stop();
                }
            } catch (Exception unused) {
            }
        }
        try {
            MediaRecorder mediaRecorder2 = this.V0;
            if (mediaRecorder2 != null) {
                mediaRecorder2.release();
            }
        } catch (Exception unused2) {
        }
        this.V0 = null;
        File file = this.a1;
        if (file != null) {
            file.delete();
        }
        this.a1 = null;
    }

    public final void t0(K0 k0, String str) {
        String str2;
        if (str.length() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            SharedPreferences sharedPreferences = AbstractC0008c.f440c;
            if (sharedPreferences == null) {
                i.b.g("sp");
                throw null;
            }
            String string = sharedPreferences.getString("recent_emoji", "");
            for (String str3 : m.e.b0(string != null ? string : "", new String[]{" "})) {
                if (str3.length() > 0 && !str3.equals(str)) {
                    arrayList.add(str3);
                }
            }
            String L = c.b.L(c.b.P(arrayList, 15), " ", null, null, null, 62);
            SharedPreferences sharedPreferences2 = AbstractC0008c.f440c;
            if (sharedPreferences2 == null) {
                i.b.g("sp");
                throw null;
            }
            sharedPreferences2.edit().putString("recent_emoji", L).apply();
        }
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = this.E;
        List list = (List) hashMap.get(Long.valueOf(k0.f150a));
        if (list == null) {
            list = c.j.f773a;
        }
        Iterator it = list.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            str2 = this.f415b;
            if (!hasNext) {
                break;
            }
            b.b bVar = (b.b) it.next();
            if (!i.b.a(bVar.f764a, str2)) {
                arrayList2.add(bVar);
            }
        }
        if (str.length() > 0) {
            arrayList2.add(new b.b(str2, str));
        }
        long j2 = k0.f150a;
        hashMap.put(Long.valueOf(j2), arrayList2);
        L0 l0 = new L0(str, System.currentTimeMillis());
        this.K0.put(Long.valueOf(j2), l0);
        x0(false);
        new Thread(new K((Object) k0, str, (Object) this, (Object) l0, 0)).start();
    }

    public final void u(String str, String str2, String str3, String str4, final h.a aVar) {
        Button button;
        boolean z = this.f419f;
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f414a, z ? R.style.Theme.DeviceDefault.Dialog.Alert : R.style.Theme.DeviceDefault.Light.Dialog.Alert);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setNegativeButton(str3, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(str4, new DialogInterface.OnClickListener() { // from class: a.w
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                h.a.this.a();
            }
        });
        AlertDialog create = builder.create();
        T0(create);
        Button button2 = create.getButton(-1);
        if (button2 != null) {
            button2.setTextColor(-13793025);
        }
        if (!z || (button = create.getButton(-2)) == null) {
            return;
        }
        button.setTextColor(-1);
    }

    public final void u0(boolean z, h.b bVar) {
        Activity activity = this.f414a;
        Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(1);
        ArrayList arrayList = new ArrayList();
        Object obj = new Object();
        if (z) {
            arrayList.add("Like");
            arrayList.add(obj);
        }
        v0(arrayList, "Your reactions", this.q);
        SharedPreferences sharedPreferences = AbstractC0008c.f440c;
        if (sharedPreferences == null) {
            i.b.g("sp");
            throw null;
        }
        String str = "";
        String string = sharedPreferences.getString("recent_emoji", "");
        if (string == null) {
            string = "";
        }
        List b0 = m.e.b0(string, new String[]{" "});
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : b0) {
            if (((String) obj2).length() > 0) {
                arrayList2.add(obj2);
            }
        }
        v0(arrayList, "Recent", arrayList2);
        ArrayList arrayList3 = new ArrayList();
        Iterator it = ((ArrayList) C()).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof String) {
                v0(arrayList, str, arrayList3);
                str = (String) next;
                arrayList3 = new ArrayList();
            } else {
                i.b.c(next, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                arrayList3.addAll((List) next);
            }
        }
        v0(arrayList, str, arrayList3);
        ListView listView = new ListView(activity);
        listView.setDivider(null);
        listView.setDividerHeight(0);
        listView.setSelector(new ColorDrawable(0));
        listView.setVerticalScrollBarEnabled(false);
        listView.setOverScrollMode(2);
        listView.setPadding(0, 0, 0, z(24));
        listView.setClipToPadding(false);
        listView.setAdapter((ListAdapter) new Y0(arrayList, obj, this, dialog, bVar));
        LinearLayout k1 = k1();
        FrameLayout frameLayout = new FrameLayout(activity);
        View view = new View(activity);
        view.setBackground(N0(this.f419f ? -10789278 : -3881012, 3.0f, 0, 0.0f));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(z(46.0f), z(4.0f), 1);
        layoutParams.topMargin = z(13.0f);
        frameLayout.addView(view, layoutParams);
        k1.addView(frameLayout, X(this, -1, z(24.0f), 0, 0, 0, 60));
        k1.addView(listView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        D2 d2 = new D2(activity, listView, new C0060p(dialog, 2));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.f422i);
        float z2 = z(21.0f);
        gradientDrawable.setCornerRadii(new float[]{z2, z2, z2, z2, 0.0f, 0.0f, 0.0f, 0.0f});
        d2.setBackground(gradientDrawable);
        d2.setClipToOutline(true);
        d2.setOutlineProvider(new Z0(z2, 0));
        d2.addView(k1, new FrameLayout.LayoutParams(-1, -1));
        dialog.setContentView(d2);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        if (window != null) {
            window.setGravity(80);
        }
        int i2 = activity.getResources().getDisplayMetrics().heightPixels;
        if (window != null) {
            window.setLayout(-1, i2 - z(38.0f));
        }
        d2.setTranslationY(i2);
        T0(dialog);
        d2.post(new L(d2, 0));
    }

    public final float[] v(boolean z, boolean z2, boolean z3, boolean z4) {
        float z5 = z(19.0f);
        float z6 = z(5.0f);
        float f2 = z ? z5 : z6;
        float f3 = z2 ? z5 : z6;
        float f4 = z3 ? z5 : z6;
        if (!z4) {
            z5 = z6;
        }
        return new float[]{f2, f2, f3, f3, f4, f4, z5, z5};
    }

    public final void w0() {
        HashMap hashMap = this.n0;
        hashMap.clear();
        this.s0 = 0L;
        ArrayList arrayList = this.D;
        int size = arrayList.size() - 1;
        String str = this.f415b;
        if (size >= 0) {
            while (true) {
                int i2 = size - 1;
                K0 k0 = (K0) arrayList.get(size);
                if (i.b.a(k0.f151b, str) && !k0.f159j && !i.b.a(k0.f152c, "sys")) {
                    this.s0 = k0.f150a;
                    break;
                } else if (i2 < 0) {
                    break;
                } else {
                    size = i2;
                }
            }
        }
        int size2 = arrayList.size() - 1;
        if (size2 >= 0) {
            while (true) {
                int i3 = size2 - 1;
                K0 k02 = (K0) arrayList.get(size2);
                if (!(i.b.a(k02.f151b, str) || k02.f159j || i.b.a(k02.f152c, "sys")) || i3 < 0) {
                    break;
                } else {
                    size2 = i3;
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        HashMap hashMap2 = new HashMap();
        for (Map.Entry entry : this.m0.entrySet()) {
            String str2 = (String) entry.getKey();
            long longValue = ((Number) entry.getValue()).longValue();
            if (!i.b.a(str2, str) && longValue > 0) {
                int size3 = arrayList.size() - 1;
                while (size3 >= 0 && ((K0) arrayList.get(size3)).f150a > longValue) {
                    size3--;
                }
                if (size3 >= 0) {
                    Long valueOf = Long.valueOf(((K0) arrayList.get(size3)).f150a);
                    Object obj = hashMap2.get(valueOf);
                    if (obj == null) {
                        obj = new ArrayList();
                        hashMap2.put(valueOf, obj);
                    }
                    ((ArrayList) obj).add(str2);
                }
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            hashMap.put(Long.valueOf(((Number) entry2.getKey()).longValue()), (ArrayList) entry2.getValue());
        }
    }

    public final String x(String str) {
        String str2 = (String) this.t0.get(str);
        return str2 == null ? str : str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x0(boolean z) {
        boolean z2;
        O0 o0;
        if (!z) {
            I2 i2 = this.W;
            if (i2 == null) {
                i.b.g("lv");
                throw null;
            }
            int lastVisiblePosition = i2.getLastVisiblePosition();
            O0 o02 = this.j0;
            if (o02 == null) {
                i.b.g("adapter");
                throw null;
            }
            if (lastVisiblePosition < o02.getCount() - 1) {
                z2 = false;
                o0 = this.j0;
                if (o0 != null) {
                    i.b.g("adapter");
                    throw null;
                }
                o0.notifyDataSetChanged();
                if (z2) {
                    O0 o03 = this.j0;
                    if (o03 == null) {
                        i.b.g("adapter");
                        throw null;
                    }
                    if (o03.getCount() > 0) {
                        this.V = true;
                        I2 i22 = this.W;
                        if (i22 == null) {
                            i.b.g("lv");
                            throw null;
                        }
                        O0 o04 = this.j0;
                        if (o04 == null) {
                            i.b.g("adapter");
                            throw null;
                        }
                        i22.setSelection(o04.getCount() - 1);
                        I2 i23 = this.W;
                        if (i23 == null) {
                            i.b.g("lv");
                            throw null;
                        }
                        i23.post(new RunnableC0048m(this, 11));
                    }
                }
                i1();
                return;
            }
        }
        z2 = true;
        o0 = this.j0;
        if (o0 != null) {
        }
    }

    public final View y() {
        View view = new View(this.f414a);
        view.setBackgroundColor(this.f427n);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        return view;
    }

    public final void y0() {
        if (this.S != null) {
            return;
        }
        if (!O()) {
            K0(1);
        }
        try {
            Object systemService = this.f414a.getSystemService("connectivity");
            i.b.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            C0002a1 c0002a1 = new C0002a1(this);
            ((ConnectivityManager) systemService).registerDefaultNetworkCallback(c0002a1);
            this.S = c0002a1;
        } catch (Exception unused) {
        }
    }

    public final int z(float f2) {
        return (int) (f2 * this.f414a.getResources().getDisplayMetrics().density * 0.93f);
    }

    public final void z0(long j2) {
        this.R0.remove(Long.valueOf(j2));
        c.h.G(this.D, new P(j2, 2));
        w0();
        x0(false);
    }
}
