package a;

import android.view.ScaleGestureDetector;
import android.view.View;

public final class PinchScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

    public final int mode;

    public final View targetView;

    public PinchScaleListener(View view, int i2) {
        this.mode = i2;
        this.targetView = view;
    }

    @Override
    public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        switch (this.mode) {
            case 0:
                ImageEditorView imageEditorView = (ImageEditorView) this.targetView;
                ImageTextOverlay imageTextOverlay = imageEditorView.draggedText;
                if (imageTextOverlay != null) {
                    imageTextOverlay.textSize = AppState.b(scaleGestureDetector.getScaleFactor() * imageTextOverlay.textSize, imageEditorView.bitmap.getWidth() * 0.03f, imageEditorView.bitmap.getWidth() * 0.4f);
                }
                imageEditorView.invalidate();
                break;
            default:
                ZoomableImageView.a((ZoomableImageView) this.targetView, scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                break;
        }
        return true;
    }
}
