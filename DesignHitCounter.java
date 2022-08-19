class HitCounter {
    public Queue<Integer> timed;

    public HitCounter() {
        timed = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        timed.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        while(!timed.isEmpty()){
            int diff = timestamp - timed.peek();
            if(diff >= 300)
                timed.remove();     //Since timestamp is always input in chronological ; previously added elements to queue can be simply removed and since each timestamp can only have one hit per second, queue.size() denotes all number of hits made in the previous 300 seconds
            else
                break;                
        }
        
        return timed.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */