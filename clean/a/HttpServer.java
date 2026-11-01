package a;

import java.io.File;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class HttpServer {

    public final File rootDir;

    public ServerSocket serverSocket;

    public final ExecutorService executor = Executors.newCachedThreadPool();

    public volatile boolean running;

    public final LinkedHashMap mimeTypes;

    public HttpServer(File file, int i2) {
        this.rootDir = file;
        b.b[] bVarArr = {new b.b("html", "text/html; charset=utf-8"), new b.b("htm", "text/html; charset=utf-8"), new b.b("css", "text/css"), new b.b("js", "application/javascript"), new b.b("json", "application/json"), new b.b("png", "image/png"), new b.b("jpg", "image/jpeg"), new b.b("jpeg", "image/jpeg"), new b.b("gif", "image/gif"), new b.b("svg", "image/svg+xml"), new b.b("webp", "image/webp"), new b.b("ico", "image/x-icon"), new b.b("txt", "text/plain; charset=utf-8"), new b.b("mp4", "video/mp4"), new b.b("mp3", "audio/mpeg"), new b.b("woff2", "font/woff2"), new b.b("woff", "font/woff"), new b.b("wasm", "application/wasm")};
        LinkedHashMap linkedHashMap = new LinkedHashMap(AppState.r(18));
        for (int i3 = 0; i3 < 18; i3++) {
            b.b bVar = bVarArr[i3];
            linkedHashMap.put(bVar.f764a, bVar.f765b);
        }
        this.mimeTypes = linkedHashMap;
    }

    public static void sendResponse(OutputStream outputStream, int i2, String str, byte[] bArr) {
        byte[] bytes = ("HTTP/1.1 " + i2 + " OK\r\nContent-Type: " + str + "\r\nContent-Length: " + bArr.length + "\r\nConnection: close\r\n\r\n").getBytes(m.a.f864a);
        i.b.d(bytes, "getBytes(...)");
        outputStream.write(bytes);
        outputStream.write(bArr);
        outputStream.flush();
    }
}
