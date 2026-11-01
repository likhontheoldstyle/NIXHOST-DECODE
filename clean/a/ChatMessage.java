package a;

import java.util.ArrayList;
import java.util.List;

public final class ChatMessage {

    public final long id;

    public final String sender;

    public final String type;

    public String text;

    public final List media;

    public final List wave;

    public int duration;

    public final long replyTo;

    public final long timestamp;

    public boolean flag;

    public final String u;

    public final String t;

    public final String x;

    public final boolean deleted;

    public int status;

    public List reactions;

    public ChatMessage(long j2, String str, String str2, String str3, List list, ArrayList arrayList, int i2, long j3, long j4, String str4, String str5, String str6, boolean z) {
        this(j2, str, str2, str3, list, arrayList, i2, j3, j4, false, str4, str5, str6, z, 0);
    }

    public ChatMessage(long j2, String str, String str2, String str3, List list, ArrayList arrayList, int i2, long j3, long j4, boolean z, String str4, String str5, String str6, boolean z2, int i3) {
        this.id = j2;
        this.sender = str;
        this.type = str2;
        this.text = str3;
        this.media = list;
        this.wave = arrayList;
        this.duration = i2;
        this.replyTo = j3;
        this.timestamp = j4;
        this.flag = z;
        this.u = str4;
        this.t = str5;
        this.x = str6;
        this.deleted = z2;
        this.status = i3;
        this.reactions = c.j.f773a;
    }
}
