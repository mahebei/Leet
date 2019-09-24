package no001_100;

import java.util.*;

public class No056 {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.isEmpty()) return intervals;
		Comparator<Interval> comparator = new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		};
		intervals.sort(comparator);
		int i = 1;
		while (i < intervals.size()) {
			Interval curr = intervals.get(i);
			Interval pre = intervals.get(i - 1);
			if (curr.start > pre.end) {
				i++;
				continue;
			}
			pre.end = Math.max(pre.end, curr.end);
			intervals.remove(i);
		}
		return intervals;
	}
}
