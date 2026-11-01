package a;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes.dex */
public final /* synthetic */ class T implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f312a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f313b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f314c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f315d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f316e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ View f317f;

    public /* synthetic */ T(Object obj, Object obj2, Object obj3, Object obj4, View view, int i2) {
        this.f312a = i2;
        this.f313b = obj;
        this.f314c = obj2;
        this.f315d = obj3;
        this.f316e = obj4;
        this.f317f = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BitmapFactory.Options options;
        InputStream openInputStream;
        int i2;
        switch (this.f312a) {
            case 0:
                Dialog dialog = (Dialog) this.f313b;
                if (dialog.isShowing()) {
                    File file = (File) this.f314c;
                    if (file == null) {
                        ((C0006b1) this.f315d).f416c.a("Video expired");
                        dialog.dismiss();
                        return;
                    } else {
                        ((i.g) this.f316e).f850b = file;
                        ((VideoView) this.f317f).setVideoPath(file.getPath());
                        return;
                    }
                }
                return;
            case 1:
                Uri uri = ((C0094z1) this.f314c).f752a;
                B1 b1 = (B1) this.f313b;
                Activity activity = b1.f26a;
                Bitmap bitmap = null;
                try {
                    options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    openInputStream = activity.getContentResolver().openInputStream(uri);
                    if (openInputStream != null) {
                        try {
                            BitmapFactory.decodeStream(openInputStream, null, options);
                            AbstractC0008c.a(openInputStream, null);
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    }
                    i2 = 1;
                } catch (Throwable unused) {
                }
                while (true) {
                    int i3 = i2 * 2;
                    if (options.outWidth / i3 < 1600 && options.outHeight / i3 < 1600) {
                        BitmapFactory.Options options2 = new BitmapFactory.Options();
                        options2.inSampleSize = i2;
                        openInputStream = activity.getContentResolver().openInputStream(uri);
                        if (openInputStream != null) {
                            try {
                                Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream, null, options2);
                                AbstractC0008c.a(openInputStream, null);
                                if (decodeStream != null) {
                                    int i4 = 0;
                                    try {
                                        openInputStream = activity.getContentResolver().openInputStream(uri);
                                        if (openInputStream != null) {
                                            try {
                                                int attributeInt = new ExifInterface(openInputStream).getAttributeInt("Orientation", 1);
                                                if (attributeInt == 3) {
                                                    i4 = 180;
                                                } else if (attributeInt == 6) {
                                                    i4 = 90;
                                                } else if (attributeInt == 8) {
                                                    i4 = 270;
                                                }
                                                AbstractC0008c.a(openInputStream, null);
                                            } catch (Throwable th) {
                                                try {
                                                    throw th;
                                                } finally {
                                                }
                                            }
                                        }
                                    } catch (Exception unused2) {
                                    }
                                    if (i4 != 0) {
                                        Matrix matrix = new Matrix();
                                        matrix.postRotate(i4);
                                        bitmap = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), matrix, true);
                                    } else {
                                        bitmap = decodeStream;
                                    }
                                }
                            } finally {
                            }
                        }
                        b1.f34i.post(new T(b1, (FrameLayout) this.f315d, (ProgressBar) this.f316e, bitmap, (FrameLayout) this.f317f, 2));
                        return;
                    }
                    i2 = i3;
                }
                break;
            default:
                B1 b12 = (B1) this.f313b;
                if (b12.D != ((FrameLayout) this.f314c)) {
                    return;
                }
                ((ProgressBar) this.f315d).setVisibility(8);
                Bitmap bitmap2 = (Bitmap) this.f316e;
                if (bitmap2 == null) {
                    Toast.makeText(b12.f26a, "Could not open the photo", 0).show();
                    return;
                }
                C0091y1 c0091y1 = new C0091y1(b12, bitmap2);
                c0091y1.f722c = b12.H;
                c0091y1.f723d = b12.I;
                c0091y1.f724e = new C0028h(b12, c0091y1, 1);
                b12.F = c0091y1;
                ((FrameLayout) this.f317f).addView(c0091y1, new FrameLayout.LayoutParams(-1, -1));
                return;
        }
    }
}
