package a;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.widget.TextView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class X0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f371a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f372b;

    public /* synthetic */ X0(C0006b1 c0006b1, int i2) {
        this.f371a = i2;
        this.f372b = c0006b1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f371a) {
            case 0:
                C0006b1 c0006b1 = this.f372b;
                MediaPlayer mediaPlayer = c0006b1.g1;
                if (mediaPlayer != null) {
                    try {
                        int max = Math.max(1, mediaPlayer.getDuration());
                        P2 p2 = (P2) c0006b1.i1.get(Long.valueOf(c0006b1.h1));
                        if (p2 != null) {
                            p2.setProgress(mediaPlayer.getCurrentPosition() / max);
                            p2.invalidate();
                        }
                    } catch (Exception unused) {
                    }
                    c0006b1.f418e.postDelayed(this, 80L);
                    break;
                }
                break;
            case 1:
                C0006b1 c0006b12 = this.f372b;
                if (c0006b12.G) {
                    c0006b12.b1();
                    c0006b12.f418e.postDelayed(this, 2500L);
                    break;
                }
                break;
            default:
                C0006b1 c0006b13 = this.f372b;
                if (i.b.a(c0006b13.U0, "rec")) {
                    int currentTimeMillis = c0006b13.Z0 + ((int) (System.currentTimeMillis() - c0006b13.X0));
                    int i2 = 0;
                    try {
                        MediaRecorder mediaRecorder = c0006b13.V0;
                        if (mediaRecorder != null) {
                            i2 = mediaRecorder.getMaxAmplitude();
                        }
                    } catch (Exception unused2) {
                    }
                    ArrayList arrayList = c0006b13.b1;
                    arrayList.add(Integer.valueOf(Math.min(100, (int) (Math.sqrt(i2 / 32767.0d) * 100))));
                    P2 p22 = c0006b13.c1;
                    if (p22 != null) {
                        p22.setValues(arrayList);
                        p22.invalidate();
                    }
                    TextView textView = c0006b13.d1;
                    if (textView != null) {
                        textView.setText(C0006b1.G(currentTimeMillis));
                    }
                    if (currentTimeMillis < 180000) {
                        c0006b13.f418e.postDelayed(this, 70L);
                        break;
                    } else {
                        c0006b13.Y0();
                        break;
                    }
                }
                break;
        }
    }
}
