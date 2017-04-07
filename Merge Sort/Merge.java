class Merge {
    private Merge() {}
    private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }
        int i = low, j = mid+1;
        for (int k = low; k <= high; k++) {
            if      (i > mid)               a[k] = aux[j++];
            else if (j > high)              a[k] = aux[i++];
            else if (less(aux[j], aux[i]))  a[k] = aux[j++];
            else                            a[k] = aux[i++];
        } 
    }
    private static void sort(Comparable[] a, Comparable[] aux, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sort(a, aux, low, mid);
        sort(a, aux, mid + 1, high);
        merge(a, aux, low, mid, high);
    }
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }
    // check if a < b
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    public static void main(String args[]) {
        String[] a = {"f","v","b","n","r","d","l","c","p","o","u","z"};
        Merge.sort(a);
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}