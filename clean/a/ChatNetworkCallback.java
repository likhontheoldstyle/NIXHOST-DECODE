package a;

import android.net.ConnectivityManager;
import android.net.Network;

public final class ChatNetworkCallback extends ConnectivityManager.NetworkCallback {

    public final ChatScreen chatScreen;

    public ChatNetworkCallback(ChatScreen chatScreen) {
        this.chatScreen = chatScreen;
    }

    @Override
    public final void onAvailable(Network network) {
        ChatScreen chatScreen = this.chatScreen;
        chatScreen.handler.post(new ChatScreenRunnable(chatScreen, 14));
    }

    @Override
    public final void onLost(Network network) {
        ChatScreen chatScreen = this.chatScreen;
        chatScreen.handler.post(new ChatScreenRunnable(chatScreen, 13));
    }
}
