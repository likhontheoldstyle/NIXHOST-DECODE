package a;

import android.view.View;

public final class NoopLongClickListener implements View.OnLongClickListener {

    @Override
    public final boolean onLongClick(View view) {
        return false;
    }
}
