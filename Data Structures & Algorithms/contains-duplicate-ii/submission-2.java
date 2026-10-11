class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for(int j = 0; j < n; j++) {
            if(set.contains(nums[j])) {
                return true;
            }

            set.add(nums[j]);

            if(set.size() > k) {
                set.remove(nums[j-k]);
            }
        }
        return false;
    }
}

// TC -> O(n), SC -> O(k)