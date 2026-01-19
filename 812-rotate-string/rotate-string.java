class Solution {
    public boolean rotateString(String s, String goal) {
        s=s+s;
        return (goal.length()*2==s.length() && s.contains(goal)) ;
    }
}