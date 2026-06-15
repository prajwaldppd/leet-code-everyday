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
    public int countNodes(TreeNode root) {
        int count=DFS(root);
        return count; 
    }
    private int DFS(TreeNode root){
        if(root==null) return 0;
        int left = DFS(root.left);
        int right = DFS(root.right);
        return 1+ left+right;
    }
}