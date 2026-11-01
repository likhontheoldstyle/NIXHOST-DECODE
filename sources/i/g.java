package i;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class g implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f849a = 0;

    /* renamed from: b, reason: collision with root package name */
    public Object f850b;

    public /* synthetic */ g() {
    }

    public static m.d a(g gVar, String str) {
        gVar.getClass();
        b.e(str, "input");
        Matcher matcher = ((Pattern) gVar.f850b).matcher(str);
        b.d(matcher, "matcher(...)");
        if (matcher.find(0)) {
            return new m.d(matcher, str);
        }
        return null;
    }

    public boolean b(CharSequence charSequence) {
        b.e(charSequence, "input");
        return ((Pattern) this.f850b).matcher(charSequence).matches();
    }

    public final String toString() {
        switch (this.f849a) {
            case 0:
                return String.valueOf(this.f850b);
            default:
                String pattern = ((Pattern) this.f850b).toString();
                b.d(pattern, "toString(...)");
                return pattern;
        }
    }

    public g(String str) {
        Pattern compile = Pattern.compile(str);
        b.d(compile, "compile(...)");
        this.f850b = compile;
    }
}
