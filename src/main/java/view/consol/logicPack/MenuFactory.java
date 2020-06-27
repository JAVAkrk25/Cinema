package view.consol.logicPack;

import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;

@NoArgsConstructor
public abstract class MenuFactory implements InterfaceMenuEntry {

    public static void getInfoLine(String element1, String element2, String element3, String element4) {
        System.out.println(infoLine(element1, element2, element3, element4));
    }

    public static void getPointLine(String element1, String element2, String element3, String element4) {
        System.out.println(pointLine(element1, element2, element3, element4));
    }

    public static void getFullLine() {
        System.out.println(SYMBOL.repeat(LINE_LENGTH));
    }

    public static void getEmptyLine() {
        System.out.println(SYMBOL + " ".repeat(LINE_LENGTH - 2) + SYMBOL);
    }

    public static void getCentreLine(String centre) {
        System.out.println(centreLIne(centre));
    }

    public static void getTitleLine(String title) {
        System.out.println(titleLine(title));
    }

    public static void getTextMultiLine(String text) {
        System.out.println(textMultiLine(text));
    }



    private static String centreLIne(@NonNull String centre) {

        StringBuilder element = new StringBuilder(SYMBOL);

        int half = (LINE_LENGTH - centre.length()) / 2;

        for (int i = 1; i < LINE_LENGTH - 1; i++) {
            if (i < half) {
                element.append(" ");
            } else if (i == half) {
                element.append(centre);
            } else if (i >= (half + centre.length())) {
                element.append(" ");
            }
        }
        element.append(SYMBOL);

        return element.toString();
    }

    private static String pointLine(String element1, String element2, String element3, String element4) {

        StringBuilder element = new StringBuilder(SYMBOL + "      ");
        element.append(element1 == null ? "" : element1 + " ");
        element.append(element2 == null ? "" : element2 + " ");
        element.append(element3 == null ? "" : element3 + " ");
        element.append(element4 == null ? "" : element4 + " ");
        element.append(" ".repeat(LINE_LENGTH - 1 - element.length()));
        element.append(SYMBOL);

        return element.toString();
    }

    private static String infoLine(String element1, String element2, String element3, String element4) {

        StringBuilder element = new StringBuilder(SYMBOL + "          - ");
        element.append(element1 == null ? "" : element1 + " ");
        element.append(element2 == null ? "" : element2 + " ");
        element.append(element3 == null ? "" : element3 + " ");
        element.append(element4 == null ? "" : element4 + " ");
        element.append(" ".repeat(LINE_LENGTH - 1 - element.length()));
        element.append(SYMBOL);

        return element.toString();
    }

    private static String titleLine(String title) {

        StringBuilder element = new StringBuilder(SYMBOL + "   " + title);
        element.append(" ".repeat(LINE_LENGTH - 1 - element.length()));
        element.append(SYMBOL);

        return element.toString();
    }

    private static String textMultiLine(String text) {

        StringBuilder line = new StringBuilder();
        StringBuilder element = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList<>();

        String[] words = text.split(" ");

        int wordId = 0;
        do {
            line.setLength(0);

            line.append(SYMBOL + "            ");

            for (int j = wordId; j < words.length; j++) {
                if ((line.length() + words[j].length()) <= (LINE_LENGTH - 2)) {
                    line.append(words[j]).append(" ");
                } else {
                    wordId = j;
                    break;
                }
                wordId = j;
            }

            line.append(" ".repeat(LINE_LENGTH - 1 - line.length()));
            line.append(SYMBOL);
            arrayList.add(line.toString());

        } while (wordId != words.length - 1);

        for (int i = 0; i < arrayList.size() - 1; i++) {
            element.append(arrayList.get(i)).append("\n");
        }
        element.append(arrayList.get(arrayList.size() - 1));

        return element.toString();
    }
}
