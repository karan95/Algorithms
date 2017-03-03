class QuickUnion {
    private int[] quickUnionArray;
    public QuickUnion(int N) {
        quickUnionArray = new int[N];
        for(int i=0; i<N; i++) {
            quickUnionArray[i] = i;
        } 
    }
    private int root(int id) {
        while( id != quickUnionArray[id]) {
            id = quickUnionArray[id];
        }
        return id;
    }
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }
    public void union(int child,int parent) {
        int c = root(child);
        int p = root(parent);
        quickUnionArray[c] = p;
    }
    public static void main(String args[]) {
        QuickUnion instanceQuickUnion = new QuickUnion(10);
        instanceQuickUnion.union(1,2);
        instanceQuickUnion.union(2,3);
        instanceQuickUnion.union(1,5);
        System.out.println("check:"+instanceQuickUnion.isConnected(2,5));
        System.out.println("check:"+instanceQuickUnion.isConnected(1,9));
    }
}