package t;

import java.lang.reflect.Array;
import m.d;
import n.j;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f978a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f979b = new int[4];

    /* renamed from: c, reason: collision with root package name */
    public final j f980c = new j(2);

    /* renamed from: d, reason: collision with root package name */
    public final short[][] f981d;

    /* renamed from: e, reason: collision with root package name */
    public final short[] f982e;

    /* renamed from: f, reason: collision with root package name */
    public final short[] f983f;

    /* renamed from: g, reason: collision with root package name */
    public final short[] f984g;

    /* renamed from: h, reason: collision with root package name */
    public final short[] f985h;

    /* renamed from: i, reason: collision with root package name */
    public final short[][] f986i;

    /* renamed from: j, reason: collision with root package name */
    public final short[][] f987j;

    /* renamed from: k, reason: collision with root package name */
    public final short[][] f988k;

    /* renamed from: l, reason: collision with root package name */
    public final short[] f989l;

    /* renamed from: m, reason: collision with root package name */
    public final s.a f990m;

    /* renamed from: n, reason: collision with root package name */
    public final u.a f991n;

    /* renamed from: o, reason: collision with root package name */
    public final b f992o;
    public final a p;
    public final a q;

    public c(s.a aVar, u.a aVar2, int i2, int i3, int i4) {
        Class cls = Short.TYPE;
        this.f981d = (short[][]) Array.newInstance((Class<?>) cls, 12, 16);
        this.f982e = new short[12];
        this.f983f = new short[12];
        this.f984g = new short[12];
        this.f985h = new short[12];
        this.f986i = (short[][]) Array.newInstance((Class<?>) cls, 12, 16);
        this.f987j = (short[][]) Array.newInstance((Class<?>) cls, 4, 64);
        this.f988k = new short[][]{new short[2], new short[2], new short[4], new short[4], new short[8], new short[8], new short[16], new short[16], new short[32], new short[32]};
        this.f989l = new short[16];
        this.f978a = (1 << i4) - 1;
        this.p = new a(this);
        this.q = new a(this);
        this.f990m = aVar;
        this.f991n = aVar2;
        this.f992o = new b(this, i2, i3);
        b();
    }

    public final void a() {
        int i2;
        int i3;
        s.a aVar = this.f990m;
        int i4 = aVar.f967g;
        if (i4 > 0) {
            aVar.a(aVar.f968h, i4);
        }
        while (true) {
            int i5 = aVar.f964d;
            int i6 = aVar.f966f;
            u.a aVar2 = this.f991n;
            if (i5 >= i6) {
                aVar2.d();
                return;
            }
            int i7 = i5 & this.f978a;
            j jVar = this.f980c;
            int i8 = 1;
            if (aVar2.a(this.f981d[jVar.f901b], i7) == 0) {
                b bVar = this.f992o;
                s.a aVar3 = bVar.f977d.f990m;
                int i9 = aVar3.f964d;
                int i10 = i9 - 1;
                if (i9 <= 0) {
                    i10 += aVar3.f962b;
                }
                int i11 = aVar3.f961a[i10] & 255;
                int i12 = bVar.f974a;
                d dVar = bVar.f976c[(i11 >> (8 - i12)) + ((i9 & bVar.f975b) << i12)];
                c cVar = ((b) dVar.f877b).f977d;
                int i13 = cVar.f980c.f901b;
                s.a aVar4 = cVar.f990m;
                u.a aVar5 = cVar.f991n;
                short[] sArr = (short[]) dVar.f876a;
                if (i13 < 7) {
                    do {
                        i8 = (i8 << 1) | aVar5.a(sArr, i8);
                    } while (i8 < 256);
                } else {
                    int i14 = cVar.f979b[0];
                    int i15 = aVar4.f964d;
                    int i16 = (i15 - i14) - 1;
                    if (i14 >= i15) {
                        i16 += aVar4.f962b;
                    }
                    int i17 = aVar4.f961a[i16] & 255;
                    int i18 = 1;
                    int i19 = 256;
                    do {
                        i17 <<= 1;
                        int i20 = i17 & i19;
                        int a2 = aVar5.a(sArr, i19 + i20 + i18);
                        i18 = (i18 << 1) | a2;
                        i19 &= (~i20) ^ (0 - a2);
                    } while (i18 < 256);
                    i8 = i18;
                }
                int i21 = aVar4.f964d;
                int i22 = i21 + 1;
                aVar4.f964d = i22;
                aVar4.f961a[i21] = (byte) i8;
                if (aVar4.f965e < i22) {
                    aVar4.f965e = i22;
                }
                j jVar2 = cVar.f980c;
                int i23 = jVar2.f901b;
                if (i23 <= 3) {
                    jVar2.f901b = 0;
                } else if (i23 <= 9) {
                    jVar2.f901b = i23 - 3;
                } else {
                    jVar2.f901b = i23 - 6;
                }
            } else {
                int a3 = aVar2.a(this.f982e, jVar.f901b);
                int[] iArr = this.f979b;
                if (a3 == 0) {
                    jVar.f901b = jVar.f901b >= 7 ? 10 : 7;
                    iArr[3] = iArr[2];
                    iArr[2] = iArr[1];
                    iArr[1] = iArr[0];
                    i3 = this.p.a(i7);
                    int b2 = aVar2.b(this.f987j[i3 < 6 ? i3 - 2 : 3]);
                    if (b2 < 4) {
                        iArr[0] = b2;
                    } else {
                        int i24 = b2 >> 1;
                        int i25 = ((b2 & 1) | 2) << (i24 - 1);
                        iArr[0] = i25;
                        if (b2 < 14) {
                            short[] sArr2 = this.f988k[b2 - 4];
                            int i26 = 0;
                            int i27 = 0;
                            int i28 = 1;
                            while (true) {
                                int a4 = aVar2.a(sArr2, i28);
                                i28 = (i28 << 1) | a4;
                                int i29 = i27 + 1;
                                i26 |= a4 << i27;
                                if (i28 >= sArr2.length) {
                                    break;
                                } else {
                                    i27 = i29;
                                }
                            }
                            iArr[0] = i25 | i26;
                        } else {
                            int i30 = i24 - 5;
                            int i31 = 0;
                            do {
                                aVar2.d();
                                int i32 = aVar2.f993a >>> 1;
                                aVar2.f993a = i32;
                                int i33 = aVar2.f994b;
                                int i34 = (i33 - i32) >>> 31;
                                aVar2.f994b = i33 - (i32 & (i34 - 1));
                                i31 = (i31 << 1) | (1 - i34);
                                i30--;
                            } while (i30 != 0);
                            int i35 = i25 | (i31 << 4);
                            iArr[0] = i35;
                            int i36 = 0;
                            int i37 = 0;
                            int i38 = 1;
                            while (true) {
                                short[] sArr3 = this.f989l;
                                int a5 = aVar2.a(sArr3, i38);
                                i38 = (i38 << 1) | a5;
                                int i39 = i37 + 1;
                                i36 |= a5 << i37;
                                if (i38 >= sArr3.length) {
                                    break;
                                } else {
                                    i37 = i39;
                                }
                            }
                            iArr[0] = i35 | i36;
                        }
                    }
                } else {
                    if (aVar2.a(this.f983f, jVar.f901b) == 0) {
                        if (aVar2.a(this.f986i[jVar.f901b], i7) == 0) {
                            jVar.f901b = jVar.f901b >= 7 ? 11 : 9;
                            i3 = i8;
                        }
                    } else {
                        if (aVar2.a(this.f984g, jVar.f901b) == 0) {
                            i2 = iArr[1];
                        } else {
                            if (aVar2.a(this.f985h, jVar.f901b) == 0) {
                                i2 = iArr[2];
                            } else {
                                i2 = iArr[3];
                                iArr[3] = iArr[2];
                            }
                            iArr[2] = iArr[1];
                        }
                        iArr[1] = iArr[0];
                        iArr[0] = i2;
                    }
                    jVar.f901b = jVar.f901b < 7 ? 8 : 11;
                    i8 = this.q.a(i7);
                    i3 = i8;
                }
                aVar.a(iArr[0], i3);
            }
        }
    }

    public final void b() {
        int[] iArr = this.f979b;
        int i2 = 0;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        this.f980c.f901b = 0;
        int i3 = 0;
        while (true) {
            short[][] sArr = this.f981d;
            if (i3 >= sArr.length) {
                break;
            }
            u.a.c(sArr[i3]);
            i3++;
        }
        u.a.c(this.f982e);
        u.a.c(this.f983f);
        u.a.c(this.f984g);
        u.a.c(this.f985h);
        int i4 = 0;
        while (true) {
            short[][] sArr2 = this.f986i;
            if (i4 >= sArr2.length) {
                break;
            }
            u.a.c(sArr2[i4]);
            i4++;
        }
        int i5 = 0;
        while (true) {
            short[][] sArr3 = this.f987j;
            if (i5 >= sArr3.length) {
                break;
            }
            u.a.c(sArr3[i5]);
            i5++;
        }
        int i6 = 0;
        while (true) {
            short[][] sArr4 = this.f988k;
            if (i6 >= sArr4.length) {
                break;
            }
            u.a.c(sArr4[i6]);
            i6++;
        }
        u.a.c(this.f989l);
        while (true) {
            d[] dVarArr = this.f992o.f976c;
            if (i2 >= dVarArr.length) {
                this.p.b();
                this.q.b();
                return;
            } else {
                u.a.c((short[]) dVarArr[i2].f876a);
                i2++;
            }
        }
    }
}
