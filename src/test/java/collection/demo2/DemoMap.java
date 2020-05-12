package collection.demo2;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: melody
 * @Date: 2020-05-12
 */
public class DemoMap extends AbstractMap<String,String> {

    private static class Entry implements Map.Entry<String,String>{
        
        int index;
        
        Entry(int index){
            this.index = index;
        }
        public boolean equals(Object o){
            return false;
        }

        @Override
        public String getKey() {
            return null;
        }

        @Override
        public String getValue() {
            return null;
        }

        @Override
        public String setValue(String value) {
            return null;
        }
    }

    @Override
    public Set<Map.Entry<String, String>> entrySet() {
        return null;
    }
}
