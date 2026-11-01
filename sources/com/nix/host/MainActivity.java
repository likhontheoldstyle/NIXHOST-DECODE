package com.nix.host;

import a.A2;
import a.AbstractC0008c;
import a.B2;
import a.C0;
import a.C0001a0;
import a.C0004b;
import a.C0006b1;
import a.C0011c2;
import a.C0018e1;
import a.C0027g2;
import a.C0035i2;
import a.C0038j1;
import a.C0057o0;
import a.C0060p;
import a.C0067q2;
import a.C0070r2;
import a.C0071s;
import a.C0085w1;
import a.C0090y0;
import a.D;
import a.D1;
import a.E;
import a.F1;
import a.G0;
import a.G1;
import a.I;
import a.I0;
import a.J0;
import a.K0;
import a.K1;
import a.K2;
import a.L1;
import a.L2;
import a.M0;
import a.M1;
import a.N0;
import a.Q1;
import a.R0;
import a.RunnableC0056o;
import a.S1;
import a.T1;
import a.ViewOnClickListenerC0016e;
import a.ViewOnClickListenerC0019e2;
import a.ViewOnClickListenerC0044l;
import a.ViewOnTouchListenerC0039j2;
import a.X1;
import a.Y1;
import a.s2;
import a.z2;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import b.c;
import c.g;
import c.j;
import com.nix.host.MainActivity;
import h.a;
import i.b;
import i.d;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import m.e;
import m.l;
import m.m;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class MainActivity extends Activity {
    public static final /* synthetic */ int R = 0;
    public EditText A;
    public LinearLayout B;
    public LinearLayout C;
    public TextView D;
    public TextView E;
    public TextView F;
    public LinearLayout G;
    public View H;
    public boolean I;
    public Dialog L;
    public View N;
    public long P;
    public File Q;

    /* renamed from: f, reason: collision with root package name */
    public long f786f;

    /* renamed from: g, reason: collision with root package name */
    public int f787g;

    /* renamed from: h, reason: collision with root package name */
    public int f788h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f789i;

    /* renamed from: j, reason: collision with root package name */
    public long f790j;

    /* renamed from: k, reason: collision with root package name */
    public C0035i2 f791k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f792l;

    /* renamed from: m, reason: collision with root package name */
    public C0006b1 f793m;

    /* renamed from: n, reason: collision with root package name */
    public File f794n;

    /* renamed from: o, reason: collision with root package name */
    public File f795o;

    /* renamed from: r, reason: collision with root package name */
    public int f796r;

    /* renamed from: s, reason: collision with root package name */
    public TextView f797s;

    /* renamed from: t, reason: collision with root package name */
    public LinearLayout f798t;

    /* renamed from: u, reason: collision with root package name */
    public View f799u;

    /* renamed from: v, reason: collision with root package name */
    public C0071s f800v;
    public int w;
    public boolean x;
    public boolean y;
    public ScrollView z;

    /* renamed from: a, reason: collision with root package name */
    public final int f781a = -1;

    /* renamed from: b, reason: collision with root package name */
    public final int f782b = -2;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f783c = new Handler(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    public String f784d = "login";

    /* renamed from: e, reason: collision with root package name */
    public String f785e = "";
    public String p = "";
    public String q = "";
    public final F1 J = new F1(this, 1);
    public final float K = 0.93f;
    public final c M = new c(new K1(this, 6));
    public boolean O = true;

    public static final void A(EditText editText, MainActivity mainActivity) {
        editText.requestFocus();
        Object systemService = mainActivity.getSystemService("input_method");
        b.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
    }

    public static void D(View view, a aVar) {
        view.setOnClickListener(new ViewOnClickListenerC0044l(aVar, 5));
        view.setOnTouchListener(new ViewOnTouchListenerC0039j2());
    }

    public static final void G(StringBuilder sb, Editable editable, d dVar, MainActivity mainActivity) {
        if (sb.length() == 0) {
            return;
        }
        int length = editable.length();
        editable.append((CharSequence) sb);
        if (dVar.f846a) {
            editable.setSpan(new ForegroundColorSpan(-11563273), length, editable.length(), 33);
            editable.setSpan(new StyleSpan(1), length, editable.length(), 33);
        } else {
            if (mainActivity.w != 0) {
                editable.setSpan(new ForegroundColorSpan(mainActivity.w), length, editable.length(), 33);
            }
            if (mainActivity.x) {
                editable.setSpan(new StyleSpan(1), length, editable.length(), 33);
            }
        }
        sb.setLength(0);
    }

    public static final EditText Q(MainActivity mainActivity, String str) {
        EditText editText = new EditText(mainActivity);
        editText.setHint(str);
        editText.setHintTextColor(-6511697);
        editText.setTextColor(-15656921);
        editText.setTextSize(1, mainActivity.K * 17.0f);
        editText.setSingleLine(true);
        editText.setBackground(mainActivity.I(-1, 16, -1710101, 2));
        editText.setPadding(mainActivity.n(16), mainActivity.n(14), mainActivity.n(16), mainActivity.n(14));
        editText.setOnFocusChangeListener(new Y1(editText, mainActivity, 1));
        return editText;
    }

    public static final void b(G1 g1, final s2 s2Var, final View view, FrameLayout frameLayout, MainActivity mainActivity, a aVar, d dVar) {
        if (dVar.f846a) {
            return;
        }
        dVar.f846a = true;
        mainActivity.f791k = null;
        g1.set("up");
        final float height = s2Var.getHeight();
        final float translationY = s2Var.getTranslationY();
        final float alpha = view.getAlpha();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(260L);
        ofFloat.setInterpolator(new DecelerateInterpolator(2.0f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: a.U1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i2 = MainActivity.R;
                Object animatedValue = valueAnimator.getAnimatedValue();
                i.b.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                float floatValue = ((Float) animatedValue).floatValue();
                float f2 = height;
                float f3 = translationY;
                s2.this.setTranslationY(((1.0f - floatValue) * (f2 - f3)) + f3);
                view.setAlpha(alpha * floatValue);
            }
        });
        ofFloat.addListener(new C0070r2(frameLayout, s2Var, view, aVar));
        ofFloat.start();
    }

    public static final void c(MainActivity mainActivity, s2 s2Var, d dVar, G1 g1, View view, FrameLayout frameLayout, String str, int i2, a aVar) {
        TextView U = mainActivity.U(str, 18.0f, i2, true);
        U.setPadding(0, mainActivity.n(16), 0, mainActivity.n(16));
        D(U, new Q1(g1, s2Var, view, frameLayout, mainActivity, aVar, dVar));
        s2Var.addView(U, v(mainActivity, mainActivity.f781a, mainActivity.f782b, 0, 0, 0, 60));
    }

    public static int d(int i2) {
        if (i2 == 0) {
            return -9735552;
        }
        if (i2 == 1) {
            return -1096636;
        }
        if (i2 == 2) {
            return -14498466;
        }
        if (i2 == 3) {
            return -1395960;
        }
        if (i2 == 4) {
            return -12877066;
        }
        if (i2 == 5) {
            return -2537745;
        }
        if (i2 == 6) {
            return -16337196;
        }
        if (i2 == 7) {
            return -1710101;
        }
        if (i2 == 8) {
            return -6511697;
        }
        if (i2 == 9) {
            return -495247;
        }
        if (i2 == 10) {
            return -11870592;
        }
        if (i2 == 11) {
            return -340971;
        }
        if (i2 == 12) {
            return -10443270;
        }
        if (i2 == 13) {
            return -1541639;
        }
        if (i2 == 14) {
            return -14494738;
        }
        if (i2 == 15) {
            return -1;
        }
        if (16 <= i2 && i2 < 232) {
            int i3 = i2 - 16;
            int[] iArr = {0, 95, 135, 175, 215, 255};
            return Color.rgb(iArr[i3 / 36], iArr[(i3 / 6) % 6], iArr[i3 % 6]);
        }
        if (232 > i2 || i2 >= 256) {
            return 0;
        }
        int i4 = ((i2 - 232) * 10) + 8;
        return Color.rgb(i4, i4, i4);
    }

    public static Dialog g(MainActivity mainActivity, int i2, boolean z, h.c cVar, int i3) {
        Window window;
        Window window2;
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            z = false;
        }
        mainActivity.getClass();
        Dialog dialog = new Dialog(mainActivity);
        if (mainActivity.J() && (window2 = dialog.getWindow()) != null) {
            window2.addFlags(8192);
        }
        dialog.requestWindowFeature(1);
        LinearLayout V = mainActivity.V();
        boolean z2 = AbstractC0008c.f442e;
        int i4 = z2 ? -14540254 : -1;
        if (i2 == 0) {
            i2 = z2 ? -13684945 : -1710101;
        }
        V.setBackground(mainActivity.I(i4, 24, i2, 1));
        V.setPadding(mainActivity.n(24), mainActivity.n(24), mainActivity.n(24), mainActivity.n(24));
        cVar.a(V, dialog);
        dialog.setContentView(V);
        Window window3 = dialog.getWindow();
        if (window3 != null) {
            window3.setBackgroundDrawable(new ColorDrawable(0));
        }
        Window window4 = dialog.getWindow();
        if (window4 != null) {
            window4.setWindowAnimations(R.style.ZoomAnim);
        }
        if (z && (window = dialog.getWindow()) != null) {
            window.setSoftInputMode(20);
        }
        dialog.show();
        Window window5 = dialog.getWindow();
        if (window5 != null) {
            window5.setLayout((int) (mainActivity.getResources().getDisplayMetrics().widthPixels * 0.9f), -2);
        }
        Window window6 = dialog.getWindow();
        if (window6 != null) {
            window6.setDimAmount(0.65f);
        }
        return dialog;
    }

    public static final EditText l(MainActivity mainActivity, String str, String str2, boolean z) {
        EditText editText = new EditText(mainActivity);
        editText.setText(str2);
        editText.setHint(str);
        editText.setHintTextColor(-7236192);
        editText.setTextColor(-263172);
        editText.setTypeface(Typeface.MONOSPACE);
        editText.setTextSize(1, mainActivity.K * 18.0f);
        editText.setBackground(null);
        editText.setPadding(mainActivity.n(18), mainActivity.n(14), mainActivity.n(18), mainActivity.n(14));
        if (z) {
            editText.setSingleLine(true);
        } else {
            editText.setMaxLines(4);
        }
        editText.setInputType((z ? 0 : 131072) | 524289);
        if (Build.VERSION.SDK_INT >= 29) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-15896869);
            gradientDrawable.setSize(mainActivity.n(2), mainActivity.n(22));
            editText.setTextCursorDrawable(gradientDrawable);
        }
        return editText;
    }

    public static void p() {
        try {
            ValueAnimator.class.getMethod("setDurationScale", Float.TYPE).invoke(null, Float.valueOf(1.0f));
        } catch (Throwable unused) {
        }
    }

    public static LinearLayout.LayoutParams v(MainActivity mainActivity, int i2, int i3, int i4, int i5, int i6, int i7) {
        if ((i7 & 4) != 0) {
            i4 = 0;
        }
        if ((i7 & 8) != 0) {
            i5 = 0;
        }
        if ((i7 & 16) != 0) {
            i6 = 0;
        }
        mainActivity.getClass();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i3);
        layoutParams.setMargins(mainActivity.n(i5), mainActivity.n(i4), mainActivity.n(i6), mainActivity.n(0));
        return layoutParams;
    }

    public static final void z(MainActivity mainActivity, LinearLayout linearLayout, String str, a aVar) {
        LinearLayout r2 = mainActivity.r();
        r2.setPadding(mainActivity.n(14), mainActivity.n(14), mainActivity.n(14), mainActivity.n(14));
        TextView U = mainActivity.U(str, 16.0f, -1, true);
        U.setTypeface(Typeface.create(mainActivity.q(), 1));
        r2.addView(U, new LinearLayout.LayoutParams(0, mainActivity.f782b, 1.0f));
        D(r2, new C0090y0(mainActivity, aVar, 5));
        linearLayout.addView(r2, v(mainActivity, mainActivity.f781a, mainActivity.f782b, 0, 0, 0, 60));
    }

    public final void B(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        b.d(sb2, "toString(...)");
        if (sb2.length() == 0) {
            return;
        }
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://wa.me/" + sb2)));
        } catch (Exception unused) {
            T("Cannot open WhatsApp");
        }
    }

    /* JADX WARN: Type inference failed for: r5v18, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v32 */
    public final void C() {
        K2 k2;
        b.b bVar;
        Editable editableText;
        int i2;
        List list;
        int i3;
        int i4;
        TextView textView = this.f797s;
        if (textView == null || this.p.length() == 0) {
            return;
        }
        L2 l2 = L2.f198a;
        String str = this.p;
        synchronized (l2) {
            k2 = (K2) L2.f199b.get(str);
        }
        if (k2 == null) {
            return;
        }
        int i5 = this.f796r;
        synchronized (k2) {
            int length = k2.f171e + k2.f170d.length();
            int i6 = k2.f171e;
            if (i5 < i6) {
                i5 = i6;
            }
            bVar = i5 >= length ? new b.b("", Integer.valueOf(length)) : new b.b(k2.f170d.substring(i5 - i6), Integer.valueOf(length));
        }
        String str2 = (String) bVar.f764a;
        this.f796r = ((Number) bVar.f765b).intValue();
        if (str2.length() == 0 || (editableText = textView.getEditableText()) == null) {
            return;
        }
        boolean z = false;
        if (this.y && str2.length() > 0) {
            editableText.append((CharSequence) "\n");
            this.y = false;
        }
        StringBuilder sb = new StringBuilder();
        d dVar = new d();
        StringBuilder sb2 = new StringBuilder();
        int length2 = str2.length();
        int i7 = 0;
        boolean z2 = false;
        while (true) {
            boolean z3 = true;
            if (i7 >= length2) {
                break;
            }
            char charAt = str2.charAt(i7);
            if (z2) {
                if (charAt == 4) {
                    String sb3 = sb2.toString();
                    if (sb3.length() == 0) {
                        list = AbstractC0008c.p(Integer.valueOf(z ? 1 : 0));
                    } else {
                        List b0 = e.b0(sb3, new String[]{";"});
                        ArrayList arrayList = new ArrayList(c.d.E(b0));
                        Iterator it = b0.iterator();
                        while (it.hasNext()) {
                            Integer C = l.C((String) it.next());
                            arrayList.add(Integer.valueOf(C != null ? C.intValue() : z ? 1 : 0));
                        }
                        list = arrayList;
                    }
                    int i8 = z ? 1 : 0;
                    int i9 = z;
                    while (i8 < list.size()) {
                        int intValue = ((Number) list.get(i8)).intValue();
                        if (intValue == 0) {
                            this.w = i9;
                            this.x = i9;
                        } else if (intValue == z3) {
                            this.x = z3;
                        } else if (intValue == 22) {
                            this.x = i9;
                        } else if (intValue == 39) {
                            this.w = i9;
                        } else if (30 <= intValue && intValue < 38) {
                            this.w = d(intValue - 30);
                        } else if (90 <= intValue && intValue < 98) {
                            this.w = d(intValue - 82);
                        } else if (intValue == 38 && (i4 = i8 + 2) < list.size() && ((Number) list.get(i8 + 1)).intValue() == 5) {
                            this.w = d(((Number) list.get(i4)).intValue());
                            i8 = i4;
                        } else if (intValue == 38 && (i3 = i8 + 4) < list.size() && ((Number) list.get(i8 + 1)).intValue() == 2) {
                            this.w = Color.rgb(AbstractC0008c.c(((Number) list.get(i8 + 2)).intValue(), 255), AbstractC0008c.c(((Number) list.get(i8 + 3)).intValue(), 255), AbstractC0008c.c(((Number) list.get(i3)).intValue(), 255));
                            i8 = i3;
                        }
                        i8++;
                        z3 = true;
                        i9 = 0;
                    }
                    sb2.setLength(i9);
                    z2 = false;
                } else {
                    sb2.append(charAt);
                }
            } else if (charAt == 1) {
                G(sb, editableText, dVar, this);
                dVar.f846a = true;
            } else if (charAt == 2) {
                G(sb, editableText, dVar, this);
                dVar.f846a = false;
            } else if (charAt == 3) {
                G(sb, editableText, dVar, this);
                z2 = true;
            } else if (charAt != '\f') {
                sb.append(charAt);
            } else {
                sb.setLength(0);
                editableText.clear();
                this.y = false;
            }
            i7++;
            z = false;
        }
        G(sb, editableText, dVar, this);
        if (editableText.length() > 0 && editableText.charAt(editableText.length() - 1) == '\n') {
            editableText.delete(editableText.length() - 1, editableText.length());
            this.y = true;
        }
        if (editableText.length() > 50000) {
            i2 = 0;
            editableText.delete(0, editableText.length() - 40000);
        } else {
            i2 = 0;
        }
        textView.setVisibility(editableText.length() == 0 ? 8 : i2);
        ScrollView scrollView = this.z;
        if (scrollView != null) {
            scrollView.post(new M1(this, 1));
        }
    }

    public final void E(String str, String str2, String str3, String str4, h.b bVar) {
        g(this, 0, true, new L1(this, str, str2, str3, str4, bVar), 1);
    }

    public final void F() {
        K2 k2;
        L2 l2 = L2.f198a;
        String str = this.p;
        synchronized (l2) {
            k2 = (K2) L2.f199b.get(str);
        }
        if (k2 == null) {
            return;
        }
        boolean z = k2.f175i;
        LinearLayout linearLayout = this.C;
        if (linearLayout != null) {
            linearLayout.setVisibility((!z || k2.f176j.length() <= 0) ? 8 : 0);
        }
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(k2.f176j);
        }
        LinearLayout linearLayout2 = this.B;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(z ? 8 : 0);
        }
        if (this.I && !z) {
            EditText editText = this.A;
            if (editText != null) {
                editText.requestFocus();
            }
            ScrollView scrollView = this.z;
            if (scrollView != null) {
                scrollView.post(new M1(this, 2));
            }
        }
        this.I = z;
        String l3 = k2.l();
        TextView textView2 = this.E;
        if (textView2 != null) {
            textView2.setText("[" + this.q + l3 + "]");
        }
        TextView textView3 = this.F;
        if (textView3 != null) {
            textView3.setText(new SimpleDateFormat("HH:mm  dd-MMM-yy", Locale.US).format(new Date(System.currentTimeMillis())));
        }
    }

    public final void H(ViewGroup viewGroup, int i2, int i3, boolean z, final boolean z2) {
        if (J()) {
            getWindow().addFlags(8192);
        } else {
            getWindow().clearFlags(8192);
        }
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                getWindow().setDecorFitsSystemWindows(!z2);
            } else {
                View decorView = getWindow().getDecorView();
                decorView.setSystemUiVisibility(z2 ? decorView.getSystemUiVisibility() | 1280 : decorView.getSystemUiVisibility() & (-1281));
            }
        } catch (Exception unused) {
        }
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(i3);
        final View view = new View(this);
        view.setBackgroundColor(i2);
        int i4 = this.f781a;
        if (!z2) {
            linearLayout.addView(view, new LinearLayout.LayoutParams(i4, this.f787g));
        }
        linearLayout.addView(viewGroup, new LinearLayout.LayoutParams(i4, 0, 1.0f));
        linearLayout.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: a.o2
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                int systemBars;
                Insets insets;
                int ime;
                Insets insets2;
                int i5;
                int i6;
                int i7;
                int i8 = MainActivity.R;
                int i9 = Build.VERSION.SDK_INT;
                MainActivity mainActivity = MainActivity.this;
                if (i9 >= 30) {
                    systemBars = WindowInsets.Type.systemBars();
                    insets = windowInsets.getInsets(systemBars);
                    ime = WindowInsets.Type.ime();
                    insets2 = windowInsets.getInsets(ime);
                    i5 = insets.top;
                    mainActivity.f787g = i5;
                    i6 = insets.bottom;
                    i7 = insets2.bottom;
                    mainActivity.f788h = Math.max(i6, i7);
                } else {
                    mainActivity.f787g = windowInsets.getSystemWindowInsetTop();
                    mainActivity.f788h = windowInsets.getSystemWindowInsetBottom();
                }
                if (z2) {
                    C0006b1 c0006b1 = mainActivity.f793m;
                    if (c0006b1 != null) {
                        int i10 = mainActivity.f787g;
                        c0006b1.y = i10;
                        LinearLayout linearLayout2 = c0006b1.B;
                        if (linearLayout2 != null) {
                            float f2 = 9;
                            linearLayout2.setPadding(c0006b1.z(2), c0006b1.z(f2) + i10, c0006b1.z(8), c0006b1.z(f2));
                        }
                    }
                } else {
                    View view3 = view;
                    ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
                    int i11 = layoutParams.height;
                    int i12 = mainActivity.f787g;
                    if (i11 != i12) {
                        layoutParams.height = i12;
                        view3.setLayoutParams(layoutParams);
                    }
                }
                view2.setPadding(0, 0, 0, mainActivity.f788h);
                return windowInsets;
            }
        });
        this.N = linearLayout;
        setContentView(linearLayout);
        linearLayout.requestApplyInsets();
        e(i2, i3, z);
    }

    public final GradientDrawable I(int i2, int i3, int i4, int i5) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius(n(i3));
        if (i5 > 0) {
            gradientDrawable.setStroke(n(i5), i4);
        }
        return gradientDrawable;
    }

    public final boolean J() {
        return !m.F(this.f785e, "aryan") && (b.a(this.f784d, "home") || b.a(this.f784d, "group"));
    }

    public final void K(File file) {
        String str;
        if (file.length() > 300000) {
            T("File too big to edit here");
            return;
        }
        this.f784d = "edit";
        h();
        this.f798t = null;
        try {
            str = m.J(g.m.I(file), "\t", "    ");
        } catch (Exception unused) {
            str = "";
        }
        String str2 = str;
        FrameLayout frameLayout = new FrameLayout(this);
        LinearLayout V = V();
        V.setBackgroundColor(-15263716);
        LinearLayout r2 = r();
        r2.setPadding(n(14), n(10), n(16), n(10));
        FrameLayout frameLayout2 = new FrameLayout(this);
        frameLayout2.addView(t("close", -263172, 26, 2.0f), new FrameLayout.LayoutParams(n(26), n(26), 17));
        r2.addView(frameLayout2, v(this, n(40), n(40), 0, 0, 0, 60));
        LinearLayout V2 = V();
        V2.addView(U(file.getName(), 15.0f, -7236192, false));
        V2.addView(U("Edit file", 26.0f, -263172, true));
        int i2 = this.f782b;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, i2, 1.0f);
        layoutParams.leftMargin = n(10);
        r2.addView(V2, layoutParams);
        V.addView(r2, v(this, this.f781a, this.f782b, 0, 0, 0, 60));
        float f2 = getResources().getDisplayMetrics().density;
        float f3 = this.K;
        C0038j1 c0038j1 = new C0038j1(this, f2 * f3);
        c0038j1.setFileName(file.getName());
        c0038j1.setText(str2);
        c0038j1.setBackground(null);
        c0038j1.setTypeface(Typeface.MONOSPACE);
        c0038j1.setTextSize(1, f3 * 14.0f);
        c0038j1.setLineSpacing(0.0f, 1.1f);
        c0038j1.setTextColor(-591622);
        c0038j1.setHighlightColor(1426943707);
        c0038j1.setGravity(48);
        c0038j1.setPadding(n(10) + c0038j1.f556h, n(3), n(10), n(90));
        c0038j1.setInputType(655361);
        if (Build.VERSION.SDK_INT >= 29) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-15896869);
            gradientDrawable.setSize(n(2), n(22));
            c0038j1.setTextCursorDrawable(gradientDrawable);
        }
        c0038j1.a();
        c0038j1.f557i.post(c0038j1.f559k);
        int i3 = this.f781a;
        V.addView(c0038j1, new LinearLayout.LayoutParams(i3, 0, 1.0f));
        frameLayout.addView(V, new FrameLayout.LayoutParams(i3, i3));
        LinearLayout r3 = r();
        r3.setGravity(17);
        r3.setBackground(I(-14319045, 10, 0, 0));
        r3.setPadding(n(18), n(14), n(16), n(14));
        r3.addView(t("commit", -1, 24, 2.0f), v(this, n(24), n(24), 0, 0, 10, 32));
        View U = U("COMMIT CHANGES", 17.0f, -1, false);
        int i4 = this.f782b;
        r3.addView(U, v(this, i4, i4, 0, 0, 10, 32));
        r3.addView(t("down", -1, 20, 2.4f), v(this, n(20), n(20), 0, 0, 0, 60));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, i2, 8388693);
        layoutParams2.setMargins(0, 0, n(16), n(16));
        frameLayout.addView(r3, layoutParams2);
        C0071s c0071s = new C0071s(this, c0038j1, str2, file);
        this.f800v = c0071s;
        D(frameLayout2, new C0057o0(c0071s, 1));
        D(r3, new S1(this, file, c0038j1));
        H(frameLayout, -15263716, -15263716, false, false);
    }

    public final void L() {
        List list;
        File file;
        char c2;
        String str;
        int i2 = 1;
        this.f784d = "files";
        h();
        this.f798t = null;
        this.f800v = null;
        File file2 = this.f794n;
        if (file2 == null && (file2 = this.f795o) == null) {
            b.g("homeDir");
            throw null;
        }
        File file3 = file2;
        String canonicalPath = file3.getCanonicalPath();
        File file4 = this.f795o;
        if (file4 == null) {
            b.g("homeDir");
            throw null;
        }
        boolean a2 = b.a(canonicalPath, file4.getCanonicalPath());
        FrameLayout frameLayout = new FrameLayout(this);
        LinearLayout V = V();
        V.setBackgroundColor(-15263716);
        LinearLayout r2 = r();
        r2.setPadding(n(14), n(14), n(10), n(14));
        FrameLayout frameLayout2 = new FrameLayout(this);
        frameLayout2.addView(t("arrow", -263172, 26, 2.0f), new FrameLayout.LayoutParams(n(26), n(26), 17));
        D(frameLayout2, new K1(this, i2));
        r2.addView(frameLayout2, v(this, n(40), n(40), 0, 0, 0, 60));
        LinearLayout r3 = r();
        if (a2) {
            r3.addView(t("logo", -43230, 26, 2.0f), v(this, n(26), n(26), 0, 0, 8, 32));
            View U = U("NixHost", 24.0f, -263172, true);
            int i3 = this.f782b;
            r3.addView(U, v(this, i3, i3, 0, 0, 0, 60));
        } else {
            TextView U2 = U(file3.getName(), 24.0f, -263172, true);
            U2.setSingleLine(true);
            U2.setEllipsize(TextUtils.TruncateAt.END);
            int i4 = this.f782b;
            r3.addView(U2, v(this, i4, i4, 0, 0, 0, 60));
        }
        int i5 = this.f782b;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, i5, 1.0f);
        layoutParams.leftMargin = n(10);
        r2.addView(r3, layoutParams);
        FrameLayout frameLayout3 = new FrameLayout(this);
        frameLayout3.addView(t("dots", -15896869, 24, 2.0f), new FrameLayout.LayoutParams(n(24), n(24), 17));
        r2.addView(frameLayout3, v(this, n(40), n(40), 0, 0, 0, 60));
        V.addView(r2, v(this, this.f781a, this.f782b, 0, 0, 0, 60));
        ScrollView scrollView = new ScrollView(this);
        LinearLayout V2 = V();
        V2.setPadding(0, n(4), 0, n(24));
        int i6 = this.f781a;
        scrollView.addView(V2, new FrameLayout.LayoutParams(i6, i5));
        V.addView(scrollView, new LinearLayout.LayoutParams(i6, 0, 1.0f));
        final i.e eVar = new i.e();
        final LinearLayout r4 = r();
        r4.setGravity(16);
        r4.setPadding(n(20), n(12), n(20), n(12));
        r4.setBackgroundColor(-13684937);
        final TextView U3 = U("", 15.0f, -263172, false);
        r4.addView(U3, new LinearLayout.LayoutParams(0, i5, 1.0f));
        View U4 = U("Cancel", 15.0f, -8012033, true);
        int i7 = this.f782b;
        r4.addView(U4, v(this, i7, i7, 0, 0, 0, 60));
        r4.setVisibility(8);
        D(U4, new C0090y0(eVar, r4, 2));
        V2.addView(r4, v(this, this.f781a, this.f782b, 0, 0, 0, 60));
        File[] listFiles = file3.listFiles();
        if (listFiles != null) {
            final h.b[] bVarArr = {new C0085w1(1), new C0085w1(2)};
            list = c.a.F(listFiles, new Comparator() { // from class: d.a
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    for (h.b bVar : bVarArr) {
                        int d2 = AbstractC0008c.d((Comparable) bVar.a(obj), (Comparable) bVar.a(obj2));
                        if (d2 != 0) {
                            return d2;
                        }
                    }
                    return 0;
                }
            });
        } else {
            list = j.f773a;
        }
        List<File> list2 = list;
        if (list2.isEmpty()) {
            file = file3;
            V2.addView(U("Empty folder", 16.0f, -7236192, false), v(this, this.f781a, this.f782b, 24, 20, 0, 48));
        } else {
            file = file3;
        }
        for (File file5 : list2) {
            LinearLayout r5 = r();
            r5.setGravity(16);
            r5.setPadding(n(20), n(16), n(20), n(16));
            List list3 = list2;
            r5.addView(t(file5.isDirectory() ? "folderf" : "file", file5.isDirectory() ? -8012033 : -9670532, 26, 1.8f), v(this, n(26), n(26), 0, 0, 18, 32));
            TextView U5 = U(file5.getName(), 18.0f, -263172, false);
            U5.setSingleLine(true);
            U5.setEllipsize(TextUtils.TruncateAt.END);
            r5.addView(U5, new LinearLayout.LayoutParams(0, i5, 1.0f));
            long currentTimeMillis = (System.currentTimeMillis() - file5.lastModified()) / 1000;
            if (currentTimeMillis < 60) {
                str = "now";
            } else {
                long j2 = 60;
                long j3 = currentTimeMillis / j2;
                if (j3 >= 60) {
                    long j4 = j3 / j2;
                    if (j4 >= 24) {
                        c2 = 24;
                        long j5 = j4 / 24;
                        if (j5 >= 30) {
                            long j6 = j5 / 30;
                            if (j6 >= 12) {
                                long j7 = j5 / 365;
                                str = j7 <= 1 ? "1 year ago" : j7 + " years ago";
                            } else if (j6 == 1) {
                                str = "1 month ago";
                            } else {
                                str = j6 + " months ago";
                            }
                        } else if (j5 == 1) {
                            str = "1 day ago";
                        } else {
                            str = j5 + " days ago";
                        }
                        TextView U6 = U(str, 13.0f, -7236192, false);
                        U6.setSingleLine(true);
                        int i8 = this.f782b;
                        r5.addView(U6, v(this, i8, i8, 0, 12, 0, 48));
                        D(r5, new C0071s(eVar, r4, this, file5, 5));
                        V2.addView(r5, v(this, this.f781a, this.f782b, 0, 0, 0, 60));
                        View view = new View(this);
                        view.setBackgroundColor(-13882061);
                        V2.addView(view, v(this, this.f781a, 1, 0, 0, 0, 60));
                        list2 = list3;
                    } else if (j4 == 1) {
                        str = "1 hour ago";
                    } else {
                        str = j4 + " hours ago";
                    }
                } else if (j3 == 1) {
                    str = "1 minute ago";
                } else {
                    str = j3 + " minutes ago";
                }
            }
            c2 = 24;
            TextView U62 = U(str, 13.0f, -7236192, false);
            U62.setSingleLine(true);
            int i82 = this.f782b;
            r5.addView(U62, v(this, i82, i82, 0, 12, 0, 48));
            D(r5, new C0071s(eVar, r4, this, file5, 5));
            V2.addView(r5, v(this, this.f781a, this.f782b, 0, 0, 0, 60));
            View view2 = new View(this);
            view2.setBackgroundColor(-13882061);
            V2.addView(view2, v(this, this.f781a, 1, 0, 0, 0, 60));
            list2 = list3;
        }
        frameLayout.addView(V, new FrameLayout.LayoutParams(i6, i6));
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            File file6 = (File) obj;
            if (file6.isFile()) {
                String lowerCase = file6.getName().toLowerCase(Locale.ROOT);
                b.d(lowerCase, "toLowerCase(...)");
                if (lowerCase.endsWith(".zip")) {
                    arrayList.add(obj);
                }
            }
        }
        final ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new b.b("Create file", -263172));
        arrayList2.add(new b.b("Create folder", -263172));
        arrayList2.add(new b.b("Upload zip", -263172));
        arrayList2.add(new b.b("Rename", -263172));
        arrayList2.add(new b.b("Delete", -1014126));
        if (!arrayList.isEmpty()) {
            arrayList2.add(new b.b("Unzip", -263172));
        }
        final File file7 = file;
        a(frameLayout, frameLayout3, arrayList2, new h.b() { // from class: a.Z1
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // h.b
            public final Object a(Object obj2) {
                int intValue = ((Integer) obj2).intValue();
                int i9 = MainActivity.R;
                String str2 = (String) ((b.b) arrayList2.get(intValue)).f764a;
                int hashCode = str2.hashCode();
                i.e eVar2 = eVar;
                TextView textView = U3;
                LinearLayout linearLayout = r4;
                MainActivity mainActivity = this;
                File file8 = file7;
                switch (hashCode) {
                    case -1850727586:
                        if (str2.equals("Rename")) {
                            eVar2.f847a = 1;
                            textView.setText("Tap a file or folder to rename");
                            linearLayout.setVisibility(0);
                            break;
                        }
                        mainActivity.E("Create folder", "Folder name", "", "Create", new C0015d2(file8, mainActivity, 1));
                        break;
                    case 81896904:
                        if (str2.equals("Unzip")) {
                            eVar2.f847a = 3;
                            textView.setText("Tap a zip file to unzip");
                            linearLayout.setVisibility(0);
                            break;
                        }
                        mainActivity.E("Create folder", "Folder name", "", "Create", new C0015d2(file8, mainActivity, 1));
                        break;
                    case 1115695616:
                        if (str2.equals("Create file")) {
                            mainActivity.E("Create file", "File name", "", "Create", new C0015d2(file8, mainActivity, 0));
                            break;
                        }
                        mainActivity.E("Create folder", "Folder name", "", "Create", new C0015d2(file8, mainActivity, 1));
                        break;
                    case 1748853922:
                        if (str2.equals("Upload zip")) {
                            mainActivity.Q = file8;
                            try {
                                Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                                intent.addCategory("android.intent.category.OPENABLE");
                                intent.setType("*/*");
                                intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/zip", "application/x-zip-compressed", "application/x-zip", "application/octet-stream"});
                                mainActivity.startActivityForResult(intent, 77);
                                break;
                            } catch (Exception unused) {
                                mainActivity.T("Cannot open the file picker");
                                break;
                            }
                        }
                        mainActivity.E("Create folder", "Folder name", "", "Create", new C0015d2(file8, mainActivity, 1));
                        break;
                    case 2043376075:
                        if (str2.equals("Delete")) {
                            eVar2.f847a = 2;
                            textView.setText("Tap a file or folder to delete");
                            linearLayout.setVisibility(0);
                            break;
                        }
                        mainActivity.E("Create folder", "Folder name", "", "Create", new C0015d2(file8, mainActivity, 1));
                        break;
                    default:
                        mainActivity.E("Create folder", "Folder name", "", "Create", new C0015d2(file8, mainActivity, 1));
                        break;
                }
                return b.d.f770c;
            }
        });
        H(frameLayout, -15263716, -15263716, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void M() {
        C0006b1 c0006b1;
        C0006b1 c0006b12;
        String str;
        String str2;
        SharedPreferences sharedPreferences;
        JSONObject optJSONObject;
        int i2;
        JSONArray jSONArray;
        int i3;
        String str3;
        SharedPreferences sharedPreferences2;
        JSONObject jSONObject;
        JSONArray optJSONArray;
        ArrayList arrayList;
        String str4;
        String optString;
        JSONObject jSONObject2;
        Iterator it;
        int i4;
        int i5 = 1;
        this.f784d = "group";
        this.f791k = null;
        h();
        C0006b1 c0006b13 = this.f793m;
        if (c0006b13 != null) {
            c0006b13.t();
        }
        String str5 = this.f785e;
        C0006b1 c0006b14 = new C0006b1(this, str5, new C0001a0(2, this), new K1(this, 7));
        this.f793m = c0006b14;
        c0006b14.y = this.f787g;
        Window window = getWindow();
        if (window != null && (!m.F(str5, c0006b14.C1))) {
            window.addFlags(8192);
        }
        File file = z2.f758a;
        File file2 = new File(getCacheDir(), "chat");
        file2.mkdirs();
        z2.f758a = file2;
        FrameLayout frameLayout = new FrameLayout(this);
        c0006b14.A = frameLayout;
        frameLayout.addView(c0006b14.j(), new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = c0006b14.A;
        if (frameLayout2 == null) {
            b.g("shell");
            throw null;
        }
        frameLayout2.addView(c0006b14.n(), new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout3 = c0006b14.A;
        if (frameLayout3 == null) {
            b.g("shell");
            throw null;
        }
        int i6 = 0;
        H(frameLayout3, 0, c0006b14.L() ? c0006b14.w.f486f : c0006b14.f422i, c0006b14.L() ? c0006b14.w.q : !c0006b14.f419f, true);
        c0006b14.z = new C0011c2(this);
        c0006b14.G = true;
        AbstractC0008c.f441d = true;
        C0018e1.f459a.b(getApplicationContext());
        String str6 = "";
        try {
            str3 = "chatcache_" + str5;
            sharedPreferences2 = AbstractC0008c.f440c;
        } catch (Exception unused) {
        }
        if (sharedPreferences2 == null) {
            b.g("sp");
            throw null;
        }
        String string = sharedPreferences2.getString(str3, "");
        if (string == null) {
            string = "";
        }
        if (string.length() != 0 && (optJSONArray = (jSONObject = new JSONObject(string)).optJSONArray("msgs")) != null && optJSONArray.length() != 0) {
            int length = optJSONArray.length();
            int i7 = 0;
            while (true) {
                arrayList = c0006b14.D;
                if (i7 >= length) {
                    break;
                }
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i7);
                if (optJSONObject2 != null && !((HashSet) c0006b14.J0.a()).contains(Long.valueOf(optJSONObject2.optLong("id")))) {
                    arrayList.add(C0006b1.k0(optJSONObject2));
                }
                i7++;
            }
            if (arrayList.size() > 1) {
                g.F(arrayList, new N0(i5));
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("r");
            if (optJSONObject3 != null) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    K0 k0 = (K0) it2.next();
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray(String.valueOf(k0.f150a));
                    if (optJSONArray2 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        int length2 = optJSONArray2.length();
                        int i8 = i6;
                        while (i8 < length2) {
                            JSONArray optJSONArray3 = optJSONArray2.optJSONArray(i8);
                            if (optJSONArray3 == null) {
                                jSONObject2 = optJSONObject3;
                                it = it2;
                                i4 = 1;
                            } else {
                                jSONObject2 = optJSONObject3;
                                it = it2;
                                String optString2 = optJSONArray3.optString(i6);
                                i4 = 1;
                                arrayList2.add(new b.b(optString2, optJSONArray3.optString(1)));
                            }
                            i8 += i4;
                            optJSONObject3 = jSONObject2;
                            it2 = it;
                            i6 = 0;
                        }
                        c0006b14.E.put(Long.valueOf(k0.f150a), arrayList2);
                        optJSONObject3 = optJSONObject3;
                        it2 = it2;
                        i6 = 0;
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("mem");
            if (optJSONArray4 != null) {
                ArrayList arrayList3 = new ArrayList();
                int length3 = optJSONArray4.length();
                for (int i9 = 0; i9 < length3; i9++) {
                    JSONObject optJSONObject4 = optJSONArray4.optJSONObject(i9);
                    if (optJSONObject4 != null) {
                        String optString3 = optJSONObject4.optString("u");
                        arrayList3.add(optString3);
                        c0006b14.t0.put(optString3, optJSONObject4.optString("n", optString3));
                        String optString4 = optJSONObject4.optString("p", "");
                        if (optString4.length() > 0) {
                            c0006b14.l0.put(optString3, optString4);
                        }
                    }
                }
                c0006b14.F = arrayList3;
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("seen");
            if (optJSONObject5 != null) {
                Iterator<String> keys = optJSONObject5.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    c0006b14.m0.put(next, Long.valueOf(optJSONObject5.optLong(next)));
                }
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("g");
            if (optJSONObject6 == null || (str4 = optJSONObject6.optString("name", "")) == null) {
                str4 = "";
            }
            c0006b14.u0 = str4;
            if (optJSONObject6 != null && (optString = optJSONObject6.optString("pic", "")) != null) {
                str6 = optString;
            }
            c0006b14.v0 = str6;
            if (str6.length() > 0) {
                File file3 = z2.f758a;
                A2 a2 = c0006b14.w0;
                if (a2 == null) {
                    b.g("headPic");
                    throw null;
                }
                z2.f(a2, c0006b14.v0);
            }
            c0006b14.I = jSONObject.optBoolean("more", true);
            c0006b14.L = !arrayList.isEmpty();
            c0006b14.w0();
            c0006b14.x0(true);
        }
        ArrayList arrayList4 = c0006b14.O0;
        if (c0006b14.N0) {
            c0006b12 = c0006b14;
        } else {
            c0006b14.N0 = true;
            try {
                str = "outbox_" + c0006b14.f415b;
                str2 = "[]";
                sharedPreferences = AbstractC0008c.f440c;
            } catch (Exception unused2) {
            }
            if (sharedPreferences == null) {
                b.g("sp");
                throw null;
            }
            String string2 = sharedPreferences.getString(str, "[]");
            if (string2 != null) {
                str2 = string2;
            }
            JSONArray jSONArray2 = new JSONArray(str2);
            int length4 = jSONArray2.length();
            int i10 = 0;
            while (i10 < length4) {
                JSONObject optJSONObject7 = jSONArray2.optJSONObject(i10);
                if (optJSONObject7 != null && (optJSONObject = optJSONObject7.optJSONObject("b")) != null) {
                    long j2 = c0006b14.L0;
                    long j3 = c0006b14.M0 + 1;
                    c0006b14.M0 = j3;
                    long j4 = j2 + j3;
                    ArrayList arrayList5 = new ArrayList();
                    JSONArray optJSONArray5 = optJSONObject.optJSONArray("media");
                    if (optJSONArray5 != null) {
                        i2 = length4;
                        int i11 = 0;
                        for (int length5 = optJSONArray5.length(); i11 < length5; length5 = length5) {
                            arrayList5.add(optJSONArray5.optString(i11));
                            i11++;
                        }
                    } else {
                        i2 = length4;
                    }
                    ArrayList arrayList6 = new ArrayList();
                    JSONArray optJSONArray6 = optJSONObject.optJSONArray("wave");
                    if (optJSONArray6 != null) {
                        int length6 = optJSONArray6.length();
                        jSONArray = jSONArray2;
                        int i12 = 0;
                        while (i12 < length6) {
                            arrayList6.add(Integer.valueOf(optJSONArray6.optInt(i12)));
                            i12++;
                            optJSONArray6 = optJSONArray6;
                        }
                    } else {
                        jSONArray = jSONArray2;
                    }
                    long optLong = optJSONObject7.optLong("ts", System.currentTimeMillis());
                    i3 = i10;
                    ArrayList arrayList7 = arrayList4;
                    try {
                        c0006b1 = c0006b14;
                    } catch (Exception unused3) {
                        c0006b1 = c0006b14;
                    }
                    try {
                        c0006b14.D.add(new K0(j4, c0006b14.f415b, optJSONObject.optString("type"), optJSONObject.optString("text"), arrayList5, arrayList6, optJSONObject.optInt("dur"), optJSONObject.optLong("reply", 0L), optLong, optJSONObject7.optString("u"), optJSONObject7.optString("t"), optJSONObject7.optString("x"), optJSONObject7.optBoolean("d")));
                        arrayList4 = arrayList7;
                        arrayList4.add(new M0(j4, optJSONObject, optLong, optJSONObject7.optString("u"), optJSONObject7.optString("t"), optJSONObject7.optString("x"), optJSONObject7.optBoolean("d")));
                        i10 = i3 + 1;
                        length4 = i2;
                        jSONArray2 = jSONArray;
                        c0006b14 = c0006b1;
                    } catch (Exception unused4) {
                        arrayList4 = arrayList7;
                        if (!arrayList4.isEmpty()) {
                        }
                        c0006b12.y0();
                        c0006b12.U();
                        c0006b12.f418e.post(c0006b12.F0);
                    }
                }
                i2 = length4;
                jSONArray = jSONArray2;
                i3 = i10;
                c0006b1 = c0006b14;
                i10 = i3 + 1;
                length4 = i2;
                jSONArray2 = jSONArray;
                c0006b14 = c0006b1;
            }
            c0006b1 = c0006b14;
            if (!arrayList4.isEmpty()) {
                c0006b12 = c0006b1;
            } else {
                c0006b1.w0();
                c0006b12 = c0006b1;
                c0006b12.x0(true);
            }
        }
        c0006b12.y0();
        c0006b12.U();
        c0006b12.f418e.post(c0006b12.F0);
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x08fc  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0a59  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0a60  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0a64  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0a5c  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x06c6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x06c0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x06d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void N() {
        JSONObject jSONObject;
        String str;
        JSONArray jSONArray;
        int i2;
        int i3;
        int i4;
        View view;
        String str2;
        int length;
        int i5;
        final String str3;
        JSONArray jSONArray2;
        LinearLayout linearLayout;
        int i6 = 0;
        JSONObject jSONObject2 = AbstractC0008c.f438a;
        if (jSONObject2 == null || (jSONObject = jSONObject2.optJSONObject("app")) == null || !AbstractC0008c.s(jSONObject)) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            R();
            return;
        }
        JSONObject i7 = AbstractC0008c.i(this.f785e);
        if (i7 == null || AbstractC0008c.q(i7)) {
            O(i7 != null && i7.optBoolean("known", true));
            return;
        }
        C0006b1 c0006b1 = this.f793m;
        if (c0006b1 != null) {
            c0006b1.t();
        }
        this.f793m = null;
        L2 l2 = L2.f198a;
        L2.f201d = true;
        l2.c();
        this.f784d = "home";
        this.f791k = null;
        h();
        this.f792l = B2.c(this);
        long optLong = i7.optLong("expires_at", 0L);
        LinearLayout V = V();
        V.setBackgroundColor(AbstractC0008c.f442e ? -15066598 : -1);
        LinearLayout V2 = V();
        V2.setBackgroundColor(AbstractC0008c.f442e ? -14540254 : -789258);
        V2.setPadding(n(20), n(14), n(20), n(14));
        LinearLayout r2 = r();
        r2.addView(t("logo", -43230, 30, 2.0f), v(this, n(30), n(30), 0, 0, 0, 60));
        View U = U("NixHost", 26.0f, AbstractC0008c.m(), true);
        int i8 = this.f782b;
        r2.addView(U, v(this, i8, i8, 0, 10, 0, 48));
        r2.addView(new View(this), new LinearLayout.LayoutParams(0, 1, 1.0f));
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackground(I(AbstractC0008c.f442e ? -13750738 : -1710101, 10, 0, 0));
        frameLayout.addView(t("folder", -429290, 20, 2.0f), new FrameLayout.LayoutParams(n(20), n(20), 17));
        D(frameLayout, new K1(this, 2));
        r2.addView(frameLayout, v(this, n(36), n(36), 0, 0, 10, 32));
        FrameLayout frameLayout2 = new FrameLayout(this);
        frameLayout2.setBackground(I(AbstractC0008c.f442e ? -13750738 : -1710101, 10, 0, 0));
        frameLayout2.addView(t("chatdots", -429290, 22, 2.4f), new FrameLayout.LayoutParams(n(22), n(22), 17));
        D(frameLayout2, new K1(this, 3));
        r2.addView(frameLayout2, v(this, n(36), n(36), 0, 0, 12, 32));
        FrameLayout frameLayout3 = new FrameLayout(this);
        frameLayout3.setBackground(I(AbstractC0008c.f442e ? -3025445 : -429290, 16, 0, 0));
        FrameLayout frameLayout4 = new FrameLayout(this);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        frameLayout4.setBackground(gradientDrawable);
        boolean z = AbstractC0008c.f442e;
        frameLayout4.addView(t(z ? "moon" : "sun", z ? -13156015 : -429290, 18, 2.0f), new FrameLayout.LayoutParams(n(18), n(18), 17));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n(26), n(26), (AbstractC0008c.f442e ? 8388611 : 8388613) | 16);
        layoutParams.setMargins(n(3), 0, n(3), 0);
        frameLayout3.addView(frameLayout4, layoutParams);
        frameLayout3.setOnClickListener(new ViewOnClickListenerC0019e2(this, i6));
        r2.addView(frameLayout3, v(this, n(56), n(32), 0, 0, 0, 60));
        View t2 = t("up", AbstractC0008c.m(), 28, 2.2f);
        r2.addView(t2, v(this, n(28), n(28), 0, 12, 0, 48));
        V2.addView(r2);
        LinearLayout r3 = r();
        r3.addView(t("user", -429290, 20, 2.0f), v(this, n(20), n(20), 0, 0, 0, 60));
        View U2 = U(this.f785e, 16.0f, AbstractC0008c.l(), false);
        int i9 = this.f782b;
        r3.addView(U2, v(this, i9, i9, 0, 8, 0, 48));
        r3.addView(t("cal", -429290, 20, 2.0f), v(this, n(20), n(20), 0, 20, 0, 48));
        if (optLong > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            str = J0.a("expire ", simpleDateFormat.format(new Date(optLong)));
        } else {
            str = "no expiry";
        }
        View U3 = U(str, 16.0f, AbstractC0008c.l(), false);
        int i10 = this.f782b;
        r3.addView(U3, v(this, i10, i10, 0, 8, 0, 48));
        V2.addView(r3, v(this, this.f781a, this.f782b, 12, 0, 0, 56));
        i.g gVar = new i.g();
        gVar.f850b = new C0(2);
        D(t2, new I0(1, gVar));
        V.addView(V2, v(this, this.f781a, this.f782b, 0, 0, 0, 60));
        View view2 = new View(this);
        view2.setBackgroundColor(AbstractC0008c.f442e ? -13684945 : -1710101);
        V.addView(view2, v(this, this.f781a, 1, 0, 0, 0, 60));
        ScrollView scrollView = new ScrollView(this);
        LinearLayout V3 = V();
        V3.setPadding(n(20), n(26), n(20), n(110));
        scrollView.addView(V3, new FrameLayout.LayoutParams(this.f781a, this.f782b));
        V.addView(scrollView, new LinearLayout.LayoutParams(this.f781a, 0, 1.0f));
        JSONObject jSONObject3 = AbstractC0008c.f438a;
        if (jSONObject3 == null || (jSONArray = jSONObject3.optJSONArray("instances")) == null) {
            jSONArray = new JSONArray();
        }
        final JSONArray jSONArray3 = jSONArray;
        final int optInt = i7.optInt("instance_count", 0);
        boolean z2 = optInt <= 0 || jSONArray3.length() >= optInt;
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        LinearLayout V4 = V();
        V4.addView(U("Terminal\nInstances", 28.0f, AbstractC0008c.m(), true));
        final boolean z3 = z2;
        V4.addView(U(jSONArray3.length() + " / " + optInt + " instances used", 16.0f, AbstractC0008c.l(), false), v(this, this.f781a, this.f782b, 6, 0, 0, 56));
        linearLayout2.addView(V4, new LinearLayout.LayoutParams(0, this.f782b, 1.0f));
        boolean x = x();
        this.O = x;
        boolean z4 = x ^ true;
        LinearLayout r4 = r();
        r4.setGravity(17);
        r4.setPadding(n(14), n(10), n(14), n(10));
        if (z3 || z4) {
            i2 = 16;
            i3 = AbstractC0008c.f442e ? -13882321 : -1710101;
        } else {
            i3 = -429290;
            i2 = 16;
        }
        r4.setBackground(I(i3, i2, 0, 0));
        if (!z3 && !z4) {
            r4.setElevation(n(6));
        }
        if (z3 || z4) {
            i4 = AbstractC0008c.f442e ? -7697776 : -9735552;
        } else {
            i4 = -1;
        }
        r4.addView(t(z4 ? "wifioff" : z3 ? "lock" : "plus", i4, 22, 2.2f), v(this, n(22), n(22), 0, 0, 10, 32));
        TextView U4 = U("New\nInstance", 16.0f, i4, true);
        U4.setGravity(17);
        int i11 = this.f782b;
        r4.addView(U4, v(this, i11, i11, 0, 0, 0, 60));
        D(r4, new a() { // from class: a.a2
            @Override // h.a
            public final Object a() {
                int i12 = MainActivity.R;
                MainActivity mainActivity = MainActivity.this;
                if (!mainActivity.x()) {
                    mainActivity.T("Internet is needed to create an instance");
                } else if (z3) {
                    mainActivity.T(optInt <= 0 ? "No instances allowed on your plan" : "Maximum instances reached");
                } else {
                    mainActivity.E("New Instance", "Instance name", "", "Save", new C0028h(jSONArray3, mainActivity, 3));
                }
                return b.d.f770c;
            }
        });
        int i12 = this.f782b;
        linearLayout2.addView(r4, v(this, i12, i12, 2, 12, 0, 48));
        V3.addView(linearLayout2, v(this, this.f781a, this.f782b, 0, 0, 0, 60));
        LinearLayout V5 = V();
        boolean x2 = x();
        this.O = x2;
        if (x2) {
            view = t2;
            if (jSONArray3.length() == 0) {
                str2 = "logo";
                View t3 = t(str2, -43230, 96, 1.8f);
                LinearLayout.LayoutParams v2 = v(this, n(96), n(96), 90, 0, 0, 56);
                v2.gravity = 1;
                V5.addView(t3, v2);
                length = !this.O ? jSONArray3.length() : 0;
                i5 = 0;
                while (i5 < length) {
                    JSONObject jSONObject4 = jSONArray3.getJSONObject(i5);
                    final String optString = jSONObject4.optString("id");
                    String optString2 = jSONObject4.optString("name");
                    long optLong2 = jSONObject4.optLong("created", 0L);
                    LinearLayout V6 = V();
                    int i13 = i5;
                    V6.setBackground(null);
                    LinearLayout r5 = r();
                    r5.setPadding(n(18), n(18), n(18), n(18));
                    String str4 = str2;
                    r5.addView(t(str2, -43230, 26, 2.0f), v(this, n(26), n(26), 0, 0, 14, 32));
                    LinearLayout V7 = V();
                    V7.addView(U(optString2, 24.0f, AbstractC0008c.f442e ? -1 : -15656921, true));
                    if (optLong2 > 0) {
                        str3 = optString2;
                        jSONArray2 = jSONArray3;
                        linearLayout = V7;
                        linearLayout.addView(U(J0.a("Created: ", new SimpleDateFormat("MMM d, yyyy, h:mm a", Locale.US).format(new Date(optLong2))), 16.0f, AbstractC0008c.f442e ? -8618878 : -9735552, false), v(this, this.f781a, this.f782b, 6, 0, 0, 56));
                    } else {
                        str3 = optString2;
                        jSONArray2 = jSONArray3;
                        linearLayout = V7;
                    }
                    final int i14 = 0;
                    r5.addView(linearLayout, new LinearLayout.LayoutParams(0, this.f782b, 1.0f));
                    D(r5, new a(this) { // from class: a.b2

                        /* renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ MainActivity f435b;

                        {
                            this.f435b = this;
                        }

                        @Override // h.a
                        public final Object a() {
                            String str5 = str3;
                            String str6 = optString;
                            switch (i14) {
                                case 0:
                                    int i15 = MainActivity.R;
                                    this.f435b.y(str6, str5);
                                    break;
                                default:
                                    int i16 = MainActivity.R;
                                    String str7 = "\"" + str6 + "\" will be deleted. Anything running in it will be stopped.";
                                    MainActivity mainActivity = this.f435b;
                                    X1 x1 = new X1(mainActivity, str5);
                                    mainActivity.getClass();
                                    MainActivity.g(mainActivity, 0, false, new N1(mainActivity, "Delete instance?", str7, "Delete", -1096636, x1), 3);
                                    break;
                            }
                            return b.d.f770c;
                        }
                    });
                    V6.addView(r5, v(this, this.f781a, this.f782b, 0, 0, 0, 60));
                    View view3 = new View(this);
                    view3.setBackgroundColor(AbstractC0008c.f442e ? -11184805 : -3880753);
                    V6.addView(view3, v(this, this.f781a, 2, 0, 0, 0, 60));
                    LinearLayout r6 = r();
                    r6.setPadding(n(18), n(16), n(18), n(16));
                    r6.addView(t("trash", -1096636, 22, 2.0f), v(this, n(22), n(22), 0, 0, 10, 32));
                    View U5 = U("Delete", 19.0f, -1096636, true);
                    int i15 = this.f782b;
                    r6.addView(U5, v(this, i15, i15, 0, 0, 0, 60));
                    final int i16 = 1;
                    D(r6, new a(this) { // from class: a.b2

                        /* renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ MainActivity f435b;

                        {
                            this.f435b = this;
                        }

                        @Override // h.a
                        public final Object a() {
                            String str5 = optString;
                            String str6 = str3;
                            switch (i16) {
                                case 0:
                                    int i152 = MainActivity.R;
                                    this.f435b.y(str6, str5);
                                    break;
                                default:
                                    int i162 = MainActivity.R;
                                    String str7 = "\"" + str6 + "\" will be deleted. Anything running in it will be stopped.";
                                    MainActivity mainActivity = this.f435b;
                                    X1 x1 = new X1(mainActivity, str5);
                                    mainActivity.getClass();
                                    MainActivity.g(mainActivity, 0, false, new N1(mainActivity, "Delete instance?", str7, "Delete", -1096636, x1), 3);
                                    break;
                            }
                            return b.d.f770c;
                        }
                    });
                    V6.addView(r6, v(this, this.f781a, this.f782b, 0, 0, 0, 60));
                    V5.addView(V6, v(this, this.f781a, this.f782b, 16, 0, 0, 56));
                    i5 = i13 + 1;
                    length = length;
                    jSONArray3 = jSONArray2;
                    str2 = str4;
                }
                V3.addView(V5, v(this, this.f781a, this.f782b, 0, 0, 0, 60));
                FrameLayout frameLayout5 = new FrameLayout(this);
                FrameLayout frameLayout6 = new FrameLayout(this);
                int i17 = this.f781a;
                frameLayout6.addView(V, new FrameLayout.LayoutParams(i17, i17));
                int i18 = this.f781a;
                frameLayout5.addView(frameLayout6, new FrameLayout.LayoutParams(i18, i18));
                gVar.f850b = new D(this, frameLayout5, view, 4);
                if (!B2.c(this)) {
                    String str5 = this.f785e;
                    View view4 = new View(this);
                    view4.setBackgroundColor(Integer.MIN_VALUE);
                    view4.setClickable(true);
                    view4.setFocusable(true);
                    view4.setAlpha(0.0f);
                    int i19 = this.f781a;
                    frameLayout5.addView(view4, new FrameLayout.LayoutParams(i19, i19));
                    LinearLayout V8 = V();
                    float n2 = n(28);
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setColor(AbstractC0008c.f442e ? -14540254 : -1);
                    gradientDrawable2.setCornerRadii(new float[]{n2, n2, n2, n2, 0.0f, 0.0f, 0.0f, 0.0f});
                    gradientDrawable2.setStroke(n(1), AbstractC0008c.f442e ? -13684945 : -1710101);
                    V8.setBackground(gradientDrawable2);
                    V8.setElevation(n(16));
                    V8.setClickable(true);
                    V8.setPadding(n(24), n(12), n(24), n(24));
                    View view5 = new View(this);
                    view5.setBackground(I(AbstractC0008c.f442e ? -13684945 : -1710101, 3, 0, 0));
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(n(40), n(5));
                    layoutParams2.gravity = 1;
                    layoutParams2.bottomMargin = n(18);
                    V8.addView(view5, layoutParams2);
                    V8.addView(U("Keep your files safe", 20.0f, AbstractC0008c.f442e ? -1 : -15656921, true));
                    V8.addView(U("Allow \"All files access\" so your files are saved in NixHost/" + str5 + " on your phone and stay after reinstall.", 15.0f, AbstractC0008c.f442e ? -8618878 : -9735552, false), v(this, this.f781a, this.f782b, 8, 0, 0, 56));
                    V8.addView(m("Allow", -429290, -1, false, new K1(this, 10)), v(this, this.f781a, n(52), 20, 0, 0, 56));
                    V8.setVisibility(4);
                    frameLayout5.addView(V8, new FrameLayout.LayoutParams(i19, this.f782b, 80));
                    V8.post(new RunnableC0056o(V8, view4, frameLayout6, 7));
                }
                boolean z5 = AbstractC0008c.f442e;
                H(frameLayout5, !z5 ? -14540254 : -789258, !z5 ? -15066598 : -1, !z5, false);
            }
        } else {
            LinearLayout V9 = V();
            V9.setBackground(I(AbstractC0008c.f442e ? -14540254 : -789258, 18, 0, 0));
            V9.setPadding(n(18), n(22), n(18), n(18));
            LinearLayout r7 = r();
            r7.setGravity(17);
            view = t2;
            r7.addView(t("wifioff", AbstractC0008c.m(), 26, 2.0f), v(this, n(26), n(26), 0, 0, 10, 32));
            View U6 = U("Connect to the internet", 20.0f, AbstractC0008c.m(), true);
            int i20 = this.f782b;
            r7.addView(U6, v(this, i20, i20, 0, 0, 0, 60));
            V9.addView(r7, v(this, this.f781a, this.f782b, 0, 0, 0, 60));
            V9.addView(f(m("Go to Settings", AbstractC0008c.f442e ? -13750738 : -1710101, AbstractC0008c.m(), false, new K1(this, 4)), m("Retry", -429290, -1, false, new K1(this, 5))), v(this, this.f781a, this.f782b, 20, 0, 0, 56));
            V5.addView(V9, v(this, this.f781a, this.f782b, 24, 0, 0, 56));
        }
        str2 = "logo";
        if (!this.O) {
        }
        i5 = 0;
        while (i5 < length) {
        }
        V3.addView(V5, v(this, this.f781a, this.f782b, 0, 0, 0, 60));
        FrameLayout frameLayout52 = new FrameLayout(this);
        FrameLayout frameLayout62 = new FrameLayout(this);
        int i172 = this.f781a;
        frameLayout62.addView(V, new FrameLayout.LayoutParams(i172, i172));
        int i182 = this.f781a;
        frameLayout52.addView(frameLayout62, new FrameLayout.LayoutParams(i182, i182));
        gVar.f850b = new D(this, frameLayout52, view, 4);
        if (!B2.c(this)) {
        }
        boolean z52 = AbstractC0008c.f442e;
        H(frameLayout52, !z52 ? -14540254 : -789258, !z52 ? -15066598 : -1, !z52, false);
    }

    public final void O(boolean z) {
        String str;
        String str2;
        L2 l2 = L2.f198a;
        L2.f201d = false;
        l2.c();
        this.f784d = "locked";
        h();
        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);
        scrollView.setBackgroundColor(AbstractC0008c.f442e ? -15066598 : -1);
        LinearLayout V = V();
        V.setGravity(17);
        V.setPadding(n(28), n(28), n(28), n(28));
        int i2 = this.f781a;
        scrollView.addView(V, new FrameLayout.LayoutParams(i2, i2));
        FrameLayout frameLayout = new FrameLayout(this);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(871985942);
        frameLayout.setBackground(gradientDrawable);
        frameLayout.addView(t("lock", -429290, 34, 2.0f), new FrameLayout.LayoutParams(n(34), n(34), 17));
        V.addView(frameLayout, v(this, n(72), n(72), 0, 0, 0, 60));
        TextView U = U(z ? "Account expired or locked" : "Account not found", 24.0f, AbstractC0008c.f442e ? -1 : -15656921, true);
        U.setGravity(17);
        V.addView(U, v(this, this.f781a, this.f782b, 18, 0, 0, 56));
        JSONObject jSONObject = AbstractC0008c.f438a;
        JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("contact") : null;
        if (optJSONObject == null || (str = optJSONObject.optString("message", "")) == null) {
            str = "";
        }
        if (str.length() == 0) {
            str = "Please contact the admin to renew.";
        }
        TextView U2 = U(str, 16.0f, AbstractC0008c.f442e ? -8618878 : -9735552, false);
        U2.setGravity(17);
        V.addView(U2, v(this, this.f781a, this.f782b, 10, 0, 0, 56));
        if (optJSONObject == null || (str2 = optJSONObject.optString("whatsapp", "")) == null) {
            str2 = "";
        }
        if (str2.length() > 0) {
            V.addView(W("Contact", new X1(2, this, str2)), v(this, this.f781a, n(56), 22, 0, 0, 56));
        }
        V.addView(f(m("Logout", 0, AbstractC0008c.f442e ? -1 : -15656921, true, new K1(this, 11)), m("Check again", -429290, -1, false, new K1(this, 12))), v(this, this.f781a, this.f782b, 14, 0, 0, 56));
        boolean z2 = AbstractC0008c.f442e;
        H(scrollView, z2 ? -15066598 : -1, z2 ? -15066598 : -1, !z2, false);
    }

    public final void P() {
        L2 l2 = L2.f198a;
        L2.f201d = false;
        l2.c();
        this.f784d = "login";
        h();
        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TL_BR;
        scrollView.setBackground(new GradientDrawable(orientation, new int[]{-429290, -2349530}));
        FrameLayout frameLayout = new FrameLayout(this);
        int i2 = this.f781a;
        scrollView.addView(frameLayout, new FrameLayout.LayoutParams(i2, i2));
        LinearLayout V = V();
        V.setGravity(1);
        V.setBackground(I(-1, 28, 0, 0));
        V.setPadding(n(28), n(36), n(28), n(32));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f781a, this.f782b, 17);
        layoutParams.setMargins(n(20), n(24), n(20), n(24));
        frameLayout.addView(V, layoutParams);
        V.addView(t("logo", -43230, 46, 2.0f), v(this, n(46), n(46), 0, 0, 0, 60));
        View U = U("NixHost", 32.0f, -14800581, true);
        int i3 = this.f782b;
        V.addView(U, v(this, i3, i3, 18, 0, 0, 56));
        View U2 = U("Terminal Manager", 17.0f, -9735552, false);
        int i4 = this.f782b;
        V.addView(U2, v(this, i4, i4, 4, 0, 0, 56));
        V.addView(U("Username", 16.0f, -13156015, true), v(this, this.f781a, this.f782b, 30, 0, 0, 56));
        EditText Q = Q(this, "Enter username");
        Q.setInputType(524289);
        V.addView(Q, v(this, this.f781a, n(56), 8, 0, 0, 56));
        V.addView(U("Password", 16.0f, -13156015, true), v(this, this.f781a, this.f782b, 18, 0, 0, 56));
        EditText Q2 = Q(this, "Enter password");
        Q2.setInputType(129);
        Q2.setPadding(n(16), n(14), n(52), n(14));
        FrameLayout frameLayout2 = new FrameLayout(this);
        int i5 = this.f781a;
        frameLayout2.addView(Q2, new FrameLayout.LayoutParams(i5, i5));
        G1 t2 = t("eye", -9735552, 24, 2.0f);
        t2.setPadding(n(4), n(4), n(4), n(4));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(n(36), n(36), 8388629);
        layoutParams2.rightMargin = n(8);
        frameLayout2.addView(t2, layoutParams2);
        t2.setOnClickListener(new ViewOnClickListenerC0016e(new d(), Q2, t2, 2));
        V.addView(frameLayout2, v(this, this.f781a, n(56), 8, 0, 0, 56));
        TextView U3 = U("", 14.0f, -2349530, false);
        U3.setVisibility(8);
        V.addView(U3, v(this, this.f781a, this.f782b, 12, 0, 0, 56));
        FrameLayout frameLayout3 = new FrameLayout(this);
        GradientDrawable gradientDrawable = new GradientDrawable(orientation, new int[]{-429290, -2349530});
        gradientDrawable.setCornerRadius(n(16));
        frameLayout3.setBackground(gradientDrawable);
        TextView U4 = U("Login", 20.0f, -1, true);
        int i6 = this.f782b;
        frameLayout3.addView(U4, new FrameLayout.LayoutParams(i6, i6, 17));
        ProgressBar progressBar = new ProgressBar(this);
        progressBar.setIndeterminate(true);
        progressBar.setIndeterminateTintList(ColorStateList.valueOf(-1));
        progressBar.setVisibility(8);
        frameLayout3.addView(progressBar, new FrameLayout.LayoutParams(n(28), n(28), 17));
        V.addView(frameLayout3, v(this, this.f781a, n(56), 22, 0, 0, 56));
        D(frameLayout3, new Q1(new d(), Q, Q2, U3, U4, progressBar, this));
        H(scrollView, -429290, -2349530, false, false);
    }

    public final void R() {
        JSONObject optJSONObject;
        JSONObject jSONObject = AbstractC0008c.f438a;
        JSONObject jSONObject2 = (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("app")) == null || !AbstractC0008c.s(optJSONObject)) ? null : optJSONObject;
        if (jSONObject2 == null) {
            return;
        }
        C0006b1 c0006b1 = this.f793m;
        if (c0006b1 != null) {
            c0006b1.t();
        }
        this.f793m = null;
        L2.f198a.e();
        try {
            startService(new Intent(this, (Class<?>) HostService.class).setAction("com.nix.host.STOP"));
        } catch (Exception unused) {
        }
        L2 l2 = L2.f198a;
        L2.f201d = false;
        l2.c();
        this.f784d = "update";
        this.f791k = null;
        h();
        LinearLayout V = V();
        V.setBackgroundColor(AbstractC0008c.f442e ? -15066598 : -1);
        LinearLayout r2 = r();
        r2.setBackgroundColor(AbstractC0008c.f442e ? -14540254 : -789258);
        r2.setPadding(n(20), n(14), n(20), n(14));
        r2.addView(t("logo", -43230, 30, 2.0f), v(this, n(30), n(30), 0, 0, 0, 60));
        View U = U("NixHost", 26.0f, AbstractC0008c.m(), true);
        int i2 = this.f782b;
        r2.addView(U, v(this, i2, i2, 0, 10, 0, 48));
        V.addView(r2, v(this, this.f781a, this.f782b, 0, 0, 0, 60));
        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);
        LinearLayout V2 = V();
        V2.setGravity(17);
        V2.setPadding(n(14), n(14), n(14), n(14));
        scrollView.addView(V2, new FrameLayout.LayoutParams(this.f781a, this.f782b));
        LinearLayout V3 = V();
        V3.setGravity(17);
        V3.setBackground(I(AbstractC0008c.f442e ? -14540254 : -789258, 24, 0, 0));
        V3.setPadding(n(22), n(24), n(22), n(24));
        V2.addView(V3, new LinearLayout.LayoutParams(this.f781a, this.f782b));
        V.addView(scrollView, new LinearLayout.LayoutParams(this.f781a, 0, 1.0f));
        String optString = jSONObject2.optString("name", "NixHost");
        String str = optString.length() != 0 ? optString : "NixHost";
        String optString2 = jSONObject2.optString("version", "");
        String optString3 = jSONObject2.optString("note", "");
        String optString4 = jSONObject2.optString("whatsapp", "");
        V3.addView(t("logo", -43230, 64, 2.0f), v(this, n(64), n(64), 0, 0, 0, 60));
        TextView U2 = U(str, 24.0f, AbstractC0008c.m(), true);
        U2.setGravity(17);
        V3.addView(U2, v(this, this.f781a, this.f782b, 10, 0, 0, 56));
        TextView U3 = U("New version " + optString2, 18.0f, -429290, true);
        U3.setGravity(17);
        V3.addView(U3, v(this, this.f781a, this.f782b, 4, 0, 0, 56));
        if (optString3.length() == 0) {
            optString3 = "Please install the new version. This version does not work any more.";
        }
        TextView U4 = U(optString3, 16.0f, AbstractC0008c.l(), false);
        U4.setGravity(17);
        V3.addView(U4, v(this, this.f781a, this.f782b, 10, 0, 0, 56));
        if (optString4.length() > 0) {
            V3.addView(W("Join WhatsApp Channel", new X1(1, this, optString4)), v(this, this.f781a, n(56), 18, 0, 0, 56));
        }
        TextView U5 = U("Join the channel to get the new version. The old version stays stopped until you install it.", 14.0f, AbstractC0008c.l(), false);
        U5.setGravity(17);
        V3.addView(U5, v(this, this.f781a, this.f782b, 10, 0, 0, 56));
        boolean z = AbstractC0008c.f442e;
        H(V, z ? -15066598 : -1, z ? -15066598 : -1, !z, false);
    }

    public final void S(File file) {
        String name;
        String canonicalPath;
        File file2;
        int i2 = 0;
        if (file.length() > 500000) {
            T("File too big to open here");
            return;
        }
        try {
            String I = g.m.I(file);
            if (e.P(I, (char) 0, 0, false, 6) >= 0) {
                T("Cannot open this file");
                return;
            }
            this.f784d = "view";
            h();
            this.f798t = null;
            this.f800v = null;
            FrameLayout frameLayout = new FrameLayout(this);
            LinearLayout V = V();
            V.setBackgroundColor(-15263716);
            LinearLayout r2 = r();
            r2.setPadding(n(14), n(14), n(10), n(14));
            FrameLayout frameLayout2 = new FrameLayout(this);
            frameLayout2.addView(t("arrow", -263172, 26, 2.0f), new FrameLayout.LayoutParams(n(26), n(26), 17));
            D(frameLayout2, new K1(this, i2));
            r2.addView(frameLayout2, v(this, n(40), n(40), 0, 0, 0, 60));
            try {
                canonicalPath = file.getCanonicalPath();
                file2 = this.f795o;
            } catch (Exception unused) {
                name = file.getName();
            }
            if (file2 == null) {
                b.g("homeDir");
                throw null;
            }
            name = e.k0(e.X(canonicalPath, file2.getCanonicalPath()), '/');
            if (name.length() == 0) {
                name = file.getName();
            }
            TextView U = U(name, 20.0f, -263172, true);
            U.setSingleLine(true);
            U.setEllipsize(TextUtils.TruncateAt.START);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, this.f782b, 1.0f);
            layoutParams.leftMargin = n(10);
            r2.addView(U, layoutParams);
            FrameLayout frameLayout3 = new FrameLayout(this);
            frameLayout3.addView(t("dots", -15896869, 24, 2.0f), new FrameLayout.LayoutParams(n(24), n(24), 17));
            r2.addView(frameLayout3, v(this, n(40), n(40), 0, 0, 0, 60));
            V.addView(r2, v(this, this.f781a, this.f782b, 0, 0, 0, 60));
            ArrayList arrayList = new ArrayList(e.b0(m.J(m.I(m.J(I, "\r\n", "\n"), '\r', '\n'), "\t", "    "), new String[]{"\n"}));
            if (arrayList.size() > 1 && ((CharSequence) c.b.M(arrayList)).length() == 0) {
                arrayList.remove(arrayList.size() - 1);
            }
            Set set = D1.f67a;
            ArrayList a2 = D1.a(arrayList, file.getName());
            ListView listView = new ListView(this);
            listView.setDivider(null);
            listView.setDividerHeight(0);
            listView.setBackgroundColor(-15263716);
            listView.setSelector(new ColorDrawable(0));
            listView.setOverScrollMode(2);
            listView.setAdapter((ListAdapter) new C0067q2(this, a2, String.valueOf(arrayList.size()).length()));
            int i3 = this.f781a;
            V.addView(listView, new LinearLayout.LayoutParams(i3, 0, 1.0f));
            frameLayout.addView(V, new FrameLayout.LayoutParams(i3, i3));
            a(frameLayout, frameLayout3, c.c.C(new b.b("Edit file", -263172), new b.b("Delete file", -1014126), new b.b("Copy", -263172)), new G0(this, file, I));
            H(frameLayout, -15263716, -15263716, false, false);
        } catch (Exception unused2) {
            T("Cannot open this file");
        }
    }

    public final void T(String str) {
        Toast.makeText(this, str, 1).show();
    }

    public final TextView U(String str, float f2, int i2, boolean z) {
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(1, this.K * f2);
        textView.setTextColor(i2);
        if (z) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        return textView;
    }

    public final LinearLayout V() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        return linearLayout;
    }

    public final LinearLayout W(String str, a aVar) {
        LinearLayout r2 = r();
        r2.setGravity(17);
        r2.setBackground(I(-14298266, 16, 0, 0));
        r2.addView(t("wa", -1, 26, 2.0f), v(this, n(26), n(26), 0, 0, 0, 60));
        TextView U = U(str, 20.0f, -1, true);
        int i2 = this.f782b;
        r2.addView(U, v(this, i2, i2, 0, 10, 0, 48));
        D(r2, aVar);
        return r2;
    }

    public final boolean X() {
        try {
            Object systemService = getSystemService("connectivity");
            b.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            for (Network network : connectivityManager.getAllNetworks()) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                if (networkCapabilities != null && (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(3))) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public final void a(FrameLayout frameLayout, FrameLayout frameLayout2, List list, final h.b bVar) {
        View view = new View(this);
        view.setVisibility(8);
        view.setOnClickListener(new ViewOnClickListenerC0019e2(this, 1));
        int i2 = this.f781a;
        frameLayout.addView(view, new FrameLayout.LayoutParams(i2, i2));
        LinearLayout V = V();
        V.setVisibility(8);
        V.setBackground(I(-13684937, 10, 0, 0));
        V.setElevation(n(10));
        V.setPadding(0, n(6), 0, n(6));
        V.setMinimumWidth(n(190));
        Iterator it = list.iterator();
        final int i3 = 0;
        while (it.hasNext()) {
            b.b bVar2 = (b.b) it.next();
            TextView U = U((String) bVar2.f764a, 18.0f, ((Number) bVar2.f765b).intValue(), false);
            U.setPadding(n(26), n(17), n(40), n(17));
            D(U, new a() { // from class: a.f2
                @Override // h.a
                public final Object a() {
                    int i4 = MainActivity.R;
                    MainActivity.this.i();
                    bVar.a(Integer.valueOf(i3));
                    return b.d.f770c;
                }
            });
            V.addView(U, v(this, this.f781a, this.f782b, 0, 0, 0, 60));
            i3++;
        }
        int i4 = this.f782b;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i4, 8388661);
        layoutParams.setMargins(0, n(56), n(12), 0);
        frameLayout.addView(V, layoutParams);
        this.f798t = V;
        this.f799u = view;
        D(frameLayout2, new C0027g2(V, this, 0));
    }

    public final void e(int i2, int i3, boolean z) {
        WindowInsetsController insetsController;
        getWindow().setStatusBarColor(i2);
        getWindow().setNavigationBarColor(i3);
        if (Build.VERSION.SDK_INT < 30) {
            int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            getWindow().getDecorView().setSystemUiVisibility(z ? systemUiVisibility | 8208 : systemUiVisibility & (-8209));
        } else {
            insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.setSystemBarsAppearance(z ? 24 : 0, 24);
            }
        }
    }

    public final LinearLayout f(TextView textView, TextView textView2) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, n(48), 1.0f);
        layoutParams.setMargins(0, 0, n(6), 0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, n(48), 1.0f);
        layoutParams2.setMargins(n(6), 0, 0, 0);
        linearLayout.addView(textView, layoutParams);
        linearLayout.addView(textView2, layoutParams2);
        return linearLayout;
    }

    public final void h() {
        this.f797s = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
    }

    public final void i() {
        View view = this.f799u;
        if (view != null) {
            view.setVisibility(8);
        }
        LinearLayout linearLayout = this.f798t;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public final void j() {
        LinearLayout linearLayout = this.G;
        if (linearLayout == null) {
            return;
        }
        View view = this.H;
        if (view != null) {
            view.setVisibility(8);
        }
        linearLayout.animate().alpha(0.0f).translationY(-n(24)).setDuration(120L).withEndAction(new I(linearLayout, 1)).start();
    }

    public final void k(String str, a aVar) {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        LinearLayout V = V();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-13684937);
        float n2 = n(22);
        gradientDrawable.setCornerRadii(new float[]{n2, n2, n2, n2, 0.0f, 0.0f, 0.0f, 0.0f});
        V.setBackground(gradientDrawable);
        V.setPadding(0, n(10), 0, n(16));
        View view = new View(this);
        view.setBackground(I(-9670786, 3, 0, 0));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(n(44), n(5));
        layoutParams.gravity = 1;
        V.addView(view, layoutParams);
        LinearLayout r2 = r();
        r2.setPadding(n(18), n(14), n(18), n(14));
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView(t("close", -263172, 26, 2.0f), new FrameLayout.LayoutParams(n(26), n(26), 17));
        D(frameLayout, new C0060p(dialog, 10));
        r2.addView(frameLayout, v(this, n(40), n(40), 0, 0, 0, 60));
        TextView U = U("Commit changes", 24.0f, -263172, true);
        int i2 = this.f782b;
        r2.addView(U, v(this, i2, i2, 0, 10, 0, 48));
        V.addView(r2, v(this, this.f781a, this.f782b, 12, 0, 0, 56));
        View view2 = new View(this);
        view2.setBackgroundColor(-12895421);
        V.addView(view2, v(this, this.f781a, 1, 0, 0, 0, 60));
        EditText l2 = l(this, "Commit message", str, true);
        V.addView(l2, v(this, this.f781a, this.f782b, 14, 0, 0, 56));
        V.addView(l(this, "Add an optional commit description", "", false), v(this, this.f781a, this.f782b, 4, 0, 0, 56));
        LinearLayout r3 = r();
        r3.setGravity(17);
        r3.setBackground(I(-14319045, 10, 0, 0));
        r3.setPadding(n(16), n(14), n(16), n(14));
        r3.addView(t("commit", -1, 24, 2.0f), v(this, n(24), n(24), 0, 0, 8, 32));
        TextView U2 = U("COMMIT", 18.0f, -1, true);
        int i3 = this.f782b;
        r3.addView(U2, v(this, i3, i3, 0, 0, 0, 60));
        D(r3, new T1(dialog, aVar, 1));
        V.addView(r3, v(this, this.f781a, this.f782b, 18, 18, 18, 32));
        dialog.setContentView(V);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Window window2 = dialog.getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(20);
        }
        dialog.show();
        Window window3 = dialog.getWindow();
        if (window3 != null) {
            window3.setLayout(-1, -2);
        }
        Window window4 = dialog.getWindow();
        if (window4 != null) {
            window4.setGravity(80);
        }
        Window window5 = dialog.getWindow();
        if (window5 != null) {
            window5.setDimAmount(0.55f);
        }
        l2.requestFocus();
        l2.setSelection(l2.getText().length());
    }

    public final TextView m(String str, int i2, int i3, boolean z, a aVar) {
        GradientDrawable I;
        TextView U = U(str, 17.0f, i3, true);
        U.setGravity(17);
        if (z) {
            I = I(0, 14, AbstractC0008c.f442e ? -12961222 : -1710101, 1);
        } else {
            I = I(i2, 14, 0, 0);
        }
        U.setBackground(I);
        D(U, aVar);
        return U;
    }

    public final int n(int i2) {
        return (int) (i2 * getResources().getDisplayMetrics().density * this.K);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
    
        if (r0.optBoolean("known", true) != false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o() {
        JSONObject optJSONObject;
        JSONObject jSONObject = AbstractC0008c.f438a;
        JSONObject jSONObject2 = null;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("app")) != null && AbstractC0008c.s(optJSONObject)) {
            jSONObject2 = optJSONObject;
        }
        if (jSONObject2 != null) {
            if (b.a(this.f784d, "update")) {
                return;
            }
            R();
            return;
        }
        if (b.a(this.f784d, "update")) {
            N();
            return;
        }
        JSONObject i2 = AbstractC0008c.i(this.f785e);
        if (i2 != null && !AbstractC0008c.q(i2)) {
            if (b.a(this.f784d, "locked")) {
                N();
            }
        } else {
            if (b.a(this.f784d, "locked")) {
                return;
            }
            L2.f198a.e();
            boolean z = i2 != null;
            O(z);
        }
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        Uri data;
        File file;
        C0006b1 c0006b1;
        Uri data2;
        String str;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 78) {
            if (i3 != -1 || (c0006b1 = this.f793m) == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            ClipData clipData = intent != null ? intent.getClipData() : null;
            if (clipData != null) {
                int min = Math.min(clipData.getItemCount(), 10);
                for (int i4 = 0; i4 < min; i4++) {
                    arrayList.add(clipData.getItemAt(i4).getUri());
                }
            } else if (intent != null && (data2 = intent.getData()) != null) {
                arrayList.add(data2);
            }
            if (arrayList.isEmpty()) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                try {
                    str = c0006b1.f414a.getContentResolver().getType(uri);
                } catch (Exception unused) {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                if (m.K(str, "video/")) {
                    arrayList2.add(uri);
                } else {
                    arrayList3.add(uri);
                }
            }
            if (c0006b1.z1) {
                c0006b1.z1 = false;
                Uri uri2 = (Uri) c.b.I(arrayList3);
                if (uri2 != null) {
                    c0006b1.I0(uri2);
                    return;
                }
                return;
            }
            if (!arrayList3.isEmpty()) {
                c0006b1.F0(arrayList3);
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                c0006b1.G0((Uri) it2.next());
            }
            return;
        }
        if (i2 == 79) {
            C0006b1 c0006b12 = this.f793m;
            if (c0006b12 != null) {
                boolean z = i3 == -1;
                Uri uri3 = c0006b12.T0;
                if (uri3 == null) {
                    return;
                }
                c0006b12.T0 = null;
                if (!z) {
                    try {
                        c0006b12.f414a.getContentResolver().delete(uri3, null, null);
                        return;
                    } catch (Exception unused2) {
                        return;
                    }
                } else if (!c0006b12.z1) {
                    c0006b12.F0(AbstractC0008c.p(uri3));
                    return;
                } else {
                    c0006b12.z1 = false;
                    c0006b12.I0(uri3);
                    return;
                }
            }
            return;
        }
        if (i2 != 77 || i3 != -1 || intent == null || (data = intent.getData()) == null || (file = this.Q) == null) {
            return;
        }
        String str2 = "upload.zip";
        try {
            Cursor query = getContentResolver().query(data, new String[]{"_display_name"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(0);
                        if (string != null) {
                            str2 = string;
                        }
                    }
                    AbstractC0008c.a(query, null);
                } finally {
                }
            }
        } catch (Exception unused3) {
        }
        String I = m.I(str2, '/', '_');
        String lowerCase = I.toLowerCase(Locale.ROOT);
        b.d(lowerCase, "toLowerCase(...)");
        if (!lowerCase.endsWith(".zip")) {
            T("Please choose a .zip file");
            return;
        }
        String substring = I.substring(0, I.length() - 4);
        b.d(substring, "substring(...)");
        File file2 = new File(file, I);
        int i5 = 1;
        while (file2.exists()) {
            file2 = new File(file, substring + " (" + i5 + ").zip");
            i5++;
        }
        T("Uploading " + ((Object) I) + " ...");
        new Thread(new RunnableC0056o(this, data, file2, 6)).start();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
    
        if (r0.equals("login") == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0120, code lost:
    
        super.onBackPressed();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0123, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00fc, code lost:
    
        if (r0.equals("home") == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x011a, code lost:
    
        if (r0.equals("locked") == false) goto L84;
     */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onBackPressed() {
        LinearLayout linearLayout;
        C0035i2 c0035i2 = this.f791k;
        if (c0035i2 != null) {
            c0035i2.a();
            return;
        }
        if ((b.a(this.f784d, "files") || b.a(this.f784d, "view")) && (linearLayout = this.f798t) != null && linearLayout.getVisibility() == 0) {
            i();
            return;
        }
        String str = this.f784d;
        switch (str.hashCode()) {
            case -1097452790:
                break;
            case 3108362:
                if (str.equals("edit")) {
                    C0071s c0071s = this.f800v;
                    if (c0071s != null) {
                        c0071s.a();
                        return;
                    } else {
                        L();
                        return;
                    }
                }
                N();
                return;
            case 3208415:
                break;
            case 3556460:
                if (str.equals("term")) {
                    LinearLayout linearLayout2 = this.G;
                    if (linearLayout2 != null && linearLayout2.getVisibility() == 0) {
                        j();
                        return;
                    }
                    this.p = "";
                    SharedPreferences sharedPreferences = AbstractC0008c.f440c;
                    if (sharedPreferences == null) {
                        b.g("sp");
                        throw null;
                    }
                    sharedPreferences.edit().remove("lastTerm").apply();
                    N();
                    return;
                }
                N();
                return;
            case 3619493:
                if (str.equals("view")) {
                    L();
                    return;
                }
                N();
                return;
            case 97434231:
                if (str.equals("files")) {
                    File file = this.f794n;
                    if (file != null) {
                        String canonicalPath = file.getCanonicalPath();
                        File file2 = this.f795o;
                        if (file2 == null) {
                            b.g("homeDir");
                            throw null;
                        }
                        if (!b.a(canonicalPath, file2.getCanonicalPath())) {
                            this.f794n = file.getParentFile();
                            L();
                            return;
                        }
                    }
                    N();
                    return;
                }
                N();
                return;
            case 98629247:
                if (str.equals("group")) {
                    C0006b1 c0006b1 = this.f793m;
                    if (c0006b1 != null) {
                        LinearLayout linearLayout3 = c0006b1.g0;
                        if (linearLayout3 == null) {
                            b.g("panel");
                            throw null;
                        }
                        if (linearLayout3.getVisibility() == 0) {
                            LinearLayout linearLayout4 = c0006b1.g0;
                            if (linearLayout4 != null) {
                                linearLayout4.setVisibility(8);
                                return;
                            } else {
                                b.g("panel");
                                throw null;
                            }
                        }
                        if (!b.a(c0006b1.U0, "idle")) {
                            c0006b1.q();
                            return;
                        }
                    }
                    N();
                    return;
                }
                N();
                return;
            case 103149417:
                break;
            default:
                N();
                return;
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        SharedPreferences sharedPreferences;
        super.onCreate(bundle);
        p();
        AbstractC0008c.f440c = getSharedPreferences("nixhost", 0);
        C0004b.h(this);
        L2 l2 = L2.f198a;
        L2.f200c = getApplicationContext();
        SharedPreferences sharedPreferences2 = AbstractC0008c.f440c;
        if (sharedPreferences2 == null) {
            b.g("sp");
            throw null;
        }
        String string = sharedPreferences2.getString("dark", "1");
        if (string == null) {
            string = "1";
        }
        AbstractC0008c.f442e = string.equals("1");
        String str = "";
        if (AbstractC0008c.f439b.length() <= 0) {
            try {
                String str2 = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
                if (str2 == null) {
                    str2 = "";
                }
                AbstractC0008c.f439b = str2;
            } catch (Exception unused) {
            }
        }
        File filesDir = getFilesDir();
        try {
            if (new File(filesDir, "c_me.json").exists()) {
                AbstractC0008c.f438a = new JSONObject(g.m.I(new File(filesDir, "c_me.json")));
            }
        } catch (Exception unused2) {
        }
        if (Build.VERSION.SDK_INT >= 33 && checkSelfPermission("android.permission.POST_NOTIFICATIONS") != 0) {
            requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 1);
        }
        SharedPreferences sharedPreferences3 = AbstractC0008c.f440c;
        if (sharedPreferences3 == null) {
            b.g("sp");
            throw null;
        }
        String string2 = sharedPreferences3.getString("user", "");
        if (string2 == null) {
            string2 = "";
        }
        this.f785e = string2;
        if (string2.length() > 0) {
            SharedPreferences sharedPreferences4 = AbstractC0008c.f440c;
            if (sharedPreferences4 == null) {
                b.g("sp");
                throw null;
            }
            String string3 = sharedPreferences4.getString("session", "");
            if (string3 == null) {
                string3 = "";
            }
            if (string3.length() > 0 && AbstractC0008c.i(this.f785e) != null) {
                i.g gVar = B2.f46a;
                this.f795o = B2.b(this, this.f785e);
                N();
                try {
                    sharedPreferences = AbstractC0008c.f440c;
                } catch (Exception unused3) {
                }
                if (sharedPreferences == null) {
                    b.g("sp");
                    throw null;
                }
                String string4 = sharedPreferences.getString("lastTerm", "");
                if (string4 != null) {
                    str = string4;
                }
                int P = e.P(str, '\n', 0, false, 6);
                JSONObject i2 = AbstractC0008c.i(this.f785e);
                if (P > 0 && i2 != null && !AbstractC0008c.q(i2)) {
                    String substring = str.substring(0, P);
                    b.d(substring, "substring(...)");
                    String substring2 = str.substring(P + 1);
                    b.d(substring2, "substring(...)");
                    JSONArray optJSONArray = i2.optJSONArray("instances");
                    boolean z = optJSONArray == null;
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                            if (optJSONObject != null && b.a(optJSONObject.optString("id"), substring)) {
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        y(substring, substring2);
                    }
                }
                Intent intent = getIntent();
                if (intent != null && intent.getBooleanExtra("openChat", false)) {
                    M();
                }
                this.f786f = System.currentTimeMillis();
                new Thread(new M1(this, 3)).start();
                return;
            }
        }
        P();
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null || !intent.getBooleanExtra("openChat", false) || this.f785e.length() <= 0 || b.a(this.f784d, "login") || b.a(this.f784d, "group")) {
            return;
        }
        M();
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        C0006b1 c0006b1 = this.f793m;
        if (c0006b1 != null) {
            c0006b1.B0();
            c0006b1.G = false;
            AbstractC0008c.f441d = false;
            c0006b1.g1();
            c0006b1.f418e.removeCallbacks(c0006b1.F0);
            c0006b1.X0();
        }
        this.f783c.removeCallbacks(this.J);
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        C0006b1 c0006b1;
        C0006b1 c0006b12;
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 3 && (c0006b12 = this.f793m) != null) {
            boolean z = ((iArr.length == 0) ^ true) && iArr[0] == 0;
            if (c0006b12.e1) {
                c0006b12.e1 = false;
                if (z) {
                    c0006b12.W0(false);
                } else {
                    c0006b12.f416c.a("Microphone permission is needed for voice messages");
                }
            }
        }
        if (i2 != 4 || (c0006b1 = this.f793m) == null) {
            return;
        }
        boolean z2 = ((iArr.length == 0) ^ true) && iArr[0] == 0;
        if (c0006b1.S0) {
            c0006b1.S0 = false;
            if (z2) {
                c0006b1.f0();
                return;
            }
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("*/*");
            intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            intent.addCategory("android.intent.category.OPENABLE");
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            try {
                c0006b1.f414a.startActivityForResult(intent, 78);
            } catch (Exception unused) {
                c0006b1.f416c.a("No gallery app found");
            }
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        C0006b1 c0006b1;
        super.onResume();
        p();
        if (b.a(this.f784d, "group") && (c0006b1 = this.f793m) != null && !c0006b1.G) {
            c0006b1.G = true;
            AbstractC0008c.f441d = true;
            C0018e1.f459a.b(c0006b1.f414a.getApplicationContext());
            c0006b1.y0();
            c0006b1.f418e.post(c0006b1.F0);
        }
        this.f783c.post(this.J);
        if (this.f790j > 0 && System.currentTimeMillis() - this.f790j > 120000) {
            this.f789i = false;
            this.f786f = 0L;
        }
        this.f790j = 0L;
        this.f783c.postDelayed(new M1(this, 4), 700L);
        if (this.f785e.length() > 0 && b.a(this.f784d, "home")) {
            Object systemService = getSystemService("power");
            b.c(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            if (((PowerManager) systemService).isIgnoringBatteryOptimizations(getPackageName())) {
                SharedPreferences sharedPreferences = AbstractC0008c.f440c;
                if (sharedPreferences == null) {
                    b.g("sp");
                    throw null;
                }
                sharedPreferences.edit().putString("battery", "1").apply();
            } else {
                SharedPreferences sharedPreferences2 = AbstractC0008c.f440c;
                if (sharedPreferences2 == null) {
                    b.g("sp");
                    throw null;
                }
                String string = sharedPreferences2.getString("battery", "");
                if (string == null) {
                    string = "";
                }
                if (string.equals("1")) {
                    SharedPreferences sharedPreferences3 = AbstractC0008c.f440c;
                    if (sharedPreferences3 == null) {
                        b.g("sp");
                        throw null;
                    }
                    sharedPreferences3.edit().putString("battery", "").apply();
                    this.f783c.postDelayed(new M1(this, 5), 900L);
                }
            }
        }
        if (this.f785e.length() <= 0 || this.f795o == null) {
            return;
        }
        i.g gVar = B2.f46a;
        File b2 = B2.b(this, this.f785e);
        String path = b2.getPath();
        File file = this.f795o;
        if (file == null) {
            b.g("homeDir");
            throw null;
        }
        if (b.a(path, file.getPath())) {
            if (!b.a(this.f784d, "home") || this.f792l == B2.c(this)) {
                return;
            }
            N();
            return;
        }
        this.f795o = b2;
        this.f794n = null;
        if (b.a(this.f784d, "home")) {
            N();
        }
    }

    @Override // android.app.Activity
    public final void onStop() {
        super.onStop();
        this.f790j = System.currentTimeMillis();
    }

    public final Typeface q() {
        return (Typeface) this.M.a();
    }

    public final LinearLayout r() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        return linearLayout;
    }

    public final void s() {
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            return;
        }
        Object systemService = getSystemService("input_method");
        b.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    public final G1 t(String str, int i2, int i3, float f2) {
        G1 g1 = new G1(this, str, i2, f2);
        g1.setMinimumWidth(n(i3));
        g1.setMinimumHeight(n(i3));
        return g1;
    }

    public final void u() {
        C0006b1 c0006b1 = this.f793m;
        if (c0006b1 != null) {
            c0006b1.t();
        }
        this.f793m = null;
        if (this.f785e.length() > 0) {
            String a2 = J0.a("chatcache_", this.f785e);
            SharedPreferences sharedPreferences = AbstractC0008c.f440c;
            if (sharedPreferences == null) {
                b.g("sp");
                throw null;
            }
            sharedPreferences.edit().remove(a2).apply();
        }
        L2.f198a.e();
        SharedPreferences sharedPreferences2 = AbstractC0008c.f440c;
        if (sharedPreferences2 == null) {
            b.g("sp");
            throw null;
        }
        sharedPreferences2.edit().remove("lastTerm").apply();
        AbstractC0008c.t("user", "");
        AbstractC0008c.t("session", "");
        File filesDir = getFilesDir();
        AbstractC0008c.f438a = null;
        try {
            new File(filesDir, "c_me.json").delete();
        } catch (Exception unused) {
        }
        this.f785e = "";
        this.p = "";
        P();
    }

    public final void w() {
        String str;
        String optString;
        if (this.f789i || !b.a(this.f784d, "home")) {
            return;
        }
        String str2 = this.f785e;
        JSONObject jSONObject = AbstractC0008c.f438a;
        if (jSONObject == null || (!b.a(jSONObject.optString("username"), str2) && jSONObject.optBoolean("known", true))) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        Long valueOf = jSONObject.optLong("expires_at", 0L) <= 0 ? null : Long.valueOf((long) Math.ceil((r0 - System.currentTimeMillis()) / 8.64E7d));
        if (valueOf != null) {
            final long longValue = valueOf.longValue();
            if (longValue > 3) {
                return;
            }
            this.f789i = true;
            JSONObject jSONObject2 = AbstractC0008c.f438a;
            JSONObject optJSONObject = jSONObject2 != null ? jSONObject2.optJSONObject("contact") : null;
            if (optJSONObject == null || (str = optJSONObject.optString("message", "")) == null) {
                str = "";
            }
            if (str.length() == 0) {
                str = "Your hosting is expiring soon! Please renew.";
            }
            final String str3 = str;
            final String str4 = (optJSONObject == null || (optString = optJSONObject.optString("whatsapp", "")) == null) ? "" : optString;
            g(this, 1727623958, false, new h.c() { // from class: a.I1
                @Override // h.c
                public final Object a(Object obj, Object obj2) {
                    String str5;
                    LinearLayout linearLayout = (LinearLayout) obj;
                    Dialog dialog = (Dialog) obj2;
                    int i2 = MainActivity.R;
                    MainActivity mainActivity = MainActivity.this;
                    FrameLayout frameLayout = new FrameLayout(mainActivity);
                    FrameLayout frameLayout2 = new FrameLayout(mainActivity);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(1);
                    gradientDrawable.setColor(871985942);
                    frameLayout2.setBackground(gradientDrawable);
                    frameLayout2.addView(mainActivity.t("warn", -429290, 32, 2.0f), new FrameLayout.LayoutParams(mainActivity.n(32), mainActivity.n(32), 17));
                    frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(mainActivity.n(64), mainActivity.n(64), 1));
                    View t2 = mainActivity.t("close", AbstractC0008c.f442e ? -8618878 : -9735552, 22, 2.0f);
                    MainActivity.D(t2, new C0060p(dialog, 9));
                    frameLayout.addView(t2, new FrameLayout.LayoutParams(mainActivity.n(26), mainActivity.n(26), 8388661));
                    linearLayout.addView(frameLayout, MainActivity.v(mainActivity, mainActivity.f781a, mainActivity.f782b, 0, 0, 0, 60));
                    TextView U = mainActivity.U("Hosting Expiring Soon!", 24.0f, -429290, true);
                    U.setGravity(17);
                    linearLayout.addView(U, MainActivity.v(mainActivity, mainActivity.f781a, mainActivity.f782b, 14, 0, 0, 56));
                    long j2 = longValue;
                    if (j2 <= 0) {
                        str5 = "Expires today";
                    } else if (j2 == 1) {
                        str5 = "1 day remaining";
                    } else {
                        str5 = j2 + " days remaining";
                    }
                    TextView U2 = mainActivity.U(str5, 32.0f, AbstractC0008c.f442e ? -1 : -15656921, true);
                    U2.setGravity(17);
                    linearLayout.addView(U2, MainActivity.v(mainActivity, mainActivity.f781a, mainActivity.f782b, 12, 0, 0, 56));
                    TextView U3 = mainActivity.U(str3, 17.0f, AbstractC0008c.f442e ? -8618878 : -9735552, false);
                    U3.setGravity(17);
                    linearLayout.addView(U3, MainActivity.v(mainActivity, mainActivity.f781a, mainActivity.f782b, 12, 0, 0, 56));
                    String str6 = str4;
                    if (str6.length() > 0) {
                        linearLayout.addView(mainActivity.W("Contact", new X1(0, mainActivity, str6)), MainActivity.v(mainActivity, mainActivity.f781a, mainActivity.n(56), 20, 0, 0, 56));
                    }
                    return b.d.f770c;
                }
            }, 2);
        }
    }

    public final boolean x() {
        try {
            Object systemService = getSystemService("connectivity");
            b.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Network activeNetwork = connectivityManager.getActiveNetwork();
            NetworkCapabilities networkCapabilities = activeNetwork != null ? connectivityManager.getNetworkCapabilities(activeNetwork) : null;
            if (networkCapabilities != null && networkCapabilities.hasCapability(12)) {
                if (networkCapabilities.hasCapability(16)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public final void y(String str, String str2) {
        if (!X()) {
            SharedPreferences sharedPreferences = AbstractC0008c.f440c;
            if (sharedPreferences == null) {
                b.g("sp");
                throw null;
            }
            sharedPreferences.edit().remove("lastTerm").apply();
            T("Connect to WiFi to open the terminal");
            return;
        }
        this.P = 0L;
        this.f784d = "term";
        this.p = this.f785e + "-" + str;
        this.q = str2;
        String str3 = str + "\n" + str2;
        SharedPreferences sharedPreferences2 = AbstractC0008c.f440c;
        if (sharedPreferences2 == null) {
            b.g("sp");
            throw null;
        }
        sharedPreferences2.edit().putString("lastTerm", str3).apply();
        this.f796r = 0;
        this.I = false;
        this.y = false;
        this.w = 0;
        this.x = false;
        L2 l2 = L2.f198a;
        String str4 = this.p;
        File file = this.f795o;
        if (file == null) {
            b.g("homeDir");
            throw null;
        }
        final K2 d2 = l2.d(file, new File(getFilesDir(), "home"), str4);
        LinearLayout V = V();
        V.setBackgroundColor(-16777216);
        LinearLayout r2 = r();
        r2.setBackgroundColor(-15789543);
        r2.setPadding(n(14), n(14), n(16), n(14));
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView(t("back", -1, 26, 2.4f), new FrameLayout.LayoutParams(n(26), n(26), 17));
        D(frameLayout, new K1(this, 13));
        r2.addView(frameLayout, v(this, n(40), n(40), 0, 0, 0, 60));
        r2.addView(t("logo", -43230, 28, 2.0f), v(this, n(28), n(28), 0, 4, 0, 48));
        TextView U = U(str2, 26.0f, -1, true);
        U.setSingleLine(true);
        U.setEllipsize(TextUtils.TruncateAt.END);
        int i2 = this.f782b;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, i2, 1.0f);
        layoutParams.leftMargin = n(10);
        r2.addView(U, layoutParams);
        LinearLayout r3 = r();
        r3.setGravity(17);
        r3.setBackground(I(-8446691, 14, 0, 0));
        r3.setPadding(n(16), n(11), n(18), n(11));
        r3.addView(t("stop", -1, 22, 2.0f), v(this, n(22), n(22), 0, 0, 8, 32));
        View U2 = U("Stop", 17.0f, -1, true);
        int i3 = this.f782b;
        r3.addView(U2, v(this, i3, i3, 0, 0, 0, 60));
        final int i4 = 4;
        D(r3, new a() { // from class: a.k2
            @Override // h.a
            public final Object a() {
                switch (i4) {
                    case 0:
                        K2 k2 = d2;
                        MainActivity mainActivity = this;
                        int i5 = MainActivity.R;
                        k2.a((k2.f175i ? "" : "$ ").concat("Ctrl+D\n"));
                        Process process = k2.f177k;
                        if (process != null) {
                            try {
                                process.getOutputStream().close();
                            } catch (Exception unused) {
                            }
                        }
                        mainActivity.C();
                        break;
                    case 1:
                        int i6 = MainActivity.R;
                        d2.a("\f");
                        this.C();
                        break;
                    case 2:
                        int i7 = MainActivity.R;
                        d2.r("ls");
                        this.C();
                        break;
                    case 3:
                        int i8 = MainActivity.R;
                        d2.r("pwd");
                        this.C();
                        break;
                    case 4:
                        int i9 = MainActivity.R;
                        K2 k22 = d2;
                        k22.a((k22.f175i ? "" : "$ ").concat("Ctrl+C\n"));
                        k22.h();
                        this.C();
                        break;
                    default:
                        int i10 = MainActivity.R;
                        K2 k23 = d2;
                        k23.a((k23.f175i ? "" : "$ ").concat("Ctrl+C\n"));
                        k23.h();
                        this.C();
                        break;
                }
                return b.d.f770c;
            }
        });
        int i5 = this.f782b;
        r2.addView(r3, v(this, i5, i5, 0, 8, 0, 48));
        FrameLayout frameLayout2 = new FrameLayout(this);
        frameLayout2.setBackground(I(-14736336, 14, 0, 0));
        frameLayout2.addView(t("down", -1, 22, 2.2f), new FrameLayout.LayoutParams(n(22), n(22), 17));
        r2.addView(frameLayout2, v(this, n(46), n(46), 0, 10, 0, 48));
        V.addView(r2, v(this, this.f781a, this.f782b, 0, 0, 0, 60));
        View view = new View(this);
        view.setBackgroundColor(-14473421);
        V.addView(view, v(this, this.f781a, 1, 0, 0, 0, 60));
        FrameLayout frameLayout3 = new FrameLayout(this);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);
        scrollView.setBackgroundColor(-16777216);
        LinearLayout V2 = V();
        V2.setPadding(n(20), n(18), n(20), n(14));
        int i6 = this.f781a;
        scrollView.addView(V2, new FrameLayout.LayoutParams(i6, i2));
        TextView textView = new TextView(this);
        textView.setTypeface(q());
        textView.setTextSize(1, this.K * 16.0f);
        textView.setTextColor(-1710101);
        textView.setLineSpacing(0.0f, 1.15f);
        textView.setTextIsSelectable(true);
        textView.setText("", TextView.BufferType.EDITABLE);
        textView.setLinkTextColor(-429290);
        textView.setVisibility(8);
        V2.addView(textView, v(this, this.f781a, this.f782b, 0, 0, 0, 60));
        LinearLayout r4 = r();
        ProgressBar progressBar = new ProgressBar(this);
        progressBar.setIndeterminate(true);
        progressBar.setIndeterminateTintList(ColorStateList.valueOf(-429290));
        r4.addView(progressBar, v(this, n(22), n(22), 0, 0, 12, 32));
        TextView U3 = U("", 15.0f, -1710101, false);
        U3.setTypeface(q());
        int i7 = this.f782b;
        r4.addView(U3, v(this, i7, i7, 0, 0, 0, 60));
        r4.setVisibility(8);
        V2.addView(r4, v(this, this.f781a, this.f782b, 6, 0, 0, 56));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        TextView U4 = U("$ ", 16.0f, -1710101, false);
        U4.setTypeface(q());
        U4.setLineSpacing(0.0f, 1.15f);
        int i8 = this.f782b;
        linearLayout.addView(U4, v(this, i8, i8, 0, 0, 0, 60));
        final EditText editText = new EditText(this);
        editText.setBackground(null);
        editText.setPadding(0, 0, 0, 0);
        editText.setTypeface(q());
        editText.setTextSize(1, this.K * 16.0f);
        editText.setTextColor(-1710101);
        editText.setSingleLine(true);
        editText.setInputType(524433);
        editText.setImeOptions(268435462);
        if (Build.VERSION.SDK_INT >= 29) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-429290);
            gradientDrawable.setSize(n(10), n(22));
            editText.setTextCursorDrawable(gradientDrawable);
        }
        String a2 = J0.a("draft_", this.p);
        SharedPreferences sharedPreferences3 = AbstractC0008c.f440c;
        if (sharedPreferences3 == null) {
            b.g("sp");
            throw null;
        }
        String string = sharedPreferences3.getString(a2, "");
        if (string == null) {
            string = "";
        }
        if (string.length() > 0) {
            editText.setText(string);
            editText.setSelection(editText.getText().length());
        }
        editText.addTextChangedListener(new R0(2, a2));
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: a.l2
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView2, int i9, KeyEvent keyEvent) {
                int i10 = MainActivity.R;
                EditText editText2 = editText;
                String obj = editText2.getText().toString();
                editText2.setText("");
                d2.r(obj);
                this.C();
                return true;
            }
        });
        linearLayout.addView(editText, new LinearLayout.LayoutParams(0, i2, 1.0f));
        V2.addView(linearLayout, v(this, this.f781a, this.f782b, 0, 0, 0, 60));
        final int i9 = 0;
        V2.setOnClickListener(new View.OnClickListener() { // from class: a.m2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i9) {
                    case 0:
                        MainActivity.A(editText, this);
                        break;
                    default:
                        MainActivity.A(editText, this);
                        break;
                }
            }
        });
        final int i10 = 1;
        scrollView.setOnClickListener(new View.OnClickListener() { // from class: a.m2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i10) {
                    case 0:
                        MainActivity.A(editText, this);
                        break;
                    default:
                        MainActivity.A(editText, this);
                        break;
                }
            }
        });
        scrollView.addOnLayoutChangeListener(new E(i10, scrollView));
        frameLayout3.addView(scrollView, new FrameLayout.LayoutParams(i6, i6));
        View view2 = new View(this);
        view2.setVisibility(8);
        view2.setOnClickListener(new ViewOnClickListenerC0019e2(this, 2));
        frameLayout3.addView(view2, new FrameLayout.LayoutParams(i6, i6));
        LinearLayout V3 = V();
        V3.setVisibility(8);
        V3.setBackground(I(-15328476, 16, -14012614, 1));
        V3.setPadding(n(6), n(6), n(6), n(6));
        V3.setElevation(n(10));
        z(this, V3, "Tab", new D(editText, d2, this, 5));
        final int i11 = 5;
        z(this, V3, "Ctrl+C", new a() { // from class: a.k2
            @Override // h.a
            public final Object a() {
                switch (i11) {
                    case 0:
                        K2 k2 = d2;
                        MainActivity mainActivity = this;
                        int i52 = MainActivity.R;
                        k2.a((k2.f175i ? "" : "$ ").concat("Ctrl+D\n"));
                        Process process = k2.f177k;
                        if (process != null) {
                            try {
                                process.getOutputStream().close();
                            } catch (Exception unused) {
                            }
                        }
                        mainActivity.C();
                        break;
                    case 1:
                        int i62 = MainActivity.R;
                        d2.a("\f");
                        this.C();
                        break;
                    case 2:
                        int i72 = MainActivity.R;
                        d2.r("ls");
                        this.C();
                        break;
                    case 3:
                        int i82 = MainActivity.R;
                        d2.r("pwd");
                        this.C();
                        break;
                    case 4:
                        int i92 = MainActivity.R;
                        K2 k22 = d2;
                        k22.a((k22.f175i ? "" : "$ ").concat("Ctrl+C\n"));
                        k22.h();
                        this.C();
                        break;
                    default:
                        int i102 = MainActivity.R;
                        K2 k23 = d2;
                        k23.a((k23.f175i ? "" : "$ ").concat("Ctrl+C\n"));
                        k23.h();
                        this.C();
                        break;
                }
                return b.d.f770c;
            }
        });
        final int i12 = 0;
        z(this, V3, "Ctrl+D", new a() { // from class: a.k2
            @Override // h.a
            public final Object a() {
                switch (i12) {
                    case 0:
                        K2 k2 = d2;
                        MainActivity mainActivity = this;
                        int i52 = MainActivity.R;
                        k2.a((k2.f175i ? "" : "$ ").concat("Ctrl+D\n"));
                        Process process = k2.f177k;
                        if (process != null) {
                            try {
                                process.getOutputStream().close();
                            } catch (Exception unused) {
                            }
                        }
                        mainActivity.C();
                        break;
                    case 1:
                        int i62 = MainActivity.R;
                        d2.a("\f");
                        this.C();
                        break;
                    case 2:
                        int i72 = MainActivity.R;
                        d2.r("ls");
                        this.C();
                        break;
                    case 3:
                        int i82 = MainActivity.R;
                        d2.r("pwd");
                        this.C();
                        break;
                    case 4:
                        int i92 = MainActivity.R;
                        K2 k22 = d2;
                        k22.a((k22.f175i ? "" : "$ ").concat("Ctrl+C\n"));
                        k22.h();
                        this.C();
                        break;
                    default:
                        int i102 = MainActivity.R;
                        K2 k23 = d2;
                        k23.a((k23.f175i ? "" : "$ ").concat("Ctrl+C\n"));
                        k23.h();
                        this.C();
                        break;
                }
                return b.d.f770c;
            }
        });
        final int i13 = 1;
        z(this, V3, "Clear", new a() { // from class: a.k2
            @Override // h.a
            public final Object a() {
                switch (i13) {
                    case 0:
                        K2 k2 = d2;
                        MainActivity mainActivity = this;
                        int i52 = MainActivity.R;
                        k2.a((k2.f175i ? "" : "$ ").concat("Ctrl+D\n"));
                        Process process = k2.f177k;
                        if (process != null) {
                            try {
                                process.getOutputStream().close();
                            } catch (Exception unused) {
                            }
                        }
                        mainActivity.C();
                        break;
                    case 1:
                        int i62 = MainActivity.R;
                        d2.a("\f");
                        this.C();
                        break;
                    case 2:
                        int i72 = MainActivity.R;
                        d2.r("ls");
                        this.C();
                        break;
                    case 3:
                        int i82 = MainActivity.R;
                        d2.r("pwd");
                        this.C();
                        break;
                    case 4:
                        int i92 = MainActivity.R;
                        K2 k22 = d2;
                        k22.a((k22.f175i ? "" : "$ ").concat("Ctrl+C\n"));
                        k22.h();
                        this.C();
                        break;
                    default:
                        int i102 = MainActivity.R;
                        K2 k23 = d2;
                        k23.a((k23.f175i ? "" : "$ ").concat("Ctrl+C\n"));
                        k23.h();
                        this.C();
                        break;
                }
                return b.d.f770c;
            }
        });
        z(this, V3, "Copy all", new C0090y0(textView, this, 3));
        final int i14 = 2;
        z(this, V3, "ls", new a() { // from class: a.k2
            @Override // h.a
            public final Object a() {
                switch (i14) {
                    case 0:
                        K2 k2 = d2;
                        MainActivity mainActivity = this;
                        int i52 = MainActivity.R;
                        k2.a((k2.f175i ? "" : "$ ").concat("Ctrl+D\n"));
                        Process process = k2.f177k;
                        if (process != null) {
                            try {
                                process.getOutputStream().close();
                            } catch (Exception unused) {
                            }
                        }
                        mainActivity.C();
                        break;
                    case 1:
                        int i62 = MainActivity.R;
                        d2.a("\f");
                        this.C();
                        break;
                    case 2:
                        int i72 = MainActivity.R;
                        d2.r("ls");
                        this.C();
                        break;
                    case 3:
                        int i82 = MainActivity.R;
                        d2.r("pwd");
                        this.C();
                        break;
                    case 4:
                        int i92 = MainActivity.R;
                        K2 k22 = d2;
                        k22.a((k22.f175i ? "" : "$ ").concat("Ctrl+C\n"));
                        k22.h();
                        this.C();
                        break;
                    default:
                        int i102 = MainActivity.R;
                        K2 k23 = d2;
                        k23.a((k23.f175i ? "" : "$ ").concat("Ctrl+C\n"));
                        k23.h();
                        this.C();
                        break;
                }
                return b.d.f770c;
            }
        });
        final int i15 = 3;
        z(this, V3, "pwd", new a() { // from class: a.k2
            @Override // h.a
            public final Object a() {
                switch (i15) {
                    case 0:
                        K2 k2 = d2;
                        MainActivity mainActivity = this;
                        int i52 = MainActivity.R;
                        k2.a((k2.f175i ? "" : "$ ").concat("Ctrl+D\n"));
                        Process process = k2.f177k;
                        if (process != null) {
                            try {
                                process.getOutputStream().close();
                            } catch (Exception unused) {
                            }
                        }
                        mainActivity.C();
                        break;
                    case 1:
                        int i62 = MainActivity.R;
                        d2.a("\f");
                        this.C();
                        break;
                    case 2:
                        int i72 = MainActivity.R;
                        d2.r("ls");
                        this.C();
                        break;
                    case 3:
                        int i82 = MainActivity.R;
                        d2.r("pwd");
                        this.C();
                        break;
                    case 4:
                        int i92 = MainActivity.R;
                        K2 k22 = d2;
                        k22.a((k22.f175i ? "" : "$ ").concat("Ctrl+C\n"));
                        k22.h();
                        this.C();
                        break;
                    default:
                        int i102 = MainActivity.R;
                        K2 k23 = d2;
                        k23.a((k23.f175i ? "" : "$ ").concat("Ctrl+C\n"));
                        k23.h();
                        this.C();
                        break;
                }
                return b.d.f770c;
            }
        });
        z(this, V3, "cd", new C0090y0(editText, this, 4));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(n(200), i2, 8388661);
        layoutParams2.setMargins(0, n(8), n(12), 0);
        frameLayout3.addView(V3, layoutParams2);
        D(frameLayout2, new C0027g2(V3, this, 1));
        V.addView(frameLayout3, new LinearLayout.LayoutParams(i6, 0, 1.0f));
        View view3 = new View(this);
        view3.setBackgroundColor(-14473421);
        V.addView(view3, v(this, this.f781a, 1, 0, 0, 0, 60));
        LinearLayout r5 = r();
        r5.setPadding(n(20), n(12), n(20), n(12));
        TextView U5 = U("[" + str2 + "]", 14.0f, -14714310, false);
        U5.setTypeface(q());
        TextView U6 = U("", 14.0f, -14714310, false);
        U6.setTypeface(q());
        r5.addView(U5, new LinearLayout.LayoutParams(0, i2, 1.0f));
        int i16 = this.f782b;
        r5.addView(U6, v(this, i16, i16, 0, 0, 0, 60));
        V.addView(r5, v(this, this.f781a, this.f782b, 0, 0, 0, 60));
        this.f797s = textView;
        this.z = scrollView;
        this.A = editText;
        this.B = linearLayout;
        this.C = r4;
        this.D = U3;
        this.E = U5;
        this.F = U6;
        this.G = V3;
        this.H = view2;
        H(V, -15789543, -16777216, false, false);
        C();
        F();
    }
}
