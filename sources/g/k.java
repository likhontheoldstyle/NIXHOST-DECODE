package g;

import java.io.File;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class k implements l.c {

    /* renamed from: a, reason: collision with root package name */
    public final File f825a;

    /* renamed from: b, reason: collision with root package name */
    public final l f826b;

    /* renamed from: c, reason: collision with root package name */
    public final h.b f827c = null;

    /* renamed from: d, reason: collision with root package name */
    public final h.b f828d = null;

    /* renamed from: e, reason: collision with root package name */
    public final h.c f829e;

    /* renamed from: f, reason: collision with root package name */
    public final int f830f;

    public k(File file, l lVar, n nVar, int i2) {
        this.f825a = file;
        this.f826b = lVar;
        this.f829e = nVar;
        this.f830f = i2;
    }

    @Override // l.c
    public final Iterator iterator() {
        return new i(this);
    }
}
