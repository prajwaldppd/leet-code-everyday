/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    void addLeftBoundry(Node root,ArrayList<Integer> res ){
        Node cur = root.left;
        while(cur!=null){
            if(!isleaf(cur)) res.add(cur.data);
            if(cur.left!=null){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
    }
    
    void addLeafNodes(Node root,ArrayList<Integer> res){
        if(root==null) return;
        if(isleaf(root)){
            res.add(root.data);
            return;
        }
        addLeafNodes(root.left,res);
        addLeafNodes(root.right,res);
    }
    
    boolean isleaf(Node n){
        return (n!=null) && (n.left==null) && (n.right==null);
    }
    
    void addRightBoundry(Node root,ArrayList<Integer> res){
        Node cur = root.right;
        ArrayList<Integer> tmp = new ArrayList<>();
        while(cur!=null){
            if(!isleaf(cur)) tmp.add(cur.data);
            if(cur.right!=null){
                cur=cur.right;
            }else{
                cur=cur.left;
            }
        }
        for(int i=tmp.size()-1;i>=0;i--){
            res.add(tmp.get(i));
        }
    }
    
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null) return res;
        if(!isleaf(root)) res.add(root.data);
        addLeftBoundry(root,res);
        addLeafNodes(root,res);
        addRightBoundry(root,res);
        return res;
        
    }
}