package no001_100;

import java.util.*;

public class No039 {
	public List<List<Integer>> solve(int[] candidates, int target, List<List<Integer>> res, List<Integer> item, int i) {
		if (target == 0) {
			res.add(new ArrayList<>(item));
			return res;
		}
		for (; i < candidates.length; i++) {
			//if (item.size() > 0 && item.get(item.size() - 1) > can) continue;
			if (target >= candidates[i]) {
				item.add(candidates[i]);
				res = solve(candidates, target - candidates[i], res, item, i);
				item.remove(item.size() - 1);
			} else break;
		}
		return res;
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		return solve(candidates, target, new ArrayList<>(), new ArrayList<>(), 0);
	}
}
