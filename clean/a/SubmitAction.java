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

public final class SubmitAction implements h.a {

    public final int mode;

    public final i.d busyRef;

    public final MainActivity activity;

    public final Object first;

    public final View second;

    public final View third;

    public final View fourth;

    public final View fifth;

    public SubmitAction(IconView g1, DragSheetLayout s2Var, View view, FrameLayout frameLayout, MainActivity mainActivity, h.a aVar, i.d dVar) {
        this.mode = 0;
        this.first = aVar;
        this.busyRef = dVar;
        this.activity = mainActivity;
        this.second = g1;
        this.third = s2Var;
        this.fourth = view;
        this.fifth = frameLayout;
    }

    @Override
    public final Object a() {
        View view = this.fifth;
        View view2 = this.third;
        View view3 = this.second;
        Object obj = this.first;
        switch (this.mode) {
            case 0:
                i.d dVar = this.busyRef;
                MainActivity.animateEmojiPanelClose((IconView) view3, (DragSheetLayout) view2, this.fourth, (FrameLayout) view, this.activity, (h.a) obj, dVar);
                break;
            default:
                int i2 = MainActivity.R;
                final i.d dVar2 = this.busyRef;
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
                        final TextView textView2 = (TextView) this.fourth;
                        textView2.setVisibility(4);
                        final ProgressBar progressBar = (ProgressBar) view;
                        progressBar.setVisibility(0);
                        final MainActivity mainActivity = this.activity;
                        mainActivity.hideKeyboard();
                        new Thread(new Runnable() {
                            @Override
                            public final void run() {
                                int i3 = MainActivity.R;
                                JSONObject jSONObject = new JSONObject();
                                final String str = obj2;
                                final ApiResponse a2 = ApiClient.request("POST", "/login", jSONObject.put("username", str).put("password", obj3), false);
                                final JSONObject c2 = a2.json();
                                final TextView textView3 = textView2;
                                final TextView textView4 = textView;
                                final MainActivity mainActivity2 = mainActivity;
                                final i.d dVar3 = dVar2;
                                final ProgressBar progressBar2 = progressBar;
                                mainActivity2.runOnUiThread(new Runnable() {
                                    @Override
                                    public final void run() {
                                        ApiResponse apiResponse = a2;
                                        JSONObject jSONObject2 = c2;
                                        MainActivity mainActivity3 = mainActivity2;
                                        String str2 = str;
                                        i.d dVar4 = dVar3;
                                        ProgressBar progressBar3 = progressBar2;
                                        TextView textView5 = textView3;
                                        TextView textView6 = textView4;
                                        int i4 = MainActivity.R;
                                        if (apiResponse.code == 0) {
                                            dVar4.f846a = false;
                                            progressBar3.setVisibility(8);
                                            textView5.setVisibility(0);
                                            textView6.setText("Cannot reach the server. Check internet and try again.");
                                            textView6.setVisibility(0);
                                            return;
                                        }
                                        if (!apiResponse.isSuccess() || jSONObject2 == null) {
                                            String a3 = apiResponse.errorMessage();
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
                                        SharedPreferences sharedPreferences = AppState.prefs;
                                        if (sharedPreferences == null) {
                                            i.b.g("sp");
                                            throw null;
                                        }
                                        sharedPreferences.edit().putString("session", optString).apply();
                                        File filesDir = mainActivity3.getFilesDir();
                                        jSONObject2.remove("session");
                                        AppState.meJson = jSONObject2;
                                        try {
                                            g.m.L(new File(filesDir, "c_me.json"), jSONObject2.toString());
                                        } catch (Exception unused) {
                                        }
                                        String optString2 = jSONObject2.optString("username", str2);
                                        mainActivity3.username = optString2;
                                        SharedPreferences sharedPreferences2 = AppState.prefs;
                                        if (sharedPreferences2 == null) {
                                            i.b.g("sp");
                                            throw null;
                                        }
                                        sharedPreferences2.edit().putString("user", optString2).apply();
                                        i.g gVar = Workspace.namePattern;
                                        mainActivity3.homeDir = Workspace.homeDir(mainActivity3, mainActivity3.username);
                                        mainActivity3.lastRefreshAt = System.currentTimeMillis();
                                        mainActivity3.expiryWarned = false;
                                        mainActivity3.showHome();
                                        mainActivity3.maybeShowExpiryWarning();
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

    public SubmitAction(i.d dVar, EditText editText, EditText editText2, TextView textView, TextView textView2, ProgressBar progressBar, MainActivity mainActivity) {
        this.mode = 1;
        this.busyRef = dVar;
        this.first = editText;
        this.second = editText2;
        this.third = textView;
        this.fourth = textView2;
        this.fifth = progressBar;
        this.activity = mainActivity;
    }
}
