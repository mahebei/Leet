package no001_100;

public class No005 {
	public String longestPalindrome(String s) {
		String res = "";
		for (int i = 1; i < s.length(); i++) {
			int j = 1;
			while (i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j)) {
				j++;
			}
			if (j * 2 - 1 > res.length()) res = s.substring(i - j + 1, i + j);
			if (s.charAt(i) == s.charAt(i - 1)) {
				j = 1;
				while (i - j >= 1 && i + j < s.length() && s.charAt(i - j - 1) == s.charAt(i + j)) {
					j++;
				}
				if (j * 2 > res.length()) res = s.substring(i - j, i + j);
			}
		}
		return res;
	}
}
