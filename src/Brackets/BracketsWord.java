package Brackets;

import java.util.*;

/**
 * Check if word is proper bracket expression
 */
public class BracketsWord {
    public static HashMap<Character, Character> brackets = new HashMap<Character, Character>(){
        {put('(',')');put('{','}');put('[',']');put('<','>');}
    };
    public static HashSet<Character> additionalLetters = new HashSet<Character>(){{add('a');add('b');}};

    public boolean IsBracketWord( String word){
        HashMap<Character, Character> closingBrackets = new HashMap<Character, Character>();
        //assuming unique values in brackets map
        for (Map.Entry entry : brackets.entrySet())
            closingBrackets.put((Character) entry.getValue(), (Character) entry.getKey());

        Stack<Character> notMatched = new Stack<Character>();
        for( char c : word.toCharArray()){
            if( closingBrackets.containsKey(c) || brackets.containsKey(c) || additionalLetters.contains(c) ){
                if( !notMatched.isEmpty() &&(
                        ( closingBrackets.containsKey(c) && closingBrackets.get(c) == notMatched.peek()) ||
                        (additionalLetters.contains(c) && notMatched.peek() == c)
                ))
                    notMatched.pop();
                else
                    notMatched.push(c);
            }
        }
        return notMatched.isEmpty();
    }
}
