package i;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class a implements Iterator, j.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f842a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f843b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f844c;

    public a(Object[] objArr) {
        b.e(objArr, "array");
        this.f844c = objArr;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Iterator it;
        switch (this.f842a) {
            case 0:
                return this.f843b < ((Object[]) this.f844c).length;
        }
        while (true) {
            int i2 = this.f843b;
            it = (Iterator) this.f844c;
            if (i2 > 0 && it.hasNext()) {
                it.next();
                this.f843b--;
            }
        }
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Iterator it;
        switch (this.f842a) {
            case 0:
                try {
                    Object[] objArr = (Object[]) this.f844c;
                    int i2 = this.f843b;
                    this.f843b = i2 + 1;
                    return objArr[i2];
                } catch (ArrayIndexOutOfBoundsException e2) {
                    this.f843b--;
                    throw new NoSuchElementException(e2.getMessage());
                }
        }
        while (true) {
            int i3 = this.f843b;
            it = (Iterator) this.f844c;
            if (i3 > 0 && it.hasNext()) {
                it.next();
                this.f843b--;
            }
        }
        return it.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f842a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public a(l.b bVar) {
        this.f844c = bVar.f861a.iterator();
        this.f843b = bVar.f862b;
    }
}
