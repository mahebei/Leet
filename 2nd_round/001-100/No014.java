package no001_100;

public class No014 {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) return "";
		String res = "";
		for (int i = 0; i < strs[0].length(); i++) {
			res += strs[0].charAt(i);
			for (String str : strs) {
				if (str.length() < res.length() || !str.startsWith(res)) {
					return res.substring(0, res.length() - 1);
				}
			}
		}
		return res;
	}
}
