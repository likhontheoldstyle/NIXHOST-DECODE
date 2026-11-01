package a;

import android.app.Dialog;
import android.widget.LinearLayout;
import com.nix.host.MainActivity;

public final class ConfirmDialogContent implements h.c {

    public final MainActivity activity;

    public final String title;

    public final String message;

    public final String confirmText;

    public final int confirmColor;

    public final h.a onConfirm;

    public ConfirmDialogContent(MainActivity mainActivity, String str, String str2, String str3, int i2, h.a aVar) {
        this.activity = mainActivity;
        this.title = str;
        this.message = str2;
        this.confirmText = str3;
        this.confirmColor = i2;
        this.onConfirm = aVar;
    }

    @Override
    public final Object a(Object obj, Object obj2) {
        LinearLayout linearLayout = (LinearLayout) obj;
        Dialog dialog = (Dialog) obj2;
        int i2 = MainActivity.R;
        int i3 = AppState.darkTheme ? -1 : -15656921;
        String str = this.title;
        MainActivity mainActivity = this.activity;
        linearLayout.addView(mainActivity.makeText(str, 22.0f, i3, true));
        linearLayout.addView(mainActivity.makeText(this.message, 16.0f, AppState.darkTheme ? -8618878 : -9735552, false), MainActivity.layoutParams(mainActivity, mainActivity.matchParent, mainActivity.wrapContent, 8, 0, 0, 56));
        linearLayout.addView(mainActivity.buttonRow(mainActivity.makeButton("Cancel", 0, AppState.darkTheme ? -1 : -15656921, true, new DismissAction(dialog, 7)), mainActivity.makeButton(this.confirmText, this.confirmColor, -1, false, new DismissAndRun(dialog, this.onConfirm, 0))), MainActivity.layoutParams(mainActivity, mainActivity.matchParent, mainActivity.wrapContent, 22, 0, 0, 56));
        return b.d.f770c;
    }
}
