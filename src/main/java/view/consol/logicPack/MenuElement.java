package view.consol.logicPack;

import java.util.Arrays;

public class MenuElement {
    private String element = "";

    public String getElement(String description, String firstElement, String conjunction, String secondElement) {
        menu(description, firstElement, conjunction, secondElement);
        return element;
    }


    private void menu(String description, String firstElement, String conjunction, String secondElement) {

        char[] line = new char[83];
        int busyFields = 0;
        StringBuilder result = new StringBuilder();

        description = "          - " + description;
        conjunction = " " + conjunction + " ";

        Arrays.fill(line, ' ');

        for (int i = 0; i < description.length(); i++) {
            line[busyFields] = description.toCharArray()[i];
            busyFields += 1;
        }

        for (char c : firstElement.trim().toCharArray()) {
            line[busyFields] = c;
            busyFields += 1;
        }

        for (int i = 0; i < conjunction.length(); i++) {
            line[busyFields] = conjunction.toCharArray()[i];
            busyFields += 1;
        }

        for (char c : secondElement.trim().toCharArray()) {
            line[busyFields] = c;
            busyFields += 1;
        }

        for (char c : line) {
            element += c;
        }
    }
}
