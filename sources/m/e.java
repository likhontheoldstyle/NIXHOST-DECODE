package m;

import a.AbstractC0008c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class e extends m {
    public static boolean L(CharSequence charSequence) {
        i.b.e(charSequence, "<this>");
        return P(charSequence, '/', 0, false, 2) >= 0;
    }

    public static boolean M(String str, String str2) {
        return Q(str, str2, 0, false, 2) >= 0;
    }

    public static final int N(CharSequence charSequence) {
        i.b.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int O(int i2, CharSequence charSequence, String str, boolean z) {
        i.b.e(charSequence, "<this>");
        i.b.e(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i2);
        }
        int length = charSequence.length();
        if (i2 < 0) {
            i2 = 0;
        }
        int length2 = charSequence.length();
        if (length > length2) {
            length = length2;
        }
        k.c cVar = new k.c(i2, length, 1);
        boolean z2 = charSequence instanceof String;
        int i3 = cVar.f853b;
        if (z2) {
            if (i2 <= i3) {
                while (!m.G(str, 0, (String) charSequence, i2, str.length(), z)) {
                    if (i2 != i3) {
                        i2++;
                    }
                }
                return i2;
            }
        } else if (i2 <= i3) {
            while (!W(str, 0, charSequence, i2, str.length(), z)) {
                if (i2 != i3) {
                    i2++;
                }
            }
            return i2;
        }
        return -1;
    }

    public static int P(CharSequence charSequence, char c2, int i2, boolean z, int i3) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        i.b.e(charSequence, "<this>");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c2, i2);
        }
        char[] cArr = {c2};
        i.b.e(charSequence, "<this>");
        i.b.e(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c.a.E(cArr), i2);
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int N = N(charSequence);
        if (i2 <= N) {
            while (true) {
                char charAt = charSequence.charAt(i2);
                for (char c3 : cArr) {
                    if (AbstractC0008c.h(c3, charAt, z)) {
                        return i2;
                    }
                }
                if (i2 == N) {
                    break;
                }
                i2++;
            }
        }
        return -1;
    }

    public static /* synthetic */ int Q(CharSequence charSequence, String str, int i2, boolean z, int i3) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return O(i2, charSequence, str, z);
    }

    public static boolean R(String str) {
        i.b.e(str, "<this>");
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (!Character.isWhitespace(charAt) && !Character.isSpaceChar(charAt)) {
                return false;
            }
        }
        return true;
    }

    public static int S(CharSequence charSequence, char c2) {
        int N = N(charSequence);
        i.b.e(charSequence, "<this>");
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(c2, N);
        }
        char[] cArr = {c2};
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(c.a.E(cArr), N);
        }
        int N2 = N(charSequence);
        if (N > N2) {
            N = N2;
        }
        while (-1 < N) {
            if (AbstractC0008c.h(cArr[0], charSequence.charAt(N), false)) {
                return N;
            }
            N--;
        }
        return -1;
    }

    public static List T(String str) {
        Iterator it = V(str, new String[]{"\r\n", "\n", "\r"}, false, 0).iterator();
        if (!it.hasNext()) {
            return c.j.f773a;
        }
        k.c cVar = (k.c) it.next();
        i.b.e(cVar, "it");
        String obj = str.subSequence(cVar.f852a, cVar.f853b + 1).toString();
        if (!it.hasNext()) {
            return AbstractC0008c.p(obj);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(obj);
        while (it.hasNext()) {
            k.c cVar2 = (k.c) it.next();
            i.b.e(cVar2, "it");
            arrayList.add(str.subSequence(cVar2.f852a, cVar2.f853b + 1).toString());
        }
        return arrayList;
    }

    public static String U(String str) {
        CharSequence charSequence;
        i.b.e(str, "<this>");
        if (2 <= str.length()) {
            charSequence = str.subSequence(0, str.length());
        } else {
            StringBuilder sb = new StringBuilder(2);
            int length = 2 - str.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append('0');
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            sb.append((CharSequence) str);
            charSequence = sb;
        }
        return charSequence.toString();
    }

    public static c V(CharSequence charSequence, String[] strArr, boolean z, int i2) {
        Z(i2);
        List asList = Arrays.asList(strArr);
        i.b.d(asList, "asList(...)");
        return new c(charSequence, 0, i2, new n(asList, z));
    }

    public static final boolean W(CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4, boolean z) {
        i.b.e(charSequence, "<this>");
        i.b.e(charSequence2, "other");
        if (i3 < 0 || i2 < 0 || i2 > charSequence.length() - i4 || i3 > charSequence2.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!AbstractC0008c.h(charSequence.charAt(i2 + i5), charSequence2.charAt(i3 + i5), z)) {
                return false;
            }
        }
        return true;
    }

    public static String X(String str, String str2) {
        i.b.e(str, "<this>");
        i.b.e(str2, "prefix");
        if (!m.K(str, str2)) {
            return str;
        }
        String substring = str.substring(str2.length());
        i.b.d(substring, "substring(...)");
        return substring;
    }

    public static String Y(String str, String str2) {
        i.b.e(str, "<this>");
        if (!str.endsWith(str2)) {
            return str;
        }
        String substring = str.substring(0, str.length() - str2.length());
        i.b.d(substring, "substring(...)");
        return substring;
    }

    public static final void Z(int i2) {
        if (i2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2).toString());
    }

    public static final List a0(int i2, CharSequence charSequence, String str, boolean z) {
        Z(i2);
        int i3 = 0;
        int O = O(0, charSequence, str, z);
        if (O == -1 || i2 == 1) {
            return AbstractC0008c.p(charSequence.toString());
        }
        boolean z2 = i2 > 0;
        int i4 = 10;
        if (z2 && i2 <= 10) {
            i4 = i2;
        }
        ArrayList arrayList = new ArrayList(i4);
        do {
            arrayList.add(charSequence.subSequence(i3, O).toString());
            i3 = str.length() + O;
            if (z2 && arrayList.size() == i2 - 1) {
                break;
            }
            O = O(i3, charSequence, str, z);
        } while (O != -1);
        arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
        return arrayList;
    }

    public static List b0(CharSequence charSequence, String[] strArr) {
        i.b.e(charSequence, "<this>");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return a0(0, charSequence, str, false);
            }
        }
        c<k.c> V = V(charSequence, strArr, false, 0);
        ArrayList arrayList = new ArrayList(c.d.E(new l.f(V)));
        for (k.c cVar : V) {
            i.b.e(cVar, "range");
            arrayList.add(charSequence.subSequence(cVar.f852a, cVar.f853b + 1).toString());
        }
        return arrayList;
    }

    public static String c0(String str, char c2, String str2) {
        i.b.e(str, "<this>");
        i.b.e(str2, "missingDelimiterValue");
        int P = P(str, c2, 0, false, 6);
        if (P == -1) {
            return str2;
        }
        String substring = str.substring(P + 1, str.length());
        i.b.d(substring, "substring(...)");
        return substring;
    }

    public static String d0(String str, char c2, String str2) {
        i.b.e(str, "<this>");
        i.b.e(str2, "missingDelimiterValue");
        int S = S(str, c2);
        if (S == -1) {
            return str2;
        }
        String substring = str.substring(S + 1, str.length());
        i.b.d(substring, "substring(...)");
        return substring;
    }

    public static String e0(String str, char c2) {
        i.b.e(str, "<this>");
        i.b.e(str, "missingDelimiterValue");
        int P = P(str, c2, 0, false, 6);
        if (P == -1) {
            return str;
        }
        String substring = str.substring(0, P);
        i.b.d(substring, "substring(...)");
        return substring;
    }

    public static String f0(String str, String str2) {
        i.b.e(str, "<this>");
        i.b.e(str, "missingDelimiterValue");
        int Q = Q(str, str2, 0, false, 6);
        if (Q == -1) {
            return str;
        }
        String substring = str.substring(0, Q);
        i.b.d(substring, "substring(...)");
        return substring;
    }

    public static String g0(int i2, String str) {
        if (i2 < 0) {
            throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
        }
        int length = str.length();
        if (i2 > length) {
            i2 = length;
        }
        String substring = str.substring(0, i2);
        i.b.d(substring, "substring(...)");
        return substring;
    }

    public static CharSequence h0(CharSequence charSequence) {
        i.b.e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            char charAt = charSequence.charAt(!z ? i2 : length);
            boolean z2 = Character.isWhitespace(charAt) || Character.isSpaceChar(charAt);
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static String i0(String str, char... cArr) {
        i.b.e(str, "<this>");
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean C = c.a.C(cArr, str.charAt(!z ? i2 : length));
            if (z) {
                if (!C) {
                    break;
                }
                length--;
            } else if (C) {
                i2++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i2, length + 1).toString();
    }

    public static String j0(String str, char... cArr) {
        CharSequence charSequence;
        i.b.e(str, "<this>");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (!c.a.C(cArr, str.charAt(length))) {
                    charSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
            return charSequence.toString();
        }
        charSequence = "";
        return charSequence.toString();
    }

    public static String k0(String str, char... cArr) {
        CharSequence charSequence;
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                charSequence = "";
                break;
            }
            if (!c.a.C(cArr, str.charAt(i2))) {
                charSequence = str.subSequence(i2, str.length());
                break;
            }
            i2++;
        }
        return charSequence.toString();
    }
}
