package a;

import android.content.DialogInterface;
import android.widget.VideoView;

/* renamed from: a.i0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class DialogInterfaceOnDismissListenerC0033i0 implements DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f529a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f530b;

    public /* synthetic */ DialogInterfaceOnDismissListenerC0033i0(int i2, Object obj) {
        this.f529a = i2;
        this.f530b = obj;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        switch (this.f529a) {
            case 0:
                ((C0006b1) this.f530b).y1 = null;
                break;
            default:
                B1 b1 = (B1) this.f530b;
                try {
                    VideoView videoView = b1.E;
                    if (videoView != null) {
                        videoView.stopPlayback();
                    }
                } catch (Throwable unused) {
                }
                b1.f35j.shutdownNow();
                b1.f36k.evictAll();
                break;
        }
    }
}
