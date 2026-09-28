class Solution {
    public void helper(boolean[] pick, int[] nums, List<List<Integer>> ans, List<Integer> ds) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(pick[i] || (i > 0 && nums[i] == nums[i-1] && !pick[i-1])) continue;

            pick[i] = true;
            ds.add(nums[i]);
            helper(pick, nums,ans,ds);
            pick[i] = false;
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(new boolean[nums.length], nums, res, new ArrayList<>());
        return res;
    }
}
