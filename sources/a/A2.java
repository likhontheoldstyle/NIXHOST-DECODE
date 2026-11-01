package a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

/* loaded from: classes.dex */
public final class A2 extends View {

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f15a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f16b;

    /* renamed from: c, reason: collision with root package name */
    public final Path f17c;

    public A2(Context context) {
        super(context);
        this.f16b = new Paint(1);
        this.f17c = new Path();
    }

    public final Bitmap getBmp() {
        return this.f15a;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float width = getWidth();
        float height = getHeight();
        float min = Math.min(width, height) / 2.0f;
        if (min <= 0.0f) {
            return;
        }
        float f2 = width / 2.0f;
        float f3 = height / 2.0f;
        Path path = this.f17c;
        path.reset();
        path.addCircle(f2, f3, min, Path.Direction.CW);
        canvas.save();
        canvas.clipPath(path);
        Bitmap bitmap = this.f15a;
        Paint paint = this.f16b;
        if (bitmap != null) {
            int min2 = Math.min(bitmap.getWidth(), bitmap.getHeight());
            int width2 = (bitmap.getWidth() - min2) / 2;
            int height2 = (bitmap.getHeight() - min2) / 2;
            canvas.drawBitmap(bitmap, new Rect(width2, height2, width2 + min2, min2 + height2), new RectF(f2 - min, f3 - min, f2 + min, f3 + min), paint);
        } else {
            float f4 = min * 2.0f;
            float f5 = f2 - min;
            float f6 = f3 - min;
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(-1775893);
            canvas.drawCircle(f2, f3, min, paint);
            paint.setColor(-9473159);
            canvas.drawOval(new RectF((0.345f * f4) + f5, (0.25f * f4) + f6, (0.655f * f4) + f5, (0.6f * f4) + f6), paint);
            canvas.drawOval(new RectF((0.15f * f4) + f5, (0.67f * f4) + f6, (0.85f * f4) + f5, (f4 * 1.33f) + f6), paint);
        }
        canvas.restore();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Math.max(1.0f, 0.035f * min));
        paint.setColor(-4407100);
        canvas.drawCircle(f2, f3, min - (paint.getStrokeWidth() / 2.0f), paint);
    }

    public final void setBmp(Bitmap bitmap) {
        this.f15a = bitmap;
    }
}
