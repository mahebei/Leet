/*
57. Insert Interval
Hard

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new LinkedList<>();
		if (intervals.size() == 0) {
			res.add(newInterval);
			return res;
		}
		for (int i = 0; i < intervals.size(); i++) {
			if (intervals.get(i).start >= newInterval.start) {
				intervals.add(i, newInterval);
				break;
			}
		}
		if (intervals.get(intervals.size() - 1).start < newInterval.start) {
			intervals.add(intervals.size(), newInterval);
		}
		int currStart = intervals.get(0).start;
		int currEnd = intervals.get(0).end;
		for (int i = 1; i < intervals.size(); i++) {
			if (intervals.get(i).start <= currEnd) {
				currEnd = Math.max(currEnd, intervals.get(i).end);
			} else {
				res.add(new Interval(currStart, currEnd));
				currStart = intervals.get(i).start;
				currEnd = intervals.get(i).end;
			}
		}
		res.add(new Interval(currStart, currEnd));
		return res;
	}
}
