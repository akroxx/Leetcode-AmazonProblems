class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Populate a frequency HashMap
        // Iterate through the keySet() 
        // add elements according to frequency into Prio
        // Simply add all elements to a PriorityQueue<Integer> and pop number of 
        // k-elements into an array size of [k+1];
        
        int res[] = new int[k+1];

        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        //FreqMap populated
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (map.get(b) - map.get(a)));
        pq.addAll(map.keySet());

        for(int i = 0; i < k; i++){
            res[i] = pq.poll();
        }

        return res;
        
        
    }
}