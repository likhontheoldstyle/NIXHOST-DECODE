package a;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class MediaPicker {

    public TextView previewButton;

    public TextView sendButton;

    public TextView emptyView;

    public FrameLayout previewRoot;

    public VideoView previewVideoView;

    public ImageEditorView editorView;

    public MediaItem previewItem;

    public boolean drawMode;

    public int brushColor;

    public final ChatAndMediaAdapter gridAdapter;

    public final Activity activity;

    public final boolean darkTheme;

    public final ChatScreenAction onCameraAction;

    public final MediaPickerContent onMediaSelected;

    public final int bgColor;

    public final int textColor;

    public final int surfaceColor;

    public final int dividerColor;

    public final Handler mainHandler;

    public final ExecutorService executor;

    public final BitmapLruCache bitmapCache;

    public final HashSet loadingUris;

    public final ArrayList allMedia;

    public List filteredMedia;

    public final ArrayList selectedItems;

    public String filterKey;

    public boolean keepScreenOn;

    public Dialog pickerDialog;

    public FrameLayout rootView;

    public TextView titleView;

    public IconView chevronIcon;

    public GridView gridView;

    public ScrollView filterMenuScroll;

    public LinearLayout filterMenuColumn;

    public FrameLayout cameraFab;

    public LinearLayout actionBar;

    public MediaPicker(Activity activity, boolean z, ChatScreenAction chatScreenAction, MediaPickerContent mediaPickerContent) {
        this.activity = activity;
        this.darkTheme = z;
        this.onCameraAction = chatScreenAction;
        this.onMediaSelected = mediaPickerContent;
        this.bgColor = z ? -15197926 : -1;
        this.textColor = z ? -920842 : -16448251;
        this.surfaceColor = z ? -12960964 : -1775893;
        this.dividerColor = z ? -12697534 : -1775893;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.executor = Executors.newFixedThreadPool(3);
        this.bitmapCache = new BitmapLruCache(16777216, 0);
        this.loadingUris = new HashSet();
        this.allMedia = new ArrayList();
        this.filteredMedia = c.j.f773a;
        this.selectedItems = new ArrayList();
        this.filterKey = "all";
        this.brushColor = -50384;
        this.gridAdapter = new ChatAndMediaAdapter(1, this);
    }

    public static GradientDrawable circleDrawable(int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i2);
        return gradientDrawable;
    }

    public final void applyFilter() {
        List arrayList;
        boolean a2 = i.b.a(this.filterKey, "all");
        ArrayList arrayList2 = this.allMedia;
        if (a2) {
            arrayList = c.b.Q(arrayList2);
        } else if (i.b.a(this.filterKey, "photos")) {
            arrayList = new ArrayList();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (!((MediaItem) next).isVideo) {
                    arrayList.add(next);
                }
            }
        } else if (i.b.a(this.filterKey, "videos")) {
            arrayList = new ArrayList();
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Object next2 = it2.next();
                if (((MediaItem) next2).isVideo) {
                    arrayList.add(next2);
                }
            }
        } else {
            arrayList = new ArrayList();
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                Object next3 = it3.next();
                if (i.b.a(StringPlus.stringPlus("b:", ((MediaItem) next3).bucketName), this.filterKey)) {
                    arrayList.add(next3);
                }
            }
        }
        this.filteredMedia = arrayList;
        this.gridAdapter.notifyDataSetChanged();
        GridView gridView = this.gridView;
        if (gridView == null) {
            i.b.g("grid");
            throw null;
        }
        gridView.setSelection(0);
        TextView textView = this.emptyView;
        if (textView != null) {
            textView.setVisibility(this.filteredMedia.isEmpty() ? 0 : 8);
        } else {
            i.b.g("emptyTv");
            throw null;
        }
    }

    public final void showTextOverlayDialog(String str, h.b bVar) {
        Window window;
        Activity activity = this.activity;
        Dialog dialog = new Dialog(activity, R.style.Theme.Black.NoTitleBar);
        Window window2 = dialog.getWindow();
        if (window2 != null) {
            window2.setWindowAnimations(com.nix.host.R.style.ZoomAnim);
        }
        Window window3 = dialog.getWindow();
        if (window3 != null) {
            window3.setBackgroundDrawable(new ColorDrawable(-436207616));
        }
        Window window4 = dialog.getWindow();
        if (window4 != null) {
            window4.setSoftInputMode(20);
        }
        FrameLayout frameLayout = new FrameLayout(activity);
        EditText editText = new EditText(activity);
        editText.setBackground(null);
        editText.setHint("Type something");
        editText.setHintTextColor(-1996488705);
        editText.setTextColor(-1);
        editText.setTextSize(1, 28.0f);
        editText.setGravity(17);
        editText.setInputType(16385);
        editText.setImeOptions(6);
        editText.setText(str);
        editText.setSelection(editText.getText().length());
        final ActionCallback actionCallback = new ActionCallback(new i.d(), editText, dialog, bVar, 3);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 != 6) {
                    return false;
                }
                actionCallback.a();
                return true;
            }
        });
        TextView doneView = makeText("Done", 20.0f, -1, true);
        doneView.setPadding(dp(14), dp(10), dp(14), dp(10));
        doneView.setOnClickListener(new ActionClickListener(actionCallback, 4));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 17);
        layoutParams.setMargins(dp(20), 0, dp(20), 0);
        frameLayout.addView(editText, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 8388661);
        layoutParams2.setMargins(0, dp(14), dp(6), 0);
        frameLayout.addView(doneView, layoutParams2);
        dialog.setContentView(frameLayout);
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public final void onCancel(DialogInterface dialogInterface) {
                actionCallback.a();
            }
        });
        if (this.keepScreenOn && (window = dialog.getWindow()) != null) {
            window.addFlags(8192);
        }
        dialog.show();
    }

    public final void applyDialogBarColors(boolean z) {
        Dialog dialog = this.pickerDialog;
        if (dialog == null) {
            i.b.g("dlg");
            throw null;
        }
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        int i2 = z ? -16777216 : this.bgColor;
        window.setStatusBarColor(i2);
        window.setNavigationBarColor(i2);
        window.getDecorView().setSystemUiVisibility((this.darkTheme || z) ? 0 : 8192);
    }

    public final void closePreview() {
        try {
            VideoView videoView = this.previewVideoView;
            if (videoView != null) {
                videoView.stopPlayback();
            }
        } catch (Throwable unused) {
        }
        this.previewVideoView = null;
        this.editorView = null;
        this.previewItem = null;
        FrameLayout frameLayout = this.previewRoot;
        if (frameLayout != null) {
            FrameLayout frameLayout2 = this.rootView;
            if (frameLayout2 == null) {
                i.b.g("top");
                throw null;
            }
            frameLayout2.removeView(frameLayout);
        }
        this.previewRoot = null;
        applyDialogBarColors(false);
    }

    public final int dp(int i2) {
        return (int) (i2 * this.activity.getResources().getDisplayMetrics().density * 0.93f);
    }

    public final void deliverSelection(List list, List list2) {
        Dialog dialog = this.pickerDialog;
        if (dialog == null) {
            i.b.g("dlg");
            throw null;
        }
        dialog.dismiss();
        this.onMediaSelected.a(list, list2);
    }

    public final void addFilterMenuRow(String str, String str2, String str3) {
        Activity activity = this.activity;
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setGravity(16);
        linearLayout.setPadding(dp(16), dp(8), dp(16), dp(8));
        FrameLayout frameLayout = new FrameLayout(activity);
        int i2 = this.surfaceColor;
        frameLayout.setBackground(circleDrawable(i2));
        int i3 = this.textColor;
        frameLayout.addView(new EditorIconView(activity, str2, i3, i2), new FrameLayout.LayoutParams(dp(24), dp(24), 17));
        linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(dp(46), dp(46)));
        TextView makeText = makeText(str, 21.0f, i3, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = dp(16);
        linearLayout.addView(makeText, layoutParams);
        linearLayout.setOnClickListener(new MediaFilterClickListener(this, str3, str, 1));
        LinearLayout linearLayout2 = this.filterMenuColumn;
        if (linearLayout2 != null) {
            linearLayout2.addView(linearLayout, new LinearLayout.LayoutParams(-1, dp(62)));
        } else {
            i.b.g("menuCol");
            throw null;
        }
    }

    public final void refreshColorSwatches(ArrayList arrayList, int[] iArr) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(iArr[i2]);
            boolean z = iArr[i2] == this.brushColor;
            gradientDrawable.setStroke(dp(z ? 3 : 2), z ? -1 : 1728053247);
            ((View) arrayList.get(i2)).setBackground(gradientDrawable);
        }
    }

    public final void toggleFilterMenu(Boolean bool) {
        boolean z;
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            ScrollView scrollView = this.filterMenuScroll;
            if (scrollView == null) {
                i.b.g("menu");
                throw null;
            }
            z = scrollView.getVisibility() != 0;
        }
        if (z) {
            LinearLayout linearLayout = this.filterMenuColumn;
            if (linearLayout == null) {
                i.b.g("menuCol");
                throw null;
            }
            linearLayout.removeAllViews();
            addFilterMenuRow("Gallery", "gallery", "all");
            addFilterMenuRow("Photos", "photos", "photos");
            addFilterMenuRow("Videos", "videos", "videos");
            View view = new View(this.activity);
            view.setBackgroundColor(this.dividerColor);
            LinearLayout linearLayout2 = this.filterMenuColumn;
            if (linearLayout2 == null) {
                i.b.g("menuCol");
                throw null;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
            layoutParams.setMargins(dp(16), dp(6), dp(16), dp(6));
            linearLayout2.addView(view, layoutParams);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = this.allMedia.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(((MediaItem) it.next()).bucketName);
            }
            Iterator it2 = linkedHashSet.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                String stringPlus = StringPlus.stringPlus("b:", str);
                TextView textView = makeText(str, 21.0f, this.textColor, false);
                textView.setGravity(16);
                textView.setPadding(dp(16), 0, dp(16), 0);
                textView.setOnClickListener(new MediaFilterClickListener(this, stringPlus, str, 0));
                LinearLayout linearLayout3 = this.filterMenuColumn;
                if (linearLayout3 == null) {
                    i.b.g("menuCol");
                    throw null;
                }
                linearLayout3.addView(textView, new LinearLayout.LayoutParams(-1, dp(54)));
            }
        }
        ScrollView scrollView2 = this.filterMenuScroll;
        if (scrollView2 == null) {
            i.b.g("menu");
            throw null;
        }
        scrollView2.setVisibility(z ? 0 : 8);
        IconView iconView = this.chevronIcon;
        if (iconView != null) {
            iconView.setIcon(z ? "up" : "down");
        } else {
            i.b.g("chev");
            throw null;
        }
    }

    public final FrameLayout makeIconButton(String str) {
        Activity activity = this.activity;
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.addView(new EditorIconView(activity, str, -1, -1), new FrameLayout.LayoutParams(dp(26), dp(26), 17));
        return frameLayout;
    }

    public final TextView makeText(String str, float f2, int i2, boolean z) {
        TextView textView = new TextView(this.activity);
        textView.setText(str);
        textView.setTextSize(1, f2);
        textView.setTextColor(i2);
        if (z) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        return textView;
    }
}
