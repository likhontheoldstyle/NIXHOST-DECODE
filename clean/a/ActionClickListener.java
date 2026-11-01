package a;

import android.view.View;
import com.nix.host.MainActivity;

public final class ActionClickListener implements View.OnClickListener {

    public final int mode;

    public final h.a action;

    public ActionClickListener(h.a aVar, int i2) {
        this.mode = i2;
        this.action = aVar;
    }

    @Override
    public final void onClick(View view) {
        h.a aVar = this.action;
        switch (this.mode) {
            case 0:
                aVar.a();
                break;
            case 1:
                aVar.a();
                break;
            case 2:
                aVar.a();
                break;
            case 3:
                aVar.a();
                break;
            case 4:
                aVar.a();
                break;
            default:
                int i2 = MainActivity.R;
                aVar.a();
                break;
        }
    }
}
