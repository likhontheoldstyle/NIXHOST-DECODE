package com.nix.host;

import a.ActionRunnable;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class NotifyReceiver extends BroadcastReceiver {

    public static final int f801a = 0;

    @Override
    public final void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("u");
        if (stringExtra == null) {
            return;
        }
        new Thread(new ActionRunnable(context.getApplicationContext(), intent.getAction(), intent.getLongExtra("last", 0L), stringExtra, intent, goAsync(), 1)).start();
    }
}
