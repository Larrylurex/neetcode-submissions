class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] sqs = new int[9][9];
        int[][] cols = new int[9][9];

        for(int r = 0; r < 9; r++) {
            int[] row = new int[9];
            for(int c = 0; c < 9; c++) {
                if(board[r][c] == '.') continue;
                int val = (board[r][c] - '0') - 1;

                // check row
                row[val] += 1;
                if(row[val] > 1) {
                    return false;
                }

                //check col
                int[] col = cols[c];
                col[val] += 1;
                if(col[val] > 1) {
                    return false;
                }

                //check sq
                int[] sq = sqs[r/3*3 + c/3];
                sq[val] +=1;
                if(sq[val] > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
