import java.util.Comparator;

class SelectionSort {
    private SelectionSort() {}
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }
    public static void sort(Object[] a, Comparator comparator) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i; 
            for (int j = i + 1; j < n; j++) {
                if(less(comparator, a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    private static boolean less(Comparator comparator, Object a, Object b) {
        return comparator.compare(a, b) < 0;
    }
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }        
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    private static void exch(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args) {
        String[] val = {"itemc", "itemf","itemh","itemi","itema","iteml","itemv","itemu"};
        SelectionSort.sort(val);
        for (int i = 0; i < val.length; i++) {
            System.out.println(val[i]);
        }
    }
}