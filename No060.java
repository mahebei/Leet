package no001_100;

import java.util.ArrayList;
import java.util.List;

public class No060 {
	public String getPermutation(int n, int k) {
		int fac = 1;
		List<Integer> nums = new ArrayList<>();
		String res = "";
		for (int i = 1; i <= n; i++) {
			fac *= i;
			nums.add(i);
		}
		k--;
		while (res.length() < n) {
			fac /= n - res.length();
			res += nums.get(k / fac);
			nums.remove(k / fac);
			k %= fac;
		}
		return res;
	}
}
