package a;

import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

public final class VideoSeekBarListener implements SeekBar.OnSeekBarChangeListener {

    public final i.e durationRef;

    public final TextView timeLabel;

    public final ChatScreen chatScreen;

    public final i.d seekingRef;

    public final i.d playingRef;

    public final VideoView videoView;

    public VideoSeekBarListener(i.e eVar, TextView textView, ChatScreen chatScreen, i.d dVar, i.d dVar2, VideoView videoView) {
        this.durationRef = eVar;
        this.timeLabel = textView;
        this.chatScreen = chatScreen;
        this.seekingRef = dVar;
        this.playingRef = dVar2;
        this.videoView = videoView;
    }

    @Override
    public final void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        int i3;
        if (!z || (i3 = this.durationRef.f847a) <= 0) {
            return;
        }
        this.chatScreen.getClass();
        this.timeLabel.setText(ChatScreen.formatDuration((int) ((i2 * i3) / 1000)));
    }

    @Override
    public final void onStartTrackingTouch(SeekBar seekBar) {
        this.seekingRef.f846a = true;
    }

    @Override
    public final void onStopTrackingTouch(SeekBar seekBar) {
        this.seekingRef.f846a = false;
        if (this.playingRef.f846a) {
            if (this.durationRef.f847a > 0) {
                this.videoView.seekTo((int) (((seekBar != null ? seekBar.getProgress() : 0) * this.durationRef.f847a) / 1000));
            }
        }
    }
}
