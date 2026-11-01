package a;

import android.content.SharedPreferences;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/* loaded from: classes.dex */
public final class R0 implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f286a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f287b;

    public /* synthetic */ R0(int i2, Object obj) {
        this.f286a = i2;
        this.f287b = obj;
    }

    private final void a(CharSequence charSequence, int i2, int i3, int i4) {
    }

    private final void b(CharSequence charSequence, int i2, int i3, int i4) {
    }

    private final void c(CharSequence charSequence, int i2, int i3, int i4) {
    }

    private final void d(CharSequence charSequence, int i2, int i3, int i4) {
    }

    private final void e(CharSequence charSequence, int i2, int i3, int i4) {
    }

    private final void f(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        String str;
        switch (this.f286a) {
            case 0:
                C0006b1 c0006b1 = (C0006b1) this.f287b;
                c0006b1.h1();
                EditText editText = c0006b1.h0;
                if (editText == null) {
                    i.b.g("input");
                    throw null;
                }
                boolean z = !m.e.R(editText.getText().toString());
                long currentTimeMillis = System.currentTimeMillis();
                if (z) {
                    if (currentTimeMillis - c0006b1.H0 > 2500) {
                        c0006b1.H0 = currentTimeMillis;
                        c0006b1.I0 = true;
                        new Thread(new RunnableC0068r0(0)).start();
                        return;
                    }
                    return;
                }
                if (c0006b1.I0) {
                    c0006b1.I0 = false;
                    c0006b1.H0 = 0L;
                    new Thread(new RunnableC0068r0(1)).start();
                    return;
                }
                return;
            case 1:
                C0038j1 c0038j1 = (C0038j1) this.f287b;
                c0038j1.a();
                c0038j1.f558j++;
                Handler handler = c0038j1.f557i;
                G g2 = c0038j1.f559k;
                handler.removeCallbacks(g2);
                handler.postDelayed(g2, 450L);
                return;
            default:
                if (editable == null || (str = editable.toString()) == null) {
                    str = "";
                }
                int length = str.length();
                String str2 = (String) this.f287b;
                if (length == 0) {
                    SharedPreferences sharedPreferences = AbstractC0008c.f440c;
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().remove(str2).apply();
                        return;
                    } else {
                        i.b.g("sp");
                        throw null;
                    }
                }
                SharedPreferences sharedPreferences2 = AbstractC0008c.f440c;
                if (sharedPreferences2 != null) {
                    sharedPreferences2.edit().putString(str2, str).apply();
                    return;
                } else {
                    i.b.g("sp");
                    throw null;
                }
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        int i5 = this.f286a;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        int i5 = this.f286a;
    }
}
