import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

import static java.lang.Integer.MAX_VALUE;
import static java.util.Arrays.stream;

class MainTest {

    public static final int PERFORMANCE_TEST_AMOUNT_OF_NUMBERS = 10_000_000;

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
            "1,3,2=2",
            "10,22,9,33,21,50,41,60,22,68,90=7",
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
    void performanceTest_increasingNumbers() {
        int[] input = new int[PERFORMANCE_TEST_AMOUNT_OF_NUMBERS];
        for (int i = 0; i < input.length; i++) {
            input[i] = i;
        }
        long startTime = System.currentTimeMillis();
        Main.LongestIncreasingSequence(input);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Duration: " + duration + "ms");
    }

    @Test
    void performanceTest_decreasingNumbers() {
        int[] input = new int[PERFORMANCE_TEST_AMOUNT_OF_NUMBERS];
        for (int i = 0; i < input.length; i++) {
            input[i] = PERFORMANCE_TEST_AMOUNT_OF_NUMBERS - i;
        }
        long startTime = System.currentTimeMillis();
        Main.LongestIncreasingSequence(input);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Duration: " + duration + "ms");
    }

    @Test
    void performanceTest_randomNumbers() {
        Random random = new Random(42);
        int[] input = new int[PERFORMANCE_TEST_AMOUNT_OF_NUMBERS];
        for (int i = 0; i < input.length; i++) {
            input[i] = random.nextInt(MAX_VALUE);
        }
        long startTime = System.currentTimeMillis();
        Main.LongestIncreasingSequence(input);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Duration: " + duration + "ms");
    }

}