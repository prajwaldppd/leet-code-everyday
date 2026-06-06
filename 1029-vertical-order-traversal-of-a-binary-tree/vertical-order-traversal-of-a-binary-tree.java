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
    class Tuple {
        TreeNode node;
        int row;
        int col;
        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    class Data {
        int row;
        int col;
        int val;
        Data(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<Data> nodes = new ArrayList<>();

        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(root, 0, 0));

        while(!q.isEmpty()) {
            Tuple curr = q.poll();
            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.col;

            nodes.add(new Data(row, col, node.val));

            if(node.left != null)  q.offer(new Tuple(node.left,row+1,col-1));
            if(node.right != null) q.offer(new Tuple(node.right,row+1,col+1));
        }

        Collections.sort(nodes, (a, b) -> {
            if(a.col != b.col)return Integer.compare(a.col, b.col);
            if(a.row != b.row) return Integer.compare(a.row, b.row);
            return Integer.compare(a.val, b.val);
        });

        List<List<Integer>> res = new ArrayList<>();
        Integer prevCol = null;
        for(Data d : nodes) {

            if(prevCol == null || d.col != prevCol) {
                res.add(new ArrayList<>());
                prevCol = d.col;
            }
            res.get(res.size() - 1).add(d.val);
        }
        return res;
    }
}