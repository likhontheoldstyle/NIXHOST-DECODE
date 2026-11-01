package a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

public final class IconView extends View {

    public String name;

    public int tint;

    public final float strokeWidth;

    public final Paint paint;

    public IconView(Context context, String str, int i2, float f2) {
        super(context);
        this.name = str;
        this.tint = i2;
        this.strokeWidth = f2;
        this.paint = new Paint(1);
    }

    public final void drawClosed(Canvas canvas, float... fArr) {
        Path path = new Path();
        path.moveTo(fArr[0], fArr[1]);
        for (int i2 = 2; i2 < fArr.length; i2 += 2) {
            path.lineTo(fArr[i2], fArr[i2 + 1]);
        }
        path.close();
        canvas.drawPath(path, this.paint);
    }

    public final void drawOpen(Canvas canvas, float... fArr) {
        Path path = new Path();
        path.moveTo(fArr[0], fArr[1]);
        for (int i2 = 2; i2 < fArr.length; i2 += 2) {
            path.lineTo(fArr[i2], fArr[i2 + 1]);
        }
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
        paint.setColor(this.tint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.strokeWidth);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        String str = this.name;
        float f3 = 7.5f;
        switch (str) {
            case "commit":
                canvas.drawCircle(12.0f, 12.0f, 4.0f, paint);
                canvas.drawLine(1.5f, 12.0f, 8.0f, 12.0f, paint);
                canvas.drawLine(16.0f, 12.0f, 22.5f, 12.0f, paint);
                break;
            case "eyeoff": {
                Path path = new Path();
                path.moveTo(2.0f, 12.0f);
                path.quadTo(12.0f, 3.0f, 22.0f, 12.0f);
                path.quadTo(12.0f, 21.0f, 2.0f, 12.0f);
                canvas.drawPath(path, paint);
                canvas.drawCircle(12.0f, 12.0f, 3.0f, paint);
                canvas.drawLine(3.5f, 3.5f, 20.5f, 20.5f, paint);
                break;
            }
            case "folder":
                drawClosed(canvas, 3.0f, 6.0f, 9.0f, 6.0f, 11.5f, 9.0f, 21.0f, 9.0f, 21.0f, 19.0f, 3.0f, 19.0f);
                break;
            case "folderf":
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                paint.setStrokeWidth(1.6f);
                drawClosed(canvas, 2.5f, 5.5f, 9.0f, 5.5f, 11.5f, 8.5f, 21.5f, 8.5f, 21.5f, 18.5f, 2.5f, 18.5f);
                break;
            case "up":
                drawOpen(canvas, 6.0f, 15.0f, 12.0f, 9.0f, 18.0f, 15.0f);
                break;
            case "wa": {
                canvas.drawCircle(12.0f, 12.0f, 9.0f, paint);
                Path path = new Path();
                path.moveTo(8.8f, 8.0f);
                path.quadTo(8.0f, 12.8f, 14.0f, 15.2f);
                canvas.drawPath(path, paint);
                canvas.drawLine(3.5f, 20.5f, 5.2f, 16.5f, paint);
                break;
            }
            case "cal":
                canvas.drawRoundRect(new RectF(3.0f, 5.0f, 21.0f, 21.0f), 3.0f, 3.0f, paint);
                canvas.drawLine(3.0f, 10.0f, 21.0f, 10.0f, paint);
                canvas.drawLine(8.0f, 3.0f, 8.0f, 7.0f, paint);
                canvas.drawLine(16.0f, 3.0f, 16.0f, 7.0f, paint);
                break;
            case "eye": {
                Path path = new Path();
                path.moveTo(2.0f, 12.0f);
                path.quadTo(12.0f, 3.0f, 22.0f, 12.0f);
                path.quadTo(12.0f, 21.0f, 2.0f, 12.0f);
                canvas.drawPath(path, paint);
                canvas.drawCircle(12.0f, 12.0f, 3.0f, paint);
                break;
            }
            case "sun":
                canvas.drawCircle(12.0f, 12.0f, 4.0f, paint);
                int i2 = 0;
                while (i2 < 8) {
                    double radians = Math.toRadians(i2 * 45.0d);
                    float cos = (float) Math.cos(radians);
                    float sin = (float) Math.sin(radians);
                    canvas.drawLine((cos * f3) + 12.0f, (sin * f3) + 12.0f, (cos * 10.0f) + 12.0f, (sin * 10.0f) + 12.0f, paint);
                    i2++;
                }
                break;
            case "back":
                drawOpen(canvas, 15.0f, 5.0f, 8.0f, 12.0f, 15.0f, 19.0f);
                break;
            case "chat": {
                paint.setStyle(Paint.Style.FILL);
                canvas.drawRoundRect(new RectF(3.0f, 4.0f, 21.0f, 17.0f), 6.0f, 6.0f, paint);
                Path path2 = new Path();
                path2.moveTo(8.0f, 15.0f);
                path2.lineTo(6.5f, 21.0f);
                path2.lineTo(13.0f, 16.0f);
                path2.close();
                canvas.drawPath(path2, paint);
                break;
            }
            case "dots":
                paint.setStyle(Paint.Style.FILL);
                canvas.drawCircle(12.0f, 4.5f, 2.2f, paint);
                canvas.drawCircle(12.0f, 12.0f, 2.2f, paint);
                canvas.drawCircle(12.0f, 19.5f, 2.2f, paint);
                break;
            case "down":
                drawOpen(canvas, 6.0f, 9.0f, 12.0f, 15.0f, 18.0f, 9.0f);
                break;
            case "file":
                drawClosed(canvas, 6.0f, 3.0f, 14.0f, 3.0f, 19.0f, 8.0f, 19.0f, 21.0f, 6.0f, 21.0f);
                drawOpen(canvas, 14.0f, 3.0f, 14.0f, 8.0f, 19.0f, 8.0f);
                break;
            case "lock": {
                canvas.drawRoundRect(new RectF(5.0f, 11.0f, 19.0f, 21.0f), 2.5f, 2.5f, paint);
                Path path3 = new Path();
                path3.moveTo(8.0f, 11.0f);
                path3.lineTo(8.0f, 8.0f);
                path3.arcTo(new RectF(8.0f, 4.0f, 16.0f, 12.0f), 180.0f, 180.0f);
                path3.lineTo(16.0f, 11.0f);
                canvas.drawPath(path3, paint);
                break;
            }
            case "logo":
                drawOpen(canvas, 4.0f, 17.0f, 10.0f, 11.0f, 4.0f, 5.0f);
                canvas.drawLine(12.0f, 19.0f, 20.0f, 19.0f, paint);
                break;
            case "moon": {
                Path path4 = new Path();
                Path.Direction direction = Path.Direction.CW;
                path4.addCircle(12.0f, 12.0f, 9.0f, direction);
                Path path5 = new Path();
                path5.addCircle(17.5f, 7.5f, 7.5f, direction);
                path4.op(path5, Path.Op.DIFFERENCE);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawPath(path4, paint);
                break;
            }
            case "plus":
                canvas.drawLine(12.0f, 5.0f, 12.0f, 19.0f, paint);
                canvas.drawLine(5.0f, 12.0f, 19.0f, 12.0f, paint);
                break;
            case "stop":
                canvas.drawCircle(12.0f, 12.0f, 9.0f, paint);
                canvas.drawRoundRect(new RectF(9.0f, 9.0f, 15.0f, 15.0f), 1.5f, 1.5f, paint);
                break;
            case "user": {
                canvas.drawCircle(12.0f, 8.0f, 4.0f, paint);
                Path path6 = new Path();
                path6.moveTo(4.0f, 21.0f);
                path6.quadTo(4.0f, 14.5f, 12.0f, 14.5f);
                path6.quadTo(20.0f, 14.5f, 20.0f, 21.0f);
                canvas.drawPath(path6, paint);
                break;
            }
            case "warn":
                drawClosed(canvas, 12.0f, 3.5f, 21.5f, 20.0f, 2.5f, 20.0f);
                canvas.drawLine(12.0f, 9.5f, 12.0f, 14.0f, paint);
                canvas.drawLine(12.0f, 17.0f, 12.0f, 17.1f, paint);
                break;
            case "arrow":
                canvas.drawLine(20.0f, 12.0f, 4.0f, 12.0f, paint);
                drawOpen(canvas, 10.0f, 6.0f, 4.0f, 12.0f, 10.0f, 18.0f);
                break;
            case "close":
                canvas.drawLine(6.0f, 6.0f, 18.0f, 18.0f, paint);
                canvas.drawLine(18.0f, 6.0f, 6.0f, 18.0f, paint);
                break;
            case "group": {
                canvas.drawCircle(9.0f, 8.0f, 3.5f, paint);
                Path path7 = new Path();
                path7.moveTo(2.5f, 20.0f);
                path7.quadTo(2.5f, 13.5f, 9.0f, 13.5f);
                path7.quadTo(15.5f, 13.5f, 15.5f, 20.0f);
                canvas.drawPath(path7, paint);
                canvas.drawCircle(17.0f, 9.0f, 2.8f, paint);
                Path path8 = new Path();
                path8.moveTo(17.5f, 14.0f);
                path8.quadTo(21.5f, 14.5f, 21.5f, 19.5f);
                canvas.drawPath(path8, paint);
                break;
            }
            case "trash":
                canvas.drawLine(4.0f, 7.0f, 20.0f, 7.0f, paint);
                drawOpen(canvas, 9.0f, 7.0f, 9.0f, 4.0f, 15.0f, 4.0f, 15.0f, 7.0f);
                drawOpen(canvas, 6.0f, 7.0f, 7.0f, 20.0f, 17.0f, 20.0f, 18.0f, 7.0f);
                canvas.drawLine(10.0f, 11.0f, 10.0f, 16.0f, paint);
                canvas.drawLine(14.0f, 11.0f, 14.0f, 16.0f, paint);
                break;
            case "trashmsg": {
                canvas.drawLine(2.6f, 5.9f, 21.4f, 5.9f, paint);
                Path path9 = new Path();
                path9.moveTo(9.3f, 5.9f);
                path9.lineTo(9.3f, 4.5f);
                path9.quadTo(9.3f, 2.9f, 12.0f, 2.9f);
                path9.quadTo(14.7f, 2.9f, 14.7f, 4.5f);
                path9.lineTo(14.7f, 5.9f);
                canvas.drawPath(path9, paint);
                Path path10 = new Path();
                path10.moveTo(5.1f, 6.6f);
                path10.lineTo(6.0f, 19.0f);
                path10.quadTo(6.2f, 21.2f, 8.6f, 21.2f);
                path10.lineTo(15.4f, 21.2f);
                path10.quadTo(17.8f, 21.2f, 18.0f, 19.0f);
                path10.lineTo(18.9f, 6.6f);
                canvas.drawPath(path10, paint);
                break;
            }
            case "wifioff": {
                Path path11 = new Path();
                path11.moveTo(2.0f, 9.0f);
                path11.quadTo(12.0f, 1.5f, 22.0f, 9.0f);
                canvas.drawPath(path11, paint);
                Path path12 = new Path();
                path12.moveTo(5.5f, 12.5f);
                path12.quadTo(12.0f, 7.5f, 18.5f, 12.5f);
                canvas.drawPath(path12, paint);
                Path path13 = new Path();
                path13.moveTo(9.0f, 16.0f);
                path13.quadTo(12.0f, 13.8f, 15.0f, 16.0f);
                canvas.drawPath(path13, paint);
                canvas.drawLine(12.0f, 19.5f, 12.0f, 19.6f, paint);
                canvas.drawLine(3.0f, 3.0f, 21.0f, 21.0f, paint);
                break;
            }
            case "chatdots":
                canvas.drawRoundRect(new RectF(3.0f, 4.0f, 21.0f, 17.5f), 5.5f, 5.5f, paint);
                drawOpen(canvas, 7.5f, 17.5f, 6.0f, 21.0f, 11.0f, 17.5f);
                canvas.drawLine(8.0f, 10.75f, 8.1f, 10.75f, paint);
                canvas.drawLine(12.0f, 10.75f, 12.1f, 10.75f, paint);
                canvas.drawLine(16.0f, 10.75f, 16.1f, 10.75f, paint);
                break;
        }
        canvas.restore();
    }

    public final void setIcon(String str) {
        this.name = str;
        invalidate();
    }

    public final void setTint(int i2) {
        this.tint = i2;
        invalidate();
    }
}
