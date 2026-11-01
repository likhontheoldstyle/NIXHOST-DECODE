package a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;

public final class ChatIconView extends View {

    public String name;

    public int color;

    public int cutColor;

    public float loadAngle;

    public final Paint paint;

    public ChatIconView(Context context, String str, int i2) {
        super(context);
        this.name = str;
        this.color = i2;
        this.cutColor = -1;
        this.paint = new Paint(1);
    }

    public static final void drawPerson(Canvas canvas, ChatIconView c1, float f2, float f3, float f4) {
        Path path = new Path();
        float f5 = (f2 + f3) / 2.0f;
        path.moveTo(f2, f4);
        float f6 = ((f4 - 12.2f) * 0.45f) + 12.2f;
        path.lineTo(f2, f6);
        path.cubicTo(f2, 12.7f, f5 - ((f5 - f2) * 0.6f), 12.2f, f5, 12.2f);
        path.cubicTo(((f3 - f5) * 0.6f) + f5, 12.2f, f3, 12.7f, f3, f6);
        path.lineTo(f3, f4);
        path.close();
        canvas.drawPath(path, c1.paint);
    }

    public final void drawRoundRect(Canvas canvas, float f2, float f3, float f4, float f5, float f6) {
        canvas.drawRoundRect(new RectF(f2, f3, f4, f5), f6, f6, this.paint);
    }

    public final int getCut() {
        return this.cutColor;
    }

    @Override

    public final void onDraw(Canvas canvas) {
        float f2;
        float f3;
        float min = Math.min(getWidth(), getHeight()) / 24.0f;
        canvas.save();
        float f4 = 24.0f * min;
        canvas.translate((getWidth() - f4) / 2.0f, (getHeight() - f4) / 2.0f);
        canvas.scale(min, min);
        Paint paint = this.paint;
        paint.setColor(this.color);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        Paint.Join join = Paint.Join.ROUND;
        paint.setStrokeJoin(join);
        String str = this.name;
        switch (str.hashCode()) {
            case -1890252483:
                if (str.equals("sticker")) {
                    Paint.Style style2 = Paint.Style.STROKE;
                    paint.setStyle(style2);
                    paint.setStrokeWidth(1.9f);
                    Path path = new Path();
                    path.moveTo(3.0f, 8.0f);
                    path.quadTo(3.0f, 3.0f, 8.0f, 3.0f);
                    path.lineTo(16.0f, 3.0f);
                    path.quadTo(21.0f, 3.0f, 21.0f, 8.0f);
                    path.lineTo(21.0f, 13.0f);
                    path.lineTo(13.0f, 21.0f);
                    path.lineTo(8.0f, 21.0f);
                    path.quadTo(3.0f, 21.0f, 3.0f, 16.0f);
                    path.close();
                    canvas.drawPath(path, paint);
                    Path path2 = new Path();
                    path2.moveTo(21.0f, 13.0f);
                    path2.lineTo(17.0f, 13.0f);
                    path2.quadTo(13.0f, 13.0f, 13.0f, 17.0f);
                    path2.lineTo(13.0f, 21.0f);
                    canvas.drawPath(path2, paint);
                    paint.setStyle(style);
                    canvas.drawCircle(8.5f, 9.0f, 1.2f, paint);
                    canvas.drawCircle(15.5f, 9.0f, 1.2f, paint);
                    paint.setStyle(style2);
                    Path path3 = new Path();
                    path3.moveTo(8.0f, 13.5f);
                    path3.quadTo(10.5f, 16.5f, 13.0f, 14.5f);
                    canvas.drawPath(path3, paint);
                    break;
                }
                break;
            case -1361527714:
                if (str.equals("checkf")) {
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(2.8f);
                    Path path4 = new Path();
                    path4.moveTo(5.5f, 12.5f);
                    path4.lineTo(10.0f, 17.0f);
                    path4.lineTo(18.5f, 7.5f);
                    canvas.drawPath(path4, paint);
                    break;
                }
                break;
            case -1123100580:
                if (str.equals("reactface")) {
                    canvas.drawCircle(12.0f, 12.0f, 12.0f, paint);
                    paint.setColor(this.cutColor);
                    canvas.drawCircle(7.6f, 9.7f, 1.8f, paint);
                    canvas.drawCircle(16.4f, 9.7f, 1.8f, paint);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(1.9f);
                    paint.setStrokeCap(cap);
                    canvas.drawArc(new RectF(3.4f, 0.7f, 20.6f, 17.9f), 51.0f, 78.0f, false, paint);
                    break;
                }
                break;
            case -995321543:
                if (str.equals("pauseo")) {
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(1.8f);
                    canvas.drawRoundRect(new RectF(6.9f, 5.4f, 10.1f, 18.6f), 1.6f, 1.6f, paint);
                    canvas.drawRoundRect(new RectF(13.9f, 5.4f, 17.1f, 18.6f), 1.6f, 1.6f, paint);
                    break;
                }
                break;
            case -991808881:
                if (str.equals("people")) {
                    canvas.drawCircle(4.8f, 8.6f, 2.5f, paint);
                    drawPerson(canvas, this, 0.8f, 8.6f, 18.6f);
                    canvas.drawCircle(19.2f, 8.6f, 2.5f, paint);
                    drawPerson(canvas, this, 15.4f, 23.2f, 18.6f);
                    canvas.drawCircle(12.0f, 7.4f, 3.4f, paint);
                    drawPerson(canvas, this, 5.6f, 18.4f, 20.4f);
                    break;
                }
                break;
            case -934524228:
                if (str.equals("replyf")) {
                    Path path5 = new Path();
                    path5.moveTo(10.5f, 4.5f);
                    path5.lineTo(2.5f, 11.5f);
                    path5.lineTo(10.5f, 18.5f);
                    path5.close();
                    canvas.drawPath(path5, paint);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(3.2f);
                    Path path6 = new Path();
                    path6.moveTo(7.0f, 11.5f);
                    path6.lineTo(13.5f, 11.5f);
                    path6.quadTo(20.5f, 11.5f, 20.5f, 19.0f);
                    canvas.drawPath(path6, paint);
                    break;
                }
                break;
            case -874822710:
                if (str.equals("themes")) {
                    canvas.drawOval(new RectF(2.2f, 3.2f, 21.8f, 20.8f), paint);
                    paint.setColor(this.cutColor);
                    canvas.drawCircle(15.8f, 16.8f, 2.7f, paint);
                    canvas.drawCircle(7.4f, 10.4f, 1.7f, paint);
                    canvas.drawCircle(11.4f, 6.9f, 1.7f, paint);
                    canvas.drawCircle(16.4f, 8.2f, 1.7f, paint);
                    canvas.drawCircle(18.6f, 12.2f, 1.7f, paint);
                    break;
                }
                break;
            case -865700818:
                if (str.equals("trashf")) {
                    drawRoundRect(canvas, 3.5f, 4.8f, 20.5f, 7.4f, 1.3f);
                    drawRoundRect(canvas, 9.0f, 2.3f, 15.0f, 5.2f, 1.2f);
                    Path path7 = new Path();
                    path7.moveTo(5.4f, 9.2f);
                    path7.lineTo(18.6f, 9.2f);
                    path7.lineTo(17.7f, 19.6f);
                    path7.quadTo(17.5f, 21.6f, 15.5f, 21.6f);
                    path7.lineTo(8.5f, 21.6f);
                    path7.quadTo(6.5f, 21.6f, 6.3f, 19.6f);
                    path7.close();
                    canvas.drawPath(path7, paint);
                    break;
                }
                break;
            case -810883302:
                f2 = 2.0f;
                f3 = 9.4f;
                break;
            case 102340:
                if (str.equals("gif")) {
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(1.9f);
                    canvas.drawRoundRect(new RectF(2.5f, 4.5f, 21.5f, 19.5f), 3.5f, 3.5f, paint);
                    paint.setStyle(style);
                    paint.setTextSize(8.2f);
                    paint.setTypeface(Typeface.DEFAULT_BOLD);
                    paint.setTextAlign(Paint.Align.CENTER);
                    canvas.drawText("GIF", 12.0f, 14.8f, paint);
                    break;
                }
                break;
            case 108103:
                if (str.equals("mic")) {
                    drawRoundRect(canvas, 7.9f, 2.0f, 16.1f, 15.5f, 4.1f);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeCap(cap);
                    paint.setStrokeWidth(1.4f);
                    canvas.drawArc(new RectF(4.9f, 2.6f, 19.1f, 18.2f), 0.0f, 180.0f, false, paint);
                    canvas.drawLine(12.0f, 18.2f, 12.0f, 21.0f, paint);
                    paint.setStrokeWidth(1.6f);
                    canvas.drawLine(8.9f, 21.1f, 15.1f, 21.1f, paint);
                    break;
                }
                break;
            case 3020035:
                break;
            case 3135069:
                if (str.equals("face")) {
                    Path path8 = new Path();
                    path8.moveTo(7.3f, 2.3f);
                    path8.lineTo(16.7f, 2.3f);
                    path8.quadTo(21.7f, 2.3f, 21.7f, 7.3f);
                    path8.lineTo(21.7f, 15.6f);
                    path8.lineTo(13.6f, 21.7f);
                    path8.lineTo(7.3f, 21.7f);
                    path8.quadTo(2.3f, 21.7f, 2.3f, 16.7f);
                    path8.lineTo(2.3f, 7.3f);
                    path8.quadTo(2.3f, 2.3f, 7.3f, 2.3f);
                    path8.close();
                    canvas.drawPath(path8, paint);
                    paint.setColor(this.cutColor);
                    canvas.drawCircle(8.2f, 9.4f, 1.45f, paint);
                    canvas.drawCircle(15.8f, 9.4f, 1.45f, paint);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(1.5f);
                    paint.setStrokeCap(cap);
                    Path path9 = new Path();
                    path9.moveTo(7.2f, 14.0f);
                    path9.quadTo(9.6f, 16.6f, 12.6f, 15.6f);
                    canvas.drawPath(path9, paint);
                    paint.setStrokeCap(Paint.Cap.BUTT);
                    Path path10 = new Path();
                    path10.moveTo(21.8f, 13.6f);
                    path10.quadTo(15.6f, 13.6f, 13.6f, 16.2f);
                    path10.quadTo(12.6f, 17.6f, 12.6f, 19.6f);
                    path10.lineTo(12.6f, 22.3f);
                    canvas.drawPath(path10, paint);
                    break;
                }
                break;
            case 3168655:
                if (str.equals("gear")) {
                    paint.setStyle(style);
                    for (int i2 = 0; i2 < 6; i2++) {
                        canvas.save();
                        canvas.rotate(i2 * 60.0f, 12.0f, 12.0f);
                        drawRoundRect(canvas, 8.4f, 2.0f, 15.6f, 12.0f, 2.1f);
                        canvas.restore();
                    }
                    canvas.drawCircle(12.0f, 12.0f, 7.6f, paint);
                    paint.setColor(this.cutColor);
                    canvas.drawCircle(12.0f, 12.0f, 4.2f, paint);
                    paint.setColor(this.color);
                    canvas.drawCircle(12.0f, 12.0f, 2.95f, paint);
                    break;
                }
                break;
            case 3321751:
                if (str.equals("like")) {
                    Path path11 = new Path();
                    path11.moveTo(7.3f, 18.9f);
                    path11.lineTo(7.3f, 11.2f);
                    path11.quadTo(7.3f, 9.2f, 8.3f, 8.3f);
                    path11.quadTo(8.9f, 7.7f, 8.9f, 6.6f);
                    path11.lineTo(8.9f, 4.1f);
                    path11.quadTo(8.9f, 2.0f, 11.0f, 2.0f);
                    path11.quadTo(13.5f, 2.0f, 13.5f, 4.2f);
                    path11.lineTo(13.5f, 7.9f);
                    path11.lineTo(19.0f, 7.9f);
                    path11.quadTo(20.4f, 7.9f, 20.4f, 9.5f);
                    path11.quadTo(20.95f, 10.3f, 20.4f, 11.1f);
                    path11.quadTo(20.9f, 12.0f, 20.3f, 12.9f);
                    path11.quadTo(20.8f, 13.8f, 20.2f, 14.7f);
                    path11.lineTo(20.0f, 17.6f);
                    path11.quadTo(19.9f, 20.4f, 17.8f, 20.4f);
                    path11.lineTo(9.3f, 20.4f);
                    path11.quadTo(7.3f, 20.4f, 7.3f, 18.9f);
                    path11.close();
                    canvas.drawPath(path11, paint);
                    drawRoundRect(canvas, 2.0f, 9.9f, 5.95f, 20.4f, 1.4f);
                    break;
                }
                break;
            case 3327206:
                if (str.equals("load")) {
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(2.8f);
                    canvas.save();
                    canvas.rotate(this.loadAngle, 12.0f, 12.0f);
                    canvas.drawArc(new RectF(4.6f, 4.6f, 19.4f, 19.4f), 0.0f, 250.0f, false, paint);
                    canvas.restore();
                    this.loadAngle = (this.loadAngle + 9.0f) % 360.0f;
                    postInvalidateOnAnimation();
                    break;
                }
                break;
            case 3351304:
                if (str.equals("mico")) {
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(1.7f);
                    paint.setStrokeCap(cap);
                    canvas.drawRoundRect(new RectF(8.5f, 2.8f, 15.5f, 14.2f), 3.5f, 3.5f, paint);
                    canvas.drawArc(new RectF(5.2f, 3.2f, 18.8f, 18.0f), 0.0f, 180.0f, false, paint);
                    canvas.drawLine(12.0f, 18.0f, 12.0f, 21.0f, paint);
                    canvas.drawLine(8.9f, 21.2f, 15.1f, 21.2f, paint);
                    break;
                }
                break;
            case 3363353:
                f3 = 9.4f;
                if (str.equals("mute")) {
                    f2 = 2.0f;
                    Path path12 = new Path();
                    path12.moveTo(3.6f, f3);
                    path12.lineTo(7.8f, f3);
                    path12.lineTo(13.0f, 4.8f);
                    path12.lineTo(13.0f, 19.2f);
                    path12.lineTo(7.8f, 14.6f);
                    path12.lineTo(3.6f, 14.6f);
                    path12.close();
                    paint.setStyle(Paint.Style.FILL_AND_STROKE);
                    paint.setStrokeWidth(1.2f);
                    canvas.drawPath(path12, paint);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(f2);
                    if (i.b.a(this.name, "volume")) {
                        canvas.drawArc(new RectF(10.2f, 8.2f, 17.2f, 15.8f), -55.0f, 110.0f, false, paint);
                        canvas.drawArc(new RectF(8.2f, 4.6f, 21.2f, 19.4f), -55.0f, 110.0f, false, paint);
                        break;
                    } else {
                        canvas.drawLine(16.2f, 9.2f, 21.2f, 14.8f, paint);
                        canvas.drawLine(21.2f, 9.2f, 16.2f, 14.8f, paint);
                        break;
                    }
                }
                break;
            case 3437163:
                if (str.equals("pend")) {
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(1.8f);
                    canvas.drawCircle(12.0f, 12.0f, 9.1f, paint);
                    break;
                }
                break;
            case 3443508:
                if (str.equals("play")) {
                    Path path13 = new Path();
                    path13.moveTo(7.2f, 5.4f);
                    path13.lineTo(19.0f, 12.0f);
                    path13.lineTo(7.2f, 18.6f);
                    path13.close();
                    paint.setStyle(Paint.Style.FILL_AND_STROKE);
                    paint.setStrokeWidth(3.6f);
                    canvas.drawPath(path13, paint);
                    break;
                }
                break;
            case 3526536:
                if (str.equals("send")) {
                    Path path14 = new Path();
                    path14.moveTo(5.33f, 5.4f);
                    path14.lineTo(20.2f, 5.4f);
                    path14.lineTo(12.44f, 18.76f);
                    path14.close();
                    paint.setStyle(Paint.Style.FILL_AND_STROKE);
                    paint.setStrokeWidth(4.6f);
                    paint.setStrokeJoin(join);
                    canvas.drawPath(path14, paint);
                    paint.setColor(this.cutColor);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(1.3f);
                    paint.setStrokeCap(cap);
                    canvas.drawLine(5.0f, 12.7f, 12.6f, 9.9f, paint);
                    break;
                }
                break;
            case 3526552:
                break;
            case 3540994:
                if (str.equals("stop")) {
                    drawRoundRect(canvas, 5.0f, 5.0f, 19.0f, 19.0f, 3.5f);
                    break;
                }
                break;
            case 94846865:
                if (str.equals("copyf")) {
                    drawRoundRect(canvas, 4.0f, 7.0f, 15.0f, 21.0f, 2.2f);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(2.2f);
                    Path path15 = new Path();
                    path15.moveTo(8.5f, 6.0f);
                    path15.lineTo(8.5f, 5.0f);
                    path15.quadTo(8.5f, 3.0f, 10.5f, 3.0f);
                    path15.lineTo(18.0f, 3.0f);
                    path15.quadTo(20.0f, 3.0f, 20.0f, 5.0f);
                    path15.lineTo(20.0f, 14.5f);
                    path15.quadTo(20.0f, 16.5f, 18.0f, 16.5f);
                    path15.lineTo(17.0f, 16.5f);
                    canvas.drawPath(path15, paint);
                    break;
                }
                break;
            case 95468152:
                break;
            case 96359324:
                if (str.equals("editf")) {
                    Path path16 = new Path();
                    path16.moveTo(3.5f, 20.5f);
                    path16.lineTo(4.3f, 15.6f);
                    path16.lineTo(15.8f, 4.1f);
                    path16.lineTo(19.9f, 8.2f);
                    path16.lineTo(8.4f, 19.7f);
                    path16.close();
                    canvas.drawPath(path16, paint);
                    break;
                }
                break;
            case 100313435:
                if (str.equals("image")) {
                    drawRoundRect(canvas, 4.2f, 2.0f, 19.8f, 22.0f, 4.3f);
                    paint.setColor(this.cutColor);
                    Path path17 = new Path();
                    path17.moveTo(6.4f, 13.4f);
                    path17.lineTo(6.4f, 6.4f);
                    path17.quadTo(6.4f, 3.9f, 8.9f, 3.9f);
                    path17.lineTo(15.1f, 3.9f);
                    path17.quadTo(17.6f, 3.9f, 17.6f, 6.4f);
                    path17.lineTo(17.6f, 12.6f);
                    path17.quadTo(16.9f, 10.6f, 15.5f, 10.9f);
                    path17.cubicTo(14.3f, 11.2f, 13.4f, 13.0f, 12.3f, 13.0f);
                    path17.cubicTo(11.2f, 13.0f, 10.6f, 12.3f, 9.7f, 12.3f);
                    path17.cubicTo(8.4f, 12.3f, 7.4f, 13.4f, 6.4f, 13.4f);
                    path17.close();
                    canvas.drawPath(path17, paint);
                    paint.setColor(this.color);
                    canvas.drawCircle(9.4f, 7.2f, 1.6f, paint);
                    break;
                }
                break;
            case 106440182:
                if (str.equals("pause")) {
                    drawRoundRect(canvas, 6.0f, 4.5f, 10.2f, 19.5f, 1.6f);
                    drawRoundRect(canvas, 13.8f, 4.5f, 18.0f, 19.5f, 1.6f);
                    break;
                }
                break;
            case 108401386:
                if (str.equals("reply")) {
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(2.0f);
                    Path path18 = new Path();
                    path18.moveTo(9.0f, 5.5f);
                    path18.lineTo(4.0f, 10.5f);
                    path18.lineTo(9.0f, 15.5f);
                    canvas.drawPath(path18, paint);
                    Path path19 = new Path();
                    path19.moveTo(4.0f, 10.5f);
                    path19.lineTo(13.0f, 10.5f);
                    path19.quadTo(20.0f, 10.5f, 20.0f, 18.0f);
                    canvas.drawPath(path19, paint);
                    break;
                }
                break;
            case 109400031:
                if (str.equals("share")) {
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(1.9f);
                    canvas.drawLine(6.2f, 12.0f, 17.6f, 5.8f, paint);
                    canvas.drawLine(6.2f, 12.0f, 17.6f, 18.2f, paint);
                    paint.setStyle(style);
                    canvas.drawCircle(18.0f, 5.5f, 3.1f, paint);
                    canvas.drawCircle(6.0f, 12.0f, 3.1f, paint);
                    canvas.drawCircle(18.0f, 18.5f, 3.1f, paint);
                    break;
                }
                break;
            case 109556488:
                if (str.equals("smile")) {
                    canvas.drawCircle(12.0f, 12.0f, 10.0f, paint);
                    paint.setColor(this.cutColor);
                    canvas.drawCircle(8.6f, 10.2f, 1.4f, paint);
                    canvas.drawCircle(15.4f, 10.2f, 1.4f, paint);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(1.9f);
                    Path path20 = new Path();
                    path20.moveTo(7.6f, 14.2f);
                    path20.quadTo(12.0f, 19.4f, 16.4f, 14.2f);
                    canvas.drawPath(path20, paint);
                    break;
                }
                break;
            case 174133769:
                if (str.equals("likebig")) {
                    Path path21 = new Path();
                    path21.moveTo(7.2f, 17.9f);
                    path21.lineTo(7.2f, 12.3f);
                    path21.quadTo(7.2f, 10.2f, 8.6f, 8.8f);
                    path21.quadTo(10.2f, 7.2f, 10.2f, 5.6f);
                    path21.lineTo(10.2f, 3.6f);
                    path21.quadTo(10.2f, 2.0f, 11.7f, 2.0f);
                    path21.quadTo(13.6f, 2.0f, 13.6f, 4.6f);
                    path21.lineTo(13.6f, 8.5f);
                    path21.lineTo(17.6f, 8.7f);
                    path21.quadTo(19.3f, 8.9f, 19.3f, 10.5f);
                    path21.quadTo(19.9f, 11.4f, 19.4f, 12.4f);
                    path21.quadTo(19.8f, 13.4f, 18.9f, 14.5f);
                    path21.quadTo(19.3f, 15.5f, 18.7f, 16.5f);
                    path21.quadTo(18.4f, 19.5f, 14.5f, 19.5f);
                    path21.lineTo(9.3f, 19.5f);
                    path21.quadTo(7.2f, 19.5f, 7.2f, 17.9f);
                    path21.close();
                    canvas.drawPath(path21, paint);
                    Path path22 = new Path();
                    path22.moveTo(3.9f, 10.5f);
                    path22.lineTo(5.0f, 10.5f);
                    path22.quadTo(5.7f, 10.5f, 5.7f, 11.2f);
                    path22.lineTo(5.7f, 19.7f);
                    path22.quadTo(5.7f, 20.4f, 5.0f, 20.4f);
                    path22.lineTo(3.7f, 20.4f);
                    path22.quadTo(1.9f, 20.4f, 1.9f, 18.4f);
                    path22.lineTo(1.9f, 12.4f);
                    path22.quadTo(1.9f, 10.5f, 3.9f, 10.5f);
                    path22.close();
                    canvas.drawPath(path22, paint);
                    break;
                }
                break;
            case 1342253626:
                if (str.equals("wifioff")) {
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(2.1f);
                    paint.setStrokeCap(cap);
                    float[] fArr = {4.6f, 8.6f, 12.6f};
                    for (int i3 = 0; i3 < 3; i3++) {
                        float f5 = fArr[i3];
                        canvas.drawArc(new RectF(12.0f - f5, 19.0f - f5, f5 + 12.0f, f5 + 19.0f), 227.0f, 86.0f, false, paint);
                    }
                    paint.setStyle(Paint.Style.FILL);
                    canvas.drawCircle(12.0f, 19.0f, 1.7f, paint);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(2.3f);
                    paint.setColor(this.cutColor);
                    canvas.drawLine(4.4f, 2.6f, 21.4f, 19.6f, paint);
                    paint.setColor(this.color);
                    paint.setStrokeWidth(2.1f);
                    canvas.drawLine(3.4f, 3.4f, 20.4f, 20.4f, paint);
                    break;
                }
                break;
            case 1353507967:
                if (str.equals("backspace")) {
                    drawRoundRect(canvas, 2.0f, 4.5f, 22.0f, 19.5f, 4.0f);
                    paint.setColor(this.cutColor);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(2.2f);
                    canvas.drawLine(9.5f, 9.5f, 14.5f, 14.5f, paint);
                    canvas.drawLine(14.5f, 9.5f, 9.5f, 14.5f, paint);
                    break;
                }
                break;
            case 1427818632:
                if (str.equals("download")) {
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(2.1f);
                    canvas.drawLine(12.0f, 3.8f, 12.0f, 14.6f, paint);
                    Path path23 = new Path();
                    path23.moveTo(7.2f, 10.2f);
                    path23.lineTo(12.0f, 15.0f);
                    path23.lineTo(16.8f, 10.2f);
                    canvas.drawPath(path23, paint);
                    Path path24 = new Path();
                    path24.moveTo(4.6f, 15.8f);
                    path24.lineTo(4.6f, 19.6f);
                    path24.lineTo(19.4f, 19.6f);
                    path24.lineTo(19.4f, 15.8f);
                    canvas.drawPath(path24, paint);
                    break;
                }
                break;
            case 1635331484:
                break;
        }
        canvas.restore();
    }

    public final void setIcon(String str) {
        this.name = str;
        invalidate();
    }

    public final void setCut(int i2) {
        this.cutColor = i2;
    }
}
