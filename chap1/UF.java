public class UF {
    private int[] id;
    private int count;

    public UF(int N) {
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        // return this.quickFind(p);
        return this.quickUnionFind(p);
    }

    public void union(int p, int q) {
        // this.quickFindUnion(p, q);
        this.quickUnion(p, q);
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }

    private int quickFind(int p) {
        return id[p];
    }

    private void quickFindUnion(int p, int q) {
        int pID = quickFind(p);
        int qID = quickFind(q);

        if(pID == qID) return;

        for(int i = 0; i < id.length; i++) {
            if(id[i] == pID) id[i] = qID;
        }
        count--;
    }
//quickunion中，id数组索引为每个节点，数组值为每个节点的父节点，根节点的父节点为本身
    private int quickUnionFind(int p) {
        while (p != id[p]) p = id[p];//p != id[p]说明该节点不是根节点，然后将该节点的上层节点的索引赋值给p，直到找到根节点为止，并返回根节点的索引
        return p;
    }

    private void quickUnion(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;//同根节点即为连通的
        
        id[pRoot] = qRoot;//根节点不同，归并两棵树

        count--;
    }
}