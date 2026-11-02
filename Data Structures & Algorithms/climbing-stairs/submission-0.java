class Solution {
    public int climbStairs(int n) {
        return climb(n, 0, new int[n + 1]);
    }

    private int climb(int n, int curSum, int[] cache) {
        if (curSum > n)
            return 0;
        if (curSum == n) {
            return 1;
        }
        if (cache[curSum] != 0)
            return cache[curSum];
        int toCache = climb(n, curSum + 1, cache) + climb(n, curSum + 2, cache);
        cache[curSum] = toCache;
        return toCache;
    }
}
