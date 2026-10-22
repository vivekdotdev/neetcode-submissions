class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int glMax = nums[0], glMin = nums[0];
        int curMax = 0, curMin = 0, total = 0;

        for(int n : nums ) {
            curMax = Math.max(curMax + n, n);
            curMin = Math.min(curMin + n, n);
            total += n;
            glMax = Math.max(glMax, curMax);
            glMin = Math.min(glMin, curMin);
        }
        return glMax > 0 ? Math.max(glMax, total - glMin) : glMax;
    }
}

