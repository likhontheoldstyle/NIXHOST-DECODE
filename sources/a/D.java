package a;

import android.R;
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

/* loaded from: classes.dex */
public final /* synthetic */ class D implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f60a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f61b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f62c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f63d;

    public /* synthetic */ D(i.d dVar, C1 c1, i.g gVar) {
        this.f60a = 1;
        this.f61b = dVar;
        this.f62c = c1;
        this.f63d = gVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0066, code lost:
    
        if (r2 == null) goto L49;
     */
    @Override // h.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a() {
        String str;
        String str2;
        File m2;
        switch (this.f60a) {
            case 0:
                if (((i.d) this.f61b).f846a) {
                    VideoView videoView = (VideoView) this.f63d;
                    boolean isPlaying = videoView.isPlaying();
                    C1 c1 = (C1) this.f62c;
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
                i.d dVar = (i.d) this.f61b;
                boolean z = !dVar.f846a;
                dVar.f846a = z;
                ((C1) this.f62c).set(z ? "mute" : "volume");
                MediaPlayer mediaPlayer = (MediaPlayer) ((i.g) this.f63d).f850b;
                if (mediaPlayer != null) {
                    boolean z2 = dVar.f846a;
                    mediaPlayer.setVolume(z2 ? 0.0f : 1.0f, z2 ? 0.0f : 1.0f);
                }
                break;
            case 2:
                C0006b1 c0006b1 = (C0006b1) this.f61b;
                c0006b1.getClass();
                Activity activity = c0006b1.f414a;
                Dialog dialog = new Dialog(activity, R.style.Theme.Black.NoTitleBar);
                DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
                C0022f1 c0022f1 = (C0022f1) this.f63d;
                boolean z3 = c0022f1.f484d;
                int i2 = z3 ? c0006b1.f425l : c0022f1.f487g;
                int i3 = z3 ? c0006b1.f426m : c0022f1.f488h;
                FrameLayout frameLayout = new FrameLayout(activity);
                boolean z4 = c0022f1.f484d;
                int i4 = (int) (displayMetrics.widthPixels * 0.5f);
                int i5 = (int) (displayMetrics.heightPixels * 0.5f);
                frameLayout.addView(new N2(c0006b1.f414a, z4 ? null : c0022f1, c0006b1.f422i, i4 < 200 ? 200 : i4, i5 < 300 ? 300 : i5), new FrameLayout.LayoutParams(-1, -1));
                LinearLayout k1 = c0006b1.k1();
                LinearLayout P = c0006b1.P();
                P.setPadding(c0006b1.z(2.0f), c0006b1.z(9.0f), c0006b1.z(8.0f), c0006b1.z(9.0f));
                P.setBackgroundColor(z4 ? 0 : c0022f1.f494n);
                FrameLayout frameLayout2 = new FrameLayout(activity);
                float f2 = 26;
                frameLayout2.addView(new G1(activity, "back", i2, 2.4f), new FrameLayout.LayoutParams(c0006b1.z(f2), c0006b1.z(f2), 17));
                C0006b1.n0(frameLayout2, new C0060p(dialog, 3));
                float f3 = 44;
                P.addView(frameLayout2, C0006b1.X(c0006b1, c0006b1.z(f3), c0006b1.z(f3), 0, 0, 0, 60));
                P.addView(c0006b1.f1("Previewing " + c0022f1.f482b, 21.0f, i2, true), new LinearLayout.LayoutParams(0, -2, 1.0f));
                k1.addView(P, C0006b1.X(c0006b1, -1, -2, 0, 0, 0, 60));
                LinearLayout k12 = c0006b1.k1();
                k12.setPadding(c0006b1.z(14.0f), c0006b1.z(14.0f), c0006b1.z(14.0f), c0006b1.z(14.0f));
                C0006b1.c1(k12, c0006b1, c0006b1.o0("There are many themes to choose from and they're all a little different.", true, c0022f1), true, 4);
                C0006b1.c1(k12, c0006b1, c0006b1.o0("You'll see the messages you send to other people in this color.", true, c0022f1), true, 3);
                C0006b1.c1(k12, c0006b1, c0006b1.o0("And messages from your friends will look like this.", false, c0022f1), false, 8);
                TextView f1 = c0006b1.f1("7:00 AM", 14.0f, i3, false);
                f1.setGravity(17);
                k12.addView(f1, c0006b1.W(-1, -2, 0, 12, 0, 6));
                C0006b1.c1(k12, c0006b1, c0006b1.o0("Tap Select to choose this theme or Cancel to preview others.", true, c0022f1), true, 3);
                k1.addView(k12, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                LinearLayout P2 = c0006b1.P();
                P2.setPadding(c0006b1.z(12.0f), c0006b1.z(8.0f), c0006b1.z(12.0f), c0006b1.z(14.0f));
                TextView f12 = c0006b1.f1("Cancel", 19.0f, -15658735, true);
                f12.setGravity(17);
                f12.setBackground(c0006b1.N0(-2318, 14.0f, 0, 0.0f));
                f12.setOnClickListener(new ViewOnClickListenerC0074t(1, dialog));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, c0006b1.z(52.0f), 1.0f);
                layoutParams.rightMargin = c0006b1.z(6.0f);
                P2.addView(f12, layoutParams);
                TextView f13 = c0006b1.f1("Select", 19.0f, -1, true);
                f13.setGravity(17);
                f13.setBackground(c0006b1.N0(z4 ? c0006b1.f420g : (16777215 & c0022f1.f491k) | (-16777216), 14.0f, 0, 0.0f));
                f13.setOnClickListener(new ViewOnClickListenerC0077u(c0006b1, c0022f1, dialog, (E2) this.f62c));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, c0006b1.z(52.0f), 1.0f);
                layoutParams2.leftMargin = c0006b1.z(6.0f);
                P2.addView(f13, layoutParams2);
                k1.addView(P2, C0006b1.X(c0006b1, -1, -2, 0, 0, 0, 60));
                frameLayout.addView(k1, new FrameLayout.LayoutParams(-1, -1));
                dialog.setContentView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
                Window window = dialog.getWindow();
                if (window != null) {
                    int i6 = c0006b1.f422i;
                    window.setBackgroundDrawable(new ColorDrawable(i6));
                    window.setLayout(-1, -1);
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(z4 ? i6 : c0022f1.f485e);
                    if (!z4) {
                        i6 = c0022f1.f486f;
                    }
                    window.setNavigationBarColor(i6);
                    boolean z5 = z4 ? !c0006b1.f419f : c0022f1.q;
                    View decorView = window.getDecorView();
                    decorView.setSystemUiVisibility(z5 ? decorView.getSystemUiVisibility() | 8208 : decorView.getSystemUiVisibility() & (-8209));
                }
                c0006b1.T0(dialog);
                break;
            case 3:
                ((C0006b1) this.f61b).m1((K0) this.f62c, (String) this.f63d);
                break;
            case 4:
                MainActivity mainActivity = (MainActivity) this.f61b;
                if (mainActivity.f791k == null) {
                    G1 g1 = (G1) this.f62c;
                    g1.set("down");
                    View view = new View(mainActivity);
                    view.setBackgroundColor(0);
                    view.setClickable(true);
                    view.setAlpha(0.0f);
                    int i7 = mainActivity.f781a;
                    ViewGroup.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i7, i7);
                    FrameLayout frameLayout3 = (FrameLayout) this.f63d;
                    frameLayout3.addView(view, layoutParams3);
                    i.g gVar = new i.g();
                    gVar.f850b = new C0085w1(3);
                    i.g gVar2 = new i.g();
                    gVar2.f850b = new C0031h2(0);
                    s2 s2Var = new s2(mainActivity, ViewConfiguration.get(mainActivity).getScaledTouchSlop(), gVar, gVar2);
                    s2Var.setOrientation(1);
                    float n2 = mainActivity.n(28);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(AbstractC0008c.f442e ? -14540254 : -1);
                    gradientDrawable.setCornerRadii(new float[]{n2, n2, n2, n2, 0.0f, 0.0f, 0.0f, 0.0f});
                    gradientDrawable.setStroke(mainActivity.n(1), AbstractC0008c.f442e ? -13684945 : -1710101);
                    s2Var.setBackground(gradientDrawable);
                    s2Var.setElevation(mainActivity.n(16));
                    s2Var.setClickable(true);
                    s2Var.setPadding(mainActivity.n(24), mainActivity.n(12), mainActivity.n(24), mainActivity.n(12));
                    View view2 = new View(mainActivity);
                    view2.setBackground(mainActivity.I(AbstractC0008c.f442e ? -13684945 : -1710101, 3, 0, 0));
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(mainActivity.n(40), mainActivity.n(5));
                    layoutParams4.gravity = 1;
                    layoutParams4.bottomMargin = mainActivity.n(6);
                    s2Var.addView(view2, layoutParams4);
                    i.d dVar2 = new i.d();
                    MainActivity.c(mainActivity, s2Var, dVar2, g1, view, frameLayout3, "Permission", AbstractC0008c.f442e ? -1 : -15656921, new K1(mainActivity, 8));
                    View view3 = new View(mainActivity);
                    view3.setBackgroundColor(AbstractC0008c.f442e ? -13684945 : -1710101);
                    s2Var.addView(view3, MainActivity.v(mainActivity, mainActivity.f781a, 1, 0, 0, 0, 60));
                    MainActivity.c(mainActivity, s2Var, dVar2, g1, view, frameLayout3, "Logout", -1096636, new K1(mainActivity, 9));
                    MainActivity.D(view, new C0035i2(dVar2, mainActivity, g1, s2Var, view, frameLayout3, 0));
                    mainActivity.f791k = new C0035i2(dVar2, mainActivity, g1, s2Var, view, frameLayout3, 1);
                    gVar.f850b = new G0(dVar2, s2Var, view, 2);
                    gVar2.f850b = new L1(s2Var, dVar2, mainActivity, g1, view, frameLayout3);
                    s2Var.setVisibility(4);
                    frameLayout3.addView(s2Var, new FrameLayout.LayoutParams(i7, mainActivity.f782b, 80));
                    s2Var.post(new U(s2Var, view, 6));
                }
                break;
            default:
                EditText editText = (EditText) this.f61b;
                K2 k2 = (K2) this.f63d;
                MainActivity mainActivity2 = (MainActivity) this.f62c;
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
                    m2 = k2.m(str2);
                    break;
                } else {
                    m2 = k2.f172f;
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
                MainActivity.A(editText, mainActivity2);
                break;
        }
        return b.d.f770c;
    }

    public /* synthetic */ D(Object obj, Object obj2, Object obj3, int i2) {
        this.f60a = i2;
        this.f61b = obj;
        this.f63d = obj2;
        this.f62c = obj3;
    }
}
