package a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/* loaded from: classes.dex */
public final class G1 extends View {

    /* renamed from: a, reason: collision with root package name */
    public String f107a;

    /* renamed from: b, reason: collision with root package name */
    public int f108b;

    /* renamed from: c, reason: collision with root package name */
    public final float f109c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f110d;

    public G1(Context context, String str, int i2, float f2) {
        super(context);
        this.f107a = str;
        this.f108b = i2;
        this.f109c = f2;
        this.f110d = new Paint(1);
    }

    public final void a(Canvas canvas, float... fArr) {
        Path path = new Path();
        path.moveTo(fArr[0], fArr[1]);
        for (int i2 = 2; i2 < fArr.length; i2 += 2) {
            path.lineTo(fArr[i2], fArr[i2 + 1]);
        }
        path.close();
        canvas.drawPath(path, this.f110d);
    }

    public final void b(Canvas canvas, float... fArr) {
        Path path = new Path();
        path.moveTo(fArr[0], fArr[1]);
        for (int i2 = 2; i2 < fArr.length; i2 += 2) {
            path.lineTo(fArr[i2], fArr[i2 + 1]);
        }
        canvas.drawPath(path, this.f110d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0480, code lost:
    
        if (r11.equals("eye") == false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x054e, code lost:
    
        r2 = new android.graphics.Path();
        r2.moveTo(2.0f, 12.0f);
        r2.quadTo(12.0f, 3.0f, 22.0f, 12.0f);
        r2.quadTo(12.0f, 21.0f, 2.0f, 12.0f);
        r17.drawPath(r2, r10);
        r17.drawCircle(12.0f, 12.0f, 3.0f, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x056a, code lost:
    
        if (i.b.a(r16.f107a, "eyeoff") == false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x056c, code lost:
    
        r17.drawLine(3.5f, 3.5f, 20.5f, 20.5f, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x054b, code lost:
    
        if (r11.equals("eyeoff") == false) goto L121;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onDraw(Canvas canvas) {
        float min = Math.min(getWidth(), getHeight()) / 24.0f;
        canvas.save();
        float f2 = 24.0f * min;
        canvas.translate((getWidth() - f2) / 2.0f, (getHeight() - f2) / 2.0f);
        canvas.scale(min, min);
        Paint paint = this.f110d;
        paint.setColor(this.f108b);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f109c);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        String str = this.f107a;
        float f3 = 7.5f;
        switch (str.hashCode()) {
            case -1354815177:
                if (str.equals("commit")) {
                    canvas.drawCircle(12.0f, 12.0f, 4.0f, paint);
                    canvas.drawLine(1.5f, 12.0f, 8.0f, 12.0f, paint);
                    canvas.drawLine(16.0f, 12.0f, 22.5f, 12.0f, paint);
                    break;
                }
                break;
            case -1288558178:
                break;
            case -1268966290:
                if (str.equals("folder")) {
                    a(canvas, 3.0f, 6.0f, 9.0f, 6.0f, 11.5f, 9.0f, 21.0f, 9.0f, 21.0f, 19.0f, 3.0f, 19.0f);
                    break;
                }
                break;
            case -683249224:
                if (str.equals("folderf")) {
                    paint.setStyle(Paint.Style.FILL_AND_STROKE);
                    paint.setStrokeWidth(1.6f);
                    a(canvas, 2.5f, 5.5f, 9.0f, 5.5f, 11.5f, 8.5f, 21.5f, 8.5f, 21.5f, 18.5f, 2.5f, 18.5f);
                    break;
                }
                break;
            case 3739:
                if (str.equals("up")) {
                    b(canvas, 6.0f, 15.0f, 12.0f, 9.0f, 18.0f, 15.0f);
                    break;
                }
                break;
            case 3786:
                if (str.equals("wa")) {
                    canvas.drawCircle(12.0f, 12.0f, 9.0f, paint);
                    Path path = new Path();
                    path.moveTo(8.8f, 8.0f);
                    path.quadTo(8.0f, 12.8f, 14.0f, 15.2f);
                    canvas.drawPath(path, paint);
                    canvas.drawLine(3.5f, 20.5f, 5.2f, 16.5f, paint);
                    break;
                }
                break;
            case 98254:
                if (str.equals("cal")) {
                    canvas.drawRoundRect(new RectF(3.0f, 5.0f, 21.0f, 21.0f), 3.0f, 3.0f, paint);
                    canvas.drawLine(3.0f, 10.0f, 21.0f, 10.0f, paint);
                    canvas.drawLine(8.0f, 3.0f, 8.0f, 7.0f, paint);
                    canvas.drawLine(16.0f, 3.0f, 16.0f, 7.0f, paint);
                    break;
                }
                break;
            case 100913:
                break;
            case 114252:
                if (str.equals("sun")) {
                    canvas.drawCircle(12.0f, 12.0f, 4.0f, paint);
                    int i2 = 0;
                    while (i2 < 8) {
                        double radians = Math.toRadians(i2 * 45.0d);
                        float cos = (float) Math.cos(radians);
                        float sin = (float) Math.sin(radians);
                        canvas.drawLine((cos * f3) + 12.0f, (sin * f3) + 12.0f, (cos * 10.0f) + 12.0f, (sin * 10.0f) + 12.0f, paint);
                        i2++;
                        f3 = f3;
                    }
                    break;
                }
                break;
            case 3015911:
                if (str.equals("back")) {
                    b(canvas, 15.0f, 5.0f, 8.0f, 12.0f, 15.0f, 19.0f);
                    break;
                }
                break;
            case 3052376:
                if (str.equals("chat")) {
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
                break;
            case 3089482:
                if (str.equals("dots")) {
                    paint.setStyle(Paint.Style.FILL);
                    canvas.drawCircle(12.0f, 4.5f, 2.2f, paint);
                    canvas.drawCircle(12.0f, 12.0f, 2.2f, paint);
                    canvas.drawCircle(12.0f, 19.5f, 2.2f, paint);
                    break;
                }
                break;
            case 3089570:
                if (str.equals("down")) {
                    b(canvas, 6.0f, 9.0f, 12.0f, 15.0f, 18.0f, 9.0f);
                    break;
                }
                break;
            case 3143036:
                if (str.equals("file")) {
                    a(canvas, 6.0f, 3.0f, 14.0f, 3.0f, 19.0f, 8.0f, 19.0f, 21.0f, 6.0f, 21.0f);
                    b(canvas, 14.0f, 3.0f, 14.0f, 8.0f, 19.0f, 8.0f);
                    break;
                }
                break;
            case 3327275:
                if (str.equals("lock")) {
                    canvas.drawRoundRect(new RectF(5.0f, 11.0f, 19.0f, 21.0f), 2.5f, 2.5f, paint);
                    Path path3 = new Path();
                    path3.moveTo(8.0f, 11.0f);
                    path3.lineTo(8.0f, 8.0f);
                    path3.arcTo(new RectF(8.0f, 4.0f, 16.0f, 12.0f), 180.0f, 180.0f);
                    path3.lineTo(16.0f, 11.0f);
                    canvas.drawPath(path3, paint);
                    break;
                }
                break;
            case 3327403:
                if (str.equals("logo")) {
                    b(canvas, 4.0f, 17.0f, 10.0f, 11.0f, 4.0f, 5.0f);
                    canvas.drawLine(12.0f, 19.0f, 20.0f, 19.0f, paint);
                    break;
                }
                break;
            case 3357441:
                if (str.equals("moon")) {
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
                break;
            case 3444122:
                if (str.equals("plus")) {
                    canvas.drawLine(12.0f, 5.0f, 12.0f, 19.0f, paint);
                    canvas.drawLine(5.0f, 12.0f, 19.0f, 12.0f, paint);
                    break;
                }
                break;
            case 3540994:
                if (str.equals("stop")) {
                    canvas.drawCircle(12.0f, 12.0f, 9.0f, paint);
                    canvas.drawRoundRect(new RectF(9.0f, 9.0f, 15.0f, 15.0f), 1.5f, 1.5f, paint);
                    break;
                }
                break;
            case 3599307:
                if (str.equals("user")) {
                    canvas.drawCircle(12.0f, 8.0f, 4.0f, paint);
                    Path path6 = new Path();
                    path6.moveTo(4.0f, 21.0f);
                    path6.quadTo(4.0f, 14.5f, 12.0f, 14.5f);
                    path6.quadTo(20.0f, 14.5f, 20.0f, 21.0f);
                    canvas.drawPath(path6, paint);
                    break;
                }
                break;
            case 3641990:
                if (str.equals("warn")) {
                    a(canvas, 12.0f, 3.5f, 21.5f, 20.0f, 2.5f, 20.0f);
                    canvas.drawLine(12.0f, 9.5f, 12.0f, 14.0f, paint);
                    canvas.drawLine(12.0f, 17.0f, 12.0f, 17.1f, paint);
                    break;
                }
                break;
            case 93090825:
                if (str.equals("arrow")) {
                    canvas.drawLine(20.0f, 12.0f, 4.0f, 12.0f, paint);
                    b(canvas, 10.0f, 6.0f, 4.0f, 12.0f, 10.0f, 18.0f);
                    break;
                }
                break;
            case 94756344:
                if (str.equals("close")) {
                    canvas.drawLine(6.0f, 6.0f, 18.0f, 18.0f, paint);
                    canvas.drawLine(18.0f, 6.0f, 6.0f, 18.0f, paint);
                    break;
                }
                break;
            case 98629247:
                if (str.equals("group")) {
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
                break;
            case 110621496:
                if (str.equals("trash")) {
                    canvas.drawLine(4.0f, 7.0f, 20.0f, 7.0f, paint);
                    b(canvas, 9.0f, 7.0f, 9.0f, 4.0f, 15.0f, 4.0f, 15.0f, 7.0f);
                    b(canvas, 6.0f, 7.0f, 7.0f, 20.0f, 17.0f, 20.0f, 18.0f, 7.0f);
                    canvas.drawLine(10.0f, 11.0f, 10.0f, 16.0f, paint);
                    canvas.drawLine(14.0f, 11.0f, 14.0f, 16.0f, paint);
                    break;
                }
                break;
            case 1285179721:
                if (str.equals("trashmsg")) {
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
                break;
            case 1342253626:
                if (str.equals("wifioff")) {
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
                break;
            case 1437879202:
                if (str.equals("chatdots")) {
                    canvas.drawRoundRect(new RectF(3.0f, 4.0f, 21.0f, 17.5f), 5.5f, 5.5f, paint);
                    b(canvas, 7.5f, 17.5f, 6.0f, 21.0f, 11.0f, 17.5f);
                    canvas.drawLine(8.0f, 10.75f, 8.1f, 10.75f, paint);
                    canvas.drawLine(12.0f, 10.75f, 12.1f, 10.75f, paint);
                    canvas.drawLine(16.0f, 10.75f, 16.1f, 10.75f, paint);
                    break;
                }
                break;
        }
        canvas.restore();
    }

    public final void set(String str) {
        this.f107a = str;
        invalidate();
    }

    public final void setTint(int i2) {
        this.f108b = i2;
        invalidate();
    }
}
