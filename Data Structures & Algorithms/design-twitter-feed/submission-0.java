class Twitter {
    private Map<Integer, Set<Integer>> userFollowees = new HashMap<>();
    // collection for tweets?
    private List<int[]> tweets = new LinkedList<>(); // author_id, tweet_id
    public Twitter() {   
    }
    
    public void postTweet(int userId, int tweetId) {
        this.tweets.addFirst(new int[]{userId, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> followees = this.getFollowees(userId);
        for (int[] tweet : this.tweets) {
            int authorId = tweet[0];
            int tweetId = tweet[1];
            if (authorId == userId || followees.contains(authorId)) {
                res.add(tweetId);
                if (res.size() == 10) {
                    break;
                }
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        this.getFollowees(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        this.getFollowees(followerId).remove(followeeId);
    }

    private Set<Integer> getFollowees(int followerId) {
        Set<Integer> followees = this.userFollowees.get(followerId);
        if (followees == null) {
            followees = new HashSet<>();
            this.userFollowees.put(followerId, followees);
        }
        return followees;
    }
}
