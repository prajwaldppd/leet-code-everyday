/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void markparents(TreeNode root, Map<TreeNode,TreeNode> p_track){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur.left!=null){
                p_track.put(cur.left,cur);
                q.offer(cur.left);
            }
            if(cur.right!=null){
                p_track.put(cur.right,cur);
                q.offer(cur.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> p_track = new HashMap<>();
        markparents(root,p_track);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int size=0;
        while(!q.isEmpty()){
            if(size==k){
                break;
            }
            size++;
            int s=q.size();
            for(int i=0;i<s;i++){
                TreeNode cur = q.poll();
                if(cur.left!=null && visited.get(cur.left)==null){
                    q.offer(cur.left);
                    visited.put(cur.left,true);
                }
                if(cur.right!=null && visited.get(cur.right)==null){
                    q.offer(cur.right);
                    visited.put(cur.right,true);
                }
                if(p_track.get(cur)!=null && visited.get(p_track.get(cur))==null){
                    q.offer(p_track.get(cur));
                    visited.put(p_track.get(cur),true);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.poll().val);
        }

        return res;
    }
}