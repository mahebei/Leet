/*
295. Find Median from Data Stream
Hard

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. 
So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 

Follow up:

If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
*/

class MedianFinder {

	PriorityQueue<Integer> l, h;

	/**
	 * initialize your data structure here.
	 */
	public MedianFinder() {
		l = new PriorityQueue<>(Collections.reverseOrder());
		h = new PriorityQueue<>();
	}

	public void addNum(int num) {
		if (l.size() - h.size() == 0) {
			h.offer(num);
			l.offer(h.poll());
		} else {
			l.offer(num);
			h.offer(l.poll());
		}
	}

	public double findMedian() {
		if (l.size() == h.size()) return (double) (l.peek() + h.peek()) / 2;
		return (double) l.peek();
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
