package no001_100;

import java.util.HashSet;

public class No003 {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0, res = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
            } else {
                res = Math.max(res, right - left);
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            right++;
        }

        res = Math.max(res, set.size());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));

        System.out.println(lengthOfLongestSubstring("ohomm"));
    }
}
