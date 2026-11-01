package m;

import a.AbstractC0008c;
import java.util.regex.Matcher;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Object f876a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f877b;

    public d(t.b bVar) {
        this.f877b = bVar;
        this.f876a = new short[768];
    }

    public k.c a() {
        Matcher matcher = (Matcher) this.f876a;
        return AbstractC0008c.B(matcher.start(), matcher.end());
    }

    public String b() {
        String group = ((Matcher) this.f876a).group();
        i.b.d(group, "group(...)");
        return group;
    }

    public d(Matcher matcher, String str) {
        i.b.e(str, "input");
        this.f876a = matcher;
        this.f877b = str;
    }
}
