package g;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class i implements Iterator, j.a {

    /* renamed from: a, reason: collision with root package name */
    public int f820a;

    /* renamed from: b, reason: collision with root package name */
    public Object f821b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayDeque f822c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k f823d;

    public i(k kVar) {
        this.f823d = kVar;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f822c = arrayDeque;
        if (kVar.f825a.isDirectory()) {
            arrayDeque.push(a(kVar.f825a));
        } else {
            if (!kVar.f825a.isFile()) {
                this.f820a = 2;
                return;
            }
            File file = kVar.f825a;
            i.b.e(file, "rootFile");
            arrayDeque.push(new g(file));
        }
    }

    public final e a(File file) {
        int ordinal = this.f823d.f826b.ordinal();
        if (ordinal == 0) {
            return new h(this, file);
        }
        if (ordinal == 1) {
            return new f(this, file);
        }
        throw new b.a();
    }

    public final boolean b() {
        File file;
        File a2;
        this.f820a = 3;
        while (true) {
            ArrayDeque arrayDeque = this.f822c;
            j jVar = (j) arrayDeque.peek();
            if (jVar == null) {
                file = null;
                break;
            }
            a2 = jVar.a();
            if (a2 == null) {
                arrayDeque.pop();
            } else {
                if (a2.equals(jVar.f824a) || !a2.isDirectory() || arrayDeque.size() >= this.f823d.f830f) {
                    break;
                }
                arrayDeque.push(a(a2));
            }
        }
        file = a2;
        if (file != null) {
            this.f821b = file;
            this.f820a = 1;
        } else {
            this.f820a = 2;
        }
        return this.f820a == 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2 = this.f820a;
        if (i2 == 0) {
            return b();
        }
        if (i2 == 1) {
            return true;
        }
        if (i2 == 2) {
            return false;
        }
        throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i2 = this.f820a;
        if (i2 == 1) {
            this.f820a = 0;
            return this.f821b;
        }
        if (i2 == 2 || !b()) {
            throw new NoSuchElementException();
        }
        this.f820a = 0;
        return this.f821b;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
