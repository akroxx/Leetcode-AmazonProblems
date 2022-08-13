import java.util.ArrayList;
import java.util.HashMap;

class TimeMap {
    HashMap<String, ArrayList<String>> map;

    public TimeMap() {
        map = new HashMap<>();   
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            map.get(key).add(timestamp,value);
        }
        else{
            map.put(key, new ArrayList<String>());
            map.get(key).add(timestamp,value);
        }
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        String arr[] = map.get(key).toArray();

        if(arr.length < timestamp){
            return "";
        }

        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */