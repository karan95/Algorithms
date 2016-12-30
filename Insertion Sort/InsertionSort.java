/**
* Inseriton Sort algorithm implementaion in java.
*
* @author  Karansinh Thakor
*/
class InsertionSort {
    public static void main(String[] args){
        if(args.length == 0) {
            System.out.println("No argument supplied");
            System.exit(0);
        }
        String[] values = args[0].split(",");
        int[] unsortedValue = new int[values.length];
        for(int i=0; i < values.length; i++){
            unsortedValue[i] = Integer.parseInt(values[i]);
        }
        int[] sortedValue = getSortedValue(unsortedValue);
        System.out.println("sortedValue " + sortedValue);
    }
    public static int[] getSortedValue(int[] values) {
        int[] sortedValue = values; 
        for(int j=1; j < sortedValue.length; j++) {
            int key = sortedValue[j];
            int i = j-1;
            while ( (i > -1) && sortedValue[i] > key) {
                sortedValue[i+1] = sortedValue[i];
                i--;
            }
            sortedValue[i+1] = key;
        }
        return sortedValue;
    }
}
