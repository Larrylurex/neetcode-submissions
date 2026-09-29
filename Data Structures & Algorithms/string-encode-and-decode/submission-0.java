class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for(String w: strs) {
            builder.append(w.length())
                    .append('#')
                    .append(w);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        char[] charArray = str.toCharArray();
        int i = 0;
        while (i < charArray.length) {
            char c = charArray[i];

            if (c != '#') {
                number.append(c);
                i++;
            } else {
                int num = Integer.parseInt(number.toString());
                int start = i + 1;
                int end = start + num;
                String word = str.substring(start, end);
                res.add(word);
                i = end;
                number = new StringBuilder();
            }
        }
        return res;
    }
}
