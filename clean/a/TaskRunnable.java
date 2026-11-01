package a;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.ScrollView;
import com.nix.host.HostService;
import com.nix.host.MainActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class TaskRunnable implements Runnable {

    public final int mode;

    public final Object target;

    public TaskRunnable(int mode, Object target) {
        this.mode = mode;
        this.target = target;
    }

    @Override
    public final void run() {
        Cursor query;
        String message;
        Throwable th = null;
        switch (this.mode) {
            case 0:
                ApiClient.requestWithDefaults(ApiClient.INSTANCE, "POST", "/chat/quick", new JSONObject().put("q", (String) this.target), 8);
                return;
            case 1:
                Context context = (Context) this.target;
                while (ChatNotifier.polling) {
                    try {
                        ChatNotifier.INSTANCE.pollOnce(context);
                    } catch (Throwable unused) {
                    }
                    try {
                        Thread.sleep(12000L);
                    } catch (InterruptedException unused2) {
                        return;
                    }
                }
                return;
            case 2:
                if (ChatNotifier.soundPlayer == ((MediaPlayer) this.target)) {
                    ChatNotifier chatNotifier = ChatNotifier.INSTANCE;
                    ChatNotifier.stopSound();
                    return;
                }
                return;
            case 3:
                final CodeEditorView editor = (CodeEditorView) this.target;
                Editable text = editor.getText();
                if (text != null && text.length() <= 80000) {
                    final int version = editor.changeCounter;
                    final String content = text.toString();
                    final String owner = editor.fileName;
                    new Thread(new Runnable() {
                        @Override
                        public final void run() {
                            String text2 = content;
                            String owner2 = owner;
                            try {
                                Set set = D1.f67a;
                                final ArrayList spans = D1.a(m.e.b0(text2, new String[]{"\n"}), owner2);
                                final int version2 = version;
                                final CodeEditorView editor2 = editor;
                                editor2.post(new Runnable() {
                                    @Override
                                    public final void run() {
                                        Editable currentText;
                                        List<CharSequence> list = spans;
                                        CodeEditorView editor3 = editor2;
                                        if (version2 != editor3.changeCounter || (currentText = editor3.getText()) == null) {
                                            return;
                                        }
                                        editor3.beginBatchEdit();
                                        try {
                                            i.a existing = i.j.a(currentText.getSpans(0, currentText.length(), ForegroundColorSpan.class));
                                            while (existing.hasNext()) {
                                                currentText.removeSpan((ForegroundColorSpan) existing.next());
                                            }
                                            int offset = 0;
                                            for (CharSequence line : list) {
                                                if (line instanceof Spanned) {
                                                    i.a lineSpans = i.j.a(((Spanned) line).getSpans(0, line.length(), ForegroundColorSpan.class));
                                                    while (lineSpans.hasNext()) {
                                                        ForegroundColorSpan span = (ForegroundColorSpan) lineSpans.next();
                                                        int spanStart = ((Spanned) line).getSpanStart(span) + offset;
                                                        int spanEnd = ((Spanned) line).getSpanEnd(span) + offset;
                                                        if (spanStart < spanEnd && spanEnd <= currentText.length()) {
                                                            currentText.setSpan(new ForegroundColorSpan(span.getForegroundColor()), spanStart, spanEnd, 33);
                                                        }
                                                    }
                                                }
                                                offset += line.length() + 1;
                                            }
                                            editor3.endBatchEdit();
                                        } catch (Throwable th2) {
                                            editor3.endBatchEdit();
                                            throw th2;
                                        }
                                    }
                                });
                            } catch (Exception unused3) {
                            }
                        }
                    }).start();
                    return;
                }
                return;
            case 4:
                ((C0042k1) this.target).f569a.a();
                return;
            case 5:
                B1 gallery = (B1) this.target;
                gallery.getClass();
                ArrayList media = new ArrayList();
                ContentResolver contentResolver = gallery.f26a.getContentResolver();
                try {
                    Uri imagesUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    query = contentResolver.query(imagesUri, new String[]{"_id", "bucket_display_name", "date_added", "_data"}, null, null, null);
                    if (query != null) {
                        while (query.moveToNext()) {
                            try {
                                Uri itemUri = ContentUris.withAppendedId(imagesUri, query.getLong(0));
                                String bucket = query.getString(1);
                                String bucketName = bucket == null ? "Other" : bucket;
                                long dateAdded = query.getLong(2);
                                String path = query.getString(3);
                                media.add(new C0094z1(itemUri, false, 0L, bucketName, dateAdded, path == null ? "" : path));
                                th = null;
                            } finally {
                            }
                        }
                        AppState.a(query, th);
                    }
                } catch (Throwable unused3) {
                }
                try {
                    Uri videosUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    query = contentResolver.query(videosUri, new String[]{"_id", "bucket_display_name", "date_added", "_data", "duration"}, null, null, null);
                    if (query != null) {
                        while (query.moveToNext()) {
                            try {
                                Uri itemUri = ContentUris.withAppendedId(videosUri, query.getLong(0));
                                long duration = query.getLong(4);
                                String bucket = query.getString(1);
                                String bucketName = bucket == null ? "Other" : bucket;
                                long dateAdded = query.getLong(2);
                                String path = query.getString(3);
                                media.add(new C0094z1(itemUri, true, duration, bucketName, dateAdded, path == null ? "" : path));
                            } finally {
                            }
                        }
                        AppState.a(query, null);
                    }
                } catch (Throwable unused4) {
                }
                if (media.size() > 1) {
                    c.g.F(media, new N0(2));
                }
                gallery.f34i.post(new HttpConnectionHandler(gallery, media, 4));
                return;
            case 6:
                HostService hostService = (HostService) this.target;
                while (HostService.server != null) {
                    try {
                        Thread.sleep(900000L);
                        if (HostService.server == null) {
                            return;
                        }
                        ApiResponse me = ApiClient.requestWithDefaults(ApiClient.INSTANCE, "GET", "/me", null, 12);
                        JSONObject meJson = me.json();
                        if (me.code == 401 || (me.isSuccess() && meJson != null && (meJson.optBoolean("locked", false) || !meJson.optBoolean("known", true) || AppState.isLockedOrExpired(meJson.optJSONObject("app"))))) {
                            hostService.stopServer();
                            hostService.stopSelf();
                            return;
                        }
                    } catch (InterruptedException unused5) {
                        return;
                    }
                }
                return;
            case 7:
                int i3 = MainActivity.R;
                ((ScrollView) this.target).scrollTo(0, 1000000000);
                return;
            case 8:
                try {
                    ((AudioTrack) this.target).release();
                    return;
                } catch (Exception unused6) {
                    return;
                }
            case 9:
                E2.a((E2) this.target);
                return;
            default:
                y2 y2Var = y2.f736a;
                try {
                    message = "Package list updated (" + ((Map) y2.s().f765b).size() + " packages available).";
                } catch (Exception e2) {
                    message = e2.getMessage();
                    if (message == null) {
                        message = "Update failed";
                    }
                }
                TerminalSession session = (TerminalSession) this.target;
                session.echo(message + "\n");
                session.finishRun();
                return;
        }
    }
}
