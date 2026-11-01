package a;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.nix.host.MainActivity;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final /* synthetic */ class Q1 implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f277a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i.d f278b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MainActivity f279c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f280d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ View f281e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ View f282f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ View f283g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ View f284h;

    public /* synthetic */ Q1(G1 g1, s2 s2Var, View view, FrameLayout frameLayout, MainActivity mainActivity, h.a aVar, i.d dVar) {
        this.f280d = aVar;
        this.f278b = dVar;
        this.f279c = mainActivity;
        this.f281e = g1;
        this.f282f = s2Var;
        this.f283g = view;
        this.f284h = frameLayout;
    }

    @Override // h.a
    public final Object a() {
        View view = this.f284h;
        View view2 = this.f282f;
        View view3 = this.f281e;
        Object obj = this.f280d;
        switch (this.f277a) {
            case 0:
                i.d dVar = this.f278b;
                MainActivity.b((G1) view3, (s2) view2, this.f283g, (FrameLayout) view, this.f279c, (h.a) obj, dVar);
                break;
            default:
                int i2 = MainActivity.R;
                final i.d dVar2 = this.f278b;
                if (!dVar2.f846a) {
                    final String obj2 = m.e.h0(((EditText) obj).getText().toString()).toString();
                    final String obj3 = ((EditText) view3).getText().toString();
                    final TextView textView = (TextView) view2;
                    if (obj2.length() == 0 || obj3.length() == 0) {
                        textView.setText("Enter username and password");
                        textView.setVisibility(0);
                    } else {
                        dVar2.f846a = true;
                        textView.setVisibility(8);
                        final TextView textView2 = (TextView) this.f283g;
                        textView2.setVisibility(4);
                        final ProgressBar progressBar = (ProgressBar) view;
                        progressBar.setVisibility(0);
                        final MainActivity mainActivity = this.f279c;
                        mainActivity.s();
                        new Thread(new Runnable() { // from class: a.P1
                            @Override // java.lang.Runnable
                            public final void run() {
                                int i3 = MainActivity.R;
                                JSONObject jSONObject = new JSONObject();
                                final String str = obj2;
                                final C0000a a2 = C0004b.a("POST", "/login", jSONObject.put("username", str).put("password", obj3), false);
                                final JSONObject c2 = a2.c();
                                final TextView textView3 = textView2;
                                final TextView textView4 = textView;
                                final MainActivity mainActivity2 = mainActivity;
                                final i.d dVar3 = dVar2;
                                final ProgressBar progressBar2 = progressBar;
                                mainActivity2.runOnUiThread(new Runnable() { // from class: a.W1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        C0000a c0000a = C0000a.this;
                                        JSONObject jSONObject2 = c2;
                                        MainActivity mainActivity3 = mainActivity2;
                                        String str2 = str;
                                        i.d dVar4 = dVar3;
                                        ProgressBar progressBar3 = progressBar2;
                                        TextView textView5 = textView3;
                                        TextView textView6 = textView4;
                                        int i4 = MainActivity.R;
                                        if (c0000a.f400a == 0) {
                                            dVar4.f846a = false;
                                            progressBar3.setVisibility(8);
                                            textView5.setVisibility(0);
                                            textView6.setText("Cannot reach the server. Check internet and try again.");
                                            textView6.setVisibility(0);
                                            return;
                                        }
                                        if (!c0000a.b() || jSONObject2 == null) {
                                            String a3 = c0000a.a();
                                            dVar4.f846a = false;
                                            progressBar3.setVisibility(8);
                                            textView5.setVisibility(0);
                                            if (a3.length() > 0) {
                                                textView6.setText(a3);
                                                textView6.setVisibility(0);
                                                return;
                                            }
                                            return;
                                        }
                                        String optString = jSONObject2.optString("session", "");
                                        SharedPreferences sharedPreferences = AbstractC0008c.f440c;
                                        if (sharedPreferences == null) {
                                            i.b.g("sp");
                                            throw null;
                                        }
                                        sharedPreferences.edit().putString("session", optString).apply();
                                        File filesDir = mainActivity3.getFilesDir();
                                        jSONObject2.remove("session");
                                        AbstractC0008c.f438a = jSONObject2;
                                        try {
                                            g.m.L(new File(filesDir, "c_me.json"), jSONObject2.toString());
                                        } catch (Exception unused) {
                                        }
                                        String optString2 = jSONObject2.optString("username", str2);
                                        mainActivity3.f785e = optString2;
                                        SharedPreferences sharedPreferences2 = AbstractC0008c.f440c;
                                        if (sharedPreferences2 == null) {
                                            i.b.g("sp");
                                            throw null;
                                        }
                                        sharedPreferences2.edit().putString("user", optString2).apply();
                                        i.g gVar = B2.f46a;
                                        mainActivity3.f795o = B2.b(mainActivity3, mainActivity3.f785e);
                                        mainActivity3.f786f = System.currentTimeMillis();
                                        mainActivity3.f789i = false;
                                        mainActivity3.N();
                                        mainActivity3.w();
                                    }
                                });
                            }
                        }).start();
                    }
                }
                break;
        }
        return b.d.f770c;
    }

    public /* synthetic */ Q1(i.d dVar, EditText editText, EditText editText2, TextView textView, TextView textView2, ProgressBar progressBar, MainActivity mainActivity) {
        this.f278b = dVar;
        this.f280d = editText;
        this.f281e = editText2;
        this.f282f = textView;
        this.f283g = textView2;
        this.f284h = progressBar;
        this.f279c = mainActivity;
    }
}
