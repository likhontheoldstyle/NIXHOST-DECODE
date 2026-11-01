package a;

import android.app.Dialog;
import android.graphics.Typeface;
import android.view.View;
import android.widget.EditText;
import com.nix.host.MainActivity;

/* renamed from: a.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class ViewOnClickListenerC0016e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f453a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f454b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f455c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f456d;

    public /* synthetic */ ViewOnClickListenerC0016e(Object obj, Object obj2, Object obj3, int i2) {
        this.f453a = i2;
        this.f455c = obj;
        this.f456d = obj2;
        this.f454b = obj3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object obj = this.f454b;
        Object obj2 = this.f456d;
        Object obj3 = this.f455c;
        switch (this.f453a) {
            case 0:
                h.a aVar = (h.a) obj3;
                if (aVar == null) {
                    ((C0006b1) obj2).m1(null, (String) obj);
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
                ((G1) obj).set(dVar.f846a ? "eyeoff" : "eye");
                break;
        }
    }
}
