package a;

public final class DownloadProgressCallback implements h.b {

    public final long packageSize;

    public final i.f progressState;

    public final i.f progressBase;

    public final i.e percentState;

    public final h.b onProgress;

    public DownloadProgressCallback(long j2, i.f fVar, i.f fVar2, i.e eVar, ToastCallback toastCallback) {
        this.packageSize = j2;
        this.progressState = fVar;
        this.progressBase = fVar2;
        this.percentState = eVar;
        this.onProgress = toastCallback;
    }

    @Override
    public final Object a(Object obj) {
        TermuxPackageManager.reportProgress(this.progressState, this.progressBase, this.percentState, this.onProgress, Math.min(((Long) obj).longValue(), this.packageSize) * 0.6d);
        return b.d.f770c;
    }
}
