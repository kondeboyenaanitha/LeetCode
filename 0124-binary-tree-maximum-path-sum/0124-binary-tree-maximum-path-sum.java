/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = -9999;
    public int maxPathSum(TreeNode root) {
        if(root.left == null && root.right == null) return root.val;
        pathSum(root);
        return max;
    }
    int pathSum(TreeNode root){
        if(root == null) return -9999;
        if(root.left == null && root.right == null) return root.val;
        
        int sum1 = pathSum(root.left);
        int sum2 = pathSum(root.right);

        int grtsum = Math.max(sum1,sum2);
        int grtsum1 = Math.max(grtsum+root.val,root.val);
        int grtsum2 = Math.max(grtsum1,grtsum);
        max = Math.max(grtsum2,max);
        max = Math.max(max,sum1+sum2+root.val);
        return grtsum1;
        


        
    }
}