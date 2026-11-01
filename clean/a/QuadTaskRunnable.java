package a;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.MediaScannerConnection;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.os.Environment;
import android.util.Size;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class QuadTaskRunnable implements Runnable {

    public final int mode;

    public final Object first;

    public final Object second;

    public final Object third;

    public final Object fourth;

    public QuadTaskRunnable(ApiResponse apiResponse, PendingReaction pendingReaction, ChatScreen chatScreen, ChatMessage chatMessage) {
        this.mode = 1;
        this.fourth = apiResponse;
        this.first = pendingReaction;
        this.second = chatScreen;
        this.third = chatMessage;
    }

    private final void loadEditorThumbnail() {
        Bitmap loadThumbnail;
        Bitmap bitmap = null;
        MediaPicker mediaPicker = (MediaPicker) this.third;
        mediaPicker.getClass();
        int i2 = Build.VERSION.SDK_INT;
        MediaItem mediaItem = (MediaItem) this.second;
        if (i2 >= 29) {
            try {
                loadThumbnail = mediaPicker.activity.getContentResolver().loadThumbnail(mediaItem.uri, new Size(320, 320), null);
                bitmap = loadThumbnail;
            } catch (Throwable unused) {
            }
            mediaPicker.mainHandler.post(new QuadTaskRunnable((Object) mediaPicker, (String) this.fourth, (Object) bitmap, this.first, 6));
        }
        boolean z = mediaItem.isVideo;
        Bitmap bitmap2 = null;
        String str = mediaItem.filePath;
        if (z) {
            bitmap2 = ThumbnailUtils.createVideoThumbnail(str, 1);
        } else {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i3 = 1;
            while (true) {
                int i4 = i3 * 2;
                if (options.outWidth / i4 < 320 || options.outHeight / i4 < 320) {
                    break;
                } else {
                    i3 = i4;
                }
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = i3;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options2);
            if (decodeFile != null) {
                int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
                int i5 = attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : 270 : 90 : 180;
                if (i5 != 0) {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(i5);
                    bitmap2 = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
                } else {
                    bitmap2 = decodeFile;
                }
            }
        }
        bitmap = bitmap2;
        mediaPicker.mainHandler.post(new QuadTaskRunnable((Object) mediaPicker, (String) this.fourth, (Object) bitmap, this.first, 6));
    }

    @Override
    public final void run() {
        boolean z;
        JSONObject c2;
        Bitmap bitmap;
        TerminalSession terminalSession;
        File file;
        String str;
        String str2;
        String str3;
        String str4;
        String message;
        File file2;
        File B;
        boolean exists;
        boolean z2;
        File[] listFiles;
        boolean z3;
        File B2 = null;
        String str5 = null;
        ArrayList H = null;
        String str6 = null;
        long j2;
        Iterator it;
        File file3;
        ArrayList arrayList;
        Throwable th;
        boolean z4;
        List list;
        Exception e = null;
        int i2 = 3;
        switch (this.mode) {
            case 0:
                ApiClient apiClient = ApiClient.INSTANCE;
                ChatMessage chatMessage = (ChatMessage) this.third;
                ApiResponse b2 = ApiClient.requestWithDefaults(apiClient, "POST", "/chat/react", new JSONObject().put("msg", chatMessage.id).put("emoji", (String) this.fourth), 8);
                ChatScreen chatScreen = (ChatScreen) this.second;
                chatScreen.activity.runOnUiThread(new QuadTaskRunnable(b2, (PendingReaction) this.first, chatScreen, chatMessage));
                return;
            case 1:
                ApiResponse apiResponse = (ApiResponse) this.fourth;
                boolean b3 = apiResponse.isSuccess();
                PendingReaction pendingReaction = (PendingReaction) this.first;
                if (b3) {
                    pendingReaction.acknowledged = true;
                    pendingReaction.sentAtMs = System.currentTimeMillis();
                    return;
                }
                ChatScreen chatScreen2 = (ChatScreen) this.second;
                HashMap hashMap = chatScreen2.reactionTimestamps;
                ChatMessage chatMessage2 = (ChatMessage) this.third;
                if (hashMap.get(Long.valueOf(chatMessage2.id)) == pendingReaction) {
                    chatScreen2.reactionTimestamps.remove(Long.valueOf(chatMessage2.id));
                }
                chatScreen2.toaster.a(ChatScreen.errorText(apiResponse));
                chatScreen2.syncSeen();
                return;
            case 2:
                String str7 = (String) this.fourth;
                final ChatScreen chatScreen3 = (ChatScreen) this.second;
                final i.d dVar = new i.d();
                try {
                    File b4 = ChatMedia.fetchMediaFile(str7);
                    if (b4 != null) {
                        File file4 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "NixHost");
                        file4.mkdirs();
                        File file5 = new File(file4, "NixHost_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date()) + ".jpg");
                        g.m.D(b4, file5, true);
                        MediaScannerConnection.scanFile(chatScreen3.activity, new String[]{file5.getPath()}, new String[]{"image/jpeg"}, null);
                        dVar.f846a = file5.length() > 0;
                    }
                } catch (Exception unused) {
                }
                Activity activity = chatScreen3.activity;
                final HideTextRunnable hideTextRunnable = (HideTextRunnable) ((Runnable) this.first);
                final TextView textView = (TextView) this.third;
                final int i3 = 0;
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public final void run() {
                        switch (i3) {
                            case 0:
                                String str8 = dVar.f846a ? "Downloaded" : "Could not save the photo";
                                HideTextRunnable hideTextRunnable2 = (HideTextRunnable) hideTextRunnable;
                                TextView textView2 = textView;
                                textView2.setText(str8);
                                textView2.setVisibility(0);
                                ChatScreen chatScreen4 = chatScreen3;
                                chatScreen4.handler.removeCallbacks(hideTextRunnable2);
                                chatScreen4.handler.postDelayed(hideTextRunnable2, 2400L);
                                break;
                            default:
                                ChatScreen.showTransientText((HideTextRunnable) hideTextRunnable, chatScreen3, textView, dVar.f846a ? "Downloaded" : "Could not save the video");
                                break;
                        }
                    }
                });
                return;
            case 3:
                File file6 = (File) this.third;
                final ChatScreen chatScreen5 = (ChatScreen) this.second;
                final i.d dVar2 = new i.d();
                try {
                    File file7 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES), "NixHost");
                    file7.mkdirs();
                    File file8 = new File(file7, "NixHost_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date()) + ".mp4");
                    g.m.D(file6, file8, true);
                    MediaScannerConnection.scanFile(chatScreen5.activity, new String[]{file8.getPath()}, new String[]{"video/mp4"}, null);
                    dVar2.f846a = file8.length() > 0;
                } catch (Exception unused2) {
                }
                Activity activity2 = chatScreen5.activity;
                final HideTextRunnable hideTextRunnable2 = (HideTextRunnable) ((Runnable) this.first);
                final TextView textView2 = (TextView) this.fourth;
                final int i4 = 1;
                activity2.runOnUiThread(new Runnable() {
                    @Override
                    public final void run() {
                        switch (i4) {
                            case 0:
                                String str8 = dVar2.f846a ? "Downloaded" : "Could not save the photo";
                                HideTextRunnable hideTextRunnable22 = (HideTextRunnable) hideTextRunnable2;
                                TextView textView22 = textView2;
                                textView22.setText(str8);
                                textView22.setVisibility(0);
                                ChatScreen chatScreen6 = chatScreen5;
                                chatScreen6.handler.removeCallbacks(hideTextRunnable22);
                                chatScreen6.handler.postDelayed(hideTextRunnable22, 2400L);
                                break;
                            default:
                                ChatScreen.showTransientText((HideTextRunnable) hideTextRunnable2, chatScreen5, textView2, dVar2.f846a ? "Downloaded" : "Could not save the video");
                                break;
                        }
                    }
                });
                return;
            case 4:
                ChatScreen chatScreen7 = (ChatScreen) this.second;
                chatScreen7.seenSyncStarted = false;
                if (chatScreen7.active) {
                    ApiResponse apiResponse2 = (ApiResponse) this.third;
                    if (apiResponse2.code == 401) {
                        chatScreen7.onSessionExpired.a();
                        return;
                    }
                    JSONObject c3 = apiResponse2.json();
                    if (apiResponse2.code == 0) {
                        if (chatScreen7.connectionState != 2 || System.currentTimeMillis() - chatScreen7.connectingSince > 8000) {
                            chatScreen7.setConnectionState(1);
                            return;
                        }
                        return;
                    }
                    if (chatScreen7.connectionState != 0) {
                        chatScreen7.setConnectionState(0);
                        if (chatScreen7.members.isEmpty()) {
                            chatScreen7.refreshMembers();
                        }
                    }
                    if (!apiResponse2.isSuccess() || c3 == null) {
                        if (chatScreen7.cacheLoaded) {
                            return;
                        }
                        chatScreen7.emptyStateText = apiResponse2.errorMessage();
                        chatScreen7.refreshHeader();
                        return;
                    }
                    chatScreen7.emptyStateText = "";
                    boolean z5 = !chatScreen7.cacheLoaded;
                    chatScreen7.cacheLoaded = true;
                    if (z5) {
                        JSONArray optJSONArray = c3.optJSONArray("msgs");
                        if ((optJSONArray != null ? optJSONArray.length() : 0) < 40) {
                            chatScreen7.hasMore = false;
                        }
                    }
                    long optLong = c3.optLong("cl", 0L);
                    String s2 = chatScreen7.clearMarkerKey();
                    SharedPreferences sharedPreferences = AppState.prefs;
                    if (sharedPreferences == null) {
                        i.b.g("sp");
                        throw null;
                    }
                    String string = sharedPreferences.getString(s2, "0");
                    Long D = m.l.D(string != null ? string : "0");
                    long longValue = D != null ? D.longValue() : 0L;
                    if (optLong > longValue) {
                        chatScreen7.clearMessagesBefore(optLong);
                    } else if (optLong < longValue) {
                        String s3 = chatScreen7.clearMarkerKey();
                        String valueOf = String.valueOf(optLong);
                        SharedPreferences sharedPreferences2 = AppState.prefs;
                        if (sharedPreferences2 == null) {
                            i.b.g("sp");
                            throw null;
                        }
                        sharedPreferences2.edit().putString(s3, valueOf).apply();
                    }
                    int b5 = chatScreen7.addMessages(c3.optJSONArray("msgs"));
                    boolean g2 = chatScreen7.applySyncPayload(c3);
                    chatScreen7.applyQuickReactionUpdate(c3);
                    chatScreen7.applyThemeUpdate(c3);
                    JSONArray optJSONArray2 = c3.optJSONArray("ty");
                    ArrayList arrayList2 = new ArrayList();
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i5 = 0; i5 < length; i5++) {
                            String optString = optJSONArray2.optString(i5);
                            if (!i.b.a(optString, chatScreen7.username)) {
                                arrayList2.add(optString);
                            }
                        }
                    }
                    if (!arrayList2.equals(chatScreen7.typingUsers)) {
                        chatScreen7.typingUsers = arrayList2;
                        chatScreen7.refreshHeader();
                    }
                    ApiResponse apiResponse3 = (ApiResponse) this.fourth;
                    JSONObject c4 = apiResponse3.json();
                    JSONObject optJSONObject = c4 != null ? c4.optJSONObject("seen") : null;
                    if (!apiResponse3.isSuccess() || optJSONObject == null) {
                        z = false;
                    } else {
                        Iterator<String> keys = optJSONObject.keys();
                        z = false;
                        while (keys.hasNext()) {
                            String next = keys.next();
                            long optLong2 = optJSONObject.optLong(next);
                            HashMap hashMap2 = chatScreen7.lastSeen;
                            Long l2 = (Long) hashMap2.get(next);
                            if (l2 == null || l2.longValue() != optLong2) {
                                hashMap2.put(next, Long.valueOf(optLong2));
                                z = true;
                            }
                        }
                    }
                    ApiResponse apiResponse4 = (ApiResponse) this.first;
                    JSONArray optJSONArray3 = (apiResponse4 == null || (c2 = apiResponse4.json()) == null) ? null : c2.optJSONArray("online");
                    if ((apiResponse4 != null && apiResponse4.isSuccess()) && optJSONArray3 != null) {
                        HashSet hashSet = new HashSet();
                        int length2 = optJSONArray3.length();
                        for (int i6 = 0; i6 < length2; i6++) {
                            hashSet.add(optJSONArray3.optString(i6));
                        }
                        HashSet hashSet2 = chatScreen7.prefetchCheckedIds;
                        if (!hashSet.equals(hashSet2)) {
                            hashSet2.clear();
                            hashSet2.addAll(hashSet);
                            z = true;
                        }
                    }
                    if (b5 > 0 || g2 || z5 || z) {
                        chatScreen7.refreshMessages();
                        chatScreen7.applyScroll(z5);
                        if (b5 > 0 || g2 || z5) {
                            chatScreen7.saveCache();
                        }
                    }
                    if (z5) {
                        ChatListView i22 = chatScreen7.messageList;
                        if (i22 == null) {
                            i.b.g("lv");
                            throw null;
                        }
                        i22.post(new ChatScreenRunnable(chatScreen7, 0));
                    }
                    ArrayList arrayList3 = chatScreen7.outbox;
                    if ((!arrayList3.isEmpty()) && !chatScreen7.outboxFlushing && !arrayList3.isEmpty()) {
                        chatScreen7.outboxFlushing = true;
                        new Thread(new ChatScreenRunnable(chatScreen7, i2)).start();
                    }
                    if (!chatScreen7.messages.isEmpty()) {
                        final long T = chatScreen7.lastServerMessageId();
                        if (T > chatScreen7.lastSeenSyncAt) {
                            chatScreen7.lastSeenSyncAt = T;
                            new Thread(new Runnable() {
                                @Override
                                public final void run() {
                                    ApiClient.INSTANCE.markSeen(T);
                                }
                            }).start();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                loadEditorThumbnail();
                return;
            case 6:
                MediaPicker mediaPicker = (MediaPicker) this.third;
                HashSet hashSet3 = mediaPicker.loadingUris;
                String str8 = (String) this.fourth;
                hashSet3.remove(str8);
                Bitmap bitmap2 = (Bitmap) this.second;
                if (bitmap2 != null) {
                    mediaPicker.bitmapCache.put(str8, bitmap2);
                    MediaGridItemView mediaGridItemView = (MediaGridItemView) this.first;
                    if (i.b.a(mediaGridItemView.uriString, str8)) {
                        mediaGridItemView.imageView.setImageBitmap(bitmap2);
                        return;
                    }
                    return;
                }
                return;
            case 7:
                ImageView imageView = (ImageView) this.third;
                Object tag = imageView.getTag();
                String str9 = (String) this.fourth;
                if (!i.b.a(tag, str9) || (bitmap = (Bitmap) this.second) == null) {
                    return;
                }
                ChatMedia.aspectRatios.put(str9, Float.valueOf(bitmap.getWidth() / bitmap.getHeight()));
                imageView.setImageBitmap(bitmap);
                h.b bVar = (h.b) this.first;
                if (bVar != null) {
                    bVar.a(bitmap);
                    return;
                }
                return;
            default:
                List list2 = (List) this.third;
                TerminalSession terminalSession2 = (TerminalSession) this.second;
                File file9 = (File) this.first;
                String str10 = (String) this.fourth;
                String str11 = "Stopped.";
                TermuxPackageManager termuxPackageManager = TermuxPackageManager.INSTANCE;
                RefAction refAction = new RefAction(2, terminalSession2);
                ToastCallback toastCallback = new ToastCallback(3, terminalSession2);
                str4 = "Stopped.";
                try {
                    B2 = TermuxPackageManager.prefixDir();
                    if (!TermuxPackageManager.isPrefixRecorded()) {
                        TermuxPackageManager.deleteRecursively(B2);
                    }
                    new File(B2, "var/cache/nixpkg").mkdirs();
                    TermuxPackageManager.recordPrefix();
                    b.b s4 = TermuxPackageManager.fetchPackageIndex();
                    str5 = (String) s4.f764a;
                    H = TermuxPackageManager.resolveDependencies((Map) s4.f765b, (ArrayList) list2, TermuxPackageManager.readInstalled(B2));
                    str6 = "clang?";
                } catch (StoppedException unused3) {
                    terminalSession = terminalSession2;
                    file = file9;
                    str = "";
                    str4 = str;
                    terminalSession.installing = false;
                    file2 = file;
                    terminalSession.finishRun();
                    return;
                } catch (Exception e2) {
                    e = e2;
                    terminalSession = terminalSession2;
                    file = file9;
                    str = "";
                    str4 = "Failed: ".concat(e.getMessage() != null ? e.getMessage() : e.getClass().getSimpleName());
                    terminalSession.installing = false;
                    file2 = file;
                    terminalSession.finishRun();
                    return;
                } catch (OutOfMemoryError unused4) {
                    terminalSession = terminalSession2;
                    file = file9;
                    str = "";
                    str4 = "Failed: out of memory";
                    terminalSession.installing = false;
                    file2 = file;
                    terminalSession.finishRun();
                    return;
                }
                if (H.isEmpty()) {
                    TermuxPackageManager.createPrefixSkeleton(B2, new ArrayList());
                    TermuxPackageManager.recordPrefix();
                    if (list2.contains("clang?")) {
                        TermuxPackageManager.recordToolsVersion();
                    }
                    file = file9;
                    str4 = "";
                    str = str4;
                    str2 = str10;
                    str3 = "Stopped.";
                    terminalSession2.installing = false;
                    if (str4.length() == 0 && !terminalSession2.installCancelled) {
                        try {
                            B = TermuxPackageManager.prefixDir();
                            exists = new File(B, "bin/python3").exists();
                        } catch (Exception unused5) {
                            B = null;
                            exists = false;
                        }
                        if (!new File(B, "bin/pip").exists() && !new File(B, "bin/pip3").exists()) {
                            z2 = false;
                            listFiles = new File(B, "lib").listFiles(new FileFilters(1));
                            if (listFiles == null) {
                                i.a a2 = i.j.a(listFiles);
                                z3 = false;
                                while (a2.hasNext()) {
                                    if (new File((File) a2.next(), "site-packages/setuptools").isDirectory()) {
                                        z3 = true;
                                    }
                                }
                            } else {
                                z3 = false;
                            }
                            if (exists && z2 && !z3) {
                                terminalSession2.prompt = "Installing setuptools...";
                                TerminalManager.INSTANCE.syncServiceState();
                                file2 = file;
                                terminalSession2.runShellCommand(file2, "python3 -m pip install --no-warn-script-location --disable-pip-version-check setuptools");
                                if (str4.length() != 0 && str2 != null && !terminalSession2.installCancelled) {
                                    String str12 = str2;
                                    terminalSession2.prompt = terminalSession2.npmInstallPattern.b(str12) ? "Installing packages..." : str;
                                    TerminalManager.INSTANCE.syncServiceState();
                                    terminalSession2.runShellCommand(file2, str12);
                                } else if (str4.length() != 0) {
                                    terminalSession2.echo("Done.\n");
                                } else if (!str4.equals(str3)) {
                                    terminalSession2.echo(str4.concat("\n"));
                                }
                                terminalSession2.finishRun();
                                return;
                            }
                        }
                        z2 = true;
                        listFiles = new File(B, "lib").listFiles(new FileFilters(1));
                        if (listFiles == null) {
                            i.a a22 = i.j.a(listFiles);
                            z3 = false;
                            while (a22.hasNext()) {
                                if (new File((File) a22.next(), "site-packages/setuptools").isDirectory()) {
                                    z3 = true;
                                }
                            }
                        } else {
                            z3 = false;
                        }
                        if (exists && z2 && !z3) {
                            terminalSession2.prompt = "Installing setuptools...";
                            TerminalManager.INSTANCE.syncServiceState();
                            file2 = file;
                            terminalSession2.runShellCommand(file2, "python3 -m pip install --no-warn-script-location --disable-pip-version-check setuptools");
                            if (str4.length() != 0 && str2 != null && !terminalSession2.installCancelled) {
                                String str12 = str2;
                                terminalSession2.prompt = terminalSession2.npmInstallPattern.b(str12) ? "Installing packages..." : str;
                                TerminalManager.INSTANCE.syncServiceState();
                                terminalSession2.runShellCommand(file2, str12);
                            } else if (str4.length() != 0) {
                                terminalSession2.echo("Done.\n");
                            } else if (!str4.equals(str3)) {
                                terminalSession2.echo(str4.concat("\n"));
                            }
                            terminalSession2.finishRun();
                            return;
                        }
                    }
                    file2 = file;
                    if (str4.length() != 0 && str2 != null && !terminalSession2.installCancelled) {
                        String str12 = str2;
                        terminalSession2.prompt = terminalSession2.npmInstallPattern.b(str12) ? "Installing packages..." : str;
                        TerminalManager.INSTANCE.syncServiceState();
                        terminalSession2.runShellCommand(file2, str12);
                    } else if (str4.length() != 0) {
                        terminalSession2.echo("Done.\n");
                    } else if (!str4.equals(str3)) {
                        terminalSession2.echo(str4.concat("\n"));
                    }
                    terminalSession2.finishRun();
                    return;
                }
                i.f fVar = new i.f();
                Iterator it2 = H.iterator();
                while (true) {
                    long j3 = 1000000;
                    if (!it2.hasNext()) {
                        String str13 = str6;
                        String str14 = str5;
                        i.f fVar2 = new i.f();
                        i.e eVar = new i.e();
                        eVar.f847a = -1;
                        str = "";
                        try {
                            TermuxPackageManager.reportProgress(fVar2, fVar, eVar, toastCallback, 0.0d);
                            ArrayList arrayList4 = new ArrayList();
                            Iterator it3 = H.iterator();
                            while (it3.hasNext()) {
                                PackageEntry packageEntry = (PackageEntry) it3.next();
                                if (((Boolean) refAction.a()).booleanValue()) {
                                    throw new StoppedException();
                                }
                                terminalSession = terminalSession2;
                                file = file9;
                                try {
                                    j2 = packageEntry.size;
                                    it = it3;
                                    if (j2 <= 0) {
                                        j2 = 1000000;
                                    }
                                    arrayList = arrayList4;
                                    String str15 = packageEntry.name;
                                    StringBuilder sb = new StringBuilder();
                                    str3 = str11;
                                    try {
                                        sb.append("var/cache/nixpkg/");
                                        sb.append(str15);
                                        sb.append(".deb");
                                        file3 = new File(B2, sb.toString());
                                        try {
                                            list = list2;
                                            str2 = str10;
                                            try {
                                                TermuxPackageManager.downloadWithRetries(str14, packageEntry, file3, refAction, new DownloadProgressCallback(j2, fVar2, fVar, eVar, toastCallback));
                                                try {
                                                    TermuxPackageManager.reportProgress(fVar2, fVar, eVar, toastCallback, j2 * 0.6d);
                                                    TermuxPackageManager.extractDeb(file3, B2, arrayList, refAction);
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    z4 = true;
                                                    if (z4) {
                                                        throw th;
                                                    }
                                                    file3.delete();
                                                    throw th;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                z4 = false;
                                                if (z4) {
                                                    throw th;
                                                }
                                                file3.delete();
                                                throw th;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            z4 = false;
                                            if (z4) {
                                                throw th;
                                            }
                                            file3.delete();
                                            throw th;
                                        }
                                    } catch (StoppedException unused6) {
                                        str2 = str10;
                                        throw new StoppedException();
                                    } catch (Exception e3) {
                                        e = e3;
                                        str2 = str10;
                                        throw e;
                                    } catch (OutOfMemoryError unused7) {
                                        str2 = str10;
                                        throw new OutOfMemoryError();
                                    }
                                } catch (StoppedException unused8) {
                                    str2 = str10;
                                    str3 = str11;
                                    terminalSession2 = terminalSession;
                                    str4 = str3;
                                    terminalSession2.installing = false;
                                    file2 = file;
                                    terminalSession2.finishRun();
                                    return;
                                } catch (Exception e4) {
                                    e = e4;
                                    str2 = str10;
                                    str3 = str11;
                                    message = e.getMessage();
                                    if (message == null) {
                                        message = e.getClass().getSimpleName();
                                    }
                                    str4 = "Failed: ".concat(message);
                                    terminalSession2 = terminalSession;
                                    terminalSession2.installing = false;
                                    file2 = file;
                                    terminalSession2.finishRun();
                                    return;
                                } catch (OutOfMemoryError unused9) {
                                    str2 = str10;
                                    str3 = str11;
                                    str4 = "Failed: out of memory";
                                    terminalSession2 = terminalSession;
                                    terminalSession2.installing = false;
                                    file2 = file;
                                    terminalSession2.finishRun();
                                    return;
                                }
                                try {
                                    file3.delete();
                                    TermuxPackageManager.recordInstalled(B2, packageEntry);
                                    fVar2.f848a += j2;
                                    TermuxPackageManager.reportProgress(fVar2, fVar, eVar, toastCallback, 0.0d);
                                    arrayList4 = arrayList;
                                    terminalSession2 = terminalSession;
                                    file9 = file;
                                    it3 = it;
                                    str11 = str3;
                                    str10 = str2;
                                    list2 = list;
                                } catch (StoppedException unused10) {
                                    terminalSession2 = terminalSession;
                                    str4 = str3;
                                    terminalSession2.installing = false;
                                    file2 = file;
                                    terminalSession2.finishRun();
                                    return;
                                } catch (Exception e5) {
                                    e = e5;
                                    message = e.getMessage();
                                    if (message == null) {
                                        message = e.getClass().getSimpleName();
                                    }
                                    str4 = "Failed: ".concat(message);
                                    terminalSession2 = terminalSession;
                                    terminalSession2.installing = false;
                                    file2 = file;
                                    terminalSession2.finishRun();
                                    return;
                                } catch (OutOfMemoryError unused11) {
                                    str4 = "Failed: out of memory";
                                    terminalSession2 = terminalSession;
                                    terminalSession2.installing = false;
                                    file2 = file;
                                    terminalSession2.finishRun();
                                    return;
                                }
                            }
                            terminalSession = terminalSession2;
                            file = file9;
                            str2 = str10;
                            str3 = str11;
                            TermuxPackageManager.createPrefixSkeleton(B2, arrayList4);
                            TermuxPackageManager.recordPrefix();
                            if (list2.contains(str13)) {
                                TermuxPackageManager.recordToolsVersion();
                            }
                            toastCallback.a(100);
                            str4 = str;
                        } catch (StoppedException unused12) {
                            terminalSession = terminalSession2;
                            file = file9;
                            str4 = "Stopped.";
                        } catch (Exception e6) {
                            e = e6;
                            terminalSession = terminalSession2;
                            file = file9;
                            message = e.getMessage();
                            if (message == null) {
                                message = e.getClass().getSimpleName();
                            }
                            str4 = "Failed: ".concat(message);
                        } catch (OutOfMemoryError unused13) {
                            terminalSession = terminalSession2;
                            file = file9;
                            str4 = "Failed: out of memory";
                        }
                        terminalSession2 = terminalSession;
                        terminalSession2.installing = false;
                        file2 = file;
                        terminalSession2.finishRun();
                        return;
                    }
                    PackageEntry packageEntry2 = (PackageEntry) it2.next();
                    String str16 = str6;
                    String str17 = str5;
                    long j4 = fVar.f848a;
                    long j5 = packageEntry2.size;
                    if (j5 > 0) {
                        j3 = j5;
                    }
                    fVar.f848a = j4 + j3;
                    str6 = str16;
                    str5 = str17;
                }
        }
    }

    public QuadTaskRunnable(HideTextRunnable hideTextRunnable, ChatScreen chatScreen, TextView textView, String str) {
        this.mode = 2;
        this.fourth = str;
        this.second = chatScreen;
        this.third = textView;
        this.first = hideTextRunnable;
    }

    public QuadTaskRunnable(ChatScreen chatScreen, ApiResponse apiResponse, ApiResponse apiResponse2, ApiResponse apiResponse3) {
        this.mode = 4;
        this.second = chatScreen;
        this.third = apiResponse;
        this.fourth = apiResponse2;
        this.first = apiResponse3;
    }

    public QuadTaskRunnable(Object obj, Object obj2, Object obj3, Object obj4, int i2) {
        this.mode = i2;
        this.third = obj;
        this.second = obj2;
        this.fourth = obj3;
        this.first = obj4;
    }

    public QuadTaskRunnable(Object obj, String str, Object obj2, Object obj3, int i2) {
        this.mode = i2;
        this.third = obj;
        this.fourth = str;
        this.second = obj2;
        this.first = obj3;
    }

    public QuadTaskRunnable(ArrayList arrayList, TerminalSession terminalSession, File file, String str) {
        this.mode = 8;
        this.third = arrayList;
        this.second = terminalSession;
        this.first = file;
        this.fourth = str;
    }
}
