package a;

import java.util.ArrayList;
import java.util.List;

public final class PackageEntry {

    public final String name;

    public final String version;

    public final List depends;

    public final String filename;

    public final String sha256;

    public final long size;

    public PackageEntry(String str, String str2, ArrayList arrayList, String str3, String str4, long j2) {
        this.name = str;
        this.version = str2;
        this.depends = arrayList;
        this.filename = str3;
        this.sha256 = str4;
        this.size = j2;
    }
}
