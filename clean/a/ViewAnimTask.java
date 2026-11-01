package a;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.nix.host.MainActivity;

public final class ViewAnimTask implements Runnable {

    public final int mode;

    public final View view;

    public ViewAnimTask(View view, int i2) {
        this.mode = i2;
        this.view = view;
    }

    @Override
    public final void run() {
        View view = this.view;
        switch (this.mode) {
            case 0:
                view.animate().translationY(0.0f).setDuration(300L).setInterpolator(new DecelerateInterpolator(1.8f)).start();
                break;
            default:
                int i2 = MainActivity.R;
                view.setVisibility(8);
                break;
        }
    }
}
