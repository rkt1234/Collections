import java.util.*; // Imports all classes from the java.util package, including Set and TreeSet.

// 1. It implements the Set interface
// The `Set` interface in Java represents a collection that does not allow duplicate elements.
// It models the mathematical concept of a set.

// 2. It orders the elements.
// This is the primary characteristic of `TreeSet`. Elements are stored in a sorted order.
// By default, it uses the natural ordering of the elements (e.g., ascending for numbers, alphabetical for strings).
// You can also provide a custom `Comparator` at the time of `TreeSet` creation to define a different sorting logic.

// 3. Elements are not indexed.
// Similar to `HashSet` and `LinkedHashSet`, you cannot access elements by an integer index (like `get(0)`)
// because `TreeSet` is a set, not a list, and it doesn't provide random access.
public class LearnTreeSet {
    public static void main(String[] args) {
        // Create a new TreeSet of Integer objects.
        // `TreeSet` internally uses a `TreeMap` to store its elements. Each element added to the `TreeSet`
        // is stored as a key in the internal `TreeMap`, with a dummy value.
        // The `TreeMap` is implemented as a Red-Black tree, which ensures elements are always kept in sorted order.
        Set<Integer> hashSet = new TreeSet<>(); // Renamed 'hashSet' to 'treeSet' for clarity in a real scenario.
                                              // For this example, keeping 'hashSet' as per user's code.

        // 4. Adding Elements to TreeSet:
        // The `add()` method attempts to add the specified element to this set.
        // It returns `true` if the set did not already contain the specified element, `false` otherwise.
        // Duplicate elements are not added.
        // As elements are added, the TreeSet automatically places them in their sorted position.
        hashSet.add(32); // Set: {32}
        hashSet.add(2);  // Set: {2, 32} (2 comes before 32)
        hashSet.add(54); // Set: {2, 32, 54}
        hashSet.add(21); // Set: {2, 21, 32, 54} (21 comes between 2 and 32)
        hashSet.add(65); // Set: {2, 21, 32, 54, 65}
        hashSet.add(2);  // This will not be added as '2' is already present. `add()` returns false.

        // Print the `TreeSet`.
        // The `toString()` method of `TreeSet` prints the elements in their natural sorted order.
        // Output: [2, 21, 32, 54, 65]
        System.out.println("TreeSet after additions (sorted): " + hashSet);

        // 5. Removing Elements from TreeSet:
        // The `remove()` method removes the specified element from this set if it is present.
        // It returns `true` if the set contained the specified element, `false` otherwise.
        // Removal maintains the sorted order of the remaining elements.
        hashSet.remove(54); // Removes 54 from the set.

        // Print the `TreeSet` after removal. The sorted order of remaining elements is preserved.
        // Output: [2, 21, 32, 65]
        System.out.println("TreeSet after removing 54: " + hashSet);

        // 6. Checking for Element Presence:
        // The `contains()` method returns `true` if this set contains the specified element, `false` otherwise.
        System.out.println("Does TreeSet contain 100? " + hashSet.contains(100)); // Output: false
        System.out.println("Does TreeSet contain 2? " + hashSet.contains(2));     // Output: true

        // 7. Checking if TreeSet is Empty:
        // The `isEmpty()` method returns `true` if this set contains no elements, `false` otherwise.
        System.out.println("Is TreeSet empty? " + hashSet.isEmpty()); // Output: false

        // 8. Getting the Size of TreeSet:
        // The `size()` method returns the number of elements in this set (its cardinality).
        System.out.println("Size of TreeSet: " + hashSet.size()); // Output will be 4 (original 5 - 1 removed)

        // 9. Clearing the TreeSet:
        // The `clear()` method removes all of the elements from this set. The set will be empty after this call returns.
        hashSet.clear();

        // Iterating over the hashSet
        Iterator<Integer> it = hashSet.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        // Print the size after clearing.
        System.out.println("Size of TreeSet after clear: " + hashSet.size()); // Output: 0
        System.out.println("TreeSet after clear: " + hashSet); // Output: [] (empty set representation)

        // --- Additional Concepts and Details for Revision ---

        // 10. Natural Ordering vs. Custom Comparator:
        // For `TreeSet` to work, the elements must be comparable.
        // - **Natural Ordering**: If elements implement the `Comparable` interface (like `Integer`, `String`, etc.),
        //   `TreeSet` uses their `compareTo()` method for sorting.
        // - **Custom Comparator**: If elements don't have a natural ordering or you want a different order,
        //   you can provide a `Comparator` object to the `TreeSet` constructor.
        /*
        // Example with a custom Comparator (e.g., sorting in descending order)
        System.out.println("\n--- TreeSet with Custom Comparator (Descending) ---");
        Set<Integer> descendingTreeSet = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1); // o2 first for descending order
            }
        });
        descendingTreeSet.add(32);
        descendingTreeSet.add(2);
        descendingTreeSet.add(54);
        descendingTreeSet.add(21);
        descendingTreeSet.add(65);
        System.out.println("Descending TreeSet: " + descendingTreeSet); // Output: [65, 54, 32, 21, 2]
        */

        // 11. Performance of TreeSet:
        // - All basic operations (`add()`, `remove()`, `contains()`) have a time complexity of **O(log n)**.
        //   This is because `TreeSet` is backed by a Red-Black tree, and tree operations are logarithmic.
        // - Iteration over `TreeSet` is also O(n) but the elements are returned in sorted order.

        // 12. When to Use TreeSet:
        // - When you need a set (unique elements).
        // - When you need the elements to be stored and retrieved in a sorted order.
        // - When you need operations like finding elements greater than/less than a given value (via `NavigableSet` methods).

        // 13. NavigableSet and SortedSet Interfaces:
        // `TreeSet` implements `NavigableSet`, which extends `SortedSet`. These interfaces provide additional methods
        // for navigating the set based on its sorted order:
        // - `first()`: Returns the first (lowest) element.
        // - `last()`: Returns the last (highest) element.
        // - `lower(E e)`: Returns the greatest element strictly less than `e`.
        // - `floor(E e)`: Returns the greatest element less than or equal to `e`.
        // - `higher(E e)`: Returns the least element strictly greater than `e`.
        // - `ceiling(E e)`: Returns the least element greater than or equal to `e`.
        // - `pollFirst()`: Retrieves and removes the first (lowest) element.
        // - `pollLast()`: Retrieves and removes the last (highest) element.
        // - `subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)`: Returns a view of the portion of this set whose elements range from `fromElement` to `toElement`.

        /*
        System.out.println("\n--- NavigableSet Methods ---");
        TreeSet<Integer> sortedNumbers = new TreeSet<>(Arrays.asList(10, 5, 20, 15, 25));
        System.out.println("Original TreeSet: " + sortedNumbers); // Output: [5, 10, 15, 20, 25]
        System.out.println("First element: " + sortedNumbers.first());   // Output: 5
        System.out.println("Last element: " + sortedNumbers.last());    // Output: 25
        System.out.println("Floor of 17: " + sortedNumbers.floor(17)); // Output: 15 (greatest <= 17)
        System.out.println("Ceiling of 17: " + sortedNumbers.ceiling(17)); // Output: 20 (least >= 17)
        System.out.println("Polling first: " + sortedNumbers.pollFirst()); // Output: 5, set becomes [10, 15, 20, 25]
        System.out.println("SubSet (10 inclusive to 20 exclusive): " + sortedNumbers.subSet(10, true, 20, false)); // Output: [10, 15]
        */
    }
}