class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(!dq.isEmpty() && dq.peekFirst() <= i-k) {
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i+1 >= k ) ans.add(nums[dq.peekFirst()]);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
