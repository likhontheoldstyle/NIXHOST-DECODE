package g;

import a.C0031h2;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public final class n extends i.c implements h.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h.c f834a;

    public n(C0031h2 c0031h2) {
        this.f834a = c0031h2;
    }

    @Override // h.c
    public final Object a(Object obj, Object obj2) {
        File file = (File) obj;
        i.b.e(file, "f");
        if (this.f834a.a(file, (IOException) obj2) != q.f840b) {
            return b.d.f770c;
        }
        throw new r(file, null, null);
    }
}
