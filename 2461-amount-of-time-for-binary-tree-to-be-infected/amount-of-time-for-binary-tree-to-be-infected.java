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
    private void markparent(TreeNode root, Map<TreeNode,TreeNode> p_tracker){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur.left!=null){
                q.offer(cur.left);
                p_tracker.put(cur.left,cur);
            }
            if(cur.right!=null){
                q.offer(cur.right);
                p_tracker.put(cur.right,cur);
            }
        }
    }
    private TreeNode get(TreeNode root, int start){
        if(root==null) return null;
        if(root.val==start) return root;
        TreeNode left = get(root.left,start);
        TreeNode right = get(root.right,start);
        if(left==null) return right;
        return left;
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode,TreeNode> p_tracker = new HashMap<>();
        markparent(root,p_tracker);
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Boolean> vis = new HashMap<>();
        q.offer(get(root,start));
        vis.put(get(root,start),true);
        int time =-1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                if(cur.left!=null && vis.get(cur.left)==null){
                q.offer(cur.left);
                vis.put(cur.left,true);
                }
                if(cur.right!=null && vis.get(cur.right)==null){
                    q.offer(cur.right);
                    vis.put(cur.right,true);
                }
                if(p_tracker.get(cur)!=null && vis.get(p_tracker.get(cur))==null){
                    q.offer(p_tracker.get(cur));
                    vis.put(p_tracker.get(cur),true);
                }
            }
            time++;
        }

        return time;
    }
}