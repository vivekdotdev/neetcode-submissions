class Solution {

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    int[] nums = null;
    public List<List<Integer>> subsets(int[] nums) {        
        List<Integer> current = new ArrayList<Integer>();
        this.nums = nums;  
        backtrack(0,current);      
        return result;
    }

    private void backtrack(int index, List<Integer> current) {
        result.add(new ArrayList<Integer>(current));
        for(int i = index ;i<nums.length;i++) {
            current.add(nums[i]);
            backtrack(i+1, current);
            current.remove(current.size()-1);
        }   
    }
}
