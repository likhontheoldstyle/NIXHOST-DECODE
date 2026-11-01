package a;

import android.app.Dialog;
import com.nix.host.MainActivity;

public final class DismissAndRun implements h.a {

    public final int mode;

    public final Dialog dialog;

    public final h.a action;

    public DismissAndRun(Dialog dialog, h.a aVar, int i2) {
        this.mode = i2;
        this.dialog = dialog;
        this.action = aVar;
    }

    @Override
    public final Object a() {
        h.a aVar = this.action;
        Dialog dialog = this.dialog;
        switch (this.mode) {
            case 0:
                int i2 = MainActivity.R;
                dialog.dismiss();
                aVar.a();
                break;
            default:
                int i3 = MainActivity.R;
                dialog.dismiss();
                aVar.a();
                break;
        }
        return b.d.f770c;
    }
}
