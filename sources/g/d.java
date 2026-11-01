package g;

import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class d extends IOException {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d(File file, File file2, String str) {
        super(r3);
        i.b.e(file, "file");
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": ".concat(str));
        }
        String sb2 = sb.toString();
        i.b.d(sb2, "toString(...)");
    }
}
