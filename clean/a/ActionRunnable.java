package a;

import android.app.NotificationManager;
import android.app.RemoteInput;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.nix.host.NotifyReceiver;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ActionRunnable implements Runnable {

    public final int mode;

    public final long messageId;

    public final Object first;

    public final Object second;

    public final Object third;

    public final Object fourth;

    public final Object fifth;

    public ActionRunnable(Object obj, Object obj2, long j2, Object obj3, Object obj4, Object obj5, int i2) {
        this.mode = i2;
        this.first = obj;
        this.second = obj2;
        this.messageId = j2;
        this.third = obj3;
        this.fourth = obj4;
        this.fifth = obj5;
    }

    @Override
    public final void run() {
        String str;
        CharSequence charSequence;
        String obj;
        boolean z = true;
        switch (this.mode) {
            case 0:
                ApiResponse apiResponse = (ApiResponse) this.first;
                int i2 = apiResponse.code;
                ChatScreen chatScreen = (ChatScreen) this.second;
                if (i2 == 401) {
                    chatScreen.onSessionExpired.a();
                    return;
                }
                boolean b2 = apiResponse.isSuccess();
                long j2 = this.messageId;
                if (b2) {
                    c.h.G(chatScreen.messages, new IdPredicate(j2, 1));
                    JSONObject c2 = apiResponse.json();
                    JSONObject optJSONObject = c2 != null ? c2.optJSONObject("msg") : null;
                    if (optJSONObject != null) {
                        chatScreen.addMessages(new JSONArray().put(optJSONObject));
                    }
                    chatScreen.refreshMessages();
                    chatScreen.applyScroll(true);
                    return;
                }
                if (apiResponse.code == 0) {
                    chatScreen.queueRetry(j2, (JSONObject) this.third, (ChatMessage) this.fourth);
                    chatScreen.setConnectionState(1);
                    return;
                }
                chatScreen.markFailed(j2);
                chatScreen.toaster.a(ChatScreen.errorText(apiResponse));
                h.a aVar = (h.a) this.fifth;
                if (aVar != null) {
                    aVar.a();
                    return;
                }
                return;
            default:
                Context context = (Context) this.first;
                String str2 = (String) this.second;
                long j3 = this.messageId;
                String str3 = (String) this.third;
                Intent intent = (Intent) this.fourth;
                BroadcastReceiver.PendingResult pendingResult = (BroadcastReceiver.PendingResult) this.fifth;
                int i3 = NotifyReceiver.f801a;
                try {
                    AppState.prefs = context.getSharedPreferences("nixhost", 0);
                    ApiClient apiClient = ApiClient.INSTANCE;
                    ApiClient.loadBaseUrl(context);
                    if (i.b.a(str2, "com.nix.host.CHAT_LIKE")) {
                        if (apiClient.sendChatMessage(new JSONObject().put("type", "like")).isSuccess()) {
                            if (j3 > 0) {
                                apiClient.markSeen(j3);
                            }
                            ChatNotifier.INSTANCE.showOwnMessageNotification(context, str3, "👍", j3);
                        } else {
                            ChatNotifier chatNotifier = ChatNotifier.INSTANCE;
                            if (ChatNotifier.displayNames.get(str3) != null) {
                                z = false;
                            }
                            chatNotifier.refreshMembers(z);
                            chatNotifier.showNotification(context, str3, AppState.p("Not sent (no internet?)"), j3, true);
                        }
                    } else if (i.b.a(str2, "com.nix.host.CHAT_REPLY")) {
                        Bundle resultsFromIntent = RemoteInput.getResultsFromIntent(intent);
                        if (resultsFromIntent == null || (charSequence = resultsFromIntent.getCharSequence("reply_text")) == null || (obj = charSequence.toString()) == null || (str = m.e.h0(obj).toString()) == null) {
                            str = "";
                        }
                        if (str.length() == 0) {
                            ChatNotifier chatNotifier2 = ChatNotifier.INSTANCE;
                            Object systemService = context.getSystemService("notification");
                            i.b.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                            String lowerCase = str3.toLowerCase(Locale.ROOT);
                            i.b.d(lowerCase, "toLowerCase(...)");
                            ((NotificationManager) systemService).cancel((lowerCase.hashCode() & 65535) + 2000);
                            synchronized (chatNotifier2) {
                            }
                        } else if (apiClient.sendChatMessage(new JSONObject().put("type", "text").put("text", str)).isSuccess()) {
                            if (j3 > 0) {
                                apiClient.markSeen(j3);
                            }
                            ChatNotifier.INSTANCE.showOwnMessageNotification(context, str3, str, j3);
                        } else {
                            ChatNotifier chatNotifier3 = ChatNotifier.INSTANCE;
                            if (ChatNotifier.displayNames.get(str3) != null) {
                                z = false;
                            }
                            chatNotifier3.refreshMembers(z);
                            chatNotifier3.showNotification(context, str3, AppState.p("Not sent (no internet?)"), j3, true);
                        }
                    }
                } catch (Throwable unused) {
                }
                pendingResult.finish();
                return;
        }
    }
}
