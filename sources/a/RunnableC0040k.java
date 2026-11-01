package a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: a.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0040k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f560a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0006b1 f561b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f562c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ K0 f563d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f564e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f565f;

    public /* synthetic */ RunnableC0040k(C0000a c0000a, C0006b1 c0006b1, long j2, JSONObject jSONObject, K0 k0) {
        this.f564e = c0000a;
        this.f561b = c0006b1;
        this.f562c = j2;
        this.f565f = jSONObject;
        this.f563d = k0;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(26:15|16|17|18|(1:19)|(1:21)(21:213|(1:215)|23|24|(22:144|145|147|148|(1:207)(2:152|153)|154|155|156|(1:158)(1:202)|159|160|161|(1:163)(1:200)|(3:165|(4:167|168|169|170)(1:198)|171)(1:199)|173|174|(2:187|188)(1:176)|177|178|179|(1:181)|183)(1:26)|27|28|29|(2:31|(1:33)(21:62|63|64|65|66|(3:67|68|(4:70|(4:72|73|74|(1:76)(2:77|(1:115)(5:(1:80)(1:114)|81|82|83|(2:110|111)(4:85|86|87|(1:90)(1:89)))))|118|(0)(0))(1:119))|112|91|92|93|94|(1:98)|99|38|(1:40)(1:61)|41|(4:54|55|(1:57)|58)|43|(4:47|48|49|(1:51))|45|46))|139|94|(2:96|98)|99|38|(0)(0)|41|(0)|43|(0)|45|46)|22|23|24|(0)(0)|27|28|29|(0)|139|94|(0)|99|38|(0)(0)|41|(0)|43|(0)|45|46) */
    /* JADX WARN: Can't wrap try/catch for region: R(26:15|16|17|18|19|(1:21)(21:213|(1:215)|23|24|(22:144|145|147|148|(1:207)(2:152|153)|154|155|156|(1:158)(1:202)|159|160|161|(1:163)(1:200)|(3:165|(4:167|168|169|170)(1:198)|171)(1:199)|173|174|(2:187|188)(1:176)|177|178|179|(1:181)|183)(1:26)|27|28|29|(2:31|(1:33)(21:62|63|64|65|66|(3:67|68|(4:70|(4:72|73|74|(1:76)(2:77|(1:115)(5:(1:80)(1:114)|81|82|83|(2:110|111)(4:85|86|87|(1:90)(1:89)))))|118|(0)(0))(1:119))|112|91|92|93|94|(1:98)|99|38|(1:40)(1:61)|41|(4:54|55|(1:57)|58)|43|(4:47|48|49|(1:51))|45|46))|139|94|(2:96|98)|99|38|(0)(0)|41|(0)|43|(0)|45|46)|22|23|24|(0)(0)|27|28|29|(0)|139|94|(0)|99|38|(0)(0)|41|(0)|43|(0)|45|46) */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x027f, code lost:
    
        r1 = r22;
        r7 = r7;
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x029e, code lost:
    
        r10 = r21;
        r7 = r24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:115:0x025e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x01e1 A[Catch: all -> 0x01c2, TRY_LEAVE, TryCatch #21 {all -> 0x01c2, blocks: (B:178:0x01ba, B:179:0x01c7, B:181:0x01e1), top: B:177:0x01ba }] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x018e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x045c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x03fa A[Catch: all -> 0x044d, TryCatch #31 {all -> 0x044d, blocks: (B:314:0x03d7, B:287:0x03e7, B:289:0x03fa, B:291:0x0403, B:292:0x0407, B:294:0x040d, B:296:0x0425, B:330:0x03e1, B:331:0x03e4, B:348:0x0449, B:349:0x044c, B:278:0x03a0, B:343:0x0446), top: B:313:0x03d7, inners: #24, #26 }] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0403 A[Catch: all -> 0x044d, TryCatch #31 {all -> 0x044d, blocks: (B:314:0x03d7, B:287:0x03e7, B:289:0x03fa, B:291:0x0403, B:292:0x0407, B:294:0x040d, B:296:0x0425, B:330:0x03e1, B:331:0x03e4, B:348:0x0449, B:349:0x044c, B:278:0x03a0, B:343:0x0446), top: B:313:0x03d7, inners: #24, #26 }] */
    /* JADX WARN: Removed duplicated region for block: B:294:0x040d A[Catch: all -> 0x044d, TryCatch #31 {all -> 0x044d, blocks: (B:314:0x03d7, B:287:0x03e7, B:289:0x03fa, B:291:0x0403, B:292:0x0407, B:294:0x040d, B:296:0x0425, B:330:0x03e1, B:331:0x03e4, B:348:0x0449, B:349:0x044c, B:278:0x03a0, B:343:0x0446), top: B:313:0x03d7, inners: #24, #26 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0201 A[Catch: all -> 0x029e, TRY_LEAVE, TryCatch #38 {all -> 0x029e, blocks: (B:28:0x01f7, B:31:0x0201), top: B:27:0x01f7 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02ad A[Catch: all -> 0x027f, TryCatch #17 {all -> 0x027f, blocks: (B:93:0x027b, B:94:0x02a3, B:96:0x02ad, B:98:0x02b3, B:130:0x029a, B:131:0x029d, B:126:0x0297), top: B:29:0x01ff, inners: #35 }] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v15, types: [android.graphics.BitmapFactory$Options] */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v30, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v41 */
    /* JADX WARN: Type inference failed for: r10v42, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v48 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v50 */
    /* JADX WARN: Type inference failed for: r10v51 */
    /* JADX WARN: Type inference failed for: r10v52 */
    /* JADX WARN: Type inference failed for: r10v57, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v63 */
    /* JADX WARN: Type inference failed for: r10v64 */
    /* JADX WARN: Type inference failed for: r10v67 */
    /* JADX WARN: Type inference failed for: r7v50 */
    /* JADX WARN: Type inference failed for: r7v51 */
    /* JADX WARN: Type inference failed for: r7v52 */
    /* JADX WARN: Type inference failed for: r7v53 */
    /* JADX WARN: Type inference failed for: r7v56 */
    /* JADX WARN: Type inference failed for: r7v57 */
    /* JADX WARN: Type inference failed for: r7v58, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r7v59 */
    /* JADX WARN: Type inference failed for: r7v60 */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.util.ArrayList] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        ?? r10;
        byte[] bArr;
        BitmapFactory.Options options;
        int i2;
        int i3;
        int max;
        Matrix matrix;
        Bitmap bitmap;
        int i4;
        InputStream openInputStream;
        File file;
        Uri uri;
        i.e eVar;
        Object obj;
        Uri uri2;
        File file2;
        byte[] bArr2;
        ArrayList arrayList;
        File file3;
        i.d dVar;
        boolean z;
        Uri uri3;
        File file4;
        long l1;
        int length;
        MediaMetadataRetriever mediaMetadataRetriever;
        File file5;
        Uri uri4;
        Object obj2;
        byte[] bArr3;
        Uri uri5;
        Object obj3;
        int i5;
        long j2;
        Integer C;
        ?? r7;
        ?? r102;
        File file6;
        ?? r103;
        Throwable th;
        byte[] copyOf;
        int i6 = 6;
        Object obj4 = this.f564e;
        Object obj5 = this.f565f;
        switch (this.f560a) {
            case 0:
                C0000a c0000a = (C0000a) obj4;
                int i7 = c0000a.f400a;
                C0006b1 c0006b1 = this.f561b;
                if (i7 == 401) {
                    c0006b1.f417d.a();
                    return;
                }
                boolean b2 = c0000a.b();
                long j3 = this.f562c;
                if (!b2) {
                    if (c0000a.f400a == 0) {
                        c0006b1.d1(j3, (JSONObject) obj5, this.f563d);
                        c0006b1.K0(1);
                        return;
                    } else {
                        c0006b1.z0(j3);
                        c0006b1.f416c.a(C0006b1.E(c0000a));
                        return;
                    }
                }
                c0006b1.R0.remove(Long.valueOf(j3));
                c.h.G(c0006b1.D, new P(j3, 0));
                JSONObject c2 = c0000a.c();
                JSONObject optJSONObject = c2 != null ? c2.optJSONObject("msg") : null;
                if (optJSONObject != null) {
                    c0006b1.b(new JSONArray().put(optJSONObject));
                }
                c0006b1.w0();
                c0006b1.x0(true);
                return;
            case 1:
                List list = (List) obj5;
                ArrayList arrayList2 = new ArrayList();
                i.g gVar = new i.g();
                gVar.f850b = "";
                Iterator it = ((List) obj4).iterator();
                int i8 = 0;
                while (true) {
                    boolean hasNext = it.hasNext();
                    C0006b1 c0006b12 = this.f561b;
                    if (!hasNext) {
                        c0006b12.f414a.runOnUiThread(new RunnableC0040k(arrayList2, c0006b12, this.f562c, this.f563d, gVar));
                        return;
                    }
                    int i9 = i8 + 1;
                    Uri uri6 = (Uri) it.next();
                    Activity activity = c0006b12.f414a;
                    try {
                        options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        InputStream openInputStream2 = activity.getContentResolver().openInputStream(uri6);
                        if (openInputStream2 != null) {
                            try {
                                BitmapFactory.decodeStream(openInputStream2, null, options);
                                try {
                                    AbstractC0008c.a(openInputStream2, null);
                                } catch (Throwable unused) {
                                    r10 = 0;
                                    bArr = r10;
                                    if (bArr != null) {
                                    }
                                    i8 = i9;
                                }
                            } catch (Throwable th2) {
                                try {
                                    throw th2;
                                    break;
                                } catch (Throwable th3) {
                                    AbstractC0008c.a(openInputStream2, th2);
                                    throw th3;
                                    break;
                                }
                            }
                        }
                        i2 = 1;
                    } catch (Throwable unused2) {
                        r10 = 0;
                    }
                    while (true) {
                        int i10 = i2 * 2;
                        if (options.outWidth / i10 >= 1280 || options.outHeight / i10 >= 1280) {
                            i2 = i10;
                        } else {
                            r10 = new BitmapFactory.Options();
                            ((BitmapFactory.Options) r10).inSampleSize = i2;
                            InputStream openInputStream3 = activity.getContentResolver().openInputStream(uri6);
                            if (openInputStream3 != null) {
                                try {
                                    Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream3, null, r10);
                                    try {
                                        AbstractC0008c.a(openInputStream3, null);
                                    } catch (Throwable unused3) {
                                        r10 = 0;
                                    }
                                    if (decodeStream != null) {
                                        try {
                                            openInputStream = activity.getContentResolver().openInputStream(uri6);
                                        } catch (Exception unused4) {
                                        }
                                        if (openInputStream != null) {
                                            try {
                                                int attributeInt = new ExifInterface(openInputStream).getAttributeInt("Orientation", 1);
                                                i3 = attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : 270 : 90 : 180;
                                                r10 = 0;
                                                try {
                                                    try {
                                                        AbstractC0008c.a(openInputStream, null);
                                                    } catch (Exception unused5) {
                                                    }
                                                    max = Math.max(decodeStream.getWidth(), decodeStream.getHeight());
                                                    matrix = new Matrix();
                                                    if (max > 1280) {
                                                        float f2 = 1280.0f / max;
                                                        matrix.postScale(f2, f2);
                                                    }
                                                    if (i3 != 0) {
                                                        matrix.postRotate(i3);
                                                    }
                                                    if (!matrix.isIdentity()) {
                                                        decodeStream = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), matrix, true);
                                                    }
                                                    bitmap = decodeStream;
                                                    while (true) {
                                                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                        bitmap.compress(Bitmap.CompressFormat.JPEG, i4, byteArrayOutputStream);
                                                        bArr = byteArrayOutputStream.toByteArray();
                                                        i4 = (bArr.length <= 1300000 && i4 > 35) ? i4 - 15 : 78;
                                                    }
                                                } catch (Throwable unused6) {
                                                }
                                                if (bArr != null) {
                                                    gVar.f850b = "Could not read the photo";
                                                } else {
                                                    try {
                                                        File file7 = z2.f758a;
                                                        g.m.K(z2.c((String) list.get(i8)), bArr);
                                                    } catch (Exception unused7) {
                                                    }
                                                    c0006b12.f414a.runOnUiThread(new RunnableC0048m(c0006b12, i6));
                                                    b.b j1 = C0006b1.j1("image", bArr);
                                                    Object obj6 = j1.f764a;
                                                    if (((CharSequence) obj6).length() > 0) {
                                                        try {
                                                            File file8 = z2.f758a;
                                                            g.m.K(z2.c((String) obj6), bArr);
                                                        } catch (Exception unused8) {
                                                        }
                                                        arrayList2.add(obj6);
                                                    } else {
                                                        gVar.f850b = j1.f765b;
                                                    }
                                                }
                                                i8 = i9;
                                            } catch (Throwable th4) {
                                                try {
                                                    throw th4;
                                                    break;
                                                } catch (Throwable th5) {
                                                    try {
                                                        AbstractC0008c.a(openInputStream, th4);
                                                        throw th5;
                                                        break;
                                                    } catch (Exception unused9) {
                                                    }
                                                }
                                            }
                                        }
                                        i3 = 0;
                                        max = Math.max(decodeStream.getWidth(), decodeStream.getHeight());
                                        matrix = new Matrix();
                                        if (max > 1280) {
                                        }
                                        if (i3 != 0) {
                                        }
                                        if (!matrix.isIdentity()) {
                                        }
                                        bitmap = decodeStream;
                                        while (true) {
                                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                            bitmap.compress(Bitmap.CompressFormat.JPEG, i4, byteArrayOutputStream2);
                                            bArr = byteArrayOutputStream2.toByteArray();
                                            if (bArr.length <= 1300000) {
                                            }
                                        }
                                        if (bArr != null) {
                                        }
                                        i8 = i9;
                                    }
                                } catch (Throwable th6) {
                                    r10 = 0;
                                    try {
                                        throw th6;
                                        break;
                                    } catch (Throwable th7) {
                                        AbstractC0008c.a(openInputStream3, th6);
                                        throw th7;
                                        break;
                                    }
                                }
                            }
                            r10 = 0;
                            bArr = r10;
                            if (bArr != null) {
                            }
                            i8 = i9;
                        }
                    }
                }
                break;
            case 2:
                final C0006b1 c0006b13 = this.f561b;
                Uri uri7 = (Uri) obj4;
                String str = (String) obj5;
                final long j4 = this.f562c;
                i.g gVar2 = new i.g();
                gVar2.f850b = "";
                i.e eVar2 = new i.e();
                i.g gVar3 = new i.g();
                gVar3.f850b = "";
                ?? arrayList3 = new ArrayList();
                byte[] bArr4 = new byte[0];
                File file9 = new File(z2.d(), "v_up_" + System.currentTimeMillis());
                try {
                    l1 = c0006b13.l1(uri7);
                    try {
                    } catch (Throwable unused10) {
                        file2 = file9;
                        uri2 = arrayList3;
                        obj = "Could not send the video";
                        eVar = eVar2;
                    }
                } catch (Throwable unused11) {
                    file = file9;
                    uri = arrayList3;
                    eVar = eVar2;
                }
                if (l1 > 0) {
                    if (l1 > 104857600) {
                        gVar2.f850b = "Video too large (max 100 MB)";
                    }
                    length = ((CharSequence) gVar2.f850b).length();
                    Activity activity2 = c0006b13.f414a;
                    if (length != 0) {
                        try {
                            mediaMetadataRetriever = new MediaMetadataRetriever();
                            try {
                                mediaMetadataRetriever.setDataSource(activity2, uri7);
                                String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                                if (extractMetadata == null || (C = m.l.C(extractMetadata)) == null) {
                                    eVar = eVar2;
                                    i5 = 0;
                                } else {
                                    i5 = C.intValue();
                                    eVar = eVar2;
                                }
                            } catch (Throwable unused12) {
                                file5 = file9;
                                uri4 = arrayList3;
                                eVar = eVar2;
                            }
                        } catch (Throwable unused13) {
                            eVar = eVar2;
                            file = file9;
                            uri = arrayList3;
                            obj = "Could not send the video";
                            file2 = file;
                            uri2 = uri;
                            bArr2 = bArr4;
                            file4 = file2;
                            uri3 = uri2;
                            gVar2.f850b = obj;
                            file3 = file4;
                            arrayList = uri3;
                            dVar = new i.d();
                            if (((CharSequence) gVar2.f850b).length() == 0) {
                            }
                            dVar.f846a = z;
                            if (z) {
                            }
                            if (!dVar.f846a) {
                            }
                            c0006b13.f414a.runOnUiThread(new RunnableC0025g0(dVar, c0006b13, j4, gVar3, arrayList, eVar, this.f563d, gVar2));
                            return;
                        }
                        try {
                            eVar.f847a = i5;
                            obj2 = "Could not send the video";
                            if (i5 > 2500) {
                                uri4 = arrayList3;
                                j2 = 1000000;
                            } else {
                                uri4 = arrayList3;
                                j2 = 0;
                            }
                            try {
                                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(j2, 2);
                                if (frameAtTime == null) {
                                    frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                                }
                                if (frameAtTime != null) {
                                    int max2 = Math.max(frameAtTime.getWidth(), frameAtTime.getHeight());
                                    if (max2 > 720) {
                                        float f3 = 720.0f / max2;
                                        file5 = file9;
                                        try {
                                            frameAtTime = Bitmap.createScaledBitmap(frameAtTime, Math.max(1, (int) (frameAtTime.getWidth() * f3)), Math.max(1, (int) (frameAtTime.getHeight() * f3)), true);
                                        } catch (Throwable unused14) {
                                            try {
                                                mediaMetadataRetriever.release();
                                            } catch (Throwable unused15) {
                                            }
                                            bArr3 = null;
                                            if (bArr3 == null) {
                                            }
                                            try {
                                                g.m.K(z2.c(str), bArr2);
                                                final int i11 = eVar.f847a;
                                                Runnable runnable = new Runnable() { // from class: a.f0
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        Object obj7;
                                                        C0006b1 c0006b14 = c0006b13;
                                                        Iterator it2 = c0006b14.D.iterator();
                                                        while (true) {
                                                            if (!it2.hasNext()) {
                                                                obj7 = null;
                                                                break;
                                                            } else {
                                                                obj7 = it2.next();
                                                                if (((K0) obj7).f150a == j4) {
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        K0 k0 = (K0) obj7;
                                                        if (k0 != null) {
                                                            k0.f156g = i11;
                                                        }
                                                        O0 o0 = c0006b14.j0;
                                                        if (o0 != null) {
                                                            o0.notifyDataSetChanged();
                                                        } else {
                                                            i.b.g("adapter");
                                                            throw null;
                                                        }
                                                    }
                                                };
                                                activity2.runOnUiThread(runnable);
                                                b.b j12 = C0006b1.j1("image", bArr2);
                                                obj3 = j12.f764a;
                                                gVar3.f850b = obj3;
                                                if (((CharSequence) obj3).length() == 0) {
                                                }
                                                bArr4 = bArr2;
                                                r7 = runnable;
                                                if (((CharSequence) gVar2.f850b).length() == 0) {
                                                }
                                                r102 = uri4;
                                                file6 = file5;
                                                if (((CharSequence) gVar2.f850b).length() == 0) {
                                                }
                                                obj = obj2;
                                                bArr2 = bArr4;
                                                file3 = file6;
                                                arrayList = r102;
                                            } catch (Throwable unused16) {
                                                uri5 = uri4;
                                                obj = obj2;
                                                file4 = file5;
                                                uri3 = uri5;
                                                gVar2.f850b = obj;
                                                file3 = file4;
                                                arrayList = uri3;
                                                dVar = new i.d();
                                                if (((CharSequence) gVar2.f850b).length() == 0) {
                                                }
                                                dVar.f846a = z;
                                                if (z) {
                                                }
                                                if (!dVar.f846a) {
                                                }
                                                c0006b13.f414a.runOnUiThread(new RunnableC0025g0(dVar, c0006b13, j4, gVar3, arrayList, eVar, this.f563d, gVar2));
                                                return;
                                            }
                                            dVar = new i.d();
                                            if (((CharSequence) gVar2.f850b).length() == 0) {
                                            }
                                            dVar.f846a = z;
                                            if (z) {
                                            }
                                            if (!dVar.f846a) {
                                            }
                                            c0006b13.f414a.runOnUiThread(new RunnableC0025g0(dVar, c0006b13, j4, gVar3, arrayList, eVar, this.f563d, gVar2));
                                            return;
                                        }
                                    } else {
                                        file5 = file9;
                                    }
                                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                                    frameAtTime.compress(Bitmap.CompressFormat.JPEG, 78, byteArrayOutputStream3);
                                    bArr3 = byteArrayOutputStream3.toByteArray();
                                } else {
                                    file5 = file9;
                                    bArr3 = null;
                                }
                                try {
                                    mediaMetadataRetriever.release();
                                } catch (Throwable unused17) {
                                }
                            } catch (Throwable unused18) {
                                file5 = file9;
                            }
                        } catch (Throwable unused19) {
                            file5 = file9;
                            uri4 = arrayList3;
                            obj2 = "Could not send the video";
                            mediaMetadataRetriever.release();
                            bArr3 = null;
                            if (bArr3 == null) {
                            }
                            g.m.K(z2.c(str), bArr2);
                            final int i112 = eVar.f847a;
                            Runnable runnable2 = new Runnable() { // from class: a.f0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    Object obj7;
                                    C0006b1 c0006b14 = c0006b13;
                                    Iterator it2 = c0006b14.D.iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            obj7 = null;
                                            break;
                                        } else {
                                            obj7 = it2.next();
                                            if (((K0) obj7).f150a == j4) {
                                                break;
                                            }
                                        }
                                    }
                                    K0 k0 = (K0) obj7;
                                    if (k0 != null) {
                                        k0.f156g = i112;
                                    }
                                    O0 o0 = c0006b14.j0;
                                    if (o0 != null) {
                                        o0.notifyDataSetChanged();
                                    } else {
                                        i.b.g("adapter");
                                        throw null;
                                    }
                                }
                            };
                            activity2.runOnUiThread(runnable2);
                            b.b j122 = C0006b1.j1("image", bArr2);
                            obj3 = j122.f764a;
                            gVar3.f850b = obj3;
                            if (((CharSequence) obj3).length() == 0) {
                            }
                            bArr4 = bArr2;
                            r7 = runnable2;
                            if (((CharSequence) gVar2.f850b).length() == 0) {
                            }
                            r102 = uri4;
                            file6 = file5;
                            if (((CharSequence) gVar2.f850b).length() == 0) {
                            }
                            obj = obj2;
                            bArr2 = bArr4;
                            file3 = file6;
                            arrayList = r102;
                            dVar = new i.d();
                            if (((CharSequence) gVar2.f850b).length() == 0) {
                            }
                            dVar.f846a = z;
                            if (z) {
                            }
                            if (!dVar.f846a) {
                            }
                            c0006b13.f414a.runOnUiThread(new RunnableC0025g0(dVar, c0006b13, j4, gVar3, arrayList, eVar, this.f563d, gVar2));
                            return;
                        }
                        if (bArr3 == null) {
                            try {
                                Bitmap createBitmap = Bitmap.createBitmap(320, 180, Bitmap.Config.ARGB_8888);
                                createBitmap.eraseColor(-14671580);
                                ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                                createBitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream4);
                                bArr2 = byteArrayOutputStream4.toByteArray();
                            } catch (Throwable unused20) {
                                uri5 = uri4;
                                obj = obj2;
                                bArr2 = bArr4;
                                file4 = file5;
                                uri3 = uri5;
                                gVar2.f850b = obj;
                                file3 = file4;
                                arrayList = uri3;
                                dVar = new i.d();
                                if (((CharSequence) gVar2.f850b).length() == 0) {
                                }
                                dVar.f846a = z;
                                if (z) {
                                }
                                if (!dVar.f846a) {
                                }
                                c0006b13.f414a.runOnUiThread(new RunnableC0025g0(dVar, c0006b13, j4, gVar3, arrayList, eVar, this.f563d, gVar2));
                                return;
                            }
                        } else {
                            bArr2 = bArr3;
                        }
                        try {
                            g.m.K(z2.c(str), bArr2);
                        } catch (Exception unused21) {
                        }
                        final int i1122 = eVar.f847a;
                        Runnable runnable22 = new Runnable() { // from class: a.f0
                            @Override // java.lang.Runnable
                            public final void run() {
                                Object obj7;
                                C0006b1 c0006b14 = c0006b13;
                                Iterator it2 = c0006b14.D.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        obj7 = null;
                                        break;
                                    } else {
                                        obj7 = it2.next();
                                        if (((K0) obj7).f150a == j4) {
                                            break;
                                        }
                                    }
                                }
                                K0 k0 = (K0) obj7;
                                if (k0 != null) {
                                    k0.f156g = i1122;
                                }
                                O0 o0 = c0006b14.j0;
                                if (o0 != null) {
                                    o0.notifyDataSetChanged();
                                } else {
                                    i.b.g("adapter");
                                    throw null;
                                }
                            }
                        };
                        activity2.runOnUiThread(runnable22);
                        b.b j1222 = C0006b1.j1("image", bArr2);
                        obj3 = j1222.f764a;
                        gVar3.f850b = obj3;
                        if (((CharSequence) obj3).length() == 0) {
                            gVar2.f850b = j1222.f765b;
                        }
                        bArr4 = bArr2;
                        r7 = runnable22;
                    } else {
                        file5 = file9;
                        uri4 = arrayList3;
                        eVar = eVar2;
                        obj2 = "Could not send the video";
                        r7 = eVar2;
                    }
                    if (((CharSequence) gVar2.f850b).length() == 0) {
                        byte[] bArr5 = new byte[12582912];
                        InputStream openInputStream4 = activity2.getContentResolver().openInputStream(uri7);
                        if (openInputStream4 == null) {
                            gVar2.f850b = "Could not read the video";
                        } else {
                            try {
                                r7 = file5;
                                try {
                                    FileOutputStream fileOutputStream = new FileOutputStream((File) r7);
                                    uri7 = uri7;
                                    while (true) {
                                        try {
                                            try {
                                                if (((CharSequence) gVar2.f850b).length() == 0) {
                                                    int i12 = 0;
                                                    while (i12 < 12582912) {
                                                        try {
                                                            int read = openInputStream4.read(bArr5, i12, 12582912 - i12);
                                                            if (read >= 0) {
                                                                i12 += read;
                                                            } else if (i12 > 0) {
                                                                if (i12 == 12582912) {
                                                                    copyOf = bArr5;
                                                                } else {
                                                                    copyOf = Arrays.copyOf(bArr5, i12);
                                                                    i.b.d(copyOf, "copyOf(...)");
                                                                }
                                                                b.b j13 = C0006b1.j1("video", copyOf);
                                                                Object obj7 = j13.f764a;
                                                                if (((CharSequence) obj7).length() == 0) {
                                                                    gVar2.f850b = j13.f765b;
                                                                } else {
                                                                    r103 = uri4;
                                                                    try {
                                                                        r103.add(obj7);
                                                                        fileOutputStream.write(bArr5, 0, i12);
                                                                        if (i12 >= 12582912) {
                                                                            uri4 = r103;
                                                                            uri7 = r103;
                                                                        }
                                                                    } catch (Throwable th8) {
                                                                        th = th8;
                                                                        th = th;
                                                                        uri7 = r103;
                                                                        try {
                                                                            throw th;
                                                                        } catch (Throwable th9) {
                                                                            AbstractC0008c.a(fileOutputStream, th);
                                                                            throw th9;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        } catch (Throwable th10) {
                                                            th = th10;
                                                            uri7 = uri4;
                                                            throw th;
                                                        }
                                                    }
                                                    if (i12 > 0) {
                                                    }
                                                }
                                            } catch (Throwable th11) {
                                                th = th11;
                                                r103 = uri4;
                                            }
                                        } catch (Throwable th12) {
                                            th = th12;
                                            Throwable th13 = th;
                                            try {
                                                throw th13;
                                            } catch (Throwable th14) {
                                                AbstractC0008c.a(openInputStream4, th13);
                                                throw th14;
                                            }
                                        }
                                    }
                                    r103 = uri4;
                                    AbstractC0008c.a(fileOutputStream, null);
                                    AbstractC0008c.a(openInputStream4, null);
                                    file6 = r7;
                                    r102 = r103;
                                    if (((CharSequence) gVar2.f850b).length() == 0 && r102.isEmpty()) {
                                        gVar2.f850b = "Could not read the video";
                                    }
                                    obj = obj2;
                                    bArr2 = bArr4;
                                    file3 = file6;
                                    arrayList = r102;
                                    dVar = new i.d();
                                    z = ((CharSequence) gVar2.f850b).length() == 0;
                                    dVar.f846a = z;
                                    if (z) {
                                        try {
                                            File file10 = z2.f758a;
                                            if (!file3.renameTo(z2.g((String) arrayList.get(0)))) {
                                                dVar.f846a = false;
                                            }
                                            g.m.K(z2.c((String) gVar3.f850b), bArr2);
                                        } catch (Exception unused22) {
                                        }
                                    }
                                    if (!dVar.f846a) {
                                        try {
                                            file3.delete();
                                        } catch (Exception unused23) {
                                        }
                                        if (((CharSequence) gVar2.f850b).length() == 0) {
                                            gVar2.f850b = obj;
                                        }
                                    }
                                    c0006b13.f414a.runOnUiThread(new RunnableC0025g0(dVar, c0006b13, j4, gVar3, arrayList, eVar, this.f563d, gVar2));
                                    return;
                                } catch (Throwable th15) {
                                    th = th15;
                                    uri7 = uri4;
                                }
                            } catch (Throwable th16) {
                                th = th16;
                                uri7 = uri4;
                                r7 = file5;
                            }
                        }
                    }
                    r102 = uri4;
                    file6 = file5;
                    if (((CharSequence) gVar2.f850b).length() == 0) {
                        gVar2.f850b = "Could not read the video";
                    }
                    obj = obj2;
                    bArr2 = bArr4;
                    file3 = file6;
                    arrayList = r102;
                    dVar = new i.d();
                    if (((CharSequence) gVar2.f850b).length() == 0) {
                    }
                    dVar.f846a = z;
                    if (z) {
                    }
                    if (!dVar.f846a) {
                    }
                    c0006b13.f414a.runOnUiThread(new RunnableC0025g0(dVar, c0006b13, j4, gVar3, arrayList, eVar, this.f563d, gVar2));
                    return;
                }
                gVar2.f850b = "Could not read the video";
                length = ((CharSequence) gVar2.f850b).length();
                Activity activity22 = c0006b13.f414a;
                if (length != 0) {
                }
                if (((CharSequence) gVar2.f850b).length() == 0) {
                }
                r102 = uri4;
                file6 = file5;
                if (((CharSequence) gVar2.f850b).length() == 0) {
                }
                obj = obj2;
                bArr2 = bArr4;
                file3 = file6;
                arrayList = r102;
                dVar = new i.d();
                if (((CharSequence) gVar2.f850b).length() == 0) {
                }
                dVar.f846a = z;
                if (z) {
                }
                if (!dVar.f846a) {
                }
                c0006b13.f414a.runOnUiThread(new RunnableC0025g0(dVar, c0006b13, j4, gVar3, arrayList, eVar, this.f563d, gVar2));
                return;
            case 3:
                ArrayList arrayList4 = (ArrayList) obj4;
                boolean z2 = !arrayList4.isEmpty();
                C0006b1 c0006b14 = this.f561b;
                long j5 = this.f562c;
                if (z2) {
                    c0006b14.E0(j5, "image", arrayList4, 0, this.f563d, c.j.f773a);
                } else {
                    c0006b14.z0(j5);
                }
                i.g gVar4 = (i.g) obj5;
                if (((CharSequence) gVar4.f850b).length() > 0) {
                    c0006b14.f416c.a(gVar4.f850b);
                    return;
                }
                return;
            default:
                JSONObject jSONObject = (JSONObject) obj5;
                C0000a d2 = C0004b.f409a.d(jSONObject);
                C0006b1 c0006b15 = this.f561b;
                c0006b15.f414a.runOnUiThread(new O(d2, c0006b15, this.f562c, jSONObject, this.f563d, (h.a) obj4, 0));
                return;
        }
    }

    public /* synthetic */ RunnableC0040k(C0006b1 c0006b1, Uri uri, String str, long j2, K0 k0) {
        this.f561b = c0006b1;
        this.f564e = uri;
        this.f565f = str;
        this.f562c = j2;
        this.f563d = k0;
    }

    public /* synthetic */ RunnableC0040k(ArrayList arrayList, C0006b1 c0006b1, long j2, K0 k0, i.g gVar) {
        this.f564e = arrayList;
        this.f561b = c0006b1;
        this.f562c = j2;
        this.f563d = k0;
        this.f565f = gVar;
    }

    public /* synthetic */ RunnableC0040k(List list, C0006b1 c0006b1, ArrayList arrayList, long j2, K0 k0) {
        this.f564e = list;
        this.f561b = c0006b1;
        this.f565f = arrayList;
        this.f562c = j2;
        this.f563d = k0;
    }

    public /* synthetic */ RunnableC0040k(JSONObject jSONObject, C0006b1 c0006b1, long j2, K0 k0, h.a aVar) {
        this.f565f = jSONObject;
        this.f561b = c0006b1;
        this.f562c = j2;
        this.f563d = k0;
        this.f564e = aVar;
    }
}
