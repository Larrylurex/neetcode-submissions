class Solution {
record Coord(int x, int y) {
    }

    public boolean exist(char[][] board, String word) {
        for(int y = 0; y < board.length; y++) {
            for(int x = 0; x < board[y].length; x++){
                if(backtrack(board, x, y, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean backtrack(char[][] board, int x, int y, int i, String word) {
        if (i == word.length()) {
            return true;
        }

        if (x < 0 || x == board[0].length) return false;
        if (y < 0 || y == board.length) return false;
        if(word.charAt(i) != board[y][x]) return false;
        if(word.charAt(i) == '#') return false;

        board[y][x] = '#';
        boolean res = backtrack(board, x + 1, y, i + 1, word) ||
                    backtrack(board, x - 1, y, i + 1, word) ||
                    backtrack(board, x, y + 1, i + 1, word) ||
                    backtrack(board, x, y - 1, i + 1, word);
        board[y][x] = word.charAt(i);
        return res;
    }
}
