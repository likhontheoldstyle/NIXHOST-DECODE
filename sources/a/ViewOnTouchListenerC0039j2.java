package a;

import android.view.MotionEvent;
import android.view.View;
import com.nix.host.MainActivity;

/* renamed from: a.j2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class ViewOnTouchListenerC0039j2 implements View.OnTouchListener {
    @Override // android.view.View.OnTouchListener
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
