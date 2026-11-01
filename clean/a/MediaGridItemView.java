package a;

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public final class MediaGridItemView extends FrameLayout {

    public final ImageView imageView;

    public final View selectionBorder;

    public final TextView durationLabel;

    public final TextView selectionBadge;

    public MediaItem item;

    public String uriString;

    public final MediaPicker owner;

    public MediaGridItemView(MediaPicker mediaPicker) {
        super(mediaPicker.activity);
        this.owner = mediaPicker;
        Activity activity = mediaPicker.activity;
        ImageView imageView = new ImageView(activity);
        this.imageView = imageView;
        View view = new View(activity);
        this.selectionBorder = view;
        TextView textView = new TextView(activity);
        this.durationLabel = textView;
        TextView textView2 = new TextView(activity);
        this.selectionBadge = textView2;
        this.uriString = "";
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setBackgroundColor(mediaPicker.surfaceColor);
        addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setStroke(mediaPicker.e(3), -16226561);
        view.setBackground(gradientDrawable);
        view.setVisibility(8);
        addView(view, new FrameLayout.LayoutParams(-1, -1));
        textView.setTextColor(-1);
        textView.setTextSize(1, 17.0f);
        textView.setShadowLayer(5.0f, 0.0f, 0.0f, -872415232);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388693);
        layoutParams.setMargins(0, 0, mediaPicker.e(8), mediaPicker.e(6));
        addView(textView, layoutParams);
        textView2.setGravity(17);
        textView2.setTextColor(-1);
        textView2.setTextSize(1, 15.0f);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setBackground(MediaPicker.circleDrawable(-16226561));
        textView2.setVisibility(8);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(mediaPicker.e(26), mediaPicker.e(26), 8388661);
        layoutParams2.setMargins(0, mediaPicker.e(7), mediaPicker.e(7), 0);
        addView(textView2, layoutParams2);
        setOnClickListener(new PairClickListener(this, mediaPicker, 4));
    }

    @Override
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i2);
    }
}
