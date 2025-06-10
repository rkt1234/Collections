import java.util.ArrayDeque;

public class LearnArrayDequeue {
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        arrayDeque.offer(23);
        arrayDeque.offerFirst(12); // add in the first
        arrayDeque.offerLast(45); // add in the last

        System.out.println(arrayDeque);

        System.out.println(arrayDeque.peek()); // get the first element in the queue
        System.out.println(arrayDeque.peekFirst()); // get the first element in the queue
        System.out.println(arrayDeque.peekLast()); // get the last element in the queue

        System.out.println(arrayDeque.poll()); // pops out the first element
        System.out.println(arrayDeque.pollFirst()); // pops out the first element
        System.out.println(arrayDeque.pollLast()); // pops out the last element

        arrayDeque.offer(200);

        System.out.println(arrayDeque);
    }
}
