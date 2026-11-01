package a;

import android.widget.AbsListView;

/* loaded from: classes.dex */
public final class P0 implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f248a;

    public P0(C0006b1 c0006b1) {
        this.f248a = c0006b1;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        C0006b1 c0006b1 = this.f248a;
        if (c0006b1.K) {
            if (c0006b1.W == null) {
                i.b.g("lv");
                throw null;
            }
            c0006b1.V = !r4.canScrollVertically(1);
        }
        if (!c0006b1.K || i2 > 4 || i4 <= 0 || !c0006b1.I || c0006b1.J || !c0006b1.L) {
            return;
        }
        c0006b1.V();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i2) {
        boolean z = i2 != 0;
        C0006b1 c0006b1 = this.f248a;
        c0006b1.K = z;
        if (i2 == 1) {
            c0006b1.U = 0L;
        }
        if (i2 == 0) {
            if (c0006b1.W == null) {
                i.b.g("lv");
                throw null;
            }
            c0006b1.V = !r6.canScrollVertically(1);
        }
        if (c0006b1.K) {
            return;
        }
        I2 i22 = c0006b1.W;
        if (i22 == null) {
            i.b.g("lv");
            throw null;
        }
        if (i22.getFirstVisiblePosition() > 1 || !c0006b1.I || c0006b1.J || !c0006b1.L) {
            return;
        }
        c0006b1.V();
    }
}
