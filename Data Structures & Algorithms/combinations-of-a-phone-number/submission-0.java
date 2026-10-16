class Solution {
private static final Map<Character, String> KEYPAD = Map.of(
            '2', "abc",  '3', "def",  '4', "ghi",  '5', "jkl",
            '6', "mno",  '7', "pqrs", '8', "tuv",  '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return List.of();
        List<String> res = new ArrayList<>();
        List<String> letters = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            letters.add(KEYPAD.get(c));
        }
        backtrack(new StringBuilder(), 0, letters, res);
        return res;

    }

    void backtrack(StringBuilder cur, int digitN, List<String> letters, List<String> res) {
        if(cur.length() == letters.size()) {
            res.add(cur.toString());
            return;
        }
        String dLetters = letters.get(digitN);

        for (char c : dLetters.toCharArray()) {
            cur.append(c);
            backtrack(cur, digitN + 1, letters, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
