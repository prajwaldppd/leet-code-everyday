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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, new ArrayList<>());
        return res;
    }

    private void helper(TreeNode root, int targetSum,List<Integer> path) {
        if(root == null) return;
        path.add(root.val);
        if(root.left == null && root.right == null && root.val == targetSum) {
            res.add(new ArrayList<>(path));
        }
        helper(root.left,targetSum - root.val,path);
        helper(root.right,targetSum - root.val,path);
        path.remove(path.size() - 1);
    }
}