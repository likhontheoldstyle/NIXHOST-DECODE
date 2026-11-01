package a;

import android.view.ScaleGestureDetector;
import android.view.View;

/* renamed from: a.x1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0088x1 extends ScaleGestureDetector.SimpleOnScaleGestureListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f711a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f712b;

    public /* synthetic */ C0088x1(View view, int i2) {
        this.f711a = i2;
        this.f712b = view;
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        switch (this.f711a) {
            case 0:
                C0091y1 c0091y1 = (C0091y1) this.f712b;
                O2 o2 = c0091y1.f729j;
                if (o2 != null) {
                    o2.f244d = AbstractC0008c.b(scaleGestureDetector.getScaleFactor() * o2.f244d, c0091y1.f720a.getWidth() * 0.03f, c0091y1.f720a.getWidth() * 0.4f);
                }
                c0091y1.invalidate();
                break;
            default:
                R2.a((R2) this.f712b, scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                break;
        }
        return true;
    }
}
