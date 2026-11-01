package a;

import android.content.Context;
import android.content.Intent;
import com.nix.host.HostService;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

public final class TerminalManager {

    public static final TerminalManager INSTANCE = new TerminalManager();

    public static final HashMap sessions = new HashMap();

    public static volatile Context appContext;

    public static volatile boolean keepAlive;

    public final synchronized boolean anyBusy() {
        boolean z;
        try {
            Collection values = sessions.values();
            z = false;
            if (!(values instanceof Collection) || !values.isEmpty()) {
                Iterator it = values.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((TerminalSession) it.next()).busy) {
                        z = true;
                        break;
                    }
                }
            }
        } finally {
        }
        return z;
    }

    public final synchronized boolean hasBusySession() {
        boolean z;
        try {
            Collection values = sessions.values();
            z = false;
            if (!(values instanceof Collection) || !values.isEmpty()) {
                Iterator it = values.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((TerminalSession) it.next()).busy) {
                        z = true;
                        break;
                    }
                }
            }
        } finally {
        }
        return z;
    }

    public final void syncServiceState() {
        Context context = appContext;
        if (context == null) {
            return;
        }
        try {
            if (!anyBusy() && !keepAlive) {
                HttpServer httpServer = HostService.server;
                if (HostService.server == null) {
                    context.startService(new Intent(context, (Class<?>) HostService.class).setAction("com.nix.host.STOP"));
                }
            }
            context.startForegroundService(new Intent(context, (Class<?>) HostService.class).putExtra("keep", true).putExtra("busy", anyBusy()));
        } catch (Exception unused) {
        }
    }

    public final TerminalSession getOrCreateSession(File file, File file2, String str) {
        synchronized (this) {
            TerminalSession terminalSession = (TerminalSession) sessions.get(str);
            if (terminalSession != null && (i.b.a(terminalSession.homeDir.getPath(), file.getPath()) || terminalSession.busy)) {
                return terminalSession;
            }
            if (terminalSession != null) {
                try {
                    terminalSession.interrupt();
                } catch (Exception unused) {
                }
            }
            TerminalManager terminalManager = INSTANCE;
            TerminalSession terminalSession2 = new TerminalSession(file, file2, terminalManager.logFileFor(str));
            try {
                File f2 = terminalManager.logFileFor(str);
                if (f2 != null) {
                    File file3 = new File(f2.getPath() + ".key");
                    File parentFile = file3.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    g.m.L(file3, str);
                }
            } catch (Exception unused2) {
            }
            sessions.put(str, terminalSession2);
            terminalSession2.start();
            return terminalSession2;
        }
    }

    public final synchronized void closeAllSessions() {
        for (TerminalSession terminalSession : sessions.values()) {
            terminalSession.getClass();
            try {
                terminalSession.interrupt();
            } catch (Exception unused) {
            }
        }
        sessions.clear();
    }

    public final synchronized File logFileFor(String str) {
        Context context = appContext;
        if (context == null) {
            return null;
        }
        File file = new File(context.getFilesDir(), "termlog");
        Pattern compile = Pattern.compile("[^A-Za-z0-9._-]");
        i.b.d(compile, "compile(...)");
        i.b.e(str, "input");
        String replaceAll = compile.matcher(str).replaceAll("_");
        i.b.d(replaceAll, "replaceAll(...)");
        return new File(file, replaceAll);
    }
}
