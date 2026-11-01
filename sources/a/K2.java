package a;

import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class K2 {

    /* renamed from: a, reason: collision with root package name */
    public final File f167a;

    /* renamed from: b, reason: collision with root package name */
    public final File f168b;

    /* renamed from: c, reason: collision with root package name */
    public final File f169c;

    /* renamed from: d, reason: collision with root package name */
    public final StringBuilder f170d;

    /* renamed from: e, reason: collision with root package name */
    public int f171e;

    /* renamed from: f, reason: collision with root package name */
    public volatile File f172f;

    /* renamed from: g, reason: collision with root package name */
    public volatile String f173g;

    /* renamed from: h, reason: collision with root package name */
    public volatile int f174h;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f175i;

    /* renamed from: j, reason: collision with root package name */
    public volatile String f176j;

    /* renamed from: k, reason: collision with root package name */
    public volatile Process f177k;

    /* renamed from: l, reason: collision with root package name */
    public volatile int f178l;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f179m;

    /* renamed from: n, reason: collision with root package name */
    public volatile boolean f180n;

    /* renamed from: o, reason: collision with root package name */
    public volatile int f181o;
    public volatile boolean p;
    public volatile boolean q;

    /* renamed from: r, reason: collision with root package name */
    public final i.g f182r;

    /* renamed from: s, reason: collision with root package name */
    public final i.g f183s;

    /* renamed from: t, reason: collision with root package name */
    public final i.g f184t;

    /* renamed from: u, reason: collision with root package name */
    public final i.g f185u;

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ef, code lost:
    
        if (m.m.K(r3.getPath(), r4 + "/") != false) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public K2(File file, File file2, File file3) {
        this.f167a = file;
        this.f168b = file2;
        this.f169c = file3;
        StringBuilder sb = new StringBuilder();
        this.f170d = sb;
        this.f172f = file;
        if (file3 != null) {
            try {
                if (file3.isFile()) {
                    String I = g.m.I(file3);
                    if (I.length() > 40000) {
                        I = I.substring(I.length() - 40000);
                        i.b.d(I, "substring(...)");
                    }
                    sb.append(I);
                }
            } catch (Exception unused) {
            }
        }
        File o2 = o();
        if (o2 != null && o2.isFile()) {
            String obj = m.e.h0(g.m.I(o2)).toString();
            o2.delete();
            if (obj.length() > 0) {
                this.f173g = obj;
                File s2 = s();
                Integer num = null;
                if (s2 != null) {
                    try {
                        String obj2 = m.e.h0(g.m.I(s2)).toString();
                        if (obj2 != null) {
                            num = m.l.C(obj2);
                        }
                    } catch (Exception unused2) {
                    }
                }
                int intValue = (num != null ? num.intValue() : 0) + 1;
                if (s2 != null) {
                    try {
                        g.m.L(s2, String.valueOf(intValue));
                    } catch (Exception unused3) {
                    }
                }
                this.f174h = intValue;
                a("\n[Android stopped the app while this was running: " + obj + "]\n");
            }
        }
        File d2 = d();
        if (d2 != null && d2.isFile()) {
            String I2 = g.m.I(d2);
            if (I2.length() > 0) {
                File canonicalFile = new File(this.f167a, I2).getCanonicalFile();
                String canonicalPath = this.f167a.getCanonicalPath();
                if (canonicalFile.isDirectory()) {
                    if (!i.b.a(canonicalFile.getPath(), canonicalPath)) {
                    }
                    q(canonicalFile);
                }
            }
        }
        this.f176j = "";
        this.f182r = new i.g("^npm\\s+(install|i|ci|add|update|up)(\\s.*)?$");
        this.f183s = new i.g("\u001b\\[[0-9;?]*[ -/]*[@-~]");
        this.f184t = new i.g("[\u0001\u0002\u0003\u0004\f]");
        this.f185u = new i.g("\u001b(\\[[0-9;?]*[ -/]*)?$");
    }

    public static String b(int i2) {
        int i3 = (i2 * 16) / 100;
        return "[" + m.m.H(i3, "#") + m.m.H(16 - i3, ".") + "] " + i2 + "%";
    }

    public static void i(int i2) {
        Process start;
        BufferedReader bufferedReader;
        l.b bVar;
        List list;
        HashMap hashMap = new HashMap();
        try {
            start = new ProcessBuilder("/system/bin/ps", "-A", "-o", "PID,PPID").redirectErrorStream(true).start();
            bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream(), m.a.f864a), 8192);
        } catch (Exception unused) {
        }
        try {
            l.c aVar = new l.a(new g.p(bufferedReader));
            if (aVar instanceof l.b) {
                l.b bVar2 = (l.b) aVar;
                int i3 = bVar2.f862b + 1;
                bVar = i3 < 0 ? new l.b(bVar2, 1) : new l.b(bVar2.f861a, i3);
            } else {
                bVar = new l.b(aVar, 1);
            }
            Iterator it = bVar.f861a.iterator();
            int i4 = bVar.f862b;
            while (true) {
                if (i4 > 0) {
                    if (it.hasNext()) {
                        it.next();
                        i4--;
                    }
                }
                if (!it.hasNext()) {
                    break;
                }
                while (i4 > 0 && it.hasNext()) {
                    it.next();
                    i4--;
                }
                String obj = m.e.h0((String) it.next()).toString();
                Pattern compile = Pattern.compile("\\s+");
                i.b.d(compile, "compile(...)");
                i.b.e(obj, "input");
                m.e.Z(0);
                Matcher matcher = compile.matcher(obj);
                if (matcher.find()) {
                    ArrayList arrayList = new ArrayList(10);
                    int i5 = 0;
                    do {
                        arrayList.add(obj.subSequence(i5, matcher.start()).toString());
                        i5 = matcher.end();
                    } while (matcher.find());
                    arrayList.add(obj.subSequence(i5, obj.length()).toString());
                    list = arrayList;
                } else {
                    list = AbstractC0008c.p(obj.toString());
                }
                if (list.size() >= 2) {
                    Integer C = m.l.C((String) list.get(0));
                    Integer C2 = m.l.C((String) list.get(1));
                    if (C != null && C2 != null) {
                        Object obj2 = hashMap.get(C2);
                        if (obj2 == null) {
                            obj2 = new ArrayList();
                            hashMap.put(C2, obj2);
                        }
                        ((List) obj2).add(C);
                    }
                }
            }
            AbstractC0008c.a(bufferedReader, null);
            start.waitFor();
            ArrayList arrayList2 = new ArrayList();
            j(hashMap, arrayList2, i2);
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                try {
                    Process.killProcess(((Number) it2.next()).intValue());
                } catch (Exception unused2) {
                }
            }
        } finally {
        }
    }

    public static final void j(HashMap hashMap, ArrayList arrayList, int i2) {
        List list = (List) hashMap.get(Integer.valueOf(i2));
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                j(hashMap, arrayList, ((Number) it.next()).intValue());
            }
        }
        arrayList.add(Integer.valueOf(i2));
    }

    public final synchronized void a(String str) {
        try {
            this.f170d.append(str);
            if (this.f170d.length() > 60000) {
                int length = this.f170d.length() - 40000;
                this.f170d.delete(0, length);
                this.f171e += length;
                k(str, true);
            } else {
                k(str, false);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final String c(String str) {
        String str2;
        String sb;
        String replaceAll = ((Pattern) this.f184t.f850b).matcher(m.m.J(str, "\r", "")).replaceAll("");
        i.b.d(replaceAll, "replaceAll(...)");
        i.g gVar = this.f183s;
        gVar.getClass();
        m.d a2 = i.g.a(gVar, replaceAll);
        if (a2 == null) {
            sb = replaceAll.toString();
        } else {
            int length = replaceAll.length();
            StringBuilder sb2 = new StringBuilder(length);
            int i2 = 0;
            do {
                sb2.append((CharSequence) replaceAll, i2, a2.a().f852a);
                if (a2.b().endsWith("m")) {
                    String substring = a2.b().substring(2, a2.b().length() - 1);
                    i.b.d(substring, "substring(...)");
                    str2 = "\u0003" + substring + "\u0004";
                } else {
                    str2 = "";
                }
                sb2.append((CharSequence) str2);
                i2 = a2.a().f853b + 1;
                Matcher matcher = (Matcher) a2.f876a;
                int end = matcher.end() + (matcher.end() != matcher.start() ? 0 : 1);
                CharSequence charSequence = (CharSequence) a2.f877b;
                m.d dVar = null;
                if (end <= charSequence.length()) {
                    Matcher matcher2 = matcher.pattern().matcher(charSequence);
                    i.b.d(matcher2, "matcher(...)");
                    String str3 = (String) charSequence;
                    if (matcher2.find(end)) {
                        dVar = new m.d(matcher2, str3);
                    }
                }
                a2 = dVar;
                if (i2 >= length) {
                    break;
                }
            } while (a2 != null);
            if (i2 < length) {
                sb2.append((CharSequence) replaceAll, i2, length);
            }
            sb = sb2.toString();
            i.b.d(sb, "toString(...)");
        }
        return m.m.J(sb, "\u001b", "");
    }

    public final File d() {
        File file = this.f169c;
        if (file == null) {
            return null;
        }
        return new File(file.getPath() + ".cwd");
    }

    public final void e(File file, String str) {
        String str2;
        boolean z = true;
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        this.q = false;
        try {
            this.f168b.mkdirs();
            File file2 = new File(this.f168b, "tmp");
            file2.mkdirs();
            y2.f736a.O(file, this.f168b);
            ProcessBuilder processBuilder = new ProcessBuilder("/system/bin/sh", "-c", "echo __NIXPID__$$; " + str);
            processBuilder.directory(file);
            processBuilder.redirectErrorStream(true);
            Map<String, String> environment = processBuilder.environment();
            environment.put("HOME", this.f168b.getPath());
            environment.put("TMPDIR", file2.getPath());
            environment.put("TERM", "xterm-256color");
            environment.put("COLORTERM", "truecolor");
            environment.put("FORCE_COLOR", "1");
            environment.put("CLICOLOR_FORCE", "1");
            environment.put("npm_config_color", "always");
            environment.put("npm_config_cache", new File(this.f168b, ".npm").getPath());
            environment.put("npm_config_audit", "false");
            y2.a(environment, this.f168b, file);
            Process start = processBuilder.start();
            this.f177k = start;
            Thread thread = new Thread(new RunnableC0093z0(atomicBoolean, y2.q(file) ? 2500L : 1000L, file, this));
            thread.setDaemon(true);
            thread.start();
            InputStreamReader inputStreamReader = new InputStreamReader(start.getInputStream(), m.a.f864a);
            char[] cArr = new char[4096];
            StringBuilder sb = new StringBuilder();
            String str3 = "";
            boolean z2 = false;
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read < 0) {
                    break;
                }
                String str4 = str3 + new String(cArr, 0, read);
                if (!z2) {
                    sb.append(str4);
                    int indexOf = sb.indexOf("\n");
                    if (indexOf >= 0) {
                        Integer C = m.l.C(m.e.X(m.e.h0(sb.substring(0, indexOf)).toString(), "__NIXPID__"));
                        this.f178l = C != null ? C.intValue() : 0;
                        str4 = sb.substring(indexOf + 1);
                        z2 = z;
                    } else {
                        str3 = "";
                    }
                }
                m.d a2 = i.g.a(this.f185u, str4);
                if (a2 == null || str4.length() - a2.a().f852a >= 40) {
                    str2 = "";
                } else {
                    str2 = str4.substring(a2.a().f852a);
                    i.b.d(str2, "substring(...)");
                    str4 = str4.substring(0, a2.a().f852a);
                    i.b.d(str4, "substring(...)");
                }
                String c2 = c(str4);
                if (c2.length() > 0) {
                    a(c2);
                }
                str3 = str2;
                z = true;
            }
            start.waitFor();
        } catch (Exception e2) {
            if (!this.q) {
                String message = e2.getMessage();
                if (message == null) {
                    message = "could not run";
                }
                a("error: " + message + "\n");
            }
        }
        atomicBoolean.set(false);
        y2.f736a.O(file, this.f168b);
    }

    public final void f() {
        try {
            File o2 = o();
            if (o2 != null) {
                o2.delete();
            }
        } catch (Exception unused) {
        }
        try {
            File s2 = s();
            if (s2 != null) {
                s2.delete();
            }
        } catch (Exception unused2) {
        }
        this.f175i = false;
        this.p = false;
        this.f176j = "";
        this.f177k = null;
        this.f178l = 0;
        L2.f198a.c();
    }

    public final void g(ArrayList arrayList, String str) {
        this.f175i = true;
        this.f179m = true;
        this.f180n = false;
        this.f176j = b(0);
        L2.f198a.c();
        new Thread(new K(arrayList, this, this.f172f, str)).start();
    }

    public final void h() {
        Process process = this.f177k;
        if (process != null) {
            this.q = true;
            int i2 = this.f178l;
            if (i2 > 0) {
                try {
                    i(i2);
                } catch (Exception unused) {
                }
            }
            try {
                process.destroyForcibly();
                return;
            } catch (Exception unused2) {
                return;
            }
        }
        if (this.f179m) {
            this.f180n = true;
        } else if (this.p) {
            this.f181o++;
            f();
        }
    }

    public final void k(String str, boolean z) {
        try {
            File file = this.f169c;
            if (file == null) {
                return;
            }
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            if (z) {
                g.m.L(file, this.f170d.toString());
                return;
            }
            Charset charset = m.a.f864a;
            i.b.e(str, "text");
            i.b.e(charset, "charset");
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            try {
                g.m.M(fileOutputStream, str, charset);
                AbstractC0008c.a(fileOutputStream, null);
            } finally {
            }
        } catch (Exception unused) {
        }
    }

    public final String l() {
        try {
            String canonicalPath = this.f167a.getCanonicalPath();
            String canonicalPath2 = this.f172f.getCanonicalPath();
            return i.b.a(canonicalPath2, canonicalPath) ? "" : m.e.X(canonicalPath2, canonicalPath);
        } catch (Exception unused) {
            return "";
        }
    }

    public final File m(String str) {
        File file;
        try {
            String i0 = m.e.i0(m.e.h0(str).toString(), '\"', '\'');
            if (i.b.a(i0, "~")) {
                file = this.f167a;
            } else {
                file = m.m.K(i0, "/") ? new File(this.f167a, i0) : new File(this.f172f, i0);
            }
            File canonicalFile = file.getCanonicalFile();
            String canonicalPath = this.f167a.getCanonicalPath();
            if (!i.b.a(canonicalFile.getPath(), canonicalPath)) {
                if (!m.m.K(canonicalFile.getPath(), canonicalPath + "/")) {
                    return null;
                }
            }
            return canonicalFile;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void n() {
        String str = this.f173g;
        if (str == null) {
            return;
        }
        this.f173g = null;
        if (this.f175i) {
            return;
        }
        Pattern compile = Pattern.compile("^(rm|mv|cp|kill|clear)(\\s.*)?$");
        i.b.d(compile, "compile(...)");
        if (compile.matcher(str).matches()) {
            return;
        }
        if (this.f174h < 3) {
            a("$ " + str + "   (continuing)\n");
            if (this.f182r.b(str)) {
                str = str.concat(" && npm rebuild");
            }
            p(str);
            return;
        }
        try {
            File o2 = o();
            if (o2 != null) {
                o2.delete();
            }
        } catch (Exception unused) {
        }
        try {
            File s2 = s();
            if (s2 != null) {
                s2.delete();
            }
        } catch (Exception unused2) {
        }
        a("\nAndroid stopped the app " + this.f174h + " times while running this (low memory?). Not restarting it again.\nClose other apps, then run it again. If it was an install, run: npm rebuild\n");
    }

    public final File o() {
        File file = this.f169c;
        if (file == null) {
            return null;
        }
        return new File(file.getPath() + ".run");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006c, code lost:
    
        if (r0 != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p(String str) {
        boolean z;
        try {
            File o2 = o();
            if (o2 != null) {
                File parentFile = o2.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                g.m.L(o2, str);
            }
        } catch (Exception unused) {
        }
        String e0 = m.e.e0(str, ' ');
        if (e0.equals("node") || e0.equals("npm") || e0.equals("npx")) {
            y2 y2Var = y2.f736a;
            try {
                if (y2.F()) {
                    if (new File(y2.B(), "bin/".concat(e0)).canExecute()) {
                        try {
                            z = i.b.a(m.e.h0(g.m.I(new File(y2.B(), "var/lib/nixpkg/tools"))).toString(), "5");
                        } catch (Exception unused2) {
                            z = false;
                        }
                    }
                }
            } catch (Exception unused3) {
            }
            y2 y2Var2 = y2.f736a;
            g(y2.x(), str);
            return;
        }
        this.f175i = true;
        this.f176j = this.f182r.b(str) ? "Installing packages..." : "";
        L2.f198a.c();
        new Thread(new RunnableC0056o((Object) this, (Object) str, (Object) this.f172f, 10, (byte) 0)).start();
    }

    public final void q(File file) {
        this.f172f = file;
        try {
            File d2 = d();
            if (d2 == null) {
                return;
            }
            File parentFile = d2.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            g.m.L(d2, l());
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x031b, code lost:
    
        if (r1.equals("full-upgrade") != false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0375, code lost:
    
        if (r1.equals("update") != false) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0378, code lost:
    
        r12.f175i = true;
        r12.f176j = "Updating package list...";
        a.L2.f198a.c();
        new java.lang.Thread(new a.G(r0, r12)).start();
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0392, code lost:
    
        a("pkg install <name> ...   (Termux packages, e.g. nodejs-lts)\npkg list   pkg update   pkg upgrade\n");
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x013a, code lost:
    
        if (r4.equals("apt") == false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0256, code lost:
    
        if (r4.equals("apt-get") == false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0130, code lost:
    
        if (r4.equals("pkg") == false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x025a, code lost:
    
        r13 = c.b.H(r1, 1);
        r1 = (java.lang.String) c.b.I(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0264, code lost:
    
        if (r1 == null) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0266, code lost:
    
        r4 = "No packages installed.\n";
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x026c, code lost:
    
        switch(r1.hashCode()) {
            case -838846263: goto L157;
            case -302669602: goto L144;
            case -231171556: goto L141;
            case -60744437: goto L132;
            case 105: goto L119;
            case 3463: goto L116;
            case 96417: goto L113;
            case 3322014: goto L110;
            case 1957569947: goto L107;
            default: goto L161;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0277, code lost:
    
        if (r1.equals("install") != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x02a1, code lost:
    
        r13 = c.b.H(r13, 1);
        r0 = new java.util.ArrayList();
        r13 = r13.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x02b2, code lost:
    
        if (r13.hasNext() == false) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x02b4, code lost:
    
        r1 = r13.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x02c0, code lost:
    
        if ((!m.m.K((java.lang.String) r1, "-")) == false) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x02c2, code lost:
    
        r0.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x02ca, code lost:
    
        if (r0.isEmpty() == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x02cc, code lost:
    
        a("Usage: pkg install <name> ...\n");
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x02d3, code lost:
    
        g(r0, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0281, code lost:
    
        if (r1.equals("list") != false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x02e2, code lost:
    
        r13 = a.y2.f736a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x02e4, code lost:
    
        r13 = m.e.h0(g.m.I(new java.io.File(a.y2.B(), "var/lib/nixpkg/installed"))).toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x02ff, code lost:
    
        if (r13.length() != 0) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0302, code lost:
    
        r4 = r13.concat("\n");
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x028b, code lost:
    
        if (r1.equals("add") != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0293, code lost:
    
        if (r1.equals("ls") != false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x029d, code lost:
    
        if (r1.equals("i") != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02de, code lost:
    
        if (r1.equals("list-installed") != false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0311, code lost:
    
        if (r1.equals("upgrade") != false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x031f, code lost:
    
        r13 = a.y2.f736a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0321, code lost:
    
        r6 = c.b.Q(a.y2.E(a.y2.B()).keySet());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r(String str) {
        List list;
        List<File> list2;
        String str2;
        String str3;
        String str4;
        int i2 = 10;
        if (this.f175i) {
            return;
        }
        a("$ " + str + "\n");
        String obj = m.e.h0(str).toString();
        if (obj.length() == 0) {
            return;
        }
        Pattern compile = Pattern.compile("\\s+");
        i.b.d(compile, "compile(...)");
        m.e.Z(0);
        Matcher matcher = compile.matcher(obj);
        if (matcher.find()) {
            ArrayList arrayList = new ArrayList(10);
            int i3 = 0;
            do {
                arrayList.add(obj.subSequence(i3, matcher.start()).toString());
                i3 = matcher.end();
            } while (matcher.find());
            arrayList.add(obj.subSequence(i3, obj.length()).toString());
            list = arrayList;
        } else {
            list = AbstractC0008c.p(obj.toString());
        }
        String str5 = (String) list.get(0);
        int hashCode = str5.hashCode();
        list2 = c.j.f773a;
        Object obj2 = null;
        switch (hashCode) {
            case -1251408554:
                if (str5.equals("gclone")) {
                    List H = c.b.H(list, 1);
                    if (H.isEmpty() || H.size() > 2) {
                        a("Usage: gclone <folder> <github-url>\n");
                        break;
                    } else {
                        String str6 = (String) H.get(0);
                        String str7 = (String) c.b.J(H, 1);
                        if (str7 == null) {
                            str2 = str6;
                            str3 = null;
                        } else if (m.e.L(str6)) {
                            str3 = str7;
                            str2 = str6;
                        } else {
                            str2 = str7;
                            str3 = str6;
                        }
                        File file = this.f172f;
                        this.f175i = true;
                        this.f176j = "Downloading...";
                        L2.f198a.c();
                        int i4 = this.f181o;
                        this.p = true;
                        new Thread(new RunnableC0037j0(str2, str3, file, i4, this)).start();
                        break;
                    }
                }
                p(obj);
                break;
            case -791419986:
                break;
            case 3169:
                if (str5.equals("cd")) {
                    List H2 = c.b.H(list, 1);
                    if (H2.isEmpty()) {
                        q(this.f167a);
                        break;
                    } else {
                        String L = c.b.L(H2, " ", null, null, null, 62);
                        File m2 = m(L);
                        if (m2 == null || !m2.isDirectory()) {
                            a("cd: " + L + ": No such folder\n");
                            break;
                        } else {
                            q(m2);
                            break;
                        }
                    }
                }
                p(obj);
                break;
            case 3463:
                if (str5.equals("ls")) {
                    Iterator it = c.b.H(list, 1).iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object next = it.next();
                            if (!m.m.K((String) next, "-")) {
                                obj2 = next;
                            }
                        }
                    }
                    String str8 = (String) obj2;
                    File m3 = str8 == null ? this.f172f : m(str8);
                    if (m3 == null || !m3.exists()) {
                        a("ls: " + (str8 != null ? str8 : "") + ": No such file or folder\n");
                        break;
                    } else if (m3.isFile()) {
                        a(m3.getName() + "\n");
                        break;
                    } else {
                        File[] listFiles = m3.listFiles();
                        if (listFiles != null) {
                            list2 = c.a.F(listFiles, new N0(4));
                        }
                        StringBuilder sb = new StringBuilder();
                        for (File file2 : list2) {
                            if (file2.isDirectory()) {
                                sb.append((char) 1);
                                sb.append(file2.getName());
                                sb.append("\u0002\n");
                            } else {
                                sb.append(file2.getName());
                                sb.append('\n');
                            }
                        }
                        a(sb.toString());
                        break;
                    }
                }
                p(obj);
                break;
            case 96805:
                break;
            case 111052:
                break;
            case 111421:
                if (str5.equals("pwd")) {
                    String l2 = l();
                    if (l2.length() == 0) {
                        l2 = "/";
                    }
                    a(((Object) l2) + "\n");
                    break;
                }
                p(obj);
                break;
            case 3083115:
                if (str5.equals("diag")) {
                    this.f175i = true;
                    this.f176j = "";
                    L2.f198a.c();
                    new Thread(new U(this, this.f172f, i2)).start();
                    break;
                }
                p(obj);
                break;
            case 3198785:
                if (str5.equals("help")) {
                    a("ls  cd <folder>  pwd  clear  kill\nnpm install  npm start  node index.js\ngclone <folder> <github-url>\npkg install <name>  pkg list  pkg update  pkg upgrade  (Termux packages)\nsetup  (install Node.js now)\n");
                    break;
                }
                p(obj);
                break;
            case 3291998:
                if (str5.equals("kill")) {
                    h();
                    break;
                }
                p(obj);
                break;
            case 94746189:
                if (str5.equals("clear")) {
                    a("\f");
                    break;
                }
                p(obj);
                break;
            case 109329021:
                if (str5.equals("setup")) {
                    y2 y2Var = y2.f736a;
                    g(y2.x(), null);
                    break;
                }
                p(obj);
                break;
            default:
                p(obj);
                break;
        }
        return;
        ArrayList arrayList2 = new ArrayList(c.d.E(list2));
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((String) it2.next()) + "?");
        }
        if (arrayList2.isEmpty()) {
            a("No packages installed.\n");
            return;
        } else {
            g(arrayList2, null);
            return;
        }
        a(str4);
    }

    public final File s() {
        File file = this.f169c;
        if (file == null) {
            return null;
        }
        return new File(file.getPath() + ".try");
    }

    public final void t() {
        File file = this.f169c;
        if (file != null) {
            try {
                file.delete();
            } catch (Exception unused) {
            }
        }
        try {
            File d2 = d();
            if (d2 != null) {
                d2.delete();
            }
        } catch (Exception unused2) {
        }
        try {
            File o2 = o();
            if (o2 != null) {
                o2.delete();
            }
        } catch (Exception unused3) {
        }
        try {
            File s2 = s();
            if (s2 != null) {
                s2.delete();
            }
        } catch (Exception unused4) {
        }
        if (file != null) {
            try {
                new File(file.getPath() + ".key").delete();
            } catch (Exception unused5) {
            }
        }
    }
}
