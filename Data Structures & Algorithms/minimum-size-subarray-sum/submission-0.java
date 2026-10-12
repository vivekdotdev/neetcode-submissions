class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE, sum = 0;
        while( r < n) {
            if(sum + nums[r] < target) {
                sum += nums[r++];
            }
            else if (sum + nums[r] >= target) {
                minLen = Math.min(minLen, r-l+1);
                sum -= nums[l++];
            }

            System.out.println(minLen);
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
// TC  -> O(n) , SC -> O(1)