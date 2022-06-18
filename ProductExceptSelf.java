class Solution {
    // let r be an array of integers the same size as nums
    // let p equal one
    // iterate over nums from left to right using index i
    // insert p into r at position i
    // multiply p by the element of nums at position i
    // after iterating, each element of r is the product of the prefix of the corresponding num
    //
    // reset p to one
    // iterate over nums from right to left using index i
    // multiply the element of r at position i by p
    // multiply p by the element of nums at position i
    // after iterating, each element of r is the product of the prefix and suffix of the corresponding num
    public int[] productExceptSelf(int[] nums) {
        int[] r = new int[nums.length];
        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            r[i] = p;
            p *= nums[i];
        }

        p = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            r[i] *= p;
            p *= nums[i];
        }

        return r;
    }
}