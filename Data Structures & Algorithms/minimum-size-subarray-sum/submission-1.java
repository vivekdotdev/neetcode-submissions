class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE, sum = 0;
        while (r < n) {
            sum += nums[r++];
            while (sum >= target) {
                minLen = Math.min(minLen, r - l);
                sum -= nums[l++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
// TC  -> O(n) , SC -> O(1)