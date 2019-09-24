package no001_100;

public class No067 {
	public String addBinary(String a, String b) {
		String res = "";
		if (a.equals("0")) return b;
		if (b.equals("0")) return a;
		if (a.length() < b.length()) {
			res = a;
			a = b;
			b = res;
			res = "";
		}
		int lenA = a.length(), lenB = b.length(), i = 1, carry = 0;
		while (lenB >= i) {
			int curr = a.charAt(lenA - i) - '0' + b.charAt(lenB - i) - '0' + carry;
			carry = curr / 2;
			curr = curr % 2;
			res = curr + res;
			i++;
		}
		while (lenA >= i) {
			int curr = a.charAt(lenA - i) - '0' + carry;
			carry = curr / 2;
			curr = curr % 2;
			res = curr + res;
			i++;
		}
		if (carry == 0) return res;
		return 1 + res;
	}
}
