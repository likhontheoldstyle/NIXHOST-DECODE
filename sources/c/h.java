package c;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public abstract class h extends g {
    public static void G(List list, h.b bVar) {
        int size;
        i.b.e(list, "<this>");
        if (!(list instanceof RandomAccess)) {
            if (list instanceof j.a) {
                ClassCastException classCastException = new ClassCastException(list.getClass().getName().concat(" cannot be cast to kotlin.collections.MutableIterable"));
                i.b.f(classCastException, i.j.class.getName());
                throw classCastException;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((Boolean) bVar.a(it.next())).booleanValue()) {
                    it.remove();
                }
            }
            return;
        }
        int size2 = list.size() - 1;
        int i2 = 0;
        if (size2 >= 0) {
            int i3 = 0;
            while (true) {
                Object obj = list.get(i2);
                if (!((Boolean) bVar.a(obj)).booleanValue()) {
                    if (i3 != i2) {
                        list.set(i3, obj);
                    }
                    i3++;
                }
                if (i2 == size2) {
                    break;
                } else {
                    i2++;
                }
            }
            i2 = i3;
        }
        if (i2 >= list.size() || i2 > (size = list.size() - 1)) {
            return;
        }
        while (true) {
            list.remove(size);
            if (size == i2) {
                return;
            } else {
                size--;
            }
        }
    }
}
