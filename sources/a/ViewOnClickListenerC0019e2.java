package a;

import android.content.SharedPreferences;
import android.view.View;
import com.nix.host.MainActivity;

/* renamed from: a.e2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class ViewOnClickListenerC0019e2 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f469a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f470b;

    public /* synthetic */ ViewOnClickListenerC0019e2(MainActivity mainActivity, int i2) {
        this.f469a = i2;
        this.f470b = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MainActivity mainActivity = this.f470b;
        switch (this.f469a) {
            case 0:
                int i2 = MainActivity.R;
                boolean z = !AbstractC0008c.f442e;
                AbstractC0008c.f442e = z;
                String str = z ? "1" : "0";
                SharedPreferences sharedPreferences = AbstractC0008c.f440c;
                if (sharedPreferences == null) {
                    i.b.g("sp");
                    throw null;
                }
                sharedPreferences.edit().putString("dark", str).apply();
                if (i.b.a(mainActivity.f784d, "files")) {
                    mainActivity.L();
                    return;
                } else {
                    mainActivity.N();
                    return;
                }
            case 1:
                int i3 = MainActivity.R;
                mainActivity.i();
                return;
            default:
                int i4 = MainActivity.R;
                mainActivity.j();
                return;
        }
    }
}
