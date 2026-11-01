package i;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class c implements Serializable {
    public final String toString() {
        h.f851a.getClass();
        String obj = getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            obj = obj.substring(21);
        }
        b.d(obj, "renderLambdaToString(...)");
        return obj;
    }
}
