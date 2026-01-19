class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        if(n!=t.length()) return false;
        HashMap<Character,Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<n; i++){
            char key = s.charAt(i);
            char val = t.charAt(i);
            if(map.containsKey(key)){
                if(map.get(key)!=val) return false;
            }else {
                if(set.contains(val)) return false;
                map.put(key,val);
                set.add(val);
            }
        }
        return true;
    }
}