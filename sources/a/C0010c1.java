package a;

import android.media.MediaPlayer;

/* renamed from: a.c1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0010c1 implements MediaPlayer.OnCompletionListener {
    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        try {
            mediaPlayer.release();
        } catch (Exception unused) {
        }
        if (C0018e1.f467i == mediaPlayer) {
            C0018e1.f467i = null;
        }
    }
}
