class Solution {
    public int orangesRotting(int[][] grid) {

        int time = 0;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0, gridLength = grid.length; r < gridLength; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] == 2) {
                    queue.offer(new int[]{r,c});
                }
                if(grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        
        while(fresh > 0 && !queue.isEmpty()) {
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++) {
                int[] cell = queue.poll();
                int[][] neighbours = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                for(int[] neighbour: neighbours) {
                    int newRow = cell[0] + neighbour[0];
                    int newCol = cell[1] + neighbour[1];
                    if(Math.min(newRow, newCol) >= 0 && newRow < grid.length && newCol < grid[newRow].length && grid[newRow][newCol] == 1) {
                        queue.offer(new int[]{newRow, newCol});
                        grid[newRow][newCol] = 2;
                        fresh--;
                    }
                }    
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
