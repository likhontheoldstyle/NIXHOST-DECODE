package a;

import android.app.Dialog;
import android.net.Uri;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;

public final class MediaPickerContent implements h.c {

    public final int mode;

    public final ChatScreen chatScreen;

    public MediaPickerContent(ChatScreen chatScreen, int i2) {
        this.mode = i2;
        this.chatScreen = chatScreen;
    }

    @Override
    public final Object a(Object obj, Object obj2) {
        switch (this.mode) {
            case 0:
                List list = (List) obj;
                List list2 = (List) obj2;
                ChatScreen chatScreen = this.chatScreen;
                if (chatScreen.avatarPickPending) {
                    chatScreen.avatarPickPending = false;
                    Uri uri = (Uri) c.b.I(list);
                    if (uri != null) {
                        chatScreen.setAvatarFromUri(uri);
                    }
                } else {
                    if (!list.isEmpty()) {
                        chatScreen.sendMedia(list);
                    }
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        chatScreen.sendVideo((Uri) it.next());
                    }
                }
                break;
            default:
                LinearLayout linearLayout = (LinearLayout) obj;
                final Dialog dialog = (Dialog) obj2;
                final ChatScreen chatScreen2 = this.chatScreen;
                TextView f1 = chatScreen2.makeText("Change profile photo", 21.0f, chatScreen2.textColor, true);
                f1.setGravity(17);
                linearLayout.addView(f1, chatScreen2.layoutParams(-1, -2, 0, 4, 0, 10));
                final int i2 = 0;
                chatScreen2.menuRow(linearLayout, "trashf", "Remove", chatScreen2.textColor, new h.a() {
                    @Override
                    public final Object a() {
                        switch (i2) {
                            case 0:
                                dialog.dismiss();
                                ChatScreen chatScreen3 = chatScreen2;
                                CharSequence charSequence = (CharSequence) chatScreen3.memberPics.get(chatScreen3.username);
                                h.b bVar = chatScreen3.toaster;
                                if (charSequence == null || charSequence.length() == 0) {
                                    bVar.a("You have no profile photo");
                                } else if (chatScreen3.isOffline()) {
                                    bVar.a("No internet connection");
                                } else {
                                    new Thread(new ChatScreenRunnable(chatScreen3, 4)).start();
                                }
                                break;
                            default:
                                dialog.dismiss();
                                ChatScreen chatScreen4 = chatScreen2;
                                chatScreen4.avatarPickPending = true;
                                chatScreen4.requestMediaPermission();
                                break;
                        }
                        return b.d.f770c;
                    }
                });
                final int i3 = 1;
                chatScreen2.menuRow(linearLayout, "image", "Choose photo", chatScreen2.textColor, new h.a() {
                    @Override
                    public final Object a() {
                        switch (i3) {
                            case 0:
                                dialog.dismiss();
                                ChatScreen chatScreen3 = chatScreen2;
                                CharSequence charSequence = (CharSequence) chatScreen3.memberPics.get(chatScreen3.username);
                                h.b bVar = chatScreen3.toaster;
                                if (charSequence == null || charSequence.length() == 0) {
                                    bVar.a("You have no profile photo");
                                } else if (chatScreen3.isOffline()) {
                                    bVar.a("No internet connection");
                                } else {
                                    new Thread(new ChatScreenRunnable(chatScreen3, 4)).start();
                                }
                                break;
                            default:
                                dialog.dismiss();
                                ChatScreen chatScreen4 = chatScreen2;
                                chatScreen4.avatarPickPending = true;
                                chatScreen4.requestMediaPermission();
                                break;
                        }
                        return b.d.f770c;
                    }
                });
                break;
        }
        return b.d.f770c;
    }
}
