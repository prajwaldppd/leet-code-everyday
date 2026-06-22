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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = build(postorder,0,n-1,inorder,0,n-1,map);
        return root;
    }
    private TreeNode build(int[]postorder, int poststart, int postend, int[] inorder,int instart,int inend,Map<Integer,Integer> map){
        if(poststart>postend || instart>inend) return null;
        TreeNode root = new TreeNode(postorder[postend]);
        int idx = map.get(postorder[postend]);
        int left = idx-instart;
        root.left=build(postorder,poststart,poststart+left-1,inorder,instart,idx-1,map);
        root.right=build(postorder,poststart+left,postend-1,inorder,idx+1,inend,map);
        return root;
    }
}