package c;

import java.util.Collection;

/* loaded from: classes.dex */
public abstract class d extends c {
    public static int E(Iterable iterable) {
        i.b.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return 10;
    }
}
