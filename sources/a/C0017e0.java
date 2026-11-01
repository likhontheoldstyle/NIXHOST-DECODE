package a;

import android.app.Dialog;
import android.net.Uri;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;

/* renamed from: a.e0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0017e0 implements h.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f457a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f458b;

    public /* synthetic */ C0017e0(C0006b1 c0006b1, int i2) {
        this.f457a = i2;
        this.f458b = c0006b1;
    }

    @Override // h.c
    public final Object a(Object obj, Object obj2) {
        switch (this.f457a) {
            case 0:
                List list = (List) obj;
                List list2 = (List) obj2;
                C0006b1 c0006b1 = this.f458b;
                if (c0006b1.z1) {
                    c0006b1.z1 = false;
                    Uri uri = (Uri) c.b.I(list);
                    if (uri != null) {
                        c0006b1.I0(uri);
                    }
                } else {
                    if (!list.isEmpty()) {
                        c0006b1.F0(list);
                    }
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        c0006b1.G0((Uri) it.next());
                    }
                }
                break;
            default:
                LinearLayout linearLayout = (LinearLayout) obj;
                final Dialog dialog = (Dialog) obj2;
                final C0006b1 c0006b12 = this.f458b;
                TextView f1 = c0006b12.f1("Change profile photo", 21.0f, c0006b12.f425l, true);
                f1.setGravity(17);
                linearLayout.addView(f1, c0006b12.W(-1, -2, 0, 4, 0, 10));
                final int i2 = 0;
                c0006b12.O0(linearLayout, "trashf", "Remove", c0006b12.f425l, new h.a() { // from class: a.y
                    @Override // h.a
                    public final Object a() {
                        switch (i2) {
                            case 0:
                                dialog.dismiss();
                                C0006b1 c0006b13 = c0006b12;
                                CharSequence charSequence = (CharSequence) c0006b13.l0.get(c0006b13.f415b);
                                h.b bVar = c0006b13.f416c;
                                if (charSequence == null || charSequence.length() == 0) {
                                    bVar.a("You have no profile photo");
                                } else if (c0006b13.e0()) {
                                    bVar.a("No internet connection");
                                } else {
                                    new Thread(new RunnableC0048m(c0006b13, 4)).start();
                                }
                                break;
                            default:
                                dialog.dismiss();
                                C0006b1 c0006b14 = c0006b12;
                                c0006b14.z1 = true;
                                c0006b14.l0();
                                break;
                        }
                        return b.d.f770c;
                    }
                });
                final int i3 = 1;
                c0006b12.O0(linearLayout, "image", "Choose photo", c0006b12.f425l, new h.a() { // from class: a.y
                    @Override // h.a
                    public final Object a() {
                        switch (i3) {
                            case 0:
                                dialog.dismiss();
                                C0006b1 c0006b13 = c0006b12;
                                CharSequence charSequence = (CharSequence) c0006b13.l0.get(c0006b13.f415b);
                                h.b bVar = c0006b13.f416c;
                                if (charSequence == null || charSequence.length() == 0) {
                                    bVar.a("You have no profile photo");
                                } else if (c0006b13.e0()) {
                                    bVar.a("No internet connection");
                                } else {
                                    new Thread(new RunnableC0048m(c0006b13, 4)).start();
                                }
                                break;
                            default:
                                dialog.dismiss();
                                C0006b1 c0006b14 = c0006b12;
                                c0006b14.z1 = true;
                                c0006b14.l0();
                                break;
                        }
                        return b.d.f770c;
                    }
                });
                break;
        }
        return b.d.f770c;
    }
}
