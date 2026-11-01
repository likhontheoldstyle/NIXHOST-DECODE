package a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ChatSendRunnable implements Runnable {

    public final int mode;

    public final ChatScreen chatScreen;

    public final long localId;

    public final ChatMessage message;

    public final Object first;

    public final Object second;

    public ChatSendRunnable(ApiResponse apiResponse, ChatScreen chatScreen, long j2, JSONObject jSONObject, ChatMessage chatMessage) {
        this.mode = 0;
        this.first = apiResponse;
        this.chatScreen = chatScreen;
        this.localId = j2;
        this.second = jSONObject;
        this.message = chatMessage;
    }

    @Override
    public final void run() {
        Object obj4 = this.first;
        Object obj5 = this.second;
        switch (this.mode) {
            case 0:
                ApiResponse apiResponse = (ApiResponse) obj4;
                int i7 = apiResponse.code;
                ChatScreen chatScreen = this.chatScreen;
                if (i7 == 401) {
                    chatScreen.onSessionExpired.a();
                    return;
                }
                boolean b2 = apiResponse.isSuccess();
                long j3 = this.localId;
                if (!b2) {
                    if (apiResponse.code == 0) {
                        chatScreen.queueRetry(j3, (JSONObject) obj5, this.message);
                        chatScreen.setConnectionState(1);
                        return;
                    } else {
                        chatScreen.markFailed(j3);
                        chatScreen.toaster.a(ChatScreen.errorText(apiResponse));
                        return;
                    }
                }
                chatScreen.pendingLocalIds.remove(Long.valueOf(j3));
                c.h.G(chatScreen.messages, new IdPredicate(j3, 0));
                JSONObject c2 = apiResponse.json();
                JSONObject optJSONObject = c2 != null ? c2.optJSONObject("msg") : null;
                if (optJSONObject != null) {
                    chatScreen.addMessages(new JSONArray().put(optJSONObject));
                }
                chatScreen.refreshMessages();
                chatScreen.applyScroll(true);
                return;
            case 1:
                List list = (List) obj5;
                ArrayList arrayList2 = new ArrayList();
                i.g gVar = new i.g();
                gVar.f850b = "";
                Iterator it = ((List) obj4).iterator();
                int i8 = 0;
                while (true) {
                    boolean hasNext = it.hasNext();
                    ChatScreen chatScreen2 = this.chatScreen;
                    if (!hasNext) {
                        chatScreen2.activity.runOnUiThread(new ChatSendRunnable(arrayList2, chatScreen2, this.localId, this.message, gVar));
                        return;
                    }
                    int i9 = i8 + 1;
                    Uri uri6 = (Uri) it.next();
                    Activity activity = chatScreen2.activity;
                    BitmapFactory.Options options = null;
                    int i2 = 1;
                    try {
                        options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        InputStream openInputStream2 = activity.getContentResolver().openInputStream(uri6);
                        if (openInputStream2 != null) {
                            try {
                                BitmapFactory.decodeStream(openInputStream2, null, options);
                                AppState.a(openInputStream2, null);
                            } catch (Throwable th2) {
                                try {
                                    throw th2;
                                } catch (Throwable th3) {
                                    AppState.a(openInputStream2, th2);
                                    throw th3;
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                    byte[] bArr = null;
                    if (options != null) {
                        while (true) {
                            int i10 = i2 * 2;
                            if (options.outWidth / i10 >= 1280 || options.outHeight / i10 >= 1280) {
                                i2 = i10;
                            } else {
                                BitmapFactory.Options options2 = new BitmapFactory.Options();
                                options2.inSampleSize = i2;
                                InputStream openInputStream3 = activity.getContentResolver().openInputStream(uri6);
                                if (openInputStream3 != null) {
                                    try {
                                        Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream3, null, options2);
                                        AppState.a(openInputStream3, null);
                                        if (decodeStream != null) {
                                            int i3 = 0;
                                            try {
                                                InputStream openInputStream = activity.getContentResolver().openInputStream(uri6);
                                                if (openInputStream != null) {
                                                    try {
                                                        int attributeInt = new ExifInterface(openInputStream).getAttributeInt("Orientation", 1);
                                                        i3 = attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : 270 : 90 : 180;
                                                        AppState.a(openInputStream, null);
                                                    } catch (Throwable th4) {
                                                        try {
                                                            throw th4;
                                                        } catch (Throwable th5) {
                                                            AppState.a(openInputStream, th4);
                                                            throw th5;
                                                        }
                                                    }
                                                }
                                            } catch (Exception unused9) {
                                            }
                                            int max = Math.max(decodeStream.getWidth(), decodeStream.getHeight());
                                            Matrix matrix = new Matrix();
                                            if (max > 1280) {
                                                float f2 = 1280.0f / max;
                                                matrix.postScale(f2, f2);
                                            }
                                            if (i3 != 0) {
                                                matrix.postRotate(i3);
                                            }
                                            if (!matrix.isIdentity()) {
                                                decodeStream = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), matrix, true);
                                            }
                                            Bitmap bitmap = decodeStream;
                                            int quality = 78;
                                            while (true) {
                                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                bitmap.compress(Bitmap.CompressFormat.JPEG, quality, byteArrayOutputStream);
                                                bArr = byteArrayOutputStream.toByteArray();
                                                if (bArr.length <= 1300000 || quality <= 35) {
                                                    break;
                                                }
                                                quality -= 15;
                                            }
                                        }
                                    } catch (Throwable th6) {
                                        try {
                                            throw th6;
                                        } catch (Throwable th7) {
                                            AppState.a(openInputStream3, th6);
                                            throw th7;
                                        }
                                    }
                                }
                                break;
                            }
                        }
                    }
                    if (bArr == null) {
                        gVar.f850b = "Could not read the photo";
                    } else {
                        try {
                            File file7 = ChatMedia.cacheDir;
                            g.m.K(ChatMedia.mediaFile((String) list.get(i8)), bArr);
                        } catch (Exception unused7) {
                        }
                        chatScreen2.activity.runOnUiThread(new ChatScreenRunnable(chatScreen2, 6));
                        b.b j1 = ChatScreen.uploadMedia("image", bArr);
                        Object obj6 = j1.f764a;
                        if (((CharSequence) obj6).length() > 0) {
                            try {
                                File file8 = ChatMedia.cacheDir;
                                g.m.K(ChatMedia.mediaFile((String) obj6), bArr);
                            } catch (Exception unused8) {
                            }
                            arrayList2.add(obj6);
                        } else {
                            gVar.f850b = j1.f765b;
                        }
                    }
                    i8 = i9;
                }
            case 2:
                final ChatScreen chatScreen3 = this.chatScreen;
                Uri uri7 = (Uri) obj4;
                String str = (String) obj5;
                final long j4 = this.localId;
                i.g gVar2 = new i.g();
                gVar2.f850b = "";
                i.e eVar2 = new i.e();
                i.g gVar3 = new i.g();
                gVar3.f850b = "";
                ArrayList arrayList3 = new ArrayList();
                byte[] bArr4 = new byte[0];
                File file9 = new File(ChatMedia.cacheDir(), "v_up_" + System.currentTimeMillis());
                long l1 = 0;
                try {
                    l1 = chatScreen3.uriSize(uri7);
                } catch (Throwable unused10) {
                    gVar2.f850b = "Could not send the video";
                }
                if (l1 > 0) {
                    if (l1 > 104857600) {
                        gVar2.f850b = "Video too large (max 100 MB)";
                    }
                    Activity activity2 = chatScreen3.activity;
                    if (((CharSequence) gVar2.f850b).length() == 0) {
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(activity2, uri7);
                            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                            Integer C = extractMetadata != null ? m.l.C(extractMetadata) : null;
                            int i5 = C != null ? C.intValue() : 0;
                            eVar2.f847a = i5;
                            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(i5 > 2500 ? 1000000 : 0, 2);
                            if (frameAtTime == null) {
                                frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                            }
                            byte[] bArr3 = null;
                            if (frameAtTime != null) {
                                int max2 = Math.max(frameAtTime.getWidth(), frameAtTime.getHeight());
                                if (max2 > 720) {
                                    float f3 = 720.0f / max2;
                                    frameAtTime = Bitmap.createScaledBitmap(frameAtTime, Math.max(1, (int) (frameAtTime.getWidth() * f3)), Math.max(1, (int) (frameAtTime.getHeight() * f3)), true);
                                }
                                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                                frameAtTime.compress(Bitmap.CompressFormat.JPEG, 78, byteArrayOutputStream3);
                                bArr3 = byteArrayOutputStream3.toByteArray();
                            }
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Throwable unused17) {
                            }
                            if (bArr3 == null) {
                                try {
                                    Bitmap createBitmap = Bitmap.createBitmap(320, 180, Bitmap.Config.ARGB_8888);
                                    createBitmap.eraseColor(-14671580);
                                    ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                                    createBitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream4);
                                    bArr3 = byteArrayOutputStream4.toByteArray();
                                } catch (Throwable unused20) {
                                }
                            }
                            if (bArr3 != null) {
                                bArr4 = bArr3;
                                try {
                                    g.m.K(ChatMedia.mediaFile(str), bArr4);
                                } catch (Exception unused21) {
                                }
                                final int i11 = eVar2.f847a;
                                Runnable runnable = new Runnable() {
                                    @Override
                                    public final void run() {
                                        Object obj7;
                                        ChatScreen chatScreen4 = chatScreen3;
                                        Iterator it2 = chatScreen4.messages.iterator();
                                        while (true) {
                                            if (!it2.hasNext()) {
                                                obj7 = null;
                                                break;
                                            } else {
                                                obj7 = it2.next();
                                                if (((ChatMessage) obj7).id == j4) {
                                                    break;
                                                }
                                            }
                                        }
                                        ChatMessage chatMessage = (ChatMessage) obj7;
                                        if (chatMessage != null) {
                                            chatMessage.duration = i11;
                                        }
                                        ChatAndMediaAdapter o0 = chatScreen4.messageAdapter;
                                        if (o0 != null) {
                                            o0.notifyDataSetChanged();
                                        } else {
                                            i.b.g("adapter");
                                            throw null;
                                        }
                                    }
                                };
                                activity2.runOnUiThread(runnable);
                                b.b j12 = ChatScreen.uploadMedia("image", bArr4);
                                Object obj3 = j12.f764a;
                                gVar3.f850b = obj3;
                                if (((CharSequence) obj3).length() == 0) {
                                    gVar2.f850b = j12.f765b;
                                }
                            }
                        } catch (Throwable unused18) {
                            gVar2.f850b = "Could not send the video";
                        }
                    }
                    i.d dVar = new i.d();
                    boolean z = false;
                    if (((CharSequence) gVar2.f850b).length() == 0) {
                        byte[] bArr5 = new byte[12582912];
                        InputStream openInputStream4 = activity2.getContentResolver().openInputStream(uri7);
                        if (openInputStream4 == null) {
                            gVar2.f850b = "Could not read the video";
                        } else {
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(file9);
                                try {
                                    while (((CharSequence) gVar2.f850b).length() == 0) {
                                        int i12 = 0;
                                        while (i12 < 12582912) {
                                            int read = openInputStream4.read(bArr5, i12, 12582912 - i12);
                                            if (read < 0) {
                                                break;
                                            }
                                            i12 += read;
                                        }
                                        if (i12 <= 0) {
                                            break;
                                        }
                                        byte[] copyOf = i12 == 12582912 ? bArr5 : Arrays.copyOf(bArr5, i12);
                                        if (i12 != 12582912) {
                                            i.b.d(copyOf, "copyOf(...)");
                                        }
                                        b.b j13 = ChatScreen.uploadMedia("video", copyOf);
                                        Object obj7 = j13.f764a;
                                        if (((CharSequence) obj7).length() == 0) {
                                            gVar2.f850b = j13.f765b;
                                        } else {
                                            arrayList3.add(obj7);
                                            fileOutputStream.write(bArr5, 0, i12);
                                        }
                                    }
                                    AppState.a(fileOutputStream, null);
                                } catch (Throwable th8) {
                                    try {
                                        throw th8;
                                    } catch (Throwable th9) {
                                        AppState.a(fileOutputStream, th8);
                                        throw th9;
                                    }
                                }
                                AppState.a(openInputStream4, null);
                            } catch (Throwable th16) {
                                try {
                                    throw th16;
                                } catch (Throwable th14) {
                                    AppState.a(openInputStream4, th16);
                                    throw th14;
                                }
                            }
                        }
                        if (((CharSequence) gVar2.f850b).length() == 0 && arrayList3.isEmpty()) {
                            gVar2.f850b = "Could not read the video";
                        }
                        z = ((CharSequence) gVar2.f850b).length() == 0;
                        dVar.f846a = z;
                        if (z) {
                            try {
                                File file10 = ChatMedia.cacheDir;
                                if (!file9.renameTo(ChatMedia.videoFile((String) arrayList3.get(0)))) {
                                    dVar.f846a = false;
                                }
                                g.m.K(ChatMedia.mediaFile((String) gVar3.f850b), bArr4);
                            } catch (Exception unused22) {
                            }
                        }
                        if (!dVar.f846a) {
                            try {
                                file9.delete();
                            } catch (Exception unused23) {
                            }
                            if (((CharSequence) gVar2.f850b).length() == 0) {
                                gVar2.f850b = "Could not send the video";
                            }
                        }
                    }
                    chatScreen3.activity.runOnUiThread(new MembersOrVideoResultRunnable(dVar, chatScreen3, j4, gVar3, arrayList3, eVar2, this.message, gVar2));
                    return;
                }
                gVar2.f850b = "Could not read the video";
                chatScreen3.activity.runOnUiThread(new MembersOrVideoResultRunnable(new i.d(), chatScreen3, j4, gVar3, arrayList3, eVar2, this.message, gVar2));
                return;
            case 3:
                ArrayList arrayList4 = (ArrayList) obj4;
                boolean z2 = !arrayList4.isEmpty();
                ChatScreen chatScreen5 = this.chatScreen;
                long j5 = this.localId;
                if (z2) {
                    chatScreen5.sendMediaMessage(j5, "image", arrayList4, 0, this.message, c.j.f773a);
                } else {
                    chatScreen5.markFailed(j5);
                }
                i.g gVar4 = (i.g) obj5;
                if (((CharSequence) gVar4.f850b).length() > 0) {
                    chatScreen5.toaster.a(gVar4.f850b);
                    return;
                }
                return;
            default:
                JSONObject jSONObject = (JSONObject) obj5;
                ApiResponse d2 = ApiClient.INSTANCE.sendChatMessage(jSONObject);
                ChatScreen chatScreen6 = this.chatScreen;
                chatScreen6.activity.runOnUiThread(new ActionRunnable(d2, chatScreen6, this.localId, jSONObject, this.message, (h.a) obj4, 0));
                return;
        }
    }

    public ChatSendRunnable(ChatScreen chatScreen, Uri uri, String str, long j2, ChatMessage chatMessage) {
        this.mode = 2;
        this.chatScreen = chatScreen;
        this.first = uri;
        this.second = str;
        this.localId = j2;
        this.message = chatMessage;
    }

    public ChatSendRunnable(ArrayList arrayList, ChatScreen chatScreen, long j2, ChatMessage chatMessage, i.g gVar) {
        this.mode = 3;
        this.first = arrayList;
        this.chatScreen = chatScreen;
        this.localId = j2;
        this.message = chatMessage;
        this.second = gVar;
    }

    public ChatSendRunnable(List list, ChatScreen chatScreen, ArrayList arrayList, long j2, ChatMessage chatMessage) {
        this.mode = 1;
        this.first = list;
        this.chatScreen = chatScreen;
        this.second = arrayList;
        this.localId = j2;
        this.message = chatMessage;
    }

    public ChatSendRunnable(JSONObject jSONObject, ChatScreen chatScreen, long j2, ChatMessage chatMessage, h.a aVar) {
        this.mode = 4;
        this.second = jSONObject;
        this.chatScreen = chatScreen;
        this.localId = j2;
        this.message = chatMessage;
        this.first = aVar;
    }
}
