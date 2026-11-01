package a;

import android.widget.LinearLayout;
import com.nix.host.MainActivity;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.json.JSONArray;

/* renamed from: a.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0028h implements h.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f515a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f516b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f517c;

    public /* synthetic */ C0028h(Object obj, Object obj2, int i2) {
        this.f515a = i2;
        this.f516b = obj;
        this.f517c = obj2;
    }

    @Override // h.b
    public final Object a(Object obj) {
        int i2 = 0;
        Object obj2 = this.f517c;
        Object obj3 = this.f516b;
        switch (this.f515a) {
            case 0:
                String str = (String) obj;
                C0006b1 c0006b1 = (C0006b1) obj3;
                c0006b1.getClass();
                c0006b1.D1 = System.currentTimeMillis();
                C0006b1.Z0(str);
                c0006b1.h1();
                new Thread(new G(i2, str)).start();
                C0006b1.g0(c0006b1, (LinearLayout) obj2);
                return b.d.f770c;
            case 1:
                O2 o2 = (O2) obj;
                ((B1) obj3).b(o2.f241a, new C0028h((C0091y1) obj2, o2, 2));
                return b.d.f770c;
            case 2:
                String str2 = (String) obj;
                C0091y1 c0091y1 = (C0091y1) obj3;
                O2 o22 = (O2) obj2;
                if (str2.length() == 0) {
                    c0091y1.f721b.remove(o22);
                } else {
                    o22.f241a = str2;
                }
                c0091y1.invalidate();
                return b.d.f770c;
            default:
                String str3 = (String) obj;
                int i3 = MainActivity.R;
                JSONArray jSONArray = (JSONArray) obj3;
                Iterable B = AbstractC0008c.B(0, jSONArray.length());
                MainActivity mainActivity = (MainActivity) obj2;
                if (!(B instanceof Collection) || !((Collection) B).isEmpty()) {
                    Iterator it = B.iterator();
                    while (((k.b) it).f857c) {
                        k.b bVar = (k.b) it;
                        int i4 = bVar.f858d;
                        if (i4 != bVar.f856b) {
                            bVar.f858d = bVar.f855a + i4;
                        } else {
                            if (!bVar.f857c) {
                                throw new NoSuchElementException();
                            }
                            bVar.f857c = false;
                        }
                        if (m.m.F(jSONArray.getJSONObject(i4).optString("name"), str3)) {
                            mainActivity.T("Instance already exists");
                            return b.d.f770c;
                        }
                    }
                }
                new Thread(new O1(0, mainActivity, str3)).start();
                return b.d.f770c;
        }
    }
}
