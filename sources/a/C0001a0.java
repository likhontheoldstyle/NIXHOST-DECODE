package a;

import android.graphics.Bitmap;
import android.graphics.Paint;
import com.nix.host.MainActivity;

/* renamed from: a.a0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0001a0 implements h.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f402a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f403b;

    public /* synthetic */ C0001a0(int i2, Object obj) {
        this.f402a = i2;
        this.f403b = obj;
    }

    @Override // h.b
    public final Object a(Object obj) {
        C0091y1 c0091y1;
        switch (this.f402a) {
            case 0:
                break;
            case 1:
                String str = (String) obj;
                if (str.length() > 0 && (c0091y1 = ((B1) this.f403b).F) != null) {
                    Bitmap bitmap = c0091y1.f720a;
                    O2 o2 = new O2(str, bitmap.getHeight() * 0.5f, bitmap.getWidth() * 0.09f, c0091y1.f723d);
                    c0091y1.c(o2);
                    Paint paint = c0091y1.f727h;
                    float measureText = paint.measureText(str);
                    if (measureText > bitmap.getWidth() * 0.9f) {
                        o2.f244d = ((o2.f244d * bitmap.getWidth()) * 0.9f) / measureText;
                    }
                    c0091y1.c(o2);
                    o2.f242b = (bitmap.getWidth() - paint.measureText(str)) / 2.0f;
                    c0091y1.f721b.add(o2);
                    c0091y1.invalidate();
                }
                break;
            case 2:
                int i2 = MainActivity.R;
                ((MainActivity) this.f403b).T((String) obj);
                break;
            default:
                K2 k2 = (K2) this.f403b;
                int intValue = ((Integer) obj).intValue();
                k2.getClass();
                k2.f176j = K2.b(intValue);
                L2.f198a.c();
                break;
        }
        return b.d.f770c;
    }
}
