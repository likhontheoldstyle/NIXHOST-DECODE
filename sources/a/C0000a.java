package a;

import java.io.Serializable;
import org.json.JSONObject;

/* renamed from: a.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0000a {

    /* renamed from: a, reason: collision with root package name */
    public final int f400a;

    /* renamed from: b, reason: collision with root package name */
    public final Serializable f401b;

    /* JADX WARN: Type inference failed for: r4v2, types: [byte[], java.io.Serializable] */
    public C0000a(int i2) {
        if (i2 < 1 || i2 > 256) {
            throw new IllegalArgumentException("Invalid distance: " + i2);
        }
        this.f400a = i2;
        this.f401b = new byte[i2];
    }

    public String a() {
        String optString;
        JSONObject c2 = c();
        if (c2 != null && (optString = c2.optString("error", "")) != null) {
            if (optString.length() == 0) {
                optString = null;
            }
            if (optString != null) {
                return optString;
            }
        }
        return "Failed";
    }

    public boolean b() {
        int i2 = this.f400a;
        return 200 <= i2 && i2 < 300;
    }

    public JSONObject c() {
        try {
            return new JSONObject((String) this.f401b);
        } catch (Exception unused) {
            return null;
        }
    }

    public C0000a(int i2, String str) {
        this.f400a = i2;
        this.f401b = str;
    }
}
