package a;

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* renamed from: a.v1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0082v1 extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final ImageView f682a;

    /* renamed from: b, reason: collision with root package name */
    public final View f683b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f684c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f685d;

    /* renamed from: e, reason: collision with root package name */
    public C0094z1 f686e;

    /* renamed from: f, reason: collision with root package name */
    public String f687f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ B1 f688g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0082v1(B1 b1) {
        super(b1.f26a);
        this.f688g = b1;
        Activity activity = b1.f26a;
        ImageView imageView = new ImageView(activity);
        this.f682a = imageView;
        View view = new View(activity);
        this.f683b = view;
        TextView textView = new TextView(activity);
        this.f684c = textView;
        TextView textView2 = new TextView(activity);
        this.f685d = textView2;
        this.f687f = "";
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setBackgroundColor(b1.f32g);
        addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setStroke(b1.e(3), -16226561);
        view.setBackground(gradientDrawable);
        view.setVisibility(8);
        addView(view, new FrameLayout.LayoutParams(-1, -1));
        textView.setTextColor(-1);
        textView.setTextSize(1, 17.0f);
        textView.setShadowLayer(5.0f, 0.0f, 0.0f, -872415232);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388693);
        layoutParams.setMargins(0, 0, b1.e(8), b1.e(6));
        addView(textView, layoutParams);
        textView2.setGravity(17);
        textView2.setTextColor(-1);
        textView2.setTextSize(1, 15.0f);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setBackground(B1.h(-16226561));
        textView2.setVisibility(8);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(b1.e(26), b1.e(26), 8388661);
        layoutParams2.setMargins(0, b1.e(7), b1.e(7), 0);
        addView(textView2, layoutParams2);
        setOnClickListener(new ViewOnClickListenerC0072s0(this, b1, 4));
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i2);
    }
}
