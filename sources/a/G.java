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

/* loaded from: classes.dex */
public final /* synthetic */ class G implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f101a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f102b;

    public /* synthetic */ G(int i2, Object obj) {
        this.f101a = i2;
        this.f102b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Cursor query;
        String message;
        Throwable th = null;
        switch (this.f101a) {
            case 0:
                C0004b.b(C0004b.f409a, "POST", "/chat/quick", new JSONObject().put("q", (String) this.f102b), 8);
                return;
            case 1:
                Context context = (Context) this.f102b;
                while (C0018e1.f460b) {
                    try {
                        C0018e1.f459a.e(context);
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
                if (C0018e1.f467i == ((MediaPlayer) this.f102b)) {
                    C0018e1 c0018e1 = C0018e1.f459a;
                    C0018e1.j();
                    return;
                }
                return;
            case 3:
                final C0038j1 c0038j1 = (C0038j1) this.f102b;
                Editable text = c0038j1.getText();
                if (text != null && text.length() <= 80000) {
                    final int i2 = c0038j1.f558j;
                    final String obj = text.toString();
                    final String str = c0038j1.f550b;
                    new Thread(new Runnable() { // from class: a.h1
                        @Override // java.lang.Runnable
                        public final void run() {
                            String str2 = obj;
                            String str3 = str;
                            try {
                                Set set = D1.f67a;
                                final ArrayList a2 = D1.a(m.e.b0(str2, new String[]{"\n"}), str3);
                                final int i3 = i2;
                                final C0038j1 c0038j12 = c0038j1;
                                c0038j12.post(new Runnable() { // from class: a.i1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        Editable text2;
                                        List<CharSequence> list = a2;
                                        C0038j1 c0038j13 = c0038j12;
                                        if (i3 != c0038j13.f558j || (text2 = c0038j13.getText()) == null) {
                                            return;
                                        }
                                        c0038j13.beginBatchEdit();
                                        try {
                                            i.a a3 = i.j.a(text2.getSpans(0, text2.length(), ForegroundColorSpan.class));
                                            while (a3.hasNext()) {
                                                text2.removeSpan((ForegroundColorSpan) a3.next());
                                            }
                                            int i4 = 0;
                                            for (CharSequence charSequence : list) {
                                                if (charSequence instanceof Spanned) {
                                                    i.a a4 = i.j.a(((Spanned) charSequence).getSpans(0, charSequence.length(), ForegroundColorSpan.class));
                                                    while (a4.hasNext()) {
                                                        ForegroundColorSpan foregroundColorSpan = (ForegroundColorSpan) a4.next();
                                                        int spanStart = ((Spanned) charSequence).getSpanStart(foregroundColorSpan) + i4;
                                                        int spanEnd = ((Spanned) charSequence).getSpanEnd(foregroundColorSpan) + i4;
                                                        if (spanStart < spanEnd && spanEnd <= text2.length()) {
                                                            text2.setSpan(new ForegroundColorSpan(foregroundColorSpan.getForegroundColor()), spanStart, spanEnd, 33);
                                                        }
                                                    }
                                                }
                                                i4 += charSequence.length() + 1;
                                            }
                                            c0038j13.endBatchEdit();
                                        } catch (Throwable th2) {
                                            c0038j13.endBatchEdit();
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
                ((C0042k1) this.f102b).f569a.a();
                return;
            case 5:
                B1 b1 = (B1) this.f102b;
                b1.getClass();
                ArrayList arrayList = new ArrayList();
                ContentResolver contentResolver = b1.f26a.getContentResolver();
                try {
                    Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    query = contentResolver.query(uri, new String[]{"_id", "bucket_display_name", "date_added", "_data"}, null, null, null);
                    if (query != null) {
                        while (query.moveToNext()) {
                            try {
                                Uri withAppendedId = ContentUris.withAppendedId(uri, query.getLong(0));
                                String string = query.getString(1);
                                String str2 = string == null ? "Other" : string;
                                long j2 = query.getLong(2);
                                String string2 = query.getString(3);
                                arrayList.add(new C0094z1(withAppendedId, false, 0L, str2, j2, string2 == null ? "" : string2));
                                th = null;
                            } finally {
                            }
                        }
                        AbstractC0008c.a(query, th);
                    }
                } catch (Throwable unused3) {
                }
                try {
                    Uri uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    query = contentResolver.query(uri2, new String[]{"_id", "bucket_display_name", "date_added", "_data", "duration"}, null, null, null);
                    if (query != null) {
                        while (query.moveToNext()) {
                            try {
                                Uri withAppendedId2 = ContentUris.withAppendedId(uri2, query.getLong(0));
                                long j3 = query.getLong(4);
                                String string3 = query.getString(1);
                                String str3 = string3 == null ? "Other" : string3;
                                long j4 = query.getLong(2);
                                String string4 = query.getString(3);
                                arrayList.add(new C0094z1(withAppendedId2, true, j3, str3, j4, string4 == null ? "" : string4));
                            } finally {
                            }
                        }
                        AbstractC0008c.a(query, null);
                    }
                } catch (Throwable unused4) {
                }
                if (arrayList.size() > 1) {
                    c.g.F(arrayList, new N0(2));
                }
                b1.f34i.post(new U(b1, arrayList, 4));
                return;
            case 6:
                HostService hostService = (HostService) this.f102b;
                while (HostService.f775f != null) {
                    try {
                        Thread.sleep(900000L);
                        if (HostService.f775f == null) {
                            return;
                        }
                        C0000a b2 = C0004b.b(C0004b.f409a, "GET", "/me", null, 12);
                        JSONObject c2 = b2.c();
                        if (b2.f400a == 401 || (b2.b() && c2 != null && (c2.optBoolean("locked", false) || !c2.optBoolean("known", true) || AbstractC0008c.s(c2.optJSONObject("app"))))) {
                            hostService.c();
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
                ((ScrollView) this.f102b).scrollTo(0, 1000000000);
                return;
            case 8:
                try {
                    ((AudioTrack) this.f102b).release();
                    return;
                } catch (Exception unused6) {
                    return;
                }
            case 9:
                E2.a((E2) this.f102b);
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
                K2 k2 = (K2) this.f102b;
                k2.a(message + "\n");
                k2.f();
                return;
        }
    }
}
