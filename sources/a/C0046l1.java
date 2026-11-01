package a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;

/* renamed from: a.l1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0046l1 extends View {

    /* renamed from: a, reason: collision with root package name */
    public final String f580a;

    /* renamed from: b, reason: collision with root package name */
    public final int f581b;

    /* renamed from: c, reason: collision with root package name */
    public final int f582c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f583d;

    public C0046l1(Context context, String str, int i2, int i3) {
        super(context);
        this.f580a = str;
        this.f581b = i2;
        this.f582c = i3;
        this.f583d = new Paint(1);
    }

    public final void a(Canvas canvas, float f2, float f3, float f4, float f5, float f6) {
        canvas.drawRoundRect(new RectF(f2, f3, f4, f5), f6, f6, this.f583d);
    }

    public final void b(Canvas canvas, float f2, float f3, float f4, float f5, float f6, float f7) {
        Path path = new Path();
        path.moveTo(f2, f3);
        path.lineTo(f4, f5);
        path.lineTo(f6, f7);
        path.close();
        canvas.drawPath(path, this.f583d);
    }

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
    public final void onDraw(Canvas canvas) {
        float min = Math.min(getWidth(), getHeight()) / 24.0f;
        canvas.save();
        float f2 = 24.0f * min;
        canvas.translate((getWidth() - f2) / 2.0f, (getHeight() - f2) / 2.0f);
        canvas.scale(min, min);
        Paint paint = this.f583d;
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        int i2 = this.f581b;
        paint.setColor(i2);
        String str = this.f580a;
        int hashCode = str.hashCode();
        int i3 = this.f582c;
        switch (hashCode) {
            case -989034367:
                if (str.equals("photos")) {
                    a(canvas, 3.0f, 4.0f, 21.0f, 20.0f, 3.5f);
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
                    a(canvas, 3.0f, 5.0f, 21.0f, 19.0f, 3.5f);
                    paint.setColor(i3);
                    b(canvas, 10.0f, 8.8f, 10.0f, 15.2f, 15.8f, 12.0f);
                    break;
                }
                break;
            case -196315310:
                if (str.equals("gallery")) {
                    a(canvas, 2.5f, 8.5f, 15.5f, 21.5f, 2.5f);
                    paint.setColor(i3);
                    canvas.drawCircle(6.6f, 12.4f, 1.3f, paint);
                    b(canvas, 4.0f, 19.5f, 8.0f, 14.8f, 13.5f, 19.5f);
                    a(canvas, 7.2f, 1.2f, 22.8f, 16.8f, 3.4f);
                    paint.setColor(i2);
                    a(canvas, 8.4f, 2.4f, 21.6f, 15.6f, 2.6f);
                    paint.setColor(i3);
                    b(canvas, 12.8f, 6.2f, 12.8f, 11.8f, 17.6f, 9.0f);
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
                    a(canvas, 2.5f, 6.5f, 21.5f, 20.0f, 3.0f);
                    b(canvas, 7.6f, 7.2f, 9.6f, 4.0f, 16.4f, 7.2f);
                    a(canvas, 9.2f, 4.0f, 14.8f, 7.5f, 1.0f);
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
