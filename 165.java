/*
165. Compare Version Numbers
Medium

Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", 
it is the fifth second-level revision of the second first-level revision.

Example 1:

Input: version1 = "0.1", version2 = "1.1"
Output: -1
Example 2:

Input: version1 = "1.0.1", version2 = "1"
Output: 1
Example 3:

Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1
*/

class Solution {
	public int compareVersion(String version1, String version2) {
		if (version1.equals(version2)) return 0;
		String[] ver1 = version1.split("[.]");
		String[] ver2 = version2.split("[.]");
		for (int i = 0; i < Math.min(ver1.length, ver2.length); i++) {
			if (Integer.parseInt(ver1[i]) > Integer.parseInt(ver2[i])) return 1;
			else if (Integer.parseInt(ver1[i]) < Integer.parseInt(ver2[i])) return -1;
		}
		if (ver1.length > ver2.length)  {
			for (int i = ver2.length; i < ver1.length; i++) {
				if (Integer.parseInt(ver1[i]) != 0) return 1;
			}
		}else if (ver1.length < ver2.length){
			for (int i = ver1.length; i < ver2.length; i++) {
				if (Integer.parseInt(ver2[i]) != 0) return -1;
			}
		}
		return 0;
	}
}
