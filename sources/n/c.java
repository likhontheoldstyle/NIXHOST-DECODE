package n;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class c extends LinkedHashMap {
    public c() {
        super(64, 0.75f, true);
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry entry) {
        return size() > 32;
    }
}
