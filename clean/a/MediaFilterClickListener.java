package a;

import android.view.View;
import android.widget.TextView;

public final class MediaFilterClickListener implements View.OnClickListener {

    public final int mode;

    public final MediaPicker picker;

    public final String filterKey;

    public final String label;

    public MediaFilterClickListener(MediaPicker mediaPicker, String str, String str2, int i2) {
        this.mode = i2;
        this.picker = mediaPicker;
        this.filterKey = str;
        this.label = str2;
    }

    @Override
    public final void onClick(View view) {
        switch (this.mode) {
            case 0:
                MediaPicker mediaPicker = this.picker;
                mediaPicker.filterKey = this.filterKey;
                TextView textView = mediaPicker.titleView;
                if (textView == null) {
                    i.b.g("titleTv");
                    throw null;
                }
                textView.setText(this.label);
                mediaPicker.applyFilter();
                mediaPicker.toggleFilterMenu(Boolean.FALSE);
                return;
            default:
                MediaPicker mediaPicker2 = this.picker;
                mediaPicker2.filterKey = this.filterKey;
                TextView textView2 = mediaPicker2.titleView;
                if (textView2 == null) {
                    i.b.g("titleTv");
                    throw null;
                }
                textView2.setText(this.label);
                mediaPicker2.applyFilter();
                mediaPicker2.toggleFilterMenu(Boolean.FALSE);
                return;
        }
    }
}
