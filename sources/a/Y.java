package a;

import android.app.Dialog;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public final /* synthetic */ class Y implements h.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f376a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f377b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f378c;

    public /* synthetic */ Y(C0006b1 c0006b1, Object obj, int i2) {
        this.f376a = i2;
        this.f377b = c0006b1;
        this.f378c = obj;
    }

    @Override // h.c
    public final Object a(Object obj, Object obj2) {
        switch (this.f376a) {
            case 0:
                LinearLayout linearLayout = (LinearLayout) obj;
                Dialog dialog = (Dialog) obj2;
                C0006b1 c0006b1 = this.f377b;
                linearLayout.addView(new View(c0006b1.f414a), new LinearLayout.LayoutParams(-1, c0006b1.z(6)));
                K0 k0 = (K0) this.f378c;
                c0006b1.O0(linearLayout, "trashf", "Delete for me", c0006b1.f425l, new W(dialog, c0006b1, k0, 3));
                c0006b1.O0(linearLayout, "trashf", "Delete for everyone", c0006b1.f425l, new W(dialog, c0006b1, k0, 4));
                break;
            default:
                LinearLayout linearLayout2 = (LinearLayout) obj;
                Dialog dialog2 = (Dialog) obj2;
                C0006b1 c0006b12 = this.f377b;
                TextView f1 = c0006b12.f1("Change name", 21.0f, c0006b12.f425l, true);
                f1.setGravity(17);
                linearLayout2.addView(f1, c0006b12.W(-1, -2, 0, 4, 0, 4));
                TextView f12 = c0006b12.f1("You can change your name once a week.", 14.5f, c0006b12.f426m, false);
                f12.setGravity(17);
                linearLayout2.addView(f12, c0006b12.W(-1, -2, 16, 0, 16, 12));
                EditText editText = new EditText(c0006b12.f414a);
                String str = (String) this.f378c;
                editText.setText(str);
                int i2 = c0006b12.f425l;
                editText.setTextColor(i2);
                editText.setTextSize(1, 19.251001f);
                editText.setBackground(c0006b12.N0(c0006b12.f429r, 6.0f, c0006b12.f419f ? -7697007 : -3420978, 1.0f));
                float f2 = 14;
                float f3 = 12;
                editText.setPadding(c0006b12.z(f2), c0006b12.z(f3), c0006b12.z(f2), c0006b12.z(f3));
                editText.setSingleLine(true);
                editText.setInputType(8193);
                editText.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(30)});
                linearLayout2.addView(editText, c0006b12.W(-1, -2, 16, 0, 16, 12));
                LinearLayout P = c0006b12.P();
                TextView f13 = c0006b12.f1("Cancel", 19.0f, i2, true);
                f13.setGravity(17);
                f13.setBackground(c0006b12.N0(c0006b12.f430s, 6.0f, 0, 0.0f));
                f13.setOnClickListener(new ViewOnClickListenerC0074t(0, dialog2));
                float f4 = 46;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, c0006b12.z(f4), 1.0f);
                float f5 = 8;
                layoutParams.rightMargin = c0006b12.z(f5);
                P.addView(f13, layoutParams);
                TextView f14 = c0006b12.f1("Save", 19.0f, -1, true);
                f14.setGravity(17);
                f14.setBackground(c0006b12.N0(c0006b12.f420g, 6.0f, 0, 0.0f));
                f14.setOnClickListener(new ViewOnClickListenerC0077u(editText, c0006b12, str, dialog2));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, c0006b12.z(f4), 1.0f);
                layoutParams2.leftMargin = c0006b12.z(f5);
                P.addView(f14, layoutParams2);
                linearLayout2.addView(P, c0006b12.W(-1, -2, 16, 0, 16, 12));
                editText.post(new RunnableC0080v(editText, c0006b12, 0));
                break;
        }
        return b.d.f770c;
    }
}
