package a;

public final class ChatTheme {

    public final String id;

    public final String displayName;

    public final String emoji;

    public final boolean isDefault;

    public final int statusBarColor;

    public final int navigationBarColor;

    public final int titleTextColor;

    public final int subTextColor;

    public final int iconColor;

    public final int ownBubbleGradientStart;

    public final int ownBubbleGradientEnd;

    public final int otherBubbleColor;

    public final int otherBubbleTextColor;

    public final int headerBarColor;

    public final int barBackgroundColor;

    public final int inputPillColor;

    public final boolean lightBars;

    public ChatTheme(String str, String str2, String str3, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, boolean z2) {
        this.id = str;
        this.displayName = str2;
        this.emoji = str3;
        this.isDefault = z;
        this.statusBarColor = i2;
        this.navigationBarColor = i3;
        this.titleTextColor = i4;
        this.subTextColor = i5;
        this.iconColor = i6;
        this.ownBubbleGradientStart = i7;
        this.ownBubbleGradientEnd = i8;
        this.otherBubbleColor = i9;
        this.otherBubbleTextColor = i10;
        this.headerBarColor = i11;
        this.barBackgroundColor = i12;
        this.inputPillColor = i13;
        this.lightBars = z2;
    }
}
