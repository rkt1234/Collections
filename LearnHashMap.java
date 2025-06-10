import java.util.*; // Imports all classes from the java.util package, including Map and HashMap.

public class LearnHashMap {
    public static void main(String[] args) {
        // 1. Map Interface and HashMap Implementation:
        // The `Map` interface represents a collection that maps unique keys to values.
        // `HashMap` is the most commonly used implementation of the `Map` interface.
        // It provides unsorted, unordered storage of key-value pairs.
        // `HashMap` is based on the principle of hashing, offering very fast average-case performance.
        // It allows one null key and multiple null values.
        // Note: HashMap is not thread-safe; if multiple threads access a HashMap concurrently,
        // it must be synchronized externally.
        Map<String, Integer> hashMap = new HashMap<>();

        // 2. Adding Entries to HashMap (`put()`):
        // The `put(K key, V value)` method associates the specified value with the specified key in this map.
        // If the map previously contained a mapping for the key, the old value is replaced by the new one.
        hashMap.put("One", 1);   // Adds "One" -> 1
        hashMap.put("Two", 2);   // Adds "Two" -> 2
        hashMap.put("Three", 3); // Adds "Three" -> 3
        hashMap.put("Three", 10); // Updates the value for "Three" from 3 to 10. Keys must be unique.

        // Print the `HashMap`.
        // The `toString()` method of `HashMap` prints the entries, but their order is not guaranteed.
        // It's typically based on hash codes and internal array structure, so it can seem random.
        System.out.println("HashMap after put operations: " + hashMap);

        // 3. Checking for Key Presence (`containsKey()`):
        // The `containsKey(Object key)` method returns `true` if this map contains a mapping for the specified key.
        System.out.println("Does HashMap contain key \"One\"? " + hashMap.containsKey("One")); // Output: true
        System.out.println("Does HashMap contain key \"Four\"? " + hashMap.containsKey("Four")); // Output: false

        // 4. Adding Entries Conditionally (`putIfAbsent()`):
        // The `putIfAbsent(K key, V value)` method (introduced in Java 8) inserts the specified mapping
        // if the specified key is not already associated with a value (or is mapped to `null`).
        // It returns the previous value associated with the key, or `null` if there was no mapping.
        hashMap.putIfAbsent("Five", 5);  // "Five" is not present, so it's added.
        hashMap.putIfAbsent("One", 100); // "One" is already present, so its value remains 1.
        System.out.println("HashMap after putIfAbsent: " + hashMap); // Order might be different, but content will be {One=1, Two=2, Three=10, Five=5}

        // 5. Getting the Size of HashMap (`size()`):
        // The `size()` method returns the number of key-value mappings in this map.
        System.out.println("Size of HashMap: " + hashMap.size()); // Output: 4

        // 6. Clearing the HashMap (`clear()`):
        // The `clear()` method removes all of the mappings from this map. The map will be empty after this call.
        // hashMap.clear(); // Uncomment to see the effect of clearing
        // System.out.println("Size of HashMap after clear: " + hashMap.size());

        // 7. Checking for Value Presence (`containsValue()`):
        // The `containsValue(Object value)` method returns `true` if this map maps one or more keys to the specified value.
        // Note: This operation can be less efficient than `containsKey()` as it may need to iterate through all values.
        System.out.println("Does HashMap contain value 10? " + hashMap.containsValue(10)); // Output: true
        System.out.println("Does HashMap contain value 20? " + hashMap.containsValue(20)); // Output: false

        // 8. Iterating Through HashMap Entries (`entrySet()`):
        // `entrySet()` returns a `Set` view of the mappings contained in this map.
        // Each element in the set is a `Map.Entry` object, representing a single key-value pair.
        // The iteration order is not guaranteed (it might seem arbitrary).
        System.out.println("\nIterating through Map.EntrySet:");
        for (Map.Entry<String, Integer> e : hashMap.entrySet()) {
            System.out.println(e);           // Prints the entire entry (e.g., "One=1")
            System.out.println("Key: " + e.getKey());   // Prints just the key (e.g., "One")
            System.out.println("Value: " + e.getValue()); // Prints just the value (e.g., "1")
        }

        // 9. Iterating Through HashMap Keys (`keySet()`):
        // `keySet()` returns a `Set` view of the keys contained in this map.
        // The iteration order of keys is not guaranteed.
        System.out.println("\nIterating through KeySet:");
        for (String key : hashMap.keySet()) {
            System.out.println(key); // Prints each key
        }

        // 10. Iterating Through HashMap Values (`values()`):
        // `values()` returns a `Collection` view of the values contained in this map.
        // The iteration order of values is not guaranteed and corresponds to the non-deterministic order of keys.
        System.out.println("\nIterating through Values:");
        for (Integer value : hashMap.values()) {
            System.out.println(value); // Prints each value
        }
    }

    // --- Additional Concepts and Details for Revision ---

    /**
     * **11. How HashMap Works (Hashing):**
     * `HashMap` uses a technique called **hashing**. When you `put()` an entry, the `hashCode()` method of the key object is called.
     * This hash code helps determine the "bucket" (an index in an internal array) where the key-value pair should be stored.
     * If multiple keys hash to the same bucket (a **collision**), they are typically stored in a linked list or,
     * in Java 8+, a balanced tree (Red-Black tree) within that bucket to maintain performance for larger buckets.
     *
     * When you `get()` or `containsKey()`, the key's `hashCode()` is again used to find the correct bucket,
     * and then the `equals()` method is used to compare keys within that bucket to find the exact match.
     */
    /**
     * **12. Important Contract for `hashCode()` and `equals()`:**
     * For `HashMap` to function correctly, if two objects are considered equal by the `equals()` method,
     * their `hashCode()` methods **must** produce the same integer result. If you override `equals()`
     * for a custom class used as a key in a `HashMap`, you **must** also override `hashCode()`.
     * Failing to adhere to this contract can lead to `HashMap` behaving unexpectedly, such as not being
     * able to retrieve values even if the key logically exists, or storing duplicate keys.
     */
    /**
     * **13. Performance of HashMap:**
     * - **Average Case**: `put()`, `get()`, `remove()`, and `containsKey()` operations typically provide **O(1) (constant time)** performance.
     * This is the main reason `HashMap` is so popular – it offers extremely fast lookups.
     * - **Worst Case**: In rare scenarios, particularly with poorly designed hash functions leading to excessive collisions,
     * performance can degrade to **O(n) (linear time)**. However, Java's `HashMap` implementation (since Java 8)
     * uses treeification (converting linked lists in buckets to balanced trees when they get too long) to mitigate this to **O(log n)**
     * in such pathological cases.
     */
    /**
     * **14. When to Use HashMap:**
     * - When you need to store key-value pairs where keys are unique.
     * - When the order of elements is **not** important.
     * - When you need the fastest possible average-case performance for adding, retrieving, and removing entries.
     * - It's the most common and generally recommended `Map` implementation for general-purpose use.
     */
    /**
     * **15. Other Map Implementations:**
     * - **`LinkedHashMap`**: This implementation maintains the **insertion order** of key-value pairs.
     * It provides almost the same performance as `HashMap` but with the added overhead of maintaining a doubly-linked list for ordering.
     * - **`TreeMap`**: This map stores entries in a **sorted order** based on the natural ordering of its keys or by a custom `Comparator`.
     * Its operations are **O(log n)** because it's backed by a Red-Black tree. Use it when you need sorted keys.
     */
}