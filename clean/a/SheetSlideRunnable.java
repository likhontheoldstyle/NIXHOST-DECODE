package a;

import android.view.animation.DecelerateInterpolator;

public final class SheetSlideRunnable implements Runnable {

    public final int mode;

    public final DraggableListSheetLayout sheet;

    public SheetSlideRunnable(DraggableListSheetLayout sheet, int i2) {
        this.mode = i2;
        this.sheet = sheet;
    }

    @Override
    public final void run() {
        switch (this.mode) {
            case 0:
                this.sheet.animate().translationY(0.0f).setDuration(300L).setInterpolator(new DecelerateInterpolator(1.8f)).start();
                break;
            default:
                this.sheet.onDismiss.a();
                break;
        }
    }
}
