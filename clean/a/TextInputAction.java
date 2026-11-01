package a;

import android.widget.LinearLayout;
import com.nix.host.MainActivity;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.json.JSONArray;

public final class TextInputAction implements h.b {

    public final int mode;

    public final Object first;

    public final Object second;

    public TextInputAction(Object obj, Object obj2, int i2) {
        this.mode = i2;
        this.first = obj;
        this.second = obj2;
    }

    @Override
    public final Object a(Object obj) {
        int i2 = 0;
        Object obj2 = this.second;
        Object obj3 = this.first;
        switch (this.mode) {
            case 0:
                String str = (String) obj;
                ChatScreen chatScreen = (ChatScreen) obj3;
                chatScreen.getClass();
                chatScreen.lastQuickReactionAt = System.currentTimeMillis();
                ChatScreen.saveQuickReaction(str);
                chatScreen.updateSendButton();
                new Thread(new TaskRunnable(i2, str)).start();
                ChatScreen.buildGroupInfo(chatScreen, (LinearLayout) obj2);
                return b.d.f770c;
            case 1:
                O2 o2 = (O2) obj;
                ((B1) obj3).b(o2.f241a, new TextInputAction((C0091y1) obj2, o2, 2));
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
                Iterable B = AppState.B(0, jSONArray.length());
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
                            mainActivity.toast("Instance already exists");
                            return b.d.f770c;
                        }
                    }
                }
                new Thread(new ApiTask(0, mainActivity, str3)).start();
                return b.d.f770c;
        }
    }
}
