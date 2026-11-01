package g;

import java.io.BufferedReader;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class p implements l.c {

    /* renamed from: a, reason: collision with root package name */
    public final BufferedReader f838a;

    public p(BufferedReader bufferedReader) {
        this.f838a = bufferedReader;
    }

    @Override // l.c
    public final Iterator iterator() {
        return new o(this);
    }
}
