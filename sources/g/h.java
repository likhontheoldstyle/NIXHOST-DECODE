package g;

import java.io.File;

/* loaded from: classes.dex */
public final class h extends e {

    /* renamed from: b, reason: collision with root package name */
    public boolean f816b;

    /* renamed from: c, reason: collision with root package name */
    public File[] f817c;

    /* renamed from: d, reason: collision with root package name */
    public int f818d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ i f819e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(i iVar, File file) {
        super(file);
        i.b.e(file, "rootDir");
        this.f819e = iVar;
    }

    @Override // g.j
    public final File a() {
        h.c cVar;
        boolean z = this.f816b;
        i iVar = this.f819e;
        File file = this.f824a;
        if (!z) {
            h.b bVar = iVar.f823d.f827c;
            if (bVar != null && !((Boolean) bVar.a(file)).booleanValue()) {
                return null;
            }
            this.f816b = true;
            return file;
        }
        File[] fileArr = this.f817c;
        if (fileArr != null && this.f818d >= fileArr.length) {
            h.b bVar2 = iVar.f823d.f828d;
            if (bVar2 != null) {
                bVar2.a(file);
            }
            return null;
        }
        if (fileArr == null) {
            File[] listFiles = file.listFiles();
            this.f817c = listFiles;
            if (listFiles == null && (cVar = iVar.f823d.f829e) != null) {
                cVar.a(file, new a(file, 0));
            }
            File[] fileArr2 = this.f817c;
            if (fileArr2 == null || fileArr2.length == 0) {
                h.b bVar3 = iVar.f823d.f828d;
                if (bVar3 != null) {
                    bVar3.a(file);
                }
                return null;
            }
        }
        File[] fileArr3 = this.f817c;
        i.b.b(fileArr3);
        int i2 = this.f818d;
        this.f818d = i2 + 1;
        return fileArr3[i2];
    }
}
