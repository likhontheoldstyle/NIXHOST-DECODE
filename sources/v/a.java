package v;

import a.AbstractC0008c;

/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f997c = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 6, 6, 0, 0, 7, 7, 4, 4, 0, 0, 4, 4, 0, 0};

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f998a;

    /* renamed from: b, reason: collision with root package name */
    public int f999b;

    @Override // v.b
    public final int a(byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        char c2;
        int i6;
        int i7;
        switch (this.f998a) {
            case 0:
                char c3 = 16;
                int i8 = (i2 + i3) - 16;
                int i9 = i2;
                while (i9 <= i8) {
                    int i10 = f997c[bArr[i9] & 31];
                    int i11 = 5;
                    int i12 = 0;
                    while (i12 < 3) {
                        if (((i10 >>> i12) & 1) == 0) {
                            c2 = c3;
                            i4 = i9;
                            i5 = i11;
                        } else {
                            int i13 = i11 >>> 3;
                            int i14 = i11 & 7;
                            long j2 = 0;
                            int i15 = 0;
                            while (i15 < 6) {
                                j2 |= (bArr[(i9 + i13) + i15] & 255) << (i15 * 8);
                                i15++;
                                i9 = i9;
                            }
                            i4 = i9;
                            long j3 = j2 >>> i14;
                            if (((j3 >>> 37) & 15) == 5 && ((j3 >>> 9) & 7) == 0) {
                                i5 = i11;
                                long j4 = (((((((int) (j3 >>> 36)) & 1) << 20) | ((int) ((j3 >>> 13) & 1048575))) << 4) - ((this.f999b + i4) - i2)) >>> 4;
                                c2 = 16;
                                long j5 = ((((j3 & (-77309403137L)) | ((j4 & 1048575) << 13)) | ((j4 & 1048576) << 16)) << i14) | (((1 << i14) - 1) & j2);
                                for (int i16 = 0; i16 < 6; i16++) {
                                    bArr[i4 + i13 + i16] = (byte) (j5 >>> (i16 * 8));
                                }
                            } else {
                                i5 = i11;
                                c2 = 16;
                            }
                        }
                        i12++;
                        i11 = i5 + 41;
                        c3 = c2;
                        i9 = i4;
                    }
                    i9 += 16;
                }
                int i17 = i9 - i2;
                this.f999b += i17;
                return i17;
            case 1:
                int i18 = (i2 + i3) - 4;
                int i19 = i2;
                while (i19 <= i18) {
                    byte b2 = bArr[i19 + 3];
                    if ((b2 & 252) == 148) {
                        AbstractC0008c.x(bArr, i19, ((AbstractC0008c.k(bArr, i19) + (-(((this.f999b + i19) - i2) >>> 2))) & 67108863) | (-1811939328));
                    } else if ((b2 & 159) == 144) {
                        int k2 = AbstractC0008c.k(bArr, i19);
                        int i20 = ((k2 >>> 29) & 3) | ((k2 >>> 3) & 2097148);
                        if (((i20 + 131072) & 1835008) == 0) {
                            int i21 = i20 + (-(((this.f999b + i19) - i2) >>> 12));
                            AbstractC0008c.x(bArr, i19, (k2 & (-1879048161)) | ((i21 & 3) << 29) | ((262140 & i21) << 3) | ((-(i21 & 131072)) & 14680064));
                        }
                    }
                    i19 += 4;
                }
                int i22 = i19 - i2;
                this.f999b += i22;
                return i22;
            case 2:
                int i23 = (i2 + i3) - 4;
                int i24 = i2;
                while (i24 <= i23) {
                    if ((bArr[i24 + 3] & 255) == 235) {
                        int i25 = i24 + 2;
                        int i26 = i24 + 1;
                        int i27 = (((((bArr[i25] & 255) << 16) | ((bArr[i26] & 255) << 8)) | (bArr[i24] & 255)) << 2) - ((this.f999b + i24) - i2);
                        bArr[i25] = (byte) (i27 >>> 18);
                        bArr[i26] = (byte) (i27 >>> 10);
                        bArr[i24] = (byte) (i27 >>> 2);
                    }
                    i24 += 4;
                }
                int i28 = i24 - i2;
                this.f999b += i28;
                return i28;
            case 3:
                int i29 = (i2 + i3) - 4;
                int i30 = i2;
                while (i30 <= i29) {
                    int i31 = i30 + 1;
                    int i32 = bArr[i31];
                    if ((i32 & 248) == 240) {
                        int i33 = i30 + 3;
                        int i34 = bArr[i33];
                        if ((i34 & 248) == 248) {
                            int i35 = ((i32 & 7) << 19) | ((bArr[i30] & 255) << 11) | ((i34 & 7) << 8);
                            int i36 = i30 + 2;
                            int i37 = ((i35 | (bArr[i36] & 255)) << 1) - ((this.f999b + i30) - i2);
                            bArr[i31] = (byte) (240 | ((i37 >>> 20) & 7));
                            bArr[i30] = (byte) (i37 >>> 12);
                            bArr[i33] = (byte) (((i37 >>> 9) & 7) | 248);
                            bArr[i36] = (byte) (i37 >>> 1);
                            i30 = i36;
                        }
                    }
                    i30 += 2;
                }
                int i38 = i30 - i2;
                this.f999b += i38;
                return i38;
            case 4:
                int i39 = (i2 + i3) - 4;
                int i40 = i2;
                while (i40 <= i39) {
                    if ((bArr[i40] & 252) == 72 && (bArr[i40 + 3] & 3) == 1) {
                        AbstractC0008c.w(bArr, i40, ((AbstractC0008c.j(bArr, i40) + (-((this.f999b + i40) - i2))) & 67108860) | 1207959553);
                    }
                    i40 += 4;
                }
                int i41 = i40 - i2;
                this.f999b += i41;
                return i41;
            case 5:
                int i42 = (i2 + i3) - 8;
                int i43 = i2;
                while (i43 <= i42) {
                    int i44 = bArr[i43];
                    int i45 = i44 & 255;
                    if (i45 == 239) {
                        int i46 = i43 + 1;
                        int i47 = bArr[i46];
                        if ((i47 & 13) == 0) {
                            int i48 = i43 + 2;
                            int i49 = i43 + 3;
                            int i50 = ((((i47 & 240) << 13) | ((bArr[i48] & 255) << 9)) | ((bArr[i49] & 255) << 1)) - ((this.f999b + i43) - i2);
                            bArr[i46] = (byte) ((i47 & 15) | ((i50 >>> 8) & 240));
                            bArr[i48] = (byte) (((i50 >>> 16) & 15) | ((i50 >>> 7) & 16) | ((i50 << 4) & 224));
                            bArr[i49] = (byte) (((i50 >>> 13) & 128) | ((i50 >>> 4) & 127));
                            i43 = i48;
                        }
                    } else if ((i44 & 127) == 23) {
                        int i51 = ((bArr[i43 + 1] & 255) << 8) | i45;
                        int i52 = i43 + 2;
                        int i53 = i51 | ((bArr[i52] & 255) << 16) | ((bArr[i43 + 3] & 255) << 24);
                        if ((i53 & 3712) != 0) {
                            i52 = i43 + 4;
                            int k3 = AbstractC0008c.k(bArr, i52);
                            if ((((i53 << 8) ^ k3) & 1015811) == 3) {
                                i6 = (i53 & (-4096)) + (k3 >>> 20);
                                i7 = (k3 << 12) | 279;
                                AbstractC0008c.x(bArr, i43, i7);
                                AbstractC0008c.x(bArr, i43 + 4, i6);
                                i43 += 6;
                            }
                            i43 = i52;
                        } else {
                            int i54 = i53 >>> 27;
                            if (((i53 - 12544) & 16256) < (i54 & 29)) {
                                int j6 = AbstractC0008c.j(bArr, i43 + 4) - ((this.f999b + i43) - i2);
                                i6 = (i53 >>> 12) | (j6 << 20);
                                i7 = ((j6 + 2048) & (-4096)) | 23 | (i54 << 7);
                                AbstractC0008c.x(bArr, i43, i7);
                                AbstractC0008c.x(bArr, i43 + 4, i6);
                                i43 += 6;
                            }
                            i43 = i52;
                        }
                    }
                    i43 += 2;
                }
                int i55 = i43 - i2;
                this.f999b += i55;
                return i55;
            default:
                int i56 = (i2 + i3) - 4;
                int i57 = i2;
                while (i57 <= i56) {
                    byte b3 = bArr[i57];
                    if ((b3 == 64 && (bArr[i57 + 1] & 192) == 0) || (b3 == Byte.MAX_VALUE && (bArr[i57 + 1] & 192) == 192)) {
                        AbstractC0008c.w(bArr, i57, ((((AbstractC0008c.j(bArr, i57) + (-(((this.f999b + i57) - i2) >>> 2))) << 9) >> 9) & 1073741823) | 1073741824);
                    }
                    i57 += 4;
                }
                int i58 = i57 - i2;
                this.f999b += i58;
                return i58;
        }
    }

    public /* synthetic */ a(int i2, int i3, boolean z) {
        this.f998a = i3;
        this.f999b = i2;
    }

    public a(int i2, int i3) {
        this.f998a = i3;
        switch (i3) {
            case 3:
                this.f999b = i2 + 4;
                break;
            default:
                this.f999b = i2 + 8;
                break;
        }
    }
}
