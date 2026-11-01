package a;

import com.nix.host.MainActivity;
import java.io.File;

public final class CommitAction implements h.a {

    public final int mode;

    public final MainActivity activity;

    public final File file;

    public final CodeEditorView editor;

    public CommitAction(MainActivity mainActivity, File file, CodeEditorView codeEditorView) {
        this.mode = 1;
        this.activity = mainActivity;
        this.file = file;
        this.editor = codeEditorView;
    }

    @Override
    public final Object a() {
        CodeEditorView codeEditorView = this.editor;
        File file = this.file;
        MainActivity mainActivity = this.activity;
        switch (this.mode) {
            case 0:
                int i2 = MainActivity.R;
                try {
                    g.m.L(file, codeEditorView.getText().toString());
                    mainActivity.toast("Saved");
                } catch (Exception unused) {
                    mainActivity.toast("Save failed");
                }
                mainActivity.showFileView(file);
                break;
            default:
                int i3 = MainActivity.R;
                mainActivity.hideKeyboard();
                mainActivity.showCommitSheet(J0.a("Update ", file.getName()), new CommitAction(file, codeEditorView, mainActivity));
                break;
        }
        return b.d.f770c;
    }

    public CommitAction(File file, CodeEditorView codeEditorView, MainActivity mainActivity) {
        this.mode = 0;
        this.file = file;
        this.editor = codeEditorView;
        this.activity = mainActivity;
    }
}
