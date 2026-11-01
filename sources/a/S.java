package a;

import android.view.View;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final /* synthetic */ class S implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f300a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0000a f301b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f302c;

    public /* synthetic */ S(C0000a c0000a, C0006b1 c0006b1, int i2) {
        this.f300a = i2;
        this.f301b = c0000a;
        this.f302c = c0006b1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String optString;
        switch (this.f300a) {
            case 0:
                C0000a c0000a = this.f301b;
                boolean b2 = c0000a.b();
                C0006b1 c0006b1 = this.f302c;
                if (!b2) {
                    c0006b1.f416c.a(C0006b1.E(c0000a));
                    return;
                }
                JSONObject c2 = c0000a.c();
                c0006b1.d(c2 != null ? c2.optLong("cl", 2305843009213693951L) : 2305843009213693951L);
                c0006b1.f416c.a("Group data cleared");
                return;
            case 1:
                C0000a c0000a2 = this.f301b;
                boolean b3 = c0000a2.b();
                C0006b1 c0006b12 = this.f302c;
                if (!b3) {
                    c0006b12.f416c.a(C0006b1.E(c0000a2));
                    return;
                }
                c0006b12.l0.remove(c0006b12.f415b);
                c0006b12.B0();
                O0 o0 = c0006b12.j0;
                if (o0 == null) {
                    i.b.g("adapter");
                    throw null;
                }
                o0.notifyDataSetChanged();
                C0029h0 c0029h0 = c0006b12.y1;
                if (c0029h0 != null) {
                    c0029h0.a();
                    return;
                }
                return;
            case 2:
                C0000a c0000a3 = this.f301b;
                boolean b4 = c0000a3.b();
                C0006b1 c0006b13 = this.f302c;
                if (b4) {
                    c0006b13.b1();
                    return;
                } else {
                    c0006b13.f416c.a(C0006b1.E(c0000a3));
                    return;
                }
            case 3:
                C0000a c0000a4 = this.f301b;
                JSONObject c3 = c0000a4.c();
                String str = "";
                if (c3 != null && (optString = c3.optString("p", "")) != null) {
                    str = optString;
                }
                boolean b5 = c0000a4.b();
                C0006b1 c0006b14 = this.f302c;
                if (!b5 || str.length() <= 0) {
                    c0006b14.f416c.a(C0006b1.E(c0000a4));
                    return;
                }
                c0006b14.l0.put(c0006b14.f415b, str);
                c0006b14.B0();
                O0 o02 = c0006b14.j0;
                if (o02 == null) {
                    i.b.g("adapter");
                    throw null;
                }
                o02.notifyDataSetChanged();
                C0029h0 c0029h02 = c0006b14.y1;
                if (c0029h02 != null) {
                    c0029h02.a();
                    return;
                }
                return;
            case 4:
                C0006b1 c0006b15 = this.f302c;
                c0006b15.J = false;
                C0000a c0000a5 = this.f301b;
                JSONObject c4 = c0000a5.c();
                if (!c0000a5.b() || c4 == null) {
                    return;
                }
                I2 i2 = c0006b15.W;
                if (i2 == null) {
                    i.b.g("lv");
                    throw null;
                }
                int firstVisiblePosition = i2.getFirstVisiblePosition();
                I2 i22 = c0006b15.W;
                if (i22 == null) {
                    i.b.g("lv");
                    throw null;
                }
                View childAt = i22.getChildAt(0);
                int top = childAt != null ? childAt.getTop() : 0;
                int b6 = c0006b15.b(c4.optJSONArray("msgs"));
                c0006b15.g(c4);
                JSONArray optJSONArray = c4.optJSONArray("msgs");
                if ((optJSONArray != null ? optJSONArray.length() : 0) < 40) {
                    c0006b15.I = false;
                }
                O0 o03 = c0006b15.j0;
                if (o03 == null) {
                    i.b.g("adapter");
                    throw null;
                }
                o03.notifyDataSetChanged();
                I2 i23 = c0006b15.W;
                if (i23 == null) {
                    i.b.g("lv");
                    throw null;
                }
                i23.setSelectionFromTop(firstVisiblePosition + b6, top);
                I2 i24 = c0006b15.W;
                if (i24 != null) {
                    i24.post(new RunnableC0048m(c0006b15, 12));
                    return;
                } else {
                    i.b.g("lv");
                    throw null;
                }
            default:
                this.f302c.f416c.a(C0006b1.E(this.f301b));
                return;
        }
    }

    public /* synthetic */ S(C0006b1 c0006b1, C0000a c0000a, int i2) {
        this.f300a = i2;
        this.f302c = c0006b1;
        this.f301b = c0000a;
    }
}
