package a;

import org.json.JSONObject;

public final class ChatSyncRunnable implements Runnable {

    public final int mode;

    public final long cursorId;

    public final ChatScreen chatScreen;

    public ChatSyncRunnable(int i2, long j2, ChatScreen chatScreen) {
        this.mode = i2;
        this.cursorId = j2;
        this.chatScreen = chatScreen;
    }

    @Override
    public final void run() {
        switch (this.mode) {
            case 0:
                ApiResponse f2 = ApiClient.INSTANCE.syncChat(0L, this.cursorId);
                ChatScreen chatScreen = this.chatScreen;
                chatScreen.activity.runOnUiThread(new ChatResultRunnable(chatScreen, f2, 4));
                break;
            default:
                ApiClient apiClient = ApiClient.INSTANCE;
                ApiResponse f3 = apiClient.syncChat(this.cursorId, 0L);
                ApiResponse apiResponse = null;
                ApiResponse b2 = ApiClient.requestWithDefaults(apiClient, "GET", "/chat/seen", null, 12);
                long currentTimeMillis = System.currentTimeMillis();
                ChatScreen chatScreen2 = this.chatScreen;
                if (currentTimeMillis - chatScreen2.typingStartedAt > 20000) {
                    chatScreen2.typingStartedAt = currentTimeMillis;
                    ApiClient.requestWithDefaults(apiClient, "POST", "/chat/ping", new JSONObject(), 8);
                }
                if (currentTimeMillis - chatScreen2.lastTypingAt > 8000) {
                    chatScreen2.lastTypingAt = currentTimeMillis;
                    apiResponse = ApiClient.requestWithDefaults(apiClient, "GET", "/chat/presence", null, 12);
                }
                chatScreen2.activity.runOnUiThread(new QuadTaskRunnable(chatScreen2, f3, b2, apiResponse));
                break;
        }
    }
}
