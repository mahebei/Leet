/*
275. H-Index II
Medium

Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, 
write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h 
if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

Example:

Input: citations = [0,1,3,5,6]
Output: 3 
Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had 
             received 0, 1, 3, 5, 6 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
Note:

If there are several possible values for h, the maximum one is taken as the h-index.

Follow up:

This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
Could you solve it in logarithmic time complexity?
*/

class Solution {
	public int hIndex(int[] citations) {
		int l = 0, h = citations.length, m, res = 0;
		while (h > l) {
			m = (l + h) / 2;
			if (citations.length - m > citations[m]) l = m + 1;
			else if (citations.length - m < citations[m]) h = m;
			else return citations[m];
			res = Math.max(res, Math.min(citations.length - m, citations[m]));
		}
		return res;
	}
}
