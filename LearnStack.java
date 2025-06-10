// 1. Stack is a class that implements the List interface
// The Stack class in Java is a legacy class that extends the Vector class and represents a LIFO (Last-In, First-Out) stack of objects.
// While it implements the List interface (indirectly through Vector), it's generally recommended to use Deque (specifically ArrayDeque)
// when you need a stack-like behavior for better performance and a more consistent API.

import java.util.Stack; // Import the Stack class from the java.util package

public class LearnStack {
    public static void main(String[] args) {
        // Create a new Stack of String objects named 'animal'.
        // The diamond operator <> infers the type, making the code more concise.
        Stack<String> animal = new Stack<>();

        // Add elements to the top of the stack using the push() method.
        // push() adds an item onto the top of this stack.
        animal.push("Cow");
        animal.push("Lion");
        animal.push("Dog");
        animal.push("Cat");

        // Print the entire stack.
        // When printing a Stack directly, it uses the toString() method inherited from
        // Vector,
        // which displays elements in insertion order (bottom to top), enclosed in
        // square brackets.
        // Output will be: [Cow, Lion, Dog, Cat]
        System.out.println(animal);

        // Peek at the top element of the stack without removing it.
        // peek() returns the object at the top of this stack without removing it from
        // the stack.
        // If the stack is empty, it throws EmptyStackException.
        String top = animal.peek();
        System.out.println("Top element: " + top); // Output: Top element: Cat

        // Remove the top element from the stack.
        // pop() removes the object at the top of this stack and returns that object as
        // the value of this function.
        // If the stack is empty, it throws EmptyStackException.
        animal.pop();
        // Print the stack after popping an element.
        // The 'Cat' element has been removed.
        // Using System.err.println for error stream output (though not strictly an
        // error here, often used for diagnostics).
        System.err.println("Stack after pop: " + animal); // Output: Stack after pop: [Cow, Lion, Dog]

        // Check if the stack is empty.
        // isEmpty() tests if this stack is empty. Returns true if the stack contains no
        // items.
        // Using System.err.println for error stream output.
        System.err.println("Is stack empty? " + animal.isEmpty()); // Output: Is stack empty? false

        // Get the number of elements in the stack.
        // size() returns the number of components in this stack.
        System.out.println("Size of stack: " + animal.size()); // Output: Size of stack: 3

        // --- Additional Concepts and Details for Revision ---

        // 2. LIFO (Last-In, First-Out) Principle:
        // Stacks operate on the LIFO principle. The last element added to the stack is
        // the first one to be removed.
        // Think of a stack of plates: you add new plates to the top, and when you take
        // a plate, you take it from the top.

        // 3. Common Stack Operations:
        // - push(E item): Adds an element to the top of the stack.
        // - pop(): Removes and returns the element at the top of the stack. Throws
        // EmptyStackException if empty.
        // - peek(): Returns the element at the top of the stack without removing it.
        // Throws EmptyStackException if empty.
        // - isEmpty(): Checks if the stack is empty.
        // - search(Object o): Returns the 1-based position where an object is on this
        // stack. Returns -1 if the object is not found.
        // (Note: search() is generally less used as it violates the LIFO principle of
        // direct access).

        // 4. Performance Considerations:
        // - push and pop operations on Stack (which extends Vector) are synchronized,
        // making them thread-safe but potentially
        // slower in single-threaded environments compared to non-synchronized
        // alternatives.
        // - For better performance in single-threaded scenarios, or when explicit
        // synchronization is handled externally,
        // it's often recommended to use `java.util.ArrayDeque` as a stack. ArrayDeque
        // is not thread-safe by default,
        // but it offers better performance for stack operations.

        // Example using ArrayDeque as a Stack (more modern approach):
        /*
         * System.out.println("\n--- Using ArrayDeque as a Stack ---");
         * Deque<String> modernAnimalStack = new ArrayDeque<>();
         * modernAnimalStack.push("Elephant"); // Equivalent to Stack's push
         * modernAnimalStack.push("Zebra");
         * System.out.println("ArrayDeque stack: " + modernAnimalStack); // Output:
         * ArrayDeque stack: [Zebra, Elephant] (Note: toString might show insertion
         * order)
         * System.out.println("Top with peek(): " + modernAnimalStack.peek()); //
         * Output: Top with peek(): Zebra
         * modernAnimalStack.pop(); // Equivalent to Stack's pop
         * System.out.println("ArrayDeque after pop: " + modernAnimalStack); // Output:
         * ArrayDeque after pop: [Elephant]
         */

        // 5. Use Cases for Stacks:
        // - Function call management (compiler uses a stack to manage function calls
        // and local variables)
        // - Undo/Redo mechanisms in applications
        // - Expression evaluation (e.g., converting infix to postfix, evaluating
        // postfix expressions)
        // - Backtracking algorithms
        // - Browser history (back button functionality)
    }
}