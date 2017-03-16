class BinarySearch {
    private BinarySearch(){ }
    public static int indexOf(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        while(low <= high) {
            int mid = low + (high-low) / 2;
            if (key < a[mid]) high = mid - 1;
            else if (key > a[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }
    public static void main(String args[]) {
        int[] values = {1,2,3,4,5,6,7,8,9};
        int value1  = BinarySearch.indexOf(values,0);
        int value1  = BinarySearch.indexOf(values,1);
        System.out.println("check 1:"+value1);
        System.out.println("check 2:"+value1);
    }
}