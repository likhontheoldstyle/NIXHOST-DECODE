package a;

import android.app.Dialog;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nix.host.MainActivity;
import java.io.File;
import java.util.Locale;

public final class ActionCallback implements h.a {

    public final int mode;

    public final Object first;

    public final Object second;

    public final Object third;

    public final Object fourth;

    public ActionCallback(MainActivity mainActivity, CodeEditorView codeEditorView, String str, File file) {
        this.mode = 6;
        this.second = mainActivity;
        this.first = codeEditorView;
        this.fourth = str;
        this.third = file;
    }

    @Override
    public final Object a() {
        int i2 = 2;
        int i3 = 3;
        int i4 = 1;
        Object obj = this.third;
        Object obj2 = this.fourth;
        Object obj3 = this.first;
        Object obj4 = this.second;
        switch (this.mode) {
            case 0:
                HideTextRunnable runnableC0064q = (HideTextRunnable) ((Runnable) obj);
                TextView textView = (TextView) obj4;
                textView.setText("Downloading...");
                textView.setVisibility(0);
                ChatScreen chatScreen = (ChatScreen) obj3;
                chatScreen.handler.removeCallbacks(runnableC0064q);
                chatScreen.handler.postDelayed(runnableC0064q, 2400L);
                new Thread(new QuadTaskRunnable(runnableC0064q, chatScreen, textView, (String) obj2)).start();
                break;
            case 1:
                String obj5 = m.e.h0(((EditText) obj4).getText().toString()).toString();
                if (obj5.length() > 0) {
                    ChatScreen chatScreen2 = (ChatScreen) obj3;
                    chatScreen2.replyTarget = (ChatMessage) obj;
                    ChatScreen.sendTextMessage(chatScreen2, "text", obj5, null, 60);
                    ((Dialog) obj2).dismiss();
                }
                break;
            case 2:
                File file = (File) ((i.g) obj2).f850b;
                TextView textView2 = (TextView) obj4;
                ChatScreen chatScreen3 = (ChatScreen) obj3;
                Runnable runnable = (Runnable) obj;
                if (file == null) {
                    ChatScreen.showTransientText((HideTextRunnable) runnable, chatScreen3, textView2, "Please wait, the video is loading");
                } else {
                    HideTextRunnable runnableC0064q2 = (HideTextRunnable) runnable;
                    ChatScreen.showTransientText(runnableC0064q2, chatScreen3, textView2, "Downloading...");
                    new Thread(new QuadTaskRunnable(file, chatScreen3, textView2, runnableC0064q2, 3)).start();
                }
                break;
            case 3:
                i.d dVar = (i.d) obj4;
                if (!dVar.f846a) {
                    dVar.f846a = true;
                    String obj6 = m.e.h0(((EditText) obj3).getText().toString()).toString();
                    ((Dialog) obj).dismiss();
                    ((h.b) obj2).a(obj6);
                }
                break;
            case 4:
                int i5 = MainActivity.R;
                String obj7 = m.e.h0(((EditText) obj4).getText().toString()).toString();
                if (obj7.length() == 0) {
                    ((MainActivity) obj3).toast("Name required");
                } else {
                    ((Dialog) obj).dismiss();
                    ((h.b) obj2).a(obj7);
                }
                break;
            case 5:
                int i6 = MainActivity.R;
                i.e eVar = (i.e) obj4;
                int i7 = eVar.f847a;
                LinearLayout linearLayout = (LinearLayout) obj3;
                MainActivity mainActivity = (MainActivity) obj;
                File file2 = (File) obj2;
                if (i7 == 1) {
                    eVar.f847a = 0;
                    linearLayout.setVisibility(8);
                    mainActivity.showInputDialog("Rename", "New name", file2.getName(), "Save", new CreateRenameAction(mainActivity, file2));
                } else if (i7 == 2) {
                    eVar.f847a = 0;
                    linearLayout.setVisibility(8);
                    mainActivity.showCommitSheet(StringPlus.stringPlus("Delete ", file2.getName()), new FileConfirmAction(file2, mainActivity, i2));
                } else if (i7 == 3) {
                    if (file2.isFile()) {
                        String lowerCase = file2.getName().toLowerCase(Locale.ROOT);
                        i.b.d(lowerCase, "toLowerCase(...)");
                        if (lowerCase.endsWith(".zip")) {
                            eVar.f847a = 0;
                            linearLayout.setVisibility(8);
                            String name = file2.getName();
                            String substring = file2.getName().substring(0, file2.getName().length() - 4);
                            i.b.d(substring, "substring(...)");
                            String str = "Unzip \"" + name + "\" into a folder named " + substring + " ?";
                            FileConfirmAction fileConfirmAction = new FileConfirmAction(mainActivity, file2, i3);
                            mainActivity.getClass();
                            MainActivity.showDialog(mainActivity, 0, false, new ConfirmDialogContent(mainActivity, "Unzip", str, "Unzip", -429290, fileConfirmAction), 3);
                        }
                    }
                    mainActivity.toast("Tap a .zip file");
                } else if (file2.isDirectory()) {
                    mainActivity.currentDir = file2;
                    mainActivity.showFiles();
                } else {
                    mainActivity.showFileView(file2);
                }
                break;
            default:
                int i8 = MainActivity.R;
                MainActivity mainActivity2 = (MainActivity) obj4;
                mainActivity2.hideKeyboard();
                File file3 = (File) obj;
                if (i.b.a(((CodeEditorView) obj3).getText().toString(), (String) obj2)) {
                    mainActivity2.showFileView(file3);
                } else {
                    MainActivity.showDialog(mainActivity2, 0, false, new ConfirmDialogContent(mainActivity2, "Discard changes?", "Your edits will be lost.", "Discard", -429290, new FileConfirmAction(mainActivity2, file3, i4)), 3);
                }
                break;
        }
        return b.d.f770c;
    }

    public ActionCallback(i.g gVar, TextView textView, ChatScreen chatScreen, HideTextRunnable runnableC0064q) {
        this.mode = 2;
        this.fourth = gVar;
        this.second = textView;
        this.first = chatScreen;
        this.third = runnableC0064q;
    }

    public ActionCallback(Object obj, Object obj2, Object obj3, Object obj4, int i2) {
        this.mode = i2;
        this.second = obj;
        this.first = obj2;
        this.third = obj3;
        this.fourth = obj4;
    }
}
