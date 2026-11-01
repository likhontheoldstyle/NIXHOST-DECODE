package a;

import android.app.Dialog;
import com.nix.host.MainActivity;

public final class DismissAction implements h.a {

    public final int mode;

    public final Dialog dialog;

    public DismissAction(Dialog dialog, int i2) {
        this.mode = i2;
        this.dialog = dialog;
    }

    @Override
    public final Object a() {
        Dialog dialog = this.dialog;
        switch (this.mode) {
            case 0:
                dialog.dismiss();
                break;
            case 1:
                dialog.dismiss();
                break;
            case 2:
                dialog.dismiss();
                break;
            case 3:
                dialog.dismiss();
                break;
            case 4:
                dialog.dismiss();
                break;
            case 5:
                int i2 = MainActivity.R;
                dialog.dismiss();
                break;
            case 6:
                int i3 = MainActivity.R;
                dialog.dismiss();
                break;
            case 7:
                int i4 = MainActivity.R;
                dialog.dismiss();
                break;
            case 8:
                int i5 = MainActivity.R;
                dialog.dismiss();
                break;
            case 9:
                int i6 = MainActivity.R;
                dialog.dismiss();
                break;
            default:
                int i7 = MainActivity.R;
                dialog.dismiss();
                break;
        }
        return b.d.f770c;
    }
}
