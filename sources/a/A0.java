package a;

import android.app.Dialog;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class A0 implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f11b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f12c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ K0 f13d;

    public /* synthetic */ A0(C0006b1 c0006b1, K0 k0, List list) {
        this.f10a = 0;
        this.f11b = c0006b1;
        this.f13d = k0;
        this.f12c = list;
    }

    @Override // h.a
    public final Object a() {
        switch (this.f10a) {
            case 0:
                final C0006b1 c0006b1 = this.f11b;
                c0006b1.getClass();
                final i.g gVar = new i.g();
                gVar.f850b = "";
                final List list = this.f12c;
                final K0 k0 = this.f13d;
                c0006b1.l(false, new h.c() { // from class: a.E0
                    @Override // h.c
                    public final Object a(Object obj, Object obj2) {
                        LinearLayout linearLayout = (LinearLayout) obj;
                        Dialog dialog = (Dialog) obj2;
                        C0006b1 c0006b12 = C0006b1.this;
                        TextView f1 = c0006b12.f1("Reactions", 21.0f, c0006b12.f425l, true);
                        f1.setGravity(17);
                        linearLayout.addView(f1, c0006b12.W(-1, -2, 0, 23, 0, 12));
                        ScrollView scrollView = new ScrollView(c0006b12.f414a);
                        LinearLayout k1 = c0006b12.k1();
                        scrollView.addView(k1, new FrameLayout.LayoutParams(-1, -2));
                        linearLayout.addView(scrollView, new LinearLayout.LayoutParams(-1, ((int) (r3.getResources().getDisplayMetrics().heightPixels * 0.5f)) - c0006b12.z(133)));
                        LinearLayout P = c0006b12.P();
                        float f2 = 14;
                        P.setPadding(c0006b12.z(f2), c0006b12.z(8), c0006b12.z(f2), 0);
                        linearLayout.addView(P, C0006b1.X(c0006b12, -1, -2, 0, 0, 0, 60));
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        List list2 = list;
                        Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            Object obj3 = ((b.b) it.next()).f765b;
                            Integer num = (Integer) linkedHashMap.get(obj3);
                            linkedHashMap.put(obj3, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
                        }
                        C0006b1.Q0(k1, list2, gVar, c0006b12, P, linkedHashMap, dialog, k0, c0006b12.f419f ? -16777216 : -1775893);
                        return b.d.f770c;
                    }
                });
                break;
            case 1:
                this.f11b.m1(this.f13d, (String) this.f12c.get(0));
                break;
            case 2:
                this.f11b.m1(this.f13d, (String) this.f12c.get(0));
                break;
            default:
                this.f11b.m1(this.f13d, (String) this.f12c.get(1));
                break;
        }
        return b.d.f770c;
    }

    public /* synthetic */ A0(C0006b1 c0006b1, List list, K0 k0, int i2) {
        this.f10a = i2;
        this.f11b = c0006b1;
        this.f12c = list;
        this.f13d = k0;
    }
}
