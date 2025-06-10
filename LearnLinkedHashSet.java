import java.util.*; // Imports all classes from the java.util package, including Set and LinkedHashSet.

// 1. It implements the Set interface
// The `Set` interface in Java represents a collection that does not allow duplicate elements.
// It models the mathematical concept of a set.

// 2. It maintains the insertion order of elements.
// This is the key difference from `HashSet`. `LinkedHashSet` preserves the order in which elements
// were inserted into the set. When you iterate over a `LinkedHashSet`, elements will be returned
// in the order they were added.

// 3. Elements are not indexed.
// Similar to `HashSet`, you cannot access elements by an integer index (like `get(0)`) because `LinkedHashSet`
// is a set, not a list, and it doesn't provide random access.
public class LearnLinkedHashSet {
    public static void main(String[] args) {
        // Create a new LinkedHashSet of Integer objects.
        // `LinkedHashSet` extends `HashSet` and implements the `Set` interface.
        // Internally, it uses a hash table (like `HashSet`) with a doubly-linked list running through
        // all of its entries. This linked list defines the iteration order.
        Set<Integer> hashSet = new LinkedHashSet<>();

        // 4. Adding Elements to LinkedHashSet:
        // The `add()` method attempts to add the specified element to this set.
        // It returns `true` if the set did not already contain the specified element, `false` otherwise.
        // Duplicate elements are not added.
        hashSet.add(32); // Set: {32}
        hashSet.add(2);  // Set: {32, 2}
        hashSet.add(54); // Set: {32, 2, 54}
        hashSet.add(21); // Set: {32, 2, 54, 21}
        hashSet.add(65); // Set: {32, 2, 54, 21, 65}
        hashSet.add(2);  // This will not be added as '2' is already present. `add()` returns false.

        // Print the `LinkedHashSet`.
        // The `toString()` method of `LinkedHashSet` prints the elements in their insertion order.
        // Output: [32, 2, 54, 21, 65] (exactly in the order they were added)
        System.out.println("LinkedHashSet after additions: " + hashSet);

        // 5. Removing Elements from LinkedHashSet:
        // The `remove()` method removes the specified element from this set if it is present.
        // It returns `true` if the set contained the specified element, `false` otherwise.
        // Removal also updates the internal linked list to maintain order of remaining elements.
        hashSet.remove(54); // Removes 54 from the set.

        // Print the `LinkedHashSet` after removal. The order of remaining elements is preserved.
        // Output: [32, 2, 21, 65]
        System.out.println("LinkedHashSet after removing 54: " + hashSet);

        // 6. Checking for Element Presence:
        // The `contains()` method returns `true` if this set contains the specified element, `false` otherwise.
        System.out.println("Does LinkedHashSet contain 100? " + hashSet.contains(100)); // Output: false
        System.out.println("Does LinkedHashSet contain 2? " + hashSet.contains(2));     // Output: true

        // 7. Checking if LinkedHashSet is Empty:
        // The `isEmpty()` method returns `true` if this set contains no elements, `false` otherwise.
        System.out.println("Is LinkedHashSet empty? " + hashSet.isEmpty()); // Output: false

        // 8. Getting the Size of LinkedHashSet:
        // The `size()` method returns the number of elements in this set (its cardinality).
        System.out.println("Size of LinkedHashSet: " + hashSet.size()); // Output will be 4 (original 5 - 1 removed)

        // 9. Clearing the LinkedHashSet:
        // The `clear()` method removes all of the elements from this set. The set will be empty after this call returns.
        hashSet.clear();

        // Iterating over the hashSet
        Iterator<Integer> it = hashSet.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        // Print the size after clearing.
        System.out.println("Size of LinkedHashSet after clear: " + hashSet.size()); // Output: 0
        System.out.println("LinkedHashSet after clear: " + hashSet); // Output: [] (or similar empty set representation)

        // --- Additional Concepts and Details for Revision ---

        // 10. Internal Working of LinkedHashSet:
        // `LinkedHashSet` combines the features of `HashSet` (hash table for quick lookups) and `LinkedList`
        // (doubly-linked list for maintaining insertion order).
        // Each entry in the hash table (which is a `HashMap` under the hood) also maintains links to the previous
        // and next elements in the insertion order.

        // 11. Performance of LinkedHashSet:
        // - **Average Case**: `add()`, `remove()`, and `contains()` operations generally offer **O(1) (constant time)** performance,
        //   similar to `HashSet`, because they leverage the hash table part.
        // - **Worst Case**: Can degrade to **O(n)** in rare collision scenarios, though mitigated by Java's `HashMap` optimizations.
        // - **Iteration**: Iterating over `LinkedHashSet` is faster than `HashSet` if the set is large,
        //   because it traverses the linked list, which is more predictable and avoids potential hash table "jumps."

        // 12. When to Use LinkedHashSet:
        // - When you need a set (unique elements).
        // - When the order of elements (specifically, the insertion order) is important for iteration.
        // - When you need fast average-case performance for adding, removing, and checking for element existence.
        // - It's a good choice when you need the benefits of both a `Set` and ordered iteration.

        // 13. Comparison with HashSet and TreeSet:
        // - `HashSet`: Fastest for add/remove/contains, but no guaranteed order.
        // - `LinkedHashSet`: Good balance of speed (O(1) average) and guaranteed insertion order.
        // - `TreeSet`: Slower (O(log n)) but provides elements in a natural sorted order or custom comparator order.

        // Example of iteration order difference:
        /*
        System.out.println("\n--- Comparing Iteration Order ---");
        Set<String> regularHashSet = new HashSet<>();
        regularHashSet.add("Apple");
        regularHashSet.add("Banana");
        regularHashSet.add("Cherry");
        System.out.println("HashSet iteration:");
        for (String s : regularHashSet) {
            System.out.print(s + " "); // Order will vary
        }
        System.out.println();

        Set<String> orderedLinkedHashSet = new LinkedHashSet<>();
        orderedLinkedHashSet.add("Apple");
        orderedLinkedHashSet.add("Banana");
        orderedLinkedHashSet.add("Cherry");
        System.out.println("LinkedHashSet iteration:");
        for (String s : orderedLinkedHashSet) {
            System.out.print(s + " "); // Output: Apple Banana Cherry (guaranteed)
        }
        System.out.println();
        */
    }
}