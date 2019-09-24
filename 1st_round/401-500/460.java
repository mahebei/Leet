/*
460. LFU Cache
Hard

Design and implement a data structure for Least Frequently Used (LFU) cache.
It should support the following operations: get and put. 

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity,
it should invalidate the least frequently used item before inserting a new item.
For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency),
the least recently used key would be evicted. 

Follow up:
 Could you do both operations in O(1) time complexity?

Example: 
LFUCache cache = new LFUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.get(3);       // returns 3.
cache.put(4, 4);    // evicts key 1.
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/

/*
This problem uses 3 maps, one is to store the (key, value) pair given by user.
One is to store the count of how many times used by each key. (key, count)
One is to store (count, HashSet), count is the time used of each key,
	HashSet is to store keys used for corresponding times(by order).
Integer min is to store current min times used of all keys.

For get method,
if map not contain the given key, return -1,
else find the time used of this key, update the time in the 2 maps about count.
	if the time == min and no other keys used for min times, update min as well.

For set method,
if cap <=0 return;
if the key already exist, update the value;
if current size < cap, just add to 1st map, add (key, 1) to count map, and add key to 3rd map, and the used times is 1.
	update min to 1, becasue the newly added key is used for once.
if current size == cap, which is full, need to remove one key before add.
	find the key to be removed in 3rd map in the HashSet of min. Then remove from all 3 maps.
*/
class LFUCache {
    Map<Integer, Integer> map;
	Map<Integer, Integer> counts;
	Map<Integer, LinkedHashSet<Integer>> lists;
	int cap, min = -1;

	public LFUCache(int capacity) {
		cap = capacity;
		map = new HashMap<>();
		counts = new HashMap<>();
		lists = new HashMap<>();
		lists.put(1, new LinkedHashSet<>());
	}

	public int get(int key) {
		if (!map.containsKey(key)) return -1;
		int count = counts.get(key);
		lists.get(count).remove(key);
		if (count == min && lists.get(count).size() == 0) min++;
		if (!lists.containsKey(++count)) lists.put(count, new LinkedHashSet<>());
		lists.get(count).add(key);
		counts.put(key, count);
		return map.get(key);
	}

	public void put(int key, int value) {
		if (cap <= 0) return;
		if (map.containsKey(key)) {
			map.put(key, value);
			get(key);
			return;
		}
		if (map.size() == cap) {
			int rm = lists.get(min).iterator().next();
			lists.get(min).remove(rm);
			map.remove(rm);
			counts.remove(rm);
		}
		map.put(key, value);
		counts.put(key, 1);
		min = 1;
		lists.get(1).add(key);
	}
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
