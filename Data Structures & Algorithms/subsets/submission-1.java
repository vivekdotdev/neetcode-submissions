class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
    
        subSeq(nums,0, new ArrayList<>(), res);
        return res;
    }

    public static void subSeq(int[] arr, int idx, List<Integer> list, List<List<Integer>> res) {
        
        if(idx == arr.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        list.add(arr[idx]);
        subSeq(arr, idx+1, list, res);
        list.remove(list.size()-1);
        subSeq(arr, idx+1, list, res);
    }
}

