package a;

import android.view.View;
import android.widget.FrameLayout;
import com.nix.host.MainActivity;

public final class EmojiPanelToggle implements h.a {

    public final int mode;

    public final i.d dismissedRef;

    public final MainActivity activity;

    public final IconView iconView;

    public final DragSheetLayout sheet;

    public final View scrimView;

    public final FrameLayout rootFrame;

    public EmojiPanelToggle(i.d dVar, MainActivity mainActivity, IconView g1, DragSheetLayout s2Var, View view, FrameLayout frameLayout, int i2) {
        this.mode = i2;
        this.dismissedRef = dVar;
        this.activity = mainActivity;
        this.iconView = g1;
        this.sheet = s2Var;
        this.scrimView = view;
        this.rootFrame = frameLayout;
    }

    @Override
    public final Object a() {
        switch (this.mode) {
            case 0:
                ValueProvider c0 = new ValueProvider(2);
                i.d dVar = this.dismissedRef;
                MainActivity.animateEmojiPanelClose(this.iconView, this.sheet, this.scrimView, this.rootFrame, this.activity, c0, dVar);
                break;
            default:
                ValueProvider c02 = new ValueProvider(2);
                i.d dVar2 = this.dismissedRef;
                MainActivity.animateEmojiPanelClose(this.iconView, this.sheet, this.scrimView, this.rootFrame, this.activity, c02, dVar2);
                break;
        }
        return b.d.f770c;
    }
}
