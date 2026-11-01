package a;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public final class MembersOrVideoResultRunnable implements Runnable {

    public final int mode;

    public final ChatScreen chatScreen;

    public final ArrayList list;

    public final long idOrTimestamp;

    public final Serializable first;

    public final Serializable second;

    public final Serializable third;

    public final Object fourth;

    public final Object fifth;

    public MembersOrVideoResultRunnable(ChatScreen chatScreen, ArrayList arrayList, HashMap hashMap, HashMap hashMap2, ArrayList arrayList2, long j2, JSONObject jSONObject, JSONObject jSONObject2) {
        this.mode = 1;
        this.chatScreen = chatScreen;
        this.list = arrayList;
        this.first = hashMap;
        this.second = hashMap2;
        this.third = arrayList2;
        this.idOrTimestamp = j2;
        this.fourth = jSONObject;
        this.fifth = jSONObject2;
    }

    @Override
    public final void run() {
        String str;
        String optString;
        Object obj = this.fifth;
        Object obj2 = this.fourth;
        Serializable serializable = this.third;
        Serializable serializable2 = this.second;
        Serializable serializable3 = this.first;
        ArrayList arrayList = this.list;
        switch (this.mode) {
            case 0:
                boolean z = ((i.d) serializable3).f846a;
                ChatScreen chatScreen = this.chatScreen;
                long j2 = this.idOrTimestamp;
                if (z) {
                    chatScreen.sendMediaMessage(j2, "video", c.b.N(AppState.p(((i.g) serializable2).f850b), arrayList), ((i.e) obj2).f847a, (ChatMessage) obj, c.j.f773a);
                    return;
                } else {
                    chatScreen.markFailed(j2);
                    chatScreen.toaster.a(((i.g) serializable).f850b);
                    return;
                }
            default:
                ChatScreen chatScreen2 = this.chatScreen;
                chatScreen2.members = arrayList;
                chatScreen2.displayNames.putAll((HashMap) serializable3);
                HashMap hashMap = chatScreen2.memberPics;
                hashMap.putAll((HashMap) serializable2);
                Iterator it = ((ArrayList) serializable).iterator();
                while (it.hasNext()) {
                    hashMap.remove((String) it.next());
                }
                chatScreen2.saveNameChangedAt(this.idOrTimestamp);
                JSONObject jSONObject = (JSONObject) obj2;
                chatScreen2.applyQuickReactionUpdate(jSONObject);
                chatScreen2.applyThemeUpdate(jSONObject);
                JSONObject jSONObject2 = (JSONObject) obj;
                String str2 = "";
                if (jSONObject2 == null || (str = jSONObject2.optString("name", "")) == null) {
                    str = "";
                }
                chatScreen2.groupName = str;
                if (jSONObject2 != null && (optString = jSONObject2.optString("picture", "")) != null) {
                    str2 = optString;
                }
                chatScreen2.groupPic = str2;
                if (str2.length() > 0) {
                    File file = ChatMedia.cacheDir;
                    AvatarView a2 = chatScreen2.groupPicView;
                    if (a2 == null) {
                        i.b.g("headPic");
                        throw null;
                    }
                    ChatMedia.loadAvatar(a2, chatScreen2.groupPic);
                }
                chatScreen2.refreshHeader();
                ChatAndMediaAdapter o0 = chatScreen2.messageAdapter;
                if (o0 == null) {
                    i.b.g("adapter");
                    throw null;
                }
                o0.notifyDataSetChanged();
                chatScreen2.saveCache();
                QuickReactionRefresher quickReactionRefresher = chatScreen2.quickReactionRefresher;
                if (quickReactionRefresher != null) {
                    quickReactionRefresher.a();
                    return;
                }
                return;
        }
    }

    public MembersOrVideoResultRunnable(i.d dVar, ChatScreen chatScreen, long j2, i.g gVar, ArrayList arrayList, i.e eVar, ChatMessage chatMessage, i.g gVar2) {
        this.mode = 0;
        this.first = dVar;
        this.chatScreen = chatScreen;
        this.idOrTimestamp = j2;
        this.second = gVar;
        this.list = arrayList;
        this.fourth = eVar;
        this.fifth = chatMessage;
        this.third = gVar2;
    }
}
