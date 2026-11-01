package a;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

public final class TopRoundedOutlineProvider extends ViewOutlineProvider {

    public final int mode;

    public final float radius;

    public TopRoundedOutlineProvider(float f2, int i2) {
        this.mode = i2;
        this.radius = f2;
    }

    @Override
    public final void getOutline(View view, Outline outline) {
        switch (this.mode) {
            case 0:
                int width = view.getWidth();
                int height = view.getHeight();
                float f2 = this.radius;
                outline.setRoundRect(0, 0, width, height + ((int) f2), f2);
                break;
            default:
                int width2 = view.getWidth();
                int height2 = view.getHeight();
                float f3 = this.radius;
                outline.setRoundRect(0, 0, width2, height2 + ((int) f3), f3);
                break;
        }
    }
}
