package a;

import android.view.View;
import android.widget.LinearLayout;
import com.nix.host.MainActivity;

public final class PanelToggleAction implements h.a {

    public final int mode;

    public final LinearLayout panel;

    public final MainActivity activity;

    public PanelToggleAction(LinearLayout linearLayout, MainActivity mainActivity, int i2) {
        this.mode = i2;
        this.panel = linearLayout;
        this.activity = mainActivity;
    }

    @Override
    public final Object a() {
        MainActivity mainActivity = this.activity;
        LinearLayout linearLayout = this.panel;
        switch (this.mode) {
            case 0:
                int i2 = MainActivity.R;
                if (linearLayout.getVisibility() == 0) {
                    mainActivity.hidePopupMenu();
                } else {
                    LinearLayout linearLayout2 = mainActivity.popupMenu;
                    if (linearLayout2 != null) {
                        View view = mainActivity.popupScrim;
                        if (view != null) {
                            view.setVisibility(0);
                        }
                        linearLayout2.setVisibility(0);
                        linearLayout2.setAlpha(0.0f);
                        linearLayout2.animate().alpha(1.0f).setDuration(120L).start();
                    }
                }
                break;
            default:
                int i3 = MainActivity.R;
                if (linearLayout.getVisibility() == 0) {
                    mainActivity.hideTermKeys();
                } else {
                    LinearLayout linearLayout3 = mainActivity.termKeysPanel;
                    if (linearLayout3 != null) {
                        View view2 = mainActivity.termScrim;
                        if (view2 != null) {
                            view2.setVisibility(0);
                        }
                        linearLayout3.setVisibility(0);
                        linearLayout3.setAlpha(0.0f);
                        linearLayout3.setTranslationY(-mainActivity.dp(24));
                        linearLayout3.animate().alpha(1.0f).translationY(0.0f).setDuration(160L).start();
                    }
                }
                break;
        }
        return b.d.f770c;
    }
}
