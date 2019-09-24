package no001_100;

public class No066 {
	public int[] plusOne(int[] digits) {
		int carry = 0, i = digits.length - 1;
		if (digits[i] == 9) {
			digits[i] = 0;
			carry = 1;
		} else digits[i]++;
		while (carry == 1 && --i >= 0) {
			if (digits[i] == 9) {
				digits[i] = 0;
				carry = 1;
			} else {
				digits[i]++;
				carry = 0;
			}
		}
		if (carry == 1) {
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			for (i = 0; i < digits.length; i++) {
				res[i + 1] = digits[i];
			}
			return res;
		} else return digits;
	}
}
