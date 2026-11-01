package a;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class MessageAction implements h.a {

    public final int mode;

    public final ChatScreen chatScreen;

    public final ChatMessage message;

    public MessageAction(ChatScreen chatScreen, ChatMessage chatMessage, int i2) {
        this.mode = i2;
        this.chatScreen = chatScreen;
        this.message = chatMessage;
    }

    @Override
    public final Object a() {
        switch (this.mode) {
            case 0:
                ChatScreen chatScreen = this.chatScreen;
                HashSet hashSet = (HashSet) chatScreen.seenIds.a();
                ChatMessage chatMessage = this.message;
                hashSet.add(Long.valueOf(chatMessage.id));
                String L = c.b.L(c.b.P(c.b.O(c.b.Q((HashSet) chatScreen.seenIds.a()), d.b.f804c), 400), " ", null, null, null, 62);
                SharedPreferences sharedPreferences = AppState.prefs;
                if (sharedPreferences == null) {
                    i.b.g("sp");
                    throw null;
                }
                sharedPreferences.edit().putString("hidden_msgs", L).apply();
                chatScreen.messages.remove(chatMessage);
                chatScreen.refreshMessages();
                chatScreen.applyScroll(false);
                return b.d.f770c;
            case 1:
                final ChatScreen chatScreen2 = this.chatScreen;
                chatScreen2.getClass();
                final ChatMessage chatMessage2 = this.message;
                final boolean a2 = i.b.a(chatMessage2.sender, chatScreen2.username);
                chatScreen2.showBottomSheet(false, new h.c() {
                    @Override
                    public final Object a(Object obj, Object obj2) {
                        LinearLayout linearLayout = (LinearLayout) obj;
                        final ChatScreen chatScreen3 = chatScreen2;
                        TextView f1 = chatScreen3.makeText("Edit history", 21.0f, chatScreen3.textColor, true);
                        f1.setGravity(17);
                        linearLayout.addView(f1, chatScreen3.layoutParams(-1, -2, 0, 4, 0, 12));
                        linearLayout.addView(chatScreen3.dividerView());
                        ScrollView scrollView = new ScrollView(chatScreen3.activity);
                        final LinearLayout k1 = chatScreen3.columnLayout();
                        float f2 = 14;
                        k1.setPadding(chatScreen3.dp(f2), chatScreen3.dp(12), chatScreen3.dp(f2), chatScreen3.dp(10));
                        k1.addView(chatScreen3.makeText("Loading...", 16.0f, chatScreen3.subTextColor, false), ChatScreen.layoutParamsDefault(chatScreen3, -2, -2, 0, 0, 0, 60));
                        scrollView.addView(k1);
                        linearLayout.addView(scrollView, new LinearLayout.LayoutParams(-1, -2));
                        final ChatMessage chatMessage3 = chatMessage2;
                        final boolean z = a2;
                        new Thread(new Runnable() {
                            @Override
                            public final void run() {
                                ApiClient apiClient = ApiClient.INSTANCE;
                                final ChatMessage chatMessage4 = chatMessage3;
                                final ApiResponse b2 = ApiClient.requestWithDefaults(apiClient, "GET", "/chat/edits/" + chatMessage4.id, null, 12);
                                final ChatScreen chatScreen4 = chatScreen3;
                                Activity activity = chatScreen4.activity;
                                final LinearLayout linearLayout2 = k1;
                                final boolean z2 = z;
                                activity.runOnUiThread(new Runnable() {
                                    @Override
                                    public final void run() {
                                        boolean z3;
                                        String str;
                                        String optString;
                                        LinearLayout linearLayout3 = linearLayout2;
                                        linearLayout3.removeAllViews();
                                        ApiResponse apiResponse = b2;
                                        JSONObject c2 = apiResponse.json();
                                        JSONArray optJSONArray = c2 != null ? c2.optJSONArray("edits") : null;
                                        boolean b3 = apiResponse.isSuccess();
                                        boolean z4 = false;
                                        ChatScreen chatScreen5 = chatScreen4;
                                        if (!b3 || optJSONArray == null) {
                                            chatScreen5.getClass();
                                            linearLayout3.addView(chatScreen5.makeText(ChatScreen.errorText(apiResponse), 16.0f, chatScreen5.subTextColor, false), ChatScreen.layoutParamsDefault(chatScreen5, -2, -2, 0, 0, 0, 60));
                                            return;
                                        }
                                        ArrayList arrayList = new ArrayList();
                                        int length = optJSONArray.length();
                                        int i2 = 0;
                                        while (true) {
                                            String str2 = "";
                                            if (i2 >= length) {
                                                break;
                                            }
                                            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                                            if (optJSONObject != null && (optString = optJSONObject.optString("x")) != null) {
                                                str2 = optString;
                                            }
                                            arrayList.add(str2);
                                            i2++;
                                        }
                                        arrayList.add(chatMessage4.text);
                                        Iterator it = arrayList.iterator();
                                        int i3 = 0;
                                        while (it.hasNext()) {
                                            int i4 = i3 + 1;
                                            String str3 = (String) it.next();
                                            String str4 = i3 == arrayList.size() - 1 ? "Current" : i3 == 0 ? "Original" : "";
                                            int length2 = str4.length();
                                            boolean z5 = z2;
                                            if (length2 > 0) {
                                                TextView f12 = chatScreen5.makeText(str4, 13.5f, chatScreen5.subTextColor, z4);
                                                z3 = z5;
                                                str = str3;
                                                LinearLayout.LayoutParams W = chatScreen5.layoutParams(-2, -2, 4, 0, 4, 3);
                                                W.gravity = z3 ? 8388613 : 8388611;
                                                linearLayout3.addView(f12, W);
                                            } else {
                                                z3 = z5;
                                                str = str3;
                                            }
                                            TextView textView = new TextView(chatScreen5.activity);
                                            textView.setText(str);
                                            textView.setTextSize(1, 19.065f);
                                            textView.setTextColor(z3 ? -1 : chatScreen5.textColor);
                                            float f3 = 14;
                                            float f4 = 9;
                                            textView.setPadding(chatScreen5.dp(f3), chatScreen5.dp(f4), chatScreen5.dp(f3), chatScreen5.dp(f4));
                                            textView.setMaxWidth((int) (chatScreen5.activity.getResources().getDisplayMetrics().widthPixels * 0.78f));
                                            textView.setBackground(chatScreen5.roundedDrawable(z3 ? chatScreen5.sendBlue : chatScreen5.mediaPlaceholderColor, 19.0f, 0, 0.0f));
                                            LinearLayout.LayoutParams W2 = chatScreen5.layoutParams(-2, -2, 0, 0, 0, 10);
                                            W2.gravity = z3 ? 8388613 : 8388611;
                                            linearLayout3.addView(textView, W2);
                                            i3 = i4;
                                            z4 = false;
                                        }
                                    }
                                });
                            }
                        }).start();
                        return b.d.f770c;
                    }
                });
                return b.d.f770c;
            case 2:
                ChatScreen chatScreen6 = this.chatScreen;
                chatScreen6.getClass();
                ChatMessage chatMessage5 = this.message;
                chatMessage5.flag = true;
                chatMessage5.text = "";
                chatScreen6.applyScroll(false);
                new Thread(new HttpConnectionHandler(chatMessage5, chatScreen6, 2)).start();
                return b.d.f770c;
            case 3:
                ChatScreen chatScreen7 = this.chatScreen;
                chatScreen7.getClass();
                ChatMessage chatMessage6 = this.message;
                String str = (String) c.b.I(chatMessage6.media);
                if (str != null) {
                    long j2 = chatScreen7.playingMessageId;
                    long j3 = chatMessage6.id;
                    if (j2 == j3) {
                        chatScreen7.toggleVoicePlayback(j3, ChatMedia.mediaFile(str));
                    } else if (chatScreen7.previewMessageId == j3) {
                        chatScreen7.resetPlayIcon();
                    } else {
                        File c2 = ChatMedia.mediaFile(str);
                        if (c2.exists() && c2.length() > 0) {
                            chatScreen7.toggleVoicePlayback(j3, c2);
                        } else if (!chatScreen7.hasUncachedMedia(AppState.p(str), false)) {
                            chatScreen7.resetPlayIcon();
                            chatScreen7.stopPlayback();
                            chatScreen7.previewMessageId = j3;
                            ChatIconView c1 = (ChatIconView) chatScreen7.playButtons.get(Long.valueOf(j3));
                            if (c1 != null) {
                                c1.setIcon("load");
                            }
                            new Thread(new BackgroundTask(str, chatScreen7, chatMessage6, 0)).start();
                        }
                    }
                }
                return b.d.f770c;
            case 4:
                ChatMessage chatMessage7 = this.message;
                ChatScreen chatScreen8 = this.chatScreen;
                chatScreen8.showReactionPicker(false, new ReactionCallback(chatScreen8, chatMessage7, 0));
                return b.d.f770c;
            default:
                final ChatScreen chatScreen9 = this.chatScreen;
                ChatMessage chatMessage8 = this.message;
                if (!chatScreen9.isLocalMessage(chatMessage8)) {
                    final List H = c.b.H(chatMessage8.media, 1);
                    if (H.isEmpty()) {
                        chatScreen9.toaster.a("Video expired");
                    } else if (!chatScreen9.hasUncachedMedia(H, true)) {
                        Activity activity = chatScreen9.activity;
                        final Dialog dialog = new Dialog(activity, R.style.Theme.Black.NoTitleBar);
                        FrameLayout frameLayout = new FrameLayout(activity);
                        frameLayout.setBackgroundColor(-16777216);
                        final VideoView videoView = new VideoView(activity);
                        frameLayout.addView(videoView, new FrameLayout.LayoutParams(-1, -1, 17));
                        final ProgressBar progressBar = new ProgressBar(activity);
                        float f2 = 34;
                        frameLayout.addView(progressBar, new FrameLayout.LayoutParams(chatScreen9.dp(f2), chatScreen9.dp(f2), 17));
                        final TextView f1 = chatScreen9.makeText("", 15.0f, -1, false);
                        f1.setGravity(17);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
                        layoutParams.topMargin = chatScreen9.dp(48);
                        frameLayout.addView(f1, layoutParams);
                        LinearLayout P = chatScreen9.rowLayout();
                        float f3 = 8;
                        P.setPadding(chatScreen9.dp(f3), chatScreen9.dp(f3), chatScreen9.dp(f3), chatScreen9.dp(f3));
                        FrameLayout frameLayout2 = new FrameLayout(activity);
                        float f4 = 26;
                        frameLayout2.addView(new IconView(activity, "back", -1, 2.4f), new FrameLayout.LayoutParams(chatScreen9.dp(f4), chatScreen9.dp(f4), 17));
                        ChatScreen.setClickAction(frameLayout2, new DismissAction(dialog, 1));
                        float f5 = 44;
                        P.addView(frameLayout2, ChatScreen.layoutParamsDefault(chatScreen9, chatScreen9.dp(f5), chatScreen9.dp(f5), 0, 0, 0, 60));
                        P.addView(new View(activity), new LinearLayout.LayoutParams(0, 1, 1.0f));
                        FrameLayout frameLayout3 = new FrameLayout(activity);
                        frameLayout3.addView(chatScreen9.makeIcon("download", -1, 26), new FrameLayout.LayoutParams(chatScreen9.dp(f4), chatScreen9.dp(f4), 17));
                        P.addView(frameLayout3, ChatScreen.layoutParamsDefault(chatScreen9, chatScreen9.dp(f5), chatScreen9.dp(f5), 0, 0, 0, 60));
                        frameLayout.addView(P, new FrameLayout.LayoutParams(-1, -2, 48));
                        LinearLayout P2 = chatScreen9.rowLayout();
                        float f6 = 14;
                        P2.setPadding(chatScreen9.dp(f6), chatScreen9.dp(f3), chatScreen9.dp(f6), chatScreen9.dp(f6));
                        FrameLayout frameLayout4 = new FrameLayout(activity);
                        final ChatIconView M = chatScreen9.makeIcon("play", -1, 26);
                        frameLayout4.addView(M, new FrameLayout.LayoutParams(chatScreen9.dp(f4), chatScreen9.dp(f4), 17));
                        float f7 = 40;
                        P2.addView(frameLayout4, ChatScreen.layoutParamsDefault(chatScreen9, chatScreen9.dp(f7), chatScreen9.dp(f7), 0, 0, 0, 60));
                        final TextView f12 = chatScreen9.makeText("0:00", 17.0f, -1, false);
                        P2.addView(f12, chatScreen9.layoutParams(-2, -2, 6, 0, 8, 0));
                        final SeekBar seekBar = new SeekBar(activity);
                        seekBar.setMax(1000);
                        seekBar.setProgressTintList(ColorStateList.valueOf(-1));
                        seekBar.setThumbTintList(ColorStateList.valueOf(-1));
                        seekBar.setProgressBackgroundTintList(ColorStateList.valueOf(1728053247));
                        P2.addView(seekBar, new LinearLayout.LayoutParams(0, -2, 1.0f));
                        final TextView f13 = chatScreen9.makeText(ChatScreen.formatDuration(chatMessage8.duration), 17.0f, -1, false);
                        P2.addView(f13, chatScreen9.layoutParams(-2, -2, 8, 0, 10, 0));
                        FrameLayout frameLayout5 = new FrameLayout(activity);
                        ChatIconView M2 = chatScreen9.makeIcon("volume", -1, 26);
                        frameLayout5.addView(M2, new FrameLayout.LayoutParams(chatScreen9.dp(f4), chatScreen9.dp(f4), 17));
                        float f8 = 36;
                        P2.addView(frameLayout5, ChatScreen.layoutParamsDefault(chatScreen9, chatScreen9.dp(f8), chatScreen9.dp(f8), 0, 0, 0, 60));
                        frameLayout.addView(P2, new FrameLayout.LayoutParams(-1, -2, 80));
                        TextView f14 = chatScreen9.makeText("", 17.0f, -1, false);
                        float f9 = 16;
                        f14.setPadding(chatScreen9.dp(f9), chatScreen9.dp(f3), chatScreen9.dp(f9), chatScreen9.dp(f3));
                        f14.setBackground(chatScreen9.roundedDrawable(-869651924, 20.0f, 0, 0.0f));
                        f14.setVisibility(8);
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 81);
                        layoutParams2.bottomMargin = chatScreen9.dp(84);
                        frameLayout.addView(f14, layoutParams2);
                        final HideTextRunnable hideTextRunnable = new HideTextRunnable(f14, 1);
                        final i.d dVar = new i.d();
                        final i.e eVar = new i.e();
                        i.d dVar2 = new i.d();
                        final i.g gVar = new i.g();
                        final i.g gVar2 = new i.g();
                        final i.d dVar3 = new i.d();
                        final VideoProgressRunnable videoProgressRunnable = new VideoProgressRunnable(dVar, dVar2, eVar, videoView, f12, chatScreen9, seekBar);
                        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public final void onDismiss(DialogInterface dialogInterface) {
                                VideoView videoView2 = videoView;
                                ChatScreen chatScreen10 = chatScreen9;
                                chatScreen10.handler.removeCallbacks(videoProgressRunnable);
                                chatScreen10.handler.removeCallbacks(hideTextRunnable);
                                try {
                                    videoView2.stopPlayback();
                                } catch (Exception unused) {
                                }
                            }
                        });
                        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public final void onPrepared(MediaPlayer mediaPlayer) {
                                gVar.f850b = mediaPlayer;
                                dVar.f846a = true;
                                VideoView videoView2 = videoView;
                                int duration = videoView2.getDuration();
                                eVar.f847a = duration;
                                chatScreen9.getClass();
                                f13.setText(ChatScreen.formatDuration(duration));
                                progressBar.setVisibility(8);
                                f1.setVisibility(8);
                                if (dVar3.f846a) {
                                    mediaPlayer.setVolume(0.0f, 0.0f);
                                }
                                videoView2.start();
                                M.setIcon("pause");
                            }
                        });
                        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public final void onCompletion(MediaPlayer mediaPlayer) {
                                M.setIcon("play");
                                seekBar.setProgress(1000);
                                int i2 = eVar.f847a;
                                chatScreen9.getClass();
                                f12.setText(ChatScreen.formatDuration(i2));
                            }
                        });
                        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                            @Override
                            public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                                progressBar.setVisibility(8);
                                chatScreen9.toaster.a("Can't play this video");
                                return true;
                            }
                        });
                        ChatScreen.setClickAction(frameLayout4, new MultiAction(dVar, videoView, M, 0));
                        seekBar.setOnSeekBarChangeListener(new VideoSeekBarListener(eVar, f12, chatScreen9, dVar2, dVar, videoView));
                        ChatScreen.setClickAction(frameLayout5, new MultiAction(dVar3, M2, gVar2));
                        ChatScreen.setClickAction(frameLayout3, new ActionCallback(gVar, f14, chatScreen9, hideTextRunnable));
                        dialog.setContentView(frameLayout);
                        chatScreen9.showDialogThemed(dialog);
                        chatScreen9.handler.post(videoProgressRunnable);
                        new Thread(new Runnable() {
                            @Override
                            public final void run() {
                                File file;
                                final TextView textView = f1;
                                File file2 = ChatMedia.cacheDir;
                                List list = H;
                                boolean isEmpty = list.isEmpty();
                                ChatScreen chatScreen10 = chatScreen9;
                                File file3 = null;
                                if (!isEmpty) {
                                    int i2 = 0;
                                    File g2 = ChatMedia.videoFile((String) list.get(0));
                                    if (g2.exists() && g2.length() > 0) {
                                        file = g2;
                                        chatScreen10.activity.runOnUiThread(new MediaOpenRunnable(dialog, file, chatScreen10, gVar, videoView, 0));
                                    }
                                    File file4 = new File(ChatMedia.cacheDir(), "v_" + list.get(0) + ".tmp");
                                    try {
                                        try {
                                            FileOutputStream fileOutputStream = new FileOutputStream(file4);
                                            try {
                                                Iterator it = list.iterator();
                                                while (it.hasNext()) {
                                                    i2++;
                                                    File b2 = ChatMedia.fetchMediaFile((String) it.next());
                                                    if (b2 == null) {
                                                        throw new IOException("expired");
                                                    }
                                                    FileInputStream fileInputStream = new FileInputStream(b2);
                                                    try {
                                                        AppState.e(fileInputStream, fileOutputStream, 65536);
                                                        AppState.a(fileInputStream, null);
                                                        final int size = list.size();
                                                        if (size > 1) {
                                                            final int i3 = i2;
                                                            chatScreen10.activity.runOnUiThread(new Runnable() {
                                                                @Override
                                                                public final void run() {
                                                                    textView.setText(i3 + "/" + size);
                                                                }
                                                            });
                                                        }
                                                    } finally {
                                                    }
                                                }
                                                AppState.a(fileOutputStream, null);
                                                if (!file4.renameTo(g2)) {
                                                    throw new IOException("rename");
                                                }
                                                Iterator it2 = list.iterator();
                                                while (it2.hasNext()) {
                                                    ChatMedia.mediaFile((String) it2.next()).delete();
                                                }
                                                file3 = g2;
                                            } finally {
                                            }
                                        } catch (Exception unused) {
                                        }
                                    } catch (Exception unused2) {
                                        file4.delete();
                                    }
                                }
                                file = file3;
                                chatScreen10.activity.runOnUiThread(new MediaOpenRunnable(dialog, file, chatScreen10, gVar, videoView, 0));
                            }
                        }).start();
                    }
                }
                return b.d.f770c;
        }
    }
}
