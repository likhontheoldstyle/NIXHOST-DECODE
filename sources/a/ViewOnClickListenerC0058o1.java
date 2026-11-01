package a;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.VideoView;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: a.o1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class ViewOnClickListenerC0058o1 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f611a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ B1 f612b;

    public /* synthetic */ ViewOnClickListenerC0058o1(B1 b1, int i2) {
        this.f611a = i2;
        this.f612b = b1;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:95:0x03ff  */
    /* JADX WARN: Type inference failed for: r0v18, types: [android.view.ViewGroup, android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r2v6, types: [android.view.View, android.view.ViewGroup, android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r3v13, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r5v12, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r5v13, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r8v0, types: [a.B1] */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.view.View, android.view.ViewGroup, android.widget.FrameLayout, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v2, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onClick(View view) {
        ?? r5;
        File file;
        FileOutputStream fileOutputStream;
        int i2;
        Activity activity;
        int i3;
        final int i4 = 0;
        final int i5 = 1;
        ?? r8 = this.f612b;
        switch (this.f611a) {
            case 0:
                r8.d();
                return;
            case 1:
                C0091y1 c0091y1 = r8.F;
                if (c0091y1 != null) {
                    ArrayList arrayList = c0091y1.f721b;
                    if (!arrayList.isEmpty()) {
                        arrayList.remove(arrayList.size() - 1);
                        c0091y1.invalidate();
                        return;
                    }
                    return;
                }
                return;
            case 2:
                C0094z1 c0094z1 = r8.G;
                if (c0094z1 == null) {
                    return;
                }
                c.j jVar = c.j.f773a;
                boolean z = c0094z1.f753b;
                Uri uri = c0094z1.f752a;
                if (z) {
                    r8.d();
                    r8.f(jVar, AbstractC0008c.p(uri));
                    return;
                }
                C0091y1 c0091y12 = r8.F;
                if (c0091y12 != null && (!c0091y12.f721b.isEmpty())) {
                    try {
                        r5 = c0091y12.f720a.copy(Bitmap.Config.ARGB_8888, true);
                        c0091y12.a(new Canvas(r5));
                        file = new File(c0091y12.f735r.f26a.getCacheDir(), "edit_" + System.currentTimeMillis() + ".jpg");
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Throwable unused) {
                        r5 = 0;
                    }
                    try {
                        try {
                            r5.compress(Bitmap.CompressFormat.JPEG, 92, fileOutputStream);
                            AbstractC0008c.a(fileOutputStream, null);
                        } catch (Throwable th) {
                            r5 = 0;
                            r5 = 0;
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                AbstractC0008c.a(fileOutputStream, th);
                                throw th2;
                            }
                        }
                    } catch (Throwable unused2) {
                        file = r5;
                        if (file != null) {
                        }
                        r8.d();
                        r8.f(AbstractC0008c.p(uri), jVar);
                        return;
                    }
                    if (file != null) {
                        uri = Uri.fromFile(file);
                    }
                }
                r8.d();
                r8.f(AbstractC0008c.p(uri), jVar);
                return;
            case 3:
                Dialog dialog = r8.f41r;
                if (dialog == null) {
                    i.b.g("dlg");
                    throw null;
                }
                dialog.dismiss();
                r8.f28c.a();
                return;
            case 4:
                final B1 b1 = this.f612b;
                if (b1.f40o.size() == 1) {
                    C0094z1 c0094z12 = (C0094z1) b1.f40o.get(0);
                    b1.G = c0094z12;
                    b1.H = false;
                    b1.c(true);
                    Activity activity2 = b1.f26a;
                    ?? frameLayout = new FrameLayout(activity2);
                    frameLayout.setBackgroundColor(-16777216);
                    frameLayout.setClickable(true);
                    b1.D = frameLayout;
                    ?? linearLayout = new LinearLayout(activity2);
                    linearLayout.setOrientation(1);
                    ?? linearLayout2 = new LinearLayout(activity2);
                    linearLayout2.setGravity(16);
                    linearLayout2.setPadding(b1.e(4), b1.e(6), b1.e(8), b1.e(6));
                    FrameLayout frameLayout2 = new FrameLayout(activity2);
                    frameLayout2.addView(new G1(activity2, "back", -1, 2.4f), new FrameLayout.LayoutParams(b1.e(26), b1.e(26), 17));
                    frameLayout2.setOnClickListener(new ViewOnClickListenerC0058o1(b1, i4));
                    linearLayout2.addView(frameLayout2, new LinearLayout.LayoutParams(b1.e(48), b1.e(48)));
                    linearLayout2.addView(b1.l("Preview", 21.0f, -1, true), new LinearLayout.LayoutParams(0, -2, 1.0f));
                    if (!c0094z12.f753b) {
                        final FrameLayout k2 = b1.k("pen");
                        FrameLayout k3 = b1.k("aa");
                        FrameLayout k4 = b1.k("undo");
                        k2.setOnClickListener(new View.OnClickListener() { // from class: a.p1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                switch (i4) {
                                    case 0:
                                        B1 b12 = b1;
                                        boolean z2 = !b12.H;
                                        b12.H = z2;
                                        C0091y1 c0091y13 = b12.F;
                                        if (c0091y13 != null) {
                                            c0091y13.f722c = z2;
                                        }
                                        k2.setBackground(z2 ? B1.h(1157627903) : null);
                                        break;
                                    default:
                                        B1 b13 = b1;
                                        b13.H = false;
                                        C0091y1 c0091y14 = b13.F;
                                        if (c0091y14 != null) {
                                            c0091y14.f722c = false;
                                        }
                                        k2.setBackground(null);
                                        b13.b("", new C0001a0(1, b13));
                                        break;
                                }
                            }
                        });
                        k3.setOnClickListener(new View.OnClickListener() { // from class: a.p1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                switch (i5) {
                                    case 0:
                                        B1 b12 = b1;
                                        boolean z2 = !b12.H;
                                        b12.H = z2;
                                        C0091y1 c0091y13 = b12.F;
                                        if (c0091y13 != null) {
                                            c0091y13.f722c = z2;
                                        }
                                        k2.setBackground(z2 ? B1.h(1157627903) : null);
                                        break;
                                    default:
                                        B1 b13 = b1;
                                        b13.H = false;
                                        C0091y1 c0091y14 = b13.F;
                                        if (c0091y14 != null) {
                                            c0091y14.f722c = false;
                                        }
                                        k2.setBackground(null);
                                        b13.b("", new C0001a0(1, b13));
                                        break;
                                }
                            }
                        });
                        k4.setOnClickListener(new ViewOnClickListenerC0058o1(b1, i5));
                        linearLayout2.addView(k2, new LinearLayout.LayoutParams(b1.e(44), b1.e(44)));
                        linearLayout2.addView(k3, new LinearLayout.LayoutParams(b1.e(44), b1.e(44)));
                        linearLayout2.addView(k4, new LinearLayout.LayoutParams(b1.e(44), b1.e(44)));
                    }
                    linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
                    ?? frameLayout3 = new FrameLayout(activity2);
                    linearLayout.addView(frameLayout3, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                    if (c0094z12.f753b) {
                        final VideoView videoView = new VideoView(activity2);
                        b1.E = videoView;
                        frameLayout3.addView(videoView, new FrameLayout.LayoutParams(-1, -1, 17));
                        FrameLayout frameLayout4 = new FrameLayout(activity2);
                        frameLayout4.setBackground(B1.h(1711276032));
                        frameLayout4.setVisibility(8);
                        frameLayout4.addView(new C1(activity2, "play", -1), new FrameLayout.LayoutParams(b1.e(34), b1.e(34), 17));
                        frameLayout3.addView(frameLayout4, new FrameLayout.LayoutParams(b1.e(70), b1.e(70), 17));
                        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: a.q1
                            @Override // android.media.MediaPlayer.OnPreparedListener
                            public final void onPrepared(MediaPlayer mediaPlayer) {
                                mediaPlayer.setLooping(true);
                                videoView.start();
                            }
                        });
                        videoView.setVideoURI(c0094z12.f752a);
                        frameLayout3.setOnClickListener(new ViewOnClickListenerC0072s0(videoView, frameLayout4, 3));
                        activity = activity2;
                        i2 = 6;
                        i3 = -2;
                    } else {
                        ProgressBar progressBar = new ProgressBar(activity2);
                        frameLayout3.addView(progressBar, new FrameLayout.LayoutParams(b1.e(34), b1.e(34), 17));
                        i2 = 6;
                        activity = activity2;
                        new Thread(new T(b1, c0094z12, frameLayout, progressBar, frameLayout3, 1)).start();
                        ?? linearLayout3 = new LinearLayout(activity);
                        linearLayout3.setGravity(17);
                        linearLayout3.setPadding(b1.e(8), b1.e(10), b1.e(8), b1.e(6));
                        final int[] iArr = {-1, -16777216, -50384, -27392, -10742, -13318311, -16087809, -4236558};
                        final ArrayList arrayList2 = new ArrayList();
                        int i6 = 0;
                        for (int i7 = 8; i6 < i7; i7 = 8) {
                            final int i8 = iArr[i6];
                            View view2 = new View(activity);
                            arrayList2.add(view2);
                            view2.setOnClickListener(new View.OnClickListener() { // from class: a.r1
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view3) {
                                    B1 b12 = B1.this;
                                    int i9 = i8;
                                    b12.I = i9;
                                    C0091y1 c0091y13 = b12.F;
                                    if (c0091y13 != null) {
                                        c0091y13.f723d = i9;
                                    }
                                    b12.i(arrayList2, iArr);
                                }
                            });
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(b1.e(28), b1.e(28));
                            layoutParams.setMargins(b1.e(5), 0, b1.e(5), 0);
                            linearLayout3.addView(view2, layoutParams);
                            i6++;
                        }
                        b1.i(arrayList2, iArr);
                        i3 = -2;
                        linearLayout.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2));
                    }
                    ?? linearLayout4 = new LinearLayout(activity);
                    linearLayout4.setGravity(17);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(-16226561);
                    gradientDrawable.setCornerRadius(b1.e(10));
                    linearLayout4.setBackground(gradientDrawable);
                    linearLayout4.addView(b1.l("Send", 20.0f, -1, true), new LinearLayout.LayoutParams(i3, i3));
                    C1 c1 = new C1(activity, "send", -1);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b1.e(24), b1.e(24));
                    layoutParams2.leftMargin = b1.e(10);
                    linearLayout4.addView(c1, layoutParams2);
                    linearLayout4.setOnClickListener(new ViewOnClickListenerC0058o1(b1, 2));
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, b1.e(50));
                    layoutParams3.setMargins(b1.e(12), b1.e(i2), b1.e(12), b1.e(12));
                    linearLayout.addView(linearLayout4, layoutParams3);
                    frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
                    ?? r0 = b1.f42s;
                    if (r0 != 0) {
                        r0.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    } else {
                        i.b.g("top");
                        throw null;
                    }
                }
                return;
            case 5:
                ArrayList arrayList3 = r8.f40o;
                ArrayList arrayList4 = new ArrayList();
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!((C0094z1) next).f753b) {
                        arrayList4.add(next);
                    }
                }
                ArrayList arrayList5 = new ArrayList(c.d.E(arrayList4));
                Iterator it2 = arrayList4.iterator();
                while (it2.hasNext()) {
                    arrayList5.add(((C0094z1) it2.next()).f752a);
                }
                ArrayList arrayList6 = new ArrayList();
                Iterator it3 = arrayList3.iterator();
                while (it3.hasNext()) {
                    Object next2 = it3.next();
                    if (((C0094z1) next2).f753b) {
                        arrayList6.add(next2);
                    }
                }
                ArrayList arrayList7 = new ArrayList(c.d.E(arrayList6));
                Iterator it4 = arrayList6.iterator();
                while (it4.hasNext()) {
                    arrayList7.add(((C0094z1) it4.next()).f752a);
                }
                if (arrayList5.isEmpty() && arrayList7.isEmpty()) {
                    return;
                }
                r8.f(arrayList5, arrayList7);
                return;
            case 6:
                Dialog dialog2 = r8.f41r;
                if (dialog2 != null) {
                    dialog2.dismiss();
                    return;
                } else {
                    i.b.g("dlg");
                    throw null;
                }
            default:
                r8.j(null);
                return;
        }
    }
}
