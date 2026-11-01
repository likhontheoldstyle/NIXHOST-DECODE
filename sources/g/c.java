package g;

import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final File f808a;

    /* renamed from: b, reason: collision with root package name */
    public final List f809b;

    public c(File file, List list) {
        this.f808a = file;
        this.f809b = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return i.b.a(this.f808a, cVar.f808a) && i.b.a(this.f809b, cVar.f809b);
    }

    public final int hashCode() {
        return this.f809b.hashCode() + (this.f808a.hashCode() * 31);
    }

    public final String toString() {
        return "FilePathComponents(root=" + this.f808a + ", segments=" + this.f809b + ')';
    }
}
