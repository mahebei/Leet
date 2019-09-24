package no001_100;

import java.util.*;

public class No040 {
	public List<List<Integer>> solve(int[] candidates, int target, List<List<Integer>> res, List<Integer> item, int i) {
		if (target == 0) {
			if (!res.contains(item)) res.add(new ArrayList<>(item));
			return res;
		}
		for (; i < candidates.length; i++) {
			if (i > 0 && candidates[i] == candidates[i - 1] && (item.isEmpty() || item.get(item.size() - 1) != candidates[i]))
				continue;
			if (target >= candidates[i]) {
				item.add(candidates[i]);
				res = solve(candidates, target - candidates[i], res, item, i + 1);
				item.remove(item.size() - 1);
			} else break;
		}
		return res;
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		return solve(candidates, target, new ArrayList<>(), new ArrayList<>(), 0);
	}
}
