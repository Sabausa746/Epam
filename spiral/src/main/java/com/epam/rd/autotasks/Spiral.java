package com.epam.rd.autotasks;

class Spiral {
    public static int[][] spiral(int rows, int columns) {
        int[][] theSpiral = new int[rows][columns];
        int value = 1;
        int topRow = 0;
        int bottomRow = rows - 1;
        int leftColumn = 0;
        int rightColumn = columns - 1;

        while (topRow <= bottomRow && leftColumn <= rightColumn) {
            for (int col = leftColumn; col <= rightColumn; col++) {
                theSpiral[topRow][col] = value++;
            }
            topRow++;

            for (int row = topRow; row <= bottomRow; row++) {
                theSpiral[row][rightColumn] = value++;
            }
            rightColumn--;

            if (topRow <= bottomRow) {
                for (int col = rightColumn; col >= leftColumn; col--) {
                    theSpiral[bottomRow][col] = value++;
                }
                bottomRow--;
            }

            if (leftColumn <= rightColumn) {
                for (int row = bottomRow; row >= topRow; row--) {
                    theSpiral[row][leftColumn] = value++;
                }
                leftColumn++;
            }
        }
        return theSpiral;
    }

}
