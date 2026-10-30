class Solution {
     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;

        List<String> words = new ArrayList<>(wordList);
        words.add(beginWord);
        Map<String, List<String>> patterns = new HashMap<>();
        for(var word: words) {
            for(int i = 0; i < word.length(); i++) {
                String patternStr = getPattern(word, i);
                patterns.putIfAbsent(patternStr, new ArrayList<>());
                patterns.get(patternStr).add(word);
            }
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int count = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String word = queue.poll();
                if( word.equals(endWord))
                    return count;
                for(int j = 0; j < word.length(); j++) {
                    String patternStr = getPattern(word, j);
                    for(var p :patterns.get(patternStr)) {
                        if (visited.add(p)) queue.offer(p);
                    }
                }
            }
            count++;
        }
        return 0;
    }

    private String getPattern(String word, int i) {
        var pattern = word.toCharArray();
        pattern[i] = '*';
        return new String(pattern);
    }
}
