package a;

import com.nix.host.MainActivity;
import java.io.File;

/* renamed from: a.d2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0015d2 implements h.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f450a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ File f451b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MainActivity f452c;

    public /* synthetic */ C0015d2(MainActivity mainActivity, File file) {
        this.f450a = 2;
        this.f452c = mainActivity;
        this.f451b = file;
    }

    @Override // h.b
    public final Object a(Object obj) {
        File file = this.f451b;
        MainActivity mainActivity = this.f452c;
        String str = (String) obj;
        switch (this.f450a) {
            case 0:
                int i2 = MainActivity.R;
                File file2 = new File(file, str);
                if (m.e.L(str)) {
                    mainActivity.T("Invalid name");
                } else if (file2.exists()) {
                    mainActivity.T("Already exists");
                } else {
                    try {
                        g.m.L(file2, "");
                        mainActivity.K(file2);
                    } catch (Exception unused) {
                        mainActivity.T("Cannot create file");
                    }
                }
                break;
            case 1:
                int i3 = MainActivity.R;
                File file3 = new File(file, str);
                if (m.e.L(str)) {
                    mainActivity.T("Invalid name");
                } else if (file3.exists()) {
                    mainActivity.T("Already exists");
                } else {
                    file3.mkdirs();
                    mainActivity.L();
                }
                break;
            default:
                int i4 = MainActivity.R;
                if (m.e.L(str)) {
                    mainActivity.T("Invalid name");
                } else if (!str.equals(file.getName()) && new File(file.getParentFile(), str).exists()) {
                    mainActivity.T("Already exists");
                } else if (!file.renameTo(new File(file.getParentFile(), str))) {
                    mainActivity.T("Rename failed");
                }
                mainActivity.L();
                break;
        }
        return b.d.f770c;
    }

    public /* synthetic */ C0015d2(File file, MainActivity mainActivity, int i2) {
        this.f450a = i2;
        this.f451b = file;
        this.f452c = mainActivity;
    }
}
