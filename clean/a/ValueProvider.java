package a;

import android.content.SharedPreferences;
import com.nix.host.MainActivity;
import java.util.HashSet;
import java.util.Iterator;

public final class ValueProvider implements h.a {

    public final int mode;

    public ValueProvider(int i2) {
        this.mode = i2;
    }

    @Override
    public final Object a() {
        switch (this.mode) {
            case 0:
                return b.d.f770c;
            case 1:
                HashSet hashSet = new HashSet();
                SharedPreferences sharedPreferences = AppState.prefs;
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
