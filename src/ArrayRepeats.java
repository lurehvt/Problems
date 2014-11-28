import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Returns all values in array that occur more than once
 */
public class ArrayRepeats {
    public Integer[] Repeats(Integer[] array){
        HashMap<Integer, Integer> repeats = new HashMap<Integer, Integer>();
        ArrayList<Integer> repeatedItems = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            repeats.putIfAbsent(array[i], 0);
            repeats.put(array[i], repeats.get(array[i])+1);
        }

        for(Map.Entry<Integer,Integer> entry : repeats.entrySet()){
            if( entry.getValue() > 1){
                repeatedItems.add(entry.getKey());
            }
        }
        return repeatedItems.toArray(new Integer[repeatedItems.size()]);
    }
}
