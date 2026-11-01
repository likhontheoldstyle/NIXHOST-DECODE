package a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

/* loaded from: classes.dex */
public final class Q0 extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f274a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f275b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h.b f276c;

    public Q0(List list, C0006b1 c0006b1, C0086x c0086x) {
        this.f274a = list;
        this.f275b = c0006b1;
        this.f276c = c0086x;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f274a.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i2) {
        return this.f274a.get(i2);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i2) {
        return !(this.f274a.get(i2) instanceof String) ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        Object obj = this.f274a.get(i2);
        boolean z = obj instanceof String;
        C0006b1 c0006b1 = this.f275b;
        if (z) {
            TextView textView = view instanceof TextView ? (TextView) view : null;
            if (textView == null) {
                textView = c0006b1.f1("", 21.0f, c0006b1.f425l, true);
                float f2 = 10;
                textView.setPadding(c0006b1.z(f2), c0006b1.z(16), c0006b1.z(f2), c0006b1.z(6));
            }
            textView.setText((CharSequence) obj);
            return textView;
        }
        i.b.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        List list = (List) obj;
        LinearLayout linearLayout = view instanceof LinearLayout ? (LinearLayout) view : null;
        if (linearLayout == null) {
            linearLayout = new LinearLayout(c0006b1.f414a);
            linearLayout.setOrientation(0);
            for (int i3 = 0; i3 < 7; i3++) {
                TextView textView2 = new TextView(c0006b1.f414a);
                textView2.setTextSize(1, 28.83f);
                textView2.setGravity(17);
                linearLayout.addView(textView2, new LinearLayout.LayoutParams(0, c0006b1.z(52), 1.0f));
            }
        }
        for (int i4 = 0; i4 < 7; i4++) {
            View childAt = linearLayout.getChildAt(i4);
            i.b.c(childAt, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView3 = (TextView) childAt;
            if (i4 < list.size()) {
                String str = (String) list.get(i4);
                c0006b1.getClass();
                textView3.setText(str);
                textView3.setVisibility(0);
                textView3.setOnClickListener(new ViewOnClickListenerC0072s0((C0086x) this.f276c, str, 1));
            } else {
                textView3.setText("");
                textView3.setVisibility(4);
                textView3.setOnClickListener(null);
            }
        }
        return linearLayout;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 2;
    }
}
