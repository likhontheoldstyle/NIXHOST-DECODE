package a;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import org.json.JSONObject;

public final class ChatSignalRunnable implements Runnable {

    public final int mode;

    public ChatSignalRunnable(int i2) {
        this.mode = i2;
    }

    @Override
    public final void run() {
        switch (this.mode) {
            case 0:
                ApiClient.requestWithDefaults(ApiClient.INSTANCE, "POST", "/chat/typing", new JSONObject().put("on", true), 8);
                break;
            case 1:
                ApiClient.requestWithDefaults(ApiClient.INSTANCE, "POST", "/chat/typing", new JSONObject().put("on", false), 8);
                break;
            default:
                try {
                    short[] sArr = SentSoundPlayer.sentSoundSamples;
                    if (sArr == null) {
                        short[] sArr2 = new short[5733];
                        double d2 = 0.0d;
                        for (int i2 = 0; i2 < 5733; i2++) {
                            double d3 = i2;
                            d2 += (((460.0d * (d3 / 5733)) + 500.0d) * 6.283185307179586d) / 44100;
                            sArr2[i2] = (short) (((Math.sin(2.0d * d2) * 0.22d) + Math.sin(d2)) * (d3 < 264.6d ? d3 / 264.6d : Math.exp((d3 / 5733) * (-5.2d))) * 0.36d * 32767.0d);
                        }
                        SentSoundPlayer.sentSoundSamples = sArr2;
                        sArr = sArr2;
                    }
                    AudioTrack build = new AudioTrack.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(13).setContentType(4).build()).setAudioFormat(new AudioFormat.Builder().setEncoding(2).setSampleRate(44100).setChannelMask(4).build()).setBufferSizeInBytes(sArr.length * 2).setTransferMode(0).build();
                    build.write(sArr, 0, sArr.length);
                    build.play();
                    SentSoundPlayer.mainHandler.postDelayed(new TaskRunnable(8, build), 450L);
                    break;
                } catch (Throwable unused) {
                    return;
                }
        }
    }
}
