/*
500. Keyboard Row
Easy

Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 
Example:

Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
 

Note:

You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.
*/

class Solution {
	public String[] findWords(String[] words) {
		String strs[] = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < 3; i++) {
			for (char ch : strs[i].toCharArray()) {
				map.put(ch, i);
			}
		}
		List<String> res = new ArrayList<>();
		for (String word : words) {
			if (word.isEmpty()) continue;
			int line = map.get(word.toLowerCase().charAt(0));
			for (char ch : word.toLowerCase().toCharArray()) {
				if (map.get(ch) != line) {
					line = -1;
					break;
				}
			}
			if (line != -1) res.add(word);
		}
		return res.toArray(new String[0]);
	}
}
