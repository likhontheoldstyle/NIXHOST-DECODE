package a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import java.util.List;

/* loaded from: classes.dex */
public final class P2 extends View {

    /* renamed from: a, reason: collision with root package name */
    public final float f256a;

    /* renamed from: b, reason: collision with root package name */
    public final float f257b;

    /* renamed from: c, reason: collision with root package name */
    public List f258c;

    /* renamed from: d, reason: collision with root package name */
    public float f259d;

    /* renamed from: e, reason: collision with root package name */
    public int f260e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f261f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f262g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f263h;

    public P2(Context context, float f2, float f3) {
        super(context);
        this.f256a = f2;
        this.f257b = f3;
        this.f258c = c.j.f773a;
        this.f260e = -1;
        this.f263h = new Paint(1);
    }

    public final boolean getCursor() {
        return this.f262g;
    }

    public final int getFg() {
        return this.f260e;
    }

    public final boolean getLive() {
        return this.f261f;
    }

    public final float getProgress() {
        return this.f259d;
    }

    public final List<Integer> getValues() {
        return this.f258c;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onDraw(Canvas canvas) {
        Paint paint;
        int intValue;
        List list;
        boolean z;
        float width = getWidth();
        float height = getHeight();
        if (width <= 0.0f) {
            return;
        }
        float f2 = this.f256a;
        float f3 = this.f257b;
        float f4 = f2 + f3;
        float f5 = this.f262g ? 2.6f * f2 : 0.0f;
        float f6 = width - (f5 * 2.0f);
        int i2 = 1;
        int max = Math.max(1, (int) ((f6 + f3) / f4));
        float f7 = max;
        float f8 = ((f6 - ((f7 * f4) - f3)) / 2.0f) + f5;
        List list2 = this.f258c;
        int i3 = 0;
        while (true) {
            paint = this.f263h;
            if (i3 >= max) {
                break;
            }
            if (this.f261f) {
                int size = (list2.size() - max) + i3;
                if (size >= 0) {
                    intValue = ((Number) list2.get(size)).intValue();
                    i2 = 0;
                }
                intValue = 0;
            } else if (((list2.isEmpty() ? 1 : 0) ^ i2) != 0) {
                intValue = ((Number) list2.get(Math.min(list2.size() - i2, (list2.size() * i3) / max))).intValue();
                i2 = 0;
            } else {
                i2 = 0;
                intValue = 0;
            }
            float max2 = (i2 != 0 || intValue < 10) ? f2 : Math.max(1.6f * f2, (intValue / 100.0f) * height * 0.95f);
            if (this.f261f) {
                list = list2;
            } else {
                list = list2;
                if (i3 >= this.f259d * f7) {
                    z = false;
                    paint.setColor(this.f260e);
                    paint.setAlpha(i2 == 0 ? 150 : z ? 255 : 120);
                    float f9 = (i3 * f4) + f8;
                    canvas.drawRoundRect(new RectF(f9, (height - max2) / 2.0f, f9 + f2, (max2 + height) / 2.0f), f2 / 2.0f, f2 / 2.0f, paint);
                    i3++;
                    list2 = list;
                    f4 = f4;
                    i2 = 1;
                }
            }
            z = true;
            paint.setColor(this.f260e);
            paint.setAlpha(i2 == 0 ? 150 : z ? 255 : 120);
            float f92 = (i3 * f4) + f8;
            canvas.drawRoundRect(new RectF(f92, (height - max2) / 2.0f, f92 + f2, (max2 + height) / 2.0f), f2 / 2.0f, f2 / 2.0f, paint);
            i3++;
            list2 = list;
            f4 = f4;
            i2 = 1;
        }
        if (this.f262g) {
            float max3 = Math.max(3.0f, f2 * 0.45f);
            float f10 = f5 * 0.4f;
            float f11 = width - f10;
            float f12 = ((f11 - f10) * this.f259d) + f10;
            paint.setColor(this.f260e);
            paint.setAlpha(255);
            float f13 = max3 / 2.0f;
            float f14 = 0.06f * height;
            float f15 = height * 0.94f;
            canvas.drawRoundRect(new RectF(f11 - f13, f14, f11 + f13, f15), f13, f13, paint);
            canvas.drawRoundRect(new RectF(f12 - f13, f14, f12 + f13, f15), f13, f13, paint);
        }
    }

    public final void setCursor(boolean z) {
        this.f262g = z;
    }

    public final void setFg(int i2) {
        this.f260e = i2;
    }

    public final void setLive(boolean z) {
        this.f261f = z;
    }

    public final void setProgress(float f2) {
        this.f259d = f2;
    }

    public final void setValues(List<Integer> list) {
        this.f258c = list;
    }
}
