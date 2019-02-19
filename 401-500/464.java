class Solution {
	Map<String, Boolean> memo;
	public boolean dfs(int target, boolean[] isChosen) {
		if (target <= 0) return false;
		String chosen = Arrays.toString(isChosen);
		if (memo.containsKey(chosen)) return memo.get(chosen);
		for (int i = 0; i < isChosen.length; i++) {
			if (isChosen[i]) continue;
			isChosen[i] = true;
			if (!dfs(target - i - 1, isChosen)) {
				memo.put(chosen, true);
				isChosen[i] = false;
				return true;
			}
			isChosen[i] = false;
		}
		memo.put(chosen, false);
		return false;
	}

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		memo = new HashMap<>();
		int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
		if (sum < desiredTotal) return false;
		if (desiredTotal < maxChoosableInteger) return true;
		return dfs(desiredTotal, new boolean[maxChoosableInteger]);
	}
}
