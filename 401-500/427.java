/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
	public Node build(int[][] grid, int x, int y, int len) {
		if (len == 1) return new Node(grid[x][y] == 1, true, null, null, null, null);
		Node tl = build(grid, x, y, len / 2);
		Node bl = build(grid, x + len / 2, y, len / 2);
		Node tr = build(grid, x, y + len / 2, len / 2);
		Node br = build(grid, x + len / 2, y + len / 2, len / 2);
		if (tl.isLeaf && bl.isLeaf && tr.isLeaf && br.isLeaf &&
					tl.val == bl.val && bl.val == tr.val && tr.val == br.val)
			return new Node(tl.val, true, null, null, null, null);
		return new Node(true, false, tl, tr, bl, br);
	}

	public Node construct(int[][] grid) {
		return build(grid, 0, 0, grid.length);
	}
}
