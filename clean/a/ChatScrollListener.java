package a;

import android.widget.AbsListView;

public final class ChatScrollListener implements AbsListView.OnScrollListener {

    public final ChatScreen chatScreen;

    public ChatScrollListener(ChatScreen chatScreen) {
        this.chatScreen = chatScreen;
    }

    @Override
    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        ChatScreen chatScreen = this.chatScreen;
        if (chatScreen.reservedFlag) {
            if (chatScreen.messageList == null) {
                i.b.g("lv");
                throw null;
            }
            chatScreen.stickToBottom = !chatScreen.messageList.canScrollVertically(1);
        }
        if (!chatScreen.reservedFlag || i2 > 4 || i4 <= 0 || !chatScreen.hasMore || chatScreen.loadingOlder || !chatScreen.cacheLoaded) {
            return;
        }
        chatScreen.loadOlderMessages();
    }

    @Override
    public final void onScrollStateChanged(AbsListView absListView, int i2) {
        boolean z = i2 != 0;
        ChatScreen chatScreen = this.chatScreen;
        chatScreen.reservedFlag = z;
        if (i2 == 1) {
            chatScreen.replyTargetId = 0L;
        }
        if (i2 == 0) {
            if (chatScreen.messageList == null) {
                i.b.g("lv");
                throw null;
            }
            chatScreen.stickToBottom = !chatScreen.messageList.canScrollVertically(1);
        }
        if (chatScreen.reservedFlag) {
            return;
        }
        ChatListView chatListView = chatScreen.messageList;
        if (chatListView == null) {
            i.b.g("lv");
            throw null;
        }
        if (chatListView.getFirstVisiblePosition() > 1 || !chatScreen.hasMore || chatScreen.loadingOlder || !chatScreen.cacheLoaded) {
            return;
        }
        chatScreen.loadOlderMessages();
    }
}
