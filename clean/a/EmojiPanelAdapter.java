package a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public final class EmojiPanelAdapter extends BaseAdapter {

    public final List items;

    public final ChatScreen chatScreen;

    public final h.b onEmojiSelected;

    public EmojiPanelAdapter(List list, ChatScreen chatScreen, ChatGestureFunction chatGestureFunction) {
        this.items = list;
        this.chatScreen = chatScreen;
        this.onEmojiSelected = chatGestureFunction;
    }

    @Override
    public final int getCount() {
        return this.items.size();
    }

    @Override
    public final Object getItem(int i2) {
        return this.items.get(i2);
    }

    @Override
    public final long getItemId(int i2) {
        return i2;
    }

    @Override
    public final int getItemViewType(int i2) {
        return !(this.items.get(i2) instanceof String) ? 1 : 0;
    }

    @Override
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        Object obj = this.items.get(i2);
        boolean z = obj instanceof String;
        ChatScreen chatScreen = this.chatScreen;
        if (z) {
            TextView textView = view instanceof TextView ? (TextView) view : null;
            if (textView == null) {
                textView = chatScreen.makeText("", 21.0f, chatScreen.textColor, true);
                float f2 = 10;
                textView.setPadding(chatScreen.dp(f2), chatScreen.dp(16), chatScreen.dp(f2), chatScreen.dp(6));
            }
            textView.setText((CharSequence) obj);
            return textView;
        }
        i.b.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        List list = (List) obj;
        LinearLayout linearLayout = view instanceof LinearLayout ? (LinearLayout) view : null;
        if (linearLayout == null) {
            linearLayout = new LinearLayout(chatScreen.activity);
            linearLayout.setOrientation(0);
            for (int i3 = 0; i3 < 7; i3++) {
                TextView textView2 = new TextView(chatScreen.activity);
                textView2.setTextSize(1, 28.83f);
                textView2.setGravity(17);
                linearLayout.addView(textView2, new LinearLayout.LayoutParams(0, chatScreen.dp(52), 1.0f));
            }
        }
        for (int i4 = 0; i4 < 7; i4++) {
            View childAt = linearLayout.getChildAt(i4);
            i.b.c(childAt, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView3 = (TextView) childAt;
            if (i4 < list.size()) {
                String str = (String) list.get(i4);
                chatScreen.getClass();
                textView3.setText(str);
                textView3.setVisibility(0);
                textView3.setOnClickListener(new PairClickListener((ChatGestureFunction) this.onEmojiSelected, str, 1));
            } else {
                textView3.setText("");
                textView3.setVisibility(4);
                textView3.setOnClickListener(null);
            }
        }
        return linearLayout;
    }

    @Override
    public final int getViewTypeCount() {
        return 2;
    }
}
