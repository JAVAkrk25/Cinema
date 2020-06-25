package view.consol.logicPack;


import java.util.LinkedHashMap;
import java.util.Map;

public class HallSeats {

    private static final Map<String, Integer> sizeBoard = new LinkedHashMap<>();
    private static final String[][] hallSeats = new String[getSizeRow()][getSizeColumn()];

    private HallSeats(int sizeRow, int sizeColumn) {
        sizeBoard.put("sizeRow", sizeRow);
        sizeBoard.put("sizeColumn", sizeColumn);
    }

    public static int getSizeRow() {
        Integer defaultValue = 3;
        return HallSeats.sizeBoard.getOrDefault("sizeRow", defaultValue);
    }

    public static int getSizeColumn() {
        Integer defaultValue = 3;
        return HallSeats.sizeBoard.getOrDefault("sizeColumn", defaultValue);
    }

    public static String getHallSeats(int row, int column) {
        return hallSeats[row][column];
    }

}
