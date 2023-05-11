package Arrays;

public class ElementNotSmallerToNeighbours {

    /**
     *
     * Approach:
     *      If array is sorted in increasing order than last element is peek.
     *      If array is sorted in decreasing order than first element is peek.
     * Native Approach:
     *     1. If the first element is greater than the second or the last element is greater than the second last, print the respective element and terminate the program.
     *     2. Else traverse the array from the second index to the second last index i.e. 1 to N – 1
     *     3. If for an element array[i] is greater than both its neighbors, i.e., array[i] > =array[i-1]  and array[i] > =array[i+1] , then print that element and terminate.
     */

    public static int peekIndex(int[] array){
        if (array.length==1) return 0;
        if(array[0]>=array[1]) return 1;
        if (array[array.length-1]>array[array.length-2]) return 1;
        for (int i=1 ; i<array.length-1 ; i++){
            if (array[i]>=array[i+1] && array[i]>=array[i-1]) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {4,5,10,7,8,2,1};
        System.out.println(peekIndex(array));
    }
}
