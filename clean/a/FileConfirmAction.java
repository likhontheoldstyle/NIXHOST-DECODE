package a;

import com.nix.host.MainActivity;
import java.io.File;

public final class FileConfirmAction implements h.a {

    public final int mode;

    public final MainActivity activity;

    public final File file;

    public FileConfirmAction(MainActivity mainActivity, File file, int i2) {
        this.mode = i2;
        this.activity = mainActivity;
        this.file = file;
    }

    @Override
    public final Object a() {
        int i2 = 4;
        File file = this.file;
        MainActivity mainActivity = this.activity;
        switch (this.mode) {
            case 0:
                int i3 = MainActivity.R;
                file.delete();
                mainActivity.toast("Deleted");
                mainActivity.showFiles();
                break;
            case 1:
                int i4 = MainActivity.R;
                mainActivity.showFileView(file);
                break;
            case 2:
                int i5 = MainActivity.R;
                g.m.E(file);
                mainActivity.showFiles();
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
                    mainActivity.toast("Unzipping " + file.getName() + " ...");
                    new Thread(new BackgroundTask(file2, file, mainActivity, i2)).start();
                }
                break;
        }
        return b.d.f770c;
    }

    public FileConfirmAction(File file, MainActivity mainActivity, int i2) {
        this.mode = i2;
        this.file = file;
        this.activity = mainActivity;
    }
}
