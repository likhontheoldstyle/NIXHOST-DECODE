package n;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

/* loaded from: classes.dex */
public final class f extends a {

    /* renamed from: b, reason: collision with root package name */
    public final c f886b = new c();

    public f() {
        new c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // n.a
    public final byte[] a(int i2) {
        d dVar;
        Object obj;
        c cVar = this.f886b;
        Object obj2 = null;
        if (i2 >= 32768) {
            synchronized (cVar) {
                dVar = (d) cVar.get(Integer.valueOf(i2));
            }
            if (dVar != null) {
                while (true) {
                    synchronized (dVar) {
                        Object[] objArr = dVar.f883a;
                        int i3 = dVar.f884b;
                        obj = objArr[i3];
                        objArr[i3] = null;
                        dVar.f884b = (i3 - 1) & 511;
                    }
                    Reference reference = (Reference) obj;
                    if (reference == null) {
                        break;
                    }
                    Object obj3 = reference.get();
                    if (obj3 != null) {
                        obj2 = obj3;
                        break;
                    }
                }
            }
        }
        byte[] bArr = (byte[]) obj2;
        return bArr == null ? new byte[i2] : bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // n.a
    public final void b(byte[] bArr) {
        d dVar;
        c cVar = this.f886b;
        int length = bArr.length;
        if (length < 32768) {
            return;
        }
        synchronized (cVar) {
            try {
                dVar = (d) cVar.get(Integer.valueOf(length));
                if (dVar == null) {
                    dVar = new d();
                    cVar.put(Integer.valueOf(length), dVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        SoftReference softReference = new SoftReference(bArr);
        synchronized (dVar) {
            int i2 = (dVar.f884b + 1) & 511;
            dVar.f884b = i2;
            dVar.f883a[i2] = softReference;
        }
    }
}
