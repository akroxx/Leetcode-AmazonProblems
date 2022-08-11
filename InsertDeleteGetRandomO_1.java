import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand = new Random();

    public RandomizedSet() {    //Simple init
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))    return false;

        map.put(val, list.size());  // <val, index in ArrayList>
        list.add(list.size(), val);

        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        //move last element to place idx of element to delete

        int lastElement = list.get(list.size()-1);
        int idx = map.get(val);
        list.set(idx, lastElement);
        map.put(lastElement, idx);
        //delete last elemt
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */