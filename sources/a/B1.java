package a;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class B1 {
    public TextView A;
    public TextView B;
    public TextView C;
    public FrameLayout D;
    public VideoView E;
    public C0091y1 F;
    public C0094z1 G;
    public boolean H;
    public int I;
    public final O0 J;

    /* renamed from: a, reason: collision with root package name */
    public final Activity f26a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f27b;

    /* renamed from: c, reason: collision with root package name */
    public final h.a f28c;

    /* renamed from: d, reason: collision with root package name */
    public final h.c f29d;

    /* renamed from: e, reason: collision with root package name */
    public final int f30e;

    /* renamed from: f, reason: collision with root package name */
    public final int f31f;

    /* renamed from: g, reason: collision with root package name */
    public final int f32g;

    /* renamed from: h, reason: collision with root package name */
    public final int f33h;

    /* renamed from: i, reason: collision with root package name */
    public final Handler f34i;

    /* renamed from: j, reason: collision with root package name */
    public final ExecutorService f35j;

    /* renamed from: k, reason: collision with root package name */
    public final A1 f36k;

    /* renamed from: l, reason: collision with root package name */
    public final HashSet f37l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f38m;

    /* renamed from: n, reason: collision with root package name */
    public List f39n;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f40o;
    public String p;
    public boolean q;

    /* renamed from: r, reason: collision with root package name */
    public Dialog f41r;

    /* renamed from: s, reason: collision with root package name */
    public FrameLayout f42s;

    /* renamed from: t, reason: collision with root package name */
    public TextView f43t;

    /* renamed from: u, reason: collision with root package name */
    public G1 f44u;

    /* renamed from: v, reason: collision with root package name */
    public GridView f45v;
    public ScrollView w;
    public LinearLayout x;
    public FrameLayout y;
    public LinearLayout z;

    public B1(Activity activity, boolean z, C0036j c0036j, C0017e0 c0017e0) {
        this.f26a = activity;
        this.f27b = z;
        this.f28c = c0036j;
        this.f29d = c0017e0;
        this.f30e = z ? -15197926 : -1;
        this.f31f = z ? -920842 : -16448251;
        this.f32g = z ? -12960964 : -1775893;
        this.f33h = z ? -12697534 : -1775893;
        this.f34i = new Handler(Looper.getMainLooper());
        this.f35j = Executors.newFixedThreadPool(3);
        this.f36k = new A1(16777216, 0);
        this.f37l = new HashSet();
        this.f38m = new ArrayList();
        this.f39n = c.j.f773a;
        this.f40o = new ArrayList();
        this.p = "all";
        this.I = -50384;
        this.J = new O0(1, this);
    }

    public static GradientDrawable h(int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i2);
        return gradientDrawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.List] */
    public final void a() {
        ?? arrayList;
        boolean a2 = i.b.a(this.p, "all");
        ArrayList arrayList2 = this.f38m;
        if (a2) {
            arrayList = c.b.Q(arrayList2);
        } else if (i.b.a(this.p, "photos")) {
            arrayList = new ArrayList();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (!((C0094z1) next).f753b) {
                    arrayList.add(next);
                }
            }
        } else if (i.b.a(this.p, "videos")) {
            arrayList = new ArrayList();
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Object next2 = it2.next();
                if (((C0094z1) next2).f753b) {
                    arrayList.add(next2);
                }
            }
        } else {
            arrayList = new ArrayList();
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                Object next3 = it3.next();
                if (i.b.a(J0.a("b:", ((C0094z1) next3).f755d), this.p)) {
                    arrayList.add(next3);
                }
            }
        }
        this.f39n = arrayList;
        this.J.notifyDataSetChanged();
        GridView gridView = this.f45v;
        if (gridView == null) {
            i.b.g("grid");
            throw null;
        }
        gridView.setSelection(0);
        TextView textView = this.C;
        if (textView != null) {
            textView.setVisibility(this.f39n.isEmpty() ? 0 : 8);
        } else {
            i.b.g("emptyTv");
            throw null;
        }
    }

    public final void b(String str, h.b bVar) {
        Window window;
        Activity activity = this.f26a;
        Dialog dialog = new Dialog(activity, R.style.Theme.Black.NoTitleBar);
        Window window2 = dialog.getWindow();
        if (window2 != null) {
            window2.setWindowAnimations(com.nix.host.R.style.ZoomAnim);
        }
        Window window3 = dialog.getWindow();
        if (window3 != null) {
            window3.setBackgroundDrawable(new ColorDrawable(-436207616));
        }
        Window window4 = dialog.getWindow();
        if (window4 != null) {
            window4.setSoftInputMode(20);
        }
        FrameLayout frameLayout = new FrameLayout(activity);
        EditText editText = new EditText(activity);
        editText.setBackground(null);
        editText.setHint("Type something");
        editText.setHintTextColor(-1996488705);
        editText.setTextColor(-1);
        editText.setTextSize(1, 28.0f);
        editText.setGravity(17);
        editText.setInputType(16385);
        editText.setImeOptions(6);
        editText.setText(str);
        editText.setSelection(editText.getText().length());
        final C0071s c0071s = new C0071s(new i.d(), editText, dialog, bVar, 3);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: a.t1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 != 6) {
                    return false;
                }
                c0071s.a();
                return true;
            }
        });
        TextView l2 = l("Done", 20.0f, -1, true);
        l2.setPadding(e(14), e(10), e(14), e(10));
        l2.setOnClickListener(new ViewOnClickListenerC0044l(c0071s, 4));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 17);
        layoutParams.setMargins(e(20), 0, e(20), 0);
        frameLayout.addView(editText, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 8388661);
        layoutParams2.setMargins(0, e(14), e(6), 0);
        frameLayout.addView(l2, layoutParams2);
        dialog.setContentView(frameLayout);
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: a.u1
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                c0071s.a();
            }
        });
        if (this.q && (window = dialog.getWindow()) != null) {
            window.addFlags(8192);
        }
        dialog.show();
    }

    public final void c(boolean z) {
        Dialog dialog = this.f41r;
        if (dialog == null) {
            i.b.g("dlg");
            throw null;
        }
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        int i2 = z ? -16777216 : this.f30e;
        window.setStatusBarColor(i2);
        window.setNavigationBarColor(i2);
        window.getDecorView().setSystemUiVisibility((this.f27b || z) ? 0 : 8192);
    }

    public final void d() {
        try {
            VideoView videoView = this.E;
            if (videoView != null) {
                videoView.stopPlayback();
            }
        } catch (Throwable unused) {
        }
        this.E = null;
        this.F = null;
        this.G = null;
        FrameLayout frameLayout = this.D;
        if (frameLayout != null) {
            FrameLayout frameLayout2 = this.f42s;
            if (frameLayout2 == null) {
                i.b.g("top");
                throw null;
            }
            frameLayout2.removeView(frameLayout);
        }
        this.D = null;
        c(false);
    }

    public final int e(int i2) {
        return (int) (i2 * this.f26a.getResources().getDisplayMetrics().density * 0.93f);
    }

    public final void f(List list, List list2) {
        Dialog dialog = this.f41r;
        if (dialog == null) {
            i.b.g("dlg");
            throw null;
        }
        dialog.dismiss();
        this.f29d.a(list, list2);
    }

    public final void g(String str, String str2, String str3) {
        Activity activity = this.f26a;
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setGravity(16);
        linearLayout.setPadding(e(16), e(8), e(16), e(8));
        FrameLayout frameLayout = new FrameLayout(activity);
        int i2 = this.f32g;
        frameLayout.setBackground(h(i2));
        int i3 = this.f31f;
        frameLayout.addView(new C0046l1(activity, str2, i3, i2), new FrameLayout.LayoutParams(e(24), e(24), 17));
        linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(e(46), e(46)));
        TextView l2 = l(str, 21.0f, i3, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = e(16);
        linearLayout.addView(l2, layoutParams);
        linearLayout.setOnClickListener(new ViewOnClickListenerC0054n1(this, str3, str, 1));
        LinearLayout linearLayout2 = this.x;
        if (linearLayout2 != null) {
            linearLayout2.addView(linearLayout, new LinearLayout.LayoutParams(-1, e(62)));
        } else {
            i.b.g("menuCol");
            throw null;
        }
    }

    public final void i(ArrayList arrayList, int[] iArr) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(iArr[i2]);
            boolean z = iArr[i2] == this.I;
            gradientDrawable.setStroke(e(z ? 3 : 2), z ? -1 : 1728053247);
            ((View) arrayList.get(i2)).setBackground(gradientDrawable);
        }
    }

    public final void j(Boolean bool) {
        boolean z;
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            ScrollView scrollView = this.w;
            if (scrollView == null) {
                i.b.g("menu");
                throw null;
            }
            z = scrollView.getVisibility() != 0;
        }
        if (z) {
            LinearLayout linearLayout = this.x;
            if (linearLayout == null) {
                i.b.g("menuCol");
                throw null;
            }
            linearLayout.removeAllViews();
            g("Gallery", "gallery", "all");
            g("Photos", "photos", "photos");
            g("Videos", "videos", "videos");
            View view = new View(this.f26a);
            view.setBackgroundColor(this.f33h);
            LinearLayout linearLayout2 = this.x;
            if (linearLayout2 == null) {
                i.b.g("menuCol");
                throw null;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
            layoutParams.setMargins(e(16), e(6), e(16), e(6));
            linearLayout2.addView(view, layoutParams);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = this.f38m.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(((C0094z1) it.next()).f755d);
            }
            Iterator it2 = linkedHashSet.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                String a2 = J0.a("b:", str);
                TextView l2 = l(str, 21.0f, this.f31f, false);
                l2.setGravity(16);
                l2.setPadding(e(16), 0, e(16), 0);
                l2.setOnClickListener(new ViewOnClickListenerC0054n1(this, a2, str, 0));
                LinearLayout linearLayout3 = this.x;
                if (linearLayout3 == null) {
                    i.b.g("menuCol");
                    throw null;
                }
                linearLayout3.addView(l2, new LinearLayout.LayoutParams(-1, e(54)));
            }
        }
        ScrollView scrollView2 = this.w;
        if (scrollView2 == null) {
            i.b.g("menu");
            throw null;
        }
        scrollView2.setVisibility(z ? 0 : 8);
        G1 g1 = this.f44u;
        if (g1 != null) {
            g1.set(z ? "up" : "down");
        } else {
            i.b.g("chev");
            throw null;
        }
    }

    public final FrameLayout k(String str) {
        Activity activity = this.f26a;
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.addView(new C0046l1(activity, str, -1, -1), new FrameLayout.LayoutParams(e(26), e(26), 17));
        return frameLayout;
    }

    public final TextView l(String str, float f2, int i2, boolean z) {
        TextView textView = new TextView(this.f26a);
        textView.setText(str);
        textView.setTextSize(1, f2);
        textView.setTextColor(i2);
        if (z) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        return textView;
    }
}
