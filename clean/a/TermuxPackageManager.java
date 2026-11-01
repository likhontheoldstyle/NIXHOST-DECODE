package a;

import android.content.Context;
import android.os.Build;
import android.system.Os;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

public final class TermuxPackageManager {

    public static final TermuxPackageManager INSTANCE = new TermuxPackageManager();

    public static final List MIRRORS = c.c.C("https://packages.termux.dev/apt/termux-main", "https://packages-cf.termux.dev/apt/termux-main");

    public static final Set preinstalledPackages = AppState.y("termux-exec", "termux-tools", "termux-keyring", "termux-licenses", "apt", "dpkg", "game-repo", "science-repo", "root-repo");

    public static final i.g binNamePattern = new i.g("[A-Za-z0-9._-]+");

    public static final HashSet rewrittenScriptKeys = new HashSet();

    public static final HashMap binEntriesCache = new HashMap();

    public static final HashMap shimContentsCache = new HashMap();

    public static HashMap parsePackageIndex(InputStream inputStream) {
        long j2;
        String readLine;
        HashMap hashMap = new HashMap();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, m.a.f864a), 65536);
        do {
            String str = "";
            String str2 = str;
            String str3 = str2;
            String str4 = str3;
            String str5 = str4;
            while (true) {
                j2 = 0;
                while (true) {
                    readLine = bufferedReader.readLine();
                    if (readLine == null || readLine.length() == 0) {
                        break;
                    }
                    if (m.m.K(readLine, "Package: ")) {
                        String substring = readLine.substring(9);
                        i.b.d(substring, "substring(...)");
                        str5 = m.e.h0(substring).toString();
                    } else if (m.m.K(readLine, "Version: ")) {
                        String substring2 = readLine.substring(9);
                        i.b.d(substring2, "substring(...)");
                        str2 = m.e.h0(substring2).toString();
                    } else if (m.m.K(readLine, "Depends: ")) {
                        str = readLine.substring(9);
                        i.b.d(str, "substring(...)");
                    } else if (m.m.K(readLine, "Filename: ")) {
                        String substring3 = readLine.substring(10);
                        i.b.d(substring3, "substring(...)");
                        str3 = m.e.h0(substring3).toString();
                    } else if (m.m.K(readLine, "SHA256: ")) {
                        String substring4 = readLine.substring(8);
                        i.b.d(substring4, "substring(...)");
                        str4 = m.e.h0(substring4).toString();
                    } else if (m.m.K(readLine, "Size: ")) {
                        String substring5 = readLine.substring(6);
                        i.b.d(substring5, "substring(...)");
                        Long D = m.l.D(m.e.h0(substring5).toString());
                        if (D != null) {
                            j2 = D.longValue();
                        }
                    } else {
                        continue;
                    }
                }
            }
            if (str5.length() > 0 && str3.length() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it = m.e.b0(str, new String[]{","}).iterator();
                while (it.hasNext()) {
                    String obj = m.e.h0(m.e.f0(m.e.f0(m.e.f0(m.e.h0((String) m.e.b0((String) it.next(), new String[]{"|"}).get(0)).toString(), " "), "("), ":")).toString();
                    if (obj.length() > 0) {
                        arrayList.add(obj);
                    }
                }
                hashMap.put(str5, new PackageEntry(str5, str2, arrayList, str3, str4, j2));
            }
        } while (readLine != null);
        return hashMap;
    }

    public static File prefixDir() {
        return new File(appContext().getApplicationInfo().dataDir, "usr");
    }

    public static String prefixPath() {
        return appContext().getApplicationInfo().dataDir + "/usr";
    }

    public static boolean readFully(TermuxPackageManager termuxPackageManager, BufferedInputStream bufferedInputStream, byte[] bArr) {
        int length = bArr.length;
        termuxPackageManager.getClass();
        int i2 = 0;
        while (i2 < length) {
            int read = bufferedInputStream.read(bArr, i2, length - i2);
            if (read < 0) {
                if (i2 == 0) {
                    return false;
                }
                throw new EOFException();
            }
            i2 += read;
        }
        return true;
    }

    public static HashMap readInstalled(File file) {
        HashMap hashMap = new HashMap();
        try {
            Iterator it = g.m.H(new File(file, "var/lib/nixpkg/installed")).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                int P = m.e.P(str, ' ', 0, false, 6);
                if (P > 0) {
                    String substring = str.substring(0, P);
                    i.b.d(substring, "substring(...)");
                    String substring2 = str.substring(P + 1);
                    i.b.d(substring2, "substring(...)");
                    hashMap.put(substring, substring2);
                }
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    public static boolean isPrefixRecorded() {
        try {
            return i.b.a(m.e.h0(g.m.I(new File(prefixDir(), "var/lib/nixpkg/prefix"))).toString(), prefixPath());
        } catch (Exception unused) {
            return false;
        }
    }

    public static String stripTermuxPrefix(String str) {
        while (m.m.K(str, "./")) {
            str = str.substring(2);
            i.b.d(str, "substring(...)");
        }
        String k0 = m.e.k0(str, '/');
        String k02 = m.e.k0("/data/data/com.termux/files/usr", '/');
        if (!i.b.a(k0, k02)) {
            if (!m.m.K(k0, k02 + "/")) {
                return null;
            }
        }
        String substring = k0.substring(k02.length());
        i.b.d(substring, "substring(...)");
        String j0 = m.e.j0(m.e.k0(substring, '/'), '/');
        List b0 = m.e.b0(j0, new String[]{"/"});
        if (!b0.isEmpty()) {
            Iterator it = b0.iterator();
            while (it.hasNext()) {
                if (i.b.a((String) it.next(), "..")) {
                    return null;
                }
            }
        }
        return j0;
    }

    public static ArrayList resolveDependencies(Map map, ArrayList arrayList, HashMap hashMap) {
        ArrayList arrayList2 = new ArrayList();
        HashSet hashSet = new HashSet();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            boolean E = m.m.E(str, "?");
            String Y = m.e.Y(str, "?");
            if (!map.containsKey(Y) && Y.equals("nodejs-lts")) {
                Y = "nodejs";
            }
            if (map.containsKey(Y)) {
                collectPackage(hashSet, hashMap, map, arrayList2, Y);
            } else if (!E) {
                throw new IOException("Package not found: ".concat(Y));
            }
        }
        return arrayList2;
    }

    public static final void collectPackage(HashSet hashSet, HashMap hashMap, Map map, ArrayList arrayList, String str) {
        if (hashSet.contains(str) || preinstalledPackages.contains(str)) {
            return;
        }
        if (i.b.a(str, "nodejs") && (hashSet.contains("nodejs-lts") || hashMap.containsKey("nodejs-lts"))) {
            return;
        }
        hashSet.add(str);
        PackageEntry entry = (PackageEntry) map.get(str);
        if (entry == null || i.b.a(hashMap.get(str), entry.version)) {
            return;
        }
        Iterator it = entry.depends.iterator();
        while (it.hasNext()) {
            collectPackage(hashSet, hashMap, map, arrayList, (String) it.next());
        }
        arrayList.add(entry);
    }

    public static String sha256Hex(File file) {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[65536];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read < 0) {
                    AppState.a(fileInputStream, null);
                    return c.a.D(messageDigest.digest(), new ValueFunction(4));
                }
                messageDigest.update(bArr, 0, read);
            }
        } finally {
        }
    }

    public static String rewriteShebangLine(String str) {
        List list;
        String d0;
        List H;
        String a2;
        String substring = str.substring(2);
        i.b.d(substring, "substring(...)");
        String obj = m.e.h0(substring).toString();
        if (obj.length() == 0) {
            return null;
        }
        Pattern compile = Pattern.compile("\\s+");
        i.b.d(compile, "compile(...)");
        m.e.Z(0);
        Matcher matcher = compile.matcher(obj);
        if (matcher.find()) {
            ArrayList arrayList = new ArrayList(10);
            int i2 = 0;
            do {
                arrayList.add(obj.subSequence(i2, matcher.start()).toString());
                i2 = matcher.end();
            } while (matcher.find());
            arrayList.add(obj.subSequence(i2, obj.length()).toString());
            list = arrayList;
        } else {
            list = AppState.p(obj.toString());
        }
        if (m.m.E((String) list.get(0), "/env")) {
            int i3 = 1;
            while (i3 < list.size() && m.m.K((String) list.get(i3), "-")) {
                i3++;
            }
            if (i3 >= list.size()) {
                return null;
            }
            d0 = (String) list.get(i3);
            H = c.b.H(list, i3 + 1);
        } else {
            String str2 = (String) list.get(0);
            d0 = m.e.d0(str2, '/', str2);
            H = c.b.H(list, 1);
        }
        List list2 = H;
        if (new File(prefixDir(), StringPlus.stringPlus("bin/", d0)).exists()) {
            a2 = prefixPath() + "/bin/" + d0;
        } else {
            if (!new File(StringPlus.stringPlus("/system/bin/", d0)).exists()) {
                return null;
            }
            a2 = StringPlus.stringPlus("/system/bin/", d0);
        }
        return "#!" + a2 + (list2.isEmpty() ? "" : " ".concat(c.b.L(list2, " ", null, null, null, 62)));
    }

    public static File shimDirFor(File file, File file2) {
        String path;
        try {
            path = file2.getCanonicalPath();
        } catch (Exception unused) {
            path = file2.getPath();
        }
        return new File(file, StringPlus.stringPlus(".nixshim/", Integer.toHexString(path.hashCode())));
    }

    public static String shimScriptFor(File file) {
        String str;
        str = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[160];
                int read = fileInputStream.read(bArr);
                str = read > 0 ? new String(bArr, 0, read, m.a.f865b) : "";
                AppState.a(fileInputStream, null);
            } finally {
            }
        } catch (Exception unused) {
        }
        String str2 = "'" + m.m.J(file.getPath(), "'", "'\\''") + "'";
        String e0 = m.e.e0(str, '\n');
        if (!m.m.K(str, "\u007fELF")) {
            if (m.m.K(e0, "#!") && !m.e.M(e0, "node") && m.e.M(e0, "sh")) {
                str2 = StringPlus.stringPlus("/system/bin/sh ", str2);
            } else {
                str2 = "'" + prefixPath() + "/bin/node' " + str2;
            }
        }
        return "#!/system/bin/sh\nexec " + str2 + " \"$@\"\n";
    }

    public static void skipBytes(BufferedInputStream bufferedInputStream, long j2) {
        byte[] bArr = new byte[8192];
        while (j2 > 0) {
            int read = bufferedInputStream.read(bArr, 0, (int) Math.min(j2, 8192));
            if (read < 0) {
                throw new EOFException();
            }
            j2 -= read;
        }
    }

    public static void deleteRecursively(File file) {
        File[] listFiles;
        try {
            if (!Files.isSymbolicLink(file.toPath()) && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    deleteRecursively(file2);
                }
            }
            file.delete();
        } catch (Exception unused) {
        }
    }

    public static void buildEnvironment(Map map, File file, File file2) {
        File file3;
        String str;
        String path;
        String str2;
        String C = prefixPath();
        String str3 = System.getenv("PATH");
        if (str3 == null) {
            str3 = "/system/bin:/system/xbin";
        }
        map.put("PREFIX", C);
        map.put("PATH", C + "/bin:" + shimDirFor(file, file2).getPath() + ":" + str3);
        map.put("LANG", "en_US.UTF-8");
        map.put("npm_config_prefix", C);
        File file4 = null;
        try {
            file3 = new File(appContext().getFilesDir(), "nix/scriptsh");
            String J = m.m.J(m.m.J("#!/system/bin/sh\nP='@PS@'\nOLD=§IFS\nIFS=:\nfor d in §PATH; do\n  case \"§d\" in\n    */node_modules/.bin) ;;\n    *) continue ;;\n  esac\n  [ -d \"§d\" ] || continue\n  for f in \"§d\"/*; do\n    [ -f \"§f\" ] || continue\n    IFS= read -r l < \"§f\" 2>/dev/null || continue\n    case \"§l\" in\n      \"#!/usr/bin/env \"*|\"#!/bin/env \"*) ;;\n      *) continue ;;\n    esac\n    rest=§{l#*env }\n    i=§{rest%% *}\n    case \"§i\" in\n      -*) rest=§{rest#* }; i=§{rest%% *} ;;\n    esac\n    if [ -x \"§P/bin/§i\" ]; then t=\"§P/bin/§i\"\n    elif [ -x \"/system/bin/§i\" ]; then t=\"/system/bin/§i\"\n    else continue; fi\n    r=§{rest#\"§i\"}\n    T=\"§f.nixtmp§§\"\n    { printf '%s\\n' \"#!§t§r\"; tail -n +2 \"§f\"; } > \"§T\" 2>/dev/null && cat \"§T\" > \"§f\" 2>/dev/null\n    rm -f \"§T\"\n  done\ndone\nIFS=§OLD\nexec /system/bin/sh \"§@\"\n", "§", "$"), "@PS@", prefixPath());
            if (!file3.isFile() || !g.m.I(file3).equals(J)) {
                File parentFile = file3.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                g.m.L(file3, J);
            }
            chmod(file3, 493);
        } catch (Exception unused) {
            file3 = null;
        }
        if (file3 == null || (str = file3.getPath()) == null) {
            str = "/system/bin/sh";
        }
        map.put("npm_config_script_shell", str);
        map.put("npm_config_update_notifier", "false");
        map.put("npm_config_fund", "false");
        map.put("UV_USE_IO_URING", "0");
        map.put("NODE_NO_WARNINGS", "1");
        map.put("GYP_DEFINES", "android_ndk_path=''");
        map.put("JOBS", "1");
        map.put("npm_config_jobs", "1");
        map.put("MAKEFLAGS", "-j1");
        map.put("CMAKE_BUILD_PARALLEL_LEVEL", "1");
        if (new File(prefixDir(), "include/node/node.h").isFile()) {
            map.put("npm_config_nodedir", C);
        }
        if (new File(prefixDir(), "bin/clang").exists()) {
            map.put("CC", C + "/bin/clang");
            map.put("CXX", C + "/bin/clang++");
        }
        if (new File(prefixDir(), "bin/python3").exists()) {
            map.put("npm_config_python", C + "/bin/python3");
        }
        if (new File(prefixDir(), "bin/clang").exists()) {
            map.put("LDFLAGS", "-L" + C + "/lib -Wl,-rpath=" + C + "/lib");
        }
        map.put("CPATH", C + "/include");
        map.put("LIBRARY_PATH", C + "/lib");
        map.put("PKG_CONFIG_PATH", C + "/lib/pkgconfig:" + C + "/share/pkgconfig");
        StringBuilder sb = new StringBuilder();
        sb.append(C);
        sb.append("/libexec/git-core");
        map.put("GIT_EXEC_PATH", sb.toString());
        if (new File(prefixDir(), "etc/tls/cert.pem").isFile()) {
            map.put("SSL_CERT_FILE", C + "/etc/tls/cert.pem");
            map.put("NODE_EXTRA_CA_CERTS", C + "/etc/tls/cert.pem");
        }
        if (isExternalStorage(file2)) {
            map.put("npm_config_bin_links", "false");
            File w = nodeModulesDirFor(file2);
            File file5 = new File(w, "node_modules");
            file5.mkdirs();
            map.put("NIX_NM", w.getPath());
            try {
                path = file2.getCanonicalPath();
            } catch (Exception unused2) {
                path = file2.getPath();
            }
            map.put("NIX_CWD", path);
            map.put("NODE_PATH", file5.getPath());
            map.put("PATH", new File(file5, ".bin").getPath() + ":" + map.get("PATH"));
            try {
                File file6 = new File(appContext().getFilesDir(), "nix/esm-hook.mjs");
                if (!file6.isFile() || !g.m.I(file6).equals("import { register } from 'node:module';\nif (process.env.NIX_NM) {\n  register('data:text/javascript,' + encodeURIComponent('import { pathToFileURL } from \"node:url\"; let base = \"\"; export function initialize(d) { base = d.base; } export async function resolve(s, c, n) { try { return await n(s, c); } catch (e) { if (base && s[0] !== \".\" && s[0] !== \"/\" && !s.startsWith(\"file:\") && !s.startsWith(\"node:\") && !s.startsWith(\"data:\")) { try { return await n(s, Object.assign({}, c, { parentURL: pathToFileURL(base + \"/index.js\").href })); } catch (e2) {} } throw e; } }'), { parentURL: import.meta.url, data: { base: process.env.NIX_NM } });\n}\n")) {
                    File parentFile2 = file6.getParentFile();
                    if (parentFile2 != null) {
                        parentFile2.mkdirs();
                    }
                    g.m.L(file6, "import { register } from 'node:module';\nif (process.env.NIX_NM) {\n  register('data:text/javascript,' + encodeURIComponent('import { pathToFileURL } from \"node:url\"; let base = \"\"; export function initialize(d) { base = d.base; } export async function resolve(s, c, n) { try { return await n(s, c); } catch (e) { if (base && s[0] !== \".\" && s[0] !== \"/\" && !s.startsWith(\"file:\") && !s.startsWith(\"node:\") && !s.startsWith(\"data:\")) { try { return await n(s, Object.assign({}, c, { parentURL: pathToFileURL(base + \"/index.js\").href })); } catch (e2) {} } throw e; } }'), { parentURL: import.meta.url, data: { base: process.env.NIX_NM } });\n}\n");
                }
                file4 = file6;
            } catch (Exception unused3) {
            }
            if (file4 != null) {
                String path2 = file4.getPath();
                String str4 = (String) map.get("NODE_OPTIONS");
                if (str4 == null || (str2 = " ".concat(str4)) == null) {
                    str2 = "";
                }
                map.put("NODE_OPTIONS", "--import=file://" + path2 + str2);
            }
        }
    }

    public static String termuxArch() {
        i.a a2 = i.j.a(Build.SUPPORTED_ABIS);
        while (a2.hasNext()) {
            String str = (String) a2.next();
            if (i.b.a(str, "arm64-v8a")) {
                return "aarch64";
            }
            if (i.b.a(str, "armeabi-v7a") || i.b.a(str, "armeabi")) {
                return "arm";
            }
            if (i.b.a(str, "x86_64")) {
                return "x86_64";
            }
            if (i.b.a(str, "x86")) {
                return "i686";
            }
        }
        throw new IOException("This CPU is not supported");
    }

    public static void chmod(File file, int i2) {
        try {
            Os.chmod(file.getPath(), i2 & 4095);
        } catch (Exception unused) {
        }
    }

    public static void replaceTermuxPrefix(BufferedInputStream bufferedInputStream, long j2, FileOutputStream fileOutputStream, byte[] bArr, byte[] bArr2) {
        int i2;
        int i3;
        int length = bArr.length;
        byte[] bArr3 = new byte[65536 + length];
        while (true) {
            int i4 = 0;
            while (true) {
                if (j2 <= 0 && i4 <= 0) {
                    return;
                }
                if (j2 > 0) {
                    i2 = bufferedInputStream.read(bArr3, i4, (int) Math.min(65536L, j2));
                    if (i2 < 0) {
                        throw new EOFException();
                    }
                    j2 -= i2;
                } else {
                    i2 = 0;
                }
                i3 = i4 + i2;
                int i5 = 0;
                while (i5 <= i3 - length) {
                    if (bArr3[i5] == bArr[0]) {
                        for (int i6 = 1; i6 < length; i6++) {
                            if (bArr3[i5 + i6] == bArr[i6]) {
                            }
                        }
                        System.arraycopy(bArr2, 0, bArr3, i5, length);
                        i5 += length;
                    }
                    i5++;
                }
                if (j2 > 0) {
                    int min = Math.min(length - 1, i3);
                    int i7 = i3 - min;
                    fileOutputStream.write(bArr3, 0, i7);
                    System.arraycopy(bArr3, i7, bArr3, 0, min);
                    i4 = min;
                }
            }
            fileOutputStream.write(bArr3, 0, i3);
        }
    }

    public static String tarHeaderString(byte[] bArr, int i2, int i3) {
        int i4 = i2;
        while (i4 < i2 + i3 && bArr[i4] != 0) {
            i4++;
        }
        return new String(bArr, i2, i4 - i2, m.a.f864a);
    }

    public static Context appContext() {
        TerminalManager terminalManager = TerminalManager.INSTANCE;
        Context context = TerminalManager.appContext;
        if (context != null) {
            return context;
        }
        throw new IOException("App is not ready");
    }

    public static void downloadWithRetries(String str, PackageEntry entry, File file, RefAction refAction, DownloadProgressCallback progressCallback) {
        String str2;
        List p = AppState.p(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : MIRRORS) {
            if (!i.b.a((String) obj, str)) {
                arrayList.add(obj);
            }
        }
        ArrayList N = c.b.N(p, arrayList);
        int i2 = 0;
        Exception e2 = null;
        while (i2 < 10) {
            if (((Boolean) refAction.a()).booleanValue()) {
                throw new StoppedException();
            }
            try {
                downloadPackage((String) N.get(i2 % N.size()), entry, file, refAction, progressCallback);
                return;
            } catch (StoppedException e3) {
                throw e3;
            } catch (Exception e4) {
                e2 = e4;
                String message = e2.getMessage();
                if (message == null) {
                    message = "";
                }
                if (m.m.K(message, "Checksum")) {
                    file.delete();
                }
                i2++;
                try {
                    Thread.sleep(Math.min(i2 * 1000, 5000L));
                } catch (InterruptedException unused) {
                }
            }
        }
        if (e2 == null || (str2 = e2.getMessage()) == null) {
            str2 = "error";
        }
        throw new IOException("Network problem while downloading " + entry.name + " (" + str2 + "). Run the command again, it continues from here.");
    }

    public static void downloadPackage(String str, PackageEntry entry, File file, RefAction refAction, DownloadProgressCallback progressCallback) {
        boolean z;
        long length = file.isFile() ? file.length() : 0L;
        long j2 = entry.size;
        if (j2 > 0 && length > j2) {
            file.delete();
            length = 0;
        }
        String str2 = entry.sha256;
        if (j2 > 0 && length == j2) {
            if (sha256Hex(file).equalsIgnoreCase(str2) || str2.length() == 0) {
                return;
            }
            file.delete();
            length = 0;
        }
        HttpURLConnection z2 = openConnection(str + "/" + entry.filename);
        z2.setRequestProperty("Accept-Encoding", "identity");
        if (length > 0) {
            z2.setRequestProperty("Range", "bytes=" + length + "-");
        }
        int responseCode = z2.getResponseCode();
        String str3 = entry.name;
        if (responseCode == 206 && length > 0) {
            z = true;
        } else {
            if (responseCode != 200) {
                throw new IOException("HTTP " + responseCode + " for " + str3);
            }
            z = false;
        }
        long j3 = z ? length : 0L;
        InputStream inputStream = z2.getInputStream();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, z);
            try {
                byte[] bArr = new byte[65536];
                while (!((Boolean) refAction.a()).booleanValue()) {
                    int read = inputStream.read(bArr);
                    if (read < 0) {
                        AppState.a(fileOutputStream, null);
                        AppState.a(inputStream, null);
                        if (j2 > 0 && j3 < j2) {
                            throw new IOException("unexpected end of stream");
                        }
                        if (str2.length() > 0 && !sha256Hex(file).equalsIgnoreCase(str2)) {
                            throw new IOException(StringPlus.stringPlus("Checksum mismatch: ", str3));
                        }
                        return;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    j3 += read;
                    progressCallback.a(Long.valueOf(j3));
                }
                throw new StoppedException();
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AppState.a(inputStream, th);
                throw th2;
            }
        }
    }

    public static void installLdconfigShim() {
        try {
            File file = new File(prefixDir(), "bin/ldconfig");
            String J = m.m.J(m.m.J("#!/system/bin/sh\n# Nix Host: lists the libraries of the Termux prefix (used by node-canvas to find jpeg / gif)\ncase \"§1\" in\n  -p)\n    for f in '@PS@'/lib/*.so*; do\n      [ -e \"§f\" ] && printf '\\t%s (libc6,AArch64) => %s\\n' \"§{f##*/}\" \"§f\"\n    done ;;\nesac\nexit 0\n", "§", "$"), "@PS@", prefixPath());
            if (!file.exists() || m.e.M(g.m.I(file), "Nix Host")) {
                if (!file.isFile() || !g.m.I(file).equals(J)) {
                    file.delete();
                    g.m.L(file, J);
                }
                chmod(file, 493);
            }
        } catch (Exception unused) {
        }
    }

    public static void installNpmWrappers() {
        String str;
        try {
            File B = prefixDir();
            if (new File(B, "bin/node").exists()) {
                String C = prefixPath();
                for (b.b bVar : c.c.C(new b.b("npm", "npm-cli.js"), new b.b("npx", "npx-cli.js"))) {
                    String str2 = (String) bVar.f764a;
                    String str3 = (String) bVar.f765b;
                    if (new File(B, "lib/node_modules/npm/bin/" + str3).isFile()) {
                        String J = i.b.a(str2, "npm") ? m.m.J(m.m.J("NODE='@PS@/bin/node'\nCLI='@PS@/lib/node_modules/npm/bin/npm-cli.js'\nsub=\nskip=\nfor a in \"§@\"; do\n  case \"§a\" in\n    -g|--global|--global=*|--location=global|--prefix|--prefix=*|-w|--workspace|--workspace=*|--workspaces) skip=1 ;;\n  esac\ndone\nif [ -z \"§skip\" ]; then\n  for a in \"§@\"; do\n    case \"§a\" in\n      -*) ;;\n      *) sub=\"§a\"; break ;;\n    esac\n  done\nfi\ncase \"§sub\" in\n  install|i|in|ins|inst|insta|instal|isnt|add|ci|clean-install|ic|uninstall|un|unlink|remove|rm|r|update|up|upgrade|prune|dedupe|ddp|rebuild|rb|ls|list|ll|la|outdated) ;;\n  *) sub= ;;\nesac\n# npm 12 does not run install scripts (sqlite3 build ...) until they are approved: approve and run them\napprove() {\n  case \"§sub\" in install|i|in|ins|inst|insta|instal|isnt|add|ci|clean-install|ic|update|up|upgrade) ;; *) return 0 ;; esac\n  before=§(\"§NODE\" -e 'try{console.log(Object.keys(JSON.parse(require(\"fs\").readFileSync(process.argv[1],\"utf8\")).allowScripts||{}).join(\"\\n\"))}catch(e){}' \"§NIX_NM/package.json\")\n  \"§NODE\" \"§CLI\" --prefix \"§NIX_NM\" install-scripts approve --all >/dev/null 2>&1 || return 0\n  names=§(NIX_BEFORE=\"§before\" \"§NODE\" -e 'try{var o=JSON.parse(require(\"fs\").readFileSync(process.argv[1],\"utf8\")).allowScripts||{};var b=(process.env.NIX_BEFORE||\"\").split(\"\\n\");console.log(Object.keys(o).filter(function(k){return o[k]===true&&b.indexOf(k)<0}).map(function(k){return k.replace(/(?!^)@[^@]*§/,\"\")}).join(\" \"))}catch(e){}' \"§NIX_NM/package.json\")\n  if [ -n \"§names\" ]; then\n    echo \"Running install scripts for: §names\"\n    \"§NODE\" \"§CLI\" --prefix \"§NIX_NM\" --bin-links=true rebuild §names\n  fi\n}\nnamed=\ncase \"§sub\" in\n  install|i|in|ins|inst|insta|instal|isnt|add)\n    first=1\n    for a in \"§@\"; do\n      case \"§a\" in -*) continue ;; esac\n      if [ -n \"§first\" ]; then first=; continue; fi\n      named=1\n      break\n    done ;;\nesac\nif [ -n \"§sub\" ] && [ -n \"§NIX_NM\" ] && [ . -ef \"§NIX_CWD\" ]; then\n  mkdir -p \"§NIX_NM/node_modules\"\n  if [ -n \"§named\" ]; then\n    # npm install <package> ...: install ONLY the named packages (and what they need).\n    # Dependencies listed in package.json but not installed yet are left out of this run.\n    rm -f \"§NIX_NM/package-lock.json\" \"§NIX_NM/npm-shrinkwrap.json\"\n    if [ -f ./.npmrc ]; then cp -f ./.npmrc \"§NIX_NM/.npmrc\"; else rm -f \"§NIX_NM/.npmrc\"; fi\n    NIX_SRC=./package.json \"§NODE\" -e 'var fs=require(\"fs\"),path=require(\"path\");var o={};try{o=JSON.parse(fs.readFileSync(process.env.NIX_SRC,\"utf8\"))}catch(e){}var nm=path.join(process.env.NIX_NM,\"node_modules\");[\"dependencies\",\"devDependencies\",\"optionalDependencies\"].forEach(function(s){if(!o[s])return;var t={};Object.keys(o[s]).forEach(function(k){if(fs.existsSync(path.join(nm,k)))t[k]=o[s][k]});o[s]=t});fs.writeFileSync(path.join(process.env.NIX_NM,\"package.json\"),JSON.stringify(o,null,2))'\n    \"§NODE\" \"§CLI\" --prefix \"§NIX_NM\" --bin-links=true \"§@\"\n    rc=§?\n    if [ §rc -eq 0 ]; then\n      approve\n      NIX_SRC=./package.json NIX_NEW=\"§NIX_NM/package.json\" \"§NODE\" -e 'var fs=require(\"fs\");var o={};try{o=JSON.parse(fs.readFileSync(process.env.NIX_SRC,\"utf8\"))}catch(e){}var n;try{n=JSON.parse(fs.readFileSync(process.env.NIX_NEW,\"utf8\"))}catch(e){process.exit(0)}[\"dependencies\",\"devDependencies\",\"optionalDependencies\",\"peerDependencies\",\"allowScripts\"].forEach(function(s){if(!n[s])return;o[s]=o[s]||{};Object.keys(n[s]).forEach(function(k){o[s][k]=n[s][k]});var t={};Object.keys(o[s]).sort().forEach(function(k){t[k]=o[s][k]});o[s]=t});fs.writeFileSync(process.env.NIX_SRC,JSON.stringify(o,null,2)+\"\\n\")'\n    fi\n    exit §rc\n  fi\n  for f in package.json package-lock.json npm-shrinkwrap.json .npmrc; do\n    if [ -f \"./§f\" ]; then cp -f \"./§f\" \"§NIX_NM/§f\"; else rm -f \"§NIX_NM/§f\"; fi\n  done\n  \"§NODE\" \"§CLI\" --prefix \"§NIX_NM\" --bin-links=true \"§@\"\n  rc=§?\n  if [ §rc -eq 0 ]; then approve; fi\n  for f in package.json package-lock.json npm-shrinkwrap.json; do\n    if [ -f \"§NIX_NM/§f\" ]; then\n      if [ ! -f \"./§f\" ] || ! cmp -s \"§NIX_NM/§f\" \"./§f\"; then cp -f \"§NIX_NM/§f\" \"./§f\"; fi\n    fi\n  done\n  exit §rc\nfi\nexec \"§NODE\" \"§CLI\" \"§@\"\n", "§", "$"), "@PS@", C) : m.m.J(m.m.J(m.m.J("if [ -n \"§NIX_NM\" ] && [ . -ef \"§NIX_CWD\" ]; then\n  case \"§1\" in\n    -*|\"\") ;;\n    *)\n      if [ -e \"§NIX_NM/node_modules/.bin/§1\" ]; then\n        b=\"§NIX_NM/node_modules/.bin/§1\"\n        shift\n        exec \"§b\" \"§@\"\n      fi ;;\n  esac\nfi\nexec '@PS@/bin/node' '@PS@/lib/node_modules/npm/bin/@JS@' \"§@\"\n", "§", "$"), "@PS@", C), "@JS@", str3);
                        File file = new File(B, "bin/" + str2);
                        if (!Files.isSymbolicLink(file.toPath()) && file.isFile()) {
                            String I = g.m.I(file);
                            str = m.e.c0(I, '\n', I);
                            if (i.b.a(str, J)) {
                                file.delete();
                                g.m.L(file, "#!/system/bin/sh\n" + J);
                                chmod(file, 493);
                            }
                        }
                        str = null;
                        if (i.b.a(str, J)) {
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void installDistutilsShim() {
        try {
            File[] listFiles = new File(prefixDir(), "lib").listFiles(new FileFilters(0));
            if (listFiles == null) {
                return;
            }
            for (File file : listFiles) {
                File file2 = new File(file, "site-packages");
                if (file2.isDirectory()) {
                    if (new File(file2, "setuptools").isDirectory()) {
                        File file3 = new File(file2, "distutils");
                        try {
                            if (m.e.M(g.m.I(new File(file3, "__init__.py")), "Nix Host")) {
                                deleteRecursively(file3);
                            }
                        } catch (Exception unused) {
                        }
                    } else {
                        File file4 = new File(file2, "distutils");
                        File file5 = new File(file4, "version.py");
                        if ((!file5.isFile() || !new File(file4, "__init__.py").isFile()) && !new File(file, "distutils").isDirectory()) {
                            file4.mkdirs();
                            g.m.L(new File(file4, "__init__.py"), "# minimal distutils replacement written by Nix Host\n");
                            g.m.L(file5, "import re\nfrom functools import total_ordering\n\n\ndef _parse(v):\n    out = []\n    for p in re.split(r\"[.\\-+_]\", str(v)):\n        m = re.match(r\"\\d+\", p)\n        out.append(int(m.group(0)) if m else 0)\n    return tuple(out) or (0,)\n\n\n@total_ordering\nclass Version(object):\n    def __init__(self, vstring=None):\n        self.vstring = vstring\n        self.version = _parse(vstring) if vstring is not None else ()\n\n    def parse(self, vstring):\n        self.vstring = vstring\n        self.version = _parse(vstring)\n        return self\n\n    def _key(self, other):\n        return other.version if isinstance(other, Version) else _parse(other)\n\n    def __eq__(self, other):\n        return self.version == self._key(other)\n\n    def __lt__(self, other):\n        return self.version < self._key(other)\n\n    def __hash__(self):\n        return hash(self.version)\n\n    def __str__(self):\n        return str(self.vstring)\n\n    def __repr__(self):\n        return \"%s('%s')\" % (self.__class__.__name__, self.vstring)\n\n\nclass StrictVersion(Version):\n    pass\n\n\nclass LooseVersion(Version):\n    pass\n");
                        }
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    public static void rewriteScriptShebang(File file) {
        try {
            if (file.isFile() && file.length() >= 4 && file.length() <= 8388608) {
                byte[] bArr = new byte[2];
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    AppState.a(fileInputStream, null);
                    if (bArr[0] == 35 && bArr[1] == 33) {
                        byte[] G = g.m.G(file);
                        int i2 = 0;
                        while (i2 < G.length && G[i2] != 10) {
                            i2++;
                        }
                        Charset charset = m.a.f864a;
                        String str = new String(G, 0, i2, charset);
                        String K = rewriteShebangLine(str);
                        if (K == null || K.equals(str)) {
                            return;
                        }
                        File file2 = new File(file.getPath() + ".nixtmp" + System.nanoTime());
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        try {
                            byte[] bytes = K.getBytes(charset);
                            i.b.d(bytes, "getBytes(...)");
                            fileOutputStream.write(bytes);
                            fileOutputStream.write(G, i2, G.length - i2);
                            AppState.a(fileOutputStream, null);
                            if (file2.renameTo(file)) {
                                chmod(file, 493);
                            } else {
                                file2.delete();
                            }
                        } finally {
                        }
                    }
                } finally {
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void createPrefixSkeleton(File file, ArrayList arrayList) {
        new File(file, "bin").mkdirs();
        new File(file, "tmp").mkdirs();
        new File(file, "etc").mkdirs();
        symlinkIfMissing(new File(file, "bin/sh"), "/system/bin/sh");
        symlinkIfMissing(new File(file, "bin/env"), "/system/bin/env");
        File file2 = new File(file, "etc/resolv.conf");
        if (!file2.exists()) {
            try {
                g.m.L(file2, "nameserver 8.8.8.8\nnameserver 1.1.1.1\n");
            } catch (Exception unused) {
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            rewriteScriptShebang((File) it.next());
        }
    }

    public static final void reportProgress(i.f fVar, i.f fVar2, i.e eVar, h.b bVar, double d2) {
        int c2 = AppState.c((int) (((fVar.f848a + d2) * 99.0d) / fVar2.f848a), 99);
        if (c2 != eVar.f847a) {
            eVar.f847a = c2;
            bVar.a(Integer.valueOf(c2));
        }
    }

    public static void extractDeb(File file, File file2, ArrayList arrayList, RefAction refAction) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 65536);
        try {
            byte[] bArr = new byte[8];
            TermuxPackageManager termuxPackageManager = INSTANCE;
            readFully(termuxPackageManager, bufferedInputStream, bArr);
            if (!new String(bArr, m.a.f865b).equals("!<arch>\n")) {
                throw new IOException("Bad package file");
            }
            while (true) {
                byte[] bArr2 = new byte[60];
                if (!readFully(termuxPackageManager, bufferedInputStream, bArr2)) {
                    throw new IOException("Package has no data");
                }
                Charset charset = m.a.f865b;
                String obj = m.e.h0(new String(bArr2, 0, 16, charset)).toString();
                long parseLong = Long.parseLong(m.e.h0(new String(bArr2, 48, 10, charset)).toString());
                long j2 = (1 & parseLong) + parseLong;
                if (m.m.K(obj, "data.tar")) {
                    InputStream dataStream = new LimitedInputStream(bufferedInputStream, parseLong);
                    if (m.m.K(obj, "data.tar.xz")) {
                        dataStream = new n.v(dataStream);
                    } else if (m.m.K(obj, "data.tar.gz")) {
                        dataStream = new GZIPInputStream(dataStream);
                    } else if (!obj.equals("data.tar") && !obj.equals("data.tar/")) {
                        throw new IOException("Unsupported package format: " + obj);
                    }
                    termuxPackageManager.extractTar(new BufferedInputStream(dataStream, 65536), file2, arrayList, refAction);
                    AppState.a(bufferedInputStream, null);
                    return;
                }
                skipBytes(bufferedInputStream, j2);
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AppState.a(bufferedInputStream, th);
                throw th2;
            }
        }
    }

    public static boolean isExternalStorage(File file) {
        try {
            String canonicalPath = file.getCanonicalPath();
            if (!m.m.K(canonicalPath, "/storage/") && !m.m.K(canonicalPath, "/sdcard")) {
                if (!m.m.K(canonicalPath, "/mnt/")) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void symlinkIfMissing(File file, String str) {
        try {
            if (new File(str).exists() && !Files.exists(file.toPath(), LinkOption.NOFOLLOW_LINKS)) {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                Os.symlink(str, file.getPath());
            }
        } catch (Exception unused) {
        }
    }

    public static b.b fetchPackageIndex() {
        String str;
        Exception e2 = null;
        for (int i2 = 0; i2 < 3; i2++) {
            for (String str2 : MIRRORS) {
                for (String str3 : c.c.C("Packages.xz", "Packages.gz", "Packages")) {
                    try {
                        HttpURLConnection z = openConnection(str2 + "/dists/stable/main/binary-" + termuxArch() + "/" + str3);
                        if (z.getResponseCode() != 200) {
                            throw new IOException("HTTP " + z.getResponseCode());
                        }
                        InputStream inputStream = new BufferedInputStream(z.getInputStream(), 65536);
                        try {
                            InputStream decompressedStream = inputStream;
                            if (m.m.E(str3, ".xz")) {
                                decompressedStream = new n.v(inputStream);
                            } else if (str3.endsWith(".gz")) {
                                decompressedStream = new GZIPInputStream(inputStream);
                            }
                            HashMap hashMap = parsePackageIndex(decompressedStream);
                            AppState.a(inputStream, null);
                            return new b.b(str2, hashMap);
                        } finally {
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                    }
                }
                try {
                    Thread.sleep(1500L);
                } catch (InterruptedException unused) {
                }
            }
        }
        if (e2 == null || (str = e2.getMessage()) == null) {
            str = "error";
        }
        throw new IOException("Cannot reach the Termux package server (" + str + ")");
    }

    public static void recordInstalled(File file, PackageEntry entry) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(readInstalled(file));
        linkedHashMap.put(entry.name, entry.version);
        File file2 = new File(file, "var/lib/nixpkg/installed");
        File parentFile = file2.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        g.m.L(file2, c.b.L(linkedHashMap.entrySet(), "\n", null, null, new ValueFunction(6), 30).concat("\n"));
    }

    public static void recordPrefix() {
        try {
            File parentFile = new File(prefixDir(), "var/lib/nixpkg/prefix").getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            g.m.L(new File(prefixDir(), "var/lib/nixpkg/prefix"), prefixPath());
        } catch (Exception unused) {
        }
    }

    public static void recordToolsVersion() {
        try {
            File file = new File(prefixDir(), "var/lib/nixpkg/tools");
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            g.m.L(file, "5");
        } catch (Exception unused) {
        }
    }

    public static File nodeModulesDirFor(File file) {
        String path;
        try {
            path = file.getCanonicalPath();
        } catch (Exception unused) {
            path = file.getPath();
        }
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = path.getBytes(m.a.f864a);
        i.b.d(bytes, "getBytes(...)");
        return new File(appContext().getFilesDir(), "nm/".concat(m.e.g0(12, c.a.D(messageDigest.digest(bytes), new ValueFunction(5)))));
    }

    public static ArrayList defaultPackages() {
        return c.b.N(c.c.C("nodejs-lts", "npm", "ca-certificates?"), c.c.C("python?", "python-pip?", "make?", "clang?", "binutils?", "pkg-config?", "cmake?", "git?", "ndk-sysroot?", "openssl?", "libsqlite?", "libuv?", "which?", "patch?", "tar?", "unzip?", "xz-utils?", "zlib?", "libffi?", "libcairo?", "cairo?", "pango?", "libpixman?", "libpng?", "libjpeg-turbo?", "giflib?", "librsvg?", "freetype?", "fontconfig?", "harfbuzz?", "glib?", "gdk-pixbuf?", "libwebp?", "libtiff?", "libxml2?", "ttf-dejavu?"));
    }

    public static long parseTarNumber(byte[] bArr, int i2, int i3) {
        long j2 = 0;
        if ((bArr[i2] & 128) != 0) {
            for (int i4 = 1; i4 < i3; i4++) {
                j2 = (j2 << 8) | (bArr[i2 + i4] & 255);
            }
            return j2;
        }
        long j3 = 0;
        boolean z = false;
        for (int i5 = 0; i5 < i3; i5++) {
            byte b2 = bArr[i2 + i5];
            if (48 > b2 || b2 >= 56) {
                if (z) {
                    break;
                }
            } else {
                j3 = (j3 * 8) + (b2 - 48);
                z = true;
            }
        }
        return j3;
    }

    public static HttpURLConnection openConnection(String str) {
        URLConnection openConnection = new URL(str).openConnection();
        i.b.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setConnectTimeout(20000);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setRequestProperty("User-Agent", "NixHost");
        return httpURLConnection;
    }

    public final void refreshShimsAndHelpers(File file, File file2) {
        try {
            File B = prefixDir();
            if (new File(B, "bin/node").exists()) {
                installDistutilsShim();
                installNpmWrappers();
                installLdconfigShim();
                if (isExternalStorage(file)) {
                    if (new File(file, "node_modules").isDirectory()) {
                        syncBinShims(new File(file, "node_modules"), shimDirFor(file2, file), true);
                    }
                    rewriteScriptsIn(new File(nodeModulesDirFor(file), "node_modules/.bin"));
                } else {
                    rewriteScriptsIn(new File(file, "node_modules/.bin"));
                }
                rewriteScriptsIn(new File(B, "bin"));
                syncBinShims(new File(B, "lib/node_modules"), new File(B, "bin"), false);
                File[] listFiles = new File(file2, ".npm/_npx").listFiles();
                if (listFiles != null) {
                    i.a a2 = i.j.a(listFiles);
                    while (a2.hasNext()) {
                        rewriteScriptsIn(new File((File) a2.next(), "node_modules/.bin"));
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final synchronized void syncBinShims(File file, File file2, boolean z) {
        File[] listFiles;
        File[] listFiles2;
        Map map;
        try {
            try {
                listFiles = file.listFiles();
            } catch (Exception unused) {
            }
            if (listFiles == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (File file3 : listFiles) {
                if (file3.isDirectory()) {
                    if (m.m.K(file3.getName(), "@")) {
                        File[] listFiles3 = file3.listFiles();
                        if (listFiles3 != null) {
                            for (File file4 : listFiles3) {
                                if (file4.isDirectory()) {
                                    arrayList.add(file4);
                                }
                            }
                        }
                    } else if (!m.m.K(file3.getName(), ".")) {
                        arrayList.add(file3);
                    }
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                File file5 = (File) it.next();
                File file6 = new File(file5, "package.json");
                String str = file6.getPath() + ":" + file6.lastModified() + ":" + file6.length();
                Map map2 = (Map) binEntriesCache.get(str);
                if (map2 != null) {
                    map = map2;
                } else {
                    HashMap hashMap = new HashMap();
                    try {
                        if (file6.isFile()) {
                            JSONObject jSONObject = new JSONObject(g.m.I(file6));
                            Object opt = jSONObject.opt("bin");
                            String optString = jSONObject.optString("name", file5.getName());
                            String d0 = m.e.d0(optString, '/', optString);
                            if (opt instanceof String) {
                                hashMap.put(d0, opt);
                            } else if (opt instanceof JSONObject) {
                                Iterator<String> keys = ((JSONObject) opt).keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    hashMap.put(next, ((JSONObject) opt).optString(next));
                                }
                            }
                        }
                    } catch (Exception unused2) {
                    }
                    binEntriesCache.put(str, hashMap);
                    map = hashMap;
                }
                if (!map.isEmpty()) {
                    String canonicalPath = file5.getCanonicalPath();
                    for (Map.Entry entry : map.entrySet()) {
                        String str2 = (String) entry.getKey();
                        String str3 = (String) entry.getValue();
                        if (binNamePattern.b(str2) && str3.length() != 0) {
                            File canonicalFile = new File(file5, str3).getCanonicalFile();
                            if (m.m.K(canonicalFile.getPath(), canonicalPath + "/") && canonicalFile.isFile()) {
                                linkedHashMap.put(str2, shimScriptFor(canonicalFile));
                            }
                        }
                    }
                }
            }
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                String str4 = (String) entry2.getKey();
                String str5 = (String) entry2.getValue();
                File file7 = new File(file2, str4);
                HashMap hashMap2 = shimContentsCache;
                String str6 = (String) hashMap2.get(file7.getPath());
                if (!i.b.a(str6, str5) || !file7.exists()) {
                    if (z || str6 != null || !file7.exists()) {
                        file2.mkdirs();
                        g.m.L(file7, str5);
                        chmod(file7, 493);
                        hashMap2.put(file7.getPath(), str5);
                    }
                }
            }
            if (z && (listFiles2 = file2.listFiles()) != null) {
                i.a a2 = i.j.a(listFiles2);
                while (a2.hasNext()) {
                    File file8 = (File) a2.next();
                    if (!linkedHashMap.containsKey(file8.getName())) {
                        file8.delete();
                    }
                }
            }
            HashMap hashMap3 = binEntriesCache;
            if (hashMap3.size() > 20000) {
                hashMap3.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void extractTar(BufferedInputStream bufferedInputStream, File file, ArrayList arrayList, RefAction refAction) {
        String prefix = prefixPath();
        byte[] bytes = "/data/data/com.termux/files/usr".getBytes(m.a.f864a);
        i.b.d(bytes, "getBytes(...)");
        if (prefix.length() > bytes.length) {
            throw new IOException("App id is too long for the prefix");
        }
        int length = bytes.length;
        if (length < 0) {
            throw new IllegalArgumentException("Desired length " + length + " is less than zero.");
        }
        CharSequence charSequence;
        if (length <= prefix.length()) {
            charSequence = prefix.subSequence(0, prefix.length());
        } else {
            StringBuilder sb = new StringBuilder(length);
            sb.append((CharSequence) prefix);
            int length2 = length - prefix.length();
            if (1 <= length2) {
                int i3 = 1;
                while (true) {
                    sb.append('/');
                    if (i3 == length2) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            charSequence = sb;
        }
        byte[] bytes2 = charSequence.toString().getBytes(m.a.f864a);
        i.b.d(bytes2, "getBytes(...)");
        byte[] bArr2 = new byte[512];
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (!((Boolean) refAction.a()).booleanValue()) {
            if (!readFully(this, bufferedInputStream, bArr2) || bArr2[0] == 0) {
                return;
            }
            String e2 = tarHeaderString(bArr2, 0, 100);
            if (m.m.K(tarHeaderString(bArr2, 257, 6), "ustar")) {
                String e3 = tarHeaderString(bArr2, 345, 155);
                if (e3.length() > 0) {
                    e2 = e3 + "/" + e2;
                }
            }
            int mode = (int) parseTarNumber(bArr2, 100, 8);
            long entrySize = parseTarNumber(bArr2, 124, 12);
            char c3 = (char) bArr2[156];
            String e4 = tarHeaderString(bArr2, 157, 100);
            long padding = (512 - (entrySize % 512)) % 512;
            if (c3 == 'K' || c3 == 'L' || c3 == 'g' || c3 == 'x') {
                int i4 = (int) entrySize;
                byte[] bArr5 = new byte[i4];
                readFully(this, bufferedInputStream, bArr5);
                skipBytes(bufferedInputStream, padding);
                if (c3 == 'K') {
                    str4 = m.e.j0(new String(bArr5, m.a.f864a), 0, '\n');
                } else if (c3 == 'L') {
                    str3 = m.e.j0(new String(bArr5, m.a.f864a), 0, '\n');
                } else if (c3 == 'x') {
                    int i5 = 0;
                    while (i5 < i4) {
                        int i6 = i5;
                        while (i6 < i4 && bArr5[i6] != 32) {
                            i6++;
                        }
                        Charset charset = m.a.f864a;
                        Integer C2 = m.l.C(new String(bArr5, i5, i6 - i5, charset));
                        if (C2 != null && C2.intValue() > 0 && (i5 = i5 + C2.intValue()) <= i4) {
                            String str8 = new String(bArr5, i6 + 1, (i5 - i6) - 2, charset);
                            int P = m.e.P(str8, '=', 0, false, 6);
                            if (P > 0) {
                                String substring = str8.substring(0, P);
                                i.b.d(substring, "substring(...)");
                                String substring2 = str8.substring(P + 1);
                                i.b.d(substring2, "substring(...)");
                                if (substring.equals("path")) {
                                    str5 = substring2;
                                } else if (substring.equals("linkpath")) {
                                    str6 = substring2;
                                }
                            }
                        }
                    }
                }
            } else {
                if (str3 == null) {
                    str3 = e2;
                }
                if (str5 == null) {
                    str5 = str3;
                }
                if (str4 == null) {
                    str4 = e4;
                }
                if (str6 != null) {
                    str4 = str6;
                }
                String G = stripTermuxPrefix(str5);
                if (G == null || G.length() == 0) {
                    skipBytes(bufferedInputStream, entrySize + padding);
                } else if (c3 == '5') {
                    File file3 = new File(file, G);
                    file3.mkdirs();
                    chmod(file3, mode | 448);
                    skipBytes(bufferedInputStream, entrySize + padding);
                } else if (c3 == '1') {
                    File file3 = new File(file, G);
                    String G2 = stripTermuxPrefix(str4);
                    if (G2 != null && G2.length() > 0) {
                        File file4 = new File(file, G2);
                        File parentFile = file3.getParentFile();
                        if (parentFile != null) {
                            parentFile.mkdirs();
                        }
                        file3.delete();
                        if (file4.exists()) {
                            g.m.D(file4, file3, true);
                            chmod(file3, mode | 384);
                        }
                    }
                    skipBytes(bufferedInputStream, entrySize + padding);
                } else if (c3 == '2') {
                    File file3 = new File(file, G);
                    File parentFile2 = file3.getParentFile();
                    if (parentFile2 != null) {
                        parentFile2.mkdirs();
                    }
                    file3.delete();
                    try {
                        Os.symlink(m.m.J(str4, "/data/data/com.termux/files/usr", prefix), file3.getPath());
                    } catch (Exception unused) {
                        throw new IOException("Cannot create link ".concat(G));
                    }
                    skipBytes(bufferedInputStream, entrySize + padding);
                } else if (c3 == 0 || c3 == '0' || c3 == '7') {
                    File file3 = new File(file, G);
                    File parentFile3 = file3.getParentFile();
                    if (parentFile3 != null) {
                        parentFile3.mkdirs();
                    }
                    file3.delete();
                    FileOutputStream fileOutputStream = new FileOutputStream(file3);
                    try {
                        replaceTermuxPrefix(bufferedInputStream, entrySize, fileOutputStream, bytes, bytes2);
                        AppState.a(fileOutputStream, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            AppState.a(fileOutputStream, th);
                            throw th2;
                        }
                    }
                    chmod(file3, mode | 384);
                    if ((mode & 73) != 0) {
                        arrayList.add(file3);
                    }
                    skipBytes(bufferedInputStream, padding);
                } else {
                    skipBytes(bufferedInputStream, entrySize + padding);
                }
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
            }
        }
        throw new StoppedException();
    }

    public final synchronized void rewriteScriptsIn(File file) {
        File[] listFiles;
        try {
            try {
                listFiles = file.listFiles();
            } catch (Exception unused) {
            }
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                try {
                    File canonicalFile = file2.getCanonicalFile();
                    if (canonicalFile.isFile()) {
                        String str = canonicalFile.getPath() + ":" + canonicalFile.lastModified() + ":" + canonicalFile.length();
                        HashSet hashSet = rewrittenScriptKeys;
                        if (!hashSet.contains(str)) {
                            rewriteScriptShebang(canonicalFile);
                            hashSet.add(str);
                            hashSet.add(canonicalFile.getPath() + ":" + canonicalFile.lastModified() + ":" + canonicalFile.length());
                        }
                    }
                } catch (Exception unused2) {
                }
            }
            HashSet hashSet2 = rewrittenScriptKeys;
            if (hashSet2.size() > 5000) {
                hashSet2.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
