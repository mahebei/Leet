package no001_100;

import java.util.Arrays;

class No105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        TreeNode newNode = new TreeNode(preorder[0]);
        int curr = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                curr = i;
                break;
            }
        }
        if (curr == 0)
            newNode.left = null;
        else
            newNode.left = buildTree(Arrays.copyOfRange(preorder, 1, curr + 1), Arrays.copyOfRange(inorder, 0, curr));
        newNode.right = buildTree(Arrays.copyOfRange(preorder, curr + 1, preorder.length),
                Arrays.copyOfRange(inorder, curr + 1, inorder.length));
        return newNode;
    }
}