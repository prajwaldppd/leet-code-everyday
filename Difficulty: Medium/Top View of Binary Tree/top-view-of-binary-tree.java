/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
   class Pair{
       Node node;
       int hd;
       Pair(Node n, int s){
           this.node =n;
           this.hd=s;
       }
   }
   
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null) return res;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            Node n = curr.node;
            int hd = curr.hd;
            
            if(!map.containsKey(hd)){
                map.put(hd,n.data);
            }
            
            if(n.left!=null) q.offer(new Pair(n.left,hd-1));
            if(n.right!=null) q.offer(new Pair(n.right,hd+1));
        }
        
        for(int val:map.values()){
            res.add(val);
        }
        return res;
    }
}