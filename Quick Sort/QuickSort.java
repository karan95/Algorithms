class QuickSort {
    private QuickSort() {}
    public static void sort(Comparable[] a) {
        int n = a.length;
        sort(a, 0, n - 1);
    }
    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int j = partition(a, low, high);
        sort(a, low, j-1);
        sort(a, j+1, high);
    }
    // quicksort the subarray from a[lo] to a[hi]
    private static int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable v = a[low];
        while (true) {
            // find item on low to swap
            while (less(a[++i], v)) {
                if (i == high) break;
            }
            // find item on high to swap
            while (less(v, a[--j])) {
                if (j == low) break;
            }
            // check if pointer cross
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, low, j);
        return j;
    }
    private static boolean less(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }
    private static void exch(Object[] a, int i,int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args) {    
        String[] a = {"z","a","h","s","o"};
        QuickSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}