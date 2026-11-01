package a;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.VideoView;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public final class MediaPickerClickListener implements View.OnClickListener {

    public final int mode;

    public final MediaPicker picker;

    public MediaPickerClickListener(MediaPicker mediaPicker, int i2) {
        this.mode = i2;
        this.picker = mediaPicker;
    }

    @Override
    public final void onClick(View view) {
        final int i4 = 0;
        final int i5 = 1;
        MediaPicker mediaPicker = this.picker;
        switch (this.mode) {
            case 0:
                mediaPicker.closePreview();
                return;
            case 1:
                ImageEditorView imageEditorView = mediaPicker.editorView;
                if (imageEditorView != null) {
                    ArrayList arrayList = imageEditorView.annotations;
                    if (!arrayList.isEmpty()) {
                        arrayList.remove(arrayList.size() - 1);
                        imageEditorView.invalidate();
                        return;
                    }
                    return;
                }
                return;
            case 2:
                MediaItem mediaItem = mediaPicker.previewItem;
                if (mediaItem == null) {
                    return;
                }
                c.j jVar = c.j.f773a;
                boolean z = mediaItem.isVideo;
                Uri uri = mediaItem.uri;
                if (z) {
                    mediaPicker.closePreview();
                    mediaPicker.deliverSelection(jVar, AppState.p(uri));
                    return;
                }
                ImageEditorView imageEditorView2 = mediaPicker.editorView;
                if (imageEditorView2 != null && (!imageEditorView2.annotations.isEmpty())) {
                    File editedFile = null;
                    try {
                        Bitmap editedBitmap = imageEditorView2.bitmap.copy(Bitmap.Config.ARGB_8888, true);
                        imageEditorView2.drawAnnotations(new Canvas(editedBitmap));
                        editedFile = new File(imageEditorView2.picker.activity.getCacheDir(), "edit_" + System.currentTimeMillis() + ".jpg");
                        FileOutputStream fileOutputStream = new FileOutputStream(editedFile);
                        try {
                            editedBitmap.compress(Bitmap.CompressFormat.JPEG, 92, fileOutputStream);
                            AppState.a(fileOutputStream, null);
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                AppState.a(fileOutputStream, th);
                                throw th2;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    if (editedFile != null) {
                        uri = Uri.fromFile(editedFile);
                    }
                }
                mediaPicker.closePreview();
                mediaPicker.deliverSelection(AppState.p(uri), jVar);
                return;
            case 3:
                Dialog dialog = mediaPicker.pickerDialog;
                if (dialog == null) {
                    i.b.g("dlg");
                    throw null;
                }
                dialog.dismiss();
                mediaPicker.onCameraAction.a();
                return;
            case 4:
                final MediaPicker b1 = this.picker;
                if (b1.selectedItems.size() == 1) {
                    MediaItem mediaItem2 = (MediaItem) b1.selectedItems.get(0);
                    b1.previewItem = mediaItem2;
                    b1.drawMode = false;
                    b1.applyDialogBarColors(true);
                    Activity activity2 = b1.activity;
                    FrameLayout frameLayout = new FrameLayout(activity2);
                    frameLayout.setBackgroundColor(-16777216);
                    frameLayout.setClickable(true);
                    b1.previewRoot = frameLayout;
                    LinearLayout linearLayout = new LinearLayout(activity2);
                    linearLayout.setOrientation(1);
                    LinearLayout linearLayout2 = new LinearLayout(activity2);
                    linearLayout2.setGravity(16);
                    linearLayout2.setPadding(b1.dp(4), b1.dp(6), b1.dp(8), b1.dp(6));
                    FrameLayout frameLayout2 = new FrameLayout(activity2);
                    frameLayout2.addView(new IconView(activity2, "back", -1, 2.4f), new FrameLayout.LayoutParams(b1.dp(26), b1.dp(26), 17));
                    frameLayout2.setOnClickListener(new MediaPickerClickListener(b1, i4));
                    linearLayout2.addView(frameLayout2, new LinearLayout.LayoutParams(b1.dp(48), b1.dp(48)));
                    linearLayout2.addView(b1.makeText("Preview", 21.0f, -1, true), new LinearLayout.LayoutParams(0, -2, 1.0f));
                    if (!mediaItem2.isVideo) {
                        final FrameLayout k2 = b1.makeIconButton("pen");
                        FrameLayout k3 = b1.makeIconButton("aa");
                        FrameLayout k4 = b1.makeIconButton("undo");
                        k2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public final void onClick(View view2) {
                                switch (i4) {
                                    case 0:
                                        MediaPicker b12 = b1;
                                        boolean z2 = !b12.drawMode;
                                        b12.drawMode = z2;
                                        ImageEditorView imageEditorView3 = b12.editorView;
                                        if (imageEditorView3 != null) {
                                            imageEditorView3.drawMode = z2;
                                        }
                                        k2.setBackground(z2 ? MediaPicker.circleDrawable(1157627903) : null);
                                        break;
                                    default:
                                        MediaPicker b13 = b1;
                                        b13.drawMode = false;
                                        ImageEditorView imageEditorView4 = b13.editorView;
                                        if (imageEditorView4 != null) {
                                            imageEditorView4.drawMode = false;
                                        }
                                        k2.setBackground(null);
                                        b13.showTextOverlayDialog("", new ToastCallback(1, b13));
                                        break;
                                }
                            }
                        });
                        k3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public final void onClick(View view2) {
                                switch (i5) {
                                    case 0:
                                        MediaPicker b12 = b1;
                                        boolean z2 = !b12.drawMode;
                                        b12.drawMode = z2;
                                        ImageEditorView imageEditorView3 = b12.editorView;
                                        if (imageEditorView3 != null) {
                                            imageEditorView3.drawMode = z2;
                                        }
                                        k2.setBackground(z2 ? MediaPicker.circleDrawable(1157627903) : null);
                                        break;
                                    default:
                                        MediaPicker b13 = b1;
                                        b13.drawMode = false;
                                        ImageEditorView imageEditorView4 = b13.editorView;
                                        if (imageEditorView4 != null) {
                                            imageEditorView4.drawMode = false;
                                        }
                                        k2.setBackground(null);
                                        b13.showTextOverlayDialog("", new ToastCallback(1, b13));
                                        break;
                                }
                            }
                        });
                        k4.setOnClickListener(new MediaPickerClickListener(b1, i5));
                        linearLayout2.addView(k2, new LinearLayout.LayoutParams(b1.dp(44), b1.dp(44)));
                        linearLayout2.addView(k3, new LinearLayout.LayoutParams(b1.dp(44), b1.dp(44)));
                        linearLayout2.addView(k4, new LinearLayout.LayoutParams(b1.dp(44), b1.dp(44)));
                    }
                    linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
                    FrameLayout frameLayout3 = new FrameLayout(activity2);
                    linearLayout.addView(frameLayout3, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                    Activity activity;
                    int i2;
                    int i3;
                    if (mediaItem2.isVideo) {
                        final VideoView videoView = new VideoView(activity2);
                        b1.previewVideoView = videoView;
                        frameLayout3.addView(videoView, new FrameLayout.LayoutParams(-1, -1, 17));
                        FrameLayout frameLayout4 = new FrameLayout(activity2);
                        frameLayout4.setBackground(MediaPicker.circleDrawable(1711276032));
                        frameLayout4.setVisibility(8);
                        frameLayout4.addView(new ChatIconView(activity2, "play", -1), new FrameLayout.LayoutParams(b1.dp(34), b1.dp(34), 17));
                        frameLayout3.addView(frameLayout4, new FrameLayout.LayoutParams(b1.dp(70), b1.dp(70), 17));
                        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public final void onPrepared(MediaPlayer mediaPlayer) {
                                mediaPlayer.setLooping(true);
                                videoView.start();
                            }
                        });
                        videoView.setVideoURI(mediaItem2.uri);
                        frameLayout3.setOnClickListener(new PairClickListener(videoView, frameLayout4, 3));
                        activity = activity2;
                        i2 = 6;
                        i3 = -2;
                    } else {
                        ProgressBar progressBar = new ProgressBar(activity2);
                        frameLayout3.addView(progressBar, new FrameLayout.LayoutParams(b1.dp(34), b1.dp(34), 17));
                        i2 = 6;
                        activity = activity2;
                        new Thread(new MediaOpenRunnable(b1, mediaItem2, frameLayout, progressBar, frameLayout3, 1)).start();
                        LinearLayout linearLayout3 = new LinearLayout(activity);
                        linearLayout3.setGravity(17);
                        linearLayout3.setPadding(b1.dp(8), b1.dp(10), b1.dp(8), b1.dp(6));
                        final int[] iArr = {-1, -16777216, -50384, -27392, -10742, -13318311, -16087809, -4236558};
                        final ArrayList arrayList2 = new ArrayList();
                        int i6 = 0;
                        for (int i7 = 8; i6 < i7; i7 = 8) {
                            final int i8 = iArr[i6];
                            View view2 = new View(activity);
                            arrayList2.add(view2);
                            view2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public final void onClick(View view3) {
                                    MediaPicker b12 = b1;
                                    int i9 = i8;
                                    b12.brushColor = i9;
                                    ImageEditorView imageEditorView3 = b12.editorView;
                                    if (imageEditorView3 != null) {
                                        imageEditorView3.brushColor = i9;
                                    }
                                    b12.refreshColorSwatches(arrayList2, iArr);
                                }
                            });
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(b1.dp(28), b1.dp(28));
                            layoutParams.setMargins(b1.dp(5), 0, b1.dp(5), 0);
                            linearLayout3.addView(view2, layoutParams);
                            i6++;
                        }
                        b1.refreshColorSwatches(arrayList2, iArr);
                        i3 = -2;
                        linearLayout.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2));
                    }
                    LinearLayout linearLayout4 = new LinearLayout(activity);
                    linearLayout4.setGravity(17);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(-16226561);
                    gradientDrawable.setCornerRadius(b1.dp(10));
                    linearLayout4.setBackground(gradientDrawable);
                    linearLayout4.addView(b1.makeText("Send", 20.0f, -1, true), new LinearLayout.LayoutParams(i3, i3));
                    ChatIconView chatIconView = new ChatIconView(activity, "send", -1);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b1.dp(24), b1.dp(24));
                    layoutParams2.leftMargin = b1.dp(10);
                    linearLayout4.addView(chatIconView, layoutParams2);
                    linearLayout4.setOnClickListener(new MediaPickerClickListener(b1, 2));
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, b1.dp(50));
                    layoutParams3.setMargins(b1.dp(12), b1.dp(i2), b1.dp(12), b1.dp(12));
                    linearLayout.addView(linearLayout4, layoutParams3);
                    frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
                    FrameLayout frameLayout5 = b1.rootView;
                    if (frameLayout5 != null) {
                        frameLayout5.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    } else {
                        i.b.g("top");
                        throw null;
                    }
                }
                return;
            case 5:
                ArrayList arrayList3 = mediaPicker.selectedItems;
                ArrayList arrayList4 = new ArrayList();
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!((MediaItem) next).isVideo) {
                        arrayList4.add(next);
                    }
                }
                ArrayList arrayList5 = new ArrayList(c.d.E(arrayList4));
                Iterator it2 = arrayList4.iterator();
                while (it2.hasNext()) {
                    arrayList5.add(((MediaItem) it2.next()).uri);
                }
                ArrayList arrayList6 = new ArrayList();
                Iterator it3 = arrayList3.iterator();
                while (it3.hasNext()) {
                    Object next2 = it3.next();
                    if (((MediaItem) next2).isVideo) {
                        arrayList6.add(next2);
                    }
                }
                ArrayList arrayList7 = new ArrayList(c.d.E(arrayList6));
                Iterator it4 = arrayList6.iterator();
                while (it4.hasNext()) {
                    arrayList7.add(((MediaItem) it4.next()).uri);
                }
                if (arrayList5.isEmpty() && arrayList7.isEmpty()) {
                    return;
                }
                mediaPicker.deliverSelection(arrayList5, arrayList7);
                return;
            case 6:
                Dialog dialog2 = mediaPicker.pickerDialog;
                if (dialog2 != null) {
                    dialog2.dismiss();
                    return;
                } else {
                    i.b.g("dlg");
                    throw null;
                }
            default:
                mediaPicker.toggleFilterMenu(null);
                return;
        }
    }
}
