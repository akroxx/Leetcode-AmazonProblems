import java.util.ArrayList;
import java.util.HashMap;

class Pair {
    int time;
    String web;
    public Pair(int time, String web){
        this.time = time;
        this.web = web;
    }
}


class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> map = new HashMap<>();
        int n = username.length;
        //collect website info for every user, key : username, value (timestamp, website)

        for(int i = 0; i < n; i++){
            map.putIfAbsent(username[i], new ArrayList<>());
            map.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }

        //
    }
}