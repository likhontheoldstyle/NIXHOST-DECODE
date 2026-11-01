package a;

import android.media.MediaPlayer;

/* renamed from: a.d1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0014d1 implements MediaPlayer.OnErrorListener {
    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        try {
            mediaPlayer.release();
        } catch (Exception unused) {
        }
        if (C0018e1.f467i != mediaPlayer) {
            return true;
        }
        C0018e1.f467i = null;
        return true;
    }
}
