package a;

import java.io.File;
import java.util.Comparator;

public final class SortComparator implements Comparator {

    public final int mode;

    public SortComparator(int i2) {
        this.mode = i2;
    }

    @Override
    public final int compare(Object obj, Object obj2) {
        switch (this.mode) {
            case 0:
            case 1:
                ChatMessage chatMessage = (ChatMessage) obj;
                ChatMessage chatMessage2 = (ChatMessage) obj2;
                int d = AppState.d(Long.valueOf(chatMessage.timestamp), Long.valueOf(chatMessage2.timestamp));
                return d != 0 ? d : AppState.d(Long.valueOf(chatMessage.id), Long.valueOf(chatMessage2.id));
            case 2:
                return AppState.d(Long.valueOf(((MediaItem) obj2).dateAdded), Long.valueOf(((MediaItem) obj).dateAdded));
            default:
                return AppState.d(((File) obj).getName(), ((File) obj2).getName());
        }
    }
}
