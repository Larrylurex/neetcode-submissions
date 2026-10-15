class Solution {
     public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        add(res, new char[n*2], n, 0 ,0);
        return res;
    }

    void add(List<String> res, char[] cur, int n, int countOpen, int countClose) {
        if(countOpen == n && countClose == n) {
            res.add(new String(cur));
            return;
        }
        char[] opCur = Arrays.copyOf(cur, cur.length);
        if(countOpen < n) {
            opCur[countClose + countOpen] = '(';
            add(res, opCur, n, countOpen + 1, countClose);
        }
        if(countClose < countOpen) {
            char[] clCur = Arrays.copyOf(cur, cur.length);
            clCur[countClose + countOpen] = ')';
            add(res, clCur, n, countOpen, countClose + 1);
        }
    }
}
