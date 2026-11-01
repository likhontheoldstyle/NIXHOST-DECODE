package a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.Layout;
import android.widget.EditText;
import com.nix.host.MainActivity;
import java.util.Arrays;

/* renamed from: a.j1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0038j1 extends EditText {

    /* renamed from: a, reason: collision with root package name */
    public final float f549a;

    /* renamed from: b, reason: collision with root package name */
    public String f550b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f551c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f552d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f553e;

    /* renamed from: f, reason: collision with root package name */
    public int f554f;

    /* renamed from: g, reason: collision with root package name */
    public int f555g;

    /* renamed from: h, reason: collision with root package name */
    public int f556h;

    /* renamed from: i, reason: collision with root package name */
    public final Handler f557i;

    /* renamed from: j, reason: collision with root package name */
    public int f558j;

    /* renamed from: k, reason: collision with root package name */
    public final G f559k;

    public C0038j1(MainActivity mainActivity, float f2) {
        super(mainActivity);
        this.f549a = f2;
        this.f550b = "";
        Paint paint = new Paint(1);
        this.f551c = paint;
        Paint paint2 = new Paint();
        this.f552d = paint2;
        this.f553e = new int[256];
        this.f554f = 1;
        this.f555g = 2;
        this.f556h = (int) (36 * f2);
        this.f557i = new Handler(Looper.getMainLooper());
        this.f559k = new G(3, this);
        paint.setTypeface(Typeface.MONOSPACE);
        paint.setTextAlign(Paint.Align.RIGHT);
        paint.setTextSize(f2 * 13.0f);
        paint.setColor(-7236447);
        paint2.setColor(-14737628);
        setBreakStrategy(0);
        setHyphenationFrequency(0);
        setOverScrollMode(2);
        addTextChangedListener(new R0(1, this));
    }

    public final void a() {
        String str;
        Editable text = getText();
        if (text == null || (str = text.toString()) == null) {
            str = "";
        }
        int P = m.e.P(str, '\n', 0, false, 6);
        if (this.f553e.length < 2) {
            this.f553e = new int[256];
        }
        this.f553e[0] = 0;
        int i2 = 1;
        while (P >= 0) {
            int[] iArr = this.f553e;
            if (i2 >= iArr.length) {
                int[] copyOf = Arrays.copyOf(iArr, iArr.length * 2);
                i.b.d(copyOf, "copyOf(...)");
                this.f553e = copyOf;
            }
            int i3 = P + 1;
            this.f553e[i2] = i3;
            P = m.e.P(str, '\n', i3, false, 4);
            i2++;
        }
        this.f554f = i2;
        int max = Math.max(String.valueOf(i2).length(), 2);
        if (max != this.f555g) {
            this.f555g = max;
            float f2 = this.f549a;
            int i4 = (int) (((max * 9) + 18) * f2);
            this.f556h = i4;
            setPadding(i4 + ((int) (10 * f2)), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public final String getFileName() {
        return this.f550b;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Layout layout = getLayout();
        Editable text = getText();
        if (layout != null && text != null) {
            int scrollY = getScrollY();
            int height = getHeight() + getScrollY();
            canvas.drawRect(0.0f, scrollY, this.f556h, height, this.f552d);
            int lineForVertical = layout.getLineForVertical(Math.max(0, scrollY - getTotalPaddingTop()));
            int min = Math.min(layout.getLineCount() - 1, layout.getLineForVertical(Math.max(0, height - getTotalPaddingTop())));
            float f2 = this.f556h - (this.f549a * 8.0f);
            if (lineForVertical <= min) {
                while (true) {
                    int lineStart = layout.getLineStart(lineForVertical);
                    if (lineStart == 0 || text.charAt(lineStart - 1) == '\n') {
                        int i2 = this.f554f - 1;
                        int i3 = 0;
                        while (i3 < i2) {
                            int i4 = ((i3 + i2) + 1) >>> 1;
                            if (this.f553e[i4] <= lineStart) {
                                i3 = i4;
                            } else {
                                i2 = i4 - 1;
                            }
                        }
                        canvas.drawText(String.valueOf(i3 + 1), f2, getTotalPaddingTop() + layout.getLineBaseline(lineForVertical), this.f551c);
                    }
                    if (lineForVertical == min) {
                        break;
                    } else {
                        lineForVertical++;
                    }
                }
            }
        }
        super.onDraw(canvas);
    }

    public final void setFileName(String str) {
        this.f550b = str;
    }
}
