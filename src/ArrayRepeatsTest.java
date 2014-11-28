import static org.junit.Assert.*;

public class ArrayRepeatsTest {

    @org.junit.Test
    public void testRepeats() throws Exception {
        ArrayRepeats arrayRepeats = new ArrayRepeats();
        Integer[][][] testCases = new Integer[][][]{
                new Integer[][]{ new Integer[]{5, 2, 3, 2, 2 }, new Integer[]{2} },
                new Integer[][]{ new Integer[]{5, 2, 3, 1, 0 }, new Integer[]{} },
                new Integer[][]{ new Integer[]{}, new Integer[]{} },
                new Integer[][]{ new Integer[]{1, 1, 2, 2, 2, 2, 3, 2,5,3,4 }, new Integer[]{1,2,3} },
                new Integer[][]{ new Integer[]{1  }, new Integer[]{} },
        };

        for (Integer[][] testCase : testCases) {
            assertEquals("For array " + testCase[0].toString() + " expected output" + testCase[1].toString(), testCase[1], arrayRepeats.Repeats(testCase[0]));
        }
    }
}