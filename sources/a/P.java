package a;

/* loaded from: classes.dex */
public final /* synthetic */ class P implements h.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f246a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f247b;

    public /* synthetic */ P(long j2, int i2) {
        this.f246a = i2;
        this.f247b = j2;
    }

    @Override // h.b
    public final Object a(Object obj) {
        K0 k0 = (K0) obj;
        switch (this.f246a) {
            case 0:
                return Boolean.valueOf(k0.f150a == this.f247b);
            case 1:
                return Boolean.valueOf(k0.f150a == this.f247b);
            default:
                return Boolean.valueOf(k0.f150a == this.f247b);
        }
    }
}
