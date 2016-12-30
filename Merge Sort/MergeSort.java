/**
* Merge Sort algorithm implementaion in java.
*
* @author  Karansinh Thakor
*/
class MergeSort {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("No argument supplied");
            System.exit(0);
        }
        String[] values = args[0].split(",");
        int[] unsortedValue = new int[values.length];
        for(int i=0; i < values.length; i++){
            unsortedValue[i] = Integer.parseInt(values[i]);
        }
        int[] sortedValue = mergeSort(unsortedValue);
        System.out.println("sortedValue " + sortedValue);
    }
    public static int[] mergeSort(int[] list) {
        if(list.length <= 1) {
            return list;
        }
        int[] firstHalf = new int[list.length / 2];
        int[] secondHalf = new int[list.length - firstHalf.length];
        System.arraycopy(list, 0, firstHalf, 0, firstHalf.length); 
        System.arraycopy(list, firstHalf.length, secondHalf, 0, secondHalf.length);
        mergeSort(firstHalf);
        mergeSort(secondHalf);
        merge(firstHalf, secondHalf, list);
        return list;
    }
    private static void merge(int[] firstHalf, int[]secondHalf, int[] result) {
        int iPart1 = 0;
        int iPart2 = 0;
        int j = 0;
        while (iPart1 < firstHalf.length && iPart2 < secondHalf.length) {
            if(firstHalf[iPart1] < secondHalf[iPart2]) {
                result[j] = firstHalf[iPart1];
                iPart1++;
            } else {
                result[j] = secondHalf[iPart2];
                iPart2++;
            }
            j++;
        }
        System.arraycopy(firstHalf, iPart1, result, j, firstHalf.length - iPart1);
        System.arraycopy(secondHalf, iPart2, result, j, secondHalf.length - iPart2); 
    }
}