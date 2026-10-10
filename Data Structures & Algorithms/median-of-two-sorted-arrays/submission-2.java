class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] SMALL = (nums1.length < nums2.length) ? nums1 : nums2;
    int[] BIG = (nums1.length >= nums2.length) ? nums1 : nums2;

    int total = SMALL.length + BIG.length;
    int half = (total + 1) / 2;

    int l = 0;
    int r = SMALL.length;
    while (l <= r) {
        int cutSMALL = l + (r - l) / 2;
        int cutBIG = half - cutSMALL;

        int leftSMALL  = (cutSMALL > 0) ? SMALL[cutSMALL - 1] : Integer.MIN_VALUE;
        int rightSMALL = (cutSMALL < SMALL.length) ? SMALL[cutSMALL] : Integer.MAX_VALUE;
        int leftBIG    = (cutBIG > 0) ? BIG[cutBIG - 1] : Integer.MIN_VALUE;
        int rightBIG   = (cutBIG < BIG.length) ? BIG[cutBIG] : Integer.MAX_VALUE;

        if (leftSMALL <= rightBIG && leftBIG <= rightSMALL) {
            if (total % 2 == 0) {
                return (Math.max(leftSMALL, leftBIG) + Math.min(rightSMALL, rightBIG)) / 2.0;
            } else {
                return Math.max(leftSMALL, leftBIG);
            }
        } else if (leftSMALL > rightBIG) {
            r = cutSMALL - 1;
        } else {
            l = cutSMALL + 1;
        }
    }
    throw new IllegalArgumentException("inputs are not sorted");
    }
}
