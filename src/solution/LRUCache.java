package solution;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author linglifan
 * @date 2022/09/08 19:37
 */
public class LRUCache extends LinkedHashMap<Integer, Integer>{

    int cap;
    Map<Integer,Integer> map;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new LinkedHashMap<Integer,Integer>(cap);

    }

    public int get(int key) {
        return map.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        map.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return map.size() > cap;
    }

}
