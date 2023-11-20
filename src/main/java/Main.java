import java.util.Arrays;

class Main {

    public static int LongestIncreasingSequence(int[] arr) {
        if (Arrays.stream(arr).anyMatch(i -> i < 0)) {
            throw new IllegalArgumentException("Only positive numbers allowed");
        }

        return findLongestPossibleSequence(arr, 0, 0);
    }

    private static int findLongestPossibleSequence(int[] arr, int start, int minimum) {
        if (start >= arr.length) {
            return 0;
        }
        var value = arr[start];

        // what if we do not include this value?
        int lengthWithoutCurrentValue = findLongestPossibleSequence(arr, start + 1, minimum);

        // do we have to skip this value, because it is too small?
        if (value <= minimum) {
            return lengthWithoutCurrentValue;
        }

        int lengthIfWeChooseTheCurrentValue = findLongestPossibleSequence(arr, start + 1, value) + 1;
        return Math.max(
                lengthWithoutCurrentValue,
                lengthIfWeChooseTheCurrentValue
        );
    }
}