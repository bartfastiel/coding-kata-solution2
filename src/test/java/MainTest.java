import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void expect0_whenUsingEmptyArray() {
        var actual = Main.LongestIncreasingSequence(new int[0]);
        Assertions.assertEquals(0, actual);
    }

}