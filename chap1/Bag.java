import java.util.Iterator;
public class Bag<T> implements Iterable<T> {
    private Node first;
    private class Node {
        T val;
        Node next;
    }
    public void add(T t) {
        Node oldfirst = first;
        first = new Node();
        first.val = t;
        first.next =oldfirst;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<T> {
        private Node current = first;

        @Override
        public boolean hasNext(){
            return current != null;
        }

        @Override
        public void remove(){}

        @Override
        public T next() {
            T t = current.val;
            current = current.next;
            return t;
        }
    }

    public static void main(String[] args) {
        Bag<Integer> bag = new Bag<>();
        for(int i = 1; i < 11; i++) {
            bag.add(i);
        }
        for(Integer i: bag) {
            System.out.print(i + " ");
        }
    }
}