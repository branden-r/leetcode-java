import java.util.HashSet;

@SuppressWarnings("unused")
public class ContainsDuplicate {
    // create a set that contains the first number
    // iterate over the rest of the numbers
    // if the set contains the current number, return true
    // otherwise, add the number to the set and continue
    // if we run out of iterations, return false
    public boolean containsDuplicate(int[] nums) {
        final HashSet<Integer> distinctNums = new HashSet<>();
        distinctNums.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (distinctNums.contains(nums[i])) {
                return true;
            }
            distinctNums.add(nums[i]);
        }
        return false;
    }
}