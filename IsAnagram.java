import java.util.HashMap;

@SuppressWarnings("unused")
class IsAnagram {
    // if the two strings are of different lengths, return false
    //
    // create a mapping from character to integer to count the number of each character in s
    // populate the map via iterating over s
    // check what value each character of t maps to
    // decrement this value
    // if the value is negative, return false
    //
    // return true
    public boolean isAnagram(String s, String t) {
        final int length = s.length();
        if (length != t.length()) return false;
        final HashMap<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < length; i++) {
            final char c = s.charAt(i);
            final int count = counter.getOrDefault(c, 0) + 1;
            counter.put(c, count);
        }
        for (int i = 0; i < length; i++) {
            final char c = t.charAt(i);
            final int count = counter.getOrDefault(c, 0) - 1;
            if (count < 0) return false;
            counter.put(c, count);
        }
        return true;
    }
}