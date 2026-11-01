package com.nix.host;

import a.AppState;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import i.b;

public final class BootReceiver extends BroadcastReceiver {
    @Override
    public final void onReceive(Context context, Intent intent) {
        String action;
        if (intent == null || (action = intent.getAction()) == null) {
            return;
        }
        if (action.equals("android.intent.action.BOOT_COMPLETED") || action.equals("android.intent.action.MY_PACKAGE_REPLACED")) {
            try {
                AppState.prefs = context.getSharedPreferences("nixhost", 0);
                String str = "";
                SharedPreferences sharedPreferences = AppState.prefs;
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
