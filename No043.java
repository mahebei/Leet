package no001_100;

public class No043 {
	public static String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) return "0";
		int len1 = num1.length(), len2 = num2.length();
		int[] res = new int[len1 + len2];
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				int idx = len1 + len2 - 1 - i - j;
				res[idx] += (num1.charAt(len1 - i - 1) - '0') * (num2.charAt(len2 - j - 1) - '0');
				while (res[idx] > 9) {
					res[idx - 1] += res[idx] / 10;
					res[idx] %= 10;
					idx--;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int digit : res) {
			sb.append(digit);
		}
		while (sb.charAt(0) == '0') sb.deleteCharAt(0);
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(multiply("123", "4"));
	}
}
