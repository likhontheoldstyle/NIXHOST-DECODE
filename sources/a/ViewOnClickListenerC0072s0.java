package a;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import java.util.ArrayList;

/* renamed from: a.s0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class ViewOnClickListenerC0072s0 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f650a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f651b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f652c;

    public /* synthetic */ ViewOnClickListenerC0072s0(Object obj, Object obj2, int i2) {
        this.f650a = i2;
        this.f651b = obj;
        this.f652c = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        switch (this.f650a) {
            case 0:
                C0006b1 c0006b1 = (C0006b1) this.f651b;
                boolean R = c0006b1.R();
                String str2 = c0006b1.f415b;
                if (R) {
                    String a2 = J0.a("muted_", str2);
                    SharedPreferences sharedPreferences = AbstractC0008c.f440c;
                    if (sharedPreferences == null) {
                        i.b.g("sp");
                        throw null;
                    }
                    sharedPreferences.edit().remove(a2).apply();
                } else {
                    String a3 = J0.a("muted_", str2);
                    SharedPreferences sharedPreferences2 = AbstractC0008c.f440c;
                    if (sharedPreferences2 == null) {
                        i.b.g("sp");
                        throw null;
                    }
                    sharedPreferences2.edit().putString(a3, "1").apply();
                }
                C0006b1.g0(c0006b1, (LinearLayout) this.f652c);
                return;
            case 1:
                ((h.b) this.f651b).a((String) this.f652c);
                return;
            case 2:
                ((Dialog) this.f651b).dismiss();
                ((h.b) this.f652c).a("");
                return;
            case 3:
                VideoView videoView = (VideoView) this.f651b;
                boolean isPlaying = videoView.isPlaying();
                FrameLayout frameLayout = (FrameLayout) this.f652c;
                if (isPlaying) {
                    videoView.pause();
                    frameLayout.setVisibility(0);
                    return;
                } else {
                    videoView.start();
                    frameLayout.setVisibility(8);
                    return;
                }
            default:
                C0094z1 c0094z1 = ((C0082v1) this.f651b).f686e;
                if (c0094z1 != null) {
                    B1 b1 = (B1) this.f652c;
                    ArrayList arrayList = b1.f40o;
                    if (arrayList.contains(c0094z1)) {
                        arrayList.remove(c0094z1);
                    } else {
                        if (arrayList.size() >= 10) {
                            Toast.makeText(b1.f26a, "You can select up to 10", 0).show();
                            return;
                        }
                        arrayList.add(c0094z1);
                    }
                    b1.J.notifyDataSetChanged();
                    int size = arrayList.size();
                    FrameLayout frameLayout2 = b1.y;
                    if (frameLayout2 == null) {
                        i.b.g("camFab");
                        throw null;
                    }
                    frameLayout2.setVisibility(size == 0 ? 0 : 8);
                    LinearLayout linearLayout = b1.z;
                    if (linearLayout == null) {
                        i.b.g("bar");
                        throw null;
                    }
                    linearLayout.setVisibility(size == 0 ? 8 : 0);
                    TextView textView = b1.A;
                    if (textView == null) {
                        i.b.g("prevBtn");
                        throw null;
                    }
                    textView.setVisibility(size != 1 ? 8 : 0);
                    TextView textView2 = b1.B;
                    if (textView2 == null) {
                        i.b.g("sendBtn");
                        throw null;
                    }
                    if (size >= 2) {
                        str = "Send " + size;
                    } else {
                        str = "Send";
                    }
                    textView2.setText(str);
                    return;
                }
                return;
        }
    }
}
