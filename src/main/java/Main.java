import java.util.Arrays;

class Main {

    public static int LongestIncreasingSequence(int[] arr) {
        if (Arrays.stream(arr).anyMatch(i -> i < 0)) {
            throw new IllegalArgumentException("Only positive numbers allowed");
        }

        var thresholds = new int[arr.length];
        var length = 0;

        for (int value : arr) {
            if (length == 0 || thresholds[length - 1] < value) {
                thresholds[length++] = value;
                continue;
            }
            if (thresholds[0] > value) {
                thresholds[0] = value;
                continue;
            }
            useBinarySearchToLowerOneThreshold(thresholds, length, value);
        }

        return length;
    }

    private static void useBinarySearchToLowerOneThreshold(int[] thresholds, int length, int value) {
        var left = 0;
        var right = length - 1;
        while (left < right) {
            var middle = (left + right) / 2;
            if (thresholds[middle] < value) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        thresholds[right] = value;
    }
}