import java.util.ArrayList;
import java.util.Arrays;

class Main {

    public static int LongestIncreasingSequence(int[] arr) {
        if (Arrays.stream(arr).anyMatch(i -> i < 0)) {
            throw new IllegalArgumentException("Only positive numbers allowed");
        }

        var listOfThresholds = new ArrayList<Integer>();

        iterateOverValues:
        for (int i = 0; i < arr.length; i++) {
            var value = arr[i];
            for (int j = 0; j < listOfThresholds.size(); j++) {
                if (value <= listOfThresholds.get(j)) {
                    listOfThresholds.set(j, value);
                    continue iterateOverValues;
                }
            }
            listOfThresholds.add(value);
        }

        return listOfThresholds.size();
    }
}