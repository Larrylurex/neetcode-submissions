class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] cols = new int[9][9];
        int[][] squares = new int[9][9];


        for(int i = 0; i < board.length; i++) {
            int[] row = new int[9];

            char[] rowChars = board[i];
            for(int j = 0; j < rowChars.length; j++) {
                if(rowChars[j] == '.') continue;

                int rowVal = rowChars[j] - '0';

                //check row
                if(row[rowVal - 1] != 0) {
                    System.out.println("Duplicate in a row: " + i);
                    // Duplicate in a row
                    return false;
                }
                row[rowVal - 1] = rowVal;

                //check col
                int[] col = cols[j];
                if(col[rowVal - 1] != 0) {
                    System.out.println("Duplicate in a col: " + j);
                    // Duplicate in a row
                    return false;
                }
                col[rowVal - 1] = rowVal;

                //check square
                int squareIndex = i - i % 3 + j / 3;
                int[] square = squares[squareIndex];
                if(square[rowVal - 1] != 0) {
                    System.out.println("Duplicate in a square " + squareIndex + " val: " + square[rowVal - 1]);
                    System.out.println("Duplicate in a square: " + i + ":" + j);
                    // Duplicate in a row
                    return false;
                }
                square[rowVal - 1] = rowVal;
            }
        }
        return true;
    }
}
