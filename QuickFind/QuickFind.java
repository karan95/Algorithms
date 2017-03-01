class QuickFind {
    private int[] quickFindArray; 
    public QuickFind(int N) {
        quickFindArray = new int[N];
        for(int i=0; i < N; i++) {
            quickFindArray[i] = i;
        }
    }
    public boolean isConnected(int p, int q) {
        if(quickFindArray[p] == quickFindArray[q]) {
            return true;
        } else {
            return false;
        }
    }
    public void union(int indexP, int indexQ) {
        int valueP = quickFindArray[indexP];
        int valueQ = quickFindArray[indexQ];
        for(int i=0; i<quickFindArray.length; i++) {
           if(quickFindArray[i] == valueP) {
               quickFindArray[i] = valueQ;
           } 
        }
    }
    /* public static void main(String args[]) {
     *  QuickFind instance = new QuickFind(10);
     *  instance.union(1,5);
     *  System.out.println("flag:"+instance.isConnected(1,5));
     *  System.out.println("flag:"+instance.isConnected(2,5));
     *  instance.union(5,2);
     *  System.out.println("flag:"+instance.isConnected(1,2));
     * } 
    */
}