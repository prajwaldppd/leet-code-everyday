class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        solve(s,ans,cur,0);
        return ans;
    }

    private void solve(String s, List<List<String>> ans, List<String> cur, int start){
        if(start>=s.length()){
            ans.add(new ArrayList<>(cur));
            return;
        }

        for(int i=start;i<s.length();i++){
            if(isPal(s,start,i)){
                cur.add(s.substring(start,i+1));
                solve(s,ans,cur,i+1);
                cur.remove(cur.size()-1);
            }
        }
    }

    private boolean isPal(String s, int start, int end){
        while(start<end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }

        }
        return true;
    }
}