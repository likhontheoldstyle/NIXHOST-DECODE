package a;

import android.media.MediaPlayer;

public final class SoundCompletionListener implements MediaPlayer.OnCompletionListener {
    @Override
    public final void onCompletion(MediaPlayer mediaPlayer) {
        try {
            mediaPlayer.release();
        } catch (Exception unused) {
        }
        if (ChatNotifier.soundPlayer == mediaPlayer) {
            ChatNotifier.soundPlayer = null;
        }
    }
}
