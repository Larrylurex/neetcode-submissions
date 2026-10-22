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
int[] starts = intervals.stream().mapToInt(i -> i.start).sorted().toArray();
        int[] ends = intervals.stream().mapToInt(i -> i.end).sorted().toArray();

        int s = 0; int e = 0;
        int count = 0;
        int max = 0;
        while(s < intervals.size()) {
            if(starts[s] < ends[e]) {
                s++;
                count++;
            } else {
                count--;
                e++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
