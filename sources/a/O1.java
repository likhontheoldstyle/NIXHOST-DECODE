package a;

import com.nix.host.MainActivity;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final /* synthetic */ class O1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f238a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f239b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MainActivity f240c;

    public /* synthetic */ O1(int i2, MainActivity mainActivity, String str) {
        this.f238a = i2;
        this.f239b = str;
        this.f240c = mainActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0004b c0004b = C0004b.f409a;
        MainActivity mainActivity = this.f240c;
        String str = this.f239b;
        switch (this.f238a) {
            case 0:
                int i2 = MainActivity.R;
                mainActivity.runOnUiThread(new U(C0004b.b(c0004b, "POST", "/instances", new JSONObject().put("name", str), 8), mainActivity, 5));
                break;
            case 1:
                int i3 = MainActivity.R;
                if (!i.b.a(str, "badsession")) {
                    mainActivity.o();
                    if (i.b.a(str, "ok")) {
                        mainActivity.w();
                        break;
                    }
                } else {
                    mainActivity.u();
                    break;
                }
                break;
            case 2:
                int i4 = MainActivity.R;
                if (!i.b.a(str, "badsession")) {
                    mainActivity.o();
                    if (i.b.a(str, "ok")) {
                        mainActivity.w();
                        break;
                    }
                } else {
                    mainActivity.u();
                    break;
                }
                break;
            case 3:
                int i5 = MainActivity.R;
                StringBuilder sb = new StringBuilder("/instances/");
                String str2 = this.f239b;
                sb.append(str2);
                C0000a b2 = C0004b.b(c0004b, "DELETE", sb.toString(), null, 12);
                MainActivity mainActivity2 = this.f240c;
                mainActivity2.runOnUiThread(new RunnableC0056o((Object) b2, (Object) mainActivity2, (Object) str2, 5, false));
                break;
            default:
                if (!i.b.a(str, "badsession")) {
                    int i6 = MainActivity.R;
                    mainActivity.o();
                    if (i.b.a(str, "ok")) {
                        mainActivity.w();
                        break;
                    }
                } else {
                    int i7 = MainActivity.R;
                    mainActivity.u();
                    break;
                }
                break;
        }
    }
}
