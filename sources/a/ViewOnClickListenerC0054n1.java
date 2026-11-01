package a;

import android.view.View;
import android.widget.TextView;

/* renamed from: a.n1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class ViewOnClickListenerC0054n1 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f599a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ B1 f600b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f601c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f602d;

    public /* synthetic */ ViewOnClickListenerC0054n1(B1 b1, String str, String str2, int i2) {
        this.f599a = i2;
        this.f600b = b1;
        this.f601c = str;
        this.f602d = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f599a) {
            case 0:
                B1 b1 = this.f600b;
                b1.p = this.f601c;
                TextView textView = b1.f43t;
                if (textView == null) {
                    i.b.g("titleTv");
                    throw null;
                }
                textView.setText(this.f602d);
                b1.a();
                b1.j(Boolean.FALSE);
                return;
            default:
                B1 b12 = this.f600b;
                b12.p = this.f601c;
                TextView textView2 = b12.f43t;
                if (textView2 == null) {
                    i.b.g("titleTv");
                    throw null;
                }
                textView2.setText(this.f602d);
                b12.a();
                b12.j(Boolean.FALSE);
                return;
        }
    }
}
