package a;

import android.view.View;
import android.widget.ScrollView;
import com.nix.host.MainActivity;

public final class LayoutTask implements View.OnLayoutChangeListener {

    public final int mode;

    public final Object target;

    public LayoutTask(int i2, Object obj) {
        this.mode = i2;
        this.target = obj;
    }

    @Override
    public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        Object obj = this.target;
        switch (this.mode) {
            case 0:
                int i10 = i5 - i3;
                int i11 = i9 - i7;
                final ChatScreen chatScreen = (ChatScreen) obj;
                if (i11 <= 0 || i10 >= i11) {
                    I2 i22 = chatScreen.messageList;
                    if (i22 != null) {
                        chatScreen.stickToBottom = true ^ i22.canScrollVertically(1);
                        return;
                    }
                    i.b.g("lv");
                    throw null;
                }
                final int i12 = i11 - i10;
                final boolean z = chatScreen.stickToBottom;
                I2 i23 = chatScreen.messageList;
                if (i23 != null) {
                    i23.post(new Runnable() {
                        @Override
                        public final void run() {
                            ChatScreen chatScreen2 = chatScreen;
                            if (chatScreen2.replyTargetId != 0) {
                                chatScreen2.scrollToReplyTarget();
                                return;
                            }
                            if (z) {
                                I2 i24 = chatScreen2.messageList;
                                if (i24 != null) {
                                    i24.scrollListBy(i12);
                                } else {
                                    i.b.g("lv");
                                    throw null;
                                }
                            }
                        }
                    });
                    return;
                }
                i.b.g("lv");
                throw null;
            default:
                int i13 = MainActivity.R;
                ScrollView scrollView = (ScrollView) obj;
                scrollView.post(new TaskRunnable(7, scrollView));
                return;
        }
    }
}
