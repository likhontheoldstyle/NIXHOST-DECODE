package a;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ChatScreenRunnable implements Runnable {

    public final int mode;

    public final ChatScreen chatScreen;

    public ChatScreenRunnable(ChatScreen chatScreen, int i2) {
        this.mode = i2;
        this.chatScreen = chatScreen;
    }

    @Override
    public final void run() {
        OutboxEntry outboxEntry;
        ApiResponse apiResponse;
        JSONObject optJSONObject;
        switch (this.mode) {
            case 0:
                ChatScreen chatScreen = this.chatScreen;
                ChatListView i2 = chatScreen.messageList;
                if (i2 != null) {
                    i2.post(new ChatScreenRunnable(chatScreen, 2));
                    return;
                } else {
                    i.b.g("lv");
                    throw null;
                }
            case 1:
                ApiResponse b2 = ApiClient.requestWithDefaults(ApiClient.INSTANCE, "POST", "/chat/clear", new JSONObject(), 8);
                ChatScreen chatScreen2 = this.chatScreen;
                chatScreen2.activity.runOnUiThread(new ChatResultRunnable(b2, chatScreen2, 0));
                return;
            case 2:
                this.chatScreen.maybeLoadOlderAtTop();
                return;
            case 3:
                ChatScreen chatScreen3 = this.chatScreen;
                while (true) {
                    synchronized (chatScreen3.outbox) {
                        outboxEntry = (OutboxEntry) c.b.I(chatScreen3.outbox);
                    }
                    if (outboxEntry == null) {
                        break;
                    }
                    apiResponse = ApiClient.INSTANCE.sendChatMessage(outboxEntry.body);
                    if (apiResponse.code == 0) {
                        break;
                    }
                    synchronized (chatScreen3.outbox) {
                        chatScreen3.outbox.remove(outboxEntry);
                    }
                    chatScreen3.saveOutbox();
                    chatScreen3.activity.runOnUiThread(new BackgroundTask(chatScreen3, apiResponse, outboxEntry, 2, (byte) 0));
                    if (apiResponse.code == 401) {
                        break;
                    }
                }
                chatScreen3.outboxFlushing = false;
                return;
            case 4:
                ApiResponse b3 = ApiClient.requestWithDefaults(ApiClient.INSTANCE, "DELETE", "/chat/avatar", null, 12);
                ChatScreen chatScreen4 = this.chatScreen;
                chatScreen4.activity.runOnUiThread(new ChatResultRunnable(b3, chatScreen4, 1));
                return;
            case 5:
                ApiResponse b4 = ApiClient.requestWithDefaults(ApiClient.INSTANCE, "GET", "/chat/members", null, 12);
                JSONObject c2 = b4.json();
                JSONArray optJSONArray = c2 != null ? c2.optJSONArray("members") : null;
                if (!b4.isSuccess() || optJSONArray == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                ArrayList arrayList2 = new ArrayList();
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject2 != null) {
                        arrayList.add(optJSONObject2.optString("u"));
                        hashMap.put(optJSONObject2.optString("u"), optJSONObject2.optString("n", optJSONObject2.optString("u")));
                        String optString = optJSONObject2.optString("p", "");
                        int length2 = optString.length();
                        String optString2 = optJSONObject2.optString("u");
                        if (length2 > 0) {
                            hashMap2.put(optString2, optString);
                        } else {
                            arrayList2.add(optString2);
                        }
                    }
                }
                JSONObject optJSONObject3 = c2 != null ? c2.optJSONObject("group") : null;
                long j2 = 0;
                if (c2 != null && (optJSONObject = c2.optJSONObject("self")) != null) {
                    j2 = optJSONObject.optLong("nat", 0L);
                }
                ChatScreen chatScreen5 = this.chatScreen;
                chatScreen5.activity.runOnUiThread(new MembersOrVideoResultRunnable(chatScreen5, arrayList, hashMap, hashMap2, arrayList2, j2, c2, optJSONObject3));
                return;
            case 6:
                ChatAndMediaAdapter o0 = this.chatScreen.messageAdapter;
                if (o0 != null) {
                    o0.notifyDataSetChanged();
                    return;
                } else {
                    i.b.g("adapter");
                    throw null;
                }
            case 7:
                this.chatScreen.scrollToReplyTarget();
                return;
            case 8:
                ChatScreen chatScreen6 = this.chatScreen;
                Object systemService = chatScreen6.activity.getSystemService("input_method");
                i.b.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                EditText editText = chatScreen6.messageInput;
                if (editText != null) {
                    inputMethodManager.showSoftInput(editText, 1);
                    return;
                } else {
                    i.b.g("input");
                    throw null;
                }
            case 9:
                this.chatScreen.toaster.a("Could not read the photo");
                return;
            case 10:
                LinearLayout linearLayout = this.chatScreen.emojiPanel;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                    return;
                } else {
                    i.b.g("panel");
                    throw null;
                }
            case 11:
                ChatScreen chatScreen7 = this.chatScreen;
                ChatListView i22 = chatScreen7.messageList;
                if (i22 == null) {
                    i.b.g("lv");
                    throw null;
                }
                if (chatScreen7.messageAdapter != null) {
                    i22.setSelection(chatScreen7.messageAdapter.getCount() - 1);
                    return;
                } else {
                    i.b.g("adapter");
                    throw null;
                }
            case 12:
                this.chatScreen.maybeLoadOlderAtTop();
                return;
            case 13:
                ChatScreen chatScreen8 = this.chatScreen;
                if (!chatScreen8.active || chatScreen8.isOnline()) {
                    return;
                }
                chatScreen8.setConnectionState(1);
                return;
            default:
                ChatScreen chatScreen9 = this.chatScreen;
                if (chatScreen9.active) {
                    if (chatScreen9.connectionState == 1) {
                        chatScreen9.setConnectionState(2);
                    }
                    if (chatScreen9.members.isEmpty()) {
                        chatScreen9.refreshMembers();
                    }
                    chatScreen9.syncSeen();
                    return;
                }
                return;
        }
    }
}
