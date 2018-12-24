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
        return this.quickFind(p);
    }

    public void union(int p, int q) {
        this.quickFindUnion(p, q);
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
}