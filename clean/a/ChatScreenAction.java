package a;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public final class ChatScreenAction implements h.a {

    public final int mode;

    public final ChatScreen chatScreen;

    public ChatScreenAction(ChatScreen chatScreen, int i2) {
        this.mode = i2;
        this.chatScreen = chatScreen;
    }

    @Override
    public final Object a() {
        float f2;
        float f3;
        LinearLayout linearLayout;
        ScrollView scrollView;
        SlideDownDialog e2;
        FrameLayout frameLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        int i2;
        List list;
        int i3;
        boolean z;
        int i4 = 3;
        int i5 = 0;
        ChatScreen chatScreen = this.chatScreen;
        switch (this.mode) {
            case 0:
                if (m.m.F(chatScreen.username, chatScreen.groupId)) {
                    if (chatScreen.isOffline()) {
                        chatScreen.showNoInternetDialog();
                    } else {
                        new Thread(new ChatScreenRunnable(chatScreen, 1)).start();
                    }
                }
                return b.d.f770c;
            case 1:
                ChatScreen chatScreen2 = this.chatScreen;
                b.b H = chatScreen2.makeFullscreenDialog();
                Dialog dialog = (Dialog) H.f764a;
                LinearLayout linearLayout4 = (LinearLayout) H.f765b;
                chatScreen2.sourceDialog = dialog;
                linearLayout4.addView(chatScreen2.dialogColumn(dialog, null), ChatScreen.layoutParamsDefault(chatScreen2, -1, -2, 0, 0, 0, 60));
                ScrollView scrollView2 = new ScrollView(chatScreen2.activity);
                scrollView2.setVerticalScrollBarEnabled(false);
                LinearLayout k1 = chatScreen2.columnLayout();
                scrollView2.addView(k1, new FrameLayout.LayoutParams(-1, -2));
                linearLayout4.addView(scrollView2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                ChatScreen.buildGroupInfo(chatScreen2, k1);
                chatScreen2.quickReactionRefresher = new QuickReactionRefresher(k1, chatScreen2);
                dialog.setOnDismissListener(new SharedOnDismissListener(0, chatScreen2));
                chatScreen2.showDialogThemed(dialog);
                chatScreen2.refreshMembers();
                return b.d.f770c;
            case 2:
                chatScreen.setReplyTarget(null);
                return b.d.f770c;
            case 3:
                EditText editText = chatScreen.messageInput;
                if (editText == null) {
                    i.b.g("input");
                    throw null;
                }
                editText.requestFocus();
                EditText editText2 = chatScreen.messageInput;
                if (editText2 == null) {
                    i.b.g("input");
                    throw null;
                }
                editText2.dispatchKeyEvent(new KeyEvent(0, 67));
                EditText editText3 = chatScreen.messageInput;
                if (editText3 == null) {
                    i.b.g("input");
                    throw null;
                }
                editText3.dispatchKeyEvent(new KeyEvent(1, 67));
                LinearLayout linearLayout5 = chatScreen.emojiPanel;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(0);
                    return b.d.f770c;
                }
                i.b.g("panel");
                throw null;
            case 4:
                h.b bVar = chatScreen.toaster;
                Activity activity = chatScreen.activity;
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("_display_name", "NixChat_" + System.currentTimeMillis() + ".jpg");
                    contentValues.put("mime_type", "image/jpeg");
                    Uri insert = activity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    if (insert == null) {
                        bVar.a("Camera is not available");
                    } else {
                        chatScreen.cameraUri = insert;
                        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                        intent.putExtra("output", insert);
                        intent.addFlags(3);
                        activity.startActivityForResult(intent, 79);
                    }
                } catch (Exception unused) {
                    bVar.a("No camera app found");
                }
                return b.d.f770c;
            case 5:
                File file = chatScreen.recordFile;
                if (file != null) {
                    chatScreen.toggleVoicePlayback(-2L, file);
                }
                return b.d.f770c;
            case 6:
                chatScreen.cancelRecording();
                return b.d.f770c;
            case 7:
                chatScreen.avatarPickPending = false;
                chatScreen.requestMediaPermission();
                return b.d.f770c;
            case 8:
                chatScreen.startRecording(false);
                return b.d.f770c;
            case 9:
                LinearLayout linearLayout6 = chatScreen.emojiPanel;
                if (linearLayout6 == null) {
                    i.b.g("panel");
                    throw null;
                }
                int visibility = linearLayout6.getVisibility();
                Activity activity2 = chatScreen.activity;
                if (visibility == 0) {
                    LinearLayout linearLayout7 = chatScreen.emojiPanel;
                    if (linearLayout7 == null) {
                        i.b.g("panel");
                        throw null;
                    }
                    linearLayout7.setVisibility(8);
                    EditText editText4 = chatScreen.messageInput;
                    if (editText4 == null) {
                        i.b.g("input");
                        throw null;
                    }
                    editText4.requestFocus();
                    Object systemService = activity2.getSystemService("input_method");
                    i.b.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                    InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                    EditText editText5 = chatScreen.messageInput;
                    if (editText5 == null) {
                        i.b.g("input");
                        throw null;
                    }
                    inputMethodManager.showSoftInput(editText5, 0);
                } else {
                    Object systemService2 = activity2.getSystemService("input_method");
                    i.b.c(systemService2, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                    InputMethodManager inputMethodManager2 = (InputMethodManager) systemService2;
                    EditText editText6 = chatScreen.messageInput;
                    if (editText6 == null) {
                        i.b.g("input");
                        throw null;
                    }
                    inputMethodManager2.hideSoftInputFromWindow(editText6.getWindowToken(), 0);
                    chatScreen.handler.postDelayed(new ChatScreenRunnable(chatScreen, 10), 120L);
                }
                return b.d.f770c;
            case 10:
                EditText editText7 = chatScreen.messageInput;
                if (editText7 == null) {
                    i.b.g("input");
                    throw null;
                }
                String obj = m.e.h0(editText7.getText().toString()).toString();
                if (obj.length() == 0) {
                    String p0 = ChatScreen.quickReaction();
                    if (p0.length() == 0) {
                        ChatScreen.sendTextMessage(chatScreen, "like", null, null, 62);
                    } else {
                        ChatScreen.sendTextMessage(chatScreen, "text", p0, null, 60);
                    }
                } else {
                    EditText editText8 = chatScreen.messageInput;
                    if (editText8 == null) {
                        i.b.g("input");
                        throw null;
                    }
                    editText8.setText("");
                    ChatScreen.sendTextMessage(chatScreen, "text", obj, new PairAction(chatScreen, obj, 0), 28);
                }
                return b.d.f770c;
            case 11:
                chatScreen.toaster.a("Stickers are coming soon");
                return b.d.f770c;
            case 12:
                chatScreen.toaster.a("GIF is coming soon");
                return b.d.f770c;
            case 13:
                float f4 = chatScreen.playbackSpeed;
                if (f4 >= 2.0f) {
                    f2 = 1.0f;
                } else {
                    f2 = 1.5f;
                    if (f4 >= 1.5f) {
                        f2 = 2.0f;
                    }
                }
                chatScreen.playbackSpeed = f2;
                String V0 = ChatScreen.formatSpeed(f2);
                Iterator it = chatScreen.speedLabels.values().iterator();
                while (it.hasNext()) {
                    ((TextView) it.next()).setText(V0);
                }
                MediaPlayer mediaPlayer = chatScreen.audioPlayer;
                if (mediaPlayer != null) {
                    try {
                        if (mediaPlayer.isPlaying()) {
                            chatScreen.applyPlaybackSpeed(mediaPlayer, chatScreen.playingMessageId);
                        }
                    } catch (Exception unused2) {
                    }
                }
                return b.d.f770c;
            case 14:
                chatScreen.getClass();
                chatScreen.showBottomSheet(false, new MediaPickerContent(chatScreen, 1));
                return b.d.f770c;
            case 15:
                long Z = chatScreen.savedNameChangedAt();
                long currentTimeMillis = (chatScreen.nameChangeCooldownMs + Z) - System.currentTimeMillis();
                if (Z <= 0 || currentTimeMillis <= 0) {
                    chatScreen.showBottomSheet(true, new DeleteOrRenameDialogContent(chatScreen, chatScreen.displayName(chatScreen.username), 1));
                } else {
                    chatScreen.toaster.a(StringPlus.stringPlus("You can change your name once a week. Try again in ", ChatScreen.formatDaysLeft(currentTimeMillis)));
                }
                return b.d.f770c;
            case 16:
                ChatScreen chatScreen3 = this.chatScreen;
                b.b H2 = chatScreen3.makeFullscreenDialog();
                Dialog dialog2 = (Dialog) H2.f764a;
                LinearLayout linearLayout8 = (LinearLayout) H2.f765b;
                linearLayout8.addView(chatScreen3.dialogColumn(dialog2, "See members"), ChatScreen.layoutParamsDefault(chatScreen3, -1, -2, 0, 0, 0, 60));
                Activity activity3 = chatScreen3.activity;
                View view = new View(activity3);
                view.setBackgroundColor(chatScreen3.bubbleAltColor);
                linearLayout8.addView(view, ChatScreen.layoutParamsDefault(chatScreen3, -1, 1, 0, 0, 0, 60));
                ScrollView scrollView3 = new ScrollView(activity3);
                scrollView3.setVerticalScrollBarEnabled(false);
                LinearLayout k12 = chatScreen3.columnLayout();
                List O = c.b.O(chatScreen3.members.isEmpty() ? AppState.p(chatScreen3.username) : chatScreen3.members, new MemberComparator(chatScreen3));
                String str = O.size() + " members";
                int i6 = chatScreen3.textColor;
                TextView f1 = chatScreen3.makeText(str, 19.5f, i6, true);
                float f5 = 14;
                float f6 = 20;
                f1.setPadding(chatScreen3.dp(f5), chatScreen3.dp(16), chatScreen3.dp(f6), chatScreen3.dp(8));
                k12.addView(f1);
                Iterator it2 = O.iterator();
                while (it2.hasNext()) {
                    String str2 = (String) it2.next();
                    boolean F = m.m.F(str2, chatScreen3.groupId);
                    LinearLayout P = chatScreen3.rowLayout();
                    float f7 = 11;
                    Iterator it3 = it2;
                    P.setPadding(chatScreen3.dp(f5), chatScreen3.dp(f7), chatScreen3.dp(f6), chatScreen3.dp(f7));
                    P.setMinimumHeight(chatScreen3.dp(66));
                    float f8 = 44;
                    AvatarView k2 = chatScreen3.avatarView(str2, f8);
                    int z2 = chatScreen3.dp(f8);
                    int z3 = chatScreen3.dp(f8);
                    Activity activity4 = activity3;
                    LinearLayout linearLayout9 = linearLayout8;
                    P.addView(k2, ChatScreen.layoutParamsDefault(chatScreen3, z2, z3, 0, 0, 9, 32));
                    LinearLayout k13 = chatScreen3.columnLayout();
                    int i7 = i6;
                    k13.addView(chatScreen3.makeText(chatScreen3.displayName(str2), 21.5f, i6, false), ChatScreen.layoutParamsDefault(chatScreen3, -2, -2, 0, 0, 0, 60));
                    if (F) {
                        f3 = f5;
                        linearLayout = k13;
                        linearLayout.addView(chatScreen3.makeText("Admin", 21.0f, chatScreen3.lightBars ? chatScreen3.subTextColor : -7697007, false), ChatScreen.layoutParamsDefault(chatScreen3, -2, -2, 0, 0, 0, 60));
                    } else {
                        f3 = f5;
                        linearLayout = k13;
                    }
                    P.addView(linearLayout, new LinearLayout.LayoutParams(0, -2, 1.0f));
                    k12.addView(P);
                    f5 = f3;
                    it2 = it3;
                    linearLayout8 = linearLayout9;
                    i6 = i7;
                    activity3 = activity4;
                }
                k12.addView(new View(activity3), ChatScreen.layoutParamsDefault(chatScreen3, -1, chatScreen3.dp(24), 0, 0, 0, 60));
                scrollView3.addView(k12, new FrameLayout.LayoutParams(-1, -2));
                linearLayout8.addView((View) scrollView3, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                chatScreen3.showDialogThemed(dialog2);
                return b.d.f770c;
            case 17:
                ChatScreen chatScreen4 = this.chatScreen;
                chatScreen4.showConfirmDialog("Clear group data?", "All messages of this group will be deleted for everyone. This cannot be undone.", "Cancel", "OK", new ChatScreenAction(chatScreen4, i5));
                return b.d.f770c;
            case 18:
                ChatScreen chatScreen5 = this.chatScreen;
                chatScreen5.getClass();
                Activity activity5 = chatScreen5.activity;
                SlideDownDialog e22 = new SlideDownDialog(activity5);
                e22.requestWindowFeature(1);
                FrameLayout frameLayout2 = new FrameLayout(activity5);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(chatScreen5.panelColor);
                float z4 = chatScreen5.dp(22.0f);
                gradientDrawable.setCornerRadii(new float[]{z4, z4, z4, z4, 0.0f, 0.0f, 0.0f, 0.0f});
                frameLayout2.setBackground(gradientDrawable);
                frameLayout2.setClipToOutline(true);
                frameLayout2.setOutlineProvider(new TopRoundedOutlineProvider(z4, 1));
                LinearLayout k14 = chatScreen5.columnLayout();
                FrameLayout frameLayout3 = new FrameLayout(activity5);
                View view2 = new View(activity5);
                view2.setBackground(chatScreen5.roundedDrawable(chatScreen5.lightBars ? -10789278 : -3881012, 3.0f, 0, 0.0f));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(chatScreen5.dp(46.0f), chatScreen5.dp(4.0f), 1);
                layoutParams.topMargin = chatScreen5.dp(13.0f);
                frameLayout3.addView(view2, layoutParams);
                FrameLayout frameLayout4 = frameLayout2;
                k14.addView(frameLayout3, ChatScreen.layoutParamsDefault(chatScreen5, -1, chatScreen5.dp(24.0f), 0, 0, 0, 60));
                int i8 = chatScreen5.textColor;
                TextView f12 = chatScreen5.makeText("Themes", 21.0f, i8, true);
                f12.setGravity(17);
                k14.addView(f12, chatScreen5.layoutParams(-1, -2, 0, 2, 0, 12));
                ScrollView scrollView4 = new ScrollView(activity5);
                scrollView4.setVerticalScrollBarEnabled(false);
                LinearLayout k15 = chatScreen5.columnLayout();
                k15.setPadding(chatScreen5.dp(14.0f), chatScreen5.dp(4.0f), chatScreen5.dp(14.0f), chatScreen5.dp(30.0f));
                int z5 = chatScreen5.dp(10.0f);
                int i9 = 3;
                int z6 = ((activity5.getResources().getDisplayMetrics().widthPixels - chatScreen5.dp(28.0f)) - (z5 * 2)) / 3;
                List list2 = ChatThemeCatalog.themes;
                int i10 = 0;
                while (i10 < list2.size()) {
                    LinearLayout linearLayout10 = new LinearLayout(activity5);
                    linearLayout10.setOrientation(i5);
                    while (i5 < i9) {
                        int i11 = i10 + i5;
                        if (i11 < list2.size()) {
                            ChatTheme chatTheme = (ChatTheme) list2.get(i11);
                            frameLayout = frameLayout4;
                            MultiAction d2 = new MultiAction(chatScreen5, chatTheme, e22, 2);
                            int i12 = (int) (z6 * 1.66f);
                            e2 = e22;
                            LinearLayout k16 = chatScreen5.columnLayout();
                            FrameLayout frameLayout5 = new FrameLayout(activity5);
                            linearLayout2 = k14;
                            scrollView = scrollView4;
                            i2 = i10;
                            list = list2;
                            frameLayout5.addView(new ThemedBackgroundView(chatScreen5.activity, chatTheme, chatScreen5.bgColor, z6, i12), new FrameLayout.LayoutParams(z6, i12));
                            frameLayout5.setClipToOutline(true);
                            frameLayout5.setOutlineProvider(new RoundedOutlineProvider(1, chatScreen5));
                            if (i.b.a(chatTheme.id, chatScreen5.palette.id)) {
                                TextView textView = new TextView(activity5);
                                textView.setText("✓");
                                textView.setTextColor(-1);
                                textView.setTextSize(1, 13.95f);
                                textView.setGravity(17);
                                textView.setBackground(ChatScreen.circleDrawable(-15173646));
                                linearLayout3 = k15;
                                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(chatScreen5.dp(26.0f), chatScreen5.dp(26.0f), 8388693);
                                z = false;
                                layoutParams2.setMargins(0, 0, chatScreen5.dp(8.0f), chatScreen5.dp(8.0f));
                                frameLayout5.addView(textView, layoutParams2);
                            } else {
                                linearLayout3 = k15;
                                z = false;
                            }
                            k16.addView(frameLayout5, new LinearLayout.LayoutParams(z6, i12));
                            k16.addView(chatScreen5.makeText(chatTheme.displayName, 16.5f, i8, z), chatScreen5.layoutParams(-2, -2, 2, 8, 0, 18));
                            k16.setOnClickListener(new ActionClickListener(d2, 1));
                            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(z6, -2);
                            if (i5 > 0) {
                                layoutParams3.leftMargin = z5;
                            }
                            linearLayout10.addView(k16, layoutParams3);
                            i3 = 1;
                        } else {
                            scrollView = scrollView4;
                            e2 = e22;
                            frameLayout = frameLayout4;
                            linearLayout2 = k14;
                            linearLayout3 = k15;
                            i2 = i10;
                            list = list2;
                            View view3 = new View(activity5);
                            i3 = 1;
                            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(z6, 1);
                            layoutParams4.leftMargin = z5;
                            linearLayout10.addView(view3, layoutParams4);
                        }
                        i5 += i3;
                        frameLayout4 = frameLayout;
                        e22 = e2;
                        k14 = linearLayout2;
                        scrollView4 = scrollView;
                        i10 = i2;
                        list2 = list;
                        k15 = linearLayout3;
                        i9 = 3;
                    }
                    LinearLayout r30 = k15;
                    r30.addView(linearLayout10, ChatScreen.layoutParamsDefault(chatScreen5, -1, -2, 0, 0, 0, 60));
                    i10 += 3;
                    i9 = 3;
                    k15 = r30;
                    i5 = 0;
                }
                ScrollView scrollView5 = scrollView4;
                SlideDownDialog e23 = e22;
                FrameLayout frameLayout6 = frameLayout4;
                LinearLayout linearLayout11 = k14;
                scrollView5.addView(k15, new FrameLayout.LayoutParams(-1, -2));
                linearLayout11.addView(scrollView5, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                frameLayout6.addView(linearLayout11, new FrameLayout.LayoutParams(-1, -1));
                e23.setContentView(frameLayout6);
                Window window = e23.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                if (window != null) {
                    window.setGravity(80);
                }
                int i13 = activity5.getResources().getDisplayMetrics().heightPixels;
                if (window != null) {
                    window.setLayout(-1, i13 - chatScreen5.dp(38.0f));
                }
                e23.sheetView = frameLayout6;
                frameLayout6.setTranslationY(activity5.getResources().getDisplayMetrics().heightPixels);
                chatScreen5.showDialogThemed(e23);
                frameLayout6.post(new ViewAnimTask(frameLayout6, 0));
                return b.d.f770c;
            case 19:
                chatScreen.toaster.a("Coming soon");
                return b.d.f770c;
            case 20:
                chatScreen.showReactionPicker(true, new ChatGestureFunction(chatScreen, i4));
                return b.d.f770c;
            default:
                chatScreen.activity.onBackPressed();
                return b.d.f770c;
        }
    }
}
