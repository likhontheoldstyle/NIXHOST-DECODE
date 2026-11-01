package a;

import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;

/* loaded from: classes.dex */
public final class T0 extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f318a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f319b;

    public /* synthetic */ T0(int i2, Object obj) {
        this.f318a = i2;
        this.f319b = obj;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        switch (this.f318a) {
            case 0:
                Path path = new Path();
                path.addRoundRect(new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight()), (float[]) this.f319b, Path.Direction.CW);
                outline.setConvexPath(path);
                break;
            default:
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ((C0006b1) this.f319b).z(14.0f));
                break;
        }
    }
}
