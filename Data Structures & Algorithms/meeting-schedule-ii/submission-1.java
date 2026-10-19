/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        } 

        Arrays.sort(start);
        Arrays.sort(end);

        int room = 0, maxi = 0;
        int s = 0, e = 0;
        for(int i = 0; i < n; i++) {
            if(start[s] < end[e]) {
                s++;
                room++;
            } else {
                e++;
                room--;
            }
            maxi = Math.max(maxi, room);
        }

        return maxi;
    }
}
