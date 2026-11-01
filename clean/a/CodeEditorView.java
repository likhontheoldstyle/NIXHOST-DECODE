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

public final class CodeEditorView extends EditText {

    public final float textScalePx;

    public String fileName;

    public final Paint gutterPaint;

    public final Paint gutterBgPaint;

    public int[] lineStarts;

    public int lineCount;

    public int gutterDigits;

    public int gutterWidth;

    public final Handler handler;

    public int changeCounter;

    public final TaskRunnable repaintTask;

    public CodeEditorView(MainActivity mainActivity, float f2) {
        super(mainActivity);
        this.textScalePx = f2;
        this.fileName = "";
        Paint paint = new Paint(1);
        this.gutterPaint = paint;
        Paint paint2 = new Paint();
        this.gutterBgPaint = paint2;
        this.lineStarts = new int[256];
        this.lineCount = 1;
        this.gutterDigits = 2;
        this.gutterWidth = (int) (36 * f2);
        this.handler = new Handler(Looper.getMainLooper());
        this.repaintTask = new TaskRunnable(3, this);
        paint.setTypeface(Typeface.MONOSPACE);
        paint.setTextAlign(Paint.Align.RIGHT);
        paint.setTextSize(f2 * 13.0f);
        paint.setColor(-7236447);
        paint2.setColor(-14737628);
        setBreakStrategy(0);
        setHyphenationFrequency(0);
        setOverScrollMode(2);
        addTextChangedListener(new SharedTextWatcher(1, this));
    }

    public final void recomputeLineStarts() {
        String str;
        Editable text = getText();
        if (text == null || (str = text.toString()) == null) {
            str = "";
        }
        int P = m.e.P(str, '\n', 0, false, 6);
        if (this.lineStarts.length < 2) {
            this.lineStarts = new int[256];
        }
        this.lineStarts[0] = 0;
        int i2 = 1;
        while (P >= 0) {
            int[] iArr = this.lineStarts;
            if (i2 >= iArr.length) {
                int[] copyOf = Arrays.copyOf(iArr, iArr.length * 2);
                i.b.d(copyOf, "copyOf(...)");
                this.lineStarts = copyOf;
            }
            int i3 = P + 1;
            this.lineStarts[i2] = i3;
            P = m.e.P(str, '\n', i3, false, 4);
            i2++;
        }
        this.lineCount = i2;
        int max = Math.max(String.valueOf(i2).length(), 2);
        if (max != this.gutterDigits) {
            this.gutterDigits = max;
            float f2 = this.textScalePx;
            int i4 = (int) (((max * 9) + 18) * f2);
            this.gutterWidth = i4;
            setPadding(i4 + ((int) (10 * f2)), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public final String getFileName() {
        return this.fileName;
    }

    @Override
    public final void onDraw(Canvas canvas) {
        Layout layout = getLayout();
        Editable text = getText();
        if (layout != null && text != null) {
            int scrollY = getScrollY();
            int height = getHeight() + getScrollY();
            canvas.drawRect(0.0f, scrollY, this.gutterWidth, height, this.gutterBgPaint);
            int lineForVertical = layout.getLineForVertical(Math.max(0, scrollY - getTotalPaddingTop()));
            int min = Math.min(layout.getLineCount() - 1, layout.getLineForVertical(Math.max(0, height - getTotalPaddingTop())));
            float f2 = this.gutterWidth - (this.textScalePx * 8.0f);
            if (lineForVertical <= min) {
                while (true) {
                    int lineStart = layout.getLineStart(lineForVertical);
                    if (lineStart == 0 || text.charAt(lineStart - 1) == '\n') {
                        int i2 = this.lineCount - 1;
                        int i3 = 0;
                        while (i3 < i2) {
                            int i4 = ((i3 + i2) + 1) >>> 1;
                            if (this.lineStarts[i4] <= lineStart) {
                                i3 = i4;
                            } else {
                                i2 = i4 - 1;
                            }
                        }
                        canvas.drawText(String.valueOf(i3 + 1), f2, getTotalPaddingTop() + layout.getLineBaseline(lineForVertical), this.gutterPaint);
                    }
                    if (lineForVertical == min) {
                        break;
                    }
                    lineForVertical++;
                }
            }
        }
        super.onDraw(canvas);
    }

    public final void setFileName(String str) {
        this.fileName = str;
    }
}
