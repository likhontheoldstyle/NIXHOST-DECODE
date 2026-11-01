package a;

import com.nix.host.MainActivity;
import java.io.File;

/* loaded from: classes.dex */
public final /* synthetic */ class S1 implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f308a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f309b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ File f310c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0038j1 f311d;

    public /* synthetic */ S1(MainActivity mainActivity, File file, C0038j1 c0038j1) {
        this.f309b = mainActivity;
        this.f310c = file;
        this.f311d = c0038j1;
    }

    @Override // h.a
    public final Object a() {
        C0038j1 c0038j1 = this.f311d;
        File file = this.f310c;
        MainActivity mainActivity = this.f309b;
        switch (this.f308a) {
            case 0:
                int i2 = MainActivity.R;
                try {
                    g.m.L(file, c0038j1.getText().toString());
                    mainActivity.T("Saved");
                } catch (Exception unused) {
                    mainActivity.T("Save failed");
                }
                mainActivity.S(file);
                break;
            default:
                int i3 = MainActivity.R;
                mainActivity.s();
                mainActivity.k(J0.a("Update ", file.getName()), new S1(file, c0038j1, mainActivity));
                break;
        }
        return b.d.f770c;
    }

    public /* synthetic */ S1(File file, C0038j1 c0038j1, MainActivity mainActivity) {
        this.f310c = file;
        this.f311d = c0038j1;
        this.f309b = mainActivity;
    }
}
