package jian_zhi_offer.P_8_DuiChengErChaShu;

import pojo.tree.TreeNode;

public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null){
            return true;
        }
        boolean res = help(pRoot.left, pRoot.right);
        return res;

    }
    private boolean help(TreeNode pL, TreeNode pR){
        if (pL == null && pR == null){
            return true;
        } else if (pL != null && pR != null){
            if (pL.val == pR.val){
                return help(pL.left, pR.right) && help(pL.right, pR.left);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
