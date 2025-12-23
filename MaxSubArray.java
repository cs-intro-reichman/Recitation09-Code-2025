public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums)); // Output: 6
    }
    public static int maxSubArray(int[] nums) {
        // create new array for memo
        int[] maxSub = new int[nums.length];
        // create fill the data with Integer.MIN_VALUE to not tamper with calculation 
        fillArray(maxSub, 0, Integer.MIN_VALUE);
        // base case 
        maxSub[0] = nums[0];
        // fill rest of memo array
        maxSubArrayHelper(nums, maxSub, 1);
        // find max in the memo array, Question 1
        return MaxValue.maxValue(maxSub);
    }

    private static void maxSubArrayHelper(int[] nums, int[] maxSub, int index) {
        // if the finished running, return
        if (nums.length == index) {
            return;
        }
        // calculating according to formula
        maxSub[index] = Math.max(maxSub[index - 1] + nums[index], nums[index]);

        // recursively calculating the rest of the array
        maxSubArrayHelper(nums, maxSub, index + 1);
    }

    private static void fillArray(int[] array, int start, int value) {
        for (int i = start; i < array.length; i++) {
            array[i] = value;
        }
    }

}
