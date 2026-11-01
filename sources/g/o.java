package g;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class o implements Iterator, j.a {

    /* renamed from: a, reason: collision with root package name */
    public String f835a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f836b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p f837c;

    public o(p pVar) {
        this.f837c = pVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f835a == null && !this.f836b) {
            String readLine = this.f837c.f838a.readLine();
            this.f835a = readLine;
            if (readLine == null) {
                this.f836b = true;
            }
        }
        return this.f835a != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        String str = this.f835a;
        this.f835a = null;
        i.b.b(str);
        return str;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
