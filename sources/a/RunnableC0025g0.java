package a;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: a.g0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0025g0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f502a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f503b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f504c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f505d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Serializable f506e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Serializable f507f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Serializable f508g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f509h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f510i;

    public /* synthetic */ RunnableC0025g0(C0006b1 c0006b1, ArrayList arrayList, HashMap hashMap, HashMap hashMap2, ArrayList arrayList2, long j2, JSONObject jSONObject, JSONObject jSONObject2) {
        this.f503b = c0006b1;
        this.f504c = arrayList;
        this.f506e = hashMap;
        this.f507f = hashMap2;
        this.f508g = arrayList2;
        this.f505d = j2;
        this.f509h = jSONObject;
        this.f510i = jSONObject2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String optString;
        Object obj = this.f510i;
        Object obj2 = this.f509h;
        Serializable serializable = this.f508g;
        Serializable serializable2 = this.f507f;
        Serializable serializable3 = this.f506e;
        ArrayList arrayList = this.f504c;
        switch (this.f502a) {
            case 0:
                boolean z = ((i.d) serializable3).f846a;
                C0006b1 c0006b1 = this.f503b;
                long j2 = this.f505d;
                if (z) {
                    c0006b1.E0(j2, "video", c.b.N(AbstractC0008c.p(((i.g) serializable2).f850b), arrayList), ((i.e) obj2).f847a, (K0) obj, c.j.f773a);
                    return;
                } else {
                    c0006b1.z0(j2);
                    c0006b1.f416c.a(((i.g) serializable).f850b);
                    return;
                }
            default:
                C0006b1 c0006b12 = this.f503b;
                c0006b12.F = arrayList;
                c0006b12.t0.putAll((HashMap) serializable3);
                HashMap hashMap = c0006b12.l0;
                hashMap.putAll((HashMap) serializable2);
                Iterator it = ((ArrayList) serializable).iterator();
                while (it.hasNext()) {
                    hashMap.remove((String) it.next());
                }
                c0006b12.d0(this.f505d);
                JSONObject jSONObject = (JSONObject) obj2;
                c0006b12.e(jSONObject);
                c0006b12.i(jSONObject);
                JSONObject jSONObject2 = (JSONObject) obj;
                String str2 = "";
                if (jSONObject2 == null || (str = jSONObject2.optString("name", "")) == null) {
                    str = "";
                }
                c0006b12.u0 = str;
                if (jSONObject2 != null && (optString = jSONObject2.optString("picture", "")) != null) {
                    str2 = optString;
                }
                c0006b12.v0 = str2;
                if (str2.length() > 0) {
                    File file = z2.f758a;
                    A2 a2 = c0006b12.w0;
                    if (a2 == null) {
                        i.b.g("headPic");
                        throw null;
                    }
                    z2.f(a2, c0006b12.v0);
                }
                c0006b12.i1();
                O0 o0 = c0006b12.j0;
                if (o0 == null) {
                    i.b.g("adapter");
                    throw null;
                }
                o0.notifyDataSetChanged();
                c0006b12.B0();
                C0029h0 c0029h0 = c0006b12.y1;
                if (c0029h0 != null) {
                    c0029h0.a();
                    return;
                }
                return;
        }
    }

    public /* synthetic */ RunnableC0025g0(i.d dVar, C0006b1 c0006b1, long j2, i.g gVar, ArrayList arrayList, i.e eVar, K0 k0, i.g gVar2) {
        this.f506e = dVar;
        this.f503b = c0006b1;
        this.f505d = j2;
        this.f507f = gVar;
        this.f504c = arrayList;
        this.f509h = eVar;
        this.f510i = k0;
        this.f508g = gVar2;
    }
}
