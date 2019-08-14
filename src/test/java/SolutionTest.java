import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {
    private int[] input;
    private int expected;
    private Solution soln = new Solution1();

    public SolutionTest(int[] input, int output) {
        this.input = input;
        this.expected = output;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
//                {new int[]{1,2,0}, 3},
//                {new int[]{3,4,-1,1}, 2},
//                {new int[]{7,8,9,11,12}, 1},
//                {new int[]{2,1}, 3},
//                {new int[]{}, 1},
                {new int[]{-1,4,2,1,9,10}, 3}
        });
    }

    @Test
    public void testFunction() {
        assertEquals(expected, soln.firstMissingPositive(input));
    }
}