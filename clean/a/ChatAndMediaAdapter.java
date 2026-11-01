package a;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class ChatAndMediaAdapter extends BaseAdapter {

    public final int mode;

    public final Object owner;

    public ChatAndMediaAdapter(int i2, Object obj) {
        this.mode = i2;
        this.owner = obj;
    }

    @Override
    public final int getCount() {
        switch (this.mode) {
            case 0:
                return ((ChatScreen) this.owner).messages.size();
            default:
                return ((MediaPicker) this.owner).filteredMedia.size();
        }
    }

    @Override
    public final Object getItem(int i2) {
        switch (this.mode) {
            case 0:
                return ((ChatScreen) this.owner).messages.get(i2);
            default:
                return ((MediaPicker) this.owner).filteredMedia.get(i2);
        }
    }

    @Override
    public final long getItemId(int i2) {
        switch (this.mode) {
            case 0:
                return ((ChatMessage) ((ChatScreen) this.owner).messages.get(i2)).id;
            default:
                return i2;
        }
    }

    @Override

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        ChatMessage k0;
        ArrayList arrayList;
        String str;
        String str2;
        ChatMessage k02;
        float f2;
        ViewGroup viewGroup3;
        ChatMessage k03;
        ViewGroup viewGroup4;
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        LinearLayout P;
        List list;
        String str3;
        int i4;
        int i5;
        View view2;
        ArrayList arrayList2;
        Iterator it;
        boolean z5;
        String str4;
        FrameLayout frameLayout;
        String str5;
        Object obj;
        String str6;
        Object obj2 = this.owner;
        switch (this.mode) {
            case 0:
                ChatScreen chatScreen = (ChatScreen) obj2;
                ArrayList arrayList3 = chatScreen.messages;
                ChatMessage k04 = (ChatMessage) arrayList3.get(i2);
                boolean a2 = i.b.a(k04.type, "sys");
                String str7 = chatScreen.username;
                Activity activity = chatScreen.activity;
                String str8 = k04.sender;
                if (a2) {
                    List b0 = m.e.b0(k04.text, new String[]{"|"});
                    LinearLayout k1 = chatScreen.columnLayout();
                    float f3 = 28;
                    float f4 = 14;
                    k1.setPadding(chatScreen.dp(f3), chatScreen.dp(f4), chatScreen.dp(f3), chatScreen.dp(f4));
                    List b02 = m.e.b0(k04.text, new String[]{"|"});
                    String x = i.b.a(str8, str7) ? "You" : chatScreen.displayName(str8);
                    String str9 = (String) c.b.J(b02, 0);
                    if (i.b.a(str9, "theme")) {
                        List list2 = ChatThemeCatalog.themes;
                        str6 = x + " changed the chat theme to " + ChatThemeCatalog.byId((String) (1 < b02.size() ? b02.get(1) : "")).displayName;
                    } else if (i.b.a(str9, "name")) {
                        String str10 = (String) (1 < b02.size() ? b02.get(1) : chatScreen.displayName(str8));
                        String str11 = (String) (2 < b02.size() ? b02.get(2) : "");
                        str6 = i.b.a(str8, str7) ? StringPlus.stringPlus("You changed your name to ", str11) : str10 + " changed their name to " + str11;
                    } else {
                        str6 = "";
                    }
                    TextView f1 = chatScreen.makeText(str6, 15.0f, chatScreen.themedSubTextColor(), false);
                    f1.setGravity(17);
                    k1.addView(f1, ChatScreen.layoutParamsDefault(chatScreen, -1, -2, 0, 0, 0, 60));
                    if (i.b.a(c.b.J(b0, 0), "theme")) {
                        List list3 = ChatThemeCatalog.themes;
                        String str12 = ChatThemeCatalog.byId((String) (1 < b0.size() ? b0.get(1) : "")).emoji;
                        TextView f12 = chatScreen.makeText((str12.length() != 0 ? str12 + " " : "") + "Change", 15.0f, chatScreen.headerBgColor(), true);
                        f12.setGravity(17);
                        float f5 = (float) 12;
                        float f6 = (float) 4;
                        f12.setPadding(chatScreen.dp(f5), chatScreen.dp(f6), chatScreen.dp(f5), chatScreen.dp(f6));
                        ChatScreen.setClickAction(f12, new ChatScreenAction(chatScreen, 20));
                        k1.addView(f12, chatScreen.layoutParams(-1, -2, 0, 2, 0, 0));
                    }
                    i5 = i2;
                    arrayList2 = arrayList3;
                    str3 = str7;
                    view2 = k1;
                    i4 = 8388613;
                } else {
                    ChatMessage k05 = i2 > 0 ? (ChatMessage) arrayList3.get(i2 - 1) : null;
                    int i6 = i2 + 1;
                    ChatMessage k06 = i6 < arrayList3.size() ? (ChatMessage) arrayList3.get(i6) : null;
                    boolean a3 = i.b.a(str8, str7);
                    long j2 = k04.timestamp;
                    boolean z6 = k05 == null || j2 - k05.timestamp > 900000;
                    boolean z7 = (k05 == null || i.b.a(k05.type, "sys") || !i.b.a(k05.sender, str8) || z6) ? false : true;
                    boolean z8 = k06 != null && !i.b.a(k06.type, "sys") && i.b.a(k06.sender, str8) && k06.timestamp - j2 <= 900000;
                    ViewGroup k12 = chatScreen.columnLayout();
                    k12.setPadding(chatScreen.dp(13.0f), 0, chatScreen.dp(13.0f), 0);
                    if (z6) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
                        boolean a4 = i.b.a(simpleDateFormat.format(new Date()), simpleDateFormat.format(new Date(j2)));
                        long currentTimeMillis = (System.currentTimeMillis() - j2) / 86400000;
                        TextView f13 = chatScreen.makeText(new SimpleDateFormat(a4 ? "HH:mm" : (0 > currentTimeMillis || currentTimeMillis >= 7) ? "d MMM, HH:mm" : "EEE HH:mm", Locale.getDefault()).format(new Date(j2)), 16.5f, chatScreen.themedSubTextColor(), false);
                        f13.setGravity(17);
                        k0 = k04;
                        ViewGroup.LayoutParams W = chatScreen.layoutParams(-1, -2, 0, i2 == 0 ? 4 : 21, 0, a3 ? 12 : 19);
                        viewGroup2 = k12;
                        viewGroup2.addView(f13, W);
                    } else {
                        viewGroup2 = k12;
                        k0 = k04;
                    }
                    if (!a3 && !z7) {
                        viewGroup2.addView(chatScreen.makeText(chatScreen.displayName(str8), 14.0f, chatScreen.themedSubTextColor(), false), chatScreen.layoutParams(-2, -2, 43, z6 ? 0 : 15, 0, 1));
                    }
                    float f7 = (!z7 || (a3 && !(k05 != null && ChatScreen.canReact(k05) && ChatScreen.canReact(k0)))) ? (z6 || !a3) ? 0.0f : 12.0f : 2.2f;
                    LinearLayout k13 = chatScreen.columnLayout();
                    k13.setGravity(a3 ? 8388613 : 8388611);
                    ChatMessage k07 = k0;
                    long j3 = k07.replyTo;
                    if (j3 > 0) {
                        String x2 = a3 ? "You" : chatScreen.displayName(str8);
                        String str13 = k07.u;
                        String str14 = x2 + " replied to " + (i.b.a(str13, str8) ? a3 ? "yourself" : "themselves" : i.b.a(str13, str7) ? "you" : chatScreen.displayName(str13));
                        LinearLayout P2 = chatScreen.rowLayout();
                        float f8 = 14;
                        str2 = str7;
                        f2 = f7;
                        k03 = k07;
                        str = str8;
                        viewGroup3 = viewGroup2;
                        ViewGroup viewGroup5 = k13;
                        P2.addView(chatScreen.makeIcon("reply", chatScreen.themedSubTextColor(), 14), ChatScreen.layoutParamsDefault(chatScreen, chatScreen.dp(f8), chatScreen.dp(f8), 0, 0, 6, 32));
                        P2.addView(chatScreen.makeText(str14, 13.0f, chatScreen.themedSubTextColor(), false), ChatScreen.layoutParamsDefault(chatScreen, -2, -2, 0, 0, 0, 60));
                        viewGroup5.addView(P2, chatScreen.layoutParams(-2, -2, 0, 2, 0, 3));
                        boolean z9 = k03.deleted;
                        String str15 = k03.t;
                        if (z9 || !(i.b.a(str15, "image") || i.b.a(str15, "video"))) {
                            str5 = null;
                        } else {
                            String str16 = (String) c.b.I(k03.reactions);
                            if (str16 == null || str16.length() <= 0) {
                                Iterator it2 = arrayList3.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        Object next = it2.next();
                                        Iterator it3 = it2;
                                        if (((ChatMessage) next).id == j3) {
                                            obj = next;
                                        } else {
                                            it2 = it3;
                                        }
                                    } else {
                                        obj = null;
                                    }
                                }
                                ChatMessage k08 = (ChatMessage) obj;
                                if (k08 == null || k08.flag || (str16 = (String) c.b.I(k08.media)) == null || str16.length() == 0) {
                                    str16 = null;
                                }
                            }
                            str5 = str16;
                        }
                        if (str5 != null) {
                            boolean a5 = i.b.a(str15, "video");
                            FrameLayout frameLayout2 = new FrameLayout(activity);
                            float f9 = 16;
                            float z10 = chatScreen.dp(f9);
                            i3 = 7;
                            arrayList = arrayList3;
                            k02 = k06;
                            String str17 = str5;
                            frameLayout2.addView(chatScreen.mediaImage(str5, new float[]{z10, z10, z10, z10, z10, z10, z10, z10}, 480, new ImageAspectCallback(chatScreen, frameLayout2, 0), new ValueProvider(0)), new FrameLayout.LayoutParams(-1, -1));
                            if (a5) {
                                FrameLayout frameLayout3 = new FrameLayout(activity);
                                frameLayout3.setBackground(ChatScreen.circleDrawable(-1290003426));
                                frameLayout3.addView(chatScreen.makeIcon("play", -1, 16), new FrameLayout.LayoutParams(chatScreen.dp(f9), chatScreen.dp(f9), 17));
                                float f10 = 34;
                                frameLayout2.addView(frameLayout3, new FrameLayout.LayoutParams(chatScreen.dp(f10), chatScreen.dp(f10), 17));
                            }
                            Float f11 = (Float) ChatMedia.aspectRatios.get(str17);
                            viewGroup5.addView(frameLayout2, chatScreen.videoLayoutParams(f11 != null ? f11.floatValue() : 0.5625f));
                            viewGroup4 = viewGroup5;
                        } else {
                            arrayList = arrayList3;
                            k02 = k06;
                            i3 = 7;
                            TextView f14 = chatScreen.makeText(ChatScreen.replyPreviewText(str15, k03.x, z9), 16.0f, chatScreen.themedSubTextColor(), false);
                            f14.setSingleLine(true);
                            f14.setEllipsize(TextUtils.TruncateAt.END);
                            f14.setMaxWidth(chatScreen.dp(240));
                            f14.setTypeface((!i.b.a(str15, "text") || z9) ? Typeface.create(Typeface.DEFAULT, 2) : Typeface.DEFAULT);
                            f14.setBackground(chatScreen.roundedDrawable(chatScreen.isDarkBg() ? chatScreen.palette.otherBubbleColor : chatScreen.mediaPlaceholderColor, 18.0f, 0, 0.0f));
                            float f15 = 9;
                            f14.setPadding(chatScreen.dp(f8), chatScreen.dp(f15), chatScreen.dp(f8), chatScreen.dp(f15));
                            viewGroup5.addView(f14, chatScreen.layoutParams(-2, -2, 0, 0, 0, -6));
                            viewGroup4 = viewGroup5;
                        }
                    } else {
                        arrayList = arrayList3;
                        str = str8;
                        str2 = str7;
                        k02 = k06;
                        f2 = f7;
                        viewGroup3 = viewGroup2;
                        k03 = k07;
                        viewGroup4 = k13;
                        i3 = 7;
                    }
                    if (k03.status > 0 && !k03.flag && i.b.a(k03.type, "text")) {
                        TextView f16 = chatScreen.makeText("Edited", 14.5f, chatScreen.inputBarColor, false);
                        float f17 = 4;
                        f16.setPadding(chatScreen.dp(f17), chatScreen.dp(3), chatScreen.dp(f17), chatScreen.dp(2));
                        ChatScreen.setClickAction(f16, new MessageAction(chatScreen, k03, 1));
                        viewGroup4.addView(f16, chatScreen.layoutParams(-2, -2, 0, 0, 2, 1));
                    }
                    HashMap hashMap = chatScreen.reactions;
                    long j4 = k03.id;
                    List list4 = (List) hashMap.get(Long.valueOf(j4));
                    if (list4 == null) {
                        list4 = c.j.f773a;
                    }
                    FrameLayout frameLayout4 = new FrameLayout(activity);
                    boolean z11 = z7 && k05 != null && ChatScreen.canReact(k05) && ChatScreen.canReact(k03);
                    if (z8 && k02 != null && ChatScreen.canReact(k02) && ChatScreen.canReact(k03)) {
                        z = a3;
                        z2 = true;
                    } else {
                        z = a3;
                        z2 = false;
                    }
                    View m2 = chatScreen.buildMessageView(k03, z, z11, z2);
                    boolean z12 = (list4.isEmpty() ^ true) && !k03.flag;
                    if (!z12 && !z && !k03.flag) {
                        if (i2 == arrayList.size() - 1) {
                            z3 = true;
                            z4 = !z12 || z3;
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 48);
                            if (z4) {
                                layoutParams.bottomMargin = chatScreen.dp(26.0f);
                            }
                            frameLayout4.addView(m2, layoutParams);
                            if (z4) {
                                int i7 = chatScreen.bgColor;
                                int i8 = chatScreen.replyPreviewColor;
                                if (z12) {
                                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                                    Iterator it4 = list4.iterator();
                                    while (it4.hasNext()) {
                                        linkedHashSet.add(((b.b) it4.next()).f765b);
                                    }
                                    LinearLayout P3 = chatScreen.rowLayout();
                                    P3.setGravity(17);
                                    GradientDrawable gradientDrawable = new GradientDrawable();
                                    gradientDrawable.setColor(i8);
                                    gradientDrawable.setCornerRadius(chatScreen.dp(40.0f));
                                    gradientDrawable.setStroke(chatScreen.dp(1.6f), i7);
                                    P3.setBackground(gradientDrawable);
                                    P3.setMinimumHeight(chatScreen.dp(32.0f));
                                    P3.setPadding(chatScreen.dp(7.5f), 0, chatScreen.dp(7.5f), 0);
                                    TextView textView = new TextView(activity);
                                    textView.setText(c.b.L(c.b.P(linkedHashSet, 3), "", null, null, null, 62));
                                    textView.setTextSize(1, 16.74f);
                                    textView.setSingleLine(true);
                                    P3.addView(textView, new LinearLayout.LayoutParams(-2, -2));
                                    if (list4.size() > 1) {
                                        TextView f18 = chatScreen.makeText(String.valueOf(list4.size()), 15.0f, chatScreen.subTextColor, false);
                                        f18.setSingleLine(true);
                                        P3.addView(f18, chatScreen.layoutParams(-2, -2, 4, 0, 0, 0));
                                    }
                                    ChatScreen.setClickAction(P3, new ReactionAction(chatScreen, k03, list4));
                                    frameLayout = P3;
                                } else {
                                    FrameLayout frameLayout5 = new FrameLayout(activity);
                                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                                    gradientDrawable2.setShape(1);
                                    gradientDrawable2.setColor(i8);
                                    gradientDrawable2.setStroke(chatScreen.dp(1.6f), i7);
                                    frameLayout5.setBackground(gradientDrawable2);
                                    ChatIconView M = chatScreen.makeIcon("reactface", chatScreen.lightBars ? -2565411 : -10460570, 17);
                                    M.setCut(i8);
                                    frameLayout5.addView(M, new FrameLayout.LayoutParams(chatScreen.dp(17.0f), chatScreen.dp(17.0f), 17));
                                    frameLayout5.setMinimumWidth(chatScreen.dp(32.0f));
                                    frameLayout5.setMinimumHeight(chatScreen.dp(32.0f));
                                    ChatScreen.setClickAction(frameLayout5, new MessageAction(chatScreen, k03, 4));
                                    frameLayout = frameLayout5;
                                }
                                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, (z ? 8388613 : 8388611) | 80);
                                layoutParams2.setMargins(chatScreen.dp(1.0f), 0, chatScreen.dp(1.0f), 0);
                                frameLayout4.addView(frameLayout, layoutParams2);
                            }
                            viewGroup4.addView(frameLayout4, ChatScreen.layoutParamsDefault(chatScreen, -2, -2, 0, 0, 0, 60));
                            P = chatScreen.rowLayout();
                            P.setClipChildren(false);
                            ViewGroup viewGroup6 = viewGroup3;
                            viewGroup6.setClipChildren(false);
                            viewGroup6.setClipToPadding(false);
                            viewGroup4.setClipChildren(false);
                            frameLayout4.setClipChildren(false);
                            P.setGravity((!z ? 8388613 : 8388611) | 80);
                            if (!z) {
                                if (z8) {
                                    View view3 = new View(activity);
                                    LinearLayout.LayoutParams X = ChatScreen.layoutParamsDefault(chatScreen, chatScreen.dp(27.4f), 1, 0, 0, 0, 60);
                                    X.rightMargin = chatScreen.dp(8.6f);
                                    P.addView(view3, X);
                                } else {
                                    View k2 = chatScreen.avatarView(str, 27.4f);
                                    LinearLayout.LayoutParams W2 = chatScreen.layoutParams(chatScreen.dp(27.4f), chatScreen.dp(27.4f), 0, 0, 0, z4 ? i3 : 0);
                                    W2.rightMargin = chatScreen.dp(8.6f);
                                    P.addView(k2, W2);
                                }
                            }
                            P.addView(viewGroup4, ChatScreen.layoutParamsDefault(chatScreen, -2, -2, 0, 0, 0, 60));
                            list = (List) chatScreen.seenByMessage.get(Long.valueOf(j4));
                            if (z || k03.flag || !((j4 == chatScreen.myLastMessageId || chatScreen.isLocalMessage(k03)) && (list == null || list.isEmpty()))) {
                                str3 = str2;
                                if (z) {
                                    P.addView(new View(activity), ChatScreen.layoutParamsDefault(chatScreen, chatScreen.dp(16.0f), 1, 0, 0, 0, 60));
                                }
                            } else {
                                HashMap hashMap2 = chatScreen.lastSeen;
                                if (!hashMap2.isEmpty()) {
                                    for (Map.Entry entry : hashMap2.entrySet()) {
                                        String str18 = (String) entry.getKey();
                                        long longValue = ((Number) entry.getValue()).longValue();
                                        str3 = str2;
                                        if (i.b.a(str18, str3) || longValue < j4) {
                                            str2 = str3;
                                        } else {
                                            z5 = true;
                                            if (chatScreen.isLocalMessage(k03)) {
                                                if (!z5) {
                                                    HashSet hashSet = chatScreen.prefetchCheckedIds;
                                                    if (!(hashSet instanceof Collection) || !hashSet.isEmpty()) {
                                                        Iterator it5 = hashSet.iterator();
                                                        while (it5.hasNext()) {
                                                            if (!i.b.a((String) it5.next(), str3)) {
                                                            }
                                                        }
                                                    }
                                                    str4 = "sent";
                                                }
                                                str4 = "deliv";
                                            } else {
                                                str4 = "pend";
                                            }
                                            View M2 = chatScreen.makeIcon(str4, !chatScreen.isDarkBg() ? chatScreen.palette.ownBubbleGradientEnd : chatScreen.sendBlue, 16);
                                            LinearLayout.LayoutParams X2 = ChatScreen.layoutParamsDefault(chatScreen, chatScreen.dp(14.0f), chatScreen.dp(14.0f), 0, 0, 0, 60);
                                            X2.leftMargin = chatScreen.dp(2.0f);
                                            X2.rightMargin = 0;
                                            X2.bottomMargin = chatScreen.dp(3.0f);
                                            P.addView(M2, X2);
                                        }
                                    }
                                }
                                str3 = str2;
                                z5 = false;
                                if (chatScreen.isLocalMessage(k03)) {
                                }
                                View M22 = chatScreen.makeIcon(str4, !chatScreen.isDarkBg() ? chatScreen.palette.ownBubbleGradientEnd : chatScreen.sendBlue, 16);
                                LinearLayout.LayoutParams X22 = ChatScreen.layoutParamsDefault(chatScreen, chatScreen.dp(14.0f), chatScreen.dp(14.0f), 0, 0, 0, 60);
                                X22.leftMargin = chatScreen.dp(2.0f);
                                X22.rightMargin = 0;
                                X22.bottomMargin = chatScreen.dp(3.0f);
                                P.addView(M22, X22);
                            }
                            if (list != null && (!list.isEmpty()) && !z) {
                                P.addView(new View(activity), new LinearLayout.LayoutParams(0, 1, 1.0f));
                                it = list.iterator();
                                while (it.hasNext()) {
                                    View k3 = chatScreen.avatarView((String) it.next(), 15.6f);
                                    LinearLayout.LayoutParams X3 = ChatScreen.layoutParamsDefault(chatScreen, chatScreen.dp(15.6f), chatScreen.dp(15.6f), 0, 0, 0, 60);
                                    X3.leftMargin = chatScreen.dp(2.0f);
                                    P.addView(k3, X3);
                                }
                            }
                            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                            layoutParams3.topMargin = chatScreen.dp(f2);
                            if (z) {
                                layoutParams3.rightMargin = -chatScreen.dp(8.0f);
                            }
                            viewGroup6.addView(P, layoutParams3);
                            if (list == null && (!list.isEmpty()) && z) {
                                LinearLayout P4 = chatScreen.rowLayout();
                                i4 = 8388613;
                                P4.setGravity(8388613);
                                Iterator it6 = list.iterator();
                                while (it6.hasNext()) {
                                    AvatarView k4 = chatScreen.avatarView((String) it6.next(), 15.6f);
                                    LinearLayout.LayoutParams X4 = ChatScreen.layoutParamsDefault(chatScreen, chatScreen.dp(15.6f), chatScreen.dp(15.6f), 0, 0, 0, 60);
                                    X4.leftMargin = chatScreen.dp(2.0f);
                                    P4.addView(k4, X4);
                                }
                                viewGroup6.addView(P4, ChatScreen.layoutParamsDefault(chatScreen, -1, -2, 0, 2, 0, 48));
                            } else {
                                i4 = 8388613;
                            }
                            viewGroup6.setTag(P);
                            i5 = i2;
                            view2 = viewGroup6;
                            arrayList2 = arrayList;
                        }
                    }
                    z3 = false;
                    if (z12) {
                    }
                    FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2, 48);
                    if (z4) {
                    }
                    frameLayout4.addView(m2, layoutParams4);
                    if (z4) {
                    }
                    viewGroup4.addView(frameLayout4, ChatScreen.layoutParamsDefault(chatScreen, -2, -2, 0, 0, 0, 60));
                    P = chatScreen.rowLayout();
                    P.setClipChildren(false);
                    ViewGroup viewGroup62 = viewGroup3;
                    viewGroup62.setClipChildren(false);
                    viewGroup62.setClipToPadding(false);
                    viewGroup4.setClipChildren(false);
                    frameLayout4.setClipChildren(false);
                    P.setGravity((!z ? 8388613 : 8388611) | 80);
                    if (!z) {
                    }
                    P.addView(viewGroup4, ChatScreen.layoutParamsDefault(chatScreen, -2, -2, 0, 0, 0, 60));
                    list = (List) chatScreen.seenByMessage.get(Long.valueOf(j4));
                    if (z) {
                    }
                    str3 = str2;
                    if (z) {
                    }
                    if (list != null) {
                        P.addView(new View(activity), new LinearLayout.LayoutParams(0, 1, 1.0f));
                        it = list.iterator();
                        while (it.hasNext()) {
                        }
                    }
                    LinearLayout.LayoutParams layoutParams32 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams32.topMargin = chatScreen.dp(f2);
                    if (z) {
                    }
                    viewGroup62.addView(P, layoutParams32);
                    if (list == null) {
                    }
                    i4 = 8388613;
                    viewGroup62.setTag(P);
                    i5 = i2;
                    view2 = viewGroup62;
                    arrayList2 = arrayList;
                }
                boolean a6 = i.b.a(((ChatMessage) arrayList2.get(i5)).sender, str3);
                final FrameLayout frameLayout6 = new FrameLayout(activity);
                frameLayout6.setClipChildren(false);
                frameLayout6.setClipToPadding(false);
                FrameLayout frameLayout7 = new FrameLayout(activity);
                frameLayout7.setBackground(ChatScreen.circleDrawable(chatScreen.chipColor));
                frameLayout7.setAlpha(0.0f);
                frameLayout7.addView(chatScreen.makeIcon("replyf", chatScreen.textColor, 18), new FrameLayout.LayoutParams(chatScreen.dp(18.0f), chatScreen.dp(18.0f), 17));
                int z13 = chatScreen.dp(34.0f);
                int z14 = chatScreen.dp(34.0f);
                if (!a6) {
                    i4 = 8388611;
                }
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(z13, z14, i4 | 48);
                layoutParams5.leftMargin = chatScreen.dp(8.0f);
                layoutParams5.rightMargin = chatScreen.dp(8.0f);
                frameLayout6.addView(frameLayout7, layoutParams5);
                frameLayout6.addView(view2, new FrameLayout.LayoutParams(-1, -2));
                Object tag = view2.getTag();
                View view4 = tag instanceof View ? (View) tag : null;
                if (view4 != null) {
                    view2 = view4;
                }
                frameLayout6.setTag(new SwipeReplyTag(view2, frameLayout7, a6));
                if (((ChatMessage) chatScreen.messages.get(i5)).id == chatScreen.lastLocalSentId) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    if (chatScreen.sentSoundElapsed == 0) {
                        chatScreen.sentSoundElapsed = uptimeMillis;
                    }
                    long j5 = uptimeMillis - chatScreen.sentSoundElapsed;
                    if (j5 >= 340) {
                        chatScreen.lastLocalSentId = Long.MIN_VALUE;
                    } else {
                        float f19 = j5 / 340.0f;
                        final float z15 = chatScreen.dp(34);
                        frameLayout6.setTranslationY((1.0f - f19) * z15);
                        frameLayout6.setAlpha(AppState.b(f19, 0.0f, 1.0f));
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(f19, 1.0f);
                        ofFloat.setDuration(340 - j5);
                        ofFloat.setInterpolator(new OvershootInterpolator(1.15f));
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                Object animatedValue = valueAnimator.getAnimatedValue();
                                i.b.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                                float floatValue = ((Float) animatedValue).floatValue();
                                float f20 = (1.0f - floatValue) * z15;
                                View view5 = frameLayout6;
                                view5.setTranslationY(f20);
                                view5.setAlpha(AppState.b(floatValue, 0.0f, 1.0f));
                            }
                        });
                        ofFloat.start();
                    }
                }
                return frameLayout6;
            default:
                MediaGridItemView c0082v1 = view instanceof MediaGridItemView ? (MediaGridItemView) view : null;
                MediaPicker b1 = (MediaPicker) obj2;
                if (c0082v1 == null) {
                    c0082v1 = new MediaGridItemView(b1);
                }
                MediaItem c0094z1 = (MediaItem) b1.filteredMedia.get(i2);
                c0082v1.item = c0094z1;
                String uri = c0094z1.uri.toString();
                c0082v1.uriString = uri;
                MediaPicker b12 = c0082v1.owner;
                Bitmap bitmap = (Bitmap) b12.bitmapCache.get(uri);
                c0082v1.imageView.setImageBitmap(bitmap);
                if (bitmap == null) {
                    HashSet hashSet2 = b12.loadingUris;
                    if (hashSet2.add(uri)) {
                        try {
                            b12.executor.execute(new QuadTaskRunnable(b12, c0094z1, uri, c0082v1, 5));
                        } catch (Throwable unused) {
                            hashSet2.remove(uri);
                        }
                    }
                }
                TextView textView2 = c0082v1.durationLabel;
                if (c0094z1.isVideo) {
                    textView2.setVisibility(0);
                    int i9 = (int) ((c0094z1.durationMs + 500) / 1000);
                    int i10 = i9 / 3600;
                    int i11 = (i9 % 3600) / 60;
                    int i12 = i9 % 60;
                    textView2.setText(i10 > 0 ? i10 + ":" + m.e.U(String.valueOf(i11)) + ":" + m.e.U(String.valueOf(i12)) : i11 + ":" + m.e.U(String.valueOf(i12)));
                } else {
                    textView2.setVisibility(8);
                }
                int indexOf = b12.selectedItems.indexOf(c0094z1);
                View view5 = c0082v1.selectionBorder;
                TextView textView3 = c0082v1.selectionBadge;
                if (indexOf >= 0) {
                    view5.setVisibility(0);
                    textView3.setVisibility(0);
                    textView3.setText(String.valueOf(indexOf + 1));
                } else {
                    view5.setVisibility(8);
                    textView3.setVisibility(8);
                }
                return c0082v1;
        }
    }
}
