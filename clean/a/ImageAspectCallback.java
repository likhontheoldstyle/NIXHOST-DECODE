package a;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public final class ImageAspectCallback implements h.b {

    public final int mode;

    public final ChatScreen chatScreen;

    public final FrameLayout container;

    public ImageAspectCallback(ChatScreen chatScreen, FrameLayout frameLayout, int i2) {
        this.mode = i2;
        this.chatScreen = chatScreen;
        this.container = frameLayout;
    }

    @Override
    public final Object a(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        switch (this.mode) {
            case 0:
                LinearLayout.LayoutParams q0 = this.chatScreen.videoLayoutParams(bitmap.getWidth() / bitmap.getHeight());
                FrameLayout frameLayout = this.container;
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                if (layoutParams == null || layoutParams.width != q0.width || layoutParams.height != q0.height) {
                    frameLayout.setLayoutParams(q0);
                }
                break;
            default:
                LinearLayout.LayoutParams U0 = this.chatScreen.mediaLayoutParams(bitmap.getWidth() / bitmap.getHeight());
                FrameLayout frameLayout2 = this.container;
                ViewGroup.LayoutParams layoutParams2 = frameLayout2.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.width != U0.width || layoutParams2.height != U0.height) {
                    frameLayout2.setLayoutParams(U0);
                }
                break;
        }
        return b.d.f770c;
    }
}
