package m;

/* loaded from: classes.dex */
public abstract class l extends k {
    public static Integer C(String str) {
        boolean z;
        int i2;
        i.b.e(str, "<this>");
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char charAt = str.charAt(0);
        int i4 = 1;
        int i5 = -2147483647;
        if ((charAt < '0' ? (char) 65535 : charAt == '0' ? (char) 0 : (char) 1) >= 0) {
            z = false;
            i4 = 0;
        } else {
            if (length == 1) {
                return null;
            }
            if (charAt == '+') {
                z = false;
            } else {
                if (charAt != '-') {
                    return null;
                }
                i5 = Integer.MIN_VALUE;
                z = true;
            }
        }
        int i6 = -59652323;
        while (i4 < length) {
            int digit = Character.digit((int) str.charAt(i4), 10);
            if (digit < 0) {
                return null;
            }
            if ((i3 < i6 && (i6 != -59652323 || i3 < (i6 = i5 / 10))) || (i2 = i3 * 10) < i5 + digit) {
                return null;
            }
            i3 = i2 - digit;
            i4++;
        }
        return z ? Integer.valueOf(i3) : Integer.valueOf(-i3);
    }

    public static Long D(String str) {
        i.b.e(str, "<this>");
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char charAt = str.charAt(0);
        boolean z = true;
        long j2 = -9223372036854775807L;
        if ((charAt < '0' ? (char) 65535 : charAt == '0' ? (char) 0 : (char) 1) >= 0) {
            z = false;
        } else {
            if (length == 1) {
                return null;
            }
            if (charAt == '+') {
                z = false;
                i2 = 1;
            } else {
                if (charAt != '-') {
                    return null;
                }
                j2 = Long.MIN_VALUE;
                i2 = 1;
            }
        }
        long j3 = -256204778801521550L;
        long j4 = 0;
        long j5 = -256204778801521550L;
        while (i2 < length) {
            int digit = Character.digit((int) str.charAt(i2), 10);
            if (digit < 0) {
                return null;
            }
            if (j4 < j5) {
                if (j5 != j3) {
                    return null;
                }
                j5 = j2 / 10;
                if (j4 < j5) {
                    return null;
                }
            }
            long j6 = j4 * 10;
            long j7 = digit;
            if (j6 < j2 + j7) {
                return null;
            }
            j4 = j6 - j7;
            i2++;
            j3 = -256204778801521550L;
        }
        return z ? Long.valueOf(j4) : Long.valueOf(-j4);
    }
}
