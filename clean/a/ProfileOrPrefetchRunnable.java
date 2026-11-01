package a;

import java.io.File;
import org.json.JSONObject;

public final class ProfileOrPrefetchRunnable implements Runnable {

    public final int mode;

    public final ChatScreen chatScreen;

    public final String value;

    public ProfileOrPrefetchRunnable(ChatScreen chatScreen, String str) {
        this.mode = 1;
        this.chatScreen = chatScreen;
        this.value = str;
    }

    @Override
    public final void run() {
        ChatScreen chatScreen = this.chatScreen;
        String str = this.value;
        switch (this.mode) {
            case 0:
                File file = ChatMedia.cacheDir;
                ChatMedia.fetchMediaFile(str);
                chatScreen.handler.post(new ProfileOrPrefetchRunnable(chatScreen, str));
                break;
            case 1:
                chatScreen.prefetchingIds.remove(str);
                break;
            default:
                chatScreen.activity.runOnUiThread(new BackgroundTask(ApiClient.requestWithDefaults(ApiClient.INSTANCE, "POST", "/chat/profile", new JSONObject().put("name", str), 8), chatScreen, str));
                break;
        }
    }

    public ProfileOrPrefetchRunnable(String str, ChatScreen chatScreen, int i2) {
        this.mode = i2;
        this.value = str;
        this.chatScreen = chatScreen;
    }
}
