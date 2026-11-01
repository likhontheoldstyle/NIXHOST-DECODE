package a;

import com.nix.host.MainActivity;
import java.io.File;

public final class CreateRenameAction implements h.b {

    public final int mode;

    public final File file;

    public final MainActivity activity;

    public CreateRenameAction(MainActivity mainActivity, File file) {
        this.mode = 2;
        this.activity = mainActivity;
        this.file = file;
    }

    @Override
    public final Object a(Object obj) {
        File file = this.file;
        MainActivity mainActivity = this.activity;
        String str = (String) obj;
        switch (this.mode) {
            case 0:
                int i2 = MainActivity.R;
                File file2 = new File(file, str);
                if (m.e.L(str)) {
                    mainActivity.toast("Invalid name");
                } else if (file2.exists()) {
                    mainActivity.toast("Already exists");
                } else {
                    try {
                        g.m.L(file2, "");
                        mainActivity.showEditor(file2);
                    } catch (Exception unused) {
                        mainActivity.toast("Cannot create file");
                    }
                }
                break;
            case 1:
                int i3 = MainActivity.R;
                File file3 = new File(file, str);
                if (m.e.L(str)) {
                    mainActivity.toast("Invalid name");
                } else if (file3.exists()) {
                    mainActivity.toast("Already exists");
                } else {
                    file3.mkdirs();
                    mainActivity.showFiles();
                }
                break;
            default:
                int i4 = MainActivity.R;
                if (m.e.L(str)) {
                    mainActivity.toast("Invalid name");
                } else if (!str.equals(file.getName()) && new File(file.getParentFile(), str).exists()) {
                    mainActivity.toast("Already exists");
                } else if (!file.renameTo(new File(file.getParentFile(), str))) {
                    mainActivity.toast("Rename failed");
                }
                mainActivity.showFiles();
                break;
        }
        return b.d.f770c;
    }

    public CreateRenameAction(File file, MainActivity mainActivity, int i2) {
        this.mode = i2;
        this.file = file;
        this.activity = mainActivity;
    }
}
