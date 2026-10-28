class Solution {
    public void solve(char[][] board) {
        boolean[][] notSurrounded = new boolean[board.length][board[0].length];
        for (int c = 0; c < board[0].length; c++) {
            if (board[0][c] == 'O') traverse(board, 0, c, notSurrounded);
            if (board[board.length - 1][c] == 'O') traverse(board, board.length - 1, c, notSurrounded);
        }

        for (int r = 0; r < board.length; r++) {
            if (board[r][0] == 'O') traverse(board, r, 0, notSurrounded);
            if (board[r][board[r].length - 1] == 'O') traverse(board, r, board[r].length - 1, notSurrounded);
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == 'O' && !notSurrounded[r][c]) {
                    board[r][c] = 'X';
                }
            }
        }
    }

    private void traverse(char[][] board, int r, int c, boolean[][] notSurrounded) {
        notSurrounded[r][c] = true;

        int[][] next = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (var n : next) {
            int newR = r + n[0];
            int newC = c + n[1];
            if (Math.min(newR, newC) < 0 ||
                    newR >= board.length || newC >= board[r].length ||
                    board[newR][newC] == 'X' || notSurrounded[newR][newC]) continue;
            traverse(board, newR, newC, notSurrounded);
        }
    }
}
