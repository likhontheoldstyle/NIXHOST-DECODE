package a;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public final /* synthetic */ class W implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f348a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Dialog f349b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f350c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ K0 f351d;

    public /* synthetic */ W(Dialog dialog, C0006b1 c0006b1, K0 k0, int i2) {
        this.f348a = i2;
        this.f349b = dialog;
        this.f350c = c0006b1;
        this.f351d = k0;
    }

    @Override // h.a
    public final Object a() {
        switch (this.f348a) {
            case 0:
                this.f349b.dismiss();
                C0006b1 c0006b1 = this.f350c;
                Object systemService = c0006b1.f414a.getSystemService("clipboard");
                i.b.c(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("message", this.f351d.f153d));
                c0006b1.f416c.a("Copied");
                break;
            case 1:
                this.f349b.dismiss();
                final C0006b1 c0006b12 = this.f350c;
                c0006b12.getClass();
                final K0 k0 = this.f351d;
                final String str = k0.f153d;
                c0006b12.l(true, new h.c() { // from class: a.c0
                    @Override // h.c
                    public final Object a(Object obj, Object obj2) {
                        LinearLayout linearLayout = (LinearLayout) obj;
                        Dialog dialog = (Dialog) obj2;
                        C0006b1 c0006b13 = C0006b1.this;
                        LinearLayout P = c0006b13.P();
                        float f2 = 8;
                        P.setPadding(c0006b13.z(16), c0006b13.z(2), c0006b13.z(f2), c0006b13.z(f2));
                        int i2 = c0006b13.f425l;
                        P.addView(c0006b13.f1("Edit message", 21.0f, i2, false), new LinearLayout.LayoutParams(0, -2, 1.0f));
                        Activity activity = c0006b13.f414a;
                        FrameLayout frameLayout = new FrameLayout(activity);
                        float f3 = 22;
                        frameLayout.addView(new G1(activity, "close", i2, 2.2f), new FrameLayout.LayoutParams(c0006b13.z(f3), c0006b13.z(f3), 17));
                        frameLayout.setOnClickListener(new ViewOnClickListenerC0074t(2, dialog));
                        float f4 = 44;
                        P.addView(frameLayout, C0006b1.X(c0006b13, c0006b13.z(f4), c0006b13.z(f4), 0, 0, 0, 60));
                        linearLayout.addView(P, C0006b1.X(c0006b13, -1, -2, 0, 0, 0, 60));
                        linearLayout.addView(c0006b13.y());
                        LinearLayout P2 = c0006b13.P();
                        float f5 = 12;
                        P2.setPadding(c0006b13.z(f5), c0006b13.z(f5), c0006b13.z(f5), c0006b13.z(14));
                        EditText editText = new EditText(activity);
                        String str2 = str;
                        editText.setText(str2);
                        editText.setTextColor(i2);
                        editText.setTextSize(1, 19.251001f);
                        editText.setBackground(c0006b13.N0(c0006b13.f430s, 26.0f, c0006b13.f419f ? -7697007 : -4407100, 1.0f));
                        float f6 = 18;
                        float f7 = 10;
                        editText.setPadding(c0006b13.z(f6), c0006b13.z(f7), c0006b13.z(f6), c0006b13.z(f7));
                        editText.setInputType(147457);
                        editText.setMaxLines(5);
                        P2.addView(editText, new LinearLayout.LayoutParams(0, -2, 1.0f));
                        FrameLayout frameLayout2 = new FrameLayout(activity);
                        C1 M = c0006b13.M("checkf", -11907758, 26);
                        float f8 = 26;
                        frameLayout2.addView(M, new FrameLayout.LayoutParams(c0006b13.z(f8), c0006b13.z(f8), 17));
                        float f9 = 46;
                        P2.addView(frameLayout2, C0006b1.X(c0006b13, c0006b13.z(f9), c0006b13.z(f9), 10, 0, 0, 56));
                        C0006b1.B(frameLayout2, c0006b13, M, editText, str2);
                        editText.addTextChangedListener(new S0(frameLayout2, c0006b13, M, editText, str2));
                        frameLayout2.setOnClickListener(new V(editText, dialog, c0006b13, k0, str2));
                        linearLayout.addView(P2, C0006b1.X(c0006b13, -1, -2, 0, 0, 0, 60));
                        editText.post(new RunnableC0080v(editText, c0006b13, 1));
                        return b.d.f770c;
                    }
                });
                break;
            case 2:
                this.f349b.dismiss();
                this.f350c.L0(this.f351d);
                break;
            case 3:
                this.f349b.dismiss();
                C0006b1 c0006b13 = this.f350c;
                c0006b13.getClass();
                c0006b13.u("Delete?", "Are you sure you want to delete this message?", "No", "Yes", new C0005b0(c0006b13, this.f351d, 0));
                break;
            default:
                this.f349b.dismiss();
                C0006b1 c0006b14 = this.f350c;
                c0006b14.getClass();
                c0006b14.u("Delete for everyone?", "This message will be permanently removed for everyone in this chat. They will see that you deleted a message and will still be able to report it.", "Cancel", "Delete", new C0005b0(c0006b14, this.f351d, 2));
                break;
        }
        return b.d.f770c;
    }
}
