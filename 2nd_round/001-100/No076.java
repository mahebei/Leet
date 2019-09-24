package no001_100;

public class No076 {
	public static String minWindow(String s, String t) {
		if (s.isEmpty() || t.isEmpty()) return "";
		int count = 0, len = s.length() + 1, res = -1;
		int[] dictT = new int[58];
		for (char c : t.toCharArray()) {
			if (dictT[c - 'A']++ == 0) count++;
		}
		int l = 0, r = 0;
		while (r <= s.length()) {
			if (count > 0) {
				if (r == s.length()) break;
				if (--dictT[s.charAt(r) - 'A'] == 0 && t.indexOf(s.charAt(r)) != -1) count--;
				r++;
			} else {
				if (r - l < len) {
					len = r - l;
					res = l;
				}
				if (dictT[s.charAt(l) - 'A']++ == 0 && t.indexOf(s.charAt(l)) != -1) count++;
				l++;
			}
		}
		return res == -1 ? "" : s.substring(res, res + len);
	}

	public static void main(String[] args) {
		String S = "ADOBECODEBANC", T = "ABC";
		System.out.println(minWindow(S, T));
	}
}
