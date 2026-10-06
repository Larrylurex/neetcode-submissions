class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        int l = 0;
        int r = 1;
        int length = 1;
        char[] arr = s.toCharArray();

        Set<Character> substr = new HashSet<>();
        substr.add(arr[l]);

        while(r < arr.length) {
            if(!substr.contains(arr[r])) {
                length = Math.max(length, r - l + 1);
                substr.add(arr[r]);
            } else {
                while(arr[l] != arr[r]) {
                    substr.remove(arr[l]);
                    l++;
                }
                l++;
            }
            r++;
        }
        return length;
    }
}
