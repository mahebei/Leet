package no001_100;

public class No013 {
	public int romanToInt(String s) {
		String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		int res = 0, i = 0, pos = 0;
		while (i < 13) {
			while (s.startsWith(romans[i])){
				res += nums[i];
				s = s.substring(romans[i].length());
			}
			i++;
		}
		return res;
	}
}
