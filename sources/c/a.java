package c;

import a.AbstractC0008c;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class a extends AbstractC0008c {
    public static boolean C(char[] cArr, char c2) {
        int length = cArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            if (c2 == cArr[i2]) {
                break;
            }
            i2++;
        }
        return i2 >= 0;
    }

    public static String D(byte[] bArr, h.b bVar) {
        i.b.e(bArr, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int i2 = 0;
        for (byte b2 : bArr) {
            i2++;
            if (i2 > 1) {
                sb.append((CharSequence) "");
            }
            sb.append((CharSequence) bVar.a(Byte.valueOf(b2)));
        }
        sb.append((CharSequence) "");
        String sb2 = sb.toString();
        i.b.d(sb2, "toString(...)");
        return sb2;
    }

    public static char E(char[] cArr) {
        i.b.e(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static List F(Object[] objArr, Comparator comparator) {
        if (objArr.length != 0) {
            objArr = Arrays.copyOf(objArr, objArr.length);
            i.b.d(objArr, "copyOf(...)");
            if (objArr.length > 1) {
                Arrays.sort(objArr, comparator);
            }
        }
        List asList = Arrays.asList(objArr);
        i.b.d(asList, "asList(...)");
        return asList;
    }
}
