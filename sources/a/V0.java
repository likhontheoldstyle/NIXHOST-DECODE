package a;

import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

/* loaded from: classes.dex */
public final class V0 implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i.e f338a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f339b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f340c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i.d f341d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ i.d f342e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ VideoView f343f;

    public V0(i.e eVar, TextView textView, C0006b1 c0006b1, i.d dVar, i.d dVar2, VideoView videoView) {
        this.f338a = eVar;
        this.f339b = textView;
        this.f340c = c0006b1;
        this.f341d = dVar;
        this.f342e = dVar2;
        this.f343f = videoView;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        int i3;
        if (!z || (i3 = this.f338a.f847a) <= 0) {
            return;
        }
        this.f340c.getClass();
        this.f339b.setText(C0006b1.G((int) ((i2 * i3) / 1000)));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
        this.f341d.f846a = true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        this.f341d.f846a = false;
        if (this.f342e.f846a) {
            if (this.f338a.f847a > 0) {
                this.f343f.seekTo((int) (((seekBar != null ? seekBar.getProgress() : 0) * r0.f847a) / 1000));
            }
        }
    }
}
