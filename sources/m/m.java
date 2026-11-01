package m;

/* loaded from: classes.dex */
public abstract class m extends l {
    public static boolean E(String str, String str2) {
        i.b.e(str, "<this>");
        return str.endsWith(str2);
    }

    public static boolean F(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    public static final boolean G(String str, int i2, String str2, int i3, int i4, boolean z) {
        i.b.e(str, "<this>");
        i.b.e(str2, "other");
        return !z ? str.regionMatches(i2, str2, i3, i4) : str.regionMatches(z, i2, str2, i3, i4);
    }

    public static String H(int i2, String str) {
        if (i2 < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i2 + '.').toString());
        }
        if (i2 == 0) {
            return "";
        }
        int i3 = 1;
        if (i2 == 1) {
            return str.toString();
        }
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char charAt = str.charAt(0);
            char[] cArr = new char[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                cArr[i4] = charAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(str.length() * i2);
        if (1 <= i2) {
            while (true) {
                sb.append((CharSequence) str);
                if (i3 == i2) {
                    break;
                }
                i3++;
            }
        }
        String sb2 = sb.toString();
        i.b.b(sb2);
        return sb2;
    }

    public static String I(String str, char c2, char c3) {
        i.b.e(str, "<this>");
        String replace = str.replace(c2, c3);
        i.b.d(replace, "replace(...)");
        return replace;
    }

    public static String J(String str, String str2, String str3) {
        i.b.e(str, "<this>");
        i.b.e(str3, "newValue");
        int O = e.O(0, str, str2, false);
        if (O < 0) {
            return str;
        }
        int length = str2.length();
        int i2 = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        int i3 = 0;
        do {
            sb.append((CharSequence) str, i3, O);
            sb.append(str3);
            i3 = O + length;
            if (O >= str.length()) {
                break;
            }
            O = e.O(O + i2, str, str2, false);
        } while (O > 0);
        sb.append((CharSequence) str, i3, str.length());
        String sb2 = sb.toString();
        i.b.d(sb2, "toString(...)");
        return sb2;
    }

    public static boolean K(String str, String str2) {
        i.b.e(str, "<this>");
        i.b.e(str2, "prefix");
        return str.startsWith(str2);
    }
}
