package a;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.nix.host.MainActivity;
import java.io.Serializable;

public final class DialogContent implements h.c {

    public final int mode;

    public final MainActivity activity;

    public final Object first;

    public final Serializable second;

    public final Object third;

    public final Object fourth;

    public final Object fifth;

    public DialogContent(DragSheetLayout s2Var, i.d dVar, MainActivity mainActivity, IconView g1, View view, FrameLayout frameLayout) {
        this.mode = 1;
        this.first = s2Var;
        this.second = dVar;
        this.activity = mainActivity;
        this.third = g1;
        this.fourth = view;
        this.fifth = frameLayout;
    }

    @Override
    public final Object a(Object obj, Object obj2) {
        Object obj3 = this.fifth;
        Object obj4 = this.third;
        Object obj5 = this.fourth;
        Serializable serializable = this.second;
        Object obj6 = this.first;
        switch (this.mode) {
            case 0:
                LinearLayout linearLayout = (LinearLayout) obj;
                Dialog dialog = (Dialog) obj2;
                int i2 = MainActivity.R;
                int i3 = AppState.darkTheme ? -1 : -15656921;
                MainActivity mainActivity = this.activity;
                linearLayout.addView(mainActivity.makeText((String) obj6, 22.0f, i3, true));
                EditText editText = new EditText(mainActivity);
                editText.setHint((String) serializable);
                editText.setText((String) obj4);
                editText.setHintTextColor(AppState.darkTheme ? -8618878 : -9735552);
                editText.setTextColor(AppState.darkTheme ? -1 : -15656921);
                editText.setTextSize(1, mainActivity.uiScale * 17.0f);
                editText.setSingleLine(true);
                boolean z = AppState.darkTheme;
                editText.setBackground(mainActivity.roundedBg(z ? -15066598 : -394501, 14, z ? -12961222 : -1710101, 2));
                editText.setPadding(mainActivity.dp(16), mainActivity.dp(14), mainActivity.dp(16), mainActivity.dp(14));
                editText.setInputType(524289);
                editText.setOnFocusChangeListener(new FocusBorderListener(editText, mainActivity, 0));
                linearLayout.addView(editText, MainActivity.layoutParams(mainActivity, mainActivity.matchParent, mainActivity.wrapContent, 16, 0, 0, 56));
                linearLayout.addView(mainActivity.buttonRow(mainActivity.makeButton("Cancel", 0, AppState.darkTheme ? -1 : -15656921, true, new DismissAction(dialog, 8)), mainActivity.makeButton((String) obj5, -429290, -1, false, new ActionCallback(editText, mainActivity, dialog, (h.b) obj3, 4))), MainActivity.layoutParams(mainActivity, mainActivity.matchParent, mainActivity.wrapContent, 18, 0, 0, 56));
                editText.setSelection(editText.getText().length());
                break;
            default:
                float floatValue = ((Float) obj).floatValue();
                float floatValue2 = ((Float) obj2).floatValue();
                int i4 = MainActivity.R;
                DragSheetLayout s2Var = (DragSheetLayout) obj6;
                float max = Math.max(1.0f, s2Var.getHeight());
                i.d dVar = (i.d) serializable;
                if (!dVar.f846a) {
                    View view = (View) obj5;
                    if (floatValue > 0.25f * max || floatValue2 > 1200.0f) {
                        MainActivity.animateEmojiPanelClose((IconView) obj4, s2Var, view, (FrameLayout) obj3, this.activity, new C0(2), dVar);
                    } else {
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(floatValue, 0.0f);
                        ofFloat.setDuration(180L);
                        ofFloat.addUpdateListener(new J1(s2Var, view, max));
                        ofFloat.start();
                    }
                }
                break;
        }
        return b.d.f770c;
    }

    public DialogContent(MainActivity mainActivity, String str, String str2, String str3, String str4, h.b bVar) {
        this.mode = 0;
        this.activity = mainActivity;
        this.first = str;
        this.second = str2;
        this.third = str3;
        this.fourth = str4;
        this.fifth = bVar;
    }
}
