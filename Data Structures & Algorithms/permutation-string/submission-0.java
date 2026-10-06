class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;

        Map<Character, Integer> s1freq = new HashMap<>();
        for(char l : s1.toCharArray()) {
            s1freq.put(l, s1freq.getOrDefault(l, 0) + 1);
        }

        int l = 0;
        Map<Character, Integer> s2freq = new HashMap<>();
        for(int r = 0; r < s2.length(); r++) {
            s2freq.put(s2.charAt(r), s2freq.getOrDefault(s2.charAt(r), 0) + 1);
            if(r - l + 1 < s1.length()) {
                continue;
            }
            if(s2freq.equals(s1freq)) {
                return true;
            }
            s2freq.put(s2.charAt(l), s2freq.get(s2.charAt(l)) - 1);
            if(s2freq.get(s2.charAt(l)) == 0) {
                s2freq.remove(s2.charAt(l));
            }
            l++;
        }
        return false;
    }
}
