public class FixedCapacityStackOfString<T> {
    private T[] a;
    private int N;
    public FixedCapacityStackOfString(int cap) {
        a = (T[])new Object[cap];
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    public void push(T s) {
        if(N == a.length) resize(2 * a.length);//if stack is full, resize it
        a[N++] = s;
    }
    public T pop() {
        T temp = a[--N];
        a[N] = null;
        return temp;
    }

    private void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for(int i = 0; i < a.length; i++){
            temp[i] = a[i];
        }
        a = temp;
        System.out.println("resized!");
    }

    public static void main(String[] args) {
        FixedCapacityStackOfString<String> f = new FixedCapacityStackOfString(20);
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