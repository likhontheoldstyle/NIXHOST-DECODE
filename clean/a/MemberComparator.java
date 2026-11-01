package a;

import java.util.Comparator;

public final class MemberComparator implements Comparator {

    public final ChatScreen chatScreen;

    public MemberComparator(ChatScreen chatScreen) {
        this.chatScreen = chatScreen;
    }

    @Override
    public final int compare(Object obj, Object obj2) {
        ChatScreen chatScreen = this.chatScreen;
        return AppState.d(Integer.valueOf(!m.m.F((String) obj, chatScreen.groupId) ? 1 : 0), Integer.valueOf(!m.m.F((String) obj2, chatScreen.groupId) ? 1 : 0));
    }
}
