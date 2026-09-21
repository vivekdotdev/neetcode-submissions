class Solution {
    public void helper(int start, int end, int k, List<List<Integer>> res, List<Integer> ds) {
        if (ds.size() == k ) {
            res.add(new ArrayList<>(ds));
            return;
        }
        for (int i = start; i <= end; i++) {
            ds.add(i);
            helper(i + 1, end, k, res, ds);
            ds.remove(ds.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1, n, k, res, new ArrayList<>());
        return res;
    }
}