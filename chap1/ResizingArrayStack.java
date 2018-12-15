import java.util.Iterator;

public class ResizingArrayStack<T> implements Iterable<T> {
    private T[] a;
    private int N;

    public ResizingArrayStack(int cap) {
        a = (T[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(T s) {
        if (N == a.length) resize(2 * a.length);//if stack is full, resize it
        a[N++] = s;
    }

    public T pop() {
        T temp = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return temp;
    }

    private void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        a = temp;
        System.out.println("resized!");
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }
        public static void main(String[] args) {
        ResizingArrayStack<String> f = new ResizingArrayStack(20);
        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if(!s.equals("-"))
                f.push(s);
            else if ( !f.isEmpty())
                StdOut.print(f.pop() + " ");
        }
        StdOut.println("(" + f.size() + " left on stack");

        for(int i = 1; i < 40; i++){
            f.push("" + i);
        }

    }
}
