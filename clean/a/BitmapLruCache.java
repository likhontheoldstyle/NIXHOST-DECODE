package a;

import android.graphics.Bitmap;
import android.util.LruCache;

public final class BitmapLruCache extends LruCache {

    public final int mode;

    public BitmapLruCache(int i2, int i3) {
        super(i2);
        this.mode = i3;
    }

    @Override
    public final int sizeOf(Object obj, Object obj2) {
        switch (this.mode) {
            case 0:
                break;
            default:
                break;
        }
        return ((Bitmap) obj2).getByteCount();
    }
}
