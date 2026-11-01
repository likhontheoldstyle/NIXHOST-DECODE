package a;

import android.content.Intent;
import android.net.Uri;
import com.nix.host.MainActivity;

public final class LinkAction implements h.a {

    public final int mode;

    public final MainActivity activity;

    public final String value;

    public LinkAction(int i2, MainActivity mainActivity, String str) {
        this.mode = i2;
        this.activity = mainActivity;
        this.value = str;
    }

    @Override
    public final Object a() {
        MainActivity mainActivity = this.activity;
        String str = this.value;
        switch (this.mode) {
            case 0:
                int i2 = MainActivity.R;
                mainActivity.openWhatsApp(str);
                break;
            case 1:
                int i3 = MainActivity.R;
                mainActivity.getClass();
                try {
                    mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception unused) {
                    mainActivity.toast("Cannot open the link");
                }
                break;
            case 2:
                int i4 = MainActivity.R;
                mainActivity.openWhatsApp(str);
                break;
            default:
                int i5 = MainActivity.R;
                new Thread(new ApiTask(3, mainActivity, str)).start();
                break;
        }
        return b.d.f770c;
    }

    public LinkAction(MainActivity mainActivity, String str) {
        this.mode = 3;
        this.value = str;
        this.activity = mainActivity;
    }
}
