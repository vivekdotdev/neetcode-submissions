class Solution {
    private void findCombi(int idx, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if(idx == arr.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[idx] <= target) {
            ds.add(arr[idx]);
            findCombi(idx, arr, target - arr[idx], ans, ds);
            ds.remove(ds.size()-1);
        }
        findCombi(idx+1, arr, target, ans, ds);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        findCombi(0, nums, target, ans, new ArrayList<>());
        return ans;
    }
}
