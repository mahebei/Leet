/*
282. Expression Add Operators
Hard

Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) 
+, -, or * between the digits so they evaluate to the target value.

Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"] 
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]
Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]
Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]
Example 5:

Input: num = "3456237490", target = 9191
Output: []
*/

class Solution {
	public void getResult(String num, int target, int index, long sum, long pre, String item, List<String> res) {
		if (index == num.length()) {
			if(target == sum){
				res.add(item);
				return;
			}
		}
		for (int i = index; i < num.length(); i++) {
			if (i > index && num.charAt(index) == '0') break;
			long curr = Long.parseLong(num.substring(index, i + 1));
			if (index == 0) {
				getResult(num, target, i + 1, curr, curr, curr + "", res);
			} else {
				getResult(num, target, i + 1, sum + curr, curr, item + "+" + curr, res);
				getResult(num, target, i + 1, sum - curr, -curr, item + "-" + curr, res);
				getResult(num, target, i + 1, sum - pre + pre * curr, pre * curr, item + "*" + curr, res);
			}
		}
	}

	public List<String> addOperators(String num, int target) {
		List<String> res = new LinkedList<>();
		if (num.isEmpty()) return res;
		getResult(num, target, 0, 0, 0, "", res);
		return res;
	}
}
