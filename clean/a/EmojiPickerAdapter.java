package a;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public final class EmojiPickerAdapter extends BaseAdapter {

    public final ArrayList items;

    public final Object likeSentinel;

    public final ChatScreen chatScreen;

    public final Dialog dialog;

    public final h.b onEmojiSelected;

    public EmojiPickerAdapter(ArrayList arrayList, Object obj, ChatScreen chatScreen, Dialog dialog, h.b bVar) {
        this.items = arrayList;
        this.likeSentinel = obj;
        this.chatScreen = chatScreen;
        this.dialog = dialog;
        this.onEmojiSelected = bVar;
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
        ArrayList arrayList = this.items;
        if (arrayList.get(i2) instanceof String) {
            return 0;
        }
        return arrayList.get(i2) == this.likeSentinel ? 2 : 1;
    }

    @Override
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        Object obj = this.items.get(i2);
        Object obj2 = this.likeSentinel;
        h.b bVar = this.onEmojiSelected;
        Dialog dialog = this.dialog;
        int i3 = 17;
        ChatScreen chatScreen = this.chatScreen;
        if (obj == obj2) {
            LinearLayout linearLayout = new LinearLayout(chatScreen.activity);
            linearLayout.setOrientation(0);
            FrameLayout frameLayout = new FrameLayout(chatScreen.activity);
            float f2 = 42;
            frameLayout.addView(chatScreen.makeIcon("like", chatScreen.barDark, 42), new FrameLayout.LayoutParams(chatScreen.dp(f2), chatScreen.dp(f2), 17));
            frameLayout.setOnClickListener(new PairClickListener(dialog, bVar, 2));
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, chatScreen.dp(77.0f), 1.0f));
            for (int i4 = 0; i4 < 4; i4++) {
                linearLayout.addView(new View(chatScreen.activity), new LinearLayout.LayoutParams(0, chatScreen.dp(77.0f), 1.0f));
            }
            return linearLayout;
        }
        if (obj instanceof String) {
            TextView textView = view instanceof TextView ? (TextView) view : null;
            if (textView == null) {
                textView = chatScreen.makeText("", 20.0f, chatScreen.subTextColor, true);
                textView.setPadding(chatScreen.dp(13.5f), chatScreen.dp(16.0f), chatScreen.dp(10), chatScreen.dp(2));
            }
            textView.setText((CharSequence) obj);
            return textView;
        }
        i.b.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        List list = (List) obj;
        LinearLayout linearLayout2 = view instanceof LinearLayout ? (LinearLayout) view : null;
        if (linearLayout2 == null) {
            linearLayout2 = new LinearLayout(chatScreen.activity);
            linearLayout2.setOrientation(0);
            int i5 = 0;
            while (i5 < 5) {
                TextView textView2 = new TextView(chatScreen.activity);
                textView2.setTextSize(1, 35.34f);
                textView2.setGravity(i3);
                linearLayout2.addView(textView2, new LinearLayout.LayoutParams(0, chatScreen.dp(77.0f), 1.0f));
                i5++;
                i3 = 17;
            }
        }
        for (int i6 = 0; i6 < 5; i6++) {
            View childAt = linearLayout2.getChildAt(i6);
            i.b.c(childAt, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView3 = (TextView) childAt;
            if (i6 < list.size()) {
                String str = (String) list.get(i6);
                chatScreen.getClass();
                textView3.setText(str);
                textView3.setVisibility(0);
                textView3.setOnClickListener(new TripleClickListener(dialog, bVar, str, 1));
            } else {
                textView3.setText("");
                textView3.setVisibility(4);
                textView3.setOnClickListener(null);
            }
        }
        return linearLayout2;
    }

    @Override
    public final int getViewTypeCount() {
        return 3;
    }
}
