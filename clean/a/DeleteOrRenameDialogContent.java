package a;

import android.app.Dialog;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class DeleteOrRenameDialogContent implements h.c {

    public final int mode;

    public final ChatScreen chatScreen;

    public final Object target;

    public DeleteOrRenameDialogContent(ChatScreen chatScreen, Object obj, int i2) {
        this.mode = i2;
        this.chatScreen = chatScreen;
        this.target = obj;
    }

    @Override
    public final Object a(Object obj, Object obj2) {
        switch (this.mode) {
            case 0:
                LinearLayout linearLayout = (LinearLayout) obj;
                Dialog dialog = (Dialog) obj2;
                ChatScreen chatScreen = this.chatScreen;
                linearLayout.addView(new View(chatScreen.activity), new LinearLayout.LayoutParams(-1, chatScreen.dp(6)));
                ChatMessage chatMessage = (ChatMessage) this.target;
                chatScreen.menuRow(linearLayout, "trashf", "Delete for me", chatScreen.textColor, new MessageMenuAction(dialog, chatScreen, chatMessage, 3));
                chatScreen.menuRow(linearLayout, "trashf", "Delete for everyone", chatScreen.textColor, new MessageMenuAction(dialog, chatScreen, chatMessage, 4));
                break;
            default:
                LinearLayout linearLayout2 = (LinearLayout) obj;
                Dialog dialog2 = (Dialog) obj2;
                ChatScreen chatScreen2 = this.chatScreen;
                TextView f1 = chatScreen2.makeText("Change name", 21.0f, chatScreen2.textColor, true);
                f1.setGravity(17);
                linearLayout2.addView(f1, chatScreen2.layoutParams(-1, -2, 0, 4, 0, 4));
                TextView f12 = chatScreen2.makeText("You can change your name once a week.", 14.5f, chatScreen2.subTextColor, false);
                f12.setGravity(17);
                linearLayout2.addView(f12, chatScreen2.layoutParams(-1, -2, 16, 0, 16, 12));
                EditText editText = new EditText(chatScreen2.activity);
                String str = (String) this.target;
                editText.setText(str);
                int i2 = chatScreen2.textColor;
                editText.setTextColor(i2);
                editText.setTextSize(1, 19.251001f);
                editText.setBackground(chatScreen2.roundedDrawable(chatScreen2.panelColor, 6.0f, chatScreen2.lightBars ? -7697007 : -3420978, 1.0f));
                float f2 = 14;
                float f3 = 12;
                editText.setPadding(chatScreen2.dp(f2), chatScreen2.dp(f3), chatScreen2.dp(f2), chatScreen2.dp(f3));
                editText.setSingleLine(true);
                editText.setInputType(8193);
                editText.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(30)});
                linearLayout2.addView(editText, chatScreen2.layoutParams(-1, -2, 16, 0, 16, 12));
                LinearLayout P = chatScreen2.rowLayout();
                TextView f13 = chatScreen2.makeText("Cancel", 19.0f, i2, true);
                f13.setGravity(17);
                f13.setBackground(chatScreen2.roundedDrawable(chatScreen2.chipColor, 6.0f, 0, 0.0f));
                f13.setOnClickListener(new DialogDismissClickListener(0, dialog2));
                float f4 = 46;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, chatScreen2.dp(f4), 1.0f);
                float f5 = 8;
                layoutParams.rightMargin = chatScreen2.dp(f5);
                P.addView(f13, layoutParams);
                TextView f14 = chatScreen2.makeText("Save", 19.0f, -1, true);
                f14.setGravity(17);
                f14.setBackground(chatScreen2.roundedDrawable(chatScreen2.sendBlue, 6.0f, 0, 0.0f));
                f14.setOnClickListener(new ChatSettingsClickListener(editText, chatScreen2, str, dialog2));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, chatScreen2.dp(f4), 1.0f);
                layoutParams2.leftMargin = chatScreen2.dp(f5);
                P.addView(f14, layoutParams2);
                linearLayout2.addView(P, chatScreen2.layoutParams(-1, -2, 16, 0, 16, 12));
                editText.post(new FocusInputRunnable(editText, chatScreen2, 0));
                break;
        }
        return b.d.f770c;
    }
}
