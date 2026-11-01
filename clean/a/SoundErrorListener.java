package a;

import android.media.MediaPlayer;

public final class SoundErrorListener implements MediaPlayer.OnErrorListener {
    @Override
    public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        try {
            mediaPlayer.release();
        } catch (Exception unused) {
        }
        if (ChatNotifier.soundPlayer != mediaPlayer) {
            return true;
        }
        ChatNotifier.soundPlayer = null;
        return true;
    }
}
