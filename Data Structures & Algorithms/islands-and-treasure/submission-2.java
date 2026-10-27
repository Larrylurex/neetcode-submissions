class Solution {
public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0, gridLength = grid.length; r < gridLength; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] == 0) {
                    queue.offer(new int[]{r,c});
                }
            }
        }

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++) {
                int[] cell = queue.poll();
                int[][] neighbours = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                for(int[] neighbour: neighbours) {
                    int newRow = cell[0] + neighbour[0];
                    int newCol = cell[1] + neighbour[1];
                    if(Math.min(newRow, newCol) >= 0 && newRow < grid.length && newCol < grid[newRow].length && grid[newRow][newCol] == Integer.MAX_VALUE) {
                        queue.offer(new int[]{newRow, newCol});
                        grid[newRow][newCol] = grid[cell[0]][cell[1]] + 1;

                    }
                }
            }
        }
    }
}
