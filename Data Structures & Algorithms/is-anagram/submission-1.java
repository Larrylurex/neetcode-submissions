class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] sum = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sum[s.charAt(i) - 'a']++;
            sum[t.charAt(i) - 'a']--;
        }
        return Arrays.equals(sum, new int[26]);
    }
}
