class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for(int[] inter : intervals) {
            int start = inter[0];
            int end = inter[1];
            int lastEnd = ans.get(ans.size() - 1)[1];

            if(start <= lastEnd) {
                ans.get(ans.size() - 1)[1] = Math.max(lastEnd, end);
            } else {
                ans.add(new int[]{start,end});
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
