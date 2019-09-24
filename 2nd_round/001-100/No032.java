package no001_100;

public class No032 {
	public static int longestValidParentheses(String s) {
		int len = s.length(), res = 0;
		int[] memo = new int[len];
		for (int i = len - 2; i >= 0; i--) {
			if (s.charAt(i) == ')') continue;
			int count = 0;
			if (i +  memo[i + count + 1] + 1<len&&s.charAt(i +  memo[i + count + 1] + 1) == ')') {
				count += memo[i + count + 1] + 2;
			}
			while (i + count < len && memo[i + count] > 0) {
				count += memo[i + count];
			}
			res = Math.max(res, count);
			memo[i] = count;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()(())"));
	}
}
