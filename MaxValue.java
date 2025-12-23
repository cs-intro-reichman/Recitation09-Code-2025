public class MaxValue {

    public static int maxValue(int[] arr) {
        int maxIndex = maxValueHelper(arr, 0, 0);
        return arr[maxIndex];
    }

    private static int maxValueHelper(int[] arr, int curMaxIndex, int curIndex) {
        if (curIndex == arr.length) {
            return curMaxIndex;
        }
        if (arr[curMaxIndex] < arr[curIndex]) {
            return maxValueHelper(arr, curIndex, curIndex + 1);
        }
        return maxValueHelper(arr, curMaxIndex, curIndex + 1);
    }
}

