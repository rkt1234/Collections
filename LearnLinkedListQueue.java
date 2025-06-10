import java.util.*; // Imports all classes from the java.util package, including Queue and LinkedList.

public class LearnLinkedListQueue {

    public static void main(String[] args) {
        // 1. Queue Interface and LinkedList Implementation:
        // The Queue interface represents a collection designed for holding elements
        // prior to processing.
        // It typically orders elements in a FIFO (First-In, First-Out) manner.
        // LinkedList is a common implementation of the Queue interface in Java.
        // It provides a doubly-linked list implementation, making it efficient for
        // adding and removing elements from both ends.
        LinkedList<Integer> queue = new LinkedList<>();

        // 2. Adding Elements to the Queue (offer() vs. add()):
        // offer(E e): Inserts the specified element into this queue if it is possible
        // to do so immediately
        // without violating capacity restrictions. Returns true on success, false if no
        // space is currently available.
        // This is generally preferred over add() for queues with capacity restrictions,
        // as it doesn't throw an exception.
        // add(E e): Inserts the specified element into this queue. Throws an
        // IllegalStateException if the queue is full.
        queue.offer(10); // Adds 10 to the back of the queue
        queue.offer(20); // Adds 20 to the back of the queue
        queue.offer(30); // Adds 30 to the back of the queue

        // Print the entire queue.
        // LinkedList's toString() method displays the elements in insertion order
        // (front to back), enclosed in square brackets.
        // Output: [10, 20, 30]
        System.out.println("Queue after offers: " + queue);

        // 3. Peeking at the Front Element (peek() vs. element()):
        // peek(): Retrieves, but does not remove, the head of this queue. Returns null
        // if this queue is empty.
        // This is generally preferred as it doesn't throw an exception if the queue is
        // empty.
        // element(): Retrieves, but does not remove, the head of this queue. Throws
        // NoSuchElementException if this queue is empty.
        int ele = queue.peek();
        System.out.println("Front element (peek): " + ele); // Output: Front element (peek): 10

        // 4. Removing Elements from the Queue (poll() vs. remove()):
        // poll(): Retrieves and removes the head of this queue. Returns null if this
        // queue is empty.
        // This is generally preferred as it doesn't throw an exception if the queue is
        // empty.
        // remove(): Retrieves and removes the head of this queue. Throws
        // NoSuchElementException if this queue is empty.
        queue.poll(); // Removes the element at the front of the queue (which is 10)

        // Print the queue after polling.
        // Output: [20, 30]
        System.out.println("Queue after poll: " + queue);

        // 5. Checking if the Queue is Empty:
        // isEmpty(): Returns true if this collection contains no elements.
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: Is queue empty? false

        // 6. Getting the Size of the Queue:
        // size(): Returns the number of elements in this collection.
        System.out.println("Size of queue: " + queue.size()); // Output: Size of queue: 2

        // Print the queue again to see its current state.
        // Output: [20, 30]
        System.out.println("Final queue state: " + queue);

        // --- Additional Concepts and Details for Revision ---

        // 7. FIFO (First-In, First-Out) Principle:
        // Queues follow the FIFO principle. The first element added to the queue is the
        // first one to be removed.
        // Think of a waiting line at a bank: the person who arrives first is served
        // first.

        // 8. Other Queue Implementations:
        // - ArrayDeque: Can be used as a queue (and a stack). It's generally more
        // efficient than LinkedList for many queue operations
        // when a fixed-size queue is not required, as it's array-backed and avoids the
        // overhead of linked nodes.
        // - PriorityQueue: A special type of queue where elements are ordered based on
        // their natural ordering or a custom Comparator.
        // Elements are removed based on priority, not necessarily FIFO.

        // Example using ArrayDeque as a Queue:
        /*
         * System.out.println("\n--- Using ArrayDeque as a Queue ---");
         * Queue<String> modernQueue = new ArrayDeque<>();
         * modernQueue.offer("Apple");
         * modernQueue.offer("Banana");
         * System.out.println("ArrayDeque queue: " + modernQueue); // Output: ArrayDeque
         * queue: [Apple, Banana]
         * System.out.println("Front with peek(): " + modernQueue.peek()); // Output:
         * Front with peek(): Apple
         * modernQueue.poll();
         * System.out.println("ArrayDeque after poll: " + modernQueue); // Output:
         * ArrayDeque after poll: [Banana]
         */

        // 9. Use Cases for Queues:
        // - Task scheduling and job processing (e.g., print spoolers, CPU scheduling)
        // - Breadth-First Search (BFS) algorithms in graph traversal
        // - Buffering data (e.g., I/O operations)
        // - Message queues in distributed systems
        // - Handling user input in applications (events queue)
    }
}