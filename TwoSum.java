import java.util.HashMap;

class TwoSum {
    public int[] twoSum(int[] my_ints, int target) {
        int[] result = new int[2];
        // map from value to index so we don't forget the indices of the integers we've already looked at
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int index = 0; index < my_ints.length; index++) {
            int partner = target - my_ints[index];  // partner is the integer we need to find to sum to the target
            if (indexMap.containsKey(partner)) {  // if we've seen this integer, we're done
                result[0] = indexMap.get(partner); // index of partner integer (seen in previous iterations)
                result[1] = index; // index of current integer
                break; // stop looping because we're done
            }
            // we did not find a solution
            indexMap.put(my_ints[index], index); // update the map with the integer we looked at in this iteration
        }
        return result;
    }
}