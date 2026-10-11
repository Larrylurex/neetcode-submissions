class Solution {

    //[1,4,3,2] : 9
    //h (n : max(m))
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxPile = 1;
        for (int i = 0; i < n; i++) {
            maxPile = Math.max(maxPile, piles[i]);
        }

        int minK = 1;
        int maxK = maxPile;

        int k = maxK;
        while(minK <= maxK) {
            int mid = minK + (maxK - minK) / 2;
            int aH = 0;
            for (int i = 0; i < n ; i++) {
                aH += Math.ceil((double)piles[i] / mid);
            }
            if(aH > h) {
                minK = mid + 1;
            } else {
                k = mid;
                maxK = mid - 1;
            }

        }
        return k;
    }
}
