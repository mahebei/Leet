/*
458. Poor Pigs
Easy

There are 1000 buckets, one and only one of them contains poison, the rest are filled with water. They all look the same.
If a pig drinks that poison it will die within 15 minutes.
What is the minimum amount of pigs you need to figure out which bucket contains the poison within one hour.

Answer this question, and write an algorithm for the follow-up general case.

Follow-up:

If there are n buckets and a pig drinking poison will die within m minutes,
how many pigs (x) you need to figure out the "poison" bucket within p minutes?
There is exact one bucket with poison.
*/

/*
This problem is to build an n-dimension coordinates, n is the num of pigs. Each pig in charge of one dimension.
For each pig in nth round of test, mix the buckets in nth order of sub-dimension of the pig is in.
The order of the dimension is test rounds + 1. Because The last one doesn't need to be tested.
If during the tests, one pig dies, the coordinates reduced by 1 dimension, and still each pig in charge of one dimension.
For example, 4 round test and 25 bucket. 2 pigs is enough.
1st pig for rows, 2nd for cols, if no pigs died, 0-3 rows and 0-3 col are tested.
For test round 1, pig 1, mix from (0,0) to (0,4) together. round 2 (1,0) to (1,4).
For test round 1, pig 2, mix from (0,0) to (4,0) together. round 2 (0,1) to (4,1).
Only (4,4) in not tested, so (4,4) is the one.
If, for example, Pig 1 dies in first round, and Pig 2 does not, that is one of (0,1)(0.2)(0.3)(0.4) is the one. 
The left 3 rounds is enough for one pig to find the one.
	0 1 2 3 4
  0 * * * * *
  1 * * * * *
  2 * * * * *
  3 * * * * *
  4 * * * * *
This solution can be extract to multi-dimension and multi pigs.
So just ensure test rounds to the power of nums of pigs no less than buckets.
*/
class Solution {
	public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		int pigs = 0;
		while (Math.pow(minutesToTest / minutesToDie + 1, pigs) < buckets) pigs++;
		return pigs;
	}
}
