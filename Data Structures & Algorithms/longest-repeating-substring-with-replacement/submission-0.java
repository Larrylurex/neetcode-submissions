class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int l = 0;
        int res = 0;

        for(int r = 0; r < s.length(); r++) {
            Integer cFreq = freq.getOrDefault(s.charAt(r), 0);
            freq.put(s.charAt(r), cFreq + 1);

            while(r - l + 1 - freq.values().stream().max(Comparator.comparingInt(Integer::intValue)).get() > k ) {
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
