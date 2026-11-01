package a;

import android.content.SharedPreferences;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public final class SharedTextWatcher implements TextWatcher {

    public final int mode;

    public final Object target;

    public SharedTextWatcher(int i2, Object obj) {
        this.mode = i2;
        this.target = obj;
    }

    @Override
    public final void afterTextChanged(Editable editable) {
        String str;
        switch (this.mode) {
            case 0:
                ChatScreen chatScreen = (ChatScreen) this.target;
                chatScreen.updateSendButton();
                EditText editText = chatScreen.messageInput;
                if (editText == null) {
                    i.b.g("input");
                    throw null;
                }
                boolean z = !m.e.R(editText.getText().toString());
                long currentTimeMillis = System.currentTimeMillis();
                if (z) {
                    if (currentTimeMillis - chatScreen.lastSyncAt > 2500) {
                        chatScreen.lastSyncAt = currentTimeMillis;
                        chatScreen.syncing = true;
                        new Thread(new ChatSignalRunnable(0)).start();
                        return;
                    }
                    return;
                }
                if (chatScreen.syncing) {
                    chatScreen.syncing = false;
                    chatScreen.lastSyncAt = 0L;
                    new Thread(new ChatSignalRunnable(1)).start();
                    return;
                }
                return;
            case 1:
                CodeEditorView codeEditorView = (CodeEditorView) this.target;
                codeEditorView.recomputeLineStarts();
                codeEditorView.changeCounter++;
                Handler handler = codeEditorView.handler;
                TaskRunnable taskRunnable = codeEditorView.repaintTask;
                handler.removeCallbacks(taskRunnable);
                handler.postDelayed(taskRunnable, 450L);
                return;
            default:
                if (editable == null || (str = editable.toString()) == null) {
                    str = "";
                }
                int length = str.length();
                String str2 = (String) this.target;
                if (length == 0) {
                    SharedPreferences sharedPreferences = AppState.prefs;
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().remove(str2).apply();
                        return;
                    }
                    i.b.g("sp");
                    throw null;
                }
                SharedPreferences sharedPreferences2 = AppState.prefs;
                if (sharedPreferences2 != null) {
                    sharedPreferences2.edit().putString(str2, str).apply();
                    return;
                }
                i.b.g("sp");
                throw null;
        }
    }

    @Override
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        int i5 = this.mode;
    }

    @Override
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        int i5 = this.mode;
    }
}
