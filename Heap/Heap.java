class Heap {
    private Heap() { }
    public static void sort(Comparable[] pq) {
        int n = pq.length;
        for (int k = n/2; k >= 1; k--) {
            sink(pq, k, n);
        }
        while (n > 1) {
            exch(pq, 1, n--);
            sink(pq, 1, n);
        }
    }
    private static void sink(Comparable[] pq, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if(j < n && less(pq, j, j+1)) j++;
            if(!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }
    private static boolean less(Comparable[] a, int x, int y) {
        return a[x-1].compareTo(a[y-1]) < 0;
    }
    private static void exch(Comparable[] a, int x, int y) {
        Object temp = a[x-1];
        a[x-1] = a[y-1];
        a[y-1] = (Comparable) temp;
    }
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    public static void main(String args[]) {
        Integer[] a = {2,5,4,9,1}; 
        Heap.sort(a);    
        Heap.show(a);
    }
}