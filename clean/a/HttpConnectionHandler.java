package a;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.AudioAttributes;
import android.media.ExifInterface;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.nix.host.MainActivity;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public final class HttpConnectionHandler implements Runnable {

    public final int mode;

    public final Object owner;

    public final Object target;

    public HttpConnectionHandler(ChatScreen chatUi, Uri uri) {
        this.mode = 1;
        this.owner = chatUi;
        this.target = uri;
    }

    private final void handleStaticFileRequest() {
        List parts = null;
        OutputStream outputStream = null;
        Socket socket = (Socket) this.owner;
        HttpServer server = (HttpServer) this.target;
        server.getClass();
        try {
            socket.setSoTimeout(20000);
            BufferedInputStream input = new BufferedInputStream(socket.getInputStream());
            StringBuilder requestLine = new StringBuilder();
            while (true) {
                int read = input.read();
                if (read < 0 || read == 10) {
                    break;
                } else if (read != 13) {
                    requestLine.append((char) read);
                }
            }
            int count = 0;
            int prev = 0;
            int read2;
            while (count < 16384 && (read2 = input.read()) >= 0) {
                count++;
                if (read2 == 10 && prev == 10) {
                    break;
                } else if (read2 != 13) {
                    prev = read2;
                }
            }
            parts = m.e.b0(requestLine.toString(), new String[]{" "});
            outputStream = socket.getOutputStream();
        } catch (Exception unused) {
        } catch (Throwable th) {
            try {
                socket.close();
            } catch (Exception unused2) {
            }
            throw th;
        }
        try {
            if (parts.size() >= 2 && (i.b.a(parts.get(0), "GET") || i.b.a(parts.get(0), "HEAD"))) {
                String decoded = URLDecoder.decode(m.e.e0((String) parts.get(1), '?'), "UTF-8");
                File root = server.rootDir.getCanonicalFile();
                File requested = new File(root, decoded).getCanonicalFile();
                if (!i.b.a(requested.getPath(), root.getPath())) {
                    if (!m.m.K(requested.getPath(), root.getPath() + "/")) {
                        byte[] bytes = "Forbidden".getBytes(m.a.f864a);
                        i.b.d(bytes, "getBytes(...)");
                        HttpServer.sendResponse(outputStream, 403, "text/plain", bytes);
                        socket.close();
                        return;
                    }
                }
                if (requested.isDirectory()) {
                    requested = new File(requested, "index.html");
                }
                if (requested.isFile()) {
                    LinkedHashMap mimeTypes = server.mimeTypes;
                    String fileName = requested.getName();
                    i.b.d(fileName, "getName(...)");
                    String extension = m.e.d0(fileName, '.', "").toLowerCase(Locale.ROOT);
                    i.b.d(extension, "toLowerCase(...)");
                    String mime = (String) mimeTypes.get(extension);
                    if (mime == null) {
                        mime = "application/octet-stream";
                    }
                    HttpServer.sendResponse(outputStream, 200, mime, i.b.a(parts.get(0), "HEAD") ? new byte[0] : g.m.G(requested));
                } else {
                    byte[] bytes2 = "Not found".getBytes(m.a.f864a);
                    i.b.d(bytes2, "getBytes(...)");
                    HttpServer.sendResponse(outputStream, 404, "text/plain", bytes2);
                }
                socket.close();
                return;
            }
            byte[] bytes3 = "Method not allowed".getBytes(m.a.f864a);
            i.b.d(bytes3, "getBytes(...)");
            HttpServer.sendResponse(outputStream, 405, "text/plain", bytes3);
            socket.close();
            return;
        } catch (Exception unused3) {
            return;
        }
    }

    @Override
    public final void run() {
        switch (this.mode) {
            case 0: {
                ApiClient apiClient = ApiClient.INSTANCE;
                ChatTheme theme = (ChatTheme) this.target;
                ApiResponse result = ApiClient.requestWithDefaults(apiClient, "POST", "/chat/theme", new JSONObject().put("id", theme.id).put("q", theme.emoji), 8);
                ChatScreen chatUi = (ChatScreen) this.owner;
                chatUi.activity.runOnUiThread(new ChatResultRunnable(result, chatUi, 2));
                return;
            }
            case 1: {
                ChatScreen chatUi = (ChatScreen) this.owner;
                Uri uri = (Uri) this.target;
                Activity activity = chatUi.activity;
                byte[] imageBytes = null;
                try {
                    BitmapFactory.Options bounds = new BitmapFactory.Options();
                    bounds.inJustDecodeBounds = true;
                    InputStream boundsStream = activity.getContentResolver().openInputStream(uri);
                    if (boundsStream != null) {
                        try {
                            BitmapFactory.decodeStream(boundsStream, null, bounds);
                            AppState.a(boundsStream, null);
                        } finally {
                        }
                    }
                    int sample = 1;
                    while (true) {
                        int next = sample * 2;
                        if (bounds.outWidth / next >= 720 && bounds.outHeight / next >= 720) {
                            sample = next;
                        } else {
                            break;
                        }
                    }
                    BitmapFactory.Options decodeOptions = new BitmapFactory.Options();
                    decodeOptions.inSampleSize = sample;
                    InputStream decodeStream = activity.getContentResolver().openInputStream(uri);
                    if (decodeStream != null) {
                        try {
                            Bitmap bitmap = BitmapFactory.decodeStream(decodeStream, null, decodeOptions);
                            AppState.a(decodeStream, null);
                            if (bitmap != null) {
                                int rotation = 0;
                                InputStream exifStream = null;
                                try {
                                    exifStream = activity.getContentResolver().openInputStream(uri);
                                } catch (Exception unused2) {
                                }
                                if (exifStream != null) {
                                    try {
                                        int orientation = new ExifInterface(exifStream).getAttributeInt("Orientation", 1);
                                        rotation = orientation != 3 ? orientation != 6 ? orientation != 8 ? 0 : 270 : 90 : 180;
                                    } catch (Exception unused3) {
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                    try {
                                        AppState.a(exifStream, null);
                                    } catch (Exception unused4) {
                                    }
                                }
                                int side = Math.min(bitmap.getWidth(), bitmap.getHeight());
                                Matrix matrix = new Matrix();
                                if (side > 360) {
                                    float scale = 360.0f / side;
                                    matrix.postScale(scale, scale);
                                }
                                if (rotation != 0) {
                                    matrix.postRotate(rotation);
                                }
                                Bitmap cropped = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - side) / 2, (bitmap.getHeight() - side) / 2, side, side, matrix, true);
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                cropped.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
                                imageBytes = byteArrayOutputStream.toByteArray();
                            }
                        } finally {
                        }
                    }
                } catch (Throwable unused) {
                }
                if (imageBytes == null) {
                    chatUi.activity.runOnUiThread(new ChatScreenRunnable(chatUi, 9));
                    return;
                }
                ApiResponse response;
                if (ApiClient.baseUrl.length() == 0) {
                    response = new ApiResponse(0, "");
                } else {
                    try {
                        URLConnection openConnection = new URL(ApiClient.baseUrl + "/chat/avatar").openConnection();
                        i.b.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setConnectTimeout(15000);
                        httpURLConnection.setReadTimeout(30000);
                        httpURLConnection.setRequestProperty("User-Agent", "NixHost");
                        SharedPreferences sharedPreferences = AppState.prefs;
                        if (sharedPreferences == null) {
                            i.b.g("sp");
                            throw null;
                        }
                        String session = sharedPreferences.getString("session", "");
                        if (session == null) {
                            session = "";
                        }
                        httpURLConnection.setRequestProperty("Authorization", "Bearer " + session);
                        httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                        httpURLConnection.setFixedLengthStreamingMode(imageBytes.length);
                        httpURLConnection.setDoOutput(true);
                        OutputStream uploadStream = httpURLConnection.getOutputStream();
                        try {
                            uploadStream.write(imageBytes);
                            AppState.a(uploadStream, null);
                            int responseCode = httpURLConnection.getResponseCode();
                            InputStream responseStream = (200 > responseCode || responseCode >= 300) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
                            response = new ApiResponse(responseCode, responseStream != null ? AppState.v(new BufferedReader(new InputStreamReader(responseStream, m.a.f864a), 8192)) : "");
                        } finally {
                        }
                    } catch (Exception unused4) {
                        response = new ApiResponse(0, "");
                    }
                }
                chatUi.activity.runOnUiThread(new ChatResultRunnable(response, chatUi, 3));
                return;
            }
            case 2: {
                ApiResponse result = ApiClient.requestWithDefaults(ApiClient.INSTANCE, "DELETE", "/chat/msg/" + ((ChatMessage) this.target).id, null, 12);
                if (result.isSuccess()) {
                    return;
                }
                ChatScreen chatUi = (ChatScreen) this.owner;
                chatUi.activity.runOnUiThread(new ChatResultRunnable(chatUi, result, 5));
                return;
            }
            case 3: {
                File file = (File) this.target;
                Context context = (Context) this.owner;
                ChatNotifier chatNotifier = ChatNotifier.INSTANCE;
                try {
                    ChatNotifier.stopSound();
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(5).setContentType(4).build());
                    if (!file.isFile() || file.length() <= 0) {
                        mediaPlayer.setDataSource(context, RingtoneManager.getDefaultUri(2));
                    } else {
                        mediaPlayer.setDataSource(file.getPath());
                    }
                    mediaPlayer.setOnCompletionListener(new SoundCompletionListener());
                    mediaPlayer.setOnErrorListener(new SoundErrorListener());
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    ChatNotifier.soundPlayer = mediaPlayer;
                    ChatNotifier.mainHandler.postDelayed(new TaskRunnable(2, mediaPlayer), 10000L);
                    return;
                } catch (Throwable unused5) {
                    ChatNotifier.stopSound();
                    return;
                }
            }
            case 4: {
                MediaPicker gallery = (MediaPicker) this.target;
                gallery.allMedia.clear();
                gallery.allMedia.addAll((List) this.owner);
                gallery.a();
                return;
            }
            case 5: {
                ApiResponse result = (ApiResponse) this.target;
                MainActivity mainActivity = (MainActivity) this.owner;
                int i9 = MainActivity.R;
                if (!result.isSuccess()) {
                    mainActivity.toast(result.errorMessage());
                    return;
                }
                JSONObject json = result.json();
                JSONArray instances = json != null ? json.optJSONArray("instances") : null;
                File filesDir = mainActivity.getFilesDir();
                JSONObject me = AppState.meJson;
                if (me != null) {
                    if (instances == null) {
                        instances = new JSONArray();
                    }
                    me.put("instances", instances);
                    try {
                        g.m.L(new File(filesDir, "c_me.json"), me.toString());
                    } catch (Exception unused6) {
                    }
                }
                mainActivity.showHome();
                return;
            }
            case 6: {
                int i10 = MainActivity.R;
                s2 view = (s2) this.target;
                float height = view.getHeight();
                view.setTranslationY(height);
                view.setVisibility(0);
                ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
                animator.setDuration(320L);
                animator.setInterpolator(new DecelerateInterpolator(2.0f));
                animator.addUpdateListener(new SheetSlideAnimatorListener(view, height, (View) this.owner));
                animator.start();
                return;
            }
            case 7: {
                A2 a2 = (A2) this.target;
                a2.setBmp((Bitmap) this.owner);
                a2.invalidate();
                return;
            }
            case 8: {
                HttpServer server = (HttpServer) this.target;
                ServerSocket serverSocket = (ServerSocket) this.owner;
                while (server.running) {
                    try {
                        server.executor.execute(new HttpConnectionHandler(server, serverSocket.accept(), 9));
                    } catch (Exception unused7) {
                        if (!server.running) {
                            return;
                        }
                    }
                }
                return;
            }
            case 9:
                handleStaticFileRequest();
                return;
            default: {
                File dir = (File) this.owner;
                TermuxPackageManager y2Var = TermuxPackageManager.INSTANCE;
                TerminalSession session = (TerminalSession) this.target;
                File envHome = session.envHomeDir;
                StringBuilder sb = new StringBuilder();
                String npmHead = "";
                try {
                    File prefix = TermuxPackageManager.prefixDir();
                    sb.append("dataDir: ");
                    sb.append(TermuxPackageManager.appContext().getApplicationInfo().dataDir);
                    sb.append('\n');
                    sb.append("prefix: ");
                    sb.append(TermuxPackageManager.prefixPath());
                    sb.append('\n');
                    sb.append("ready: ");
                    sb.append(TermuxPackageManager.isPrefixRecorded());
                    sb.append('\n');
                    for (String tool : c.c.C("node", "npm", "sh")) {
                        File toolFile = new File(prefix, "bin/" + tool);
                        String link;
                        try {
                            link = Files.readSymbolicLink(toolFile.toPath()).toString();
                        } catch (Exception unused8) {
                            link = "-";
                        }
                        sb.append(tool);
                        sb.append(": exists=");
                        sb.append(toolFile.exists());
                        sb.append(" exec=");
                        sb.append(toolFile.canExecute());
                        sb.append(" link=");
                        sb.append(link);
                        sb.append('\n');
                    }
                    File npmFile = new File(prefix, "bin/npm");
                    if (npmFile.isFile()) {
                        sb.append("npm head: ");
                        try {
                            String readLine = new BufferedReader(new InputStreamReader(new FileInputStream(npmFile), m.a.f864a), 8192).readLine();
                            if (readLine != null) {
                                npmHead = readLine;
                            }
                        } catch (Exception unused9) {
                        }
                        sb.append(npmHead);
                        sb.append('\n');
                    }
                    ProcessBuilder processBuilder = new ProcessBuilder("/system/bin/sh", "-c", "'" + TermuxPackageManager.prefixPath() + "/bin/node' -v 2>&1; echo \"npm path: $(command -v npm 2>&1)\"; echo \"NIX_NM=$NIX_NM\"; npm -v 2>&1");
                    processBuilder.directory(dir);
                    TermuxPackageManager.buildEnvironment(processBuilder.environment(), envHome, dir);
                    processBuilder.redirectErrorStream(true);
                    java.lang.Process process = processBuilder.start();
                    sb.append(AppState.v(new BufferedReader(new InputStreamReader(process.getInputStream(), m.a.f864a), 8192)));
                    process.waitFor();
                } catch (Exception e2) {
                    sb.append("diag error: ");
                    sb.append(e2.getMessage());
                    sb.append('\n');
                }
                session.echo(sb.toString());
                session.finishRun();
                return;
            }
        }
    }

    public HttpConnectionHandler(Object target, Object owner, int mode) {
        this.mode = mode;
        this.target = target;
        this.owner = owner;
    }
}
