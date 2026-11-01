package a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* loaded from: classes.dex */
public final class F2 extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f98a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f99b;

    /* renamed from: c, reason: collision with root package name */
    public float f100c;

    public F2(Context context) {
        super(context);
        Paint paint = new Paint(1);
        paint.setColor(-1728053248);
        this.f98a = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(-1);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        this.f99b = paint2;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float min = Math.min(getWidth(), getHeight());
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        canvas.drawCircle(width, height, min / 2.0f, this.f98a);
        Paint paint = this.f99b;
        paint.setStrokeWidth(0.08f * min);
        float f2 = min * 0.27f;
        canvas.drawArc(new RectF(width - f2, height - f2, width + f2, height + f2), this.f100c, 255.0f, false, paint);
        this.f100c = (this.f100c + 8.0f) % 360.0f;
        postInvalidateOnAnimation();
    }
}
