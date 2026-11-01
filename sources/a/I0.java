package a;

import com.nix.host.MainActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class I0 implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f127a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f128b;

    public /* synthetic */ I0(int i2, Object obj) {
        this.f127a = i2;
        this.f128b = obj;
    }

    @Override // h.a
    public final Object a() {
        switch (this.f127a) {
            case 0:
                ((E2) this.f128b).dismiss();
                return b.d.f770c;
            case 1:
                int i2 = MainActivity.R;
                ((h.a) ((i.g) this.f128b).f850b).a();
                return b.d.f770c;
            default:
                return Boolean.valueOf(((K2) this.f128b).f180n);
        }
    }
}
