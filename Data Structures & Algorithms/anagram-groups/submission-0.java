class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] sorted = str.toCharArray();
            Arrays.sort(sorted);
            map.compute(new String(sorted), (k, v) -> {
                if (v == null) {
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    return list;
                } else {
                    v.add(str);
                    return v;
                }
            });
        }
        for (var entry: map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
