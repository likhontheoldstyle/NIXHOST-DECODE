package a;

import android.app.Dialog;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public final class ReactionAction implements h.a {

    public final int mode;

    public final ChatScreen chatScreen;

    public final List reactions;

    public final ChatMessage message;

    public ReactionAction(ChatScreen chatScreen, ChatMessage chatMessage, List list) {
        this.mode = 0;
        this.chatScreen = chatScreen;
        this.message = chatMessage;
        this.reactions = list;
    }

    @Override
    public final Object a() {
        switch (this.mode) {
            case 0:
                final ChatScreen chatScreen = this.chatScreen;
                chatScreen.getClass();
                final i.g gVar = new i.g();
                gVar.f850b = "";
                final List list = this.reactions;
                final ChatMessage chatMessage = this.message;
                chatScreen.showBottomSheet(false, new h.c() {
                    @Override
                    public final Object a(Object obj, Object obj2) {
                        LinearLayout linearLayout = (LinearLayout) obj;
                        Dialog dialog = (Dialog) obj2;
                        ChatScreen chatScreen2 = chatScreen;
                        TextView f1 = chatScreen2.makeText("Reactions", 21.0f, chatScreen2.textColor, true);
                        f1.setGravity(17);
                        linearLayout.addView(f1, chatScreen2.layoutParams(-1, -2, 0, 23, 0, 12));
                        ScrollView scrollView = new ScrollView(chatScreen2.activity);
                        LinearLayout k1 = chatScreen2.columnLayout();
                        scrollView.addView(k1, new FrameLayout.LayoutParams(-1, -2));
                        linearLayout.addView(scrollView, new LinearLayout.LayoutParams(-1, ((int) (chatScreen2.activity.getResources().getDisplayMetrics().heightPixels * 0.5f)) - chatScreen2.dp(133)));
                        LinearLayout P = chatScreen2.rowLayout();
                        float f2 = 14;
                        P.setPadding(chatScreen2.dp(f2), chatScreen2.dp(8), chatScreen2.dp(f2), 0);
                        linearLayout.addView(P, ChatScreen.layoutParamsDefault(chatScreen2, -1, -2, 0, 0, 0, 60));
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        List list2 = list;
                        Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            Object obj3 = ((b.b) it.next()).f765b;
                            Integer num = (Integer) linkedHashMap.get(obj3);
                            linkedHashMap.put(obj3, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
                        }
                        ChatScreen.bindReactionList(k1, list2, gVar, chatScreen2, P, linkedHashMap, dialog, chatMessage, chatScreen2.lightBars ? -16777216 : -1775893);
                        return b.d.f770c;
                    }
                });
                break;
            case 1:
                this.chatScreen.showMessageInfo(this.message, (String) this.reactions.get(0));
                break;
            case 2:
                this.chatScreen.showMessageInfo(this.message, (String) this.reactions.get(0));
                break;
            default:
                this.chatScreen.showMessageInfo(this.message, (String) this.reactions.get(1));
                break;
        }
        return b.d.f770c;
    }

    public ReactionAction(ChatScreen chatScreen, List list, ChatMessage chatMessage, int i2) {
        this.mode = i2;
        this.chatScreen = chatScreen;
        this.reactions = list;
        this.message = chatMessage;
    }
}
