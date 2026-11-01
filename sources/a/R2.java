package a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewParent;
import android.widget.ImageView;

/* loaded from: classes.dex */
public final class R2 extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f291a;

    /* renamed from: b, reason: collision with root package name */
    public final RectF f292b;

    /* renamed from: c, reason: collision with root package name */
    public float f293c;

    /* renamed from: d, reason: collision with root package name */
    public final float f294d;

    /* renamed from: e, reason: collision with root package name */
    public final float f295e;

    /* renamed from: f, reason: collision with root package name */
    public float f296f;

    /* renamed from: g, reason: collision with root package name */
    public float f297g;

    /* renamed from: h, reason: collision with root package name */
    public final ScaleGestureDetector f298h;

    /* renamed from: i, reason: collision with root package name */
    public final GestureDetector f299i;

    public R2(Context context) {
        super(context);
        this.f291a = new Matrix();
        this.f292b = new RectF();
        this.f293c = 1.0f;
        this.f294d = 0.5f;
        this.f295e = 6.0f;
        this.f298h = new ScaleGestureDetector(context, new C0088x1(this, 1));
        this.f299i = new GestureDetector(context, new Q2(this));
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public static final void a(R2 r2, float f2, float f3, float f4) {
        float b2 = AbstractC0008c.b(r2.f293c * f2, r2.f294d, r2.f295e);
        float f5 = b2 / r2.f293c;
        Matrix matrix = r2.f291a;
        matrix.postScale(f5, f5, f3, f4);
        r2.f293c = b2;
        r2.b();
        r2.setImageMatrix(matrix);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b() {
        float f2;
        float width;
        float f3;
        float height;
        float f4;
        if (getDrawable() == null) {
            return;
        }
        RectF rectF = this.f292b;
        float f5 = 0.0f;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        Matrix matrix = this.f291a;
        matrix.mapRect(rectF);
        if (rectF.width() > getWidth()) {
            float f6 = rectF.left;
            if (f6 > 0.0f) {
                f2 = -f6;
            } else if (rectF.right < getWidth()) {
                width = getWidth();
                f3 = rectF.right;
            } else {
                f2 = 0.0f;
            }
            if (rectF.height() <= getHeight()) {
                float f7 = rectF.top;
                if (f7 > 0.0f) {
                    f5 = -f7;
                } else if (rectF.bottom < getHeight()) {
                    height = getHeight();
                    f4 = rectF.bottom;
                }
                matrix.postTranslate(f2, f5);
            }
            height = (getHeight() - rectF.height()) / 2.0f;
            f4 = rectF.top;
            f5 = height - f4;
            matrix.postTranslate(f2, f5);
        }
        width = (getWidth() - rectF.width()) / 2.0f;
        f3 = rectF.left;
        f2 = width - f3;
        if (rectF.height() <= getHeight()) {
        }
        f5 = height - f4;
        matrix.postTranslate(f2, f5);
    }

    public final void c() {
        Drawable drawable = getDrawable();
        if (drawable == null || getWidth() == 0 || getHeight() == 0 || drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        float min = Math.min(getWidth() / intrinsicWidth, getHeight() / intrinsicHeight);
        Matrix matrix = this.f291a;
        matrix.reset();
        matrix.postScale(min, min);
        matrix.postTranslate((getWidth() - (intrinsicWidth * min)) / 2.0f, (getHeight() - (intrinsicHeight * min)) / 2.0f);
        this.f293c = 1.0f;
        setImageMatrix(matrix);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        c();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        this.f299i.onTouchEvent(motionEvent);
        ScaleGestureDetector scaleGestureDetector = this.f298h;
        scaleGestureDetector.onTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f296f = motionEvent.getX();
            this.f297g = motionEvent.getY();
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        } else if (actionMasked == 2) {
            if (!scaleGestureDetector.isInProgress() && motionEvent.getPointerCount() == 1) {
                Matrix matrix = this.f291a;
                matrix.postTranslate(motionEvent.getX() - this.f296f, motionEvent.getY() - this.f297g);
                b();
                setImageMatrix(matrix);
            }
            this.f296f = motionEvent.getX();
            this.f297g = motionEvent.getY();
        } else if (actionMasked == 5) {
            this.f296f = motionEvent.getX();
            this.f297g = motionEvent.getY();
        } else if (actionMasked == 6) {
            int i2 = motionEvent.getActionIndex() == 0 ? 1 : 0;
            this.f296f = motionEvent.getX(i2);
            this.f297g = motionEvent.getY(i2);
        }
        return true;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        c();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        c();
    }
}
