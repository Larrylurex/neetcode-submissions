class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            sMap.compute(s.charAt(i), (k , v) -> (v == null) ? 1 : v+1);
            tMap.compute(t.charAt(i), (k , v) -> (v == null) ? 1 : v+1);
        }
        for(int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if(!Objects.equals(sMap.getOrDefault(key, 0), tMap.getOrDefault(key, 0))) return false;
        }
        return true;
    }
}
