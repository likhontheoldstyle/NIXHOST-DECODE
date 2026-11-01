package a;

import android.content.Context;
import android.content.Intent;
import com.nix.host.HostService;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class L2 {

    /* renamed from: a, reason: collision with root package name */
    public static final L2 f198a = new L2();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f199b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static volatile Context f200c;

    /* renamed from: d, reason: collision with root package name */
    public static volatile boolean f201d;

    public final synchronized boolean a() {
        boolean z;
        try {
            Collection values = f199b.values();
            z = false;
            if (!(values instanceof Collection) || !values.isEmpty()) {
                Iterator it = values.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((K2) it.next()).f175i) {
                        z = true;
                        break;
                    }
                }
            }
        } finally {
        }
        return z;
    }

    public final synchronized boolean b() {
        boolean z;
        try {
            Collection values = f199b.values();
            z = false;
            if (!(values instanceof Collection) || !values.isEmpty()) {
                Iterator it = values.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((K2) it.next()).f175i) {
                        z = true;
                        break;
                    }
                }
            }
        } finally {
        }
        return z;
    }

    public final void c() {
        Context context = f200c;
        if (context == null) {
            return;
        }
        try {
            if (!a() && !f201d) {
                G2 g2 = HostService.f775f;
                if (HostService.f775f == null) {
                    context.startService(new Intent(context, (Class<?>) HostService.class).setAction("com.nix.host.STOP"));
                }
            }
            context.startForegroundService(new Intent(context, (Class<?>) HostService.class).putExtra("keep", true).putExtra("busy", a()));
        } catch (Exception unused) {
        }
    }

    public final K2 d(File file, File file2, String str) {
        synchronized (this) {
            K2 k2 = (K2) f199b.get(str);
            if (k2 != null && (i.b.a(k2.f167a.getPath(), file.getPath()) || k2.f175i)) {
                return k2;
            }
            if (k2 != null) {
                try {
                    k2.h();
                } catch (Exception unused) {
                }
            }
            L2 l2 = f198a;
            K2 k22 = new K2(file, file2, l2.f(str));
            try {
                File f2 = l2.f(str);
                if (f2 != null) {
                    File file3 = new File(f2.getPath() + ".key");
                    File parentFile = file3.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    g.m.L(file3, str);
                }
            } catch (Exception unused2) {
            }
            f199b.put(str, k22);
            k22.n();
            return k22;
        }
    }

    public final synchronized void e() {
        for (K2 k2 : f199b.values()) {
            k2.getClass();
            try {
                k2.h();
            } catch (Exception unused) {
            }
        }
        f199b.clear();
    }

    public final synchronized File f(String str) {
        Context context = f200c;
        if (context == null) {
            return null;
        }
        File file = new File(context.getFilesDir(), "termlog");
        Pattern compile = Pattern.compile("[^A-Za-z0-9._-]");
        i.b.d(compile, "compile(...)");
        i.b.e(str, "input");
        String replaceAll = compile.matcher(str).replaceAll("_");
        i.b.d(replaceAll, "replaceAll(...)");
        return new File(file, replaceAll);
    }
}
