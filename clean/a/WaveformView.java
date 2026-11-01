package a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import java.util.List;

public final class WaveformView extends View {

    public final float barWidth;

    public final float barGap;

    public List values;

    public float progress;

    public int fgColor;

    public boolean live;

    public boolean cursor;

    public final Paint paint;

    public WaveformView(Context context, float f2, float f3) {
        super(context);
        this.barWidth = f2;
        this.barGap = f3;
        this.values = c.j.f773a;
        this.fgColor = -1;
        this.paint = new Paint(1);
    }

    public final boolean getCursor() {
        return this.cursor;
    }

    public final int getFg() {
        return this.fgColor;
    }

    public final boolean getLive() {
        return this.live;
    }

    public final float getProgress() {
        return this.progress;
    }

    public final List<Integer> getValues() {
        return this.values;
    }

    @Override

    public final void onDraw(Canvas canvas) {
        Paint paint;
        int intValue;
        List list;
        boolean z;
        float width = getWidth();
        float height = getHeight();
        if (width <= 0.0f) {
            return;
        }
        float f2 = this.barWidth;
        float f3 = this.barGap;
        float f4 = f2 + f3;
        float f5 = this.cursor ? 2.6f * f2 : 0.0f;
        float f6 = width - (f5 * 2.0f);
        int i2 = 1;
        int max = Math.max(1, (int) ((f6 + f3) / f4));
        float f7 = max;
        float f8 = ((f6 - ((f7 * f4) - f3)) / 2.0f) + f5;
        List list2 = this.values;
        int i3 = 0;
        while (true) {
            paint = this.paint;
            if (i3 >= max) {
                break;
            }
            if (this.live) {
                int size = (list2.size() - max) + i3;
                if (size >= 0) {
                    intValue = ((Number) list2.get(size)).intValue();
                    i2 = 0;
                }
                intValue = 0;
            } else if (((list2.isEmpty() ? 1 : 0) ^ i2) != 0) {
                intValue = ((Number) list2.get(Math.min(list2.size() - i2, (list2.size() * i3) / max))).intValue();
                i2 = 0;
            } else {
                i2 = 0;
                intValue = 0;
            }
            float max2 = (i2 != 0 || intValue < 10) ? f2 : Math.max(1.6f * f2, (intValue / 100.0f) * height * 0.95f);
            if (this.live) {
                list = list2;
            } else {
                list = list2;
                if (i3 >= this.progress * f7) {
                    z = false;
                    paint.setColor(this.fgColor);
                    paint.setAlpha(i2 == 0 ? 150 : z ? 255 : 120);
                    float f9 = (i3 * f4) + f8;
                    canvas.drawRoundRect(new RectF(f9, (height - max2) / 2.0f, f9 + f2, (max2 + height) / 2.0f), f2 / 2.0f, f2 / 2.0f, paint);
                    i3++;
                    list2 = list;
                    f4 = f4;
                    i2 = 1;
                }
            }
            z = true;
            paint.setColor(this.fgColor);
            paint.setAlpha(i2 == 0 ? 150 : z ? 255 : 120);
            float f92 = (i3 * f4) + f8;
            canvas.drawRoundRect(new RectF(f92, (height - max2) / 2.0f, f92 + f2, (max2 + height) / 2.0f), f2 / 2.0f, f2 / 2.0f, paint);
            i3++;
            list2 = list;
            f4 = f4;
            i2 = 1;
        }
        if (this.cursor) {
            float max3 = Math.max(3.0f, f2 * 0.45f);
            float f10 = f5 * 0.4f;
            float f11 = width - f10;
            float f12 = ((f11 - f10) * this.progress) + f10;
            paint.setColor(this.fgColor);
            paint.setAlpha(255);
            float f13 = max3 / 2.0f;
            float f14 = 0.06f * height;
            float f15 = height * 0.94f;
            canvas.drawRoundRect(new RectF(f11 - f13, f14, f11 + f13, f15), f13, f13, paint);
            canvas.drawRoundRect(new RectF(f12 - f13, f14, f12 + f13, f15), f13, f13, paint);
        }
    }

    public final void setCursor(boolean z) {
        this.cursor = z;
    }

    public final void setFg(int i2) {
        this.fgColor = i2;
    }

    public final void setLive(boolean z) {
        this.live = z;
    }

    public final void setProgress(float f2) {
        this.progress = f2;
    }

    public final void setValues(List<Integer> list) {
        this.values = list;
    }
}
