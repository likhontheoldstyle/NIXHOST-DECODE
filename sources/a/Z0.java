package a;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* loaded from: classes.dex */
public final class Z0 extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f392a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f393b;

    public /* synthetic */ Z0(float f2, int i2) {
        this.f392a = i2;
        this.f393b = f2;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        switch (this.f392a) {
            case 0:
                int width = view.getWidth();
                int height = view.getHeight();
                float f2 = this.f393b;
                outline.setRoundRect(0, 0, width, height + ((int) f2), f2);
                break;
            default:
                int width2 = view.getWidth();
                int height2 = view.getHeight();
                float f3 = this.f393b;
                outline.setRoundRect(0, 0, width2, height2 + ((int) f3), f3);
                break;
        }
    }
}
