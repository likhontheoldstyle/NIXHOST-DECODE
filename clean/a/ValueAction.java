package a;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.nix.host.MainActivity;
import java.io.File;

public final class ValueAction implements h.b {

    public final int mode;

    public final Object first;

    public final Object second;

    public final Object third;

    public ValueAction(MainActivity mainActivity, File file, String str) {
        this.mode = 1;
        this.second = mainActivity;
        this.third = file;
        this.first = str;
    }

    @Override
    public final Object a(Object obj) {
        Object obj2 = this.third;
        Object obj3 = this.first;
        Object obj4 = this.second;
        switch (this.mode) {
            case 0:
                Bitmap bitmap = (Bitmap) obj;
                float width = bitmap.getWidth() / bitmap.getHeight();
                ChatScreen chatScreen = (ChatScreen) obj4;
                chatScreen.getClass();
                View childAt = ((LinearLayout) obj2).getChildAt(0);
                if (childAt != null && i.b.a(childAt.getTag(), (String) obj3)) {
                    LinearLayout.LayoutParams MemberComparator = chatScreen.mediaLayoutParams(width);
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams == null || layoutParams.width != MemberComparator.width || layoutParams.height != MemberComparator.height) {
                        childAt.setLayoutParams(MemberComparator);
                    }
                }
                break;
            case 1:
                int intValue = ((Integer) obj).intValue();
                int i2 = MainActivity.R;
                MainActivity mainActivity = (MainActivity) obj4;
                File file = (File) obj2;
                if (intValue == 0) {
                    mainActivity.showEditor(file);
                } else if (intValue != 1) {
                    Object systemService = mainActivity.getSystemService("clipboard");
                    i.b.c(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                    ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(file.getName(), (String) obj3));
                    mainActivity.toast("Copied");
                } else {
                    mainActivity.showCommitSheet(StringPlus.stringPlus("Delete ", file.getName()), new FileConfirmAction(file, mainActivity, 0));
                }
                break;
            default:
                float floatValue = ((Float) obj).floatValue();
                int i3 = MainActivity.R;
                if (!((i.d) obj4).f846a) {
                    float max = Math.max(1.0f, ((View) obj2).getHeight());
                    ((DragSheetLayout) obj3).setTranslationY(floatValue);
                    ((View) obj2).setAlpha(AppState.b(1.0f - (floatValue / max), 0.0f, 1.0f));
                }
                break;
        }
        return b.d.f770c;
    }

    public ValueAction(Object obj, Object obj2, View view, int i2) {
        this.mode = i2;
        this.second = obj;
        this.first = obj2;
        this.third = view;
    }
}
