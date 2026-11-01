package a;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ListView;

public final class ChatListView extends ListView {

    public h.b hook;

    public ChatListView(Context context) {
        super(context);
    }

    public final void superDispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
    }

    @Override
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        h.b bVar = this.hook;
        Boolean bool = bVar != null ? (Boolean) bVar.a(motionEvent) : null;
        return bool != null ? bool.booleanValue() : super.dispatchTouchEvent(motionEvent);
    }

    public final h.b getHook() {
        return this.hook;
    }

    public final void setHook(h.b bVar) {
        this.hook = bVar;
    }
}
