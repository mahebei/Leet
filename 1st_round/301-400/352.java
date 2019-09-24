/*
352. Data Stream as Disjoint Intervals
Hard

Given a data stream input of non-negative integers a1, a2, ..., an, ..., 
summarize the numbers seen so far as a list of disjoint intervals.

For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]
Follow up:
What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
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
class SummaryRanges {
	Map<Integer, Integer> nums; // stores <nums, start of the nums in interval>
	Map<Integer, Interval> inter; // stores all <start of intervals, the corresponding interval>

	/**
	 * Initialize your data structure here.
	 */
	public SummaryRanges() {
		nums = new HashMap<>();
		inter = new TreeMap<>();
	}

	public void addNum(int val) {
		// val exists
		if (nums.containsKey(val)) return;
		// val cannot connected to any current intervals
		if (!(nums.containsKey(val - 1) || nums.containsKey(val + 1))) {
			nums.put(val, val);
			inter.put(val, new Interval(val, val));
			return;
		}
		// val can be connected to its left, its right or both
		int left = (nums.containsKey(val - 1)) ? nums.get(val - 1) : val;
		int right = (nums.containsKey(val + 1)) ? inter.get(val + 1).end : val;
		nums.put(val, left);
		nums.put(right, left);
		inter.remove(val + 1);
		inter.put(left, new Interval(left, right));
	}

	public List<Interval> getIntervals() {
		return new ArrayList<>(inter.values());
	}
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
