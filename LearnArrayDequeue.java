import java.util.ArrayDeque; // Imports the ArrayDeque class from the java.util package.

public class LearnArrayDequeue {
    public static void main(String[] args) {
        // 1. ArrayDeque: A Resizable-Array Implementation of the Deque Interface
        // ArrayDeque is a double-ended queue (Deque) implementation that can be used as both a queue (FIFO) and a stack (LIFO).
        // It provides efficient operations for adding and removing elements from both ends (front and back).
        // ArrayDeque is generally preferred over Stack and LinkedList for most queue and stack use cases due to its performance benefits.
        // It's not thread-safe; if multiple threads access an ArrayDeque concurrently, it must be synchronized externally.
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        // 2. Adding Elements to ArrayDeque:
        // ArrayDeque offers a rich set of methods for adding elements to either end.

        // offer(E e): Inserts the specified element at the tail of this deque. Equivalent to offerLast(e).
        // Returns true on success, false if no space is currently available (relevant for capacity-constrained deques, not ArrayDeque).
        arrayDeque.offer(23); // Adds 23 to the end: [23]

        // offerFirst(E e): Inserts the specified element at the front of this deque.
        arrayDeque.offerFirst(12); // Adds 12 to the front: [12, 23]

        // offerLast(E e): Inserts the specified element at the end of this deque. Equivalent to offer(e).
        arrayDeque.offerLast(45); // Adds 45 to the end: [12, 23, 45]

        // Print the ArrayDeque.
        // ArrayDeque's toString() method displays elements in insertion order (front to back).
        System.out.println("ArrayDeque after offers: " + arrayDeque); // Output: [12, 23, 45]

        // 3. Peeking at Elements in ArrayDeque (Retrieving without Removal):
        // These methods retrieve the element but do not remove it.

        // peek(): Retrieves, but does not remove, the head of the queue represented by this deque. Equivalent to peekFirst().
        // Returns null if the deque is empty.
        System.out.println("Peek (front): " + arrayDeque.peek()); // Output: 12

        // peekFirst(): Retrieves, but does not remove, the first element of this deque. Returns null if this deque is empty.
        System.out.println("Peek First: " + arrayDeque.peekFirst()); // Output: 12

        // peekLast(): Retrieves, but does not remove, the last element of this deque. Returns null if this deque is empty.
        System.out.println("Peek Last: " + arrayDeque.peekLast()); // Output: 45

        // 4. Removing Elements from ArrayDeque:
        // These methods retrieve and remove the element.

        // poll(): Retrieves and removes the head of the queue represented by this deque. Equivalent to pollFirst().
        // Returns null if the deque is empty.
        System.out.println("Poll (front): " + arrayDeque.poll()); // Removes and returns 12. Deque: [23, 45]

        // pollFirst(): Retrieves and removes the first element of this deque. Returns null if this deque is empty.
        System.out.println("Poll First: " + arrayDeque.pollFirst()); // Removes and returns 23. Deque: [45]

        // pollLast(): Retrieves and removes the last element of this deque. Returns null if this deque is empty.
        System.out.println("Poll Last: " + arrayDeque.pollLast()); // Removes and returns 45. Deque: []

        // After all poll operations, the ArrayDeque is empty.
        System.out.println("ArrayDeque after all polls: " + arrayDeque); // Output: []

        // Adding an element to an empty ArrayDeque.
        arrayDeque.offer(200); // Adds 200 to the end: [200]

        System.out.println("ArrayDeque after adding 200: " + arrayDeque); // Output: [200]

        // --- Additional Concepts and Details for Revision ---

        // 5. ArrayDeque as a Queue (FIFO - First-In, First-Out):
        // When using ArrayDeque as a queue, common methods are:
        // - offer(E e) or offerLast(E e): To add elements to the tail (enqueue).
        // - poll() or pollFirst(): To remove elements from the head (dequeue).
        // - peek() or peekFirst(): To inspect the head element.
        // - isEmpty(): To check if the queue is empty.
        // This is the recommended way to implement a queue in Java for most cases.

        // 6. ArrayDeque as a Stack (LIFO - Last-In, First-Out):
        // When using ArrayDeque as a stack, common methods are:
        // - push(E e) or offerFirst(E e): To add elements to the front (push onto stack).
        // - pop() or pollFirst(): To remove elements from the front (pop from stack).
        // - peek() or peekFirst(): To inspect the top element of the stack.
        // - isEmpty(): To check if the stack is empty.
        // This is the recommended way to implement a stack in Java, replacing the legacy `java.util.Stack`.

        // 7. Exception-Throwing vs. Null/Boolean Returning Methods:
        // ArrayDeque provides two sets of methods for similar operations:
        // - Methods that throw exceptions (e.g., `add()`, `remove()`, `element()`, `push()`, `pop()`):
        //   These methods throw `IllegalStateException` or `NoSuchElementException` if the operation cannot be performed.
        //   They are generally used when the failure to perform the operation is considered an error condition.
        // - Methods that return `null` or `boolean` (e.g., `offer()`, `poll()`, `peek()`):
        //   These methods return `null` or `false` if the operation cannot be performed, indicating success or failure without throwing an exception.
        //   They are generally preferred in typical application code where you might need to gracefully handle situations like an empty queue/stack.

        // For example:
        // arrayDeque.add(50); // Throws IllegalStateException if full (not applicable for unbounded ArrayDeque normally)
        // arrayDeque.remove(); // Throws NoSuchElementException if empty
        // arrayDeque.element(); // Throws NoSuchElementException if empty
        // arrayDeque.push(60); // Adds to front, similar to offerFirst, but throws IllegalStateException if capacity constrained (rare for ArrayDeque)
        // arrayDeque.pop(); // Removes from front, similar to pollFirst, but throws NoSuchElementException if empty

        // 8. Internal Implementation:
        // ArrayDeque uses a resizable array internally. When the array is full, it automatically resizes by allocating a larger array and copying elements.
        // This makes it efficient for both adding and removing elements from either end (amortized constant time for most operations).
    }
}