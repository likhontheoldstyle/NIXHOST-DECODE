package e;

import i.b;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f806a;

    static {
        Method method;
        Method[] methods = Throwable.class.getMethods();
        b.b(methods);
        int length = methods.length;
        int i2 = 0;
        while (true) {
            method = null;
            if (i2 >= length) {
                break;
            }
            Method method2 = methods[i2];
            if (b.a(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                b.d(parameterTypes, "getParameterTypes(...)");
                if (b.a(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                    method = method2;
                    break;
                }
            }
            i2++;
        }
        f806a = method;
        int length2 = methods.length;
        for (int i3 = 0; i3 < length2 && !b.a(methods[i3].getName(), "getSuppressed"); i3++) {
        }
    }
}
