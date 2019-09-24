package no001_100;

import java.util.*;

public class No057 {
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals.isEmpty()) {
			intervals.add(newInterval);
			return intervals;
		}
		if (newInterval.start > intervals.get(intervals.size() - 1).start) intervals.add(newInterval);
		else {
			for (int i = 0; i < intervals.size(); ++i) {
				if (newInterval.start <= intervals.get(i).start) {
					intervals.add(i, newInterval);
					break;
				}
			}
		}
		int i = 1;
		while (i < intervals.size()) {
			Interval curr = intervals.get(i);
			Interval pre = intervals.get(i - 1);
			if (curr.start > pre.end) {
				i++;
				continue;
			}
			pre.end = Math.max(curr.end, pre.end);
			intervals.remove(i);
		}
		return intervals;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 16));
		intervals = (insert(intervals, new Interval(4, 8)));
		for (Interval i : intervals) {
			System.out.println(i.start + " " + i.end);
		}
	}
}
