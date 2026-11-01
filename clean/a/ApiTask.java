package a;

import com.nix.host.MainActivity;
import org.json.JSONObject;

public final class ApiTask implements Runnable {

    public final int mode;

    public final String value;

    public final MainActivity activity;

    public ApiTask(int i2, MainActivity mainActivity, String str) {
        this.mode = i2;
        this.value = str;
        this.activity = mainActivity;
    }

    @Override
    public final void run() {
        ApiClient apiClient = ApiClient.INSTANCE;
        MainActivity mainActivity = this.activity;
        String str = this.value;
        switch (this.mode) {
            case 0:
                int i2 = MainActivity.R;
                mainActivity.runOnUiThread(new HttpConnectionHandler(ApiClient.requestWithDefaults(apiClient, "POST", "/instances", new JSONObject().put("name", str), 8), mainActivity, 5));
                break;
            case 1:
                int i3 = MainActivity.R;
                if (!i.b.a(str, "badsession")) {
                    mainActivity.onAccountStateChanged();
                    if (i.b.a(str, "ok")) {
                        mainActivity.maybeShowExpiryWarning();
                        break;
                    }
                } else {
                    mainActivity.logout();
                    break;
                }
                break;
            case 2:
                int i4 = MainActivity.R;
                if (!i.b.a(str, "badsession")) {
                    mainActivity.onAccountStateChanged();
                    if (i.b.a(str, "ok")) {
                        mainActivity.maybeShowExpiryWarning();
                        break;
                    }
                } else {
                    mainActivity.logout();
                    break;
                }
                break;
            case 3:
                int i5 = MainActivity.R;
                StringBuilder sb = new StringBuilder("/instances/");
                String str2 = this.value;
                sb.append(str2);
                ApiResponse b2 = ApiClient.requestWithDefaults(apiClient, "DELETE", sb.toString(), null, 12);
                MainActivity mainActivity2 = this.activity;
                mainActivity2.runOnUiThread(new BackgroundTask((Object) b2, (Object) mainActivity2, (Object) str2, 5, false));
                break;
            default:
                if (!i.b.a(str, "badsession")) {
                    int i6 = MainActivity.R;
                    mainActivity.onAccountStateChanged();
                    if (i.b.a(str, "ok")) {
                        mainActivity.maybeShowExpiryWarning();
                        break;
                    }
                } else {
                    int i7 = MainActivity.R;
                    mainActivity.logout();
                    break;
                }
                break;
        }
    }
}
