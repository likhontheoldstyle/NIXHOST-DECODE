package com.nix.host;

import a.ActionCallback;
import a.ActionClickListener;
import a.ActivityAction;
import a.ActivityClickListener;
import a.ApiClient;
import a.AppState;
import a.ChatMedia;
import a.ConfirmDialogContent;
import a.CreateRenameAction;
import a.DismissAndRun;
import a.DragSheetLayout;
import a.FocusBorderListener;
import a.SubmitAction;
import a.TextInputAction;
import a.AvatarView;
import a.BackgroundTask;
import a.ChatNotifier;
import a.ChatScreen;
import a.CodeEditorView;
import a.CodeLinesAdapter;
import a.CommitAction;
import a.DialogContent;
import a.DismissAction;
import a.EmojiPanelToggle;
import a.FileFilters;
import a.HttpServer;
import a.IconView;
import a.LayoutTask;
import a.MultiAction;
import a.PairAction;
import a.PanelToggleAction;
import a.PressMediaTouchListener;
import a.RefAction;
import a.SharedTextWatcher;
import a.SyntaxHighlighter;
import a.TerminalManager;
import a.TerminalSession;
import a.TickRunnable;
import a.ToastCallback;
import a.TripleClickListener;
import a.UiTask;
import a.ValueAction;
import a.ViewAnimTask;
import a.Workspace;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

public final class MainActivity extends Activity {
    public static final int R = 0;
    public EditText termInput;
    public LinearLayout termInputRow;
    public LinearLayout termBusyRow;
    public TextView termPrompt;
    public TextView termPathLabel;
    public TextView termClockLabel;
    public LinearLayout termKeysPanel;
    public View termScrim;
    public boolean termBusy;
    public Dialog notifDialog;
    public View rootView;
    public long wifiLostAt;
    public File uploadTargetDir;

    public long lastRefreshAt;

    public int statusBarHeight;

    public int bottomInset;

    public boolean expiryWarned;

    public long stoppedAt;

    public EmojiPanelToggle emojiToggle;

    public boolean storageGranted;

    public ChatScreen chatScreen;

    public File currentDir;

    public File homeDir;

    public int outputCursor;

    public TextView termOutput;

    public LinearLayout popupMenu;

    public View popupScrim;

    public ActionCallback editorSession;
    public int termColor;
    public boolean termBold;
    public boolean termNeedsNewline;
    public ScrollView termScroll;

    public final int matchParent = -1;

    public final int wrapContent = -2;

    public final Handler mainHandler = new Handler(Looper.getMainLooper());

    public String screen = "login";

    public String username = "";
    public String termKey = "";
    public String termTitle = "";
    public final TickRunnable uiTicker = new TickRunnable(this, 1);
    public final float uiScale = 0.93f;
    public final b.c fontLazy = new b.c(new ActivityAction(this, 6));
    public boolean online = true;

    public static final void focusAndShowKeyboard(EditText editText, MainActivity mainActivity) {
        editText.requestFocus();
        Object systemService = mainActivity.getSystemService("input_method");
        i.b.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
    }

    public static void setAction(View view, h.a aVar) {
        view.setOnClickListener(new ActionClickListener(aVar, 5));
        view.setOnTouchListener(new PressMediaTouchListener());
    }

    public static final void appendStyled(StringBuilder sb, Editable editable, i.d dVar, MainActivity mainActivity) {
        if (sb.length() == 0) {
            return;
        }
        int length = editable.length();
        editable.append((CharSequence) sb);
        if (dVar.f846a) {
            editable.setSpan(new ForegroundColorSpan(-11563273), length, editable.length(), 33);
            editable.setSpan(new StyleSpan(1), length, editable.length(), 33);
        } else {
            if (mainActivity.termColor != 0) {
                editable.setSpan(new ForegroundColorSpan(mainActivity.termColor), length, editable.length(), 33);
            }
            if (mainActivity.termBold) {
                editable.setSpan(new StyleSpan(1), length, editable.length(), 33);
            }
        }
        sb.setLength(0);
    }

    public static final EditText makeInput(MainActivity mainActivity, String str) {
        EditText editText = new EditText(mainActivity);
        editText.setHint(str);
        editText.setHintTextColor(-6511697);
        editText.setTextColor(-15656921);
        editText.setTextSize(1, mainActivity.uiScale * 17.0f);
        editText.setSingleLine(true);
        editText.setBackground(mainActivity.roundedBg(-1, 16, -1710101, 2));
        editText.setPadding(mainActivity.dp(16), mainActivity.dp(14), mainActivity.dp(16), mainActivity.dp(14));
        editText.setOnFocusChangeListener(new a.FocusBorderListener(editText, mainActivity, 1));
        return editText;
    }

    public static final void animateEmojiPanelClose(IconView g1, final DragSheetLayout s2Var, final View view, FrameLayout frameLayout, MainActivity mainActivity, h.a aVar, i.d dVar) {
        if (dVar.f846a) {
            return;
        }
        dVar.f846a = true;
        mainActivity.emojiToggle = null;
        g1.setIcon("up");
        final float height = s2Var.getHeight();
        final float translationY = s2Var.getTranslationY();
        final float alpha = view.getAlpha();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(260L);
        ofFloat.setInterpolator(new DecelerateInterpolator(2.0f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i2 = MainActivity.R;
                Object animatedValue = valueAnimator.getAnimatedValue();
                i.b.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                float floatValue = ((Float) animatedValue).floatValue();
                float f2 = height;
                float f3 = translationY;
                s2Var.setTranslationY(((1.0f - floatValue) * (f2 - f3)) + f3);
                view.setAlpha(alpha * floatValue);
            }
        });
        ofFloat.addListener(new SheetDismissAnimatorListener(frameLayout, s2Var, view, aVar));
        ofFloat.start();
    }

    public static final void addSheetItem(MainActivity mainActivity, DragSheetLayout s2Var, i.d dVar, IconView g1, View view, FrameLayout frameLayout, String str, int i2, h.a aVar) {
        TextView U = mainActivity.makeText(str, 18.0f, i2, true);
        U.setPadding(0, mainActivity.dp(16), 0, mainActivity.dp(16));
        setAction(U, new a.SubmitAction(g1, s2Var, view, frameLayout, mainActivity, aVar, dVar));
        s2Var.addView(U, layoutParams(mainActivity, mainActivity.matchParent, mainActivity.wrapContent, 0, 0, 0, 60));
    }

    public static int ansiColor(int i2) {
        if (i2 == 0) {
            return -9735552;
        }
        if (i2 == 1) {
            return -1096636;
        }
        if (i2 == 2) {
            return -14498466;
        }
        if (i2 == 3) {
            return -1395960;
        }
        if (i2 == 4) {
            return -12877066;
        }
        if (i2 == 5) {
            return -2537745;
        }
        if (i2 == 6) {
            return -16337196;
        }
        if (i2 == 7) {
            return -1710101;
        }
        if (i2 == 8) {
            return -6511697;
        }
        if (i2 == 9) {
            return -495247;
        }
        if (i2 == 10) {
            return -11870592;
        }
        if (i2 == 11) {
            return -340971;
        }
        if (i2 == 12) {
            return -10443270;
        }
        if (i2 == 13) {
            return -1541639;
        }
        if (i2 == 14) {
            return -14494738;
        }
        if (i2 == 15) {
            return -1;
        }
        if (16 <= i2 && i2 < 232) {
            int i3 = i2 - 16;
            int[] iArr = {0, 95, 135, 175, 215, 255};
            return Color.rgb(iArr[i3 / 36], iArr[(i3 / 6) % 6], iArr[i3 % 6]);
        }
        if (232 > i2 || i2 >= 256) {
            return 0;
        }
        int i4 = ((i2 - 232) * 10) + 8;
        return Color.rgb(i4, i4, i4);
    }

    public static Dialog showDialog(MainActivity mainActivity, int i2, boolean z, h.c cVar, int i3) {
        Window window;
        Window window2;
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            z = false;
        }
        mainActivity.getClass();
        Dialog dialog = new Dialog(mainActivity);
        if (mainActivity.shouldKeepScreenOn() && (window2 = dialog.getWindow()) != null) {
            window2.addFlags(8192);
        }
        dialog.requestWindowFeature(1);
        LinearLayout V = mainActivity.column();
        boolean z2 = AppState.darkTheme;
        int i4 = z2 ? -14540254 : -1;
        if (i2 == 0) {
            i2 = z2 ? -13684945 : -1710101;
        }
        V.setBackground(mainActivity.roundedBg(i4, 24, i2, 1));
        V.setPadding(mainActivity.dp(24), mainActivity.dp(24), mainActivity.dp(24), mainActivity.dp(24));
        cVar.a(V, dialog);
        dialog.setContentView(V);
        Window window3 = dialog.getWindow();
        if (window3 != null) {
            window3.setBackgroundDrawable(new ColorDrawable(0));
        }
        Window window4 = dialog.getWindow();
        if (window4 != null) {
            window4.setWindowAnimations(com.nix.host.R.style.ZoomAnim);
        }
        if (z && (window = dialog.getWindow()) != null) {
            window.setSoftInputMode(20);
        }
        dialog.show();
        Window window5 = dialog.getWindow();
        if (window5 != null) {
            window5.setLayout((int) (mainActivity.getResources().getDisplayMetrics().widthPixels * 0.9f), -2);
        }
        Window window6 = dialog.getWindow();
        if (window6 != null) {
            window6.setDimAmount(0.65f);
        }
        return dialog;
    }

    public static final EditText makeEditorField(MainActivity mainActivity, String str, String str2, boolean z) {
        EditText editText = new EditText(mainActivity);
        editText.setText(str2);
        editText.setHint(str);
        editText.setHintTextColor(-7236192);
        editText.setTextColor(-263172);
        editText.setTypeface(Typeface.MONOSPACE);
        editText.setTextSize(1, mainActivity.uiScale * 18.0f);
        editText.setBackground(null);
        editText.setPadding(mainActivity.dp(18), mainActivity.dp(14), mainActivity.dp(18), mainActivity.dp(14));
        if (z) {
            editText.setSingleLine(true);
        } else {
            editText.setMaxLines(4);
        }
        editText.setInputType((z ? 0 : 131072) | 524289);
        if (Build.VERSION.SDK_INT >= 29) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-15896869);
            gradientDrawable.setSize(mainActivity.dp(2), mainActivity.dp(22));
            editText.setTextCursorDrawable(gradientDrawable);
        }
        return editText;
    }

    public static void resetAnimationScale() {
        try {
            ValueAnimator.class.getMethod("setDurationScale", Float.TYPE).invoke(null, Float.valueOf(1.0f));
        } catch (Throwable unused) {
        }
    }

    public static LinearLayout.LayoutParams layoutParams(MainActivity mainActivity, int i2, int i3, int i4, int i5, int i6, int i7) {
        if ((i7 & 4) != 0) {
            i4 = 0;
        }
        if ((i7 & 8) != 0) {
            i5 = 0;
        }
        if ((i7 & 16) != 0) {
            i6 = 0;
        }
        mainActivity.getClass();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i3);
        layoutParams.setMargins(mainActivity.dp(i5), mainActivity.dp(i4), mainActivity.dp(i6), mainActivity.dp(0));
        return layoutParams;
    }

    public static final void addKeyButton(MainActivity mainActivity, LinearLayout linearLayout, String str, h.a aVar) {
        LinearLayout r2 = mainActivity.row();
        r2.setPadding(mainActivity.dp(14), mainActivity.dp(14), mainActivity.dp(14), mainActivity.dp(14));
        TextView U = mainActivity.makeText(str, 16.0f, -1, true);
        U.setTypeface(Typeface.create(mainActivity.monoFont(), 1));
        r2.addView(U, new LinearLayout.LayoutParams(0, mainActivity.wrapContent, 1.0f));
        setAction(r2, new PairAction(mainActivity, aVar, 5));
        linearLayout.addView(r2, layoutParams(mainActivity, mainActivity.matchParent, mainActivity.wrapContent, 0, 0, 0, 60));
    }

    public final void openWhatsApp(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        i.b.d(sb2, "toString(...)");
        if (sb2.length() == 0) {
            return;
        }
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://wa.me/" + sb2)));
        } catch (Exception unused) {
            toast("Cannot open WhatsApp");
        }
    }

    public final void flushTerminalOutput() {
        TerminalSession terminalSession;
        b.b bVar;
        Editable editableText;
        int i2;
        List list;
        int i3;
        int i4;
        TextView textView = this.termOutput;
        if (textView == null || this.termKey.length() == 0) {
            return;
        }
        TerminalManager terminalManager = TerminalManager.INSTANCE;
        String str = this.termKey;
        synchronized (terminalManager) {
            terminalSession = (TerminalSession) TerminalManager.sessions.get(str);
        }
        if (terminalSession == null) {
            return;
        }
        int i5 = this.outputCursor;
        synchronized (terminalSession) {
            int length = terminalSession.outputFlushed + terminalSession.output.length();
            int i6 = terminalSession.outputFlushed;
            if (i5 < i6) {
                i5 = i6;
            }
            bVar = i5 >= length ? new b.b("", Integer.valueOf(length)) : new b.b(terminalSession.output.substring(i5 - i6), Integer.valueOf(length));
        }
        String str2 = (String) bVar.f764a;
        this.outputCursor = ((Number) bVar.f765b).intValue();
        if (str2.length() == 0 || (editableText = textView.getEditableText()) == null) {
            return;
        }
        if (this.termNeedsNewline && str2.length() > 0) {
            editableText.append((CharSequence) "\n");
            this.termNeedsNewline = false;
        }
        StringBuilder sb = new StringBuilder();
        i.d dVar = new i.d();
        StringBuilder sb2 = new StringBuilder();
        int length2 = str2.length();
        int i7 = 0;
        boolean inSgr = false;
        while (true) {
            if (i7 >= length2) {
                break;
            }
            char charAt = str2.charAt(i7);
            if (inSgr) {
                if (charAt == 4) {
                    String sb3 = sb2.toString();
                    if (sb3.length() == 0) {
                        list = AppState.p(Integer.valueOf(0));
                    } else {
                        List b0 = m.e.b0(sb3, new String[]{";"});
                        ArrayList arrayList = new ArrayList(c.d.E(b0));
                        Iterator it = b0.iterator();
                        while (it.hasNext()) {
                            Integer C = m.l.C((String) it.next());
                            arrayList.add(Integer.valueOf(C != null ? C.intValue() : 0));
                        }
                        list = arrayList;
                    }
                    int i8 = 0;
                    while (i8 < list.size()) {
                        int intValue = ((Number) list.get(i8)).intValue();
                        if (intValue == 0) {
                            this.termColor = 0;
                            this.termBold = false;
                        } else if (intValue == 1) {
                            this.termBold = true;
                        } else if (intValue == 22) {
                            this.termBold = false;
                        } else if (intValue == 39) {
                            this.termColor = 0;
                        } else if (30 <= intValue && intValue < 38) {
                            this.termColor = ansiColor(intValue - 30);
                        } else if (90 <= intValue && intValue < 98) {
                            this.termColor = ansiColor(intValue - 82);
                        } else if (intValue == 38 && (i4 = i8 + 2) < list.size() && ((Number) list.get(i8 + 1)).intValue() == 5) {
                            this.termColor = ansiColor(((Number) list.get(i4)).intValue());
                            i8 = i4;
                        } else if (intValue == 38 && (i3 = i8 + 4) < list.size() && ((Number) list.get(i8 + 1)).intValue() == 2) {
                            this.termColor = Color.rgb(AppState.c(((Number) list.get(i8 + 2)).intValue(), 255), AppState.c(((Number) list.get(i8 + 3)).intValue(), 255), AppState.c(((Number) list.get(i3)).intValue(), 255));
                            i8 = i3;
                        }
                        i8++;
                    }
                    sb2.setLength(0);
                    inSgr = false;
                } else {
                    sb2.append(charAt);
                }
            } else if (charAt == 1) {
                appendStyled(sb, editableText, dVar, this);
                dVar.f846a = true;
            } else if (charAt == 2) {
                appendStyled(sb, editableText, dVar, this);
                dVar.f846a = false;
            } else if (charAt == 3) {
                appendStyled(sb, editableText, dVar, this);
                inSgr = true;
            } else if (charAt != '\f') {
                sb.append(charAt);
            } else {
                sb.setLength(0);
                editableText.clear();
                this.termNeedsNewline = false;
            }
            i7++;
        }
        appendStyled(sb, editableText, dVar, this);
        if (editableText.length() > 0 && editableText.charAt(editableText.length() - 1) == '\n') {
            editableText.delete(editableText.length() - 1, editableText.length());
            this.termNeedsNewline = true;
        }
        if (editableText.length() > 50000) {
            i2 = 0;
            editableText.delete(0, editableText.length() - 40000);
        } else {
            i2 = 0;
        }
        textView.setVisibility(editableText.length() == 0 ? 8 : i2);
        ScrollView scrollView = this.termScroll;
        if (scrollView != null) {
            scrollView.post(new UiTask(this, 1));
        }
    }

    public final void showInputDialog(String str, String str2, String str3, String str4, h.b bVar) {
        showDialog(this, 0, true, new DialogContent(this, str, str2, str3, str4, bVar), 1);
    }

    public final void refreshTerminalChrome() {
        TerminalSession terminalSession;
        TerminalManager terminalManager = TerminalManager.INSTANCE;
        String str = this.termKey;
        synchronized (terminalManager) {
            terminalSession = (TerminalSession) TerminalManager.sessions.get(str);
        }
        if (terminalSession == null) {
            return;
        }
        boolean z = terminalSession.busy;
        LinearLayout linearLayout = this.termBusyRow;
        if (linearLayout != null) {
            linearLayout.setVisibility((!z || terminalSession.prompt.length() <= 0) ? 8 : 0);
        }
        TextView textView = this.termPrompt;
        if (textView != null) {
            textView.setText(terminalSession.prompt);
        }
        LinearLayout linearLayout2 = this.termInputRow;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(z ? 8 : 0);
        }
        if (this.termBusy && !z) {
            EditText editText = this.termInput;
            if (editText != null) {
                editText.requestFocus();
            }
            ScrollView scrollView = this.termScroll;
            if (scrollView != null) {
                scrollView.post(new UiTask(this, 2));
            }
        }
        this.termBusy = z;
        String l3 = terminalSession.cwdLabel();
        TextView textView2 = this.termPathLabel;
        if (textView2 != null) {
            textView2.setText("[" + this.termTitle + l3 + "]");
        }
        TextView textView3 = this.termClockLabel;
        if (textView3 != null) {
            textView3.setText(new SimpleDateFormat("HH:mm  dd-MMM-yy", Locale.US).format(new Date(System.currentTimeMillis())));
        }
    }

    public final void setRootContent(ViewGroup viewGroup, int i2, int i3, boolean z, final boolean z2) {
        if (shouldKeepScreenOn()) {
            getWindow().addFlags(8192);
        } else {
            getWindow().clearFlags(8192);
        }
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                getWindow().setDecorFitsSystemWindows(!z2);
            } else {
                View decorView = getWindow().getDecorView();
                decorView.setSystemUiVisibility(z2 ? decorView.getSystemUiVisibility() | 1280 : decorView.getSystemUiVisibility() & (-1281));
            }
        } catch (Exception unused) {
        }
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(i3);
        final View view = new View(this);
        view.setBackgroundColor(i2);
        int i4 = this.matchParent;
        if (!z2) {
            linearLayout.addView(view, new LinearLayout.LayoutParams(i4, this.statusBarHeight));
        }
        linearLayout.addView(viewGroup, new LinearLayout.LayoutParams(i4, 0, 1.0f));
        linearLayout.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            @Override
            public final WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                int systemBars;
                Insets insets;
                int ime;
                Insets insets2;
                int i5;
                int i6;
                int i7;
                int i8 = MainActivity.R;
                int i9 = Build.VERSION.SDK_INT;
                MainActivity mainActivity = MainActivity.this;
                if (i9 >= 30) {
                    systemBars = WindowInsets.Type.systemBars();
                    insets = windowInsets.getInsets(systemBars);
                    ime = WindowInsets.Type.ime();
                    insets2 = windowInsets.getInsets(ime);
                    i5 = insets.top;
                    mainActivity.statusBarHeight = i5;
                    i6 = insets.bottom;
                    i7 = insets2.bottom;
                    mainActivity.bottomInset = Math.max(i6, i7);
                } else {
                    mainActivity.statusBarHeight = windowInsets.getSystemWindowInsetTop();
                    mainActivity.bottomInset = windowInsets.getSystemWindowInsetBottom();
                }
                if (z2) {
                    ChatScreen chatScreen = mainActivity.chatScreen;
                    if (chatScreen != null) {
                        int i10 = mainActivity.statusBarHeight;
                        chatScreen.topInset = i10;
                        LinearLayout linearLayout2 = chatScreen.headerBar;
                        if (linearLayout2 != null) {
                            float f2 = 9;
                            linearLayout2.setPadding(chatScreen.dp(2), chatScreen.dp(f2) + i10, chatScreen.dp(8), chatScreen.dp(f2));
                        }
                    }
                } else {
                    View view3 = view;
                    ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
                    int i11 = layoutParams.height;
                    int i12 = mainActivity.statusBarHeight;
                    if (i11 != i12) {
                        layoutParams.height = i12;
                        view3.setLayoutParams(layoutParams);
                    }
                }
                view2.setPadding(0, 0, 0, mainActivity.bottomInset);
                return windowInsets;
            }
        });
        this.rootView = linearLayout;
        setContentView(linearLayout);
        linearLayout.requestApplyInsets();
        applyBarColors(i2, i3, z);
    }

    public final GradientDrawable roundedBg(int i2, int i3, int i4, int i5) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius(dp(i3));
        if (i5 > 0) {
            gradientDrawable.setStroke(dp(i5), i4);
        }
        return gradientDrawable;
    }

    public final boolean shouldKeepScreenOn() {
        return !m.m.F(this.username, "aryan") && (i.b.a(this.screen, "home") || i.b.a(this.screen, "group"));
    }

    public final void showEditor(File file) {
        String str;
        if (file.length() > 300000) {
            toast("File too big to edit here");
            return;
        }
        this.screen = "edit";
        clearScreenRefs();
        this.popupMenu = null;
        try {
            str = m.m.J(g.m.I(file), "\t", "    ");
        } catch (Exception unused) {
            str = "";
        }
        String str2 = str;
        FrameLayout frameLayout = new FrameLayout(this);
        LinearLayout V = column();
        V.setBackgroundColor(-15263716);
        LinearLayout r2 = row();
        r2.setPadding(dp(14), dp(10), dp(16), dp(10));
        FrameLayout frameLayout2 = new FrameLayout(this);
        frameLayout2.addView(makeIcon("close", -263172, 26, 2.0f), new FrameLayout.LayoutParams(dp(26), dp(26), 17));
        r2.addView(frameLayout2, layoutParams(this, dp(40), dp(40), 0, 0, 0, 60));
        LinearLayout V2 = column();
        V2.addView(makeText(file.getName(), 15.0f, -7236192, false));
        V2.addView(makeText("Edit file", 26.0f, -263172, true));
        int i2 = this.wrapContent;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, i2, 1.0f);
        layoutParams.leftMargin = dp(10);
        r2.addView(V2, layoutParams);
        V.addView(r2, layoutParams(this, this.matchParent, this.wrapContent, 0, 0, 0, 60));
        float f2 = getResources().getDisplayMetrics().density;
        float f3 = this.uiScale;
        CodeEditorView codeEditorView = new CodeEditorView(this, f2 * f3);
        codeEditorView.setFileName(file.getName());
        codeEditorView.setText(str2);
        codeEditorView.setBackground(null);
        codeEditorView.setTypeface(Typeface.MONOSPACE);
        codeEditorView.setTextSize(1, f3 * 14.0f);
        codeEditorView.setLineSpacing(0.0f, 1.1f);
        codeEditorView.setTextColor(-591622);
        codeEditorView.setHighlightColor(1426943707);
        codeEditorView.setGravity(48);
        codeEditorView.setPadding(dp(10) + codeEditorView.gutterWidth, dp(3), dp(10), dp(90));
        codeEditorView.setInputType(655361);
        if (Build.VERSION.SDK_INT >= 29) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-15896869);
            gradientDrawable.setSize(dp(2), dp(22));
            codeEditorView.setTextCursorDrawable(gradientDrawable);
        }
        codeEditorView.recomputeLineStarts();
        codeEditorView.handler.post(codeEditorView.repaintTask);
        int i3 = this.matchParent;
        V.addView(codeEditorView, new LinearLayout.LayoutParams(i3, 0, 1.0f));
        frameLayout.addView(V, new FrameLayout.LayoutParams(i3, i3));
        LinearLayout r3 = row();
        r3.setGravity(17);
        r3.setBackground(roundedBg(-14319045, 10, 0, 0));
        r3.setPadding(dp(18), dp(14), dp(16), dp(14));
        r3.addView(makeIcon("commit", -1, 24, 2.0f), layoutParams(this, dp(24), dp(24), 0, 0, 10, 32));
        View U = makeText("COMMIT CHANGES", 17.0f, -1, false);
        int i4 = this.wrapContent;
        r3.addView(U, layoutParams(this, i4, i4, 0, 0, 10, 32));
        r3.addView(makeIcon("down", -1, 20, 2.4f), layoutParams(this, dp(20), dp(20), 0, 0, 0, 60));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, i2, 8388693);
        layoutParams2.setMargins(0, 0, dp(16), dp(16));
        frameLayout.addView(r3, layoutParams2);
        ActionCallback actionCallback = new ActionCallback(this, codeEditorView, str2, file);
        this.editorSession = actionCallback;
        setAction(frameLayout2, new a.DelegateAction(actionCallback, 1));
        setAction(r3, new CommitAction(this, file, codeEditorView));
        setRootContent(frameLayout, -15263716, -15263716, false, false);
    }

    public final void showFiles() {
        List list;
        File file;
        String str;
        int i2 = 1;
        this.screen = "files";
        clearScreenRefs();
        this.popupMenu = null;
        this.editorSession = null;
        File file2 = this.currentDir;
        if (file2 == null && (file2 = this.homeDir) == null) {
            i.b.g("homeDir");
            throw null;
        }
        File file3 = file2;
        String canonicalPath = file3.getCanonicalPath();
        File file4 = this.homeDir;
        if (file4 == null) {
            i.b.g("homeDir");
            throw null;
        }
        boolean a2 = i.b.a(canonicalPath, file4.getCanonicalPath());
        FrameLayout frameLayout = new FrameLayout(this);
        LinearLayout V = column();
        V.setBackgroundColor(-15263716);
        LinearLayout r2 = row();
        r2.setPadding(dp(14), dp(14), dp(10), dp(14));
        FrameLayout frameLayout2 = new FrameLayout(this);
        frameLayout2.addView(makeIcon("arrow", -263172, 26, 2.0f), new FrameLayout.LayoutParams(dp(26), dp(26), 17));
        setAction(frameLayout2, new ActivityAction(this, i2));
        r2.addView(frameLayout2, layoutParams(this, dp(40), dp(40), 0, 0, 0, 60));
        LinearLayout r3 = row();
        if (a2) {
            r3.addView(makeIcon("logo", -43230, 26, 2.0f), layoutParams(this, dp(26), dp(26), 0, 0, 8, 32));
            View U = makeText("NixHost", 24.0f, -263172, true);
            int i3 = this.wrapContent;
            r3.addView(U, layoutParams(this, i3, i3, 0, 0, 0, 60));
        } else {
            TextView U2 = makeText(file3.getName(), 24.0f, -263172, true);
            U2.setSingleLine(true);
            U2.setEllipsize(TextUtils.TruncateAt.END);
            int i4 = this.wrapContent;
            r3.addView(U2, layoutParams(this, i4, i4, 0, 0, 0, 60));
        }
        int i5 = this.wrapContent;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, i5, 1.0f);
        layoutParams.leftMargin = dp(10);
        r2.addView(r3, layoutParams);
        FrameLayout frameLayout3 = new FrameLayout(this);
        frameLayout3.addView(makeIcon("dots", -15896869, 24, 2.0f), new FrameLayout.LayoutParams(dp(24), dp(24), 17));
        r2.addView(frameLayout3, layoutParams(this, dp(40), dp(40), 0, 0, 0, 60));
        V.addView(r2, layoutParams(this, this.matchParent, this.wrapContent, 0, 0, 0, 60));
        ScrollView scrollView = new ScrollView(this);
        LinearLayout V2 = column();
        V2.setPadding(0, dp(4), 0, dp(24));
        int i6 = this.matchParent;
        scrollView.addView(V2, new FrameLayout.LayoutParams(i6, i5));
        V.addView(scrollView, new LinearLayout.LayoutParams(i6, 0, 1.0f));
        final i.e eVar = new i.e();
        final LinearLayout r4 = row();
        r4.setGravity(16);
        r4.setPadding(dp(20), dp(12), dp(20), dp(12));
        r4.setBackgroundColor(-13684937);
        final TextView U3 = makeText("", 15.0f, -263172, false);
        r4.addView(U3, new LinearLayout.LayoutParams(0, i5, 1.0f));
        View U4 = makeText("Cancel", 15.0f, -8012033, true);
        int i7 = this.wrapContent;
        r4.addView(U4, layoutParams(this, i7, i7, 0, 0, 0, 60));
        r4.setVisibility(8);
        setAction(U4, new PairAction(eVar, r4, 2));
        V2.addView(r4, layoutParams(this, this.matchParent, this.wrapContent, 0, 0, 0, 60));
        File[] listFiles = file3.listFiles();
        if (listFiles != null) {
            final h.b[] bVarArr = {new ValueFunction(1), new ValueFunction(2)};
            list = c.a.F(listFiles, new Comparator() {
                @Override
                public final int compare(Object obj, Object obj2) {
                    for (h.b bVar : bVarArr) {
                        int d2 = AppState.d((Comparable) bVar.a(obj), (Comparable) bVar.a(obj2));
                        if (d2 != 0) {
                            return d2;
                        }
                    }
                    return 0;
                }
            });
        } else {
            list = c.j.f773a;
        }
        List<File> list2 = list;
        if (list2.isEmpty()) {
            file = file3;
            V2.addView(makeText("Empty folder", 16.0f, -7236192, false), layoutParams(this, this.matchParent, this.wrapContent, 24, 20, 0, 48));
        } else {
            file = file3;
        }
        for (File file5 : list2) {
            LinearLayout r5 = row();
            r5.setGravity(16);
            r5.setPadding(dp(20), dp(16), dp(20), dp(16));
            List list3 = list2;
            r5.addView(makeIcon(file5.isDirectory() ? "folderf" : "file", file5.isDirectory() ? -8012033 : -9670532, 26, 1.8f), layoutParams(this, dp(26), dp(26), 0, 0, 18, 32));
            TextView U5 = makeText(file5.getName(), 18.0f, -263172, false);
            U5.setSingleLine(true);
            U5.setEllipsize(TextUtils.TruncateAt.END);
            r5.addView(U5, new LinearLayout.LayoutParams(0, i5, 1.0f));
            long currentTimeMillis = (System.currentTimeMillis() - file5.lastModified()) / 1000;
            if (currentTimeMillis < 60) {
                str = "now";
            } else {
                long j2 = 60;
                long j3 = currentTimeMillis / j2;
                if (j3 < 60) {
                    str = j3 == 1 ? "1 minute ago" : j3 + " minutes ago";
                } else {
                    long j4 = j3 / j2;
                    if (j4 < 24) {
                        str = j4 == 1 ? "1 hour ago" : j4 + " hours ago";
                    } else {
                        long j5 = j4 / 24;
                        if (j5 < 30) {
                            str = j5 == 1 ? "1 day ago" : j5 + " days ago";
                        } else {
                            long j6 = j5 / 30;
                            if (j6 < 12) {
                                str = j6 == 1 ? "1 month ago" : j6 + " months ago";
                            } else {
                                long j7 = j5 / 365;
                                str = j7 <= 1 ? "1 year ago" : j7 + " years ago";
                            }
                        }
                    }
                }
            }
            TextView U6 = makeText(str, 13.0f, -7236192, false);
            U6.setSingleLine(true);
            int i8 = this.wrapContent;
            r5.addView(U6, layoutParams(this, i8, i8, 0, 12, 0, 48));
            setAction(r5, new ActionCallback(eVar, r4, this, file5, 5));
            V2.addView(r5, layoutParams(this, this.matchParent, this.wrapContent, 0, 0, 0, 60));
            View view = new View(this);
            view.setBackgroundColor(-13882061);
            V2.addView(view, layoutParams(this, this.matchParent, 1, 0, 0, 0, 60));
            list2 = list3;
        }
        frameLayout.addView(V, new FrameLayout.LayoutParams(i6, i6));
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            File file6 = (File) obj;
            if (file6.isFile()) {
                String lowerCase = file6.getName().toLowerCase(Locale.ROOT);
                i.b.d(lowerCase, "toLowerCase(...)");
                if (lowerCase.endsWith(".zip")) {
                    arrayList.add(obj);
                }
            }
        }
        final ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new b.b("Create file", -263172));
        arrayList2.add(new b.b("Create folder", -263172));
        arrayList2.add(new b.b("Upload zip", -263172));
        arrayList2.add(new b.b("Rename", -263172));
        arrayList2.add(new b.b("Delete", -1014126));
        if (!arrayList.isEmpty()) {
            arrayList2.add(new b.b("Unzip", -263172));
        }
        final File file7 = file;
        showPopupMenu(frameLayout, frameLayout3, arrayList2, new h.b() {
            @Override
            public final Object a(Object obj2) {
                int intValue = ((Integer) obj2).intValue();
                int i9 = MainActivity.R;
                String str2 = (String) ((b.b) arrayList2.get(intValue)).f764a;
                i.e eVar2 = eVar;
                TextView textView = U3;
                LinearLayout linearLayout = r4;
                MainActivity mainActivity = MainActivity.this;
                File file8 = file7;
                if (str2.equals("Rename")) {
                    eVar2.f847a = 1;
                    textView.setText("Tap a file or folder to rename");
                    linearLayout.setVisibility(0);
                } else if (str2.equals("Unzip")) {
                    eVar2.f847a = 3;
                    textView.setText("Tap a zip file to unzip");
                    linearLayout.setVisibility(0);
                } else if (str2.equals("Create file")) {
                    mainActivity.showInputDialog("Create file", "File name", "", "Create", new a.CreateRenameAction(file8, mainActivity, 0));
                } else if (str2.equals("Upload zip")) {
                    mainActivity.uploadTargetDir = file8;
                    try {
                        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                        intent.addCategory("android.intent.category.OPENABLE");
                        intent.setType("*/*");
                        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/zip", "application/x-zip-compressed", "application/x-zip", "application/octet-stream"});
                        mainActivity.startActivityForResult(intent, 77);
                    } catch (Exception unused) {
                        mainActivity.toast("Cannot open the file picker");
                    }
                } else if (str2.equals("Delete")) {
                    eVar2.f847a = 2;
                    textView.setText("Tap a file or folder to delete");
                    linearLayout.setVisibility(0);
                } else {
                    mainActivity.showInputDialog("Create folder", "Folder name", "", "Create", new a.CreateRenameAction(file8, mainActivity, 1));
                }
                return b.d.f770c;
            }
        });
        setRootContent(frameLayout, -15263716, -15263716, false, false);
    }

    public final void showChat() {
        ChatScreen chatScreen;
        this.screen = "group";
        this.emojiToggle = null;
        clearScreenRefs();
        ChatScreen oldScreen = this.chatScreen;
        if (oldScreen != null) {
            oldScreen.destroy();
        }
        String str5 = this.username;
        ChatScreen newScreen = new ChatScreen(this, str5, new ToastCallback(2, this), new ActivityAction(this, 7));
        this.chatScreen = newScreen;
        newScreen.topInset = this.statusBarHeight;
        Window window = getWindow();
        if (window != null && !m.m.F(str5, newScreen.groupId)) {
            window.addFlags(8192);
        }
        File file = ChatMedia.cacheDir;
        File file2 = new File(getCacheDir(), "chat");
        file2.mkdirs();
        ChatMedia.cacheDir = file2;
        FrameLayout frameLayout = new FrameLayout(this);
        newScreen.shell = frameLayout;
        frameLayout.addView(newScreen.buildChatView(), new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = newScreen.shell;
        if (frameLayout2 == null) {
            i.b.g("shell");
            throw null;
        }
        frameLayout2.addView(newScreen.buildPanel(), new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout3 = newScreen.shell;
        if (frameLayout3 == null) {
            i.b.g("shell");
            throw null;
        }
        setRootContent(frameLayout3, 0, newScreen.isDarkBg() ? newScreen.palette.navigationBarColor : newScreen.bgColor, newScreen.isDarkBg() ? newScreen.palette.lightBars : !newScreen.lightBars, true);
        newScreen.activityRef = new ActivityRef(this);
        newScreen.active = true;
        AppState.chatForeground = true;
        ChatNotifier.INSTANCE.clearChatNotifications(getApplicationContext());
        String groupPic = "";
        try {
            String cacheKey = "chatcache_" + str5;
            SharedPreferences prefs = AppState.prefs;
            if (prefs == null) {
                i.b.g("sp");
                throw null;
            }
            String string = prefs.getString(cacheKey, "");
            if (string == null) {
                string = "";
            }
            if (string.length() != 0) {
                JSONObject cacheJson = new JSONObject(string);
                JSONArray messagesArray = cacheJson.optJSONArray("msgs");
                if (messagesArray != null && messagesArray.length() != 0) {
                    ArrayList messages = newScreen.messages;
                    int length = messagesArray.length();
                    for (int i7 = 0; i7 < length; i7++) {
                        JSONObject optJSONObject2 = messagesArray.optJSONObject(i7);
                        if (optJSONObject2 != null && !((HashSet) newScreen.seenIds.a()).contains(Long.valueOf(optJSONObject2.optLong("id")))) {
                            messages.add(ChatScreen.messageFromJson(optJSONObject2));
                        }
                    }
                    if (messages.size() > 1) {
                        c.g.F(messages, new SortComparator(1));
                    }
                    JSONObject reactionsJson = cacheJson.optJSONObject("r");
                    if (reactionsJson != null) {
                        Iterator it2 = messages.iterator();
                        while (it2.hasNext()) {
                            ChatMessage message = (ChatMessage) it2.next();
                            JSONArray reactionsArray = reactionsJson.optJSONArray(String.valueOf(message.id));
                            if (reactionsArray != null) {
                                ArrayList arrayList2 = new ArrayList();
                                int length2 = reactionsArray.length();
                                for (int i8 = 0; i8 < length2; i8++) {
                                    JSONArray pair = reactionsArray.optJSONArray(i8);
                                    if (pair != null) {
                                        arrayList2.add(new b.b(pair.optString(0), pair.optString(1)));
                                    }
                                }
                                newScreen.reactions.put(Long.valueOf(message.id), arrayList2);
                            }
                        }
                    }
                    JSONArray membersArray = cacheJson.optJSONArray("mem");
                    if (membersArray != null) {
                        ArrayList arrayList3 = new ArrayList();
                        int length3 = membersArray.length();
                        for (int i9 = 0; i9 < length3; i9++) {
                            JSONObject memberJson = membersArray.optJSONObject(i9);
                            if (memberJson != null) {
                                String memberName = memberJson.optString("u");
                                arrayList3.add(memberName);
                                newScreen.displayNames.put(memberName, memberJson.optString("n", memberName));
                                String memberPic = memberJson.optString("p", "");
                                if (memberPic.length() > 0) {
                                    newScreen.memberPics.put(memberName, memberPic);
                                }
                            }
                        }
                        newScreen.members = arrayList3;
                    }
                    JSONObject seenJson = cacheJson.optJSONObject("seen");
                    if (seenJson != null) {
                        Iterator<String> keys = seenJson.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            newScreen.lastSeen.put(next, Long.valueOf(seenJson.optLong(next)));
                        }
                    }
                    JSONObject groupJson = cacheJson.optJSONObject("g");
                    String groupName = groupJson == null ? "" : groupJson.optString("name", "");
                    if (groupName == null) {
                        groupName = "";
                    }
                    newScreen.groupName = groupName;
                    if (groupJson != null) {
                        String pic = groupJson.optString("pic", "");
                        if (pic != null) {
                            groupPic = pic;
                        }
                    }
                    newScreen.groupPic = groupPic;
                    if (groupPic.length() > 0) {
                        AvatarView avatarView = newScreen.groupPicView;
                        if (avatarView == null) {
                            i.b.g("headPic");
                            throw null;
                        }
                        ChatMedia.loadAvatar(avatarView, newScreen.groupPic);
                    }
                    newScreen.hasMore = cacheJson.optBoolean("more", true);
                    newScreen.cacheLoaded = !messages.isEmpty();
                    newScreen.refreshMessages();
                    newScreen.applyScroll(true);
                }
            }
        } catch (Exception unused) {
        }
        ArrayList outbox = newScreen.outbox;
        if (!newScreen.outboxLoaded) {
            newScreen.outboxLoaded = true;
            try {
                String outboxKey = "outbox_" + newScreen.username;
                SharedPreferences prefs2 = AppState.prefs;
                if (prefs2 == null) {
                    i.b.g("sp");
                    throw null;
                }
                String string2 = prefs2.getString(outboxKey, "[]");
                if (string2 == null) {
                    string2 = "[]";
                }
                JSONArray outboxArray = new JSONArray(string2);
                int length4 = outboxArray.length();
                for (int i10 = 0; i10 < length4; i10++) {
                    JSONObject entryJson = outboxArray.optJSONObject(i10);
                    if (entryJson != null) {
                        JSONObject bodyJson = entryJson.optJSONObject("b");
                        if (bodyJson != null) {
                            newScreen.localIdCounter = newScreen.localIdCounter + 1;
                            long localId = newScreen.localIdBase + newScreen.localIdCounter;
                            ArrayList mediaList = new ArrayList();
                            JSONArray mediaArray = bodyJson.optJSONArray("media");
                            if (mediaArray != null) {
                                for (int i11 = 0; i11 < mediaArray.length(); i11++) {
                                    mediaList.add(mediaArray.optString(i11));
                                }
                            }
                            ArrayList waveList = new ArrayList();
                            JSONArray waveArray = bodyJson.optJSONArray("wave");
                            if (waveArray != null) {
                                for (int i12 = 0; i12 < waveArray.length(); i12++) {
                                    waveList.add(Integer.valueOf(waveArray.optInt(i12)));
                                }
                            }
                            long optLong = entryJson.optLong("ts", System.currentTimeMillis());
                            newScreen.messages.add(new ChatMessage(localId, newScreen.username, bodyJson.optString("type"), bodyJson.optString("text"), mediaList, waveList, bodyJson.optInt("dur"), bodyJson.optLong("reply", 0L), optLong, entryJson.optString("u"), entryJson.optString("t"), entryJson.optString("x"), entryJson.optBoolean("d")));
                            outbox.add(new OutboxEntry(localId, bodyJson, optLong, entryJson.optString("u"), entryJson.optString("t"), entryJson.optString("x"), entryJson.optBoolean("d")));
                        }
                    }
                }
            } catch (Exception unused2) {
            }
            if (outbox.isEmpty()) {
                newScreen.refreshMessages();
                newScreen.applyScroll(true);
            }
        }
        chatScreen = newScreen;
        chatScreen.startSync();
        chatScreen.refreshMembers();
        chatScreen.handler.post(chatScreen.pollRunnable);
    }

    public final void showHome() {
        JSONObject appJson;
        JSONObject jSONObject2 = AppState.meJson;
        if (jSONObject2 == null || (appJson = jSONObject2.optJSONObject("app")) == null || !AppState.isUpdateAvailable(appJson)) {
            appJson = null;
        }
        if (appJson != null) {
            showUpdate();
            return;
        }
        JSONObject account = AppState.accountFor(this.username);
        if (account == null || AppState.isLockedOrExpired(account)) {
            showLocked(account != null && account.optBoolean("known", true));
            return;
        }
        ChatScreen chatScreen = this.chatScreen;
        if (chatScreen != null) {
            chatScreen.destroy();
        }
        this.chatScreen = null;
        TerminalManager terminalManager = TerminalManager.INSTANCE;
        TerminalManager.keepAlive = true;
        terminalManager.syncServiceState();
        this.screen = "home";
        this.emojiToggle = null;
        clearScreenRefs();
        this.storageGranted = Workspace.hasStorageAccess(this);
        long optLong = account.optLong("expires_at", 0L);
        LinearLayout V = column();
        V.setBackgroundColor(AppState.darkTheme ? -15066598 : -1);
        LinearLayout V2 = column();
        V2.setBackgroundColor(AppState.darkTheme ? -14540254 : -789258);
        V2.setPadding(dp(20), dp(14), dp(20), dp(14));
        LinearLayout r2 = row();
        r2.addView(makeIcon("logo", -43230, 30, 2.0f), layoutParams(this, dp(30), dp(30), 0, 0, 0, 60));
        View U = makeText("NixHost", 26.0f, AppState.mainTextColor(), true);
        int i8 = this.wrapContent;
        r2.addView(U, layoutParams(this, i8, i8, 0, 10, 0, 48));
        r2.addView(new View(this), new LinearLayout.LayoutParams(0, 1, 1.0f));
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackground(roundedBg(AppState.darkTheme ? -13750738 : -1710101, 10, 0, 0));
        frameLayout.addView(makeIcon("folder", -429290, 20, 2.0f), new FrameLayout.LayoutParams(dp(20), dp(20), 17));
        setAction(frameLayout, new ActivityAction(this, 2));
        r2.addView(frameLayout, layoutParams(this, dp(36), dp(36), 0, 0, 10, 32));
        FrameLayout frameLayout2 = new FrameLayout(this);
        frameLayout2.setBackground(roundedBg(AppState.darkTheme ? -13750738 : -1710101, 10, 0, 0));
        frameLayout2.addView(makeIcon("chatdots", -429290, 22, 2.4f), new FrameLayout.LayoutParams(dp(22), dp(22), 17));
        setAction(frameLayout2, new ActivityAction(this, 3));
        r2.addView(frameLayout2, layoutParams(this, dp(36), dp(36), 0, 0, 12, 32));
        FrameLayout frameLayout3 = new FrameLayout(this);
        frameLayout3.setBackground(roundedBg(AppState.darkTheme ? -3025445 : -429290, 16, 0, 0));
        FrameLayout frameLayout4 = new FrameLayout(this);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        frameLayout4.setBackground(gradientDrawable);
        boolean dark = AppState.darkTheme;
        frameLayout4.addView(makeIcon(dark ? "moon" : "sun", dark ? -13156015 : -429290, 18, 2.0f), new FrameLayout.LayoutParams(dp(18), dp(18), 17));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dp(26), dp(26), (AppState.darkTheme ? 8388611 : 8388613) | 16);
        layoutParams.setMargins(dp(3), 0, dp(3), 0);
        frameLayout3.addView(frameLayout4, layoutParams);
        frameLayout3.setOnClickListener(new a.ActivityClickListener(this, 0));
        r2.addView(frameLayout3, layoutParams(this, dp(56), dp(32), 0, 0, 0, 60));
        View t2 = makeIcon("up", AppState.mainTextColor(), 28, 2.2f);
        r2.addView(t2, layoutParams(this, dp(28), dp(28), 0, 12, 0, 48));
        V2.addView(r2);
        LinearLayout r3 = row();
        r3.addView(makeIcon("user", -429290, 20, 2.0f), layoutParams(this, dp(20), dp(20), 0, 0, 0, 60));
        View U2 = makeText(this.username, 16.0f, AppState.subTextColor(), false);
        int i9 = this.wrapContent;
        r3.addView(U2, layoutParams(this, i9, i9, 0, 8, 0, 48));
        r3.addView(makeIcon("cal", -429290, 20, 2.0f), layoutParams(this, dp(20), dp(20), 0, 20, 0, 48));
        String expiryText;
        if (optLong > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            expiryText = StringPlus.stringPlus("expire ", simpleDateFormat.format(new Date(optLong)));
        } else {
            expiryText = "no expiry";
        }
        View U3 = makeText(expiryText, 16.0f, AppState.subTextColor(), false);
        int i10 = this.wrapContent;
        r3.addView(U3, layoutParams(this, i10, i10, 0, 8, 0, 48));
        V2.addView(r3, layoutParams(this, this.matchParent, this.wrapContent, 12, 0, 0, 56));
        i.g gVar = new i.g();
        gVar.f850b = new ValueProvider(2);
        setAction(t2, new RefAction(1, gVar));
        V.addView(V2, layoutParams(this, this.matchParent, this.wrapContent, 0, 0, 0, 60));
        View view2 = new View(this);
        view2.setBackgroundColor(AppState.darkTheme ? -13684945 : -1710101);
        V.addView(view2, layoutParams(this, this.matchParent, 1, 0, 0, 0, 60));
        ScrollView scrollView = new ScrollView(this);
        LinearLayout V3 = column();
        V3.setPadding(dp(20), dp(26), dp(20), dp(110));
        scrollView.addView(V3, new FrameLayout.LayoutParams(this.matchParent, this.wrapContent));
        V.addView(scrollView, new LinearLayout.LayoutParams(this.matchParent, 0, 1.0f));
        JSONObject jSONObject3 = AppState.meJson;
        JSONArray instancesArray;
        if (jSONObject3 == null || (instancesArray = jSONObject3.optJSONArray("instances")) == null) {
            instancesArray = new JSONArray();
        }
        final JSONArray jSONArray3 = instancesArray;
        final int optInt = account.optInt("instance_count", 0);
        final boolean limitReached = optInt <= 0 || jSONArray3.length() >= optInt;
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        LinearLayout V4 = column();
        V4.addView(makeText("Terminal\nInstances", 28.0f, AppState.mainTextColor(), true));
        V4.addView(makeText(jSONArray3.length() + " / " + optInt + " instances used", 16.0f, AppState.subTextColor(), false), layoutParams(this, this.matchParent, this.wrapContent, 6, 0, 0, 56));
        linearLayout2.addView(V4, new LinearLayout.LayoutParams(0, this.wrapContent, 1.0f));
        boolean onlineNow = isOnline();
        this.online = onlineNow;
        boolean offline = !onlineNow;
        LinearLayout r4 = row();
        r4.setGravity(17);
        r4.setPadding(dp(14), dp(10), dp(14), dp(10));
        int newInstanceBg = (limitReached || offline) ? (AppState.darkTheme ? -13882321 : -1710101) : -429290;
        r4.setBackground(roundedBg(newInstanceBg, 16, 0, 0));
        if (!limitReached && !offline) {
            r4.setElevation(dp(6));
        }
        int newInstanceColor = (limitReached || offline) ? (AppState.darkTheme ? -7697776 : -9735552) : -1;
        r4.addView(makeIcon(offline ? "wifioff" : limitReached ? "lock" : "plus", newInstanceColor, 22, 2.2f), layoutParams(this, dp(22), dp(22), 0, 0, 10, 32));
        TextView U4 = makeText("New\nInstance", 16.0f, newInstanceColor, true);
        U4.setGravity(17);
        int i11 = this.wrapContent;
        r4.addView(U4, layoutParams(this, i11, i11, 0, 0, 0, 60));
        setAction(r4, new h.a() {
            @Override
            public final Object a() {
                int i12 = MainActivity.R;
                MainActivity mainActivity = MainActivity.this;
                if (!mainActivity.isOnline()) {
                    mainActivity.toast("Internet is needed to create an instance");
                } else if (limitReached) {
                    mainActivity.toast(optInt <= 0 ? "No instances allowed on your plan" : "Maximum instances reached");
                } else {
                    mainActivity.showInputDialog("New Instance", "Instance name", "", "Save", new a.TextInputAction(jSONArray3, mainActivity, 3));
                }
                return b.d.f770c;
            }
        });
        int i12 = this.wrapContent;
        linearLayout2.addView(r4, layoutParams(this, i12, i12, 2, 12, 0, 48));
        V3.addView(linearLayout2, layoutParams(this, this.matchParent, this.wrapContent, 0, 0, 0, 60));
        LinearLayout V5 = column();
        boolean onlineNow2 = isOnline();
        this.online = onlineNow2;
        View profileAnchor = t2;
        if (onlineNow2) {
            if (jSONArray3.length() == 0) {
                View t3 = makeIcon("logo", -43230, 96, 1.8f);
                LinearLayout.LayoutParams LimitedInputStream = layoutParams(this, dp(96), dp(96), 90, 0, 0, 56);
                LimitedInputStream.gravity = 1;
                V5.addView(t3, LimitedInputStream);
            }
            for (int i5 = 0; i5 < jSONArray3.length(); i5++) {
                JSONObject instanceJson = jSONArray3.getJSONObject(i5);
                final String instanceId = instanceJson.optString("id");
                final String instanceName = instanceJson.optString("name");
                long createdAt = instanceJson.optLong("created", 0L);
                LinearLayout V6 = column();
                V6.setBackground(null);
                LinearLayout r5 = row();
                r5.setPadding(dp(18), dp(18), dp(18), dp(18));
                r5.addView(makeIcon("logo", -43230, 26, 2.0f), layoutParams(this, dp(26), dp(26), 0, 0, 14, 32));
                LinearLayout V7 = column();
                V7.addView(makeText(instanceName, 24.0f, AppState.darkTheme ? -1 : -15656921, true));
                if (createdAt > 0) {
                    V7.addView(makeText(StringPlus.stringPlus("Created: ", new SimpleDateFormat("MMM d, yyyy, h:mm a", Locale.US).format(new Date(createdAt))), 16.0f, AppState.darkTheme ? -8618878 : -9735552, false), layoutParams(this, this.matchParent, this.wrapContent, 6, 0, 0, 56));
                }
                r5.addView(V7, new LinearLayout.LayoutParams(0, this.wrapContent, 1.0f));
                setAction(r5, new h.a() {
                    @Override
                    public final Object a() {
                        int i15 = MainActivity.R;
                        MainActivity.this.openTerminal(instanceId, instanceName);
                        return b.d.f770c;
                    }
                });
                V6.addView(r5, layoutParams(this, this.matchParent, this.wrapContent, 0, 0, 0, 60));
                View view3 = new View(this);
                view3.setBackgroundColor(AppState.darkTheme ? -11184805 : -3880753);
                V6.addView(view3, layoutParams(this, this.matchParent, 2, 0, 0, 0, 60));
                LinearLayout r6 = row();
                r6.setPadding(dp(18), dp(16), dp(18), dp(16));
                r6.addView(makeIcon("trash", -1096636, 22, 2.0f), layoutParams(this, dp(22), dp(22), 0, 0, 10, 32));
                View U5 = makeText("Delete", 19.0f, -1096636, true);
                int i15 = this.wrapContent;
                r6.addView(U5, layoutParams(this, i15, i15, 0, 0, 0, 60));
                setAction(r6, new h.a() {
                    @Override
                    public final Object a() {
                        int i16 = MainActivity.R;
                        MainActivity mainActivity = MainActivity.this;
                        String message = "\"" + instanceName + "\" will be deleted. Anything running in it will be stopped.";
                        LinkAction deleteAction = new LinkAction(mainActivity, instanceId);
                        MainActivity.showDialog(mainActivity, 0, false, new a.ConfirmDialogContent(mainActivity, "Delete instance?", message, "Delete", -1096636, deleteAction), 3);
                        return b.d.f770c;
                    }
                });
                V6.addView(r6, layoutParams(this, this.matchParent, this.wrapContent, 0, 0, 0, 60));
                V5.addView(V6, layoutParams(this, this.matchParent, this.wrapContent, 16, 0, 0, 56));
            }
        } else {
            LinearLayout V9 = column();
            V9.setBackground(roundedBg(AppState.darkTheme ? -14540254 : -789258, 18, 0, 0));
            V9.setPadding(dp(18), dp(22), dp(18), dp(18));
            LinearLayout r7 = row();
            r7.setGravity(17);
            r7.addView(makeIcon("wifioff", AppState.mainTextColor(), 26, 2.0f), layoutParams(this, dp(26), dp(26), 0, 0, 10, 32));
            View U6 = makeText("Connect to the internet", 20.0f, AppState.mainTextColor(), true);
            int i20 = this.wrapContent;
            r7.addView(U6, layoutParams(this, i20, i20, 0, 0, 0, 60));
            V9.addView(r7, layoutParams(this, this.matchParent, this.wrapContent, 0, 0, 0, 60));
            V9.addView(buttonRow(makeButton("Go to Settings", AppState.darkTheme ? -13750738 : -1710101, AppState.mainTextColor(), false, new ActivityAction(this, 4)), makeButton("Retry", -429290, -1, false, new ActivityAction(this, 5))), layoutParams(this, this.matchParent, this.wrapContent, 20, 0, 0, 56));
            V5.addView(V9, layoutParams(this, this.matchParent, this.wrapContent, 24, 0, 0, 56));
        }
        V3.addView(V5, layoutParams(this, this.matchParent, this.wrapContent, 0, 0, 0, 60));
        FrameLayout frameLayout5 = new FrameLayout(this);
        FrameLayout frameLayout6 = new FrameLayout(this);
        int i17 = this.matchParent;
        frameLayout6.addView(V, new FrameLayout.LayoutParams(i17, i17));
        int i18 = this.matchParent;
        frameLayout5.addView(frameLayout6, new FrameLayout.LayoutParams(i18, i18));
        gVar.f850b = new MultiAction(this, frameLayout5, profileAnchor, 4);
        if (!Workspace.hasStorageAccess(this)) {
            String user = this.username;
            View scrim = new View(this);
            scrim.setBackgroundColor(Integer.MIN_VALUE);
            scrim.setClickable(true);
            scrim.setFocusable(true);
            scrim.setAlpha(0.0f);
            int i19 = this.matchParent;
            frameLayout5.addView(scrim, new FrameLayout.LayoutParams(i19, i19));
            LinearLayout V8 = column();
            float radius = dp(28);
            GradientDrawable sheetBg = new GradientDrawable();
            sheetBg.setColor(AppState.darkTheme ? -14540254 : -1);
            sheetBg.setCornerRadii(new float[]{radius, radius, radius, radius, 0.0f, 0.0f, 0.0f, 0.0f});
            sheetBg.setStroke(dp(1), AppState.darkTheme ? -13684945 : -1710101);
            V8.setBackground(sheetBg);
            V8.setElevation(dp(16));
            V8.setClickable(true);
            V8.setPadding(dp(24), dp(12), dp(24), dp(24));
            View handle = new View(this);
            handle.setBackground(roundedBg(AppState.darkTheme ? -13684945 : -1710101, 3, 0, 0));
            LinearLayout.LayoutParams handleParams = new LinearLayout.LayoutParams(dp(40), dp(5));
            handleParams.gravity = 1;
            handleParams.bottomMargin = dp(18);
            V8.addView(handle, handleParams);
            V8.addView(makeText("Keep your files safe", 20.0f, AppState.darkTheme ? -1 : -15656921, true));
            V8.addView(makeText("Allow \"All files access\" so your files are saved in NixHost/" + user + " on your phone and stay after reinstall.", 15.0f, AppState.darkTheme ? -8618878 : -9735552, false), layoutParams(this, this.matchParent, this.wrapContent, 8, 0, 0, 56));
            V8.addView(makeButton("Allow", -429290, -1, false, new ActivityAction(this, 10)), layoutParams(this, this.matchParent, dp(52), 20, 0, 0, 56));
            V8.setVisibility(4);
            frameLayout5.addView(V8, new FrameLayout.LayoutParams(i19, this.wrapContent, 80));
            V8.post(new a.BackgroundTask(V8, scrim, frameLayout6, 7));
        }
        boolean dark2 = AppState.darkTheme;
        setRootContent(frameLayout5, dark2 ? -789258 : -14540254, dark2 ? -1 : -15066598, !dark2, false);
    }

    public final void showLocked(boolean z) {
        String str;
        String str2;
        TerminalManager terminalManager = TerminalManager.INSTANCE;
        TerminalManager.keepAlive = false;
        terminalManager.syncServiceState();
        this.screen = "locked";
        clearScreenRefs();
        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);
        scrollView.setBackgroundColor(AppState.darkTheme ? -15066598 : -1);
        LinearLayout V = column();
        V.setGravity(17);
        V.setPadding(dp(28), dp(28), dp(28), dp(28));
        int i2 = this.matchParent;
        scrollView.addView(V, new FrameLayout.LayoutParams(i2, i2));
        FrameLayout frameLayout = new FrameLayout(this);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(871985942);
        frameLayout.setBackground(gradientDrawable);
        frameLayout.addView(makeIcon("lock", -429290, 34, 2.0f), new FrameLayout.LayoutParams(dp(34), dp(34), 17));
        V.addView(frameLayout, layoutParams(this, dp(72), dp(72), 0, 0, 0, 60));
        TextView U = makeText(z ? "Account expired or locked" : "Account not found", 24.0f, AppState.darkTheme ? -1 : -15656921, true);
        U.setGravity(17);
        V.addView(U, layoutParams(this, this.matchParent, this.wrapContent, 18, 0, 0, 56));
        JSONObject jSONObject = AppState.meJson;
        JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("contact") : null;
        if (optJSONObject == null || (str = optJSONObject.optString("message", "")) == null) {
            str = "";
        }
        if (str.length() == 0) {
            str = "Please contact the admin to renew.";
        }
        TextView U2 = makeText(str, 16.0f, AppState.darkTheme ? -8618878 : -9735552, false);
        U2.setGravity(17);
        V.addView(U2, layoutParams(this, this.matchParent, this.wrapContent, 10, 0, 0, 56));
        if (optJSONObject == null || (str2 = optJSONObject.optString("whatsapp", "")) == null) {
            str2 = "";
        }
        if (str2.length() > 0) {
            V.addView(whatsAppButton("Contact", new a.LinkAction(2, this, str2)), layoutParams(this, this.matchParent, dp(56), 22, 0, 0, 56));
        }
        V.addView(buttonRow(makeButton("Logout", 0, AppState.darkTheme ? -1 : -15656921, true, new ActivityAction(this, 11)), makeButton("Check again", -429290, -1, false, new ActivityAction(this, 12))), layoutParams(this, this.matchParent, this.wrapContent, 14, 0, 0, 56));
        boolean z2 = AppState.darkTheme;
        setRootContent(scrollView, z2 ? -15066598 : -1, z2 ? -15066598 : -1, !z2, false);
    }

    public final void showLogin() {
        TerminalManager terminalManager = TerminalManager.INSTANCE;
        TerminalManager.keepAlive = false;
        terminalManager.syncServiceState();
        this.screen = "login";
        clearScreenRefs();
        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TL_BR;
        scrollView.setBackground(new GradientDrawable(orientation, new int[]{-429290, -2349530}));
        FrameLayout frameLayout = new FrameLayout(this);
        int i2 = this.matchParent;
        scrollView.addView(frameLayout, new FrameLayout.LayoutParams(i2, i2));
        LinearLayout V = column();
        V.setGravity(1);
        V.setBackground(roundedBg(-1, 28, 0, 0));
        V.setPadding(dp(28), dp(36), dp(28), dp(32));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.matchParent, this.wrapContent, 17);
        layoutParams.setMargins(dp(20), dp(24), dp(20), dp(24));
        frameLayout.addView(V, layoutParams);
        V.addView(makeIcon("logo", -43230, 46, 2.0f), layoutParams(this, dp(46), dp(46), 0, 0, 0, 60));
        View U = makeText("NixHost", 32.0f, -14800581, true);
        int i3 = this.wrapContent;
        V.addView(U, layoutParams(this, i3, i3, 18, 0, 0, 56));
        View U2 = makeText("Terminal Manager", 17.0f, -9735552, false);
        int i4 = this.wrapContent;
        V.addView(U2, layoutParams(this, i4, i4, 4, 0, 0, 56));
        V.addView(makeText("Username", 16.0f, -13156015, true), layoutParams(this, this.matchParent, this.wrapContent, 30, 0, 0, 56));
        EditText userInput = makeInput(this, "Enter username");
        userInput.setInputType(524289);
        V.addView(userInput, layoutParams(this, this.matchParent, dp(56), 8, 0, 0, 56));
        V.addView(makeText("Password", 16.0f, -13156015, true), layoutParams(this, this.matchParent, this.wrapContent, 18, 0, 0, 56));
        EditText passInput = makeInput(this, "Enter password");
        passInput.setInputType(129);
        passInput.setPadding(dp(16), dp(14), dp(52), dp(14));
        FrameLayout frameLayout2 = new FrameLayout(this);
        int i5 = this.matchParent;
        frameLayout2.addView(passInput, new FrameLayout.LayoutParams(i5, i5));
        IconView eyeIcon = makeIcon("eye", -9735552, 24, 2.0f);
        eyeIcon.setPadding(dp(4), dp(4), dp(4), dp(4));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dp(36), dp(36), 8388629);
        layoutParams2.rightMargin = dp(8);
        frameLayout2.addView(eyeIcon, layoutParams2);
        eyeIcon.setOnClickListener(new a.TripleClickListener(new i.d(), passInput, eyeIcon, 2));
        V.addView(frameLayout2, layoutParams(this, this.matchParent, dp(56), 8, 0, 0, 56));
        TextView errorText = makeText("", 14.0f, -2349530, false);
        errorText.setVisibility(8);
        V.addView(errorText, layoutParams(this, this.matchParent, this.wrapContent, 12, 0, 0, 56));
        FrameLayout loginButton = new FrameLayout(this);
        GradientDrawable gradientDrawable = new GradientDrawable(orientation, new int[]{-429290, -2349530});
        gradientDrawable.setCornerRadius(dp(16));
        loginButton.setBackground(gradientDrawable);
        TextView loginLabel = makeText("Login", 20.0f, -1, true);
        int i6 = this.wrapContent;
        loginButton.addView(loginLabel, new FrameLayout.LayoutParams(i6, i6, 17));
        ProgressBar progressBar = new ProgressBar(this);
        progressBar.setIndeterminate(true);
        progressBar.setIndeterminateTintList(ColorStateList.valueOf(-1));
        progressBar.setVisibility(8);
        loginButton.addView(progressBar, new FrameLayout.LayoutParams(dp(28), dp(28), 17));
        V.addView(loginButton, layoutParams(this, this.matchParent, dp(56), 22, 0, 0, 56));
        setAction(loginButton, new a.SubmitAction(new i.d(), userInput, passInput, errorText, loginLabel, progressBar, this));
        setRootContent(scrollView, -429290, -2349530, false, false);
    }

    public final void showUpdate() {
        JSONObject optJSONObject;
        JSONObject jSONObject = AppState.meJson;
        JSONObject appJson = (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("app")) == null || !AppState.isUpdateAvailable(optJSONObject)) ? null : optJSONObject;
        if (appJson == null) {
            return;
        }
        ChatScreen chatScreen = this.chatScreen;
        if (chatScreen != null) {
            chatScreen.destroy();
        }
        this.chatScreen = null;
        TerminalManager.INSTANCE.closeAllSessions();
        try {
            startService(new Intent(this, (Class<?>) HostService.class).setAction("com.nix.host.STOP"));
        } catch (Exception unused) {
        }
        TerminalManager terminalManager = TerminalManager.INSTANCE;
        TerminalManager.keepAlive = false;
        terminalManager.syncServiceState();
        this.screen = "update";
        this.emojiToggle = null;
        clearScreenRefs();
        LinearLayout V = column();
        V.setBackgroundColor(AppState.darkTheme ? -15066598 : -1);
        LinearLayout r2 = row();
        r2.setBackgroundColor(AppState.darkTheme ? -14540254 : -789258);
        r2.setPadding(dp(20), dp(14), dp(20), dp(14));
        r2.addView(makeIcon("logo", -43230, 30, 2.0f), layoutParams(this, dp(30), dp(30), 0, 0, 0, 60));
        View U = makeText("NixHost", 26.0f, AppState.mainTextColor(), true);
        int i2 = this.wrapContent;
        r2.addView(U, layoutParams(this, i2, i2, 0, 10, 0, 48));
        V.addView(r2, layoutParams(this, this.matchParent, this.wrapContent, 0, 0, 0, 60));
        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);
        LinearLayout V2 = column();
        V2.setGravity(17);
        V2.setPadding(dp(14), dp(14), dp(14), dp(14));
        scrollView.addView(V2, new FrameLayout.LayoutParams(this.matchParent, this.wrapContent));
        LinearLayout V3 = column();
        V3.setGravity(17);
        V3.setBackground(roundedBg(AppState.darkTheme ? -14540254 : -789258, 24, 0, 0));
        V3.setPadding(dp(22), dp(24), dp(22), dp(24));
        V2.addView(V3, new LinearLayout.LayoutParams(this.matchParent, this.wrapContent));
        V.addView(scrollView, new LinearLayout.LayoutParams(this.matchParent, 0, 1.0f));
        String optString = appJson.optString("name", "NixHost");
        String appName = optString.length() != 0 ? optString : "NixHost";
        String optString2 = appJson.optString("version", "");
        String optString3 = appJson.optString("note", "");
        String optString4 = appJson.optString("whatsapp", "");
        V3.addView(makeIcon("logo", -43230, 64, 2.0f), layoutParams(this, dp(64), dp(64), 0, 0, 0, 60));
        TextView U2 = makeText(appName, 24.0f, AppState.mainTextColor(), true);
        U2.setGravity(17);
        V3.addView(U2, layoutParams(this, this.matchParent, this.wrapContent, 10, 0, 0, 56));
        TextView U3 = makeText("New version " + optString2, 18.0f, -429290, true);
        U3.setGravity(17);
        V3.addView(U3, layoutParams(this, this.matchParent, this.wrapContent, 4, 0, 0, 56));
        if (optString3.length() == 0) {
            optString3 = "Please install the new version. This version does not work any more.";
        }
        TextView U4 = makeText(optString3, 16.0f, AppState.subTextColor(), false);
        U4.setGravity(17);
        V3.addView(U4, layoutParams(this, this.matchParent, this.wrapContent, 10, 0, 0, 56));
        if (optString4.length() > 0) {
            V3.addView(whatsAppButton("Join WhatsApp Channel", new a.LinkAction(1, this, optString4)), layoutParams(this, this.matchParent, dp(56), 18, 0, 0, 56));
        }
        TextView U5 = makeText("Join the channel to get the new version. The old version stays stopped until you install it.", 14.0f, AppState.subTextColor(), false);
        U5.setGravity(17);
        V3.addView(U5, layoutParams(this, this.matchParent, this.wrapContent, 10, 0, 0, 56));
        boolean z = AppState.darkTheme;
        setRootContent(V, z ? -15066598 : -1, z ? -15066598 : -1, !z, false);
    }

    public final void showFileView(File file) {
        String name;
        String canonicalPath;
        File file2;
        if (file.length() > 500000) {
            toast("File too big to open here");
            return;
        }
        try {
            String content = g.m.I(file);
            if (m.e.P(content, (char) 0, 0, false, 6) >= 0) {
                toast("Cannot open this file");
                return;
            }
            this.screen = "view";
            clearScreenRefs();
            this.popupMenu = null;
            this.editorSession = null;
            FrameLayout frameLayout = new FrameLayout(this);
            LinearLayout V = column();
            V.setBackgroundColor(-15263716);
            LinearLayout r2 = row();
            r2.setPadding(dp(14), dp(14), dp(10), dp(14));
            FrameLayout frameLayout2 = new FrameLayout(this);
            frameLayout2.addView(makeIcon("arrow", -263172, 26, 2.0f), new FrameLayout.LayoutParams(dp(26), dp(26), 17));
            setAction(frameLayout2, new ActivityAction(this, 0));
            r2.addView(frameLayout2, layoutParams(this, dp(40), dp(40), 0, 0, 0, 60));
            try {
                canonicalPath = file.getCanonicalPath();
                file2 = this.homeDir;
            } catch (Exception unused) {
                name = file.getName();
            }
            if (file2 == null) {
                i.b.g("homeDir");
                throw null;
            }
            name = m.e.k0(m.e.X(canonicalPath, file2.getCanonicalPath()), '/');
            if (name.length() == 0) {
                name = file.getName();
            }
            TextView U = makeText(name, 20.0f, -263172, true);
            U.setSingleLine(true);
            U.setEllipsize(TextUtils.TruncateAt.START);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, this.wrapContent, 1.0f);
            layoutParams.leftMargin = dp(10);
            r2.addView(U, layoutParams);
            FrameLayout frameLayout3 = new FrameLayout(this);
            frameLayout3.addView(makeIcon("dots", -15896869, 24, 2.0f), new FrameLayout.LayoutParams(dp(24), dp(24), 17));
            r2.addView(frameLayout3, layoutParams(this, dp(40), dp(40), 0, 0, 0, 60));
            V.addView(r2, layoutParams(this, this.matchParent, this.wrapContent, 0, 0, 0, 60));
            ArrayList arrayList = new ArrayList(m.e.b0(m.m.J(m.m.I(m.m.J(content, "\r\n", "\n"), (char) 13, (char) 10), "\t", "    "), new String[]{"\n"}));
            if (arrayList.size() > 1 && ((CharSequence) c.b.M(arrayList)).length() == 0) {
                arrayList.remove(arrayList.size() - 1);
            }
            java.util.Set set = SyntaxHighlighter.jsKeywords;
            ArrayList highlighted = SyntaxHighlighter.highlight(arrayList, file.getName());
            ListView listView = new ListView(this);
            listView.setDivider(null);
            listView.setDividerHeight(0);
            listView.setBackgroundColor(-15263716);
            listView.setSelector(new ColorDrawable(0));
            listView.setOverScrollMode(2);
            listView.setAdapter((ListAdapter) new CodeLinesAdapter(this, highlighted, String.valueOf(arrayList.size()).length()));
            int i3 = this.matchParent;
            V.addView(listView, new LinearLayout.LayoutParams(i3, 0, 1.0f));
            frameLayout.addView(V, new FrameLayout.LayoutParams(i3, i3));
            showPopupMenu(frameLayout, frameLayout3, c.c.C(new b.b("Edit file", -263172), new b.b("Delete file", -1014126), new b.b("Copy", -263172)), new a.ValueAction(this, file, content));
            setRootContent(frameLayout, -15263716, -15263716, false, false);
        } catch (Exception unused2) {
            toast("Cannot open this file");
        }
    }

    public final void toast(String str) {
        Toast.makeText(this, str, 1).show();
    }

    public final TextView makeText(String str, float f2, int i2, boolean z) {
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(1, this.uiScale * f2);
        textView.setTextColor(i2);
        if (z) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        return textView;
    }

    public final LinearLayout column() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        return linearLayout;
    }

    public final LinearLayout whatsAppButton(String str, h.a aVar) {
        LinearLayout r2 = row();
        r2.setGravity(17);
        r2.setBackground(roundedBg(-14298266, 16, 0, 0));
        r2.addView(makeIcon("wa", -1, 26, 2.0f), layoutParams(this, dp(26), dp(26), 0, 0, 0, 60));
        TextView U = makeText(str, 20.0f, -1, true);
        int i2 = this.wrapContent;
        r2.addView(U, layoutParams(this, i2, i2, 0, 10, 0, 48));
        setAction(r2, aVar);
        return r2;
    }

    public final boolean isWifiConnected() {
        try {
            Object systemService = getSystemService("connectivity");
            i.b.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            for (Network network : connectivityManager.getAllNetworks()) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                if (networkCapabilities != null && (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(3))) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public final void showPopupMenu(FrameLayout frameLayout, FrameLayout frameLayout2, List list, final h.b bVar) {
        View view = new View(this);
        view.setVisibility(8);
        view.setOnClickListener(new a.ActivityClickListener(this, 1));
        int i2 = this.matchParent;
        frameLayout.addView(view, new FrameLayout.LayoutParams(i2, i2));
        LinearLayout V = column();
        V.setVisibility(8);
        V.setBackground(roundedBg(-13684937, 10, 0, 0));
        V.setElevation(dp(10));
        V.setPadding(0, dp(6), 0, dp(6));
        V.setMinimumWidth(dp(190));
        Iterator it = list.iterator();
        int index = 0;
        while (it.hasNext()) {
            b.b bVar2 = (b.b) it.next();
            TextView U = makeText((String) bVar2.f764a, 18.0f, ((Number) bVar2.f765b).intValue(), false);
            U.setPadding(dp(26), dp(17), dp(40), dp(17));
            final int itemIndex = index;
            setAction(U, new h.a() {
                @Override
                public final Object a() {
                    int i4 = MainActivity.R;
                    MainActivity.this.hidePopupMenu();
                    bVar.a(Integer.valueOf(itemIndex));
                    return b.d.f770c;
                }
            });
            V.addView(U, layoutParams(this, this.matchParent, this.wrapContent, 0, 0, 0, 60));
            index++;
        }
        int i4 = this.wrapContent;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i4, 8388661);
        layoutParams.setMargins(0, dp(56), dp(12), 0);
        frameLayout.addView(V, layoutParams);
        this.popupMenu = V;
        this.popupScrim = view;
        setAction(frameLayout2, new a.PanelToggleAction(V, this, 0));
    }

    public final void applyBarColors(int i2, int i3, boolean z) {
        WindowInsetsController insetsController;
        getWindow().setStatusBarColor(i2);
        getWindow().setNavigationBarColor(i3);
        if (Build.VERSION.SDK_INT < 30) {
            int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            getWindow().getDecorView().setSystemUiVisibility(z ? systemUiVisibility | 8208 : systemUiVisibility & (-8209));
        } else if ((insetsController = getWindow().getInsetsController()) != null) {
            insetsController.setSystemBarsAppearance(z ? 24 : 0, 24);
        }
    }

    public final LinearLayout buttonRow(TextView textView, TextView textView2) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dp(48), 1.0f);
        layoutParams.setMargins(0, 0, dp(6), 0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, dp(48), 1.0f);
        layoutParams2.setMargins(dp(6), 0, 0, 0);
        linearLayout.addView(textView, layoutParams);
        linearLayout.addView(textView2, layoutParams2);
        return linearLayout;
    }

    public final void clearScreenRefs() {
        this.termOutput = null;
        this.termScroll = null;
        this.termInput = null;
        this.termInputRow = null;
        this.termBusyRow = null;
        this.termPrompt = null;
        this.termPathLabel = null;
        this.termClockLabel = null;
        this.termKeysPanel = null;
        this.termScrim = null;
    }

    public final void hidePopupMenu() {
        View view = this.popupScrim;
        if (view != null) {
            view.setVisibility(8);
        }
        LinearLayout linearLayout = this.popupMenu;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public final void hideTermKeys() {
        LinearLayout linearLayout = this.termKeysPanel;
        if (linearLayout == null) {
            return;
        }
        View view = this.termScrim;
        if (view != null) {
            view.setVisibility(8);
        }
        linearLayout.animate().alpha(0.0f).translationY(-dp(24)).setDuration(120L).withEndAction(new a.ViewAnimTask(linearLayout, 1)).start();
    }

    public final void showCommitSheet(String str, h.a aVar) {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        LinearLayout V = column();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-13684937);
        float radius = dp(22);
        gradientDrawable.setCornerRadii(new float[]{radius, radius, radius, radius, 0.0f, 0.0f, 0.0f, 0.0f});
        V.setBackground(gradientDrawable);
        V.setPadding(0, dp(10), 0, dp(16));
        View view = new View(this);
        view.setBackground(roundedBg(-9670786, 3, 0, 0));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dp(44), dp(5));
        layoutParams.gravity = 1;
        V.addView(view, layoutParams);
        LinearLayout r2 = row();
        r2.setPadding(dp(18), dp(14), dp(18), dp(14));
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView(makeIcon("close", -263172, 26, 2.0f), new FrameLayout.LayoutParams(dp(26), dp(26), 17));
        setAction(frameLayout, new a.DismissAction(dialog, 10));
        r2.addView(frameLayout, layoutParams(this, dp(40), dp(40), 0, 0, 0, 60));
        TextView U = makeText("Commit changes", 24.0f, -263172, true);
        int i2 = this.wrapContent;
        r2.addView(U, layoutParams(this, i2, i2, 0, 10, 0, 48));
        V.addView(r2, layoutParams(this, this.matchParent, this.wrapContent, 12, 0, 0, 56));
        View view2 = new View(this);
        view2.setBackgroundColor(-12895421);
        V.addView(view2, layoutParams(this, this.matchParent, 1, 0, 0, 0, 60));
        EditText messageInput = makeEditorField(this, "Commit message", str, true);
        V.addView(messageInput, layoutParams(this, this.matchParent, this.wrapContent, 14, 0, 0, 56));
        V.addView(makeEditorField(this, "Add an optional commit description", "", false), layoutParams(this, this.matchParent, this.wrapContent, 4, 0, 0, 56));
        LinearLayout r3 = row();
        r3.setGravity(17);
        r3.setBackground(roundedBg(-14319045, 10, 0, 0));
        r3.setPadding(dp(16), dp(14), dp(16), dp(14));
        r3.addView(makeIcon("commit", -1, 24, 2.0f), layoutParams(this, dp(24), dp(24), 0, 0, 8, 32));
        TextView U2 = makeText("COMMIT", 18.0f, -1, true);
        int i3 = this.wrapContent;
        r3.addView(U2, layoutParams(this, i3, i3, 0, 0, 0, 60));
        setAction(r3, new a.DismissAndRun(dialog, aVar, 1));
        V.addView(r3, layoutParams(this, this.matchParent, this.wrapContent, 18, 18, 18, 32));
        dialog.setContentView(V);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Window window2 = dialog.getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(20);
        }
        dialog.show();
        Window window3 = dialog.getWindow();
        if (window3 != null) {
            window3.setLayout(-1, -2);
        }
        Window window4 = dialog.getWindow();
        if (window4 != null) {
            window4.setGravity(80);
        }
        Window window5 = dialog.getWindow();
        if (window5 != null) {
            window5.setDimAmount(0.55f);
        }
        messageInput.requestFocus();
        messageInput.setSelection(messageInput.getText().length());
    }

    public final TextView makeButton(String str, int i2, int i3, boolean z, h.a aVar) {
        GradientDrawable bg;
        TextView U = makeText(str, 17.0f, i3, true);
        U.setGravity(17);
        if (z) {
            bg = roundedBg(0, 14, AppState.darkTheme ? -12961222 : -1710101, 1);
        } else {
            bg = roundedBg(i2, 14, 0, 0);
        }
        U.setBackground(bg);
        setAction(U, aVar);
        return U;
    }

    public final int dp(int i2) {
        return (int) (i2 * getResources().getDisplayMetrics().density * this.uiScale);
    }

    public final void onAccountStateChanged() {
        JSONObject optJSONObject;
        JSONObject jSONObject = AppState.meJson;
        JSONObject appJson = null;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("app")) != null && AppState.isUpdateAvailable(optJSONObject)) {
            appJson = optJSONObject;
        }
        if (appJson != null) {
            if (i.b.a(this.screen, "update")) {
                return;
            }
            showUpdate();
            return;
        }
        if (i.b.a(this.screen, "update")) {
            showHome();
            return;
        }
        JSONObject account = AppState.accountFor(this.username);
        if (account != null && !AppState.isLockedOrExpired(account)) {
            if (i.b.a(this.screen, "locked")) {
                showHome();
            }
        } else {
            if (i.b.a(this.screen, "locked")) {
                return;
            }
            TerminalManager.INSTANCE.closeAllSessions();
            showLocked(account != null && account.optBoolean("known", true));
        }
    }

    @Override
    public final void onActivityResult(int i2, int i3, Intent intent) {
        Uri data;
        File file;
        ChatScreen chatScreen;
        Uri data2;
        String mimeType;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 78) {
            if (i3 != -1 || (chatScreen = this.chatScreen) == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            ClipData clipData = intent != null ? intent.getClipData() : null;
            if (clipData != null) {
                int min = Math.min(clipData.getItemCount(), 10);
                for (int i4 = 0; i4 < min; i4++) {
                    arrayList.add(clipData.getItemAt(i4).getUri());
                }
            } else if (intent != null && (data2 = intent.getData()) != null) {
                arrayList.add(data2);
            }
            if (arrayList.isEmpty()) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                try {
                    mimeType = chatScreen.activity.getContentResolver().getType(uri);
                } catch (Exception unused) {
                    mimeType = null;
                }
                if (mimeType == null) {
                    mimeType = "";
                }
                if (m.m.K(mimeType, "video/")) {
                    arrayList2.add(uri);
                } else {
                    arrayList3.add(uri);
                }
            }
            if (chatScreen.avatarPickPending) {
                chatScreen.avatarPickPending = false;
                Uri uri2 = (Uri) c.b.I(arrayList3);
                if (uri2 != null) {
                    chatScreen.setAvatarFromUri(uri2);
                }
                return;
            }
            if (!arrayList3.isEmpty()) {
                chatScreen.sendMedia(arrayList3);
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                chatScreen.sendVideo((Uri) it2.next());
            }
            return;
        }
        if (i2 == 79) {
            ChatScreen chatScreen2 = this.chatScreen;
            if (chatScreen2 != null) {
                boolean z = i3 == -1;
                Uri uri3 = chatScreen2.cameraUri;
                if (uri3 == null) {
                    return;
                }
                chatScreen2.cameraUri = null;
                if (!z) {
                    try {
                        chatScreen2.activity.getContentResolver().delete(uri3, null, null);
                    } catch (Exception unused2) {
                    }
                } else if (!chatScreen2.avatarPickPending) {
                    chatScreen2.sendMedia(AppState.p(uri3));
                } else {
                    chatScreen2.avatarPickPending = false;
                    chatScreen2.setAvatarFromUri(uri3);
                }
            }
            return;
        }
        if (i2 != 77 || i3 != -1 || intent == null || (data = intent.getData()) == null || (file = this.uploadTargetDir) == null) {
            return;
        }
        String displayName = "upload.zip";
        try {
            Cursor query = getContentResolver().query(data, new String[]{"_display_name"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(0);
                        if (string != null) {
                            displayName = string;
                        }
                    }
                    AppState.a(query, null);
                } finally {
                }
            }
        } catch (Exception unused3) {
        }
        String sanitized = m.m.I(displayName, '/', '_');
        String lowerCase = sanitized.toLowerCase(Locale.ROOT);
        i.b.d(lowerCase, "toLowerCase(...)");
        if (!lowerCase.endsWith(".zip")) {
            toast("Please choose a .zip file");
            return;
        }
        String baseName = sanitized.substring(0, sanitized.length() - 4);
        i.b.d(baseName, "substring(...)");
        File file2 = new File(file, sanitized);
        int i5 = 1;
        while (file2.exists()) {
            file2 = new File(file, baseName + " (" + i5 + ").zip");
            i5++;
        }
        toast("Uploading " + ((Object) sanitized) + " ...");
        new Thread(new a.BackgroundTask(this, data, file2, 6)).start();
    }

    @Override
    public final void onBackPressed() {
        LinearLayout linearLayout;
        EmojiPanelToggle emojiPanelToggle = this.emojiToggle;
        if (emojiPanelToggle != null) {
            emojiPanelToggle.a();
            return;
        }
        if ((i.b.a(this.screen, "files") || i.b.a(this.screen, "view")) && (linearLayout = this.popupMenu) != null && linearLayout.getVisibility() == 0) {
            hidePopupMenu();
            return;
        }
        String str = this.screen;
        if (i.b.a(str, "edit")) {
            ActionCallback actionCallback = this.editorSession;
            if (actionCallback != null) {
                actionCallback.a();
            } else {
                showFiles();
            }
        } else if (i.b.a(str, "term")) {
            LinearLayout linearLayout2 = this.termKeysPanel;
            if (linearLayout2 != null && linearLayout2.getVisibility() == 0) {
                hideTermKeys();
                return;
            }
            this.termKey = "";
            SharedPreferences sharedPreferences = AppState.prefs;
            if (sharedPreferences == null) {
                i.b.g("sp");
                throw null;
            }
            sharedPreferences.edit().remove("lastTerm").apply();
            showHome();
        } else if (i.b.a(str, "view")) {
            showFiles();
        } else if (i.b.a(str, "files")) {
            File file = this.currentDir;
            if (file != null) {
                String canonicalPath = file.getCanonicalPath();
                File file2 = this.homeDir;
                if (file2 == null) {
                    i.b.g("homeDir");
                    throw null;
                }
                if (!i.b.a(canonicalPath, file2.getCanonicalPath())) {
                    this.currentDir = file.getParentFile();
                    showFiles();
                    return;
                }
            }
            showHome();
        } else if (i.b.a(str, "group")) {
            ChatScreen chatScreen = this.chatScreen;
            if (chatScreen != null) {
                LinearLayout panel = chatScreen.emojiPanel;
                if (panel == null) {
                    i.b.g("panel");
                    throw null;
                }
                if (panel.getVisibility() == 0) {
                    panel.setVisibility(8);
                    return;
                }
                if (!i.b.a(chatScreen.recordState, "idle")) {
                    chatScreen.cancelRecording();
                    return;
                }
            }
            showHome();
        } else if (i.b.a(str, "login") || i.b.a(str, "home") || i.b.a(str, "locked") || i.b.a(str, "update")) {
            super.onBackPressed();
        } else {
            showHome();
        }
    }

    @Override
    public final void onCreate(Bundle bundle) {
        SharedPreferences sharedPreferences;
        super.onCreate(bundle);
        resetAnimationScale();
        AppState.prefs = getSharedPreferences("nixhost", 0);
        ApiClient.loadBaseUrl(this);
        TerminalManager terminalManager = TerminalManager.INSTANCE;
        TerminalManager.appContext = getApplicationContext();
        SharedPreferences sharedPreferences2 = AppState.prefs;
        if (sharedPreferences2 == null) {
            i.b.g("sp");
            throw null;
        }
        String string = sharedPreferences2.getString("dark", "1");
        if (string == null) {
            string = "1";
        }
        AppState.darkTheme = string.equals("1");
        String lastTerm = "";
        if (AppState.appVersion.length() <= 0) {
            try {
                String versionName = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
                if (versionName == null) {
                    versionName = "";
                }
                AppState.appVersion = versionName;
            } catch (Exception unused) {
            }
        }
        File filesDir = getFilesDir();
        try {
            if (new File(filesDir, "c_me.json").exists()) {
                AppState.meJson = new JSONObject(g.m.I(new File(filesDir, "c_me.json")));
            }
        } catch (Exception unused2) {
        }
        if (Build.VERSION.SDK_INT >= 33 && checkSelfPermission("android.permission.POST_NOTIFICATIONS") != 0) {
            requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 1);
        }
        SharedPreferences sharedPreferences3 = AppState.prefs;
        if (sharedPreferences3 == null) {
            i.b.g("sp");
            throw null;
        }
        String string2 = sharedPreferences3.getString("user", "");
        if (string2 == null) {
            string2 = "";
        }
        this.username = string2;
        if (string2.length() > 0) {
            SharedPreferences sharedPreferences4 = AppState.prefs;
            if (sharedPreferences4 == null) {
                i.b.g("sp");
                throw null;
            }
            String string3 = sharedPreferences4.getString("session", "");
            if (string3 == null) {
                string3 = "";
            }
            if (string3.length() > 0 && AppState.accountFor(this.username) != null) {
                i.g gVar = Workspace.namePattern;
                this.homeDir = Workspace.homeDir(this, this.username);
                showHome();
                try {
                    sharedPreferences = AppState.prefs;
                } catch (Exception unused3) {
                    sharedPreferences = null;
                }
                if (sharedPreferences == null) {
                    i.b.g("sp");
                    throw null;
                }
                String string4 = sharedPreferences.getString("lastTerm", "");
                if (string4 != null) {
                    lastTerm = string4;
                }
                int newlineIndex = m.e.P(lastTerm, '\n', 0, false, 6);
                JSONObject account = AppState.accountFor(this.username);
                if (newlineIndex > 0 && account != null && !AppState.isLockedOrExpired(account)) {
                    String instanceId = lastTerm.substring(0, newlineIndex);
                    i.b.d(instanceId, "substring(...)");
                    String instanceName = lastTerm.substring(newlineIndex + 1);
                    i.b.d(instanceName, "substring(...)");
                    JSONArray optJSONArray = account.optJSONArray("instances");
                    boolean found = optJSONArray == null;
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                            if (optJSONObject != null && i.b.a(optJSONObject.optString("id"), instanceId)) {
                                found = true;
                            }
                        }
                    }
                    if (found) {
                        openTerminal(instanceId, instanceName);
                    }
                }
                Intent intent = getIntent();
                if (intent != null && intent.getBooleanExtra("openChat", false)) {
                    showChat();
                }
                this.lastRefreshAt = System.currentTimeMillis();
                new Thread(new UiTask(this, 3)).start();
                return;
            }
        }
        showLogin();
    }

    @Override
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null || !intent.getBooleanExtra("openChat", false) || this.username.length() <= 0 || i.b.a(this.screen, "login") || i.b.a(this.screen, "group")) {
            return;
        }
        showChat();
    }

    @Override
    public final void onPause() {
        super.onPause();
        ChatScreen chatScreen = this.chatScreen;
        if (chatScreen != null) {
            chatScreen.saveCache();
            chatScreen.active = false;
            AppState.chatForeground = false;
            chatScreen.unregisterNetworkCallback();
            chatScreen.handler.removeCallbacks(chatScreen.pollRunnable);
            chatScreen.stopPlayback();
        }
        this.mainHandler.removeCallbacks(this.uiTicker);
    }

    @Override
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        ChatScreen chatScreen;
        ChatScreen chatScreen2;
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 3 && (chatScreen2 = this.chatScreen) != null) {
            boolean granted = (iArr.length != 0) && iArr[0] == 0;
            if (chatScreen2.micPermPending) {
                chatScreen2.micPermPending = false;
                if (granted) {
                    chatScreen2.startRecording(false);
                } else {
                    chatScreen2.toaster.a("Microphone permission is needed for voice messages");
                }
            }
        }
        if (i2 != 4 || (chatScreen = this.chatScreen) == null) {
            return;
        }
        boolean granted2 = (iArr.length != 0) && iArr[0] == 0;
        if (chatScreen.galleryPending) {
            chatScreen.galleryPending = false;
            if (granted2) {
                chatScreen.showMediaPicker();
                return;
            }
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("*/*");
            intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            intent.addCategory("android.intent.category.OPENABLE");
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            try {
                chatScreen.activity.startActivityForResult(intent, 78);
            } catch (Exception unused) {
                chatScreen.toaster.a("No gallery app found");
            }
        }
    }

    @Override
    public final void onResume() {
        ChatScreen chatScreen;
        super.onResume();
        resetAnimationScale();
        if (i.b.a(this.screen, "group") && (chatScreen = this.chatScreen) != null && !chatScreen.active) {
            chatScreen.active = true;
            AppState.chatForeground = true;
            ChatNotifier.INSTANCE.clearChatNotifications(chatScreen.activity.getApplicationContext());
            chatScreen.startSync();
            chatScreen.handler.post(chatScreen.pollRunnable);
        }
        this.mainHandler.post(this.uiTicker);
        if (this.stoppedAt > 0 && System.currentTimeMillis() - this.stoppedAt > 120000) {
            this.expiryWarned = false;
            this.lastRefreshAt = 0L;
        }
        this.stoppedAt = 0L;
        this.mainHandler.postDelayed(new UiTask(this, 4), 700L);
        if (this.username.length() > 0 && i.b.a(this.screen, "home")) {
            Object systemService = getSystemService("power");
            i.b.c(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            if (((PowerManager) systemService).isIgnoringBatteryOptimizations(getPackageName())) {
                SharedPreferences sharedPreferences = AppState.prefs;
                if (sharedPreferences == null) {
                    i.b.g("sp");
                    throw null;
                }
                sharedPreferences.edit().putString("battery", "1").apply();
            } else {
                SharedPreferences sharedPreferences2 = AppState.prefs;
                if (sharedPreferences2 == null) {
                    i.b.g("sp");
                    throw null;
                }
                String string = sharedPreferences2.getString("battery", "");
                if (string == null) {
                    string = "";
                }
                if (string.equals("1")) {
                    SharedPreferences sharedPreferences3 = AppState.prefs;
                    if (sharedPreferences3 == null) {
                        i.b.g("sp");
                        throw null;
                    }
                    sharedPreferences3.edit().putString("battery", "").apply();
                    this.mainHandler.postDelayed(new UiTask(this, 5), 900L);
                }
            }
        }
        if (this.username.length() <= 0 || this.homeDir == null) {
            return;
        }
        i.g gVar = Workspace.namePattern;
        File newHome = Workspace.homeDir(this, this.username);
        String path = newHome.getPath();
        File file = this.homeDir;
        if (file == null) {
            i.b.g("homeDir");
            throw null;
        }
        if (i.b.a(path, file.getPath())) {
            if (!i.b.a(this.screen, "home") || this.storageGranted == Workspace.hasStorageAccess(this)) {
                return;
            }
            showHome();
            return;
        }
        this.homeDir = newHome;
        this.currentDir = null;
        if (i.b.a(this.screen, "home")) {
            showHome();
        }
    }

    @Override
    public final void onStop() {
        super.onStop();
        this.stoppedAt = System.currentTimeMillis();
    }

    public final Typeface monoFont() {
        return (Typeface) this.fontLazy.a();
    }

    public final LinearLayout row() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        return linearLayout;
    }

    public final void hideKeyboard() {
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            return;
        }
        Object systemService = getSystemService("input_method");
        i.b.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    public final IconView makeIcon(String str, int i2, int i3, float f2) {
        IconView iconView = new IconView(this, str, i2, f2);
        iconView.setMinimumWidth(dp(i3));
        iconView.setMinimumHeight(dp(i3));
        return iconView;
    }

    public final void logout() {
        ChatScreen chatScreen = this.chatScreen;
        if (chatScreen != null) {
            chatScreen.destroy();
        }
        this.chatScreen = null;
        if (this.username.length() > 0) {
            String cacheKey = StringPlus.stringPlus("chatcache_", this.username);
            SharedPreferences sharedPreferences = AppState.prefs;
            if (sharedPreferences == null) {
                i.b.g("sp");
                throw null;
            }
            sharedPreferences.edit().remove(cacheKey).apply();
        }
        TerminalManager.INSTANCE.closeAllSessions();
        SharedPreferences sharedPreferences2 = AppState.prefs;
        if (sharedPreferences2 == null) {
            i.b.g("sp");
            throw null;
        }
        sharedPreferences2.edit().remove("lastTerm").apply();
        AppState.putPref("user", "");
        AppState.putPref("session", "");
        File filesDir = getFilesDir();
        AppState.meJson = null;
        try {
            new File(filesDir, "c_me.json").delete();
        } catch (Exception unused) {
        }
        this.username = "";
        this.termKey = "";
        showLogin();
    }

    public final void maybeShowExpiryWarning() {
        if (this.expiryWarned || !i.b.a(this.screen, "home")) {
            return;
        }
        String user = this.username;
        JSONObject jSONObject = AppState.meJson;
        if (jSONObject == null || (!i.b.a(jSONObject.optString("username"), user) && jSONObject.optBoolean("known", true))) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        long expiresAt = jSONObject.optLong("expires_at", 0L);
        Long daysLeft = expiresAt <= 0 ? null : Long.valueOf((long) Math.ceil((expiresAt - System.currentTimeMillis()) / 8.64E7d));
        if (daysLeft != null) {
            final long longValue = daysLeft.longValue();
            if (longValue > 3) {
                return;
            }
            this.expiryWarned = true;
            JSONObject jSONObject2 = AppState.meJson;
            JSONObject contact = jSONObject2 != null ? jSONObject2.optJSONObject("contact") : null;
            String message;
            if (contact == null || (message = contact.optString("message", "")) == null) {
                message = "";
            }
            if (message.length() == 0) {
                message = "Your hosting is expiring soon! Please renew.";
            }
            final String messageText = message;
            String whatsapp;
            if (contact == null || (whatsapp = contact.optString("whatsapp", "")) == null) {
                whatsapp = "";
            }
            final String whatsappNumber = whatsapp;
            showDialog(this, 1727623958, false, new h.c() {
                @Override
                public final Object a(Object obj, Object obj2) {
                    String daysText;
                    LinearLayout linearLayout = (LinearLayout) obj;
                    Dialog dialog = (Dialog) obj2;
                    int i2 = MainActivity.R;
                    MainActivity mainActivity = MainActivity.this;
                    FrameLayout frameLayout = new FrameLayout(mainActivity);
                    FrameLayout frameLayout2 = new FrameLayout(mainActivity);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(1);
                    gradientDrawable.setColor(871985942);
                    frameLayout2.setBackground(gradientDrawable);
                    frameLayout2.addView(mainActivity.makeIcon("warn", -429290, 32, 2.0f), new FrameLayout.LayoutParams(mainActivity.dp(32), mainActivity.dp(32), 17));
                    frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(mainActivity.dp(64), mainActivity.dp(64), 1));
                    View closeIcon = mainActivity.makeIcon("close", AppState.darkTheme ? -8618878 : -9735552, 22, 2.0f);
                    MainActivity.setAction(closeIcon, new a.DismissAction(dialog, 9));
                    frameLayout.addView(closeIcon, new FrameLayout.LayoutParams(mainActivity.dp(26), mainActivity.dp(26), 8388661));
                    linearLayout.addView(frameLayout, MainActivity.layoutParams(mainActivity, mainActivity.matchParent, mainActivity.wrapContent, 0, 0, 0, 60));
                    TextView U = mainActivity.makeText("Hosting Expiring Soon!", 24.0f, -429290, true);
                    U.setGravity(17);
                    linearLayout.addView(U, MainActivity.layoutParams(mainActivity, mainActivity.matchParent, mainActivity.wrapContent, 14, 0, 0, 56));
                    long j2 = longValue;
                    if (j2 <= 0) {
                        daysText = "Expires today";
                    } else if (j2 == 1) {
                        daysText = "1 day remaining";
                    } else {
                        daysText = j2 + " days remaining";
                    }
                    TextView U2 = mainActivity.makeText(daysText, 32.0f, AppState.darkTheme ? -1 : -15656921, true);
                    U2.setGravity(17);
                    linearLayout.addView(U2, MainActivity.layoutParams(mainActivity, mainActivity.matchParent, mainActivity.wrapContent, 12, 0, 0, 56));
                    TextView U3 = mainActivity.makeText(messageText, 17.0f, AppState.darkTheme ? -8618878 : -9735552, false);
                    U3.setGravity(17);
                    linearLayout.addView(U3, MainActivity.layoutParams(mainActivity, mainActivity.matchParent, mainActivity.wrapContent, 12, 0, 0, 56));
                    String number = whatsappNumber;
                    if (number.length() > 0) {
                        linearLayout.addView(mainActivity.whatsAppButton("Contact", new a.LinkAction(0, mainActivity, number)), MainActivity.layoutParams(mainActivity, mainActivity.matchParent, mainActivity.dp(56), 20, 0, 0, 56));
                    }
                    return b.d.f770c;
                }
            }, 2);
        }
    }

    public final boolean isOnline() {
        try {
            Object systemService = getSystemService("connectivity");
            i.b.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Network activeNetwork = connectivityManager.getActiveNetwork();
            NetworkCapabilities networkCapabilities = activeNetwork != null ? connectivityManager.getNetworkCapabilities(activeNetwork) : null;
            if (networkCapabilities != null && networkCapabilities.hasCapability(12)) {
                if (networkCapabilities.hasCapability(16)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public final void openTerminal(String str, String str2) {
        if (!isWifiConnected()) {
            SharedPreferences sharedPreferences = AppState.prefs;
            if (sharedPreferences == null) {
                i.b.g("sp");
                throw null;
            }
            sharedPreferences.edit().remove("lastTerm").apply();
            toast("Connect to WiFi to open the terminal");
            return;
        }
        this.wifiLostAt = 0L;
        this.screen = "term";
        this.termKey = this.username + "-" + str;
        this.termTitle = str2;
        String lastTerm = str + "\n" + str2;
        SharedPreferences sharedPreferences2 = AppState.prefs;
        if (sharedPreferences2 == null) {
            i.b.g("sp");
            throw null;
        }
        sharedPreferences2.edit().putString("lastTerm", lastTerm).apply();
        this.outputCursor = 0;
        this.termBusy = false;
        this.termNeedsNewline = false;
        this.termColor = 0;
        this.termBold = false;
        TerminalManager terminalManager = TerminalManager.INSTANCE;
        String key = this.termKey;
        File file = this.homeDir;
        if (file == null) {
            i.b.g("homeDir");
            throw null;
        }
        final TerminalSession session = terminalManager.getOrCreateSession(file, new File(getFilesDir(), "home"), key);
        LinearLayout V = column();
        V.setBackgroundColor(-16777216);
        LinearLayout r2 = row();
        r2.setBackgroundColor(-15789543);
        r2.setPadding(dp(14), dp(14), dp(16), dp(14));
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView(makeIcon("back", -1, 26, 2.4f), new FrameLayout.LayoutParams(dp(26), dp(26), 17));
        setAction(frameLayout, new ActivityAction(this, 13));
        r2.addView(frameLayout, layoutParams(this, dp(40), dp(40), 0, 0, 0, 60));
        r2.addView(makeIcon("logo", -43230, 28, 2.0f), layoutParams(this, dp(28), dp(28), 0, 4, 0, 48));
        TextView U = makeText(str2, 26.0f, -1, true);
        U.setSingleLine(true);
        U.setEllipsize(TextUtils.TruncateAt.END);
        int i2 = this.wrapContent;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, i2, 1.0f);
        layoutParams.leftMargin = dp(10);
        r2.addView(U, layoutParams);
        LinearLayout r3 = row();
        r3.setGravity(17);
        r3.setBackground(roundedBg(-8446691, 14, 0, 0));
        r3.setPadding(dp(16), dp(11), dp(18), dp(11));
        r3.addView(makeIcon("stop", -1, 22, 2.0f), layoutParams(this, dp(22), dp(22), 0, 0, 8, 32));
        View U2 = makeText("Stop", 17.0f, -1, true);
        int i3 = this.wrapContent;
        r3.addView(U2, layoutParams(this, i3, i3, 0, 0, 0, 60));
        setAction(r3, new h.a() {
            @Override
            public final Object a() {
                int i9 = MainActivity.R;
                TerminalSession k22 = session;
                k22.echo((k22.busy ? "" : "$ ").concat("Ctrl+C\n"));
                k22.interrupt();
                MainActivity.this.flushTerminalOutput();
                return b.d.f770c;
            }
        });
        int i5 = this.wrapContent;
        r2.addView(r3, layoutParams(this, i5, i5, 0, 8, 0, 48));
        FrameLayout frameLayout2 = new FrameLayout(this);
        frameLayout2.setBackground(roundedBg(-14736336, 14, 0, 0));
        frameLayout2.addView(makeIcon("down", -1, 22, 2.2f), new FrameLayout.LayoutParams(dp(22), dp(22), 17));
        r2.addView(frameLayout2, layoutParams(this, dp(46), dp(46), 0, 10, 0, 48));
        V.addView(r2, layoutParams(this, this.matchParent, this.wrapContent, 0, 0, 0, 60));
        View view = new View(this);
        view.setBackgroundColor(-14473421);
        V.addView(view, layoutParams(this, this.matchParent, 1, 0, 0, 0, 60));
        FrameLayout frameLayout3 = new FrameLayout(this);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);
        scrollView.setBackgroundColor(-16777216);
        LinearLayout V2 = column();
        V2.setPadding(dp(20), dp(18), dp(20), dp(14));
        int i6 = this.matchParent;
        scrollView.addView(V2, new FrameLayout.LayoutParams(i6, i2));
        TextView textView = new TextView(this);
        textView.setTypeface(monoFont());
        textView.setTextSize(1, this.uiScale * 16.0f);
        textView.setTextColor(-1710101);
        textView.setLineSpacing(0.0f, 1.15f);
        textView.setTextIsSelectable(true);
        textView.setText("", TextView.BufferType.EDITABLE);
        textView.setLinkTextColor(-429290);
        textView.setVisibility(8);
        V2.addView(textView, layoutParams(this, this.matchParent, this.wrapContent, 0, 0, 0, 60));
        LinearLayout r4 = row();
        ProgressBar progressBar = new ProgressBar(this);
        progressBar.setIndeterminate(true);
        progressBar.setIndeterminateTintList(ColorStateList.valueOf(-429290));
        r4.addView(progressBar, layoutParams(this, dp(22), dp(22), 0, 0, 12, 32));
        TextView U3 = makeText("", 15.0f, -1710101, false);
        U3.setTypeface(monoFont());
        int i7 = this.wrapContent;
        r4.addView(U3, layoutParams(this, i7, i7, 0, 0, 0, 60));
        r4.setVisibility(8);
        V2.addView(r4, layoutParams(this, this.matchParent, this.wrapContent, 6, 0, 0, 56));
        LinearLayout inputRow = new LinearLayout(this);
        inputRow.setOrientation(0);
        TextView U4 = makeText("$ ", 16.0f, -1710101, false);
        U4.setTypeface(monoFont());
        U4.setLineSpacing(0.0f, 1.15f);
        int i8 = this.wrapContent;
        inputRow.addView(U4, layoutParams(this, i8, i8, 0, 0, 0, 60));
        final EditText editText = new EditText(this);
        editText.setBackground(null);
        editText.setPadding(0, 0, 0, 0);
        editText.setTypeface(monoFont());
        editText.setTextSize(1, this.uiScale * 16.0f);
        editText.setTextColor(-1710101);
        editText.setSingleLine(true);
        editText.setInputType(524433);
        editText.setImeOptions(268435462);
        if (Build.VERSION.SDK_INT >= 29) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-429290);
            gradientDrawable.setSize(dp(10), dp(22));
            editText.setTextCursorDrawable(gradientDrawable);
        }
        String draftKey = StringPlus.stringPlus("draft_", this.termKey);
        SharedPreferences sharedPreferences3 = AppState.prefs;
        if (sharedPreferences3 == null) {
            i.b.g("sp");
            throw null;
        }
        String draft = sharedPreferences3.getString(draftKey, "");
        if (draft == null) {
            draft = "";
        }
        if (draft.length() > 0) {
            editText.setText(draft);
            editText.setSelection(editText.getText().length());
        }
        editText.addTextChangedListener(new a.SharedTextWatcher(2, draftKey));
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public final boolean onEditorAction(TextView textView2, int i9, KeyEvent keyEvent) {
                int i10 = MainActivity.R;
                EditText editText2 = editText;
                String obj = editText2.getText().toString();
                editText2.setText("");
                session.runCommand(obj);
                MainActivity.this.flushTerminalOutput();
                return true;
            }
        });
        inputRow.addView(editText, new LinearLayout.LayoutParams(0, i2, 1.0f));
        V2.addView(inputRow, layoutParams(this, this.matchParent, this.wrapContent, 0, 0, 0, 60));
        V2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view2) {
                MainActivity.focusAndShowKeyboard(editText, MainActivity.this);
            }
        });
        scrollView.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view2) {
                MainActivity.focusAndShowKeyboard(editText, MainActivity.this);
            }
        });
        scrollView.addOnLayoutChangeListener(new a.LayoutTask(1, scrollView));
        frameLayout3.addView(scrollView, new FrameLayout.LayoutParams(i6, i6));
        View scrim = new View(this);
        scrim.setVisibility(8);
        scrim.setOnClickListener(new a.ActivityClickListener(this, 2));
        frameLayout3.addView(scrim, new FrameLayout.LayoutParams(i6, i6));
        LinearLayout keysPanel = column();
        keysPanel.setVisibility(8);
        keysPanel.setBackground(roundedBg(-15328476, 16, -14012614, 1));
        keysPanel.setPadding(dp(6), dp(6), dp(6), dp(6));
        keysPanel.setElevation(dp(10));
        addKeyButton(this, keysPanel, "Tab", new MultiAction(editText, session, this, 5));
        addKeyButton(this, keysPanel, "Ctrl+C", new h.a() {
            @Override
            public final Object a() {
                int i9 = MainActivity.R;
                TerminalSession k22 = session;
                k22.echo((k22.busy ? "" : "$ ").concat("Ctrl+C\n"));
                k22.interrupt();
                MainActivity.this.flushTerminalOutput();
                return b.d.f770c;
            }
        });
        addKeyButton(this, keysPanel, "Ctrl+D", new h.a() {
            @Override
            public final Object a() {
                int i5 = MainActivity.R;
                TerminalSession k2 = session;
                MainActivity mainActivity = MainActivity.this;
                k2.echo((k2.busy ? "" : "$ ").concat("Ctrl+D\n"));
                Process process = k2.process;
                if (process != null) {
                    try {
                        process.getOutputStream().close();
                    } catch (Exception unused) {
                    }
                }
                mainActivity.flushTerminalOutput();
                return b.d.f770c;
            }
        });
        addKeyButton(this, keysPanel, "Clear", new h.a() {
            @Override
            public final Object a() {
                int i6 = MainActivity.R;
                session.echo("\f");
                MainActivity.this.flushTerminalOutput();
                return b.d.f770c;
            }
        });
        addKeyButton(this, keysPanel, "Copy all", new a.PairAction(textView, this, 3));
        addKeyButton(this, keysPanel, "ls", new h.a() {
            @Override
            public final Object a() {
                int i7 = MainActivity.R;
                session.runCommand("ls");
                MainActivity.this.flushTerminalOutput();
                return b.d.f770c;
            }
        });
        addKeyButton(this, keysPanel, "pwd", new h.a() {
            @Override
            public final Object a() {
                int i8 = MainActivity.R;
                session.runCommand("pwd");
                MainActivity.this.flushTerminalOutput();
                return b.d.f770c;
            }
        });
        addKeyButton(this, keysPanel, "cd", new a.PairAction(editText, this, 4));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dp(200), i2, 8388661);
        layoutParams2.setMargins(0, dp(8), dp(12), 0);
        frameLayout3.addView(keysPanel, layoutParams2);
        setAction(frameLayout2, new a.PanelToggleAction(keysPanel, this, 1));
        V.addView(frameLayout3, new LinearLayout.LayoutParams(i6, 0, 1.0f));
        View view3 = new View(this);
        view3.setBackgroundColor(-14473421);
        V.addView(view3, layoutParams(this, this.matchParent, 1, 0, 0, 0, 60));
        LinearLayout r5 = row();
        r5.setPadding(dp(20), dp(12), dp(20), dp(12));
        TextView U5 = makeText("[" + str2 + "]", 14.0f, -14714310, false);
        U5.setTypeface(monoFont());
        TextView U6 = makeText("", 14.0f, -14714310, false);
        U6.setTypeface(monoFont());
        r5.addView(U5, new LinearLayout.LayoutParams(0, i2, 1.0f));
        int i16 = this.wrapContent;
        r5.addView(U6, layoutParams(this, i16, i16, 0, 0, 0, 60));
        V.addView(r5, layoutParams(this, this.matchParent, this.wrapContent, 0, 0, 0, 60));
        this.termOutput = textView;
        this.termScroll = scrollView;
        this.termInput = editText;
        this.termInputRow = inputRow;
        this.termBusyRow = r4;
        this.termPrompt = U3;
        this.termPathLabel = U5;
        this.termClockLabel = U6;
        this.termKeysPanel = keysPanel;
        this.termScrim = scrim;
        setRootContent(V, -15789543, -16777216, false, false);
        flushTerminalOutput();
        refreshTerminalChrome();
    }
}
