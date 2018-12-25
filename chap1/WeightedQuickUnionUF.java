/**
额外维护一个N的数组，主要是针对quickUnion中，find深度进行优化
 */
public class WeightedQuickUnionUF {

    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        // while(p != id[p])
        //     p = id[p];
        // return p;

        //路径压缩的加权算法

        while(p != id[p]) {
            /*
            id[p]指向上上一个节点（若上一个节点是根节点，那么会循环依然指向根节点），结合union方法可以保证，
            第二次及以后的union，都会指向上上一个节点，从而保证都指向根节点相同
             */
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if(i == j) return;
        if(sz[i] < sz[j]) {
            id[i] = j;//小树指向大树
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count --;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}