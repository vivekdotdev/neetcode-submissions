class Solution {
    public int subsetXORSum(int[] nums) {
        int res = 0; 
        for(int it : nums) {
            res |= it;
        }
        return res << (nums.length - 1);
    }
}