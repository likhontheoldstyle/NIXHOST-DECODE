package a;

import android.widget.TextView;

/* renamed from: a.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0064q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f627a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f628b;

    public /* synthetic */ RunnableC0064q(TextView textView, int i2) {
        this.f627a = i2;
        this.f628b = textView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f627a) {
            case 0:
                this.f628b.setVisibility(8);
                break;
            default:
                this.f628b.setVisibility(8);
                break;
        }
    }
}
