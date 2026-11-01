package a;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import org.json.JSONObject;

/* renamed from: a.r0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0068r0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f636a;

    public /* synthetic */ RunnableC0068r0(int i2) {
        this.f636a = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f636a) {
            case 0:
                C0004b.b(C0004b.f409a, "POST", "/chat/typing", new JSONObject().put("on", true), 8);
                break;
            case 1:
                C0004b.b(C0004b.f409a, "POST", "/chat/typing", new JSONObject().put("on", false), 8);
                break;
            default:
                try {
                    short[] sArr = C2.f59c;
                    if (sArr == null) {
                        short[] sArr2 = new short[5733];
                        double d2 = 0.0d;
                        for (int i2 = 0; i2 < 5733; i2++) {
                            double d3 = i2;
                            d2 += (((460.0d * (d3 / 5733)) + 500.0d) * 6.283185307179586d) / 44100;
                            sArr2[i2] = (short) (((Math.sin(2.0d * d2) * 0.22d) + Math.sin(d2)) * (d3 < 264.6d ? d3 / 264.6d : Math.exp(r9 * (-5.2d))) * 0.36d * 32767.0d);
                        }
                        C2.f59c = sArr2;
                        sArr = sArr2;
                    }
                    AudioTrack build = new AudioTrack.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(13).setContentType(4).build()).setAudioFormat(new AudioFormat.Builder().setEncoding(2).setSampleRate(44100).setChannelMask(4).build()).setBufferSizeInBytes(sArr.length * 2).setTransferMode(0).build();
                    build.write(sArr, 0, sArr.length);
                    build.play();
                    C2.f57a.postDelayed(new G(8, build), 450L);
                    break;
                } catch (Throwable unused) {
                    return;
                }
        }
    }
}
