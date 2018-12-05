/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: 
get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/

class LRUCache {
	public LinkedHashMap<Integer, Integer> map;
	
	public LRUCache(int capacity) {
		// build a linded hash map, 0.75f is default load factor, ture is to enable ordering mode, 
		// can put most recently accessed data to the end.
		// Line 35-36 is to remove the least accessed data when current size of the list > capacity.
		map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return size() > capacity;
			}
		};
	}
	
	public int get(int key) {
		return map.getOrDefault(key, -1);
	}
	
	public void put(int key, int value) {
		map.put(key, value);
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
