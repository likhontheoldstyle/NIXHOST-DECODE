package a;

import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;

public final class RoundedOutlineProvider extends ViewOutlineProvider {

    public final int mode;

    public final Object target;

    public RoundedOutlineProvider(int i2, Object obj) {
        this.mode = i2;
        this.target = obj;
    }

    @Override
    public final void getOutline(View view, Outline outline) {
        switch (this.mode) {
            case 0:
                Path path = new Path();
                path.addRoundRect(new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight()), (float[]) this.target, Path.Direction.CW);
                outline.setConvexPath(path);
                break;
            default:
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ((ChatScreen) this.target).dp(14.0f));
                break;
        }
    }
}
