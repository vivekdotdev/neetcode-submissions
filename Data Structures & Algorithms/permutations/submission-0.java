class Solution {
    public void helper(boolean[] pick, int[] nums, List<List<Integer>> res, List<Integer> ds) {
        if (ds.size() == nums.length) {
            res.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!pick[i]) {
                ds.add(nums[i]);
                pick[i] = true;
                helper(pick, nums, res,ds);
                ds.remove(ds.size() - 1);
                pick[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper( new boolean[nums.length], nums, res, new ArrayList<>());
        return res;
    }
}
