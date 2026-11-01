package a;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public abstract class SyntaxHighlighter {

    public static final Set jsKeywords = AppState.y("async", "await", "break", "case", "catch", "class", "const", "continue", "debugger", "default", "delete", "do", "else", "enum", "export", "extends", "finally", "for", "function", "if", "implements", "import", "in", "instanceof", "interface", "let", "new", "package", "private", "protected", "public", "return", "static", "super", "switch", "throw", "try", "typeof", "var", "void", "while", "with", "yield", "abstract", "final", "throws", "namespace");

    public static final Set pyKeywords = AppState.y("and", "as", "assert", "async", "await", "break", "class", "continue", "def", "del", "elif", "else", "except", "finally", "for", "from", "global", "if", "import", "in", "is", "lambda", "nonlocal", "not", "or", "pass", "raise", "return", "try", "while", "with", "yield");

    public static final Set literals = AppState.y("true", "false", "null", "undefined", "NaN", "Infinity", "None", "True", "False");

    public static ArrayList highlight(List list, String str) {
        String d0 = m.e.d0(str, '.', "");
        Locale locale = Locale.ROOT;
        String lowerCase = d0.toLowerCase(locale);
        i.b.d(lowerCase, "toLowerCase(...)");
        String lowerCase2 = str.toLowerCase(locale);
        i.b.d(lowerCase2, "toLowerCase(...)");
        int lang = AppState.y("js", "mjs", "cjs", "jsx", "ts", "tsx", "java", "kt", "kts", "c", "h", "cpp", "cc", "hpp", "cs", "go", "rs", "php", "swift", "dart", "scala", "gradle").contains(lowerCase) ? 0 : AppState.y("css", "scss", "less").contains(lowerCase) ? 1 : lowerCase.equals("py") ? 2 : lowerCase.equals("json") ? 4 : AppState.y("html", "htm", "xml", "svg", "vue").contains(lowerCase) ? 5 : (AppState.y("sh", "bash", "zsh", "yml", "yaml", "toml", "rb", "env", "ini", "conf", "properties", "gitignore").contains(lowerCase) || lowerCase2.equals("dockerfile")) ? 3 : 6;
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        boolean inBlockComment = false;
        boolean inTemplateString = false;
        boolean inHtmlComment = false;
        boolean inTag = false;
        while (it.hasNext()) {
            String line = (String) it.next();
            if (lang == 6 || line.length() > 2000) {
                arrayList.add(line);
                continue;
            }
            SpannableStringBuilder spannable = new SpannableStringBuilder(line);
            int length = line.length();
            if (lang == 5) {
                int pos = 0;
                while (pos < length) {
                    if (inHtmlComment) {
                        int close = m.e.Q(line, "-->", pos, false, 4);
                        if (close < 0) {
                            paintSpan(spannable, pos, length, -6971995);
                            pos = length;
                        } else {
                            int end = close + 3;
                            paintSpan(spannable, pos, end, -6971995);
                            pos = end;
                            inHtmlComment = false;
                        }
                    } else if (!inTag) {
                        int open = m.e.P(line, '<', pos, false, 4);
                        if (open < 0) {
                            pos = length;
                        } else if (line.startsWith("<!--", open)) {
                            int close = m.e.Q(line, "-->", open + 4, false, 4);
                            if (close < 0) {
                                paintSpan(spannable, open, length, -6971995);
                                inHtmlComment = true;
                                pos = length;
                            } else {
                                int end = close + 3;
                                paintSpan(spannable, open, end, -6971995);
                                pos = end;
                            }
                        } else {
                            int nameStart = open + 1;
                            if (nameStart < length && (line.charAt(nameStart) == '/' || line.charAt(nameStart) == '!' || line.charAt(nameStart) == '?')) {
                                nameStart = open + 2;
                            }
                            int nameEnd = nameStart;
                            while (nameEnd < length && (Character.isLetterOrDigit(line.charAt(nameEnd)) || line.charAt(nameEnd) == '-' || line.charAt(nameEnd) == ':' || line.charAt(nameEnd) == '_')) {
                                nameEnd++;
                            }
                            if (nameEnd > nameStart) {
                                paintSpan(spannable, nameStart, nameEnd, -8001379);
                                inTag = true;
                                pos = nameEnd;
                            } else {
                                pos = open + 1;
                            }
                        }
                    } else {
                        char charAt = line.charAt(pos);
                        if (charAt == '>') {
                            inTag = false;
                            pos++;
                        } else if (charAt == '"' || charAt == '\'') {
                            int end = pos + 1;
                            while (end < length && line.charAt(end) != charAt) {
                                end++;
                            }
                            int stop = end >= length ? length : end + 1;
                            paintSpan(spannable, pos, stop, -8800001);
                            pos = stop;
                        } else if (Character.isLetter(charAt) || charAt == '_' || charAt == '@' || charAt == ':') {
                            int end = pos + 1;
                            while (end < length && (Character.isLetterOrDigit(line.charAt(end)) || line.charAt(end) == '-' || line.charAt(end) == '_' || line.charAt(end) == ':' || line.charAt(end) == '.')) {
                                end++;
                            }
                            paintSpan(spannable, pos, end, -5008656);
                            pos = end;
                        } else {
                            pos++;
                        }
                    }
                }
                arrayList.add(spannable);
                continue;
            }
            int pos = 0;
            while (pos < length) {
                if (inBlockComment) {
                    int close = m.e.Q(line, "*/", pos, false, 4);
                    if (close < 0) {
                        paintSpan(spannable, pos, length, -6971995);
                        pos = length;
                    } else {
                        int end = close + 2;
                        paintSpan(spannable, pos, end, -6971995);
                        pos = end;
                        inBlockComment = false;
                    }
                } else if (inTemplateString) {
                    int end = pos;
                    while (end < length && line.charAt(end) != '`') {
                        if (line.charAt(end) == '\\') {
                            end++;
                        }
                        end++;
                    }
                    if (end >= length) {
                        paintSpan(spannable, pos, length, -8800001);
                        pos = length;
                    } else {
                        int stop = end + 1;
                        paintSpan(spannable, pos, stop, -8800001);
                        pos = stop;
                        inTemplateString = false;
                    }
                } else {
                    char charAt = line.charAt(pos);
                    if (lang == 0 && charAt == '/' && pos + 1 < length && line.charAt(pos + 1) == '/') {
                        paintSpan(spannable, pos, length, -6971995);
                        pos = length;
                    } else if ((lang == 0 || lang == 1) && charAt == '/' && pos + 1 < length && line.charAt(pos + 1) == '*') {
                        int close = m.e.Q(line, "*/", pos + 2, false, 4);
                        if (close < 0) {
                            paintSpan(spannable, pos, length, -6971995);
                            inBlockComment = true;
                            pos = length;
                        } else {
                            int end = close + 2;
                            paintSpan(spannable, pos, end, -6971995);
                            pos = end;
                        }
                    } else if ((lang == 2 || lang == 3) && charAt == '#') {
                        paintSpan(spannable, pos, length, -6971995);
                        pos = length;
                    } else if (charAt == '"' || charAt == '\'' || (charAt == '`' && lang == 0)) {
                        int end = pos + 1;
                        while (end < length && line.charAt(end) != charAt) {
                            if (line.charAt(end) == '\\') {
                                end++;
                            }
                            end++;
                        }
                        if (end >= length) {
                            paintSpan(spannable, pos, length, -8800001);
                            if (charAt == '`') {
                                inTemplateString = true;
                            }
                            pos = length;
                        } else {
                            int stop = end + 1;
                            if (lang == 4) {
                                int look = stop;
                                while (look < length && line.charAt(look) == ' ') {
                                    look++;
                                }
                                if (look < length && line.charAt(look) == ':') {
                                    paintSpan(spannable, pos, stop, -8001379);
                                } else {
                                    paintSpan(spannable, pos, stop, -8800001);
                                }
                            } else {
                                paintSpan(spannable, pos, stop, -8800001);
                            }
                            pos = stop;
                        }
                    } else if (Character.isDigit(charAt)) {
                        boolean boundary = true;
                        if (pos != 0) {
                            char prev = line.charAt(pos - 1);
                            if (Character.isLetterOrDigit(prev) || prev == '_' || prev == '$') {
                                boundary = false;
                            }
                        }
                        if (boundary) {
                            int end = pos + 1;
                            while (end < length && (Character.isLetterOrDigit(line.charAt(end)) || line.charAt(end) == '.' || line.charAt(end) == '_')) {
                                end++;
                            }
                            if (lang != 4) {
                                paintSpan(spannable, pos, end, -8800001);
                            }
                            pos = end;
                        } else {
                            pos++;
                        }
                    } else if (Character.isLetter(charAt) || charAt == '_' || charAt == '$') {
                        int end = pos + 1;
                        while (end < length && (Character.isLetterOrDigit(line.charAt(end)) || line.charAt(end) == '_' || line.charAt(end) == '$')) {
                            end++;
                        }
                        if (lang == 0 || lang == 2) {
                            String word = line.substring(pos, end);
                            i.b.d(word, "substring(...)");
                            int before = pos - 1;
                            while (before >= 0 && line.charAt(before) == ' ') {
                                before--;
                            }
                            int after = end;
                            while (after < length && line.charAt(after) == ' ') {
                                after++;
                            }
                            char charBefore = before >= 0 ? line.charAt(before) : ' ';
                            char charAfter = after < length ? line.charAt(after) : ' ';
                            Set set = lang == 2 ? pyKeywords : jsKeywords;
                            if (charBefore != '.' && set.contains(word)) {
                                paintSpan(spannable, pos, end, -1422758);
                            } else if (charBefore != '.' && literals.contains(word)) {
                                paintSpan(spannable, pos, end, -8800001);
                            } else if (charBefore == '.') {
                                int next = after + 1;
                                char charNext = next < length ? line.charAt(next) : ' ';
                                if (charAfter == '(' || (charAfter == '=' && charNext != '=' && charNext != '>')) {
                                    paintSpan(spannable, pos, end, -5008656);
                                } else {
                                    paintSpan(spannable, pos, end, -8800001);
                                }
                            } else if (charAfter == '(') {
                                paintSpan(spannable, pos, end, -5008656);
                            }
                        }
                        pos = end;
                    } else {
                        pos++;
                    }
                }
            }
            arrayList.add(spannable);
        }
        return arrayList;
    }

    public static void paintSpan(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4) {
        if (i3 > i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i4), i2, i3, 33);
        }
    }
}
