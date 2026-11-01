package a;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.widget.TextView;
import java.util.ArrayList;

public final class ChatTimerRunnable implements Runnable {

    public final int mode;

    public final ChatScreen chatScreen;

    public ChatTimerRunnable(ChatScreen chatScreen, int i2) {
        this.mode = i2;
        this.chatScreen = chatScreen;
    }

    @Override
    public final void run() {
        switch (this.mode) {
            case 0:
                ChatScreen chatScreen = this.chatScreen;
                MediaPlayer mediaPlayer = chatScreen.audioPlayer;
                if (mediaPlayer != null) {
                    try {
                        int max = Math.max(1, mediaPlayer.getDuration());
                        WaveformView waveformView = (WaveformView) chatScreen.waveViews.get(Long.valueOf(chatScreen.playingMessageId));
                        if (waveformView != null) {
                            waveformView.setProgress(mediaPlayer.getCurrentPosition() / max);
                            waveformView.invalidate();
                        }
                    } catch (Exception unused) {
                    }
                    chatScreen.handler.postDelayed(this, 80L);
                    break;
                }
                break;
            case 1:
                ChatScreen chatScreen2 = this.chatScreen;
                if (chatScreen2.active) {
                    chatScreen2.syncSeen();
                    chatScreen2.handler.postDelayed(this, 2500L);
                    break;
                }
                break;
            default:
                ChatScreen chatScreen3 = this.chatScreen;
                if (i.b.a(chatScreen3.recordState, "rec")) {
                    int currentTimeMillis = chatScreen3.recordBaseDurationMs + ((int) (System.currentTimeMillis() - chatScreen3.recordStartedAt));
                    int i2 = 0;
                    try {
                        MediaRecorder mediaRecorder = chatScreen3.mediaRecorder;
                        if (mediaRecorder != null) {
                            i2 = mediaRecorder.getMaxAmplitude();
                        }
                    } catch (Exception unused2) {
                    }
                    ArrayList arrayList = chatScreen3.waveformSamples;
                    arrayList.add(Integer.valueOf(Math.min(100, (int) (Math.sqrt(i2 / 32767.0d) * 100))));
                    WaveformView waveformView2 = chatScreen3.recordWaveView;
                    if (waveformView2 != null) {
                        waveformView2.setValues(arrayList);
                        waveformView2.invalidate();
                    }
                    TextView textView = chatScreen3.recordTimeText;
                    if (textView != null) {
                        textView.setText(ChatScreen.formatDuration(currentTimeMillis));
                    }
                    if (currentTimeMillis < 180000) {
                        chatScreen3.handler.postDelayed(this, 70L);
                        break;
                    } else {
                        chatScreen3.stopRecording();
                        break;
                    }
                }
                break;
        }
    }
}
