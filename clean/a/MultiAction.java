package a;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.nix.host.MainActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class MultiAction implements h.a {

    public final int mode;

    public final Object first;

    public final Object second;

    public final Object third;

    public MultiAction(i.d dVar, C1 c1, i.g gVar) {
        this.mode = 1;
        this.first = dVar;
        this.second = c1;
        this.third = gVar;
    }

    @Override
    public final Object a() {
        String str;
        String str2;
        File m2;
        switch (this.mode) {
            case 0:
                if (((i.d) this.first).f846a) {
                    VideoView videoView = (VideoView) this.third;
                    boolean isPlaying = videoView.isPlaying();
                    C1 c1 = (C1) this.second;
                    if (isPlaying) {
                        videoView.pause();
                        str = "play";
                    } else {
                        videoView.start();
                        str = "pause";
                    }
                    c1.set(str);
                }
                break;
            case 1:
                i.d dVar = (i.d) this.first;
                boolean z = !dVar.f846a;
                dVar.f846a = z;
                ((C1) this.second).set(z ? "mute" : "volume");
                MediaPlayer mediaPlayer = (MediaPlayer) ((i.g) this.third).f850b;
                if (mediaPlayer != null) {
                    boolean z2 = dVar.f846a;
                    mediaPlayer.setVolume(z2 ? 0.0f : 1.0f, z2 ? 0.0f : 1.0f);
                }
                break;
            case 2:
                ChatScreen chatScreen = (ChatScreen) this.first;
                chatScreen.getClass();
                Activity activity = chatScreen.activity;
                Dialog dialog = new Dialog(activity, android.R.style.Theme_Black_NoTitleBar);
                DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
                C0022f1 c0022f1 = (C0022f1) this.third;
                boolean z3 = c0022f1.f484d;
                int i2 = z3 ? chatScreen.textColor : c0022f1.f487g;
                int i3 = z3 ? chatScreen.subTextColor : c0022f1.f488h;
                FrameLayout frameLayout = new FrameLayout(activity);
                boolean z4 = c0022f1.f484d;
                int i4 = (int) (displayMetrics.widthPixels * 0.5f);
                int i5 = (int) (displayMetrics.heightPixels * 0.5f);
                frameLayout.addView(new N2(chatScreen.activity, z4 ? null : c0022f1, chatScreen.bgColor, i4 < 200 ? 200 : i4, i5 < 300 ? 300 : i5), new FrameLayout.LayoutParams(-1, -1));
                LinearLayout k1 = chatScreen.columnLayout();
                LinearLayout P = chatScreen.rowLayout();
                P.setPadding(chatScreen.dp(2.0f), chatScreen.dp(9.0f), chatScreen.dp(8.0f), chatScreen.dp(9.0f));
                P.setBackgroundColor(z4 ? 0 : c0022f1.f494n);
                FrameLayout frameLayout2 = new FrameLayout(activity);
                float f2 = 26;
                frameLayout2.addView(new IconView(activity, "back", i2, 2.4f), new FrameLayout.LayoutParams(chatScreen.dp(f2), chatScreen.dp(f2), 17));
                ChatScreen.setClickAction(frameLayout2, new DismissAction(dialog, 3));
                float f3 = 44;
                P.addView(frameLayout2, ChatScreen.layoutParamsDefault(chatScreen, chatScreen.dp(f3), chatScreen.dp(f3), 0, 0, 0, 60));
                P.addView(chatScreen.makeText("Previewing " + c0022f1.f482b, 21.0f, i2, true), new LinearLayout.LayoutParams(0, -2, 1.0f));
                k1.addView(P, ChatScreen.layoutParamsDefault(chatScreen, -1, -2, 0, 0, 0, 60));
                LinearLayout k12 = chatScreen.columnLayout();
                k12.setPadding(chatScreen.dp(14.0f), chatScreen.dp(14.0f), chatScreen.dp(14.0f), chatScreen.dp(14.0f));
                ChatScreen.addAlignedText(k12, chatScreen, chatScreen.nameText("There are many themes to choose from and they're all a little different.", true, c0022f1), true, 4);
                ChatScreen.addAlignedText(k12, chatScreen, chatScreen.nameText("You'll see the messages you send to other people in this color.", true, c0022f1), true, 3);
                ChatScreen.addAlignedText(k12, chatScreen, chatScreen.nameText("And messages from your friends will look like this.", false, c0022f1), false, 8);
                TextView f1 = chatScreen.makeText("7:00 AM", 14.0f, i3, false);
                f1.setGravity(17);
                k12.addView(f1, chatScreen.layoutParams(-1, -2, 0, 12, 0, 6));
                ChatScreen.addAlignedText(k12, chatScreen, chatScreen.nameText("Tap Select to choose this theme or Cancel to preview others.", true, c0022f1), true, 3);
                k1.addView(k12, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                LinearLayout P2 = chatScreen.rowLayout();
                P2.setPadding(chatScreen.dp(12.0f), chatScreen.dp(8.0f), chatScreen.dp(12.0f), chatScreen.dp(14.0f));
                TextView f12 = chatScreen.makeText("Cancel", 19.0f, -15658735, true);
                f12.setGravity(17);
                f12.setBackground(chatScreen.roundedDrawable(-2318, 14.0f, 0, 0.0f));
                f12.setOnClickListener(new ViewOnClickListenerC0074t(1, dialog));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, chatScreen.dp(52.0f), 1.0f);
                layoutParams.rightMargin = chatScreen.dp(6.0f);
                P2.addView(f12, layoutParams);
                TextView f13 = chatScreen.makeText("Select", 19.0f, -1, true);
                f13.setGravity(17);
                f13.setBackground(chatScreen.roundedDrawable(z4 ? chatScreen.sendBlue : (16777215 & c0022f1.f491k) | (-16777216), 14.0f, 0, 0.0f));
                f13.setOnClickListener(new ViewOnClickListenerC0077u(chatScreen, c0022f1, dialog, (E2) this.second));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, chatScreen.dp(52.0f), 1.0f);
                layoutParams2.leftMargin = chatScreen.dp(6.0f);
                P2.addView(f13, layoutParams2);
                k1.addView(P2, ChatScreen.layoutParamsDefault(chatScreen, -1, -2, 0, 0, 0, 60));
                frameLayout.addView(k1, new FrameLayout.LayoutParams(-1, -1));
                dialog.setContentView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
                Window window = dialog.getWindow();
                if (window != null) {
                    int i6 = chatScreen.bgColor;
                    window.setBackgroundDrawable(new ColorDrawable(i6));
                    window.setLayout(-1, -1);
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(z4 ? i6 : c0022f1.f485e);
                    if (!z4) {
                        i6 = c0022f1.f486f;
                    }
                    window.setNavigationBarColor(i6);
                    boolean z5 = z4 ? !chatScreen.lightBars : c0022f1.q;
                    View decorView = window.getDecorView();
                    decorView.setSystemUiVisibility(z5 ? decorView.getSystemUiVisibility() | 8208 : decorView.getSystemUiVisibility() & (-8209));
                }
                chatScreen.showDialogThemed(dialog);
                break;
            case 3:
                ((ChatScreen) this.first).showMessageInfo((ChatMessage) this.second, (String) this.third);
                break;
            case 4:
                MainActivity mainActivity = (MainActivity) this.first;
                if (mainActivity.emojiToggle == null) {
                    IconView g1 = (IconView) this.second;
                    g1.setIcon("down");
                    View view = new View(mainActivity);
                    view.setBackgroundColor(0);
                    view.setClickable(true);
                    view.setAlpha(0.0f);
                    int i7 = mainActivity.matchParent;
                    ViewGroup.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i7, i7);
                    FrameLayout frameLayout3 = (FrameLayout) this.third;
                    frameLayout3.addView(view, layoutParams3);
                    i.g gVar = new i.g();
                    gVar.f850b = new C0085w1(3);
                    i.g gVar2 = new i.g();
                    gVar2.f850b = new NoopFunction2(0);
                    DragSheetLayout s2Var = new DragSheetLayout(mainActivity, ViewConfiguration.get(mainActivity).getScaledTouchSlop(), gVar, gVar2);
                    s2Var.setOrientation(1);
                    float n2 = mainActivity.dp(28);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(AppState.darkTheme ? -14540254 : -1);
                    gradientDrawable.setCornerRadii(new float[]{n2, n2, n2, n2, 0.0f, 0.0f, 0.0f, 0.0f});
                    gradientDrawable.setStroke(mainActivity.dp(1), AppState.darkTheme ? -13684945 : -1710101);
                    s2Var.setBackground(gradientDrawable);
                    s2Var.setElevation(mainActivity.dp(16));
                    s2Var.setClickable(true);
                    s2Var.setPadding(mainActivity.dp(24), mainActivity.dp(12), mainActivity.dp(24), mainActivity.dp(12));
                    View view2 = new View(mainActivity);
                    view2.setBackground(mainActivity.roundedBg(AppState.darkTheme ? -13684945 : -1710101, 3, 0, 0));
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(mainActivity.dp(40), mainActivity.dp(5));
                    layoutParams4.gravity = 1;
                    layoutParams4.bottomMargin = mainActivity.dp(6);
                    s2Var.addView(view2, layoutParams4);
                    i.d dVar2 = new i.d();
                    MainActivity.addSheetItem(mainActivity, s2Var, dVar2, g1, view, frameLayout3, "Permission", AppState.darkTheme ? -1 : -15656921, new ActivityAction(mainActivity, 8));
                    View view3 = new View(mainActivity);
                    view3.setBackgroundColor(AppState.darkTheme ? -13684945 : -1710101);
                    s2Var.addView(view3, MainActivity.layoutParams(mainActivity, mainActivity.matchParent, 1, 0, 0, 0, 60));
                    MainActivity.addSheetItem(mainActivity, s2Var, dVar2, g1, view, frameLayout3, "Logout", -1096636, new ActivityAction(mainActivity, 9));
                    MainActivity.setAction(view, new EmojiPanelToggle(dVar2, mainActivity, g1, s2Var, view, frameLayout3, 0));
                    mainActivity.emojiToggle = new EmojiPanelToggle(dVar2, mainActivity, g1, s2Var, view, frameLayout3, 1);
                    gVar.f850b = new ValueAction(dVar2, s2Var, view, 2);
                    gVar2.f850b = new DialogContent(s2Var, dVar2, mainActivity, g1, view, frameLayout3);
                    s2Var.setVisibility(4);
                    frameLayout3.addView(s2Var, new FrameLayout.LayoutParams(i7, mainActivity.wrapContent, 80));
                    s2Var.post(new HttpConnectionHandler(s2Var, view, 6));
                }
                break;
            default:
                EditText editText = (EditText) this.first;
                TerminalSession k2 = (TerminalSession) this.third;
                MainActivity mainActivity2 = (MainActivity) this.second;
                int i8 = MainActivity.R;
                String obj = editText.getText().toString();
                k2.getClass();
                int S = m.e.S(obj, ' ') + 1;
                String substring = obj.substring(0, S);
                i.b.d(substring, "substring(...)");
                String substring2 = obj.substring(S);
                i.b.d(substring2, "substring(...)");
                int S2 = m.e.S(substring2, '/');
                if (S2 >= 0) {
                    str2 = substring2.substring(0, S2 + 1);
                    i.b.d(str2, "substring(...)");
                } else {
                    str2 = "";
                }
                String substring3 = substring2.substring(S2 + 1);
                i.b.d(substring3, "substring(...)");
                if (str2.length() != 0) {
                    m2 = k2.resolvePath(str2);
                } else {
                    m2 = k2.currentDir;
                }
                File[] listFiles = m2.listFiles();
                if (listFiles != null) {
                    ArrayList arrayList = new ArrayList();
                    for (File file : listFiles) {
                        if (m.m.K(file.getName(), substring3) && (m.m.K(substring3, ".") || !m.m.K(file.getName(), "."))) {
                            arrayList.add(file);
                        }
                    }
                    List<File> O = c.b.O(arrayList, new N0(3));
                    if (!O.isEmpty()) {
                        if (O.size() == 1) {
                            File file2 = (File) O.get(0);
                            obj = substring + str2 + file2.getName() + (file2.isDirectory() ? "/" : " ");
                        } else {
                            String name = ((File) O.get(0)).getName();
                            for (File file3 : O) {
                                int i9 = 0;
                                while (i9 < name.length() && i9 < file3.getName().length() && name.charAt(i9) == file3.getName().charAt(i9)) {
                                    i9++;
                                }
                                name = name.substring(0, i9);
                                i.b.d(name, "substring(...)");
                            }
                            obj = substring + str2 + name;
                        }
                    }
                }
                editText.setText(obj);
                editText.setSelection(editText.getText().length());
                MainActivity.focusAndShowKeyboard(editText, mainActivity2);
                break;
        }
        return b.d.f770c;
    }

    public MultiAction(Object obj, Object obj2, Object obj3, int i2) {
        this.mode = i2;
        this.first = obj;
        this.third = obj2;
        this.second = obj3;
    }
}
