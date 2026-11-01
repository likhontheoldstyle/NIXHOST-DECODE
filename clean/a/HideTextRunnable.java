package a;

import android.widget.TextView;

public final class HideTextRunnable implements Runnable {

    public final int mode;

    public final TextView textView;

    public HideTextRunnable(TextView textView, int i2) {
        this.mode = i2;
        this.textView = textView;
    }

    @Override
    public final void run() {
        switch (this.mode) {
            case 0:
                this.textView.setVisibility(8);
                break;
            default:
                this.textView.setVisibility(8);
                break;
        }
    }
}
