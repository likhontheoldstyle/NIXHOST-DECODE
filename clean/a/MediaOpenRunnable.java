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

public final class MediaOpenRunnable implements Runnable {

    public final int mode;

    public final Object first;

    public final Object second;

    public final Object third;

    public final Object fourth;

    public final View targetView;

    public MediaOpenRunnable(Object obj, Object obj2, Object obj3, Object obj4, View view, int i2) {
        this.mode = i2;
        this.first = obj;
        this.second = obj2;
        this.third = obj3;
        this.fourth = obj4;
        this.targetView = view;
    }

    @Override
    public final void run() {
        BitmapFactory.Options options;
        InputStream openInputStream;
        int i2;
        switch (this.mode) {
            case 0:
                Dialog dialog = (Dialog) this.first;
                if (dialog.isShowing()) {
                    File file = (File) this.second;
                    if (file == null) {
                        ((ChatScreen) this.third).toaster.a("Video expired");
                        dialog.dismiss();
                        return;
                    } else {
                        ((i.g) this.fourth).f850b = file;
                        ((VideoView) this.targetView).setVideoPath(file.getPath());
                        return;
                    }
                }
                return;
            case 1:
                Uri uri = ((MediaItem) this.second).uri;
                MediaPicker mediaPicker = (MediaPicker) this.first;
                Activity activity = mediaPicker.activity;
                Bitmap bitmap = null;
                try {
                    options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    openInputStream = activity.getContentResolver().openInputStream(uri);
                    if (openInputStream != null) {
                        try {
                            BitmapFactory.decodeStream(openInputStream, null, options);
                            AppState.a(openInputStream, null);
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
                                AppState.a(openInputStream, null);
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
                                                AppState.a(openInputStream, null);
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
                        mediaPicker.mainHandler.post(new MediaOpenRunnable(mediaPicker, (FrameLayout) this.third, (ProgressBar) this.fourth, bitmap, (FrameLayout) this.targetView, 2));
                        return;
                    }
                    i2 = i3;
                }
            default:
                MediaPicker mediaPicker2 = (MediaPicker) this.first;
                if (mediaPicker2.D != ((FrameLayout) this.second)) {
                    return;
                }
                ((ProgressBar) this.third).setVisibility(8);
                Bitmap bitmap2 = (Bitmap) this.fourth;
                if (bitmap2 == null) {
                    Toast.makeText(mediaPicker2.activity, "Could not open the photo", 0).show();
                    return;
                }
                ImageEditorView imageEditorView = new ImageEditorView(mediaPicker2, bitmap2);
                imageEditorView.drawMode = mediaPicker2.H;
                imageEditorView.brushColor = mediaPicker2.I;
                imageEditorView.onTextTap = new TextInputAction(mediaPicker2, imageEditorView, 1);
                mediaPicker2.F = imageEditorView;
                ((FrameLayout) this.targetView).addView(imageEditorView, new FrameLayout.LayoutParams(-1, -1));
                return;
        }
    }
}
