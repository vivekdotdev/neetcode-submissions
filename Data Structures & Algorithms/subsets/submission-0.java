class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
    
        return new ArrayList<>(subSeq(nums,0,list));
    }

    public static List<List<Integer>> subSeq(int[] arr, int idx, List<Integer> list) {
        
        if(idx == arr.length) {
            List<List<Integer>> copy = new ArrayList<>();
            copy.add(new ArrayList<>(list));
            return copy; 
        }
        List<List<Integer>> res = new ArrayList<>();
        
        list.add(arr[idx]);
        res.addAll(subSeq(arr, idx+1, list));
        list.remove(list.size()-1);
        res.addAll(subSeq(arr, idx+1, list));

        return res;
    }
}

