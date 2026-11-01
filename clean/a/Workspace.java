package a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public abstract class Workspace {

    public static final i.g namePattern = new i.g("^[A-Za-z0-9_.-]{1,100}$");

    public static final i.g pathPattern = new i.g("^[A-Za-z0-9_./-]{1,100}$");

    public static final i.g folderPattern = new i.g("^[A-Za-z0-9_][A-Za-z0-9_.-]{0,59}$");

    public static String gclone(String str, String str2, File file) {
        String str3;
        String str4;
        List b0 = m.e.b0(m.e.j0(m.e.X(m.e.X(m.e.X(m.e.X(m.e.h0(str).toString(), "https://"), "http://"), "www."), "github.com/"), '/'), new String[]{"/"});
        if (b0.size() < 2) {
            return "Usage: gclone <folder> <github-url>";
        }
        String str5 = (String) b0.get(0);
        String Y = m.e.Y((String) b0.get(1), ".git");
        if (b0.size() >= 4 && i.b.a(b0.get(2), "tree")) {
            str3 = c.b.L(c.b.H(b0, 3), "/", null, null, null, 62);
        } else {
            if (b0.size() != 2) {
                return "Only github.com/owner/repo links are supported.";
            }
            str3 = "";
        }
        i.g gVar = namePattern;
        if (!gVar.b(str5) || !gVar.b(Y) || m.e.i0(str5, '.').length() == 0 || m.e.i0(Y, '.').length() == 0) {
            return "That does not look like a GitHub repo link.";
        }
        if (str3.length() > 0 && (!pathPattern.b(str3) || m.e.M(str3, ".."))) {
            return "Bad branch name.";
        }
        if (str2 == null) {
            str2 = Y;
        }
        if (!folderPattern.b(str2)) {
            return "Bad folder name. Use letters, numbers, - _ . only.";
        }
        if (str3.length() == 0) {
            str4 = "https://github.com/" + str5 + "/" + Y + "/archive/HEAD.zip";
        } else {
            str4 = "https://github.com/" + str5 + "/" + Y + "/archive/refs/heads/" + str3 + ".zip";
        }
        file.mkdirs();
        File file2 = new File(file, ".gclone-" + System.nanoTime() + ".tmp");
        try {
            try {
                URLConnection openConnection = new URL(str4).openConnection();
                i.b.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestProperty("User-Agent", "NixHost");
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 404) {
                    return "Repo (or branch) not found. gclone works only with PUBLIC GitHub repos.";
                }
                if (responseCode != 200) {
                    String str6 = "GitHub error " + responseCode;
                    try {
                        file2.delete();
                    } catch (Exception unused) {
                    }
                    return str6;
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    try {
                        byte[] bArr = new byte[16384];
                        long j2 = 0;
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read < 0) {
                                AppState.a(fileOutputStream, null);
                                AppState.a(inputStream, null);
                                String str7 = "Done: " + unzip(file2, new File(file, str2)) + " files in " + str2 + "\nNext: cd " + str2;
                                try {
                                    file2.delete();
                                } catch (Exception unused2) {
                                }
                                return str7;
                            }
                            j2 += read;
                            if (j2 > 209715200) {
                                throw new IOException("Repo too big (max 200 MB)");
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
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
            } catch (Exception e2) {
                String message = e2.getMessage();
                if (message == null) {
                    message = "no internet";
                }
                String str8 = "Failed: " + message;
                try {
                    file2.delete();
                } catch (Exception unused3) {
                }
                return str8;
            }
        } finally {
            try {
                file2.delete();
            } catch (Exception unused4) {
            }
        }
    }

    public static File homeDir(Context context, String str) {
        String[] list;
        String lowerCase = str.toLowerCase(Locale.ROOT);
        i.b.d(lowerCase, "toLowerCase(...)");
        Pattern compile = Pattern.compile("[^a-z0-9_-]");
        i.b.d(compile, "compile(...)");
        String replaceAll = compile.matcher(lowerCase).replaceAll("_");
        i.b.d(replaceAll, "replaceAll(...)");
        String g0 = m.e.g0(32, replaceAll);
        if (g0.length() == 0) {
            g0 = "user";
        }
        File file = new File(context.getFilesDir(), "workspace/".concat(g0));
        if (hasStorageAccess(context)) {
            try {
                File file2 = new File(new File(Environment.getExternalStorageDirectory(), "NixHost"), g0);
                file2.mkdirs();
                if (file2.isDirectory() && file2.canWrite()) {
                    if (file.exists() && (list = file.list()) != null) {
                        if (!(list.length == 0)) {
                            g.m.C(file, file2, new NoopFunction2(1));
                            g.m.E(file);
                        }
                    }
                    return file2;
                }
            } catch (Exception unused) {
            }
        }
        file.mkdirs();
        return file;
    }

    public static boolean hasStorageAccess(Context context) {
        boolean isExternalStorageManager;
        if (Build.VERSION.SDK_INT < 30) {
            return context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        }
        isExternalStorageManager = Environment.isExternalStorageManager();
        return isExternalStorageManager;
    }

    public static int unzip(File file, File file2) {
        file2.mkdirs();
        File canonicalFile = file2.getCanonicalFile();
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(file), 8192));
        try {
            byte[] bArr = new byte[16384];
            long j2 = 0;
            int i2 = 0;
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    AppState.a(zipInputStream, null);
                    return i2;
                }
                String c0 = m.e.c0(nextEntry.getName(), '/', "");
                if (c0.length() != 0) {
                    File canonicalFile2 = new File(canonicalFile, c0).getCanonicalFile();
                    if (!i.b.a(canonicalFile2.getPath(), canonicalFile.getPath())) {
                        if (!m.m.K(canonicalFile2.getPath(), canonicalFile.getPath() + "/")) {
                            continue;
                        }
                    }
                    if (nextEntry.isDirectory()) {
                        canonicalFile2.mkdirs();
                    } else {
                        File parentFile = canonicalFile2.getParentFile();
                        if (parentFile != null) {
                            parentFile.mkdirs();
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(canonicalFile2);
                        while (true) {
                            try {
                                int read = zipInputStream.read(bArr);
                                if (read < 0) {
                                    AppState.a(fileOutputStream, null);
                                    i2++;
                                    break;
                                }
                                j2 += read;
                                if (j2 > 524288000) {
                                    throw new IOException("Too big (over 500 MB)");
                                }
                                fileOutputStream.write(bArr, 0, read);
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } finally {
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                AppState.a(zipInputStream, th2);
                throw th3;
            }
        }
    }
}
