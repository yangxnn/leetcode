package jian_zhi_offer.P_4_KthNodeOfBinaryTree;

import pojo.tree.TreeNode;

import java.util.Stack;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        /**
         * 二叉搜索树的中序遍历是有序的
         */
        TreeNode res = inorder(pRoot, k);
        return res;

    }
    private TreeNode inorder(TreeNode root, int k){
        TreeNode res =  null;
        if (root == null || k < 1){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (k == 1){
                res = cur;
            }
            k--;
            cur = cur.right;
        }
        return res;
    }
}
