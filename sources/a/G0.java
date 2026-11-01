package a;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.nix.host.MainActivity;
import java.io.File;

/* loaded from: classes.dex */
public final /* synthetic */ class G0 implements h.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f103a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f104b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f105c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f106d;

    public /* synthetic */ G0(MainActivity mainActivity, File file, String str) {
        this.f103a = 1;
        this.f105c = mainActivity;
        this.f106d = file;
        this.f104b = str;
    }

    @Override // h.b
    public final Object a(Object obj) {
        Object obj2 = this.f106d;
        Object obj3 = this.f104b;
        Object obj4 = this.f105c;
        switch (this.f103a) {
            case 0:
                Bitmap bitmap = (Bitmap) obj;
                float width = bitmap.getWidth() / bitmap.getHeight();
                C0006b1 c0006b1 = (C0006b1) obj4;
                c0006b1.getClass();
                View childAt = ((LinearLayout) obj2).getChildAt(0);
                if (childAt != null && i.b.a(childAt.getTag(), (String) obj3)) {
                    LinearLayout.LayoutParams U0 = c0006b1.U0(width);
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams == null || layoutParams.width != U0.width || layoutParams.height != U0.height) {
                        childAt.setLayoutParams(U0);
                    }
                }
                break;
            case 1:
                int intValue = ((Integer) obj).intValue();
                int i2 = MainActivity.R;
                MainActivity mainActivity = (MainActivity) obj4;
                File file = (File) obj2;
                if (intValue == 0) {
                    mainActivity.K(file);
                } else if (intValue != 1) {
                    Object systemService = mainActivity.getSystemService("clipboard");
                    i.b.c(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                    ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(file.getName(), (String) obj3));
                    mainActivity.T("Copied");
                } else {
                    mainActivity.k(J0.a("Delete ", file.getName()), new R1(file, mainActivity, 0));
                }
                break;
            default:
                float floatValue = ((Float) obj).floatValue();
                int i3 = MainActivity.R;
                if (!((i.d) obj4).f846a) {
                    float max = Math.max(1.0f, r2.getHeight());
                    ((s2) obj3).setTranslationY(floatValue);
                    ((View) obj2).setAlpha(AbstractC0008c.b(1.0f - (floatValue / max), 0.0f, 1.0f));
                }
                break;
        }
        return b.d.f770c;
    }

    public /* synthetic */ G0(Object obj, Object obj2, View view, int i2) {
        this.f103a = i2;
        this.f105c = obj;
        this.f104b = obj2;
        this.f106d = view;
    }
}
