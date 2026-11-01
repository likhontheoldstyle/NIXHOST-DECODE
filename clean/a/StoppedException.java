package a;

import java.io.IOException;

public final class StoppedException extends IOException {
    public StoppedException() {
        super("stopped");
    }
}
