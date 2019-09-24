package no001_100;

public class No050 {
	public static double myPow(double x, int n) {
		if (n == 1) return x;
		if (n > 0) {
			n *= -1;
			x = 1 / x;
		}
		double res = 1, divisor = 1 / x;
		int p = -1, sign = 1;
		if (x < 0 && n % 2 == -1) sign = -1;
		while (n != 0) {
			while (n != 0 && n <= p * 2) {
				p *= 2;
				divisor *= divisor;
				res *= divisor;
				n -= p;
			}
			while (n != 0 && n > p) {
				p /= 2;
				divisor = Math.sqrt(divisor);
			}
			if (n != 0) {
				res *= divisor;
				n -= p;
			}
		}
		return res * sign;
	}

	public static void main(String[] args) {
		System.out.println(myPow(-2, 4));
	}
}
