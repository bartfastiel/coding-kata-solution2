import java.util.Arrays;

class Main {

    public static int LongestIncreasingSequence(int[] arr) {
        Arrays.stream(arr).forEach(i -> {
            if (i < 0) {
                throw new IllegalArgumentException("Only positive numbers allowed");
            }
        });
        return 0;
    }
}