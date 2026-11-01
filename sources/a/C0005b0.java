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

/* renamed from: a.b0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0005b0 implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f411a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f412b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ K0 f413c;

    public /* synthetic */ C0005b0(C0006b1 c0006b1, K0 k0, int i2) {
        this.f411a = i2;
        this.f412b = c0006b1;
        this.f413c = k0;
    }

    @Override // h.a
    public final Object a() {
        switch (this.f411a) {
            case 0:
                C0006b1 c0006b1 = this.f412b;
                HashSet hashSet = (HashSet) c0006b1.J0.a();
                K0 k0 = this.f413c;
                hashSet.add(Long.valueOf(k0.f150a));
                String L = c.b.L(c.b.P(c.b.O(c.b.Q((HashSet) c0006b1.J0.a()), d.b.f804c), 400), " ", null, null, null, 62);
                SharedPreferences sharedPreferences = AbstractC0008c.f440c;
                if (sharedPreferences == null) {
                    i.b.g("sp");
                    throw null;
                }
                sharedPreferences.edit().putString("hidden_msgs", L).apply();
                c0006b1.D.remove(k0);
                c0006b1.w0();
                c0006b1.x0(false);
                return b.d.f770c;
            case 1:
                final C0006b1 c0006b12 = this.f412b;
                c0006b12.getClass();
                final K0 k02 = this.f413c;
                final boolean a2 = i.b.a(k02.f151b, c0006b12.f415b);
                c0006b12.l(false, new h.c() { // from class: a.D0
                    @Override // h.c
                    public final Object a(Object obj, Object obj2) {
                        LinearLayout linearLayout = (LinearLayout) obj;
                        final C0006b1 c0006b13 = C0006b1.this;
                        TextView f1 = c0006b13.f1("Edit history", 21.0f, c0006b13.f425l, true);
                        f1.setGravity(17);
                        linearLayout.addView(f1, c0006b13.W(-1, -2, 0, 4, 0, 12));
                        linearLayout.addView(c0006b13.y());
                        ScrollView scrollView = new ScrollView(c0006b13.f414a);
                        final LinearLayout k1 = c0006b13.k1();
                        float f2 = 14;
                        k1.setPadding(c0006b13.z(f2), c0006b13.z(12), c0006b13.z(f2), c0006b13.z(10));
                        k1.addView(c0006b13.f1("Loading...", 16.0f, c0006b13.f426m, false), C0006b1.X(c0006b13, -2, -2, 0, 0, 0, 60));
                        scrollView.addView(k1);
                        linearLayout.addView(scrollView, new LinearLayout.LayoutParams(-1, -2));
                        final K0 k03 = k02;
                        final boolean z = a2;
                        new Thread(new Runnable() { // from class: a.F0
                            @Override // java.lang.Runnable
                            public final void run() {
                                C0004b c0004b = C0004b.f409a;
                                final K0 k04 = K0.this;
                                final C0000a b2 = C0004b.b(c0004b, "GET", "/chat/edits/" + k04.f150a, null, 12);
                                final C0006b1 c0006b14 = c0006b13;
                                Activity activity = c0006b14.f414a;
                                final LinearLayout linearLayout2 = k1;
                                final boolean z2 = z;
                                activity.runOnUiThread(new Runnable() { // from class: a.M
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        boolean z3;
                                        String str;
                                        String optString;
                                        LinearLayout linearLayout3 = linearLayout2;
                                        linearLayout3.removeAllViews();
                                        C0000a c0000a = b2;
                                        JSONObject c2 = c0000a.c();
                                        JSONArray optJSONArray = c2 != null ? c2.optJSONArray("edits") : null;
                                        boolean b3 = c0000a.b();
                                        boolean z4 = false;
                                        C0006b1 c0006b15 = c0006b14;
                                        if (!b3 || optJSONArray == null) {
                                            c0006b15.getClass();
                                            linearLayout3.addView(c0006b15.f1(C0006b1.E(c0000a), 16.0f, c0006b15.f426m, false), C0006b1.X(c0006b15, -2, -2, 0, 0, 0, 60));
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
                                        arrayList.add(k04.f153d);
                                        Iterator it = arrayList.iterator();
                                        int i3 = 0;
                                        while (it.hasNext()) {
                                            int i4 = i3 + 1;
                                            String str3 = (String) it.next();
                                            String str4 = i3 == arrayList.size() - 1 ? "Current" : i3 == 0 ? "Original" : "";
                                            int length2 = str4.length();
                                            boolean z5 = z2;
                                            if (length2 > 0) {
                                                TextView f12 = c0006b15.f1(str4, 13.5f, c0006b15.f426m, z4);
                                                z3 = z5;
                                                str = str3;
                                                LinearLayout.LayoutParams W = c0006b15.W(-2, -2, 4, 0, 4, 3);
                                                W.gravity = z3 ? 8388613 : 8388611;
                                                linearLayout3.addView(f12, W);
                                            } else {
                                                z3 = z5;
                                                str = str3;
                                            }
                                            TextView textView = new TextView(c0006b15.f414a);
                                            textView.setText(str);
                                            textView.setTextSize(1, 19.065f);
                                            textView.setTextColor(z3 ? -1 : c0006b15.f425l);
                                            float f3 = 14;
                                            float f4 = 9;
                                            textView.setPadding(c0006b15.z(f3), c0006b15.z(f4), c0006b15.z(f3), c0006b15.z(f4));
                                            textView.setMaxWidth((int) (c0006b15.f414a.getResources().getDisplayMetrics().widthPixels * 0.78f));
                                            textView.setBackground(c0006b15.N0(z3 ? c0006b15.f420g : c0006b15.f423j, 19.0f, 0, 0.0f));
                                            LinearLayout.LayoutParams W2 = c0006b15.W(-2, -2, 0, 0, 0, 10);
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
                C0006b1 c0006b13 = this.f412b;
                c0006b13.getClass();
                K0 k03 = this.f413c;
                k03.f159j = true;
                k03.f153d = "";
                c0006b13.x0(false);
                new Thread(new U(k03, c0006b13, 2)).start();
                return b.d.f770c;
            case 3:
                C0006b1 c0006b14 = this.f412b;
                c0006b14.getClass();
                K0 k04 = this.f413c;
                String str = (String) c.b.I(k04.f154e);
                if (str != null) {
                    long j2 = c0006b14.h1;
                    long j3 = k04.f150a;
                    if (j2 == j3) {
                        c0006b14.e1(j3, z2.c(str));
                    } else if (c0006b14.m1 == j3) {
                        c0006b14.p();
                    } else {
                        File c2 = z2.c(str);
                        if (c2.exists() && c2.length() > 0) {
                            c0006b14.e1(j3, c2);
                        } else if (!c0006b14.a0(AbstractC0008c.p(str), false)) {
                            c0006b14.p();
                            c0006b14.X0();
                            c0006b14.m1 = j3;
                            C1 c1 = (C1) c0006b14.j1.get(Long.valueOf(j3));
                            if (c1 != null) {
                                c1.set("load");
                            }
                            new Thread(new RunnableC0056o(str, c0006b14, k04, 0)).start();
                        }
                    }
                }
                return b.d.f770c;
            case 4:
                K0 k05 = this.f413c;
                C0006b1 c0006b15 = this.f412b;
                c0006b15.u0(false, new C0024g(c0006b15, k05, 0));
                return b.d.f770c;
            default:
                final C0006b1 c0006b16 = this.f412b;
                K0 k06 = this.f413c;
                if (!c0006b16.S(k06)) {
                    final List H = c.b.H(k06.f154e, 1);
                    if (H.isEmpty()) {
                        c0006b16.f416c.a("Video expired");
                    } else if (!c0006b16.a0(H, true)) {
                        Activity activity = c0006b16.f414a;
                        final Dialog dialog = new Dialog(activity, R.style.Theme.Black.NoTitleBar);
                        FrameLayout frameLayout = new FrameLayout(activity);
                        frameLayout.setBackgroundColor(-16777216);
                        final VideoView videoView = new VideoView(activity);
                        frameLayout.addView(videoView, new FrameLayout.LayoutParams(-1, -1, 17));
                        final ProgressBar progressBar = new ProgressBar(activity);
                        float f2 = 34;
                        frameLayout.addView(progressBar, new FrameLayout.LayoutParams(c0006b16.z(f2), c0006b16.z(f2), 17));
                        final TextView f1 = c0006b16.f1("", 15.0f, -1, false);
                        f1.setGravity(17);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
                        layoutParams.topMargin = c0006b16.z(48);
                        frameLayout.addView(f1, layoutParams);
                        LinearLayout P = c0006b16.P();
                        float f3 = 8;
                        P.setPadding(c0006b16.z(f3), c0006b16.z(f3), c0006b16.z(f3), c0006b16.z(f3));
                        FrameLayout frameLayout2 = new FrameLayout(activity);
                        float f4 = 26;
                        frameLayout2.addView(new G1(activity, "back", -1, 2.4f), new FrameLayout.LayoutParams(c0006b16.z(f4), c0006b16.z(f4), 17));
                        C0006b1.n0(frameLayout2, new C0060p(dialog, 1));
                        float f5 = 44;
                        P.addView(frameLayout2, C0006b1.X(c0006b16, c0006b16.z(f5), c0006b16.z(f5), 0, 0, 0, 60));
                        P.addView(new View(activity), new LinearLayout.LayoutParams(0, 1, 1.0f));
                        FrameLayout frameLayout3 = new FrameLayout(activity);
                        frameLayout3.addView(c0006b16.M("download", -1, 26), new FrameLayout.LayoutParams(c0006b16.z(f4), c0006b16.z(f4), 17));
                        P.addView(frameLayout3, C0006b1.X(c0006b16, c0006b16.z(f5), c0006b16.z(f5), 0, 0, 0, 60));
                        frameLayout.addView(P, new FrameLayout.LayoutParams(-1, -2, 48));
                        LinearLayout P2 = c0006b16.P();
                        float f6 = 14;
                        P2.setPadding(c0006b16.z(f6), c0006b16.z(f3), c0006b16.z(f6), c0006b16.z(f6));
                        FrameLayout frameLayout4 = new FrameLayout(activity);
                        final C1 M = c0006b16.M("play", -1, 26);
                        frameLayout4.addView(M, new FrameLayout.LayoutParams(c0006b16.z(f4), c0006b16.z(f4), 17));
                        float f7 = 40;
                        P2.addView(frameLayout4, C0006b1.X(c0006b16, c0006b16.z(f7), c0006b16.z(f7), 0, 0, 0, 60));
                        final TextView f12 = c0006b16.f1("0:00", 17.0f, -1, false);
                        P2.addView(f12, c0006b16.W(-2, -2, 6, 0, 8, 0));
                        final SeekBar seekBar = new SeekBar(activity);
                        seekBar.setMax(1000);
                        seekBar.setProgressTintList(ColorStateList.valueOf(-1));
                        seekBar.setThumbTintList(ColorStateList.valueOf(-1));
                        seekBar.setProgressBackgroundTintList(ColorStateList.valueOf(1728053247));
                        P2.addView(seekBar, new LinearLayout.LayoutParams(0, -2, 1.0f));
                        final TextView f13 = c0006b16.f1(C0006b1.G(k06.f156g), 17.0f, -1, false);
                        P2.addView(f13, c0006b16.W(-2, -2, 8, 0, 10, 0));
                        FrameLayout frameLayout5 = new FrameLayout(activity);
                        C1 M2 = c0006b16.M("volume", -1, 26);
                        frameLayout5.addView(M2, new FrameLayout.LayoutParams(c0006b16.z(f4), c0006b16.z(f4), 17));
                        float f8 = 36;
                        P2.addView(frameLayout5, C0006b1.X(c0006b16, c0006b16.z(f8), c0006b16.z(f8), 0, 0, 0, 60));
                        frameLayout.addView(P2, new FrameLayout.LayoutParams(-1, -2, 80));
                        TextView f14 = c0006b16.f1("", 17.0f, -1, false);
                        float f9 = 16;
                        f14.setPadding(c0006b16.z(f9), c0006b16.z(f3), c0006b16.z(f9), c0006b16.z(f3));
                        f14.setBackground(c0006b16.N0(-869651924, 20.0f, 0, 0.0f));
                        f14.setVisibility(8);
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 81);
                        layoutParams2.bottomMargin = c0006b16.z(84);
                        frameLayout.addView(f14, layoutParams2);
                        final RunnableC0064q runnableC0064q = new RunnableC0064q(f14, 1);
                        final i.d dVar = new i.d();
                        final i.e eVar = new i.e();
                        i.d dVar2 = new i.d();
                        final i.g gVar = new i.g();
                        final i.g gVar2 = new i.g();
                        final i.d dVar3 = new i.d();
                        final W0 w0 = new W0(dVar, dVar2, eVar, videoView, f12, c0006b16, seekBar);
                        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: a.z
                            @Override // android.content.DialogInterface.OnDismissListener
                            public final void onDismiss(DialogInterface dialogInterface) {
                                VideoView videoView2 = videoView;
                                C0006b1 c0006b17 = C0006b1.this;
                                c0006b17.f418e.removeCallbacks(w0);
                                c0006b17.f418e.removeCallbacks(runnableC0064q);
                                try {
                                    videoView2.stopPlayback();
                                } catch (Exception unused) {
                                }
                            }
                        });
                        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: a.A
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public final void onPrepared(MediaPlayer mediaPlayer) {
                                i.g.this.f850b = mediaPlayer;
                                dVar.f846a = true;
                                VideoView videoView2 = videoView;
                                int duration = videoView2.getDuration();
                                eVar.f847a = duration;
                                c0006b16.getClass();
                                f13.setText(C0006b1.G(duration));
                                progressBar.setVisibility(8);
                                f1.setVisibility(8);
                                if (dVar3.f846a) {
                                    mediaPlayer.setVolume(0.0f, 0.0f);
                                }
                                videoView2.start();
                                M.set("pause");
                            }
                        });
                        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: a.B
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public final void onCompletion(MediaPlayer mediaPlayer) {
                                C1.this.set("play");
                                seekBar.setProgress(1000);
                                int i2 = eVar.f847a;
                                c0006b16.getClass();
                                f12.setText(C0006b1.G(i2));
                            }
                        });
                        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: a.C
                            @Override // android.media.MediaPlayer.OnErrorListener
                            public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                                progressBar.setVisibility(8);
                                c0006b16.f416c.a("Can't play this video");
                                return true;
                            }
                        });
                        C0006b1.n0(frameLayout4, new D(dVar, videoView, M, 0));
                        seekBar.setOnSeekBarChangeListener(new V0(eVar, f12, c0006b16, dVar2, dVar, videoView));
                        C0006b1.n0(frameLayout5, new D(dVar3, M2, gVar2));
                        C0006b1.n0(frameLayout3, new C0071s(gVar, f14, c0006b16, runnableC0064q));
                        dialog.setContentView(frameLayout);
                        c0006b16.T0(dialog);
                        c0006b16.f418e.post(w0);
                        new Thread(new Runnable() { // from class: a.F
                            @Override // java.lang.Runnable
                            public final void run() {
                                File file;
                                final TextView textView = f1;
                                File file2 = z2.f758a;
                                List list = H;
                                boolean isEmpty = list.isEmpty();
                                C0006b1 c0006b17 = c0006b16;
                                File file3 = null;
                                if (!isEmpty) {
                                    final int i2 = 0;
                                    File g2 = z2.g((String) list.get(0));
                                    if (g2.exists() && g2.length() > 0) {
                                        file = g2;
                                        c0006b17.f414a.runOnUiThread(new T(dialog, file, c0006b17, gVar, videoView, 0));
                                    }
                                    File file4 = new File(z2.d(), "v_" + list.get(0) + ".tmp");
                                    try {
                                        try {
                                            FileOutputStream fileOutputStream = new FileOutputStream(file4);
                                            try {
                                                Iterator it = list.iterator();
                                                while (it.hasNext()) {
                                                    i2++;
                                                    File b2 = z2.b((String) it.next());
                                                    if (b2 == null) {
                                                        throw new IOException("expired");
                                                    }
                                                    FileInputStream fileInputStream = new FileInputStream(b2);
                                                    try {
                                                        AbstractC0008c.e(fileInputStream, fileOutputStream, 65536);
                                                        AbstractC0008c.a(fileInputStream, null);
                                                        final int size = list.size();
                                                        if (size > 1) {
                                                            c0006b17.f414a.runOnUiThread(new Runnable() { // from class: a.d0
                                                                @Override // java.lang.Runnable
                                                                public final void run() {
                                                                    textView.setText(i2 + "/" + size);
                                                                }
                                                            });
                                                        }
                                                    } finally {
                                                    }
                                                }
                                                AbstractC0008c.a(fileOutputStream, null);
                                                if (!file4.renameTo(g2)) {
                                                    throw new IOException("rename");
                                                }
                                                Iterator it2 = list.iterator();
                                                while (it2.hasNext()) {
                                                    z2.c((String) it2.next()).delete();
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
                                c0006b17.f414a.runOnUiThread(new T(dialog, file, c0006b17, gVar, videoView, 0));
                            }
                        }).start();
                    }
                }
                return b.d.f770c;
        }
    }
}
