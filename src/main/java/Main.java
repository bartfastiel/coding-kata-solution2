import java.util.ArrayList;
import java.util.Arrays;

class Main {

    public static int LongestIncreasingSequence(int[] arr) {
        if (Arrays.stream(arr).anyMatch(i -> i < 0)) {
            throw new IllegalArgumentException("Only positive numbers allowed");
        }

        var thresholds = new int[arr.length];
        var length = 0;

        for (int i = 0; i < arr.length; i++) {
            var value = arr[i];
            if (length == 0 || thresholds[length-1] < value) {
                thresholds[length++] = value;
                continue;
            }
            for (int j = 0; j < length; j++) {
                if (value <= thresholds[j]) {
                    thresholds[j] = value;
                }
            }
        }

        return length;
    }
}