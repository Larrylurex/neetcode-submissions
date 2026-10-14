class Twitter {

    private record Tweet(int id, int time) {}

    private int clock = 0;
    private final Map<Integer, List<Tweet>> tweets = new HashMap<>();
    private final Map<Integer, Set<Integer>> following = new HashMap<>();

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>())
              .add(new Tweet(tweetId, clock++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> heap =
                new PriorityQueue<>((a, b) -> Integer.compare(b.time(), a.time()));  // newest first

        Set<Integer> sources = new HashSet<>(following.getOrDefault(userId, Set.of()));
        sources.add(userId);                                  // own tweets, exactly once

        for (int src : sources) {
            List<Tweet> list = tweets.get(src);
            if (list == null) continue;
            for (int i = list.size() - 1, c = 0; i >= 0 && c < 10; i--, c++) {
                heap.add(list.get(i));                        // only the last 10 can matter
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!heap.isEmpty() && res.size() < 10) res.add(heap.poll().id());
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;                 // self-follow would duplicate
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> s = following.get(followerId);
        if (s != null) s.remove(followeeId);
    }

}
