package a;

import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

public final class VideoProgressRunnable implements Runnable {

    public final i.d prepared;

    public final i.d seeking;

    public final i.e duration;

    public final VideoView videoView;

    public final TextView timeLabel;

    public final ChatScreen chatScreen;

    public final SeekBar seekBar;

    public VideoProgressRunnable(i.d dVar, i.d dVar2, i.e eVar, VideoView videoView, TextView textView, ChatScreen chatScreen, SeekBar seekBar) {
        this.prepared = dVar;
        this.seeking = dVar2;
        this.duration = eVar;
        this.videoView = videoView;
        this.timeLabel = textView;
        this.chatScreen = chatScreen;
        this.seekBar = seekBar;
    }

    @Override
    public final void run() {
        boolean z = this.prepared.f846a;
        ChatScreen chatScreen = this.chatScreen;
        if (z && !this.seeking.f846a) {
            if (this.duration.f847a > 0) {
                int currentPosition = this.videoView.getCurrentPosition();
                chatScreen.getClass();
                this.timeLabel.setText(ChatScreen.formatDuration(currentPosition));
                this.seekBar.setProgress((int) ((currentPosition * 1000) / this.duration.f847a));
            }
        }
        chatScreen.handler.postDelayed(this, 250L);
    }
}
