class Solution {
    public int minimumLength(String s) {
        int start=0;
        int end = s.length()-1;

        while(start<end){

            if(s.charAt(start)!=s.charAt(end)){
               return end-start+1;
            }
            
            else{
                while(start<end && s.charAt(start)==s.charAt(start+1)){
                    start++;
                }
                while(start<end &&s.charAt(end)==s.charAt(end-1)){
                    end--;
                }
                start++;
                end--;

            }
        }

        if(start==end){
            return 1;
        }
    
        if(start>end){
            return 0;
        }


        return end-start+1;

    }
}