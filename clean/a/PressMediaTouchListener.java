package a;

import android.view.MotionEvent;
import android.view.View;
import com.nix.host.MainActivity;

public final class PressMediaTouchListener implements View.OnTouchListener {
    @Override
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int i2 = MainActivity.R;
        int action = motionEvent.getAction();
        if (action == 0) {
            view.setAlpha(0.7f);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        view.setAlpha(1.0f);
        return false;
    }
}
