package a;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.nix.host.MainActivity;
import java.io.Serializable;

/* loaded from: classes.dex */
public final /* synthetic */ class L1 implements h.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f191a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f192b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f193c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Serializable f194d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f195e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f196f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f197g;

    public /* synthetic */ L1(s2 s2Var, i.d dVar, MainActivity mainActivity, G1 g1, View view, FrameLayout frameLayout) {
        this.f193c = s2Var;
        this.f194d = dVar;
        this.f192b = mainActivity;
        this.f195e = g1;
        this.f196f = view;
        this.f197g = frameLayout;
    }

    @Override // h.c
    public final Object a(Object obj, Object obj2) {
        Object obj3 = this.f197g;
        Object obj4 = this.f195e;
        Object obj5 = this.f196f;
        Serializable serializable = this.f194d;
        Object obj6 = this.f193c;
        switch (this.f191a) {
            case 0:
                LinearLayout linearLayout = (LinearLayout) obj;
                Dialog dialog = (Dialog) obj2;
                int i2 = MainActivity.R;
                int i3 = AbstractC0008c.f442e ? -1 : -15656921;
                MainActivity mainActivity = this.f192b;
                linearLayout.addView(mainActivity.U((String) obj6, 22.0f, i3, true));
                EditText editText = new EditText(mainActivity);
                editText.setHint((String) serializable);
                editText.setText((String) obj4);
                editText.setHintTextColor(AbstractC0008c.f442e ? -8618878 : -9735552);
                editText.setTextColor(AbstractC0008c.f442e ? -1 : -15656921);
                editText.setTextSize(1, mainActivity.K * 17.0f);
                editText.setSingleLine(true);
                boolean z = AbstractC0008c.f442e;
                editText.setBackground(mainActivity.I(z ? -15066598 : -394501, 14, z ? -12961222 : -1710101, 2));
                editText.setPadding(mainActivity.n(16), mainActivity.n(14), mainActivity.n(16), mainActivity.n(14));
                editText.setInputType(524289);
                editText.setOnFocusChangeListener(new Y1(editText, mainActivity, 0));
                linearLayout.addView(editText, MainActivity.v(mainActivity, mainActivity.f781a, mainActivity.f782b, 16, 0, 0, 56));
                linearLayout.addView(mainActivity.f(mainActivity.m("Cancel", 0, AbstractC0008c.f442e ? -1 : -15656921, true, new C0060p(dialog, 8)), mainActivity.m((String) obj5, -429290, -1, false, new C0071s(editText, mainActivity, dialog, (h.b) obj3, 4))), MainActivity.v(mainActivity, mainActivity.f781a, mainActivity.f782b, 18, 0, 0, 56));
                editText.setSelection(editText.getText().length());
                break;
            default:
                float floatValue = ((Float) obj).floatValue();
                float floatValue2 = ((Float) obj2).floatValue();
                int i4 = MainActivity.R;
                s2 s2Var = (s2) obj6;
                float max = Math.max(1.0f, s2Var.getHeight());
                i.d dVar = (i.d) serializable;
                if (!dVar.f846a) {
                    View view = (View) obj5;
                    if (floatValue > 0.25f * max || floatValue2 > 1200.0f) {
                        MainActivity.b((G1) obj4, s2Var, view, (FrameLayout) obj3, this.f192b, new C0(2), dVar);
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

    public /* synthetic */ L1(MainActivity mainActivity, String str, String str2, String str3, String str4, h.b bVar) {
        this.f192b = mainActivity;
        this.f193c = str;
        this.f194d = str2;
        this.f195e = str3;
        this.f196f = str4;
        this.f197g = bVar;
    }
}
