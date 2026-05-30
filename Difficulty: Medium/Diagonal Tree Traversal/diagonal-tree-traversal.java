/* Node is defined as
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/
class Tree {
    public ArrayList<Integer> diagonal(Node root) {
        // add your code here.
        ArrayList<Integer> res = new ArrayList<>();
        
        if(root==null) return res;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            while(curr!=null){
                res.add(curr.data);
                if(curr.left!=null) q.offer(curr.left);
                curr=curr.right;
            }
        }
        
        return res;
    }
}