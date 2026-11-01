package a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: a.y1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0091y1 extends View {

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f719s = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Bitmap f720a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f721b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f722c;

    /* renamed from: d, reason: collision with root package name */
    public int f723d;

    /* renamed from: e, reason: collision with root package name */
    public h.b f724e;

    /* renamed from: f, reason: collision with root package name */
    public final Matrix f725f;

    /* renamed from: g, reason: collision with root package name */
    public final Matrix f726g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f727h;

    /* renamed from: i, reason: collision with root package name */
    public Path f728i;

    /* renamed from: j, reason: collision with root package name */
    public O2 f729j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f730k;

    /* renamed from: l, reason: collision with root package name */
    public float f731l;

    /* renamed from: m, reason: collision with root package name */
    public float f732m;

    /* renamed from: n, reason: collision with root package name */
    public float f733n;

    /* renamed from: o, reason: collision with root package name */
    public float f734o;
    public final int p;
    public final ScaleGestureDetector q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ B1 f735r;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0091y1(B1 b1, Bitmap bitmap) {
        super(r3);
        this.f735r = b1;
        Activity activity = b1.f26a;
        this.f720a = bitmap;
        this.f721b = new ArrayList();
        this.f723d = -50384;
        this.f724e = new C0085w1(0);
        this.f725f = new Matrix();
        this.f726g = new Matrix();
        this.f727h = new Paint(1);
        this.p = ViewConfiguration.get(activity).getScaledTouchSlop();
        this.q = new ScaleGestureDetector(activity, new C0088x1(this, 0));
    }

    public final void a(Canvas canvas) {
        Iterator it = this.f721b.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean z = next instanceof H2;
            Paint paint = this.f727h;
            if (z) {
                H2 h2 = (H2) next;
                b(h2.f124c, h2.f123b);
                canvas.drawPath(h2.f122a, paint);
            } else if (next instanceof O2) {
                O2 o2 = (O2) next;
                c(o2);
                canvas.drawText(o2.f241a, o2.f242b, o2.f243c, paint);
            }
        }
    }

    public final void b(float f2, int i2) {
        Paint paint = this.f727h;
        paint.reset();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(f2);
        paint.setColor(i2);
    }

    public final void c(O2 o2) {
        Paint paint = this.f727h;
        paint.reset();
        paint.setAntiAlias(true);
        paint.setTextSize(o2.f244d);
        paint.setColor(o2.f245e);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setShadowLayer(o2.f244d * 0.06f, 0.0f, 0.0f, -872415232);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(this.f725f);
        canvas.drawBitmap(this.f720a, 0.0f, 0.0f, (Paint) null);
        canvas.clipRect(0.0f, 0.0f, r0.getWidth(), r0.getHeight());
        a(canvas);
        Path path = this.f728i;
        if (path != null) {
            b(Math.max(r0.getWidth(), r0.getHeight()) * 0.009f, this.f723d);
            canvas.drawPath(path, this.f727h);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        float f2 = i2;
        Bitmap bitmap = this.f720a;
        float f3 = i3;
        float min = Math.min(f2 / bitmap.getWidth(), f3 / bitmap.getHeight());
        Matrix matrix = this.f725f;
        matrix.reset();
        matrix.postScale(min, min);
        matrix.postTranslate((f2 - (bitmap.getWidth() * min)) / 2.0f, (f3 - (bitmap.getHeight() * min)) / 2.0f);
        matrix.invert(this.f726g);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = this.f722c;
        ScaleGestureDetector scaleGestureDetector = this.q;
        if (!z) {
            scaleGestureDetector.onTouchEvent(motionEvent);
        }
        float[] fArr = {motionEvent.getX(), motionEvent.getY()};
        Matrix matrix = this.f726g;
        matrix.mapPoints(fArr);
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.f721b;
        O2 o2 = null;
        if (actionMasked == 0) {
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            this.f733n = motionEvent.getX();
            this.f734o = motionEvent.getY();
            this.f730k = false;
            float f2 = fArr[0];
            this.f731l = f2;
            float f3 = fArr[1];
            this.f732m = f3;
            if (this.f722c) {
                Path path = new Path();
                path.moveTo(fArr[0], fArr[1]);
                path.lineTo(fArr[0] + 0.01f, fArr[1]);
                this.f728i = path;
            } else {
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i2 = size - 1;
                        Object obj = arrayList.get(size);
                        O2 o22 = obj instanceof O2 ? (O2) obj : null;
                        if (o22 != null) {
                            c(o22);
                            float measureText = this.f727h.measureText(o22.f241a);
                            float f4 = o22.f244d;
                            float f5 = 0.3f * f4;
                            float f6 = o22.f242b;
                            if (f2 >= f6 - f5 && f2 <= f6 + measureText + f5) {
                                float f7 = o22.f243c;
                                if (f3 >= (f7 - f4) - f5 && f3 <= f7 + f5 + f5) {
                                    o2 = o22;
                                    break;
                                }
                            }
                        }
                        if (i2 < 0) {
                            break;
                        }
                        size = i2;
                    }
                }
                this.f729j = o2;
            }
            invalidate();
        } else if (actionMasked == 1) {
            if (this.f722c) {
                Path path2 = this.f728i;
                if (path2 != null) {
                    int i3 = this.f723d;
                    Bitmap bitmap = this.f720a;
                    arrayList.add(new H2(path2, i3, Math.max(bitmap.getWidth(), bitmap.getHeight()) * 0.009f));
                }
                this.f728i = null;
            } else {
                O2 o23 = this.f729j;
                if (o23 != null && !this.f730k) {
                    this.f724e.a(o23);
                }
            }
            this.f729j = null;
            invalidate();
        } else if (actionMasked == 2) {
            if (scaleGestureDetector.isInProgress()) {
                this.f730k = true;
            } else if (this.f722c) {
                Path path3 = this.f728i;
                if (path3 != null) {
                    float f8 = this.f731l;
                    float f9 = this.f732m;
                    path3.quadTo(f8, f9, (fArr[0] + f8) / 2.0f, (fArr[1] + f9) / 2.0f);
                }
                this.f731l = fArr[0];
                this.f732m = fArr[1];
            } else {
                O2 o24 = this.f729j;
                if (o24 != null && motionEvent.getPointerCount() == 1) {
                    float x = motionEvent.getX() - this.f733n;
                    float y = motionEvent.getY() - this.f734o;
                    float f10 = (y * y) + (x * x);
                    int i4 = this.p;
                    if (f10 > i4 * i4) {
                        this.f730k = true;
                    }
                    if (this.f730k) {
                        o24.f242b = (fArr[0] - this.f731l) + o24.f242b;
                        o24.f243c = (fArr[1] - this.f732m) + o24.f243c;
                    }
                }
                this.f731l = fArr[0];
                this.f732m = fArr[1];
            }
            invalidate();
        } else if (actionMasked == 3) {
            this.f728i = null;
            this.f729j = null;
            invalidate();
        } else if (actionMasked == 5) {
            this.f730k = true;
            this.f731l = fArr[0];
            this.f732m = fArr[1];
        } else if (actionMasked == 6) {
            int i5 = motionEvent.getActionIndex() == 0 ? 1 : 0;
            float[] fArr2 = {motionEvent.getX(i5), motionEvent.getY(i5)};
            matrix.mapPoints(fArr2);
            this.f731l = fArr2[0];
            this.f732m = fArr2[1];
            this.f730k = true;
        }
        return true;
    }
}
