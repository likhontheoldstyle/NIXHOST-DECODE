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

public final class ImageEditorView extends View {

    public static final int f719s = 0;

    public final Bitmap bitmap;

    public final ArrayList annotations;

    public boolean drawMode;

    public int brushColor;

    public h.b onTextTap;

    public final Matrix imageMatrix;

    public final Matrix inverseMatrix;

    public final Paint paint;

    public Path currentStrokePath;

    public ImageTextOverlay draggedText;

    public boolean dragMoved;

    public float lastBitmapX;

    public float lastBitmapY;

    public float touchStartX;

    public float touchStartY;

    public final int touchSlop;

    public final ScaleGestureDetector scaleDetector;

    public final MediaPicker picker;

    public ImageEditorView(MediaPicker mediaPicker, Bitmap bitmap) {
        super(mediaPicker.activity);
        this.picker = mediaPicker;
        Activity activity = mediaPicker.activity;
        this.bitmap = bitmap;
        this.annotations = new ArrayList();
        this.brushColor = -50384;
        this.onTextTap = new ValueFunction(0);
        this.imageMatrix = new Matrix();
        this.inverseMatrix = new Matrix();
        this.paint = new Paint(1);
        this.touchSlop = ViewConfiguration.get(activity).getScaledTouchSlop();
        this.scaleDetector = new ScaleGestureDetector(activity, new PinchScaleListener(this, 0));
    }

    public final void drawAnnotations(Canvas canvas) {
        Iterator it = this.annotations.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean z = next instanceof BrushStroke;
            Paint paint = this.paint;
            if (z) {
                BrushStroke brushStroke = (BrushStroke) next;
                configureStrokePaint(brushStroke.strokeWidth, brushStroke.color);
                canvas.drawPath(brushStroke.path, paint);
            } else if (next instanceof ImageTextOverlay) {
                ImageTextOverlay imageTextOverlay = (ImageTextOverlay) next;
                configureTextPaint(imageTextOverlay);
                canvas.drawText(imageTextOverlay.text, imageTextOverlay.x, imageTextOverlay.y, paint);
            }
        }
    }

    public final void configureStrokePaint(float f2, int i2) {
        Paint paint = this.paint;
        paint.reset();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(f2);
        paint.setColor(i2);
    }

    public final void configureTextPaint(ImageTextOverlay imageTextOverlay) {
        Paint paint = this.paint;
        paint.reset();
        paint.setAntiAlias(true);
        paint.setTextSize(imageTextOverlay.textSize);
        paint.setColor(imageTextOverlay.color);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setShadowLayer(imageTextOverlay.textSize * 0.06f, 0.0f, 0.0f, -872415232);
    }

    @Override
    public final void onDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(this.imageMatrix);
        canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.clipRect(0.0f, 0.0f, this.bitmap.getWidth(), this.bitmap.getHeight());
        drawAnnotations(canvas);
        Path path = this.currentStrokePath;
        if (path != null) {
            configureStrokePaint(Math.max(this.bitmap.getWidth(), this.bitmap.getHeight()) * 0.009f, this.brushColor);
            canvas.drawPath(path, this.paint);
        }
        canvas.restore();
    }

    @Override
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        float f2 = i2;
        Bitmap bitmap = this.bitmap;
        float f3 = i3;
        float min = Math.min(f2 / bitmap.getWidth(), f3 / bitmap.getHeight());
        Matrix matrix = this.imageMatrix;
        matrix.reset();
        matrix.postScale(min, min);
        matrix.postTranslate((f2 - (bitmap.getWidth() * min)) / 2.0f, (f3 - (bitmap.getHeight() * min)) / 2.0f);
        matrix.invert(this.inverseMatrix);
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = this.drawMode;
        ScaleGestureDetector scaleGestureDetector = this.scaleDetector;
        if (!z) {
            scaleGestureDetector.onTouchEvent(motionEvent);
        }
        float[] fArr = {motionEvent.getX(), motionEvent.getY()};
        Matrix matrix = this.inverseMatrix;
        matrix.mapPoints(fArr);
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.annotations;
        ImageTextOverlay imageTextOverlay = null;
        if (actionMasked == 0) {
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            this.touchStartX = motionEvent.getX();
            this.touchStartY = motionEvent.getY();
            this.dragMoved = false;
            float f2 = fArr[0];
            this.lastBitmapX = f2;
            float f3 = fArr[1];
            this.lastBitmapY = f3;
            if (this.drawMode) {
                Path path = new Path();
                path.moveTo(fArr[0], fArr[1]);
                path.lineTo(fArr[0] + 0.01f, fArr[1]);
                this.currentStrokePath = path;
            } else {
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i2 = size - 1;
                        Object obj = arrayList.get(size);
                        ImageTextOverlay imageTextOverlay2 = obj instanceof ImageTextOverlay ? (ImageTextOverlay) obj : null;
                        if (imageTextOverlay2 != null) {
                            configureTextPaint(imageTextOverlay2);
                            float measureText = this.paint.measureText(imageTextOverlay2.text);
                            float f4 = imageTextOverlay2.textSize;
                            float f5 = 0.3f * f4;
                            float f6 = imageTextOverlay2.x;
                            if (f2 >= f6 - f5 && f2 <= f6 + measureText + f5) {
                                float f7 = imageTextOverlay2.y;
                                if (f3 >= (f7 - f4) - f5 && f3 <= f7 + f5 + f5) {
                                    imageTextOverlay = imageTextOverlay2;
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
                this.draggedText = imageTextOverlay;
            }
            invalidate();
        } else if (actionMasked == 1) {
            if (this.drawMode) {
                Path path2 = this.currentStrokePath;
                if (path2 != null) {
                    int i3 = this.brushColor;
                    Bitmap bitmap = this.bitmap;
                    arrayList.add(new BrushStroke(path2, i3, Math.max(bitmap.getWidth(), bitmap.getHeight()) * 0.009f));
                }
                this.currentStrokePath = null;
            } else {
                ImageTextOverlay imageTextOverlay3 = this.draggedText;
                if (imageTextOverlay3 != null && !this.dragMoved) {
                    this.onTextTap.a(imageTextOverlay3);
                }
            }
            this.draggedText = null;
            invalidate();
        } else if (actionMasked == 2) {
            if (scaleGestureDetector.isInProgress()) {
                this.dragMoved = true;
            } else if (this.drawMode) {
                Path path3 = this.currentStrokePath;
                if (path3 != null) {
                    float f8 = this.lastBitmapX;
                    float f9 = this.lastBitmapY;
                    path3.quadTo(f8, f9, (fArr[0] + f8) / 2.0f, (fArr[1] + f9) / 2.0f);
                }
                this.lastBitmapX = fArr[0];
                this.lastBitmapY = fArr[1];
            } else {
                ImageTextOverlay imageTextOverlay4 = this.draggedText;
                if (imageTextOverlay4 != null && motionEvent.getPointerCount() == 1) {
                    float x = motionEvent.getX() - this.touchStartX;
                    float y = motionEvent.getY() - this.touchStartY;
                    float f10 = (y * y) + (x * x);
                    int i4 = this.touchSlop;
                    if (f10 > i4 * i4) {
                        this.dragMoved = true;
                    }
                    if (this.dragMoved) {
                        imageTextOverlay4.x = (fArr[0] - this.lastBitmapX) + imageTextOverlay4.x;
                        imageTextOverlay4.y = (fArr[1] - this.lastBitmapY) + imageTextOverlay4.y;
                    }
                }
                this.lastBitmapX = fArr[0];
                this.lastBitmapY = fArr[1];
            }
            invalidate();
        } else if (actionMasked == 3) {
            this.currentStrokePath = null;
            this.draggedText = null;
            invalidate();
        } else if (actionMasked == 5) {
            this.dragMoved = true;
            this.lastBitmapX = fArr[0];
            this.lastBitmapY = fArr[1];
        } else if (actionMasked == 6) {
            int i5 = motionEvent.getActionIndex() == 0 ? 1 : 0;
            float[] fArr2 = {motionEvent.getX(i5), motionEvent.getY(i5)};
            matrix.mapPoints(fArr2);
            this.lastBitmapX = fArr2[0];
            this.lastBitmapY = fArr2[1];
            this.dragMoved = true;
        }
        return true;
    }
}
