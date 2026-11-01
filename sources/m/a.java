package m;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f864a;

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f865b;

    static {
        Charset forName = Charset.forName("UTF-8");
        i.b.d(forName, "forName(...)");
        f864a = forName;
        i.b.d(Charset.forName("UTF-16"), "forName(...)");
        i.b.d(Charset.forName("UTF-16BE"), "forName(...)");
        i.b.d(Charset.forName("UTF-16LE"), "forName(...)");
        i.b.d(Charset.forName("US-ASCII"), "forName(...)");
        Charset forName2 = Charset.forName("ISO-8859-1");
        i.b.d(forName2, "forName(...)");
        f865b = forName2;
    }
}
