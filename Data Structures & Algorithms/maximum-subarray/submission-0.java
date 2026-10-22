class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0] , curr = 0;

        for(int n : nums) {
            if(curr < 0 ) {
                curr = 0;
            }
            curr += n;
            sum = Math.max(sum, curr);
        }
        return sum;
    }
}
