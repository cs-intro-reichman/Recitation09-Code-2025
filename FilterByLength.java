public class FilterByLength {

    public static String[] filterByLength(String[] arr, int minLen) { 
        int count = filterByLengthCounter(arr, minLen, 0);
        String[] filteredArray = new String[count];
        filteredArray = filterByLengthHelper(arr, filteredArray, minLen, 0, 0);
        return filteredArray;
    }

    private static int filterByLengthCounter(String[] arr, int minLen, int index) {
        if (arr.length == index) {
            return 0;
        }
        int isInLength = (arr[index].length() >= minLen) ? 1 : 0;
        return isInLength + filterByLengthCounter(arr, minLen, index + 1);
    }

    private static String[] filterByLengthHelper(String[] arr, String[] filtered,
        int minLen, int originalArrIndex, int newArrIndex) {
        if (arr.length == originalArrIndex) {
            return filtered;
        }

        if (arr[originalArrIndex].length() >= minLen) {
            filtered[newArrIndex] = arr[originalArrIndex];
            newArrIndex++;
        }
        return filterByLengthHelper(arr, filtered, minLen, originalArrIndex + 1, newArrIndex);
    }
}
