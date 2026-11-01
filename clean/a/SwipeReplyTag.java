package a;

import android.view.View;
import android.widget.FrameLayout;

public final class SwipeReplyTag {

    public final View rowView;

    public final View replyIconView;

    public final boolean ownMessage;

    public SwipeReplyTag(View view, FrameLayout frameLayout, boolean z) {
        this.rowView = view;
        this.replyIconView = frameLayout;
        this.ownMessage = z;
    }
}
