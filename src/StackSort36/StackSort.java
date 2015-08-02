package StackSort36;

import java.util.Stack;

/**
 * Created by M on 2015-07-23.
 */
public class StackSort<T extends Comparable<T>> {
    void SortAscending( Stack<T> stack){
        Stack<T> tmpStack = new Stack<T>();

        if( stack.isEmpty())
            return;

        T curr;
        boolean sorted = false;

        while( !sorted){
            curr = stack.peek();
            while (!stack.isEmpty() && stack.peek().compareTo(curr) <= 0) {
                curr = stack.peek();
                tmpStack.push(stack.pop());
            }
            if( stack.isEmpty()){
                sorted = true;
            }
            else{
                T tmp = stack.pop();
                while (!tmpStack.isEmpty() && tmp.compareTo(tmpStack.peek()) > 0 )
                    stack.push(tmpStack.pop());
                stack.push(tmp);
            }
        }
        while (!tmpStack.isEmpty())
            stack.push(tmpStack.pop());
    }
}
