package a;

import org.json.JSONObject;

public final class OutboxEntry {

    public final long id;

    public final JSONObject body;

    public final long timestamp;

    public final String u;

    public final String t;

    public final String x;

    public final boolean deleted;

    public OutboxEntry(long j2, JSONObject jSONObject, long j3, String str, String str2, String str3, boolean z) {
        this.id = j2;
        this.body = jSONObject;
        this.timestamp = j3;
        this.u = str;
        this.t = str2;
        this.x = str3;
        this.deleted = z;
    }
}
