package a;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nix.host.MainActivity;
import java.util.ArrayList;
import java.util.List;

/* renamed from: a.q2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0067q2 extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final List f630a;

    /* renamed from: b, reason: collision with root package name */
    public final int f631b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MainActivity f632c;

    public C0067q2(MainActivity mainActivity, ArrayList arrayList, int i2) {
        this.f632c = mainActivity;
        this.f630a = arrayList;
        int max = (Math.max(i2, 2) * 9) + 18;
        int i3 = MainActivity.R;
        this.f631b = mainActivity.n(max);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f630a.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i2) {
        return this.f630a.get(i2);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout;
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            MainActivity mainActivity = this.f632c;
            linearLayout = new LinearLayout(mainActivity);
            linearLayout.setOrientation(0);
            TextView textView = new TextView(mainActivity);
            Typeface typeface = Typeface.MONOSPACE;
            textView.setTypeface(typeface);
            textView.setTextSize(1, mainActivity.K * 13.0f);
            textView.setTextColor(-7236447);
            textView.setBackgroundColor(-14737628);
            textView.setGravity(8388613);
            textView.setPadding(mainActivity.n(4), mainActivity.n(3), mainActivity.n(8), mainActivity.n(3));
            linearLayout.addView(textView, new LinearLayout.LayoutParams(this.f631b, -1));
            TextView textView2 = new TextView(mainActivity);
            textView2.setTypeface(typeface);
            textView2.setTextSize(1, mainActivity.K * 14.0f);
            textView2.setTextColor(-591622);
            textView2.setLineSpacing(0.0f, 1.1f);
            textView2.setPadding(mainActivity.n(10), mainActivity.n(3), mainActivity.n(10), mainActivity.n(3));
            linearLayout.addView(textView2, new LinearLayout.LayoutParams(0, -2, 1.0f));
        }
        View childAt = linearLayout.getChildAt(0);
        i.b.c(childAt, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) childAt).setText(String.valueOf(i2 + 1));
        View childAt2 = linearLayout.getChildAt(1);
        i.b.c(childAt2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) childAt2).setText((CharSequence) this.f630a.get(i2));
        return linearLayout;
    }
}
