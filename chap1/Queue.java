import java.util.Iterator;
public class Queue<T> implements Iterable<T> {
    private Node first;//queue head
    private Node last;//queue tail
    private int N;
    private class Node {
        Node next;
        T val;
    }
    public boolean isEmpty() {
        return N == 0; // or first == null
    }
    public int size() {
        return N;
    }
    public void enqueue(T t) {
        Node oldLast = last;
        last = new Node();
        last.val = t;
        last.next = null;
        if(isEmpty()) first = last;
        else   oldLast.next = last;
        N++;
    }
    public T dequeue() {
        if(isEmpty()){
            throw new RuntimeException("empty queue!");
        }
        T t = first.val;
        first = first.next;
        if(isEmpty()) last = null;
        N--;
        return t;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public void remove() {

        }
        @Override
        public T next() { //return current and move current point to current.next
            T t = current.val;
            current = current.next;
            return t;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        // //test empty dequeue
        // queue.dequeue();
        //queue
        for(int i = 1; i < 11; i++) {
            queue.enqueue(i);
        }
        for(Integer i : queue) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 1; i < 6; i++) {
            System.out.println(queue.dequeue());
        }
        for(Integer i : queue) {
            System.out.print(i + " ");
        }
    }
}