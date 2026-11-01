package a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public final class LoadingSpinnerView extends View {

    public final Paint bgPaint;

    public final Paint arcPaint;

    public float startAngle;

    public LoadingSpinnerView(Context context) {
        super(context);
        Paint paint = new Paint(1);
        paint.setColor(-1728053248);
        this.bgPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(-1);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        this.arcPaint = paint2;
    }

    @Override
    public final void onDraw(Canvas canvas) {
        float min = Math.min(getWidth(), getHeight());
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        canvas.drawCircle(width, height, min / 2.0f, this.bgPaint);
        Paint paint = this.arcPaint;
        paint.setStrokeWidth(0.08f * min);
        float f2 = min * 0.27f;
        canvas.drawArc(new RectF(width - f2, height - f2, width + f2, height + f2), this.startAngle, 255.0f, false, paint);
        this.startAngle = (this.startAngle + 8.0f) % 360.0f;
        postInvalidateOnAnimation();
    }
}
