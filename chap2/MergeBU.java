public class MergeBU {
    private Comparable[] aux;

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz)
            for (int lo = 0; lo < N - sz; lo += sz + sz)
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
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