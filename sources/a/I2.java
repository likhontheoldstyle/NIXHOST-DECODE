package a;

import android.view.MotionEvent;
import android.widget.ListView;

/* loaded from: classes.dex */
public final class I2 extends ListView {

    /* renamed from: a, reason: collision with root package name */
    public h.b f133a;

    public final void a(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        h.b bVar = this.f133a;
        Boolean bool = bVar != null ? (Boolean) bVar.a(motionEvent) : null;
        return bool != null ? bool.booleanValue() : super.dispatchTouchEvent(motionEvent);
    }

    public final h.b getHook() {
        return this.f133a;
    }

    public final void setHook(h.b bVar) {
        this.f133a = bVar;
    }
}
