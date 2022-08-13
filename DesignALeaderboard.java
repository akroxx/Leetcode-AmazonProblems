class Leaderboard {
    private HashMap<Integer, Integer> scores;
    //map stores playerID, totalScore

    public Leaderboard() {  //init
        this.scores = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        if(!this.scores.containsKey(playerId)){
            this.scores.put(playerId, 0);
        }

        this.scores.put(playerId, scores.get(playerId) + score);
    }
    
    public int top(int K) {
        // A min heap with greater value from hashmap first
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b - a));

        for(int x : this.scores.keySet()){
            pq.offer(this.scores.get(x));
            if(pq.size() > K){
                pq.poll();
            }
        }

        int res = 0;

        Iterator itr = pq.iterator();
        while(itr.hasNext()){
            res += itr.next();
        }

        return res;
    }
    
    public void reset(int playerId) {
        this.scores.put(playerId, 0);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */