package a;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.media.AudioManager;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.nix.host.MainActivity;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;



public final class ChatScreen {
    public FrameLayout shell;
    public LinearLayout inputPill;
    public long nameChangedAt;
    public LinearLayout headerBar;
    public FrameLayout endButton;
    public final long nameChangeCooldownMs;
    public Dialog sourceDialog;
    public C1 endGlyph;
    public final String groupId;
    public final ArrayList messages;
    public TextView endEmojiText;
    public long lastQuickReactionAt;
    public final HashMap reactions;
    public ArrayList emojiCatalogCache;
    public List members;
    public final X0 pollRunnable;
    public boolean active;
    public List typingUsers;
    public boolean seenSyncStarted;
    public long lastSyncAt;
    public boolean hasMore;
    public boolean syncing;
    public boolean loadingOlder;
    public final b.c seenIds;
    public boolean reservedFlag;
    public final HashMap reactionTimestamps;
    public boolean cacheLoaded;
    public final long localIdBase;
    public String emptyStateText;
    public long localIdCounter;
    public int connectionState;
    public boolean outboxLoaded;
    public long connectingSince;
    public final ArrayList outbox;
    public LinearLayout netBar;
    public final ExecutorService sendExecutor;
    public FrameLayout netIcon;
    public boolean outboxFlushing;
    public TextView netText;
    public final HashSet pendingLocalIds;
    public C0002a1 networkCallback;
    public boolean galleryPending;
    public ChatMessage replyTarget;
    public Uri cameraUri;
    public long replyTargetId;
    public String recordState;
    public boolean stickToBottom;
    public MediaRecorder mediaRecorder;
    public I2 messageList;
    public File recordFile;
    public TextView emptyText;
    public long recordStartedAt;
    public ProgressBar loadingSpinner;
    public int recordDurationMs;
    public TextView subtitleText;
    public int recordBaseDurationMs;

    
    public final Activity activity;
    public TextView statusText;
    public File recordTempFile;

    
    public final String username;
    public LinearLayout replyBar;
    public final ArrayList waveformSamples;

    
    public final h.b toaster;
    public View replyTopLine;
    public P2 recordWaveView;

    
    public final h.a onSessionExpired;
    public TextView replyWhoText;
    public TextView recordTimeText;

    
    public final Handler handler = new Handler(Looper.getMainLooper());
    public TextView replyText;
    public boolean micPermPending;

    
    public final boolean lightBars;
    public FrameLayout inputHolder;
    public final X0 recordTickRunnable;

    
    public final int sendBlue;
    public LinearLayout emojiPanel;
    public MediaPlayer audioPlayer;

    
    public final int barDark;
    public EditText messageInput;
    public long playingMessageId;

    
    public final int bgColor;
    public LinearLayout idleInputView;
    public final HashMap waveViews;

    
    public final int mediaPlaceholderColor;
    public O0 messageAdapter;
    public final HashMap playButtons;

    
    public final int faceBaseColor;
    public final float waveScale;
    public final X0 playbackTickRunnable;

    
    public final int textColor;
    public final HashMap memberPics;
    public float playbackSpeed;

    
    public final int subTextColor;
    public final HashMap lastSeen;
    public long previewMessageId;

    
    public final int dividerColor;
    public final HashMap seenByMessage;
    public final HashMap speedLabels;

    
    public final int bubbleAltColor;
    public long lastSeenSyncAt;
    public final ExecutorService prefetchExecutor;
    public final int altTextColor;
    public final HashSet prefetchCheckedIds;
    public final HashSet prefetchingIds;
    public final List quickReactions;
    public long typingStartedAt;
    public float swipeOffset;

    
    public final int panelColor;
    public long lastTypingAt;
    public float swipeOffset2;

    
    public final int chipColor;
    public long myLastMessageId;
    public int recordQuality;

    
    public final int inputBarColor;
    public final HashMap displayNames;
    public boolean swipeArmed;

    
    public final int dangerColor;
    public String groupName;
    public J2 activeSwipe;

    
    public final int replyPreviewColor;
    public String groupPic;
    public ChatMessage highlightedMessage;
    public C0022f1 palette;
    public AvatarView groupPicView;
    public long lastLocalSentId;
    public long lastThemeSyncAt;
    public TextView titleText;
    public long sentSoundElapsed;
    public int topInset;
    public FrameLayout imageButton;
    public C0029h0 quickReactionRefresher;
    public ActivityRef activityRef;
    public FrameLayout micButton;
    public boolean avatarPickPending;

    public ChatScreen(Activity activity, String str, ToastCallback toastCallback, ActivityAction k1) {
        int i2 = 1;
        this.activity = activity;
        this.username = str;
        this.toaster = toastCallback;
        this.onSessionExpired = k1;
        boolean z = AppState.darkTheme;
        this.lightBars = z;
        this.sendBlue = -16226561;
        this.barDark = z ? -13793025 : -15173646;
        this.bgColor = z ? -14276823 : -1;
        this.mediaPlaceholderColor = z ? -13421773 : -986379;
        this.faceBaseColor = z ? -12895170 : -986379;
        this.textColor = z ? -920842 : -16448251;
        this.subTextColor = z ? -5196872 : -10131605;
        this.dividerColor = z ? -12697534 : -1775893;
        this.bubbleAltColor = z ? -13289674 : -3420978;
        this.reactions = z ? -10131092 : -2960427;
        this.quickReactions = c.c.C("❤️", "😆", "😮", "😢", "😠", "👍");
        this.panelColor = z ? -14408410 : -1;
        this.chipColor = z ? -12960964 : -1775893;
        this.inputBarColor = z ? -11559440 : -15173646;
        this.dangerColor = -45715;
        this.replyPreviewColor = z ? -12895170 : -1775893;
        List list = AbstractC0026g1.f511a;
        SharedPreferences sharedPreferences = AppState.prefs;
        if (sharedPreferences == null) {
            i.b.g("sp");
            throw null;
        }
        String string = sharedPreferences.getString("chat_theme", "");
        this.palette = AbstractC0026g1.a(string == null ? "" : string);
        this.messages = new ArrayList();
        this.reactions = new HashMap();
        c.j jVar = c.j.f773a;
        this.members = jVar;
        this.hasMore = true;
        this.emptyStateText = "";
        this.stickToBottom = true;
        this.waveScale = 250.0f;
        this.memberPics = new HashMap();
        this.lastSeen = new HashMap();
        this.seenByMessage = new HashMap();
        this.prefetchCheckedIds = new HashSet();
        this.displayNames = new HashMap();
        this.groupName = "";
        this.groupPic = "";
        this.pollRunnable = new X0(this, 1);
        this.typingUsers = jVar;
        this.seenIds = new b.c(new C0(i2));
        this.reactionTimestamps = new HashMap();
        this.localIdBase = 4611686018427387903L;
        this.outbox = new ArrayList();
        this.sendExecutor = Executors.newSingleThreadExecutor();
        this.pendingLocalIds = new HashSet();
        this.recordState = "idle";
        this.waveformSamples = new ArrayList();
        this.recordTickRunnable = new X0(this, 2);
        this.playingMessageId = Long.MIN_VALUE;
        this.waveViews = new HashMap();
        this.playButtons = new HashMap();
        this.playbackTickRunnable = new X0(this, 0);
        this.playbackSpeed = 1.0f;
        this.previewMessageId = Long.MIN_VALUE;
        this.speedLabels = new HashMap();
        this.prefetchExecutor = Executors.newSingleThreadExecutor();
        this.prefetchingIds = new HashSet();
        this.lastLocalSentId = Long.MIN_VALUE;
        this.nameChangeCooldownMs = 604800000L;
        this.groupId = "aryan";
    }

    public static final boolean hasEditedText(EditText editText, String str) {
        String obj = m.e.h0(editText.getText().toString()).toString();
        return obj.length() > 0 && !obj.equals(m.e.h0(str).toString());
    }

    public static ArrayList waveformPeaks(List list) {
        if (list.isEmpty()) {
            ArrayList arrayList = new ArrayList(48);
            for (int i2 = 0; i2 < 48; i2++) {
                arrayList.add(5);
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        while (i3 < 48) {
            int size = (list.size() * i3) / 48;
            i3++;
            int min = Math.min(Math.max(size + 1, (list.size() * i3) / 48), list.size());
            int i4 = 0;
            while (size < min) {
                i4 = Math.max(i4, ((Number) list.get(size)).intValue());
                size++;
            }
            arrayList2.add(Integer.valueOf(i4));
        }
        return arrayList2;
    }

    public static final void updateEditSaveButton(FrameLayout frameLayout, ChatScreen chatScreen, C1 c1, EditText editText, String str) {
        if (hasEditedText(editText, str)) {
            chatScreen.getClass();
            frameLayout.setBackground(circleDrawable(-13793025));
            c1.f53b = chatScreen.lightBars ? -14934495 : -1;
            c1.invalidate();
            return;
        }
        chatScreen.getClass();
        frameLayout.setBackground(circleDrawable(-3091496));
        c1.f53b = -11907758;
        c1.invalidate();
    }

    public static boolean isSingleEmoji(String str) {
        String obj = m.e.h0(str).toString();
        if (obj.length() == 0 || obj.length() > 12) {
            return false;
        }
        int i2 = 0;
        while (i2 < obj.length()) {
            int codePointAt = obj.codePointAt(i2);
            if (codePointAt != 8205 && codePointAt != 65039 && codePointAt < 8592) {
                return false;
            }
            i2 += Character.charCount(codePointAt);
        }
        return true;
    }

    public static String errorText(ApiResponse c0000a) {
        return c0000a.code == 0 ? "No internet" : c0000a.errorMessage();
    }

    public static String formatDuration(int i2) {
        int i3 = (i2 + 500) / 1000;
        return (i3 / 60) + ":" + m.e.U(String.valueOf(i3 % 60));
    }

    public static boolean canReact(ChatMessage k0) {
        String str = k0.type;
        if (i.b.a(str, "sys")) {
            return false;
        }
        if (k0.deleted) {
            return true;
        }
        if (i.b.a(str, "like")) {
            return false;
        }
        return (i.b.a(str, "text") && isSingleEmoji(k0.text)) ? false : true;
    }

    public static final void bindReactionList(LinearLayout linearLayout, List list, i.g gVar, ChatScreen chatScreen, LinearLayout linearLayout2, LinkedHashMap linkedHashMap, Dialog dialog, ChatMessage k0, int i2) {
        linearLayout.removeAllViews();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b.b bVar = (b.b) it.next();
            if (((CharSequence) gVar.f850b).length() <= 0 || i.b.a(bVar.f765b, gVar.f850b)) {
                LinearLayout P = chatScreen.rowLayout();
                float f2 = 9;
                P.setPadding(chatScreen.dp(16), chatScreen.dp(f2), chatScreen.dp(20), chatScreen.dp(f2));
                P.addView(chatScreen.avatarView((String) bVar.f764a, 50.0f), layoutParamsDefault(chatScreen, chatScreen.dp(50.0f), chatScreen.dp(50.0f), 0, 0, 14, 32));
                LinearLayout k1 = chatScreen.columnLayout();
                Object obj = bVar.f764a;
                String x = chatScreen.displayName((String) obj);
                int i3 = chatScreen.textColor;
                k1.addView(chatScreen.makeText(x, 20.0f, i3, true));
                String str = chatScreen.username;
                if (i.b.a(obj, str)) {
                    k1.addView(chatScreen.makeText("Tap to remove", 16.0f, chatScreen.subTextColor, false));
                }
                P.addView(k1, new LinearLayout.LayoutParams(0, -2, 1.0f));
                P.addView(chatScreen.makeText((String) bVar.f765b, 30.0f, i3, false));
                if (i.b.a(obj, str)) {
                    P.setOnClickListener(new H(dialog, chatScreen, k0, 0));
                }
                linearLayout.addView(P, layoutParamsDefault(chatScreen, -1, -2, 0, 0, 0, 60));
            }
        }
        linearLayout2.removeAllViews();
        addReactionTab(chatScreen, gVar, i2, linearLayout2, linearLayout, list, linkedHashMap, dialog, k0, "All", list.size(), "");
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            addReactionTab(chatScreen, gVar, i2, linearLayout2, linearLayout, list, linkedHashMap, dialog, k0, str2, ((Number) entry.getValue()).intValue(), str2);
        }
    }

    public static final void addReactionTab(final ChatScreen chatScreen, final i.g gVar, final int i2, final LinearLayout linearLayout, final LinearLayout linearLayout2, final List list, final LinkedHashMap linkedHashMap, final Dialog dialog, final ChatMessage k0, String str, int i3, final String str2) {
        LinearLayout P = chatScreen.rowLayout();
        float f2 = 18;
        float f3 = 7;
        P.setPadding(chatScreen.dp(f2), chatScreen.dp(f3), chatScreen.dp(f2), chatScreen.dp(f3));
        if (i.b.a(gVar.f850b, str2)) {
            P.setBackground(chatScreen.roundedDrawable(i2, 30.0f, 0, 0.0f));
        }
        boolean a2 = i.b.a(gVar.f850b, str2);
        int i4 = chatScreen.textColor;
        int i5 = a2 ? i4 : chatScreen.subTextColor;
        if (str2.length() == 0) {
            P.addView(chatScreen.makeText(str, 20.0f, i5, true));
        } else {
            P.addView(chatScreen.makeText(str, 26.0f, i4, false));
            P.addView(chatScreen.makeText(String.valueOf(i3), 20.0f, i5, false), chatScreen.layoutParams(-2, -2, 6, 0, 0, 0));
        }
        P.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public final void onClick(View view) {
                i.g gVar2 = i.g.this;
                gVar2.f850b = str2;
                ChatScreen.bindReactionList(linearLayout2, list, gVar2, chatScreen, linearLayout, linkedHashMap, dialog, k0, i2);
            }
        });
        linearLayout.addView(P, layoutParamsDefault(chatScreen, -2, -2, 0, 0, 8, 32));
    }

    public static String formatSpeed(float f2) {
        return f2 >= 2.0f ? "2x" : f2 >= 1.5f ? "1.5x" : "1x";
    }

    public static  LinearLayout.LayoutParams layoutParamsDefault(ChatScreen chatScreen, int i2, int i3, int i4, int i5, int i6, int i7) {
        return chatScreen.layoutParams(i2, i3, (i7 & 4) != 0 ? 0 : i4, (i7 & 8) != 0 ? 0 : i5, (i7 & 16) != 0 ? 0 : i6, 0);
    }

    public static void saveQuickReaction(String str) {
        if (str.length() == 0) {
            SharedPreferences sharedPreferences = AppState.prefs;
            if (sharedPreferences != null) {
                sharedPreferences.edit().remove("qr_all").apply();
                return;
            } else {
                i.b.g("sp");
                throw null;
            }
        }
        SharedPreferences sharedPreferences2 = AppState.prefs;
        if (sharedPreferences2 != null) {
            sharedPreferences2.edit().putString("qr_all", str).apply();
        } else {
            i.b.g("sp");
            throw null;
        }
    }

    public static String newLocalId() {
        return "L".concat(m.e.g0(14, m.m.J(UUID.randomUUID().toString(), "-", "")));
    }

    public static final void addAlignedText(LinearLayout linearLayout, ChatScreen chatScreen, TextView textView, boolean z, int i2) {
        chatScreen.getClass();
        LinearLayout.LayoutParams W = chatScreen.layoutParams(-2, -2, 0, i2, 0, 0);
        W.gravity = z ? 8388613 : 8388611;
        linearLayout.addView(textView, W);
    }

    public static final void buildGroupInfo(ChatScreen chatScreen, LinearLayout linearLayout) {
        int i2 = 0;
        linearLayout.removeAllViews();
        AvatarView a2 = new AvatarView(chatScreen.activity);
        if (chatScreen.groupPic.length() > 0) {
            File file = ChatMedia.cacheDir;
            ChatMedia.loadAvatar(a2, chatScreen.groupPic);
        }
        float f2 = 106;
        LinearLayout.LayoutParams W = chatScreen.layoutParams(chatScreen.dp(f2), chatScreen.dp(f2), 0, 2, 0, 0);
        W.gravity = 1;
        linearLayout.addView(a2, W);
        String str = chatScreen.groupName.length() == 0 ? "NixHost Group" : chatScreen.groupName;
        int i3 = chatScreen.textColor;
        TextView f1 = chatScreen.makeText(str, 29.0f, i3, true);
        f1.setGravity(17);
        float f3 = 20;
        f1.setPadding(chatScreen.dp(f3), 0, chatScreen.dp(f3), 0);
        linearLayout.addView(f1, chatScreen.layoutParams(-1, -2, 0, 12, 0, 0));
        boolean R = chatScreen.isMuted();
        int i4 = chatScreen.chipColor;
        int i5 = R ? chatScreen.lightBars ? -14272175 : -1575937 : i4;
        LinearLayout k1 = chatScreen.columnLayout();
        k1.setGravity(1);
        Activity activity = chatScreen.activity;
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setBackground(circleDrawable(i5));
        String str2 = R ? "bellmute" : "bell";
        int i6 = chatScreen.sendBlue;
        C1 M = chatScreen.makeIcon(str2, R ? i6 : i3, 26);
        M.setCut(i5);
        float f4 = 26;
        frameLayout.addView(M, new FrameLayout.LayoutParams(chatScreen.dp(f4), chatScreen.dp(f4), 17));
        float f5 = 53;
        k1.addView(frameLayout, new LinearLayout.LayoutParams(chatScreen.dp(f5), chatScreen.dp(f5)));
        String str3 = R ? "Unmute" : "Mute";
        if (!R) {
            i6 = i3;
        }
        k1.addView(chatScreen.makeText(str3, 16.0f, i6, true), chatScreen.layoutParams(-2, -2, 0, 6, 0, 0));
        k1.setOnClickListener(new ViewOnClickListenerC0072s0(chatScreen, linearLayout, i2));
        LinearLayout.LayoutParams W2 = chatScreen.layoutParams(-2, -2, 0, 28, 0, 0);
        W2.gravity = 1;
        linearLayout.addView(k1, W2);
        linearLayout.addView(chatScreen.sectionHeader(24, "Users"));
        String str4 = chatScreen.username;
        linearLayout.addView(chatScreen.settingsRow(chatScreen.avatarView(str4, 38), "Profile photo", null, new C0036j(chatScreen, 14)));
        long Z = chatScreen.savedNameChangedAt();
        long currentTimeMillis = (chatScreen.nameChangeCooldownMs + Z) - System.currentTimeMillis();
        linearLayout.addView(chatScreen.settingsRow(chatScreen.iconBadge(i3, "editf"), chatScreen.displayName(str4), (Z <= 0 || currentTimeMillis <= 0) ? "Change name" : J0.a("You can change it again in ", formatDaysLeft(currentTimeMillis)), new C0036j(chatScreen, 15)));
        linearLayout.addView(chatScreen.sectionHeader(12, "Actions"));
        linearLayout.addView(chatScreen.settingsRow(chatScreen.iconBadge(i3, "people"), "See members", null, new C0036j(chatScreen, 16)));
        if (m.m.F(str4, chatScreen.groupId)) {
            linearLayout.addView(chatScreen.settingsRow(chatScreen.iconBadge(chatScreen.dangerColor, "trashf"), "Clear group data", null, new C0036j(chatScreen, 17)));
        }
        linearLayout.addView(chatScreen.sectionHeader(12, "Customization"));
        linearLayout.addView(chatScreen.settingsRow(chatScreen.iconBadge(i3, "themes"), "Themes", chatScreen.palette.f482b, new C0036j(chatScreen, 18)));
        FrameLayout frameLayout2 = new FrameLayout(activity);
        frameLayout2.setBackground(circleDrawable(i4));
        String p0 = quickReaction();
        if (p0.length() == 0) {
            float f6 = 22;
            frameLayout2.addView(chatScreen.makeIcon("like", chatScreen.barDark, 22), new FrameLayout.LayoutParams(chatScreen.dp(f6), chatScreen.dp(f6), 17));
        } else {
            TextView textView = new TextView(activity);
            textView.setText(p0);
            textView.setTextSize(1, 19.53f);
            textView.setGravity(17);
            frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1, 17));
        }
        linearLayout.addView(chatScreen.settingsRow(frameLayout2, "Quick reaction", null, new C0029h0(chatScreen, linearLayout)));
        linearLayout.addView(chatScreen.sectionHeader(12, "Privacy & support"));
        linearLayout.addView(chatScreen.settingsRow(chatScreen.iconBadge(i3, "gear"), "Coming soon", null, new C0036j(chatScreen, 19)));
        linearLayout.addView(new View(activity), layoutParamsDefault(chatScreen, -1, chatScreen.dp(36), 0, 0, 0, 60));
    }

    public static final void showTransientText(RunnableC0064q runnableC0064q, ChatScreen chatScreen, TextView textView, String str) {
        textView.setText(str);
        textView.setVisibility(0);
        chatScreen.handler.removeCallbacks(runnableC0064q);
        chatScreen.handler.postDelayed(runnableC0064q, 2400L);
    }

    public static GradientDrawable circleDrawable(int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i2);
        return gradientDrawable;
    }

    public static b.b uploadMedia(String str, byte[] bArr) {
        ApiResponse c0000a;
        String str2;
        String str3 = "";
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                break;
            }
            if (ApiClient.baseUrl.length() == 0) {
                c0000a = new ApiResponse(0, "");
            } else {
                try {
                    URLConnection openConnection = new URL(ApiClient.baseUrl + "/chat/media?kind=" + str).openConnection();
                    i.b.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                    HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.setReadTimeout(60000);
                    httpURLConnection.setRequestProperty("User-Agent", "NixHost");
                    SharedPreferences sharedPreferences = AppState.prefs;
                    if (sharedPreferences == null) {
                        i.b.g("sp");
                        throw null;
                    }
                    String string = sharedPreferences.getString("session", "");
                    if (string == null) {
                        string = "";
                    }
                    httpURLConnection.setRequestProperty("Authorization", "Bearer " + string);
                    httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                    httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                    httpURLConnection.setDoOutput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    try {
                        outputStream.write(bArr);
                        AppState.a(outputStream, null);
                        int responseCode = httpURLConnection.getResponseCode();
                        InputStream errorStream = (200 > responseCode || responseCode >= 300) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
                        c0000a = new ApiResponse(responseCode, errorStream != null ? AppState.v(new BufferedReader(new InputStreamReader(errorStream, m.a.f864a), 8192)) : "");
                    } finally {
                    }
                } catch (Exception unused) {
                    c0000a = new ApiResponse(0, "");
                }
            }
            JSONObject c2 = c0000a.json();
            if (c2 == null || (str2 = c2.optString("id")) == null) {
                str2 = "";
            }
            if (c0000a.isSuccess() && str2.length() > 0) {
                return new b.b(str2, "");
            }
            String E = errorText(c0000a);
            int i3 = c0000a.code;
            if (i3 != 0 && i3 < 500) {
                str3 = E;
                break;
            }
            try {
                Thread.sleep(800L);
            } catch (Exception unused2) {
            }
            i2++;
            str3 = E;
        }
        return new b.b("", str3);
    }

    public static ChatMessage messageFromJson(JSONObject jSONObject) {
        JSONArray optJSONArray;
        String optString;
        String optString2;
        String optString3;
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("m");
        if (optJSONArray2 != null) {
            int length = optJSONArray2.length();
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(optJSONArray2.optString(i2));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("w");
        if (optJSONArray3 != null) {
            int length2 = optJSONArray3.length();
            for (int i3 = 0; i3 < length2; i3++) {
                arrayList2.add(Integer.valueOf(optJSONArray3.optInt(i3)));
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("rp");
        ChatMessage k0 = new ChatMessage(jSONObject.optLong("id"), jSONObject.optString("u"), jSONObject.optString("t"), jSONObject.optString("x"), arrayList, arrayList2, jSONObject.optInt("d"), jSONObject.optLong("re"), jSONObject.optLong("ts"), jSONObject.optInt("del") == 1, (optJSONObject == null || (optString3 = optJSONObject.optString("u")) == null) ? "" : optString3, (optJSONObject == null || (optString2 = optJSONObject.optString("t")) == null) ? "" : optString2, (optJSONObject == null || (optString = optJSONObject.optString("x")) == null) ? "" : optString, (optJSONObject != null ? optJSONObject.optInt("del") : 0) == 1, jSONObject.optInt("ed"));
        ArrayList arrayList3 = new ArrayList();
        if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("m")) != null) {
            int length3 = optJSONArray.length();
            for (int i4 = 0; i4 < length3; i4++) {
                arrayList3.add(optJSONArray.optString(i4));
            }
        }
        k0.reactions = arrayList3;
        return k0;
    }

    public static void sendTextMessage(ChatScreen chatScreen, String str, String str2, PairAction pairAction, int i2) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13 = (i2 & 2) != 0 ? "" : str2;
        c.j jVar = c.j.f773a;
        PairAction pairAction2 = (i2 & 32) != 0 ? null : pairAction;
        chatScreen.getClass();
        JSONObject put = new JSONObject().put("type", str).put("text", str13).put("media", new JSONArray((Collection) jVar)).put("wave", new JSONArray((Collection) jVar)).put("dur", 0);
        ChatMessage k0 = chatScreen.replyTarget;
        if (k0 != null) {
            str3 = "type";
            put.put("reply", k0.id);
        } else {
            str3 = "type";
        }
        chatScreen.setReplyTarget(null);
        int i3 = chatScreen.connectionState;
        ArrayList arrayList = chatScreen.messages;
        ArrayList arrayList2 = chatScreen.outbox;
        long j2 = chatScreen.localIdBase;
        if (i3 != 1 && !(!arrayList2.isEmpty())) {
            long j3 = chatScreen.localIdCounter + 1;
            chatScreen.localIdCounter = j3;
            long j4 = j2 + j3;
            arrayList.add(new ChatMessage(j4, chatScreen.username, str, str13, new ArrayList(), new ArrayList(jVar), 0, k0 != null ? k0.id : 0L, System.currentTimeMillis(), (k0 == null || (str12 = k0.sender) == null) ? "" : str12, (k0 == null || (str11 = k0.type) == null) ? "" : str11, (k0 == null || (str10 = k0.text) == null) ? "" : str10, k0 != null ? k0.deleted : false));
            chatScreen.markLocalSent(j4);
            chatScreen.refreshMessages();
            chatScreen.applyScroll(true);
            chatScreen.sendExecutor.execute(new RunnableC0040k(put, chatScreen, j4, k0, pairAction2));
            return;
        }
        long j5 = chatScreen.localIdCounter + 1;
        chatScreen.localIdCounter = j5;
        long j6 = j5 + j2;
        ArrayList arrayList3 = new ArrayList();
        JSONArray optJSONArray = put.optJSONArray("media");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                arrayList3.add(optJSONArray.optString(i4));
            }
        }
        ArrayList arrayList4 = new ArrayList();
        JSONArray optJSONArray2 = put.optJSONArray("wave");
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i5 = 0; i5 < length2; i5++) {
                arrayList4.add(Integer.valueOf(optJSONArray2.optInt(i5)));
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        arrayList.add(new ChatMessage(j6, chatScreen.username, put.optString(str3), put.optString("text"), arrayList3, arrayList4, put.optInt("dur"), k0 != null ? k0.id : 0L, currentTimeMillis, (k0 == null || (str9 = k0.sender) == null) ? "" : str9, (k0 == null || (str8 = k0.type) == null) ? "" : str8, (k0 == null || (str7 = k0.text) == null) ? "" : str7, k0 != null ? k0.deleted : false));
        chatScreen.markLocalSent(j6);
        arrayList2.add(new OutboxEntry(j6, put, currentTimeMillis, (k0 == null || (str6 = k0.sender) == null) ? "" : str6, (k0 == null || (str5 = k0.type) == null) ? "" : str5, (k0 == null || (str4 = k0.text) == null) ? "" : str4, k0 != null ? k0.deleted : false));
        chatScreen.saveOutbox();
        chatScreen.refreshMessages();
        chatScreen.applyScroll(true);
    }

    public static void setClickAction(View view, h.a aVar) {
        view.setOnClickListener(new ActionClickListener(aVar, 3));
    }

    public static String quickReaction() {
        SharedPreferences sharedPreferences = AppState.prefs;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("qr_all", "");
            return string == null ? "" : string;
        }
        i.b.g("sp");
        throw null;
    }

    public static String replyPreviewText(String str, String str2, boolean z) {
        return z ? "Message deleted" : i.b.a(str, "voice") ? "Audio 📎" : i.b.a(str, "image") ? "Attachment 📎" : i.b.a(str, "video") ? "Video 📎" : i.b.a(str, "like") ? "👍" : str2;
    }

    public static final void addEmojiSection(ArrayList arrayList, String str, List list) {
        if (list.isEmpty()) {
            return;
        }
        arrayList.add(str);
        int i2 = 0;
        while (i2 < list.size()) {
            int i3 = i2 + 5;
            arrayList.add(c.b.Q(list.subList(i2, Math.min(i3, list.size()))));
            i2 = i3;
        }
    }

    public static String formatDaysLeft(long j2) {
        int i2 = (int) ((j2 + 86399999) / 86400000);
        if (i2 < 1) {
            i2 = 1;
        }
        if (i2 == 1) {
            return "1 day";
        }
        return i2 + " days";
    }

    
    
    
    public final void saveCache() {
        boolean z;
        SharedPreferences sharedPreferences;
        try {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.messages.iterator();
            while (it.hasNext()) {
                ChatMessage k0 = (ChatMessage) it.next();
                if (!isLocalMessage(k0)) {
                    arrayList.add(k0);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            List subList = arrayList.size() > 60 ? arrayList.subList(arrayList.size() - 60, arrayList.size()) : arrayList;
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            Iterator it2 = subList.iterator();
            while (it2.hasNext()) {
                ChatMessage k02 = (ChatMessage) it2.next();
                JSONObject jSONObject2 = new JSONObject();
                long j2 = k02.id;
                JSONArray jSONArray2 = jSONArray;
                long j3 = k02.replyTo;
                Iterator it3 = it2;
                JSONObject put = jSONObject2.put("id", j2).put("u", k02.sender).put("t", k02.type).put("x", k02.text).put("m", new JSONArray((Collection) k02.media)).put("w", new JSONArray((Collection) k02.wave)).put("d", k02.duration).put("re", j3).put("ts", k02.timestamp).put("del", k02.deleted ? 1 : 0).put("ed", k02.status);
                if (j3 > 0) {
                    put.put("rp", new JSONObject().put("u", k02.u).put("t", k02.t).put("x", k02.x).put("del", k02.deleted ? 1 : 0));
                }
                jSONArray2.put(put);
                List<b.b> list = (List) this.reactions.get(Long.valueOf(j2));
                if (list != null && (!list.isEmpty())) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (b.b bVar : list) {
                        jSONArray3.put(new JSONArray().put(bVar.f764a).put(bVar.f765b));
                    }
                    jSONObject.put(String.valueOf(j2), jSONArray3);
                }
                jSONArray = jSONArray2;
                it2 = it3;
            }
            JSONArray jSONArray4 = jSONArray;
            JSONArray jSONArray5 = new JSONArray();
            for (String str : this.members) {
                JSONObject put2 = new JSONObject().put("u", str);
                String str2 = (String) this.displayNames.get(str);
                if (str2 == null) {
                    str2 = str;
                }
                JSONObject put3 = put2.put("n", str2);
                String str3 = (String) this.memberPics.get(str);
                if (str3 == null) {
                    str3 = "";
                }
                jSONArray5.put(put3.put("p", str3));
            }
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry entry : this.lastSeen.entrySet()) {
                jSONObject3.put((String) entry.getKey(), ((Number) entry.getValue()).longValue());
            }
            JSONObject put4 = new JSONObject().put("msgs", jSONArray4).put("r", jSONObject).put("mem", jSONArray5).put("seen", jSONObject3).put("g", new JSONObject().put("name", this.groupName).put("pic", this.groupPic));
            if (!this.hasMore && arrayList.size() <= 60) {
                z = false;
                JSONObject put5 = put4.put("more", z);
                String str4 = "chatcache_" + this.username;
                String jSONObject4 = put5.toString();
                sharedPreferences = AppState.prefs;
                if (sharedPreferences == null) {
                    sharedPreferences.edit().putString(str4, jSONObject4).apply();
                    return;
                } else {
                    i.b.g("sp");
                    throw null;
                }
            }
            z = true;
            JSONObject put52 = put4.put("more", z);
            String str42 = "chatcache_" + this.username;
            String jSONObject42 = put52.toString();
            sharedPreferences = AppState.prefs;
            if (sharedPreferences == null) {
            }
        } catch (Exception unused) {
        }
    }

    public final List emojiCatalog() {
        ArrayList arrayList = this.emojiCatalogCache;
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            TextPaint textPaint = new TextPaint();
            String str = null;
            for (String str2 : m.e.T(AppState.v(new BufferedReader(new InputStreamReader(this.activity.getAssets().open("data/emoji.txt"), m.a.f864a), 8192)))) {
                if (m.m.K(str2, "# ")) {
                    str = str2.substring(2);
                    i.b.d(str, "substring(...)");
                } else if (!m.e.R(str2)) {
                    List b0 = m.e.b0(str2, new String[]{" "});
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj : b0) {
                        String str3 = (String) obj;
                        if (str3.length() > 0 && textPaint.hasGlyph(str3)) {
                            arrayList3.add(obj);
                        }
                    }
                    if (!arrayList3.isEmpty()) {
                        if (str != null) {
                            arrayList2.add(str);
                            str = null;
                        }
                        int i2 = 0;
                        while (i2 < arrayList3.size()) {
                            int i3 = i2 + 7;
                            arrayList2.add(c.b.Q(arrayList3.subList(i2, Math.min(i3, arrayList3.size()))));
                            i2 = i3;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        this.emojiCatalogCache = arrayList2;
        return arrayList2;
    }

    public final void saveOutbox() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.outbox) {
            Iterator it = this.outbox.iterator();
            while (it.hasNext()) {
                OutboxEntry m0 = (OutboxEntry) it.next();
                jSONArray.put(new JSONObject().put("b", m0.body).put("ts", m0.timestamp).put("u", m0.u).put("t", m0.t).put("x", m0.x).put("d", m0.deleted));
            }
        }
        if (jSONArray.length() == 0) {
            String str = "outbox_" + this.username;
            SharedPreferences sharedPreferences = AppState.prefs;
            if (sharedPreferences != null) {
                sharedPreferences.edit().remove(str).apply();
                return;
            } else {
                i.b.g("sp");
                throw null;
            }
        }
        String str2 = "outbox_" + this.username;
        String jSONArray2 = jSONArray.toString();
        SharedPreferences sharedPreferences2 = AppState.prefs;
        if (sharedPreferences2 != null) {
            sharedPreferences2.edit().putString(str2, jSONArray2).apply();
        } else {
            i.b.g("sp");
            throw null;
        }
    }

    public final TextView sectionHeader(int i2, String str) {
        TextView f1 = makeText(str, 15.5f, this.textColor, true);
        f1.setPadding(dp(21), dp(i2), dp(20), dp(13));
        return f1;
    }

    public final void sendMediaMessage(long j2, String str, List list, int i2, ChatMessage k0, List list2) {
        JSONObject put = new JSONObject().put("type", str).put("text", "").put("media", new JSONArray((Collection) list)).put("wave", new JSONArray((Collection) list2)).put("dur", i2);
        if (k0 != null) {
            put.put("reply", k0.id);
        }
        if (this.connectionState == 1 || (!this.outbox.isEmpty())) {
            queueRetry(j2, put, k0);
        } else {
            new Thread(new RunnableC0093z0(put, this, j2, k0)).start();
        }
    }

    public final void maybeLoadOlderAtTop() {
        if (this.hasMore && !this.loadingOlder && this.cacheLoaded && (!this.messages.isEmpty())) {
            I2 i2 = this.messageList;
            if (i2 == null) {
                i.b.g("lv");
                throw null;
            }
            if (i2.canScrollVertically(-1)) {
                return;
            }
            I2 i22 = this.messageList;
            if (i22 == null) {
                i.b.g("lv");
                throw null;
            }
            if (i22.canScrollVertically(1)) {
                return;
            }
            loadOlderMessages();
        }
    }

    public final void sendMedia(List list) {
        ChatMessage k0 = this.replyTarget;
        setReplyTarget(null);
        ArrayList arrayList = new ArrayList(c.d.E(list));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(newLocalId());
        }
        new Thread(new RunnableC0040k(list, this, arrayList, addLocalMediaMessage("image", arrayList, 0, k0, c.j.f773a), k0)).start();
    }

    public final void sendVideo(Uri uri) {
        ChatMessage k0 = this.replyTarget;
        setReplyTarget(null);
        String c0 = newLocalId();
        new Thread(new RunnableC0040k(this, uri, c0, addLocalMediaMessage("video", AppState.p(c0), 0, k0, c.j.f773a), k0)).start();
    }

    public final b.b makeFullscreenDialog() {
        Dialog dialog = new Dialog(this.activity, R.style.Theme.Black.NoTitleBar);
        LinearLayout k1 = columnLayout();
        int i2 = this.bgColor;
        k1.setBackgroundColor(i2);
        dialog.setContentView(k1, new ViewGroup.LayoutParams(-1, -1));
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(i2));
            window.setLayout(-1, -1);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i2);
            window.setNavigationBarColor(i2);
            if (!this.lightBars) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8208);
            }
        }
        return new b.b(dialog, k1);
    }

    public final void sendRecordedVoice() {
        byte[] bArr;
        File file = this.recordFile;
        if (file == null) {
            return;
        }
        stopPlayback();
        final ArrayList A0 = waveformPeaks(this.waveformSamples);
        final int i2 = this.recordDurationMs;
        this.recordFile = null;
        this.recordState = "idle";
        showIdleInput();
        try {
            bArr = g.m.G(file);
        } catch (Exception unused) {
            bArr = null;
        }
        file.delete();
        if (bArr == null) {
            this.toaster.a("Could not read the recording");
            return;
        }
        final ChatMessage k0 = this.replyTarget;
        setReplyTarget(null);
        String c0 = newLocalId();
        try {
            g.m.K(ChatMedia.mediaFile(c0), bArr);
        } catch (Exception unused2) {
        }
        final long a2 = addLocalMediaMessage("voice", AppState.p(c0), i2, k0, A0);
        final byte[] bArr2 = bArr;
        new Thread(new Runnable() { 
            @Override 
            public final void run() {
                final ChatScreen chatScreen = ChatScreen.this;
                chatScreen.getClass();
                final byte[] bArr3 = bArr2;
                final b.b j1 = ChatScreen.uploadMedia("voice", bArr3);
                final ArrayList arrayList = (ArrayList) A0;
                final long j2 = a2;
                final int i3 = i2;
                final ChatMessage k02 = k0;
                chatScreen.activity.runOnUiThread(new Runnable() { 
                    @Override 
                    public final void run() {
                        byte[] bArr4 = bArr3;
                        b.b bVar = b.b.this;
                        Object obj = bVar.f764a;
                        int length = ((CharSequence) obj).length();
                        ChatScreen chatScreen2 = chatScreen;
                        long j3 = j2;
                        if (length <= 0) {
                            chatScreen2.markFailed(j3);
                            chatScreen2.toaster.a(bVar.f765b);
                            return;
                        }
                        try {
                            File file2 = ChatMedia.cacheDir;
                            g.m.K(ChatMedia.mediaFile((String) obj), bArr4);
                        } catch (Exception unused3) {
                        }
                        chatScreen2.sendMediaMessage(j3, "voice", AppState.p(obj), i3, k02, arrayList);
                    }
                });
            }
        }).start();
    }

    public final int headerBgColor() {
        return isDarkBg() ? this.palette.f489i : this.barDark;
    }

    public final void setAvatarFromUri(Uri uri) {
        if (isOffline()) {
            this.toaster.a("No internet connection");
        } else {
            new Thread(new HttpConnectionHandler(this, uri)).start();
        }
    }

    public final int titleTextColor() {
        return isDarkBg() ? this.palette.f487g : this.textColor;
    }

    public final void attachLongPressMenu(View view, final ChatMessage k0) {
        view.setOnLongClickListener(new View.OnLongClickListener() { 
            
            @Override 
            
            public final boolean onLongClick(View view2) {
                final String str;
                Object obj;
                final ChatScreen chatScreen = ChatScreen.this;
                chatScreen.getClass();
                final ChatMessage k02 = k0;
                String str2 = k02.sender;
                String str3 = chatScreen.username;
                final boolean a2 = i.b.a(str2, str3);
                List list = (List) chatScreen.reactions.get(Long.valueOf(k02.id));
                if (list != null) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (i.b.a(((b.b) obj).f764a, str3)) {
                            break;
                        }
                    }
                    b.b bVar = (b.b) obj;
                    if (bVar != null) {
                        str = (String) bVar.f765b;
                    }
                }
                str = "";
                chatScreen.showBottomSheet(false, new h.c() { 
                    @Override 
                    public final Object addLocalMediaMessage(Object obj2, Object obj3) {
                        ChatMessage k03;
                        Activity activity;
                        final ChatScreen chatScreen2;
                        final ChatMessage k04;
                        LinearLayout linearLayout = (LinearLayout) obj2;
                        final Dialog dialog = (Dialog) obj3;
                        ChatScreen chatScreen3 = ChatScreen.this;
                        LinearLayout P = chatScreen3.rowLayout();
                        int i2 = 17;
                        P.setGravity(17);
                        float f2 = 4;
                        P.setPadding(chatScreen3.dp(f2), chatScreen3.dp(8), chatScreen3.dp(f2), chatScreen3.dp(10));
                        Iterator it2 = chatScreen3.quickReactions.iterator();
                        while (true) {
                            boolean hasNext = it2.hasNext();
                            k03 = k02;
                            activity = chatScreen3.activity;
                            if (!hasNext) {
                                break;
                            }
                            String str4 = (String) it2.next();
                            TextView textView = new TextView(activity);
                            textView.setText(str4);
                            textView.setTextSize(1, 31.62f);
                            textView.setGravity(i2);
                            String str5 = str;
                            if (i.b.a(str4, str5)) {
                                textView.setBackground(ChatScreen.circleDrawable(chatScreen3.lightBars ? -14272175 : -1575937));
                            }
                            textView.setOnClickListener(new V(dialog, chatScreen3, k03, str4, str5));
                            P.addView(textView, new LinearLayout.LayoutParams(0, chatScreen3.dp(52), 1.0f));
                            i2 = 17;
                        }
                        FrameLayout frameLayout = new FrameLayout(activity);
                        FrameLayout frameLayout2 = new FrameLayout(activity);
                        frameLayout2.setBackground(ChatScreen.circleDrawable(chatScreen3.chipColor));
                        float f3 = 22;
                        frameLayout2.addView(new IconView(activity, "plus", chatScreen3.textColor, 2.4f), new FrameLayout.LayoutParams(chatScreen3.dp(f3), chatScreen3.dp(f3), 17));
                        frameLayout2.setOnClickListener(new H(dialog, chatScreen3, k03, 1));
                        float f4 = 40;
                        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(chatScreen3.dp(f4), chatScreen3.dp(f4), 17));
                        P.addView(frameLayout, new LinearLayout.LayoutParams(0, chatScreen3.dp(52), 1.0f));
                        linearLayout.addView(P, ChatScreen.layoutParamsDefault(chatScreen3, -1, -2, 0, 0, 0, 60));
                        linearLayout.addView(chatScreen3.dividerView());
                        linearLayout.addView(new View(activity), new LinearLayout.LayoutParams(-1, chatScreen3.dp(6)));
                        boolean a3 = i.b.a(k03.type, "text");
                        if (a3) {
                            chatScreen2 = chatScreen3;
                            k04 = k03;
                            chatScreen3.menuRow(linearLayout, "copyf", "Copy", chatScreen3.textColor, new W(dialog, chatScreen3, k03, 0));
                        } else {
                            chatScreen2 = chatScreen3;
                            k04 = k03;
                        }
                        final boolean z = a2;
                        if (z && a3) {
                            chatScreen2.menuRow(linearLayout, "editf", "Edit", chatScreen2.textColor, new W(dialog, chatScreen2, k04, 1));
                        }
                        chatScreen2.menuRow(linearLayout, "replyf", "Reply", chatScreen2.textColor, new W(dialog, chatScreen2, k04, 2));
                        chatScreen2.menuRow(linearLayout, "trashf", z ? "Delete" : "Delete for me", chatScreen2.dangerColor, new h.a() { 
                            @Override 
                            public final Object addLocalMediaMessage() {
                                dialog.dismiss();
                                boolean ChatMedia = z;
                                ChatScreen chatScreen4 = chatScreen2;
                                ChatMessage k05 = k04;
                                chatScreen4.getClass();
                                if (ChatMedia) {
                                    chatScreen4.showBottomSheet(false, new Y(chatScreen4, k05, 0));
                                } else {
                                    chatScreen4.showConfirmDialog("Delete?", "Are you sure you want to delete this message?", "No", "Yes", new C0005b0(chatScreen4, k05, 0));
                                }
                                return b.d.f770c;
                            }
                        });
                        return b.d.f770c;
                    }
                });
                return true;
            }
        });
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                attachLongPressMenu(viewGroup.getChildAt(i2), k0);
            }
        }
    }

    public final int themedSubTextColor() {
        return isDarkBg() ? this.palette.f488h : this.subTextColor;
    }

    public final void setConnectionState(int i2) {
        if (i2 == 2 && this.connectionState != 2) {
            this.connectingSince = System.currentTimeMillis();
        }
        if (this.connectionState == i2) {
            return;
        }
        this.connectionState = i2;
        FrameLayout frameLayout = this.netIcon;
        if (frameLayout == null) {
            i.b.g("netIcon");
            throw null;
        }
        frameLayout.removeAllViews();
        if (i2 == 1) {
            FrameLayout frameLayout2 = this.netIcon;
            if (frameLayout2 == null) {
                i.b.g("netIcon");
                throw null;
            }
            float f2 = 24;
            frameLayout2.addView(makeIcon("wifioff", themedSubTextColor(), 24), new FrameLayout.LayoutParams(dp(f2), dp(f2), 17));
            TextView textView = this.netText;
            if (textView == null) {
                i.b.g("netTv");
                throw null;
            }
            textView.setText("No internet connection");
            LinearLayout linearLayout = this.netBar;
            if (linearLayout == null) {
                i.b.g("netBar");
                throw null;
            }
            linearLayout.setVisibility(0);
        } else if (i2 != 2) {
            LinearLayout linearLayout2 = this.netBar;
            if (linearLayout2 == null) {
                i.b.g("netBar");
                throw null;
            }
            linearLayout2.setVisibility(8);
        } else {
            FrameLayout frameLayout3 = this.netIcon;
            if (frameLayout3 == null) {
                i.b.g("netIcon");
                throw null;
            }
            float f3 = 22;
            frameLayout3.addView(new ProgressBar(this.activity), new FrameLayout.LayoutParams(dp(f3), dp(f3), 17));
            TextView textView2 = this.netText;
            if (textView2 == null) {
                i.b.g("netTv");
                throw null;
            }
            textView2.setText("Connecting...");
            LinearLayout linearLayout3 = this.netBar;
            if (linearLayout3 == null) {
                i.b.g("netBar");
                throw null;
            }
            linearLayout3.setVisibility(0);
        }
        refreshHeader();
    }

    public final boolean isDarkBg() {
        return !this.palette.f484d;
    }

    public final void setReplyTarget(ChatMessage k0) {
        this.replyTarget = k0;
        if (k0 == null) {
            this.replyTargetId = 0L;
            LinearLayout linearLayout = this.replyBar;
            if (linearLayout == null) {
                i.b.g("replyBar");
                throw null;
            }
            linearLayout.setVisibility(8);
            View view = this.replyTopLine;
            if (view != null) {
                view.setVisibility(8);
                return;
            } else {
                i.b.g("replyTop");
                throw null;
            }
        }
        String str = k0.sender;
        String x = i.b.a(str, this.username) ? "yourself" : displayName(str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("Replying to ");
        spannableStringBuilder.append((CharSequence) x);
        spannableStringBuilder.setSpan(new StyleSpan(1), spannableStringBuilder.length() - x.length(), spannableStringBuilder.length(), 33);
        TextView textView = this.replyWhoText;
        if (textView == null) {
            i.b.g("replyWho");
            throw null;
        }
        textView.setText(spannableStringBuilder);
        TextView textView2 = this.replyText;
        if (textView2 == null) {
            i.b.g("replyTxt");
            throw null;
        }
        textView2.setText(replyPreviewText(k0.type, k0.text, k0.deleted));
        LinearLayout linearLayout2 = this.replyBar;
        if (linearLayout2 == null) {
            i.b.g("replyBar");
            throw null;
        }
        linearLayout2.setVisibility(0);
        View view2 = this.replyTopLine;
        if (view2 == null) {
            i.b.g("replyTop");
            throw null;
        }
        view2.setVisibility(0);
        this.replyTargetId = k0.id;
        EditText editText = this.messageInput;
        if (editText == null) {
            i.b.g("input");
            throw null;
        }
        editText.requestFocus();
        I2 i2 = this.messageList;
        if (i2 == null) {
            i.b.g("lv");
            throw null;
        }
        i2.post(new RunnableC0048m(this, 7));
        this.handler.postDelayed(new RunnableC0048m(this, 8), 150L);
    }

    public final C1 makeIcon(String str, int i2, int i3) {
        C1 c1 = new C1(this.activity, str, i2);
        float f2 = i3;
        c1.setMinimumWidth(dp(f2));
        c1.setMinimumHeight(dp(f2));
        c1.setCut(str.equals("face") ? isDarkBg() ? this.palette.p | (-16777216) : this.faceBaseColor : (isDarkBg() && (str.equals("deliv") || str.equals("sent"))) ? -1 : isDarkBg() ? this.palette.f486f : this.bgColor);
        return c1;
    }

    public final LinearLayout settingsRow(View view, String str, String str2, h.a aVar) {
        LinearLayout P = rowLayout();
        float f2 = 8;
        P.setPadding(dp(17), dp(f2), dp(16), dp(f2));
        float f3 = 38;
        P.addView(view, layoutParamsDefault(this, dp(f3), dp(f3), 0, 0, 14, 32));
        LinearLayout k1 = columnLayout();
        k1.addView(makeText(str, 20.0f, this.textColor, false), layoutParamsDefault(this, -2, -2, 0, 0, 0, 60));
        if (str2 != null) {
            k1.addView(makeText(str2, 14.5f, this.subTextColor, false), layoutParamsDefault(this, -2, -2, 0, 0, 0, 60));
        }
        P.addView(k1, new LinearLayout.LayoutParams(0, -2, 1.0f));
        P.setOnClickListener(new ActionClickListener(aVar, 0));
        return P;
    }

    public final GradientDrawable roundedDrawable(int i2, float f2, int i3, float f3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius(dp(f2));
        if (f3 > 0.0f) {
            gradientDrawable.setStroke(dp(f3), i3);
        }
        return gradientDrawable;
    }

    public final boolean isOnline() {
        try {
            Object systemService = this.activity.getSystemService("connectivity");
            i.b.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Network activeNetwork = connectivityManager.getActiveNetwork();
            NetworkCapabilities networkCapabilities = activeNetwork == null ? null : connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities != null) {
                if (networkCapabilities.hasCapability(12)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public final void menuRow(LinearLayout linearLayout, String str, String str2, int i2, h.a aVar) {
        LinearLayout P = rowLayout();
        float f2 = 16;
        float f3 = 6;
        P.setPadding(dp(f2), dp(f3), dp(f2), dp(f3));
        FrameLayout frameLayout = new FrameLayout(this.activity);
        frameLayout.setBackground(circleDrawable(this.chipColor));
        float f4 = 22;
        frameLayout.addView(makeIcon(str, i2, 22), new FrameLayout.LayoutParams(dp(f4), dp(f4), 17));
        float f5 = 44;
        P.addView(frameLayout, layoutParamsDefault(this, dp(f5), dp(f5), 0, 0, 16, 32));
        P.addView(makeText(str2, 20.5f, this.textColor, false), new LinearLayout.LayoutParams(0, -2, 1.0f));
        P.setOnClickListener(new ActionClickListener(aVar, 2));
        linearLayout.addView(P, layoutParamsDefault(this, -1, -2, 0, 0, 0, 60));
    }

    public final LinearLayout rowLayout() {
        LinearLayout linearLayout = new LinearLayout(this.activity);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        return linearLayout;
    }

    public final void showIdleInput() {
        FrameLayout frameLayout = this.inputHolder;
        if (frameLayout == null) {
            i.b.g("holder");
            throw null;
        }
        frameLayout.removeAllViews();
        FrameLayout frameLayout2 = this.inputHolder;
        if (frameLayout2 == null) {
            i.b.g("holder");
            throw null;
        }
        LinearLayout linearLayout = this.idleInputView;
        if (linearLayout != null) {
            frameLayout2.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        } else {
            i.b.g("idleView");
            throw null;
        }
    }

    public final ImageView mediaImage(String str, float[] fArr, int i2, h.b bVar, h.a aVar) {
        ImageView imageView = new ImageView(this.activity);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setBackgroundColor(this.mediaPlaceholderColor);
        imageView.setOutlineProvider(new T0(0, fArr));
        imageView.setClipToOutline(true);
        ChatMedia.loadInto(imageView, str, i2, bVar);
        imageView.setOnClickListener(new TripleClickListener(aVar, this, str, 0));
        imageView.setOnLongClickListener(new ViewOnLongClickListenerC0065q0());
        return imageView;
    }

    public final boolean isMuted() {
        String str = "muted_" + this.username;
        SharedPreferences sharedPreferences = AppState.prefs;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            return i.b.a(string != null ? string : "", "1");
        }
        i.b.g("sp");
        throw null;
    }

    public final boolean isLocalMessage(ChatMessage k0) {
        return k0.id >= this.localIdBase;
    }

    
    
    
    
    public final void buildRecordBar() {
        ?? r11;
        TextView textView;
        final boolean a2 = i.b.a(this.recordState, "rec");
        LinearLayout k1 = columnLayout();
        float f2 = 13;
        k1.setPadding(dp(f2), dp(6), dp(f2), dp(8));
        LinearLayout P = rowLayout();
        P.setBackground(roundedDrawable(this.sendBlue, 30.0f, 0, 0.0f));
        P.setPadding(dp(a2 ? 18 : 12), 0, dp(f2), 0);
        float z = dp(3);
        float ChatMedia = dp(2.5f);
        Activity activity = this.activity;
        P2 p2 = new P2(activity, z, ChatMedia);
        p2.setFg(-1);
        ArrayList arrayList = this.waveformSamples;
        if (a2) {
            p2.setLive(true);
            p2.setValues(arrayList);
            this.recordWaveView = p2;
            r11 = 1;
            textView = null;
        } else {
            C1 M = makeIcon("play", -1, 26);
            float f3 = 26;
            r11 = 1;
            P.addView(M, layoutParamsDefault(this, dp(f3), dp(f3), 0, 0, 11, 32));
            p2.setValues(waveformPeaks(arrayList));
            p2.setCursor(true);
            textView = null;
            this.recordWaveView = null;
            this.playButtons.put(-2L, M);
            this.waveViews.put(-2L, p2);
            setClickAction(M, new C0036j(this, 5));
        }
        P.addView(p2, new LinearLayout.LayoutParams(0, dp(34), 1.0f));
        TextView f1 = makeText(formatDuration(a2 ? this.recordBaseDurationMs : this.recordDurationMs), 16.0f, -1, r11);
        this.recordTimeText = a2 ? f1 : textView;
        P.addView(f1, layoutParamsDefault(this, -2, -2, 17, 0, 0, 56));
        k1.addView(P, layoutParamsDefault(this, -1, dp(44), 0, 0, 0, 60));
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        FrameLayout frameLayout = new FrameLayout(activity);
        float f4 = 26;
        frameLayout.addView(new IconView(activity, "trashmsg", this.subTextColor, 1.7f), new FrameLayout.LayoutParams(dp(f4), dp(f4), 17));
        setClickAction(frameLayout, new C0036j(this, 6));
        float f5 = 52;
        linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(dp(f5), dp(f5)));
        linearLayout.addView(new View(activity), new LinearLayout.LayoutParams(0, r11, 1.0f));
        FrameLayout frameLayout2 = new FrameLayout(activity);
        String str = a2 ? "pauseo" : "mico";
        int i2 = this.barDark;
        float f6 = 28;
        frameLayout2.addView(makeIcon(str, i2, 28), new FrameLayout.LayoutParams(dp(f6), dp(f6), 17));
        final int i3 = 0;
        setClickAction(frameLayout2, new h.a() { 
            @Override 
            public final Object addLocalMediaMessage() {
                switch (i3) {
                    case 0:
                        boolean z3 = a2;
                        ChatScreen chatScreen = this;
                        if (z3) {
                            chatScreen.stopRecording();
                        } else {
                            chatScreen.stopPlayback();
                            chatScreen.startRecording(true);
                        }
                        break;
                    default:
                        boolean z4 = a2;
                        ChatScreen chatScreen2 = this;
                        if (z4) {
                            chatScreen2.stopRecording();
                            if (i.b.a(chatScreen2.recordState, "prev")) {
                                chatScreen2.sendRecordedVoice();
                            }
                        } else {
                            chatScreen2.sendRecordedVoice();
                        }
                        break;
                }
                return b.d.f770c;
            }
        });
        linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(dp(f5), dp(f5)));
        linearLayout.addView(new View(activity), new LinearLayout.LayoutParams(0, r11, 1.0f));
        FrameLayout frameLayout3 = new FrameLayout(activity);
        frameLayout3.addView(makeIcon("send", i2, 28), new FrameLayout.LayoutParams(dp(f6), dp(f6), 17));
        final int i4 = 1;
        setClickAction(frameLayout3, new h.a() { 
            @Override 
            public final Object addLocalMediaMessage() {
                switch (i4) {
                    case 0:
                        boolean z3 = a2;
                        ChatScreen chatScreen = this;
                        if (z3) {
                            chatScreen.stopRecording();
                        } else {
                            chatScreen.stopPlayback();
                            chatScreen.startRecording(true);
                        }
                        break;
                    default:
                        boolean z4 = a2;
                        ChatScreen chatScreen2 = this;
                        if (z4) {
                            chatScreen2.stopRecording();
                            if (i.b.a(chatScreen2.recordState, "prev")) {
                                chatScreen2.sendRecordedVoice();
                            }
                        } else {
                            chatScreen2.sendRecordedVoice();
                        }
                        break;
                }
                return b.d.f770c;
            }
        });
        linearLayout.addView(frameLayout3, new LinearLayout.LayoutParams(dp(f5), dp(f5)));
        k1.addView(linearLayout, layoutParamsDefault(this, -1, -2, 0, 0, 0, 60));
        FrameLayout frameLayout4 = this.inputHolder;
        if (frameLayout4 == null) {
            i.b.g("holder");
            throw null;
        }
        frameLayout4.removeAllViews();
        FrameLayout frameLayout5 = this.inputHolder;
        if (frameLayout5 != null) {
            frameLayout5.addView(k1, new FrameLayout.LayoutParams(-1, -2));
        } else {
            i.b.g("holder");
            throw null;
        }
    }

    public final long lastServerMessageId() {
        ArrayList arrayList = this.messages;
        int size = arrayList.size() - 1;
        if (size < 0) {
            return 0L;
        }
        while (true) {
            int i2 = size - 1;
            if (!isLocalMessage((ChatMessage) arrayList.get(size))) {
                return ((ChatMessage) arrayList.get(size)).id;
            }
            if (i2 < 0) {
                return 0L;
            }
            size = i2;
        }
    }

    public final void showDialogThemed(Dialog dialog) {
        Window window = dialog.getWindow();
        if (window != null && (!m.m.F(this.username, this.groupId))) {
            window.addFlags(8192);
        }
        dialog.show();
    }

    public final void refreshMembers() {
        new Thread(new RunnableC0048m(this, 5)).start();
    }

    public final LinearLayout.LayoutParams mediaLayoutParams(float f2) {
        int z = dp(254);
        int ChatMedia = dp(265);
        int i2 = (int) (z / f2);
        if (i2 > ChatMedia) {
            z = (int) (ChatMedia * f2);
        } else {
            ChatMedia = i2;
        }
        float f3 = 90;
        if (z < dp(f3)) {
            z = dp(f3);
        }
        float f4 = 80;
        if (ChatMedia < dp(f4)) {
            ChatMedia = dp(f4);
        }
        return new LinearLayout.LayoutParams(z, ChatMedia);
    }

    public final void loadOlderMessages() {
        ArrayList arrayList = this.messages;
        if (arrayList.isEmpty()) {
            return;
        }
        this.loadingOlder = true;
        new Thread(new RunnableC0049m0(0, ((ChatMessage) arrayList.get(0)).id, this)).start();
    }

    public final LinearLayout.LayoutParams layoutParams(int i2, int i3, int i4, int i5, int i6, int i7) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i3);
        layoutParams.setMargins(dp(i4), dp(i5), dp(i6), dp(i7));
        return layoutParams;
    }

    public final void startRecording(boolean z) {
        Activity activity = this.activity;
        if (activity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            this.micPermPending = true;
            activity.requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, 3);
            return;
        }
        h.b bVar = this.toaster;
        if (z && this.recordDurationMs >= 179000) {
            bVar.a("Voice message is at the maximum length");
            return;
        }
        try {
            try {
                File file = new File(activity.getCacheDir(), "rec_" + System.currentTimeMillis() + ".m4a");
                MediaRecorder mediaRecorder = new MediaRecorder();
                mediaRecorder.setAudioSource(1);
                mediaRecorder.setOutputFormat(2);
                mediaRecorder.setAudioEncoder(3);
                mediaRecorder.setAudioEncodingBitRate(32000);
                mediaRecorder.setAudioSamplingRate(22050);
                mediaRecorder.setAudioChannels(1);
                mediaRecorder.setOutputFile(file.getPath());
                mediaRecorder.prepare();
                mediaRecorder.start();
                this.mediaRecorder = mediaRecorder;
                this.recordTempFile = file;
                LinearLayout linearLayout = this.emojiPanel;
                if (linearLayout == null) {
                    i.b.g("panel");
                    throw null;
                }
                linearLayout.setVisibility(8);
                Object systemService = activity.getSystemService("input_method");
                i.b.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                EditText editText = this.messageInput;
                if (editText == null) {
                    i.b.g("input");
                    throw null;
                }
                inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                if (!z) {
                    this.waveformSamples.clear();
                    this.recordDurationMs = 0;
                    this.recordFile = null;
                }
                this.recordBaseDurationMs = z ? this.recordDurationMs : 0;
                this.recordState = "rec";
                this.recordStartedAt = System.currentTimeMillis();
                buildRecordBar();
                this.handler.post(this.recordTickRunnable);
            } catch (Exception unused) {
                this.mediaRecorder = null;
                bVar.a("Could not start the microphone");
            }
        } catch (Exception unused2) {
            MediaRecorder mediaRecorder2 = this.mediaRecorder;
            if (mediaRecorder2 != null) {
                mediaRecorder2.release();
            }
            this.mediaRecorder = null;
            bVar.a("Could not start the microphone");
        }
    }

    public final void stopPlayback() {
        this.handler.removeCallbacks(this.playbackTickRunnable);
        try {
            MediaPlayer mediaPlayer = this.audioPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        } catch (Exception unused) {
        }
        this.audioPlayer = null;
        C1 c1 = (C1) this.playButtons.get(Long.valueOf(this.playingMessageId));
        if (c1 != null) {
            c1.set("play");
        }
        TextView textView = (TextView) this.speedLabels.get(Long.valueOf(this.playingMessageId));
        if (textView != null) {
            textView.setVisibility(8);
        }
        P2 p2 = (P2) this.waveViews.get(Long.valueOf(this.playingMessageId));
        if (p2 != null) {
            p2.setProgress(0.0f);
            p2.invalidate();
        }
        this.playingMessageId = Long.MIN_VALUE;
    }

    public final void markLocalSent(long j2) {
        int i2 = 2;
        this.lastLocalSentId = j2;
        this.sentSoundElapsed = 0L;
        Handler handler = C2.f57a;
        try {
            Object systemService = this.activity.getSystemService("audio");
            i.b.c(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            if (((AudioManager) systemService).getRingerMode() != 2) {
                return;
            }
            C2.f58b.execute(new RunnableC0068r0(i2));
        } catch (Exception unused) {
        }
    }

    
    
    
    
    
    public final void stopRecording() {
        boolean z;
        MediaMuxer mediaMuxer;
        ByteBuffer allocate;
        MediaCodec.BufferInfo bufferInfo;
        Iterator it;
        int i2;
        int i3;
        long j2;
        MediaExtractor mediaExtractor;
        int i4;
        Iterator it2;
        int i5;
        if (i.b.a(this.recordState, "rec")) {
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.recordStartedAt);
            int i6 = 0;
            try {
                MediaRecorder mediaRecorder = this.mediaRecorder;
                if (mediaRecorder != null) {
                    mediaRecorder.stop();
                }
                z = true;
            } catch (Exception unused) {
                z = false;
            }
            try {
                MediaRecorder mediaRecorder2 = this.mediaRecorder;
                if (mediaRecorder2 != null) {
                    mediaRecorder2.release();
                }
            } catch (Exception unused2) {
            }
            MediaMuxer mediaMuxer2 = null;
            this.mediaRecorder = null;
            File file = this.recordTempFile;
            this.recordTempFile = null;
            File file2 = this.recordFile;
            boolean ChatMedia = file2 == null;
            h.b bVar = this.toaster;
            if (!z || file == null || ((ChatMedia && currentTimeMillis < 600) || (!ChatMedia && currentTimeMillis < 300))) {
                if (file != null) {
                    file.delete();
                }
                if (!ChatMedia) {
                    this.recordState = "prev";
                    buildRecordBar();
                    return;
                } else {
                    bVar.a("Voice message is too short");
                    this.recordFile = null;
                    this.recordState = "idle";
                    showIdleInput();
                    return;
                }
            }
            if (ChatMedia) {
                this.recordFile = file;
                this.recordDurationMs = currentTimeMillis;
            } else {
                i.b.b(file2);
                File file3 = new File(this.activity.getCacheDir(), "rec_m_" + System.currentTimeMillis() + ".m4a");
                try {
                    try {
                        mediaMuxer = new MediaMuxer(file3.getPath(), 0);
                    } catch (Exception unused3) {
                    }
                } catch (Exception unused4) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    allocate = ByteBuffer.allocate(65536);
                    bufferInfo = new MediaCodec.BufferInfo();
                    it = c.c.C(file2, file).iterator();
                    i2 = 0;
                    i3 = -1;
                    j2 = 0;
                } catch (Exception unused5) {
                    mediaMuxer2 = mediaMuxer;
                    if (i6 != 0) {
                        try {
                            mediaMuxer2.stop();
                        } catch (Exception unused6) {
                        }
                    }
                    if (mediaMuxer2 != null) {
                    }
                    file3.delete();
                    file.delete();
                    bVar.a("Could not add to the recording");
                    this.recordState = "prev";
                    buildRecordBar();
                } catch (Throwable th2) {
                    th = th2;
                    mediaMuxer2 = mediaMuxer;
                    if (i6 != 0) {
                        try {
                            mediaMuxer2.stop();
                        } catch (Exception unused7) {
                        }
                    }
                    if (mediaMuxer2 != null) {
                    }
                }
                while (it.hasNext()) {
                    try {
                        File file4 = (File) it.next();
                        mediaExtractor = new MediaExtractor();
                        try {
                            mediaExtractor.setDataSource(file4.getPath());
                            int trackCount = mediaExtractor.getTrackCount();
                            i4 = i6;
                            while (true) {
                                if (i4 >= trackCount) {
                                    it2 = it;
                                    i5 = i3;
                                    i4 = -1;
                                    break;
                                }
                                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i4);
                                String string = trackFormat.getString("mime");
                                if (string == null) {
                                    string = "";
                                }
                                it2 = it;
                                if (m.m.K(string, "audio/")) {
                                    if (i3 < 0) {
                                        i3 = mediaMuxer.addTrack(trackFormat);
                                        mediaMuxer.start();
                                        i2 = 1;
                                    }
                                    i5 = i3;
                                } else {
                                    i4++;
                                    it = it2;
                                }
                            }
                        } catch (Throwable th3) {
                            i6 = i2;
                            mediaExtractor.release();
                            throw th3;
                        }
                    } catch (Exception unused8) {
                        mediaMuxer2 = mediaMuxer;
                        i6 = i2;
                        if (i6 != 0 && mediaMuxer2 != null) {
                            mediaMuxer2.stop();
                        }
                        if (mediaMuxer2 != null) {
                            mediaMuxer2.release();
                        }
                        file3.delete();
                        file.delete();
                        bVar.a("Could not add to the recording");
                        this.recordState = "prev";
                        buildRecordBar();
                    } catch (Throwable th4) {
                        th = th4;
                        mediaMuxer2 = mediaMuxer;
                        i6 = i2;
                        if (i6 != 0 && mediaMuxer2 != null) {
                            mediaMuxer2.stop();
                        }
                        if (mediaMuxer2 != null) {
                            throw th;
                        }
                        try {
                            mediaMuxer2.release();
                            throw th;
                        } catch (Exception unused9) {
                            throw th;
                        }
                    }
                    if (i4 < 0) {
                        mediaExtractor.release();
                        if (i2 != 0) {
                            try {
                                mediaMuxer.stop();
                            } catch (Exception unused10) {
                            }
                        }
                        mediaMuxer.release();
                        file3.delete();
                        file.delete();
                        bVar.a("Could not add to the recording");
                    } else {
                        mediaExtractor.selectTrack(i4);
                        long j3 = 0;
                        while (true) {
                            allocate.clear();
                            i6 = 0;
                            int readSampleData = mediaExtractor.readSampleData(allocate, 0);
                            if (readSampleData < 0) {
                                break;
                            }
                            bufferInfo.offset = 0;
                            bufferInfo.size = readSampleData;
                            bufferInfo.presentationTimeUs = mediaExtractor.getSampleTime() + j2;
                            bufferInfo.flags = (mediaExtractor.getSampleFlags() & 1) != 0 ? 1 : 0;
                            mediaMuxer.writeSampleData(i5, allocate, bufferInfo);
                            j3 = bufferInfo.presentationTimeUs;
                            mediaExtractor.advance();
                        }
                        j2 = j3 + 46440;
                        mediaExtractor.release();
                        i3 = i5;
                        it = it2;
                    }
                }
                if (i2 != 0) {
                    try {
                        mediaMuxer.stop();
                    } catch (Exception unused11) {
                    }
                }
                mediaMuxer.release();
                file2.delete();
                file.delete();
                this.recordFile = file3;
                this.recordDurationMs = this.recordBaseDurationMs + currentTimeMillis;
            }
            this.recordState = "prev";
            buildRecordBar();
        }
    }

    public final long savedNameChangedAt() {
        long j2 = this.nameChangedAt;
        String str = "nameat_" + this.username;
        SharedPreferences sharedPreferences = AppState.prefs;
        if (sharedPreferences == null) {
            i.b.g("sp");
            throw null;
        }
        String string = sharedPreferences.getString(str, "0");
        Long D = m.l.D(string != null ? string : "0");
        return Math.max(j2, D != null ? D.longValue() : 0L);
    }

    public final long addLocalMediaMessage(String str, List list, int i2, ChatMessage k0, List list2) {
        String str2;
        String str3;
        String str4;
        long j2 = this.localIdCounter + 1;
        this.localIdCounter = j2;
        long j3 = this.localIdBase + j2;
        this.messages.add(new ChatMessage(j3, this.username, str, "", list, new ArrayList(list2), i2, k0 != null ? k0.id : 0L, System.currentTimeMillis(), (k0 == null || (str4 = k0.sender) == null) ? "" : str4, (k0 == null || (str3 = k0.type) == null) ? "" : str3, (k0 == null || (str2 = k0.text) == null) ? "" : str2, k0 != null ? k0.deleted : false));
        markLocalSent(j3);
        this.pendingLocalIds.add(Long.valueOf(j3));
        refreshMessages();
        applyScroll(true);
        return j3;
    }

    public final boolean hasUncachedMedia(List list, boolean z) {
        if (!list.isEmpty() && isOffline()) {
            if (z) {
                File file = ChatMedia.cacheDir;
                File g2 = ChatMedia.videoFile((String) list.get(0));
                if ((!g2.exists() || g2.length() <= 0) && !list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (!m.m.K(str, "L")) {
                            File c2 = ChatMedia.mediaFile(str);
                            if (c2.exists() && c2.length() > 0) {
                            }
                            showNoInternetDialog();
                            return true;
                        }
                    }
                }
            } else if (!list.isEmpty()) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    String str2 = (String) it2.next();
                    if (!m.m.K(str2, "L")) {
                        File c3 = ChatMedia.mediaFile(str2);
                        if (c3.exists() && c3.length() > 0) {
                        }
                        showNoInternetDialog();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void applySwipeOffset(J2 j2, float f2) {
        if (j2.f144c) {
            f2 = -f2;
        }
        float max = Math.max(0.0f, f2);
        float z = dp(80.0f);
        float f3 = max <= z ? 0.75f * max : (0.75f * z) + ((max - z) * 0.12f);
        j2.f142a.setTranslationX((j2.f144c ? -1.0f : 1.0f) * f3);
        float b2 = AppState.b((f3 - dp(14.0f)) / dp(24.0f), 0.0f, 1.0f);
        boolean ChatMedia = max >= ((float) dp(70.0f));
        if (ChatMedia != this.swipeArmed) {
            this.swipeArmed = ChatMedia;
            if (ChatMedia) {
                I2 i2 = this.messageList;
                if (i2 == null) {
                    i.b.g("lv");
                    throw null;
                }
                i2.performHapticFeedback(3);
            }
        }
        View view = j2.f143b;
        view.setAlpha(b2);
        float f4 = ((b2 * 0.6f) + 0.4f) * (ChatMedia ? 1.12f : 1.0f);
        view.setScaleX(f4);
        view.setScaleY(f4);
    }

    public final int addMessages(JSONArray jSONArray) {
        if (jSONArray == null) {
            return 0;
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = this.messages;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            hashSet.add(Long.valueOf(((ChatMessage) it.next()).id));
        }
        String DragSheetLayout = clearMarkerKey();
        SharedPreferences sharedPreferences = AppState.prefs;
        if (sharedPreferences == null) {
            i.b.g("sp");
            throw null;
        }
        String string = sharedPreferences.getString(DragSheetLayout, "0");
        Long D = m.l.D(string != null ? string : "0");
        long longValue = D != null ? D.longValue() : 0L;
        int length = jSONArray.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                long optLong = optJSONObject.optLong("id");
                if (optLong > longValue && !hashSet.contains(Long.valueOf(optLong)) && !((HashSet) this.seenIds.a()).contains(Long.valueOf(optLong))) {
                    arrayList.add(messageFromJson(optJSONObject));
                    hashSet.add(Long.valueOf(optLong));
                    i2++;
                }
            }
        }
        if (i2 > 0 && arrayList.size() > 1) {
            c.g.F(arrayList, new N0(0));
        }
        return i2;
    }

    public final void showNoInternetDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.activity, this.lightBars ? R.style.Theme.DeviceDefault.Dialog.Alert : R.style.Theme.DeviceDefault.Light.Dialog.Alert);
        builder.setMessage("No internet connection.\nTurn on mobile data or Wi-Fi and try again.");
        builder.setPositiveButton("OK", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        showDialogThemed(create);
        Button button = create.getButton(-1);
        if (button != null) {
            button.setTextColor(-13793025);
        }
    }

    public final void syncSeen() {
        if (this.seenSyncStarted) {
            return;
        }
        this.seenSyncStarted = true;
        new Thread(new RunnableC0049m0(1, lastServerMessageId(), this)).start();
    }

    public final void scrollToReplyTarget() {
        long j2 = this.replyTargetId;
        if (j2 == 0) {
            return;
        }
        Iterator it = this.messages.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (((ChatMessage) it.next()).id == j2) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0) {
            return;
        }
        I2 i22 = this.messageList;
        if (i22 == null) {
            i.b.g("lv");
            throw null;
        }
        if (i22 == null) {
            i.b.g("lv");
            throw null;
        }
        View childAt = i22.getChildAt(i2 - i22.getFirstVisiblePosition());
        if (childAt == null) {
            I2 i23 = this.messageList;
            if (i23 == null) {
                i.b.g("lv");
                throw null;
            }
            if (i23 == null) {
                i.b.g("lv");
                throw null;
            }
            int paddingTop = i23.getPaddingTop();
            I2 i24 = this.messageList;
            if (i24 != null) {
                i23.setSelectionFromTop(i2, Math.max(paddingTop, i24.getHeight() - dp(90)));
                return;
            } else {
                i.b.g("lv");
                throw null;
            }
        }
        int bottom = childAt.getBottom();
        I2 i25 = this.messageList;
        if (i25 == null) {
            i.b.g("lv");
            throw null;
        }
        int height = bottom - i25.getHeight();
        if (height > 0) {
            I2 i26 = this.messageList;
            if (i26 == null) {
                i.b.g("lv");
                throw null;
            }
            int top = childAt.getTop();
            I2 i27 = this.messageList;
            if (i27 != null) {
                i26.scrollListBy(Math.min(height, Math.max(top - i27.getPaddingTop(), 0)));
            } else {
                i.b.g("lv");
                throw null;
            }
        }
    }

    public final void clearMessagesBefore(final long j2) {
        c.h.G(this.messages, new h.b() { 
            @Override 
            public final Object addLocalMediaMessage(Object obj) {
                ChatMessage k0 = (ChatMessage) obj;
                return Boolean.valueOf(!ChatScreen.this.isLocalMessage(k0) && k0.id <= j2);
            }
        });
        this.reactions.clear();
        this.lastSeen.clear();
        this.hasMore = false;
        String str = "chatcache_" + this.username;
        SharedPreferences sharedPreferences = AppState.prefs;
        if (sharedPreferences == null) {
            i.b.g("sp");
            throw null;
        }
        sharedPreferences.edit().remove(str).apply();
        String DragSheetLayout = clearMarkerKey();
        String valueOf = String.valueOf(j2);
        SharedPreferences sharedPreferences2 = AppState.prefs;
        if (sharedPreferences2 == null) {
            i.b.g("sp");
            throw null;
        }
        sharedPreferences2.edit().putString(DragSheetLayout, valueOf).apply();
        refreshMessages();
        applyScroll(false);
    }

    public final void saveNameChangedAt(long j2) {
        this.nameChangedAt = j2;
        String str = "nameat_" + this.username;
        String valueOf = String.valueOf(j2);
        SharedPreferences sharedPreferences = AppState.prefs;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, valueOf).apply();
        } else {
            i.b.g("sp");
            throw null;
        }
    }

    public final void queueRetry(long j2, JSONObject jSONObject, ChatMessage k0) {
        Object obj;
        String str;
        String str2;
        String str3;
        this.pendingLocalIds.remove(Long.valueOf(j2));
        Iterator it = this.messages.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((ChatMessage) obj).id == j2) {
                    break;
                }
            }
        }
        ChatMessage k02 = (ChatMessage) obj;
        this.outbox.add(new OutboxEntry(j2, jSONObject, k02 != null ? k02.timestamp : System.currentTimeMillis(), (k0 == null || (str3 = k0.sender) == null) ? "" : str3, (k0 == null || (str2 = k0.type) == null) ? "" : str2, (k0 == null || (str = k0.text) == null) ? "" : str, k0 != null ? k0.deleted : false));
        saveOutbox();
        O0 o0 = this.messageAdapter;
        if (o0 != null) {
            o0.notifyDataSetChanged();
        } else {
            i.b.g("adapter");
            throw null;
        }
    }

    public final void applyQuickReactionUpdate(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("q") || System.currentTimeMillis() - this.lastQuickReactionAt < 6000) {
            return;
        }
        String optString = jSONObject.optString("q", "");
        if (i.b.a(optString, quickReaction())) {
            return;
        }
        saveQuickReaction(optString);
        updateSendButton();
        C0029h0 c0029h0 = this.quickReactionRefresher;
        if (c0029h0 != null) {
            c0029h0.a();
        }
    }

    public final boolean isOffline() {
        try {
            Object systemService = this.activity.getSystemService("connectivity");
            i.b.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Network activeNetwork = connectivityManager.getActiveNetwork();
            NetworkCapabilities networkCapabilities = activeNetwork == null ? null : connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities != null && networkCapabilities.hasCapability(12)) {
                if (networkCapabilities.hasCapability(16)) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void toggleVoicePlayback(final long j2, File file) {
        MediaPlayer mediaPlayer = this.audioPlayer;
        HashMap hashMap = this.playButtons;
        if (mediaPlayer == null || this.playingMessageId != j2) {
            resetPlayIcon();
            stopPlayback();
            MediaPlayer mediaPlayer2 = new MediaPlayer();
            try {
                mediaPlayer2.setDataSource(file.getPath());
                this.audioPlayer = mediaPlayer2;
                this.playingMessageId = j2;
                C1 c1 = (C1) hashMap.get(Long.valueOf(j2));
                if (c1 != null) {
                    c1.set("load");
                }
                mediaPlayer2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { 
                    @Override 
                    public final void onPrepared(MediaPlayer mediaPlayer3) {
                        ChatScreen chatScreen = ChatScreen.this;
                        if (chatScreen.audioPlayer == mediaPlayer3) {
                            mediaPlayer3.start();
                            long j3 = j2;
                            chatScreen.applyPlaybackSpeed(mediaPlayer3, j3);
                            TextView textView = (TextView) chatScreen.speedLabels.get(Long.valueOf(j3));
                            if (textView != null) {
                                textView.setText(ChatScreen.formatSpeed(chatScreen.playbackSpeed));
                                textView.setVisibility(0);
                            }
                            C1 c12 = (C1) chatScreen.playButtons.get(Long.valueOf(j3));
                            if (c12 != null) {
                                c12.set("pause");
                            }
                            chatScreen.handler.post(chatScreen.playbackTickRunnable);
                        }
                    }
                });
                mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { 
                    @Override 
                    public final void onCompletion(MediaPlayer mediaPlayer3) {
                        ChatScreen chatScreen = ChatScreen.this;
                        if (chatScreen.audioPlayer == mediaPlayer3) {
                            chatScreen.stopPlayback();
                        }
                    }
                });
                mediaPlayer2.setOnErrorListener(new MediaPlayer.OnErrorListener() { 
                    @Override 
                    public final boolean onError(MediaPlayer mediaPlayer3, int i2, int i3) {
                        ChatScreen chatScreen = ChatScreen.this;
                        if (chatScreen.audioPlayer == mediaPlayer3) {
                            chatScreen.stopPlayback();
                        }
                        chatScreen.toaster.a("Can't play this voice message");
                        return true;
                    }
                });
                mediaPlayer2.prepareAsync();
                return;
            } catch (Exception unused) {
                if (this.audioPlayer == mediaPlayer2) {
                    stopPlayback();
                } else {
                    try {
                        mediaPlayer2.release();
                    } catch (Exception unused2) {
                    }
                }
                this.toaster.a("Can't play this voice message");
                return;
            }
        }
        try {
            boolean isPlaying = mediaPlayer.isPlaying();
            X0 x0 = this.playbackTickRunnable;
            Handler handler = this.handler;
            if (isPlaying) {
                mediaPlayer.pause();
                C1 c12 = (C1) hashMap.get(Long.valueOf(j2));
                if (c12 != null) {
                    c12.set("play");
                }
                handler.removeCallbacks(x0);
                return;
            }
            mediaPlayer.start();
            applyPlaybackSpeed(mediaPlayer, j2);
            C1 c13 = (C1) hashMap.get(Long.valueOf(j2));
            if (c13 != null) {
                c13.set("pause");
            }
            handler.post(x0);
        } catch (Exception unused3) {
            stopPlayback();
        }
    }

    public final void applyPlaybackSpeed(MediaPlayer mediaPlayer, long j2) {
        if (this.speedLabels.containsKey(Long.valueOf(j2))) {
            try {
                mediaPlayer.setPlaybackParams(mediaPlayer.getPlaybackParams().setSpeed(this.playbackSpeed));
            } catch (Exception unused) {
            }
        }
    }

    public final void showMediaPicker() {
        C0036j c0036j = new C0036j(this, 4);
        C0017e0 c0017e0 = new C0017e0(this, 0);
        boolean z = this.lightBars;
        Activity activity = this.activity;
        final B1 b1 = new B1(activity, z, c0036j, c0017e0);
        b1.quickReactions = !m.m.F(this.username, this.groupId);
        Dialog dialog = new Dialog(activity, R.style.Theme.Black.NoTitleBar);
        b1.f41r = dialog;
        Window window = dialog.getWindow();
        int i2 = b1.f30e;
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(i2));
        }
        Dialog dialog2 = b1.f41r;
        if (dialog2 == null) {
            i.b.g("dlg");
            throw null;
        }
        Window window2 = dialog2.getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(16);
        }
        FrameLayout frameLayout = new FrameLayout(activity);
        b1.f42s = frameLayout;
        frameLayout.setBackgroundColor(i2);
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setGravity(16);
        linearLayout2.setPadding(b1.e(4), b1.e(6), b1.e(12), b1.e(6));
        FrameLayout frameLayout2 = new FrameLayout(activity);
        int i3 = b1.f31f;
        frameLayout2.addView(new IconView(activity, "back", i3, 2.4f), new FrameLayout.LayoutParams(b1.e(26), b1.e(26), 17));
        frameLayout2.setOnClickListener(new ViewOnClickListenerC0058o1(b1, 6));
        linearLayout2.addView(frameLayout2, new LinearLayout.LayoutParams(b1.e(48), b1.e(48)));
        LinearLayout linearLayout3 = new LinearLayout(activity);
        linearLayout3.setGravity(16);
        b1.f43t = b1.l("Gallery", 22.0f, i3, true);
        b1.f44u = new IconView(activity, "down", i3, 2.6f);
        TextView textView = b1.f43t;
        if (textView == null) {
            i.b.g("titleTv");
            throw null;
        }
        linearLayout3.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        IconView g1 = b1.f44u;
        if (g1 == null) {
            i.b.g("chev");
            throw null;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(b1.e(22), b1.e(22));
        layoutParams.leftMargin = b1.e(4);
        linearLayout3.addView(g1, layoutParams);
        linearLayout3.setOnClickListener(new ViewOnClickListenerC0058o1(b1, 7));
        linearLayout2.addView(linearLayout3, new LinearLayout.LayoutParams(-2, b1.e(48)));
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        View view = new View(activity);
        view.setBackgroundColor(b1.f33h);
        linearLayout.addView(view, new LinearLayout.LayoutParams(-1, 1));
        FrameLayout frameLayout3 = new FrameLayout(activity);
        GridView gridView = new GridView(activity);
        b1.f45v = gridView;
        gridView.setNumColumns(3);
        GridView gridView2 = b1.f45v;
        if (gridView2 == null) {
            i.b.g("grid");
            throw null;
        }
        gridView2.setHorizontalSpacing(b1.e(2));
        GridView gridView3 = b1.f45v;
        if (gridView3 == null) {
            i.b.g("grid");
            throw null;
        }
        gridView3.setVerticalSpacing(b1.e(2));
        GridView gridView4 = b1.f45v;
        if (gridView4 == null) {
            i.b.g("grid");
            throw null;
        }
        gridView4.setStretchMode(2);
        GridView gridView5 = b1.f45v;
        if (gridView5 == null) {
            i.b.g("grid");
            throw null;
        }
        gridView5.setPadding(b1.e(2), b1.e(2), b1.e(2), b1.e(90));
        GridView gridView6 = b1.f45v;
        if (gridView6 == null) {
            i.b.g("grid");
            throw null;
        }
        gridView6.setClipToPadding(false);
        GridView gridView7 = b1.f45v;
        if (gridView7 == null) {
            i.b.g("grid");
            throw null;
        }
        gridView7.setSelector(new ColorDrawable(0));
        GridView gridView8 = b1.f45v;
        if (gridView8 == null) {
            i.b.g("grid");
            throw null;
        }
        gridView8.setBackgroundColor(i2);
        GridView gridView9 = b1.f45v;
        if (gridView9 == null) {
            i.b.g("grid");
            throw null;
        }
        gridView9.setAdapter((ListAdapter) b1.J);
        GridView gridView10 = b1.f45v;
        if (gridView10 == null) {
            i.b.g("grid");
            throw null;
        }
        frameLayout3.addView(gridView10, new FrameLayout.LayoutParams(-1, -1));
        TextView l2 = b1.l("No photos or videos", 18.0f, i3, false);
        b1.C = l2;
        l2.setVisibility(8);
        TextView textView2 = b1.C;
        if (textView2 == null) {
            i.b.g("emptyTv");
            throw null;
        }
        frameLayout3.addView(textView2, new FrameLayout.LayoutParams(-2, -2, 17));
        FrameLayout frameLayout4 = new FrameLayout(activity);
        frameLayout4.setBackground(B1.h(-1));
        frameLayout4.setElevation(b1.e(6));
        frameLayout4.addView(new C0046l1(activity, "cam", -16777216, -1), new FrameLayout.LayoutParams(b1.e(30), b1.e(30), 17));
        frameLayout4.setOnClickListener(new ViewOnClickListenerC0058o1(b1, 3));
        b1.y = frameLayout4;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(b1.e(60), b1.e(60), 81);
        layoutParams2.bottomMargin = b1.e(18);
        frameLayout3.addView(frameLayout4, layoutParams2);
        LinearLayout linearLayout4 = new LinearLayout(activity);
        b1.z = linearLayout4;
        linearLayout4.setOrientation(0);
        TextView l3 = b1.l("Preview", 19.0f, i3, true);
        b1.A = l3;
        l3.setGravity(17);
        TextView textView3 = b1.A;
        if (textView3 == null) {
            i.b.g("prevBtn");
            throw null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(b1.f32g);
        gradientDrawable.setCornerRadius(b1.e(8));
        textView3.setBackground(gradientDrawable);
        TextView textView4 = b1.A;
        if (textView4 == null) {
            i.b.g("prevBtn");
            throw null;
        }
        textView4.setOnClickListener(new ViewOnClickListenerC0058o1(b1, 4));
        TextView l4 = b1.l("Send", 19.0f, -1, true);
        b1.B = l4;
        l4.setGravity(17);
        TextView textView5 = b1.B;
        if (textView5 == null) {
            i.b.g("sendBtn");
            throw null;
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-16226561);
        gradientDrawable2.setCornerRadius(b1.e(8));
        textView5.setBackground(gradientDrawable2);
        TextView textView6 = b1.B;
        if (textView6 == null) {
            i.b.g("sendBtn");
            throw null;
        }
        textView6.setOnClickListener(new ViewOnClickListenerC0058o1(b1, 5));
        LinearLayout linearLayout5 = b1.z;
        if (linearLayout5 == null) {
            i.b.g("bar");
            throw null;
        }
        TextView textView7 = b1.A;
        if (textView7 == null) {
            i.b.g("prevBtn");
            throw null;
        }
        linearLayout5.addView(textView7, new LinearLayout.LayoutParams(0, b1.e(48), 1.0f));
        LinearLayout linearLayout6 = b1.z;
        if (linearLayout6 == null) {
            i.b.g("bar");
            throw null;
        }
        TextView textView8 = b1.B;
        if (textView8 == null) {
            i.b.g("sendBtn");
            throw null;
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, b1.e(48), 1.0f);
        layoutParams3.leftMargin = b1.e(12);
        linearLayout6.addView(textView8, layoutParams3);
        LinearLayout linearLayout7 = b1.z;
        if (linearLayout7 == null) {
            i.b.g("bar");
            throw null;
        }
        linearLayout7.setVisibility(8);
        LinearLayout linearLayout8 = b1.z;
        if (linearLayout8 == null) {
            i.b.g("bar");
            throw null;
        }
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2, 80);
        layoutParams4.setMargins(b1.e(12), 0, b1.e(12), b1.e(12));
        frameLayout3.addView(linearLayout8, layoutParams4);
        ScrollView scrollView = new ScrollView(activity);
        b1.w = scrollView;
        scrollView.setBackgroundColor(i2);
        ScrollView scrollView2 = b1.w;
        if (scrollView2 == null) {
            i.b.g("menu");
            throw null;
        }
        scrollView2.setClickable(true);
        ScrollView scrollView3 = b1.w;
        if (scrollView3 == null) {
            i.b.g("menu");
            throw null;
        }
        scrollView3.setVisibility(8);
        LinearLayout linearLayout9 = new LinearLayout(activity);
        b1.x = linearLayout9;
        linearLayout9.setOrientation(1);
        ScrollView scrollView4 = b1.w;
        if (scrollView4 == null) {
            i.b.g("menu");
            throw null;
        }
        LinearLayout linearLayout10 = b1.x;
        if (linearLayout10 == null) {
            i.b.g("menuCol");
            throw null;
        }
        scrollView4.addView(linearLayout10, new FrameLayout.LayoutParams(-1, -2));
        ScrollView scrollView5 = b1.w;
        if (scrollView5 == null) {
            i.b.g("menu");
            throw null;
        }
        frameLayout3.addView(scrollView5, new FrameLayout.LayoutParams(-1, -1));
        linearLayout.addView(frameLayout3, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        FrameLayout frameLayout5 = b1.f42s;
        if (frameLayout5 == null) {
            i.b.g("top");
            throw null;
        }
        frameLayout5.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        Dialog dialog3 = b1.f41r;
        if (dialog3 == null) {
            i.b.g("dlg");
            throw null;
        }
        FrameLayout frameLayout6 = b1.f42s;
        if (frameLayout6 == null) {
            i.b.g("top");
            throw null;
        }
        dialog3.setContentView(frameLayout6);
        b1.scrollToReplyTarget(false);
        Dialog dialog4 = b1.f41r;
        if (dialog4 == null) {
            i.b.g("dlg");
            throw null;
        }
        dialog4.setOnKeyListener(new DialogInterface.OnKeyListener() { 
            @Override 
            public final boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
                if (i4 != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                B1 b12 = B1.this;
                if (b12.D != null) {
                    b12.d();
                    return true;
                }
                ScrollView scrollView6 = b12.w;
                if (scrollView6 == null) {
                    i.b.g("menu");
                    throw null;
                }
                if (scrollView6.getVisibility() == 0) {
                    b12.j(Boolean.FALSE);
                    return true;
                }
                Dialog dialog5 = b12.f41r;
                if (dialog5 != null) {
                    dialog5.dismiss();
                    return true;
                }
                i.b.g("dlg");
                throw null;
            }
        });
        Dialog dialog5 = b1.f41r;
        if (dialog5 == null) {
            i.b.g("dlg");
            throw null;
        }
        dialog5.setOnDismissListener(new DialogInterfaceOnDismissListenerC0033i0(1, b1));
        if (b1.quickReactions) {
            Dialog dialog6 = b1.f41r;
            if (dialog6 == null) {
                i.b.g("dlg");
                throw null;
            }
            Window window3 = dialog6.getWindow();
            if (window3 != null) {
                window3.addFlags(8192);
            }
        }
        Dialog dialog7 = b1.f41r;
        if (dialog7 == null) {
            i.b.g("dlg");
            throw null;
        }
        dialog7.show();
        new Thread(new TaskRunnable(5, b1)).start();
    }

    public final TextView makeText(String str, float f2, int i2, boolean z) {
        TextView textView = new TextView(this.activity);
        textView.setText(str);
        textView.setTextSize(1, f2 * 0.93f);
        textView.setTextColor(i2);
        if (z) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        return textView;
    }

    public final boolean applySyncPayload(JSONObject jSONObject) {
        Iterator it;
        JSONObject jSONObject2;
        long j2;
        long j3;
        String str;
        Object obj;
        String str2;
        boolean z;
        long j4;
        long optLong = jSONObject.optLong("lo", 0L);
        long optLong2 = jSONObject.optLong("hi", 0L);
        JSONObject optJSONObject = jSONObject.optJSONObject("r");
        JSONArray optJSONArray = jSONObject.optJSONArray("d");
        HashSet hashSet = new HashSet();
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                hashSet.add(Long.valueOf(optJSONArray.optLong(i2)));
            }
        }
        HashMap hashMap = new HashMap();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("e");
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                if (optJSONObject2 != null) {
                    hashMap.put(Long.valueOf(optJSONObject2.optLong("id")), new b.b(optJSONObject2.optString("x"), Integer.valueOf(optJSONObject2.optInt("ed"))));
                }
            }
        }
        Iterator it2 = this.messages.iterator();
        boolean ChatMedia = false;
        while (it2.hasNext()) {
            ChatMessage k0 = (ChatMessage) it2.next();
            long j5 = k0.id;
            if (j5 < optLong || (optLong2 > 0 && j5 > optLong2)) {
                it = it2;
                jSONObject2 = optJSONObject;
                j2 = optLong;
                j3 = optLong2;
            } else {
                b.b bVar = (b.b) hashMap.get(Long.valueOf(j5));
                if (bVar != null && !k0.deleted) {
                    String str3 = k0.text;
                    Object obj2 = bVar.f764a;
                    boolean a2 = i.b.a(str3, obj2);
                    Object obj3 = bVar.f765b;
                    if (!a2 || k0.status != ((Number) obj3).intValue()) {
                        k0.text = (String) obj2;
                        k0.status = ((Number) obj3).intValue();
                        ChatMedia = true;
                    }
                }
                long j6 = k0.id;
                JSONArray optJSONArray3 = optJSONObject != null ? optJSONObject.optJSONArray(String.valueOf(j6)) : null;
                ArrayList arrayList = new ArrayList();
                if (optJSONArray3 != null) {
                    int length3 = optJSONArray3.length();
                    it = it2;
                    int i4 = 0;
                    while (true) {
                        jSONObject2 = optJSONObject;
                        if (i4 >= length3) {
                            break;
                        }
                        JSONArray optJSONArray4 = optJSONArray3.optJSONArray(i4);
                        if (optJSONArray4 == null) {
                            z = ChatMedia;
                            j4 = optLong;
                        } else {
                            z = ChatMedia;
                            j4 = optLong;
                            arrayList.add(new b.b(optJSONArray4.optString(0), optJSONArray4.optString(1)));
                        }
                        i4++;
                        optJSONObject = jSONObject2;
                        ChatMedia = z;
                        optLong = j4;
                    }
                } else {
                    it = it2;
                    jSONObject2 = optJSONObject;
                }
                boolean z3 = ChatMedia;
                j2 = optLong;
                HashMap hashMap2 = this.reactionTimestamps;
                L0 l0 = (L0) hashMap2.get(Long.valueOf(j6));
                if (l0 != null) {
                    j3 = optLong2;
                    long currentTimeMillis = System.currentTimeMillis() - l0.f189b;
                    Iterator it3 = arrayList.iterator();
                    while (true) {
                        boolean hasNext = it3.hasNext();
                        str = this.username;
                        if (!hasNext) {
                            obj = null;
                            break;
                        }
                        obj = it3.next();
                        if (i.b.a(((b.b) obj).f764a, str)) {
                            break;
                        }
                    }
                    b.b bVar2 = (b.b) obj;
                    if (bVar2 == null || (str2 = (String) bVar2.f765b) == null) {
                        str2 = "";
                    }
                    String str4 = l0.f188a;
                    if (str2.equals(str4) || ((l0.f190c && currentTimeMillis > 4000) || currentTimeMillis > 25000)) {
                        hashMap2.remove(Long.valueOf(j6));
                    } else {
                        c.h.G(arrayList, new C0086x(this, 1));
                        if (str4.length() > 0) {
                            arrayList.add(new b.b(str, str4));
                        }
                    }
                } else {
                    j3 = optLong2;
                }
                HashMap hashMap3 = this.reactions;
                Object obj4 = (List) hashMap3.get(Long.valueOf(j6));
                if (obj4 == null) {
                    obj4 = c.j.f773a;
                }
                if (!arrayList.equals(obj4)) {
                    hashMap3.put(Long.valueOf(j6), arrayList);
                    z3 = true;
                }
                if (!hashSet.contains(Long.valueOf(j6)) || k0.deleted) {
                    it2 = it;
                    optJSONObject = jSONObject2;
                    ChatMedia = z3;
                    optLong = j2;
                    optLong2 = j3;
                } else {
                    k0.deleted = true;
                    k0.text = "";
                    ChatMedia = true;
                }
            }
            it2 = it;
            optJSONObject = jSONObject2;
            optLong = j2;
            optLong2 = j3;
        }
        return ChatMedia;
    }

    public final void unregisterNetworkCallback() {
        C0002a1 c0002a1 = this.networkCallback;
        if (c0002a1 == null) {
            return;
        }
        this.networkCallback = null;
        try {
            Object systemService = this.activity.getSystemService("connectivity");
            i.b.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ((ConnectivityManager) systemService).unregisterNetworkCallback(c0002a1);
        } catch (Exception unused) {
        }
    }

    public final void applyTheme(C0022f1 c0022f1) {
        EditText editText;
        if (this.messageInput == null || i.b.a(this.recordState, "idle")) {
            this.palette = c0022f1;
            String str = c0022f1.f481a;
            SharedPreferences sharedPreferences = AppState.prefs;
            if (sharedPreferences == null) {
                i.b.g("sp");
                throw null;
            }
            sharedPreferences.edit().putString("chat_theme", str).apply();
            if (this.shell == null || (editText = this.messageInput) == null) {
                return;
            }
            String obj = editText.getText().toString();
            EditText editText2 = this.messageInput;
            if (editText2 == null) {
                i.b.g("input");
                throw null;
            }
            int selectionStart = editText2.getSelectionStart();
            EditText editText3 = this.messageInput;
            if (editText3 == null) {
                i.b.g("input");
                throw null;
            }
            boolean hasFocus = editText3.hasFocus();
            I2 i2 = this.messageList;
            if (i2 == null) {
                i.b.g("lv");
                throw null;
            }
            final int firstVisiblePosition = i2.getFirstVisiblePosition();
            I2 i22 = this.messageList;
            if (i22 == null) {
                i.b.g("lv");
                throw null;
            }
            View childAt = i22.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : 0;
            final boolean z = this.stickToBottom;
            ChatMessage k0 = this.replyTarget;
            LinearLayout linearLayout = this.emojiPanel;
            if (linearLayout == null) {
                i.b.g("panel");
                throw null;
            }
            int visibility = linearLayout.getVisibility();
            FrameLayout frameLayout = this.shell;
            if (frameLayout == null) {
                i.b.g("shell");
                throw null;
            }
            frameLayout.removeAllViews();
            FrameLayout frameLayout2 = this.shell;
            if (frameLayout2 == null) {
                i.b.g("shell");
                throw null;
            }
            frameLayout2.addView(buildChatView(), new FrameLayout.LayoutParams(-1, -1));
            FrameLayout frameLayout3 = this.shell;
            if (frameLayout3 == null) {
                i.b.g("shell");
                throw null;
            }
            frameLayout3.addView(buildPanel(), new FrameLayout.LayoutParams(-1, -1));
            EditText editText4 = this.messageInput;
            if (editText4 == null) {
                i.b.g("input");
                throw null;
            }
            editText4.setText(obj);
            EditText editText5 = this.messageInput;
            if (editText5 == null) {
                i.b.g("input");
                throw null;
            }
            editText5.setSelection(AppState.c(selectionStart, editText5.length()));
            if (k0 != null) {
                setReplyTarget(k0);
            }
            EditText editText6 = this.messageInput;
            if (hasFocus) {
                if (editText6 == null) {
                    i.b.g("input");
                    throw null;
                }
                editText6.requestFocus();
            } else {
                if (editText6 == null) {
                    i.b.g("input");
                    throw null;
                }
                editText6.clearFocus();
            }
            LinearLayout linearLayout2 = this.emojiPanel;
            if (linearLayout2 == null) {
                i.b.g("panel");
                throw null;
            }
            linearLayout2.setVisibility(visibility);
            int i3 = this.connectionState;
            this.connectionState = -1;
            setConnectionState(i3);
            if (this.groupPic.length() > 0) {
                File file = ChatMedia.cacheDir;
                AvatarView a2 = this.groupPicView;
                if (a2 == null) {
                    i.b.g("headPic");
                    throw null;
                }
                ChatMedia.loadAvatar(a2, this.groupPic);
            }
            updateSendButton();
            refreshHeader();
            I2 i23 = this.messageList;
            if (i23 == null) {
                i.b.g("lv");
                throw null;
            }
            i23.post(new Runnable() { 
                @Override 
                public final void run() {
                    boolean ChatMedia = z;
                    ChatScreen chatScreen = this;
                    if (!ChatMedia) {
                        I2 i24 = chatScreen.messageList;
                        if (i24 != null) {
                            i24.setSelectionFromTop(firstVisiblePosition, top);
                            return;
                        } else {
                            i.b.g("lv");
                            throw null;
                        }
                    }
                    I2 i25 = chatScreen.messageList;
                    if (i25 == null) {
                        i.b.g("lv");
                        throw null;
                    }
                    if (chatScreen.messageAdapter != null) {
                        i25.setSelection(Math.max(r2.getCount() - 1, 0));
                    } else {
                        i.b.g("adapter");
                        throw null;
                    }
                }
            });
            ActivityRef activityRef = this.activityRef;
            if (activityRef != null) {
                int i4 = isDarkBg() ? this.palette.f486f : this.bgColor;
                boolean ChatMedia = isDarkBg() ? this.palette.q : !this.lightBars;
                int i5 = MainActivity.R;
                MainActivity mainActivity = activityRef.activity;
                mainActivity.e(0, i4, ChatMedia);
                View view = mainActivity.N;
                if (view != null) {
                    view.setBackgroundColor(i4);
                }
            }
            C0029h0 c0029h0 = this.quickReactionRefresher;
            if (c0029h0 != null) {
                c0029h0.a();
            }
        }
    }

    public final void updateSendButton() {
        EditText editText = this.messageInput;
        if (editText == null) {
            i.b.g("input");
            throw null;
        }
        boolean R = m.e.R(editText.getText().toString());
        C1 c1 = this.endGlyph;
        if (c1 == null) {
            i.b.g("endGlyph");
            throw null;
        }
        c1.set(R ? "like" : "send");
        String p0 = quickReaction();
        if (!R || p0.length() <= 0) {
            TextView textView = this.endEmojiText;
            if (textView == null) {
                i.b.g("endEmoji");
                throw null;
            }
            textView.setVisibility(8);
            C1 c12 = this.endGlyph;
            if (c12 == null) {
                i.b.g("endGlyph");
                throw null;
            }
            c12.setVisibility(0);
        } else {
            TextView textView2 = this.endEmojiText;
            if (textView2 == null) {
                i.b.g("endEmoji");
                throw null;
            }
            textView2.setText(p0);
            TextView textView3 = this.endEmojiText;
            if (textView3 == null) {
                i.b.g("endEmoji");
                throw null;
            }
            textView3.setVisibility(0);
            C1 c13 = this.endGlyph;
            if (c13 == null) {
                i.b.g("endGlyph");
                throw null;
            }
            c13.setVisibility(8);
        }
        FrameLayout frameLayout = this.imageButton;
        if (frameLayout == null) {
            i.b.g("btnImg");
            throw null;
        }
        frameLayout.setVisibility(R ? 0 : 8);
        FrameLayout frameLayout2 = this.micButton;
        if (frameLayout2 == null) {
            i.b.g("btnMic");
            throw null;
        }
        frameLayout2.setVisibility(R ? 0 : 8);
        LinearLayout linearLayout = this.inputPill;
        if (linearLayout == null) {
            i.b.g("pillRef");
            throw null;
        }
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        i.b.c(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.leftMargin = R ? 0 : dp(12);
        LinearLayout linearLayout2 = this.inputPill;
        if (linearLayout2 != null) {
            linearLayout2.setLayoutParams(layoutParams2);
        } else {
            i.b.g("pillRef");
            throw null;
        }
    }

    public final void applyThemeUpdate(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("th") || System.currentTimeMillis() - this.lastThemeSyncAt < 6000) {
            return;
        }
        String optString = jSONObject.optString("th", "");
        if (optString.length() == 0) {
            optString = "default";
        }
        if (optString.equals(this.palette.f481a)) {
            return;
        }
        applyTheme(AbstractC0026g1.a(optString));
    }

    
    
    
    public final void refreshHeader() {
        StringBuilder sb;
        String str;
        String str2;
        TextView textView;
        TextView textView2 = this.titleText;
        if (textView2 == null) {
            i.b.g("titleTv");
            throw null;
        }
        textView2.setText(this.groupName.length() == 0 ? "NixHost Group" : this.groupName);
        TextView textView3 = this.subtitleText;
        if (textView3 == null) {
            i.b.g("subTitle");
            throw null;
        }
        if (!this.typingUsers.isEmpty()) {
            String x = displayName((String) this.typingUsers.get(0));
            sb = new StringBuilder();
            sb.append(x);
            str = " is typing...";
        } else {
            if (this.members.isEmpty()) {
                str2 = "";
                textView3.setText(str2);
                boolean z = this.cacheLoaded;
                ArrayList arrayList = this.messages;
                boolean ChatMedia = !z && arrayList.isEmpty() && this.emptyStateText.length() == 0 && this.connectionState == 0;
                textView = this.emptyText;
                if (textView != null) {
                    i.b.g("emptyTv");
                    throw null;
                }
                textView.setVisibility(ChatMedia ? 0 : 8);
                if (this.emptyStateText.length() <= 0 || !arrayList.isEmpty()) {
                    TextView textView4 = this.emptyText;
                    if (textView4 == null) {
                        i.b.g("emptyTv");
                        throw null;
                    }
                    textView4.setText("No messages yet.\nSay hi to everyone 👋");
                } else {
                    TextView textView5 = this.emptyText;
                    if (textView5 == null) {
                        i.b.g("emptyTv");
                        throw null;
                    }
                    textView5.setText(this.emptyStateText);
                    TextView textView6 = this.emptyText;
                    if (textView6 == null) {
                        i.b.g("emptyTv");
                        throw null;
                    }
                    textView6.setVisibility(0);
                }
                ProgressBar progressBar = this.loadingSpinner;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                    return;
                } else {
                    i.b.g("spin");
                    throw null;
                }
            }
            int size = this.members.size();
            sb = new StringBuilder();
            sb.append(size);
            str = " members";
        }
        sb.append(str);
        str2 = sb.toString();
        textView3.setText(str2);
        boolean z3 = this.cacheLoaded;
        ArrayList arrayList2 = this.messages;
        if (z3) {
        }
        textView = this.emptyText;
        if (textView != null) {
        }
    }

    public final N2 buildChatView() {
        DisplayMetrics displayMetrics = this.activity.getResources().getDisplayMetrics();
        int i2 = (int) (displayMetrics.widthPixels * 0.5f);
        int i3 = (int) (displayMetrics.heightPixels * 0.5f);
        return new N2(this.activity, isDarkBg() ? this.palette : null, this.bgColor, i2 < 200 ? 200 : i2, i3 < 300 ? 300 : i3);
    }

    public final LinearLayout dialogColumn(Dialog dialog, String str) {
        LinearLayout P = rowLayout();
        float f2 = 9;
        P.setPadding(dp(2), dp(f2), dp(8), dp(f2));
        Activity activity = this.activity;
        FrameLayout frameLayout = new FrameLayout(activity);
        int i2 = this.textColor;
        float f3 = 26;
        frameLayout.addView(new IconView(activity, "back", i2, 2.4f), new FrameLayout.LayoutParams(dp(f3), dp(f3), 17));
        setClickAction(frameLayout, new C0060p(dialog, 4));
        float f4 = 44;
        P.addView(frameLayout, layoutParamsDefault(this, dp(f4), dp(f4), 0, 0, 0, 60));
        if (str != null) {
            P.addView(makeText(str, 21.0f, i2, true), new LinearLayout.LayoutParams(0, -2, 1.0f));
        }
        return P;
    }

    public final AvatarView avatarView(String str, float f2) {
        AvatarView a2 = new AvatarView(this.activity);
        a2.setLayoutParams(new LinearLayout.LayoutParams(dp(f2), dp(f2)));
        String str2 = (String) this.memberPics.get(str);
        if (str2 != null && str2.length() != 0) {
            ChatMedia.loadAvatar(a2, str2);
        }
        return a2;
    }

    public final LinearLayout columnLayout() {
        LinearLayout linearLayout = new LinearLayout(this.activity);
        linearLayout.setOrientation(1);
        return linearLayout;
    }

    public final E2 showBottomSheet(boolean z, h.c cVar) {
        Activity activity = this.activity;
        E2 e2 = new E2(activity);
        e2.requestWindowFeature(1);
        C0042k1 c0042k1 = new C0042k1(activity, new RefAction(0, e2));
        float ChatMedia = dp(21.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.panelColor);
        gradientDrawable.setCornerRadii(new float[]{ChatMedia, ChatMedia, ChatMedia, ChatMedia, 0.0f, 0.0f, 0.0f, 0.0f});
        c0042k1.setBackground(gradientDrawable);
        View view = new View(activity);
        view.setBackground(roundedDrawable(this.lightBars ? -10131605 : -4407100, 3.0f, 0, 0.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dp(45), dp(4));
        layoutParams.gravity = 1;
        layoutParams.topMargin = dp(10);
        layoutParams.bottomMargin = dp(6);
        c0042k1.addView(view, layoutParams);
        cVar.a(c0042k1, e2);
        c0042k1.setPadding(0, 0, 0, dp(8));
        e2.setContentView(c0042k1);
        Window window = e2.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        if (window != null) {
            window.setGravity(80);
        }
        if (window != null) {
            window.setLayout(-1, -2);
        }
        if (z && window != null) {
            window.setSoftInputMode(20);
        }
        e2.f84a = c0042k1;
        c0042k1.setTranslationY(activity.getResources().getDisplayMetrics().heightPixels);
        showDialogThemed(e2);
        c0042k1.post(new ViewAnimTask(c0042k1, 0));
        return e2;
    }

    
    
    public final void requestMediaPermission() {
        boolean isExternalStorageManager;
        if (Build.VERSION.SDK_INT >= 30) {
            isExternalStorageManager = Environment.isExternalStorageManager();
        }
        Activity activity = this.activity;
        if (activity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            this.galleryPending = true;
            activity.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 4);
            return;
        }
        showMediaPicker();
    }

    public final long uriSize(Uri uri) {
        Activity activity = this.activity;
        try {
            Cursor query = activity.getContentResolver().query(uri, new String[]{"_size"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst() && !query.isNull(0)) {
                        long j2 = query.getLong(0);
                        AppState.a(query, null);
                        return j2;
                    }
                    AppState.a(query, null);
                } finally {
                }
            }
        } catch (Exception unused) {
        }
        try {
            AssetFileDescriptor openAssetFileDescriptor = activity.getContentResolver().openAssetFileDescriptor(uri, "r");
            if (openAssetFileDescriptor == null) {
                return 0L;
            }
            try {
                long length = openAssetFileDescriptor.getLength();
                AppState.a(openAssetFileDescriptor, null);
                return length;
            } finally {
            }
        } catch (Exception unused2) {
            return 0L;
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public final View buildMessageView(ChatMessage k0, boolean z, boolean ChatMedia, boolean z3) {
        Activity activity;
        int i2;
        ArrayList arrayList;
        Activity activity2;
        int i3;
        Iterator it;
        int i4;
        int i5;
        LinearLayout linearLayout;
        boolean z4;
        boolean z5;
        boolean z6;
        int i6;
        boolean z7;
        ViewGroup viewGroup;
        int i7;
        boolean z8;
        int i8;
        boolean z9;
        TextView textView;
        boolean z10;
        int i9 = this.sendBlue;
        int i10 = z ? isDarkBg() ? this.palette.f490j : i9 : isDarkBg() ? this.palette.f492l : this.mediaPlaceholderColor;
        int i11 = this.textColor;
        int i12 = z ? -1 : isDarkBg() ? this.palette.f493m : i11;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i10);
        if (z && isDarkBg()) {
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            C0022f1 c0022f1 = this.palette;
            gradientDrawable.setColors(new int[]{c0022f1.f490j, c0022f1.f491k});
        }
        gradientDrawable.setCornerRadii(bubbleCorners(z, ChatMedia, z3, 19.0f));
        if (!k0.deleted) {
            String str = k0.type;
            int hashCode = str.hashCode();
            HashSet hashSet = this.pendingLocalIds;
            Activity activity3 = this.activity;
            List list = k0.media;
            long j2 = k0.id;
            switch (hashCode) {
                case 3321751:
                    activity = activity3;
                    if (str.equals("like")) {
                        C1 M = makeIcon("likebig", isDarkBg() ? this.palette.f491k : i9, 43);
                        ?? frameLayout = new FrameLayout(activity);
                        frameLayout.setClipChildren(false);
                        float f2 = 43;
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dp(f2), dp(f2));
                        layoutParams.rightMargin = -dp(7);
                        frameLayout.addView(M, layoutParams);
                        float f3 = 2;
                        frameLayout.setPadding(dp(4), dp(f3), 0, dp(f3));
                        textView = frameLayout;
                        break;
                    }
                    TextView textView2 = new TextView(activity);
                    textView2.setText(k0.text);
                    textView2.setMaxWidth(Math.min(dp(this.waveScale), (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.68f)));
                    textView2.setTextIsSelectable(false);
                    if (!isSingleEmoji(k0.text)) {
                        textView2.setTextSize(1, 19.065f);
                        textView2.setTextColor(i12);
                        float f4 = 14;
                        float f5 = 9;
                        textView2.setPadding(dp(f4), dp(f5), dp(f4), dp(f5));
                        textView2.setBackground(gradientDrawable);
                        textView = textView2;
                        break;
                    } else {
                        String str2 = k0.text;
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i13 = 0; i13 < length; i13++) {
                            char charAt = str2.charAt(i13);
                            if (!(Character.isWhitespace(charAt) || Character.isSpaceChar(charAt))) {
                                sb.append(charAt);
                            }
                        }
                        String sb2 = sb.toString();
                        i.b.d(sb2, "toString(...)");
                        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
                        characterInstance.setText(sb2);
                        StringBuilder sb3 = new StringBuilder();
                        int first = characterInstance.first();
                        int next = characterInstance.next();
                        int i14 = 0;
                        while (true) {
                            int i15 = next;
                            int i16 = first;
                            first = i15;
                            if (first == -1) {
                                textView2.setText(sb3.toString());
                                textView2.setTextSize(1, 46.5f);
                                textView2.setPadding(0, 0, 0, 0);
                                textView2.setTranslationX(z ? dp(4.0f) : -dp(4.0f));
                                textView = textView2;
                                break;
                            } else {
                                if (i14 > 0 && i14 % 3 == 0) {
                                    sb3.append('\n');
                                }
                                sb3.append((CharSequence) sb2, i16, first);
                                i14++;
                                next = characterInstance.next();
                            }
                        }
                    }
                    break;
                case 100313435:
                    if (str.equals("image")) {
                        boolean z11 = z || !ChatMedia;
                        boolean z12 = (z && ChatMedia) ? false : true;
                        boolean z13 = z || !z3;
                        boolean z14 = (z && z3) ? false : true;
                        ?? k1 = columnLayout();
                        int z15 = dp(166);
                        int z16 = dp(2.7f);
                        if (list.size() == 1) {
                            String str3 = (String) list.get(0);
                            ImageView Q = mediaImage(str3, cornerRadii(z11, z12, z14, z13), 1280, new ValueAction(this, str3, k1, 0), new MultiAction(this, str3, k0, 3));
                            Float f6 = (Float) ChatMedia.aspectRatios.get(str3);
                            k1.addView(Q, f6 != null ? mediaLayoutParams(f6.floatValue()) : new LinearLayout.LayoutParams(z15, dp(200)));
                        } else {
                            int i17 = (z15 - z16) / 2;
                            ArrayList arrayList2 = new ArrayList();
                            if (list.size() % 2 == 1) {
                                arrayList2.add(AppState.p(list.get(0)));
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            while (true) {
                                int i18 = i2 + 1;
                                int i19 = i17;
                                if (i18 < list.size()) {
                                    arrayList2.add(c.c.C(new String[]{list.get(i2), list.get(i18)}));
                                    i2 += 2;
                                    i17 = i19;
                                    z16 = z16;
                                } else {
                                    int i20 = z16;
                                    Iterator it2 = arrayList2.iterator();
                                    int i21 = 0;
                                    while (it2.hasNext()) {
                                        int i22 = i21 + 1;
                                        List list2 = (List) it2.next();
                                        boolean z17 = i21 == 0;
                                        boolean z18 = i21 == arrayList2.size() - 1;
                                        LinearLayout linearLayout2 = new LinearLayout(activity3);
                                        linearLayout2.setOrientation(0);
                                        ArrayList arrayList3 = arrayList2;
                                        if (list2.size() == 1) {
                                            String str4 = (String) list2.get(0);
                                            boolean z19 = z17 && z11;
                                            boolean z20 = z17 && z12;
                                            if (z18 && z14) {
                                                i7 = i21;
                                                z8 = true;
                                            } else {
                                                i7 = i21;
                                                z8 = false;
                                            }
                                            if (z18 && z13) {
                                                i8 = z15;
                                                z9 = true;
                                            } else {
                                                i8 = z15;
                                                z9 = false;
                                            }
                                            arrayList = arrayList3;
                                            int i23 = i19;
                                            it = it2;
                                            i4 = i20;
                                            i5 = i7;
                                            activity2 = activity3;
                                            i3 = i8;
                                            linearLayout2.addView(mediaImage(str4, cornerRadii(z19, z20, z8, z9), 800, null, new A0(this, list2, k0, 1)), new LinearLayout.LayoutParams(i3, i23));
                                            z5 = z11;
                                            z7 = z12;
                                            z6 = z13;
                                            viewGroup = linearLayout2;
                                            i6 = i23;
                                        } else {
                                            arrayList = arrayList3;
                                            activity2 = activity3;
                                            i3 = z15;
                                            int i24 = i19;
                                            it = it2;
                                            i4 = i20;
                                            i5 = i21;
                                            String str5 = (String) list2.get(0);
                                            boolean z21 = z17 && z11;
                                            if (z18 && z13) {
                                                linearLayout = linearLayout2;
                                                z4 = true;
                                            } else {
                                                linearLayout = linearLayout2;
                                                z4 = false;
                                            }
                                            z5 = z11;
                                            LinearLayout linearLayout3 = linearLayout;
                                            z6 = z13;
                                            i6 = i24;
                                            linearLayout3.addView(mediaImage(str5, cornerRadii(z21, false, false, z4), 480, null, new A0(this, list2, k0, 2)), new LinearLayout.LayoutParams(i6, i6));
                                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i6, i6);
                                            layoutParams2.leftMargin = i4;
                                            String str6 = (String) list2.get(1);
                                            boolean z22 = z17 && z12;
                                            z7 = z12;
                                            viewGroup = linearLayout3;
                                            viewGroup.addView(mediaImage(str6, cornerRadii(false, z22, z18 && z14, false), 480, null, new A0(this, list2, k0, 3)), layoutParams2);
                                        }
                                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i3, -2);
                                        if (i5 > 0) {
                                            layoutParams3.topMargin = i4;
                                        }
                                        k1.addView(viewGroup, layoutParams3);
                                        i20 = i4;
                                        z15 = i3;
                                        i21 = i22;
                                        z12 = z7;
                                        activity3 = activity2;
                                        arrayList2 = arrayList;
                                        z11 = z5;
                                        it2 = it;
                                        i19 = i6;
                                        z13 = z6;
                                    }
                                }
                            }
                        }
                        Activity activity4 = activity3;
                        if (hashSet.contains(Long.valueOf(j2))) {
                            ?? frameLayout2 = new FrameLayout(activity4);
                            frameLayout2.addView(k1, new FrameLayout.LayoutParams(-2, -2));
                            float f7 = 46;
                            frameLayout2.addView(new F2(activity4), new FrameLayout.LayoutParams(dp(f7), dp(f7), 17));
                            textView = frameLayout2;
                            break;
                        } else {
                            textView = k1;
                            break;
                        }
                    }
                    activity = activity3;
                    TextView textView22 = new TextView(activity);
                    textView22.setText(k0.text);
                    textView22.setMaxWidth(Math.min(dp(this.waveScale), (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.68f)));
                    textView22.setTextIsSelectable(false);
                    if (!isSingleEmoji(k0.text)) {
                    }
                    break;
                case 112202875:
                    if (str.equals("video")) {
                        boolean z23 = z || !ChatMedia;
                        boolean z24 = (z && ChatMedia) ? false : true;
                        boolean z25 = z || !z3;
                        boolean z26 = (z && z3) ? false : true;
                        String str7 = (String) c.b.I(list);
                        if (str7 == null) {
                            str7 = "";
                        }
                        String str8 = str7;
                        FrameLayout frameLayout3 = new FrameLayout(activity3);
                        ImageView Q2 = mediaImage(str8, cornerRadii(z23, z24, z26, z25), 800, new B0(this, frameLayout3, 1), new C0005b0(this, k0, 5));
                        Float f8 = (Float) ChatMedia.aspectRatios.get(str8);
                        LinearLayout.LayoutParams U0 = f8 != null ? mediaLayoutParams(f8.floatValue()) : new LinearLayout.LayoutParams(dp(166), dp(200));
                        frameLayout3.addView(Q2, new FrameLayout.LayoutParams(-1, -1));
                        if (hashSet.contains(Long.valueOf(j2))) {
                            float f9 = 46;
                            frameLayout3.addView(new F2(activity3), new FrameLayout.LayoutParams(dp(f9), dp(f9), 17));
                        } else {
                            FrameLayout frameLayout4 = new FrameLayout(activity3);
                            frameLayout4.setBackground(circleDrawable(-1290003426));
                            float f10 = 26;
                            frameLayout4.addView(makeIcon("play", -1, 26), new FrameLayout.LayoutParams(dp(f10), dp(f10), 17));
                            float f11 = 46;
                            frameLayout3.addView(frameLayout4, new FrameLayout.LayoutParams(dp(f11), dp(f11), 17));
                        }
                        int i25 = k0.duration;
                        if (i25 > 0) {
                            TextView f1 = makeText(formatDuration(i25), 16.0f, -1, false);
                            float f12 = 8;
                            float f13 = 3;
                            f1.setPadding(dp(f12), dp(f13), dp(f12), dp(f13));
                            z10 = false;
                            f1.setBackground(roundedDrawable(-870638819, 9.0f, 0, 0.0f));
                            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2, 8388693);
                            layoutParams4.setMargins(0, 0, dp(f12), dp(f12));
                            frameLayout3.addView(f1, layoutParams4);
                        } else {
                            z10 = false;
                        }
                        ?? P = rowLayout();
                        P.setClipChildren(z10);
                        P.addView(frameLayout3, U0);
                        textView = P;
                        break;
                    }
                    activity = activity3;
                    TextView textView222 = new TextView(activity);
                    textView222.setText(k0.text);
                    textView222.setMaxWidth(Math.min(dp(this.waveScale), (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.68f)));
                    textView222.setTextIsSelectable(false);
                    if (!isSingleEmoji(k0.text)) {
                    }
                    break;
                case 112386354:
                    if (str.equals("voice")) {
                        ?? P2 = rowLayout();
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        gradientDrawable2.setColor(i10);
                        gradientDrawable2.setCornerRadii(bubbleCorners(z, ChatMedia, z3, 14.5f));
                        P2.setBackground(gradientDrawable2);
                        float f14 = 9;
                        P2.setPadding(dp(13.5f), dp(f14), dp(15), dp(f14));
                        int i26 = z ? -1 : i11;
                        C1 M2 = makeIcon("play", i26, 30);
                        float f15 = 30;
                        LinearLayout.LayoutParams X = layoutParamsDefault(this, dp(f15), dp(f15), 0, 0, 0, 60);
                        X.rightMargin = dp(8.5f);
                        P2.addView(M2, X);
                        ?? p2 = new P2(activity3, dp(3.2f), dp(3.2f));
                        p2.setFg(i26);
                        ?? r0 = k0.wave;
                        if (r0.isEmpty()) {
                            r0 = new ArrayList(40);
                            for (int i27 = 0; i27 < 40; i27++) {
                                r0.add(20);
                            }
                        }
                        p2.setValues(r0);
                        P2.addView(p2, new LinearLayout.LayoutParams(dp(Math.min(143, (Math.max(0, ((k0.duration + 500) / 1000) - 8) * 3) + 113)), dp(52)));
                        LinearLayout k12 = columnLayout();
                        k12.setGravity(1);
                        k12.addView(makeText(formatDuration(k0.duration), 16.0f, i26, true), layoutParamsDefault(this, -2, -2, 0, 0, 0, 60));
                        TextView f16 = makeText(formatSpeed(this.playbackSpeed), 13.5f, i26, true);
                        f16.setGravity(17);
                        f16.setMinWidth(dp(42));
                        float f17 = 8;
                        float f18 = 3;
                        f16.setPadding(dp(f17), dp(f18), dp(f17), dp(f18));
                        f16.setBackground(roundedDrawable((16777215 & i26) | 939524096, 9.0f, 0, 0.0f));
                        f16.setVisibility(this.playingMessageId == j2 ? 0 : 8);
                        setClickAction(f16, new C0036j(this, 13));
                        k12.addView(f16, layoutParams(-2, -2, 0, 3, 0, 0));
                        P2.addView(k12, layoutParams(dp(48), -2, 8, 0, 0, 0));
                        this.playButtons.put(Long.valueOf(j2), M2);
                        this.waveViews.put(Long.valueOf(j2), p2);
                        this.speedLabels.put(Long.valueOf(j2), f16);
                        if (this.playingMessageId == j2) {
                            try {
                                MediaPlayer mediaPlayer = this.audioPlayer;
                                M2.set((mediaPlayer == null || !mediaPlayer.isPlaying()) ? "play" : "pause");
                            } catch (Exception unused) {
                            }
                        } else if (this.previewMessageId == j2) {
                            M2.set("load");
                        }
                        setClickAction(M2, new C0005b0(this, k0, 3));
                        String str9 = (String) c.b.I(list);
                        if (str9 != null && !m.m.K(str9, "L") && !isOffline()) {
                            File c2 = ChatMedia.mediaFile(str9);
                            if (!c2.exists() || c2.length() <= 0) {
                                HashSet hashSet2 = this.prefetchingIds;
                                if (hashSet2.add(str9)) {
                                    try {
                                        this.prefetchExecutor.execute(new RunnableC0032i(str9, this, 0));
                                    } catch (Exception unused2) {
                                        hashSet2.remove(str9);
                                    }
                                }
                            }
                        }
                        textView = P2;
                        break;
                    }
                    activity = activity3;
                    TextView textView2222 = new TextView(activity);
                    textView2222.setText(k0.text);
                    textView2222.setMaxWidth(Math.min(dp(this.waveScale), (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.68f)));
                    textView2222.setTextIsSelectable(false);
                    if (!isSingleEmoji(k0.text)) {
                    }
                    break;
                default:
                    activity = activity3;
                    TextView textView22222 = new TextView(activity);
                    textView22222.setText(k0.text);
                    textView22222.setMaxWidth(Math.min(dp(this.waveScale), (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.68f)));
                    textView22222.setTextIsSelectable(false);
                    if (!isSingleEmoji(k0.text)) {
                    }
                    break;
            }
        } else {
            TextView f19 = makeText(z ? "You deleted a message" : displayName(k0.sender) + " deleted a message", 20.5f, themedSubTextColor(), false);
            float f20 = 14;
            float f21 = 9;
            f19.setPadding(dp(f20), dp(f21), dp(f20), dp(f21));
            f19.setSingleLine(false);
            f19.setMaxLines(Integer.MAX_VALUE);
            f19.setEllipsize(null);
            f19.setMaxWidth(dp(28) + ((int) Math.ceil(f19.getPaint().measureText("You deleted a "))));
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setColor(isDarkBg() ? 587202559 : this.bgColor);
            gradientDrawable3.setStroke(dp(1), isDarkBg() ? themedSubTextColor() : this.dividerColor);
            gradientDrawable3.setCornerRadii(bubbleCorners(z, ChatMedia, z3, 19.0f));
            f19.setBackground(gradientDrawable3);
            textView = f19;
        }
        if (k0.deleted || isLocalMessage(k0)) {
            textView.setOnLongClickListener(new ViewOnLongClickListenerC0065q0());
        } else {
            attachLongPressMenu(textView, k0);
        }
        return textView;
    }

    public final void showMessageInfo(ChatMessage k0, String str) {
        if (hasUncachedMedia(AppState.p(str), false)) {
            return;
        }
        Activity activity = this.activity;
        Dialog dialog = new Dialog(activity, R.style.Theme.Black.NoTitleBar);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
        }
        final FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setBackgroundColor(-16777216);
        LinearLayout k1 = columnLayout();
        frameLayout.addView(k1, new FrameLayout.LayoutParams(-1, -1));
        LinearLayout P = rowLayout();
        float f2 = 8;
        P.setPadding(dp(f2), dp(f2), dp(f2), dp(f2));
        FrameLayout frameLayout2 = new FrameLayout(activity);
        float f3 = 26;
        frameLayout2.addView(new IconView(activity, "close", -1, 2.4f), new FrameLayout.LayoutParams(dp(f3), dp(f3), 17));
        setClickAction(frameLayout2, new C0060p(dialog, 0));
        float f4 = 44;
        P.addView(frameLayout2, layoutParamsDefault(this, dp(f4), dp(f4), 0, 0, 0, 60));
        P.addView(new View(activity), new LinearLayout.LayoutParams(0, 1, 1.0f));
        FrameLayout frameLayout3 = new FrameLayout(activity);
        frameLayout3.addView(makeIcon("download", -1, 26), new FrameLayout.LayoutParams(dp(f3), dp(f3), 17));
        P.addView(frameLayout3, layoutParamsDefault(this, dp(f4), dp(f4), 0, 0, 0, 60));
        k1.addView(P, new LinearLayout.LayoutParams(-1, -2));
        R2 r2 = new R2(activity);
        r2.setBackgroundColor(-16777216);
        ChatMedia.loadInto(r2, str, 1600, null);
        k1.addView(r2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        TextView f1 = makeText("", 17.0f, -1, false);
        float f5 = 16;
        f1.setPadding(dp(f5), dp(f2), dp(f5), dp(f2));
        f1.setBackground(roundedDrawable(-869651924, 20.0f, 0, 0.0f));
        f1.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 81);
        layoutParams.bottomMargin = dp(84);
        frameLayout.addView(f1, layoutParams);
        final RunnableC0064q runnableC0064q = new RunnableC0064q(f1, 0);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { 
            @Override 
            public final void onDismiss(DialogInterface dialogInterface) {
                FrameLayout frameLayout4 = frameLayout;
                ChatScreen chatScreen = ChatScreen.this;
                chatScreen.handler.removeCallbacks(runnableC0064q);
                try {
                    Object systemService = chatScreen.activity.getSystemService("input_method");
                    i.b.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                    ((InputMethodManager) systemService).hideSoftInputFromWindow(frameLayout4.getWindowToken(), 0);
                } catch (Exception unused) {
                }
            }
        });
        setClickAction(frameLayout3, new C0071s(f1, this, runnableC0064q, str, 0));
        if (k0 != null && !k0.deleted) {
            String str2 = k0.sender;
            String x = i.b.a(str2, this.username) ? "yourself" : displayName(str2);
            LinearLayout P2 = rowLayout();
            P2.setBackgroundColor(-14935010);
            float f6 = 12;
            float f7 = 10;
            P2.setPadding(dp(f6), dp(f7), dp(f2), dp(f7));
            LinearLayout P3 = rowLayout();
            P3.setBackground(roundedDrawable(-12961220, 26.0f, 0, 0.0f));
            P3.setPadding(dp(18), 0, dp(14), 0);
            EditText editText = new EditText(activity);
            editText.setBackground(null);
            editText.setHint("Reply to " + x);
            editText.setHintTextColor(-5196872);
            editText.setTextColor(-1);
            editText.setTextSize(1, 18.6f);
            editText.setPadding(0, dp(f6), 0, dp(f6));
            editText.setInputType(147457);
            editText.setMaxLines(4);
            P3.addView(editText, new LinearLayout.LayoutParams(0, -2, 1.0f));
            P2.addView(P3, new LinearLayout.LayoutParams(0, -2, 1.0f));
            FrameLayout frameLayout4 = new FrameLayout(activity);
            float f8 = 30;
            frameLayout4.addView(makeIcon("send", -1, 30), new FrameLayout.LayoutParams(dp(f8), dp(f8), 17));
            setClickAction(frameLayout4, new C0071s(editText, this, k0, dialog, 1));
            P2.addView(frameLayout4, layoutParams(dp(52), dp(48), 4, 0, 0, 0));
            k1.addView(P2, new LinearLayout.LayoutParams(-1, -2));
        }
        dialog.setContentView(frameLayout);
        showDialogThemed(dialog);
    }

    public final LinearLayout buildPanel() {
        LinearLayout k1 = columnLayout();
        LinearLayout P = rowLayout();
        float f2 = 9;
        float f3 = 8;
        P.setPadding(dp(2), dp(f2) + this.topInset, dp(f3), dp(f2));
        P.setBackgroundColor(isDarkBg() ? this.palette.f494n : 0);
        this.headerBar = P;
        Activity activity = this.activity;
        FrameLayout frameLayout = new FrameLayout(activity);
        float f4 = 26;
        frameLayout.addView(new IconView(activity, "back", titleTextColor(), 2.4f), new FrameLayout.LayoutParams(dp(f4), dp(f4), 17));
        setClickAction(frameLayout, new C0036j(this, 21));
        float f5 = 44;
        P.addView(frameLayout, layoutParamsDefault(this, dp(f5), dp(f5), 0, 0, 0, 60));
        AvatarView a2 = new AvatarView(activity);
        this.groupPicView = a2;
        float f6 = 39;
        P.addView(a2, layoutParamsDefault(this, dp(f6), dp(f6), 5, 0, 10, 32));
        LinearLayout k12 = columnLayout();
        TextView f1 = makeText("NixHost Group", 21.0f, titleTextColor(), true);
        this.titleText = f1;
        f1.setSingleLine(true);
        TextView textView = this.titleText;
        if (textView == null) {
            i.b.g("titleTv");
            throw null;
        }
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        TextView textView2 = this.titleText;
        if (textView2 == null) {
            i.b.g("titleTv");
            throw null;
        }
        k12.addView(textView2);
        TextView f12 = makeText("", 13.0f, themedSubTextColor(), false);
        this.subtitleText = f12;
        k12.addView(f12);
        P.addView(k12, new LinearLayout.LayoutParams(0, -2, 1.0f));
        FrameLayout frameLayout2 = new FrameLayout(activity);
        frameLayout2.addView(makeIcon("gear", titleTextColor(), 26), new FrameLayout.LayoutParams(dp(f4), dp(f4), 17));
        setClickAction(frameLayout2, new C0036j(this, 1));
        float f7 = 40;
        P.addView(frameLayout2, layoutParamsDefault(this, dp(f7), dp(f7), 0, 0, 0, 60));
        k1.addView(P, layoutParamsDefault(this, -1, -2, 0, 0, 0, 60));
        View view = new View(activity);
        view.setBackgroundColor(isDarkBg() ? 0 : this.bubbleAltColor);
        k1.addView(view, layoutParamsDefault(this, -1, 1, 0, 0, 0, 60));
        LinearLayout P2 = rowLayout();
        this.netBar = P2;
        P2.setGravity(17);
        LinearLayout linearLayout = this.netBar;
        if (linearLayout == null) {
            i.b.g("netBar");
            throw null;
        }
        boolean L = isDarkBg();
        int i2 = this.bgColor;
        linearLayout.setBackgroundColor(L ? this.palette.f495o : i2);
        LinearLayout linearLayout2 = this.netBar;
        if (linearLayout2 == null) {
            i.b.g("netBar");
            throw null;
        }
        float f8 = 16;
        float f9 = 10;
        linearLayout2.setPadding(dp(f8), dp(f9), dp(f8), dp(f9));
        FrameLayout frameLayout3 = new FrameLayout(activity);
        this.netIcon = frameLayout3;
        float f10 = 24;
        frameLayout3.addView(makeIcon("wifioff", themedSubTextColor(), 24), new FrameLayout.LayoutParams(dp(f10), dp(f10), 17));
        LinearLayout linearLayout3 = this.netBar;
        if (linearLayout3 == null) {
            i.b.g("netBar");
            throw null;
        }
        FrameLayout frameLayout4 = this.netIcon;
        if (frameLayout4 == null) {
            i.b.g("netIcon");
            throw null;
        }
        linearLayout3.addView(frameLayout4, layoutParamsDefault(this, dp(f10), dp(f10), 0, 0, 10, 32));
        TextView f13 = makeText("No internet connection", 19.0f, themedSubTextColor(), false);
        this.netText = f13;
        LinearLayout linearLayout4 = this.netBar;
        if (linearLayout4 == null) {
            i.b.g("netBar");
            throw null;
        }
        linearLayout4.addView(f13, layoutParamsDefault(this, -2, -2, 0, 0, 0, 60));
        LinearLayout linearLayout5 = this.netBar;
        if (linearLayout5 == null) {
            i.b.g("netBar");
            throw null;
        }
        linearLayout5.setVisibility(8);
        View view2 = this.netBar;
        if (view2 == null) {
            i.b.g("netBar");
            throw null;
        }
        k1.addView(view2, layoutParamsDefault(this, -1, -2, 0, 0, 0, 60));
        FrameLayout frameLayout5 = new FrameLayout(activity);
        I2 i22 = new I2(activity);
        this.messageList = i22;
        i22.setHook(new C0086x(this, 0));
        I2 i23 = this.messageList;
        if (i23 == null) {
            i.b.g("lv");
            throw null;
        }
        i23.setDivider(null);
        I2 i24 = this.messageList;
        if (i24 == null) {
            i.b.g("lv");
            throw null;
        }
        i24.setDividerHeight(0);
        I2 i25 = this.messageList;
        if (i25 == null) {
            i.b.g("lv");
            throw null;
        }
        i25.setSelector(new ColorDrawable(0));
        I2 i26 = this.messageList;
        if (i26 == null) {
            i.b.g("lv");
            throw null;
        }
        i26.setCacheColorHint(0);
        I2 i27 = this.messageList;
        if (i27 == null) {
            i.b.g("lv");
            throw null;
        }
        i27.setVerticalScrollBarEnabled(false);
        I2 i28 = this.messageList;
        if (i28 == null) {
            i.b.g("lv");
            throw null;
        }
        i28.setClipToPadding(false);
        I2 i29 = this.messageList;
        if (i29 == null) {
            i.b.g("lv");
            throw null;
        }
        i29.setPadding(0, dp(f3), 0, dp(f9));
        O0 o0 = new O0(0, this);
        this.messageAdapter = o0;
        I2 i210 = this.messageList;
        if (i210 == null) {
            i.b.g("lv");
            throw null;
        }
        i210.setAdapter((ListAdapter) o0);
        I2 i211 = this.messageList;
        if (i211 == null) {
            i.b.g("lv");
            throw null;
        }
        i211.setOnScrollListener(new P0(this));
        I2 i212 = this.messageList;
        if (i212 == null) {
            i.b.g("lv");
            throw null;
        }
        i212.addOnLayoutChangeListener(new LayoutTask(0, this));
        I2 i213 = this.messageList;
        if (i213 == null) {
            i.b.g("lv");
            throw null;
        }
        frameLayout5.addView(i213, new FrameLayout.LayoutParams(-1, -1));
        TextView f14 = makeText("No messages yet.\nSay hi to everyone 👋", 16.0f, themedSubTextColor(), false);
        this.emptyText = f14;
        f14.setGravity(17);
        TextView textView3 = this.emptyText;
        if (textView3 == null) {
            i.b.g("emptyTv");
            throw null;
        }
        textView3.setVisibility(8);
        TextView textView4 = this.emptyText;
        if (textView4 == null) {
            i.b.g("emptyTv");
            throw null;
        }
        frameLayout5.addView(textView4, new FrameLayout.LayoutParams(-2, -2, 17));
        ProgressBar progressBar = new ProgressBar(activity);
        this.loadingSpinner = progressBar;
        float f11 = 30;
        frameLayout5.addView(progressBar, new FrameLayout.LayoutParams(dp(f11), dp(f11), 17));
        k1.addView(frameLayout5, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        TextView f15 = makeText("", 13.0f, themedSubTextColor(), false);
        this.statusText = f15;
        float f16 = 4;
        f15.setPadding(dp(f8), dp(f16), dp(f8), dp(f16));
        TextView textView5 = this.statusText;
        if (textView5 == null) {
            i.b.g("statusTv");
            throw null;
        }
        textView5.setVisibility(8);
        View view3 = this.statusText;
        if (view3 == null) {
            i.b.g("statusTv");
            throw null;
        }
        k1.addView(view3, layoutParamsDefault(this, -1, -2, 0, 0, 0, 60));
        LinearLayout P3 = rowLayout();
        this.replyBar = P3;
        P3.setBackgroundColor(isDarkBg() ? this.palette.f495o : i2);
        LinearLayout linearLayout6 = this.replyBar;
        if (linearLayout6 == null) {
            i.b.g("replyBar");
            throw null;
        }
        linearLayout6.setPadding(dp(f8), dp(f2), dp(12), dp(f2));
        LinearLayout k13 = columnLayout();
        this.replyWhoText = makeText("", 18.0f, titleTextColor(), false);
        TextView f17 = makeText("", 16.0f, themedSubTextColor(), false);
        this.replyText = f17;
        f17.setSingleLine(true);
        TextView textView6 = this.replyText;
        if (textView6 == null) {
            i.b.g("replyTxt");
            throw null;
        }
        textView6.setEllipsize(truncateAt);
        TextView textView7 = this.replyWhoText;
        if (textView7 == null) {
            i.b.g("replyWho");
            throw null;
        }
        k13.addView(textView7);
        TextView textView8 = this.replyText;
        if (textView8 == null) {
            i.b.g("replyTxt");
            throw null;
        }
        k13.addView(textView8);
        LinearLayout linearLayout7 = this.replyBar;
        if (linearLayout7 == null) {
            i.b.g("replyBar");
            throw null;
        }
        linearLayout7.addView(k13, new LinearLayout.LayoutParams(0, -2, 1.0f));
        FrameLayout frameLayout6 = new FrameLayout(activity);
        float f18 = 18;
        frameLayout6.addView(new IconView(activity, "close", themedSubTextColor(), 2.2f), new FrameLayout.LayoutParams(dp(f18), dp(f18), 17));
        setClickAction(frameLayout6, new C0036j(this, 2));
        LinearLayout linearLayout8 = this.replyBar;
        if (linearLayout8 == null) {
            i.b.g("replyBar");
            throw null;
        }
        float f19 = 34;
        linearLayout8.addView(frameLayout6, layoutParamsDefault(this, dp(f19), dp(f19), 0, 0, 0, 60));
        LinearLayout linearLayout9 = this.replyBar;
        if (linearLayout9 == null) {
            i.b.g("replyBar");
            throw null;
        }
        linearLayout9.setVisibility(8);
        View view4 = new View(activity);
        this.replyTopLine = view4;
        boolean L2 = isDarkBg();
        int i3 = this.reactions;
        view4.setBackgroundColor(L2 ? 0 : i3);
        View view5 = this.replyTopLine;
        if (view5 == null) {
            i.b.g("replyTop");
            throw null;
        }
        view5.setVisibility(8);
        View view6 = this.replyTopLine;
        if (view6 == null) {
            i.b.g("replyTop");
            throw null;
        }
        k1.addView(view6, layoutParamsDefault(this, -1, 1, 0, 0, 0, 60));
        View view7 = this.replyBar;
        if (view7 == null) {
            i.b.g("replyBar");
            throw null;
        }
        k1.addView(view7, layoutParamsDefault(this, -1, -2, 0, 0, 0, 60));
        View view8 = new View(activity);
        if (isDarkBg()) {
            i3 = 0;
        }
        view8.setBackgroundColor(i3);
        k1.addView(view8, layoutParamsDefault(this, -1, 1, 0, 0, 0, 60));
        FrameLayout frameLayout7 = new FrameLayout(activity);
        this.inputHolder = frameLayout7;
        frameLayout7.setBackgroundColor(isDarkBg() ? this.palette.f495o : 0);
        LinearLayout P4 = rowLayout();
        P4.setPadding(0, dp(f2), dp(5), dp(f3));
        FrameLayout frameLayout8 = new FrameLayout(activity);
        frameLayout8.addView(makeIcon("image", headerBgColor(), 30), new FrameLayout.LayoutParams(dp(f11), dp(f11), 17));
        setClickAction(frameLayout8, new C0036j(this, 7));
        this.imageButton = frameLayout8;
        float f20 = 46;
        P4.addView(frameLayout8, layoutParamsDefault(this, dp(f20), dp(f20), 0, 0, 0, 60));
        FrameLayout frameLayout9 = new FrameLayout(activity);
        frameLayout9.addView(makeIcon("mic", headerBgColor(), 30), new FrameLayout.LayoutParams(dp(f11), dp(f11), 17));
        setClickAction(frameLayout9, new C0036j(this, 8));
        this.micButton = frameLayout9;
        P4.addView(frameLayout9, layoutParamsDefault(this, dp(f20), dp(f20), 0, 0, 0, 60));
        LinearLayout P5 = rowLayout();
        P5.setBackground(roundedDrawable(isDarkBg() ? this.palette.p : this.faceBaseColor, 24.0f, 0, 0.0f));
        P5.setPadding(dp(19), 0, dp(1), 0);
        P5.setMinimumHeight(dp(47));
        this.inputPill = P5;
        EditText editText = new EditText(activity);
        this.messageInput = editText;
        editText.setBackground(null);
        EditText editText2 = this.messageInput;
        if (editText2 == null) {
            i.b.g("input");
            throw null;
        }
        editText2.setHint("Message");
        EditText editText3 = this.messageInput;
        if (editText3 == null) {
            i.b.g("input");
            throw null;
        }
        editText3.setHintTextColor(themedSubTextColor());
        EditText editText4 = this.messageInput;
        if (editText4 == null) {
            i.b.g("input");
            throw null;
        }
        editText4.setTextColor(titleTextColor());
        EditText editText5 = this.messageInput;
        if (editText5 == null) {
            i.b.g("input");
            throw null;
        }
        editText5.setTextSize(1, 19.251001f);
        EditText editText6 = this.messageInput;
        if (editText6 == null) {
            i.b.g("input");
            throw null;
        }
        editText6.setPadding(0, dp(f9), 0, dp(f9));
        EditText editText7 = this.messageInput;
        if (editText7 == null) {
            i.b.g("input");
            throw null;
        }
        editText7.setInputType(147457);
        EditText editText8 = this.messageInput;
        if (editText8 == null) {
            i.b.g("input");
            throw null;
        }
        editText8.setMaxLines(5);
        EditText editText9 = this.messageInput;
        if (editText9 == null) {
            i.b.g("input");
            throw null;
        }
        editText9.setOnClickListener(new ViewOnClickListenerC0074t(3, this));
        EditText editText10 = this.messageInput;
        if (editText10 == null) {
            i.b.g("input");
            throw null;
        }
        editText10.setOnFocusChangeListener(new View.OnFocusChangeListener() { 
            @Override 
            public final void onFocusChange(View view9, boolean z) {
                if (z) {
                    LinearLayout linearLayout10 = ChatScreen.this.emojiPanel;
                    if (linearLayout10 != null) {
                        linearLayout10.setVisibility(8);
                    } else {
                        i.b.g("panel");
                        throw null;
                    }
                }
            }
        });
        EditText editText11 = this.messageInput;
        if (editText11 == null) {
            i.b.g("input");
            throw null;
        }
        editText11.addTextChangedListener(new SharedTextWatcher(0, this));
        EditText editText12 = this.messageInput;
        if (editText12 == null) {
            i.b.g("input");
            throw null;
        }
        P5.addView(editText12, new LinearLayout.LayoutParams(0, -2, 1.0f));
        FrameLayout frameLayout10 = new FrameLayout(activity);
        frameLayout10.addView(makeIcon("face", headerBgColor(), 30), new FrameLayout.LayoutParams(dp(f11), dp(f11), 17));
        setClickAction(frameLayout10, new C0036j(this, 9));
        float f21 = 38;
        P5.addView(frameLayout10, layoutParamsDefault(this, dp(f21), dp(f21), 0, 0, 0, 60));
        LinearLayout.LayoutParams X = layoutParamsDefault(this, 0, -2, 0, 0, 0, 60);
        X.weight = 1.0f;
        P4.addView(P5, X);
        this.endButton = new FrameLayout(activity);
        C1 M = makeIcon("like", headerBgColor(), 30);
        this.endGlyph = M;
        FrameLayout frameLayout11 = this.endButton;
        if (frameLayout11 == null) {
            i.b.g("btnEnd");
            throw null;
        }
        frameLayout11.addView(M, new FrameLayout.LayoutParams(dp(f11), dp(f11), 17));
        TextView textView9 = new TextView(activity);
        this.endEmojiText = textView9;
        textView9.setTextSize(1, 25.11f);
        TextView textView10 = this.endEmojiText;
        if (textView10 == null) {
            i.b.g("endEmoji");
            throw null;
        }
        textView10.setGravity(17);
        TextView textView11 = this.endEmojiText;
        if (textView11 == null) {
            i.b.g("endEmoji");
            throw null;
        }
        textView11.setVisibility(8);
        FrameLayout frameLayout12 = this.endButton;
        if (frameLayout12 == null) {
            i.b.g("btnEnd");
            throw null;
        }
        TextView textView12 = this.endEmojiText;
        if (textView12 == null) {
            i.b.g("endEmoji");
            throw null;
        }
        frameLayout12.addView(textView12, new FrameLayout.LayoutParams(dp(f7), dp(f7), 17));
        FrameLayout frameLayout13 = this.endButton;
        if (frameLayout13 == null) {
            i.b.g("btnEnd");
            throw null;
        }
        setClickAction(frameLayout13, new C0036j(this, 10));
        View view9 = this.endButton;
        if (view9 == null) {
            i.b.g("btnEnd");
            throw null;
        }
        P4.addView(view9, layoutParamsDefault(this, dp(f20), dp(f20), 0, 0, 0, 60));
        this.idleInputView = P4;
        FrameLayout frameLayout14 = this.inputHolder;
        if (frameLayout14 == null) {
            i.b.g("holder");
            throw null;
        }
        frameLayout14.addView(P4, new FrameLayout.LayoutParams(-1, -2));
        View view10 = this.inputHolder;
        if (view10 == null) {
            i.b.g("holder");
            throw null;
        }
        k1.addView(view10, layoutParamsDefault(this, -1, -2, 0, 0, 0, 60));
        LinearLayout o2 = buildComposerRow(new C0086x(this, 2), new C0036j(this, 3));
        this.emojiPanel = o2;
        o2.setVisibility(8);
        View view11 = this.emojiPanel;
        if (view11 == null) {
            i.b.g("panel");
            throw null;
        }
        k1.addView(view11, layoutParamsDefault(this, -1, dp(300), 0, 0, 0, 60));
        updateSendButton();
        refreshHeader();
        return k1;
    }

    public final LinearLayout buildComposerRow(C0086x c0086x, C0036j c0036j) {
        LinearLayout k1 = columnLayout();
        int i2 = this.bgColor;
        k1.setBackgroundColor(i2);
        LinearLayout P = rowLayout();
        P.setGravity(17);
        boolean z = this.lightBars;
        P.setBackgroundColor(z ? -14934754 : -1249551);
        float f2 = 8;
        P.setPadding(0, dp(f2), 0, dp(f2));
        Activity activity = this.activity;
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setBackground(roundedDrawable(z ? -12960964 : -2894117, 22.0f, 0, 0.0f));
        int i3 = this.textColor;
        C1 M = makeIcon("smile", i3, 26);
        M.setCut(z ? -12960964 : -2894117);
        float f3 = 26;
        frameLayout.addView(M, new FrameLayout.LayoutParams(dp(f3), dp(f3), 17));
        float f4 = 86;
        float f5 = 44;
        P.addView(frameLayout, layoutParamsDefault(this, dp(f4), dp(f5), 0, 0, 30, 32));
        FrameLayout frameLayout2 = new FrameLayout(activity);
        int i4 = this.subTextColor;
        frameLayout2.addView(makeIcon("sticker", i4, 26), new FrameLayout.LayoutParams(dp(f3), dp(f3), 17));
        setClickAction(frameLayout2, new C0036j(this, 11));
        P.addView(frameLayout2, layoutParamsDefault(this, dp(f4), dp(f5), 0, 0, 30, 32));
        FrameLayout frameLayout3 = new FrameLayout(activity);
        frameLayout3.addView(makeIcon("gif", i4, 26), new FrameLayout.LayoutParams(dp(f3), dp(f3), 17));
        setClickAction(frameLayout3, new C0036j(this, 12));
        P.addView(frameLayout3, layoutParamsDefault(this, dp(f4), dp(f5), 0, 0, 0, 60));
        k1.addView(P, layoutParamsDefault(this, -1, -2, 0, 0, 0, 60));
        FrameLayout frameLayout4 = new FrameLayout(activity);
        List C = emojiCatalog();
        ListView listView = new ListView(activity);
        listView.setDivider(null);
        listView.setDividerHeight(0);
        listView.setSelector(new ColorDrawable(0));
        listView.setVerticalScrollBarEnabled(false);
        listView.setClipToPadding(false);
        listView.setPadding(dp(f2), 0, dp(f2), dp(64));
        listView.setAdapter((ListAdapter) new Q0(C, this, c0086x));
        frameLayout4.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout5 = new FrameLayout(activity);
        frameLayout5.setBackground(circleDrawable(i2));
        frameLayout5.addView(makeIcon("backspace", i3, 34), new FrameLayout.LayoutParams(dp(40), dp(34), 17));
        setClickAction(frameLayout5, new C0057o0(c0036j, 0));
        float f6 = 52;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dp(f6), dp(f6), 8388693);
        layoutParams.setMargins(0, 0, dp(10), dp(f2));
        frameLayout4.addView(frameLayout5, layoutParams);
        k1.addView(frameLayout4, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        return k1;
    }

    public final TextView nameText(String str, boolean z, C0022f1 c0022f1) {
        TextView f1 = makeText(str, 18.0f, z ? -1 : c0022f1.f484d ? this.textColor : c0022f1.f493m, false);
        f1.setPadding(dp(16.0f), dp(11.0f), dp(16.0f), dp(11.0f));
        f1.setMaxWidth(dp(270.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dp(20.0f));
        if (!z || c0022f1.f484d) {
            gradientDrawable.setColor(z ? this.sendBlue : c0022f1.f484d ? this.mediaPlaceholderColor : c0022f1.f492l);
        } else {
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(new int[]{c0022f1.f490j, c0022f1.f491k});
        }
        f1.setBackground(gradientDrawable);
        return f1;
    }

    public final void resetPlayIcon() {
        long j2 = this.previewMessageId;
        if (j2 != Long.MIN_VALUE) {
            C1 c1 = (C1) this.playButtons.get(Long.valueOf(j2));
            if (c1 != null) {
                c1.set("play");
            }
            this.previewMessageId = Long.MIN_VALUE;
        }
    }

    public final void cancelRecording() {
        if (i.b.a(this.recordState, "rec")) {
            try {
                MediaRecorder mediaRecorder = this.mediaRecorder;
                if (mediaRecorder != null) {
                    mediaRecorder.stop();
                }
            } catch (Exception unused) {
            }
            try {
                MediaRecorder mediaRecorder2 = this.mediaRecorder;
                if (mediaRecorder2 != null) {
                    mediaRecorder2.release();
                }
            } catch (Exception unused2) {
            }
            this.mediaRecorder = null;
            File file = this.recordTempFile;
            if (file != null) {
                file.delete();
            }
            this.recordTempFile = null;
        }
        stopPlayback();
        File file2 = this.recordFile;
        if (file2 != null) {
            file2.delete();
        }
        this.recordFile = null;
        this.recordState = "idle";
        showIdleInput();
    }

    public final LinearLayout.LayoutParams videoLayoutParams(float f2) {
        int z = (int) (dp(r0) * f2);
        int ChatMedia = dp(132);
        float f3 = 130;
        if (z > dp(f3)) {
            z = dp(f3);
            ChatMedia = (int) (z / f2);
        }
        float f4 = 64;
        if (z < dp(f4)) {
            z = dp(f4);
        }
        float f5 = 60;
        if (ChatMedia < dp(f5)) {
            ChatMedia = dp(f5);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(z, ChatMedia);
        layoutParams.setMargins(0, 0, 0, -dp(6));
        return layoutParams;
    }

    public final FrameLayout iconBadge(int i2, String str) {
        FrameLayout frameLayout = new FrameLayout(this.activity);
        int i3 = this.chipColor;
        frameLayout.setBackground(circleDrawable(i3));
        C1 M = makeIcon(str, i2, 21);
        if (str.equals("themes")) {
            M.setCut(i3);
        }
        float f2 = 21;
        frameLayout.addView(M, new FrameLayout.LayoutParams(dp(f2), dp(f2), 17));
        return frameLayout;
    }

    public final String clearMarkerKey() {
        return "chatclear_" + this.username;
    }

    public final float[] bubbleCorners(boolean z, boolean ChatMedia, boolean z3, float f2) {
        float z4 = dp(f2);
        float z5 = dp(5.0f);
        float f3 = (z || !ChatMedia) ? z4 : z5;
        float f4 = (z || !z3) ? z4 : z5;
        float f5 = (z && ChatMedia) ? z5 : z4;
        if (z && z3) {
            z4 = z5;
        }
        return new float[]{f3, f3, f5, f5, z4, z4, f4, f4};
    }

    public final void destroy() {
        if (!m.m.F(this.username, this.groupId)) {
            this.activity.getWindow().clearFlags(8192);
        }
        saveCache();
        this.active = false;
        AppState.chatForeground = false;
        unregisterNetworkCallback();
        this.handler.removeCallbacksAndMessages(null);
        stopPlayback();
        if (i.b.a(this.recordState, "rec")) {
            try {
                MediaRecorder mediaRecorder = this.mediaRecorder;
                if (mediaRecorder != null) {
                    mediaRecorder.stop();
                }
            } catch (Exception unused) {
            }
        }
        try {
            MediaRecorder mediaRecorder2 = this.mediaRecorder;
            if (mediaRecorder2 != null) {
                mediaRecorder2.release();
            }
        } catch (Exception unused2) {
        }
        this.mediaRecorder = null;
        File file = this.recordTempFile;
        if (file != null) {
            file.delete();
        }
        this.recordTempFile = null;
    }

    public final void setReaction(ChatMessage k0, String str) {
        String str2;
        if (str.length() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            SharedPreferences sharedPreferences = AppState.prefs;
            if (sharedPreferences == null) {
                i.b.g("sp");
                throw null;
            }
            String string = sharedPreferences.getString("recent_emoji", "");
            for (String str3 : m.e.b0(string != null ? string : "", new String[]{" "})) {
                if (str3.length() > 0 && !str3.equals(str)) {
                    arrayList.add(str3);
                }
            }
            String L = c.b.L(c.b.P(arrayList, 15), " ", null, null, null, 62);
            SharedPreferences sharedPreferences2 = AppState.prefs;
            if (sharedPreferences2 == null) {
                i.b.g("sp");
                throw null;
            }
            sharedPreferences2.edit().putString("recent_emoji", L).apply();
        }
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = this.reactions;
        List list = (List) hashMap.get(Long.valueOf(k0.id));
        if (list == null) {
            list = c.j.f773a;
        }
        Iterator it = list.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            str2 = this.username;
            if (!hasNext) {
                break;
            }
            b.b bVar = (b.b) it.next();
            if (!i.b.a(bVar.f764a, str2)) {
                arrayList2.add(bVar);
            }
        }
        if (str.length() > 0) {
            arrayList2.add(new b.b(str2, str));
        }
        long j2 = k0.id;
        hashMap.put(Long.valueOf(j2), arrayList2);
        L0 l0 = new L0(str, System.currentTimeMillis());
        this.reactionTimestamps.put(Long.valueOf(j2), l0);
        applyScroll(false);
        new Thread(new K((Object) k0, str, (Object) this, (Object) l0, 0)).start();
    }

    public final void showConfirmDialog(String str, String str2, String str3, String str4, final h.a aVar) {
        Button button;
        boolean z = this.lightBars;
        AlertDialog.Builder builder = new AlertDialog.Builder(this.activity, z ? R.style.Theme.DeviceDefault.Dialog.Alert : R.style.Theme.DeviceDefault.Light.Dialog.Alert);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setNegativeButton(str3, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(str4, new DialogInterface.OnClickListener() { 
            @Override 
            public final void onClick(DialogInterface dialogInterface, int i2) {
                h.a.this.addLocalMediaMessage();
            }
        });
        AlertDialog create = builder.create();
        showDialogThemed(create);
        Button button2 = create.getButton(-1);
        if (button2 != null) {
            button2.setTextColor(-13793025);
        }
        if (!z || (button = create.getButton(-2)) == null) {
            return;
        }
        button.setTextColor(-1);
    }

    public final void showReactionPicker(boolean z, h.b bVar) {
        Activity activity = this.activity;
        Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(1);
        ArrayList arrayList = new ArrayList();
        Object obj = new Object();
        if (z) {
            arrayList.add("Like");
            arrayList.add(obj);
        }
        addEmojiSection(arrayList, "Your reactions", this.quickReactions);
        SharedPreferences sharedPreferences = AppState.prefs;
        if (sharedPreferences == null) {
            i.b.g("sp");
            throw null;
        }
        String str = "";
        String string = sharedPreferences.getString("recent_emoji", "");
        if (string == null) {
            string = "";
        }
        List b0 = m.e.b0(string, new String[]{" "});
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : b0) {
            if (((String) obj2).length() > 0) {
                arrayList2.add(obj2);
            }
        }
        addEmojiSection(arrayList, "Recent", arrayList2);
        ArrayList arrayList3 = new ArrayList();
        Iterator it = ((ArrayList) emojiCatalog()).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof String) {
                addEmojiSection(arrayList, str, arrayList3);
                str = (String) next;
                arrayList3 = new ArrayList();
            } else {
                i.b.c(next, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                arrayList3.addAll((List) next);
            }
        }
        addEmojiSection(arrayList, str, arrayList3);
        ListView listView = new ListView(activity);
        listView.setDivider(null);
        listView.setDividerHeight(0);
        listView.setSelector(new ColorDrawable(0));
        listView.setVerticalScrollBarEnabled(false);
        listView.setOverScrollMode(2);
        listView.setPadding(0, 0, 0, dp(24));
        listView.setClipToPadding(false);
        listView.setAdapter((ListAdapter) new Y0(arrayList, obj, this, dialog, bVar));
        LinearLayout k1 = columnLayout();
        FrameLayout frameLayout = new FrameLayout(activity);
        View view = new View(activity);
        view.setBackground(roundedDrawable(this.lightBars ? -10789278 : -3881012, 3.0f, 0, 0.0f));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dp(46.0f), dp(4.0f), 1);
        layoutParams.topMargin = dp(13.0f);
        frameLayout.addView(view, layoutParams);
        k1.addView(frameLayout, layoutParamsDefault(this, -1, dp(24.0f), 0, 0, 0, 60));
        k1.addView(listView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        D2 d2 = new D2(activity, listView, new C0060p(dialog, 2));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.bgColor);
        float ChatMedia = dp(21.0f);
        gradientDrawable.setCornerRadii(new float[]{ChatMedia, ChatMedia, ChatMedia, ChatMedia, 0.0f, 0.0f, 0.0f, 0.0f});
        d2.setBackground(gradientDrawable);
        d2.setClipToOutline(true);
        d2.setOutlineProvider(new Z0(ChatMedia, 0));
        d2.addView(k1, new FrameLayout.LayoutParams(-1, -1));
        dialog.setContentView(d2);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        if (window != null) {
            window.setGravity(80);
        }
        int i2 = activity.getResources().getDisplayMetrics().heightPixels;
        if (window != null) {
            window.setLayout(-1, i2 - dp(38.0f));
        }
        d2.setTranslationY(i2);
        showDialogThemed(dialog);
        d2.post(new L(d2, 0));
    }

    public final float[] cornerRadii(boolean z, boolean ChatMedia, boolean z3, boolean z4) {
        float z5 = dp(19.0f);
        float z6 = dp(5.0f);
        float f2 = z ? z5 : z6;
        float f3 = ChatMedia ? z5 : z6;
        float f4 = z3 ? z5 : z6;
        if (!z4) {
            z5 = z6;
        }
        return new float[]{f2, f2, f3, f3, f4, f4, z5, z5};
    }

    public final void refreshMessages() {
        HashMap hashMap = this.seenByMessage;
        hashMap.clear();
        this.myLastMessageId = 0L;
        ArrayList arrayList = this.messages;
        int size = arrayList.size() - 1;
        String str = this.username;
        if (size >= 0) {
            while (true) {
                int i2 = size - 1;
                ChatMessage k0 = (ChatMessage) arrayList.get(size);
                if (i.b.a(k0.sender, str) && !k0.deleted && !i.b.a(k0.type, "sys")) {
                    this.myLastMessageId = k0.id;
                    break;
                } else if (i2 < 0) {
                    break;
                } else {
                    size = i2;
                }
            }
        }
        int size2 = arrayList.size() - 1;
        if (size2 >= 0) {
            while (true) {
                int i3 = size2 - 1;
                ChatMessage k02 = (ChatMessage) arrayList.get(size2);
                if (!(i.b.a(k02.sender, str) || k02.deleted || i.b.a(k02.type, "sys")) || i3 < 0) {
                    break;
                } else {
                    size2 = i3;
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        HashMap hashMap2 = new HashMap();
        for (Map.Entry entry : this.lastSeen.entrySet()) {
            String str2 = (String) entry.getKey();
            long longValue = ((Number) entry.getValue()).longValue();
            if (!i.b.a(str2, str) && longValue > 0) {
                int size3 = arrayList.size() - 1;
                while (size3 >= 0 && ((ChatMessage) arrayList.get(size3)).id > longValue) {
                    size3--;
                }
                if (size3 >= 0) {
                    Long valueOf = Long.valueOf(((ChatMessage) arrayList.get(size3)).id);
                    Object obj = hashMap2.get(valueOf);
                    if (obj == null) {
                        obj = new ArrayList();
                        hashMap2.put(valueOf, obj);
                    }
                    ((ArrayList) obj).add(str2);
                }
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            hashMap.put(Long.valueOf(((Number) entry2.getKey()).longValue()), (ArrayList) entry2.getValue());
        }
    }

    public final String displayName(String str) {
        String str2 = (String) this.displayNames.get(str);
        return str2 == null ? str : str2;
    }

    
    
    
    public final void applyScroll(boolean z) {
        boolean ChatMedia;
        O0 o0;
        if (!z) {
            I2 i2 = this.messageList;
            if (i2 == null) {
                i.b.g("lv");
                throw null;
            }
            int lastVisiblePosition = i2.getLastVisiblePosition();
            O0 o02 = this.messageAdapter;
            if (o02 == null) {
                i.b.g("adapter");
                throw null;
            }
            if (lastVisiblePosition < o02.getCount() - 1) {
                ChatMedia = false;
                o0 = this.messageAdapter;
                if (o0 != null) {
                    i.b.g("adapter");
                    throw null;
                }
                o0.notifyDataSetChanged();
                if (ChatMedia) {
                    O0 o03 = this.messageAdapter;
                    if (o03 == null) {
                        i.b.g("adapter");
                        throw null;
                    }
                    if (o03.getCount() > 0) {
                        this.stickToBottom = true;
                        I2 i22 = this.messageList;
                        if (i22 == null) {
                            i.b.g("lv");
                            throw null;
                        }
                        O0 o04 = this.messageAdapter;
                        if (o04 == null) {
                            i.b.g("adapter");
                            throw null;
                        }
                        i22.setSelection(o04.getCount() - 1);
                        I2 i23 = this.messageList;
                        if (i23 == null) {
                            i.b.g("lv");
                            throw null;
                        }
                        i23.post(new RunnableC0048m(this, 11));
                    }
                }
                refreshHeader();
                return;
            }
        }
        ChatMedia = true;
        o0 = this.messageAdapter;
        if (o0 != null) {
        }
    }

    public final View dividerView() {
        View view = new View(this.activity);
        view.setBackgroundColor(this.dividerColor);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        return view;
    }

    public final void startSync() {
        if (this.networkCallback != null) {
            return;
        }
        if (!isOnline()) {
            setConnectionState(1);
        }
        try {
            Object systemService = this.activity.getSystemService("connectivity");
            i.b.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            C0002a1 c0002a1 = new C0002a1(this);
            ((ConnectivityManager) systemService).registerDefaultNetworkCallback(c0002a1);
            this.networkCallback = c0002a1;
        } catch (Exception unused) {
        }
    }

    public final int dp(float f2) {
        return (int) (f2 * this.activity.getResources().getDisplayMetrics().density * 0.93f);
    }

    public final void markFailed(long j2) {
        this.pendingLocalIds.remove(Long.valueOf(j2));
        c.h.G(this.messages, new IdPredicate(j2, 2));
        refreshMessages();
        applyScroll(false);
    }
}
