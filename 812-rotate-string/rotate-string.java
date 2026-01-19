class Solution {
    public boolean rotateString(String s, String goal) {
        return (goal.length()==s.length() && (s+s).contains(goal)) ;
    }
}