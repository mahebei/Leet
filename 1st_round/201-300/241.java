/*
241. Different Ways to Add Parentheses
Medium

Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1:

Input: "2-1-1"
Output: [0, 2]
Explanation: 
((2-1)-1) = 0 
(2-(1-1)) = 2
Example 2:

Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation: 
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
*/

class Solution {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new LinkedList<>();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '+'
					    || input.charAt(i) == '-'
					    || input.charAt(i) == '*') {
				List<Integer> l = diffWaysToCompute(input.substring(0, i));
				List<Integer> r = diffWaysToCompute(input.substring(i + 1));
				for (int num1 : l) {
					for (int num2 : r) {
						switch (input.charAt(i)) {
							case '+':
								res.add(num1 + num2);
								break;
							case '-':
								res.add(num1 - num2);
								break;
							case '*':
								res.add(num1 * num2);
								break;
						}
					}
				}
			}
		}
		if (res.isEmpty()) res.add(Integer.parseInt(input));
		return res;
	}
}
