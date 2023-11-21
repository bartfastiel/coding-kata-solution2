import java.util.Arrays;

class Main {

    public static int LongestIncreasingSequence(int[] arr) {
        if (Arrays.stream(arr).anyMatch(i -> i < 0)) {
            throw new IllegalArgumentException("Only positive numbers allowed");
        }

        int[] thresholds = new int[arr.length];
        int length = 0;

        for (int value : arr) {
            if (length == 0 || thresholds[length - 1] < value) {
                thresholds[length++] = value;
                continue;
            }
            if (value < thresholds[0]) {
                thresholds[0] = value;
                continue;
            }
            useBinarySearchToLowerOneThreshold(thresholds, length, value);
        }

        return length;
    }

    private static void useBinarySearchToLowerOneThreshold(int[] thresholds, int length, int value) {
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (thresholds[middle] < value) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        thresholds[right] = value;
    }
}