package a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;

public final class EditorIconView extends View {

    public final String name;

    public final int color;

    public final int cutColor;

    public final Paint paint;

    public EditorIconView(Context context, String str, int i2, int i3) {
        super(context);
        this.name = str;
        this.color = i2;
        this.cutColor = i3;
        this.paint = new Paint(1);
    }

    public final void drawRoundRect(Canvas canvas, float f2, float f3, float f4, float f5, float f6) {
        canvas.drawRoundRect(new RectF(f2, f3, f4, f5), f6, f6, this.paint);
    }

    public final void drawTriangle(Canvas canvas, float f2, float f3, float f4, float f5, float f6, float f7) {
        Path path = new Path();
        path.moveTo(f2, f3);
        path.lineTo(f4, f5);
        path.lineTo(f6, f7);
        path.close();
        canvas.drawPath(path, this.paint);
    }

    @Override
    public final void onDraw(Canvas canvas) {
        float min = Math.min(getWidth(), getHeight()) / 24.0f;
        canvas.save();
        float f2 = 24.0f * min;
        canvas.translate((getWidth() - f2) / 2.0f, (getHeight() - f2) / 2.0f);
        canvas.scale(min, min);
        Paint paint = this.paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        int i2 = this.color;
        paint.setColor(i2);
        String str = this.name;
        int hashCode = str.hashCode();
        int i3 = this.cutColor;
        switch (hashCode) {
            case -989034367:
                if (str.equals("photos")) {
                    drawRoundRect(canvas, 3.0f, 4.0f, 21.0f, 20.0f, 3.5f);
                    paint.setColor(i3);
                    canvas.drawCircle(8.6f, 9.4f, 1.9f, paint);
                    Path path = new Path();
                    path.moveTo(5.5f, 17.5f);
                    path.lineTo(10.0f, 12.4f);
                    path.lineTo(13.0f, 15.8f);
                    path.lineTo(15.0f, 13.8f);
                    path.lineTo(18.5f, 17.5f);
                    path.close();
                    canvas.drawPath(path, paint);
                    break;
                }
                break;
            case -816678056:
                if (str.equals("videos")) {
                    drawRoundRect(canvas, 3.0f, 5.0f, 21.0f, 19.0f, 3.5f);
                    paint.setColor(i3);
                    drawTriangle(canvas, 10.0f, 8.8f, 10.0f, 15.2f, 15.8f, 12.0f);
                    break;
                }
                break;
            case -196315310:
                if (str.equals("gallery")) {
                    drawRoundRect(canvas, 2.5f, 8.5f, 15.5f, 21.5f, 2.5f);
                    paint.setColor(i3);
                    canvas.drawCircle(6.6f, 12.4f, 1.3f, paint);
                    drawTriangle(canvas, 4.0f, 19.5f, 8.0f, 14.8f, 13.5f, 19.5f);
                    drawRoundRect(canvas, 7.2f, 1.2f, 22.8f, 16.8f, 3.4f);
                    paint.setColor(i2);
                    drawRoundRect(canvas, 8.4f, 2.4f, 21.6f, 15.6f, 2.6f);
                    paint.setColor(i3);
                    drawTriangle(canvas, 12.8f, 6.2f, 12.8f, 11.8f, 17.6f, 9.0f);
                    break;
                }
                break;
            case 3104:
                if (str.equals("aa")) {
                    paint.setTextAlign(Paint.Align.CENTER);
                    paint.setTypeface(Typeface.DEFAULT_BOLD);
                    paint.setTextSize(15.0f);
                    canvas.drawText("Aa", 12.0f, 17.0f, paint);
                    break;
                }
                break;
            case 98255:
                if (str.equals("cam")) {
                    drawRoundRect(canvas, 2.5f, 6.5f, 21.5f, 20.0f, 3.0f);
                    drawTriangle(canvas, 7.6f, 7.2f, 9.6f, 4.0f, 16.4f, 7.2f);
                    drawRoundRect(canvas, 9.2f, 4.0f, 14.8f, 7.5f, 1.0f);
                    paint.setColor(i3);
                    canvas.drawCircle(12.0f, 13.2f, 4.6f, paint);
                    paint.setColor(i2);
                    canvas.drawCircle(12.0f, 13.2f, 2.7f, paint);
                    break;
                }
                break;
            case 110873:
                if (str.equals("pen")) {
                    Path path2 = new Path();
                    path2.moveTo(3.8f, 20.2f);
                    path2.lineTo(4.6f, 15.6f);
                    path2.lineTo(15.4f, 4.8f);
                    path2.lineTo(19.2f, 8.6f);
                    path2.lineTo(8.4f, 19.4f);
                    path2.close();
                    canvas.drawPath(path2, paint);
                    break;
                }
                break;
            case 3594468:
                if (str.equals("undo")) {
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(2.4f);
                    Path path3 = new Path();
                    path3.moveTo(9.0f, 5.5f);
                    path3.lineTo(4.6f, 10.0f);
                    path3.lineTo(9.0f, 14.5f);
                    canvas.drawPath(path3, paint);
                    Path path4 = new Path();
                    path4.moveTo(5.0f, 10.0f);
                    path4.lineTo(13.5f, 10.0f);
                    path4.cubicTo(17.6f, 10.0f, 19.6f, 12.4f, 19.6f, 15.0f);
                    path4.cubicTo(19.6f, 17.7f, 17.4f, 19.8f, 14.2f, 19.8f);
                    path4.lineTo(10.0f, 19.8f);
                    canvas.drawPath(path4, paint);
                    break;
                }
                break;
            case 94627080:
                if (str.equals("check")) {
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(2.6f);
                    Path path5 = new Path();
                    path5.moveTo(5.0f, 12.5f);
                    path5.lineTo(10.0f, 17.5f);
                    path5.lineTo(19.5f, 7.0f);
                    canvas.drawPath(path5, paint);
                    break;
                }
                break;
        }
        canvas.restore();
    }
}
