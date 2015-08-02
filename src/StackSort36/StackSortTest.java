package StackSort36;

/**
 * Created by Magda on 2015-07-23.
 */


import java.util.Stack;

import static org.junit.Assert.*;

public class StackSortTest {
    @org.junit.Test
    public void testRepeats() throws Exception {
        StackSort stackSort = new StackSort();


            Stack<Integer>[][] testCases = new Stack[][]{
                    new Stack[]{new Stack(){{push(4);push(5);push(1);}}, new Stack(){{push(1);push(4);push(5);}} },
                    new Stack[]{new Stack(){{push(1);push(1);push(1);}}, new Stack(){{push(1);push(1);push(1);}} },
                    new Stack[]{new Stack(){{push(4);push(3);push(2);push(1);}}, new Stack(){{push(1);push(2);push(3);push(4);}} },
                    new Stack[]{new Stack(){}, new Stack(){ } },
                    new Stack[]{new Stack(){{push(1);}}, new Stack(){{push(1);}} },

            };


        for (Stack<Integer>[] testCase : testCases) {
            stackSort.SortAscending(testCase[0]);
            assertEquals(testCase[0], testCase[1]);
        }
    }
}
