public class Selection {
    public static void sort(Comparable[] a) {
        //该方法交换次数过多，遍历一次只需找到最小的即可
        // for(int i = 0; i < a.length; i++) {
        //     for(int j = i + 1; j < a.length; j++) {
        //         if(less(a[j], a[i])) {
        //             exch(a, i, j);
        //         }
        //     }
        // }
        //下面方法只需要保存索引，每趟交换一次
        for(int i = 0; i < a.length; i++) {
            int min = i;
            for(int j = i; j < a.length; j++) {
                if(less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }
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

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}