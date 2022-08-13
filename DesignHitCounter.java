class HitCounter {
    public Queue<Integer> hits; //Actually stores timeStamps when a hit comes-in

    public HitCounter() {
        hits = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        hits.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        while(!hits.isEmpty()){
            int diff = timestamp - hits.peek();
            if(diff >= 300) hits.remove();
            else break; //out of loop->
        }

        return hits.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */