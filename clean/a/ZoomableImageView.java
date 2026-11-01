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

public final class ZoomableImageView extends ImageView {

    public final Matrix matrix;

    public final RectF drawableRect;

    public float scale;

    public final float minScale;

    public final float maxScale;

    public float lastX;

    public float lastY;

    public final ScaleGestureDetector scaleDetector;

    public final GestureDetector gestureDetector;

    public ZoomableImageView(Context context) {
        super(context);
        this.matrix = new Matrix();
        this.drawableRect = new RectF();
        this.scale = 1.0f;
        this.minScale = 0.5f;
        this.maxScale = 6.0f;
        this.scaleDetector = new ScaleGestureDetector(context, new PinchScaleListener(this, 1));
        this.gestureDetector = new GestureDetector(context, new DoubleTapZoomListener(this));
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public static final void applyScale(ZoomableImageView r2, float f2, float f3, float f4) {
        float b2 = AppState.b(r2.scale * f2, r2.minScale, r2.maxScale);
        float f5 = b2 / r2.scale;
        Matrix matrix = r2.matrix;
        matrix.postScale(f5, f5, f3, f4);
        r2.scale = b2;
        r2.clampBounds();
        r2.setImageMatrix(matrix);
    }

    public final void clampBounds() {
        float f2;
        float width;
        float f3;
        float height;
        float f4;
        if (getDrawable() == null) {
            return;
        }
        RectF rectF = this.drawableRect;
        float f5 = 0.0f;
        rectF.set(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
        Matrix matrix = this.matrix;
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

    public final void fitToView() {
        Drawable drawable = getDrawable();
        if (drawable == null || getWidth() == 0 || getHeight() == 0 || drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        float min = Math.min(getWidth() / intrinsicWidth, getHeight() / intrinsicHeight);
        Matrix matrix = this.matrix;
        matrix.reset();
        matrix.postScale(min, min);
        matrix.postTranslate((getWidth() - (intrinsicWidth * min)) / 2.0f, (getHeight() - (intrinsicHeight * min)) / 2.0f);
        this.scale = 1.0f;
        setImageMatrix(matrix);
    }

    @Override
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        fitToView();
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        this.gestureDetector.onTouchEvent(motionEvent);
        ScaleGestureDetector scaleGestureDetector = this.scaleDetector;
        scaleGestureDetector.onTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.lastX = motionEvent.getX();
            this.lastY = motionEvent.getY();
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        } else if (actionMasked == 2) {
            if (!scaleGestureDetector.isInProgress() && motionEvent.getPointerCount() == 1) {
                Matrix matrix = this.matrix;
                matrix.postTranslate(motionEvent.getX() - this.lastX, motionEvent.getY() - this.lastY);
                clampBounds();
                setImageMatrix(matrix);
            }
            this.lastX = motionEvent.getX();
            this.lastY = motionEvent.getY();
        } else if (actionMasked == 5) {
            this.lastX = motionEvent.getX();
            this.lastY = motionEvent.getY();
        } else if (actionMasked == 6) {
            int i2 = motionEvent.getActionIndex() == 0 ? 1 : 0;
            this.lastX = motionEvent.getX(i2);
            this.lastY = motionEvent.getY(i2);
        }
        return true;
    }

    @Override
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        fitToView();
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        fitToView();
    }
}
