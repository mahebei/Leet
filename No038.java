package no001_100;

public class No038 {
	public String countAndSay(int n) {
		if (n == 1) return "1";
		StringBuilder sb1 = new StringBuilder("1");
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < n - 1; i++) {
			int count = 1;
			for (int j = 0; j < sb1.length(); j++) {
				char ch = sb1.charAt(j);
				if (j < sb1.length() - 1 && ch == sb1.charAt(j + 1)) count++;
				else {
					sb2.append(count).append(ch);
					count = 1;
				}
			}
			sb1 = sb2;
			sb2 = new StringBuilder();
		}
		return sb1.toString();
	}
}
