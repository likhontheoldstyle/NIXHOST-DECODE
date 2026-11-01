package a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import java.io.File;
import org.json.JSONObject;

public final class MultiWorkRunnable implements Runnable {

    public final int mode;

    public final Object first;

    public final String text;

    public final int sizeOrCount;

    public final Object owner;

    public final Object extra;

    public MultiWorkRunnable(ChatMessage chatMessage, String str, int i2, ChatScreen chatScreen, ApiResponse apiResponse) {
        this.mode = 1;
        this.first = chatMessage;
        this.text = str;
        this.sizeOrCount = i2;
        this.owner = chatScreen;
        this.extra = apiResponse;
    }

    @Override
    public final void run() {
        String concat;
        switch (this.mode) {
            case 0:
                ApiClient apiClient = ApiClient.INSTANCE;
                ChatMessage chatMessage = (ChatMessage) this.first;
                ApiResponse b2 = ApiClient.requestWithDefaults(apiClient, "POST", "/chat/edit/" + chatMessage.id, new JSONObject().put("text", this.text), 8);
                if (!b2.isSuccess()) {
                    ChatScreen chatScreen = (ChatScreen) this.owner;
                    chatScreen.activity.runOnUiThread(new MultiWorkRunnable(chatMessage, (String) this.extra, this.sizeOrCount, chatScreen, b2));
                    break;
                }
                break;
            case 1:
                String str = this.text;
                ChatMessage chatMessage2 = (ChatMessage) this.first;
                chatMessage2.text = str;
                chatMessage2.status = this.sizeOrCount;
                ChatScreen chatScreen2 = (ChatScreen) this.owner;
                chatScreen2.applyScroll(false);
                chatScreen2.toaster.a(ChatScreen.errorText((ApiResponse) this.extra));
                break;
            case 2:
                File file = ChatMedia.cacheDir;
                String str2 = this.text;
                File b3 = ChatMedia.fetchMediaFile(str2);
                Bitmap a2 = b3 != null ? ChatMedia.decodeSampled(b3, this.sizeOrCount) : null;
                if (a2 != null) {
                    ChatMedia.bitmapCache.put((String) this.extra, a2);
                }
                ChatMedia.mainHandler.post(new QuadTaskRunnable(this.first, str2, (Object) a2, this.owner, 7));
                break;
            default:
                String str3 = this.text;
                String str4 = (String) this.extra;
                File file2 = (File) this.first;
                int i2 = this.sizeOrCount;
                TerminalSession terminalSession = (TerminalSession) this.owner;
                try {
                    concat = Workspace.gclone(str3, str4, file2);
                } catch (Exception e2) {
                    String message = e2.getMessage();
                    if (message == null) {
                        message = "error";
                    }
                    concat = "Failed: ".concat(message);
                }
                if (i2 == terminalSession.generation) {
                    terminalSession.echo(concat + "\n");
                    terminalSession.finishRun();
                    break;
                }
                break;
        }
    }

    public MultiWorkRunnable(ChatMessage chatMessage, String str, ChatScreen chatScreen, String str2, int i2) {
        this.mode = 0;
        this.first = chatMessage;
        this.text = str;
        this.owner = chatScreen;
        this.extra = str2;
        this.sizeOrCount = i2;
    }

    public MultiWorkRunnable(String str, int i2, String str2, ImageView imageView, h.b bVar) {
        this.mode = 2;
        this.text = str;
        this.sizeOrCount = i2;
        this.extra = str2;
        this.first = imageView;
        this.owner = bVar;
    }

    public MultiWorkRunnable(String str, String str2, File file, int i2, TerminalSession terminalSession) {
        this.mode = 3;
        this.text = str;
        this.extra = str2;
        this.first = file;
        this.sizeOrCount = i2;
        this.owner = terminalSession;
    }
}
