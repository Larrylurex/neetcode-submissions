class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        int left = -1; int right = -1;
        for (int i = 0, intervalsLength = intervals.length; i < intervalsLength; i++) {
            int[] interval = intervals[i];
            if (left == -1 && newInterval[0] >= interval[0] && newInterval[0] <= interval[1]) {
                left = interval[0];
            }
            if(left == -1 && newInterval[0] < interval[0]){
                left = newInterval[0];
            }

            if(left != -1 && right == -1) {
                if(newInterval[1] < interval[0]) {
                    right = newInterval[1];
                    res.add(new int[]{left, right});
                    res.add(interval);
                } else if(newInterval[1] < interval[1]) {
                    right = interval[1];
                    res.add(new int[]{left, right});
                }
                continue;
            }

            res.add(interval);
        }
        if(left == -1) {
            res.add(newInterval);
        } else if(right == -1) {
            res.add(new int[]{left, newInterval[1]});
        }
        return res.toArray(new int[0][0]);
    }
}
