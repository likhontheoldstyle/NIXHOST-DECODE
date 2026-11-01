package a;

import android.app.Dialog;
import android.view.View;
import android.widget.LinearLayout;

public final class DialogDismissClickListener implements View.OnClickListener {

    public final int mode;

    public final Object target;

    public DialogDismissClickListener(int i2, Object obj) {
        this.mode = i2;
        this.target = obj;
    }

    @Override
    public final void onClick(View view) {
        switch (this.mode) {
            case 0:
                ((Dialog) this.target).dismiss();
                return;
            case 1:
                ((Dialog) this.target).dismiss();
                return;
            case 2:
                ((Dialog) this.target).dismiss();
                return;
            default:
                LinearLayout linearLayout = ((ChatScreen) this.target).emojiPanel;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    return;
                } else {
                    i.b.g("panel");
                    throw null;
                }
        }
    }
}
