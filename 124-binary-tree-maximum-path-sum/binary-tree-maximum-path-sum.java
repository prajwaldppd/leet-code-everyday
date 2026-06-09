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
    int maxsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
       height(root);
       return maxsum;
    }
    public int height(TreeNode root){
         if(root==null) return 0;
        int l = Math.max(0,height(root.left));
        int r = Math.max(0,height(root.right));
        maxsum = Math.max(root.val+l+r,maxsum);
        return root.val+Math.max(l,r);
    }
}