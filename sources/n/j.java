package n;

import java.io.InputStream;

/* loaded from: classes.dex */
public final class j implements m, l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f900a;

    /* renamed from: b, reason: collision with root package name */
    public int f901b;

    public /* synthetic */ j(int i2) {
        this.f900a = i2;
    }

    @Override // n.l
    public boolean a() {
        switch (this.f900a) {
            case 0:
                return false;
            default:
                return true;
        }
    }

    @Override // n.m
    public InputStream b(InputStream inputStream, a aVar) {
        switch (this.f900a) {
            case 0:
                return new k(inputStream, this.f901b);
            default:
                return new o(inputStream, this.f901b, aVar);
        }
    }

    @Override // n.l
    public boolean c() {
        switch (this.f900a) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    @Override // n.m
    public int d() {
        switch (this.f900a) {
            case 0:
                return 1;
            default:
                return (o.b(this.f901b) / 1024) + 104;
        }
    }

    @Override // n.l
    public boolean e() {
        switch (this.f900a) {
            case 0:
                return false;
            default:
                return true;
        }
    }

    public j(byte[] bArr) {
        this.f900a = 0;
        if (bArr.length != 1) {
            throw new r("Unsupported Delta filter properties");
        }
        this.f901b = (bArr[0] & 255) + 1;
    }
}
