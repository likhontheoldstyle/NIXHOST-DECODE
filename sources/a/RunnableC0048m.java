package a;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: a.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0048m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f587a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f588b;

    public /* synthetic */ RunnableC0048m(C0006b1 c0006b1, int i2) {
        this.f587a = i2;
        this.f588b = c0006b1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        M0 m0;
        C0000a d2;
        JSONObject optJSONObject;
        switch (this.f587a) {
            case 0:
                C0006b1 c0006b1 = this.f588b;
                I2 i2 = c0006b1.W;
                if (i2 != null) {
                    i2.post(new RunnableC0048m(c0006b1, 2));
                    return;
                } else {
                    i.b.g("lv");
                    throw null;
                }
            case 1:
                C0000a b2 = C0004b.b(C0004b.f409a, "POST", "/chat/clear", new JSONObject(), 8);
                C0006b1 c0006b12 = this.f588b;
                c0006b12.f414a.runOnUiThread(new S(b2, c0006b12, 0));
                return;
            case 2:
                this.f588b.F();
                return;
            case 3:
                C0006b1 c0006b13 = this.f588b;
                do {
                    synchronized (c0006b13.O0) {
                        m0 = (M0) c.b.I(c0006b13.O0);
                    }
                    if (m0 != null) {
                        d2 = C0004b.f409a.d(m0.f208b);
                        if (d2.f400a != 0) {
                            synchronized (c0006b13.O0) {
                                c0006b13.O0.remove(m0);
                            }
                            c0006b13.C0();
                            c0006b13.f414a.runOnUiThread(new RunnableC0056o(c0006b13, d2, m0, 2, (byte) 0));
                        }
                    }
                    c0006b13.Q0 = false;
                    return;
                } while (d2.f400a != 401);
                c0006b13.Q0 = false;
                return;
            case 4:
                C0000a b3 = C0004b.b(C0004b.f409a, "DELETE", "/chat/avatar", null, 12);
                C0006b1 c0006b14 = this.f588b;
                c0006b14.f414a.runOnUiThread(new S(b3, c0006b14, 1));
                return;
            case 5:
                C0000a b4 = C0004b.b(C0004b.f409a, "GET", "/chat/members", null, 12);
                JSONObject c2 = b4.c();
                JSONArray optJSONArray = c2 != null ? c2.optJSONArray("members") : null;
                if (!b4.b() || optJSONArray == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                ArrayList arrayList2 = new ArrayList();
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject2 != null) {
                        arrayList.add(optJSONObject2.optString("u"));
                        hashMap.put(optJSONObject2.optString("u"), optJSONObject2.optString("n", optJSONObject2.optString("u")));
                        String optString = optJSONObject2.optString("p", "");
                        int length2 = optString.length();
                        String optString2 = optJSONObject2.optString("u");
                        if (length2 > 0) {
                            hashMap2.put(optString2, optString);
                        } else {
                            arrayList2.add(optString2);
                        }
                    }
                }
                JSONObject optJSONObject3 = c2 != null ? c2.optJSONObject("group") : null;
                long j2 = 0;
                if (c2 != null && (optJSONObject = c2.optJSONObject("self")) != null) {
                    j2 = optJSONObject.optLong("nat", 0L);
                }
                C0006b1 c0006b15 = this.f588b;
                c0006b15.f414a.runOnUiThread(new RunnableC0025g0(c0006b15, arrayList, hashMap, hashMap2, arrayList2, j2, c2, optJSONObject3));
                return;
            case 6:
                O0 o0 = this.f588b.j0;
                if (o0 != null) {
                    o0.notifyDataSetChanged();
                    return;
                } else {
                    i.b.g("adapter");
                    throw null;
                }
            case 7:
                this.f588b.c();
                return;
            case 8:
                C0006b1 c0006b16 = this.f588b;
                Object systemService = c0006b16.f414a.getSystemService("input_method");
                i.b.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                EditText editText = c0006b16.h0;
                if (editText != null) {
                    inputMethodManager.showSoftInput(editText, 1);
                    return;
                } else {
                    i.b.g("input");
                    throw null;
                }
            case 9:
                this.f588b.f416c.a("Could not read the photo");
                return;
            case 10:
                LinearLayout linearLayout = this.f588b.g0;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                    return;
                } else {
                    i.b.g("panel");
                    throw null;
                }
            case 11:
                C0006b1 c0006b17 = this.f588b;
                I2 i22 = c0006b17.W;
                if (i22 == null) {
                    i.b.g("lv");
                    throw null;
                }
                if (c0006b17.j0 != null) {
                    i22.setSelection(r0.getCount() - 1);
                    return;
                } else {
                    i.b.g("adapter");
                    throw null;
                }
            case 12:
                this.f588b.F();
                return;
            case 13:
                C0006b1 c0006b18 = this.f588b;
                if (!c0006b18.G || c0006b18.O()) {
                    return;
                }
                c0006b18.K0(1);
                return;
            default:
                C0006b1 c0006b19 = this.f588b;
                if (c0006b19.G) {
                    if (c0006b19.N == 1) {
                        c0006b19.K0(2);
                    }
                    if (c0006b19.F.isEmpty()) {
                        c0006b19.U();
                    }
                    c0006b19.b1();
                    return;
                }
                return;
        }
    }
}
