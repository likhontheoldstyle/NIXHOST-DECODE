package a;

import java.io.File;
import java.io.FileFilter;

public final class FileFilters implements FileFilter {

    public final int mode;

    public FileFilters(int i2) {
        this.mode = i2;
    }

    @Override
    public final boolean accept(File file) {
        switch (this.mode) {
            case 0:
                return file.isDirectory() && m.m.K(file.getName(), "python3");
            case 1:
                return file.isDirectory() && m.m.K(file.getName(), "python3");
            default:
                return m.m.E(file.getName(), ".run");
        }
    }
}
