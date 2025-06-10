import java.util.*; // Imports all classes from the java.util package, including Map and TreeMap.

public class LearnTreeMap {
    public static void main(String[] args) {
        // 1. Map Interface and TreeMap Implementation:
        // The `Map` interface represents a collection that maps keys to values. A map cannot contain duplicate keys;
        // each key can map to at most one value.
        // `TreeMap` is an implementation of the `SortedMap` interface (which extends `Map`), and it stores its
        // entries (key-value pairs) in a sorted order based on the natural ordering of its keys, or by a `Comparator`
        // provided at map creation time.
        // `TreeMap` is internally implemented using a Red-Black tree.
        Map<String, Integer> treeMap = new TreeMap<>(); // Changed 'hashMap' to 'treeMap' for clarity, as it's a TreeMap.

        // 2. Adding Entries to TreeMap (`put()`):
        // The `put(K key, V value)` method associates the specified value with the specified key in this map.
        // If the map previously contained a mapping for the key, the old value is replaced by the specified value.
        // `TreeMap` maintains the keys in sorted order as elements are added.
        treeMap.put("One", 1);    // Adds "One" -> 1
        treeMap.put("Two", 2);    // Adds "Two" -> 2
        treeMap.put("Three", 3);  // Adds "Three" -> 3
        treeMap.put("Three", 10); // Updates the value for "Three" from 3 to 10, as keys must be unique.

        // Print the `TreeMap`.
        // The `toString()` method of `TreeMap` prints the entries in sorted order of keys.
        // Output will be based on alphabetical order of keys: {One=1, Three=10, Two=2}
        System.out.println("TreeMap after put operations: " + treeMap);

        // 3. Checking for Key Presence (`containsKey()`):
        // The `containsKey(Object key)` method returns `true` if this map contains a mapping for the specified key.
        System.out.println("Does TreeMap contain key \"One\"? " + treeMap.containsKey("One")); // Output: true
        System.out.println("Does TreeMap contain key \"Four\"? " + treeMap.containsKey("Four")); // Output: false

        // 4. Adding Entries Conditionally (`putIfAbsent()`):
        // The `putIfAbsent(K key, V value)` method, available from Java 8, inserts the specified mapping into this map
        // if the specified key is not already associated with a value (or is mapped to `null`).
        // It returns the previous value associated with the key, or `null` if there was no mapping.
        treeMap.putIfAbsent("Five", 5); // "Five" is not present, so it's added.
        treeMap.putIfAbsent("One", 100); // "One" is already present, so its value is not updated.
        System.out.println("TreeMap after putIfAbsent: " + treeMap); // Output: {Five=5, One=1, Three=10, Two=2} (sorted)

        // 5. Getting the Size of TreeMap (`size()`):
        // The `size()` method returns the number of key-value mappings in this map.
        System.out.println("Size of TreeMap: " + treeMap.size()); // Output: 4

        // 6. Clearing the TreeMap (`clear()`):
        // The `clear()` method removes all of the mappings from this map. The map will be empty after this call returns.
        // `treeMap.clear();` // Uncomment to see the effect of clearing
        // `System.out.println("Size of TreeMap after clear: " + treeMap.size());`

        // 7. Checking for Value Presence (`containsValue()`):
        // The `containsValue(Object value)` method returns `true` if this map maps one or more keys to the specified value.
        // Note: Checking for value presence is generally less efficient than checking for key presence, as it might
        // require iterating through all values.
        System.out.println("Does TreeMap contain value 10? " + treeMap.containsValue(10)); // Output: true
        System.out.println("Does TreeMap contain value 20? " + treeMap.containsValue(20)); // Output: false

        // 8. Iterating Through TreeMap Entries (EntrySet):
        // `entrySet()` returns a `Set` view of the mappings contained in this map.
        // Each element in the set is a `Map.Entry` object, which represents a single key-value pair.
        // Iteration order is guaranteed to be the natural sorted order of keys.
        System.out.println("\nIterating through Map.EntrySet:");
        for (Map.Entry<String, Integer> e : treeMap.entrySet()) {
            System.out.println(e);           // Prints the entire entry (e.g., "Five=5")
            System.out.println("Key: " + e.getKey());   // Prints just the key (e.g., "Five")
            System.out.println("Value: " + e.getValue()); // Prints just the value (e.g., "5")
        }

        // 9. Iterating Through TreeMap Keys (KeySet):
        // `keySet()` returns a `Set` view of the keys contained in this map.
        // Iteration order is guaranteed to be the natural sorted order of keys.
        System.out.println("\nIterating through KeySet:");
        for (String key : treeMap.keySet()) {
            System.out.println(key); // Prints each key in sorted order
        }

        // 10. Iterating Through TreeMap Values (Values Collection):
        // `values()` returns a `Collection` view of the values contained in this map.
        // Iteration order corresponds to the sorted order of their respective keys.
        System.out.println("\nIterating through Values:");
        for (Integer value : treeMap.values()) {
            System.out.println(value); // Prints each value corresponding to the sorted keys
        }

        // --- Additional Concepts and Details for Revision ---

        // 11. SortedMap and NavigableMap Interfaces:
        // `TreeMap` implements `NavigableMap`, which extends `SortedMap`. These interfaces provide additional methods
        // for navigating the map based on its sorted order:
        // - `firstKey()`: Returns the first (lowest) key.
        // - `lastKey()`: Returns the last (highest) key.
        // - `headMap(K toKey)`: Returns a view of the portion of this map whose keys are strictly less than `toKey`.
        // - `tailMap(K fromKey)`: Returns a view of the portion of this map whose keys are greater than or equal to `fromKey`.
        // - `subMap(K fromKey, K toKey)`: Returns a view of the portion of this map whose keys range from `fromKey` (inclusive) to `toKey` (exclusive).
        // - `floorKey(K key)`: Returns the greatest key less than or equal to the given key.
        // - `ceilingKey(K key)`: Returns the least key greater than or equal to the given key.
        // - `pollFirstEntry()`: Removes and returns a key-value mapping associated with the least key.
        // - `pollLastEntry()`: Removes and returns a key-value mapping associated with the greatest key.

        /*
        System.out.println("\n--- NavigableMap Methods (Example) ---");
        TreeMap<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.put("Apple", 10);
        sortedMap.put("Banana", 20);
        sortedMap.put("Cherry", 30);
        sortedMap.put("Date", 40);
        System.out.println("First key: " + sortedMap.firstKey()); // Output: Apple
        System.out.println("Last key: " + sortedMap.lastKey());   // Output: Date
        System.out.println("Head map (keys < Cherry): " + sortedMap.headMap("Cherry")); // Output: {Apple=10, Banana=20}
        System.out.println("Tail map (keys >= Banana): " + sortedMap.tailMap("Banana")); // Output: {Banana=20, Cherry=30, Date=40}
        System.out.println("Floor key for 'D': " + sortedMap.floorKey("D")); // Output: Date (or null/previous if not found, depending on context)
        */

        // 12. Performance of TreeMap:
        // - All basic operations (`put()`, `get()`, `remove()`, `containsKey()`) have a time complexity of **O(log n)**.
        //   This is due to the nature of tree-based data structures (Red-Black tree).
        // - Iteration over `TreeMap` is also O(n) but the elements are returned in sorted order of keys.

        // 13. When to Use TreeMap:
        // - When you need to store key-value pairs.
        // - When the keys need to be kept in a sorted order (either natural or custom).
        // - When you need efficient retrieval of elements based on their sorted order (e.g., finding the next/previous key, sub-maps).
        // - If you don't need sorted order, `HashMap` is generally preferred for its O(1) average time complexity.
    }
}