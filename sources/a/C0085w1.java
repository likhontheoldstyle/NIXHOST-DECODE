package a;

import com.nix.host.MainActivity;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

/* renamed from: a.w1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0085w1 implements h.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f696a;

    @Override // h.b
    public final Object a(Object obj) {
        switch (this.f696a) {
            case 0:
                int i2 = C0091y1.f719s;
                return b.d.f770c;
            case 1:
                int i3 = MainActivity.R;
                return Boolean.valueOf(!((File) obj).isDirectory());
            case 2:
                int i4 = MainActivity.R;
                String lowerCase = ((File) obj).getName().toLowerCase(Locale.ROOT);
                i.b.d(lowerCase, "toLowerCase(...)");
                return lowerCase;
            case 3:
                ((Float) obj).getClass();
                int i5 = MainActivity.R;
                return b.d.f770c;
            case 4:
                Byte b2 = (Byte) obj;
                b2.byteValue();
                return String.format("%02x", Arrays.copyOf(new Object[]{b2}, 1));
            case 5:
                Byte b3 = (Byte) obj;
                b3.byteValue();
                return String.format("%02x", Arrays.copyOf(new Object[]{b3}, 1));
            default:
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() + " " + entry.getValue();
        }
    }
}
