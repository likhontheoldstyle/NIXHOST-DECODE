package a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class N2 extends View {

    /* renamed from: a, reason: collision with root package name */
    public final int f226a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f227b;

    /* renamed from: c, reason: collision with root package name */
    public final Bitmap f228c;

    public N2(Context context, C0022f1 c0022f1, int i2, int i3, int i4) {
        super(context);
        Bitmap bitmap;
        this.f226a = i2;
        this.f227b = new Paint(2);
        if (c0022f1 != null) {
            HashMap hashMap = M2.f216a;
            String str = c0022f1.f481a + "|" + i3 + "x" + i4;
            HashMap hashMap2 = M2.f216a;
            bitmap = (Bitmap) hashMap2.get(str);
            if (bitmap == null) {
                if (hashMap2.size() > 26) {
                    hashMap2.clear();
                }
                bitmap = Bitmap.createBitmap(i3 < 1 ? 1 : i3, i4 < 1 ? 1 : i4, Bitmap.Config.ARGB_8888);
                M2.b(c0022f1, new Canvas(bitmap), bitmap.getWidth(), bitmap.getHeight());
                hashMap2.put(str, bitmap);
            }
        } else {
            bitmap = null;
        }
        this.f228c = bitmap;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Bitmap bitmap = this.f228c;
        if (bitmap == null) {
            canvas.drawColor(this.f226a);
            return;
        }
        float max = Math.max(getWidth() / bitmap.getWidth(), getHeight() / bitmap.getHeight());
        float width = bitmap.getWidth() * max;
        float height = bitmap.getHeight() * max;
        float width2 = (getWidth() - width) / 2.0f;
        canvas.drawBitmap(bitmap, (Rect) null, new RectF(width2, 0.0f, width + width2, height), this.f227b);
    }
}
