import java.util.*; // Imports all classes from the java.util package, including Set and HashSet.

// 1. It implements the Set interface
// The `Set` interface in Java represents a collection that does not allow duplicate elements.
// It models the mathematical concept of a set.

// 2. It does not order the element; order will be random (or rather, non-deterministic).
// `HashSet` makes no guarantees about the iteration order of its elements. The order can change
// over time, even with the same elements, if the hash function changes or if the internal
// array (backing the hash table) is resized.

// 3. Elements are not indexed.
// You cannot access elements by an integer index (like `get(0)`) because `HashSet` is not an ordered collection.
public class LearnHashSet {
    public static void main(String[] args) {
        // Create a new HashSet of Integer objects.
        // `HashSet` internally uses a `HashMap` to store its elements. Each element added to the `HashSet`
        // is stored as a key in the internal `HashMap`, with a dummy value (a constant `Object`).
        Set<Integer> hashSet = new HashSet<>();

        // 4. Adding Elements to HashSet:
        // The `add()` method attempts to add the specified element to this set.
        // It returns `true` if the set did not already contain the specified element, `false` otherwise.
        // Duplicate elements are not added.
        hashSet.add(32); // Set: {32}
        hashSet.add(2);  // Set: {32, 2}
        hashSet.add(54); // Set: {32, 2, 54}
        hashSet.add(21); // Set: {32, 2, 54, 21}
        hashSet.add(65); // Set: {32, 2, 54, 21, 65}
        hashSet.add(2);  // This will not be added as '2' is already present. `add()` returns false.

        // Print the `HashSet`.
        // The `toString()` method of `HashSet` prints the elements, but their order is not guaranteed.
        // It might look like `[32, 2, 21, 54, 65]` or any other permutation depending on hash codes and internal rehashings.
        System.out.println("HashSet after additions: " + hashSet);

        // 5. Removing Elements from HashSet:
        // The `remove()` method removes the specified element from this set if it is present.
        // It returns `true` if the set contained the specified element, `false` otherwise.
        hashSet.remove(54); // Removes 54 from the set.

        // Print the `HashSet` after removal.
        System.out.println("HashSet after removing 54: " + hashSet);

        // 6. Checking for Element Presence:
        // The `contains()` method returns `true` if this set contains the specified element, `false` otherwise.
        System.out.println("Does HashSet contain 100? " + hashSet.contains(100)); // Output: false
        System.out.println("Does HashSet contain 2? " + hashSet.contains(2));     // Output: true

        // 7. Checking if HashSet is Empty:
        // The `isEmpty()` method returns `true` if this set contains no elements, `false` otherwise.
        System.out.println("Is HashSet empty? " + hashSet.isEmpty()); // Output: false

        // 8. Getting the Size of HashSet:
        // The `size()` method returns the number of elements in this set (its cardinality).
        System.out.println("Size of HashSet: " + hashSet.size()); // Output will be 4 (original 5 - 1 removed)

        // 9. Clearing the HashSet:
        // The `clear()` method removes all of the elements from this set. The set will be empty after this call returns.
        hashSet.clear();

        // Print the size after clearing.
        System.out.println("Size of HashSet after clear: " + hashSet.size()); // Output: 0
        System.out.println("HashSet after clear: " + hashSet); // Output: [] (or similar empty set representation)

        // Iterating over the hashSet
        Iterator<Integer> it = hashSet.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        // --- Additional Concepts and Details for Revision ---

        // 10. How HashSet Works (Hashing):
        // `HashSet` stores elements by using a hash table. When an element is added, its `hashCode()` method is called.
        // This hash code determines where the element should be stored in the internal array (buckets).
        // If two objects have the same hash code (a "hash collision"), they are typically stored in the same "bucket,"
        // often in a linked list or tree structure within that bucket.
        // For `add()` and `contains()`, `equals()` is then used to differentiate between objects in the same bucket
        // and to check for true equality (and thus prevent duplicates).

        // 11. Important Contract for `hashCode()` and `equals()`:
        // For `HashSet` (and other hash-based collections like `HashMap`) to work correctly,
        // if two objects are equal according to the `equals()` method, then their `hashCode()` methods
        // **must** produce the same integer result. If you override `equals()`, you *must* also override `hashCode()`.
        // Failing to do so can lead to `HashSet` (or `HashMap`) incorrectly storing duplicate elements or
        // failing to find elements that are logically present.

        // 12. Performance of HashSet:
        // - **Average Case**: `add()`, `remove()`, and `contains()` operations generally offer **O(1) (constant time)** performance.
        //   This is because hashing allows direct access to elements.
        // - **Worst Case**: In scenarios with very poor hash functions leading to many collisions,
        //   performance can degrade to **O(n) (linear time)**, as these operations might have to traverse a linked list
        //   of elements in a single bucket. However, modern Java's `HashMap` (and thus `HashSet`)
        //   uses tree structures for large buckets to mitigate this to **O(log n)**.

        // 13. When to Use HashSet:
        // - When you need to store a collection of unique elements.
        // - When the order of elements is not important.
        // - When you need fast average-case performance for adding, removing, and checking for element existence.

        // 14. Other Set Implementations:
        // - **`LinkedHashSet`**: Maintains the insertion order of elements. It offers almost the same performance as `HashSet`
        //   but with the added overhead of maintaining a doubly-linked list.
        // - **`TreeSet`**: Stores elements in a sorted order (natural order or by a `Comparator`). Operations like `add()`,
        //   `remove()`, `contains()` are **O(log n)** because it uses a Red-Black Tree for storage. Use it when you need sorted unique elements.
    }
}