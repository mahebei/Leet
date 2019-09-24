package no001_100;

public class No006 {
	public String convert(String s, int numRows) {
		StringBuilder sb = new StringBuilder();
		char[] chs = s.toCharArray();
		for (int i = 0; i < chs.length; i += (numRows - 1) * 2) {
			sb.append(chs[i]);
		}
		for (int i = 1; i < numRows - 1; i++) {
			for (int j = 0; j < chs.length; j += (numRows - 1) * 2) {
				if (j - i > 0) sb.append(chs[j - i]);
				if (j + i < chs.length) sb.append(chs[j + i]);
			}
		}
		for (int i = numRows - 1; i < chs.length; i += (numRows - 1) * 2) {
			sb.append(chs[i]);
		}
		return sb.toString();
	}
}
