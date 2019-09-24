package no001_100;

public class No091 {
	public int numDecodings(String s) {
		if (s.startsWith("0")) return 0;
		int[] memo = new int[s.length() + 1];
		memo[0] = 1;
		memo[1] = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				if (Integer.parseInt(s.substring(i - 1, i + 1)) >= 30) return 0;
				memo[i + 1] = memo[i - 1];
				memo[i] = 0;
			} else if (Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
				memo[i + 1] = memo[i - 1] + memo[i];
			} else memo[i + 1] = memo[i];
		}
		return memo[s.length()];
	}
}
