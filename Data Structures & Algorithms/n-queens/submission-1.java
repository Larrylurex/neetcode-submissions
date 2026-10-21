class Solution {
public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        backtrack(n, 0, new ArrayList<>(), res);
        return res;
    }

    void backtrack(int n, int r, List<Integer> queens, List<List<String>> res) {
        if(r == n) {
            List<String> boardRow = new ArrayList<>();
            for(int i = 0; i < n; i ++) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                int queenCol = queens.get(i);
                row[queenCol] = 'Q';
                boardRow.add(new String(row));
            }
            res.add(boardRow);
            return;
        }
        for (int c = 0; c < n; c++) {
            if (!canPlace(r, c, queens)) continue;
            queens.add(c);
            backtrack(n, r + 1, queens, res);
            queens.remove(queens.size() - 1);
        }
    }

    private boolean canPlace(int r, int c, List<Integer> queens) {
        for (int i = 0; i < queens.size(); i++) {
            if(queens.get(i) == c) return false;
            if(Math.abs(r - i) == Math.abs(c - queens.get(i))) return false;
        }
        return true;
    }
}
