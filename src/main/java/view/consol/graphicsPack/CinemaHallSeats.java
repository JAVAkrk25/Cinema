package view.consol.graphicsPack;

import view.consol.logicPack.HallSeats;

public class CinemaHallSeats {
    private final int sizeRow = HallSeats.getSizeRow() * 2 + 3;
    private final int sizeColumn = HallSeats.getSizeColumn() * 2 + 3;

    private final String[][] cinemaHall = new String[sizeRow][sizeColumn];

    private String setAllSeatsEmpty(int row, int column) {
        String field = HallSeats.getHallSeats(row, column);
        if (field == null) field = " ";
        return field;
    }

    private String[][] seatingArrangement() {
        for (int i = 0; i < sizeRow; i++) {
            for (int j = 0; j < sizeColumn; j++) {
                if ((i + 1) % 2 == 0 && (j + 1) % 2 == 0) {
                    if (i == 1 && j == 1) {
                        cinemaHall[i][j] = " * ";
                    } else if (i == 1) {
                        cinemaHall[i][j] = " " + (1 + (j - 3) / 2) + " ";
                    } else if (j == 1) {
                        cinemaHall[i][j] = " " + Character.toString(65 + (i - 3) / 2) + " ";
                    } else {
                        cinemaHall[i][j] = " " + setAllSeatsEmpty((i - 3) / 2, (j - 3) / 2) + " ";
                    }
                } else {
                    if (i % 2 == 0 && j % 2 == 0) {
                        cinemaHall[i][j] = " + ";
                    } else if (i % 2 == 0) {
                        cinemaHall[i][j] = " - ";
                    } else {
                        cinemaHall[i][j] = " | ";
                    }
                }
            }
        }
        return cinemaHall;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sizeRow; i++) {
            for (int j = 0; j < sizeColumn; j++) {
                result.append(seatingArrangement()[i][j]);
            }
            if (i < sizeRow - 1)
                result.append("\n");
        }
        return result.toString();
    }
}
