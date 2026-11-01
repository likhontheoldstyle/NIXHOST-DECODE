package a;

import android.content.Intent;
import android.net.Uri;
import com.nix.host.MainActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class X1 implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f373a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f374b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f375c;

    public /* synthetic */ X1(int i2, MainActivity mainActivity, String str) {
        this.f373a = i2;
        this.f374b = mainActivity;
        this.f375c = str;
    }

    @Override // h.a
    public final Object a() {
        MainActivity mainActivity = this.f374b;
        String str = this.f375c;
        switch (this.f373a) {
            case 0:
                int i2 = MainActivity.R;
                mainActivity.B(str);
                break;
            case 1:
                int i3 = MainActivity.R;
                mainActivity.getClass();
                try {
                    mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception unused) {
                    mainActivity.T("Cannot open the link");
                }
                break;
            case 2:
                int i4 = MainActivity.R;
                mainActivity.B(str);
                break;
            default:
                int i5 = MainActivity.R;
                new Thread(new O1(3, mainActivity, str)).start();
                break;
        }
        return b.d.f770c;
    }

    public /* synthetic */ X1(MainActivity mainActivity, String str) {
        this.f373a = 3;
        this.f375c = str;
        this.f374b = mainActivity;
    }
}
