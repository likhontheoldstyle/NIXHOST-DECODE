package g;

import java.io.File;

/* loaded from: classes.dex */
public final class f extends e {

    /* renamed from: b, reason: collision with root package name */
    public boolean f810b;

    /* renamed from: c, reason: collision with root package name */
    public File[] f811c;

    /* renamed from: d, reason: collision with root package name */
    public int f812d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f813e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ i f814f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(i iVar, File file) {
        super(file);
        i.b.e(file, "rootDir");
        this.f814f = iVar;
    }

    @Override // g.j
    public final File a() {
        boolean z = this.f813e;
        i iVar = this.f814f;
        File file = this.f824a;
        if (!z && this.f811c == null) {
            h.b bVar = iVar.f823d.f827c;
            if (bVar != null && !((Boolean) bVar.a(file)).booleanValue()) {
                return null;
            }
            File[] listFiles = file.listFiles();
            this.f811c = listFiles;
            if (listFiles == null) {
                h.c cVar = iVar.f823d.f829e;
                if (cVar != null) {
                    cVar.a(file, new a(file, 0));
                }
                this.f813e = true;
            }
        }
        File[] fileArr = this.f811c;
        if (fileArr != null && this.f812d < fileArr.length) {
            i.b.b(fileArr);
            int i2 = this.f812d;
            this.f812d = i2 + 1;
            return fileArr[i2];
        }
        if (!this.f810b) {
            this.f810b = true;
            return file;
        }
        h.b bVar2 = iVar.f823d.f828d;
        if (bVar2 != null) {
            bVar2.a(file);
        }
        return null;
    }
}
