package a;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class ChatThemeCatalog {

    public static final List themes;

    static {
        int i2 = (int) 4076863487L;
        int i3 = (int) 4280032284L;
        int i4 = (int) 2164260863L;
        ChatTheme chatTheme = new ChatTheme("soccer", "Soccer", "⚽", false, (int) 4284264009L, (int) 4285383766L, (int) 4279187986L, (int) 4281297715L, (int) 4280187432L, (int) 4281245244L, (int) 4280187434L, i2, i3, 1728053247, 1719982190, i4, true);
        int i5 = (int) 4294942784L;
        ChatTheme chatTheme2 = new ChatTheme("pizza", "Pizza", "🍕", false, i5, (int) 4294939440L, (int) 4282062080L, (int) 4286200336L, (int) 4292363029L, (int) 4293412138L, (int) 4290918943L, i2, i3, 1728036992, 1728023072, i4, true);
        int i6 = (int) 4283338542L;
        int i7 = (int) 2583691263L;
        ChatTheme chatTheme3 = new ChatTheme("avocado", "Avocado", "🥑", false, (int) 4293521588L, (int) 4293062056L, (int) 4280961554L, (int) 4284250682L, i6, (int) 4285378117L, i6, i2, i3, (int) 2163406536L, (int) 2162355624L, i7, true);
        ChatTheme chatTheme4 = new ChatTheme("lollipop", "Lollipop", "🍭", false, (int) 4289257435L, (int) 4288731348L, (int) 4278926136L, (int) 4282018663L, (int) 4292890783L, (int) 4294281929L, (int) 4292893354L, i2, i3, 1728053247, 1728053247, i7, true);
        int i8 = (int) 4294967295L;
        int i9 = (int) 4279672965L;
        int i10 = (int) 3019898879L;
        int i11 = (int) 4293980400L;
        int i12 = (int) 4278519045L;
        int i13 = (int) 4278740735L;
        int i14 = (int) 4293980917L;
        themes = c.c.C(chatTheme, chatTheme2, chatTheme3, chatTheme4, new ChatTheme("music", "Music", "🎵", false, (int) 4294244095L, (int) 4294572543L, (int) 4280951376L, (int) 4285162640L, (int) 4286344437L, (int) 4288384245L, (int) 4286015462L, i8, i3, i7, i7, (int) 4293783546L, true), new ChatTheme("sky", "Sky", "☁️", false, (int) 4286566655L, (int) 4291687679L, (int) 4278924630L, (int) 4282215311L, (int) 4280191205L, (int) 4282032383L, (int) 4280187104L, i2, i3, 1728053247, 1724773631, i7, true), new ChatTheme("celebration", "Celebration", "🥳", false, (int) 4294942832L, (int) 4291321035L, (int) 4281997860L, (int) 4285218636L, (int) 4287505608L, (int) 4292891218L, (int) 4289739366L, i2, i3, (int) 3439041138L, (int) 3436606178L, 1442840575, true), new ChatTheme("care", "Care", "🥰", false, (int) 4292081648L, (int) 4291098338L, (int) 4279122739L, (int) 4282150500L, i9, (int) 4281058470L, i9, i2, i3, 1728053247, 1723266010, i7, true), new ChatTheme("astrology", "Astrology", "✨", false, (int) 4294964637L, (int) 4294957480L, (int) 4283050496L, (int) 4287257120L, (int) 4293423898L, i5, (int) 4293949984L, i2, i3, (int) 2583683210L, (int) 2298464393L, i4, true), new ChatTheme("cottagecore", "Cottagecore", "🌸", false, (int) 4292278015L, (int) 4290308256L, (int) 4280237343L, (int) 4283198284L, (int) 4281240378L, (int) 4284268380L, (int) 4281306943L, i2, i3, (int) 2582182655L, (int) 2579032224L, i7, true), new ChatTheme("ocean", "Ocean", "🐢", false, (int) 4288673776L, (int) 4278249717L, (int) 4278532928L, (int) 4278937200L, (int) 4278223759L, (int) 4278239190L, (int) 4278228903L, i2, i3, (int) 2410216181L, (int) 2281756133L, i4, true), new ChatTheme("tiedye", "Tie-Dye", "🌀", false, (int) 4293588479L, (int) 4292931839L, (int) 4279641679L, (int) 4283063946L, (int) 4282016736L, (int) 4284188671L, (int) 4281555160L, i2, i3, (int) 2582837503L, (int) 2582312191L, i10, true), new ChatTheme("mono", "Monochrome", "🖤", false, i11, i11, (int) 4279308561L, (int) 4284900966L, (int) 4280427042L, (int) 4283058762L, (int) 4280163870L, i8, i3, 1728053247, 1728053247, (int) 4293059298L, true), new ChatTheme("default", "Default", "", true, (int) 4288348415L, (int) 4278221823L, i12, (int) 4284835691L, (int) 4279793650L, i13, i13, i14, i12, 0, 0, i14, true), new ChatTheme("spectrum", "Spectrum", "🔥", false, (int) 4279916031L, (int) 4294912811L, i8, i10, i8, (int) 4286259199L, (int) 4290910315L, 956301311, i8, 1073741824, 1073741824, 872415231, false), new ChatTheme("cotton", "Cotton Candy", "🍬", false, (int) 4294938545L, (int) 4278248959L, (int) 4281014847L, (int) 4284238452L, (int) 4286336511L, (int) 4290014453L, (int) 4286213109L, i2, i3, 1728053247, 1728053247, i7, true), new ChatTheme("berry", "Berry", "💜", false, (int) 4294266080L, (int) 4281998476L, i8, i10, i8, (int) 4294922184L, (int) 4289729704L, 1090519039, i8, 1073741824, 1493172224, 872415231, false));
    }

    public static ChatTheme byId(String str) {
        Object obj;
        List<ChatTheme> list = themes;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (i.b.a(((ChatTheme) obj).id, str)) {
                break;
            }
        }
        ChatTheme result = (ChatTheme) obj;
        if (result == null) {
            for (ChatTheme chatTheme : list) {
                if (i.b.a(chatTheme.id, "default")) {
                    return chatTheme;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        return result;
    }
}
