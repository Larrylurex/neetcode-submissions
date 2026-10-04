class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) return "";

        StringBuilder builder = new StringBuilder();
        for(String str: strs) {
            builder.append(str.length())
                    .append('|')
                    .append(str);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty()) return List.of();

        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while(str.charAt(j) != '|') {
                j++;
            }
            int l = Integer.parseInt(str.substring(i, j));
            i = ++j;    
            String word = str.substring(i, i + l);
            res.add(word);
            i += l;
        }
        return res;
    }
}
