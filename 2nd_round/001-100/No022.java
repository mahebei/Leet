package no001_100;

import java.util.*;

public class No022 {
	public List<String> generate(List<String> res, String str, int n, int diff) {
		if (n == 0 && diff == 0) res.add(str);
		if (n != 0) res = generate(res, str + "(", n - 1, diff + 1);
		if (diff != 0) res = generate(res, str + ")", n, diff - 1);
		return res;
	}

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		return generate(res, "", n, 0);
	}
}
