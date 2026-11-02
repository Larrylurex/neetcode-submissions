class Solution {
    public int minCostClimbingStairs(int[] cost) {
        var cache = new int[cost.length];
        return Math.min(climb(0, cache, cost), climb(1, cache, cost));
    }

    private int climb(int i, int[] cache, int[] cost){
        if(i >= cost.length) return 0;
        if(i == cost.length - 1) {
            return cost[i];
        }
        if(cache[i] != 0) return cache[i];
        int toCache = cost[i] + Math.min(climb(i + 1, cache, cost), climb(i + 2, cache, cost));
        cache[i] = toCache;
        return toCache;
    }
}
