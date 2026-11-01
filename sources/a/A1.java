package a;

import android.graphics.Bitmap;
import android.util.LruCache;

/* loaded from: classes.dex */
public final class A1 extends LruCache {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ A1(int i2, int i3) {
        super(i2);
        this.f14a = i3;
    }

    @Override // android.util.LruCache
    public final int sizeOf(Object obj, Object obj2) {
        switch (this.f14a) {
            case 0:
                break;
            default:
                break;
        }
        return ((Bitmap) obj2).getByteCount();
    }
}
