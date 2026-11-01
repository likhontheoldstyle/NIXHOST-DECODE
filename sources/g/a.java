package g;

import java.io.File;

/* loaded from: classes.dex */
public final class a extends d {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(File file, int i2) {
        super(file, null, "Cannot list files in a directory");
        switch (i2) {
            case 2:
                i.b.e(file, "file");
                super(file, null, "The source file doesn't exist.");
                break;
            default:
                i.b.e(file, "file");
                break;
        }
    }
}
