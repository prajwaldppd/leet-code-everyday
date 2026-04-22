class Solution {
    public boolean check(char[] s, char[] p ){
        if (s.length != p.length) return false;
        int edits =0;
        for(int i=0;i<s.length;i++){
            if(s[i]!=p[i]){
                edits++;
                if (edits > 2) return false;
            }
        }
        return true;
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        
        for(String s: queries){
            boolean matched =false;
            char[] S = s.toCharArray();
            for(String p:dictionary){
                char[] P = p.toCharArray();
                if(check(S,P)){
                    matched =true;
                break;
                }
            }
            if(matched) result.add(s);
        }
        return result;
    }
}