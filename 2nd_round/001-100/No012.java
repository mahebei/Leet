package no001_100;

public class No012 {
	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		int i = 0;
		while (i < 13) {
			while (num >= nums[i]) {
				sb.append(romans[i]);
				num -= nums[i];
			}
			i++;
		}
		return sb.toString();
	}
}
