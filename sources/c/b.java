package c;

import a.AbstractC0008c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public abstract class b extends h {
    public static List H(Iterable iterable, int i2) {
        ArrayList arrayList;
        Object obj;
        i.b.e(iterable, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return Q(iterable);
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size() - i2;
            if (size <= 0) {
                return j.f773a;
            }
            if (size == 1) {
                if (iterable instanceof List) {
                    obj = M((List) iterable);
                } else {
                    Iterator it = iterable.iterator();
                    if (!it.hasNext()) {
                        throw new NoSuchElementException("Collection is empty.");
                    }
                    Object next = it.next();
                    while (it.hasNext()) {
                        next = it.next();
                    }
                    obj = next;
                }
                return AbstractC0008c.p(obj);
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    int size2 = collection.size();
                    while (i2 < size2) {
                        arrayList.add(((List) iterable).get(i2));
                        i2++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i2);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i3 = 0;
        for (Object obj2 : iterable) {
            if (i3 >= i2) {
                arrayList.add(obj2);
            } else {
                i3++;
            }
        }
        return c.D(arrayList);
    }

    public static Object I(List list) {
        i.b.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object J(List list, int i2) {
        if (i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return list.get(i2);
    }

    public static final void K(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, h.b bVar) {
        i.b.e(iterable, "<this>");
        i.b.e(charSequence, "separator");
        i.b.e(charSequence2, "prefix");
        i.b.e(charSequence3, "postfix");
        i.b.e(charSequence4, "truncated");
        sb.append(charSequence2);
        Iterator it = iterable.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i3++;
            if (i3 > 1) {
                sb.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (bVar != null) {
                sb.append((CharSequence) bVar.a(next));
            } else {
                if (next != null ? next instanceof CharSequence : true) {
                    sb.append((CharSequence) next);
                } else if (next instanceof Character) {
                    sb.append(((Character) next).charValue());
                } else {
                    sb.append((CharSequence) String.valueOf(next));
                }
            }
        }
        if (i2 >= 0 && i3 > i2) {
            sb.append(charSequence4);
        }
        sb.append(charSequence3);
    }

    public static String L(Iterable iterable, String str, String str2, String str3, h.b bVar, int i2) {
        String str4 = (i2 & 2) != 0 ? "" : str2;
        String str5 = (i2 & 4) != 0 ? "" : str3;
        if ((i2 & 32) != 0) {
            bVar = null;
        }
        i.b.e(iterable, "<this>");
        i.b.e(str4, "prefix");
        i.b.e(str5, "postfix");
        StringBuilder sb = new StringBuilder();
        K(iterable, sb, str, str4, str5, -1, "...", bVar);
        String sb2 = sb.toString();
        i.b.d(sb2, "toString(...)");
        return sb2;
    }

    public static Object M(List list) {
        i.b.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(list.size() - 1);
    }

    public static ArrayList N(List list, List list2) {
        ArrayList arrayList = new ArrayList(list2.size() + list.size());
        arrayList.addAll(list);
        arrayList.addAll(list2);
        return arrayList;
    }

    public static List O(List list, Comparator comparator) {
        i.b.e(list, "<this>");
        if (list.size() <= 1) {
            return Q(list);
        }
        Object[] array = list.toArray(new Object[0]);
        i.b.e(array, "<this>");
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        List asList = Arrays.asList(array);
        i.b.d(asList, "asList(...)");
        return asList;
    }

    public static List P(Iterable iterable, int i2) {
        Object next;
        if (i2 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return j.f773a;
        }
        if (i2 >= ((Collection) iterable).size()) {
            return Q(iterable);
        }
        int i3 = 0;
        if (i2 != 1) {
            ArrayList arrayList = new ArrayList(i2);
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
                i3++;
                if (i3 == i2) {
                    break;
                }
            }
            return c.D(arrayList);
        }
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                throw new NoSuchElementException("List is empty.");
            }
            next = list.get(0);
        } else {
            Iterator it2 = iterable.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException("Collection is empty.");
            }
            next = it2.next();
        }
        return AbstractC0008c.p(next);
    }

    public static List Q(Iterable iterable) {
        ArrayList arrayList;
        i.b.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return j.f773a;
            }
            if (size != 1) {
                return new ArrayList(collection);
            }
            return AbstractC0008c.p(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        i.b.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            arrayList = new ArrayList((Collection) iterable);
        } else {
            arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return c.D(arrayList);
    }
}
