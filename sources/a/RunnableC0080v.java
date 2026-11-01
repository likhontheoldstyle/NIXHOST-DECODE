package a;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* renamed from: a.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0080v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f678a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EditText f679b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f680c;

    public /* synthetic */ RunnableC0080v(EditText editText, C0006b1 c0006b1, int i2) {
        this.f678a = i2;
        this.f679b = editText;
        this.f680c = c0006b1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f678a) {
            case 0:
                EditText editText = this.f679b;
                editText.requestFocus();
                editText.setSelection(editText.length());
                Object systemService = this.f680c.f414a.getSystemService("input_method");
                i.b.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                ((InputMethodManager) systemService).showSoftInput(editText, 1);
                break;
            default:
                EditText editText2 = this.f679b;
                editText2.requestFocus();
                editText2.setSelection(editText2.length());
                Object systemService2 = this.f680c.f414a.getSystemService("input_method");
                i.b.c(systemService2, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                ((InputMethodManager) systemService2).showSoftInput(editText2, 1);
                break;
        }
    }
}
