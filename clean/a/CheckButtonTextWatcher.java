package a;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.FrameLayout;

public final class CheckButtonTextWatcher implements TextWatcher {

    public final FrameLayout checkButtonFrame;

    public final ChatScreen chatScreen;

    public final ChatIconView checkIcon;

    public final EditText editText;

    public final String originalText;

    public CheckButtonTextWatcher(FrameLayout frameLayout, ChatScreen chatScreen, ChatIconView chatIconView, EditText editText, String str) {
        this.checkButtonFrame = frameLayout;
        this.chatScreen = chatScreen;
        this.checkIcon = chatIconView;
        this.editText = editText;
        this.originalText = str;
    }

    @Override
    public final void afterTextChanged(Editable editable) {
        ChatScreen.updateEditSaveButton(this.checkButtonFrame, this.chatScreen, this.checkIcon, this.editText, this.originalText);
    }

    @Override
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
