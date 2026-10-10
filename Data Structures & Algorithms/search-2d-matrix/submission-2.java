class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = searchRow(matrix, target, 0, matrix.length - 1);
        if(row == -1) return false;
        return search(matrix[row], target, 0, matrix[row].length - 1);
    }

    int searchRow(int[][] matrix, int target, int from, int to) {
        if(to < from) return -1;

        int mid = from + (to - from)/2;
        if(matrix[mid][0] <= target && target <= matrix[mid][matrix[mid].length -1]) {
            return mid;
        } 
        return (matrix[mid][0] > target) ?
                searchRow(matrix, target, from, mid - 1) :
                searchRow(matrix, target, mid + 1, to);

    }

    boolean search(int[] row, int target, int from, int to) {
        if(to < from) return false;

        int mid = from + (to - from)/2;
        if(row[mid] == target) return true;

        return (row[mid] > target) ?
                search(row, target, from, mid - 1) :
                search(row, target, mid + 1, to);
    }
}
