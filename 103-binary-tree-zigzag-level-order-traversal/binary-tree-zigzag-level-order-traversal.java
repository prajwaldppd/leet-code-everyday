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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int flag=0;
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> cur = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                cur.add(curr.val);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            if(flag==0) {
                res.add(cur);
                flag=1;
            }else{
                Collections.reverse(cur);
                res.add(cur);
                flag=0;
            }
        }

        return res;
    }
}