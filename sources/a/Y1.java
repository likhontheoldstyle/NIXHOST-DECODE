package a;

import android.view.View;
import android.widget.EditText;
import com.nix.host.MainActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class Y1 implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f384a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EditText f385b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MainActivity f386c;

    public /* synthetic */ Y1(EditText editText, MainActivity mainActivity, int i2) {
        this.f384a = i2;
        this.f385b = editText;
        this.f386c = mainActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        EditText editText = this.f385b;
        MainActivity mainActivity = this.f386c;
        int i2 = -429290;
        switch (this.f384a) {
            case 0:
                int i3 = MainActivity.R;
                boolean z2 = AbstractC0008c.f442e;
                int i4 = z2 ? -15066598 : -394501;
                if (!z) {
                    i2 = z2 ? -12961222 : -1710101;
                }
                editText.setBackground(mainActivity.I(i4, 14, i2, 2));
                break;
            default:
                int i5 = MainActivity.R;
                editText.setBackground(mainActivity.I(-1, 16, z ? -429290 : -1710101, 2));
                break;
        }
    }
}
