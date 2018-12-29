public class Merge {
    private static Comparable[] aux;

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++){
            if(less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        //divide
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        //conquer
        merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        //copy old array
        for(int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        //merge
        for(int k = lo; k <= hi; k++) {
            if(i > mid) a[k] = aux[j++];//if all of the left array are merged, merge the rest right array
            else if (j > hi) a[k] = aux[i++];//if all of the right array are merged, merge the rest left array
            else if (less(aux[j], aux[i])) a[k] = aux[j++];//if aux[i] > aux[j] merge first of the right array
            else a[k] = aux[i++];//if aux[i] < aux[j] merge first of the left array
        }
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }

}