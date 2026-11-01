package a;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public final /* synthetic */ class B0 implements h.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f23a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f24b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f25c;

    public /* synthetic */ B0(C0006b1 c0006b1, FrameLayout frameLayout, int i2) {
        this.f23a = i2;
        this.f24b = c0006b1;
        this.f25c = frameLayout;
    }

    @Override // h.b
    public final Object a(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        switch (this.f23a) {
            case 0:
                LinearLayout.LayoutParams q0 = this.f24b.q0(bitmap.getWidth() / bitmap.getHeight());
                FrameLayout frameLayout = this.f25c;
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                if (layoutParams == null || layoutParams.width != q0.width || layoutParams.height != q0.height) {
                    frameLayout.setLayoutParams(q0);
                }
                break;
            default:
                LinearLayout.LayoutParams U0 = this.f24b.U0(bitmap.getWidth() / bitmap.getHeight());
                FrameLayout frameLayout2 = this.f25c;
                ViewGroup.LayoutParams layoutParams2 = frameLayout2.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.width != U0.width || layoutParams2.height != U0.height) {
                    frameLayout2.setLayoutParams(U0);
                }
                break;
        }
        return b.d.f770c;
    }
}
