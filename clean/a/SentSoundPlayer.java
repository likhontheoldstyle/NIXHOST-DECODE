package a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class SentSoundPlayer {

    public static final Handler mainHandler = new Handler(Looper.getMainLooper());

    public static final ExecutorService executor = Executors.newSingleThreadExecutor();

    public static short[] sentSoundSamples;
}
