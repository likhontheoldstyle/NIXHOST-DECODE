package a;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class D1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f67a = AbstractC0008c.y("async", "await", "break", "case", "catch", "class", "const", "continue", "debugger", "default", "delete", "do", "else", "enum", "export", "extends", "finally", "for", "function", "if", "implements", "import", "in", "instanceof", "interface", "let", "new", "package", "private", "protected", "public", "return", "static", "super", "switch", "throw", "try", "typeof", "var", "void", "while", "with", "yield", "abstract", "final", "throws", "namespace");

    /* renamed from: b, reason: collision with root package name */
    public static final Set f68b = AbstractC0008c.y("and", "as", "assert", "async", "await", "break", "class", "continue", "def", "del", "elif", "else", "except", "finally", "for", "from", "global", "if", "import", "in", "is", "lambda", "nonlocal", "not", "or", "pass", "raise", "return", "try", "while", "with", "yield");

    /* renamed from: c, reason: collision with root package name */
    public static final Set f69c = AbstractC0008c.y("true", "false", "null", "undefined", "NaN", "Infinity", "None", "True", "False");

    /* JADX WARN: Code restructure failed: missing block: B:214:0x0358, code lost:
    
        if (r14.charAt(r7) != '$') goto L211;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:144:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x04b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:335:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x04c5  */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r15v32 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5, types: [int] */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33, types: [int] */
    /* JADX WARN: Type inference failed for: r8v34 */
    /* JADX WARN: Type inference failed for: r8v35 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v43, types: [int] */
    /* JADX WARN: Type inference failed for: r8v51 */
    /* JADX WARN: Type inference failed for: r8v52 */
    /* JADX WARN: Type inference failed for: r8v53 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList a(List list, String str) {
        char c2;
        Iterator it;
        boolean z;
        ?? r15;
        Iterator it2;
        char c3;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i2;
        int i3;
        int i4;
        int i5;
        char c4;
        boolean z6;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        char c5 = '.';
        String d0 = m.e.d0(str, '.', "");
        Locale locale = Locale.ROOT;
        String lowerCase = d0.toLowerCase(locale);
        i.b.d(lowerCase, "toLowerCase(...)");
        String lowerCase2 = str.toLowerCase(locale);
        i.b.d(lowerCase2, "toLowerCase(...)");
        boolean z7 = false;
        int i12 = 4;
        char c6 = 6;
        char c7 = 5;
        char c8 = AbstractC0008c.y("js", "mjs", "cjs", "jsx", "ts", "tsx", "java", "kt", "kts", "c", "h", "cpp", "cc", "hpp", "cs", "go", "rs", "php", "swift", "dart", "scala", "gradle").contains(lowerCase) ? (char) 0 : AbstractC0008c.y("css", "scss", "less").contains(lowerCase) ? (char) 1 : lowerCase.equals("py") ? (char) 2 : lowerCase.equals("json") ? (char) 4 : AbstractC0008c.y("html", "htm", "xml", "svg", "vue").contains(lowerCase) ? (char) 5 : (AbstractC0008c.y("sh", "bash", "zsh", "yml", "yaml", "toml", "rb", "env", "ini", "conf", "properties", "gitignore").contains(lowerCase) || lowerCase2.equals("dockerfile")) ? (char) 3 : (char) 6;
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it3 = list.iterator();
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        while (it3.hasNext()) {
            ?? r14 = (String) it3.next();
            if (c8 == c6 || r14.length() > 2000) {
                c2 = c5;
                it = it3;
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(r14);
                char c9 = '/';
                int i13 = -6971995;
                if (c8 == c7) {
                    int length = r14.length();
                    ?? r8 = z7;
                    while (true) {
                        if (r8 >= length) {
                            break;
                        }
                        if (z8) {
                            int Q = m.e.Q(r14, "-->", r8, z7, i12);
                            if (Q < 0) {
                                b(spannableStringBuilder, r8, length, i13);
                                break;
                            }
                            int i14 = Q + 3;
                            b(spannableStringBuilder, r8, i14, i13);
                            r8 = i14;
                            z8 = z7;
                        } else if (!z9) {
                            int P = m.e.P(r14, '<', r8, z7, i12);
                            if (P < 0) {
                                break;
                            }
                            if (r14.startsWith("<!--", P)) {
                                int Q2 = m.e.Q(r14, "-->", P + 4, z7, i12);
                                if (Q2 < 0) {
                                    b(spannableStringBuilder, P, length, i13);
                                    z8 = true;
                                    break;
                                }
                                r8 = Q2 + 3;
                                b(spannableStringBuilder, P, r8, i13);
                            } else {
                                i11 = P + 1;
                                int i15 = (i11 >= length || !(r14.charAt(i11) == c9 || r14.charAt(i11) == '!' || r14.charAt(i11) == '?')) ? i11 : P + 2;
                                int i16 = i15;
                                while (i16 < length && (Character.isLetterOrDigit(r14.charAt(i16)) || r14.charAt(i16) == '-' || r14.charAt(i16) == ':' || r14.charAt(i16) == '_')) {
                                    i16++;
                                }
                                if (i16 > i15) {
                                    b(spannableStringBuilder, i15, i16, -8001379);
                                    z9 = true;
                                    r8 = i16;
                                    i13 = -6971995;
                                    c9 = '/';
                                } else {
                                    r8 = i11;
                                    i13 = -6971995;
                                    c9 = '/';
                                }
                            }
                        } else {
                            char charAt = r14.charAt(r8);
                            if (charAt == '>') {
                                z9 = z7;
                                r8++;
                            } else {
                                if (charAt == '\"' || charAt == '\'') {
                                    int i17 = r8 + 1;
                                    while (i17 < length && r14.charAt(i17) != charAt) {
                                        i17++;
                                    }
                                    i11 = i17 >= length ? length : i17 + 1;
                                    b(spannableStringBuilder, r8, i11, -8800001);
                                } else if (Character.isLetter(charAt) || charAt == '_' || charAt == '@' || charAt == ':') {
                                    i11 = r8 + 1;
                                    while (i11 < length && (Character.isLetterOrDigit(r14.charAt(i11)) || r14.charAt(i11) == '-' || r14.charAt(i11) == '_' || r14.charAt(i11) == ':' || r14.charAt(i11) == '.')) {
                                        i11++;
                                    }
                                    b(spannableStringBuilder, r8, i11, -5008656);
                                } else {
                                    r8++;
                                }
                                r8 = i11;
                            }
                            i13 = -6971995;
                            c9 = '/';
                        }
                    }
                } else {
                    int length2 = r14.length();
                    boolean z11 = c8 == 0 ? true : z7;
                    boolean z12 = (c8 == 0 || c8 == 1) ? true : z7;
                    if (c8 != 2 && c8 != 3) {
                        z = z7;
                        r15 = z7;
                        while (r15 < length2) {
                            if (z8) {
                                int Q3 = m.e.Q(r14, "*/", r15, z7, i12);
                                if (Q3 < 0) {
                                    b(spannableStringBuilder, r15, length2, -6971995);
                                    i9 = length2;
                                } else {
                                    int i18 = Q3 + 2;
                                    b(spannableStringBuilder, r15, i18, -6971995);
                                    i9 = i18;
                                    z8 = false;
                                }
                                z7 = false;
                            } else {
                                if (z10) {
                                    int i19 = r15;
                                    for (char c10 = '`'; i19 < length2 && r14.charAt(i19) != c10; c10 = '`') {
                                        if (r14.charAt(i19) == '\\') {
                                            i19++;
                                        }
                                        i19++;
                                    }
                                    if (i19 >= length2) {
                                        b(spannableStringBuilder, r15, length2, -8800001);
                                        i10 = length2;
                                    } else {
                                        int i20 = i19 + 1;
                                        b(spannableStringBuilder, r15, i20, -8800001);
                                        i10 = i20;
                                        z10 = false;
                                    }
                                } else {
                                    char charAt2 = r14.charAt(r15);
                                    if (z11) {
                                        if (charAt2 == '/') {
                                            int i21 = r15 + 1;
                                            if (i21 < length2) {
                                                it2 = it3;
                                                c3 = '/';
                                                if (r14.charAt(i21) == '/') {
                                                    b(spannableStringBuilder, r15, length2, -6971995);
                                                    z2 = false;
                                                    i8 = length2;
                                                    z7 = z2;
                                                    it3 = it2;
                                                    i9 = i8;
                                                    i12 = 4;
                                                }
                                            }
                                        } else {
                                            it2 = it3;
                                            c3 = '/';
                                        }
                                        if (z12 || charAt2 != c3 || (i7 = r15 + 1) >= length2 || r14.charAt(i7) != '*') {
                                            z2 = false;
                                            if (z || charAt2 != '#') {
                                                if (charAt2 != '\"' || charAt2 == '\'' || (charAt2 == '`' && c8 == 0)) {
                                                    z3 = z11;
                                                    z4 = z12;
                                                    z5 = z;
                                                    i2 = r15 + 1;
                                                    while (i2 < length2 && r14.charAt(i2) != charAt2) {
                                                        if (r14.charAt(i2) != '\\') {
                                                            i2++;
                                                        }
                                                        i2++;
                                                    }
                                                    if (i2 < length2) {
                                                        b(spannableStringBuilder, r15, length2, -8800001);
                                                        if (charAt2 == '`') {
                                                            z10 = true;
                                                        }
                                                        i5 = length2;
                                                        z = z5;
                                                        it3 = it2;
                                                        z11 = z3;
                                                        z12 = z4;
                                                        i10 = i5;
                                                    } else {
                                                        i3 = i2 + 1;
                                                        if (c8 == 4) {
                                                            int i22 = i3;
                                                            while (i22 < length2 && r14.charAt(i22) == ' ') {
                                                                i22++;
                                                            }
                                                            if (i22 < length2) {
                                                                if (r14.charAt(i22) == ':') {
                                                                    i4 = -8001379;
                                                                    b(spannableStringBuilder, r15, i3, i4);
                                                                }
                                                                i4 = -8800001;
                                                                b(spannableStringBuilder, r15, i3, i4);
                                                            }
                                                        }
                                                        i4 = -8800001;
                                                        b(spannableStringBuilder, r15, i3, i4);
                                                    }
                                                } else {
                                                    if (Character.isDigit(charAt2)) {
                                                        if (r15 != 0) {
                                                            int i23 = r15 - 1;
                                                            if (!Character.isLetterOrDigit(r14.charAt(i23))) {
                                                                if (r14.charAt(i23) != '_') {
                                                                }
                                                            }
                                                        }
                                                        int i24 = r15 + 1;
                                                        while (i24 < length2 && (Character.isLetterOrDigit(r14.charAt(i24)) || r14.charAt(i24) == '.' || r14.charAt(i24) == '_')) {
                                                            i24++;
                                                        }
                                                        if (c8 != 4) {
                                                            b(spannableStringBuilder, r15, i24, -8800001);
                                                        }
                                                        i6 = i24;
                                                        it3 = it2;
                                                        i10 = i6;
                                                    }
                                                    if (Character.isLetter(charAt2) || charAt2 == '_' || charAt2 == '$') {
                                                        i3 = r15 + 1;
                                                        while (i3 < length2) {
                                                            if (!Character.isLetterOrDigit(r14.charAt(i3)) && r14.charAt(i3) != '_') {
                                                                if (r14.charAt(i3) != '$') {
                                                                    break;
                                                                }
                                                                i3++;
                                                            }
                                                            i3++;
                                                        }
                                                        if (c8 == 0 || c8 == 2) {
                                                            String substring = r14.substring(r15, i3);
                                                            i.b.d(substring, "substring(...)");
                                                            int i25 = r15 - 1;
                                                            while (true) {
                                                                if (i25 < 0) {
                                                                    z3 = z11;
                                                                    c4 = ' ';
                                                                    break;
                                                                }
                                                                z3 = z11;
                                                                c4 = ' ';
                                                                if (r14.charAt(i25) != ' ') {
                                                                    break;
                                                                }
                                                                i25--;
                                                                z11 = z3;
                                                            }
                                                            int i26 = i3;
                                                            while (true) {
                                                                z4 = z12;
                                                                if (i26 >= length2 || r14.charAt(i26) != c4) {
                                                                    break;
                                                                }
                                                                i26++;
                                                                z12 = z4;
                                                                c4 = ' ';
                                                            }
                                                            char charAt3 = i25 >= 0 ? r14.charAt(i25) : ' ';
                                                            char charAt4 = i26 < length2 ? r14.charAt(i26) : ' ';
                                                            Set set = c8 == 2 ? f68b : f67a;
                                                            z5 = z;
                                                            if (charAt3 != '.' && set.contains(substring)) {
                                                                b(spannableStringBuilder, r15, i3, -1422758);
                                                            } else if (charAt3 != '.' && f69c.contains(substring)) {
                                                                b(spannableStringBuilder, r15, i3, -8800001);
                                                            } else if (charAt3 == '.') {
                                                                int i27 = i26 + 1;
                                                                char charAt5 = i27 < length2 ? r14.charAt(i27) : ' ';
                                                                if (charAt4 == '=' && charAt5 != '=') {
                                                                    if (charAt5 != '>') {
                                                                        z6 = true;
                                                                        b(spannableStringBuilder, r15, i3, (charAt4 != '(' || z6) ? -5008656 : -8800001);
                                                                    }
                                                                }
                                                                z6 = false;
                                                                b(spannableStringBuilder, r15, i3, (charAt4 != '(' || z6) ? -5008656 : -8800001);
                                                            } else if (charAt4 == '(') {
                                                                b(spannableStringBuilder, r15, i3, -5008656);
                                                            }
                                                        } else {
                                                            z3 = z11;
                                                            z4 = z12;
                                                            z5 = z;
                                                        }
                                                    } else {
                                                        i6 = r15 + 1;
                                                        it3 = it2;
                                                        i10 = i6;
                                                    }
                                                }
                                                i5 = i3;
                                                z = z5;
                                                it3 = it2;
                                                z11 = z3;
                                                z12 = z4;
                                                i10 = i5;
                                            } else {
                                                b(spannableStringBuilder, r15, length2, -6971995);
                                                i8 = length2;
                                                z7 = z2;
                                                it3 = it2;
                                                i9 = i8;
                                                i12 = 4;
                                            }
                                        } else {
                                            z2 = false;
                                            int Q4 = m.e.Q(r14, "*/", r15 + 2, false, 4);
                                            if (Q4 < 0) {
                                                b(spannableStringBuilder, r15, length2, -6971995);
                                                i8 = length2;
                                                z8 = true;
                                            } else {
                                                int i28 = Q4 + 2;
                                                b(spannableStringBuilder, r15, i28, -6971995);
                                                i8 = i28;
                                            }
                                            z7 = z2;
                                            it3 = it2;
                                            i9 = i8;
                                            i12 = 4;
                                        }
                                    }
                                    it2 = it3;
                                    c3 = '/';
                                    if (z12) {
                                    }
                                    z2 = false;
                                    if (z) {
                                    }
                                    if (charAt2 != '\"') {
                                    }
                                    z3 = z11;
                                    z4 = z12;
                                    z5 = z;
                                    i2 = r15 + 1;
                                    while (i2 < length2) {
                                        if (r14.charAt(i2) != '\\') {
                                        }
                                        i2++;
                                    }
                                    if (i2 < length2) {
                                    }
                                }
                                z7 = false;
                                i9 = i10;
                                i12 = 4;
                            }
                            r15 = i9;
                        }
                    }
                    z = true;
                    r15 = z7;
                    while (r15 < length2) {
                    }
                }
                it = it3;
                c2 = '.';
                r14 = spannableStringBuilder;
            }
            arrayList.add(r14);
            c5 = c2;
            it3 = it;
            z7 = false;
            i12 = 4;
            c6 = 6;
            c7 = 5;
        }
        return arrayList;
    }

    public static void b(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4) {
        if (i3 > i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i4), i2, i3, 33);
        }
    }
}
