package a;

import java.io.Serializable;
import org.json.JSONObject;

public final class ApiResponse {

    public final int code;

    public final Serializable body;

    public String errorMessage() {
        String optString;
        JSONObject c2 = json();
        if (c2 != null && (optString = c2.optString("error", "")) != null) {
            if (optString.length() == 0) {
                optString = null;
            }
            if (optString != null) {
                return optString;
            }
        }
        return "Failed";
    }

    public boolean isSuccess() {
        int i2 = this.code;
        return 200 <= i2 && i2 < 300;
    }

    public JSONObject json() {
        try {
            return new JSONObject((String) this.body);
        } catch (Exception unused) {
            return null;
        }
    }

    public ApiResponse(int i2, String str) {
        this.code = i2;
        this.body = str;
    }
}
