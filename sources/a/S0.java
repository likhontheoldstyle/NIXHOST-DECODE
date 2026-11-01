package a;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public final class S0 implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f303a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f304b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C1 f305c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ EditText f306d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f307e;

    public S0(FrameLayout frameLayout, C0006b1 c0006b1, C1 c1, EditText editText, String str) {
        this.f303a = frameLayout;
        this.f304b = c0006b1;
        this.f305c = c1;
        this.f306d = editText;
        this.f307e = str;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        C0006b1.B(this.f303a, this.f304b, this.f305c, this.f306d, this.f307e);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
