import java.util.Iterator;
public class Stack<T> implements Iterable<T> {
    private Node first;
    private int N;
    private class Node {
        Node next;
        T val;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        return N;
    }
    public void push(T val) {
        Node oldFirst = first;
        first = new Node();
        first.val = val;
        first.next = oldFirst;
        N++;
    }
    public T pop() {
        T val = first.val;
        first = first.next;
        N--;
        return val;
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

        public void remove() {

        }

        public T next() { //return current and move current point to current.next
            T t = current.val;
            current = current.next;
            return t;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        //test push
        for(int i = 1; i < 11; i++) {
            stack.push(i);  
        }
        //test iterator
        for(Integer i: stack){
            System.out.print(i + " ");
        }
        //test pop
        System.out.println("\nstart pop:");
        for(int i = 0; i < 5; i++) {
            System.out.println(stack.pop());
        }System.out.println("end pop.");
        for(Integer i: stack){
            System.out.print(i + " ");
        }
    }  
}