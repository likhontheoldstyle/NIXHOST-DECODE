package a;

import android.view.GestureDetector;
import android.view.MotionEvent;

public final class DoubleTapZoomListener extends GestureDetector.SimpleOnGestureListener {

    public final ZoomableImageView zoomView;

    public DoubleTapZoomListener(ZoomableImageView zoomableImageView) {
        this.zoomView = zoomableImageView;
    }

    @Override
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        ZoomableImageView zoomableImageView = this.zoomView;
        float f2 = zoomableImageView.scale;
        if (f2 > 1.05f || f2 < 0.95f) {
            zoomableImageView.c();
            return true;
        }
        ZoomableImageView.a(zoomableImageView, 2.5f, motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override
    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }
}
