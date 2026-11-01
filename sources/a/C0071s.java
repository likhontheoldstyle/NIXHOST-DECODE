package a;

import android.app.Dialog;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nix.host.MainActivity;
import java.io.File;
import java.util.Locale;

/* renamed from: a.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0071s implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f645a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f646b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f647c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f648d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f649e;

    public /* synthetic */ C0071s(MainActivity mainActivity, C0038j1 c0038j1, String str, File file) {
        this.f645a = 6;
        this.f647c = mainActivity;
        this.f646b = c0038j1;
        this.f649e = str;
        this.f648d = file;
    }

    @Override // h.a
    public final Object a() {
        int i2 = 2;
        int i3 = 3;
        int i4 = 1;
        Object obj = this.f648d;
        Object obj2 = this.f649e;
        Object obj3 = this.f646b;
        Object obj4 = this.f647c;
        switch (this.f645a) {
            case 0:
                RunnableC0064q runnableC0064q = (RunnableC0064q) ((Runnable) obj);
                TextView textView = (TextView) obj4;
                textView.setText("Downloading...");
                textView.setVisibility(0);
                C0006b1 c0006b1 = (C0006b1) obj3;
                c0006b1.f418e.removeCallbacks(runnableC0064q);
                c0006b1.f418e.postDelayed(runnableC0064q, 2400L);
                new Thread(new K(runnableC0064q, c0006b1, textView, (String) obj2)).start();
                break;
            case 1:
                String obj5 = m.e.h0(((EditText) obj4).getText().toString()).toString();
                if (obj5.length() > 0) {
                    C0006b1 c0006b12 = (C0006b1) obj3;
                    c0006b12.T = (K0) obj;
                    C0006b1.m0(c0006b12, "text", obj5, null, 60);
                    ((Dialog) obj2).dismiss();
                }
                break;
            case 2:
                File file = (File) ((i.g) obj2).f850b;
                TextView textView2 = (TextView) obj4;
                C0006b1 c0006b13 = (C0006b1) obj3;
                Runnable runnable = (Runnable) obj;
                if (file == null) {
                    C0006b1.h0((RunnableC0064q) runnable, c0006b13, textView2, "Please wait, the video is loading");
                } else {
                    RunnableC0064q runnableC0064q2 = (RunnableC0064q) runnable;
                    C0006b1.h0(runnableC0064q2, c0006b13, textView2, "Downloading...");
                    new Thread(new K(file, c0006b13, textView2, runnableC0064q2, 3)).start();
                }
                break;
            case 3:
                i.d dVar = (i.d) obj4;
                if (!dVar.f846a) {
                    dVar.f846a = true;
                    String obj6 = m.e.h0(((EditText) obj3).getText().toString()).toString();
                    ((Dialog) obj).dismiss();
                    ((h.b) obj2).a(obj6);
                }
                break;
            case 4:
                int i5 = MainActivity.R;
                String obj7 = m.e.h0(((EditText) obj4).getText().toString()).toString();
                if (obj7.length() == 0) {
                    ((MainActivity) obj3).T("Name required");
                } else {
                    ((Dialog) obj).dismiss();
                    ((h.b) obj2).a(obj7);
                }
                break;
            case 5:
                int i6 = MainActivity.R;
                i.e eVar = (i.e) obj4;
                int i7 = eVar.f847a;
                LinearLayout linearLayout = (LinearLayout) obj3;
                MainActivity mainActivity = (MainActivity) obj;
                File file2 = (File) obj2;
                if (i7 == 1) {
                    eVar.f847a = 0;
                    linearLayout.setVisibility(8);
                    mainActivity.E("Rename", "New name", file2.getName(), "Save", new C0015d2(mainActivity, file2));
                } else if (i7 == 2) {
                    eVar.f847a = 0;
                    linearLayout.setVisibility(8);
                    mainActivity.k(J0.a("Delete ", file2.getName()), new R1(file2, mainActivity, i2));
                } else if (i7 == 3) {
                    if (file2.isFile()) {
                        String lowerCase = file2.getName().toLowerCase(Locale.ROOT);
                        i.b.d(lowerCase, "toLowerCase(...)");
                        if (lowerCase.endsWith(".zip")) {
                            eVar.f847a = 0;
                            linearLayout.setVisibility(8);
                            String name = file2.getName();
                            String substring = file2.getName().substring(0, file2.getName().length() - 4);
                            i.b.d(substring, "substring(...)");
                            String str = "Unzip \"" + name + "\" into a folder named " + substring + " ?";
                            R1 r1 = new R1(mainActivity, file2, i3);
                            mainActivity.getClass();
                            MainActivity.g(mainActivity, 0, false, new N1(mainActivity, "Unzip", str, "Unzip", -429290, r1), 3);
                        }
                    }
                    mainActivity.T("Tap a .zip file");
                } else if (file2.isDirectory()) {
                    mainActivity.f794n = file2;
                    mainActivity.L();
                } else {
                    mainActivity.S(file2);
                }
                break;
            default:
                int i8 = MainActivity.R;
                MainActivity mainActivity2 = (MainActivity) obj4;
                mainActivity2.s();
                File file3 = (File) obj;
                if (i.b.a(((C0038j1) obj3).getText().toString(), (String) obj2)) {
                    mainActivity2.S(file3);
                } else {
                    MainActivity.g(mainActivity2, 0, false, new N1(mainActivity2, "Discard changes?", "Your edits will be lost.", "Discard", -429290, new R1(mainActivity2, file3, i4)), 3);
                }
                break;
        }
        return b.d.f770c;
    }

    public /* synthetic */ C0071s(i.g gVar, TextView textView, C0006b1 c0006b1, RunnableC0064q runnableC0064q) {
        this.f645a = 2;
        this.f649e = gVar;
        this.f647c = textView;
        this.f646b = c0006b1;
        this.f648d = runnableC0064q;
    }

    public /* synthetic */ C0071s(Object obj, Object obj2, Object obj3, Object obj4, int i2) {
        this.f645a = i2;
        this.f647c = obj;
        this.f646b = obj2;
        this.f648d = obj3;
        this.f649e = obj4;
    }
}
