package a;

import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TerminalSession {

    public final File homeDir;

    public final File envHomeDir;

    public final File logFile;

    public final StringBuilder output;

    public int outputFlushed;

    public volatile File currentDir;

    public volatile String pendingCommand;

    public volatile int restartCount;

    public volatile boolean busy;

    public volatile String prompt;

    public volatile java.lang.Process process;

    public volatile int shellPid;

    public volatile boolean installing;

    public volatile boolean installCancelled;

    public volatile int generation;
    public volatile boolean cloning;
    public volatile boolean killed;

    public final i.g npmInstallPattern;

    public final i.g ansiEscapePattern;

    public final i.g controlCharsPattern;

    public final i.g trailingEscapePattern;

    public TerminalSession(File homeDir, File envHomeDir, File logFile) {
        this.homeDir = homeDir;
        this.envHomeDir = envHomeDir;
        this.logFile = logFile;
        StringBuilder sb = new StringBuilder();
        this.output = sb;
        this.currentDir = homeDir;
        if (logFile != null) {
            try {
                if (logFile.isFile()) {
                    String savedOutput = g.m.I(logFile);
                    if (savedOutput.length() > 40000) {
                        savedOutput = savedOutput.substring(savedOutput.length() - 40000);
                        i.b.d(savedOutput, "substring(...)");
                    }
                    sb.append(savedOutput);
                }
            } catch (Exception unused) {
            }
        }
        File runFile = runFile();
        if (runFile != null && runFile.isFile()) {
            String savedCommand = m.e.h0(g.m.I(runFile)).toString();
            runFile.delete();
            if (savedCommand.length() > 0) {
                this.pendingCommand = savedCommand;
                File tryFile = tryFile();
                Integer count = null;
                if (tryFile != null) {
                    try {
                        String savedCount = m.e.h0(g.m.I(tryFile)).toString();
                        if (savedCount != null) {
                            count = m.l.C(savedCount);
                        }
                    } catch (Exception unused2) {
                    }
                }
                int newCount = (count != null ? count.intValue() : 0) + 1;
                if (tryFile != null) {
                    try {
                        g.m.L(tryFile, String.valueOf(newCount));
                    } catch (Exception unused3) {
                    }
                }
                this.restartCount = newCount;
                echo("\n[Android stopped the app while this was running: " + savedCommand + "]\n");
            }
        }
        File cwdFile = cwdFile();
        if (cwdFile != null && cwdFile.isFile()) {
            String savedCwd = g.m.I(cwdFile);
            if (savedCwd.length() > 0) {
                File canonicalFile = new File(this.homeDir, savedCwd).getCanonicalFile();
                String canonicalPath = this.homeDir.getCanonicalPath();
                if (canonicalFile.isDirectory()) {
                    if (!i.b.a(canonicalFile.getPath(), canonicalPath)) {
                    }
                    setCurrentDir(canonicalFile);
                }
            }
        }
        this.prompt = "";
        this.npmInstallPattern = new i.g("^npm\\s+(install|i|ci|add|update|up)(\\s.*)?$");
        this.ansiEscapePattern = new i.g("\u001b\\[[0-9;?]*[ -/]*[@-~]");
        this.controlCharsPattern = new i.g("[\u0001\u0002\u0003\u0004\f]");
        this.trailingEscapePattern = new i.g("\u001b(\\[[0-9;?]*[ -/]*)?$");
    }

    public static String progressBar(int percent) {
        int filled = (percent * 16) / 100;
        return "[" + m.m.H(filled, "#") + m.m.H(16 - filled, ".") + "] " + percent + "%";
    }

    public static void killProcessTree(int rootPid) {
        java.lang.Process psProcess;
        BufferedReader psReader;
        l.b lines;
        List list;
        HashMap hashMap = new HashMap();
        try {
            psProcess = new ProcessBuilder("/system/bin/ps", "-A", "-o", "PID,PPID").redirectErrorStream(true).start();
            psReader = new BufferedReader(new InputStreamReader(psProcess.getInputStream(), m.a.f864a), 8192);
        } catch (Exception unused) {
            return;
        }
        try {
            l.c sequence = new l.a(new g.p(psReader));
            if (sequence instanceof l.b) {
                l.b bVar2 = (l.b) sequence;
                int skip = bVar2.f862b + 1;
                lines = skip < 0 ? new l.b(bVar2, 1) : new l.b(bVar2.f861a, skip);
            } else {
                lines = new l.b(sequence, 1);
            }
            Iterator it = lines.f861a.iterator();
            int remaining = lines.f862b;
            while (true) {
                if (remaining > 0) {
                    if (it.hasNext()) {
                        it.next();
                        remaining--;
                    }
                }
                if (!it.hasNext()) {
                    break;
                }
                while (remaining > 0 && it.hasNext()) {
                    it.next();
                    remaining--;
                }
                String line = m.e.h0((String) it.next()).toString();
                Pattern compile = Pattern.compile("\\s+");
                i.b.d(compile, "compile(...)");
                i.b.e(line, "input");
                m.e.Z(0);
                Matcher matcher = compile.matcher(line);
                if (matcher.find()) {
                    ArrayList arrayList = new ArrayList(10);
                    int start = 0;
                    do {
                        arrayList.add(line.subSequence(start, matcher.start()).toString());
                        start = matcher.end();
                    } while (matcher.find());
                    arrayList.add(line.subSequence(start, line.length()).toString());
                    list = arrayList;
                } else {
                    list = AppState.p(line.toString());
                }
                if (list.size() >= 2) {
                    Integer pid = m.l.C((String) list.get(0));
                    Integer ppid = m.l.C((String) list.get(1));
                    if (pid != null && ppid != null) {
                        Object children = hashMap.get(ppid);
                        if (children == null) {
                            children = new ArrayList();
                            hashMap.put(ppid, children);
                        }
                        ((List) children).add(pid);
                    }
                }
            }
            AppState.a(psReader, null);
            psProcess.waitFor();
            ArrayList toKill = new ArrayList();
            collectProcessTree(hashMap, toKill, rootPid);
            Iterator it2 = toKill.iterator();
            while (it2.hasNext()) {
                try {
                    Process.killProcess(((Number) it2.next()).intValue());
                } catch (Exception unused2) {
                }
            }
        } finally {
        }
    }

    public static final void collectProcessTree(HashMap childrenByParent, ArrayList out, int pid) {
        List children = (List) childrenByParent.get(Integer.valueOf(pid));
        if (children != null) {
            Iterator it = children.iterator();
            while (it.hasNext()) {
                collectProcessTree(childrenByParent, out, ((Number) it.next()).intValue());
            }
        }
        out.add(Integer.valueOf(pid));
    }

    public final synchronized void echo(String text) {
        try {
            this.output.append(text);
            if (this.output.length() > 60000) {
                int trim = this.output.length() - 40000;
                this.output.delete(0, trim);
                this.outputFlushed += trim;
                persistOutput(text, true);
            } else {
                persistOutput(text, false);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final String cleanOutput(String raw) {
        String marker;
        String cleaned;
        String stripped = ((Pattern) this.controlCharsPattern.f850b).matcher(m.m.J(raw, "\r", "")).replaceAll("");
        i.b.d(stripped, "replaceAll(...)");
        i.g pattern = this.ansiEscapePattern;
        pattern.getClass();
        m.d match = i.g.a(pattern, stripped);
        if (match == null) {
            cleaned = stripped.toString();
        } else {
            int length = stripped.length();
            StringBuilder sb2 = new StringBuilder(length);
            int pos = 0;
            do {
                sb2.append((CharSequence) stripped, pos, match.a().f852a);
                if (match.b().endsWith("m")) {
                    String params = match.b().substring(2, match.b().length() - 1);
                    i.b.d(params, "substring(...)");
                    marker = "\u0003" + params + "\u0004";
                } else {
                    marker = "";
                }
                sb2.append((CharSequence) marker);
                pos = match.a().f853b + 1;
                Matcher matcher = (Matcher) match.f876a;
                int end = matcher.end() + (matcher.end() != matcher.start() ? 0 : 1);
                CharSequence source = (CharSequence) match.f877b;
                m.d next = null;
                if (end <= source.length()) {
                    Matcher matcher2 = matcher.pattern().matcher(source);
                    i.b.d(matcher2, "matcher(...)");
                    String sourceText = (String) source;
                    if (matcher2.find(end)) {
                        next = new m.d(matcher2, sourceText);
                    }
                }
                match = next;
                if (pos >= length) {
                    break;
                }
            } while (match != null);
            if (pos < length) {
                sb2.append((CharSequence) stripped, pos, length);
            }
            cleaned = sb2.toString();
            i.b.d(cleaned, "toString(...)");
        }
        return m.m.J(cleaned, "\u001b", "");
    }

    public final File cwdFile() {
        File file = this.logFile;
        if (file == null) {
            return null;
        }
        return new File(file.getPath() + ".cwd");
    }

    public final void runShellCommand(File dir, String command) {
        String leftover;
        boolean keepGoing = true;
        AtomicBoolean running = new AtomicBoolean(true);
        this.killed = false;
        try {
            this.envHomeDir.mkdirs();
            File tmpDir = new File(this.envHomeDir, "tmp");
            tmpDir.mkdirs();
            TermuxPackageManager.INSTANCE.refreshShimsAndHelpers(dir, this.envHomeDir);
            ProcessBuilder processBuilder = new ProcessBuilder("/system/bin/sh", "-c", "echo __NIXPID__$$; " + command);
            processBuilder.directory(dir);
            processBuilder.redirectErrorStream(true);
            Map<String, String> environment = processBuilder.environment();
            environment.put("HOME", this.envHomeDir.getPath());
            environment.put("TMPDIR", tmpDir.getPath());
            environment.put("TERM", "xterm-256color");
            environment.put("COLORTERM", "truecolor");
            environment.put("FORCE_COLOR", "1");
            environment.put("CLICOLOR_FORCE", "1");
            environment.put("npm_config_color", "always");
            environment.put("npm_config_cache", new File(this.envHomeDir, ".npm").getPath());
            environment.put("npm_config_audit", "false");
            TermuxPackageManager.buildEnvironment(environment, this.envHomeDir, dir);
            java.lang.Process shell = processBuilder.start();
            this.process = shell;
            Thread refresher = new Thread(new SendAndPersistRunnable(running, TermuxPackageManager.isExternalStorage(dir) ? 2500L : 1000L, dir, this));
            refresher.setDaemon(true);
            refresher.start();
            InputStreamReader reader = new InputStreamReader(shell.getInputStream(), m.a.f864a);
            char[] buffer = new char[4096];
            StringBuilder firstLine = new StringBuilder();
            String pending = "";
            boolean pidLineDone = false;
            while (true) {
                int read = reader.read(buffer);
                if (read < 0) {
                    break;
                }
                String chunk = pending + new String(buffer, 0, read);
                if (!pidLineDone) {
                    firstLine.append(chunk);
                    int newline = firstLine.indexOf("\n");
                    if (newline >= 0) {
                        Integer pid = m.l.C(m.e.X(m.e.h0(firstLine.substring(0, newline)).toString(), "__NIXPID__"));
                        this.shellPid = pid != null ? pid.intValue() : 0;
                        chunk = firstLine.substring(newline + 1);
                        pidLineDone = keepGoing;
                    } else {
                        pending = "";
                    }
                }
                m.d trailing = i.g.a(this.trailingEscapePattern, chunk);
                if (trailing == null || chunk.length() - trailing.a().f852a >= 40) {
                    leftover = "";
                } else {
                    leftover = chunk.substring(trailing.a().f852a);
                    i.b.d(leftover, "substring(...)");
                    chunk = chunk.substring(0, trailing.a().f852a);
                    i.b.d(chunk, "substring(...)");
                }
                String cleaned = cleanOutput(chunk);
                if (cleaned.length() > 0) {
                    echo(cleaned);
                }
                pending = leftover;
                keepGoing = true;
            }
            shell.waitFor();
        } catch (Exception e2) {
            if (!this.killed) {
                String message = e2.getMessage();
                if (message == null) {
                    message = "could not run";
                }
                echo("error: " + message + "\n");
            }
        }
        running.set(false);
        TermuxPackageManager.INSTANCE.refreshShimsAndHelpers(dir, this.envHomeDir);
    }

    public final void finishRun() {
        try {
            File runFile = runFile();
            if (runFile != null) {
                runFile.delete();
            }
        } catch (Exception unused) {
        }
        try {
            File tryFile = tryFile();
            if (tryFile != null) {
                tryFile.delete();
            }
        } catch (Exception unused2) {
        }
        this.busy = false;
        this.cloning = false;
        this.prompt = "";
        this.process = null;
        this.shellPid = 0;
        TerminalManager.INSTANCE.syncServiceState();
    }

    public final void installPackages(ArrayList packageNames, String followUpCommand) {
        this.busy = true;
        this.installing = true;
        this.installCancelled = false;
        this.prompt = progressBar(0);
        TerminalManager.INSTANCE.syncServiceState();
        new Thread(new QuadTaskRunnable(packageNames, this, this.currentDir, followUpCommand)).start();
    }

    public final void interrupt() {
        java.lang.Process runningProcess = this.process;
        if (runningProcess != null) {
            this.killed = true;
            int pid = this.shellPid;
            if (pid > 0) {
                try {
                    killProcessTree(pid);
                } catch (Exception unused) {
                }
            }
            try {
                runningProcess.destroyForcibly();
                return;
            } catch (Exception unused2) {
                return;
            }
        }
        if (this.installing) {
            this.installCancelled = true;
        } else if (this.cloning) {
            this.generation++;
            finishRun();
        }
    }

    public final void persistOutput(String text, boolean rewriteAll) {
        try {
            File file = this.logFile;
            if (file == null) {
                return;
            }
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            if (rewriteAll) {
                g.m.L(file, this.output.toString());
                return;
            }
            Charset charset = m.a.f864a;
            i.b.e(text, "text");
            i.b.e(charset, "charset");
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            try {
                g.m.M(fileOutputStream, text, charset);
                AppState.a(fileOutputStream, null);
            } finally {
            }
        } catch (Exception unused) {
        }
    }

    public final String cwdLabel() {
        try {
            String homePath = this.homeDir.getCanonicalPath();
            String currentPath = this.currentDir.getCanonicalPath();
            return i.b.a(currentPath, homePath) ? "" : m.e.X(currentPath, homePath);
        } catch (Exception unused) {
            return "";
        }
    }

    public final File resolvePath(String path) {
        File file;
        try {
            String cleaned = m.e.i0(m.e.h0(path).toString(), '\"', '\'');
            if (i.b.a(cleaned, "~")) {
                file = this.homeDir;
            } else {
                file = m.m.K(cleaned, "/") ? new File(this.homeDir, cleaned) : new File(this.currentDir, cleaned);
            }
            File canonicalFile = file.getCanonicalFile();
            String homePath = this.homeDir.getCanonicalPath();
            if (!i.b.a(canonicalFile.getPath(), homePath)) {
                if (!m.m.K(canonicalFile.getPath(), homePath + "/")) {
                    return null;
                }
            }
            return canonicalFile;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void start() {
        String command = this.pendingCommand;
        if (command == null) {
            return;
        }
        this.pendingCommand = null;
        if (this.busy) {
            return;
        }
        Pattern compile = Pattern.compile("^(rm|mv|cp|kill|clear)(\\s.*)?$");
        i.b.d(compile, "compile(...)");
        if (compile.matcher(command).matches()) {
            return;
        }
        if (this.restartCount < 3) {
            echo("$ " + command + "   (continuing)\n");
            if (this.npmInstallPattern.b(command)) {
                command = command.concat(" && npm rebuild");
            }
            launchCommand(command);
            return;
        }
        try {
            File runFile = runFile();
            if (runFile != null) {
                runFile.delete();
            }
        } catch (Exception unused) {
        }
        try {
            File tryFile = tryFile();
            if (tryFile != null) {
                tryFile.delete();
            }
        } catch (Exception unused2) {
        }
        echo("\nAndroid stopped the app " + this.restartCount + " times while running this (low memory?). Not restarting it again.\nClose other apps, then run it again. If it was an install, run: npm rebuild\n");
    }

    public final File runFile() {
        File file = this.logFile;
        if (file == null) {
            return null;
        }
        return new File(file.getPath() + ".run");
    }

    public final void launchCommand(String command) {
        try {
            File runFile = runFile();
            if (runFile != null) {
                File parentFile = runFile.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                g.m.L(runFile, command);
            }
        } catch (Exception unused) {
        }
        String firstWord = m.e.e0(command, ' ');
        if (firstWord.equals("node") || firstWord.equals("npm") || firstWord.equals("npx")) {
            TermuxPackageManager y2Var = TermuxPackageManager.INSTANCE;
            try {
                if (TermuxPackageManager.isPrefixRecorded()) {
                    if (new File(TermuxPackageManager.prefixDir(), "bin/".concat(firstWord)).canExecute()) {
                        try {
                            boolean toolsCurrent = i.b.a(m.e.h0(g.m.I(new File(TermuxPackageManager.prefixDir(), "var/lib/nixpkg/tools"))).toString(), "5");
                        } catch (Exception unused2) {
                            boolean toolsCurrent = false;
                        }
                    }
                }
            } catch (Exception unused3) {
            }
            TermuxPackageManager y2Var2 = TermuxPackageManager.INSTANCE;
            installPackages(TermuxPackageManager.defaultPackages(), command);
            return;
        }
        this.busy = true;
        this.prompt = this.npmInstallPattern.b(command) ? "Installing packages..." : "";
        TerminalManager.INSTANCE.syncServiceState();
        new Thread(new BackgroundTask((Object) this, (Object) command, (Object) this.currentDir, 10, (byte) 0)).start();
    }

    public final void setCurrentDir(File dir) {
        this.currentDir = dir;
        try {
            File cwdFile = cwdFile();
            if (cwdFile == null) {
                return;
            }
            File parentFile = cwdFile.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            g.m.L(cwdFile, cwdLabel());
        } catch (Exception unused) {
        }
    }

    public final void runCommand(String command) {
        List list;
        if (this.busy) {
            return;
        }
        echo("$ " + command + "\n");
        String trimmed = m.e.h0(command).toString();
        if (trimmed.length() == 0) {
            return;
        }
        Pattern compile = Pattern.compile("\\s+");
        i.b.d(compile, "compile(...)");
        m.e.Z(0);
        Matcher matcher = compile.matcher(trimmed);
        if (matcher.find()) {
            ArrayList arrayList = new ArrayList(10);
            int pos = 0;
            do {
                arrayList.add(trimmed.subSequence(pos, matcher.start()).toString());
                pos = matcher.end();
            } while (matcher.find());
            arrayList.add(trimmed.subSequence(pos, trimmed.length()).toString());
            list = arrayList;
        } else {
            list = AppState.p(trimmed.toString());
        }
        String name = (String) list.get(0);
        switch (name) {
            case "gclone": {
                List args = c.b.H(list, 1);
                if (args.isEmpty() || args.size() > 2) {
                    echo("Usage: gclone <folder> <github-url>\n");
                    break;
                }
                String first = (String) args.get(0);
                String second = (String) c.b.J(args, 1);
                String folder;
                String url;
                if (second == null) {
                    folder = first;
                    url = null;
                } else if (m.e.L(first)) {
                    url = second;
                    folder = first;
                } else {
                    folder = second;
                    url = first;
                }
                File dir = this.currentDir;
                this.busy = true;
                this.prompt = "Downloading...";
                TerminalManager.INSTANCE.syncServiceState();
                int gen = this.generation;
                this.cloning = true;
                new Thread(new MultiWorkRunnable(folder, url, dir, gen, this)).start();
                break;
            }
            case "cd": {
                List args = c.b.H(list, 1);
                if (args.isEmpty()) {
                    setCurrentDir(this.homeDir);
                    break;
                }
                String joined = c.b.L(args, " ", null, null, null, 62);
                File target = resolvePath(joined);
                if (target == null || !target.isDirectory()) {
                    echo("cd: " + joined + ": No such folder\n");
                    break;
                }
                setCurrentDir(target);
                break;
            }
            case "ls": {
                Object found = null;
                Iterator it = c.b.H(list, 1).iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object next = it.next();
                        if (!m.m.K((String) next, "-")) {
                            found = next;
                        }
                    } else {
                        break;
                    }
                }
                String arg = (String) found;
                File target = arg == null ? this.currentDir : resolvePath(arg);
                if (target == null || !target.exists()) {
                    echo("ls: " + (arg != null ? arg : "") + ": No such file or folder\n");
                    break;
                }
                if (target.isFile()) {
                    echo(target.getName() + "\n");
                    break;
                }
                List<File> entries = c.j.f773a;
                File[] listFiles = target.listFiles();
                if (listFiles != null) {
                    entries = c.a.F(listFiles, new SortComparator(4));
                }
                StringBuilder sb = new StringBuilder();
                for (File entry : entries) {
                    if (entry.isDirectory()) {
                        sb.append((char) 1);
                        sb.append(entry.getName());
                        sb.append("\u0002\n");
                    } else {
                        sb.append(entry.getName());
                        sb.append('\n');
                    }
                }
                echo(sb.toString());
                break;
            }
            case "pkg":
            case "apt":
            case "apt-get": {
                List args = c.b.H(list, 1);
                String sub = (String) c.b.I(args);
                if (sub == null) {
                    echo("pkg install <name> ...   (Termux packages, e.g. nodejs-lts)\npkg list   pkg update   pkg upgrade\n");
                    break;
                }
                switch (sub) {
                    case "install":
                    case "add":
                    case "i": {
                        List rest = c.b.H(args, 1);
                        ArrayList names = new ArrayList();
                        Iterator restIt = rest.iterator();
                        while (restIt.hasNext()) {
                            Object item = restIt.next();
                            if (!m.m.K((String) item, "-")) {
                                names.add(item);
                            }
                        }
                        if (names.isEmpty()) {
                            echo("Usage: pkg install <name> ...\n");
                            break;
                        }
                        installPackages(names, null);
                        break;
                    }
                    case "list":
                    case "ls":
                    case "list-installed": {
                        String message = "No packages installed.\n";
                        String installedText = m.e.h0(g.m.I(new File(TermuxPackageManager.prefixDir(), "var/lib/nixpkg/installed"))).toString();
                        if (installedText.length() != 0) {
                            message = installedText.concat("\n");
                        }
                        echo(message);
                        break;
                    }
                    case "upgrade":
                    case "full-upgrade": {
                        List installedNames = c.b.Q(TermuxPackageManager.readInstalled(TermuxPackageManager.prefixDir()).keySet());
                        ArrayList reinstall = new ArrayList(c.d.E(installedNames));
                        Iterator namesIt = installedNames.iterator();
                        while (namesIt.hasNext()) {
                            reinstall.add(((String) namesIt.next()) + "?");
                        }
                        if (reinstall.isEmpty()) {
                            echo("No packages installed.\n");
                            break;
                        }
                        installPackages(reinstall, null);
                        break;
                    }
                    case "update": {
                        this.busy = true;
                        this.prompt = "Updating package list...";
                        TerminalManager.INSTANCE.syncServiceState();
                        new Thread(new TaskRunnable(10, this)).start();
                        break;
                    }
                    default:
                        echo("pkg install <name> ...   (Termux packages, e.g. nodejs-lts)\npkg list   pkg update   pkg upgrade\n");
                        break;
                }
                break;
            }
            case "pwd": {
                String label = cwdLabel();
                if (label.length() == 0) {
                    label = "/";
                }
                echo(((Object) label) + "\n");
                break;
            }
            case "diag": {
                this.busy = true;
                this.prompt = "";
                TerminalManager.INSTANCE.syncServiceState();
                new Thread(new HttpConnectionHandler(this, this.currentDir, 10)).start();
                break;
            }
            case "help":
                echo("ls  cd <folder>  pwd  clear  kill\nnpm install  npm start  node index.js\ngclone <folder> <github-url>\npkg install <name>  pkg list  pkg update  pkg upgrade  (Termux packages)\nsetup  (install Node.js now)\n");
                break;
            case "kill":
                interrupt();
                break;
            case "clear":
                echo("\f");
                break;
            case "setup": {
                TermuxPackageManager y2Var = TermuxPackageManager.INSTANCE;
                installPackages(TermuxPackageManager.defaultPackages(), null);
                break;
            }
            default:
                launchCommand(trimmed);
                break;
        }
    }

    public final File tryFile() {
        File file = this.logFile;
        if (file == null) {
            return null;
        }
        return new File(file.getPath() + ".try");
    }

    public final void deleteLogFiles() {
        File file = this.logFile;
        if (file != null) {
            try {
                file.delete();
            } catch (Exception unused) {
            }
        }
        try {
            File cwdFile = cwdFile();
            if (cwdFile != null) {
                cwdFile.delete();
            }
        } catch (Exception unused2) {
        }
        try {
            File runFile = runFile();
            if (runFile != null) {
                runFile.delete();
            }
        } catch (Exception unused3) {
        }
        try {
            File tryFile = tryFile();
            if (tryFile != null) {
                tryFile.delete();
            }
        } catch (Exception unused4) {
        }
        if (file != null) {
            try {
                new File(file.getPath() + ".key").delete();
            } catch (Exception unused5) {
            }
        }
    }
}
