import java.util.Arrays;
public class TwoSumFast {
    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StopWatch timer = new StopWatch();
        int cnt = count(a);
        double time = timer.elapsedTime();
        StdOut.println(cnt + " doubles " + time + " seconds ");
        StopWatch timer2 = new StopWatch();
        int cnt2 = ThreeSum.count(a);
        double time2 = timer2.elapsedTime();
        StdOut.println(cnt2 + " triples " + time2 + " seconds ");
    }
    public static int count(int[] a){
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            if(BinarySearch.rank(-a[i], a) > i)
                cnt++;
        }
        return cnt;
    }
}