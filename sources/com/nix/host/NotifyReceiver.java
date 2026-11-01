package com.nix.host;

import a.O;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public final class NotifyReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f801a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("u");
        if (stringExtra == null) {
            return;
        }
        new Thread(new O(context.getApplicationContext(), intent.getAction(), intent.getLongExtra("last", 0L), stringExtra, intent, goAsync(), 1)).start();
    }
}
