package a;

import android.graphics.Path;

public final class BrushStroke {

    public final Path path;

    public final int color;

    public final float strokeWidth;

    public BrushStroke(Path path, int i2, float f2) {
        this.path = path;
        this.color = i2;
        this.strokeWidth = f2;
    }
}
