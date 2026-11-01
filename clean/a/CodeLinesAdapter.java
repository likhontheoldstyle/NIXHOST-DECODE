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

public final class CodeLinesAdapter extends BaseAdapter {

    public final List lines;

    public final int gutterWidth;

    public final MainActivity activity;

    public CodeLinesAdapter(MainActivity mainActivity, ArrayList arrayList, int i2) {
        this.activity = mainActivity;
        this.lines = arrayList;
        int max = (Math.max(i2, 2) * 9) + 18;
        int i3 = MainActivity.R;
        this.gutterWidth = mainActivity.dp(max);
    }

    @Override
    public final int getCount() {
        return this.lines.size();
    }

    @Override
    public final Object getItem(int i2) {
        return this.lines.get(i2);
    }

    @Override
    public final long getItemId(int i2) {
        return i2;
    }

    @Override
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout;
        if (view instanceof LinearLayout) {
            linearLayout = (LinearLayout) view;
        } else {
            MainActivity mainActivity = this.activity;
            linearLayout = new LinearLayout(mainActivity);
            linearLayout.setOrientation(0);
            TextView textView = new TextView(mainActivity);
            Typeface typeface = Typeface.MONOSPACE;
            textView.setTypeface(typeface);
            textView.setTextSize(1, mainActivity.uiScale * 13.0f);
            textView.setTextColor(-7236447);
            textView.setBackgroundColor(-14737628);
            textView.setGravity(8388613);
            textView.setPadding(mainActivity.dp(4), mainActivity.dp(3), mainActivity.dp(8), mainActivity.dp(3));
            linearLayout.addView(textView, new LinearLayout.LayoutParams(this.gutterWidth, -1));
            TextView textView2 = new TextView(mainActivity);
            textView2.setTypeface(typeface);
            textView2.setTextSize(1, mainActivity.uiScale * 14.0f);
            textView2.setTextColor(-591622);
            textView2.setLineSpacing(0.0f, 1.1f);
            textView2.setPadding(mainActivity.dp(10), mainActivity.dp(3), mainActivity.dp(10), mainActivity.dp(3));
            linearLayout.addView(textView2, new LinearLayout.LayoutParams(0, -2, 1.0f));
        }
        View childAt = linearLayout.getChildAt(0);
        i.b.c(childAt, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) childAt).setText(String.valueOf(i2 + 1));
        View childAt2 = linearLayout.getChildAt(1);
        i.b.c(childAt2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) childAt2).setText((CharSequence) this.lines.get(i2));
        return linearLayout;
    }
}
