import java.util.LinkedHashMap;
import java.util.Map;
/*
LRUCache implementation
*/
public class LRUCache {
    private LinkedHashMap lhm ;
    private final int cap;
    
    public LRUCache(int capacity) {
        this.cap=capacity;
        lhm = new LinkedHashMap(capacity,1,true){
            public boolean removeEldestEntry(Map.Entry eldest) {
                return size() > cap;
            }
        };
    }
    
    public int get(int key) {
        if(lhm.containsKey(key))
            return (Integer)lhm.get(key);
        else
            return -1;
    }
    
    public void set(int key, int value) {
        lhm.put(key,value);
    }
}