package a;

import android.app.Dialog;
import android.graphics.Typeface;
import android.view.View;
import android.widget.EditText;
import com.nix.host.MainActivity;

public final class TripleClickListener implements View.OnClickListener {

    public final int mode;

    public final Object first;

    public final Object second;

    public final Object third;

    public TripleClickListener(Object obj, Object obj2, Object obj3, int i2) {
        this.mode = i2;
        this.first = obj;
        this.second = obj2;
        this.third = obj3;
    }

    @Override
    public final void onClick(View view) {
        Object obj = this.third;
        Object obj2 = this.second;
        Object obj3 = this.first;
        switch (this.mode) {
            case 0:
                h.a aVar = (h.a) obj3;
                if (aVar == null) {
                    ((ChatScreen) obj2).showMessageInfo(null, (String) obj);
                    break;
                } else {
                    aVar.a();
                    break;
                }
            case 1:
                ((Dialog) obj3).dismiss();
                ((h.b) obj2).a((String) obj);
                break;
            default:
                int i2 = MainActivity.R;
                i.d dVar = (i.d) obj3;
                dVar.f846a = !dVar.f846a;
                EditText editText = (EditText) obj2;
                int selectionEnd = editText.getSelectionEnd();
                editText.setInputType((dVar.f846a ? 144 : 128) | 1);
                editText.setTypeface(Typeface.DEFAULT);
                if (selectionEnd >= 0) {
                    editText.setSelection(selectionEnd);
                }
                ((IconView) obj).setIcon(dVar.f846a ? "eyeoff" : "eye");
                break;
        }
    }
}
