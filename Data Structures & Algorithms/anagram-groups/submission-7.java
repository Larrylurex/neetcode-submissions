class Solution {
       public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String freq = toFreq(strs[i]);
            anagrams.putIfAbsent(freq, new ArrayList<>());
            anagrams.get(freq).add(strs[i]);
        }
        return new ArrayList<>(anagrams.values());
    }

    public String toFreq(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        return Arrays.toString(freq);
    }
}
