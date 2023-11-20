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

}