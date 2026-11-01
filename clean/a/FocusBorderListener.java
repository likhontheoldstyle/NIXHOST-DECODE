package a;

import android.view.View;
import android.widget.EditText;
import com.nix.host.MainActivity;

public final class FocusBorderListener implements View.OnFocusChangeListener {

    public final int mode;

    public final EditText editText;

    public final MainActivity activity;

    public FocusBorderListener(EditText editText, MainActivity mainActivity, int i2) {
        this.mode = i2;
        this.editText = editText;
        this.activity = mainActivity;
    }

    @Override
    public final void onFocusChange(View view, boolean z) {
        EditText editText = this.editText;
        MainActivity mainActivity = this.activity;
        int i2 = -429290;
        switch (this.mode) {
            case 0:
                int i3 = MainActivity.R;
                boolean z2 = AppState.darkTheme;
                int i4 = z2 ? -15066598 : -394501;
                if (!z) {
                    i2 = z2 ? -12961222 : -1710101;
                }
                editText.setBackground(mainActivity.roundedBg(i4, 14, i2, 2));
                break;
            default:
                int i5 = MainActivity.R;
                editText.setBackground(mainActivity.roundedBg(-1, 16, z ? -429290 : -1710101, 2));
                break;
        }
    }
}
