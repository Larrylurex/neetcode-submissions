class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> res = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] sorted = str.toCharArray();
            Arrays.sort(sorted);
            String sortedStr = new String(sorted);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
