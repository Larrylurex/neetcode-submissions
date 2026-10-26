class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int res = 0;
        for (int i = 0; i < ROWS * COLS; i++) {
            int r = i / COLS;
            int c = i % COLS;
            int v = grid[r][c];
            if (v == 0) continue;
            if (v == -1) continue;
            if (v == 1) {
                res = Math.max(res, dfs(grid, r, c));
            }
        }
        return res;

    }

    int dfs(int[][] grid, int r, int c) {
        if (Math.min(r, c) < 0 ||
                r == grid.length || c == grid[0].length ||
                grid[r][c] == 0 || grid[r][c] == -1) return 0;

        grid[r][c] = -1;
        int area = 1;
        area += dfs(grid, r + 1, c);
        area += dfs(grid, r - 1, c);
        area += dfs(grid, r, c + 1);
        area += dfs(grid, r, c - 1);
        return area;
    }
}
