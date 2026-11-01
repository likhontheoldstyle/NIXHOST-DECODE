package c;

import a.AbstractC0008c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c extends AbstractC0008c {
    public static List C(Object... objArr) {
        if (objArr.length <= 0) {
            return j.f773a;
        }
        List asList = Arrays.asList(objArr);
        i.b.d(asList, "asList(...)");
        return asList;
    }

    public static final List D(ArrayList arrayList) {
        int size = arrayList.size();
        return size != 0 ? size != 1 ? arrayList : AbstractC0008c.p(arrayList.get(0)) : j.f773a;
    }
}
