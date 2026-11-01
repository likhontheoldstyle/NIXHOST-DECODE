package a;

import android.view.View;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ChatResultRunnable implements Runnable {

    public final int mode;

    public final ApiResponse response;

    public final ChatScreen chatScreen;

    public ChatResultRunnable(ApiResponse apiResponse, ChatScreen chatScreen, int i2) {
        this.mode = i2;
        this.response = apiResponse;
        this.chatScreen = chatScreen;
    }

    @Override
    public final void run() {
        String optString;
        switch (this.mode) {
            case 0:
                ApiResponse apiResponse = this.response;
                boolean b2 = apiResponse.isSuccess();
                ChatScreen chatScreen = this.chatScreen;
                if (!b2) {
                    chatScreen.toaster.a(ChatScreen.errorText(apiResponse));
                    return;
                }
                JSONObject c2 = apiResponse.json();
                chatScreen.clearMessagesBefore(c2 != null ? c2.optLong("cl", 2305843009213693951L) : 2305843009213693951L);
                chatScreen.toaster.a("Group data cleared");
                return;
            case 1:
                ApiResponse apiResponse2 = this.response;
                boolean b3 = apiResponse2.isSuccess();
                ChatScreen chatScreen2 = this.chatScreen;
                if (!b3) {
                    chatScreen2.toaster.a(ChatScreen.errorText(apiResponse2));
                    return;
                }
                chatScreen2.memberPics.remove(chatScreen2.username);
                chatScreen2.saveCache();
                ChatAndMediaAdapter o0 = chatScreen2.messageAdapter;
                if (o0 == null) {
                    i.b.g("adapter");
                    throw null;
                }
                o0.notifyDataSetChanged();
                QuickReactionRefresher quickReactionRefresher = chatScreen2.quickReactionRefresher;
                if (quickReactionRefresher != null) {
                    quickReactionRefresher.a();
                    return;
                }
                return;
            case 2:
                ApiResponse apiResponse3 = this.response;
                boolean b4 = apiResponse3.isSuccess();
                ChatScreen chatScreen3 = this.chatScreen;
                if (b4) {
                    chatScreen3.syncSeen();
                    return;
                } else {
                    chatScreen3.toaster.a(ChatScreen.errorText(apiResponse3));
                    return;
                }
            case 3:
                ApiResponse apiResponse4 = this.response;
                JSONObject c3 = apiResponse4.json();
                String str = "";
                if (c3 != null && (optString = c3.optString("p", "")) != null) {
                    str = optString;
                }
                boolean b5 = apiResponse4.isSuccess();
                ChatScreen chatScreen4 = this.chatScreen;
                if (!b5 || str.length() <= 0) {
                    chatScreen4.toaster.a(ChatScreen.errorText(apiResponse4));
                    return;
                }
                chatScreen4.memberPics.put(chatScreen4.username, str);
                chatScreen4.saveCache();
                ChatAndMediaAdapter o02 = chatScreen4.messageAdapter;
                if (o02 == null) {
                    i.b.g("adapter");
                    throw null;
                }
                o02.notifyDataSetChanged();
                QuickReactionRefresher quickReactionRefresher2 = chatScreen4.quickReactionRefresher;
                if (quickReactionRefresher2 != null) {
                    quickReactionRefresher2.a();
                    return;
                }
                return;
            case 4:
                ChatScreen chatScreen5 = this.chatScreen;
                chatScreen5.loadingOlder = false;
                ApiResponse apiResponse5 = this.response;
                JSONObject c4 = apiResponse5.json();
                if (!apiResponse5.isSuccess() || c4 == null) {
                    return;
                }
                ChatListView i2 = chatScreen5.messageList;
                if (i2 == null) {
                    i.b.g("lv");
                    throw null;
                }
                int firstVisiblePosition = i2.getFirstVisiblePosition();
                ChatListView i22 = chatScreen5.messageList;
                if (i22 == null) {
                    i.b.g("lv");
                    throw null;
                }
                View childAt = i22.getChildAt(0);
                int top = childAt != null ? childAt.getTop() : 0;
                int b6 = chatScreen5.addMessages(c4.optJSONArray("msgs"));
                chatScreen5.applySyncPayload(c4);
                JSONArray optJSONArray = c4.optJSONArray("msgs");
                if ((optJSONArray != null ? optJSONArray.length() : 0) < 40) {
                    chatScreen5.hasMore = false;
                }
                ChatAndMediaAdapter o03 = chatScreen5.messageAdapter;
                if (o03 == null) {
                    i.b.g("adapter");
                    throw null;
                }
                o03.notifyDataSetChanged();
                ChatListView i23 = chatScreen5.messageList;
                if (i23 == null) {
                    i.b.g("lv");
                    throw null;
                }
                i23.setSelectionFromTop(firstVisiblePosition + b6, top);
                ChatListView i24 = chatScreen5.messageList;
                if (i24 != null) {
                    i24.post(new ChatScreenRunnable(chatScreen5, 12));
                    return;
                } else {
                    i.b.g("lv");
                    throw null;
                }
            default:
                this.chatScreen.toaster.a(ChatScreen.errorText(this.response));
                return;
        }
    }

    public ChatResultRunnable(ChatScreen chatScreen, ApiResponse apiResponse, int i2) {
        this.mode = i2;
        this.chatScreen = chatScreen;
        this.response = apiResponse;
    }
}
