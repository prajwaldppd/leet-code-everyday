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
    class Tuple{
        TreeNode node;
        int row;
        int col;

        Tuple(TreeNode n, int r, int c){
            this.node =n;
            this.row=r;
            this.col=c;
        }
    }

    class Data{
        int val;
        int row;
        int col;
        Data(int v, int r, int c){
            this.val=v;
            this.row=r;
            this.col=c;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Data> nodes = new ArrayList<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root,0,0));

        while(!q.isEmpty()){
            Tuple cur= q.poll();
            if(cur.node.left!=null) q.offer(new Tuple(cur.node.left,cur.row+1,cur.col-1));
            if(cur.node.right!=null) q.offer(new Tuple(cur.node.right,cur.row+1,cur.col+1));
            nodes.add(new Data(cur.node.val,cur.row,cur.col));
        }

        Collections.sort(nodes,(a,b)->{
            if(a.col!=b.col) return Integer.compare(a.col,b.col);
            if(a.row!=b.row) return Integer.compare(a.row,b.row);
            return Integer.compare(a.val,b.val);
        });

        List<List<Integer>> res = new ArrayList<>();
        Integer prev = null;
        for(Data d: nodes){
            if(prev==null || d.col!=prev){
                res.add(new ArrayList<>());
                prev=d.col;
            }
            res.get(res.size()-1).add(d.val);
        }
        return res;
    }
}