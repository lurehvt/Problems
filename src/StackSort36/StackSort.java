package StackSort36;

import java.util.Stack;

/**
 * Created by Magda on 2015-07-23.
 */
public class StackSort {
    void SortAscending( Stack<Integer> stack){
        Stack<Integer> tmpStack = new Stack<Integer>();

        if( stack.isEmpty())
            return;

        Integer curr;
        boolean sorted = false;

        while( !sorted){
            curr = stack.peek();
            while (!stack.isEmpty() && stack.peek() <= curr) {
                curr = stack.peek();
                tmpStack.push(stack.pop());
            }
            if( stack.isEmpty()){
                sorted = true;
            }
            else{
                Integer tmp = stack.pop();
                while (!tmpStack.isEmpty() && tmp > tmpStack.peek())
                    stack.push(tmpStack.pop());
                stack.push(tmp);
                while (!tmpStack.isEmpty())
                    stack.push(tmpStack.pop());
            }
        }
        while (!tmpStack.isEmpty())
            stack.push(tmpStack.pop());
    }
}
