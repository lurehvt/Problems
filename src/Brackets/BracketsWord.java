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

    public static HashMap<Character, List<Character>> bracketsExtended = new HashMap<Character, List<Character>>(){
        {
            put('(', Arrays.asList(')',']', '[') );
            put('{', Arrays.asList('>',']','(') );
            put('[', Arrays.asList(')','}') );
            put('<', Arrays.asList('>') );
        }
    };

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

    public boolean IsBracketWordExtended( String word){
        HashMap<Character, List<Character>> closingBrackets = new HashMap<Character, List<Character>>();
        //assuming unique values in brackets map
        for (Map.Entry<Character, List<Character>> entry : bracketsExtended.entrySet())
            for (Character end : entry.getValue()) {
                closingBrackets.putIfAbsent(end, Arrays.asList(entry.getKey()));
                closingBrackets.get(end).add(entry.getKey());
            }

        Stack<Character> notMatched = new Stack<Character>();
        char[] letters = word.toCharArray();

        return IsBracketWordExtended(letters, notMatched, closingBrackets);
    }

    private boolean IsBracketWordExtended(char[] letters, Stack<Character> notMatched, HashMap<Character, List<Character>> closingBrackets) {
        if( letters.length == 0 )
            return notMatched.isEmpty();
        //skip non brackets
        int i = 0;
        while(!IsBracketLetter( letters[i], closingBrackets) && i < letters.length) i++;
        if( i == letters.length) return notMatched.isEmpty();


        if( notMatched.isEmpty()){
            if( additionalLetters.contains(letters[i]) || bracketsExtended.containsKey(letters[i])){
                notMatched.push(letters[i]);
                return IsBracketWordExtended(Arrays.copyOfRange(letters, i+1, letters.length-1), notMatched, closingBrackets);
            }
            else return false; //closing bracket with no opening bracket to match
        }
        else{
            if( (additionalLetters.contains(letters[i]) && notMatched.peek() == letters[i])){
                notMatched.pop();
                return IsBracketWordExtended(Arrays.copyOfRange(letters, i+1, letters.length-1), notMatched, closingBrackets);
            }
            if( closingBrackets.containsKey(letters[i]) && closingBrackets.get(letters[i]).contains( notMatched.peek()) ) {
                if(!bracketsExtended.containsKey(letters[i])){
                    notMatched.pop();
                    return IsBracketWordExtended(Arrays.copyOfRange(letters, i+1, letters.length-1), notMatched, closingBrackets);
                }
                else{
                    //branch:
                    notMatched.push(letters[i]);
                    boolean openingBracketBranch =
                            IsBracketWordExtended(Arrays.copyOfRange(letters, i+1, letters.length-1), notMatched, closingBrackets);
                    if(openingBracketBranch) return true;
                    //closing bracket branch:
                    notMatched.pop();
                    return IsBracketWordExtended(Arrays.copyOfRange(letters, i+1, letters.length-1), notMatched, closingBrackets);

                }
            }
            else {
                //opening bracket, and not closing
                notMatched.push(letters[i]);
                return IsBracketWordExtended(Arrays.copyOfRange(letters, i+1, letters.length-1), notMatched, closingBrackets);
            }

        }
    }

    private boolean IsBracketLetter(char c, HashMap<Character, List<Character>> closingBrackets) {
        return closingBrackets.containsKey(c) || bracketsExtended.containsKey(c) || additionalLetters.contains(c);
    }
}
