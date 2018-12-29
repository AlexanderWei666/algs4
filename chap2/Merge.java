public class Merge {
    private static Comparable[] aux;

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

}