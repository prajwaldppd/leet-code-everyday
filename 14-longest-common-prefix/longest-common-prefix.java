class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1) return strs[0];
        if(strs.length==0) return "";

        StringBuilder ans= new StringBuilder();
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length-1].toCharArray();

        int n = Math.min(first.length,last.length);
        for(int i=0;i<n;i++){
            if(first[i]!=last[i]) return ans.toString();
            ans.append(first[i]);
        }

        return ans.toString();


    }
}