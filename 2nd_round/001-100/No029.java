package no001_100;

public class No029 {
	public static int divide(int dividend, int divisor) {
		if (divisor == 1) return dividend;
		if (divisor == -1) {
			if (dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
			else return -dividend;
		}
		boolean isNegative = true;
		if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) isNegative = false;
		if (dividend > 0) dividend = -dividend;
		if (divisor > 0) divisor = -divisor;
		int res = 0;
		while (dividend <= divisor) {
			int factor = 1, real = divisor;
			while (dividend <= real) {
				dividend -= real;
				res += factor;
				if (real > (Integer.MIN_VALUE / 2)) {
					factor += factor;
					real += real;
				}
			}
		}
		if (isNegative) res = -res;
		return res;
	}

	public static void main(String[] args) {
		System.out.println(divide(1100540749, -1090366779));
	}
}
