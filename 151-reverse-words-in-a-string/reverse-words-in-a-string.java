class Solution {
    public String reverseWords(String s) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!= ' ') sb.append(s.charAt(i));
            else if(sb.length()>0) {
                list.add(sb.toString());
                sb.setLength(0);    
            }
        }
        if (sb.length() > 0) list.add(sb.toString());
        Collections.reverse(list);
        sb.setLength(0);
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i));
            if(i<list.size()-1) sb.append(' ');
        }
        return sb.toString();
    }
}