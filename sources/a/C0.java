package a;

import android.content.SharedPreferences;
import com.nix.host.MainActivity;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final /* synthetic */ class C0 implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f51a;

    public /* synthetic */ C0(int i2) {
        this.f51a = i2;
    }

    @Override // h.a
    public final Object a() {
        switch (this.f51a) {
            case 0:
                return b.d.f770c;
            case 1:
                HashSet hashSet = new HashSet();
                SharedPreferences sharedPreferences = AbstractC0008c.f440c;
                if (sharedPreferences == null) {
                    i.b.g("sp");
                    throw null;
                }
                String string = sharedPreferences.getString("hidden_msgs", "");
                Iterator it = m.e.b0(string != null ? string : "", new String[]{" "}).iterator();
                while (it.hasNext()) {
                    Long D = m.l.D((String) it.next());
                    if (D != null) {
                        hashSet.add(Long.valueOf(D.longValue()));
                    }
                }
                return hashSet;
            default:
                int i2 = MainActivity.R;
                return b.d.f770c;
        }
    }
}
