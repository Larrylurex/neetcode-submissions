class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> res = new ArrayList<>();
        int[] mergeInterval = intervals[0];
        int i = 1;
        int n = intervals.length;
        while(i < n) {
            if(intervals[i][0] > mergeInterval[1]) {
                res.add(mergeInterval);
                mergeInterval = intervals[i];

            } else {
                mergeInterval = new int[] {Math.min(mergeInterval[0], intervals[i][0]),
                        Math.max(mergeInterval[1], intervals[i][1])};
            }
            i++;
        }
        res.add(mergeInterval);

        return res.toArray(new int[0][0]);
    }
}
