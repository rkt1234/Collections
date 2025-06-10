import java.util.Arrays; // Imports the Arrays utility class, which provides static methods for common array operations.

public class LearnArrayClass {
    public static void main(String[] args) {
        // 1. Declaring and Initializing an Array:
        // An array is a fixed-size data structure that holds a sequence of elements of the same type.
        // Here, 'numbers' is an array of integers.
        int numbers[] = {98, 67, 41, -1, 78, -2, 6};

        // 2. Sorting an Array (`Arrays.sort()`):
        // `Arrays.sort()` sorts the specified array into ascending numerical order.
        // For primitive types (like int, long, short, char, byte, float, double), it typically uses a Dual-Pivot Quicksort algorithm,
        // which offers O(n log(n)) performance on average. For objects, it uses Timsort.
        Arrays.sort(numbers); // After sorting, 'numbers' will be: [-2, -1, 6, 41, 67, 78, 98]

        // Accessing an element by index.
        // Arrays are 0-indexed, meaning the first element is at index 0, and the last element is at index `length - 1`.
        // In the sorted array `numbers`, the element at index 6 is the largest.
        System.out.println("Largest element after sorting: " + numbers[6]); // Output: 98

        // 3. Searching in a Sorted Array (`Arrays.binarySearch()`):
        // `Arrays.binarySearch(array, key)` searches the specified array for the specified value using the binary search algorithm.
        // IMPORTANT: The array MUST BE SORTED in ascending order prior to making this call. If it is not sorted,
        // the results are undefined and may be incorrect.
        // It returns the index of the search key, if it is contained in the array.
        // Otherwise, it returns `(-(insertion point) - 1)`. The "insertion point" is the index at which the key would be
        // inserted into the array to maintain sorted order.
        System.out.println("Index of 98 using binary search: " + Arrays.binarySearch(numbers, 98)); // Output: 6 (because 98 is at index 6)
        System.out.println("Index of 10 using binary search: " + Arrays.binarySearch(numbers, 10)); // Output: -4 (insertion point is 3, so -(3)-1 = -4)

        // 4. Filling an Array (`Arrays.fill()`):
        // `Arrays.fill(array, value)` assigns the specified `value` to each element of the specified array.
        int arr[] = {100, 200, 300}; // Original array: [100, 200, 300]
        Arrays.fill(arr, 100); // Fills all elements of 'arr' with the value 100.
        // After filling, 'arr' will be: [100, 100, 100]

        // 5. Iterating and Printing Array Elements:
        // A traditional for loop is used to iterate through the array elements and print them.
        System.out.println("Elements of arr after fill:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]); // Output: 100, 100, 100 (each on a new line)
        }

        // --- Additional Concepts and Details for Revision ---

        // 6. Converting Array to String (`Arrays.toString()`):
        // This method returns a string representation of the contents of the specified array.
        // The string representation consists of a list of the array's elements, enclosed in square brackets ("[]"),
        // with adjacent elements separated by the characters ", " (a comma followed by a space).
        System.out.println("\nString representation of numbers array: " + Arrays.toString(numbers)); // Output: [-2, -1, 6, 41, 67, 78, 98]

        // 7. Comparing Arrays (`Arrays.equals()`):
        // `Arrays.equals(array1, array2)` returns true if the two specified arrays are *deeply* equal to one another.
        // "Deeply equal" means that all corresponding pairs of elements in the two arrays are equal.
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {3, 2, 1};
        System.out.println("Are arr1 and arr2 equal? " + Arrays.equals(arr1, arr2)); // Output: true
        System.out.println("Are arr1 and arr3 equal? " + Arrays.equals(arr1, arr3)); // Output: false

        // 8. Copying Arrays (`Arrays.copyOf()` and `Arrays.copyOfRange()`):
        // `Arrays.copyOf(originalArray, newLength)` copies the specified array, truncating or padding with zeros (or nulls for objects)
        // if the new array is shorter or longer than the original.
        int[] original = {10, 20, 30, 40};
        int[] copiedArray = Arrays.copyOf(original, 2); // Copies first 2 elements: [10, 20]
        System.out.println("Copied array (length 2): " + Arrays.toString(copiedArray));

        int[] largerCopiedArray = Arrays.copyOf(original, 6); // Copies original, pads with 0s: [10, 20, 30, 40, 0, 0]
        System.out.println("Copied array (length 6): " + Arrays.toString(largerCopiedArray));

        // `Arrays.copyOfRange(originalArray, from, to)` copies a specified range of the specified array into a new array.
        // The range is inclusive of `from` and exclusive of `to`.
        int[] subArray = Arrays.copyOfRange(original, 1, 3); // Copies elements from index 1 up to (but not including) index 3: [20, 30]
        System.out.println("Sub-array from index 1 to 3: " + Arrays.toString(subArray));

        // 9. Array Declaration and Initialization Forms:
        // - `int[] myArray;` // Declaration only (recommended style for type)
        // - `int myArray[];` // Declaration only (C-style, legal but less common in Java)
        // - `int[] myArray = new int[5];` // Declaration and initialization with default values (0 for int)
        // - `int[] myArray = {1, 2, 3};` // Declaration and initialization with explicit values
        // - `int[] myArray = new int[]{1, 2, 3};` // Similar to above, but explicitly creating the array object

        // 10. Arrays vs. Collections (Lists, Sets, Maps):
        // - **Arrays**: Fixed size, direct memory access, good performance for sequential access and simple data.
        //   Less flexible for dynamic data manipulation (adding/removing elements after creation).
        // - **Collections (e.g., ArrayList, LinkedList, HashMap)**: Dynamic size, more overhead but greater flexibility.
        //   Provide rich APIs for adding, removing, searching, and manipulating data. Generally preferred for most
        //   application development where data size is not fixed.
        // `Arrays` class provides utility methods to bridge between primitive arrays and collections (e.g., `Arrays.asList()`).
    }
}