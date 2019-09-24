package no001_100;

import java.util.*;

public class No089 {
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<>();
		res.add(0);
		if (n == 0) return res;
		res.add(1);
		if (n == 1) return res;
		int add = 1;
		for (int i = 1; i < n; i++) {
			int index = res.size() - 1;
			add += add;
			while (index >= 0) {
				res.add(res.get(index) + add);
				index--;
			}
		}
		return res;
	}
}
