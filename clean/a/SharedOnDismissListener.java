package a;

import android.content.DialogInterface;
import android.widget.VideoView;

public final class SharedOnDismissListener implements DialogInterface.OnDismissListener {

    public final int mode;

    public final Object owner;

    public SharedOnDismissListener(int i2, Object obj) {
        this.mode = i2;
        this.owner = obj;
    }

    @Override
    public final void onDismiss(DialogInterface dialogInterface) {
        switch (this.mode) {
            case 0:
                ((ChatScreen) this.owner).quickReactionRefresher = null;
                break;
            default:
                MediaPicker mediaPicker = (MediaPicker) this.owner;
                try {
                    VideoView videoView = mediaPicker.previewVideoView;
                    if (videoView != null) {
                        videoView.stopPlayback();
                    }
                } catch (Throwable unused) {
                }
                mediaPicker.executor.shutdownNow();
                mediaPicker.bitmapCache.evictAll();
                break;
        }
    }
}
