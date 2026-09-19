class Solution {
    public void findSS(int idx, int[] arr, List<List<Integer>> ans, List<Integer> ds) {
        ans.add(new ArrayList<>(ds));
        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1])
                continue;
            ds.add(arr[i]);
            findSS(i + 1, arr, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        findSS(0, nums, ans, new ArrayList<>());
        return ans;
    }
}
