package g;

import a.AbstractC0008c;
import a.C0031h2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public abstract class m extends AbstractC0008c {
    public static void C(File file, File file2, C0031h2 c0031h2) {
        if (!file.exists()) {
            new a(file, 2);
            return;
        }
        try {
            i iVar = new i(new k(file, l.f831a, new n(c0031h2), Integer.MAX_VALUE));
            while (iVar.hasNext()) {
                File file3 = (File) iVar.next();
                if (file3.exists()) {
                    File file4 = new File(file2, J(file3, file));
                    if (file4.exists() && (!file3.isDirectory() || !file4.isDirectory())) {
                        new a(file3, file4, "The destination file already exists.");
                    } else if (file3.isDirectory()) {
                        file4.mkdirs();
                    } else {
                        D(file3, file4, false);
                        if (file4.length() != file3.length()) {
                            new IOException("Source file wasn't copied completely, length of destination file differs.");
                        }
                    }
                } else {
                    new a(file3, 2);
                }
            }
        } catch (r unused) {
        }
    }

    public static void D(File file, File file2, boolean z) {
        i.b.e(file, "<this>");
        if (!file.exists()) {
            throw new a(file, 2);
        }
        if (file2.exists()) {
            if (!z) {
                throw new a(file, file2, "The destination file already exists.");
            }
            if (!file2.delete()) {
                throw new a(file, file2, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (file.isDirectory()) {
            if (!file2.mkdirs()) {
                throw new d(file, file2, "Failed to create target directory.");
            }
            return;
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                AbstractC0008c.e(fileInputStream, fileOutputStream, 8192);
                AbstractC0008c.a(fileOutputStream, null);
                AbstractC0008c.a(fileInputStream, null);
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AbstractC0008c.a(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static boolean E(File file) {
        i iVar = new i(new k(file, l.f832b, null, Integer.MAX_VALUE));
        while (true) {
            boolean z = true;
            while (iVar.hasNext()) {
                File file2 = (File) iVar.next();
                if (file2.delete() || !file2.exists()) {
                    if (z) {
                        break;
                    }
                }
                z = false;
            }
            return z;
        }
    }

    public static final c F(c cVar) {
        List<File> list = cVar.f809b;
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (!i.b.a(name, ".")) {
                if (!i.b.a(name, "..")) {
                    arrayList.add(file);
                } else if (arrayList.isEmpty() || i.b.a(((File) c.b.M(arrayList)).getName(), "..")) {
                    arrayList.add(file);
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        return new c(cVar.f808a, arrayList);
    }

    public static byte[] G(File file) {
        i.b.e(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i2 = (int) length;
            byte[] bArr = new byte[i2];
            int i3 = i2;
            int i4 = 0;
            while (i3 > 0) {
                int read = fileInputStream.read(bArr, i4, i3);
                if (read < 0) {
                    break;
                }
                i3 -= read;
                i4 += read;
            }
            if (i3 > 0) {
                bArr = Arrays.copyOf(bArr, i4);
                i.b.d(bArr, "copyOf(...)");
            } else {
                int read2 = fileInputStream.read();
                if (read2 != -1) {
                    b bVar = new b(8193);
                    bVar.write(read2);
                    AbstractC0008c.e(fileInputStream, bVar, 8192);
                    int size = bVar.size() + i2;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] a2 = bVar.a();
                    bArr = Arrays.copyOf(bArr, size);
                    i.b.d(bArr, "copyOf(...)");
                    System.arraycopy(a2, 0, bArr, i2, bVar.size());
                }
            }
            AbstractC0008c.a(fileInputStream, null);
            return bArr;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AbstractC0008c.a(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static ArrayList H(File file) {
        Charset charset = m.a.f864a;
        i.b.e(charset, "charset");
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
        try {
            for (String str : new l.a(new p(bufferedReader))) {
                i.b.e(str, "it");
                arrayList.add(str);
            }
            AbstractC0008c.a(bufferedReader, null);
            return arrayList;
        } finally {
        }
    }

    public static String I(File file) {
        Charset charset = m.a.f864a;
        i.b.e(file, "<this>");
        i.b.e(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String v2 = AbstractC0008c.v(inputStreamReader);
            AbstractC0008c.a(inputStreamReader, null);
            return v2;
        } finally {
        }
    }

    public static final String J(File file, File file2) {
        c F = F(AbstractC0008c.A(file));
        c F2 = F(AbstractC0008c.A(file2));
        String str = null;
        if (i.b.a(F.f808a, F2.f808a)) {
            List list = F2.f809b;
            int size = list.size();
            List list2 = F.f809b;
            int size2 = list2.size();
            int min = Math.min(size2, size);
            int i2 = 0;
            while (i2 < min && i.b.a(list2.get(i2), list.get(i2))) {
                i2++;
            }
            StringBuilder sb = new StringBuilder();
            int i3 = size - 1;
            if (i2 <= i3) {
                while (!i.b.a(((File) list.get(i3)).getName(), "..")) {
                    sb.append("..");
                    if (i3 != i2) {
                        sb.append(File.separatorChar);
                    }
                    if (i3 != i2) {
                        i3--;
                    }
                }
            }
            if (i2 < size2) {
                if (i2 < size) {
                    sb.append(File.separatorChar);
                }
                List H = c.b.H(list2, i2);
                String str2 = File.separator;
                i.b.d(str2, "separator");
                c.b.K(H, sb, str2, "", "", -1, "...", null);
            }
            str = sb.toString();
        }
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + file2 + '.');
    }

    public static void K(File file, byte[] bArr) {
        i.b.e(bArr, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            AbstractC0008c.a(fileOutputStream, null);
        } finally {
        }
    }

    public static void L(File file, String str) {
        Charset charset = m.a.f864a;
        i.b.e(file, "<this>");
        i.b.e(str, "text");
        i.b.e(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            M(fileOutputStream, str, charset);
            AbstractC0008c.a(fileOutputStream, null);
        } finally {
        }
    }

    public static final void M(FileOutputStream fileOutputStream, String str, Charset charset) {
        i.b.e(str, "text");
        i.b.e(charset, "charset");
        if (str.length() < 16384) {
            byte[] bytes = str.getBytes(charset);
            i.b.d(bytes, "getBytes(...)");
            fileOutputStream.write(bytes);
            return;
        }
        CharsetEncoder newEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        CharsetEncoder onUnmappableCharacter = newEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
        CharBuffer allocate = CharBuffer.allocate(8192);
        i.b.b(onUnmappableCharacter);
        ByteBuffer allocate2 = ByteBuffer.allocate(8192 * ((int) Math.ceil(onUnmappableCharacter.maxBytesPerChar())));
        i.b.d(allocate2, "allocate(...)");
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            int min = Math.min(8192 - i3, str.length() - i2);
            int i4 = i2 + min;
            char[] array = allocate.array();
            i.b.d(array, "array(...)");
            str.getChars(i2, i4, array, i3);
            allocate.limit(min + i3);
            i3 = 1;
            if (!onUnmappableCharacter.encode(allocate, allocate2, i4 == str.length()).isUnderflow()) {
                throw new IllegalStateException("Check failed.".toString());
            }
            fileOutputStream.write(allocate2.array(), 0, allocate2.position());
            if (allocate.position() != allocate.limit()) {
                allocate.put(0, allocate.get());
            } else {
                i3 = 0;
            }
            allocate.clear();
            allocate2.clear();
            i2 = i4;
        }
    }
}
