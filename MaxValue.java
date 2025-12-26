public class MaxValue {

    public static void main(String[] args) {
        int [] arr = {5, 4, 6, 7, -10, 14, 3};
        System.out.println(maxValue(arr));
    }
    public static int maxValue(int[] arr) {
        int maxIndex = maxValueHelper(arr, 0, 0);
        return arr[maxIndex];
    }

    private static int maxValueHelper(int[] arr, int curMaxIndex, int curIndex) {
        System.out.println("curIndex: " + curIndex + " ,Max index: " + curMaxIndex);
        if (curIndex == arr.length) {
            return curMaxIndex;
        }
        if (arr[curMaxIndex] < arr[curIndex]) {
            return maxValueHelper(arr, curIndex, curIndex + 1);
        }
        return maxValueHelper(arr, curMaxIndex, curIndex + 1);
    }
}

