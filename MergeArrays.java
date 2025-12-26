public class MergeArrays {

    public static void main(String[] args) {
        int [] arr1 = {1, 2, 6};
        int [] arr2 = {3, 4, 5, 6, 7, 8};
        int [] result = mergeArrays(arr1, arr2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
        System.out.println();
        
    }
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        // create a new array to store the merged elements
        int[] merged = new int[arr1.length + arr2.length];
        
        // merge the arrays
        mergeArrays(arr1, arr2, 0, 0, merged);
        
        // return the merged array
        return merged;
    }

    private static int[] mergeArrays(int[] arr1, int[] arr2, int index1, int index2, int[] merged) {
        // if one of the arrays is empty, copy the rest of the other array into merged
        if (index1 >= arr1.length) {
            copyArray(arr2, merged, index2, index1 + index2);
            return merged;
        }
        if (index2 >= arr2.length) {
            copyArray(arr1, merged, index1, index1 + index2);
            return merged;
        }
        // add the smaller element to the merged array
        if (arr1[index1] < arr2[index2]) {
            merged[index1 + index2] = arr1[index1];
            index1++;
        } else {
            merged[index1 + index2] = arr2[index2];
            index2++;
        }
        // recursively merge the rest of the arrays
        return mergeArrays(arr1, arr2, index1, index2, merged);
    }

    private static void copyArray(int[] arr1, int[] arr2, int index1, int index2) {
        // if finished copying, return
        if (index1 == arr1.length || index2 == arr2.length) {
            return;
        }
        
        // copy the value at the current index
        arr2[index2] = arr1[index1];
        
        // recursively copy the rest of the array
        copyArray(arr1, arr2, index1 + 1, index2 + 1);
    }
}
