package a;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class Y0 extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f379a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f380b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f381c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Dialog f382d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h.b f383e;

    public Y0(ArrayList arrayList, Object obj, C0006b1 c0006b1, Dialog dialog, h.b bVar) {
        this.f379a = arrayList;
        this.f380b = obj;
        this.f381c = c0006b1;
        this.f382d = dialog;
        this.f383e = bVar;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f379a.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i2) {
        return this.f379a.get(i2);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i2) {
        ArrayList arrayList = this.f379a;
        if (arrayList.get(i2) instanceof String) {
            return 0;
        }
        return arrayList.get(i2) == this.f380b ? 2 : 1;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        Object obj = this.f379a.get(i2);
        Object obj2 = this.f380b;
        h.b bVar = this.f383e;
        Dialog dialog = this.f382d;
        int i3 = 17;
        C0006b1 c0006b1 = this.f381c;
        if (obj == obj2) {
            LinearLayout linearLayout = new LinearLayout(c0006b1.f414a);
            linearLayout.setOrientation(0);
            FrameLayout frameLayout = new FrameLayout(c0006b1.f414a);
            float f2 = 42;
            frameLayout.addView(c0006b1.M("like", c0006b1.f421h, 42), new FrameLayout.LayoutParams(c0006b1.z(f2), c0006b1.z(f2), 17));
            frameLayout.setOnClickListener(new ViewOnClickListenerC0072s0(dialog, bVar, 2));
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, c0006b1.z(77.0f), 1.0f));
            for (int i4 = 0; i4 < 4; i4++) {
                linearLayout.addView(new View(c0006b1.f414a), new LinearLayout.LayoutParams(0, c0006b1.z(77.0f), 1.0f));
            }
            return linearLayout;
        }
        if (obj instanceof String) {
            TextView textView = view instanceof TextView ? (TextView) view : null;
            if (textView == null) {
                textView = c0006b1.f1("", 20.0f, c0006b1.f426m, true);
                textView.setPadding(c0006b1.z(13.5f), c0006b1.z(16.0f), c0006b1.z(10), c0006b1.z(2));
            }
            textView.setText((CharSequence) obj);
            return textView;
        }
        i.b.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        List list = (List) obj;
        LinearLayout linearLayout2 = view instanceof LinearLayout ? (LinearLayout) view : null;
        if (linearLayout2 == null) {
            linearLayout2 = new LinearLayout(c0006b1.f414a);
            linearLayout2.setOrientation(0);
            int i5 = 0;
            while (i5 < 5) {
                TextView textView2 = new TextView(c0006b1.f414a);
                textView2.setTextSize(1, 35.34f);
                textView2.setGravity(i3);
                linearLayout2.addView(textView2, new LinearLayout.LayoutParams(0, c0006b1.z(77.0f), 1.0f));
                i5++;
                i3 = 17;
            }
        }
        for (int i6 = 0; i6 < 5; i6++) {
            View childAt = linearLayout2.getChildAt(i6);
            i.b.c(childAt, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView3 = (TextView) childAt;
            if (i6 < list.size()) {
                String str = (String) list.get(i6);
                c0006b1.getClass();
                textView3.setText(str);
                textView3.setVisibility(0);
                textView3.setOnClickListener(new ViewOnClickListenerC0016e(dialog, bVar, str, 1));
            } else {
                textView3.setText("");
                textView3.setVisibility(4);
                textView3.setOnClickListener(null);
            }
        }
        return linearLayout2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 3;
    }
}
