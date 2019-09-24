package no001_100;

public class No009 {
	public static boolean isPalindrome(int x) {
		if (x < 0) return false;
		double reverse = 0;
		int num = x;
		while (num != 0) {
			reverse = reverse * 10 + num % 10;
			num /= 10;
		}
		return reverse == x;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(1001));
		System.out.println(isPalindrome(Integer.MAX_VALUE));
	}
}
