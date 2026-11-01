package a;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class SendAndPersistRunnable implements Runnable {

    public final int mode;

    public final long idOrInterval;

    public final Object first;

    public final Object second;

    public final Object third;

    public SendAndPersistRunnable(AtomicBoolean atomicBoolean, long j2, File file, TerminalSession terminalSession) {
        this.mode = 1;
        this.first = atomicBoolean;
        this.idOrInterval = j2;
        this.second = file;
        this.third = terminalSession;
    }

    @Override
    public final void run() {
        switch (this.mode) {
            case 0:
                ApiClient apiClient = ApiClient.INSTANCE;
                JSONObject jSONObject = (JSONObject) this.first;
                ApiResponse d2 = apiClient.sendChatMessage(jSONObject);
                ChatScreen chatScreen = (ChatScreen) this.second;
                chatScreen.activity.runOnUiThread(new ChatSendRunnable(d2, chatScreen, this.idOrInterval, jSONObject, (ChatMessage) this.third));
                break;
            default:
                long j2 = this.idOrInterval;
                while (true) {
                    AtomicBoolean atomicBoolean = (AtomicBoolean) this.first;
                    if (!atomicBoolean.get()) {
                        break;
                    } else {
                        try {
                            Thread.sleep(j2);
                            if (!atomicBoolean.get()) {
                                break;
                            } else {
                                TermuxPackageManager.INSTANCE.refreshShimsAndHelpers((File) this.second, ((TerminalSession) this.third).envHomeDir);
                            }
                        } catch (InterruptedException unused) {
                        }
                    }
                }
        }
    }

    public SendAndPersistRunnable(JSONObject jSONObject, ChatScreen chatScreen, long j2, ChatMessage chatMessage) {
        this.mode = 0;
        this.first = jSONObject;
        this.second = chatScreen;
        this.idOrInterval = j2;
        this.third = chatMessage;
    }
}
