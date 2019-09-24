package no001_100;

public class No028 {
	public int strStr(String haystack, String needle) {
		int diff = haystack.length() - needle.length();
		if (needle.isEmpty()) return 0;
		if (diff < 0) return -1;
		for (int i = 0; i <= diff; i++) {
			if (haystack.charAt(i) == needle.charAt(0)){
				if (haystack.substring(i,i+needle.length()).equals(needle)) return i;
			}
		}
		return -1;
	}
}
