import java.util.*;

public class LearnHashMap {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();

        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        hashMap.put("Three", 3);
        hashMap.put("Three", 10); // The key:value pair will now get updated

        System.out.println(hashMap);

        System.out.println(hashMap.containsKey("One"));

        hashMap.putIfAbsent("Five", 5);
        System.out.println(hashMap);

        System.out.println(hashMap.size());

        // hashMap.clear();
        // System.out.println(hashMap.size());

        System.out.println(hashMap.containsValue(10));


        for(Map.Entry<String,Integer> e : hashMap.entrySet()) {
            System.out.println(e);
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        for(String key: hashMap.keySet()) {
            System.out.println(key);
        }

        for(Integer value: hashMap.values()) {
            System.out.println(value);
        }
        
    }
    }
