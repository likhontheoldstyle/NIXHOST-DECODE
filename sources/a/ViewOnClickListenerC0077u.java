package a;

import android.app.Dialog;
import android.view.View;
import android.widget.EditText;
import java.util.regex.Pattern;

/* renamed from: a.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class ViewOnClickListenerC0077u implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f666a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f667b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Dialog f668c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f669d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f670e;

    public /* synthetic */ ViewOnClickListenerC0077u(C0006b1 c0006b1, C0022f1 c0022f1, Dialog dialog, Dialog dialog2) {
        this.f667b = c0006b1;
        this.f669d = c0022f1;
        this.f668c = dialog;
        this.f670e = dialog2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f666a) {
            case 0:
                String obj = ((EditText) this.f669d).getText().toString();
                Pattern compile = Pattern.compile("\\s+");
                i.b.d(compile, "compile(...)");
                i.b.e(obj, "input");
                String replaceAll = compile.matcher(obj).replaceAll(" ");
                i.b.d(replaceAll, "replaceAll(...)");
                String obj2 = m.e.h0(replaceAll).toString();
                int length = obj2.length();
                C0006b1 c0006b1 = this.f667b;
                if (length != 0) {
                    boolean a2 = i.b.a(obj2, (String) this.f670e);
                    Dialog dialog = this.f668c;
                    if (!a2) {
                        if (!c0006b1.e0()) {
                            dialog.dismiss();
                            new Thread(new RunnableC0032i(obj2, c0006b1, 2)).start();
                            break;
                        } else {
                            c0006b1.f416c.a("No internet connection");
                            break;
                        }
                    } else {
                        dialog.dismiss();
                        break;
                    }
                } else {
                    c0006b1.f416c.a("Name can't be empty");
                    break;
                }
            default:
                C0006b1 c0006b12 = this.f667b;
                if (!c0006b12.e0()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    c0006b12.x = currentTimeMillis;
                    c0006b12.D1 = currentTimeMillis;
                    C0022f1 c0022f1 = (C0022f1) this.f669d;
                    C0006b1.Z0(c0022f1.f483c);
                    c0006b12.h(c0022f1);
                    new Thread(new U(c0022f1, c0006b12, 0)).start();
                    this.f668c.dismiss();
                    ((Dialog) this.f670e).dismiss();
                    Dialog dialog2 = c0006b12.C;
                    if (dialog2 != null) {
                        dialog2.dismiss();
                        break;
                    }
                } else {
                    c0006b12.f416c.a("No internet connection");
                    break;
                }
                break;
        }
    }

    public /* synthetic */ ViewOnClickListenerC0077u(EditText editText, C0006b1 c0006b1, String str, Dialog dialog) {
        this.f669d = editText;
        this.f667b = c0006b1;
        this.f670e = str;
        this.f668c = dialog;
    }
}
