package k;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b implements Iterator, j.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f855a;

    /* renamed from: b, reason: collision with root package name */
    public final int f856b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f857c;

    /* renamed from: d, reason: collision with root package name */
    public int f858d;

    public b(int i2, int i3, int i4) {
        this.f855a = i4;
        this.f856b = i3;
        boolean z = false;
        if (i4 <= 0 ? i2 >= i3 : i2 <= i3) {
            z = true;
        }
        this.f857c = z;
        this.f858d = z ? i2 : i3;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f857c;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i2 = this.f858d;
        if (i2 != this.f856b) {
            this.f858d = this.f855a + i2;
        } else {
            if (!this.f857c) {
                throw new NoSuchElementException();
            }
            this.f857c = false;
        }
        return Integer.valueOf(i2);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
