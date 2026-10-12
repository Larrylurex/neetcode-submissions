class Solution {
  public String minWindow(String s, String t) {
        int l = 0;
        int bestLen = Integer.MAX_VALUE;
        int[] res = new int[2];

        Map<Character, Integer> tFreq = new HashMap<>();
        for(char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sFreq = new HashMap<>();

        for(int r = 0; r < s.length(); r++){
            sFreq.put(s.charAt(r), sFreq.getOrDefault(s.charAt(r), 0) + 1);

            while(hasAllFrom(sFreq, tFreq)) {
                int substrLength = r - l + 1;
                if(substrLength < bestLen) {
                    bestLen = substrLength;
                    res[0] = l;
                    res[1] = r;
                }

                sFreq.put(s.charAt(l), sFreq.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }

    private boolean hasAllFrom(Map<Character, Integer> s, Map<Character, Integer> t) {
        for( Character c : t.keySet()) {
            if(t.get(c) > s.getOrDefault(c, 0)) {
                return false;
            }
        }
        return true;
    }
}
