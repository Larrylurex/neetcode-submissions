class Solution {

    // [1, 3, 5, 7]
    // [10, 11, 16, 20]
    // [23, 30, 34, 60]

    // rows = 3 cols = 4
    // f = 0, t = 11 m=5 (1:1)


    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int from = 0;
        int to = rows * cols - 1;

        while(from <= to) {
            int mid = from + (to - from)/2;

            int c = matrix[mid / cols][mid % cols];
            if(c == target) return true;
            if(target > c) {
                from = mid + 1;
            } else {
                to = mid - 1;
            }
        }
        return false;   
    }
}
