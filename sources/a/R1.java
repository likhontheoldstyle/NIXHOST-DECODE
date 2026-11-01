package a;

import com.nix.host.MainActivity;
import java.io.File;

/* loaded from: classes.dex */
public final /* synthetic */ class R1 implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f288a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f289b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ File f290c;

    public /* synthetic */ R1(MainActivity mainActivity, File file, int i2) {
        this.f288a = i2;
        this.f289b = mainActivity;
        this.f290c = file;
    }

    @Override // h.a
    public final Object a() {
        int i2 = 4;
        File file = this.f290c;
        MainActivity mainActivity = this.f289b;
        switch (this.f288a) {
            case 0:
                int i3 = MainActivity.R;
                file.delete();
                mainActivity.T("Deleted");
                mainActivity.L();
                break;
            case 1:
                int i4 = MainActivity.R;
                mainActivity.S(file);
                break;
            case 2:
                int i5 = MainActivity.R;
                g.m.E(file);
                mainActivity.L();
                break;
            default:
                int i6 = MainActivity.R;
                mainActivity.getClass();
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    String substring = file.getName().substring(0, file.getName().length() - 4);
                    i.b.d(substring, "substring(...)");
                    File file2 = new File(parentFile, substring);
                    int i7 = 1;
                    while (file2.exists()) {
                        file2 = new File(parentFile, substring + " (" + i7 + ")");
                        i7++;
                    }
                    mainActivity.T("Unzipping " + file.getName() + " ...");
                    new Thread(new RunnableC0056o(file2, file, mainActivity, i2)).start();
                }
                break;
        }
        return b.d.f770c;
    }

    public /* synthetic */ R1(File file, MainActivity mainActivity, int i2) {
        this.f288a = i2;
        this.f290c = file;
        this.f289b = mainActivity;
    }
}
