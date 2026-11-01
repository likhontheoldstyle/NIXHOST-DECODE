package a;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public final class FocusInputRunnable implements Runnable {

    public final int mode;

    public final EditText editText;

    public final ChatScreen chatScreen;

    public FocusInputRunnable(EditText editText, ChatScreen chatScreen, int i2) {
        this.mode = i2;
        this.editText = editText;
        this.chatScreen = chatScreen;
    }

    @Override
    public final void run() {
        switch (this.mode) {
            case 0:
                EditText editText = this.editText;
                editText.requestFocus();
                editText.setSelection(editText.length());
                Object systemService = this.chatScreen.activity.getSystemService("input_method");
                i.b.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                ((InputMethodManager) systemService).showSoftInput(editText, 1);
                break;
            default:
                EditText editText2 = this.editText;
                editText2.requestFocus();
                editText2.setSelection(editText2.length());
                Object systemService2 = this.chatScreen.activity.getSystemService("input_method");
                i.b.c(systemService2, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                ((InputMethodManager) systemService2).showSoftInput(editText2, 1);
                break;
        }
    }
}
