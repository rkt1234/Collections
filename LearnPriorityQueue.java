
// Import the PriorityQueue class from java.util package
import java.util.PriorityQueue;

// Class to demonstrate the usage of PriorityQueue in Java
public class LearnPriorityQueue {
    public static void main(String[] args) {
        // Create a PriorityQueue to store Integer elements
        // By default, PriorityQueue implements a min-heap, where the smallest element
        // has the highest priority
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Add elements to the PriorityQueue using offer() method
        // offer() adds the element to the queue while maintaining the heap property
        priorityQueue.offer(40); // Adds 40 to the queue
        priorityQueue.offer(12); // Adds 12, which becomes the smallest element
        priorityQueue.offer(24); // Adds 24
        priorityQueue.offer(36); // Adds 36

        // Print the entire PriorityQueue
        // Note: The output may not reflect the exact order of elements as stored
        // internally
        // The internal structure is a heap, but toString() may show elements in a
        // different order
        System.out.println("PriorityQueue contents: " + priorityQueue);

        // Peek at the head of the queue (smallest element) without removing it
        // peek() returns null if the queue is empty
        System.out.println("Head element (peek): " + priorityQueue.peek());

        // Remove and return the head of the queue (smallest element) using poll()
        // poll() returns null if the queue is empty
        System.out.println("Removed element (poll): " + priorityQueue.poll()); // Removes and returns 12 (smallest)

        // Remove and return the next smallest element
        System.out.println("Removed element (poll): " + priorityQueue.poll()); // Removes and returns 24

        // Additional Note:
        // PriorityQueue is not sorted in the traditional sense; it maintains a heap
        // structure
        // Elements are organized to ensure the smallest (for min-heap) or largest (for
        // max-heap) is at the head
        // To create a max-heap, use PriorityQueue<>(Collections.reverseOrder())
        // Example: PriorityQueue<Integer> maxHeap = new
        // PriorityQueue<>(Collections.reverseOrder());
    }
}