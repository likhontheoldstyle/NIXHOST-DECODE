package a;

/* loaded from: classes.dex */
public final /* synthetic */ class u2 implements h.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f673a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i.f f674b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i.f f675c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i.e f676d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h.b f677e;

    public /* synthetic */ u2(long j2, i.f fVar, i.f fVar2, i.e eVar, C0001a0 c0001a0) {
        this.f673a = j2;
        this.f674b = fVar;
        this.f675c = fVar2;
        this.f676d = eVar;
        this.f677e = c0001a0;
    }

    @Override // h.b
    public final Object a(Object obj) {
        y2.o(this.f674b, this.f675c, this.f676d, this.f677e, Math.min(((Long) obj).longValue(), this.f673a) * 0.6d);
        return b.d.f770c;
    }
}
