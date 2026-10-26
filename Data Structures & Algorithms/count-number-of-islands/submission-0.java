class Solution {
public int numIslands(char[][] grid) {

        int ROWS = grid.length;
        int COLS = grid[0].length;
        int res = 0;
        for (int i = 0; i < ROWS * COLS; i++) {
            int r = i / COLS;
            int c = i % COLS;
            char v = grid[r][c];
            if (v == '0') continue;
            if (v == 'X') continue;
            if (v == '1') {
                res++;
                dfs(grid, r, c);
            }
        }
        return res;

    }

    void dfs(char[][] grid, int r, int c) {
        if (Math.min(r, c) < 0 ||
                r == grid.length || c == grid[0].length ||
                grid[r][c] == '0' || grid[r][c] == 'X') return;

        grid[r][c] = 'X';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);

    }
}
