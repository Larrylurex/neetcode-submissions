class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<List<Integer>> pacific = new HashSet<>();
        Set<List<Integer>> atlantic = new HashSet<>();
        Set<List<Integer>> intersection = new HashSet<>();
        for(int r = 0; r < heights.length; r++) {
            for(int c = 0; c < heights[r].length; c++) {
                if(r == 0 || c == 0) {
                    dfs(heights, r, c, pacific, atlantic, intersection);
                }
                if(r == heights.length - 1 || c == heights[r].length - 1) {
                    dfs(heights, r, c, atlantic, pacific, intersection);
                }
            }
        }
        return new ArrayList<>(intersection);
    }

    private void dfs(int[][] heights, int r, int c, Set<List<Integer>> cur, Set<List<Integer>> another, Set<List<Integer>> intersection) {
        List<Integer> point = new ArrayList<>(){ {this.add(r); this.add(c);} };
        cur.add(point);
        if(another.contains(point)) intersection.add(point);


        int[][] next = new int[][]{{1, 0},{-1, 0},{0, 1},{0, -1}};
        for(var n: next) {
            int newR = r + n[0];
            int newC = c + n[1];
            if(Math.min(newR, newC) < 0 ||
                    newR >= heights.length || newC >= heights[r].length ||
                    heights[newR][newC] < heights[r][c] ||
                    cur.contains(new ArrayList<Integer>(){ {this.add(newR); this.add(newC);} })) continue;
            dfs(heights, newR, newC, cur, another, intersection);
        }
    }
}
