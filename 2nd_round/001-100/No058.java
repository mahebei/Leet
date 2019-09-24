package no001_100;

public class No058 {
	public int lengthOfLastWord(String s) {
		if (s.isEmpty()) return 0;
		return s.length() - 1 - s.lastIndexOf(" ");
	}
}
