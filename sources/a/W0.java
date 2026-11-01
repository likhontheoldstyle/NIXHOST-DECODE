package a;

import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

/* loaded from: classes.dex */
public final class W0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i.d f352a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i.d f353b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i.e f354c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ VideoView f355d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ TextView f356e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f357f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ SeekBar f358g;

    public W0(i.d dVar, i.d dVar2, i.e eVar, VideoView videoView, TextView textView, C0006b1 c0006b1, SeekBar seekBar) {
        this.f352a = dVar;
        this.f353b = dVar2;
        this.f354c = eVar;
        this.f355d = videoView;
        this.f356e = textView;
        this.f357f = c0006b1;
        this.f358g = seekBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = this.f352a.f846a;
        C0006b1 c0006b1 = this.f357f;
        if (z && !this.f353b.f846a) {
            if (this.f354c.f847a > 0) {
                int currentPosition = this.f355d.getCurrentPosition();
                c0006b1.getClass();
                this.f356e.setText(C0006b1.G(currentPosition));
                this.f358g.setProgress((int) ((currentPosition * 1000) / r0.f847a));
            }
        }
        c0006b1.f418e.postDelayed(this, 250L);
    }
}
