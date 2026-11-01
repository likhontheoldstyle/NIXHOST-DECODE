package com.nix.host;

import a.AbstractC0008c;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import i.b;

/* loaded from: classes.dex */
public final class BootReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action;
        if (intent == null || (action = intent.getAction()) == null) {
            return;
        }
        if (action.equals("android.intent.action.BOOT_COMPLETED") || action.equals("android.intent.action.MY_PACKAGE_REPLACED")) {
            try {
                AbstractC0008c.f440c = context.getSharedPreferences("nixhost", 0);
                String str = "";
                SharedPreferences sharedPreferences = AbstractC0008c.f440c;
                if (sharedPreferences == null) {
                    b.g("sp");
                    throw null;
                }
                String string = sharedPreferences.getString("user", "");
                if (string != null) {
                    str = string;
                }
                if (str.length() == 0) {
                    return;
                }
                context.startForegroundService(new Intent(context, (Class<?>) HostService.class).setAction("com.nix.host.RESTORE"));
            } catch (Exception unused) {
            }
        }
    }
}
