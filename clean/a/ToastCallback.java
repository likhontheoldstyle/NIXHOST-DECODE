package a;

import android.graphics.Bitmap;
import android.graphics.Paint;
import com.nix.host.MainActivity;

public final class ToastCallback implements h.b {

    public final int mode;

    public final Object target;

    public ToastCallback(int i2, Object obj) {
        this.mode = i2;
        this.target = obj;
    }

    @Override
    public final Object a(Object obj) {
        C0091y1 c0091y1;
        switch (this.mode) {
            case 0:
                break;
            case 1:
                String str = (String) obj;
                if (str.length() > 0 && (c0091y1 = ((B1) this.target).F) != null) {
                    Bitmap bitmap = c0091y1.f720a;
                    O2 o2 = new O2(str, bitmap.getHeight() * 0.5f, bitmap.getWidth() * 0.09f, c0091y1.f723d);
                    c0091y1.c(o2);
                    Paint paint = c0091y1.f727h;
                    float measureText = paint.measureText(str);
                    if (measureText > bitmap.getWidth() * 0.9f) {
                        o2.f244d = ((o2.f244d * bitmap.getWidth()) * 0.9f) / measureText;
                    }
                    c0091y1.c(o2);
                    o2.f242b = (bitmap.getWidth() - paint.measureText(str)) / 2.0f;
                    c0091y1.f721b.add(o2);
                    c0091y1.invalidate();
                }
                break;
            case 2:
                int i2 = MainActivity.R;
                ((MainActivity) this.target).toast((String) obj);
                break;
            default:
                TerminalSession terminalSession = (TerminalSession) this.target;
                int intValue = ((Integer) obj).intValue();
                terminalSession.getClass();
                terminalSession.prompt = TerminalSession.progressBar(intValue);
                TerminalManager.INSTANCE.syncServiceState();
                break;
        }
        return b.d.f770c;
    }
}
