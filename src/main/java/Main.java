import java.util.Arrays;

class Main {

    public static int LongestIncreasingSequence(int[] arr) {
        Arrays.stream(arr).forEach(i -> {
            if (i < 0) {
                throw new IllegalArgumentException("Only positive numbers allowed");
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] < arr[i-1]) {
                return i;
            }
        }
        return arr.length;
    }
}