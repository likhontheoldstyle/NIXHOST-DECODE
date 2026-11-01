package a;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* renamed from: a.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0036j implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f541a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f542b;

    public /* synthetic */ C0036j(C0006b1 c0006b1, int i2) {
        this.f541a = i2;
        this.f542b = c0006b1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v5, types: [android.view.View, android.widget.ScrollView] */
    /* JADX WARN: Type inference failed for: r19v0, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r1v58, types: [a.b1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r30v0, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r3v70, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r6v17, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    @Override // h.a
    public final Object a() {
        float f2;
        float f3;
        LinearLayout linearLayout;
        ScrollView scrollView;
        E2 e2;
        FrameLayout frameLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        int i2;
        List list;
        int i3;
        boolean z;
        int i4 = 3;
        int i5 = 0;
        C0006b1 c0006b1 = this.f542b;
        switch (this.f541a) {
            case 0:
                if (m.m.F(c0006b1.f415b, c0006b1.C1)) {
                    if (c0006b1.e0()) {
                        c0006b1.b0();
                    } else {
                        new Thread(new RunnableC0048m(c0006b1, 1)).start();
                    }
                }
                return b.d.f770c;
            case 1:
                C0006b1 c0006b12 = this.f542b;
                b.b H = c0006b12.H();
                Dialog dialog = (Dialog) H.f764a;
                LinearLayout linearLayout4 = (LinearLayout) H.f765b;
                c0006b12.C = dialog;
                linearLayout4.addView(c0006b12.j0(dialog, null), C0006b1.X(c0006b12, -1, -2, 0, 0, 0, 60));
                ScrollView scrollView2 = new ScrollView(c0006b12.f414a);
                scrollView2.setVerticalScrollBarEnabled(false);
                LinearLayout k1 = c0006b12.k1();
                scrollView2.addView(k1, new FrameLayout.LayoutParams(-1, -2));
                linearLayout4.addView(scrollView2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                C0006b1.g0(c0006b12, k1);
                c0006b12.y1 = new C0029h0(k1, c0006b12);
                dialog.setOnDismissListener(new DialogInterfaceOnDismissListenerC0033i0(0, c0006b12));
                c0006b12.T0(dialog);
                c0006b12.U();
                return b.d.f770c;
            case 2:
                c0006b1.L0(null);
                return b.d.f770c;
            case 3:
                EditText editText = c0006b1.h0;
                if (editText == null) {
                    i.b.g("input");
                    throw null;
                }
                editText.requestFocus();
                EditText editText2 = c0006b1.h0;
                if (editText2 == null) {
                    i.b.g("input");
                    throw null;
                }
                editText2.dispatchKeyEvent(new KeyEvent(0, 67));
                EditText editText3 = c0006b1.h0;
                if (editText3 == null) {
                    i.b.g("input");
                    throw null;
                }
                editText3.dispatchKeyEvent(new KeyEvent(1, 67));
                LinearLayout linearLayout5 = c0006b1.g0;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(0);
                    return b.d.f770c;
                }
                i.b.g("panel");
                throw null;
            case 4:
                h.b bVar = c0006b1.f416c;
                Activity activity = c0006b1.f414a;
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("_display_name", "NixChat_" + System.currentTimeMillis() + ".jpg");
                    contentValues.put("mime_type", "image/jpeg");
                    Uri insert = activity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    if (insert == null) {
                        bVar.a("Camera is not available");
                    } else {
                        c0006b1.T0 = insert;
                        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                        intent.putExtra("output", insert);
                        intent.addFlags(3);
                        activity.startActivityForResult(intent, 79);
                    }
                } catch (Exception unused) {
                    bVar.a("No camera app found");
                }
                return b.d.f770c;
            case 5:
                File file = c0006b1.W0;
                if (file != null) {
                    c0006b1.e1(-2L, file);
                }
                return b.d.f770c;
            case 6:
                c0006b1.q();
                return b.d.f770c;
            case 7:
                c0006b1.z1 = false;
                c0006b1.l0();
                return b.d.f770c;
            case 8:
                c0006b1.W0(false);
                return b.d.f770c;
            case 9:
                LinearLayout linearLayout6 = c0006b1.g0;
                if (linearLayout6 == null) {
                    i.b.g("panel");
                    throw null;
                }
                int visibility = linearLayout6.getVisibility();
                Activity activity2 = c0006b1.f414a;
                if (visibility == 0) {
                    LinearLayout linearLayout7 = c0006b1.g0;
                    if (linearLayout7 == null) {
                        i.b.g("panel");
                        throw null;
                    }
                    linearLayout7.setVisibility(8);
                    EditText editText4 = c0006b1.h0;
                    if (editText4 == null) {
                        i.b.g("input");
                        throw null;
                    }
                    editText4.requestFocus();
                    Object systemService = activity2.getSystemService("input_method");
                    i.b.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                    InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                    EditText editText5 = c0006b1.h0;
                    if (editText5 == null) {
                        i.b.g("input");
                        throw null;
                    }
                    inputMethodManager.showSoftInput(editText5, 0);
                } else {
                    Object systemService2 = activity2.getSystemService("input_method");
                    i.b.c(systemService2, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                    InputMethodManager inputMethodManager2 = (InputMethodManager) systemService2;
                    EditText editText6 = c0006b1.h0;
                    if (editText6 == null) {
                        i.b.g("input");
                        throw null;
                    }
                    inputMethodManager2.hideSoftInputFromWindow(editText6.getWindowToken(), 0);
                    c0006b1.f418e.postDelayed(new RunnableC0048m(c0006b1, 10), 120L);
                }
                return b.d.f770c;
            case 10:
                EditText editText7 = c0006b1.h0;
                if (editText7 == null) {
                    i.b.g("input");
                    throw null;
                }
                String obj = m.e.h0(editText7.getText().toString()).toString();
                if (obj.length() == 0) {
                    String p0 = C0006b1.p0();
                    if (p0.length() == 0) {
                        C0006b1.m0(c0006b1, "like", null, null, 62);
                    } else {
                        C0006b1.m0(c0006b1, "text", p0, null, 60);
                    }
                } else {
                    EditText editText8 = c0006b1.h0;
                    if (editText8 == null) {
                        i.b.g("input");
                        throw null;
                    }
                    editText8.setText("");
                    C0006b1.m0(c0006b1, "text", obj, new C0090y0(c0006b1, obj, 0), 28);
                }
                return b.d.f770c;
            case 11:
                c0006b1.f416c.a("Stickers are coming soon");
                return b.d.f770c;
            case 12:
                c0006b1.f416c.a("GIF is coming soon");
                return b.d.f770c;
            case 13:
                float f4 = c0006b1.l1;
                if (f4 >= 2.0f) {
                    f2 = 1.0f;
                } else {
                    f2 = 1.5f;
                    if (f4 >= 1.5f) {
                        f2 = 2.0f;
                    }
                }
                c0006b1.l1 = f2;
                String V0 = C0006b1.V0(f2);
                Iterator it = c0006b1.n1.values().iterator();
                while (it.hasNext()) {
                    ((TextView) it.next()).setText(V0);
                }
                MediaPlayer mediaPlayer = c0006b1.g1;
                if (mediaPlayer != null) {
                    try {
                        if (mediaPlayer.isPlaying()) {
                            c0006b1.f(mediaPlayer, c0006b1.h1);
                        }
                    } catch (Exception unused2) {
                    }
                }
                return b.d.f770c;
            case 14:
                c0006b1.getClass();
                c0006b1.l(false, new C0017e0(c0006b1, 1));
                return b.d.f770c;
            case 15:
                long Z = c0006b1.Z();
                long currentTimeMillis = (c0006b1.B1 + Z) - System.currentTimeMillis();
                if (Z <= 0 || currentTimeMillis <= 0) {
                    c0006b1.l(true, new Y(c0006b1, c0006b1.x(c0006b1.f415b), 1));
                } else {
                    c0006b1.f416c.a(J0.a("You can change your name once a week. Try again in ", C0006b1.w(currentTimeMillis)));
                }
                return b.d.f770c;
            case 16:
                C0006b1 c0006b13 = this.f542b;
                b.b H2 = c0006b13.H();
                Dialog dialog2 = (Dialog) H2.f764a;
                LinearLayout linearLayout8 = (LinearLayout) H2.f765b;
                linearLayout8.addView(c0006b13.j0(dialog2, "See members"), C0006b1.X(c0006b13, -1, -2, 0, 0, 0, 60));
                Activity activity3 = c0006b13.f414a;
                View view = new View(activity3);
                view.setBackgroundColor(c0006b13.f428o);
                linearLayout8.addView(view, C0006b1.X(c0006b13, -1, 1, 0, 0, 0, 60));
                ?? scrollView3 = new ScrollView(activity3);
                scrollView3.setVerticalScrollBarEnabled(false);
                LinearLayout k12 = c0006b13.k1();
                List O = c.b.O(c0006b13.F.isEmpty() ? AbstractC0008c.p(c0006b13.f415b) : c0006b13.F, new U0(c0006b13));
                String str = O.size() + " members";
                int i6 = c0006b13.f425l;
                TextView f1 = c0006b13.f1(str, 19.5f, i6, true);
                float f5 = 14;
                float f6 = 20;
                f1.setPadding(c0006b13.z(f5), c0006b13.z(16), c0006b13.z(f6), c0006b13.z(8));
                k12.addView(f1);
                Iterator it2 = O.iterator();
                while (it2.hasNext()) {
                    String str2 = (String) it2.next();
                    boolean F = m.m.F(str2, c0006b13.C1);
                    LinearLayout P = c0006b13.P();
                    float f7 = 11;
                    Iterator it3 = it2;
                    P.setPadding(c0006b13.z(f5), c0006b13.z(f7), c0006b13.z(f6), c0006b13.z(f7));
                    P.setMinimumHeight(c0006b13.z(66));
                    float f8 = 44;
                    A2 k2 = c0006b13.k(str2, f8);
                    int z2 = c0006b13.z(f8);
                    int z3 = c0006b13.z(f8);
                    Activity activity4 = activity3;
                    LinearLayout linearLayout9 = linearLayout8;
                    P.addView(k2, C0006b1.X(c0006b13, z2, z3, 0, 0, 9, 32));
                    LinearLayout k13 = c0006b13.k1();
                    int i7 = i6;
                    k13.addView(c0006b13.f1(c0006b13.x(str2), 21.5f, i6, false), C0006b1.X(c0006b13, -2, -2, 0, 0, 0, 60));
                    if (F) {
                        f3 = f5;
                        linearLayout = k13;
                        linearLayout.addView(c0006b13.f1("Admin", 21.0f, c0006b13.f419f ? c0006b13.f426m : -7697007, false), C0006b1.X(c0006b13, -2, -2, 0, 0, 0, 60));
                    } else {
                        f3 = f5;
                        linearLayout = k13;
                    }
                    P.addView(linearLayout, new LinearLayout.LayoutParams(0, -2, 1.0f));
                    k12.addView(P);
                    f5 = f3;
                    it2 = it3;
                    linearLayout8 = linearLayout9;
                    i6 = i7;
                    activity3 = activity4;
                }
                k12.addView(new View(activity3), C0006b1.X(c0006b13, -1, c0006b13.z(24), 0, 0, 0, 60));
                scrollView3.addView(k12, new FrameLayout.LayoutParams(-1, -2));
                linearLayout8.addView((View) scrollView3, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                c0006b13.T0(dialog2);
                return b.d.f770c;
            case 17:
                C0006b1 c0006b14 = this.f542b;
                c0006b14.u("Clear group data?", "All messages of this group will be deleted for everyone. This cannot be undone.", "Cancel", "OK", new C0036j(c0006b14, i5));
                return b.d.f770c;
            case 18:
                ?? r1 = this.f542b;
                r1.getClass();
                Activity activity5 = r1.f414a;
                E2 e22 = new E2(activity5);
                e22.requestWindowFeature(1);
                FrameLayout frameLayout2 = new FrameLayout(activity5);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(r1.f429r);
                float z4 = r1.z(22.0f);
                gradientDrawable.setCornerRadii(new float[]{z4, z4, z4, z4, 0.0f, 0.0f, 0.0f, 0.0f});
                frameLayout2.setBackground(gradientDrawable);
                frameLayout2.setClipToOutline(true);
                frameLayout2.setOutlineProvider(new Z0(z4, 1));
                LinearLayout k14 = r1.k1();
                FrameLayout frameLayout3 = new FrameLayout(activity5);
                View view2 = new View(activity5);
                view2.setBackground(r1.N0(r1.f419f ? -10789278 : -3881012, 3.0f, 0, 0.0f));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(r1.z(46.0f), r1.z(4.0f), 1);
                layoutParams.topMargin = r1.z(13.0f);
                frameLayout3.addView(view2, layoutParams);
                FrameLayout frameLayout4 = frameLayout2;
                k14.addView(frameLayout3, C0006b1.X(r1, -1, r1.z(24.0f), 0, 0, 0, 60));
                int i8 = r1.f425l;
                TextView f12 = r1.f1("Themes", 21.0f, i8, true);
                f12.setGravity(17);
                k14.addView(f12, r1.W(-1, -2, 0, 2, 0, 12));
                ScrollView scrollView4 = new ScrollView(activity5);
                scrollView4.setVerticalScrollBarEnabled(false);
                LinearLayout k15 = r1.k1();
                k15.setPadding(r1.z(14.0f), r1.z(4.0f), r1.z(14.0f), r1.z(30.0f));
                int z5 = r1.z(10.0f);
                int i9 = 3;
                int z6 = ((activity5.getResources().getDisplayMetrics().widthPixels - r1.z(28.0f)) - (z5 * 2)) / 3;
                List list2 = AbstractC0026g1.f511a;
                int i10 = 0;
                while (i10 < list2.size()) {
                    ?? linearLayout10 = new LinearLayout(activity5);
                    linearLayout10.setOrientation(i5);
                    while (i5 < i9) {
                        int i11 = i10 + i5;
                        if (i11 < list2.size()) {
                            C0022f1 c0022f1 = (C0022f1) list2.get(i11);
                            frameLayout = frameLayout4;
                            D d2 = new D(r1, c0022f1, e22, 2);
                            int i12 = (int) (z6 * 1.66f);
                            e2 = e22;
                            ?? k16 = r1.k1();
                            FrameLayout frameLayout5 = new FrameLayout(activity5);
                            linearLayout2 = k14;
                            scrollView = scrollView4;
                            i2 = i10;
                            list = list2;
                            frameLayout5.addView(new N2(r1.f414a, c0022f1, r1.f422i, z6, i12), new FrameLayout.LayoutParams(z6, i12));
                            frameLayout5.setClipToOutline(true);
                            frameLayout5.setOutlineProvider(new T0(1, r1));
                            if (i.b.a(c0022f1.f481a, r1.w.f481a)) {
                                TextView textView = new TextView(activity5);
                                textView.setText("✓");
                                textView.setTextColor(-1);
                                textView.setTextSize(1, 13.95f);
                                textView.setGravity(17);
                                textView.setBackground(C0006b1.i0(-15173646));
                                linearLayout3 = k15;
                                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(r1.z(26.0f), r1.z(26.0f), 8388693);
                                z = false;
                                layoutParams2.setMargins(0, 0, r1.z(8.0f), r1.z(8.0f));
                                frameLayout5.addView(textView, layoutParams2);
                            } else {
                                linearLayout3 = k15;
                                z = false;
                            }
                            k16.addView(frameLayout5, new LinearLayout.LayoutParams(z6, i12));
                            k16.addView(r1.f1(c0022f1.f482b, 16.5f, i8, z), r1.W(-2, -2, 2, 8, 0, 18));
                            k16.setOnClickListener(new ViewOnClickListenerC0044l(d2, 1));
                            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(z6, -2);
                            if (i5 > 0) {
                                layoutParams3.leftMargin = z5;
                            }
                            linearLayout10.addView(k16, layoutParams3);
                            i3 = 1;
                        } else {
                            scrollView = scrollView4;
                            e2 = e22;
                            frameLayout = frameLayout4;
                            linearLayout2 = k14;
                            linearLayout3 = k15;
                            i2 = i10;
                            list = list2;
                            View view3 = new View(activity5);
                            i3 = 1;
                            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(z6, 1);
                            layoutParams4.leftMargin = z5;
                            linearLayout10.addView(view3, layoutParams4);
                        }
                        i5 += i3;
                        frameLayout4 = frameLayout;
                        e22 = e2;
                        k14 = linearLayout2;
                        scrollView4 = scrollView;
                        i10 = i2;
                        list2 = list;
                        k15 = linearLayout3;
                        i9 = 3;
                    }
                    ?? r30 = k15;
                    r30.addView(linearLayout10, C0006b1.X(r1, -1, -2, 0, 0, 0, 60));
                    i10 += 3;
                    i9 = 3;
                    k15 = r30;
                    scrollView4 = scrollView4;
                    list2 = list2;
                    i5 = 0;
                }
                ScrollView scrollView5 = scrollView4;
                E2 e23 = e22;
                FrameLayout frameLayout6 = frameLayout4;
                LinearLayout linearLayout11 = k14;
                scrollView5.addView(k15, new FrameLayout.LayoutParams(-1, -2));
                linearLayout11.addView(scrollView5, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                frameLayout6.addView(linearLayout11, new FrameLayout.LayoutParams(-1, -1));
                e23.setContentView(frameLayout6);
                Window window = e23.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                if (window != null) {
                    window.setGravity(80);
                }
                int i13 = activity5.getResources().getDisplayMetrics().heightPixels;
                if (window != null) {
                    window.setLayout(-1, i13 - r1.z(38.0f));
                }
                e23.f84a = frameLayout6;
                frameLayout6.setTranslationY(activity5.getResources().getDisplayMetrics().heightPixels);
                r1.T0(e23);
                frameLayout6.post(new I(frameLayout6, 0));
                return b.d.f770c;
            case 19:
                c0006b1.f416c.a("Coming soon");
                return b.d.f770c;
            case 20:
                c0006b1.u0(true, new C0086x(c0006b1, i4));
                return b.d.f770c;
            default:
                c0006b1.f414a.onBackPressed();
                return b.d.f770c;
        }
    }
}
