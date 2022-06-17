import java.util.HashMap;

@SuppressWarnings("unused")
class TwoSum {
    // create a map where the key is a num and the value is its index
    // the first element of nums maps to zero
    // iterate over the remaining nums
    // for a num, the key we need for a solution equals the target minus the num
    // if this key exists, return the current index and the value the key maps to
    //
    // return negative one and negative one (no solution)
    // note that the constraints of the problem guarantee exactly one solution, so this won't happen
    // however, a valid method in java contains a return statement for all control paths
    public int[] twoSum(int[] nums, int target) {
        final HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            final int j = map.getOrDefault(target - nums[i], -1);
            if (j != -1) return new int[] {i, j};
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}