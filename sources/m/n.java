package m;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class n extends i.c implements h.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f878a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f879b;

    public n(List list, boolean z) {
        this.f878a = list;
        this.f879b = z;
    }

    @Override // h.c
    public final Object a(Object obj, Object obj2) {
        int i2;
        boolean z;
        Object obj3;
        b.b bVar;
        Object obj4;
        CharSequence charSequence = (CharSequence) obj;
        int intValue = ((Number) obj2).intValue();
        i.b.e(charSequence, "$this$$receiver");
        List list = this.f878a;
        boolean z2 = this.f879b;
        if (z2 || list.size() != 1) {
            if (intValue < 0) {
                intValue = 0;
            }
            boolean z3 = charSequence instanceof String;
            int i3 = new k.c(intValue, charSequence.length(), 1).f853b;
            if (z3) {
                if (intValue <= i3) {
                    while (true) {
                        Iterator it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj4 = null;
                                break;
                            }
                            obj4 = it.next();
                            String str = (String) obj4;
                            if (m.G(str, 0, (String) charSequence, intValue, str.length(), z2)) {
                                break;
                            }
                        }
                        String str2 = (String) obj4;
                        if (str2 == null) {
                            if (intValue == i3) {
                                break;
                            }
                            intValue++;
                        } else {
                            bVar = new b.b(Integer.valueOf(intValue), str2);
                            break;
                        }
                    }
                }
                bVar = null;
            } else {
                if (intValue <= i3) {
                    int i4 = intValue;
                    while (true) {
                        Iterator it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                i2 = i3;
                                z = z2;
                                obj3 = null;
                                break;
                            }
                            obj3 = it2.next();
                            String str3 = (String) obj3;
                            i2 = i3;
                            z = z2;
                            if (e.W(str3, 0, charSequence, i4, str3.length(), z2)) {
                                break;
                            }
                            z2 = z;
                            i3 = i2;
                        }
                        String str4 = (String) obj3;
                        if (str4 == null) {
                            if (i4 == i2) {
                                break;
                            }
                            i4++;
                            z2 = z;
                            i3 = i2;
                        } else {
                            bVar = new b.b(Integer.valueOf(i4), str4);
                            break;
                        }
                    }
                }
                bVar = null;
            }
        } else {
            int size = list.size();
            if (size == 0) {
                throw new NoSuchElementException("List is empty.");
            }
            if (size != 1) {
                throw new IllegalArgumentException("List has more than one element.");
            }
            String str5 = (String) list.get(0);
            int Q = e.Q(charSequence, str5, intValue, false, 4);
            if (Q >= 0) {
                bVar = new b.b(Integer.valueOf(Q), str5);
            }
            bVar = null;
        }
        if (bVar == null) {
            return null;
        }
        return new b.b(bVar.f764a, Integer.valueOf(((String) bVar.f765b).length()));
    }
}
