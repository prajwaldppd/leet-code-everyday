class Solution {
    public String largestOddNumber(String num) {
        int i=0;
        int j=num.length()-1;

        while(j>=0 &&(num.charAt(j)-'0')%2==0) j--;
        if(j<0) return "";
        StringBuilder sb = new StringBuilder();
        while(i<=j){
            sb.append(num.charAt(i));
            i++;
        } 

        return sb.toString();
    }
}