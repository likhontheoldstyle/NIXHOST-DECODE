package a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import java.util.HashMap;

public final class ThemedBackgroundView extends View {

    public final int fallbackColor;

    public final Paint paint;

    public final Bitmap themeBitmap;

    public ThemedBackgroundView(Context context, ChatTheme chatTheme, int i2, int i3, int i4) {
        super(context);
        Bitmap bitmap;
        this.fallbackColor = i2;
        this.paint = new Paint(2);
        if (chatTheme != null) {
            HashMap hashMap = ThemeBackgroundPainter.bitmapCache;
            String str = chatTheme.id + "|" + i3 + "x" + i4;
            HashMap hashMap2 = ThemeBackgroundPainter.bitmapCache;
            bitmap = (Bitmap) hashMap2.get(str);
            if (bitmap == null) {
                if (hashMap2.size() > 26) {
                    hashMap2.clear();
                }
                bitmap = Bitmap.createBitmap(i3 < 1 ? 1 : i3, i4 < 1 ? 1 : i4, Bitmap.Config.ARGB_8888);
                ThemeBackgroundPainter.drawBackground(chatTheme, new Canvas(bitmap), bitmap.getWidth(), bitmap.getHeight());
                hashMap2.put(str, bitmap);
            }
        } else {
            bitmap = null;
        }
        this.themeBitmap = bitmap;
    }

    @Override
    public final void onDraw(Canvas canvas) {
        Bitmap bitmap = this.themeBitmap;
        if (bitmap == null) {
            canvas.drawColor(this.fallbackColor);
            return;
        }
        float max = Math.max(getWidth() / bitmap.getWidth(), getHeight() / bitmap.getHeight());
        float width = bitmap.getWidth() * max;
        float height = bitmap.getHeight() * max;
        float width2 = (getWidth() - width) / 2.0f;
        canvas.drawBitmap(bitmap, (Rect) null, new RectF(width2, 0.0f, width + width2, height), this.paint);
    }
}
