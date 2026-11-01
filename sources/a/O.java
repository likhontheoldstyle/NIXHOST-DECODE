package a;

import android.app.NotificationManager;
import android.app.RemoteInput;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.nix.host.NotifyReceiver;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final /* synthetic */ class O implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f229a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f230b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f231c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f232d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f233e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f234f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f235g;

    public /* synthetic */ O(Object obj, Object obj2, long j2, Object obj3, Object obj4, Object obj5, int i2) {
        this.f229a = i2;
        this.f231c = obj;
        this.f232d = obj2;
        this.f230b = j2;
        this.f233e = obj3;
        this.f234f = obj4;
        this.f235g = obj5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        CharSequence charSequence;
        String obj;
        boolean z = true;
        switch (this.f229a) {
            case 0:
                C0000a c0000a = (C0000a) this.f231c;
                int i2 = c0000a.f400a;
                C0006b1 c0006b1 = (C0006b1) this.f232d;
                if (i2 == 401) {
                    c0006b1.f417d.a();
                    return;
                }
                boolean b2 = c0000a.b();
                long j2 = this.f230b;
                if (b2) {
                    c.h.G(c0006b1.D, new P(j2, 1));
                    JSONObject c2 = c0000a.c();
                    JSONObject optJSONObject = c2 != null ? c2.optJSONObject("msg") : null;
                    if (optJSONObject != null) {
                        c0006b1.b(new JSONArray().put(optJSONObject));
                    }
                    c0006b1.w0();
                    c0006b1.x0(true);
                    return;
                }
                if (c0000a.f400a == 0) {
                    c0006b1.d1(j2, (JSONObject) this.f233e, (K0) this.f234f);
                    c0006b1.K0(1);
                    return;
                }
                c0006b1.z0(j2);
                c0006b1.f416c.a(C0006b1.E(c0000a));
                h.a aVar = (h.a) this.f235g;
                if (aVar != null) {
                    aVar.a();
                    return;
                }
                return;
            default:
                Context context = (Context) this.f231c;
                String str2 = (String) this.f232d;
                long j3 = this.f230b;
                String str3 = (String) this.f233e;
                Intent intent = (Intent) this.f234f;
                BroadcastReceiver.PendingResult pendingResult = (BroadcastReceiver.PendingResult) this.f235g;
                int i3 = NotifyReceiver.f801a;
                try {
                    AbstractC0008c.f440c = context.getSharedPreferences("nixhost", 0);
                    C0004b c0004b = C0004b.f409a;
                    C0004b.h(context);
                    if (i.b.a(str2, "com.nix.host.CHAT_LIKE")) {
                        if (c0004b.d(new JSONObject().put("type", "like")).b()) {
                            if (j3 > 0) {
                                c0004b.c(j3);
                            }
                            C0018e1.f459a.g(context, str3, "👍", j3);
                        } else {
                            C0018e1 c0018e1 = C0018e1.f459a;
                            if (C0018e1.f463e.get(str3) != null) {
                                z = false;
                            }
                            c0018e1.c(z);
                            c0018e1.f(context, str3, AbstractC0008c.p("Not sent (no internet?)"), j3, true);
                        }
                    } else if (i.b.a(str2, "com.nix.host.CHAT_REPLY")) {
                        Bundle resultsFromIntent = RemoteInput.getResultsFromIntent(intent);
                        if (resultsFromIntent == null || (charSequence = resultsFromIntent.getCharSequence("reply_text")) == null || (obj = charSequence.toString()) == null || (str = m.e.h0(obj).toString()) == null) {
                            str = "";
                        }
                        if (str.length() == 0) {
                            C0018e1 c0018e12 = C0018e1.f459a;
                            Object systemService = context.getSystemService("notification");
                            i.b.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                            String lowerCase = str3.toLowerCase(Locale.ROOT);
                            i.b.d(lowerCase, "toLowerCase(...)");
                            ((NotificationManager) systemService).cancel((lowerCase.hashCode() & 65535) + 2000);
                            synchronized (c0018e12) {
                            }
                        } else if (c0004b.d(new JSONObject().put("type", "text").put("text", str)).b()) {
                            if (j3 > 0) {
                                c0004b.c(j3);
                            }
                            C0018e1.f459a.g(context, str3, str, j3);
                        } else {
                            C0018e1 c0018e13 = C0018e1.f459a;
                            if (C0018e1.f463e.get(str3) != null) {
                                z = false;
                            }
                            c0018e13.c(z);
                            c0018e13.f(context, str3, AbstractC0008c.p("Not sent (no internet?)"), j3, true);
                        }
                    }
                } catch (Throwable unused) {
                }
                pendingResult.finish();
                return;
        }
    }
}
