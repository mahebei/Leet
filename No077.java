package no001_100;

import java.util.*;

public class No077 {
	public List<List<Integer>> combine(List<List<Integer>> res, List<Integer> item, int i, int n, int k) {
		if (k == 0) {
			res.add(new ArrayList<>(item));
			return res;
		}
		for (; i < n - k + 1; i++) {
			item.add(i);
			res = combine(res, item, i + 1, n, k - 1);
			item.remove(item.size() - 1);
		}
		return res;
	}

	public List<List<Integer>> combine(int n, int k) {
		return combine(new ArrayList<>(), new ArrayList<>(), 1, n, k);
	}
}
