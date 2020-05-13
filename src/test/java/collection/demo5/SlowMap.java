package collection.demo5;

import org.apache.tiles.request.collection.MapEntry;

import java.util.*;

/**
 * @Author: melody
 * @Date: 2020-05-13
 */
public class SlowMap<K,V> extends AbstractMap<K,V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();
    public V put(K key,V value){
        V oldValue = get(key);
        if (!keys.contains(key)){
            keys.add(key);
            values.add(value);
        }else {
            values.set(keys.indexOf(key),value);
        }
        return oldValue;
    }
    public V get(Object key){
        if (!keys.contains(key)){
            return null;
        }
        return values.get(keys.indexOf(key));
    }
    @Override
    public Set<Map.Entry<K,V>> entrySet(){
        Set<Map.Entry<K,V>> set = new HashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext()){
            set.add(new MapEntry<K, V>(ki.next(),vi.next(),false));
        }
        return set;
    }
}
