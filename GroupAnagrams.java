import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
class Solution {
    // create a map from a string to a list of strings
    // the key is a representation of a string that is the same for itself and all of its anagrams
    // the value is a reference to the list containing that string's anagrams
    //
    // iterate over every string
    //
    // iterate over every character to create a frequency array
    // add the current string to the list that its frequency array maps to
    //
    // return the values in the map
    public List<List<String>> groupAnagrams(String[] strings) {
        final Map<String, List<String>> map = new HashMap<>();
        for (String string: strings) {
            final char[] counter = new char[26];
            for (char c: string.toCharArray()) counter[c - 'a']++;
            String key = String.valueOf(counter);
            if (map.containsKey(key)) map.get(key).add(string);
            else map.put(key, new ArrayList<>() {{ add(string); }});
        }
        return new ArrayList<>(map.values());
    }
}