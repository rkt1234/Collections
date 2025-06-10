import java.util.*;

// LearnArrayList class demonstrates the fundamental operations and properties of ArrayList in Java.
class LearnArrayList {
    public static void main(String[] args) {
        // 1. ArrayList is a class that implements the List interface.
        // 2. The List interface extends the Collection interface, providing methods for
        // ordered collections.
        // 3. ArrayList is a dynamic array, meaning its size can grow or shrink as
        // needed.
        // It's built on top of a regular array.

        // Creating an ArrayList of Integers.
        // The diamond operator (<>) infers the type from the left-hand side.
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Initial capacity of an ArrayList is 10.
        // When the number of elements exceeds the current capacity, the ArrayList
        // automatically resizes. The new capacity is typically (current_capacity * 3 /
        // 2) + 1.
        // The comment "// when an element is added in the list the size of the list
        // increases by (n/2)+1"
        // is not entirely accurate for the default resizing strategy. It's usually 1.5
        // times the current capacity.

        // Adding elements to the ArrayList using add() method.
        // Elements are added at the end of the list.
        arrayList.add(10); // Adds 10 at index 0
        arrayList.add(20); // Adds 20 at index 1
        arrayList.add(30); // Adds 30 at index 2

        // Printing the ArrayList. The toString() method of ArrayList is overridden
        // to provide a clear representation of its elements.
        System.out.println("ArrayList after initial additions: " + arrayList); // Output: [10, 20, 30]

        // Adding an element at a specific index.
        // This operation shifts existing elements to the right.
        // Computational complexity: O(n) because elements after the insertion point
        // need to be shifted.
        arrayList.add(1, 15); // Adds 15 at index 1, shifting 20 and 30 to the right.

        System.out.println("ArrayList after adding 15 at index 1: " + arrayList); // Output: [10, 15, 20, 30]

        // Demonstrating polymorphism: List interface reference pointing to an ArrayList
        // object.
        // This is good practice as it allows for more flexible code (e.g., easy
        // switching to LinkedList).
        List<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(-1);
        arrayList2.add(-2);
        arrayList2.add(-3);

        // Adding all elements from another collection to the current ArrayList.
        // Elements are appended to the end of the list.
        // Computational complexity: O(n) where n is the number of elements being added.
        arrayList.addAll(arrayList2);

        System.out.println("ArrayList after adding all elements from arrayList2: " + arrayList); // Output: [10, 15, 20,
                                                                                                 // 30, -1, -2, -3]

        // Accessing an element by its index using the get() method.
        // Computational complexity: O(1) as it's direct access to an array element.
        int ele = arrayList.get(0);
        System.out.println("Element at index 0: " + ele); // Output: 10

        // Removing an element at a specific index using the remove() method.
        // This operation shifts subsequent elements to the left.
        // Computational complexity: O(n) because elements after the removal point need
        // to be shifted.
        arrayList.remove(1); // Removes element at index 1 (which is 15)

        System.out.println("ArrayList after removing element at index 1: " + arrayList); // Output: [10, 20, 30, -1, -2,
                                                                                         // -3]

        // Removing a specific object from the ArrayList.
        // This method searches for the first occurrence of the specified element and
        // removes it.
        // It returns true if the element was found and removed, false otherwise.
        // For primitive types like 'int', you need to wrap them in their respective
        // wrapper classes
        // (e.g., Integer.valueOf(30)) to call the object removal method.
        // If you pass an 'int' directly, it will be interpreted as an index.
        // Computational complexity: O(n) in the worst case, as it might need to iterate
        // through the list.
        boolean removedNumber = arrayList.remove(Integer.valueOf(30)); // Removes the Integer object 30

        System.out.println("Was 30 removed? " + removedNumber); // Output: true
        System.out.println("ArrayList after removing Integer 30: " + arrayList); // Output: [10, 20, -1, -2, -3]

        // Replacing an element at a specific index using the set() method.
        // This operation overwrites the existing element at the given index.
        // Computational complexity: O(1) as it's direct array element assignment.
        arrayList.set(0, -100); // Replaces the element at index 0 with -100

        System.out.println("ArrayList after setting element at index 0 to -100: " + arrayList); // Output: [-100, 20,
                                                                                                // -1, -2, -3]

        // Checking if an element exists in the ArrayList using the contains() method.
        // Computational complexity: O(n) in the worst case, as it might need to iterate
        // through the entire list.
        boolean result = arrayList.contains(40);

        System.out.println("Does ArrayList contain 40? " + result); // Output: false

        // Iterating over the ArrayList using a traditional for loop.
        System.out.println("\nIterating using a traditional for loop:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        // Iterating over the ArrayList using an enhanced for-each loop (recommended for
        // readability).
        System.out.println("\nIterating using an enhanced for-each loop:");
        for (Integer elem : arrayList) {
            System.out.println(elem);
        }

        // Iterating over the ArrayList using an Iterator.
        // The Iterator provides a standard way to traverse elements in a collection.
        // It's particularly useful when you need to remove elements during iteration
        // (which is not safe with a for-each loop as it can lead to
        // ConcurrentModificationException).
        System.out.println("\nIterating using an Iterator:");
        Iterator<Integer> it = arrayList.iterator();
        // The print statement below will print the Iterator object itself, not its
        // content.
        // To see the content, you need to use the while loop and it.next().
        System.out.println("Iterator object: " + it);
        while (it.hasNext()) { // Checks if there are more elements
            // System.err.println is used here, which prints to the standard error stream.
            // Typically, System.out.println is used for normal output.
            System.out.println(it.next()); // Retrieves the next element and advances the iterator
        }

        // Clearing all elements from the ArrayList.
        // This makes the list empty.
        // Computational complexity: O(n) as it sets all elements to null for garbage
        // collection.
        // arrayList.clear();
        // System.out.println("ArrayList after clearing: " + arrayList); // Output: []
    }
}

/*
 * Computational complexities of common ArrayList operations:
 *
 * 1. Adding an element:
 * - `add(E e)` (at the end): Amortized O(1). While adding, if the capacity is
 * exceeded,
 * a new larger array is allocated and elements are copied, which is O(n).
 * However, most additions are O(1), leading to an amortized O(1) complexity.
 * - `add(int index, E element)` (at a specific index): O(n) because elements
 * from `index` to the end
 * need to be shifted to the right.
 *
 * 2. Removing an element:
 * - `remove(int index)` (at a specific index): O(n) because elements after the
 * removed position
 * need to be shifted to the left.
 * - `remove(Object o)` (by object): O(n) in the worst case as it involves
 * searching for the element,
 * and then shifting if found.
 *
 * 3. Getting an element:
 * - `get(int index)`: O(1) as it's direct array access.
 *
 * 4. Setting/Replacing an element:
 * - `set(int index, E element)`: O(1) as it's direct array element assignment.
 *
 * 5. Checking for an element existence:
 * - `contains(Object o)`: O(n) in the worst case as it might need to iterate
 * through the entire list
 * to find the element.
 *
 * 6. Iterating:
 * - Using `for` loop with `get(i)`: O(n) total, O(1) per access.
 * - Using enhanced `for-each` loop: O(n) total, O(1) per access (internally
 * uses an iterator).
 * - Using `Iterator`: O(n) total, O(1) per `next()` call.
 *
 * 7. `addAll(Collection<? extends E> c)`: O(n) where n is the number of
 * elements being added.
 *
 * 8. `clear()`: O(n) as it nullifies all elements for garbage collection.
 *
 * Additional Detail/Concepts:
 * - Backed by an Array: ArrayList uses a dynamically resizable array to store
 * its elements.
 * - Random Access: Due to its array-based implementation, ArrayList provides
 * fast random access to elements (O(1) for get and set).
 * - Not Synchronized: ArrayList is not thread-safe. If multiple threads access
 * an ArrayList concurrently and at least one of the threads modifies the list,
 * it must be synchronized externally. You can use
 * `Collections.synchronizedList(new ArrayList<...>)` for a synchronized
 * version.
 * - Fail-Fast Iterators: The iterators returned by ArrayList are "fail-fast."
 * This means that if the list is structurally modified at any time after the
 * iterator is created, in any way except through the iterator's own remove or
 * add methods, the iterator will immediately throw a
 * `ConcurrentModificationException`.
 * - Choosing between ArrayList and LinkedList:
 * - Use `ArrayList` when you need frequent random access to elements and fewer
 * insertions/deletions in the middle of the list.
 * - Use `LinkedList` when you need frequent insertions/deletions in the middle
 * of the list, but random access is less frequent.
 */