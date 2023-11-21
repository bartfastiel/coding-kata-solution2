import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.util.Arrays.stream;

class MainTest {

    @Test
    void expectException_whenUsingNegatives() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Main.LongestIncreasingSequence(new int[]{-1});
        });
    }

    @ParameterizedTest
    @CsvSource(value = {
            "=0",
            "1=1",
            "999=1",
            "1,2=2",
            "2,1=1",
            "1,2,1=2",
            "1,3,2,3=3",
            "9,9,4,2=1",
    }, delimiter = '=')
    void check(String input, int expected) {
        int[] data;
        if (input == null) {
            data = new int[0];
        } else {
            data = stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        }
        var actual = Main.LongestIncreasingSequence(data);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void performanceTest() {
        long startTime = System.currentTimeMillis();
        int[] input = new int[10_000];
        for (int i = 0; i < input.length; i++) {
            input[i] = i;
        }
        Main.LongestIncreasingSequence(input);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Duration: " + duration + "ms");
    }

}