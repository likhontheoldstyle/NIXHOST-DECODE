package a;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import java.util.ArrayList;

public final class PairClickListener implements View.OnClickListener {

    public final int mode;

    public final Object first;

    public final Object second;

    public PairClickListener(Object obj, Object obj2, int i2) {
        this.mode = i2;
        this.first = obj;
        this.second = obj2;
    }

    @Override
    public final void onClick(View view) {
        String str;
        switch (this.mode) {
            case 0:
                ChatScreen chatScreen = (ChatScreen) this.first;
                boolean isMuted = chatScreen.isMuted();
                String str2 = chatScreen.username;
                if (isMuted) {
                    String stringPlus = StringPlus.stringPlus("muted_", str2);
                    SharedPreferences sharedPreferences = AppState.prefs;
                    if (sharedPreferences == null) {
                        i.b.g("sp");
                        throw null;
                    }
                    sharedPreferences.edit().remove(stringPlus).apply();
                } else {
                    String stringPlus2 = StringPlus.stringPlus("muted_", str2);
                    SharedPreferences sharedPreferences2 = AppState.prefs;
                    if (sharedPreferences2 == null) {
                        i.b.g("sp");
                        throw null;
                    }
                    sharedPreferences2.edit().putString(stringPlus2, "1").apply();
                }
                ChatScreen.buildGroupInfo(chatScreen, (LinearLayout) this.second);
                return;
            case 1:
                ((h.b) this.first).a((String) this.second);
                return;
            case 2:
                ((Dialog) this.first).dismiss();
                ((h.b) this.second).a("");
                return;
            case 3:
                VideoView videoView = (VideoView) this.first;
                boolean isPlaying = videoView.isPlaying();
                FrameLayout frameLayout = (FrameLayout) this.second;
                if (isPlaying) {
                    videoView.pause();
                    frameLayout.setVisibility(0);
                    return;
                } else {
                    videoView.start();
                    frameLayout.setVisibility(8);
                    return;
                }
            default:
                MediaItem mediaItem = ((MediaGridItemView) this.first).item;
                if (mediaItem != null) {
                    MediaPicker mediaPicker = (MediaPicker) this.second;
                    ArrayList arrayList = mediaPicker.selectedItems;
                    if (arrayList.contains(mediaItem)) {
                        arrayList.remove(mediaItem);
                    } else {
                        if (arrayList.size() >= 10) {
                            Toast.makeText(mediaPicker.activity, "You can select up to 10", 0).show();
                            return;
                        }
                        arrayList.add(mediaItem);
                    }
                    mediaPicker.gridAdapter.notifyDataSetChanged();
                    int size = arrayList.size();
                    FrameLayout frameLayout2 = mediaPicker.cameraFab;
                    if (frameLayout2 == null) {
                        i.b.g("camFab");
                        throw null;
                    }
                    frameLayout2.setVisibility(size == 0 ? 0 : 8);
                    LinearLayout linearLayout = mediaPicker.actionBar;
                    if (linearLayout == null) {
                        i.b.g("bar");
                        throw null;
                    }
                    linearLayout.setVisibility(size == 0 ? 8 : 0);
                    TextView textView = mediaPicker.previewButton;
                    if (textView == null) {
                        i.b.g("prevBtn");
                        throw null;
                    }
                    textView.setVisibility(size != 1 ? 8 : 0);
                    TextView textView2 = mediaPicker.sendButton;
                    if (textView2 == null) {
                        i.b.g("sendBtn");
                        throw null;
                    }
                    if (size >= 2) {
                        str = "Send " + size;
                    } else {
                        str = "Send";
                    }
                    textView2.setText(str);
                    return;
                }
                return;
        }
    }
}
