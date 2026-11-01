package a;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public final class O0 extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f236a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f237b;

    public /* synthetic */ O0(int i2, Object obj) {
        this.f236a = i2;
        this.f237b = obj;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        switch (this.f236a) {
            case 0:
                return ((C0006b1) this.f237b).D.size();
            default:
                return ((B1) this.f237b).f39n.size();
        }
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i2) {
        switch (this.f236a) {
            case 0:
                return ((C0006b1) this.f237b).D.get(i2);
            default:
                return ((B1) this.f237b).f39n.get(i2);
        }
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        switch (this.f236a) {
            case 0:
                return ((K0) ((C0006b1) this.f237b).D.get(i2)).f150a;
            default:
                return i2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0750  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x075d  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x08ca  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x08d7  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x09ac  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x09e2  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0a61 A[LOOP:1: B:283:0x0a5b->B:285:0x0a61, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0a9a  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x09e9  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x09af  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0a1d  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x08ce  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        K0 k0;
        ArrayList arrayList;
        String str;
        String str2;
        K0 k02;
        float f2;
        ViewGroup viewGroup3;
        K0 k03;
        ViewGroup viewGroup4;
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        LinearLayout P;
        List list;
        String str3;
        int i4;
        int i5;
        View view2;
        ArrayList arrayList2;
        Iterator it;
        boolean z5;
        String str4;
        FrameLayout frameLayout;
        String str5;
        Object obj;
        String str6;
        Object obj2 = this.f237b;
        switch (this.f236a) {
            case 0:
                C0006b1 c0006b1 = (C0006b1) obj2;
                ArrayList arrayList3 = c0006b1.D;
                K0 k04 = (K0) arrayList3.get(i2);
                boolean a2 = i.b.a(k04.f152c, "sys");
                String str7 = c0006b1.f415b;
                Activity activity = c0006b1.f414a;
                String str8 = k04.f151b;
                if (a2) {
                    List b0 = m.e.b0(k04.f153d, new String[]{"|"});
                    LinearLayout k1 = c0006b1.k1();
                    float f3 = 28;
                    float f4 = 14;
                    k1.setPadding(c0006b1.z(f3), c0006b1.z(f4), c0006b1.z(f3), c0006b1.z(f4));
                    List b02 = m.e.b0(k04.f153d, new String[]{"|"});
                    String x = i.b.a(str8, str7) ? "You" : c0006b1.x(str8);
                    String str9 = (String) c.b.J(b02, 0);
                    if (i.b.a(str9, "theme")) {
                        List list2 = AbstractC0026g1.f511a;
                        str6 = x + " changed the chat theme to " + AbstractC0026g1.a((String) (1 < b02.size() ? b02.get(1) : "")).f482b;
                    } else if (i.b.a(str9, "name")) {
                        String str10 = (String) (1 < b02.size() ? b02.get(1) : c0006b1.x(str8));
                        String str11 = (String) (2 < b02.size() ? b02.get(2) : "");
                        str6 = i.b.a(str8, str7) ? J0.a("You changed your name to ", str11) : str10 + " changed their name to " + str11;
                    } else {
                        str6 = "";
                    }
                    TextView f1 = c0006b1.f1(str6, 15.0f, c0006b1.K(), false);
                    f1.setGravity(17);
                    k1.addView(f1, C0006b1.X(c0006b1, -1, -2, 0, 0, 0, 60));
                    if (i.b.a(c.b.J(b0, 0), "theme")) {
                        List list3 = AbstractC0026g1.f511a;
                        String str12 = AbstractC0026g1.a((String) (1 < b0.size() ? b0.get(1) : "")).f483c;
                        TextView f12 = c0006b1.f1((str12.length() != 0 ? str12 + " " : "") + "Change", 15.0f, c0006b1.I(), true);
                        f12.setGravity(17);
                        float f5 = (float) 12;
                        float f6 = (float) 4;
                        f12.setPadding(c0006b1.z(f5), c0006b1.z(f6), c0006b1.z(f5), c0006b1.z(f6));
                        C0006b1.n0(f12, new C0036j(c0006b1, 20));
                        k1.addView(f12, c0006b1.W(-1, -2, 0, 2, 0, 0));
                    }
                    i5 = i2;
                    arrayList2 = arrayList3;
                    str3 = str7;
                    view2 = k1;
                    i4 = 8388613;
                } else {
                    K0 k05 = i2 > 0 ? (K0) arrayList3.get(i2 - 1) : null;
                    int i6 = i2 + 1;
                    K0 k06 = i6 < arrayList3.size() ? (K0) arrayList3.get(i6) : null;
                    boolean a3 = i.b.a(str8, str7);
                    long j2 = k04.f158i;
                    boolean z6 = k05 == null || j2 - k05.f158i > 900000;
                    boolean z7 = (k05 == null || i.b.a(k05.f152c, "sys") || !i.b.a(k05.f151b, str8) || z6) ? false : true;
                    boolean z8 = k06 != null && !i.b.a(k06.f152c, "sys") && i.b.a(k06.f151b, str8) && k06.f158i - j2 <= 900000;
                    ViewGroup k12 = c0006b1.k1();
                    k12.setPadding(c0006b1.z(13.0f), 0, c0006b1.z(13.0f), 0);
                    if (z6) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
                        boolean a4 = i.b.a(simpleDateFormat.format(new Date()), simpleDateFormat.format(new Date(j2)));
                        long currentTimeMillis = (System.currentTimeMillis() - j2) / 86400000;
                        TextView f13 = c0006b1.f1(new SimpleDateFormat(a4 ? "HH:mm" : (0 > currentTimeMillis || currentTimeMillis >= 7) ? "d MMM, HH:mm" : "EEE HH:mm", Locale.getDefault()).format(new Date(j2)), 16.5f, c0006b1.K(), false);
                        f13.setGravity(17);
                        k0 = k04;
                        ViewGroup.LayoutParams W = c0006b1.W(-1, -2, 0, i2 == 0 ? 4 : 21, 0, a3 ? 12 : 19);
                        viewGroup2 = k12;
                        viewGroup2.addView(f13, W);
                    } else {
                        viewGroup2 = k12;
                        k0 = k04;
                    }
                    if (!a3 && !z7) {
                        viewGroup2.addView(c0006b1.f1(c0006b1.x(str8), 14.0f, c0006b1.K(), false), c0006b1.W(-2, -2, 43, z6 ? 0 : 15, 0, 1));
                    }
                    float f7 = (!z7 || (a3 && !(k05 != null && C0006b1.N(k05) && C0006b1.N(k0)))) ? (z6 || !a3) ? 0.0f : 12.0f : 2.2f;
                    LinearLayout k13 = c0006b1.k1();
                    k13.setGravity(a3 ? 8388613 : 8388611);
                    K0 k07 = k0;
                    long j3 = k07.f157h;
                    if (j3 > 0) {
                        String x2 = a3 ? "You" : c0006b1.x(str8);
                        String str13 = k07.f160k;
                        String str14 = x2 + " replied to " + (i.b.a(str13, str8) ? a3 ? "yourself" : "themselves" : i.b.a(str13, str7) ? "you" : c0006b1.x(str13));
                        LinearLayout P2 = c0006b1.P();
                        float f8 = 14;
                        str2 = str7;
                        f2 = f7;
                        k03 = k07;
                        str = str8;
                        viewGroup3 = viewGroup2;
                        ViewGroup viewGroup5 = k13;
                        P2.addView(c0006b1.M("reply", c0006b1.K(), 14), C0006b1.X(c0006b1, c0006b1.z(f8), c0006b1.z(f8), 0, 0, 6, 32));
                        P2.addView(c0006b1.f1(str14, 13.0f, c0006b1.K(), false), C0006b1.X(c0006b1, -2, -2, 0, 0, 0, 60));
                        viewGroup5.addView(P2, c0006b1.W(-2, -2, 0, 2, 0, 3));
                        boolean z9 = k03.f163n;
                        String str15 = k03.f161l;
                        if (z9 || !(i.b.a(str15, "image") || i.b.a(str15, "video"))) {
                            str5 = null;
                        } else {
                            String str16 = (String) c.b.I(k03.p);
                            if (str16 == null || str16.length() <= 0) {
                                Iterator it2 = arrayList3.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        Object next = it2.next();
                                        Iterator it3 = it2;
                                        if (((K0) next).f150a == j3) {
                                            obj = next;
                                        } else {
                                            it2 = it3;
                                        }
                                    } else {
                                        obj = null;
                                    }
                                }
                                K0 k08 = (K0) obj;
                                if (k08 == null || k08.f159j || (str16 = (String) c.b.I(k08.f154e)) == null || str16.length() == 0) {
                                    str16 = null;
                                }
                            }
                            str5 = str16;
                        }
                        if (str5 != null) {
                            boolean a5 = i.b.a(str15, "video");
                            FrameLayout frameLayout2 = new FrameLayout(activity);
                            float f9 = 16;
                            float z10 = c0006b1.z(f9);
                            i3 = 7;
                            arrayList = arrayList3;
                            k02 = k06;
                            String str17 = str5;
                            frameLayout2.addView(c0006b1.Q(str5, new float[]{z10, z10, z10, z10, z10, z10, z10, z10}, 480, new B0(c0006b1, frameLayout2, 0), new C0(0)), new FrameLayout.LayoutParams(-1, -1));
                            if (a5) {
                                FrameLayout frameLayout3 = new FrameLayout(activity);
                                frameLayout3.setBackground(C0006b1.i0(-1290003426));
                                frameLayout3.addView(c0006b1.M("play", -1, 16), new FrameLayout.LayoutParams(c0006b1.z(f9), c0006b1.z(f9), 17));
                                float f10 = 34;
                                frameLayout2.addView(frameLayout3, new FrameLayout.LayoutParams(c0006b1.z(f10), c0006b1.z(f10), 17));
                            }
                            Float f11 = (Float) z2.f763f.get(str17);
                            viewGroup5.addView(frameLayout2, c0006b1.q0(f11 != null ? f11.floatValue() : 0.5625f));
                            viewGroup4 = viewGroup5;
                        } else {
                            arrayList = arrayList3;
                            k02 = k06;
                            i3 = 7;
                            TextView f14 = c0006b1.f1(C0006b1.r0(str15, k03.f162m, z9), 16.0f, c0006b1.K(), false);
                            f14.setSingleLine(true);
                            f14.setEllipsize(TextUtils.TruncateAt.END);
                            f14.setMaxWidth(c0006b1.z(240));
                            f14.setTypeface((!i.b.a(str15, "text") || z9) ? Typeface.create(Typeface.DEFAULT, 2) : Typeface.DEFAULT);
                            f14.setBackground(c0006b1.N0(c0006b1.L() ? c0006b1.w.f492l : c0006b1.f423j, 18.0f, 0, 0.0f));
                            float f15 = 9;
                            f14.setPadding(c0006b1.z(f8), c0006b1.z(f15), c0006b1.z(f8), c0006b1.z(f15));
                            viewGroup5.addView(f14, c0006b1.W(-2, -2, 0, 0, 0, -6));
                            viewGroup4 = viewGroup5;
                        }
                    } else {
                        arrayList = arrayList3;
                        str = str8;
                        str2 = str7;
                        k02 = k06;
                        f2 = f7;
                        viewGroup3 = viewGroup2;
                        k03 = k07;
                        viewGroup4 = k13;
                        i3 = 7;
                    }
                    if (k03.f164o > 0 && !k03.f159j && i.b.a(k03.f152c, "text")) {
                        TextView f16 = c0006b1.f1("Edited", 14.5f, c0006b1.f431t, false);
                        float f17 = 4;
                        f16.setPadding(c0006b1.z(f17), c0006b1.z(3), c0006b1.z(f17), c0006b1.z(2));
                        C0006b1.n0(f16, new C0005b0(c0006b1, k03, 1));
                        viewGroup4.addView(f16, c0006b1.W(-2, -2, 0, 0, 2, 1));
                    }
                    HashMap hashMap = c0006b1.E;
                    long j4 = k03.f150a;
                    List list4 = (List) hashMap.get(Long.valueOf(j4));
                    if (list4 == null) {
                        list4 = c.j.f773a;
                    }
                    FrameLayout frameLayout4 = new FrameLayout(activity);
                    boolean z11 = z7 && k05 != null && C0006b1.N(k05) && C0006b1.N(k03);
                    if (z8 && k02 != null && C0006b1.N(k02) && C0006b1.N(k03)) {
                        z = a3;
                        z2 = true;
                    } else {
                        z = a3;
                        z2 = false;
                    }
                    View m2 = c0006b1.m(k03, z, z11, z2);
                    boolean z12 = (list4.isEmpty() ^ true) && !k03.f159j;
                    if (!z12 && !z && !k03.f159j) {
                        if (i2 == arrayList.size() - 1) {
                            z3 = true;
                            z4 = !z12 || z3;
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 48);
                            if (z4) {
                                layoutParams.bottomMargin = c0006b1.z(26.0f);
                            }
                            frameLayout4.addView(m2, layoutParams);
                            if (z4) {
                                int i7 = c0006b1.f422i;
                                int i8 = c0006b1.f433v;
                                if (z12) {
                                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                                    Iterator it4 = list4.iterator();
                                    while (it4.hasNext()) {
                                        linkedHashSet.add(((b.b) it4.next()).f765b);
                                    }
                                    LinearLayout P3 = c0006b1.P();
                                    P3.setGravity(17);
                                    GradientDrawable gradientDrawable = new GradientDrawable();
                                    gradientDrawable.setColor(i8);
                                    gradientDrawable.setCornerRadius(c0006b1.z(40.0f));
                                    gradientDrawable.setStroke(c0006b1.z(1.6f), i7);
                                    P3.setBackground(gradientDrawable);
                                    P3.setMinimumHeight(c0006b1.z(32.0f));
                                    P3.setPadding(c0006b1.z(7.5f), 0, c0006b1.z(7.5f), 0);
                                    TextView textView = new TextView(activity);
                                    textView.setText(c.b.L(c.b.P(linkedHashSet, 3), "", null, null, null, 62));
                                    textView.setTextSize(1, 16.74f);
                                    textView.setSingleLine(true);
                                    P3.addView(textView, new LinearLayout.LayoutParams(-2, -2));
                                    if (list4.size() > 1) {
                                        TextView f18 = c0006b1.f1(String.valueOf(list4.size()), 15.0f, c0006b1.f426m, false);
                                        f18.setSingleLine(true);
                                        P3.addView(f18, c0006b1.W(-2, -2, 4, 0, 0, 0));
                                    }
                                    C0006b1.n0(P3, new A0(c0006b1, k03, list4));
                                    frameLayout = P3;
                                } else {
                                    FrameLayout frameLayout5 = new FrameLayout(activity);
                                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                                    gradientDrawable2.setShape(1);
                                    gradientDrawable2.setColor(i8);
                                    gradientDrawable2.setStroke(c0006b1.z(1.6f), i7);
                                    frameLayout5.setBackground(gradientDrawable2);
                                    C1 M = c0006b1.M("reactface", c0006b1.f419f ? -2565411 : -10460570, 17);
                                    M.setCut(i8);
                                    frameLayout5.addView(M, new FrameLayout.LayoutParams(c0006b1.z(17.0f), c0006b1.z(17.0f), 17));
                                    frameLayout5.setMinimumWidth(c0006b1.z(32.0f));
                                    frameLayout5.setMinimumHeight(c0006b1.z(32.0f));
                                    C0006b1.n0(frameLayout5, new C0005b0(c0006b1, k03, 4));
                                    frameLayout = frameLayout5;
                                }
                                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, (z ? 8388613 : 8388611) | 80);
                                layoutParams2.setMargins(c0006b1.z(1.0f), 0, c0006b1.z(1.0f), 0);
                                frameLayout4.addView(frameLayout, layoutParams2);
                            }
                            viewGroup4.addView(frameLayout4, C0006b1.X(c0006b1, -2, -2, 0, 0, 0, 60));
                            P = c0006b1.P();
                            P.setClipChildren(false);
                            ViewGroup viewGroup6 = viewGroup3;
                            viewGroup6.setClipChildren(false);
                            viewGroup6.setClipToPadding(false);
                            viewGroup4.setClipChildren(false);
                            frameLayout4.setClipChildren(false);
                            P.setGravity((!z ? 8388613 : 8388611) | 80);
                            if (!z) {
                                if (z8) {
                                    View view3 = new View(activity);
                                    LinearLayout.LayoutParams X = C0006b1.X(c0006b1, c0006b1.z(27.4f), 1, 0, 0, 0, 60);
                                    X.rightMargin = c0006b1.z(8.6f);
                                    P.addView(view3, X);
                                } else {
                                    View k2 = c0006b1.k(str, 27.4f);
                                    LinearLayout.LayoutParams W2 = c0006b1.W(c0006b1.z(27.4f), c0006b1.z(27.4f), 0, 0, 0, z4 ? i3 : 0);
                                    W2.rightMargin = c0006b1.z(8.6f);
                                    P.addView(k2, W2);
                                }
                            }
                            P.addView(viewGroup4, C0006b1.X(c0006b1, -2, -2, 0, 0, 0, 60));
                            list = (List) c0006b1.n0.get(Long.valueOf(j4));
                            if (z || k03.f159j || !((j4 == c0006b1.s0 || c0006b1.S(k03)) && (list == null || list.isEmpty()))) {
                                str3 = str2;
                                if (z) {
                                    P.addView(new View(activity), C0006b1.X(c0006b1, c0006b1.z(16.0f), 1, 0, 0, 0, 60));
                                }
                            } else {
                                HashMap hashMap2 = c0006b1.m0;
                                if (!hashMap2.isEmpty()) {
                                    for (Map.Entry entry : hashMap2.entrySet()) {
                                        String str18 = (String) entry.getKey();
                                        long longValue = ((Number) entry.getValue()).longValue();
                                        str3 = str2;
                                        if (i.b.a(str18, str3) || longValue < j4) {
                                            str2 = str3;
                                        } else {
                                            z5 = true;
                                            if (c0006b1.S(k03)) {
                                                if (!z5) {
                                                    HashSet hashSet = c0006b1.p0;
                                                    if (!(hashSet instanceof Collection) || !hashSet.isEmpty()) {
                                                        Iterator it5 = hashSet.iterator();
                                                        while (it5.hasNext()) {
                                                            if (!i.b.a((String) it5.next(), str3)) {
                                                            }
                                                        }
                                                    }
                                                    str4 = "sent";
                                                }
                                                str4 = "deliv";
                                            } else {
                                                str4 = "pend";
                                            }
                                            View M2 = c0006b1.M(str4, !c0006b1.L() ? c0006b1.w.f491k : c0006b1.f420g, 16);
                                            LinearLayout.LayoutParams X2 = C0006b1.X(c0006b1, c0006b1.z(14.0f), c0006b1.z(14.0f), 0, 0, 0, 60);
                                            X2.leftMargin = c0006b1.z(2.0f);
                                            X2.rightMargin = 0;
                                            X2.bottomMargin = c0006b1.z(3.0f);
                                            P.addView(M2, X2);
                                        }
                                    }
                                }
                                str3 = str2;
                                z5 = false;
                                if (c0006b1.S(k03)) {
                                }
                                View M22 = c0006b1.M(str4, !c0006b1.L() ? c0006b1.w.f491k : c0006b1.f420g, 16);
                                LinearLayout.LayoutParams X22 = C0006b1.X(c0006b1, c0006b1.z(14.0f), c0006b1.z(14.0f), 0, 0, 0, 60);
                                X22.leftMargin = c0006b1.z(2.0f);
                                X22.rightMargin = 0;
                                X22.bottomMargin = c0006b1.z(3.0f);
                                P.addView(M22, X22);
                            }
                            if (list != null && (!list.isEmpty()) && !z) {
                                P.addView(new View(activity), new LinearLayout.LayoutParams(0, 1, 1.0f));
                                it = list.iterator();
                                while (it.hasNext()) {
                                    View k3 = c0006b1.k((String) it.next(), 15.6f);
                                    LinearLayout.LayoutParams X3 = C0006b1.X(c0006b1, c0006b1.z(15.6f), c0006b1.z(15.6f), 0, 0, 0, 60);
                                    X3.leftMargin = c0006b1.z(2.0f);
                                    P.addView(k3, X3);
                                }
                            }
                            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                            layoutParams3.topMargin = c0006b1.z(f2);
                            if (z) {
                                layoutParams3.rightMargin = -c0006b1.z(8.0f);
                            }
                            viewGroup6.addView(P, layoutParams3);
                            if (list == null && (!list.isEmpty()) && z) {
                                LinearLayout P4 = c0006b1.P();
                                i4 = 8388613;
                                P4.setGravity(8388613);
                                Iterator it6 = list.iterator();
                                while (it6.hasNext()) {
                                    A2 k4 = c0006b1.k((String) it6.next(), 15.6f);
                                    LinearLayout.LayoutParams X4 = C0006b1.X(c0006b1, c0006b1.z(15.6f), c0006b1.z(15.6f), 0, 0, 0, 60);
                                    X4.leftMargin = c0006b1.z(2.0f);
                                    P4.addView(k4, X4);
                                }
                                viewGroup6.addView(P4, C0006b1.X(c0006b1, -1, -2, 0, 2, 0, 48));
                            } else {
                                i4 = 8388613;
                            }
                            viewGroup6.setTag(P);
                            i5 = i2;
                            view2 = viewGroup6;
                            arrayList2 = arrayList;
                        }
                    }
                    z3 = false;
                    if (z12) {
                    }
                    FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2, 48);
                    if (z4) {
                    }
                    frameLayout4.addView(m2, layoutParams4);
                    if (z4) {
                    }
                    viewGroup4.addView(frameLayout4, C0006b1.X(c0006b1, -2, -2, 0, 0, 0, 60));
                    P = c0006b1.P();
                    P.setClipChildren(false);
                    ViewGroup viewGroup62 = viewGroup3;
                    viewGroup62.setClipChildren(false);
                    viewGroup62.setClipToPadding(false);
                    viewGroup4.setClipChildren(false);
                    frameLayout4.setClipChildren(false);
                    P.setGravity((!z ? 8388613 : 8388611) | 80);
                    if (!z) {
                    }
                    P.addView(viewGroup4, C0006b1.X(c0006b1, -2, -2, 0, 0, 0, 60));
                    list = (List) c0006b1.n0.get(Long.valueOf(j4));
                    if (z) {
                    }
                    str3 = str2;
                    if (z) {
                    }
                    if (list != null) {
                        P.addView(new View(activity), new LinearLayout.LayoutParams(0, 1, 1.0f));
                        it = list.iterator();
                        while (it.hasNext()) {
                        }
                    }
                    LinearLayout.LayoutParams layoutParams32 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams32.topMargin = c0006b1.z(f2);
                    if (z) {
                    }
                    viewGroup62.addView(P, layoutParams32);
                    if (list == null) {
                    }
                    i4 = 8388613;
                    viewGroup62.setTag(P);
                    i5 = i2;
                    view2 = viewGroup62;
                    arrayList2 = arrayList;
                }
                boolean a6 = i.b.a(((K0) arrayList2.get(i5)).f151b, str3);
                final FrameLayout frameLayout6 = new FrameLayout(activity);
                frameLayout6.setClipChildren(false);
                frameLayout6.setClipToPadding(false);
                FrameLayout frameLayout7 = new FrameLayout(activity);
                frameLayout7.setBackground(C0006b1.i0(c0006b1.f430s));
                frameLayout7.setAlpha(0.0f);
                frameLayout7.addView(c0006b1.M("replyf", c0006b1.f425l, 18), new FrameLayout.LayoutParams(c0006b1.z(18.0f), c0006b1.z(18.0f), 17));
                int z13 = c0006b1.z(34.0f);
                int z14 = c0006b1.z(34.0f);
                if (!a6) {
                    i4 = 8388611;
                }
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(z13, z14, i4 | 48);
                layoutParams5.leftMargin = c0006b1.z(8.0f);
                layoutParams5.rightMargin = c0006b1.z(8.0f);
                frameLayout6.addView(frameLayout7, layoutParams5);
                frameLayout6.addView(view2, new FrameLayout.LayoutParams(-1, -2));
                Object tag = view2.getTag();
                View view4 = tag instanceof View ? (View) tag : null;
                if (view4 != null) {
                    view2 = view4;
                }
                frameLayout6.setTag(new J2(view2, frameLayout7, a6));
                if (((K0) c0006b1.D.get(i5)).f150a == c0006b1.w1) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    if (c0006b1.x1 == 0) {
                        c0006b1.x1 = uptimeMillis;
                    }
                    long j5 = uptimeMillis - c0006b1.x1;
                    if (j5 >= 340) {
                        c0006b1.w1 = Long.MIN_VALUE;
                    } else {
                        float f19 = j5 / 340.0f;
                        final float z15 = c0006b1.z(34);
                        frameLayout6.setTranslationY((1.0f - f19) * z15);
                        frameLayout6.setAlpha(AbstractC0008c.b(f19, 0.0f, 1.0f));
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(f19, 1.0f);
                        ofFloat.setDuration(340 - j5);
                        ofFloat.setInterpolator(new OvershootInterpolator(1.15f));
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: a.p0
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                Object animatedValue = valueAnimator.getAnimatedValue();
                                i.b.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                                float floatValue = ((Float) animatedValue).floatValue();
                                float f20 = (1.0f - floatValue) * z15;
                                View view5 = frameLayout6;
                                view5.setTranslationY(f20);
                                view5.setAlpha(AbstractC0008c.b(floatValue, 0.0f, 1.0f));
                            }
                        });
                        ofFloat.start();
                    }
                }
                return frameLayout6;
            default:
                C0082v1 c0082v1 = view instanceof C0082v1 ? (C0082v1) view : null;
                B1 b1 = (B1) obj2;
                if (c0082v1 == null) {
                    c0082v1 = new C0082v1(b1);
                }
                C0094z1 c0094z1 = (C0094z1) b1.f39n.get(i2);
                c0082v1.f686e = c0094z1;
                String uri = c0094z1.f752a.toString();
                c0082v1.f687f = uri;
                B1 b12 = c0082v1.f688g;
                Bitmap bitmap = (Bitmap) b12.f36k.get(uri);
                c0082v1.f682a.setImageBitmap(bitmap);
                if (bitmap == null) {
                    HashSet hashSet2 = b12.f37l;
                    if (hashSet2.add(uri)) {
                        try {
                            b12.f35j.execute(new K(b12, c0094z1, uri, c0082v1, 5));
                        } catch (Throwable unused) {
                            hashSet2.remove(uri);
                        }
                    }
                }
                TextView textView2 = c0082v1.f684c;
                if (c0094z1.f753b) {
                    textView2.setVisibility(0);
                    int i9 = (int) ((c0094z1.f754c + 500) / 1000);
                    int i10 = i9 / 3600;
                    int i11 = (i9 % 3600) / 60;
                    int i12 = i9 % 60;
                    textView2.setText(i10 > 0 ? i10 + ":" + m.e.U(String.valueOf(i11)) + ":" + m.e.U(String.valueOf(i12)) : i11 + ":" + m.e.U(String.valueOf(i12)));
                } else {
                    textView2.setVisibility(8);
                }
                int indexOf = b12.f40o.indexOf(c0094z1);
                View view5 = c0082v1.f683b;
                TextView textView3 = c0082v1.f685d;
                if (indexOf >= 0) {
                    view5.setVisibility(0);
                    textView3.setVisibility(0);
                    textView3.setText(String.valueOf(indexOf + 1));
                } else {
                    view5.setVisibility(8);
                    textView3.setVisibility(8);
                }
                return c0082v1;
        }
    }
}
