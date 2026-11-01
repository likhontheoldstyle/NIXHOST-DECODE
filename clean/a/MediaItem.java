package a;

import android.net.Uri;

public final class MediaItem {

    public final Uri uri;

    public final boolean isVideo;

    public final long durationMs;

    public final String bucketName;

    public final long dateAdded;

    public final String filePath;

    public MediaItem(Uri uri, boolean z, long j2, String str, long j3, String str2) {
        this.uri = uri;
        this.isVideo = z;
        this.durationMs = j2;
        this.bucketName = str;
        this.dateAdded = j3;
        this.filePath = str2;
    }
}
