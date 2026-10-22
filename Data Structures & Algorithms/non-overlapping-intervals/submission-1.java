class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

    int kept = 0, end = Integer.MIN_VALUE;
    for (int[] iv : intervals) {
        if (iv[0] >= end) { kept++; end = iv[1]; }   // doesn't overlap the last kept
    }
    return intervals.length - kept;
}
}
