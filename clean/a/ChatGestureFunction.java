package a;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import java.util.ArrayList;

public final class ChatGestureFunction implements h.b {

    public final int mode;

    public final ChatScreen chatScreen;

    public ChatGestureFunction(ChatScreen chatScreen, int i2) {
        this.mode = i2;
        this.chatScreen = chatScreen;
    }

    @Override
    public final Object a(Object obj) {
        switch (this.mode) {
            case 0:
                MotionEvent motionEvent = (MotionEvent) obj;
                ChatScreen chatScreen = this.chatScreen;
                chatScreen.getClass();
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    chatScreen.recordQuality = 0;
                    chatScreen.swipeArmed = false;
                    chatScreen.activeSwipe = null;
                    chatScreen.highlightedMessage = null;
                    chatScreen.swipeOffset = motionEvent.getX();
                    chatScreen.swipeOffset2 = motionEvent.getY();
                    ChatListView i2 = chatScreen.messageList;
                    if (i2 == null) {
                        i.b.g("lv");
                        throw null;
                    }
                    int pointToPosition = i2.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (pointToPosition < 0) {
                        return null;
                    }
                    ArrayList arrayList = chatScreen.messages;
                    if (pointToPosition >= arrayList.size()) {
                        return null;
                    }
                    ChatMessage chatMessage = (ChatMessage) arrayList.get(pointToPosition);
                    ChatListView i22 = chatScreen.messageList;
                    if (i22 == null) {
                        i.b.g("lv");
                        throw null;
                    }
                    View childAt = i22.getChildAt(pointToPosition - i22.getFirstVisiblePosition());
                    Object tag = childAt != null ? childAt.getTag() : null;
                    SwipeReplyTag swipeReplyTag = tag instanceof SwipeReplyTag ? (SwipeReplyTag) tag : null;
                    if (swipeReplyTag == null || chatMessage.flag || chatScreen.isLocalMessage(chatMessage) || i.b.a(chatMessage.type, "sys")) {
                        return null;
                    }
                    chatScreen.activeSwipe = swipeReplyTag;
                    chatScreen.highlightedMessage = chatMessage;
                    return null;
                }
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        SwipeReplyTag swipeReplyTag2 = chatScreen.activeSwipe;
                        if (swipeReplyTag2 == null) {
                            return null;
                        }
                        int i3 = chatScreen.recordQuality;
                        if (i3 == 1) {
                            chatScreen.applySwipeOffset(swipeReplyTag2, motionEvent.getX() - chatScreen.swipeOffset);
                            return Boolean.TRUE;
                        }
                        if (i3 == 2) {
                            return null;
                        }
                        float x = motionEvent.getX() - chatScreen.swipeOffset;
                        float y = motionEvent.getY() - chatScreen.swipeOffset2;
                        int scaledTouchSlop = ViewConfiguration.get(chatScreen.activity).getScaledTouchSlop();
                        float abs = Math.abs(x);
                        float abs2 = Math.abs(y);
                        float f2 = scaledTouchSlop;
                        if (abs2 > f2 && abs2 > abs) {
                            chatScreen.recordQuality = 2;
                            return null;
                        }
                        if (abs <= f2 * 1.5f || abs <= abs2 * 1.5f) {
                            return null;
                        }
                        boolean z = swipeReplyTag2.ownMessage;
                        if ((!z || x >= 0.0f) && (z || x <= 0.0f)) {
                            chatScreen.recordQuality = 2;
                            return null;
                        }
                        MotionEvent obtain = MotionEvent.obtain(motionEvent);
                        obtain.setAction(3);
                        ChatListView i23 = chatScreen.messageList;
                        if (i23 == null) {
                            i.b.g("lv");
                            throw null;
                        }
                        i23.a(obtain);
                        obtain.recycle();
                        ChatListView i24 = chatScreen.messageList;
                        if (i24 == null) {
                            i.b.g("lv");
                            throw null;
                        }
                        ViewParent parent = i24.getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                        chatScreen.recordQuality = 1;
                        chatScreen.swipeOffset = motionEvent.getX();
                        View view = swipeReplyTag2.rowView;
                        View view2 = swipeReplyTag2.replyIconView;
                        view2.setTranslationY(((view.getHeight() / 2.0f) + view.getTop()) - chatScreen.dp(17.0f));
                        view2.setAlpha(0.0f);
                        view2.setScaleX(0.4f);
                        view2.setScaleY(0.4f);
                        chatScreen.applySwipeOffset(swipeReplyTag2, 0.0f);
                        return Boolean.TRUE;
                    }
                    if (actionMasked != 3) {
                        return null;
                    }
                }
                SwipeReplyTag swipeReplyTag3 = chatScreen.activeSwipe;
                ChatMessage chatMessage2 = chatScreen.highlightedMessage;
                int i4 = chatScreen.recordQuality;
                boolean z2 = chatScreen.swipeArmed && motionEvent.getActionMasked() == 1;
                chatScreen.recordQuality = 0;
                chatScreen.swipeArmed = false;
                chatScreen.activeSwipe = null;
                chatScreen.highlightedMessage = null;
                if (i4 != 1 || swipeReplyTag3 == null) {
                    return null;
                }
                swipeReplyTag3.rowView.animate().translationX(0.0f).setDuration(190L).setInterpolator(new DecelerateInterpolator()).start();
                swipeReplyTag3.replyIconView.animate().alpha(0.0f).scaleX(0.4f).scaleY(0.4f).setDuration(150L).start();
                if (z2 && chatMessage2 != null) {
                    chatScreen.setReplyTarget(chatMessage2);
                }
                return Boolean.TRUE;
            case 1:
                return Boolean.valueOf(i.b.a(((b.b) obj).f764a, this.chatScreen.username));
            case 2:
                String str = (String) obj;
                ChatScreen chatScreen2 = this.chatScreen;
                EditText editText = chatScreen2.messageInput;
                if (editText == null) {
                    i.b.g("input");
                    throw null;
                }
                editText.append(str);
                chatScreen2.updateSendButton();
                return b.d.f770c;
            default:
                String str2 = (String) obj;
                ChatScreen chatScreen3 = this.chatScreen;
                chatScreen3.getClass();
                chatScreen3.lastQuickReactionAt = System.currentTimeMillis();
                ChatScreen.saveQuickReaction(str2);
                chatScreen3.updateSendButton();
                new Thread(new TaskRunnable(0, str2)).start();
                QuickReactionRefresher quickReactionRefresher = chatScreen3.quickReactionRefresher;
                if (quickReactionRefresher != null) {
                    quickReactionRefresher.a();
                }
                return b.d.f770c;
        }
    }
}
