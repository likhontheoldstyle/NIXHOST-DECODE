package a;

import java.io.File;
import java.io.FileFilter;

/* loaded from: classes.dex */
public final /* synthetic */ class t2 implements FileFilter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f665a;

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        switch (this.f665a) {
            case 0:
                return file.isDirectory() && m.m.K(file.getName(), "python3");
            case 1:
                return file.isDirectory() && m.m.K(file.getName(), "python3");
            default:
                return m.m.E(file.getName(), ".run");
        }
    }
}
